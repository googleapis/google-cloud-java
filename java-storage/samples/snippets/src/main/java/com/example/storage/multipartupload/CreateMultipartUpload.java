/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.multipartupload;

// [START storage_create_multipart_upload]

import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.MultipartUploadClient;
import com.google.cloud.storage.MultipartUploadSettings;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import java.util.HashMap;
import java.util.Map;

public class CreateMultipartUpload {
  public static void createMultipartUpload(String projectId, String bucketName, String objectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String sourceBucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String sourceObjectName = "your-object-name";

    HttpStorageOptions storageOptions =
        HttpStorageOptions.newBuilder().setProjectId(projectId).build();
    MultipartUploadSettings mpuSettings = MultipartUploadSettings.of(storageOptions);
    MultipartUploadClient mpuClient = MultipartUploadClient.create(mpuSettings);

    System.out.println("Initiating multipart upload for " + objectName);

    Map<String, String> metadata = new HashMap<>();
    metadata.put("key1", "value1");
    String contentType = "text/plain";
    CreateMultipartUploadRequest createRequest =
        CreateMultipartUploadRequest.builder()
            .bucket(bucketName)
            .key(objectName)
            .metadata(metadata)
            .contentType(contentType)
            .build();

    CreateMultipartUploadResponse createResponse = mpuClient.createMultipartUpload(createRequest);
    String uploadId = createResponse.uploadId();
    System.out.println("Upload ID: " + uploadId);
  }
}
// [END storage_create_multipart_upload]
