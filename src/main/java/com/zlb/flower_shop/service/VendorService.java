package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Vendor;
import com.zlb.flower_shop.mapper.VendorMapper;
import com.zlb.flower_shop.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService implements VendorRepository {

    @Autowired
    VendorMapper vendorMapper;

    @Override
    public int insertVendor(Vendor vendor) {
        return vendorMapper.insert(vendor);
    }

    @Override
    public int deleteVendor(Integer vendorId) {
        return vendorMapper.deleteById(vendorId);
    }

    @Override
    public List<Vendor> allVendor() {
        QueryWrapper<Vendor> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("vendor_id","vendor_name");
        return vendorMapper.selectList(walletQueryWrapper);
    }

    @Override
    public int updateVendor(Vendor vendor) {
        return vendorMapper.updateById(vendor);
    }


    @Override
    public Vendor selectVendorByVendorName(String vendor_name) {
        QueryWrapper<Vendor> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("vendor_id","vendor_name").eq("vendor_name",vendor_name);
        return vendorMapper.selectOne(walletQueryWrapper);
    }
}
