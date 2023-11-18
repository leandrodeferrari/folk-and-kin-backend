package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.dto.mapper.ICategoryMapper;
import com.folkandkin.tienda.dto.request.CategoryRequest;
import com.folkandkin.tienda.dto.response.CategoryResponse;
import com.folkandkin.tienda.exception.CategoryNotNullException;
import com.folkandkin.tienda.repository.ICategoryRepository;
import com.folkandkin.tienda.service.ICategoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de objeto de negocio del objeto de dominio Categoria.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    public CategoryServiceImpl(ICategoryRepository categoryRepository, ICategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryResponse> findAll() {
        return this.categoryMapper.mapToDto(this.categoryRepository.findAll());
    }

    @Transactional
    @Override
    public CategoryResponse save(CategoryRequest request) {
        if(request == null){
            throw new CategoryNotNullException("La solicitud no puede ser nula.");
        }

        return this.categoryMapper.mapToDto(this.categoryRepository.save(this.categoryMapper.mapToEntity(request)));
    }
}
