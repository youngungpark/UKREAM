package com.ukream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ukream.annotation.LoginCheck;
import com.ukream.dto.UserDTO;
import com.ukream.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    @GetMapping("/usersSㄴ")
    public List<UserDTO> findByUsers() {
        return adminService.findByUsers();
    }
}
