package com.ukream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.ukream.dto.UserDTO;

@Mapper
public interface AdminMapper {

    public List<UserDTO> findByUsers();
}