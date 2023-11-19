package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.dto.mapper.ISizeMapper;
import com.folkandkin.tienda.dto.response.SizeResponse;
import com.folkandkin.tienda.repository.ISizeRepository;
import com.folkandkin.tienda.service.ISizeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de objeto de negocio del objeto de dominio Talle.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class SizeServiceImpl implements ISizeService {
    private final ISizeMapper sizeMapper;
    private final ISizeRepository sizeRepository;

    public SizeServiceImpl(ISizeMapper sizeMapper, ISizeRepository sizeRepository) {
        this.sizeMapper = sizeMapper;
        this.sizeRepository = sizeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SizeResponse> findAll() {
        return this.sizeMapper.mapToDto(this.sizeRepository.findAll());
    }
}
