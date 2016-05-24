create table if not exists article(
articleid int primary key not null auto_increment,
title varchar(200) not null,
content text not null,
userid int not null,
columnid int not null,
isdel boolean not null default 0,
createdate date not null
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;