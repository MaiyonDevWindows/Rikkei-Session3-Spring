package com.maiyon.config.initilize;

import com.maiyon.model.entity.Category;
import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.enums.RoleName;
import com.maiyon.repository.CategoryRepository;
import com.maiyon.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitSamplesData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initRoleSampleData();
        initCategorySampleData();
    }
    public void initCategorySampleData(){
        if(categoryRepository.count() == 0){
            categoryRepository.save(new Category("Áo", "Mô tả"));
            categoryRepository.save(new Category("Quần", "Mô tả"));
            categoryRepository.save(new Category("Phụ kiện", "Mô tả"));
            categoryRepository.save(new Category("Laptop", "Mô tả"));
            categoryRepository.save(new Category("Smartphone", "Mô tả"));
            categoryRepository.save(new Category("Macbook", "Mô tả"));
            categoryRepository.save(new Category("Chuột", "Mô tả"));
            categoryRepository.save(new Category("Bàn phím", "Mô tả"));
            categoryRepository.save(new Category("Tai nghe", "Mô tả"));
            categoryRepository.save(new Category("Đèn màn hình", "Mô tả"));
        }
    }
    public void initRoleSampleData(){
        if(roleRepository.count() == 0){
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            roleRepository.save(new Role(RoleName.ROLE_USER));
        }
    }
}
