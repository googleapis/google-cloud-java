/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.licensemanager.v1.samples;

// [START licensemanager_v1_generated_LicenseManager_ReactivateConfiguration_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.licensemanager.v1.Configuration;
import com.google.cloud.licensemanager.v1.ConfigurationName;
import com.google.cloud.licensemanager.v1.LicenseManagerClient;
import com.google.cloud.licensemanager.v1.OperationMetadata;
import com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest;

public class AsyncReactivateConfigurationLRO {

  public static void main(String[] args) throws Exception {
    asyncReactivateConfigurationLRO();
  }

  public static void asyncReactivateConfigurationLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
      ReactivateConfigurationRequest request =
          ReactivateConfigurationRequest.newBuilder()
              .setName(
                  ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Configuration, OperationMetadata> future =
          licenseManagerClient.reactivateConfigurationOperationCallable().futureCall(request);
      // Do something.
      Configuration response = future.get();
    }
  }
}
// [END licensemanager_v1_generated_LicenseManager_ReactivateConfiguration_LRO_async]
