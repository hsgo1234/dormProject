<template>
	<view>
		<view class="uni-padding-wrap uni-common-mt">
		    <form @submit="formSubmit">
				<view class="uni-btn-v">
					你好,{{formdata.username}}。
				</view>
				<view class="uni-btn-v">
					当前位置：
					<view>{{loginLocation.longitude}}（经）</view>
					<view>{{loginLocation.latitude}}（纬）</view>
				</view>
				<view class="uni-btn-v">
		            <button formType="submit">归寝打卡</button>
		        </view>
			</form>
			<view>{{res}}</view>
			<view>
				<button @click="InDorm">进公寓</button>
			</view>
			<view>{{res2}}</view>
			<view>
				<button @click="OutDorm">出公寓</button>
			</view>
			<view>{{res3}}</view>
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
				loginLocation:{
					longitude:"",
					latitude:""
				},
				res:"",
				res2:"",
				res3:""
			}
		},
		methods:{
			formSubmit(){
				var url = "http://192.168.0.112:8090/insertBedTime?username=" + this.formdata.username
				uni.request({
					url: url, //仅为示例，并非真实接口地址。
					method:"POST",
					success: (res) => {
						console.log(res.data);
						if(res.data == "success"){
							this.res = "success"
						}else{
							this.res = "failed"
						}
					}
				});
			},
			InDorm(){
				var url = "http://192.168.0.112:8090/insertInAccess?username=" + this.formdata.username
				uni.request({
					url: url, //仅为示例，并非真实接口地址。
					method:"POST",
					success: (res) => {
						console.log(res.data);
						if(res.data == "success"){
							this.res2 = "success"
						}else{
							this.res2 = "failed"
						}
					}
				});
			},
			OutDorm(){
				var url = "http://192.168.0.112:8090/insertOutAccess?username=" + this.formdata.username
				uni.request({
					url: url, //仅为示例，并非真实接口地址。
					method:"POST",
					success: (res) => {
						console.log(res.data);
						if(res.data == "success"){
							this.res3 = "success"
						}else{
							this.res3 = "failed"
						}
					}
				});
			},
			getLoginStorage(){
				var loginid = null;
				var loginname = null;
				uni.getStorage({
					key: 'formdata',
					success: function (res) {
						loginname = res.data.username;
					}
				});
				this.formdata.username = loginname;
				console.log(".."+this.formdata.username)
			},
			getLoginLocation(){
				var longitude = null;
				var latitude = null;
				uni.getLocation({
					type: 'wgs84',
					success: function (res) {
						longitude = res.longitude
						latitude = res.latitude
					}
				});
				this.timeout = setTimeout(() => {
                    this.loginLocation.longitude = longitude
                    this.loginLocation.latitude = latitude
                }, 2000);
			}
		},
		mounted() {
			this.getLoginStorage()
			this.getLoginLocation()
		}
	}
</script>

<style>
</style>
