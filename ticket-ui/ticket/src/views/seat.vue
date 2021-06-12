<template>
  <div>
    <div class="box" style="width:800px ">
      <div id="room">
        <div class="row" style="margin-left:15%; ">
          <div style="margin-left: 20px;">
            <div class="sit bg-sit"></div>
            <div>可选座位</div>
          </div>
          <div style="margin-left: 20px;">
            <div class="sit bg-sited"></div>
            <div>已售座位</div>
          </div>
          <div style="margin-left: 20px;">
            <div class="sit bg-temp"></div>
            <div>已选座位</div>
          </div>
        </div>
        <div class="row" style="width: 100%;text-align: center;">
                    <span>
							银幕中央
						</span>
          <hr style="width: 90%;">
        </div>
        <div v-for="(item,i) in list" class="row" style="margin-left: 5px ; ">
          <div class="sit bg-nosit" style="margin-right:8px">{{i+1}}</div>
          <div @click="selectSeat(item1,i,j)" :class="['sit',{'bg-temp':item1==3},{'bg-sited':item1==2},{'bg-sit':item1==1},{'bg-nosit':item1==0}]" v-for="(item1,j) in item">
          </div>
        </div>
      </div>
      <div class="win-right">
        <div class="row">
          <div>
            <img class="film-img" :src="filmSession.filmImg" alt="">
          </div>
          <div>
            <div class="row film-title">{{filmSession.filmName}}</div>
            <div class="row">类型：{{filmSession.filmType}}</div>
            <div class="row">时长：120分钟</div>
          </div>
        </div>
        <div class="row">
          <span>影院：</span>
          <span>{{cinemaMessage.cinemaName}}</span>
        </div>
        <div class="row">
          <span>影厅：</span>
          <span>{{cinemaMessage.hallName}}</span>
        </div>
        <div class="row">
          <span>场次：</span>
          <span>{{cinemaMessage.showTime|time}}</span>
        </div>
        <div class="row">
          <span>票价：</span>
          <span>￥{{cinemaMessage.price|price}}</span>
        </div>
        <div class="row">
          <div>座位：</div>
          <div v-for="sit in msg">
            <div>
              <div class="select-sit">{{sit|f3}}</div>
            </div>
          </div>
        </div>

        <div class="row">
          <span>总价：</span>
          <span style="font-size: 25px;color: red;font-weight: 900;">￥{{cinemaMessage.price*msg.length|price}}</span>
        </div>
        <div class="row">
          <button type="button" class="btn" @click="sub">确认选座</button>
        </div>
      </div>
    </div>
  </div>

</template>
<script>
export default {
  name:"seat",
  data(){
    return{
      filmSession: {
        //放映点名称
        svname: "花语影院",
        //放映点地址
        svaddress: "5号放映厅",
        //开始时间
        fstartTime: new Date(),
        filmName: "订单信息",
        filmType: "科幻",
        filmImg: "../src/assets/logo.png",
        filmPrice: 33.50,
        // 座位状态数组



      },
      list: [
        [1, 1, 2, 2, 1, 0, 1, 2, 1, 1],
        [1, 1, 2, 2, 1, 2, 1, 2, 1, 0],
        [1, 1, 2, 2, 1, 0, 1, 2, 1, 1],
        [1, 1, 2, 0, 1, 0, 1, 2, 1, 1],
        [0, 1, 2, 2, 1, 0, 1, 2, 1, 2],
        [0, 1, 2, 2, 1, 0, 1, 2, 1, 0],
        [0, 1, 2, 2, 1, 2, 1, 2, 1, 1],
        [1, 1, 2, 2, 1, 2, 1, 2, 1, 0],
        [1, 1, 2, 2, 1, 1, 1, 2, 1, 0],
        [1, 1, 2, 2, 1, 1, 1, 2, 1, 0]
      ],
      // 已选座位数
      msgCount: 0,
      // 选座信息
      msg: [],
      cinemaMessage:[],
        form:{
            userId: '',
            showmovieId:'',
            amount:'',
            seat:''

        }
    }
  },
  methods: {
    // 选座时触发
    selectSeat(data, x, y) {
      if (data == 1 && this.msgCount <= 3) {
        this.$set(this.msg, this.msgCount++, [x, y]);
        this.list[x][y] = 3;
      } else if (data == 3) {
        // 用于记录要删除的座位下标
        var temp = null;
        for (var i = 0; i < this.msg.length; i++) {
          if (this.msg[i][0] == x && this.msg[i][1] == y) {
            temp = i;
            break;
          }
        }
        this.msgCount--;
        this.$delete(this.msg, temp);
        this.list[x][y] = 1;
      } else {
        if (this.msgCount == 4) {
          this.$notify({
            title: '警告',
            message: '最多只能订四张票',
            type: 'warning'
          });
        }
      }
    },

    // 确认选座时触发
    sub() {
      var x, y;
      var t='';
      for (var i = 0; i < this.msg.length; i++) {
        x = this.msg[i][0];
        y = this.msg[i][1];
        this.$set(this.list, 'x,y', 2);
        this.list[x][y] = 2;
        t+=x + "排  " + y + "座";
      };
      // this.$ax.post("addorder",{
      //
      //   params: {
      //     userId: '1',
      //     showmovieId:this.cinemaMessage.movieId,
      //     amount:this.cinemaMessage.price*this.msg.length,
      //     seat:t
      //   }
      // };

      let formData = new FormData();
      // if(!sessionStorage.getItem("UserId")){
      //   this.$router.push({path:"/login"})
      // }
      formData.append("msg", this.msg);
      console.log(formData);
      this.$ax.put("updseats",formData);
        this.form.userId=sessionStorage.getItem("UserId");
        this.form.showmovieId=this.cinemaMessage.movieId;
        this.form.amount=this.cinemaMessage.price*this.msg.length;
        this.form.seat=t
        this.$ax.post("addorder",this.form
        ).then((response)=>{
            let OrderId = response.data.data
            this.$router.push({path:"/Order",query:{seatNum:OrderId}})
        })

    }
  },
  mounted(){
    this.cinemaMessage=this.$route.query.cinema;
    console.log(this.cinemaMessage.hallId);
    this.$ax.get("seats/"+this.cinemaMessage.hallId).then((response)=>{
      this.list=response.data
    }).catch((error)=>{
      console.error(error);
    })
  },

  // 过滤器
  filters: {
    // 选座信息过滤器
    f3(data) {
      return (data[0] + 1) + "排 | " + (data[1] + 1) + "座";
    },
    // 日期过滤器
    time(data) {
      var date = new Date(data);
      var month = date.getMonth() + 1;
      var day = date.getDate();
      var hours = date.getHours() > 9 ? date.getHours() : ("0" + date.getHours());
      var minutes = date.getMinutes() > 9 ? date.getMinutes() : ("0" + date.getMinutes());
      return month + "月" + day + "日  " + hours + ":" + minutes;
    },
    // 价格过滤器,数字保留两位小数
    price(data) {
      var price = parseFloat(data);
      return price.toFixed(2);
    }
  }
};
</script>
<style scoped>
body {
  margin: 0;
  padding: 0;
  height: 100%;
}

#app div {
  /* border: 1px solid black; */
  float: left;
}

#room {
  /* width: 300px; */
  width: 60%;
  border: 1px solid black;
  padding: 20px 20px 20px 20px;
}

.sit {
  height: 35px;
  width: 35px;
  min-height: 10px;
  min-width: 10px;
  margin: 4px 4px 4px 4px;
  background-size: cover;
  /* border: 1px solid black; */
}
/* 座位 */

.bg-sit {
  background-image: url('../assets/sit.png');
}

.bg-sit:hover {
  cursor: pointer;
}
/* 已售座位 */

.bg-sited {
  /* background-color: red; */
  background-image: url('../assets/nosit.png');
}
/* 已选座位 */

.bg-temp {
  cursor: pointer;
  background-image: url('../assets/csit.png');
}
/* 已选座位号 */

.select-sit {
  border: 2px orange solid;
  border-radius: 10px;
  margin-left: 10px;
  padding: 4px 10px 4px 10px;
  background-color: red
}

.row {
  /* 清除格式并换行 */
  clear: both;
}
/* 确认选座按钮 */

.btn {
  border-radius: 10px;
  width: 200px;
  height: 50px;
  /* padding: 4px 10px 4px 10px; */
  background-color: red;
  font-size: 25px;
  color: white;
  font-family: '微软雅黑';
}
/* 右侧信息栏 */

.win-right {
  padding-left: 2%;
  padding-top: 2%;
  width: 27%;
  background-color: rgba(112, 112, 112, 0.2);
  border: 1px white solid;
  height: 100%;
}
/* 整体容器 */

.box {
  width: 90%;
  margin-left: 5%;
  height: 64%;
}
/* 电影封面 */

.film-img {
  width: 80%;
}
/* 电影名 */

.film-title {
  font-family: "微软雅黑";
  font-weight: 900;
  font-size: 25px;
}

#app {
  height: 100%;
}
</style>