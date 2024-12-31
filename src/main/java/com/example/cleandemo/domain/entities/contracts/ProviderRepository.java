package com.example.cleandemo.domain.entities.contracts;

import com.example.cleandemo.domain.entities.AuthenticateUploadProviderEntity;

public interface ProviderRepository {
    AuthenticateUploadProviderEntity authProvider(Integer id);
}
