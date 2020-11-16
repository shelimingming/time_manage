package com.mj.time.service;

import com.mj.time.domain.Tag;

import java.util.List;

public interface TagService {
    List<Tag> selectUserTagList(Integer userId);
}
