package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Color;
import com.folkandkin.tienda.dto.mapper.IColorMapper;
import com.folkandkin.tienda.dto.request.ColorRequest;
import com.folkandkin.tienda.dto.response.ColorResponse;
import com.folkandkin.tienda.exception.ColorNotNullException;
import com.folkandkin.tienda.repository.IColorRepository;
import com.folkandkin.tienda.service.IColorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Clase de objeto de negocio del objeto de dominio Color.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class ColorServiceImpl implements IColorService {
    private final IColorMapper colorMapper;
    private final IColorRepository colorRepository;

    public ColorServiceImpl(IColorMapper colorMapper, IColorRepository colorRepository) {
        this.colorMapper = colorMapper;
        this.colorRepository = colorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Color> findById(Integer id) {
        return this.colorRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ColorResponse> findAll() {
        return this.colorMapper.mapToDto(this.colorRepository.findAll());
    }

    @Transactional
    @Override
    public ColorResponse save(ColorRequest request) {
        if(request == null){
            throw new ColorNotNullException("La solicitud no puede ser nula.");
        }

        return this.colorMapper.mapToDto(this.colorRepository.save(this.colorMapper.mapToEntity(request)));
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Color> findByName(String colorName) {
        return this.colorRepository.findByName(colorName);
    }
}