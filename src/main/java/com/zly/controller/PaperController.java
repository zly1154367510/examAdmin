package com.zly.controller;

import com.zly.model.Paper;
import com.zly.model.TestPaper;
import com.zly.service.SelectQuestionService;
import com.zly.service.TestPaperService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */

@Controller
public class PaperController {

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private SelectQuestionService selectQuestionService;

    @RequestMapping("paper/item")
    public String item(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model){
        long pages = testPaperService.getNum() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        List<Paper> list = testPaperService.getAll(page);
        model.addAttribute("list",list);
        return "paper/item";
    }

    @RequestMapping("paper/addItem")
    public String addItem(){
        return "paper/addItem";
    }


    @RequestMapping("paper/addItemDo")
    public String addItemDo(@RequestParam("name")String name,@RequestParam("subject")String subject,@RequestParam("questionItemId")Integer[] id,Model model){
//        System.out.println(name);
//        System.out.println(subject);
//        System.out.println(id);
        int i = testPaperService.insertPaper(subject,name,id);
        if (i!=0){
            model.addAttribute("message","成功创建一套试题");
        }else{
            model.addAttribute("message","创建试题失败请重试");
        }
        return "message/success";
    }

    @ResponseBody
    @RequestMapping("paper/questionItem")
    public JsonResult questionItem(@RequestParam("id")Integer id){
        return JsonResult.ok(testPaperService.SelectAllByPId(id));
    }

    @ResponseBody
    @RequestMapping("paper/questionItemBySubject")
    public JsonResult questionItemBySubject(@RequestParam(value = "page", required = false, defaultValue = "1") int page,@RequestParam("subject")String subject){
        System.out.print(page);
        return JsonResult.ok(selectQuestionService.selecBySubject(subject,page));
    }


}
