package com.zly.controller;

import com.zly.model.SelectQuestion;
import com.zly.service.SelectQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zly11 on 2018/5/22.
 */
@Controller
public class PaparController {


    @Autowired
    private SelectQuestionService selectQuestionService;

    @RequestMapping("paper/item")
    public String item(Model model){
        List<SelectQuestion> list = selectQuestionService.getAll();
        model.addAttribute("list",list);
        return "paper/item";
    }
}
