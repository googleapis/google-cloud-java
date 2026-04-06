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

// [START storage_upload_part]

import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.MultipartUploadClient;
import com.google.cloud.storage.MultipartUploadSettings;
import com.google.cloud.storage.RequestBody;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

public class UploadPart {
  public static void uploadPart(
      String projectId, String bucketName, String objectName, String uploadId, int partNumber)
      throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The ID of the multipart upload
    // String uploadId = "your-upload-id";

    // The part number of the part being uploaded
    // int partNumber = 1;

    HttpStorageOptions storageOptions =
        HttpStorageOptions.newBuilder().setProjectId(projectId).build();
    MultipartUploadSettings mpuSettings = MultipartUploadSettings.of(storageOptions);
    MultipartUploadClient mpuClient = MultipartUploadClient.create(mpuSettings);

    // The minimum part size for a multipart upload is 5 MiB, except for the last part.
    byte[] bytes = new byte[5 * 1024 * 1024];
    new Random().nextBytes(bytes);
    RequestBody requestBody = RequestBody.of(ByteBuffer.wrap(bytes));

    System.out.println("Uploading part " + partNumber);
    UploadPartRequest uploadPartRequest =
        UploadPartRequest.builder()
            .bucket(bucketName)
            .key(objectName)
            .partNumber(partNumber)
            .uploadId(uploadId)
            .build();

    UploadPartResponse uploadPartResponse = mpuClient.uploadPart(uploadPartRequest, requestBody);

    System.out.println("Part " + partNumber + " uploaded with ETag: " + uploadPartResponse.eTag());
  }
}
// [END storage_upload_part]
