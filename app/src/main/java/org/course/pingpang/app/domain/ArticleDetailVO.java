package org.course.pingpang.app.domain;

import lombok.Data;

import java.util.List;

@Data
public class ArticleDetailVO {

    private List<String> images;

    private String title;

    private String subTitle;

    private String content;

    private String recommend;

    private Float price;

}
