package com.zly.controller;

import com.zly.model.Admin;
import org.springframework.stereotype.Controller;
import com.zly.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by zly11 on 2018/5/22.
 */

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("admin",new Admin());
        return "login/login";
    }

    @RequestMapping("/loginDo")
    public String loginDo(Model model, @ModelAttribute("admin")@Valid Admin admin, Errors errors, HttpServletRequest request){
        if (errors.hasErrors()){
            //model.addAttribute("admin",admin);
            return "login/login";
        }
        if (adminService.login(admin.getUsername(), admin.getPassword())!=null){
            request.getSession().setAttribute("username",admin.getUsername());
//            model.addAttribute("message","登录成功");
        }else{
            model.addAttribute("message","登录失败");
            return "message/success";
        }
        return "redirect:/question/item";
    }



}
