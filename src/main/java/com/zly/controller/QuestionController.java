package com.zly.controller;

import com.zly.model.SelectQuestion;
import com.zly.service.SelectQuestionService;
import com.zly.utils.JsonResult;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by zly11 on 2018/5/22.
 */
@Controller
public class QuestionController {


    @Autowired
    private SelectQuestionService selectQuestionService;

    @RequestMapping("question/item")
    public String item(Model model,@RequestParam(value = "page", required = false, defaultValue = "1") int page){

        long pages = selectQuestionService.getItemNum() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        List<SelectQuestion> list = selectQuestionService.getAll(page);
        model.addAttribute("list",list);
        return "question/item";
    }
    @RequestMapping("question/itemDetail")
    public String itemDetail(Model model, @RequestParam("id")int id){
        //System.out.println(id);
        model.addAttribute("item",selectQuestionService.selectById(id));
        return "question/itemDetails";
    }
    @RequestMapping("question/itemDetailDo")
    public String itemDetail(Model model,HttpServletRequest request){
        int itemId = new Integer(request.getParameter("itemId"));
        String subject = request.getParameter("subject");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String[] isanswer = request.getParameterValues("isanswer");
        String[] trueAnswer = request.getParameterValues("trueAnswer");
        String[] content = request.getParameterValues("content");
        String[] itemmId = request.getParameterValues("itemmId");
        int i = selectQuestionService.updateQuestion(itemId,subject,type,title,trueAnswer,isanswer,content,itemmId);
        if (i != 0) {
            model.addAttribute("message","成功修改"+1+"条");
        }
        else{
            model.addAttribute("message","修改失败");
        }
        return "message/success";
    }

    @RequestMapping("question/addItem")
    public String addItem(){
        return "question/addItem";
    }

    @RequestMapping("question/addItemDo")
    public String addItemDo(
            @RequestParam("subject")String subject,
            @RequestParam("type")String type,
            @RequestParam("title")String title,
            @RequestParam("isanswer")Integer[] isanswer,
            @RequestParam("content")String[] content,
            Model model){

//        System.out.println(subject);
//        System.out.println(type);
//        System.out.println(title);
//        System.out.println(isanswer);
//        System.out.println(content);
        int res = selectQuestionService.insertQuestion(subject,type,title,isanswer,content);
        if (res != 0){
            model.addAttribute("message","成功加入"+res+"条题目");
            return "message/success";
        }else{
            model.addAttribute("message","添加题目失败请重试");
            return "message/success";
        }

    }

    @ResponseBody
    @RequestMapping("question/selQuestionBysubject")
    public JsonResult selQuestionBysubject(@RequestParam("subject")String subject, @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        return JsonResult.ok(selectQuestionService.selecBySubject(subject, page));
    }
}
