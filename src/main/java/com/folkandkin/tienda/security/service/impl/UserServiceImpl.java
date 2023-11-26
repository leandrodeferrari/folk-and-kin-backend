package com.folkandkin.tienda.security.service.impl;

import com.folkandkin.tienda.exception.PasswordNotMatchException;
import com.folkandkin.tienda.security.config.SecurityConfig;
import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.security.dto.request.ChangePasswordRequest;
import com.folkandkin.tienda.security.dto.response.ChangePasswordResponse;
import com.folkandkin.tienda.security.repository.IUserRepository;
import com.folkandkin.tienda.security.service.IUserService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Clase de objeto de negocio del objeto de dominio Usuario.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> optional = this.userRepository.findByEmail(email);

        if(optional.isPresent()){
            User user = optional.get();

            boolean macthes = this.passwordEncoder.matches(request.getOldPassword(), user.getPassword());

            if(macthes){
                user.setPassword(SecurityConfig.passwordEncoder().encode(request.getNewPassword()));
                return new ChangePasswordResponse("Cambio de contraseña exitoso");
            } else {
                throw new PasswordNotMatchException("Contraseña antigua incorrecta.");
            }
        } else {
            throw new NoSuchElementException("Usuario no encontrado.");
        }
    }
}
