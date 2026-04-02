/*
 * Copyright 2022 Google LLC
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

// [START storage_batch_request]
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BatchSetObjectMetadata {
  public static void batchSetObjectMetadata(
      String projectId, String bucketName, String pathPrefix) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The directory prefix. All objects in the bucket with this prefix will have their metadata
    // updated
    // String pathPrefix = "yourPath/";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("keyToAddOrUpdate", "value");
    Page<Blob> blobs =
        storage.list(
            bucketName,
            Storage.BlobListOption.prefix(pathPrefix),
            Storage.BlobListOption.delimiter("/"));
    StorageBatch batchRequest = storage.batch();

    // Add all blobs with the given prefix to the batch request
    List<StorageBatchResult<Blob>> batchResults =
        blobs
            .streamAll()
            .map(blob -> batchRequest.update(blob.toBuilder().setMetadata(newMetadata).build()))
            .collect(Collectors.toList());

    // Execute the batch request
    batchRequest.submit();
    List<StorageException> failures =
        batchResults.stream()
            .map(
                r -> {
                  try {
                    BlobInfo blob = r.get();
                    return null;
                  } catch (StorageException e) {
                    return e;
                  }
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    System.out.println(
        (batchResults.size() - failures.size())
            + " blobs in bucket "
            + bucketName
            + " with prefix '"
            + pathPrefix
            + "' had their metadata updated successfully.");

    if (!failures.isEmpty()) {
      System.out.println("While processing, there were " + failures.size() + " failures");

      for (StorageException failure : failures) {
        failure.printStackTrace(System.out);
      }
    }
  }
}
// [END storage_batch_request]
