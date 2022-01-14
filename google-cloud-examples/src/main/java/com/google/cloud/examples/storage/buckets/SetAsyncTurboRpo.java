package com.google.cloud.examples.storage.buckets;

// [START storage_set_rpo_async_turbo]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Rpo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class SetAsyncTurboRpo {
  public static void setAsyncTurboRpo(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    bucket.toBuilder().setRpo(Rpo.ASYNC_TURBO).build().update();

    System.out.println("Turbo replication was enabled for " + bucketName);
  }
}
// [END storage_set_rpo_async_turbo]
