package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Store;
import com.folkandkin.tienda.dto.mapper.IProductMapper;
import com.folkandkin.tienda.dto.response.ProductResponse;
import com.folkandkin.tienda.exception.IdException;
import com.folkandkin.tienda.exception.StoreNotFoundException;
import com.folkandkin.tienda.repository.IProductRepository;
import com.folkandkin.tienda.repository.IStoreRepository;
import com.folkandkin.tienda.service.IProductService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    private final IStoreRepository storeRepository;

    public ProductServiceImpl(IProductRepository productRepository, IProductMapper productMapper, IStoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.storeRepository = storeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponse> findAll() {
        return this.productMapper.mapToDto(this.productRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponse> findAllByStoreId(Long storeId) {
        this.validId(storeId);

        Optional<Store> optionalStore = this.storeRepository.findById(storeId);

        if(optionalStore.isPresent()){
            Store store = optionalStore.get();

            return this.productMapper.mapToDto(this.productRepository.findAllByStore(store));
        } else {
            throw new StoreNotFoundException("No existe Tienda con ese ID.");
        }
    }

    private void validId(Long id){
        if(id == null){
            throw new IdException("El ID no puede ser nulo.");
        }

        if(id < 1){
            throw new IdException("El ID no puede ser menor a 1.");
        }
    }
}
