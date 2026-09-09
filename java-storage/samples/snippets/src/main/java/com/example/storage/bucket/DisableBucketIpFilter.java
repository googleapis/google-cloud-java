/*
 * Copyright 2026 Google LLC
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

package com.example.storage.bucket;

// [START storage_disable_ip_filtering]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DisableBucketIpFilter {
  public static Bucket disableBucketIpFilter(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    if (bucket.getIpFilter() == null) {
      System.out.println("Bucket " + bucketName + " has no IP Filter configured.");
      return bucket;
    }

    IpFilter disabledIpFilter = bucket.getIpFilter().toBuilder().setMode("Disabled").build();
    Bucket updatedBucket = storage.update(bucket.toBuilder().setIpFilter(disabledIpFilter).build());

    System.out.println("IP filtering disabled for bucket " + bucketName);
    return updatedBucket;
  }
}
// [END storage_disable_ip_filtering]
