package com.kaede.spring.factory;

import com.kaede.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author kaede
 * @create 2022-07-24 8:20
 */

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
