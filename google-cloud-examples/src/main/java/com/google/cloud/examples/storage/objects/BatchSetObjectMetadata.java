package com.google.cloud.examples.storage.objects;

// [START storage_batch_request]
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageOptions;
import java.util.HashMap;
import java.util.Map;

public class BatchSetObjectMetadata {
  public static void batchSetObjectMetadata(
      String projectId, String bucketName, String directoryPrefix) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The directory prefix. All objects in the bucket with this prefix will have their metadata
    // updated
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("keyToAddOrUpdate", "value");
    Page<Blob> blobs =
        storage.list(
            bucketName,
            Storage.BlobListOption.prefix(directoryPrefix),
            Storage.BlobListOption.currentDirectory());
    StorageBatch batchRequest = storage.batch();

    // Add all blobs with the given prefix to the batch request
    for (Blob blob : blobs.iterateAll()) {
      batchRequest.update(blob.toBuilder().setMetadata(newMetadata).build());
    }

    // Execute the batch request
    batchRequest.submit();

    System.out.println(
        "All blobs in bucket "
            + bucketName
            + " with prefix '"
            + directoryPrefix
            + "' had their metadata updated.");
  }
}
// [END storage_batch_request]
