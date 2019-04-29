<!-- 可视化视图 -->
<template>
    <div id="admincanvas" v-bind:style="{width:screenporps.screenwidth+'px'}">
        <div>
            <div style="position:absolute;left:3vw">
                <button class="adminnavbutton">实时数据</button><button class="adminnavbutton">全部信息</button>
            </div>
            <div id="admintitle">
                <p>公寓管理大数据平台</p>
                <p style="color:white;font-size:1vw;top:0.4vw;position:relative;">{{date}}</p>
            </div>
            <div id="adminauthor">
                <span>Powered by EDU</span>
            </div>
        </div>

        <div  v-bind:style="{width:screenporps.screenwidth+'px',height:(screenporps.screenheight)/3.0+'px'}">
            <div style="position:absolute;top:7vw;left:2vw;">
                <div class="frame"></div>
                <div style="margin-top:0.5vw;" class="frame"></div>
            </div>

            <div style="position:absolute;top:7vw;left:26vw;width:47vw;height:32vw;"></div>

            <div style="top:7vw;left:75vw;position:absolute">
                <div class="frame"></div>
                <div style="margin-top:0.5vw;" class="frame"> </div>
            </div>
        </div>

        <div id="adminbottom" style="position:absolute;top:40vw;" v-bind:style="{width:screenporps.screenwidth+'px',height:(screenporps.screenheight)/3.8  +'px'}">
            <div style="left:2vw;" class="frame"></div>
            <div style="left:26.3vw;" class="frame"></div>
            <div style="left:50.7vw;" class="frame"></div>
            <div style="left:75vw;" class="frame"></div>
        </div>
    </div>
</template>

<script>
import {mapState} from "vuex"                                             
import { setInterval, clearInterval } from 'timers';
export default {
    computed:mapState({
        screenporps:state => state.screenporps
    }),
    data:function(){
        return {
            date:Date()
    }
    },
    mounted(){
        let _this = this;
        this.timer = setInterval(()=>{
            _this.date = new Date();
        },1000)
    },
    beforeDestroy(){
        if(this.timer){
            clearInterval(this.timer)
        }
    }
}
</script>

<style scoped>
#admincanvas{
    height: 60vw;
    background-color: #061F3E;
}
.frame{
    width: 23vw;
    height: 16vw;
    background-image: url('../assets/Frame.png');
    background-size: 100%;
    background-repeat: no-repeat;
}
.adminnavbutton{
    width: 10vw;
    height: 5.6vw;;
    border: none;
    background-image: url('../assets/nav.png');
    background-size: 100%;
    background-repeat: no-repeat;
    font-size: 1vw;
    color: white;
    padding-top: 1.3vw;
}
#admintitle{
    position: absolute;
    left: 30vw;
    background-size: 100%;
    background-repeat: no-repeat;
    width:40vw;height:7vw;
    background-image: url('../assets/title.png');
    padding-top: 1.5vw;
    color:lightskyblue;
    font-size: 2.5vw;
}
#admintitle p{
    margin: 0 0;
}
#adminauthor{
    position: absolute;
    width: 15vw;
    height: 7vw;
    left:84vw ;
    background-image: url('../assets/power.png');
    background-repeat: no-repeat;
    background-size: 63%;
    display: flex;
    justify-content:center;
    align-items:Center; 
    color: white;
}
#adminauthor span{
    position: relative;
    font-size: 1.3vw;
    bottom: 0.7vw;
}
#adminbottom .frame{
    position: absolute;
}
</style>
