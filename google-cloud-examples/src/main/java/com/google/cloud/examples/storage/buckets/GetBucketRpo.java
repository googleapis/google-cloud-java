package com.google.cloud.examples.storage.buckets;

// [START storage_get_rpo]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GetBucketRpo {
  public static void getBucketRpo(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    String rpo = bucket.getRpo().toString();

    System.out.println("The RPO setting of bucket " + bucketName + " is " + rpo);
  }
}
// [END storage_get_rpo]
