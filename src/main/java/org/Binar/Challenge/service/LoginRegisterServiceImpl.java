package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.enumeration.ERole;
import org.Binar.Challenge.model.Roles;
import org.Binar.Challenge.model.Users;
import org.Binar.Challenge.repository.RoleRepository;
import org.Binar.Challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void registerOauth2User(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        Set<Roles> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(ERole.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found")));
        userRepository.save(Users.builder()
                .password(oAuth2User.getAttributes().get("id").toString())
                .provider("github")
                .roles(roles)
                .username(oAuth2User.getAttributes().get("login").toString())
                .build());
    }

    @Override
    public Optional<Users> loginOauth2User(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        return userRepository.findByUsername(oAuth2User.getAttributes().get("login").toString());
    }
}