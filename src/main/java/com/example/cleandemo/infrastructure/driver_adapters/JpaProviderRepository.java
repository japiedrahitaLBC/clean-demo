package com.example.cleandemo.infrastructure.driver_adapters;

import com.example.cleandemo.domain.entities.AuthenticateUploadProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProviderRepository extends JpaRepository<AuthenticateUploadProviderEntity, Integer> {

}
