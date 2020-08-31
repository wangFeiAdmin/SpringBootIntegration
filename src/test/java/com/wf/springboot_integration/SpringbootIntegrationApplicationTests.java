package com.wf.springboot_integration;


import com.wf.Exception.UserNotExistException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootIntegrationApplicationTests {
    //获取一个日志记录器
    //Logger logger= LoggerFactory.getLogger(getClass());//括号中即为需要被记录的类
    //日志的输出级别如下，由低到高
    @Test
    void contextLoads() {
//        logger.trace("这是trace");
//        logger.debug("这是debug");
//        logger.info("这是info");
//        logger.warn("这是warn");
//        logger.error("这是error");
//        if(1==1){
//            throw new UserNotExistException();
//        }
    }

}
