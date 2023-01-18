package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    //Actor tablosundaki tüm verileri yeni excelle yazdırınız

    @Test
    public void test4() throws SQLException, IOException {

        // Excell Oluşturma Kısmı***************************************************************************************

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("JDBC");
        String path = "src/test/java/ApachePOI/resource/Jdbc.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);

        // DATABASE'DEN VERİ ÇEKME**************************************************************************************

        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();

        //EXCELLE DATA YAZDIRMA*****************************************************************************************
        int rowNum = 0;
        while (rs.next()) {
            XSSFRow row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                XSSFCell cell = row.createCell(colNum++);
                cell.setCellValue(rs.getString(i));
            }
        }
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}