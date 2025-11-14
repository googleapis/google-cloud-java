/*
 * Copyright 2025 Google LLC
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

// [START vectorsearch_v1beta_generated_DataObjectSearchService_SearchDataObjects_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vectorsearch.v1beta.CollectionName;
import com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.SearchResult;

public class AsyncSearchDataObjects {

  public static void main(String[] args) throws Exception {
    asyncSearchDataObjects();
  }

  public static void asyncSearchDataObjects() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
        DataObjectSearchServiceClient.create()) {
      SearchDataObjectsRequest request =
          SearchDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<SearchResult> future =
          dataObjectSearchServiceClient.searchDataObjectsPagedCallable().futureCall(request);
      // Do something.
      for (SearchResult element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END vectorsearch_v1beta_generated_DataObjectSearchService_SearchDataObjects_async]
