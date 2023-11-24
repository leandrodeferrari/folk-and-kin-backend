package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Store;
import com.folkandkin.tienda.dto.mapper.IStoreMapper;
import com.folkandkin.tienda.dto.response.StoreResponse;
import com.folkandkin.tienda.repository.IStoreRepository;
import com.folkandkin.tienda.security.domain.entity.User;
import com.folkandkin.tienda.service.IStoreService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {
    private final IStoreMapper storeMapper;
    private final IStoreRepository storeRepository;

    public StoreServiceImpl(IStoreMapper storeMapper, IStoreRepository storeRepository) {
        this.storeMapper = storeMapper;
        this.storeRepository = storeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StoreResponse> findAllByUser(User user) {
        return this.storeMapper.mapToDto(this.storeRepository.findAllByUser(user));
    }

    @Transactional
    @Override
    public StoreResponse save(Store store) {
        return this.storeMapper.mapToDto(this.storeRepository.save(store));
    }
}
