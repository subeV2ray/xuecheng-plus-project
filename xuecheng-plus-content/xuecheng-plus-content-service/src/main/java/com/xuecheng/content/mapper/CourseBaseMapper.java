package com.xuecheng.content.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.po.CourseBase;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程基本信息 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Mapper
public interface CourseBaseMapper extends BaseMapper<CourseBase> {

    CourseBaseInfoDto createCourseBase(AddCourseDto addCourseDto);
}
