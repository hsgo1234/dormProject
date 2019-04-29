<template>
    <div>
        <div>
            <el-timeline :reverse="true">
                <el-timeline-item
                        v-for="(access,index) in accesss.slice((currpage-1) * pagesize,currpage * pagesize)"
                        :key="index"
                        :timestamp="access.accdate"
                        placement="top">
                    <el-card>
                        <p>
                            <span class="accimpo">{{access.stuname}}</span> 同学 <span class="accimpo">{{access.acctype}}</span>
                            了 <span class="accimpo">{{access.dormname}}</span>
                        </p>
                        <p>于：<span class="accimpo">{{access.accdate}}</span> </p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
            <el-pagination
                    style="margin-left: 12vw;"
                    layout="prev, pager, next,sizes"
                    background
                    :page-sizes="[5, 10, 15, 20]"
                    :page-size="pagesize"
                    :total="accesss.length"
                    @current-change="handleCurrentChange"
                    @size-change="handleSizeChange">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AccManage",
        data(){
            return {
                accesss:"",
                reverse:-1,
                currpage: 1,
                pagesize:5
            }
        },
        methods:{
            queryAccess() {
                const url = "http://localhost:8090/selectAccess"
                this.$http.post(url).then(response => {
                    this.accesss = response.data
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
            this.queryAccess()
            setTimeout(() => {
                this.reverse = 1
            }, 100);
        }
    }
</script>

<style scoped>
    .accimpo{
        font-size: 17px;
        color: lightskyblue
    }
</style>