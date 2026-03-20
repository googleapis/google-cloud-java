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

package com.google.cloud.ces.v1.samples;

// [START ces_v1_generated_AgentService_CreateApp_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ces.v1.AgentServiceClient;
import com.google.cloud.ces.v1.App;
import com.google.cloud.ces.v1.CreateAppRequest;
import com.google.cloud.ces.v1.LocationName;
import com.google.cloud.ces.v1.OperationMetadata;

public class AsyncCreateAppLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateAppLRO();
  }

  public static void asyncCreateAppLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
      CreateAppRequest request =
          CreateAppRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setAppId("appId93028124")
              .setApp(App.newBuilder().build())
              .build();
      OperationFuture<App, OperationMetadata> future =
          agentServiceClient.createAppOperationCallable().futureCall(request);
      // Do something.
      App response = future.get();
    }
  }
}
// [END ces_v1_generated_AgentService_CreateApp_LRO_async]
