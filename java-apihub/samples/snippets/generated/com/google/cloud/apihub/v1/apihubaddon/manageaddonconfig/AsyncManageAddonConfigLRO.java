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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_ApiHubAddon_ManageAddonConfig_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.apihub.v1.Addon;
import com.google.cloud.apihub.v1.AddonConfig;
import com.google.cloud.apihub.v1.AddonName;
import com.google.cloud.apihub.v1.ApiHubAddonClient;
import com.google.cloud.apihub.v1.ManageAddonConfigRequest;
import com.google.cloud.apihub.v1.OperationMetadata;

public class AsyncManageAddonConfigLRO {

  public static void main(String[] args) throws Exception {
    asyncManageAddonConfigLRO();
  }

  public static void asyncManageAddonConfigLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
      ManageAddonConfigRequest request =
          ManageAddonConfigRequest.newBuilder()
              .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
              .setConfig(AddonConfig.newBuilder().build())
              .build();
      OperationFuture<Addon, OperationMetadata> future =
          apiHubAddonClient.manageAddonConfigOperationCallable().futureCall(request);
      // Do something.
      Addon response = future.get();
    }
  }
}
// [END apihub_v1_generated_ApiHubAddon_ManageAddonConfig_LRO_async]
