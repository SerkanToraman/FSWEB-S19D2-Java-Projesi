package com.workintechs23g2session.project;

import com.workintechs23g2session.project.entity.Member;
import com.workintechs23g2session.project.entity.Role;
import com.workintechs23g2session.project.repository.MemberRepository;
import com.workintechs23g2session.project.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, MemberRepository memberRepository,
						  PasswordEncoder passwordEncoder) {
		return args -> {
//			if(roleRepository.findByAuthority("ADMIN").isPresent()){
//				return;
//			}

			Role adminRole = new Role();
			adminRole.setAuthority("ADMIN");

			Role userRole = new Role();
			userRole.setAuthority("USER");

			roleRepository.save(adminRole);
			roleRepository.save(userRole);
			Set<Role> roleSet = new HashSet<>();
			roleSet.add(adminRole);

			Member admin = new Member();
			admin.setEmail("serkan@test.com");
			admin.setPassword(passwordEncoder.encode("deneme"));
			admin.setAuthorities(roleSet);
			memberRepository.save(admin);

		};
	}
}
