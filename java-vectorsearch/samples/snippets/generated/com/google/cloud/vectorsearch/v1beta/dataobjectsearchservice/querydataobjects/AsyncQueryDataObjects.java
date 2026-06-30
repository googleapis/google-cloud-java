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

package com.google.cloud.vectorsearch.v1beta.samples;

// [START vectorsearch_v1beta_generated_DataObjectSearchService_QueryDataObjects_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vectorsearch.v1beta.CollectionName;
import com.google.cloud.vectorsearch.v1beta.DataObject;
import com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient;
import com.google.cloud.vectorsearch.v1beta.OutputFields;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest;
import com.google.protobuf.Struct;

public class AsyncQueryDataObjects {

  public static void main(String[] args) throws Exception {
    asyncQueryDataObjects();
  }

  public static void asyncQueryDataObjects() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
        DataObjectSearchServiceClient.create()) {
      QueryDataObjectsRequest request =
          QueryDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setFilter(Struct.newBuilder().build())
              .setOutputFields(OutputFields.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<DataObject> future =
          dataObjectSearchServiceClient.queryDataObjectsPagedCallable().futureCall(request);
      // Do something.
      for (DataObject element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END vectorsearch_v1beta_generated_DataObjectSearchService_QueryDataObjects_async]
