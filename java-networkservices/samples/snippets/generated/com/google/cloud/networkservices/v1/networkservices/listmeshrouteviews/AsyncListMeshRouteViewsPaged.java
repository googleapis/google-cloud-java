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

package com.google.cloud.networkservices.v1.samples;

// [START networkservices_v1_generated_NetworkServices_ListMeshRouteViews_Paged_async]
import com.google.cloud.networkservices.v1.ListMeshRouteViewsRequest;
import com.google.cloud.networkservices.v1.ListMeshRouteViewsResponse;
import com.google.cloud.networkservices.v1.MeshName;
import com.google.cloud.networkservices.v1.MeshRouteView;
import com.google.cloud.networkservices.v1.NetworkServicesClient;
import com.google.common.base.Strings;

public class AsyncListMeshRouteViewsPaged {

  public static void main(String[] args) throws Exception {
    asyncListMeshRouteViewsPaged();
  }

  public static void asyncListMeshRouteViewsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
      ListMeshRouteViewsRequest request =
          ListMeshRouteViewsRequest.newBuilder()
              .setParent(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListMeshRouteViewsResponse response =
            networkServicesClient.listMeshRouteViewsCallable().call(request);
        for (MeshRouteView element : response.getMeshRouteViewsList()) {
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
// [END networkservices_v1_generated_NetworkServices_ListMeshRouteViews_Paged_async]
