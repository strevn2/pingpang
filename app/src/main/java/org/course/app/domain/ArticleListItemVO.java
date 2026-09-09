package org.course.app.domain;

import lombok.Data;

@Data
public class ArticleListItemVO {

    private String title;       // 接口文档里的 "title": "xxx"
    private String coverImg;    // 接口文档里的 "coverImg": "xxx.jpg"
    private Long tutorialId;    // 接口文档里的 "tutorialId": 1
}