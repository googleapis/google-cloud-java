/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

// [START storage_disable_uniform_bucket_level_access]

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

public class DisableUniformBucketLevelAccess {
  public static void disableUniformBucketLevelAccess(String projectId, String bucketName)
      throws StorageException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // first look up the bucket, so we will have its metageneration
    Bucket bucket = storage.get(bucketName);

    BucketInfo.IamConfiguration iamConfiguration =
        BucketInfo.IamConfiguration.newBuilder()
            .setIsUniformBucketLevelAccessEnabled(false)
            .build();

    storage.update(
        bucket.toBuilder().setIamConfiguration(iamConfiguration).build(),
        BucketTargetOption.metagenerationMatch());

    System.out.println("Uniform bucket-level access was disabled for " + bucketName);
  }
}
// [END storage_disable_uniform_bucket_level_access]
