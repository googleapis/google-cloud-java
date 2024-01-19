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

package com.google.cloud.vmwareengine.v1.samples;

// [START vmwareengine_v1_generated_VmwareEngine_ListPeeringRoutes_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest;
import com.google.cloud.vmwareengine.v1.NetworkPeeringName;
import com.google.cloud.vmwareengine.v1.PeeringRoute;
import com.google.cloud.vmwareengine.v1.VmwareEngineClient;

public class AsyncListPeeringRoutes {

  public static void main(String[] args) throws Exception {
    asyncListPeeringRoutes();
  }

  public static void asyncListPeeringRoutes() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
      ListPeeringRoutesRequest request =
          ListPeeringRoutesRequest.newBuilder()
              .setParent(
                  NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      ApiFuture<PeeringRoute> future =
          vmwareEngineClient.listPeeringRoutesPagedCallable().futureCall(request);
      // Do something.
      for (PeeringRoute element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END vmwareengine_v1_generated_VmwareEngine_ListPeeringRoutes_async]
