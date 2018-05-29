package com.zly.controller;

import com.zly.model.Paper;
import com.zly.model.TestPaper;
import com.zly.service.SelectQuestionService;
import com.zly.service.TestPaperService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public String addItemDo(@RequestParam("name")String name,@RequestParam("subject")String subject,@RequestParam("questionItemId")Integer[] id,@RequestParam("time")String time,Model model){
//        System.out.println(name);
//        System.out.println(subject);
//        System.out.println(id);
        int i = testPaperService.insertPaper(subject,name,id,time);
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
        return JsonResult.ok(selectQuestionService.selecBySubject(subject,page));
    }

    @ResponseBody
    @RequestMapping("mi/user/paper")
    public JsonResult paper(@RequestParam(value = "page", required = false, defaultValue = "1") int page){

        return JsonResult.ok(testPaperService.getAll(page));
    }

    @ResponseBody
    @RequestMapping("mi/user/paperDeta")
    public JsonResult paperDeta(@RequestParam("id")int id){
        return JsonResult.ok(testPaperService.SelectAllByPId(id));
    }

    @ResponseBody
    @RequestMapping("mi/user/paperTime")
    public JsonResult paperTime(@RequestParam("id")int id){
        return JsonResult.ok(testPaperService.selTimeById(id));
    }

    @RequestMapping("mi/user/savePaper")
    public void ascePaper(@RequestBody Map<String,String> params){
//        System.out.println("-----------------------");
//        System.out.println(params);
//        System.out.println("------------------");
        int paperId = Integer.parseInt(params.get("paper"));
        String username = params.get("username");
        String time = params.get("time");
        testPaperService.delByUsernamePaper(username,paperId);
        Date date = new Date();
        for (Map.Entry<String,String> entry:params.entrySet()){
            if (entry.getKey()!="username"&&entry.getKey()!="paper"&&entry.getKey()!="time"){
                testPaperService.savePaper(username,paperId, Integer.parseInt(entry.getKey()),entry.getValue(),time,date);
            }
        }
    }

    @RequestMapping("mi/user/noPerPaper")
    @ResponseBody
    public JsonResult noPerPaper(@RequestParam("username")String username){
        return JsonResult.ok(testPaperService.selectNoPerByUsername(username));
    }


}
