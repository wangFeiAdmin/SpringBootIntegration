package com.wf.controller;

import com.wf.Exception.UserNotExistException;
import com.wf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes(value = {"user"})
@RequestMapping("/login")
public class LoginController {

    /**
     * 用于验证登录
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/verify",method= RequestMethod.POST)
    public String verifyLogin(User user, Model model){
        //登录成功
        if("王飞".equals(user.getName())&&"123".equals(user.getPassword())){
            model.addAttribute("user",user);
            //通过配置的试图解析器，跳转到登录成功的界面
            return "redirect:/main.html";
        }else{
            model.addAttribute("mss","用户名或密码错误");
            return "index";
        }
    }

    /**
     * 测试自定义异常
     * @return
     */
    @RequestMapping("/testException")
    @ResponseBody
    public String test(){
        if(1==1){

            throw new UserNotExistException();
        }
        return "ok";
    }

    @GetMapping("/esc")
    public String exit(HttpSession session){
        session.invalidate();//清除session 中的数据
        return "redirect:/index.html";
    }
}
