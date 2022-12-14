package ApachePOI;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _17_FormulaCellCreate {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FormulaWrite");
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue(10);
        row.createCell(1).setCellValue(20);
        row.createCell(2).setCellValue(30);

        row.createCell(3).setCellFormula("A1*B1*C1");

        FileOutputStream outputStream=new FileOutputStream("src/test/java/ApachePOI/resource/Formula.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("Excelle formul yazıldı");


    }
}
