package cn.lang.server.controller;

import cn.lang.server.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class RandomController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/random")
    public String randomPwd(Integer length){
        logger.debug("收到请求，length={}", length);
        if (length==null){
            return RandomUtils.randomwPwd(8);
        }else {
            return RandomUtils.randomwPwd(length);
        }
    }

}
