package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class _12_ITERATOR {
    public static void main(String[] args) throws IOException {

        String excellFilePath="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(excellFilePath);

        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheetAt(1); // XSSFSheet sheet1=workbook.getSheet("Sheet1");

        Iterator iterator=sheet.iterator();



    }
}
