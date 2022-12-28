package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_FirstLastGetRowGetType extends JDBCParent {

    @Test
    public void test() throws SQLException {

        ResultSet rs=statement.executeQuery("select city_id, country_id from city;");

        rs.last(); // sonuncu satıra gider

        String id=rs.getString(1); //city id gelecek çünkü zaten onu almıştım
        System.out.println("id = " + id);

        int idInt=rs.getInt(1);
        System.out.println("idint = " + idInt);

        // Integer da olsa String de olsa tüm verileri alabilirim. Verileri kendi tipinde de alabilirim. Hepsini String de alabilirim.

        int currentRow=rs.getRow(); // KAÇINCI SATIRDA OLDUĞUMU GÖRÜYORUM...
        System.out.println("currentRow = " + currentRow);


        rs.first(); // İLK SATIRA GİDER







    }
}
