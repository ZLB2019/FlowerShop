package com.zlb.flower_shop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunPage implements CommandLineRunner {

    public void run(String... args) throws Exception {
        Runtime.getRuntime()
                .exec("cmd   /c   start  http://localhost:8080/flower_shop/login.html");
    }
}