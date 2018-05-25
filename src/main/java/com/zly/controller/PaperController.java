package com.zly.controller;

import com.zly.model.TestPaper;
import com.zly.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */

@Controller
public class PaperController {

    @Autowired
    private TestPaperService testPaperService;

    @RequestMapping("paper/item")
    public String item(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model){
        long pages = testPaperService.getNum() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        List<TestPaper> list = testPaperService.getAll(page);
        model.addAttribute("list",list);
        return "paper/item";
    }

    @RequestMapping("paper/addItem")
    public String addItem(){
        return "paper/addItem";
    }


    @RequestMapping("paper/addItemDo")
    public String addItemDo(){
        return "message/success";
    }

}
