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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_IndexEndpointService_MutateDeployedIndex_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.DeployedIndex;
import com.google.cloud.aiplatform.v1beta1.IndexEndpointName;
import com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexResponse;

public class AsyncMutateDeployedIndexLRO {

  public static void main(String[] args) throws Exception {
    asyncMutateDeployedIndexLRO();
  }

  public static void asyncMutateDeployedIndexLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IndexEndpointServiceClient indexEndpointServiceClient =
        IndexEndpointServiceClient.create()) {
      MutateDeployedIndexRequest request =
          MutateDeployedIndexRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .setDeployedIndex(DeployedIndex.newBuilder().build())
              .build();
      OperationFuture<MutateDeployedIndexResponse, MutateDeployedIndexOperationMetadata> future =
          indexEndpointServiceClient.mutateDeployedIndexOperationCallable().futureCall(request);
      // Do something.
      MutateDeployedIndexResponse response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_IndexEndpointService_MutateDeployedIndex_LRO_async]
