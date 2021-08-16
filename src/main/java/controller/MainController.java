package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        map2.put("key", "2key");
        map2.put("val", "2val");
        Map<String, String> map3 = new HashMap<>();
        map3.put("key", "3key");
        map3.put("val", "3val");

        List<Map<String, String>> list = new ArrayList<>();

        list.add(map1);
        list.add(map2);
        list.add(map3);

        //Optional<Stream<Map<String, String>>> stream = Optional.empty();

        model.addAttribute("list", list);
        return "format/format";
    }

    @PostMapping("/format/file")
    @ResponseBody
    public String formatFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        System.out.println(multipartFile.getInputStream());
        File file = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        System.out.println(file.getAbsolutePath());
        return "";
    }

}
