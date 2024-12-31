package com.example.cleandemo.infrastructure.entry_points.api;


import com.example.cleandemo.domain.entities.FileEntity;
import com.example.cleandemo.domain.use_cases.contracts.FileService;
import com.example.cleandemo.infrastructure.entry_points.dtos.FileUploadRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/upload")
public class UploadFileController {

    private final FileService fileService;

    @PostMapping("/")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestBody FileUploadRequest fileUploadRequest) {

        FileEntity uploadedFile = fileService.uploadFile(file, fileUploadRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(uploadedFile);
    }
}
