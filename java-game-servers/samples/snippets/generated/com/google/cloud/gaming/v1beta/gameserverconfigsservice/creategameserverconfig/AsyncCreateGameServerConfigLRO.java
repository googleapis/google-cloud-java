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

package com.google.cloud.gaming.v1beta.samples;

// [START gameservices_v1beta_generated_GameServerConfigsService_CreateGameServerConfig_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gaming.v1beta.CreateGameServerConfigRequest;
import com.google.cloud.gaming.v1beta.GameServerConfig;
import com.google.cloud.gaming.v1beta.GameServerConfigsServiceClient;
import com.google.cloud.gaming.v1beta.GameServerDeploymentName;
import com.google.cloud.gaming.v1beta.OperationMetadata;

public class AsyncCreateGameServerConfigLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateGameServerConfigLRO();
  }

  public static void asyncCreateGameServerConfigLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
        GameServerConfigsServiceClient.create()) {
      CreateGameServerConfigRequest request =
          CreateGameServerConfigRequest.newBuilder()
              .setParent(
                  GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
              .setConfigId("configId-580140035")
              .setGameServerConfig(GameServerConfig.newBuilder().build())
              .build();
      OperationFuture<GameServerConfig, OperationMetadata> future =
          gameServerConfigsServiceClient
              .createGameServerConfigOperationCallable()
              .futureCall(request);
      // Do something.
      GameServerConfig response = future.get();
    }
  }
}
// [END gameservices_v1beta_generated_GameServerConfigsService_CreateGameServerConfig_LRO_async]
