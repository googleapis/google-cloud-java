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

// [START storage_remove_bucket_label]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.HashMap;
import java.util.Map;

public class RemoveBucketLabel {
  public static void removeBucketLabel(String projectId, String bucketName, String labelKey) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The key of the label to remove from the bucket
    // String labelKey = "label-key-to-remove";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Map<String, String> labelsToRemove = new HashMap<>();
    labelsToRemove.put(labelKey, null);

    Bucket bucket = storage.get(bucketName);
    Map<String, String> labels;
    if (bucket.getLabels() == null) {
      labels = new HashMap<>();
    } else {
      labels = new HashMap(bucket.getLabels());
    }
    labels.putAll(labelsToRemove);
    bucket.toBuilder().setLabels(labels).build().update();

    System.out.println("Removed label " + labelKey + " from bucket " + bucketName);
  }
}
// [END storage_remove_bucket_label]
