package org.course.pingpang.app.domain;

import lombok.Data;

import java.util.List;           // 引入 List，因为下面要用

@Data
public class ArticleListVO {     // 定义一个类，名字和接口文档对应

    private List<ArticleListItemVO> list;   // 【核心】接口文档里的 "list": [ ... ]


}