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

// [START storage_open_object_read_full_object]

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.ReadAsChannel;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OpenObjectReadFullObject {
  public static void openObjectReadFullObject(String bucketName, String objectName)
      throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object to read
    // String objectName = "your-object-name";

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      ApiFuture<BlobReadSession> futureBlobReadSession = storage.blobReadSession(blobId);

      try (BlobReadSession blobReadSession = futureBlobReadSession.get(10, TimeUnit.SECONDS)) {

        ReadAsChannel readAsChannelConfig = ReadProjectionConfigs.asChannel();
        try (ScatteringByteChannel channel = blobReadSession.readAs(readAsChannelConfig)) {
          long totalBytesRead = 0;
          ByteBuffer buffer = ByteBuffer.allocate(64 * 1024);
          int bytesRead;

          while ((bytesRead = channel.read(buffer)) != -1) {
            totalBytesRead += bytesRead;
            buffer.clear();
          }

          System.out.printf(
              Locale.US,
              "Successfully read a total of %d bytes from object %s%n",
              totalBytesRead,
              blobId.toGsUtilUri());
        }
      }
    }
  }
}
// [END storage_open_object_read_full_object]
