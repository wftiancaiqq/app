package com.wf.first.app.dto;

import com.wf.first.app.pojo.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO extends User {
    private String a;

    private List<String> accountList;
}
