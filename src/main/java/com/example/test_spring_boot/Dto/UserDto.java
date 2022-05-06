package com.example.test_spring_boot.Dto;

import com.example.test_spring_boot.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullname;
    private String password;
    private Date createDate;
    private String createBy;

    public UserDto(UserEntity userEntity){
       if(userEntity!= null){
           this.id = userEntity.getId();
           this.username = userEntity.getUsername();
           this.email = userEntity.getEmail();
           this.fullname = userEntity.getFullname();
           this.createBy = userEntity.getCreateBy();
           this.createDate = userEntity.getCreateDate();
           this.password = userEntity.getPassword();
       }
    }
}
