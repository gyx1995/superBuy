
package cs304_SuperBuy;


import java.sql.*;

public class conn {

    protected static String dbClassName = "com.mysql.jdbc.Driver";
    protected static String userName = "root";
    protected static String password = "root";
    protected static String dbURL = "jdbc:mysql://localhost:4321/SuperBuyDB";

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //private Object input;


    // public static void main(String[] args) {
    //     createConnection();
    //     insert();
    //     close();
    // }

    public conn() {
    }

    public static Connection createConnection ()   {
        try {
            //regrister driver
            System.out.println("Attempting to load driver");
            Class.forName(dbClassName);
            System.out.println("Load driver successfully");

            connect = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect Successfully!");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException..." + cnfe.getMessage());
        }
        catch(SQLException ex) {
            System.out.println("connect exception" + ex.getMessage());
        }
        return connect;
    }

    public static void insert() {
        try {
            String insertquery = "insert into customer(cid,cname,phone,address)"
                    +  "values(31,'Kristy',7789858759, '2388 WesternPakrway')";
            statement = connect.createStatement();
            int countInserted = statement.executeUpdate(insertquery);
            System.out.println(countInserted);
        }
        catch (Exception e) {
            System.out.println("Fail to create statement");
        }
    }

    private static void close() {
        try {
            if (connect != null)
                connect.close();
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
        }
        catch (Exception e) {
        }
    }
}