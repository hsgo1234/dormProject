<template>
    <div style="width: 100%; height: 100%;">
        <el-row type="flex"
                style="height: 3.8vw;position: absolute;top: 1vw;right: 3vw;">
            <el-col :span="7">
                <div class="grid-all grid-search" style="margin: 0 0;width: 20vw;text-align: right">
                    <el-autocomplete popper-class="my-autocomplete"
                                     v-model="search"
                                     :fetch-suggestions="querySearchAsync"
                                     placeholder="用户名"
                                     @select="handleSelect"
                                     style="width: 13vw;height: 3vw">
                        <template slot-scope="{ item }">
                            <div class="name">{{ item.username }}</div>
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
                            :data="userdata"
                            border
                            style="width: 100%"
                            height= "36vw">
                        <el-table-column
                                label="ID">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.userid"></el-input>
                                <span v-else>{{slotProps.row.userid}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="身份">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.usertype"></el-input>
                                <span v-else>{{slotProps.row.usertype}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="用户名">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.username"></el-input>
                                <span v-else>{{slotProps.row.username}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="密码">
                            <template v-slot="slotProps">
                                <el-input v-if="isEdit==slotProps.row"
                                          v-model="slotProps.row.password"></el-input>
                                <span v-else>{{slotProps.row.password}}</span>
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
                                <el-button v-else-if="updatefailed==slotProps.row.userid"
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
                              :data="plusUser"
                              border
                              style="width: 100%">
                        <el-table-column label="ID">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.userid"></el-input>
                            </template>

                        </el-table-column>
                        <el-table-column label="身份">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.usertype"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="用户名">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.username"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="密码">
                            <template v-slot="slotProps">
                                <el-input v-model="slotProps.row.password"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" fixed="right" width="150">
                            <el-button @click="insertUserDate" size="mini">添加</el-button>
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
        name: "PlanFour",
        data() {
            return {
                userdata:[],
                isEdit: "",
                updatefailed: "",
                plusUser: [{
                    userid: '',
                    username: '',
                    usertype: "",
                    password: ''
                }],
                plusUserNull: [{
                    userid: '',
                    username: '',
                    usertype: "",
                    password: ''
                }],
                isPlusShow: -1,
                olduserid: "",
                search: ""
            }
        },
        methods: {
            editclick(row) {
                this.isEdit = row
                this.olduserid = row.userid
            },
            updateRow() {
                this.$http.post("http://localhost:8090/updateLoginInfo", this.isEdit).then(responed => {
                    console.log("is success?:" + responed.bodyText)
                    this.updatefailed = null;
                    this.isEdit = "success";
                }, responed => {
                    console.log("failed" + responed)
                    this.updatefailed = this.olduserid;
                    this.isEdit = "faild";
                    this.queryUser();
                })
            },
            queryUser() {
                const url = "http://localhost:8090/selectLoginInfoByUsertype?usertype=" + this.usertype
                this.$http.post(url).then(response => {
                    this.userdata = response.data
                }, response => {
                    console.log("error" + response.data)
                })
            },
            insertUserDate() {
                this.$http.post("http://localhost:8090/insertLoginInfo", this.plusUser[0]).then(response => {
                    console.log("success:" + response.bodyText)
                    this.queryUser()
                }, response => {
                    console.log("failed:" + response.bodyText)
                })
            },
            clearInsertDate() {
                this.plusUser = this.plusUserNull
            },
            showPlus() {
                this.isPlusShow = -this.isPlusShow;
            },
            deleteclick(row) {
                const url = "http://localhost:8090/deleteByUserId?userid=" + row.userid
                this.$http.post(url).then(response => {
                    console.log("success:" + response.bodyText)
                    this.queryUser()
                }, response => {
                    console.log("failed:" + response.bodyText)
                })
            },
            querySearchAsync(queryString, cb) {
                var restaurants = this.userdata;
                var results = queryString ? restaurants.filter(this.createSearchFilter(queryString)) : restaurants;
                console.log("results:"+results)
                this.timeout = setTimeout(() => {
                    cb(results);
                }, 3000 * Math.random());
            },
            createSearchFilter(queryString) {
                console.log("queryString"+queryString)
                return (restaurants) => {
                    return (restaurants.username.toLowerCase().indexOf(queryString.toLowerCase()) >= 0);
                };
            },
            handleSelect(item) {
                this.search = item.username
                this.userdata = this.userdata.filter(data => data.username.toLowerCase().includes(item.username.toLowerCase()))
            },
            cancelSearch(){
                this.search = null
                this.queryUser()
            }
        },
        mounted() {
            this.queryUser()
        },
        computed: {
            usertype() {
                return this.$route.query.usertype
            }
        },
        watch: {
            usertype() {
                this.queryUser();
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