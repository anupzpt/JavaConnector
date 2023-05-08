package Prepare;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost/mydatabase";

        //connect to database
        Connection conn= DriverManager.getConnection(url,"root","");
        System.out.println("connection success");

        //Prepare statement
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from data WHERE id =? OR address=?");
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"Pkr");

        ResultSet resultSet =preparedStatement.executeQuery();

        while (resultSet.next())
        {
            System.out.print(resultSet.getInt("id" ));
            System.out.print(" ");
            System.out.print(resultSet.getString("name"));
            System.out.print(" ");
            System.out.print(resultSet.getString("address"));
            System.out.print("\n");
        }
    }
}
