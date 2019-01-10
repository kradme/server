package cn.lang.server.controller;

import cn.lang.server.entity.PwdLog;
import cn.lang.server.repo.PwdLogRepo;
import cn.lang.server.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RandomController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PwdLogRepo pwdLogRepo;

    @RequestMapping("/random")
    public String randomPwd(Integer length){
        logger.debug("收到请求，length={}", length);
        String pwd = null;
        if (length==null){
            pwd = RandomUtils.randomwPwd(8);
        }else {
            pwd = RandomUtils.randomwPwd(length);
        }
        if(pwd!=null){
            PwdLog pwdLog = new PwdLog();
            pwdLog.setPwd(pwd);
            pwdLog.setRequestDate(new Date());
            pwdLogRepo.save(pwdLog);
        }
        return pwd;
    }

}
