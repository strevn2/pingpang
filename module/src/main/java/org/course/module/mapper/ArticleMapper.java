package org.course.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.course.module.entity.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 查询教程列表
    List<Article> list();

    // 查询教程详情
    Article detail(@Param("tutorialId") Long tutorialId);

    //教程新增
    int insert(Article article);

    //教程修改
    int update(Article article);

    //教程删除
    int delete(@Param("tutorialId")Long tutorialId);
}