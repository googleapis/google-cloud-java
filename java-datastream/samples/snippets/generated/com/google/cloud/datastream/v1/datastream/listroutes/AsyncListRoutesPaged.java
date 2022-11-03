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

package com.google.cloud.datastream.v1.samples;

// [START datastream_v1_generated_Datastream_ListRoutes_Paged_async]
import com.google.cloud.datastream.v1.DatastreamClient;
import com.google.cloud.datastream.v1.ListRoutesRequest;
import com.google.cloud.datastream.v1.ListRoutesResponse;
import com.google.cloud.datastream.v1.PrivateConnectionName;
import com.google.cloud.datastream.v1.Route;
import com.google.common.base.Strings;

public class AsyncListRoutesPaged {

  public static void main(String[] args) throws Exception {
    asyncListRoutesPaged();
  }

  public static void asyncListRoutesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastreamClient datastreamClient = DatastreamClient.create()) {
      ListRoutesRequest request =
          ListRoutesRequest.newBuilder()
              .setParent(
                  PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListRoutesResponse response = datastreamClient.listRoutesCallable().call(request);
        for (Route element : response.getRoutesList()) {
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
// [END datastream_v1_generated_Datastream_ListRoutes_Paged_async]
