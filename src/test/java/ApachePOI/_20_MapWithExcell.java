package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _20_MapWithExcell {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Student data");

        Map<String,String> data=new HashMap<String,String>();
        data.put("101","John");
        data.put("102","Can");
        data.put("103","Cem");
        data.put("104","Cin");
        data.put("105","Çın");
        data.put("106","Çun");
        data.put("107","Çon");
        data.put("108","Çin");


        int rowNo=0;
        for (Map.Entry entry:data.entrySet()) {

           XSSFRow row=sheet.createRow(rowNo++);
           row.createCell(0).setCellValue((String)entry.getKey());
           row.createCell(1).setCellValue((String)entry.getValue());
        }

        FileOutputStream outputStream = new FileOutputStream("src/test/java/ApachePOI/resource/MAP.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("Excelle formul yazıldı");

    }
}
