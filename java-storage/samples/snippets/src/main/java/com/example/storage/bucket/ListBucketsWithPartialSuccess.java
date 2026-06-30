/*
 * Copyright 2026 Google LLC
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

// [START storage_list_buckets_partial_success]

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ListBucketsWithPartialSuccess {
  public static void listBucketsWithPartialSuccess(String projectId) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Page<Bucket> buckets = storage.list(Storage.BucketListOption.returnPartialSuccess(true));

    // Retrieve the list of buckets that are unreachable due to issues like regional outages or
    // permission issues
    System.out.println("Unreachable buckets: \n");
    for (Bucket bucket : buckets.iterateAll()) {
      if (Boolean.TRUE.equals(bucket.isUnreachable())) {
        System.out.println(bucket.getName());
      }
    }
  }
}
// [END storage_list_buckets_partial_success]
