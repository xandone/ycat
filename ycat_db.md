-- User��
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

--joke��
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

--joke���ޱ�
create table y_joke_like(
id int(11) unsigned not null auto_increment,
joke_id varchar(18) not null,
joke_user_id varchar(18),
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--joke���۱�
create table y_joke_comment(
id int(11) unsigned not null auto_increment,
comment_id varchar(18) not null,
joke_id varchar(18),
comment_user_id varchar(18),
comment_details mediumtext,
comment_date datetime DEFAULT NULL,
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--ͼƬ
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