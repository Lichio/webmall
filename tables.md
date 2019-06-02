### WebMall Tables

[TOC]

#### tb_buyer
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|buyer_id| |true|true|用户ID，自增 |
|username | | | true|用户名 |
|password | | | true| 密码|
|address| | | false|收货地址 |
|create_time| | | true| 注册时间|

***

#### tb_seller
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|seller_id| |true|true|用户ID，自增|
|username | | | true|用户名 |
|password | | | true| 密码|
|shop| | | true|店铺名|
|create_time| | | true| 注册时间|

***

#### tb_commodity
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|commodity_id||true|true|商品ID，自增|
|name| | |true|商品名称|
|description| | | |商品介绍|
|picture| | | |商品图片 |
|quantity| | | true|商品剩余数量|
|price| | | true| 商品价格|
|seller_id| | |true|卖家ID|
|is_deleted| | | true|1表示已删除，0表示未删除|

***

#### tb_order
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|order_id | | true| true| 订单ID，自增|
|order_sn| | | true|订单编号|
|commodity_id| | | true| 商品ID|
|seller_id| | | true|卖家ID|
|quantity| | | true| 商品数量|
|total_value| | | true| 总金额|
|buyer_id| | | true| 买家ID|
|address| | | true| 收货地址|
|create_time| | | true|订单创建时间|
|status| | | true| 订单状态：0创建成功（未支付），1支付成功，2支付失败|
|is_deleted| | | true|1表示已删除，0表示未删除|

***

#### tb_cart（购物车）
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|cart_id| | true| true| 购物车ID，自增|
|buyer_id| | | true| 买家ID|
|commodity_id| | | true|商品ID|
|quantity| | | true| 商品数量|
|create_time| | | true| 加入购物车的时间|
|is_deleted| | | true| 1表示已删除，0表示未删除|

***

#### tb_logistics
| 字段 | 类型 | Primary Key | NOT NULL | 说明 |
---|---|---|---|---
|logistics_id| | true| true| 物流ID，自增|
|order_sn| | | true| 订单编号|
|status| | | true| 物流状态：0未发货，1已发货，2运输中，3派件中，4已签收|
