package com.yb.mapper;

import com.yb.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -15:56
 */

@Mapper
@Repository
public interface BookMapper {
    List<Book> getBookList();
    Book getBookByBid(int bid);
    int updateBookInfo(Book book);
}
