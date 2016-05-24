create table IF NOT EXISTS  admin
(id int primary key not null auto_increment,
username varchar(20) not null,
password varchar(50) not null,
level int not null,
enable boolean not null,
isdel boolean not null,
createdate date not null
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci; 