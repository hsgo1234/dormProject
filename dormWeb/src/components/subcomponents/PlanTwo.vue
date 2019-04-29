<template>
    <div style="width: 100%; height: 100%;">
        <el-row>
            <el-col :span="24">
                <div class="grid-all grid-content">
                    <el-table
                            :data="dormdata"
                            border
                            style="width: 100%;"
                            height= "36vw">
                        <el-table-column
                                label="ID"
                                style="width: 16%">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormid"></el-input>
                                <span v-else>{{slotProps.row.dormid}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="名称"
                                style="width: 16%">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormname"></el-input>
                                <span v-else>{{slotProps.row.dormname}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="楼号"
                                style="width: 16%">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormno"></el-input>
                                <span v-else>{{slotProps.row.dormno}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="地址"
                                style="width: 16%">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormaddr"></el-input>
                                <span v-else>{{slotProps.row.dormaddr}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="容量"
                                style="width: 15%">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormcap"></el-input>
                                <span v-else>{{slotProps.row.dormcap}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="操作"
                                style="width: 15%">
                            <template v-slot="slotProps">
                                <el-button v-if="isEdit==slotProps.row"
                                           @click="updateRow()"
                                           type="info"
                                           size="mini">
                                    确认
                                </el-button>
                                <el-button v-else-if="updatefailed==slotProps.row.dormid"
                                           @click="editclick(slotProps.row)"
                                           type="warning"
                                           size="mini">
                                    失败
                                </el-button>
                                <el-button v-else
                                           @click="editclick(slotProps.row)"
                                           size="mini">
                                    编辑
                                </el-button>
                                <el-button type="danger"
                                           @click="deleteclick(slotProps.row)"
                                           size="mini">
                                    删除
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <div style="height: 4vw">
                        <div @click="showPlus" style="width: 10%;height: 100%;margin-left: auto;margin-right: auto;">
                            <i class="fa fa-plus-circle" style="margin-top:0.5vw;font-size: 2vw;color: white"></i>&nbsp;
                        </div>
                    </div>
                    <el-table v-if="isPlusShow==1"
                              :data="plusDorm"
                              border
                              style="width: 100%">
                        <el-table-column label="ID">
                            <template v-slot="slotProps"><el-input v-model="slotProps.row.dormid"></el-input></template>

                        </el-table-column>
                        <el-table-column label="名称">
                            <template v-slot="slotProps"><el-input v-model="slotProps.row.dormname"></el-input></template>
                        </el-table-column>
                        <el-table-column label="楼号">
                            <template v-slot="slotProps"><el-input v-model="slotProps.row.dormno"></el-input></template>
                        </el-table-column>
                        <el-table-column label="地址">
                            <template v-slot="slotProps"><el-input v-model="slotProps.row.dormaddr"></el-input></template>
                        </el-table-column>
                        <el-table-column label="容量">
                            <template v-slot="slotProps"><el-input v-model="slotProps.row.dormcap"></el-input></template>
                        </el-table-column>
                        <el-table-column label="操作">
                            <el-button @click="insertDormDate" size="medium">添加</el-button>
                            <el-button @click="clearInsertDate" size="medium">清空</el-button>
                        </el-table-column>
                    </el-table>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "plantwo",
        data() {
            return {
                dormdata: {dormid: 1},
                isEdit: "",
                updatefailed:"",
                plusDorm:[{
                    dormid:"",
                    dormname:"",
                    dormno:"",
                    dormaddr:"",
                    dormcap:""
                }],
                plusDormNull:[{
                    dormid:"",
                    dormname:"",
                    dormno:"",
                    dormaddr:"",
                    dormcap:""
                }],
                isPlusShow:-1,
                searchdormno:""
            }
        },
        mounted() {
            const url = "http://localhost:8090/selectDormByDormName?dormname=" + this.dormname
            this.$http.post(url).then(response => {
                this.dormdata = response.data
                console.log("result:" + this.dormdata)
            }, response => {
                console.log("error" + response.data)
            })
        },
        watch: {
            dormname() {
                const url = "http://localhost:8090/selectDormByDormName?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.dormdata = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            }
        },
        computed: {
            dormname() {
                return this.$route.query.dormname
            }
        },
        methods: {
            editclick(row) {
                this.isEdit = row
                this.isEdit.olddormid = row.dormid
            },
            updateRow() {
                this.$http.post("http://localhost:8090/updateDorm",this.isEdit).then(responed=>{
                    console.log("is success?:"+responed.bodyText)
                    this.updatefailed = null;
                    this.isEdit = "success";
                },responed=>{
                    console.log("failed"+responed)
                    this.updatefailed = this.isEdit.olddormid;
                    this.queryDorm();
                })
            },
            queryDorm(){
                const url = "http://localhost:8090/selectDormByDormName?dormname=" + this.dormname
                this.$http.post(url).then(response => {
                    this.dormdata = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            showPlus(){
                this.isPlusShow = -this.isPlusShow;
            },
            insertDormDate(){
                this.$http.post("http://localhost:8090/insertDorm",this.plusDorm[0]).then(response=>{
                    console.log("success:"+response.bodyText)
                    this.queryDorm()
                },response=>{
                    console.log("failed:"+response.bodyText)
                })
            },
            clearInsertDate (){
                this.plusDorm = this.plusDormNull
            },
            deleteclick(row){
                const url = "http://localhost:8090/deleteByDormId?dormid=" + row.dormid
                this.$http.post(url).then(response=>{
                    console.log("success:"+response.bodyText)
                    this.queryDorm()
                },response=>{
                    console.log("failed:"+response.bodyText)
                })
            }
        }
    }
</script>

<style scoped>
    .grid-all {
        border-radius: 4px;
        min-height: 2.1vw;
        line-height: 2.1vw;
        margin-left: 1.3vw;
    }

    .grid-content {
        margin-top: 1vw;
        min-height: 50vw;
        background-color: #030a1d;
    }

    .el-table {
        background-color: #030a1d;
    }

    .el-table th {
        background-color: black;
    }
</style>