package com.yb.controller;

import com.yb.pojo.Book;
import com.yb.pojo.UOB;
import com.yb.pojo.User;
import com.yb.service.BookService;
import com.yb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:03
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/toUser")
    public ModelAndView toUser(Model model) {
        ModelAndView mv = new ModelAndView();
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);
        List<Book> bookList = bookService.getBookList();
        mv.addObject("user", user);
        mv.addObject("bookList", bookList);
        mv.setViewName("/user/user");
        return mv;
    }

    @RequestMapping(value = "/toMyOrder")
    public ModelAndView toMyOrder() {
        ModelAndView mv = new ModelAndView();
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);
        List<UOB> uobList = userService.getUOBListByUname(user.getUname());
        mv.addObject("user", user);
        mv.addObject("uobList", uobList);
        mv.setViewName("user/myOrder");
        return mv;
    }

    @RequestMapping(value = "/toChangePwd")
    public ModelAndView toChangePwd() {
        ModelAndView mv = new ModelAndView();
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);
        mv.addObject("user", user);
        mv.setViewName("user/changePwd");
        return mv;
    }


    @RequestMapping(value = "/changePwd")
    @ResponseBody
    public String changePwd(String Npwd, String Opwd) {
        String currentUserName = "";
        String msg = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);

        if (!user.getUpwd().equals(Opwd)) {
            msg = "旧密码错误，请检查";
        }
        if (userService.updatePwd(user.getUid(), Npwd) > 0) {
            msg = "密码修改成功！";
        } else {
            msg = "密码修改失败！";
        }
        return msg;
    }

    @RequestMapping(value = "/buyBook")
    @ResponseBody
    public String buyBook(int bid){
        String currentUserName = "";
        String msg = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);

        if (userService.buyBook(bid,user.getUid())){
            msg = "购买成功！";
        }else {
            msg = "购买失败！";
        }
        return msg;
    }


}
