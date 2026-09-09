package org.course.module.service.impl;

import org.course.module.entity.Article;
import org.course.module.mapper.ArticleMapper;
import org.course.module.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> list() {
        return articleMapper.list();
    }

    @Override
    public Article detail(Long tutorialId) {
        return articleMapper.detail(tutorialId);
    }

    @Override
    public int insert(Article article) {
        return  articleMapper.insert(article);
    }

    @Override
    public int update(Article article) {
       return articleMapper.update(article);
    }

    @Override
    public int delete(Long tutorialId) {
       return articleMapper.delete(tutorialId);
    }


}