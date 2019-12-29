package com.yb.mapper;

import com.yb.pojo.UOB;
import com.yb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -15:25
 */


@Mapper
@Repository
public interface UserMapper {
    User queryUserByUname(String uname);
    List<UOB> getUOBListByUname(String uname);
    List<UOB> getUOBList();
    int updatePwd(int uid, String pwd);
    int addUser(User user);
}
