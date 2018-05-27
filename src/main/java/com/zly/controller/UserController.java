package com.zly.controller;

import com.zly.model.SelectQuestion;
import com.zly.model.Student;
import com.zly.service.StudentService;
import com.zly.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("user/addItem")
    public String addItem(Model model){
        return "user/addItem";
    }

    @RequestMapping("user/addItemDo")
    public String addItemDo(
            Model model,
            @RequestParam("username")String username,
            @RequestParam("name")String name,
            @RequestParam("password")String password
    ){
        int res = studentService.insertAll(username, name, password);
        if (res != 0 ){
            model.addAttribute("message","成功添加一名用户");
        }else{
            model.addAttribute("message","添加失败，请冲重试");
        }

        return "message/success";
    }

    @ResponseBody
    @RequestMapping("mi/user/login")
    public JsonResult login(@RequestParam("username")String username,@RequestParam("password")String password){
        //String username = request.getParameter("username");
        Student student = studentService.login(username,password);
        if (student != null) {
            return JsonResult.ok(student);
        }else{
            return JsonResult.exitUser();
        }
    }

}
