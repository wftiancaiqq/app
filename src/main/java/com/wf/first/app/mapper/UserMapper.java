package com.wf.first.app.mapper;

import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//@Mapper
public interface UserMapper {
    User selectByUserId(Long id);

    User selectBySelective(UserDTO userDTO);

    List<User> selectList(UserDTO userDTO);

    List<User> selectListByList(UserDTO dto);
}
