package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _18_ExcellOperations {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FormulaWrite");

        for ( int i = 0; i < 5; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 5; j++) {
                XSSFCell cell = row.createCell(j);


            }

            //sheet.getRow(i).getCell(j).setCellFormula("TOPLA(C2:C6)");

                FileOutputStream outputStream = new FileOutputStream("src/test/java/ApachePOI/resource/ExcellOperations.xlsx");
                workbook.write(outputStream);
                outputStream.close();


        }System.out.println("Excelle formul yazıldı");
    }
}