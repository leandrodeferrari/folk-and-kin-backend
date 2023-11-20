package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Photo;
import com.folkandkin.tienda.dto.response.PhotoResponse;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz mapeadora para la Foto. Utilizando la librería MapStruct.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface IPhotoMapper {
    PhotoResponse mapToDto(Photo entity);
    List<PhotoResponse> mapToDto(List<Photo> entities);
}
