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

package com.google.cloud.numberregistry.v1alpha.samples;

// [START cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_SearchIpResources_Paged_async]
import com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient;
import com.google.cloud.numberregistry.v1alpha.Range;
import com.google.cloud.numberregistry.v1alpha.RegistryBookName;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncSearchIpResourcesPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchIpResourcesPaged();
  }

  public static void asyncSearchIpResourcesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
      SearchIpResourcesRequest request =
          SearchIpResourcesRequest.newBuilder()
              .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
              .setQuery("query107944136")
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setShowUtilization(true)
              .addAllSearchResourceTypes(
                  new ArrayList<SearchIpResourcesRequest.SearchResourceType>())
              .build();
      while (true) {
        SearchIpResourcesResponse response =
            cloudNumberRegistryClient.searchIpResourcesCallable().call(request);
        for (Range element : response.getRangesList()) {
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
// [END cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_SearchIpResources_Paged_async]
