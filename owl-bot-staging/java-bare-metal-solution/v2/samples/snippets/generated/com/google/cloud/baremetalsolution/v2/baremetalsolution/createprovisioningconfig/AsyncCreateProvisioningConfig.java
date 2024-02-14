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

package com.google.cloud.baremetalsolution.v2.samples;

// [START baremetalsolution_v2_generated_BareMetalSolution_CreateProvisioningConfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient;
import com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.LocationName;
import com.google.cloud.baremetalsolution.v2.ProvisioningConfig;

public class AsyncCreateProvisioningConfig {

  public static void main(String[] args) throws Exception {
    asyncCreateProvisioningConfig();
  }

  public static void asyncCreateProvisioningConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
      CreateProvisioningConfigRequest request =
          CreateProvisioningConfigRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
              .setEmail("email96619420")
              .build();
      ApiFuture<ProvisioningConfig> future =
          bareMetalSolutionClient.createProvisioningConfigCallable().futureCall(request);
      // Do something.
      ProvisioningConfig response = future.get();
    }
  }
}
// [END baremetalsolution_v2_generated_BareMetalSolution_CreateProvisioningConfig_async]
