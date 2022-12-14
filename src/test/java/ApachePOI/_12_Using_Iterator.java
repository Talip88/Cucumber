package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class _12_Using_Iterator {
    public static void main(String[] args) throws IOException {

        String excellFilePath="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(excellFilePath);

        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheetAt(1); // XSSFSheet sheet1=workbook.getSheet("Sheet1");

        Iterator iterator=sheet.iterator();

        while (iterator.hasNext())  // //check row  is present or not------ if yes condition is true
        {
            XSSFRow row= (XSSFRow) iterator.next();
            Iterator cellIterator= row.cellIterator();

            while(cellIterator.hasNext()) //check cell is present or not
            {
               XSSFCell cell= (XSSFCell) cellIterator.next(); //cell objesi oluşturduk....
                switch(cell.getCellType())  // cell lerin içeriği string ya da int olabilir.... type a göre veriyi okuyacağız...
                {
                    case STRING: System.out.print(cell.getStringCellValue()); break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}
