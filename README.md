# 天使音乐后台接口文档

***

## 版本信息

 版本        | 修改日期		| 修改人  | 修改记录
 :---------- |:-------------|:-----|:--------
 1.0.0    | 2016.09.28 | 宁旭温 | 创建文档
 2.0.0    | 2016.10.8  | 王勇   | 增加接口

## 接口目录
### [1.发布文章](#1)
### [2.发布文章](#2)


## 接口说明

<h3 id="1">1. 发布文章</h3>

#### 接口地址

* /article/pubArticle.json

#### 请求方法
* GET

#### 请求参数

参数名     | 是否必传	| 类型  | 说明
:---------- |:-------------|:-----|:--------
articleTitle | true |String | 文章标题
articleSummary | true  |String|文章摘要
articleDesc|true|String|文章描述
articleContent|true|String|文章发布内容
articleImg|true|String|文章配图，不是文章内容的图（无图值为 #）
articleKeywords|false|String|关键词
articleType|true|int|文章类型：1天使动态、2 课程内容、3 自学课程介绍
#### 调用示例
```
/article/pubArticle.json?articleTitle=''&articleSummary=....
```
#### 返回结果
##### json示例
* 成功
```
{
	code:0,
	message:'',
	result:”…”
}
```
* 失败
```
{
	code:xxx,
	message:'',
	result：''
}
```

### 错误返回值

| 错误码 | 说明 |
|:-----|:----|
| 1010 | xxxx |