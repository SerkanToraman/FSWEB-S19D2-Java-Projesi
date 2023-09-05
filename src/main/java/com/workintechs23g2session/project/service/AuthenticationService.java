package com.workintechs23g2session.project.service;

import com.workintechs23g2session.project.entity.Member;
import com.workintechs23g2session.project.entity.Role;
import com.workintechs23g2session.project.repository.MemberRepository;
import com.workintechs23g2session.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class AuthenticationService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member register(String email,String password){
        Optional<Member>existsMember = memberRepository.findMemberByEmail(email);
        if(existsMember.isPresent()){
            return null;
            //it is better to throw exception
        }
        String encodedPassword = passwordEncoder.encode(password);
        Role memberRole = roleRepository.findByAuthority("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(memberRole);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setAuthorities(roles);
        return memberRepository.save(member);
    }
}
