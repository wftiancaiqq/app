package com.wf.first.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User {

    @TableId(value = "id", type= IdType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String email;
}
