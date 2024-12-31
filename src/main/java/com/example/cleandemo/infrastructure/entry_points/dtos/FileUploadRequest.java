package com.example.cleandemo.infrastructure.entry_points.dtos;

import com.example.cleandemo.domain.entities.FileEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadRequest extends FileEntity {
    private Integer id;
    private String bucket;
    private String fileName;
    private String fileContentBase64;
}
