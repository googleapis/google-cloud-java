/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.storage.buckets;

// [START storage_get_bucket_metadata]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.Map;

public class GetBucketMetadata {
  public static void getBucketMetadata(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // Select all fields. Fields can be selected individually e.g. Storage.BucketField.NAME
    Bucket bucket =
        storage.get(bucketName, Storage.BucketGetOption.fields(Storage.BucketField.values()));

    // Print bucket metadata
    System.out.println("BucketName: " + bucket.getName());
    System.out.println("DefaultEventBasedHold: " + bucket.getDefaultEventBasedHold());
    System.out.println("DefaultKmsKeyName: " + bucket.getDefaultKmsKeyName());
    System.out.println("Id: " + bucket.getGeneratedId());
    System.out.println("IndexPage: " + bucket.getIndexPage());
    System.out.println("Location: " + bucket.getLocation());
    System.out.println("LocationType: " + bucket.getLocationType());
    System.out.println("Metageneration: " + bucket.getMetageneration());
    System.out.println("NotFoundPage: " + bucket.getNotFoundPage());
    System.out.println("RetentionEffectiveTime: " + bucket.getRetentionEffectiveTime());
    System.out.println("RetentionPeriod: " + bucket.getRetentionPeriod());
    System.out.println("RetentionPolicyIsLocked: " + bucket.retentionPolicyIsLocked());
    System.out.println("RequesterPays: " + bucket.requesterPays());
    System.out.println("SelfLink: " + bucket.getSelfLink());
    System.out.println("StorageClass: " + bucket.getStorageClass().name());
    System.out.println("TimeCreated: " + bucket.getCreateTime());
    System.out.println("VersioningEnabled: " + bucket.versioningEnabled());
    if (bucket.getLabels() != null) {
      System.out.println("\n\n\nLabels:");
      for (Map.Entry<String, String> label : bucket.getLabels().entrySet()) {
        System.out.println(label.getKey() + "=" + label.getValue());
      }
    }
    if (bucket.getLifecycleRules() != null) {
      System.out.println("\n\n\nLifecycle Rules:");
      for (BucketInfo.LifecycleRule rule : bucket.getLifecycleRules()) {
        System.out.println(rule);
      }
    }
  }
}
// [END storage_get_bucket_metadata]
