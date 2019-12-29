package com.yb.mapper;

import com.yb.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:00
 */

@Mapper
@Repository
public interface OrderMapper {
    int addOrder(Order order);
}
