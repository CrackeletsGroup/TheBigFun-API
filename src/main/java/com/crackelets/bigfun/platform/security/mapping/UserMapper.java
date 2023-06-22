package com.crackelets.bigfun.platform.security.mapping;

import com.crackelets.bigfun.platform.security.domain.model.entity.Role;
import com.crackelets.bigfun.platform.security.domain.model.entity.User;
import com.crackelets.bigfun.platform.security.resource.UserResource;
import com.crackelets.bigfun.platform.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    Converter<Role, String> roleToString = new AbstractConverter<Role, String>() {
        @Override
        protected String convert(Role role) {
            return role == null ? null : role.getName().name();
        }
    };

    public UserResource toResource(User model){
        mapper.addConverter(roleToString);
        return  mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable){
        mapper.addConverter(roleToString);
        return new PageImpl<>(mapper.mapList(modelList,UserResource.class), pageable, modelList.size());
    }
}