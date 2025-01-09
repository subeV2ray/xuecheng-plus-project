package com.xuecheng.content.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;

/**
 * @program: xuecheng-plus-project
 * @description: 课程基本信息service接口
 * @author: ペイン
 * @create: 2025-01-09 13:37
 **/
public interface CourseBaseInfoService {
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);
}
