import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'; //导入elementui
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import Video from 'video.js';
import 'video.js/dist/video-js.css';
axios.defaults.baseURL="http://localhost:9999"
//绑定到vue的原型，方便全局引用
Vue.prototype.$ax = axios;
Vue.config.productionTip = false
Vue.prototype.$video = Video
//安装elementUI
Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')