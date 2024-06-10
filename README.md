<p align="center">
</p>

<p align="center">
<a>
    <img src="https://img.shields.io/badge/Spring Boot-2.7.2-brightgreen.svg" alt="Spring Boot">
    <img src="https://img.shields.io/badge/MySQL-8.0.20-orange.svg" alt="MySQL">
    <img src="https://img.shields.io/badge/Java-17.0.2-blue.svg" alt="Java">
    <img src="https://img.shields.io/badge/Redis-5.0.14-red.svg" alt="Redis">
    <img src="https://img.shields.io/badge/zhipu-2.0.2-orange.svg" alt="Zhipu">
    <img src="https://img.shields.io/badge/MyBatis--Plus-3.5.2-blue.svg" alt="MyBatis-Plus">
    <img src="https://img.shields.io/badge/Redisson-3.21.3-yellow.svg" alt="Redisson">
    <img src="https://img.shields.io/badge/Caffeine-2.9.2-blue.svg" alt="Caffeine">
    <img src="https://img.shields.io/badge/Hutool-5.8.8-green.svg" alt="Hutool">
    <img src="https://img.shields.io/badge/Shardingsphere--Jdbc-5.2.0-yellow.svg" alt="Shardingsphere">
</a>
</p>

# PaleAnswer

一款基于 Vue + Spring Boot + Redis + ChatGLM + RxJava + Caffeine + SSE 的智能答题平台。前台用户可以基于AI快速生成应用题目并发布多种答题应用，支持检索和分享应用、在线答题并基于评分算法或AI得到回答总结。后台管理员可以审核应用、集中管理整站内容，并进行统计分析。

## 已有功能
- 用户模块
  - 用户登录
  - 用户注册
  - 管理用户
- 应用模块：
  - 添加应用
  - 删除应用
  - 修改应用
  - 审核应用
  - 管理应用
  - 分享应用
- 题目模块
  - 创建题目，包括题目选项的分设置
  - 修改题目
  - 删除题目
  - 管理题目
  - AI自动生成题目 
- 评分模块
  - 创建评分
  - 修改评分
  - 删除评分
  - 根据回答计算评分，多种评分策略，可以自定义评分规则或通过AI评分 
- 回答记录模块
  - 提交回答
  - 查看回答结果
  - 回答记录管理  
- 统计分析模块
  - 应用使用次数分析
  - 应用结果分析 
  
## 项目亮点
- 库表设计：根据业务设计用户/应用/题日/评分结果/用户答题表。其中题目表采用 JSON 存储复杂的嵌套题目和选项，便于维护扩展，并通过给题目表添加 appld 索引提升检索性能。
- 评分模块:基于策略模式实现了多种用户回答评分算法(如统计得分、AI评分等)，全局执行器会扫描策略类上的自定义注解并选取策略，相较于if else提高了系统的可扩展性。
- 基于 ChatGLM AI 封装了通用 AI 服务，并通过配置类自动读取 key 配置初始化 AI 客户端 Bean，便于全局使用。
- 基于腾讯云 COS 封装了通用文件管理服务，并通过配置类自动读取 key 配置初始化 COS 客户端 Bean，便于全局使用。
- AI生成题目：通过系统预设、少样本学习、任务拆解等手段优化 Prompt，让 AI 返回 JSON 题目内容，便于后端处理。
- 由于 AI 生成题目较慢，选用 ChatGLM 的流式 API并通过 SSE 实时推送单道题目给前端，提高用户体验。
- 基于 Rxava 的操作符链式调用处理 AI异步数据流，先通过 map 获取并处理字符串、flter 过滤空值、flatMap 映射串为单个字符，再通过括号平衡算法准确拼接出单道题目，使得逻辑简单清晰。
- 为防止用户多次提交重复答案，基于雪花算法为每次答题分配唯一 id，并通过数据库主键实现,幂等设计，避免了重复的脏数据。
- 由于相同答案的 AI 评分应该相同，使用 caffeine 本地缓存答案 Hash 对应的 AI评分结果，提高评分性能(5s到5ms)的同时大幅节约成本;并通过 Redisson 分布式锁解决缓存击穿问题。
- 为应对用户答题数的增长，基于 ShardingJDBC 配置取模分片算法，根据应用 id 对用户答题记录分表，提高了单表査询性能和可扩展性。
- 由于服务器资源有限，为会员创建核心线程数更大的隔离线程池，保证普通用户不会影响会员使用 AI 的体验
- 统计分析：基于 MyBatis 注解自定义 SQL 实现热门应用和回答分布的统计，前端通过 ECharts 实现可视化。


## 系统架构
![image](https://github.com/PALE13/PaleAnswer/assets/77827436/d3b55f71-059c-4d88-9357-ca15bf9548fe)



## 核心业务流程

![image](https://github.com/PALE13/PaleAnswer/assets/77827436/0c59698c-10fc-4c5e-a34c-b1d81937af32)

## 时序图

![image](https://github.com/PALE13/PaleAnswer/assets/77827436/ccf3d03c-beac-40c9-8954-e13c493ab40b)





