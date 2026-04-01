/*
 * Copyright 2021 Google LLC
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

package com.example.storage;

// [START storage_configure_retries]

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.StorageRetryStrategy;
import org.threeten.bp.Duration;

public final class ConfigureRetries {
  public static void main(String[] args) {
    String bucketName = "my-bucket";
    String blobName = "blob/to/delete";
    deleteBlob(bucketName, blobName);
  }

  static void deleteBlob(String bucketName, String blobName) {
    // Customize retry behavior
    RetrySettings retrySettings =
        StorageOptions.getDefaultRetrySettings().toBuilder()
            // Set the max number of attempts to 10 (initial attempt plus 9 retries)
            .setMaxAttempts(10)
            // Set the backoff multiplier to 3.0
            .setRetryDelayMultiplier(3.0)
            // Set the max duration of all attempts to 5 minutes
            .setTotalTimeout(Duration.ofMinutes(5))
            .build();

    StorageOptions alwaysRetryStorageOptions =
        StorageOptions.newBuilder()
            // Customize retry so all requests are retried even if they are non-idempotent.
            .setStorageRetryStrategy(StorageRetryStrategy.getUniformStorageRetryStrategy())
            // provide the previously configured retrySettings
            .setRetrySettings(retrySettings)
            .build();

    // Instantiate a client
    Storage storage = alwaysRetryStorageOptions.getService();

    // Delete the blob
    BlobId blobId = BlobId.of(bucketName, blobName);
    boolean success = storage.delete(blobId);

    System.out.printf(
        "Deletion of Blob %s completed %s.%n", blobId, success ? "successfully" : "unsuccessfully");
  }
}
// [END storage_configure_retries]
