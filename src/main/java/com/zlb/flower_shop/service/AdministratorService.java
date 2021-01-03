package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Administrator;
import com.zlb.flower_shop.mapper.AdministratorMapper;
import com.zlb.flower_shop.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements AdministratorRepository {

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public Administrator selectAdministrator(String administrator_account) {
        QueryWrapper<Administrator> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("administrator_id","administrator_account","administrator_password")
                .eq("administrator_account",administrator_account);
        return administratorMapper.selectOne(walletQueryWrapper);
    }
}
