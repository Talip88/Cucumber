package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class _16_FormulaCellRead {
    public static void main(String[] args) throws IOException {

        // Formul bulunan excell satırlarını okuma

        FileInputStream file=new FileInputStream("src/test/java/ApachePOI/resource/Formula.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("FormulaWrite");
        int rows=sheet.getPhysicalNumberOfRows();

        int i=0;
        int cols=sheet.getRow(i).getLastCellNum();

        for ( i = 0; i <rows; i++) {
            XSSFRow row=sheet.getRow(i);
            for (int j = 0; j <cols; j++) {
                XSSFCell cell=row.getCell(j);

                switch(cell.getCellType())  // cell lerin içeriği string ya da int olabilir.... type a göre veriyi okuyacağız...
                {
                    case STRING: System.out.print(cell.getStringCellValue()); break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
                    case FORMULA: System.out.print(cell.getCellFormula()); break;  // TYPE FORMUL İSE .....****
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}
