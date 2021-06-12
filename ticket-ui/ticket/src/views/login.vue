<template>
  <div class="login" clearfix>
    <div class="login-wrap">
      <el-row type="flex" justify="center">
        <el-form ref="loginForm" :model="user" status-icon label-width="80px">
          <h3>登录</h3>
          <hr>
          <el-form-item prop="username" label="用户名">
            <el-input v-model="user.username" placeholder="请输入用户名" prefix-icon></el-input>
          </el-form-item>
          <el-form-item id="password" prop="password" label="密码">
            <el-input v-model="user.password" show-password placeholder="请输入密码"></el-input>
          </el-form-item>
          <router-link to="/">找回密码 </router-link>
          <router-link to="/register">注册账号</router-link>
          <el-form-item>
            <el-button type="primary" icon="el-icon-upload" @click="doLogin()">登 录</el-button>
          </el-form-item>
        </el-form>
      </el-row>

    </div>
  </div>
</template>
 
<script>
export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: ""
      }  
    };
  },
  methods: {
    doLogin() {
      if (!this.user.username) {
        this.$message.error("请输入用户名！");
        return;
      } else if (!this.user.password) {
        this.$message.error("请输入密码！");
        return;
      } else {
        this.$ax.get("/login",{params:{
            "username":this.user.username,
            "password":this.user.password
          }})
          .then(response=>{
            if (response.data.success) {
              sessionStorage.setItem("UserId",response.data.data.userId);
              this.$router.push({ path: '/Home'});
            } else {
              alert("您输入的用户名或密码错误！");
            }
          });
      }
    }
  }
};
</script>
 
<style scoped>
.login {
  width: 100%;
  height: 890px;
  background: url("../assets/loginbg.png") no-repeat;
  background-size: cover;
  overflow: hidden;
}
.login-wrap {
  background: url("../assets/loginw.png") no-repeat;
  background:rgba(255, 255, 255, 0.5);
  background-size: cover;
  width: 400px;
  height: 400px;
  margin: 215px auto;
  overflow: hidden;
  padding-top: 10px;
  line-height: 40px;
}
#password {
  margin-bottom: 5px;
}
h3 {
  color: #0babeab8;
  font-size: 24px;
}
hr {
  background-color: rgb(99, 96, 124);
  margin: 20px auto;
}
a {
  text-decoration: none;
  color: #388aef;
  font-size: 15px;
}
a:hover {
  color: coral;
}
.el-button {
  width: 80%;
  margin-left: -50px;
}
</style>