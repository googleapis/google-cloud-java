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

package com.google.cloud.osconfig.v1.samples;

// [START osconfig_v1_generated_osconfigzonalserviceclient_listinventories_paged_async]
import com.google.cloud.osconfig.v1.InstanceName;
import com.google.cloud.osconfig.v1.Inventory;
import com.google.cloud.osconfig.v1.InventoryView;
import com.google.cloud.osconfig.v1.ListInventoriesRequest;
import com.google.cloud.osconfig.v1.ListInventoriesResponse;
import com.google.cloud.osconfig.v1.OsConfigZonalServiceClient;
import com.google.common.base.Strings;

public class AsyncListInventoriesPaged {

  public static void main(String[] args) throws Exception {
    asyncListInventoriesPaged();
  }

  public static void asyncListInventoriesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigZonalServiceClient osConfigZonalServiceClient =
        OsConfigZonalServiceClient.create()) {
      ListInventoriesRequest request =
          ListInventoriesRequest.newBuilder()
              .setParent(
                  InstanceName.ofProjectLocationInstanceName(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]")
                      .toString())
              .setView(InventoryView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListInventoriesResponse response =
            osConfigZonalServiceClient.listInventoriesCallable().call(request);
        for (Inventory element : response.getInventoriesList()) {
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
// [END osconfig_v1_generated_osconfigzonalserviceclient_listinventories_paged_async]
