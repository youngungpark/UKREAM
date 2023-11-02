package com.ukream.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.ukream.dto.UserDTO;

@Mapper
public interface UserMapper {

    public int emailCheck(String email);

    public void createUser(UserDTO user);

    public UserDTO findByEmailAndPassword(UserDTO user);
}
