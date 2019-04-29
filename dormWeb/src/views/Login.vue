<!-- 登陆 -->
<template>
    <div id="login">
        <!-- 上条 -->
        <div id="logintop" v-bind:style="{height:(screenporps.screenwidth)*2.5/16+'px'}"></div>
        <!-- 中间条 -->
        <div id="logincenter" v-bind:style="{height:(screenporps.screenwidth)*2.5/16+'px'}">
            <!-- 欢迎语 -->
            <div>
                <img id="loginimg" v-bind:style="{height:(screenporps.screenwidth)*1.2/16+'px'}" src="../assets/porm.png"/>
                <img id="loginimg2" v-bind:style="{height:(screenporps.screenwidth)*0.4/16+'px',left:(screenporps.screenwidth)*4.4/16+'px',top:(screenporps.screenwidth)*4.1/16+'px'}" src="../assets/live.png"/>
            </div>
            <!-- 登录窗口 -->
            <div id="loginform" v-bind:style="{left:(screenporps.screenwidth)*8/16+'px',top:(screenporps.screenwidth)*3.1/17+'px'}">
                <p><span style="color:#C0F5F9">username : </span><input v-on:keyup.enter="login" type="text" name="username" v-model="formdata.username"></p>
                <p><span style="color:#C0F5F9">password : </span><input v-on:keyup.enter="login" type="password" name="password" v-model="formdata.password"></p>
                <button id="loginbutton" @click="login" v-bind:style="{left:(screenporps.screenwidth)*3.5/16+'px',top:(screenporps.screenwidth)*0.15/20+'px'}">login</button>
            </div>
        </div>
        <!-- 下条 -->
        <div id="loginbottom" v-bind:style="{height:(screenporps.screenwidth)*2.5/16+'px'}"></div>
    </div>
</template>

<script>
// 获取store中屏幕宽高
import {mapState} from "vuex"                                             
export default {
    name: "login",
    data: function() {
      return {
          formdata:{
              usertype:"admin",
              username:"",
              password:""
          }
      }
    },
    methods:{
        login(){
            this.$http.post("http://localhost:8090/login",this.formdata).then(response =>{
                var result = response.bodyText;
                if (result=="success"){
                    console.log("good")
                    this.$store.commit("login",this.formdata);
                }
            },response =>{
                console.log("error"+response)
            })
        }
    },
    computed:mapState({
        screenporps:state => state.screenporps
    })
    };
</script>
<style scoped>
#logintop,#loginbottom{
    background-color:#0076a4;
}
#logincenter{
    background-color: #005687;
    display: flex;
    justify-content:center;
    align-items:Center; 
}
#loginform{
    position:absolute;
    font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    font-size: 1vw;
}
#loginform input{
    width: 14vw;
    height: 1.3vw;
    border-radius: 4px;
    border:none; 
    padding-left: 3px;
}
#loginimg2{

    position:absolute;
}
#loginbutton{
    position: absolute;
    width: 4vw;
    height: 4.5vw;
    background-color: #38AECA;
    border: none;
    border-radius: 4px;
    color: white;
    font-size: 1vw;
}
</style>
