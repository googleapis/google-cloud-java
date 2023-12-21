/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.edgenetwork.v1.samples;

// [START edgenetwork_v1_generated_EdgeNetwork_ListNetworks_Paged_async]
import com.google.cloud.edgenetwork.v1.EdgeNetworkClient;
import com.google.cloud.edgenetwork.v1.ListNetworksRequest;
import com.google.cloud.edgenetwork.v1.ListNetworksResponse;
import com.google.cloud.edgenetwork.v1.Network;
import com.google.cloud.edgenetwork.v1.ZoneName;
import com.google.common.base.Strings;

public class AsyncListNetworksPaged {

  public static void main(String[] args) throws Exception {
    asyncListNetworksPaged();
  }

  public static void asyncListNetworksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
      ListNetworksRequest request =
          ListNetworksRequest.newBuilder()
              .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListNetworksResponse response = edgeNetworkClient.listNetworksCallable().call(request);
        for (Network element : response.getNetworksList()) {
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
// [END edgenetwork_v1_generated_EdgeNetwork_ListNetworks_Paged_async]
