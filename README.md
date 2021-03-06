# 豆瓣App开发记录

## 项目目的
1. 学习团队协作开发
2. 学习Android开发框架
3. 增加项目经验

## 项目开发进度
### 2017/04/20讨论

1. 讨论代码规范
    1. 项目名称（DouBanApp） -- 改为DouBanApp_4A，方便区分我们4群A组
    2. 项目包名（com.teamwork）
    3. 项目结构（功能分5个大包）
    4. 项目框架 （各自开发自己模块，开发完成后对比学习，再统一）
2. 分配任务
    1. 步か一 制作首页（周日下午前完工）
    2. Iden  制作底部导航栏，加剩余主页面（周日下午前完工）
    3. 周日晚上整合项目，并计划下周任务

### 2017/04/21 进度
1. 项目结构搭建完成
 
![项目结构](http://i.imgur.com/mQwfLjY.jpg-w300) 

2. 当前效果

![当前效果](http://i.imgur.com/QN5EwsO.jpg)

### 2017/04/21 计划
1. 新成员加入，再次讨论分配任务

### 2017/04/21 讨论
1. 分配任务
	1. 一个                首页
	2. 一个人去旅行         书影音
	3. Iden                广播
	4. Pugss               小组
	5. 冷                  我的
### 2017/04/23 整合项目进度
1. 5个首页面搭建完成

 >效果图：

![首页](http://oovbhs6lj.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E7%95%8C%E9%9D%A2.jpg)
![书影音](http://oovbhs6lj.bkt.clouddn.com/%E4%B9%A6%E5%BD%B1%E9%9F%B3%E7%95%8C%E9%9D%A2.jpg)
![广播](http://oovbhs6lj.bkt.clouddn.com/%E5%B9%BF%E6%92%AD%E7%95%8C%E9%9D%A2.jpg)
![小组](http://oovbhs6lj.bkt.clouddn.com/%E5%B0%8F%E7%BB%84%E7%95%8C%E9%9D%A2.jpg)
![我的](http://oovbhs6lj.bkt.clouddn.com/%E6%88%91%E7%9A%84%E7%95%8C%E9%9D%A2.jpg)

2. 人员方面： 一个  个人原因暂时没时间，由 亚磊 代替做首页
3. 下周任务:由于豆瓣App数据太过复杂，考虑自己定义一些数据，后面和阳叔讨论完再做决定！每个人暂时先完善各自页面，优化代码！


### 2017/05/06 整合项目进度
1. 5个模块情况
	1. 首页     本地数据填充
	2. 书影音   电影，电视，读书，音乐数据填充
	3. 广播     编辑，发送广播（本地存储)，发现更多广播列表，点赞，留言，搜索用户界面
	4. 小组     小组信息各界面，精选小组列表，我的小组列表，更多小组列表，Item点击进入小组详情(WebView)
	5. 我的     设置界面（只写界面），提醒界面，功能列表点击能进入相应的界面

2. 人员方面： HuangHuanHuan，Iden  其他成员暂无时间
3. 下周任务： 重构代码（有数据的界面改为MVP），提高交互性，在此项目基础上学习对比第三方的优缺点


### 2017/05/10 整合项目进度
1. 数据接口方面（简易网络Json数据）
	1. 首页 			Bannner:http://60.205.189.201/douban/home/banner.php 
	2. 首页 			数据列表：http://60.205.189.201/douban/home/datalist.php
	3. 书影音 		电影列表：http://60.205.189.201/douban/bbm/movies.php
	3. 书影音 		推荐电影：http://60.205.189.201/douban/bbm/suggestmovies.php
	4. 小组			精选小组：http://60.205.189.201/douban/group/mixedgroups.php
	5. 小组 			更多小组：http://60.205.189.201/douban/group/moregroups.php
2. 5个模块情况
	1. 首页     网络数据填充，各个Item点击进入详情（Webview）
	2. 书影音   电影，电视，读书，音乐数据填充(都是填充电影数据)，各个Item点击进入详情（Webview）
	3. 广播     编辑，发送广播（本地存储)，发现更多广播列表，点赞，留言，搜索用户界面
	4. 小组     小组信息各界面，精选小组列表，我的小组列表，更多小组列表，Item点击进入小组详情(WebView)
	5. 我的     设置界面（只写界面），提醒界面，功能列表点击能进入相应的界面

### 项目情况(2017/05/10)

    现阶段项目界面基本上算是完成，后期等后端对接数据。
    代码是多人组合的，结构不统一。代码也比较乱，但基本功能效果是有了，暂时不准备继续重构下去。等后期对接数据再改。
    


 
	
