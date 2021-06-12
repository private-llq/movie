

<template>
<div class="personalinfor">
  <div id="app">
    <div id="nav">

     
     <el-row :gutter="10" class="header" >
     <el-menu  router class="el-menu-demo" mode="horizontal"  >

    <el-col :span="2"><div class="grid-content bg-purple">
    <el-menu-item >
    <img alt="logo" src="./assets/O.png">Eyes 电影
    </el-menu-item></div></el-col>
    
    <el-col :span="2"><div class="grid-content bg-purple">
    <el-submenu index="2">
    <template slot="title" >重庆</template>
    <el-menu-item >成都</el-menu-item>
    <el-menu-item >广州</el-menu-item>
    <el-menu-item >上海</el-menu-item>
    </el-submenu>
    </div></el-col>

    <el-col :span="1"><div class="grid-content bg-purple"><el-menu-item index="/">首页</el-menu-item></div></el-col>

    <el-col :span="1"><div class="grid-content bg-purple"><el-menu-item index="movies">电影</el-menu-item></div></el-col>

    <el-col :span="1"><div class="grid-content bg-purple"><el-menu-item index="cinema">影院</el-menu-item></div></el-col>

    <el-col :span="1"><div class="grid-content bg-purple"><el-menu-item index="List">榜单</el-menu-item></div></el-col>

    <el-col :span="1"><div class="grid-content bg-purple"><el-menu-item index="shoppingmall">商城</el-menu-item></div></el-col>

    <el-col :push="5" :span="5"><div class="grid-content bg-purple"><el-menu-item>
    <el-input placeholder="请输入内容" v-model="input" clearable></el-input>
    <el-button type="primary" icon="el-icon-search">搜索</el-button>
    </el-menu-item></div></el-col>


    <el-col :push="7" :span="2"><div class="grid-content bg-purple"><el-menu-item index="/user"><el-dropdown>
    <span class="el-dropdown-link">用户<i class="el-icon-arrow-down el-icon--right"></i></span>
    <el-dropdown-menu slot="dropdown">
    <el-dropdown-item ><a href="/#/login">登录</a></el-dropdown-item>
    <el-dropdown-item ><a href="/#/register">注册</a></el-dropdown-item>
    </el-dropdown-menu></el-dropdown></el-menu-item></div></el-col>
    

    </el-menu>
    </el-row>
   
    <div class="line"></div>
    </div>
    <router-view/>
    </div>
  </div>
    
</template>

<script>
  export default {
    data() {
      return {
       input: ''
      };
    },
    created() {
        setTimeout(() => {
            window.L2Dwidget.init({
                pluginRootPath: 'live2dw/',
                pluginJsPath: 'lib/',
                pluginModelPath: 'live2d-widget-model-z16/assets/',
                tagMode: false,
                debug: false,
                model: { jsonPath: '/live2dw/live2d-widget-model-z16/assets/z16.model.json' },
                display: { position: 'left', width: 150, height: 300 },
                mobile: { show: true },
                log: false
            })
           
        }, 1000)
    },
}
</script>

<style scoped>
.header{
   position: fixed;
  width: 100%;
  left: 0;
  top: 0;
  z-index: 1000;
}
</style>
