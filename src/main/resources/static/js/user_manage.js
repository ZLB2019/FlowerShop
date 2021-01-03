new Vue({
    el:"#PUB",
    data:{
        user_list:[]
    },
    methods: {
        /**
         * 查找所有用户
         */
        AllUser: function () {
            that = this;
            axios.get('/flower_shop/UserManage/all_user')
                .then(function (response) {
                    that.user_list=response.data;
                }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 返回管理员主界面
         */
        Return_Adm:function () {
            window.location.href='/flower_shop/administrator.html';
        },
        /**
         * 添加用户
         */
        InsertUser:function () {

            that = this;
            var userEmail=this.$refs.insert_email.value;
            var userPassword = this.$refs.insert_password.value;
            var eamil = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            if (!eamil.test(userEmail)||userEmail===""){
                alert("请输入正确的邮箱地址！");
            }else{
                axios.get('/flower_shop/UserManage/insert_user',{
                    params:{
                        userEmail:userEmail,
                        userPassword:userPassword
                    }
                }).then(function (response) {
                    if (response.data===0)
                        alert("该邮箱已经存在，添加失败！");
                    else
                        alert("添加成功");
                    that.AllUser();
                }).catch(function (error) {
                    alert(error);
                })
            }
        },
        /**
         * 根据邮箱查找用户
         */
        SelectUser:function () {
            that = this;
            var user_email=this.$refs.select_email.value;
            axios.get('/flower_shop/UserManage/selectUserByEmail',{
                params:{
                    user_email:user_email
                }
            }).then(function (response) {
                if (response.data==="")
                    alert("未找到该用户！");
                else
                {
                    that.user_list=[];
                    that.user_list[0]=response.data;
                    console.log(that.user_list)
                }
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 编辑用户，记录是哪个用户
         */
        UpdateUser:function (index) {
            this.$refs.update_email.innerHTML=that.user_list[index].userEmail;
            this.$refs.update_id.innerHTML=that.user_list[index].userId;
        },
        /**
         * 编辑用户提交更改
         */
        UpdateUserSubmit:function () {
            var that = this;
            var userId = this.$refs.update_id.innerHTML;
            var userEmail = this.$refs.update_email.innerHTML;
            var userPassword = this.$refs.update_password.value;
            axios.get('/flower_shop/UserManage/UpdateUser',{
                params:{
                    userId:userId,
                    userEmail:userEmail,
                    userPassword:userPassword
                }
            }).then(function (response) {
                alert("更改成功！");
                that.AllUser();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 删除用户，记录是哪个用户
         */
        DeleteUser:function (index) {
            this.$refs.delete_id.innerHTML=this.user_list[index].userEmail;
        },
        /**
         * 确认删除用户
         */
        DeleteUserSubmit:function () {
            that = this;
            var userId = this.$refs.delete_id.innerHTML;
            axios.get('/flower_shop/UserManage/DeleteUser',{
                params:{
                    userId:userId
                }
            }).then(function (response) {
                alert("删除成功！");
                that.AllUser();
            }).catch(function (error) {
                alert(error);
            })
        }
    }
});