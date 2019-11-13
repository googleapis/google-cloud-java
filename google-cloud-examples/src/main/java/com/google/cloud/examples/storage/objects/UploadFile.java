package com.google.cloud.examples.storage.objects;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class UploadFile {
    public static void uploadFile(String projectId, String bucketName, String objectName, String filePath) {
        // String projectId = "your-project-id";
        // String bucketName = "your-unique-bucket-name";
        // String objectName = "name-for-your-gcs-object"
        // String filePath = "path-to-your-file-to-upload"
        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    }
}
