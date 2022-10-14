package com.techtalentsouth.TechTalentTwitter.repository;

import org.springframework.data.repository.CrudRepository;

import com.techtalentsouth.TechTalentTwitter.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
 
	User findByUsername(String username);
}
