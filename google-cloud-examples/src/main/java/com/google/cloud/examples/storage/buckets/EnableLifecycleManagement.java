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

// [START storage_enable_bucket_lifecycle_management]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;

public class EnableLifecycleManagement {
  public static void enableLifecycleManagement(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    // See the LifecycleRule documentation for additional info on what you can do with lifecycle
    // management rules. This one deletes objects that are over 100 days old.
    // https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/storage/BucketInfo.LifecycleRule.html
    bucket
        .toBuilder()
        .setLifecycleRules(
            ImmutableList.of(
                new LifecycleRule(
                    LifecycleRule.LifecycleAction.newDeleteAction(),
                    LifecycleRule.LifecycleCondition.newBuilder().setAge(100).build())))
        .build()
        .update();

    System.out.println("Lifecycle management was enabled and configured for bucket " + bucketName);
  }
}
// [END storage_enable_bucket_lifecycle_management]
