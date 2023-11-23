package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Photo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoService {
    List<Photo> saveAll(List<MultipartFile> photos);
}
