package com.example.bootrestapi.repository;

import com.example.bootrestapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    Role getByName(String name);
}
