import Vue from "vue";
import Index from "./Index.vue";
import router from "./router";
import store from "./store";
import "./plugins/component"
import './plugins/element.js'
import "./plugins/resource.js"

Vue.config.productionTip = false;


new Vue({
  router,
  store,
  render: h => h(Index)
}).$mount("#app");
