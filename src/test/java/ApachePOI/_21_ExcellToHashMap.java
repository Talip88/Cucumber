package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _21_ExcellToHashMap {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream=new FileInputStream("src/test/java/ApachePOI/resource/MAP.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheet("Sheet1");




        HashMap <String,String> data=new HashMap<>();
        int rows=sheet.getLastRowNum();
        //Reading data from excell to HashMap

        for (int i = 0; i <rows ; i++) {

            String key= sheet.getRow(i).getCell(0).getStringCellValue();
            String value=sheet.getRow(i).getCell(1).getStringCellValue();
            data.put(key,value);
            }


        //READ DATA FROM HASHMAP

        for (Map.Entry entry:data.entrySet()){
            System.out.print(entry.getKey()+" "+entry.getValue());
        }
        }
}
