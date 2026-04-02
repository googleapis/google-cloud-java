/*
 * Copyright 2025 Google LLC
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

package com.example.storage.object;

// [START storage_finalize_appendable_object_upload]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class FinalizeAppendableObjectUpload {
  public static void finalizeAppendableObjectUpload(String bucketName, String objectName)
      throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS unfinalized appendable object
    // String objectName = "your-object-name";

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      Blob existingBlob = storage.get(blobId);

      if (existingBlob == null) {
        System.out.println("Object " + objectName + " not found in bucket " + bucketName);
        return;
      }

      BlobInfo blobInfoForTakeover = BlobInfo.newBuilder(existingBlob.getBlobId()).build();
      BlobAppendableUpload finalizingSession =
          storage.blobAppendableUpload(
              blobInfoForTakeover,
              BlobAppendableUploadConfig.of()
                  .withCloseAction(BlobAppendableUploadConfig.CloseAction.FINALIZE_WHEN_CLOSING));

      try (BlobAppendableUpload.AppendableUploadWriteableByteChannel channel =
          finalizingSession.open()) {
        channel.finalizeAndClose();
      }

      System.out.println(
          "Successfully finalized object " + objectName + " in bucket " + bucketName);
    }
  }
}
// [END storage_finalize_appendable_object_upload]
