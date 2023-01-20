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

package com.google.cloud.apigateway.v1.samples;

// [START apigateway_v1_generated_ApiGatewayService_CreateApiConfig_sync]
import com.google.cloud.apigateway.v1.ApiConfig;
import com.google.cloud.apigateway.v1.ApiGatewayServiceClient;
import com.google.cloud.apigateway.v1.ApiName;
import com.google.cloud.apigateway.v1.CreateApiConfigRequest;

public class SyncCreateApiConfig {

  public static void main(String[] args) throws Exception {
    syncCreateApiConfig();
  }

  public static void syncCreateApiConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
      CreateApiConfigRequest request =
          CreateApiConfigRequest.newBuilder()
              .setParent(ApiName.of("[PROJECT]", "[API]").toString())
              .setApiConfigId("apiConfigId-64952265")
              .setApiConfig(ApiConfig.newBuilder().build())
              .build();
      ApiConfig response = apiGatewayServiceClient.createApiConfigAsync(request).get();
    }
  }
}
// [END apigateway_v1_generated_ApiGatewayService_CreateApiConfig_sync]
