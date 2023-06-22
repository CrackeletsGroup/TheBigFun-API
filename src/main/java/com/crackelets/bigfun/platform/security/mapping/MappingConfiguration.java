package com.crackelets.bigfun.platform.security.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {

    @Bean
    public UserMapper userMapper(){return new UserMapper();}

    @Bean
    public RoleMapper roleMapper(){return new RoleMapper();}
}