package com.test.awss3.service;

import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class PictureUploadService {    
    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Value("${amazon.aws.region}")
    private String s3RegionName;

    public String uploadBase64Image(String base64Image) {
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        String fileName = UUID.randomUUID().toString() + ".jpg";

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType("image/jpeg")
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(imageBytes));

        String imageUrl = "https://" + bucketName + ".s3." + s3RegionName + ".amazonaws.com/" + fileName;
        return imageUrl;
    }
    
}
