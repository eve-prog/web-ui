package ro.sda.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @GetMapping(path = "/")     //url -ul este /
    public String homePage(){
        return "home.html";
    }
    @GetMapping("items")    // url-ul este items
    public String items(){
        return"items.html";
    }
    @GetMapping("menu")
    public String menu(){
        return"menu.html";
    }
    @GetMapping("operation")
    public String operation(){
        return "operation.html";
    }
}
