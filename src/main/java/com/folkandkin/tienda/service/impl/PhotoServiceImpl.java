package com.folkandkin.tienda.service.impl;

import com.folkandkin.tienda.domain.entity.Photo;
import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.dto.mapper.IPhotoMapper;
import com.folkandkin.tienda.dto.response.PhotoResponse;
import com.folkandkin.tienda.exception.*;
import com.folkandkin.tienda.repository.IPhotoRepository;
import com.folkandkin.tienda.service.ICloudinaryService;
import com.folkandkin.tienda.service.IPhotoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImpl implements IPhotoService {
    private final ICloudinaryService cloudinaryService;
    private final IPhotoMapper photoMapper;
    private final IPhotoRepository photoRepository;

    public PhotoServiceImpl(ICloudinaryService cloudinaryService, IPhotoMapper photoMapper, IPhotoRepository photoRepository) {
        this.cloudinaryService = cloudinaryService;
        this.photoMapper = photoMapper;
        this.photoRepository = photoRepository;
    }

    @Transactional
    @Override
    public List<Photo> saveAll(List<MultipartFile> photos) {
        List<Photo> response = new ArrayList<>();

        photos.forEach(p -> {
            String url = null;

            try {
                url = this.cloudinaryService.save(p);
            } catch (IOException e) {
                throw new CloudinaryException(e.getMessage());
            }

            Photo photo = new Photo();
            photo.setUrl(url);

            response.add(photo);
        });
        return this.photoRepository.saveAll(response);
    }

    @Transactional
    @Override
    public PhotoResponse save(MultipartFile photo, Product product) {
        if(photo == null){
            throw new PhotoNotNullException("La foto no puede ser nula.");
        }

        if(!photo.isEmpty()){
            String url = null;

            try {
                url = this.cloudinaryService.save(photo);
            } catch (IOException e) {
                throw new CloudinaryException(e.getMessage());
            }

            Photo newPhoto = new Photo();
            newPhoto.setUrl(url);
            newPhoto.setProduct(product);

            return this.photoMapper.mapToDto(this.photoRepository.save(newPhoto));
        } else {
            throw new PhotoIsEmptyException("La foto no puede estar vacía.");
        }
    }
}
