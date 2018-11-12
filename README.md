### JaveWeb小项目
基于SSM架构，包含后台管理和移动端接口<br/>
戳这里[Android端项目](https://github.com/xandone/yCatApp)


## TO-DO

- [x] 帖子增删改查
- [x] 点赞、回帖
- [x] 图片管理
- [ ] 视频管理
- [ ] 用户信息维护
- [ ] 其他

### 项目部署
#### 版本
**tomcat**   9.0.0 <br/>
**maven**    3.5.0 <br/>
**jdk**      1.8.0 <br/>
**mysql**    5.7.19 <br/>
**spring**   4.1.3 <br/>
**mybatis**  3.2.8 <br/>
**os**       CentOs 6.5 <br/>
**nginx**    1.12.2 <br/>

#### db
```
-- User表
create table y_user(
id int(11) unsigned not null auto_increment,
name varchar(20) not null unique,
password varchar(20) not null,
nickname varchar(20) not null,
user_id varchar(18) DEFAULT NULL,
user_icon varchar(100) DEFAULT NULL,
token varchar(50),
rtime TIMESTAMP,
primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--joke表
create table y_joke(
id int(11) unsigned not null auto_increment,
joke_id varchar(18) not null,
joke_user_id varchar(18) not null,
title varchar(100) not null,
content mediumtext,
post_time datetime DEFAULT NULL,
article_like_count int(5) DEFAULT '0',
article_comment_count int(5) DEFAULT '0',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--joke点赞表
create table y_joke_like(
id int(11) unsigned not null auto_increment,
joke_id varchar(18) not null,
joke_user_id varchar(18),
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--joke评论表
create table y_joke_comment(
id int(11) unsigned not null auto_increment,
comment_id varchar(18) not null,
joke_id varchar(18),
comment_user_id varchar(18),
comment_details mediumtext,
comment_date datetime DEFAULT NULL,
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--图片
create table y_image(
id int(11) unsigned not null auto_increment,
userId varchar(18) not null,
imgId varchar(18),
imgUrl varchar(100),
pageViews int(6),
size_type int(1),
upTime datetime DEFAULT NULL,
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

```