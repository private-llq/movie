#电影的票务，选座系统
Forked from https:https://gitee.com/private-llq/movie.git

#### 介绍

基于SpringBoot + Vue 的电影售票系统和影院后台管理系统

# 程序运行环境说明

## 架构
mvc架构  前后端没分离

## 运行环境

- java 8
- vue 2.6.12
- vue_cli 2.0
- maven 3.6.3
- nodeJS 12

## 后端配置

找到oneeyeticket-management-system-模块下的resources文件夹内的application.yml，端口在最下方配置
同文件内application.yml配置mysql的数据源
之后重新导入maven依赖即可

## 前端配置


### 一眼票务系统前端


进入ticket-ui文件夹下的ticket文件夹内，执行npm install命令
在根目录下vue.config.js文件中修改运行端口
进入src目录下，找到main.js文件，其中有两个属性，base属性表示访问后端图片的路径，baseUrl表示通过axios访问后端接口的默认路径(若本地运行，均修改为http://localhost:8081即可，端口为后端配置的端口号)
运行前端vue项目，进入ticket文件夹，执行npm run serve命令即可运行


## 运行后部分信息
运行后通过控制台显示的指定地址即可访问前台和后台，默认登录用户为：用户名：aaa 密码：123


