package com.fbs.websecurity.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fbs.websecurity.entity.ERole;
import com.fbs.websecurity.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
