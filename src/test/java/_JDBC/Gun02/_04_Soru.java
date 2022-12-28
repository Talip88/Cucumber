package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    //Actor tablosundaki tüm verileri yeni excelle yazdırınız

    @Test
    public void test4() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s", rs.getString(i));

            System.out.println();

        }

        XSSFWorkbook workbook = new XSSFWorkbook(); // hafızada bir workbook oluşturuldu
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // içinde sheet oluşturdum

        Row yeniSatir = sheet.createRow(0); // hafızada satır oluşturuldu 0.yerde
        Cell yeniHucre = yeniSatir.createCell(0); // hafızada yeni satırda ilk hucre olusturuldu

        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            yeniSatir.createCell(i).setCellValue(i);  // Merhaba Dünya 1 2 3 4 5 6 7 8 9
        }
    }
}