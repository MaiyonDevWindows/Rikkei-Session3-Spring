package com.maiyon.config;

import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.enums.RoleName;
import com.maiyon.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(roleRepository.count() == 0){
            roleRepository.save(new Role(RoleName.ADMIN));
            roleRepository.save(new Role(RoleName.USER));
        }
    }
}
