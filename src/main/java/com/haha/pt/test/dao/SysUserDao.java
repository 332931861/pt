package com.haha.pt.test.dao;

import com.haha.pt.test.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserDao {
    List<SysUser> queryAll();

}
