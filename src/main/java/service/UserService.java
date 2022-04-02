package service;

import DBConnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //inserting new user
    public void insertUser(User users){
        String query = "insert into users (userName, password, fullName)" + "values(?,?,?)";
        System.out.println(query);
        //PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        //or
        DBConnection dbConnection = new DBConnection();
        PreparedStatement preparedStatement = dbConnection.getStatement(query);
        try {
            //insertUser vitra User ko object (users) ma value servlet getUsername vanne method le tanera data base ma set gareko
            preparedStatement.setString(1, users.getUserName());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getFullName());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
//Deleting User
    public void deleteUser(int id){
        String query = "DELETE FROM users WHERE id = ?";
        System.out.println(query);
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try{
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
//update user

    public void updateUser(User user, int id) throws  SQLException{
        String query = "UPDATE users SET userName = ?, password = ?, fullName = ?" + "WHERE id = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFullName());
        preparedStatement.setInt(4, id);
            preparedStatement.execute();

    }

    //login
    public User getUser(String userName, String password) throws SQLException{

        User user = null;
        String query = "Select * from users where userName = ? and password = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);

        //login garda dherai users haru ko credentials hunxa so jun pani huna sakne--
        //--vako le sabai check garnu parxa ani rs le pointer sardai lanxa ani --
        //--textfield ma jun username ra password haleko vetxa tya rokxa ani login huna dinxa
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));
        }
        return user;
    }

    //get User list stored in database
    public List<User> getUserList() throws SQLException{

        List<User> alist = new ArrayList<>();
        String query = "select * from users ";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));



            alist.add(user);

        }
        return alist;

    }

    public User getUserRow(int id){
        User user = new User();
        String query = "Select * from users where id = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try{
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
