package controller.format;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {

    @GetMapping("/ymlEncrypt")
    public String getConfig(){
        return "config/ymlEncrypt";
    }
}
