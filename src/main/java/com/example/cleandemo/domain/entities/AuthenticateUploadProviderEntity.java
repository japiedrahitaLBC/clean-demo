package com.example.cleandemo.domain.entities;

import lombok.Data;

@Data
public class AuthenticateUploadProviderEntity {
    private Integer id;
    private String secretKey;
    private String key;
}