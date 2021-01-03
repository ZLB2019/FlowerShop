package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Administrator;

public interface AdministratorRepository {

    Administrator selectAdministrator(String administrator_account);

}
