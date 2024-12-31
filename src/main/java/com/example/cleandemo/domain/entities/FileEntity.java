package com.example.cleandemo.domain.entities;

import lombok.Data;

@Data
public class FileEntity {
    private Integer id;
    private String url;
    private AuthenticateUploadProviderEntity authenticateProvider;
    private String bucket;
    private String fileName;
    private String fileContentBase64;
}


