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

// [START vectorsearch_v1beta_generated_VectorSearchService_CreateCollection_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vectorsearch.v1beta.Collection;
import com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.LocationName;
import com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient;
import com.google.longrunning.Operation;

public class AsyncCreateCollection {

  public static void main(String[] args) throws Exception {
    asyncCreateCollection();
  }

  public static void asyncCreateCollection() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VectorSearchServiceClient vectorSearchServiceClient = VectorSearchServiceClient.create()) {
      CreateCollectionRequest request =
          CreateCollectionRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setCollectionId("collectionId1636075609")
              .setCollection(Collection.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          vectorSearchServiceClient.createCollectionCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END vectorsearch_v1beta_generated_VectorSearchService_CreateCollection_async]
