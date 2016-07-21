
create TABLE if not exists easybuy_user
(
eu_user_id int primary key auto_increment,
eu_user_name varchar(50),
eu_password varchar(20),
eu_sex varchar(10),
eu_birthday DATE,
eu_identity_code varchar(20),
eu_email varchar(50),
eu_mobile int,
eu_address varchar(50),
eu_status int
)default charset=utf8;


CREATE TABLE if not exists easybuy_news
(
en_id int primary key auto_increment,
en_title varchar(50),
en_content varchar(50),
en_create_time DATE
)default charset=utf8;
insert  into  easybuy_news values(1,'618提前热身大处理','今日特价，618提前享受优惠。','2016-6-15');
insert  into  easybuy_news values(default,'毕业季，留住青春','青春时尚，秀出自己，青春不孤单。','2016-6-16');
insert  into  easybuy_news values(default,'笔记本特惠','高性能笔记本今日7折起，就在一天！抓紧时间','2016-6-17');
insert  into  easybuy_news values(default,'618大卖场','618狂欢节，各大商品1折起！','2016-6-18');
insert  into  easybuy_news values(default,'换季特惠','夏装2折起，特卖大优惠，给你一个清凉的夏季','2016-6-20');


CREATE TABLE if not exists easybuy_comment
(
ec_id int primary key auto_increment,
ec_reply varchar(50),
ec_content varchar(50),
ec_create_time DATE,
ec_reply_time DATE,
ec_nick_name varchar(20)
)default charset=utf8;
insert  into  easybuy_comment values(1,'亲，遇到你的情况我建议请即使与卖家联系换货，给你带来诸多不便，敬请谅解',  '我买的鞋大了，怎么办？', '2016-6-10' ,  '2016-6-10' ,  '在世乔丹');
insert  into  easybuy_comment values(default, '亲，遇到你的情况我建议请即使与卖家联系换货，给你带来诸多不便，敬请谅解',  '我买的衣服小了，怎么办？', '2016-6-11' ,  '2016-6-11' ,  '羞涩的小喷菇');
insert  into  easybuy_comment values(default, '亲，遇到你的情况我建议请即使与卖家联系换货，给你带来诸多不便，敬请谅解',  '买的电脑经常死机，怎么办？', '2016-6-12' ,  '2016-6-12' ,  'IT王者');
insert  into  easybuy_comment values(default, '亲，肯定是正品，祝你购物愉快',  '请问电脑都是正品吗？', '2016-6-12' ,  '2016-6-12' ,  '打假专业户');
insert  into  easybuy_comment values(default, '亲，618各大店铺都有优惠活动，你可以在店铺查看优惠商品，祝你购物愉快',  '618有什么活动吗？', '2016-6-13' ,  '2016-6-13' ,  '捡漏大师');


CREATE TABLE if not exists easybuy_product
(
ep_id int primary key auto_increment,
ep_name varchar(50),
ep_description varchar(50),
ep_price float(10,2),
ep_stock int,
epc_id int,
epc_child_id int,
ep_file_name varchar(50)
)default charset=utf8;

insert  into  easybuy_product values(1,'法国德菲丝松露精品巧克力500g/盒','巧克力',108.00,21,1,1,'1.jpg');
insert  into  easybuy_product values(default,'乐扣普通型保鲜盒圣诞7件套','保鲜盒',69.90,101,2,2,'2.jpg');
insert  into  easybuy_product values(default,'欧珀莱均衡保湿四件套','化妆品',279.00,61,3,3,'3.jpg');
insert  into  easybuy_product values(default,'联想笔记本电脑 高速独立显存','笔记本',4199.00,11,4,4,'4.jpg');
insert  into  easybuy_product values(default,'法姿韩版显瘦彩边时尚牛仔铅笔裤','裤子',49.00,651,5,5,'5.jpg');
insert  into  easybuy_product values(default,'Genius925纯银施华洛世奇水晶吊坠','吊坠',69.90,51,6,6,'6.jpg');
insert  into  easybuy_product values(default,'利仁2018M福满堂电饼铛 好用实惠','电饼铛',268.00,31,2,2,'7.jpg');
insert  into  easybuy_product values(default,'达派高档拉杆箱20寸 经典款式','拉杆箱',198.00,223,7,7,'8.jpg');
insert  into  easybuy_product values(default,'爱国者MP4 全屏触摸多格式播放 4G','MP4',289.00,123,4,4,'9.jpg');
insert  into  easybuy_product values(default,'多美滋金装金盾3阶段幼儿配方奶粉','奶粉',186.00,13,8,8,'10.jpg');




CREATE TABLE if not exists easybuy_product_category
(
epc_id int primary key auto_increment,
epc_name varchar(50),
epc_parent_id int
)default charset=utf8;

insert  into  easybuy_product_category  values(1,'食品',1);
insert  into  easybuy_product_category  values(default,'家具',2);
insert  into  easybuy_product_category  values(default,'美妆',3);
insert  into  easybuy_product_category  values(default,'手机数码',4);
insert  into  easybuy_product_category  values(default,'服装',5);
insert  into  easybuy_product_category  values(default,'手表饰品',6);
insert  into  easybuy_product_category  values(default,'鞋包',7);
insert  into  easybuy_product_category  values(default,'母婴',8);





CREATE TABLE if not exists easybuy_order
(
eo_id int primary key auto_increment,
eo_user_id int,
eo_user_name varchar(50),
eo_user_address varchar(50),
eo_create_time DATE,
eo_cost float(16,2),
eo_status int,
eo_type int
)default charset=utf8;

insert  into  easybuy_order values(1,520,'奥格瑞玛','艾泽拉斯','2016-6-1',107.50,1,1);
insert  into  easybuy_order values(default,521,'安东尼','达拉然','2016-6-2',10.50,1,2);
insert  into  easybuy_order values(default,522,'佛丁','暴风城','2016-6-3',19.70,1,2);
insert  into  easybuy_order values(default, 523,'沃金','暗影岛','2016-6-4',88.89,2,1);
insert  into  easybuy_order values(default, 524,'希尔瓦娜斯','不知道','2016-6-5',108.50,2,2);






CREATE TABLE if not exists easybuy_order_detail
(
eod_id int primary key auto_increment,
eo_id int,
ep_id int,
eod_quantity int,
eod_cost float(16,2)
)default charset=utf8;

