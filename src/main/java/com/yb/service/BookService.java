package com.yb.service;

import com.yb.mapper.BookMapper;
import com.yb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:24
 */

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    public boolean updateBookInfo(Book book) {
        if (bookMapper.updateBookInfo(book) > 0) {
            return true;
        }
        return false;
    }
}
