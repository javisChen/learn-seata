package io.seata.samples.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class UserConfig {

    @Bean
    public User user() {
        return new User();
    }

}
