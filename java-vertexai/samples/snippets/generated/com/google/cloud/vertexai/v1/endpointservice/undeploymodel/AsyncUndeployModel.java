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

// [START aiplatform_v1_generated_EndpointService_UndeployModel_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vertexai.v1.EndpointName;
import com.google.cloud.vertexai.v1.EndpointServiceClient;
import com.google.cloud.vertexai.v1.UndeployModelRequest;
import com.google.longrunning.Operation;
import java.util.HashMap;

public class AsyncUndeployModel {

  public static void main(String[] args) throws Exception {
    asyncUndeployModel();
  }

  public static void asyncUndeployModel() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
      UndeployModelRequest request =
          UndeployModelRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setDeployedModelId("deployedModelId-1817547906")
              .putAllTrafficSplit(new HashMap<String, Integer>())
              .build();
      ApiFuture<Operation> future =
          endpointServiceClient.undeployModelCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END aiplatform_v1_generated_EndpointService_UndeployModel_async]
