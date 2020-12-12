package com.mj.time.controller;

import com.mj.time.common.CommonResponse;
import com.mj.time.controller.base.BaseController;
import com.mj.time.domain.Tag;
import com.mj.time.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time/tag")
public class TagController extends BaseController {
    @Autowired
    private TagService tagService;

    @GetMapping
    CommonResponse<List<Tag>> getAllMenu() {
        List<Tag> tagList = tagService.selectUserTagList(this.userId);
        return new CommonResponse<List<Tag>>(tagList);
    }
}
