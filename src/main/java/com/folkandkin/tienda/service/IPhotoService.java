package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Photo;
import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.dto.response.PhotoResponse;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoService {
    List<Photo> saveAll(List<MultipartFile> photos);
    PhotoResponse save(MultipartFile photo, Product product);
}
