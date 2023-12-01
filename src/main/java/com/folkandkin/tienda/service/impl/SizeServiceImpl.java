package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Size;
import com.folkandkin.tienda.domain.entity.StandardSize;
import com.folkandkin.tienda.dto.mapper.ISizeMapper;
import com.folkandkin.tienda.dto.request.SizeRequest;
import com.folkandkin.tienda.dto.response.SizeResponse;
import com.folkandkin.tienda.exception.SizeExistsException;
import com.folkandkin.tienda.exception.SizeNotNullException;
import com.folkandkin.tienda.repository.ISizeRepository;
import com.folkandkin.tienda.repository.IStandardSizeRepository;
import com.folkandkin.tienda.service.ISizeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    private final IStandardSizeRepository stantardRepository;

    public SizeServiceImpl(ISizeMapper sizeMapper, ISizeRepository sizeRepository, IStandardSizeRepository stantardRepository) {
        this.sizeMapper = sizeMapper;
        this.sizeRepository = sizeRepository;
        this.stantardRepository = stantardRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SizeResponse> findAll() {
        return this.sizeMapper.mapToDto(this.sizeRepository.findAll());
    }

    @Transactional
    @Override
    public SizeResponse save(SizeRequest request) {
        if(request == null){
            throw new SizeNotNullException("La solicitud no puede ser nula.");
        }

        boolean existsByName = this.sizeRepository.existsByName(request.getName());

        if(!existsByName){
            Size size = this.sizeMapper.mapToEntity(request);

            StandardSize standard = this.stantardRepository.findByName("Personalizados").orElseThrow();
            size.setStandard(standard);

            return this.sizeMapper.mapToDto(this.sizeRepository.save(size));
        } else {
            throw new SizeExistsException("El talle " + request.getName() +  " ya existe.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Size> findById(Integer id) {
        return this.sizeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Size> findByName(String sizeName) {
        return this.sizeRepository.findByName(sizeName);
    }
}