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

// [START storage_set_public_access_prevention_enforced]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class SetPublicAccessPreventionEnforced {
  public static void setPublicAccessPreventionEnforced(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    // Enforces public access prevention for the bucket
    bucket
        .toBuilder()
        .setIamConfiguration(
            BucketInfo.IamConfiguration.newBuilder()
                .setPublicAccessPrevention(BucketInfo.PublicAccessPrevention.ENFORCED)
                .build())
        .build()
        .update();

    System.out.println("Public access prevention is set to enforced for " + bucketName);
  }
}
// [END storage_set_public_access_prevention_enforced]
