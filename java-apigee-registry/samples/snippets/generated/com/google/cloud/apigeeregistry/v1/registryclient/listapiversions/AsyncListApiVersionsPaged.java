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

package com.google.cloud.apigeeregistry.v1.samples;

// [START apigeeregistry_v1_generated_registryclient_listapiversions_paged_async]
import com.google.cloud.apigeeregistry.v1.ApiName;
import com.google.cloud.apigeeregistry.v1.ApiVersion;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse;
import com.google.cloud.apigeeregistry.v1.RegistryClient;
import com.google.common.base.Strings;

public class AsyncListApiVersionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListApiVersionsPaged();
  }

  public static void asyncListApiVersionsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (RegistryClient registryClient = RegistryClient.create()) {
      ListApiVersionsRequest request =
          ListApiVersionsRequest.newBuilder()
              .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListApiVersionsResponse response = registryClient.listApiVersionsCallable().call(request);
        for (ApiVersion element : response.getApiVersionsList()) {
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
// [END apigeeregistry_v1_generated_registryclient_listapiversions_paged_async]
