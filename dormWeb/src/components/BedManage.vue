<template>
    <div><div style="width: 100%;height: 100%;">
        <div class="manage-nav" style="height: 8%">
            <el-row type="flex" class="row-bg">
                <el-col :span="3"><router-link :to="{ path: '/BedManage/planSix',query:{dormname: '浮山公寓'}}"><div @click="isclick=1" :class="{menuSelected: isclick==1}" class="grid-content bg-purple"><span>浮山公寓</span></div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/BedManage/planSix',query:{dormname: '鸿园'}}"><div @click="isclick=2" :class="{menuSelected: isclick==2}" class="grid-content bg-purple">鸿园</div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/BedManage/planSix',query:{dormname: '滢园'}}"><div @click="isclick=3" :class="{menuSelected: isclick==3}" class="grid-content bg-purple">滢园</div></router-link></el-col>
                <el-col :span="3"><router-link :to="{ path: '/BedManage/planSix',query:{dormname: '浩园'}}"><div @click="isclick=4" :class="{menuSelected: isclick==4}" class="grid-content bg-purple">浩园</div></router-link></el-col>
            </el-row>
        </div>
        <div style="height: 92%;">
            <router-view></router-view>
        </div>
    </div></div>
</template>

<script>
    export default {
        name: "BedManage",
        data(){
            return{
                isclick:0
            }
        }
    }
</script>

<style scoped>

</style>