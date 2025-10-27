// src/main/java/com/example/servingwebcontent/Repository/RoleRepository.java
package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}