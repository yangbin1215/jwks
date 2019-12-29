package com.yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author Yangbin
 * @date 2019/12/19 -0:07
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int oid;
    private String odate;
    private int uid;
    private int bid;


    public Order(String odate,int uid, int bid){
        this.odate = odate;
        this.uid = uid;
        this.bid = bid;
    }
}
