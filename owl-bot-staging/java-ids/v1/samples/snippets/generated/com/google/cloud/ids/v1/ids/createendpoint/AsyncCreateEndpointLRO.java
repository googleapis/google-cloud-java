/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.ids.v1.samples;

// [START ids_v1_generated_IDS_CreateEndpoint_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ids.v1.CreateEndpointRequest;
import com.google.cloud.ids.v1.Endpoint;
import com.google.cloud.ids.v1.IDSClient;
import com.google.cloud.ids.v1.LocationName;
import com.google.cloud.ids.v1.OperationMetadata;

public class AsyncCreateEndpointLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateEndpointLRO();
  }

  public static void asyncCreateEndpointLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IDSClient iDSClient = IDSClient.create()) {
      CreateEndpointRequest request =
          CreateEndpointRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setEndpointId("endpointId-1837754992")
              .setEndpoint(Endpoint.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Endpoint, OperationMetadata> future =
          iDSClient.createEndpointOperationCallable().futureCall(request);
      // Do something.
      Endpoint response = future.get();
    }
  }
}
// [END ids_v1_generated_IDS_CreateEndpoint_LRO_async]
