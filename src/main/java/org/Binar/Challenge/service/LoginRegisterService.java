package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Users;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface LoginRegisterService {
    public void registerOauth2User(Authentication authentication);
    public Optional<Users> loginOauth2User(Authentication authentication);

}
