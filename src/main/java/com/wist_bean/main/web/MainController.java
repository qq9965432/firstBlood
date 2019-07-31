package com.wist_bean.main.web;

import com.wist_bean.main.domain.Tab;
import com.wist_bean.main.service.impl.ReplyServiceImpl;
import com.wist_bean.main.service.impl.TabServiceImpl;
import com.wist_bean.main.service.impl.TopicServiceImpl;
import com.wist_bean.user.service.impl.UserServiceImpl;
import com.wist_bean.util.StringUtils;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * 主控制类
 */
@Controller
public class MainController {

    @Autowired
    public TopicServiceImpl topicService;
    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TabServiceImpl tabService;

    /**
     * 进入登录页面.
     */
    @RequestMapping(value = {"/signin"})
    public String signin(Model model){
        boolean isLogin = SecurityUtils.getSubject().isAuthenticated();
        if(!isLogin) {
        	SecurityUtils.getSubject().logout();
        	 //获取统计信息
            int topicsNum=topicService.getTopicsNum();
            int usersNum=userService.getUserCount();
            model.addAttribute("topicsNum", topicsNum);
            model.addAttribute("usersNum", usersNum);
        	return "jsp/signin";
        }else {
        	return "redirect:/";
        }
    }

    /**
     * 进入注册页面.
     */
    @RequestMapping("/signup")
    public String signup(Model model){
        boolean isLogin = SecurityUtils.getSubject().isAuthenticated();
        if(!isLogin) {
        	SecurityUtils.getSubject().logout();
        	 //获取统计信息
            int topicsNum=topicService.getTopicsNum();
            int usersNum=userService.getUserCount();
            model.addAttribute("topicsNum", topicsNum);
            model.addAttribute("usersNum", usersNum);
            return "jsp/signup";
        }else {
        	return "redirect:/";
        }
    }

    /**
     * 进入新建主题页面
     */
    @RequestMapping(value = {"/new"})
    public ModelAndView newTopic(){
        ModelAndView newTopicPage=new ModelAndView("jsp/new");
        List<Tab> tabs=tabService.getAllTabs();

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        newTopicPage.addObject("tabs",tabs);
        newTopicPage.addObject("topicsNum",topicsNum);
        newTopicPage.addObject("usersNum",usersNum);
        return  newTopicPage;
    }

    /**
     * 配置404页面
     */
    @RequestMapping("*")
    public String notFind(){
        return "jsp/404";
    }
}
