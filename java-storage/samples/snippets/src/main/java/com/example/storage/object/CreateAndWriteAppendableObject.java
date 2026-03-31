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

// [START storage_create_and_write_appendable_object_upload]

import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.FlushPolicy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.util.Locale;

public class CreateAndWriteAppendableObject {
  public static void createAndWriteAppendableObject(
      String bucketName, String objectName, String filePath) throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to the file to upload
    // String filePath = "path/to/your/file";

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

      int flushSize = 64 * 1000;
      FlushPolicy.MaxFlushSizeFlushPolicy flushPolicy = FlushPolicy.maxFlushSize(flushSize);
      BlobAppendableUploadConfig config =
          BlobAppendableUploadConfig.of()
              .withCloseAction(CloseAction.FINALIZE_WHEN_CLOSING)
              .withFlushPolicy(flushPolicy);
      BlobAppendableUpload uploadSession = storage.blobAppendableUpload(blobInfo, config);
      try (AppendableUploadWriteableByteChannel channel = uploadSession.open();
          ReadableByteChannel readableByteChannel = FileChannel.open(Paths.get(filePath))) {
        ByteStreams.copy(readableByteChannel, channel);
        // Since the channel is in a try-with-resources block, channel.close()
        // will be implicitly called here, which triggers the finalization.
      } catch (IOException ex) {
        throw new IOException("Failed to upload to object " + blobId.toGsUtilUri(), ex);
      }
      BlobInfo result = storage.get(blobId);
      System.out.printf(
          Locale.US,
          "Object %s successfully uploaded",
          result.getBlobId().toGsUtilUriWithGeneration());
    }
  }
}

// [END storage_create_and_write_appendable_object_upload]
