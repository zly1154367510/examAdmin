package com.zly.controller;

import com.zly.model.Score;

import com.zly.model.SelectItem;
import com.zly.model.SelectQuestion;
import com.zly.model.TestPaper;
import com.zly.service.ScoreService;

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
        for (TestPaper item : list){
            int itemId = item.getqId();
            String[] qId = request.getParameterValues(itemId+"");
            for (SelectItem i:item.getSelectQuestion().getItemList()){//此处循环进入问题的选项
                for(String j : qId){//此处循环时取出学生选择的选项

                    if (j.equals(i)&&i.getIsanswer()){
                        scord++;
                    }
                }
            }
        }
        return JsonResult.ok(scord);
    }


}
