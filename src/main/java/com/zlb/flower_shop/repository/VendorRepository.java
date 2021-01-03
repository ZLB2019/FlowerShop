package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Vendor;

import java.util.List;

public interface VendorRepository {

    int insertVendor(Vendor vendor);

    int deleteVendor(Integer vendorId);

    Vendor selectVendorByVendorName(String vendor_name);

    List<Vendor> allVendor();

    int updateVendor(Vendor vendor);
}
