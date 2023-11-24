package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Store;
import com.folkandkin.tienda.dto.response.StoreResponse;
import com.folkandkin.tienda.security.domain.entity.User;

import java.util.List;

public interface IStoreService {
    List<StoreResponse> findAllByUser(User user);
    StoreResponse save(Store store);
}
