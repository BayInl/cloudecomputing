package org.cc.cloudecomputing.controller;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.dto.UserDTO;
import org.cc.cloudecomputing.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody UserDTO userDTO) {

        return userService.login(userDTO.getName(), userDTO.getPasswd());
    }

    @PutMapping("/register")
    public Object register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO.getName(), userDTO.getPasswd(), userDTO.getPhone());
    }

    @GetMapping("/getUserInfo")
    public Object getUserInfo(@RequestParam String name) {
        return userService.getUserInfo(name);
    }
}
