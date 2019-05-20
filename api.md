API文档
=======

**Json Web Token**

**Header**

| 参数名  | 类型   | 描述         |
| ------- | ------ | ------------ |
| Token   | String | 令牌         |
| Expires | Date   | 令牌过期时间 |

<hr/>

### User Module 用户模块

**API 列表**

* /user/api/v1/user/register **注册用户**
* /user/api/v1/user/login **用户登录**
* /user/api/v1/user/logout **用户注销**
* /user/api/v1/password/alter **修改密码**
* /user/api/v1/user/info **获取用户个人信息**
* /user/api/v1/userInfo/update **修改用户个人信息**
* /user/api/v1/userDetail/update **修改用户详情信息**
* /user/api/v1/headPortrait/upload **上传用户头像**

<hr/>

**/user/api/v1/user/register**

**注册用户**

**方法：POST**

**请求参数**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| username | 是   | String | 用户名   |
| password | 是   | String | 密    码 |

**Header**

无

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

------

**/user/api/v1/user/login**

**用户登录**

**方法：GET**

**请求参数**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| username | 是   | String | 用户名   |
| password | 是   | String | 密    码 |

**Header**

无

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

------

**/user/api/v1/user/logout**

**用户注销**

**方法：GET**

**请求参数**

无

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

**/user/api/v1/password/update**

**修改密码**

**方法：POST**

**请求参数**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| username | 是   | String | 用户名   |
| password | 是   | String | 密    码 |

**Header**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| Token | 是   | String | 令牌   |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

------

**/user/api/v1/user/info**

**获取用户个人信息**

**方法：GET**

**请求参数**

无

**Header**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| Token | 是   | String | 令牌   |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {
        "id": 1,              // 用户id
        "nickname": "user1",  // 昵称
        "gender": "",         // 性别
        "birthday": null,     // 出生日期
        "img": "",            // 头像
        "phone": "",          // 电话号码
        "email": ""           // 电子邮箱
    }
}
```

<hr/>

**/user/api/v1/userInfo/update**

**修改用户个人信息**

**方法：POST**

**请求参数**

| 参数名    | 必选 | 类型   | 描述     |
| --------- | ---- | ------ | -------- |
| userPhone | 否   | String | 手机号码 |
| userEmail | 否   | String | 电子邮箱 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

**/user/api/v1/userDetail/update**

**修改用户详情信息**

**方法：POST**

**请求参数**

| 参数名       | 必选 | 类型   | 描述     |
| ------------ | ---- | ------ | -------- |
| userNickname | 否   | String | 手机号码 |
| userGender   | 否   | String | 电子邮箱 |
| userBirthday | 否   | Date   | 出生日期 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
	"code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

**/user/api/v1/headPortrait/upload**

**上传用户头像**

**方法：POST**

**请求参数**

| 参数名 | 必选 | 类型          | 描述     |
| ------ | ---- | ------------- | -------- |
| file   | 是   | MultipartFile | 用户头像 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/> 

### Address Module 地址模块

**API列表**

* /address/api/v1/address/add **添加地址**
* /address/api/v1/address/update **修改地址信息**
* /address/api/v1/address/list **获取地址列表**
* /address/api/v1/address/get **获取地址信息**
* /address/api/v1/address/delete **删除地址**

<hr/>

**/address/api/v1/address/add**

**添加地址**

**方法：POST**

**请求参数**

| 参数名        | 必选 | 类型    | 描述           |
| ------------- | ---- | ------- | -------------- |
| receiverName  | 是   | String  | 收货人姓名     |
| receiverPhone | 是   | String  | 收货人手机号码 |
| postalCode    | 是   | String  | 邮政编码       |
| areaId        | 是   | Integer | 地区id         |
| addressDetail | 是   | String  | 收货详细地址   |
| addressStatus | 是   | Boolean | 是否默认为地址 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

**/address/api/v1/address/update**

**修改地址信息**

**方法：POST**

**请求参数**

| 参数名        | 必选 | 类型    | 描述           |
| ------------- | ---- | ------- | -------------- |
| receiverName  | 否   | String  | 收货人姓名     |
| receiverPhone | 否   | String  | 收货人手机号码 |
| postalCode    | 否   | String  | 邮政编码       |
| areaId        | 否   | Integer | 地区id         |
| addressDetail | 否   | String  | 收货详细地址   |
| addressStatus | 否   | Boolean | 是否默认为地址 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

**/address/api/v1/address/list**

**获取地址列表**

**方法：GET**

**请求参数**

| 参数名   | 必选 | 类型    | 描述 |
| -------- | ---- | ------- | ---- |
| pageNum  | 是   | Integer | 页码 |
| pageSize | 是   | Integer | 数目 |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": [
        {
            "id": 1,							// 收货地址id
            "name": "陈先生",					  // 收货人姓名
            "phone": "13112341234",             // 收货人手机号码
            "code": "000001",                   // 邮政编码
            "areaId": 440404,                   // 地区id
            "area": "广东省珠海市金湾区",          // 地区
            "address": "三灶镇吉林大学珠海学院",    // 详细地址
            "default": false                    // 是否默认地址
        },
        {
            "id": 2,
            "name": "陈先生",
            "phone": "13100000000",
            "code": "000000",
            "areaId": 710448,
            "area": "台湾省台中市清水区",
            "address": "123456789",
            "default": false
        },
        {
            "id": 3,
            "name": "Mr.no",
            "phone": "13112341232",
            "code": "111719",
            "areaId": 710449,
            "area": "台湾省台中市大甲区",
            "address": "111",
            "default": false
        }
	]
}
```

<hr/>

**/address/api/v1/address/get**

**获取某个地址**

**方法：GET**

**请求参数**

| 参数名            | 必选 | 类型    | 描述       |
| ----------------- | ---- | ------- | ---------- |
| receiverAddressId | 是   | Integer | 收货地址id |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {
        "id": 1,
        "name": "陈先生",
        "phone": "13112341234",
        "code": "000001",
        "areaId": 440404,
        "area": "广东省珠海市金湾区",
        "address": "三灶镇吉林大学珠海学院",
        "default": false
    }
}
```

<hr/>

**/address/api/v1/address/delete**

**删除地址**

**方法：POST**

**请求参数**

| 参数名            | 必选 | 类型    | 描述       |
| ----------------- | ---- | ------- | ---------- |
| receiverAddressId | 是   | Integer | 收货地址id |

**Header**

| 参数名 | 必选 | 类型   | 描述 |
| ------ | ---- | ------ | ---- |
| Token  | 是   | String | 令牌 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

<hr/>

### Book Module 图书模块

**API列表**

* /book/api/v1/book/get **获取图书信息**

<hr/>

**/book/api/v1/book/get**

**获取图书信息**

**方法：GET**

**请求参数**

| 参数名     | 必选 | 类型    | 描述       |
| ---------- | ---- | ------- | ---------- |
| bookInfoId | 是   | Integer | 图书信息id |

**Header**

无

**响应**

```javascript
{
	"code": 0,
	"msg": "ok",
	"data": {
		"id": 1,									 // 图书id
        "category": "小说/中国当代小说",				// 图书分类
        "name": "人生海海",                            // 图书名称
        "author": "麦家",                             // 图书作者
        "intro": "人生海海，何必在意一时沉浮！",          // 图书简介
        "publisher": "北京十月文艺出版社",              // 出版社
        "pubDate": "2019-05",                        // 出版时间
        "isbn": "9787530219218",                     // ISBN
        "actualPrice": "53.90",						 // 实际价格
        "originalPrice": "55.00",					 // 原价
        "stock": 1000,								 // 库存
        "status": false,							 // 上架状态
        "infoImg": "",							     // 图书封面
        "detailImg": ""								 // 图书详情
	}
}
```

