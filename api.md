## WebMall API

[TOC]

### 获取验证码
目前有3种验证码，对应的**type**为：
- 短信注册验证码：register
- 使用手机号登录验证码：login
- 修改密码验证码：changePassword

#### Request
- Method：**GET**
- URL：```/v1.0/smscode?type={type}&phone={phone} ```
	- 如新用户注册时获取短信验证码:```/1.0/smscode?type={register}&phone={18706811105} ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 用户注册
目前有两种用户：
商品购买者：buyer
商品出售者：seller

#### Request
- Method：**POST**
- URL：```/v1.0/register ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"password": "12345678",
	"smscode": "238537",
	"role": "buyer"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 重置密码
目前有两种用户：
商品购买者：buyer
商品出售者：seller

#### Request
- Method：**PUT**
- URL：```/v1.0/password ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"password": "12345678",
	"smscode": "238537",
	"role": "role"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 用户登录(buyer，密码登录)
#### Request
- Method：**POST**
- URL：```/v1.0/buyer/passwordLogin ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"password": "12345678"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": {
		"buyerId": "1",
		"username": "18706811105"
	}
}
```

***

### 用户登录(buyer，验证码登录)
#### Request
- Method：**POST**
- URL：```/v1.0/buyer/smscodeLogin ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"smscode": "238537"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": {
		"buyerId": "1",
		"username": "18706811105"
	}
}
```

***

### 获取首页商品列表（buyer）
#### Request
- Method：**GET**
- URL：```/v1.0/buyer/commodities?pageSize=10&pageNumber=1 ```
- Headers：
- Body：

#### Response
- Body
```json
[
	{
		"commodity_id": "1",
		"name": "商品名称",
		"picture": ""
	}
]
```

***

### 获取商品详情（buyer）
#### Request
- Method：**GET**
- URL：```/v1.0/buyer/commodity?commodity_id=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"commodity_id": "商品ID",
	"name": "商品名称",
	"picture": "图片",
	"description": "描述",
	"quantity": "剩余量",
	"price": "价格",
	"seller_id": "卖家ID",
	"shop": "店铺"
}
```

***

### 加入购物车
#### Request
- Method：**POST**
- URL：```/v1.0/buyer/cart ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"commodity_id": "1",
	"quantity": "2",
	"buyer_id": "1"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 查看购物车
#### Request
- Method：**GET**
- URL：```/v1.0/buyer/cart?buyerId=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": [
		{
			"commodity_id": "1",
			"name": "HUAWEI P30",
			"picture": "pic url",
			"quantity": "2",
			"create_time": "201906021623"
		}
	]
}
```

***

### 提交订单（buyer）
#### Request
- Method：**POST**
- URL：```/v1.0/buyer/order ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"commodity_id": 1,
	"quantity": 2,
	"totalValue": 450,
	"buyer_id": 1,
	"address": "shanghai"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 查看订单（buyer）
#### Request
- Method：**GET**
- URL：```/v1.0/buyer/orders?buyerId=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": [
		{
			"order_sn": "订单编号",
			"commodity_id": 1,
			"name": "商品名称",
			"picture": "商品图片",
			"quantity": 2,
			"totalValue": 450,
			"create_time": "201906021633",
			"status": 1
		}
	]
}
```

***

### 查看物流信息
#### Request
- Method：**GET**
- URL：```/v1.0/buyer/logistics?orderSn={orderSn} ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": [
		{
			"order_sn": "",
			"status": 0
		}
	]
}
```




***
***




### 用户登录(seller，密码登录)
#### Request
- Method：**POST**
- URL：```/v1.0/seller/passwordLogin ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"password": "12345678"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": {
		"sellerId": 1,
		"username": "18706811105"
	}
}
```

***

### 用户登录(seller，验证码登录)
#### Request
- Method：**POST**
- URL：```/v1.0/seller/smscodeLogin ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"username": "18706811105",
	"smscode": "238537"
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": {
		"sellerId": 1,
		"username": "18706811105"
	}
}
```

***

### 新建商品
#### Request
- Method：**POST**
- URL：```/v1.0/seller/commodity ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"name": "",
	"picture": "",
	"description": "",
	"quantity": 9999,
	"price": 123,
	"seller_id": 1
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 修改商品
#### Request
- Method：**PUT**
- URL：```/v1.0/seller/commodity ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"commodity_id": 1,
	"name": "",
	"picture": "",
	"description": "",
	"quantity": 9999,
	"price": 123
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 删除商品
#### Request
- Method：**DELETE**
- URL：```/v1.0/seller/commodity ```
- Headers：Content-Type:application/json
- Body：
```json
{
	"commodity_id": 1
}
```

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": ""
}
```

***

### 获取商品详情（seller）
#### Request
- Method：**GET**
- URL：```/v1.0/seller/commodity?commodity_id=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"commodity_id": "商品ID",
	"name": "商品名称",
	"picture": "图片",
	"description": "描述",
	"quantity": "剩余量",
	"price": "价格"
}
```

***

### 获取商品列表（seller）
#### Request
- Method：**GET**
- URL：```/v1.0/seller/commodities?sellerId=1&pageSize=10&pageNumber=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "OK",
	"data": [
		{
			"commodity_id": "1",
			"name": "商品名称",
			"picture": ""
		}
	]
}
```

***

### 查看订单（seller）
#### Request
- Method：**GET**
- URL：```/v1.0/seller/orders?sellerId=1 ```
- Headers：
- Body：

#### Response
- Body
```json
{
	"code": 200,
	"message": "SUCCESS",
	"data": [
		{
			"order_sn": "订单编号",
			"commodity_id": 1,
			"name": "商品名称",
			"picture": "商品图片",
			"quantity": 2,
			"totalValue": 450,
			"create_time": "201906021633",
			"status": 1
		}
	]
}
```



