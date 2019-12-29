package com.yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yangbin
 * @date 2019/12/19 -0:01
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bid;
    private String bname;
    private double bcost;
    private int bnum;
}
