new Vue({
    el:"#PUB",
    data:{
        class_list:[]
    },
    methods: {
        /**
         * 查找所有分类
         */
        AllClass: function () {
            that = this;
            axios.get('/flower_shop/ClassManage/allClass')
                .then(function (response) {
                    that.class_list=response.data;
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
         * 添加分类
         */
        InsertClass:function () {
            that = this;
            var className=this.$refs.insert_name.value;
            axios.get('/flower_shop/ClassManage/insertClass',{
                params:{
                    className:className
                }
            }).then(function () {
                alert("添加成功");
                that.AllClass();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 编辑分类，记录是哪个分类
         */
        UpdateClass:function (index) {
            this.$refs.update_id.innerHTML=that.class_list[index].classId;
        },
        /**
         * 编辑分类提交更改
         */
        UpdateClassSubmit:function () {
            that = this;
            var classId = this.$refs.update_id.innerHTML;
            var className = this.$refs.update_name.value;
            axios.get('/flower_shop/ClassManage/updateClass',{
                params:{
                    classId:classId,
                    className:className
                }
            }).then(function () {
                alert("更改成功！");
                that.AllClass();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 删除分类，记录是哪个分类
         */
        DeleteClass:function (index) {
            this.$refs.delete_id.innerHTML=this.class_list[index].classId;
            this.$refs.delete_name.innerHTML=this.class_list[index].className;
        },
        /**
         * 确认删除分类
         */
        DeleteClassSubmit:function () {
            that = this;
            var classId = this.$refs.delete_id.innerHTML;
            axios.get('/flower_shop/ClassManage/deleteClass',{
                params:{
                    classId:classId
                }
            }).then(function (response) {
                alert("删除成功！");
                that.AllClass();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
            根据分类名查分类
         */
        SelectClass:function () {
            that = this;
            var class_name=this.$refs.select_name.value;
            axios.get('/flower_shop/ClassManage/selectClass',{
                params:{
                    className:class_name
                }
            }).then(function (response) {
                if (response.data===null)
                    alert("未找到此分类！");
                else
                {
                    that.class_list=[];
                    that.class_list[0]=response.data;
                    console.log(that.class_list)
                }
            }).catch(function (error) {
                alert(error);
            })
        }
    }
});