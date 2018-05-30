package com.zly.controller;

import com.zly.model.*;

import com.zly.service.ScoreService;

import com.zly.service.SelectQuestionService;
import com.zly.service.TestPaperService;
import com.zly.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.annotate.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Controller
public class ScordController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private SelectQuestionService selectQuestionService;

    @RequestMapping("score/item")
    public String item(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page){

        long pages = scoreService.selectNumAll() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        List<Score> list = scoreService.selectAll(page);
        model.addAttribute("list",list);
        return "score/item";
    }

    @ResponseBody
    @RequestMapping("mi/score/evaluate")
    public JsonResult evaluate(@RequestParam("username")String username, @RequestParam("pId")String pId, HttpServletRequest request){
        List<TestPaper> list = testPaperService.SelectAllByPId(new Integer(pId));
        Integer scord = 0;
        ex:
        for (TestPaper question : list){
            int questionId = question.getqId();//获取试卷id
            if (request.getParameterValues(questionId+"")==null){
                String[] itemId = null;
            }
            String[] itemId = request.getParameterValues(questionId+"");//通过试卷id获取用户的选项
            //把试卷id和用户选项传入service进行评定
            if (scoreService.evaluationScore(questionId,itemId)){
                scord ++ ;
            }
        }
        Paper paper = testPaperService.selecPaperById(Integer.parseInt(pId));
        scord = scord * Integer.parseInt(paper.getScore());
        int res = scoreService.insertAll(username,paper.getSubject(),pId,scord.toString());
        testPaperService.delByUsernamePaper(username,Integer.parseInt(pId));
        if (res==0){
            return JsonResult.errorMsg("保存失败:"+scord);
        }
        return JsonResult.ok(scord);
    }

    @ResponseBody
    @RequestMapping("mi/score/item")
    public JsonResult item(@RequestParam("username")String username){
        return JsonResult.ok(scoreService.selectBySId(username));
    }


}
