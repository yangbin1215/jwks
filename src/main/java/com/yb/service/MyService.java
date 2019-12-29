package com.yb.service;

import com.yb.mapper.AuthorityMapper;
import com.yb.mapper.UserMapper;
import com.yb.pojo.Authority;
import com.yb.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:48
 */

@Service
public class MyService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthorityMapper authorityMapper;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.queryUserByUname(username);
        if (user != null) {
            Authority authority = authorityMapper.queryAuthorityByUid(user.getUid());
            user.setRole(authority);

            //密码加密
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(user.getPassword());
            user.setUpwd(password);
            return user;
        } else {
            logger.error(username + "不存在");
            return null;
        }
    }

}
