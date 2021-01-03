new Vue({
    el:"#PUB",
    data:{
        flowerList:[],
        user_name_css:"display: none;",
        user_name:"",

        type:"登陆",
        flowerId:0
    },
    methods: {
        selectFlower:function () {
            var flowerInf=this.$refs.flowerInf.value;
            var that=this;
            axios.get('/flower_shop/main/allFlower',{
                params:{
                    ans:flowerInf
                }
            }).then(function (response) {
                    that.flowerList=response.data;
                    console.log(that.flowerList);
                }).catch(function (error) {
                alert(error);
            });
        },
        addCar:function () {
            var that = this;
            var number=this.$refs.car_number.value;
            this.$refs.car_number.value="";
            var user_id = sessionStorage.getItem("user_id");
            axios.get('/flower_shop/main/addCar', {
                params: {
                    userId: user_id,
                    number:number,
                    flowerId:that.flowerId
                }
            })
                .then(function (response) {
                    alert("添加购物车成功！")
                }).catch(function (error) {
                //alert(error);
            })
        },
        addOrder:function () {
            var that = this;
            var number=this.$refs.buy_number.value;
            this.$refs.buy_number.value="";
            var user_id = sessionStorage.getItem("user_id");
            axios.get('/flower_shop/main/addOrder', {
                params: {
                    userId: user_id,
                    number:number,
                    flowerId:that.flowerId,
                    type:0
                }
            })
                .then(function (response) {
                    alert("购买成功！")
                }).catch(function (error) {
                //alert(error);
            })
        }
    },
    created:function () {
        var that = this;
        if (sessionStorage.getItem("user_id") !== null) {
            that.user_name_css = "margin-top: 9px;margin-right:30px;font-size: 20px;";
            that.type = "退出登录";
            var user_id = sessionStorage.getItem("user_id");
            axios.get('/flower_shop/main/selectUserById', {
                params: {
                    userId: user_id
                }
            })
                .then(function (response) {
                    that.user_name = response.data.userEmail;
                }).catch(function (error) {
                //alert(error);
            })
        }

        if (sessionStorage.getItem("ans") !== null) {
            axios.get('/flower_shop/main/allFlower',{
                params:{
                    ans:sessionStorage.getItem("ans")
                }
            })
                .then(function (response) {
                    that.flowerList=response.data;
                    console.log(that.flowerList);
                }).catch(function (error) {
                alert(error);
            });
        }
    }
});