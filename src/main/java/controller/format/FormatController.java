package controller.format;

import config.component.file.ExcelUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FormatController {

    private final ExcelUtil excelUtil;

    @Autowired
    public FormatController(ExcelUtil excelUtil) {
        this.excelUtil = excelUtil;
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
        JSONObject xmlJson = excelUtil.getXmlToJson(multipartFile);
        //File file = new File(multipartFile.getOriginalFilename());
        //multipartFile.transferTo(file);
        //System.out.println(file.getAbsolutePath());

        return "xmlJson.toJSONString()";
    }

}
