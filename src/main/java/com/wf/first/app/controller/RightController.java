package com.wf.first.app.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.dto.RightDTO;
import com.wf.first.app.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/right")
@AllArgsConstructor
public class RightController {

    @PostMapping("/getMenu")
    public BaseResult<String> getMenu(HttpServletRequest request) {
        return BaseResult.success("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"首页\",\n" +
                "    \"key\": \"/home\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"用户管理\",\n" +
                "    \"key\": \"/user-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"title\": \"添加用户\",\n" +
                "        \"rightId\": 2,\n" +
                "        \"key\": \"/user-manage/add\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 4,\n" +
                "        \"title\": \"删除用户\",\n" +
                "        \"rightId\": 2,\n" +
                "        \"key\": \"/user-manage/delete\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 5,\n" +
                "        \"title\": \"修改用户\",\n" +
                "        \"rightId\": 2,\n" +
                "        \"key\": \"/user-manage/update\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 6,\n" +
                "        \"title\": \"用户列表\",\n" +
                "        \"rightId\": 2,\n" +
                "        \"key\": \"/user-manage/list\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7,\n" +
                "    \"title\": \"权限管理\",\n" +
                "    \"key\": \"/right-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"id\": 8,\n" +
                "        \"title\": \"角色列表\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/role/list\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 9,\n" +
                "        \"title\": \"权限列表\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/right/list\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 10,\n" +
                "        \"title\": \"修改角色\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/role/update\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 11,\n" +
                "        \"title\": \"删除角色\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/role/delete\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 12,\n" +
                "        \"title\": \"修改权限\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/right/update\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 13,\n" +
                "        \"title\": \"删除权限\",\n" +
                "        \"rightId\": 7,\n" +
                "        \"key\": \"/right-manage/right/delete\",\n" +
                "        \"grade\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 14,\n" +
                "    \"title\": \"新闻管理\",\n" +
                "    \"key\": \"/news-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"id\": 15,\n" +
                "        \"title\": \"新闻列表\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/list\",\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 16,\n" +
                "        \"title\": \"撰写新闻\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/add\",\n" +
                "        \"grade\": 2,\n" +
                "        \"pagepermisson\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 17,\n" +
                "        \"title\": \"新闻更新\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/update/:id\",\n" +
                "        \"grade\": 2,\n" +
                "        \"routepermisson\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 18,\n" +
                "        \"title\": \"新闻预览\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/preview/:id\",\n" +
                "        \"grade\": 2,\n" +
                "        \"routepermisson\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 19,\n" +
                "        \"title\": \"草稿箱\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/draft\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 20,\n" +
                "        \"title\": \"新闻分类\",\n" +
                "        \"rightId\": 14,\n" +
                "        \"key\": \"/news-manage/category\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 21,\n" +
                "    \"title\": \"审核管理\",\n" +
                "    \"key\": \"/audit-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"id\": 22,\n" +
                "        \"title\": \"审核新闻\",\n" +
                "        \"rightId\": 21,\n" +
                "        \"key\": \"/audit-manage/audit\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 23,\n" +
                "        \"title\": \"审核列表\",\n" +
                "        \"rightId\": 21,\n" +
                "        \"key\": \"/audit-manage/list\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 24,\n" +
                "    \"title\": \"发布管理\",\n" +
                "    \"key\": \"/publish-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1,\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"id\": 25,\n" +
                "        \"title\": \"待发布\",\n" +
                "        \"rightId\": 24,\n" +
                "        \"key\": \"/publish-manage/unpublished\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 26,\n" +
                "        \"title\": \"已发布\",\n" +
                "        \"rightId\": 24,\n" +
                "        \"key\": \"/publish-manage/published\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 27,\n" +
                "        \"title\": \"已下线\",\n" +
                "        \"rightId\": 24,\n" +
                "        \"key\": \"/publish-manage/sunset\",\n" +
                "        \"pagepermisson\": 1,\n" +
                "        \"grade\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");
    }

    @PostMapping("/getRights")
    public BaseResult<List<RightDTO>> getRights(HttpServletRequest request) {
        List<RightDTO> rightDTOList = JSONArray.parseArray("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"首页\",\n" +
                "    \"key\": \"/home\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"用户管理\",\n" +
                "    \"key\": \"/user-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7,\n" +
                "    \"title\": \"权限管理\",\n" +
                "    \"key\": \"/right-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 14,\n" +
                "    \"title\": \"新闻管理\",\n" +
                "    \"key\": \"/news-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 21,\n" +
                "    \"title\": \"审核管理\",\n" +
                "    \"key\": \"/audit-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 24,\n" +
                "    \"title\": \"发布管理\",\n" +
                "    \"key\": \"/publish-manage\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 1\n" +
                "  }\n" +
                "]", RightDTO.class);
        return BaseResult.success(rightDTOList);
    }
    @PostMapping("/getRightsChildren")
    public BaseResult<List<RightDTO>> getRightsChildren(HttpServletRequest request) {
        List<RightDTO> rightDTOList = JSONArray.parseArray("[\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"添加用户\",\n" +
                "    \"rightId\": 2,\n" +
                "    \"key\": \"/user-manage/add\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"title\": \"删除用户\",\n" +
                "    \"rightId\": 2,\n" +
                "    \"key\": \"/user-manage/delete\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"title\": \"修改用户\",\n" +
                "    \"rightId\": 2,\n" +
                "    \"key\": \"/user-manage/update\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"title\": \"用户列表\",\n" +
                "    \"rightId\": 2,\n" +
                "    \"key\": \"/user-manage/list\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 8,\n" +
                "    \"title\": \"角色列表\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/role/list\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 9,\n" +
                "    \"title\": \"权限列表\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/right/list\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10,\n" +
                "    \"title\": \"修改角色\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/role/update\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 11,\n" +
                "    \"title\": \"删除角色\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/role/delete\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 12,\n" +
                "    \"title\": \"修改权限\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/right/update\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 13,\n" +
                "    \"title\": \"删除权限\",\n" +
                "    \"rightId\": 7,\n" +
                "    \"key\": \"/right-manage/right/delete\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 15,\n" +
                "    \"title\": \"新闻列表\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/list\",\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 16,\n" +
                "    \"title\": \"撰写新闻\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/add\",\n" +
                "    \"grade\": 2,\n" +
                "    \"pagepermisson\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 17,\n" +
                "    \"title\": \"新闻更新\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/update/:id\",\n" +
                "    \"grade\": 2,\n" +
                "    \"routepermisson\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 18,\n" +
                "    \"title\": \"新闻预览\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/preview/:id\",\n" +
                "    \"grade\": 2,\n" +
                "    \"routepermisson\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 19,\n" +
                "    \"title\": \"草稿箱\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/draft\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 20,\n" +
                "    \"title\": \"新闻分类\",\n" +
                "    \"rightId\": 14,\n" +
                "    \"key\": \"/news-manage/category\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 22,\n" +
                "    \"title\": \"审核新闻\",\n" +
                "    \"rightId\": 21,\n" +
                "    \"key\": \"/audit-manage/audit\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 23,\n" +
                "    \"title\": \"审核列表\",\n" +
                "    \"rightId\": 21,\n" +
                "    \"key\": \"/audit-manage/list\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 25,\n" +
                "    \"title\": \"待发布\",\n" +
                "    \"rightId\": 24,\n" +
                "    \"key\": \"/publish-manage/unpublished\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 26,\n" +
                "    \"title\": \"已发布\",\n" +
                "    \"rightId\": 24,\n" +
                "    \"key\": \"/publish-manage/published\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 27,\n" +
                "    \"title\": \"已下线\",\n" +
                "    \"rightId\": 24,\n" +
                "    \"key\": \"/publish-manage/sunset\",\n" +
                "    \"pagepermisson\": 1,\n" +
                "    \"grade\": 2\n" +
                "  }\n" +
                "]", RightDTO.class);
        return  BaseResult.success(rightDTOList);

    }
}
