<template>
    <div style="width: 100%;height: 100%;">
        <div class="manage-nav" style="height: 8%">
            <el-row type="flex" class="row-bg">
                <el-col :span="3"><router-link :to="{ path: '/dormmanage/plantwo',query:{dormname: '浮山公寓'}}"><div @click="isclick=1" :class="{menuSelected: isclick==1}" class="grid-content bg-purple"><span>浮山公寓</span></div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/dormmanage/PlanTwo',query:{dormname: '鸿园'}}"><div @click="isclick=2" :class="{menuSelected: isclick==2}" class="grid-content bg-purple">鸿园</div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/dormmanage/planTwo',query:{dormname: '滢园'}}"><div @click="isclick=3" :class="{menuSelected: isclick==3}" class="grid-content bg-purple">滢园</div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/dormmanage/planTwo',query:{dormname: '浩园'}}"><div @click="isclick=4" :class="{menuSelected: isclick==4}" class="grid-content bg-purple">浩园</div></router-link></el-col>
            </el-row>
        </div>
        <div style="height: 92%;">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
    export default {
        name: "DormManage",
        data(){
            return{
                isclick:0
            }
        }
    }
</script>

<style scoped>
    .manage-nav a{
        text-decoration: none;
        color: #fff;
        font-size: 1vw;
    }
    .bg-purple {
        background: #161e33;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 2.1vw;
        line-height: 2.1vw;
        margin-left: 1vw;
    }
    .row-bg {
        padding: 1vw;
        color: #fff;
        font-size: 1vw;
    }
    .menuSelected{
        background-color: #4D4F52;
    }
</style>