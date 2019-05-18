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

