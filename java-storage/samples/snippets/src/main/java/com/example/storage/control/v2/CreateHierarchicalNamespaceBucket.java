/*
 * Copyright 2024 Google LLC
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

package com.example.storage.control.v2;

// [START storage_create_bucket_hierarchical_namespace]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public final class CreateHierarchicalNamespaceBucket {

  public static void createHierarchicalNamespaceBucket(String projectId, String bucketName)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";
    StorageOptions storageOptions = StorageOptions.newBuilder().setProjectId(projectId).build();
    try (Storage storage = storageOptions.getService()) {

      BucketInfo bucketInfo =
          BucketInfo.newBuilder(bucketName)
              .setIamConfiguration(
                  // Hierarchical namespace buckets must use uniform bucket-level access.
                  IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
              .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
              .build();

      Bucket bucket = storage.create(bucketInfo);

      System.out.printf(
          "Created bucket %s with Hierarchical Namespace enabled.%n", bucket.getName());
    }
  }
}
// [END storage_create_bucket_hierarchical_namespace]
