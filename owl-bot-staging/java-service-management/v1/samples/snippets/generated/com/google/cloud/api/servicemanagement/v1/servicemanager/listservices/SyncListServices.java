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

// [START servicemanagement_v1_generated_ServiceManager_ListServices_sync]
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.cloud.api.servicemanagement.v1.ServiceManagerClient;

public class SyncListServices {

  public static void main(String[] args) throws Exception {
    syncListServices();
  }

  public static void syncListServices() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
      ListServicesRequest request =
          ListServicesRequest.newBuilder()
              .setProducerProjectId("producerProjectId-1297373534")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setConsumerId("consumerId-166238287")
              .build();
      for (ManagedService element : serviceManagerClient.listServices(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END servicemanagement_v1_generated_ServiceManager_ListServices_sync]
