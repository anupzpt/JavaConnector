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

        //insert query
//      statement.executeUpdate("insert into data values ('2','Neha','Bkt')");
//      statement.executeUpdate("insert into data values ('3','Riya','Pkr')");

        //delete query
//      statement.executeUpdate("delete from data where id=6");

        //update query
//      statement.executeUpdate("update data set address='BKT' where id=3");
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