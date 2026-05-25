package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {
    //bad practice
    //row and col > start from 0
    private static final String TEST_DATA_PATH = "src/test/resource/test-data/";
    public static String getExcelData(String filePath, String sheetName, int rowNum, int cellNum){
        XSSFWorkbook workbook;
        XSSFSheet sheet;

        String cellData;
        try{
            String excelFileName = "";
            workbook = new XSSFWorkbook(TEST_DATA_PATH + excelFileName);
            sheet = workbook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum-1).getCell(cellNum-1).getStringCellValue();
            workbook.close();
            return cellData;
        }catch (IOException e){
            System.out.println("Error reading Excel file: " + e.getMessage());
            return "";
        }
    }
}
