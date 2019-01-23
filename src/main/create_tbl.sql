
DROP TABLE  sys_user_info ;

CREATE TABLE sys_user_info (
    username VARCHAR (32) NOT NULL primary key,
    nickname VARCHAR (32),
    password VARCHAR (32),
    email VARCHAR (64),
    telephone  VARCHAR (16),
    ip  VARCHAR (64),
    birthday  VARCHAR (16),
    sex INT ,
    delFlag INT DEFAULT 0,
    createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    remark  VARCHAR (128) DEFAULT ""
)
