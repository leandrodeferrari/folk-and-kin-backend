package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.domain.entity.Size;
import com.folkandkin.tienda.domain.entity.SizeProduct;

public interface ISizeProductService {
    SizeProduct save(Integer stock, Product response, Size size);
}
