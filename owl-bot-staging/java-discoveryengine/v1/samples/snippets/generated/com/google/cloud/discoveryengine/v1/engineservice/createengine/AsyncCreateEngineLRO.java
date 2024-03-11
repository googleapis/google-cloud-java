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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_EngineService_CreateEngine_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.discoveryengine.v1.CollectionName;
import com.google.cloud.discoveryengine.v1.CreateEngineMetadata;
import com.google.cloud.discoveryengine.v1.CreateEngineRequest;
import com.google.cloud.discoveryengine.v1.Engine;
import com.google.cloud.discoveryengine.v1.EngineServiceClient;

public class AsyncCreateEngineLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateEngineLRO();
  }

  public static void asyncCreateEngineLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
      CreateEngineRequest request =
          CreateEngineRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setEngine(Engine.newBuilder().build())
              .setEngineId("engineId1820490493")
              .build();
      OperationFuture<Engine, CreateEngineMetadata> future =
          engineServiceClient.createEngineOperationCallable().futureCall(request);
      // Do something.
      Engine response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_EngineService_CreateEngine_LRO_async]
