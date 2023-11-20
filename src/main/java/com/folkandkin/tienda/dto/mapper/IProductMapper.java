package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.dto.response.ProductResponse;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz mapeadora para el Producto. Utilizando la librería MapStruct.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring",
        uses = {IStoreMapper.class, IPhotoMapper.class, ICategoryMapper.class,
        IColorProductMapper.class, ISizeProductMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IProductMapper {
    @Mapping(target = "price", expression = "java(entity.getPrice().toPlainString())")
    ProductResponse mapToDto(Product entity);

    List<ProductResponse> mapToDto(List<Product> entities);

    default BigDecimal mapToBigDecimal(String price){
        return new BigDecimal(price);
    }
}
