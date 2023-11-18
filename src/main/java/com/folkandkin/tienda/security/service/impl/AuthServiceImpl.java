package com.folkandkin.tienda.security.service.impl;

import com.folkandkin.tienda.security.domain.entity.Role;
import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.security.domain.enums.RoleName;
import com.folkandkin.tienda.security.repository.IUserRepository;
import com.folkandkin.tienda.security.config.SecurityConfig;
import com.folkandkin.tienda.security.domain.UserDetailsImpl;
import com.folkandkin.tienda.security.dto.mapper.IRegisterMapper;
import com.folkandkin.tienda.security.dto.request.LoginRequest;
import com.folkandkin.tienda.security.dto.request.RegisterRequest;
import com.folkandkin.tienda.security.dto.response.LoginResponse;
import com.folkandkin.tienda.security.dto.response.RegisterResponse;
import com.folkandkin.tienda.security.jwt.JwtTokenProvider;
import com.folkandkin.tienda.security.service.IAuthService;
import com.folkandkin.tienda.security.service.IRoleService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase de objeto de negocio de Auth.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authManager;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final IUserRepository userRepository;
    private final IRegisterMapper registerMapper;
    private final IRoleService roleService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authManager, UserDetailsServiceImpl userDetailsServiceImpl, IUserRepository userRepository, IRegisterMapper registerMapper, IRoleService roleService, JwtTokenProvider jwtTokenProvider) {
        this.authManager = authManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepository = userRepository;
        this.registerMapper = registerMapper;
        this.roleService = roleService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        this.authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetailsImpl userDetailsImpl = this.userDetailsServiceImpl.loadUserByUsername(request.getEmail());

        String token = jwtTokenProvider.generateToken(userDetailsImpl);

        return new LoginResponse(userDetailsImpl.getUsername(), token);
    }

    @Transactional
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = this.registerMapper.mapToEntity(request);

        Role role = this.roleService.findByName(RoleName.ADMIN.getName());
        user.setRole(role);
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));

        RegisterResponse response = this.registerMapper.mapToDto(this.userRepository.save(user));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());

        LoginResponse loginResponse = this.login(loginRequest);
        response.setToken(loginResponse.getToken());

        return response;
    }
}
