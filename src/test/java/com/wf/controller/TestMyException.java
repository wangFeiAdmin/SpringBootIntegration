package com.wf.controller;

import com.wf.Exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestMyException {
    @RequestMapping("/testException")
    @ResponseBody
    public String test(){
        if(1==1){
            throw new UserNotExistException();
        }
        return "ok";
    }
}
