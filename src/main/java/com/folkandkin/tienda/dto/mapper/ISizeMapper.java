package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Size;
import com.folkandkin.tienda.dto.request.SizeRequest;
import com.folkandkin.tienda.dto.response.SizeResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Interfaz mapeadora para el Talle. Utilizando la librería MapStruct.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface ISizeMapper {
    Size mapToEntity(SizeRequest dto);

    @Mapping(target = "standard", source = "entity.standard.name")
    SizeResponse mapToDto(Size entity);

    @Mapping(target = "standard", ignore = true)
    List<SizeResponse> mapToDto(List<Size> entities);
}
