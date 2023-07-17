package com.test.awss3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSS3Config {
    @Value("${amazon.aws.accessKey}")
    private String accessKeyId;

    @Value("${amazon.aws.secretKey}")
    private String accessKeySecret;

    @Value("${amazon.aws.region}")
    private String s3RegionName;

    @Bean
    public S3Client s3Client() {
        final AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, accessKeySecret);
        return S3Client.builder()
                .region(Region.of(s3RegionName))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }
}
