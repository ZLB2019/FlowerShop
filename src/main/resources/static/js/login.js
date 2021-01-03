var login = new Vue({
    el:"#login_con",
    data:{
        user_email:"",
        user_password:""
    },
    methods:{
        //输入判断，判断用户有没有输入完全
        InputJudge:function(){
            if (this.user_email ===""||this.user_email===null||this.user_password ===""||this.user_password===null){
                alert("你的输入有误或不完整，请重新输入！");
            }else{
                this.loginJudge();
            }
        },
        //登陆判断，判断是管理员还是用户，并且判断密码是否匹配
        loginJudge:function () {
            var that = this;
            axios.get('/flower_shop/login/loginJudge',{
                params:{
                    userEmail:that.user_email,
                    userPassword:that.user_password
                }
            }).then(function (response) {
                if (response.data===-1) {
                    sessionStorage.setItem("administrator",that.user_email);
                    window.location.href='/flower_shop/administrator.html';
                }
                else if (response.data!==0) {
                    sessionStorage.setItem("user_id",response.data);
                    window.location.href='/flower_shop/main.html';
                       }else{
                        alert("邮箱未注册或密码错误！");
                        that.user_password="";
                    }
            }).catch(function (error) {
                    alert("错误"+error);
                });
        }
    },
    //删除session中记录的用户id
    created:function () {   //如果回到这个界面，session中存在user_id，则删除
        if (sessionStorage.getItem("user_id")!==null) {
            sessionStorage.removeItem("user_id");
        }
    }
});