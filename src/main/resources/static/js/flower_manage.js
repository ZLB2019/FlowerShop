new Vue({
    el:"#PUB",
    data:{
        flower_list:[],
        vendor_list:[],
        class_list:[],
        image_path:"image/flower/default.jpg",
        class_default:{},
        vendor_default:{}
    },
    methods: {
        /**
         * 查找所有花
         */
        AllFlower: function () {
            that = this;
            axios.get('/flower_shop/FlowerManage/selectFlowerLike',{
                params:{
                    ans:""
                }
            })
                .then(function (response) {
                    that.flower_list=response.data;
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
         * 添加花
         */
        InsertFlower:function () {
            that = this;
            var flowerName=this.$refs.insert_name.value;
            var number=this.$refs.insert_number.value;
            var price=this.$refs.insert_price.value;
            var classId=that.class_default.classId;
            var vendorId=that.vendor_default.vendorId;
            if (classId===-1||vendorId===-1){
                alert("没有相对应的分类和厂商，请先添加分类和厂商！")
                return;
            }
            if (isNaN(price)){
                alert("请输入正确的价格！");
                return;
            }
            axios.get('/flower_shop/FlowerManage/insertFlower',{
                params:{
                    flowerName:flowerName,
                    number:number,
                    price:price,
                    classId:classId,
                    vendorId:vendorId,
                    image:that.image_path
                }
            }).then(function () {
                alert("添加成功");
                that.AllFlower();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 编辑花，记录是哪个花
         */
        UpdateFlower:function (index) {
            this.$refs.update_id.value=this.flower_list[index].flowerId;
            this.$refs.update_name.value=this.flower_list[index].flowerName;
            this.$refs.update_price.value=this.flower_list[index].price;
            this.$refs.update_number.value=this.flower_list[index].number;
            for (var i=0;i<this.class_list.length;i++)
                if (this.flower_list[index].classId===this.class_list[i].classId){
                    this.class_default=this.class_list[i];
                    break;
                }
            for (i=0;i<this.vendor_list.length;i++)
                if (this.flower_list[index].vendorId===this.vendor_list[i].vendorId){
                    this.vendor_default=this.vendor_list[i];
                    break;
                }
            this.image_path=this.flower_list[index].image;
        },
        /**
         * 编辑花提交更改
         */
        UpdateFlowerSubmit:function () {
            that = this;
            var flowerId =  this.$refs.update_id.value;
            var flowerName =  this.$refs.update_name.value;
            var number =  this.$refs.update_number.value;
            var price =  this.$refs.update_price.value;
            var image = this.image_path;
            var classId = this.class_default.classId;
            var vendorId = this.vendor_default.vendorId;
            axios.get('/flower_shop/FlowerManage/updateFlower',{
                params:{
                    flowerId:flowerId,
                    flowerName:flowerName,
                    number:number,
                    price:price,
                    image:image,
                    classId:classId,
                    vendorId:vendorId
                }
            }).then(function () {
                alert("更改成功！");
                that.AllFlower();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 删除花，记录是哪个花
         */
        DeleteFlower:function (index) {
            this.$refs.delete_id.innerHTML=this.flower_list[index].flowerId;
            this.$refs.delete_name.innerHTML=this.flower_list[index].flowerName;
        },
        /**
         * 确认删除花
         */
        DeleteFlowerSubmit:function () {
            that = this;
            var flowerId = this.$refs.delete_id.innerHTML;
            axios.get('/flower_shop/FlowerManage/deleteFlower',{
                params:{
                    flowerId:flowerId
                }
            }).then(function (response) {
                if (response.data===1)
                    alert("删除成功！");
                else
                    alert("删除失败");
                that.AllFlower();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         根据花名查花
         */
        SelectFlower:function () {
            that = this;
            var flowerName=this.$refs.select_name.value;
            axios.get('/flower_shop/FlowerManage/selectFlowerLike',{
                params:{
                    ans:flowerName
                }
            }).then(function (response) {
                that.flower_list=response.data;
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
            图片上传，tmp为0代表添加，tmp为1代表修改
         */
        imgChoosePut:function (tmp) {
            var imgFile;
            if (tmp===0)
                imgFile = this.$refs.img_choose.files[0];
            else
                imgFile = this.$refs.img_choose_update.files[0];
            var formData = new FormData();
            formData.append("image",imgFile);

            var headers = {headers: {"Content-Type": "multipart/form-data"}};
            that = this;
            axios.post('/flower_shop/FlowerManage/upload',formData,headers)
                .then(function (response) {
                    that.image_path = response.data.url;
                    console.log(response.data.url);
                })
                .catch(function (error) {
                alert(error);
            })
        },
        class_choose:function (index) {
            this.class_default=this.class_list[index];
        },
        vendor_choose:function (index) {
            this.vendor_default=this.vendor_list[index];
        }
    },
    created:function () {
        /**
         * 获取所有的分类和厂商，便于添加商品使用
         */
        that = this;
        axios.get('/flower_shop/ClassManage/allClass')
            .then(function (response) {
                that.class_list=response.data;
                if (that.class_list.length>0)
                    that.class_default=that.class_list[0];
                else
                    that.class_default={className:"暂无分类",classId:-1};
            }).catch(function (error) {
            alert(error);
        });
        axios.get('/flower_shop/VendorManage/allVendor')
            .then(function (response) {
                that.vendor_list=response.data;
                if (that.vendor_list.length>0)
                    that.vendor_default=that.vendor_list[0];
                else
                    that.vendor_default={vendorName:"暂无厂商",vendorId:-1};
            }).catch(function (error) {
            alert(error);
        })
    }
});