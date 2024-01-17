package com.ra.model.entity;

import com.ra.model.entity.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;
}