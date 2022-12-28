package _JDBC.Gun01;

import org.junit.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {


public static Connection connection;
public static Statement statement;

    @BeforeTest

    public void DBConnectionOpen()

    {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String userName="root";
        String password="'\"-LhCB'.%k[4S]z";

        try{
           connection= DriverManager.getConnection(url, userName,password);
           statement =connection.createStatement();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @AfterTest

    public void DBConnectionClose()
    {
        try{
             connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test1() throws SQLException {

        ResultSet rs=statement.executeQuery("select * from language");
        rs.next();

        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();

        System.out.println("rs.getString(2) = " + rs.getString(2));

        rs.previous();
        System.out.println("rs.getString(2) = " + rs.getString(2));


    }
}
