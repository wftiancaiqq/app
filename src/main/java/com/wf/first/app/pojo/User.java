package com.wf.first.app.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private String avatarUrl;

    private Date gmtCreate;

    private Date gmtModified;

    private Long creator;

    private Long modifier;

    private Long roleId;

    private Integer isAdmin;

    private Long regionId;
}
