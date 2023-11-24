package com.folkandkin.tienda.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.folkandkin.tienda.service.ICloudinaryService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CloudinaryServiceImpl implements ICloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String save(MultipartFile photo) throws IOException {
        return this.cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.emptyMap()).get("secure_url").toString();
    }
}
