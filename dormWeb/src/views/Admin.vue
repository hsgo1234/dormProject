<!-- 管理系统 -->
<template>
    <div id="system">
        <!-- 导航 -->
        <div id="systembar">
            <div id="systembartitle"><img style="height:2vw;" src="../assets/dorm.png"/><span>&nbsp;&nbsp;青岛大学公寓管理系统</span></div>
            <div id="systembarsetup"><i class="fa fa-bell-o"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-power-off"></i><i id="systembarreddot">12</i></div>
        </div>

        <!-- 菜单 -->
        <div id="systemmenu">
            <!-- 时间 -->
            <div id="systemmenutime">
                <div style="position: relative;top:2vw;">
                <p id="systemmenutimehour" style=""></p>
                <p id="systemmenutimeday"></p>
                </div>
            </div>
            <!-- 菜单 -->
            <div id="systemmenucontent">
                <router-link to="/overview"><div @click="menuclick0=1" :class="{systemmenuactive : 1===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;公寓概况</span></div></router-link>
                <router-link to="/accmanage"><div @click="menuclick0=2" :class="{systemmenuactive : 2===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;门禁检测</span></div></router-link>
                <router-link to="/dormmanage"><div @click="menuclick0=3" :class="{systemmenuactive : 3===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;公寓管理</span></div></router-link>
                <router-link to="/stumanage"><div @click="menuclick0=4" :class="{systemmenuactive : 4===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;学生管理</span></div></router-link>
                <router-link to="/loginmanage"><div @click="menuclick0=5" :class="{systemmenuactive : 5===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;登录信息</span></div></router-link>
                <router-link to="/visrecords"><div @click="menuclick0=6" :class="{systemmenuactive : 6===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;访客记录</span></div></router-link>
                <router-link to="/bedmanage"><div @click="menuclick0=7" :class="{systemmenuactive : 7===menuclick0}" class="systemmenucontent"><i class="fa fa-cogs"></i><span>&nbsp;&nbsp;归寝管理</span></div></router-link>
            </div>
        </div>

        <!-- 内容 -->
        <div id="systemcontent">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
window.onload = function(){
    showtime();
}

function checktime(i){
    if(i<10){
        i="0"+i;
    }
    return i;
}

function showtime(){
    var now = new Date();
    // var year=now.getFullYear();
    var month=now.getMonth()+1; //js获取的月份是从0开始；
    var day=now.getDate();
    var h=now.getHours();
    var m=now.getMinutes();
    // var s=now.getSeconds();
    m=checktime(m);
    // s=checktime(s);

    var weekday=new Array(7)
    weekday[0]="星期日"
    weekday[1]="星期一"
    weekday[2]="星期二"
    weekday[3]="星期三"
    weekday[4]="星期四"
    weekday[5]="星期五"
    weekday[6]="星期六"
    var w=weekday[now.getDay()]; //js获取的星期是0~6,0是星期天
    document.getElementById("systemmenutimehour").innerHTML=+h+" : "+m;
    document.getElementById("systemmenutimeday").innerHTML=month+"月"+day+"日 "+w;
    setTimeout(() => {
        showtime();
    }, 1000);
}

export default {
    data:function() {
        return {
            date:new Date(),
            menuclick0:0
        }
    }
}
</script>


<style scoped>
    #system{
        height: 60vw;
         background-color: #070F24;
    }
    #systembar{
        background-color: #161E33;
        height: 3vw;
        color: white;
    }
    #systembartitle{
        position: absolute;
        left: 2vw;
        top: 0.2vw;
        align-items:Center; 
        font-size: 1vw;
    }
    #systembarsetup{
        position: absolute;
        right: 2vw;
        height: 3vw;
    }
    #systembarsetup .fa{
        font-size: 1.5vw;
        line-height: 3vw;
    }
    #systembarreddot{
        background-color: #BE4C51;
        color: white;
        border-radius: 100%;
        font-size: 0.8vw;
        padding: 0.1vw;
        padding-right: 0.4vw;
        position: absolute;
        top: 0.2vw;
        right: 2vw;;
    }
    #systemmenu{
        position: absolute;
        top: 3vw;
        width: 14vw;
        height: 57vw;
        background-color: #030A1D;
    }
    #systemmenutime{
        position: relative;
        height: 8vw;
        width: 14vw;
        color: #AFB5CB;
        font-family:fantasy;
        font-size: 1.2vw;
        line-height: 2vw;
    }
    #systemmenutime p{
        margin: 0 0;
        padding: 0 0;
    }

    #systemcontent{
        position: absolute;
        top: 3vw;
        left: 14vw;
        height: 57vw;
        width: 83vw;
    }
    #systemmenucontent a{
        text-decoration: none;
        color: #AFB5CB;
        font-size: 1vw;
    }
    .systemmenuactive{
        background-color: #3648B4;
    }
    .systemmenucontent{
        padding-right: 3vw;
        height: 3vw;
        line-height: 3vw;
        font-family:Georgia, 'Times New Roman', Times, serif
    }
</style>
