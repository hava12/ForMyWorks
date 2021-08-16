package config.component.file;

public enum FileExtentionsEnum {
    XLS("xls"), XLSX("xlsx");

    String strName;
    FileExtentionsEnum(String strName) {
        this.strName = strName;
    }
    String getStr() {
        return strName;
    }
}
