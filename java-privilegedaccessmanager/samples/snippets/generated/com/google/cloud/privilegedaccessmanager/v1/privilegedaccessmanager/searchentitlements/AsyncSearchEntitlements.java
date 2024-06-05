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

package com.google.cloud.privilegedaccessmanager.v1.samples;

// [START privilegedaccessmanager_v1_generated_PrivilegedAccessManager_SearchEntitlements_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.privilegedaccessmanager.v1.Entitlement;
import com.google.cloud.privilegedaccessmanager.v1.LocationName;
import com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest;

public class AsyncSearchEntitlements {

  public static void main(String[] args) throws Exception {
    asyncSearchEntitlements();
  }

  public static void asyncSearchEntitlements() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
        PrivilegedAccessManagerClient.create()) {
      SearchEntitlementsRequest request =
          SearchEntitlementsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Entitlement> future =
          privilegedAccessManagerClient.searchEntitlementsPagedCallable().futureCall(request);
      // Do something.
      for (Entitlement element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END privilegedaccessmanager_v1_generated_PrivilegedAccessManager_SearchEntitlements_async]
