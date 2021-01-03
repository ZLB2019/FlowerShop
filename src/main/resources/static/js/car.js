new Vue({
    el:"#PUB",
    data:{
        carList:[],
        user_name_css:"display: none;",
        user_name:"",
        type:"登陆",
        flowerId:0
    },
    methods: {
        //搜索商品
        selectFlower: function (temp) {
            var ans;
            if (temp===0)
                ans="";
            else
                ans=this.$refs.selectInput.value;
            sessionStorage.setItem("ans",ans);
            window.location.href='/flower_shop/select_flower.html';
        },
        //删除购物车
        delCar:function(index){
            var that =this;
            axios.get('/flower_shop/car/delCar', {
                params: {
                    carId:that.carList[index].carId
                }
            }).then(function (response) {
                that.carList.splice(index,1);
            })
        },
        //修改商品数量
        changeNumber:function (type,index) {
            if (type === 1)
                this.carList[index].number++;
            else
                if ( this.carList[index].number>0)
                    this.carList[index].number--;
            var that = this;
            axios.get('/flower_shop/car/updateCar', {
                params: {
                    carId:that.carList[index].carId,
                    userId: that.carList[index].userId,
                    number:that.carList[index].number,
                    flowerId:that.carList[index].flowerId
                }
            })
        },
        //购买-->添加订单
        addOrder:function (index) {
            var that = this;
            axios.get('/flower_shop/main/addOrder', {
                params: {
                    userId:that.carList[index].userId,
                    number:that.carList[index].number,
                    flowerId:that.carList[index].flowerId,
                    type:0
                }
            }).then(function (response) {
                if (response.data===0) {
                    alert("购买失败，数量有误！");
                }else{
                    that.delCar(index);
                    alert("购买成功！");
                }
            })
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
                    axios.get('/flower_shop/car/allCar',
                        {
                            params:{
                                userId:user_id
                            }
                        }).then(function (response) {
                        that.carList=response.data;
                        console.log(that.carList);
                    }).catch(function (error) {
                        alert(error);
                    });
                })
        }
    }
});