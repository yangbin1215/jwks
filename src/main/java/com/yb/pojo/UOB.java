package com.yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yangbin
 * @date 2019/12/20 -22:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UOB {
    private String odate;
    private int bid;
    private String bname;
    private int uid;
    private String uname;
}
