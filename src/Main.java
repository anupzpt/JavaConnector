import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost/mydatabase";
        
        //connect to database
        Connection conn= DriverManager.getConnection(url,"root","");
        System.out.println("connection success");

        //fetch data from database
        Statement statement =conn.createStatement();
        ResultSet resultSet=statement.executeQuery("Select * from data");
        System.out.println(resultSet);

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