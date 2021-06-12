<template>

  <div class="home">
     
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark"></div></el-col>
    </el-row>

  <div id="a">
    <div class="b"></div>
    <div class="c">
     <template>
     <video id="myVideo" class="video-js">
     <source 
     src="../assets/wow.mp4" 
     type="video/mp4"
     ></video>
     </template>
    </div>
    <div class="d"></div>
  </div>

    
     <div id="a3">
       <div class="c3"></div>
       <div class="b3">
       <span class="textcolor_bule"><h1>人气热门：</h1></span>
       </div>
       </div>
       

    <el-carousel :interval="4000" type="card" height="600px">
      <el-carousel-item v-for="item in imagesbox" :key="item.id">
        <img :src="item.idView" calss="image">
      </el-carousel-item>
    </el-carousel>
   
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark"></div></el-col>
    </el-row>

<el-row>
<el-col :span="10" :push=2><div class="grid-content bg-purple">

<span class="panel-more">
<a href="/#/movies" class="textcolor_bule"><span>全部</span></a>
<i class="el-icon-arrow-right" style="color:#388aef"></i>
</span>

        <span class="textcolor_bule"><h2>正在热映(10部)</h2></span>
      </div></el-col>

<el-col :span="8" :push=4><div class="grid-content bg-purple-light">
  <span class="textcolor_bule"><h2>
  今日热榜:
  </h2></span></div></el-col>
</el-row>

<!--正在热映电影展示-->

<div class="movie-list">
<div class="panel">
  <div class="panel-content">
    <el-row class="el-row-e1">
      <div v-for="movie in list">
        <el-col :span="2.5" :push=4>
          <div class="grid-content bg-purple">
            <dd>
              <div class = "movie-item">
                <a href="javaScript:;" >
                  <div calss="movie-poster">
                    <img class="movie-poster-img" :alt="movie.title" :src="movie.poster">
                    <div class="movie-overlay movie-overlay-bg">
                      <div class="movie-info">
                        <div class="movie-score">
                          <i class="integer">9.</i>
                          <i class="fraction">9</i>
                        </div>
                        <div class="movie-title movie-title-padding" title="movie.title">{{movie.title}}</div>
                      </div>
                    </div>
                  </div>
                </a>
              </div>
              <div class="movie-detail movie-detail-strong movie-sale">
                <el-button type="primary" @click="detail(movie)">购票</el-button>
              </div>
            </dd>
          </div>
        </el-col>
      </div>
    </el-row>
</div>
</div>
</div>


<div id="a1">
      <div class="b1"></div>
      <div class="c1">
  <div class="block">
    <el-carousel height="450px">
      <el-carousel-item v-for="item in imagesbox2" :key="item.id2">
        <img :src="item.id2View" class="image">
      </el-carousel-item>
    </el-carousel>
  </div>
</div>
      <div class="d1"></div>
</div>

   
  </div>

</template>

<script>
import {} from '../static/canvas-nest.js';
export default {
  name: "Home",
  data() {
    return {
      imagesbox: [
        {
          id: 0, idView: require("../assets/gsd.png"),
        },
        {
          id: 1, idView: require("../assets/zrkd.png"),
        },
        {
          id: 2, idView: require("../assets/hhxd.png"),
        },
        {
          id: 3, idView: require("../assets/xzgjl.png"),
        },
        {
          id: 4, idView: require("../assets/jzy.png"),
        }
      ],
      imagesbox2:[
        {
          id: 0, id2View: require("../assets/组长.png"),
        },
        {
          id: 1, id2View: require("../assets/组员1.png"),
        },
        {
          id: 2, id2View: require("../assets/组员2.png"),
        },
        {
          id: 3, id2View: require("../assets/组员3.png"),
        },
      ],
      list: []
       
    }
  },
  methods: {
    initVideo(){
    let myPlayer = this.$video(myVideo,{
      controls: true,
      width:"1400px",
      height:"800px",
      preload:"auto",
      poster:require("../assets/wowlogo.png")
      
    })
    },


    detail(movie) {
      this.$router.push({path: "/MovieDetail", query: {movie: movie}})
    },
  },
  mounted() {
    this.initVideo();

    this.$ax.get("index").then((response) => {
      this.list = response.data.data
    }).catch((error) => {
      console.log(error)
    })
    
  },
  

}
</script>

<style scoped>

.el-row {
  margin-bottom: 20px;
  background: rgba(255, 255, 255, 0.2);
  
}
.el-row-e1{
  width: 50%;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #ffffff;
}
.bg-purple {
  background: #ffffff;
}
.bg-purple-light {
  background: #ffffff;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #3d62ac;
}

.panel-more{
  font-size:14px;
  line-height:16px;
  float:right;
  margin-top:10px;
}

.textcolor_bule{
  color: #388aef;
}

.movie-item{
  position: relative;
  border: 1px solid #efefef;
  border-top-color: rgb(239, 239, 239);
  border-top-style: solid;
  border-top-width: 1px;
  border-right-color: rgb(239, 239, 239);
  border-right-style: solid;
  border-right-width: 1px;
  border-bottom-color: rgb(239, 239, 239);
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-left-color: rgb(239, 239, 239);
  border-left-style: solid;
  border-left-width: 1px;
  border-image-source: initial;
  border-image-slice: initial;
  border-image-width: initial;
  border-image-outset: initial;
  border-image-repeat: initial;
  margin: -1px;
  margin-top: -1px;
  margin-right: -1px;
  margin-bottom: -1px;
  margin-left: -1px;
}

.movie-poster{
  background-color: #fcfcfc;
  width: 160px;
  height: 220px;
  overflow: hidden;
  position: relative;
}

.panel-content {
    overflow: hidden;
    width: 100%;
    margin-top: 23px;
}

.movie-poster .poster-default {
  top: 50%;
  left: 50%;
  width: 68px;
  height: 62px;
  margin-top: -31px;
  margin-left: -34px;
}
.movie-poster .movie-poster-img[src] {
  visibility: visible;
}

.movie-poster .movie-poster-img[src] {
  visibility: visible;
}

.movie-poster img {
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.movie-list dd {
  margin: 30px 0 0 30px;
  display: inline-block;
  vertical-align: top;
  position: relative;
}

.movie-sale a {
  display: block;
  color: #999;
  font-size: 14px;
}

.movie-poster .movie-overlay {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.movie-overlay-bg {
  
}

.movie-overlay .movie-info {
  color: #fff;
  position: absolute;
  bottom: 7px;
  width: 100%;
}

.movie-score {
  color: #ffb400;
  float: right;
  margin-right: 10px;
}
.movie-score .integer {
  font-size: 18px;
}
.movie-score .fraction {
  font-size: 14px;
}
.movie-title-padding {
  margin-right: 35px;
}
.movie-title {
  font-size: 16px;
  line-height: 22px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  margin: 0 10px;
}
.movie-detail-strong {
  height: 40px;
  line-height: 40px;
}
.movie-detail {
  height: 40px;
  line-height: 34px;
  text-align: center;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.movie-sale a.active {
  color: #388aef;
}

.movie-grid .panel {
    margin: 62px 0 0;
    width: 750px;
}
    .space {
        width: 100%;
        height: 100%;
        display: block;
        vertical-align: baseline;
        position: absolute;
        z-index: -5;
    }

#a{
       
        width:100%;
        height: 800px;
        display:flex;
}

.b{
        
        height: 800px;
        width: 250px;
        order: 0;
        background-image: url(../assets/wowL.png);
      
}

.c{
       
        width: 1400px;
        height: 800px;
        order: 1;
 }

.d{
        
        height: 800px;
        width: 250px;
        order: 2;
        background-image: url(../assets/wowr.png);
}

#a1{
  
        width:100%;
        height: 450px;
        display:flex;
        background: rgba(92, 88, 88,0.2);
}

.b1{
        
        height: 450px;
        width: 25%;
        order: 0;
        
      
}

.c1{
      
        height: 450px;
        width: 50%;
        order: 1;
 }

.d1{
        
        height: 450px;
        width: 25%;
        order: 2;
}

#a3{
  width:100%;
  height:50px;
  display:flex;
  background: rgba(255, 255, 255, 0.2);
}
.c3{
  order:0;
  width: 10%;
}

.b3{
  order:1;
}

</style>