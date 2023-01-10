package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
    /**  Soru 1:
     *  yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */

    /**  Soru 2:
     * yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */


    public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Dikey Çarpım Tablosu");
        String path="src/test/java/ApachePOI/resource/Table.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);

        //RENKLENDİRME BÖLÜMÜ

        SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
        ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("MOD(ROW(),2)");
        PatternFormatting fill1 = rule1.createPatternFormatting();
        fill1.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
        fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        CellRangeAddress[] regions = {CellRangeAddress.valueOf("A1:Z100")};
        sheetCF.addConditionalFormatting(regions, rule1);


        //HESAPMAKİNESİ BÖLÜMÜ

        Row row;
        for (int i = 1; i <= 10; i++) {

            Cell cell = null;
            for ( int j = 1; j <= 10; j++) {
                int rowCount=sheet.getPhysicalNumberOfRows();
                row = sheet.createRow(rowCount);
                cell = row.createCell(0);
                cell.setCellValue(i + " x " + j + " = " + (i * j));

            }
            int rowCount=sheet.getPhysicalNumberOfRows();
            row = sheet.createRow(rowCount);
            cell=row.createCell(0);
            cell.setCellValue(" ");
        }




        sheet=workbook.createSheet("Yatay Çarpım Tablosu");

        //RENKLENDİRME BÖLÜMÜ

        SheetConditionalFormatting sheetCFF = sheet.getSheetConditionalFormatting();
        ConditionalFormattingRule rule2 = sheetCFF.createConditionalFormattingRule("MOD(ROW(),2)");
        PatternFormatting fill2 = rule2.createPatternFormatting();
        fill2.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
        fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        CellRangeAddress[] region = {CellRangeAddress.valueOf("A1:Z100")};
        sheetCFF.addConditionalFormatting(region, rule1);


        for (int i = 1; i <= 10; i++) {
            row = sheet.createRow(i-1);
            int cellCount=row.getPhysicalNumberOfCells();
            for (int j = 1; j <= 10; j++) {
                Cell cell = row.createCell(cellCount);
                cellCount+=2;
                cell.setCellValue(j + "x" + i + " =" + (j * i));
            }
        }
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();


        // TODO: 12/31/2022 Sadece veri yazdığı bölümü renklendir.
    }
}
