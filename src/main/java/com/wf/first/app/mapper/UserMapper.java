package com.wf.first.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wf.first.app.dto.UserQueryDTO;
import com.wf.first.app.pojo.User;
import com.wf.first.app.vo.UserVO;

import java.util.List;


//@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<UserVO> listUser(UserQueryDTO queryDTO);
}
