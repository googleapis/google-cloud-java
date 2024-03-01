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

package com.google.cloud.servicehealth.v1.samples;

// [START servicehealth_v1_generated_ServiceHealth_ListOrganizationEvents_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest;
import com.google.cloud.servicehealth.v1.OrganizationEvent;
import com.google.cloud.servicehealth.v1.OrganizationEventView;
import com.google.cloud.servicehealth.v1.OrganizationLocationName;
import com.google.cloud.servicehealth.v1.ServiceHealthClient;

public class AsyncListOrganizationEvents {

  public static void main(String[] args) throws Exception {
    asyncListOrganizationEvents();
  }

  public static void asyncListOrganizationEvents() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
      ListOrganizationEventsRequest request =
          ListOrganizationEventsRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setView(OrganizationEventView.forNumber(0))
              .build();
      ApiFuture<OrganizationEvent> future =
          serviceHealthClient.listOrganizationEventsPagedCallable().futureCall(request);
      // Do something.
      for (OrganizationEvent element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END servicehealth_v1_generated_ServiceHealth_ListOrganizationEvents_async]
