package cn.lang.server.controller;

import cn.lang.server.utils.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class RandomController {

    @GetMapping("/random")
    public String randomPwd(@RequestParam("length") Integer length){
        if (length==null){
            return RandomUtils.randomwPwd(8);
        }else {
            return RandomUtils.randomwPwd(length);
        }
    }

}
