
<template>
<div class="MovieDetail">
<el-row>
<el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
  <el-card :body-style="{ padding: '0px' }">
    <img :src=form.poster class="image">
    <div style="padding: 14px;">
      <p>影片名：{{form.title}}</p>
      <p>年份：{{form.year}}</p>
      <p>语言：{{form.languages}}</p>
      <p>时长：{{form.duration}}</p>
      <p>描述{{form.summary}}</p>
      <div class="bottom clearfix">
        <el-button type="text" class="button" @click="start">开始购票</el-button>
      </div>
    </div>
  </el-card>
</el-col>
</el-row>
</div>
</template>

<style>

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>

<script>
export default {
  name: 'MovieDetail'
}
</script>

<script>


export default {
  name:"MovieDetail",
  data() {
    return {
      form: {
        movieId:'',
        poster:'',
        title:'',
        year:'',
        languages:'',
        duration:'',
        summary:''
      }
    };

  },
  methods:{
    start(){
       this.$router.push({path: "/cinema", query: {movieId: this.form.movieId}})
    }
  },
  mounted() {
    console.log(this.$route.query.movie);
    this.form=this.$route.query.movie;
    // this.$ax.get('movie/'+ this.$route.query.movieId).then((response) => {
    //   this.form = response.data.data
    // }).catch((error) => {
    //   console.error(error)
    // })
  }
}
</script>