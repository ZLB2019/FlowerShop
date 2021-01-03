new Vue({
    el:"#PUB",
    data:{
        flower_showList:[],
        user_name_css:"display: none;",
        user_name:"",
        type:"登陆",
        flowerId:0
    },
    methods: {
        selectFlower: function (temp) {
            var ans;
            if (temp===0)
                ans="";
            else
                ans=this.$refs.selectInput.value;
            sessionStorage.setItem("ans",ans);
            window.location.href='/flower_shop/select_flower.html';
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
                    if (response.data===0) {
                        alert("购买失败，数量有误！");
                    }else{
                        alert("购买成功！");
                    }
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
            /**
             * 初始化显示的商品
             */
            axios.get('/flower_shop/main/allFlower',
                {
                params:{
                ans:""
            }
            }).then(function (response) {
                     that.flower_showList=response.data;
                    console.log(that.flower_showList);
                }).catch(function (error) {
                alert(error);
            });
        }
});