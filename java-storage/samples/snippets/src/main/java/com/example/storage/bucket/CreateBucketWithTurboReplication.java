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
