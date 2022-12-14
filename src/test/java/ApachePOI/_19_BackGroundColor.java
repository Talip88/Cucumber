package ApachePOI;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class _19_BackGroundColor {
    public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FormulaWrite");
        XSSFRow row=sheet.createRow(1);


        //Setting Background Color

        XSSFCellStyle style=workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
        style.setFillPattern(FillPatternType.FINE_DOTS);

        XSSFCell cell=row.createCell(1);
        cell.setCellValue("Welcome");
        cell.setCellStyle(style);

        style=workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell=row.createCell(2);
        cell.setCellValue("Auto");
        cell.setCellStyle(style);

        FileOutputStream outputStream = new FileOutputStream("src/test/java/ApachePOI/resource/ExcellOperations.xlsx");
        workbook.write(outputStream);
        outputStream.close();

        System.out.println("Excelle formul yazıldı");
    }
}








