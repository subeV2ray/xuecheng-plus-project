package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.CourseCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @program: xuecheng-plus-project
 * @description:
 * @author: ペイン
 * @create: 2025-01-09 17:08
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {
    private List<CourseCategory> childrenTreeNodes;
}
