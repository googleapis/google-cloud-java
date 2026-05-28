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

// [START cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_ListRegistryBooks_Paged_async]
import com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse;
import com.google.cloud.numberregistry.v1alpha.LocationName;
import com.google.cloud.numberregistry.v1alpha.RegistryBook;
import com.google.cloud.numberregistry.v1alpha.RegistryBookView;
import com.google.common.base.Strings;

public class AsyncListRegistryBooksPaged {

  public static void main(String[] args) throws Exception {
    asyncListRegistryBooksPaged();
  }

  public static void asyncListRegistryBooksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
      ListRegistryBooksRequest request =
          ListRegistryBooksRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setView(RegistryBookView.forNumber(0))
              .build();
      while (true) {
        ListRegistryBooksResponse response =
            cloudNumberRegistryClient.listRegistryBooksCallable().call(request);
        for (RegistryBook element : response.getRegistryBooksList()) {
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
// [END cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_ListRegistryBooks_Paged_async]
