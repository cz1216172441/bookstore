API文档
=======



### User Module 用户模块

**API 列表**

* /user/api/v1/user/register **注册用户**
* /user/api/v1/user/login **用户登录**
* /user/api/v1/password/alter **修改密码**



------

**/user/api/v1/user/register**

**注册用户**

**方法：POST**

**请求参数**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| username | 是   | String | 用户名   |
| password | 是   | String | 密    码 |

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

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

------

**/user/api/v1/password/alter**

**修改密码**

**方法：POST**

**请求参数**

| 参数名   | 必选 | 类型   | 描述     |
| -------- | ---- | ------ | -------- |
| username | 是   | String | 用户名   |
| password | 是   | String | 密    码 |

**响应**

```javascript
{
    "code": 0,
    "msg": "ok",
    "data": {}
}
```

------

