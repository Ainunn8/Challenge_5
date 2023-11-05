package org.Binar.Challenge.repository;

import org.Binar.Challenge.enumeration.ERole;
import org.Binar.Challenge.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByRoleName(ERole name);

}