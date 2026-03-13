/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.storage.v2.samples;

// [START storage_v2_generated_Storage_ListBuckets_async]
import com.google.api.core.ApiFuture;
import com.google.protobuf.FieldMask;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ProjectName;
import com.google.storage.v2.StorageClient;

public class AsyncListBuckets {

  public static void main(String[] args) throws Exception {
    asyncListBuckets();
  }

  public static void asyncListBuckets() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageClient storageClient = StorageClient.create()) {
      ListBucketsRequest request =
          ListBucketsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setPrefix("prefix-980110702")
              .setReadMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Bucket> future = storageClient.listBucketsPagedCallable().futureCall(request);
      // Do something.
      for (Bucket element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END storage_v2_generated_Storage_ListBuckets_async]
