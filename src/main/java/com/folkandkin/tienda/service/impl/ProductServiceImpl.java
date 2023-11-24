package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.*;
import com.folkandkin.tienda.dto.mapper.IProductMapper;
import com.folkandkin.tienda.dto.request.ProductRequest;
import com.folkandkin.tienda.dto.response.ProductResponse;
import com.folkandkin.tienda.exception.CategoryIsEmptyException;
import com.folkandkin.tienda.exception.IdException;
import com.folkandkin.tienda.exception.PhotoIsEmptyException;
import com.folkandkin.tienda.exception.StoreNotFoundException;
import com.folkandkin.tienda.repository.IProductRepository;
import com.folkandkin.tienda.repository.IStoreRepository;
import com.folkandkin.tienda.service.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private final ICategoryService categoryService;
    private final IColorService colorService;
    private final IColorProductService colorProductService;
    private final IPhotoService photoService;
    private final IProductRepository productRepository;
    private final IProductMapper productMapper;
    private final ISizeService sizeService;
    private final ISizeProductService sizeProductService;
    private final IStoreRepository storeRepository;

    public ProductServiceImpl(ICategoryService categoryService, IColorService colorService, IColorProductService colorProductService, IPhotoService photoService,
                              IProductRepository productRepository,
                              IProductMapper productMapper,
                              ISizeService sizeService, ISizeProductService sizeProductService, IStoreRepository storeRepository) {
        this.categoryService = categoryService;
        this.colorService = colorService;
        this.colorProductService = colorProductService;
        this.photoService = photoService;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.sizeService = sizeService;
        this.sizeProductService = sizeProductService;
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

        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();

            return this.productMapper.mapToDto(this.productRepository.findAllByStore(store));
        } else {
            throw new StoreNotFoundException("No existe Tienda con ese ID.");
        }
    }

    @Transactional
    @Override
    public ProductResponse save(ProductRequest request) {

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(new BigDecimal(request.getPrice()));
        product.setStock(request.getStock());

        Optional<Store> optionalStore = this.storeRepository.findById(request.getStoreId());

        if(optionalStore.isPresent()){
            product.setStore(optionalStore.get());

            if(!request.getPhotos().isEmpty()){
                List<Photo> photos = this.photoService.saveAll(request.getPhotos());
                product.setPhotos(photos);

                if(!request.getCategoriesId().isEmpty()){
                    List<Category> categories = this.categoryService
                            .findAllById(request.getCategoriesId());

                    product.setCategories(categories);

                    Product response = this.productRepository.save(product);

                    if(request.getColors() != null && !request.getColors().isEmpty()){
                        List<ColorProduct> colorsProduct = new ArrayList<>();

                        request.getColors().forEach(c -> {
                            Optional<Color> optionalColor = this.colorService.findById(c.getColorId());

                            if(optionalColor.isPresent()){
                                Color color = optionalColor.get();
                                Integer stock = c.getStock();
                                ColorProduct colorProduct = this.colorProductService.save(stock, response, color);
                                colorsProduct.add(colorProduct);
                            }
                        });
                        response.setColors(colorsProduct);
                    }

                    if(request.getSizes() != null && !request.getSizes().isEmpty()){
                        List<SizeProduct> sizesProduct = new ArrayList<>();

                        request.getSizes().forEach(s -> {
                            Optional<Size> optionalSize = this.sizeService.findById(s.getSizeId());

                            if(optionalSize.isPresent()){
                                Size size = optionalSize.get();
                                Integer stock = s.getStock();
                                SizeProduct sizeProduct = this.sizeProductService.save(stock, response, size);
                                sizesProduct.add(sizeProduct);
                            }
                        });
                        response.setSizes(sizesProduct);
                    }
                    return this.productMapper.mapToDto(response);
                } else {
                    throw new CategoryIsEmptyException("La lista de categorías no puede estar vacía.");
                }
            } else {
                throw new PhotoIsEmptyException("La lista de fotos no puede estar vacía.");
            }
        } else {
            throw new StoreNotFoundException("No existe tienda con ese ID.");
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
