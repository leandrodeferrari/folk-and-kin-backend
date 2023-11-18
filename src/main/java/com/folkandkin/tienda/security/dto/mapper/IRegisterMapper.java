package com.folkandkin.tienda.security.dto.mapper;

import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.security.dto.request.RegisterRequest;
import com.folkandkin.tienda.security.dto.response.RegisterResponse;

import org.mapstruct.Mapper;

/**
 * Interfaz mapeadora para el Registro. Utilizando la librería MapStruct.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface IRegisterMapper {
    User mapToEntity(RegisterRequest dto);
    RegisterResponse mapToDto(User entity);
}
