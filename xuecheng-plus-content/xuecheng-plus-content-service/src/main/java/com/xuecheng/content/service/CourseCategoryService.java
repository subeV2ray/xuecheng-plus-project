package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @program: xuecheng-plus-project
 * @description: 课程分类Service接口
 * @author: ペイン
 * @create: 2025-01-09 17:22
 **/
public interface CourseCategoryService {
    List<CourseCategoryTreeDto> treeNodes(String id);

}
