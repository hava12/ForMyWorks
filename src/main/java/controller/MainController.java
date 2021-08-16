package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping({"/", "/main"})
    public String main() {
        return "main";
    }

}
