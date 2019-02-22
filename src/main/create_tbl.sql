
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




/*==============================================================*/
/* Table: vedio_info                                             */
/*==============================================================*/

drop table vedio_info;

create table vedio_info
(
    vedio_id             bigint                         not null primary key auto_increment,
    vedio_url            varchar(500)                   not null,
    vedio_title          varchar(128)                    null,
    vedio_desc           text                           null,
    vedio_status         smallint                       null,
    vedio_type           smallint                       null,
    author_id            int                            null,
    author_idea          text                           null,
    main_image           varchar(500)                   null,
    create_time          datetime                       null,
    update_time          datetime                       null,
    user_good_thumbs     int                            default 0
);

/*==============================================================*/
/* Index: authorId                                              */
/*==============================================================*/
create index authorId on vedio_info (
    author_id ASC
);