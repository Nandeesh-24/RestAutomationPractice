import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ReadData {
    @Test
    public void readExcel() throws IOException {
        File src = new File("src/test/resources/VoltDemoApplication_Testcases.xlsx");

        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook xsf = new XSSFWorkbook(fis);

        XSSFSheet sheet = xsf.getSheetAt(0);

        while(sheet.rowIterator().hasNext()){

        }

        String row1=sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row1);
        sheet.getRow(0).getCell(0).setCellValue("desc");
        String row2=sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row2);
        xsf.close();
    }

    @Test
    public void readCsv() throws IOException, CsvValidationException {

        ObjectMapper mapper = new ObjectMapper();

        CSVReader reader = new CSVReader(new FileReader("src/test/resources/VoltDemoApplication_Testcases - Sheet1.csv"));

        String data[];

        while ((data=reader.readNext()) != null){
            for (String s : data){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
