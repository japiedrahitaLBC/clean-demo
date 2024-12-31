package com.example.cleandemo.domain.use_cases.impl;

import com.example.cleandemo.domain.entities.FileEntity;
import com.example.cleandemo.domain.entities.contracts.FileRepository;
import com.example.cleandemo.domain.use_cases.contracts.FileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;

    @Override
    public FileEntity uploadFile(MultipartFile file, FileEntity fileEntity) {
        return fileRepository.uploadFile(file, fileEntity);
    }
}
