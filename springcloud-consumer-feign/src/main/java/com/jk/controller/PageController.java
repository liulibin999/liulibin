package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toShowGoods")
    public String toShowGoods(){
        return "showGoods";
    }

    @RequestMapping("/toAddGood")
    public String toAddGood(){
        return "addGood";
    }


}
