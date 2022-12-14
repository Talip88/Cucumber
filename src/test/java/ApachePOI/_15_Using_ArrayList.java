package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _15_Using_ArrayList {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        ArrayList<Object[]>empdata=new ArrayList<Object[]>();

        empdata.add(new Object[]{"Empid", "Name", "Job"});
        empdata.add(new Object[]{101, "David", "Engineer"});
        empdata.add(new Object[]{102, "Smith", "Manager"});
        empdata.add(new Object[]{103, "Scott", "Analyst"});


        int rowNum=0;

        for (Object[] emp:empdata) {
            XSSFRow row=sheet.createRow(rowNum++);
            int cellNum=0;
            for (Object value:emp) {
                XSSFCell cell =row.createCell(cellNum++);
            }
        }


        String filePath="src/test/java/ApachePOI/resource/ForEachList.xlsx";
        FileOutputStream outputStream=new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();

    }
}
