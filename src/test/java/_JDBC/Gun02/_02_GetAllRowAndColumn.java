package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowAndColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        // ResultSet: data+ diğer bilgiler (data dışındaki bilgiler--kolon sayısı tipleri ve isimleri gibi)

        rs.getMetaData(); //görünen datanın ötesindeki görünmez bilgiler META-ötesi, görünmeyeni demek
        //datayı get ile alıyorduk. metaData ile gelen sonuçların tiplerini objelerin kolonlarını özelliklerini alıyoruz


        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i < columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnTypeName = rsmd.getColumnTypeName(i);
            System.out.println("columnTypeName = " + columnTypeName);
            System.out.println("columnName = " + columnName);


        }
    }

    @Test
    public void test2() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();


        //TABLONUN BAŞLIKLARINI ALIYORUM METADATA İLE
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.print(rsmd.getColumnName(i) + "\t");

        System.out.println();

        while (rs.next()) {
            //KURSORUN BULUNDUĞU SATIRDAKI TUM KOLONLAR YAZDIRILIR
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.print(rs.getString(i) + "\t");

            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi


        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane


        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();


        //TABLONUN BAŞLIKLARINI ALIYORUM METADATA İLE
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            //KURSORUN BULUNDUĞU SATIRDAKI TUM KOLONLAR YAZDIRILIR
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));

            System.out.println();
        }
    }



    @Test
    public void test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from actor");

        getTable2("select * from actor");
    }
    public void getTable(String sorgu) throws SQLException {
        ResultSet rs=statement.executeQuery(sorgu);
        ResultSetMetaData rsmd=rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next())
        {
            for(int i=1; i<= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));
            System.out.println();
        }
    }

    public void getTable2(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%d ", rsmd.getColumnDisplaySize(i));

        System.out.println();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                if (rsmd.getColumnDisplaySize(i) > 100) {
                    System.out.printf("%-100s ", rs.getString(i).substring(0,
                            rs.getString(i).length() > 100 ? 100 : rs.getString(i).length()));
                } else
                    System.out.printf("%-" + rsmd.getColumnDisplaySize(i) + "s ", rs.getString(i));
            }

            System.out.println();
       }
    }
}