# 乒乓学堂APP

baseUrl: http://localhost:8080

### **1、教程列表**

/article/list

参数：

返回：

```json
{
    list:[
        {
            title:[String],
            coverImg:[String],
            tutorialId:[Long]
        }
     ]
}
```

### 2、教程详情

/article/detail

参数：

tutorialId:[Long]

返回：

```json
{   
    images:[String[]]
    title:[String]
    subTitle:[String]
    content:[String]
    recommend:[String]
    price:[Float]    
}
```

# 乒乓学堂CONSOLE

baseUrl: http://localhost:8081

### 1、教程新增

/article/create

参数：

images:[String]
title:[String]
subTitle:[String]
content:[String]
recommend:[String]
price:[Float]

返回：

成功 or 失败

### 2、教程修改

/article/update

参数：

tutorialId:[Long]
images:[String]
title:[String]
subTitle:[String]
content:[String]
recommend:[String]
price:[Float]

返回：

成功 or 失败

### 3、教程删除

/article/delete

参数：

tutorialId:[Long]

返回：

成功 or 失败

# 数据库设计

```sql
CREATE TABLE article(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `coverImgs` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '轮播图，$拼接',                                        
    `title` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',                                                                                              
    `sub_title` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '副标题',
    `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '内容',
    `recommend` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '推荐器材',
    `price` DECIMAL(10,2) unsigned NOT NULL  COMMENT '价格',
    `create_time` int unsigned NOT NULL,
    `update_time` int unsigned NOT NULL,
    `is_deleted` tinyint unsigned NOT NULL DEFAULT '0',
     PRIMARY KEY (`id`),
     INDEX `idx_title` (`title`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='教程表'
```
