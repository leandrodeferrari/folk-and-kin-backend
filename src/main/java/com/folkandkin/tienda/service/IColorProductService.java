package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Color;
import com.folkandkin.tienda.domain.entity.ColorProduct;
import com.folkandkin.tienda.domain.entity.Product;

public interface IColorProductService {
    ColorProduct save(Integer stock, Product product, Color color);
}
