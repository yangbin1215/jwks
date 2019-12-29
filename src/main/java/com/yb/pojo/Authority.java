package com.yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Yangbin
 * @date 2019/12/19 -0:05
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int aid;
    private String ast;
    private int uid;
}
