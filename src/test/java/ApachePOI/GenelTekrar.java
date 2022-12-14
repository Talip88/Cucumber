package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GenelTekrar {
    public static void main(String[] args) throws IOException {

        String excellFilePath="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(excellFilePath);

        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheetAt(0); // XSSFSheet sheet1=workbook.getSheet("Sheet1");

        int i=0;
        int rows=sheet.getLastRowNum();
        int cols=sheet.getRow(i).getLastCellNum();

        for ( i = 0; i < rows; i++) { // OUTER LOOP -----> ROWS
            XSSFRow row=sheet.getRow(i); //-----before creating cell we need to get row
            for (int j = 0; j <cols ; j++) { //INNER LOOP --->>> COLUMNS
              XSSFCell cell=row.getCell(j);      // we create and read cells in this loop...... execute multiple times

                switch(cell.getCellType())  // cell lerin içeriği string ya da int olabilir.... type a göre veriyi okuyacağız...
                {
                    case STRING: System.out.println(cell.getStringCellValue()); break;
                    case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
                    case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
                }

            }
        }




    }
}
