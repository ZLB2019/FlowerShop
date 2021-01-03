new Vue({
    el:"#PUB",
    data:{
        vendor_list:[]
    },
    methods: {
        /**
         * 查找所有厂家
         */
        AllVendor: function () {
            that = this;
            axios.get('/flower_shop/VendorManage/allVendor')
                .then(function (response) {
                    that.vendor_list=response.data;
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
         * 添加厂家
         */
        InsertVendor:function () {
            that = this;
            var vendorName=this.$refs.insert_name.value;
            axios.get('/flower_shop/VendorManage/insertVendor',{
                params:{
                    vendorName:vendorName
                }
            }).then(function () {
                alert("添加成功");
                that.AllVendor();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 编辑厂家，记录是哪个厂家
         */
        UpdateVendor:function (index) {
            this.$refs.update_id.innerHTML=that.vendor_list[index].vendorId;
        },
        /**
         * 编辑厂家提交更改
         */
        UpdateVendorSubmit:function () {
            that = this;
            var vendorId = this.$refs.update_id.innerHTML;
            var vendorName = this.$refs.update_name.value;
            axios.get('/flower_shop/VendorManage/updateVendor',{
                params:{
                    vendorId:vendorId,
                    vendorName:vendorName
                }
            }).then(function () {
                alert("更改成功！");
                that.AllVendor();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 删除厂家，记录是哪个厂家
         */
        DeleteVendor:function (index) {
            this.$refs.delete_id.innerHTML=this.vendor_list[index].vendorId;
            this.$refs.delete_name.innerHTML=this.vendor_list[index].vendorName;
        },
        /**
         * 确认删除厂家
         */
        DeleteVendorSubmit:function () {
            that = this;
            var vendorId = this.$refs.delete_id.innerHTML;
            axios.get('/flower_shop/VendorManage/deleteVendor',{
                params:{
                    vendorId:vendorId
                }
            }).then(function () {
                alert("删除成功！");
                that.AllVendor();
            }).catch(function (error) {
                alert(error);
            })
        },
        /**
         * 根据厂商名字查找
         */
        SelectClass:function () {
            that = this;
            var vendor_name=this.$refs.select_name.value;
            axios.get('/flower_shop/VendorManage/selectVendor',{
                params:{
                    vendorName:vendor_name
                }
            }).then(function (response) {
                if (response.data==="")
                    alert("未找到此厂商！");
                else
                {
                    that.vendor_list=[];
                    that.vendor_list[0]=response.data;
                    console.log(that.vendor_list)
                }
            }).catch(function (error) {
                alert(error);
            })
        }
    }
});