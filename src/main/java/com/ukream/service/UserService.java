package com.ukream.service;


import org.springframework.stereotype.Service;

import com.ukream.dto.UserDTO;
import com.ukream.error.exception.AuthenticationFailureException;
import com.ukream.error.exception.DuplicatedEmailException;
import com.ukream.mapper.UserMapper;
import com.ukream.util.SHA256Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    
    /**
     * 회원 가입
     *
     * @param userDTO 회원정보
     * @throws DuplicatedEmailException 제공된 이메일이 시스템에 이미 존재할 경우 발생합니다.
     */
    public void createUser(UserDTO user){
        if(isDuplicatedEmail(user.getEmail())){
            throw new DuplicatedEmailException("중복된 이메일 입니다.");
        }
        user.setPassword(SHA256Util.generateSha256(user.getPassword()));
        userMapper.createUser(user);
    }

    /**
     * 이메일 중복 체크
     *
     * @param email 확인할 이메일 문자열
     * @return 이메일이 이미 등록되어 있으면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     */
    public boolean isDuplicatedEmail(String email) {
        return userMapper.emailCheck(email) == 1 ? true : false;
    }

    public UserDTO login(UserDTO input){
        input.setPassword(SHA256Util.generateSha256(input.getPassword()));
        UserDTO user = userMapper.findByEmailAndPassword(input);
        if(user == null){
            throw new AuthenticationFailureException("유효하지 않은 이메일 또는 비밀번호입니다.");
        }
        return user;
    }
}
