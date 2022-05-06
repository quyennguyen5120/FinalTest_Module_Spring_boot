package com.example.test_spring_boot.Configuration;

import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Entity.RoleEntity;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.RoleRepository;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserService userService;

//    @GetMapping("/add")
//    public String addUser(){
//        RoleEntity r = roleRepository.findById(1L).get();
//        Set<RoleEntity> roles = new HashSet<>();
//        roles.add(r);
//        UserEntity userEntity = new UserEntity();
//        userEntity.setEmail("quyenproxxxxx@gmail.com");
//        userEntity.setFullname("Nguyễn Hữu Quyền");
//        userEntity.setRoles(roles);
//        userEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
//        userEntity.setUsername("admin");
//        userRepository.save(userEntity);
//        return "redirect:/login";
//    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }

    @PostMapping("/register_account")
    public ResponseEntity<?> registerAccount(UserDto userDto){
        userDto = userService.registerAcc(userDto, bCryptPasswordEncoder);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/403")
    public String forbiedanView(){
        return "403";
    }
}
