# 一眼票务管理系统

Forked from https:https://gitee.com/lu-oh/oneeyeticket-management-system-

#### 介绍

基于SpringBoot + Vue 的电影售票系统和影院后台管理系统

# 程序运行环境说明

## 运行环境

1. java 8
2. vue 2.6.12
3. vue_cli 2.0
4. maven 3.6.3
5. nodeJS 12

## 后端配置

1. 找到`oneeyeticket-management-system-`模块下的`resources`文件夹内的`application.yml`，端口在最下方配置
2. 同文件内`application.yml`配置`mysql`的数据源
3. 之后重新导入maven依赖即可

## 前端配置

### 一眼票务系统前端

1. 进入`ticket-ui`文件夹下的`ticket`文件夹内，执行`npm install`命令
2. 在根目录下`vue.config.js`文件中修改运行端口
3. 进入`src`目录下，找到`main.js`文件，其中有两个属性，`base`属性表示访问后端图片的路径，`baseUrl`表示通过`axios`访问后端接口的默认路径(若本地运行，均修改为`http://localhost:8081`即可，端口为后端配置的端口号)
4. 运行前端vue项目，进入`ticket`文件夹，执行`npm run serve`命令即可运行


## 运行后部分信息

运行后通过控制台显示的指定地址即可访问前台和后台，默认登录用户为：`用户名：aaa 密码：123`


