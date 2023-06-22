package com.wf.first.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wf.first.app.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
