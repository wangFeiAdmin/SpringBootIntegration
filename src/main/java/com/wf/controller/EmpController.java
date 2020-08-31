package com.wf.controller;

import com.wf.pojo.Department;
import com.wf.pojo.Employee;
import com.wf.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    @Qualifier("empServiceImpl")
    private EmpService empService;

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @GetMapping("/selectAll")
    public String getEmpAll(Model model){
        model.addAttribute("empAll",empService.getAll());
        return "list";
    }

    /**
     * 查询所有部门，并跳转到添加员工的页面
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String  getAddPage(Model model){
        model.addAttribute("depts",empService.getDeptAll());
        return "addEmp";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(method ={ RequestMethod.POST,RequestMethod.PUT},value = {"/addEmp"})
    public String  addEmp(Employee employee){
        System.err.println(employee);
        empService.addEmp(employee);
        return "redirect:/emp/selectAll";
    }

    /**
     * 获取即将修该的员工信息
     * @param id
     * @return
     */
    @GetMapping("/getUpdateMass/{id}")
    public String showUpdateMassage(@PathVariable Integer id,Model model){
        //获取需要修改的员工
        model.addAttribute("updateEmp",empService.getEmployee(id));
        model.addAttribute("depts",empService.getDeptAll());
        return "addEmp";
    }

    @GetMapping("/delete/{id}")
    public  String  deleteEmp(@PathVariable Integer id){
        empService.deleteEmp(id);
        return "redirect:/emp/selectAll";
    }

}
