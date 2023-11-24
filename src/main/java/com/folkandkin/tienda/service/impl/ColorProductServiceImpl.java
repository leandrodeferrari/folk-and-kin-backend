package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Color;
import com.folkandkin.tienda.domain.entity.ColorProduct;
import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.repository.IColorProductRepository;
import com.folkandkin.tienda.service.IColorProductService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColorProductServiceImpl implements IColorProductService {
    private final IColorProductRepository colorProductRepository;

    public ColorProductServiceImpl(IColorProductRepository colorProductRepository) {
        this.colorProductRepository = colorProductRepository;
    }

    @Transactional
    @Override
    public ColorProduct save(Integer stock, Product product, Color color) {
        ColorProduct colorProduct = new ColorProduct();
        colorProduct.setStock(stock);
        colorProduct.setProduct(product);
        colorProduct.setColor(color);

        return this.colorProductRepository.save(colorProduct);
    }
}
