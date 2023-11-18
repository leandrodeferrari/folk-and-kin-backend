package com.folkandkin.tienda.security.service.impl;

import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.security.repository.IUserRepository;
import com.folkandkin.tienda.security.domain.UserDetailsImpl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Clase de objeto de negocio del objeto que representa al usuario logueado.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository userRepository;

    public UserDetailsServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email).orElseThrow();

        return new UserDetailsImpl(user);
    }
}
