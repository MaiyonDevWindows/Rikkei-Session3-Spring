package com.maiyon.repository;
import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(RoleName roleName);
}
