package com.example.test_spring_boot.Controller;

import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/manager_user")
    public String managerUser(Model model, HttpServletRequest request){
        List<UserDto> userDtoList = userRepository.findAll().stream().map(x-> new UserDto(x)).collect(Collectors.toList());
        model.addAttribute("lstUser", userDtoList);
        model.addAttribute("userDto", new UserDto());
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/user/index";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/create_update_user")
    public String registerAccount(UserDto userDto){
        userDto = userService.updateAcc(userDto, bCryptPasswordEncoder);
        return "redirect:/user/manager_user";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/user_detail/{id}")
    public String user_detail(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        model.addAttribute("userDto", new UserDto(userRepository.getById(id)));
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/user/user_detail";
    }

    @GetMapping("/remove_user/{id}")
    @Secured({"ROLE_ADMIN"})
    public String removeUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/user/manager_user";
    }
}
