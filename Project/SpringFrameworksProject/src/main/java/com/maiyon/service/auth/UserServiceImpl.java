package com.maiyon.service.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.User;
import com.maiyon.model.entity.enums.RoleName;
import com.maiyon.repository.RoleRepository;
import com.maiyon.repository.UserRepository;
import com.maiyon.security.jwt.JwtProvider;
import com.maiyon.security.user_principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public User register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Role role = roleRepository.findByRoleName(RoleName.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public UserResponse login(UserLogin userLogin) {
        Authentication authentication;
        try {
            authentication = authenticationProvider.
                    authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(),userLogin.getPassword()));
        } catch (AuthenticationException exception){
            throw new RuntimeException("username or password sai cmnr");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtProvider.generateToken(userPrincipal);
        return UserResponse.builder().
                fullName(userPrincipal.getUser().getFullName())
                .id(userPrincipal.getUser().getUserId()).token(token).
                roles(userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet())).
                build();
    }
}
