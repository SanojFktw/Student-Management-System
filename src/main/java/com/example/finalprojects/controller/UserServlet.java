package com.example.finalprojects.controller;

import Hashing.PasswordHashing;
import model.User;
import service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {

        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String page = request.getParameter("page");

        //register new user
        if (page.equalsIgnoreCase("register")){
            User user = new User();

            //text field bata username, password ra fullname leko ani User ko setUsername bla  bla method ma value pathako
            user.setUserName(request.getParameter("userName"));
            user.setPassword(new PasswordHashing().hashPassword(request.getParameter("password")));
//          user.setPassword (request.getParameter("password"));
            user.setFullName(request.getParameter("fullName"));
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getFullName());

//            UserService userService = new UserService();
            new UserService().insertUser(user); //user vanne object jun chai User Model ko ho tesbata value insertuser vannee method jo chai userservice ma xa tesma user ko value pass gareko

            //user register vaisakepaxi feri login page ma redirect gareko.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        //user login gareko

        if (page.equalsIgnoreCase("login")){
            //login garda haleko uname ra password
            String userName = request.getParameter("userName");
            String password = PasswordHashing.hashPassword(request.getParameter("password"));
//            String password = request.getParameter("password");
            //yo chai database ma Vako username ra password
            User user = null;
            try {
                //getUser vanne method ma username ra password ko value pass gareko
                user = new UserService().getUser(userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (user != null){

                //session create gareko if user null chaina vanne
                HttpSession httpSession = request.getSession();
                Cookie cookie = new Cookie("userName", userName);
                response.addCookie(cookie);
                httpSession.setAttribute("userName", userName);
                httpSession.setAttribute("user", user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request, response);
            }

        }
        if (page.equalsIgnoreCase("newUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("index")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("dashboard")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
            requestDispatcher.forward(request, response);
        }

        // list of user
        if (page.equalsIgnoreCase("list_user")){
            try {
                User user = new User();
                List<User> userList = new UserService().getUserList();
                request.setAttribute("userLists", userList); //esma chai list of users. esma chai loop laune jsp file ma
                request.setAttribute("user", user);           //esle chai individual info of users access garna milxa i.e. esma chai user.id user.fullName garna chahinxa

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
                requestDispatcher.forward(request, response);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        //details liyera matra janxa row ko
        if(page.equalsIgnoreCase("userEdit")){
            int id = Integer.parseInt(request.getParameter("id"));

            User user = new UserService().getUserRow(id);
            request.setAttribute("user", user);
            request.setAttribute("id", id);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/update_user.jsp");
            requestDispatcher.forward(request, response);
        }

        //userdetails
        if (page.equalsIgnoreCase("userDetails")){
            int id = Integer.parseInt(request.getParameter("id")); //url bata id ko value tanneko, id lai string jasari treat garxa so int ma parse gareko.
            User user = new UserService().getUserRow(id); //getUserRow ma id ko value pathako jun chai userservice vitra xa
            request.setAttribute("id", id);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user_Details.jsp");
            requestDispatcher.forward(request,response);
        }
        //edit garxa
        if (page.equalsIgnoreCase("editUser")){
            User user = new User();
            int id = Integer.parseInt(request.getParameter("id"));
            user.setUserName(request.getParameter("username"));
            user.setPassword(PasswordHashing.hashPassword(request.getParameter("password")));
            user.setFullName(request.getParameter("fullname"));

            try {
                new UserService().updateUser(user, id); //value pass garera service call gareko
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                // update garepaxi naya list show garna lekheko
                List<User> userList = new UserService().getUserList();
                request.setAttribute("userLists", userList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
                requestDispatcher.forward(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if (page.equalsIgnoreCase("userDelete")){
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUser(id);

            try {
                List<User> userLists = new UserService().getUserList(); //teii list ma lana lai getuserlist garera list ma redirect garxa
                request.setAttribute("userLists", userLists);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
                requestDispatcher.forward(request, response);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        //url bata tanna lai doGet vitra dopost rakheko

        doPost(request,response);

    }



    public void destroy() {
    }
}