package config.component.file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

@Component
public class ExcelUtil {

    private Workbook workbook;
    private InputStream inputStream;
    private String ext;

    public ExcelUtil() {
        System.out.println("ExcelUtil 생성 완료");
    }

    private void setExt(String ext) {
        this.ext = ext;
    }

    private void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private void init(MultipartFile multipartFile) throws IOException {
        setInputStream(multipartFile.getInputStream());
        setExt(multipartFile.getOriginalFilename().split(Pattern.quote("."))[1]);
        setWorkbook();
    }

    private void setWorkbook() throws IOException {
        if (ext.equals(FileExtentionsEnum.XLSX.getStr())) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (ext.equals(FileExtentionsEnum.XLS.getStr())) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IOException("Unsupported ext type");
        }
    }

    public JSONObject readXmlFile() throws IOException {
        Sheet workSheet = workbook.getSheetAt(0);
        int rowSize = workSheet.getPhysicalNumberOfRows();
        System.out.println(workSheet.getPhysicalNumberOfRows());
        System.out.println(workSheet.getLastRowNum());
        for (int i = 1; i < rowSize; i++) {
            Row row = workSheet.getRow(i);
            Cell nameCell = row.getCell(0);
            Cell lengthCell = row.getCell(1);
            Cell valueCell = row.getCell(2);
            System.out.println("nameCell : " + getCellValue(nameCell));
            System.out.println("lengthCell : " + getCellValue(lengthCell));
        }
        return null;
    }

    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC: return String.valueOf((int) cell.getNumericCellValue());
            case STRING: return cell.getStringCellValue();
            default: return "";
        }
    }

    public JSONObject getXmlToJson(MultipartFile multipartFile) throws IOException {
        init(multipartFile);
        readXmlFile();
        return null;
    }
}
