package config.component.file;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileUtil {
    public void stringToFile(String fileName) {
        System.out.println("stringToFile");
        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
    }
}
