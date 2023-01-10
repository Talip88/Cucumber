package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test // Main de olur fark etmez
    public void test1() throws SQLException {

        //JAVA BAGLANTI: MYSQL BAGLANTI : URL HOSTNAME : PORT / DB NAME
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String userName="root"; //USERNAME
        String password="'\"-LhCB'.%k[4S]z"; //PASSWORD

        //CONNECTION
        Connection connection= DriverManager.getConnection(url, userName,password);
        //sql lerin yazılacağı sayfa
        Statement statement =connection.createStatement(); //sorguları çalıştırmam için sayfa aç

        ResultSet rs=statement.executeQuery("select * from actor");
        //sorgunun sonuçları oluştu db de bekliyor
        //hızlı çalışmak için sonuçların hepsi bilgisayarına gelmedi. Sonuçların olduğu yer db nin içi.

        //Peki nasıl alıcam .. ITERATOR ile..

        rs.next(); // ilk satır bilgisayarıma geldi. İlk satırı bilgisayarımıza aldık.

        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        rs.next();//2.satır

        firstName=rs.getString("first_name");
        lastName=rs.getString("last_name");
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);


        connection.close();



    }
}
