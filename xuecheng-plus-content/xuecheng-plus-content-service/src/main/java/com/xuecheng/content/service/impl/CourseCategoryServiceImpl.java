package com.xuecheng.content.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: xuecheng-plus-project
 * @description: 课程分类service业务实现
 * @author: ペイン
 * @create: 2025-01-09 17:23
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseCategoryServiceImpl implements CourseCategoryService {

    private final CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> treeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtoList = courseCategoryMapper.selectTreeNodes(id);
        Map<String, CourseCategoryTreeDto> map = courseCategoryTreeDtoList.stream().filter(item -> !StrUtil.equals(id, item.getId())).collect(Collectors.toMap(CourseCategoryTreeDto::getId, value -> value, (key1, key2) -> key1));

        List<CourseCategoryTreeDto> courseCategoryTreeDtos = new ArrayList<>();

        courseCategoryTreeDtoList.stream()
                .filter(item -> !StrUtil.equals(id, item.getId()))
                .forEach(courseCategoryTreeDto -> {
                    if (StrUtil.equals(courseCategoryTreeDto.getParentid(), id)) {
                        courseCategoryTreeDtos.add(courseCategoryTreeDto);
                    }

                    CourseCategoryTreeDto courseCategoryTreeDto1 = map.get(courseCategoryTreeDto.getParentid());

                    if (ObjectUtil.isNotNull(courseCategoryTreeDto1)) {
                        if (ObjectUtil.isNull(courseCategoryTreeDto1.getChildrenTreeNodes())) {
                            courseCategoryTreeDto1.setChildrenTreeNodes(new ArrayList<>());
                        }

                        courseCategoryTreeDto1.getChildrenTreeNodes().add(courseCategoryTreeDto);
                    }



                });

        return courseCategoryTreeDtos;
    }
}
