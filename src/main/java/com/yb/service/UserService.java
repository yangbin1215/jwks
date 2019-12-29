package com.yb.service;

import com.yb.mapper.AuthorityMapper;
import com.yb.mapper.BookMapper;
import com.yb.mapper.OrderMapper;
import com.yb.mapper.UserMapper;
import com.yb.pojo.Book;
import com.yb.pojo.Order;
import com.yb.pojo.UOB;
import com.yb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:24
 */


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AuthorityMapper authorityMapper;

    public User queryUserByUname(String uname) {
        return userMapper.queryUserByUname(uname);
    }

    public List<UOB> getUOBListByUname(String uname) {
        return userMapper.getUOBListByUname(uname);
    }

    public List<UOB> getUOBList() {
        return userMapper.getUOBList();
    }

    public int updatePwd(int uid, String pwd) {
        return userMapper.updatePwd(uid, pwd);
    }

    public boolean buyBook(int bid, int uid) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Book book = bookMapper.getBookByBid(bid);
        if (book.getBnum() <= 0) {
            return false;
        }
        book.setBnum(book.getBnum() - 1);
        bookMapper.updateBookInfo(book);
        if (orderMapper.addOrder(new Order(now, uid, book.getBid())) == 0) {
            return false;
        }
        return true;
    }

    public boolean addUser(User user) {
        int i = userMapper.addUser(user);
        User user1 = userMapper.queryUserByUname(user.getUname());
        int n = authorityMapper.addAuthority(user1.getUid());
        if (i > 0 && n > 0) {
            return true;
        }
        return false;
    }

}
