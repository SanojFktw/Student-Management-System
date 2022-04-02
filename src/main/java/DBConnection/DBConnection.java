package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    Connection connection = null;

    public DBConnection(){
        try {
            //driver load gareko Class.forName le
            Class.forName("com.mysql.jdbc.Driver");
            String DB_URL = "jdbc:mysql://localhost:3306/studentmanagement";
            String name = "root";
            String password = "";

            //connection gareko
            this.connection = DriverManager.getConnection(DB_URL, name, password);
            System.out.println("Database Connected !!");

            //duita exception aauxa euta driver load vayena vane and arko url name pass kunai ma wrong vayo vane exception aauxa sql exception
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
    }

    public PreparedStatement getStatement(String query){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;

    }

}
