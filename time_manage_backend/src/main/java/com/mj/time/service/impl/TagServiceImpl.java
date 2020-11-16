package com.mj.time.service.impl;

import com.mj.time.domain.Tag;
import com.mj.time.mapper.TagMapper;
import com.mj.time.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TagServiceImpl implements TagService
{
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectUserTagList(Integer userId) {
        List<Tag> tagListAdmin = tagMapper.selectByUserId(1);
        List<Tag> tagList = tagMapper.selectByUserId(userId);
        tagList.addAll(tagListAdmin);
        return tagList;
    }
}
