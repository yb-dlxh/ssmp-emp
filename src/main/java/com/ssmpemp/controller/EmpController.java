package com.ssmpemp.controller;

import com.ssmpemp.pojo.Emp;
import com.ssmpemp.service.DeptService;
import com.ssmpemp.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class EmpController {
    @Autowired
    private EmpService es;
    @Autowired
    private DeptService ds;
    @GetMapping("/empall")
    public String all(Model model){
        model.addAttribute("list", es.getAll());
        return "emp";
    }

    @GetMapping("/empallPage")
    public String allpage(Model model, Integer pno){
        model.addAttribute("info", es.getAllByPage(pno));
        return "emp-page";
    }

    @GetMapping("/empallPage2")
    public String allpage2(Model model, Integer pno,Integer psize){
        model.addAttribute("info", es.getAllByMyPage(pno, psize));
        return "emp-page2";
    }

    @GetMapping("/empdel")
    public String delete(@RequestParam("empno") Integer empno, Model model){
       int cnt =  es.delete(empno);
       if(cnt >0){
           return "forward:/empall";
       }else{
           model.addAttribute("error", "2");
           return "failed";
       }
    }

    @GetMapping("/savepage")
    public String savepage(Model model){
        model.addAttribute("info", "add");
        model.addAttribute("emp", new Emp());
        this.addDept(model);
        return  "modify";
    }

    @GetMapping("/updatepage/{empno}")
    public String savepage(Model model,@PathVariable("empno")Integer empno){
        model.addAttribute("info", "update");
        model.addAttribute("emp", es.getOne(empno));
        this.addDept(model);
        return  "modify";
    }

    private void addDept(Model model){
        model.addAttribute("depts", ds.getall());
    }

    @PostMapping("/empsave")
    public String save(Emp emp, Model model){
        int cnt = es.save(emp);
        if(cnt > 0){
            return "redirect:/empall";
        }else{
            model.addAttribute("error", 1);
            return "failed";
        }
    }
    @PostMapping("/empupdate")
    public String update(Emp emp, Model model){
        int cnt = es.update(emp);
        if(cnt > 0){
            return "redirect:/empall";
        }else{
            model.addAttribute("error", 3);
            return "failed";
        }
    }
}
