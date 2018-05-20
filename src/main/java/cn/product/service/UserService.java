package cn.product.service;

import cn.product.mapper.UserMapper;
import cn.product.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public List<User> findAll() {
        return mapper.select(new User());
    }

    public User findByAccount(String account) {
        User us = new User();
        us.setAccount(account);
        return mapper.selectOne(us);
    }
}
