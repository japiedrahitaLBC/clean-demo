package com.example.cleandemo.domain.entities.contracts;

import com.example.cleandemo.domain.entities.FileEntity;
import org.springframework.web.multipart.MultipartFile;


public interface FileRepository {
    FileEntity uploadFile(MultipartFile file, FileEntity fileEntity);
}
