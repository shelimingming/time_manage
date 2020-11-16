package com.mj.time.controller;

import com.mj.time.common.CommonResponse;
import com.mj.time.domain.Tag;
import com.mj.time.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time/tag")
public class TagController {
    @Autowired
    private TagService tagService;


    @GetMapping("/user/{userId}")
    CommonResponse<List<Tag>> getAllMenu(@PathVariable("userId") Integer userId) {
        List<Tag> tagList = tagService.selectUserTagList(userId);
        return new CommonResponse<List<Tag>>(tagList);
    }
}
