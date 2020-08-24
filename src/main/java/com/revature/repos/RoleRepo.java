package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	Optional<Role> getRoleByRole(String role);
}
