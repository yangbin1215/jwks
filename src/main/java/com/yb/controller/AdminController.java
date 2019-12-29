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
 * @date 2019/12/19 -16:05
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/toAdmin")
    public ModelAndView toAdmin(Model model) {
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
        mv.setViewName("/admin/admin");
        return mv;
    }
    @RequestMapping(value = "/toAllOrder")
    public ModelAndView toAdmin() {
        ModelAndView mv = new ModelAndView();
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = userService.queryUserByUname(currentUserName);
        List<UOB> uobList = userService.getUOBList();
        mv.addObject("user", user);
        mv.addObject("uobList", uobList);
        mv.setViewName("admin/AllOrder");
        return mv;
    }

    @RequestMapping(value = "/updateBook")
    @ResponseBody
    public String updateBook(Book book){
        String msg = "";
        if (bookService.updateBookInfo(book)){
            msg = "修改成功！";
        }else {
            msg = "修改失败！";
        }
        return msg;
    }
}
