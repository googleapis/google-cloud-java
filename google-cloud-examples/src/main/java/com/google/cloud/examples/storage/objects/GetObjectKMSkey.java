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

// [storage_object_get_kms_key]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

// Sample to get the KMS key of an object
public class GetObjectKMSkey {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String bucketName = "your-unique-bucket-name";
    String objectName = "your-object-name";

    getObjectKMSkey(projectId, bucketName, objectName);
  }

  public static void getObjectKMSkey(String projectId, String bucketName, String objectName) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Blob blob = storage.get(bucketName, objectName);

    System.out.println("KMS key name for an object " + objectName + " is " + blob.getKmsKeyName());
  }
}
// [storage_object_get_kms_key]
