package org.cc.cloudecomputing.service;

import org.cc.cloudecomputing.util.Result;

public interface UserService {
    Result<?> login(String name, String passwd);
    Result<?> register(String name, String passwd, long phone);
    Result<?> getUserInfo(String name);
}
