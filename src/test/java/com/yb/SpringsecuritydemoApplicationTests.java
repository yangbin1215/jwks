package com.yb;

import com.yb.mapper.AuthorityMapper;
import com.yb.mapper.BookMapper;
import com.yb.mapper.OrderMapper;
import com.yb.mapper.UserMapper;
import com.yb.pojo.Authority;
import com.yb.pojo.Book;
import com.yb.pojo.Order;
import com.yb.pojo.UOB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringsecuritydemoApplicationTests {
    @Autowired
    UserMapper mapper;

    @Autowired
    AuthorityMapper authorityMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    OrderMapper orderMapper;

    @Test
    void contextLoads() {
        Authority authority = authorityMapper.queryAuthorityByUid(1);
        System.out.println(authority);
    }

    @Test
    void bookTest() {
//        List<Book> bookList = bookMapper.getBookList();
//        System.out.println(bookList);
//        Book book = new Book(1,"Java设计思想",58.5,6);
//        int i = bookMapper.updateBookInfo(book);
//        System.out.println(i);
        Book book = new Book(1,"Java程序设计基础",22,6);
        int i = bookMapper.updateBookInfo(book);
        System.out.println(i);
    }

    @Test
    void userTest() {
//        User user = mapper.queryUserByUname("孙嘉辉");
//        System.out.println(user);
//        List<UOB> uob1 = mapper.getUOBListByUname("曹学成");
//        System.out.println(uob1);
//        List<UOB> uob2 = mapper.getUOBList();
//        System.out.println(uob2);
        int i = mapper.updatePwd(1, "123");
        System.out.println(i);
    }

    @Test
    void orderTest(){
//        String now = DateFormat.getDateInstance().format(new Date());
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Order order = new Order(now,1,1);
        int i = orderMapper.addOrder(order);
        System.out.println(i);
    }
}
