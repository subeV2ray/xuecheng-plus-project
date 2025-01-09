package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: xuecheng-plus-project
 * @description: 课程分类api
 * @author: ペイン
 * @create: 2025-01-09 18:10
 **/
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/course-category")
public class CourseCategoryController {

    private final CourseCategoryService courseCategoryService;

    /**
     * 课程分类树形结构查询
     *
     * @return
     */
    @GetMapping("/tree-nodes")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return courseCategoryService.treeNodes("1");
    }

}
