package org.course.pingpang.console.controller;

import lombok.extern.slf4j.Slf4j;
import org.course.pingpang.module.entity.Article;
import org.course.pingpang.module.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@Slf4j
public class ConsoleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/create")
    public String articleCreate(
            @RequestParam String images,
            @RequestParam String title,
            @RequestParam String subTitle,
            @RequestParam String content,
            @RequestParam String recommend,
            @RequestParam Float price) {

        log.info("开始创建文章，标题={}", title);
        Article article = new Article();

        // 接口参数 images → 实体字段 coverImgs
        article.setCoverImgs(images);
        article.setTitle(title);
        article.setSubTitle(subTitle);
        article.setContent(content);
        article.setRecommend(recommend);
        article.setPrice(BigDecimal.valueOf(price));
        int result = articleService.insert(article);
        if (result == 1) {

            log.info("文章创建成功，标题={}", title);

            return "成功";

        } else {

            log.warn("文章创建失败，标题={}", title);

            return "失败";

        }
    }

    @RequestMapping("/article/update")
    public String articleUpdate(
            @RequestParam(name = "tutorialId") Long tutorialId,
            @RequestParam(name = "images") String images,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "subTitle") String subTitle,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "recommend") String recommend,
            @RequestParam(name = "price") Float price) {
        log.info("开始修改文章，id={}", tutorialId);
        Article article = new Article();

        // tutorialId 是接口参数名；数据库实体字段名是 id
        article.setId(tutorialId);

        // images 是接口参数名；实体字段名是 coverImgs
        article.setCoverImgs(images);

        article.setTitle(title);
        article.setSubTitle(subTitle);
        article.setContent(content);
        article.setRecommend(recommend);
        article.setPrice(BigDecimal.valueOf(price));

        int result = articleService.update(article);
        if (result == 1) {

            log.info("文章修改成功，id={}", tutorialId);

            return "成功";

        } else {

            log.warn("文章修改失败，id={}", tutorialId);

            return "失败";

        }

    }

    @RequestMapping("/article/delete")
    public String articleDelete(
            @RequestParam(name = "tutorialId") Long tutorialId) {

        int result = articleService.delete(tutorialId);
        if (result == 1) {
            log.info("文章删除成功,id={}", tutorialId);
            return "成功";
        } else {

            log.warn("文章删除失败，,id={}", tutorialId);
            return "失败";
        }

    }


}
