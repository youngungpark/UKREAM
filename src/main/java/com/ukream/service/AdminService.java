package com.ukream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ukream.dto.UserDTO;
import com.ukream.mapper.AdminMapper;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<UserDTO> findByUsers() {
        return adminMapper.findByUsers();
    }
}