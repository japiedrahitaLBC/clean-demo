package com.example.cleandemo.infrastructure.driver_adapters;

import com.example.cleandemo.domain.entities.AuthenticateUploadProviderEntity;
import com.example.cleandemo.domain.entities.FileEntity;
import com.example.cleandemo.domain.entities.contracts.FileRepository;
import com.example.cleandemo.domain.entities.contracts.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
@AllArgsConstructor
public class S3AdapterRepository implements FileRepository {

    @Qualifier("postgresAdapterRepository")
    private final ProviderRepository providerRepository;

    @Override
    public FileEntity uploadFile(MultipartFile file, FileEntity fileEntity) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede ser nulo o vacío.");
        }

        Integer authProviderId = fileEntity.getAuthenticateProvider().getId();
        AuthenticateUploadProviderEntity  authProvider =  providerRepository.authProvider(authProviderId);

        FileEntity response = getFileEntity(file, authProvider);

        return response;
    }

    private static FileEntity getFileEntity(MultipartFile file, AuthenticateUploadProviderEntity authProvider) {
        String bucketName = "simulated-bucket";
        String fileName = file.getOriginalFilename();
        String fileUrl = "https://s3.amazonaws.com/" + bucketName + "/" + authProvider + "/" + fileName;

        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(1);
        fileEntity.setFileName(fileName);
        fileEntity.setUrl(fileUrl);
        fileEntity.setBucket(bucketName);
        return fileEntity;
    }
}
