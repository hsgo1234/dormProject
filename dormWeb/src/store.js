import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    screenporps: {
      screenwidth: window.innerWidth,
      screenheight: window.innerHeight
    },
    loginfo:{
      username: "",
      password: "",
      state: 0
    }
  },
  mutations: {
    screenporpschange() {
      this.state.screenporps.screenwidth = window.innerWidth;
      this.state.screenporps.screenheight = window.innerHeight;
    },
    login(loginfo,formdata){
      this.state.loginfo.username=formdata.username;
      this.state.loginfo.password=formdata.password;
      this.state.loginfo.state=1;
    }

  },
  actions: {}
});

