package com.example.cleandemo.infrastructure.driver_adapters;

import com.example.cleandemo.domain.entities.AuthenticateUploadProviderEntity;
import com.example.cleandemo.domain.entities.contracts.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PostgresAdapterRepository implements ProviderRepository {
    private final JpaProviderRepository jpaProviderRepository;

    @Override
    public AuthenticateUploadProviderEntity authProvider(Integer id) {
        return jpaProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found for ID: " + id));
    }
}
