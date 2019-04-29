<template>
    <div>
        <el-timeline :reverse="true">
            <el-timeline-item
                    v-for="(visitor,index) in visitors.slice((currpage-1) * pagesize,currpage * pagesize)"
                    :key="index"
                    :timestamp="visitor.visdate"
                    placement="top">
                <el-card>
                    <p>
                        <span class="visimpo">{{visitor.visname}}</span> 因 <span class="visimpo">{{visitor.reason}}
                        </span> 拜访了 <span class="visimpo">{{visitor.stuname}}</span> 同学,
                        进入：<span class="visimpo">{{visitor.dormname}}</span>
                    </p>
                    <p>访问于：<span class="visimpo">{{visitor.visdate}}</span> 电话：<span class="visimpo">{{visitor.vistel}}</span></p>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <el-pagination
                style="margin-left: 12vw;"
                layout="prev, pager, next,sizes"
                background
                :page-sizes="[4,5, 10, 15, 20]"
                :page-size="pagesize"
                :total="visitors.length"
                @current-change="handleCurrentChange"
                @size-change="handleSizeChange">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "PlanFive",
        data(){
            return {
                visitors:"",
                currpage: 1,
                pagesize:4
            }
        },
        methods:{
            queryVisitors() {
                const url = "http://localhost:8090/selectVisitors?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.visitors = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            handleCurrentChange(changepage){
                this.currpage =changepage
            },
            handleSizeChange(changesize){
                this.pagesize = changesize
            }
        },
        mounted(){
            this.queryVisitors()
            setTimeout(() => {
                this.reverse = 1
            }, 100);
        },
        computed: {
            dormname() {
                return this.$route.query.dormname
            }
        },
        watch: {
            dormname() {
                this.queryVisitors();
            }

        }
    }
</script>

<style scoped>
    .visimpo{
        font-size: 17px;
        color:#b3e19d;
    }
</style>