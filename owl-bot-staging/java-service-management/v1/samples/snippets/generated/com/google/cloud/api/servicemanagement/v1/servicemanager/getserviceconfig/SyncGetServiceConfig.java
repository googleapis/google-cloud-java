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

package com.google.cloud.api.servicemanagement.v1.samples;

// [START servicemanagement_v1_generated_ServiceManager_GetServiceConfig_sync]
import com.google.api.Service;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.cloud.api.servicemanagement.v1.ServiceManagerClient;

public class SyncGetServiceConfig {

  public static void main(String[] args) throws Exception {
    syncGetServiceConfig();
  }

  public static void syncGetServiceConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
      GetServiceConfigRequest request =
          GetServiceConfigRequest.newBuilder()
              .setServiceName("serviceName-1928572192")
              .setConfigId("configId-580140035")
              .build();
      Service response = serviceManagerClient.getServiceConfig(request);
    }
  }
}
// [END servicemanagement_v1_generated_ServiceManager_GetServiceConfig_sync]
