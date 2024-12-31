package com.example.cleandemo.infrastructure.entry_points.dtos;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class FileDto {
    private Integer id;
    private String url;
    private String bucket;
    private String fileName;
    private String fileContentBase64;
}
