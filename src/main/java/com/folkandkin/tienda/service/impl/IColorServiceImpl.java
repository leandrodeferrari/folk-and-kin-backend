package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.dto.mapper.IColorMapper;
import com.folkandkin.tienda.dto.response.ColorResponse;
import com.folkandkin.tienda.repository.IColorRepository;
import com.folkandkin.tienda.service.IColorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de objeto de negocio del objeto de dominio Color.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class IColorServiceImpl implements IColorService {
    private final IColorMapper colorMapper;
    private final IColorRepository colorRepository;

    public IColorServiceImpl(IColorMapper colorMapper, IColorRepository colorRepository) {
        this.colorMapper = colorMapper;
        this.colorRepository = colorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ColorResponse> findAll() {
        return this.colorMapper.mapToDto(this.colorRepository.findAll());
    }
}
