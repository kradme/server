package cn.lang.server.controller;

import cn.lang.server.entity.PwdLog;
import cn.lang.server.repo.PwdLogRepo;
import cn.lang.server.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class WebController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PwdLogRepo pwdLogRepo;

    @GetMapping(value = "/random")
    public ModelAndView list(Model model, Integer start, Integer limit){
        start = (start==null||start<0) ? 0 :start;
        limit = (limit==null||limit<=0) ? 20 :limit;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<PwdLog> all = pwdLogRepo.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("page", all);
        return modelAndView;
    }

    @PostMapping("/genRan")
    public String randomPwd(Model model, Integer length, String userName){
        logger.debug("收到请求，length={}, userName={}", length, userName);
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
            pwdLog.setUserName(userName);
            pwdLogRepo.save(pwdLog);
        }
        return "redirect:/random";
    }

}
