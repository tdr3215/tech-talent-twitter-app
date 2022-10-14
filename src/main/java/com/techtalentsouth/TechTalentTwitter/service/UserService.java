package com.techtalentsouth.TechTalentTwitter.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techtalentsouth.TechTalentTwitter.model.Role;
import com.techtalentsouth.TechTalentTwitter.model.User;
import com.techtalentsouth.TechTalentTwitter.repository.RoleRepository;
import com.techtalentsouth.TechTalentTwitter.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	  
	 public UserService(UserRepository userRepository, RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User saveNewUser(User user) {
	
		String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPass);
//	
		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		return userRepository.save(user);
	}
	
	public User getLoggedInUser() {
		String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		return findByUsername(loggedInUsername);
	}


	
	
	
}
