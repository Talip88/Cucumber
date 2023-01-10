package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _14_UsingForEachLoop {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        Object empData[][] = {

                {"EmpID", "Name", "Job", "status"},
                {101, "David", "Engineer", true},
                {102, "Smith", "Manager", false},
                {103, "Scott", "Analyst", true}};

        int rowCount = 0;
        for (Object emp[] : empData) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object value : emp) {
                XSSFCell cell = row.createCell(columnCount++);

                if (value instanceof String) {
                    cell.setCellValue((String) (value));
                } else if (value instanceof Integer) {
                    cell.setCellValue((Integer) (value));
                } else if (value instanceof Boolean) {
                    cell.setCellValue((Boolean) (value));
                }

                String filePath = "src/test/java/ApachePOI/resource/ForEachList.xlsx";
                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                outputStream.close();

            }

        }System.out.println("Employee excell file written successfully");
    }
}