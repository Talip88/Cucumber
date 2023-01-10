package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _13_ApachePOI_Recap2 {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        Object empData[][] = {

                {"EmpID", "Name", "Job"},
                {101, "David", "Engineer"},
                {102, "Smith", "Manager"},
                {103, "Scott", "Analyst"}};

        //Using normal for loop
        int i = 0;
        int rows = empData.length;
        int cols = empData[i].length;

        System.out.println(rows);
        System.out.println(cols);

        for (i = 0; i < rows; i++) {

            XSSFRow row = sheet.createRow(i);

            for (int j = 0; j < cols; j++) {

                XSSFCell cell = row.createCell(j);
                Object value = empData[i][j];

                if (value instanceof String) {
                    cell.setCellValue((String) (value));
                } else if (value instanceof Integer) {
                    cell.setCellValue((Integer) (value));
                } else if (value instanceof Boolean) {

                    cell.setCellValue((Boolean) (value));

                }

                String filePath = "src/test/java/ApachePOI/resource/employee.xlsx";
                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                outputStream.close();

            }
        }
        System.out.println("Employee excell file written successfully");
    }
}