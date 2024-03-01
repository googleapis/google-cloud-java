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

package com.google.cloud.securitycenter.v2.samples;

// [START securitycenter_v2_generated_SecurityCenter_ListValuedResources_Paged_async]
import com.google.cloud.securitycenter.v2.ListValuedResourcesRequest;
import com.google.cloud.securitycenter.v2.ListValuedResourcesResponse;
import com.google.cloud.securitycenter.v2.SecurityCenterClient;
import com.google.cloud.securitycenter.v2.SimulationName;
import com.google.cloud.securitycenter.v2.ValuedResource;
import com.google.common.base.Strings;

public class AsyncListValuedResourcesPaged {

  public static void main(String[] args) throws Exception {
    asyncListValuedResourcesPaged();
  }

  public static void asyncListValuedResourcesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      ListValuedResourcesRequest request =
          ListValuedResourcesRequest.newBuilder()
              .setParent(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
              .setFilter("filter-1274492040")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListValuedResourcesResponse response =
            securityCenterClient.listValuedResourcesCallable().call(request);
        for (ValuedResource element : response.getValuedResourcesList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END securitycenter_v2_generated_SecurityCenter_ListValuedResources_Paged_async]
