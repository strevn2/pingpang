package org.course.pingpang.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.course.pingpang.app.domain.ArticleDetailVO;
import org.course.pingpang.app.domain.ArticleListItemVO;
import org.course.pingpang.app.domain.ArticleListVO;
import org.course.pingpang.module.entity.Article;
import org.course.pingpang.module.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
@RestController
public class AppController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article/list")
    public ArticleListVO articleList() {
        log.info("开始查询文章列表");
        // 1. 查所有 Entity
        List<Article> articleList = articleService.list();
        log.info("文章列表查询完成，共{}条数据", articleList.size());
        // 2. 外层 VO
        ArticleListVO result = new ArticleListVO();
        List<ArticleListItemVO> list = new ArrayList<>();

        // 3. for 循环：Entity → 内层 VO
        for (Article article : articleList) {
            ArticleListItemVO item = new ArticleListItemVO();

            item.setTitle(article.getTitle());

            // coverImg：数据库是 $ 拼接的多张，列表只取第一张作为封面
            String coverImgsStr = article.getCoverImgs();
            if (coverImgsStr != null && !coverImgsStr.isEmpty()) {
                String[] imgs = coverImgsStr.split("\\$");
                item.setCoverImg(imgs[0]);  // 取第一张
            } else {
                item.setCoverImg("");
                log.warn("文章{}没有封面图片", article.getId());
            }

            // tutorialId 对应数据库 id
            item.setTutorialId(article.getId());

            list.add(item);
        }

        result.setList(list);
        log.info("文章列表返回成功");
        return result;
    }

    // ==================== 2. 教程详情 /article/detail ====================

    @RequestMapping("/article/detail")
    public ArticleDetailVO articleDetail(@RequestParam(name = "tutorialId") Long tutorialId) {
        // 1. 查 Entity
        log.info("开始查询文章详情，id={}", tutorialId);
        Article article = articleService.detail(tutorialId);
        if(article == null){

            log.warn("文章不存在，id={}", tutorialId);

            return null;

        }
        // 2. 新建 VO，get/set 赋值
        ArticleDetailVO vo = new ArticleDetailVO();

        // images：轮播图 $ 分割成数组
        String coverImgsStr = article.getCoverImgs();
        if (coverImgsStr != null && !coverImgsStr.isEmpty()) {
            vo.setImages(Arrays.asList(coverImgsStr.split("\\$")));
        } else {
            vo.setImages(new ArrayList<>());
            log.warn("文章{}没有图片", tutorialId);
        }

        vo.setTitle(article.getTitle());
        vo.setSubTitle(article.getSubTitle());
        vo.setContent(article.getContent());
        vo.setRecommend(article.getRecommend());

        // 类型转换：BigDecimal → Float
        vo.setPrice(article.getPrice().floatValue());
        log.info("文章详情查询成功，id={}", tutorialId);
        return vo;
    }
}