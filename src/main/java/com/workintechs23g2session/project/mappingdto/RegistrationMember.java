package com.workintechs23g2session.project.mappingdto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationMember {
    private String email;
    private String password;
}

