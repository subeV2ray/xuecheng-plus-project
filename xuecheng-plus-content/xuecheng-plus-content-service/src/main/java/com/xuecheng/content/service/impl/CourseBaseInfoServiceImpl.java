package com.xuecheng.content.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xuecheng-plus-project
 * @description: 课程基本信息Service实现
 * @author: ペイン
 * @create: 2025-01-09 13:40
 **/
@Service
@RequiredArgsConstructor
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    private final CourseBaseMapper courseBaseMapper;

    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {

        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotEmpty(queryCourseParamsDto.getCourseName()), CourseBase::getName, queryCourseParamsDto.getCourseName());
        //根据课程审核状态
        queryWrapper.eq(StrUtil.isNotEmpty(queryCourseParamsDto.getAuditStatus()), CourseBase::getAuditStatus, queryCourseParamsDto.getAuditStatus());

        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, queryWrapper);

        List<CourseBase> records = pageResult.getRecords();
        long total = pageResult.getTotal();


        return new PageResult<>(records, total, pageParams.getPageNo(), pageParams.getPageSize());
    }
}
