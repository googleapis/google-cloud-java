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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_Mirroring_ListMirroringDeployments_Paged_async]
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse;
import com.google.cloud.networksecurity.v1.LocationName;
import com.google.cloud.networksecurity.v1.MirroringClient;
import com.google.cloud.networksecurity.v1.MirroringDeployment;
import com.google.common.base.Strings;

public class AsyncListMirroringDeploymentsPaged {

  public static void main(String[] args) throws Exception {
    asyncListMirroringDeploymentsPaged();
  }

  public static void asyncListMirroringDeploymentsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MirroringClient mirroringClient = MirroringClient.create()) {
      ListMirroringDeploymentsRequest request =
          ListMirroringDeploymentsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListMirroringDeploymentsResponse response =
            mirroringClient.listMirroringDeploymentsCallable().call(request);
        for (MirroringDeployment element : response.getMirroringDeploymentsList()) {
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
// [END networksecurity_v1_generated_Mirroring_ListMirroringDeployments_Paged_async]
