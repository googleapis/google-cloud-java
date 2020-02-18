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
package com.google.cloud.examples.storage.objects;

// [START storage_copy_file]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class CopyObject {
  public static void copyObject(
      String projectId, String sourceBucketName, String objectName, String targetBucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of the bucket the original object is in
    // String sourceBucketName = "your-source-bucket";

    // The ID of the GCS object to copy
    // String objectName = "your-object-name";

    // The ID of the bucket to copy the object to
    // String targetBucketName = "target-object-bucket"

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Blob blob = storage.get(sourceBucketName, objectName);

    // This keeps the original name, you could also do
    // copyTo(targetBucketName, "target-object-name") to change the name
    blob.copyTo(targetBucketName);

    System.out.println(
        "Copied object "
            + objectName
            + " from bucket "
            + sourceBucketName
            + " to "
            + targetBucketName);
  }
}
// [END storage_copy_file]
