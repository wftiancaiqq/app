package com.wf.first.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wf.first.app.common.PageResult;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.dto.UserQueryDTO;
import com.wf.first.app.mapper.UserMapper;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import com.wf.first.app.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //@Resource
    @Autowired
    private UserMapper userMapper;


    @Override
    public Boolean register(User user) {
        long isExist = userMapper.selectCount(new QueryWrapper<User>().lambda().eq(User::getUserName, user.getUserName()));
        if (isExist > 0) {
            return false;
        }
        Date now = new Date();
        user.setGmtCreate(now);
        user.setGmtModified(now);
        user.setIsAdmin(0);
        int n = userMapper.insert(user);
        return n > 0;
    }

    @Override
    public PageResult<UserVO> listUser(UserQueryDTO queryDTO) {
        Integer page = queryDTO.getPage();
        Integer pageSize = queryDTO.getPageSize();;
        Page<UserDTO> pageInfo = PageHelper.startPage(page, pageSize);
        List<UserVO> userVOList = userMapper.listUser(queryDTO);
        PageResult<UserVO> pageResult = new PageResult<>();
        pageResult.setPage(queryDTO.getPage());
        pageResult.setPageSize(queryDTO.getPageSize());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(userVOList);
        return pageResult;
    }
}
