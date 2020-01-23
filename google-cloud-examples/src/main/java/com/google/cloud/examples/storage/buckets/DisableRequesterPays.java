package com.google.cloud.examples.storage.buckets;

// [START storage_disable_requester_pays]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DisableRequesterPays {
    public static void disableRequesterPays(String projectId, String bucketName) {
        // The ID of your GCP project
        // String projectId = "your-project-id";

        // The ID of your GCS bucket
        // String bucketName = "your-unique-bucket-name";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        Bucket bucket = storage.get(bucketName);
        bucket.toBuilder().setRequesterPays(false).build().update();

        System.out.println("Requester pays disabled for bucket " + bucketName);
    }
}
// [END storage_disable_requester_pays]
