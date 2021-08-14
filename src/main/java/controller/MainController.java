package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Stream;

@Controller
public class MainController {

    @GetMapping({"/", "/main"})
    public String main() {
        return "main";
    }

    @GetMapping("/format")
    public String format(Model model) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key", "1key");
        map1.put("val", "1val");
        Map<String, String> map2 = new HashMap<>();
        map1.put("key", "2key");
        map1.put("val", "2val");
        Map<String, String> map3 = new HashMap<>();
        map1.put("key", "3key");
        map1.put("val", "3val");


        Optional<Stream<Map<String, String>>> stream = Optional.empty();

        model.addAttribute("");
        return "form/format";
    }

}
