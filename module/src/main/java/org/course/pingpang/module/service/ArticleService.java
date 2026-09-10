package org.course.pingpang.module.service;

import org.course.pingpang.module.entity.Article;

import java.util.List;

public interface ArticleService {

    // 查询教程列表
    List<Article> list();

    // 查询教程详情
    Article detail(Long tutorialId);

    //教程新增
    int insert(Article article);

    //教程修改
    int update(Article article);

    //教程删除
    int delete(Long tutorialId);


}