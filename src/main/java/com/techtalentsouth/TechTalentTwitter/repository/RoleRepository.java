package com.techtalentsouth.TechTalentTwitter.repository;

import org.springframework.data.repository.CrudRepository;

import com.techtalentsouth.TechTalentTwitter.model.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{
	Role findByRole(String role);
}
