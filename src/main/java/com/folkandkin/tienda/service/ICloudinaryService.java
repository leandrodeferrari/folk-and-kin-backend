package com.folkandkin.tienda.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICloudinaryService {
    String save(MultipartFile p) throws IOException;
}
