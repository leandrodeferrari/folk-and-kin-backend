package com.folkandkin.tienda.security.service.impl;

import com.folkandkin.tienda.domain.entity.Store;
import com.folkandkin.tienda.dto.response.StoreResponse;
import com.folkandkin.tienda.exception.EmailNotFoundException;
import com.folkandkin.tienda.security.domain.entity.Role;
import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.security.domain.enums.RoleName;
import com.folkandkin.tienda.security.dto.response.LogoutResponse;
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
import com.folkandkin.tienda.service.IStoreService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    private final IStoreService storeService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authManager, UserDetailsServiceImpl userDetailsServiceImpl, IUserRepository userRepository, IRegisterMapper registerMapper, IRoleService roleService, IStoreService storeService, JwtTokenProvider jwtTokenProvider) {
        this.authManager = authManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepository = userRepository;
        this.registerMapper = registerMapper;
        this.roleService = roleService;
        this.storeService = storeService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> optional = this.userRepository.findByEmail(request.getEmail());

        if(optional.isPresent()){
            this.authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            UserDetailsImpl userDetailsImpl = this.userDetailsServiceImpl.loadUserByUsername(request.getEmail());

            String token = jwtTokenProvider.generateToken(userDetailsImpl);

            List<StoreResponse> stores = this.storeService.findAllByUser(optional.get());

            return new LoginResponse(userDetailsImpl.getUsername(), token, stores);
        } else {
            throw new EmailNotFoundException("No existe usuario con el email ingresado.");
        }
    }

    @Transactional
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = this.registerMapper.mapToEntity(request);

        Role role = this.roleService.findByName(RoleName.ADMIN.getName());
        user.setRole(role);
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));

        User user1 = this.userRepository.save(user);

        Store store = new Store();
        store.setName(request.getStoreName());
        store.setUser(user1);

        StoreResponse storeResponse = this.storeService.save(store);

        RegisterResponse response = this.registerMapper.mapToDto(user1);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());

        LoginResponse loginResponse = this.login(loginRequest);
        response.setToken(loginResponse.getToken());
        response.setStore(storeResponse);

        return response;
    }

    @Override
    public LogoutResponse logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return new LogoutResponse("Cierre de sesión exitoso.");
        } else {
            return new LogoutResponse("Ya se encontraba cerrada la sesión.");
        }
    }
}
