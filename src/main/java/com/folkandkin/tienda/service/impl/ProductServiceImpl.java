package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.dto.mapper.IProductMapper;
import com.folkandkin.tienda.dto.response.ProductResponse;
import com.folkandkin.tienda.repository.IProductRepository;
import com.folkandkin.tienda.service.IProductService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de objeto de negocio del objeto de dominio Producto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public ProductServiceImpl(IProductRepository productRepository, IProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponse> findAll() {
        return this.productMapper.mapToDto(this.productRepository.findAll());
    }
}
