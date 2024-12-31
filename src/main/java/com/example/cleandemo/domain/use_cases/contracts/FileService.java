package com.example.cleandemo.domain.use_cases.contracts;

import com.example.cleandemo.domain.entities.FileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity uploadFile(MultipartFile file, FileEntity fileEntity);
}
