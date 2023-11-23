package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.domain.entity.Size;
import com.folkandkin.tienda.domain.entity.SizeProduct;
import com.folkandkin.tienda.repository.ISizeProductRepository;
import com.folkandkin.tienda.service.ISizeProductService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SizeProductServiceImpl implements ISizeProductService {
    private final ISizeProductRepository sizeProductRepository;

    public SizeProductServiceImpl(ISizeProductRepository sizeProductRepository) {
        this.sizeProductRepository = sizeProductRepository;
    }

    @Transactional
    @Override
    public SizeProduct save(Integer stock, Product response, Size size) {
        SizeProduct sizeProduct = new SizeProduct();
        sizeProduct.setStock(stock);
        sizeProduct.setProduct(response);
        sizeProduct.setSize(size);

        return this.sizeProductRepository.save(sizeProduct);
    }
}
