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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_VertexRagService_AsyncRetrieveContexts_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.AsyncRetrieveContextsRequest;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.RagQuery;
import com.google.cloud.aiplatform.v1beta1.Tool;
import com.google.cloud.aiplatform.v1beta1.VertexRagServiceClient;
import com.google.longrunning.Operation;
import java.util.ArrayList;

public class AsyncAsyncRetrieveContexts {

  public static void main(String[] args) throws Exception {
    asyncAsyncRetrieveContexts();
  }

  public static void asyncAsyncRetrieveContexts() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VertexRagServiceClient vertexRagServiceClient = VertexRagServiceClient.create()) {
      AsyncRetrieveContextsRequest request =
          AsyncRetrieveContextsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setQuery(RagQuery.newBuilder().build())
              .addAllTools(new ArrayList<Tool>())
              .build();
      ApiFuture<Operation> future =
          vertexRagServiceClient.asyncRetrieveContextsCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_VertexRagService_AsyncRetrieveContexts_async]
