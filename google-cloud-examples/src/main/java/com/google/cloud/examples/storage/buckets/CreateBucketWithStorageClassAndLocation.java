/*
 * Copyright 2019 Google LLC
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

// [START storage_create_bucket_class_location]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

public class CreateBucketWithStorageClassAndLocation {
  public static void createBucketWithStorageClassAndLocation(String projectId, String bucketName) {
    // String projectId = "your-project-id";
    // String bucketName = "your-unique-bucket-name";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                // See here for possible values: http://g.co/cloud/storage/docs/storage-classes
                .setStorageClass(StorageClass.COLDLINE)
                // Possible values: http://g.co/cloud/storage/docs/bucket-locations#location-mr
                .setLocation("asia")
                .build());
    System.out.println(
        "Created bucket "
            + bucket.getName()
            + " in "
            + bucket.getLocation()
            + " with storage class "
            + bucket.getStorageClass());
  }
}
// [END storage_create_bucket_class_location]
