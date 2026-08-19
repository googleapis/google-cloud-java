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

package com.google.cloud.agentidentity.v1beta.samples;

// [START agentidentity_v1beta_generated_AuthProviderService_ListAuthProviders_Paged_async]
import com.google.cloud.agentidentity.v1beta.AuthProvider;
import com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient;
import com.google.cloud.agentidentity.v1beta.ListAuthProvidersRequest;
import com.google.cloud.agentidentity.v1beta.ListAuthProvidersResponse;
import com.google.cloud.agentidentity.v1beta.LocationName;
import com.google.common.base.Strings;

public class AsyncListAuthProvidersPaged {

  public static void main(String[] args) throws Exception {
    asyncListAuthProvidersPaged();
  }

  public static void asyncListAuthProvidersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
      ListAuthProvidersRequest request =
          ListAuthProvidersRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setShowDeleted(true)
              .build();
      while (true) {
        ListAuthProvidersResponse response =
            authProviderServiceClient.listAuthProvidersCallable().call(request);
        for (AuthProvider element : response.getAuthProvidersList()) {
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
// [END agentidentity_v1beta_generated_AuthProviderService_ListAuthProviders_Paged_async]
