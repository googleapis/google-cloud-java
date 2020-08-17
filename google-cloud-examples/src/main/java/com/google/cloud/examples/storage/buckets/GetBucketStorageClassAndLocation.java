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

// [START storage_get_bucket_class_and_location]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

// Sample to get the bucket storage class and location
public class GetBucketStorageClassAndLocation {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String bucketName = "your-unique-bucket-name";

    // See the StorageClass documentation for other valid storage classes:
    // https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/storage/StorageClass.html
    StorageClass storageClass = StorageClass.COLDLINE;

    // See this documentation for other valid locations:
    // http://g.co/cloud/storage/docs/bucket-locations#location-mr
    String location = "ASIA";

    getBucketStorageClassAndLocation(projectId, bucketName, storageClass, location);
  }

  public static void getBucketStorageClassAndLocation(
      String projectId, String bucketName, StorageClass storageClass, String location) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    storage.create(
        BucketInfo.newBuilder(bucketName)
            .setStorageClass(storageClass)
            .setLocation(location)
            .build());

    Bucket bucket = storage.get(bucketName);

    System.out.println(
        "Get Bucket "
            + bucket.getName()
            + " storage class "
            + bucket.getStorageClass()
            + " and location "
            + bucket.getLocation());
  }
}
// [END storage_get_bucket_class_and_location]
