package com.wf.first.app.dto;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;

@Data
public class UserQueryDTO {
    private Integer page;
    private Integer pageSize;

    private Long regionId;
    private String roleName;
    private String userName;
    private Integer isDeleted;
}
