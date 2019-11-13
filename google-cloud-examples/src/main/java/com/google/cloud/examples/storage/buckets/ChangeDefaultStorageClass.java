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

// [START storage_change_default_storage_class]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

public class ChangeDefaultStorageClass {
  public static void changeDefaultStorageClass(
      String projectId, String bucketName) {
    // String projectId = "your-project-id";
    // String bucketName = "your-unique-bucket-name";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    bucket =
        bucket.toBuilder().setStorageClass(StorageClass.COLDLINE).build().update();

    System.out.println(
        "Default storage class for bucket "
            + bucketName
            + " has been set to "
            + bucket.getStorageClass()
            + ".");
  }
}
// [END storage_change_default_storage_class]
