package com.wf.compont;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取参数
        String l = request.getParameter("l");
        Locale locale=Locale.getDefault();//获取默认的配置
        //判断参数是否为空
        if(!StringUtils.isEmpty(l)){
            //将传入的地区和语言进行拆分
            String [] target=l.split("_");
            //传入语言，地区
            locale=new Locale(target[0],target[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
