package com.yb.mapper;

import com.yb.pojo.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Yangbin
 * @date 2019/12/19 -15:59
 */

@Mapper
@Repository
public interface AuthorityMapper {
    public Authority queryAuthorityByUid(int uid);
    public int addAuthority(int uid);
}
