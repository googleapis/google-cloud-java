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

// [START storage_open_object_multiple_ranged_read]

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenObjectMultipleRangedRead {
  public static void openObjectMultipleRangedRead(
      String bucketName, String objectName, long offset1, int length1, long offset2, int length2)
      throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The beginning of the range 1
    // long offset = 0

    // The maximum number of bytes to read in range 1
    // int length = 16;

    // The beginning of the range 2
    // long offset = 16

    // The maximum number of bytes to read in range 2
    // int length = 32;

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      ApiFuture<BlobReadSession> futureBlobReadSession = storage.blobReadSession(blobId);
      RangeSpec rangeSpec1 = RangeSpec.of(offset1, length1);
      RangeSpec rangeSpec2 = RangeSpec.of(offset2, length2);

      try (BlobReadSession blobReadSession = futureBlobReadSession.get(10, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> future1 =
            blobReadSession.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(rangeSpec1));
        ApiFuture<byte[]> future2 =
            blobReadSession.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(rangeSpec2));

        List<byte[]> allBytes = ApiFutures.allAsList(ImmutableList.of(future1, future2)).get();

        byte[] bytes1 = allBytes.get(0);
        byte[] bytes2 = allBytes.get(1);

        System.out.println(
            "Successfully read "
                + bytes1.length
                + " bytes from range 1 and "
                + bytes2.length
                + " bytes from range 2.");
      }
    }
  }
}

// [END storage_open_object_multiple_ranged_read]
