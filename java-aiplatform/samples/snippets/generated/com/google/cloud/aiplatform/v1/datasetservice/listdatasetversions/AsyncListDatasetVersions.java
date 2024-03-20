/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_DatasetService_ListDatasetVersions_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1.DatasetName;
import com.google.cloud.aiplatform.v1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1.DatasetVersion;
import com.google.cloud.aiplatform.v1.ListDatasetVersionsRequest;
import com.google.protobuf.FieldMask;

public class AsyncListDatasetVersions {

  public static void main(String[] args) throws Exception {
    asyncListDatasetVersions();
  }

  public static void asyncListDatasetVersions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
      ListDatasetVersionsRequest request =
          ListDatasetVersionsRequest.newBuilder()
              .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setReadMask(FieldMask.newBuilder().build())
              .setOrderBy("orderBy-1207110587")
              .build();
      ApiFuture<DatasetVersion> future =
          datasetServiceClient.listDatasetVersionsPagedCallable().futureCall(request);
      // Do something.
      for (DatasetVersion element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END aiplatform_v1_generated_DatasetService_ListDatasetVersions_async]
