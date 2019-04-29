<template>
    <div style="width: 100%;height: 100%">
        <el-row type="flex" justify="space-around">
            <el-col :span="17" style="height: 36vw;background-color: #030a1d;border-radius: 4px;">
                <el-table
                    :data="BedData"
                    style="width: 100%"
                    border
                    height="36vw">
                    <el-table-column
                            prop="beddate"
                            label="时间"
                            width="200">
                    </el-table-column>
                    <el-table-column
                            prop="stuname"
                            label="姓名">
                    </el-table-column>
                    <el-table-column
                            prop="bedtype"
                            label="打卡/请假（1/0）">
                    </el-table-column>
                    <el-table-column
                            prop="dormname"
                            label="公寓">
                    </el-table-column>
                    <el-table-column
                            prop="stuid"
                            label="学号">
                    </el-table-column>
                </el-table>
            </el-col>
            <el-col :span="6" style="height: 36vw;background-color: #030a1d;">
                <el-date-picker
                    style="margin-top: 1vw"
                    v-model="mydatepicaker"
                    type="date"
                    format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd"
                    placeholder="选择日期"
                    @change="changedate">
                </el-date-picker>
                <div>
                    <p style="font-size: 1.5vw;color: #909399">未归寝学生名单</p>
                    <el-tag
                            v-for="item in NoBedStu"
                            :key="item.stuid"
                            type="info"
                            size="medium"
                            @click="clickContact(item)"
                            style="width: 5vw;height: 3vw;font-size: 1.2vw;line-height: 3vw;margin: 0.5vw;">
                        {{item.stuname}}
                    </el-tag>
                    <p style="margin-left: 10vw;font-size: 1vw;color: #BE4C51;">点击标签联系</p>
                </div>
            </el-col>
        </el-row>
        <el-row justify="center">
            <el-col :span="21" style="height: 13vw;background-color: #030a1d;margin-top: 1vw;">
                <el-table :data="ContactStu" style="width: 100%;margin-top: 1.5vw">
                    <el-table-column prop="stuid" label="ID"></el-table-column>
                    <el-table-column prop="stuname" label="姓名"></el-table-column>
                    <el-table-column prop="roomid" label="房间ID"></el-table-column>
                    <el-table-column prop="stutel" label="电话"></el-table-column>
                    <el-table-column prop="stumail" width="160" label="邮箱"></el-table-column>
                    <el-table-column prop="stuins" label="学院"></el-table-column>
                    <el-table-column prop="studep" label="系"></el-table-column>
                    <el-table-column prop="stuclass" label="班级"></el-table-column>
                </el-table>
            </el-col>
            <el-col :span="3" style="height: 13vw;background-color: #030a1d;margin-top: 1vw;line-height: 13vw;">
                <el-popover
                        placement="left-end"
                        width="30vw"
                        v-model="visible">
                    <div style="width: 50vw;height: 30vw">
                            <p>收件人:{{ContactStu[0].stumail}}({{ContactStu[0].stuname}})</p>
                            <p>主题：</p>
                            <p><el-input v-model="ContactForm.theme"></el-input></p>
                            <p><el-input v-model="ContactForm.content" type="textarea" :autosize="{minRows:9,maxRows:9}"></el-input></p>
                            <p>
                                <el-button @click="SendMail" type="success">发送</el-button>
                                <el-button @click="visible = false" type="text">取消</el-button>
                            </p>
                    </div>
                    <el-button slot="reference" >填写邮件</el-button>
                </el-popover>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "PlanSix",
        data(){
            return{
                BedData:[],
                LocalBedData:[],
                DormData:[],
                StuData:[],
                NoBedStu:[],
                ContactStu:[{stumail:"",stuname:""}],
                ContactForm:{
                    from:"",
                    to:"",
                    theme:"来自“青岛大学宿舍管理系统”的来信",
                    content:"尊敬的这位同学，今天是不是忘记归寝打卡了？"
                },
                visible:false,
                mydatepicaker:""
            }
        },
        computed: {
            dormname() {
                return this.$route.query.dormname
            }
        },
        watch: {
            dormname() {
                this.queryBed();
                this.queryDorm();
                this.queryStu();
                this.timeout = setTimeout(() => {
                    this.selectNoBed()
                }, 500);
            }
        },
        methods:{
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
            changedate(datepicker){
                this.BedData = datepicker? this.LocalBedData.filter(data =>data.beddate.includes(datepicker)) :this.LocalBedData
                this.selectNoBed()
            },
            clickContact(item){
                this.ContactStu = []
                this.ContactStu.push(item);
            },
            SendMail(){
                this.ContactForm.to = this.ContactStu[0].stumail;
                this.$http.post("http://localhost:8090/sendmail",this.ContactForm).then(response => {
                    if (response.bodyText== "success") {
                        this.visible = false;
                        this.$message({
                            message: '恭喜您，发送成功',
                            type: 'success'
                        });
                    }else {
                        this.visible = false;
                        this.$message.error('错了哦，这是一条错误消息');
                    }
                }, response => {
                    console.log("error" + response.data)
                    this.visible = false;
                    this.$message.error('错了哦，这是一条错误消息');
                })
            }
        },
        mounted() {
            this.queryBed()
            this.queryDorm()
            this.queryStu()
            this.timeout = setTimeout(() => {
                this.selectNoBed()
            }, 500);
        }
    }
</script>

<style scoped>
    .el-table {
        background-color: #030a1d;
    }
</style>