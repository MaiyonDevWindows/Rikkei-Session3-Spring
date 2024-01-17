package com.maiyon.config;

import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.enums.RoleName;
import com.maiyon.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEvent {
    @Autowired
    private RoleRepository roleRepository;
    @PostConstruct
    public void initializeData() {
        roleRepository.save(new Role(RoleName.ADMIN));
        roleRepository.save(new Role(RoleName.USER));
    }
}
