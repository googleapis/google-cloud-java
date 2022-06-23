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

package com.google.cloud.servicedirectory.v1.samples;

// [START servicedirectory_v1_generated_registrationserviceclient_listendpoints_sync]
import com.google.cloud.servicedirectory.v1.Endpoint;
import com.google.cloud.servicedirectory.v1.ListEndpointsRequest;
import com.google.cloud.servicedirectory.v1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1.ServiceName;

public class SyncListEndpoints {

  public static void main(String[] args) throws Exception {
    syncListEndpoints();
  }

  public static void syncListEndpoints() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (RegistrationServiceClient registrationServiceClient = RegistrationServiceClient.create()) {
      ListEndpointsRequest request =
          ListEndpointsRequest.newBuilder()
              .setParent(
                  ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      for (Endpoint element : registrationServiceClient.listEndpoints(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END servicedirectory_v1_generated_registrationserviceclient_listendpoints_sync]
