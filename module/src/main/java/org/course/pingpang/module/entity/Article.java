package org.course.pingpang.module.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Article {

    private Long id;

    private String coverImgs;

    private String title;

    private String subTitle;

    private String content;

    private String recommend;

    private BigDecimal price;

    private Integer createTime;

    private Integer updateTime;

    private Integer isDeleted;

}