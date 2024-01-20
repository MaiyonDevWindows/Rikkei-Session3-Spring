package com.maiyon.service.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.request.UserRegister;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.Role;
import com.maiyon.model.entity.User;
import com.maiyon.model.entity.enums.ActiveStatus;
import com.maiyon.model.entity.enums.RoleName;
import com.maiyon.repository.RoleRepository;
import com.maiyon.repository.UserRepository;
import com.maiyon.security.jwt.JwtProvider;
import com.maiyon.security.user_principal.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public Boolean register(UserRegister userRegister) {
        if(userRepository.findByUsername(userRegister.getUsername()).isEmpty()){
            Role roleUser = roleRepository.findByRoleName(RoleName.ROLE_USER);
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleUser);
            User user = User.builder()
                    .username(userRegister.getUsername())
                    .password(new BCryptPasswordEncoder().encode(userRegister.getPassword()))
                    .fullName(userRegister.getFullName())
                    .email(userRegister.getEmail())
                    .phone(userRegister.getPhone())
                    .address(userRegister.getAddress())
                    .roles(userRoles)
                    .build();
            try{
                userRepository.save(user);
                return true;
            } catch(DataIntegrityViolationException e){
                logger.error("Constraint key error " + e);
            } catch(JpaSystemException e){
                logger.error("Jpa error " + e);
            } catch(Exception e){
                logger.error("Undetermined error " + e);
            }
        } else logger.error("User name is existed, can not sign up with this user name.");
        return false;
    }

    @Override
    public UserResponse login(UserLogin userLogin) {
        UserResponse userResponse = null;
        Authentication authentication;
        try {
            authentication = authenticationProvider.
                    authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(),userLogin.getPassword()));
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            String token = jwtProvider.generateToken(userPrincipal);
            userResponse = UserResponse.builder().
                    fullName(userPrincipal.getUser().getFullName())
                    .id(userPrincipal.getUser().getUserId()).token(token).
                    roles(userPrincipal.getAuthorities()
                            .stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toSet())).
                    build();
        } catch (AuthenticationException e){
            logger.error("User or password is invalid");
            logger.error(e.getMessage());
        } catch (Exception e){
            logger.error("Undetermined error " + e);
        }
        return userResponse;
    }
}
