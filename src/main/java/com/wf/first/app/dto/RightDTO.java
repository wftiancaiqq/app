package com.wf.first.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RightDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("key")
    private String key;
    @JsonProperty("pagepermisson")
    private Integer pagepermisson;
    @JsonProperty("grade")
    private Integer grade;
    @JsonProperty("children")
    private List<RightDTO> children;
}
