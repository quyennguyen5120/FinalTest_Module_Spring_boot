package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface UserService {
    void checkExistUserOauth(String username, String method);
    UserDto registerAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder);
    UserDto updateAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder);
}
