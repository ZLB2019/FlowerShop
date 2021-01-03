new Vue({
    el:"#PUB",
    data:{
        order_list:[]
    },
    methods: {
        /**
         * 查找所有订单
         */
        AllOrder: function () {
            that = this;
            axios.get('/flower_shop/orderManage/allOrder')
                .then(function (response) {
                    that.order_list=response.data;
                }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 返回
         */
        Return_Adm:function () {
            window.location.href='/flower_shop/administrator.html';
        },
        /**
         * 查找未完成订单
         */
        SelectOrderNo:function () {
            that = this;
            axios.get('/flower_shop/orderManage/selectOrder',{
                params:{
                    userId:0,
                    type:0
                }
            }).then(function (response) {
                that.order_list=response.data;
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 查找已经完成订单
         */
        SelectOrderYes:function () {
            that = this;
            axios.get('/flower_shop/orderManage/selectOrder',{
                params:{
                    userEmail:"",
                    type:1
                }
            }).then(function (response) {
                that.order_list=response.data;
            }).catch(function (error) {
                alert(error);
            })
        },/**
         * 根据邮箱查找订单
         */
        SelectOrder:function () {
            that = this;
            var userEmail=this.$refs.select_email.value;
            axios.get('/flower_shop/orderManage/selectOrder',{
                params:{
                    userEmail:userEmail,
                    type:-1
                }
            }).then(function (response) {
                that.order_list=response.data;
            }).catch(function (error) {
                alert(error);
            })
        },

        /**
         * 删除订单，记录是哪个订单
         */
        DeleteOrder:function (id) {
            this.$refs.delete_id.innerHTML=id;
        },
        /**
         * 确认删除订单
         */
        DeleteOrderSubmit:function () {
            that = this;
            var orderId = this.$refs.delete_id.innerHTML;
            axios.get('/flower_shop/orderManage/deleteOrder',{
                params:{
                    orderId:orderId
                }
            }).then(function (response) {
                alert("删除成功！");
                that.AllOrder();
            }).catch(function (error) {
                alert(error);
            })
        },
        UpdateOrder:function (orderId,flowerId,userId,number,type) {
            var that =this;
            axios.get('/flower_shop/orderManage/updateOrder',{
                params:{
                    orderId:orderId,
                    flowerId:flowerId,
                    userId:userId,
                    number:number,
                    type:type
                }
            }).then(function (response) {
                alert("修改成功！");
                that.AllOrder();
            }).catch(function (error) {
                alert(error);
            })
        }
    }
});