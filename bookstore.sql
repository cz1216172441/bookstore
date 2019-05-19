--
-- bookstore.sql
-- create by noTalent
-- 2019.04.18
--
create database
  if not exists bookstore;
use bookstore;

--
-- Manager Module
-- 管理员模块
--

-- manager 管理员
create table if not exists manager (
  manager_id int(11) not null auto_increment comment '管理员id',
  username varchar(32) not null default '' comment '用户名',
  password varchar(64) not null default '' comment '密码',
  salt varchar(64) not null default '' comment '加密盐值',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp
    on update current_timestamp comment '更新时间',
  primary key (manager_id),
  unique key (username)
);

insert into manager (username, password, salt) values ('admin', 'a0ff9c6ae7c2021e940a6d3f93a9dac8', 'c5afb53a7a774cb48f9e4a3b448ce1be');
insert into manager (username, password, salt) values ('visitor', '986287d78c6e991e2bff66c09418536c', '5184a68e8e674d1581ac7d24777f0e28');

-- permission 权限
create table if not exists permission (
  permission_id int(11) not null auto_increment comment '权限id',
  permission_name varchar(32) not null default '' comment '权限名',
  permission_url varchar(32) not null default '' comment '权限路径',
  create_time timestamp not null default current_timestamp comment '创建时间',
  primary key (permission_id),
  unique key (permission_name)
);

# 总权限
insert into permission (permission_name) values ('total');
#

-- role 角色
create table if not exists role (
  role_id int(11) not null auto_increment comment '角色id',
  role_name varchar(32) not null default '' comment '角色名',
  create_time timestamp not null default current_timestamp comment '创建时间',
  primary key (role_id),
  unique key (role_name)
);

insert into role (role_name) values ('admin');
insert into role (role_name) values ("visit");

-- role_permission 角色权限
create table if not exists role_permission (
  role_permission_id int(11) not null auto_increment comment '角色权限id',
  role_id int(11) not null,
  permission_id int(11) not null,
  create_time timestamp not null default current_timestamp comment '创建时间',
  primary key (role_permission_id),
  key idx_role_id (role_id),
  key idx_perm_id (permission_id)
);

-- manager_role 管理员角色
create table if not exists manager_role (
  manager_role_id int(11) not null auto_increment comment '管理员角色id',
  manager_id int(11) not null,
  role_id int(11) not null,
  create_time timestamp not null default current_timestamp comment '创建时间',
  primary key (manager_role_id),
  key idx_manger_id (manager_id),
  key idx_role_id (role_id)
);

--
-- Book Module
-- 图书模块
--

-- book_info 图书信息
create table if not exists book_info (
    book_info_id int(11) not null auto_increment comment '图书信息id',
    category_id int(11) not null comment '图书分类id',
    book_info_img varchar(500) not null default '' comment '图书封面',
    book_name varchar(64) not null default '' comment '图书名称',
    book_author varchar(64) not null default '' comment '图书作者',
    book_actual_price decimal(6, 2) not null default 0 comment '图书价格',
    book_original_price decimal(6, 2) not null default 0 comment '原价',
    book_status tinyint(1) not null default 1 comment '图书状态：0下架 1上架',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (book_info_id),
    key idx_book_name (book_name),
    key idx_book_author (book_author)
);

-- book_detail 图书详情信息
create table if not exists book_detail (
    book_detail_id int(11) not null auto_increment comment '图书详情id',
    book_info_id int(11) not null comment '图书信息id',
    book_intro varchar(255) not null default '' comment '图书简介',
    publishing_house varchar(64) not null default '' comment '出版社',
    publishing_time date not null comment '出版时间',
    book_isbn varchar(32) not null default '' comment 'ISBN',
    book_detail_img varchar(500) not null default '' comment '图书详情图片',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (book_detail_id),
    key idx_book_info_id_1 (book_info_id)
);

-- book_category 图书分类
create table if not exists book_category (
    category_id int(11) not null auto_increment comment '图书分类id',
    super_category_id int(11) not null comment '父级图书分类id',
    category_name varchar(16) not null default '' comment '分类名称',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (category_id),
    key idx_category_name (category_name)
);

-- book_sku 图书库存
create table if not exists book_sku (
    book_sku_id int(11) not null auto_increment comment '图书库存id',
    book_info_id int(11) not null comment '图书信息id',
    book_stock int(11) not null default 0 comment '图书库存',
    book_sku_property varchar(16) not null default '' comment '库存属性',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (book_sku_id),
    key idx_book_info_id_2 (book_info_id)
);

--
-- UserInfo Module
-- 用户模块
--

-- user_info 用户信息
create table if not exists user_info (
    user_info_id int(11) not null auto_increment comment '用户信息id',
    username varchar(32) not null default '' comment '用户名',
    salt varchar(64) not null default '' comment '盐值',
    password varchar(64) not null default '' comment '密码',
    user_phone varchar(11) comment '手机号码',
    user_email varchar(32) comment '电子邮箱',
    user_status tinyint(1) not null default 1 comment '用户状态：0禁止 1正在使用',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (user_info_id),
    unique key (username),
    unique key (user_phone),
    unique key (user_email)
);

-- user_detail 用户详情
create table if not exists user_detail (
    user_detail_id int(11) not null auto_increment comment '用户详情id',
    user_info_id int(11) not null comment '用户信息id',
    user_img varchar(128) not null default '' comment '用户头像',
    user_nickname varchar(16) not null default '' comment '用户昵称',
    user_gender char(1) not null default '' comment '用户性别',
    user_birthday date comment '用户生日',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (user_detail_id),
    unique key (user_info_id)
);

--  receiver_address 收货地址
create table if not exists receiver_address (
    receiver_address_id int(11) not null auto_increment comment '收货地址id',
    user_info_id int(11) not null comment '用户信息id',
    receiver_name varchar(16) not null default '' comment '收货人姓名',
    receiver_phone varchar(11) not null default '' comment '收货人手机号码',
    postal_code varchar(6) not null default '' comment '邮政编码',
    area_id int(11) not null comment '地区id',
    address_detail varchar(64) not null default '' comment '详情地址',
    address_status tinyint(1) not null default 0 comment '地址状态：0 非默认地址， 1 默认地址',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (receiver_address_id),
    key idx_user_info_id_1 (user_info_id)
);

-- area 地区
create table if not exists area (
    area_id int(11) not null comment '地区id',
    area_name varchar(15) not null default '' comment '地区名',
    super_area_id int(11) not null default 0 comment '父级地区id',
    primary key (area_id),
    key idx_super_area_id (super_area_id),
    key idx_area_name (area_name)
);

--
-- Order Module
-- 订单模块
--

-- order_info 订单信息表
create table if not exists order_info (
    order_info_id varchar(18) not null comment '订单信息id',
    user_info_id int(11) not null comment '用户信息id',
    receiver_address_id int(11) not null comment '收货地址id',
    payment_mode varchar(16) not null default '' comment '支付方式：微信支付，支付宝支付',
    payment_order varchar(32) not null default '' comment '支付单号',
    payment_time timestamp comment '付款时间',
    deliver_time timestamp comment '发货时间',
    finish_time timestamp comment '成交时间',
    order_status tinyint(1) not null default 0 comment '订单状态：0未付款 1未发货 2已发货 3已成交',
    create_time timestamp not null default current_timestamp comment '创建时间',
    primary key (order_info_id),
    key idx_user_info_id_2 (user_info_id)
);

-- order_info 订单详情表
create table if not exists order_detail (
    order_detail_id int(11) not null auto_increment comment '订单详情id',
    order_info_id varchar(18) not null comment '订单信息id',
    book_info_id int(11) not null comment '图书信息id',
    purchase_quantity int(11) not null comment '图书数量',
    purchase_price decimal(6, 2) not null default 0 comment '单价',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (order_detail_id),
    key idx_order_info_id (order_info_id)
);

--
-- Advertisement Module
-- 广告模块
--

-- advertisement_info 广告信息
create table if not exists advertisement_info (
    advertisement_info_id int(11) not null auto_increment comment '广告信息id',
    advertisement_info_title varchar(32) not null default '' comment '广告标题',
    advertisement_info_intro varchar(128) not null default '' comment '广告简介',
    advertisement_info_img varchar(128) not null default '' comment '广告图片',
    begin_time timestamp not null comment '开始时间',
    end_time timestamp not null comment '结束时间',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (advertisement_info_id),
    key idx_advertisement_info_title (advertisement_info_title)
);

-- advertisement_detail 促销详情
create table if not exists advertisement_detail (
    advertisement_detail_id int(11) not null auto_increment comment '促销详情id',
    advertisement_info_id int(11) not null comment '广告信息id',
    book_info_id int(11) not null comment '图书信息id',
    purchase_discount decimal(6, 2) not null default 0 comment '促销折扣',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (advertisement_detail_id),
    key idx_advertisement_info_id (advertisement_info_id),
    key idx_book_info_id_3 (book_info_id),
    unique key (advertisement_info_id, book_info_id)
);

--
-- ShoppingCart Module
-- 购物车模块
--

-- shopping_cart_info 购物车信息
create table if not exists shopping_cart (
    shopping_cart_id int(11) not null auto_increment comment '购物车信息id',
    user_info_id int(11) not null comment '用户信息id',
    book_info_id int(11) not null comment '图书信息id',
    book_quantity int(11) not null default 1 comment '图书数量',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp
        on update current_timestamp comment '更新时间',
    primary key (shopping_cart_id)
);


