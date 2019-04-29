<template>
	<view>
        <view class="uni-padding-wrap uni-common-mt">
            <form @submit="formSubmit" @reset="formReset">
				<view class="uni-form-item uni-column">
                    <view class="zhanghao">用户名</view>
                    <input class="uni-input" v-model="formdata.username" name="input" placeholder="这是一个输入框" />
                </view>
				<view class="uni-form-item uni-column">
                    <view class="title">密码</view>
                    <input class="uni-input" v-model="formdata.password" name="input" placeholder="这是一个输入框" />
                </view>
				<view class="uni-btn-v">
                    <button formType="submit">登录</button>
                    <button type="default" formType="reset">Reset</button>
                </view>
			</form>
			<text>res:{{res}}</text>
        </view>
    </view>
</template>

<script>
	export default {
		data() {
			return {
				formdata:{
					usertype:"student",
					username:"",
					password:""
				},
				res:""
			}
		},
		onLoad() {
			
		},
		methods: {
			formSubmit(){
				uni.request({
					url: 'http://192.168.0.112:8090/loginStu', //仅为示例，并非真实接口地址。
					data: this.formdata,
					method:"POST",
					success: (res) => {
						console.log(res.data);
						if(res.data == "success"){
							console.log("req userid:"+res.data.userid)
							this.loginStorage();
							uni.reLaunch({
								url: 'index'
							});
						}else{
							this.res =res.data
						}
					}
				});
			},
			loginStorage(){
				uni.setStorage({
					key: 'formdata',
					data: this.formdata,
					success: function () {
						console.log('success');
					}
				});
			}
		}
	}
</script>

<style>
</style>
