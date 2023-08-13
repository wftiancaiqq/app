package com.wf.first.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wf.first.app.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UserDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("roleState")
    private Boolean roleState;
    @JsonProperty("default")
    private Boolean defaultX;
    @JsonProperty("region")
    private String region;
    @JsonProperty("roleId")
    private Integer roleId;
    @JsonProperty("role")
    private RoleDTO role;

    @NoArgsConstructor
    @Data
    public static class RoleDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("roleName")
        private String roleName;
        @JsonProperty("roleType")
        private Integer roleType;
        @JsonProperty("rights")
        private List<String> rights;
    }

}
