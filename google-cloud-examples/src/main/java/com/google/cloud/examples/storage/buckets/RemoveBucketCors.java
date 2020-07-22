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

// [START storage_remove_cors_configuration]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Cors;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.List;

public class RemoveBucketCors {
  public static void removeBucketCors(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket =
        storage.get(bucketName, Storage.BucketGetOption.fields(Storage.BucketField.CORS));

    // getCors() returns the List and copying over to an ArrayList so it's mutable.
    List<Cors> cors = new ArrayList<>(bucket.getCors());

    // Clear bucket CORS configuration.
    cors.clear();

    // Update bucket to remove CORS.
    bucket.toBuilder().setCors(cors).build().update();
    System.out.println("Removed CORS configuration from bucket " + bucketName);
  }
}
// [END storage_remove_cors_configuration]
