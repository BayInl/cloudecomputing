package org.cc.cloudecomputing.service.Impl;

import jakarta.annotation.Resource;
import netscape.javascript.JSObject;
import org.cc.cloudecomputing.dao.UserDao;
import org.cc.cloudecomputing.entity.User;
import org.cc.cloudecomputing.service.UserService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Result<?> login(String name, String passwd) {
        User user = userDao.findByName(name);
        if (user == null) {
            return Result.error(404, "User not found");
        }
        if (!user.getPasswd().equals(passwd)) {
            return Result.error(400, "Wrong password");
        }
        return Result.success("Login success", user);
    }

    @Override
    public Result<?> register(String name, String passwd, long phone) {
        User user = userDao.findByName(name);
        if (user != null) {
            return Result.error(400, "User already exists");
        }
        user = new User();
        user.setName(name);
        user.setPasswd(passwd);
        user.setPhone(phone);
        System.out.println(user);
        user=userDao.save(user);

        return Result.success("Register success", user);
    }

    @Override
    public Result<?> getUserInfo(String name) {
        User user = userDao.findByName(name);
        if (user == null) {
            return Result.error(404, "User not found");
        }
        return Result.success("Get user info success", user);
    }
}
