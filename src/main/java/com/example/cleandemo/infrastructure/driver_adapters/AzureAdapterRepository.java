package com.example.cleandemo.infrastructure.driver_adapters;

import com.example.cleandemo.domain.entities.AuthenticateUploadProviderEntity;
import com.example.cleandemo.domain.entities.FileEntity;
import com.example.cleandemo.domain.entities.contracts.FileRepository;
import com.example.cleandemo.domain.entities.contracts.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class AzureAdapterRepository  implements FileRepository {

    @Qualifier("postgresAdapterRepository")
    private final ProviderRepository providerRepository;

    @Override
    public FileEntity uploadFile(MultipartFile file, FileEntity fileEntity) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede ser nulo o vacío.");
        }

        Integer authProviderId = fileEntity.getAuthenticateProvider().getId();
        AuthenticateUploadProviderEntity  authProvider =  providerRepository.authProvider(authProviderId);

        String containerName = "example-container";
        String uniqueFileName = generateUniqueFileName(file.getOriginalFilename());
        String azureUrl = String.format("https://azurestorage.example.com/%s/%s", containerName, uniqueFileName);

        fileEntity.setUrl(azureUrl);
        fileEntity.setFileName(uniqueFileName);
        fileEntity.setBucket(containerName);
        fileEntity.setAuthenticateProvider(authProvider);

        return fileEntity;
    }

    private String generateUniqueFileName(String originalFilename) {
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueName = UUID.randomUUID().toString();
        return uniqueName + fileExtension;
    }
}
