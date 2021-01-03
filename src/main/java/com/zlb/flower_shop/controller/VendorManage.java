package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.Vendor;
import com.zlb.flower_shop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 产商管理
 */
@RestController
@RequestMapping("VendorManage")
public class VendorManage {

    @Autowired
    VendorService vendorService;

    /**
    功能描述 :返回所有厂家
    * @author zlb
    * @date 2020/9/29
    * @param []
    * @return java.util.List<com.zlb.flower_shop.bean.Vendor>
    */
    @RequestMapping("allVendor")
    public List<Vendor> allVendor(){
        return vendorService.allVendor();
    }

    /**
     功能描述 :添加厂家
     * @author zlb
     * @date 2020/9/29
     * @param [vendor]
     * @return int
     */
    @RequestMapping("insertVendor")
    public int insertVendor(Vendor vendor){
        return vendorService.insertVendor(vendor);
    }

    /**
     功能描述 :删除厂家
     * @author zlb
     * @date 2020/9/29
     * @param [vendorId]
     * @return int
     */
    @RequestMapping("deleteVendor")
    public int deleteVendor(Integer vendorId){
        return vendorService.deleteVendor(vendorId);
    }

    /**
     功能描述 :修改厂家名
     * @author zlb
     * @date 2020/9/29
     * @param [vendor]
     * @return int
     */
    @RequestMapping("updateVendor")
    public int updateVendor(Vendor vendor){
        return vendorService.updateVendor(vendor);
    }

    /***
    功能描述 : 根据厂商名查找厂商
    * @author zlb
    * @date 2020/10/2
    * @param [vendorName]
    * @return com.zlb.flower_shop.bean.Vendor
    */
    @RequestMapping("selectVendor")
    public Vendor selectVendor(String vendorName){
        return vendorService.selectVendorByVendorName(vendorName);
    }
}
