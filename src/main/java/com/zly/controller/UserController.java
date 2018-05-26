package com.zly.controller;

import com.zly.model.SelectQuestion;
import com.zly.model.Student;
import com.zly.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Controller
public class UserController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("user/item")
    public String item(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page){

        long pages = studentService.selectNumAll() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        List<Student> list = studentService.selectAll(page);
        model.addAttribute("list",list);
        return "user/item";
    }

}
