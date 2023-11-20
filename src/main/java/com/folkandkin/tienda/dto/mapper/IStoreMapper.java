package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Store;
import com.folkandkin.tienda.dto.response.StoreResponse;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz mapeadora para la Tienda. Utilizando la librería MapStruct.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface IStoreMapper {
    StoreResponse mapToDto(Store entity);
    List<StoreResponse> mapToDto(List<Store> entities);
}
