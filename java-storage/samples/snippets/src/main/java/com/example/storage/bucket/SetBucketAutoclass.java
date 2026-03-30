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

// [START storage_set_autoclass]

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.Autoclass;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

public class SetBucketAutoclass {
  public static void setBucketAutoclass(
      String projectId, String bucketName, StorageClass storageClass) throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The storage class that objects in an Autoclass bucket eventually transition to if not read
    // for a certain length of time
    // StorageClass storageClass = StorageClass.ARCHIVE;

    // Configure the Autoclass setting for a bucket.

    // Note:  terminal_storage_class field is optional and defaults to NEARLINE if not otherwise
    // specified. Valid terminal_storage_class values are NEARLINE and ARCHIVE.
    boolean enabled = true;

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {
      Bucket bucket = storage.get(bucketName);

      Bucket toUpdate =
          bucket.toBuilder()
              .setAutoclass(
                  Autoclass.newBuilder()
                      .setEnabled(enabled)
                      .setTerminalStorageClass(storageClass)
                      .build())
              .build();

      Bucket updated = storage.update(toUpdate, BucketTargetOption.metagenerationMatch());

      System.out.println(
          "Autoclass for bucket "
              + bucketName
              + " was "
              + (updated.getAutoclass().getEnabled() ? "enabled." : "disabled."));
      System.out.println(
          "Autoclass terminal storage class is "
              + updated.getAutoclass().getTerminalStorageClass().toString());
    }
  }
}
// [END storage_set_autoclass]
