<template>
    <div>
        <el-row type="flex" class="row-bg" justify="space-around">
            <el-col :span="12"><div class="grid-content bg-top">
                <div id="dormView" style="width: 100%;height: 100%"></div>
            </div></el-col>
            <el-col :span="6"><div class="grid-content bg-top">
                <p style="font-size: 1vw;margin: 0 0">请假学生名单</p>
                <el-table :data="LeaStu" height="90%">
                    <el-table-column prop="stuname" width="60vw" label="姓名"></el-table-column>
                    <el-table-column prop="beddate" label="请假时间"></el-table-column>
                </el-table>
            </div></el-col>
            <el-col :span="6"><div class="grid-content bg-top">
                <p style="font-size: 1vw;margin: 0 0">未归学生名单</p>
                <el-table :data="NoBedStu" height="90%">
                    <el-table-column prop="stuname" width="60vw" label="姓名"></el-table-column>
                    <el-table-column prop="stuins" label="学院"></el-table-column>
                    <el-table-column prop="stuclass" label="班级"></el-table-column>
                </el-table>
            </div></el-col>
        </el-row>

        <el-row class="row-bg">
            <el-col :span="24"><div class="grid-content grid-foot">
                <el-table :data="StuData" style="margin-top: 2vw" height="18vw">
                    <el-table-column prop="stuid" label="ID"></el-table-column>
                    <el-table-column prop="stuname" label="姓名"></el-table-column>
                    <el-table-column prop="roomid" label="房间ID"></el-table-column>
                    <el-table-column prop="stutel" label="电话"></el-table-column>
                    <el-table-column prop="stumail" width="160" abel="邮箱"></el-table-column>
                    <el-table-column prop="stuins" label="学院"></el-table-column>
                    <el-table-column prop="studep" label="系"></el-table-column>
                    <el-table-column prop="stuclass" label="班级"></el-table-column>
                </el-table>
            </div></el-col>
        </el-row>
    </div>
</template>

<script>
    import echarts from "echarts";
    export default {
        name: "PlanOne",
        data () {
            return {
                BedData:[],
                LocalBedData:[],
                DormData:[],
                StuData:[],
                NoBedStu:[],
                LeaStu:[],
                charts: ""
            }
        },
        computed: {
            dormname() {
                return this.$route.query.dormname
            }
        },
        methods: {
            drawPie(id){
                this.charts = echarts.init(document.getElementById(id))
                this.charts.setOption({
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['归寝','请假','未归']
                    },
                    series : [
                        {
                            name: '人数',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value:this.BedData.length, name:'归寝'},
                                {value:this.BedData.length, name:'请假'},
                                {value:this.NoBedStu.length, name:'未归'},
                            ],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                })
            },
             queryBed() {
                const url = "http://localhost:8090/selectBedByDormName?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.BedData = response.data
                    this.LocalBedData = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            queryDorm(){
                const url = "http://localhost:8090/selectDormByDormName?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.DormData = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            queryStu() {
                const url = "http://localhost:8090/selectStuByDormName?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.StuData = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            selectNoBed(){
                this.NoBedStu = this.StuData.filter(studata => {
                    let flag = 1;
                    this.BedData.forEach(beddata => {
                        if(beddata.stuid==studata.stuid){
                            flag = 0;
                        }
                    })
                    return flag
                })
            },
            selectLeaStu(){
                this.LeaStu = this.BedData.filter(date =>{
                    if (date.bedtype == "0"){
                        return true
                    } else {
                        return false
                    }
                })
            }
        },
        mounted() {
            this.queryBed()
            this.queryDorm()
            this.queryStu()
            this.timeout = setTimeout(() => {
                this.selectLeaStu();
                this.selectNoBed()
                this.timeout = setTimeout(() => {
                    this.$nextTick(function () {
                        this.drawPie("dormView")
                    })
                }, 500);
            }, 500);
        },
        watch: {
            dormname() {
                this.queryBed();
                this.queryDorm();
                this.queryStu();
                this.timeout = setTimeout(() => {
                    this.selectLeaStu();
                    this.selectNoBed()
                    this.timeout = setTimeout(() => {
                        this.$nextTick(function () {
                            this.drawPie("dormView")
                        })
                    }, 500);
                }, 500);
            }
        }
    }
</script>

<style scoped>
    .bg-top {
        height: 27vw;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 2.1vw;
        line-height: 2.1vw;
        margin-left: 1vw;
        background-color: #030a1d;
    }
    .grid-foot{
        min-height: 22vw;
    }
    .row-bg {
         padding:0.6vw 1vw;
         color: #fff;
         font-size: 1vw;
     }
    .el-table {
        background-color: #030a1d;
    }
</style>