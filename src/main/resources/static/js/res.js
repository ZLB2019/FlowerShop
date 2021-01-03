var login = new Vue({
    el:"#login_con",
    data:{
        user_email:"",
        user_password:"",
        user_password_two:"",
        VerificationCode:""
    },
    methods:{
        //发送邮箱验证码
        SendMessage:function(){
                alert("验证码已经通过邮箱发送，请注意查收！");
                var that = this;
                axios.get('/flower_shop/registered/sendMessage',{
                    params:{
                        user_email:that.user_email
                    }
                }).then(function (response) {
                    if (!response.data) {
                        alert("该邮箱已被注册！");
                    }
                })
        },
        //输入判断，判断输入邮箱格式是否有误且所有输入是否完全
        InputJudge:function(x){
            var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            if (!reg.test(this.user_email)||this.user_email ===""||this.user_email===null||this.user_password ===""||this.user_password===null||this.user_password!==this.user_password_two){
                alert("你的输入格式有误或不完整，请重新输入！");
            }else{
                if (x === 0)
                    this.SendMessage();
                else
                    this.resJudge();
            }
        },
        //注册判断
        resJudge:function () {
            var that = this;
            axios.get('/flower_shop/registered/insertUser',{
                params:{
                    userEmail:that.user_email,
                    userPassword:that.user_password,
                    VerificationCode:that.VerificationCode
                }
            }).then(function (response) {
                if (response.data===-1) {
                    alert("邮箱已经被注册！");
                }
                else if (response.data!==0) {
                    alert("注册成功！");
                    window.location.href='/flower_shop/login.html';
                }else{
                    alert("验证码错误！");
                    that.VerificationCode="";
                }
            }).catch(function (error) {
                alert("错误"+error);
            });
        }
    },
    created:function () {   //如果回到这个界面，session中存在user_id，则删除
        if (sessionStorage.getItem("user_id")!==null) {
            sessionStorage.removeItem("user_id");
        }
    }
});