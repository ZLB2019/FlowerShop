new Vue({
    el:"#PUB",
    data:{
        orderList:[],
        user_name_css:"display: none;",
        user_name:"",
        type:"登陆"
    },
    methods: {
        //搜索商品
        selectFlower: function (temp) {
            var ans;
            if (temp === 0)
                ans = "";
            else
                ans = this.$refs.selectInput.value;
            sessionStorage.setItem("ans", ans);
            window.location.href = '/flower_shop/select_flower.html';
        }
    },
    //初始化
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
                    /**
                     * 初始化显示的商品
                     */
                    axios.get('/flower_shop/order/userAllOrder',
                        {
                            params:{
                                userId:user_id
                            }
                        }).then(function (response) {
                        that.orderList=response.data;
                        console.log(that.orderList);
                    }).catch(function (error) {
                        alert(error);
                    });
                })
        }
    }
});