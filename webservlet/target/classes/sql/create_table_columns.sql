CREATE table if not exists columns(
columnid int primary key not null auto_increment,
columnname varchar(50) not null,
orderid int not null default 0,
indexshow boolean not null default 0,
isenable boolean not null default 1,
isdel boolean not null default 0,
createdate date not null
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;