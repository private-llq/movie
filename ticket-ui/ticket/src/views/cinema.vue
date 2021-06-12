<template>
  <div class="cinema">
<!--  二级导航栏  -->
    <div class="movie-path">
<!--   路径地址  -->
      <div class="path">
        <el-link :underline="false" href="/">首页</el-link>
        &gt
        <el-link :underline="false" href="/#/cinema">影院</el-link>
        &gt <el-link :underline="false">重庆</el-link>
      </div>
<!--   购票流程   -->
      <div class="steps">
        <span>3步轻松购票：1.选座购票/买劵</span>
          <i></i>
        <span>2.收电子码</span>
          <i></i>
        <span>3.影院收票</span>
      </div>
    </div>
<!--  筛选  -->
    <div class="center-wrap">
      <div class="fliter-wrap">
          <ul class="filler-select">
            <li>
              <label>选择区域</label>
<!--              循环展示数据库的地区名字-->
                <div class="select-tags">
                  <a  @click="queryAll(num)" :class="{active:isActive}" style="cursor:pointer;">全部区域</a>
                  <a v-for="(a,index) in Area" :key="a.areaId" :class="currentClass(index)" @click="queryArea(a.areaId,$event,index)" style="cursor:pointer;">{{a.areaName}}</a>
                </div>
            </li>
            <li id="seach1">
              <label>搜索</label>
              <div class="seach">
                <input placeholder="请输入影院名称" type="text" class="seach-input" v-model="cinemaname">
                <a @click="serch()" style="cursor:pointer;"><img src="../assets/magnifier.png" class="icon-search">查询</a>
              </div>
            </li>
          </ul>
        <template v-if="cinema.length==0">
          <ul class="cinmaList">
            <li>
              <h3>暂无影院信息</h3>
            </li>
          </ul>
        </template>
        <template v-else>
        <ul class="cinmaList">
<!--          循环展示电影院信息-->
            <li v-for="(c,i) in cinema" @mouseover="show(i)" @mouseleave="hide(i)" :class="currentStyle(i)">
              <span class="cinmaImg"></span>
              <div class="detail-middle">
                <div class="detail-hd">
                  <h4>{{c.cinemaName}}</h4>
                </div>
                <div class="middle-p" style="padding-top: 10px;">
                  <div class="middle-p-list">
                    <i>地址：</i>
                    <span class="limit-address">{{c.cinemaPosition}}</span>
                  </div>
                  <div class="middle-p-list">
                    <i>电话：</i>
                    <span class="limit-address">{{c.telephone}}</span>
                  </div>
                </div>
              </div>
              <div class="detail-right">
                <div class="right-score">
                  评分：
                  <strong>8.0</strong>
                </div>
                <div class="right-fav">
                </div>
                <div class="right-buy">
                  <a @click="buyTicket(c.cinemaId)" style="cursor:pointer;">选厅</a>
                </div>
                <el-dialog title="选厅"  :visible.sync="dialogTableVisible">
                  <el-table :data="gridData">
                    <el-table-column property="showTime" :formatter="formatTime" label="时间" width="240"></el-table-column>
                    <el-table-column property="title" label="电影名字" width="120"></el-table-column>
                    <el-table-column property="hallName" label="观影厅" width="100"></el-table-column>
                    <el-table-column property="price" label="价格" width="50"></el-table-column>

                    <el-table-column>
                      <template slot-scope="scope">
                        <el-button @click="selection(scope.row)" type="text" size="small">选座</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </el-dialog>
              </div>
            </li>
        </ul>
        </template>
      </div>
    </div>
  </div>

</template>
<style>
/*页面所有字体大小*/
  body{
    font-size: 12px;
  }
/*二级导航栏*/
  .movie-path{
    width: 990px;
    min-width: 990px;
    margin: auto;
  }
  /*路径地址*/
  .movie-path .path{
    float: left;
    color: #3e3e3e;
    line-height: 60px;
  }
  /*购票流程*/
  .movie-path .steps{
    float: right;
    color: #9a9a9a;
    line-height: 60px;
  }
  /*购票流程字体*/
  .movie-path .steps span{
    display: block;
    float: left;
    font-size: 12px;
  }
/* 购票流程图标*/
  .movie-path .steps i{
    float: left;
    display: inline-block;
    width: 14px;
    height: 60px;
    margin-right: 5px;
    margin-left: 5px;
    background: url("../assets/youbian.png") center center no-repeat;
  }
  /*中间展示内容*/
  .center-wrap{
    width: 990px;
    min-width: 990px;
    margin: auto;
  }
  /*中间筛选器*/
  .center-wrap .fliter-wrap{
    width: 638px;
    float: left;
    border: 1px solid #ddd;
    overflow: hidden;
    zomm:1;
  }
/*  选择区域*/
  .center-wrap .fliter-wrap .filler-select{
    padding-left: 90px;
    background: #FFDDDC;
    overflow: hidden;
    margin: 0;
  }
  /*标题样式*/
  .center-wrap .fliter-wrap .filler-select label{
    cursor: default;
    position: absolute;
    width: 90px;
    left: -90px;
    text-align: center;
    color: #797979;
    font-size: 12px;
  }
#seach1{
  position: relative;
  line-height: 25px;
  padding: 12px 232px 12px 0px;
  background: #FFF6F5;
  display: inline-block;
  height: 40px;
  float: left;
}

  /*中间区域li的样式*/
  .center-wrap .fliter-wrap .filler-select li{
    position: relative;
    line-height: 25px;
    padding: 12px 20px 12px 0px;
    clear: both;
    background: #FFF6F5;
    display: inline-block;
    height: 40px;
    float: left;
  }
/*  搜索标题样式*/
  .center-wrap .fliter-wrap .filler-select .select-tags{
    width: 100%;
    overflow: hidden;
    max-height: 50px;
  }
/*  a标签样式*/
.center-wrap .fliter-wrap .filler-select .select-tags a{
    display: inline-block;
    height: 25px;
    line-height: 25px;
    float: left;
    white-space: nowrap;
    width: auto;
  padding: 0px 8px;
  margin-left: 22px;
    margin-top: 2px;
  }
/*搜索框样式*/
  .seach{
    padding-left: 22px;
  }
  /*输入框样式*/
  .center-wrap .seach .seach-input{
    width: 219px;
    height: 28px;
    background: #fff;
    color: #626060;
    outline: 0;
    border: 1px solid #e5e5e5;
    border-right: none;
    float: left;
    text-indent: 4px;
    font-size: 12px;
  }
  .seach a{
    display: inline-block;
    width: 70px;
    height: 30px;
    line-height: 30px;
    float: left;
    padding: 0;
    margin: 0;
    background: #eb002a;
    color: #FFF;
  }
  .icon-search{
    width: 15px;
    height: 15px;
    margin-left: 10px;

    margin-right: 3px;
  }
  .active {
    background: red;
    color: white;
  }
  /*影院信息*/
  .cinmaList li{
    padding: 22px 19px 18px;
    border-bottom: 1px dashed #ddd;
    position: relative;
    zoom: 1;
    overflow: hidden;
  }
  /*影院展示图片*/
  .cinmaList li .cinmaImg{
    position: relative;
    float: left;
    width: 118px;
    height: 88px;
    border: 1px solid #ddd;
  }
  /*影院细节部分*/
  .detail-middle{
    width: 300px;
    float: left;
    padding-left: 19px;
    color: #999;
    overflow: hidden;
  }
  /*院线名字*/
  .detail-middle .detail-hd{
    overflow: hidden;
  }
  /*院线名字字体*/
  .detail-middle .detail-hd h4{
    display: inline-block;
    max-width: 100%;
    font-weight: 500;
    font-size: 16px;
    float: left;
    padding-right: 14px;
    color: #000;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin: 0;
  }
  .detail-middle .middle-p .middle-p-list{
    clear: both;
    line-height: 22px;
    color: #666;
  }
/*  影院信息字体样式*/
  .detail-middle .middle-p .middle-p-list i{
    color: #999;
    float: left;
    font-style: normal;
  }
/*影院地址样式*/
  .detail-middle .middle-p .middle-p-list span{
    max-width: 70%;
    float: left;
    display: inline-block;
    height: 23px;
    line-height: 23px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  /*院线地址样式*/
   .limit-address{
    max-width: 70%;
    float: left;
    display: inline-block;
    height: 23px;
    line-height: 23px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  /*院线详情右边部分*/
   .detail-right{
    position: absolute;
    width: 160px;
    overflow: hidden;
    zoom: 1;
     right: 30px;
  }
   .right-fav{
    padding: 8px 0 14px;
    text-align: right;
  }
   .right-buy a{
    float: right;
    padding: 2px 11px;
    text-align: center;
    line-height: 24px;
    color: #fff;
    background: #eb002a;
    margin-left: 5px;
     text-decoration:none;
  }
  li .right-buy{
    display: none;
    overflow: hidden;
    zoom: 1;
  }
   .current .right-buy{
    display: block;
  }
   .right-score{
     color: #666;
     text-align: right;
   }
   strong{
     color: #eb002a;
     font-weight: 700;
     font-family: Verdana;
   }
</style>
<script>

export default {
  name: 'cinema',

  data(){
    return {
      Area: [],
      cinema:[],
      currentNumber: 0,
      num:0,
      isActive:true,
      isCurrent:false,
      showNum:0,
      cinemaname:"",
      movieId:"",
      cinemaMessage:[],
      gridData: [
        {
          showTime: '2016-05-02',
          hallName: '王小虎',
          price: '2222222',
          use:"",
          title:""
        }
      ],
      dialogTableVisible:false,

    }
  },
  mounted() {

    //显示地区
    this.$ax.get("/queryArea").then((respone) => {
      if(respone.data.success){
        this.Area = respone.data.data;
      }else {
        this.$notify({
          title: '查询失败',
          message:response.data.message,
          type: 'error',
          duration:1000
        })
      }
      //挂载开始就查询全部区域
      this.queryAll();
    })
  },
  methods:{
    //显示全部区域影院
    queryAll () {
      this.movieId = this.$route.query.movieId;
      console.log(this.movieId)
      this.$ax.get("/queryCinema",{params:{"movieId":this.movieId}}).then((response) => {
        if(response.data.success){
          this.cinema = response.data.data;
        }else {
          this.$notify({
            title: '查询失败',
            message:response.data.message,
            type: 'error',
            duration:1000
          })
        }
      })
      this.isActive = true;
      this.currentNumber = 0;
    },
    //选择地区
    queryArea(id,event,index){
      this.$ax.get("/queryCinema",{params:{"movieId":this.movieId,"areaId":id}}).then((respone) => {
        if(respone.data.success){
          this.cinema = respone.data.data;
        }else {
          this.$notify({
            title: '查询失败',
            message:response.data.message,
            type: 'error',
            duration:1000
          })
        }
      })
      this.currentNumber = index+1;
      this.isActive = false;

    },
    //选择地区更改样式
    currentClass(index) {
        if(this.currentNumber!=0){
          return [this.currentNumber == index+1 ? 'active' : ''];
        }else {
          return '';
        }
    },
    //显示购买按钮
    show(i){
      this.showNum = i;

    },
    hide(i){
      this.showNum = i;

    },
    currentStyle(i){
      return [this.showNum == i ? 'current' : ''];
    },
    //搜索框
    serch(){

      this.$ax.get("/queryCinema",{params:{"movieId":this.movieId,"cinemaName":this.cinemaname}}).then(response => {
        if(response.data.success){
          this.cinema = response.data.data;
        }else {
          this.$notify({
            title: '查询失败',
            message:response.data.message,
            type: 'error',
            duration:1000
          })
        }
        this.isActive = true;
        this.currentNumber = 0;
      })
    },

    //选厅
    buyTicket(cinemaId){
      this.dialogTableVisible = true;
      this.$ax.get("/queryCinemaBycinemaId",{params:{"cinemaId":cinemaId,"movieId":this.movieId}}).then(response => {
        if(response.data.success){
          this.gridData = response.data.data;
          console.log(this.gridData)
        }else {
          this.$notify({
            title: '查询失败',
            message:response.data.message,
            type: 'error',
            duration:1000
          })
        }
      })

      },
  //  选座
      selection(row){
        this.cinemaMessage = row;
        console.log(this.cinemaMessage)
        this.$router.push({path:"/seat",query:{cinema:this.cinemaMessage}});
      },
// row[column.property] 能读取到该行该列的数据。代码中实现了时间格式的转换
    formatTime(row, column) {
      const date = new Date(row[column.property])
      return date.getFullYear() + '年' +
          date.getMonth() + '月' +
          date.getDate() + '日 ' +
          date.getHours() + ':' +
          date.getMinutes()
    }
  }

}
</script>