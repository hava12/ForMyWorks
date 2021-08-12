package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/","/main"})
    public String main(){
        return "main";
    }

    @GetMapping("/format")
    public String format(){
        return "form/format";
    }

}
