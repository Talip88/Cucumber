package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        //next(): bulunduğu yerden bir sonraki row
        // previous() :bulunduğu yerden bir önceki row
        // absolute (4) : baştan itibaren 4.row

        ResultSet rs=statement.executeQuery("select * from city");

        rs.absolute(10);

        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // baştan itibaren verilen rakamın bulunduğu rowa gider

        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15);
        title=rs.getString("title");
        System.out.println("title = "+title);

        rs.absolute(10);

        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5);
        title=rs.getString("title");
        System.out.println("relative = "+title);

        rs.first(); // ilk satıra gider
        title=rs.getString("title");
        System.out.println("title = "+title);


    }
}
