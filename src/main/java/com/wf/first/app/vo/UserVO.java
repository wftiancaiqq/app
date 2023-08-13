package com.wf.first.app.vo;

import com.wf.first.app.pojo.User;
import lombok.Data;

@Data
public class UserVO extends User {
    private String region;
    private String roleName;
}
