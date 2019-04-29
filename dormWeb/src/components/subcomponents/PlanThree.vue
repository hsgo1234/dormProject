<template>
    <div style="width: 100%; height: 100%;">
        <el-row type="flex"
                style="height: 3.8vw;position: absolute;top: 1vw;right: 3vw;">
            <el-col :span="7">
                <div class="grid-all grid-search" style="margin: 0 0;width: 20vw;text-align: right">
                    <el-autocomplete popper-class="my-autocomplete"
                                     v-model="search"
                                     :value="stuid"
                                     :fetch-suggestions="querySearchAsync"
                                     placeholder="学生姓名"
                                     @select="handleSelect"
                                     style="width: 13vw;height: 3vw">
                        <template slot-scope="{ item }">
                            <div class="name">{{ item.stuname }}</div>
                        </template>7
                    </el-autocomplete>
                    <el-button style="margin-left: 1vw" @click="cancelSearch" type="info" size="small">重置</el-button>
                </div>
            </el-col>
        </el-row>
        <el-row type="flex">
            <el-col :span="24">
                <div class="grid-all grid-content">
                    <el-table
                            :data="studata"
                            border
                            style="width: 100%;"
                            height= "36vw">
                        <el-table-column
                                label="ID"
                                width="60">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stuid"></el-input>
                                <span v-else>{{slotProps.row.stuid}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="姓名">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stuname"></el-input>
                                <span v-else>{{slotProps.row.stuname}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="年级">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stueyear"></el-input>
                                <span v-else>{{slotProps.row.stueyear}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="公寓ID">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.dormid"></el-input>
                                <span v-else>{{slotProps.row.dormid}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="房间ID">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.roomid"></el-input>
                                <span v-else>{{slotProps.row.roomid}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="电话" width="130">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stutel"></el-input>
                                <span v-else>{{slotProps.row.stutel}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="邮箱" width="180">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stumail"></el-input>
                                <span v-else>{{slotProps.row.stumail}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="学院">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.stuins"></el-input>
                                <span v-else>{{slotProps.row.stuins}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="操作"
                                width="150">
                            <template v-slot="slotProps">
                                <el-button v-if="isEdit==slotProps.row"
                                           @click="updateRow()"
                                           type="info"
                                           size="mini">
                                    确认
                                </el-button>
                                <el-button v-else-if="updatefailed==slotProps.row.stuid"
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
                              :data="plusStu"
                              border
                              style="width: 100%">
                        <el-table-column label="ID" width="60">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stuid"></el-input>
                            </template>

                        </el-table-column>
                        <el-table-column label="名字">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stuname"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="年级">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stueyear"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="公寓ID">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.dormid"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="房间ID">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.roomid"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="电话" width="160">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stutel"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="邮箱" width="180">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stumail"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="性别">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stusex"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="学院">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stuins"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="系">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.studep"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="班级">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.stuclass"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" fixed="right" width="150">
                            <el-button @click="insertStuDate" size="mini">添加</el-button>
                            <el-button @click="clearInsertDate" size="mini" type="info">清空</el-button>
                        </el-table-column>
                    </el-table>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "PlanThree",
        data() {
            return {
                studata:[],
                isEdit: "",
                updatefailed: "",
                plusStu: [{
                    stuid: '',
                    stueyear: '',
                    roomid: '',
                    dormid: '',
                    stuname: '',
                    stutel: "",
                    stumail: '',
                    stusex: '',
                    stuins: '',
                    studep: '',
                    stuclass: ''
                }],
                plusStuNull: [{
                    stuid: '',
                    stueyear: '',
                    roomid: '',
                    dormid: '',
                    stuname: '',
                    stutel: "",
                    stumail: '',
                    stusex: '',
                    stuins: '',
                    studep: '',
                    stuclass: ''
                }],
                isPlusShow: -1,
                oldstuid: "",
                search: ""
            }
        },
        methods: {
            editclick(row) {
                this.isEdit = row
                this.oldstuid = row.stuid
            },
            updateRow() {
                this.$http.post("http://localhost:8090/updateStu", this.isEdit).then(responed => {
                    console.log("is success?:" + responed.bodyText)
                    this.updatefailed = null;
                    this.isEdit = "success";
                }, responed => {
                    console.log("failed" + responed)
                    this.updatefailed = this.oldstuid;
                    this.isEdit = "faild";
                    this.queryStu();
                })
            },
            queryStu() {
                const url = "http://localhost:8090/selectStuByStuEYear?stueyear=" + this.stueyear
                this.$http.post(url).then(response => {
                    this.studata = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            insertStuDate() {
                this.$http.post("http://localhost:8090/insertStu", this.plusStu[0]).then(response => {
                    console.log("success:" + response.bodyText)
                    this.queryStu()
                }, response => {
                    console.log("failed:" + response.bodyText)
                })
            },
            clearInsertDate() {
                this.plusStu = this.plusStuNull
            },
            showPlus() {
                this.isPlusShow = -this.isPlusShow;
            },
            deleteclick(row) {
                const url = "http://localhost:8090/deleteByStuId?stuid=" + row.stuid
                this.$http.post(url).then(response => {
                    console.log("success:" + response.bodyText)
                    this.queryStu()
                }, response => {
                    console.log("failed:" + response.bodyText)
                })
            },
            querySearchAsync(queryString, cb) {
                var restaurants = this.studata;
                var results = queryString ? restaurants.filter(this.createSearchFilter(queryString)) : restaurants;
                console.log("results:"+results)
                    cb(results);
            },
            createSearchFilter(queryString) {
                console.log("queryString"+queryString)
                return (restaurants) => {
                    return (restaurants.stuname.toLowerCase().indexOf(queryString.toLowerCase()) >= 0);
                };
            },
            handleSelect(item) {
                this.search = item.stuname
                this.studata = this.studata.filter(data => data.stuname.toLowerCase().includes(item.stuname.toLowerCase()))
            },
            cancelSearch(){
                this.search = null
                this.queryStu()
            }
        },
        mounted() {
            this.queryStu()
        },
        computed: {
            stueyear() {
                return this.$route.query.stueyear
            }
        },
        watch: {
            stueyear() {
                this.queryStu();
            }
        }
    }
</script>

<style scoped>
    .my-autocomplete {
        li {
            line-height: normal;
            padding: 7px;

            .name {
                text-overflow: ellipsis;
                overflow: hidden;
            }
            .addr {
                font-size: 12px;
                color: #b4b4b4;
            }

            .highlighted .addr {
                color: #ddd;
            }
        }
    }
    .grid-all {
        border-radius: 4px;
        margin-left: 1.3vw;
    }

    .grid-content {
        height: 51vw;
        background-color: #030a1d;
    }

    .el-table {
        background-color: #030a1d;
    }

    .el-table th {
        background-color: black;
    }
</style>