/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vertexai.v1.samples;

// [START aiplatform_v1_generated_EndpointService_DeployModel_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vertexai.v1.DeployModelOperationMetadata;
import com.google.cloud.vertexai.v1.DeployModelRequest;
import com.google.cloud.vertexai.v1.DeployModelResponse;
import com.google.cloud.vertexai.v1.DeployedModel;
import com.google.cloud.vertexai.v1.EndpointName;
import com.google.cloud.vertexai.v1.EndpointServiceClient;
import java.util.HashMap;

public class AsyncDeployModelLRO {

  public static void main(String[] args) throws Exception {
    asyncDeployModelLRO();
  }

  public static void asyncDeployModelLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
      DeployModelRequest request =
          DeployModelRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setDeployedModel(DeployedModel.newBuilder().build())
              .putAllTrafficSplit(new HashMap<String, Integer>())
              .build();
      OperationFuture<DeployModelResponse, DeployModelOperationMetadata> future =
          endpointServiceClient.deployModelOperationCallable().futureCall(request);
      // Do something.
      DeployModelResponse response = future.get();
    }
  }
}
// [END aiplatform_v1_generated_EndpointService_DeployModel_LRO_async]
