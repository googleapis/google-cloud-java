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

package com.google.cloud.networkservices.v1.samples;

// [START networkservices_v1_generated_NetworkServices_ListTlsRoutes_Paged_async]
import com.google.cloud.networkservices.v1.ListTlsRoutesRequest;
import com.google.cloud.networkservices.v1.ListTlsRoutesResponse;
import com.google.cloud.networkservices.v1.LocationName;
import com.google.cloud.networkservices.v1.NetworkServicesClient;
import com.google.cloud.networkservices.v1.TlsRoute;
import com.google.common.base.Strings;

public class AsyncListTlsRoutesPaged {

  public static void main(String[] args) throws Exception {
    asyncListTlsRoutesPaged();
  }

  public static void asyncListTlsRoutesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
      ListTlsRoutesRequest request =
          ListTlsRoutesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTlsRoutesResponse response =
            networkServicesClient.listTlsRoutesCallable().call(request);
        for (TlsRoute element : response.getTlsRoutesList()) {
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
// [END networkservices_v1_generated_NetworkServices_ListTlsRoutes_Paged_async]
