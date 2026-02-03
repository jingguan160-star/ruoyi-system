-- ----------------------------
-- PDA/钥匙管理、PDA/钥匙用户管理 表结构
-- 执行前请确认数据库已选择（如 ruoyi）。若表已存在可跳过。
-- ----------------------------

-- PDA/钥匙管理表
DROP TABLE IF EXISTS pda_key;
CREATE TABLE pda_key (
    id              bigint(20)      NOT NULL AUTO_INCREMENT    COMMENT '主键',
    `key`           varchar(100)    DEFAULT ''                 COMMENT 'KEY值',
    type            varchar(20)    DEFAULT ''                 COMMENT '类型（钥匙/PDA）',
    description     varchar(500)    DEFAULT ''                 COMMENT '描述',
    company         varchar(100)    DEFAULT ''                 COMMENT '所属公司',
    create_by       varchar(64)    DEFAULT ''                 COMMENT '创建者',
    create_time     datetime                                   COMMENT '创建时间',
    update_by       varchar(64)    DEFAULT ''                 COMMENT '更新者',
    update_time     datetime                                   COMMENT '更新时间',
    remark          varchar(500)    DEFAULT NULL                COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='PDA/钥匙管理表';

-- PDA/钥匙用户关联表
DROP TABLE IF EXISTS pda_key_user;
CREATE TABLE pda_key_user (
    id              bigint(20)      NOT NULL AUTO_INCREMENT    COMMENT '主键',
    key_id          bigint(20)      DEFAULT NULL               COMMENT '关联的PDA/钥匙ID',
    user_id         bigint(20)      DEFAULT NULL               COMMENT '关联的用户ID',
    user_name       varchar(64)    DEFAULT ''                 COMMENT '用户名（冗余）',
    create_by       varchar(64)    DEFAULT ''                 COMMENT '创建者',
    create_time     datetime                                   COMMENT '创建时间',
    update_by       varchar(64)    DEFAULT ''                 COMMENT '更新者',
    update_time     datetime                                   COMMENT '更新时间',
    remark          varchar(500)    DEFAULT NULL                COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='PDA/钥匙用户关联表';
