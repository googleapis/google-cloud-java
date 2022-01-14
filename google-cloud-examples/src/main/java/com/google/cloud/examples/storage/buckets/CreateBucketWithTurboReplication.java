package com.google.cloud.examples.storage.buckets;

// [START storage_create_bucket_turbo_replication]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Rpo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class CreateBucketWithTurboReplication {
  public static void createBucketWithTurboReplication(
      String projectId, String bucketName, String location) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The dual-region location to create your bucket in
    // String location = "NAM4"

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Bucket bucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                .setLocation(location)
                .setRpo(Rpo.ASYNC_TURBO)
                .build());

    System.out.println(
        "Created bucket "
            + bucket.getName()
            + " in "
            + bucket.getLocation()
            + " with RPO setting"
            + bucket.getRpo());
  }
}
// [END storage_create_bucket_turbo_replication]
