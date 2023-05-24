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

package com.google.cloud.resourcemanager.v3.samples;

// [START cloudresourcemanager_v3_generated_Organizations_SearchOrganizations_Paged_async]
import com.google.cloud.resourcemanager.v3.Organization;
import com.google.cloud.resourcemanager.v3.OrganizationsClient;
import com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest;
import com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse;
import com.google.common.base.Strings;

public class AsyncSearchOrganizationsPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchOrganizationsPaged();
  }

  public static void asyncSearchOrganizationsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
      SearchOrganizationsRequest request =
          SearchOrganizationsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setQuery("query107944136")
              .build();
      while (true) {
        SearchOrganizationsResponse response =
            organizationsClient.searchOrganizationsCallable().call(request);
        for (Organization element : response.getOrganizationsList()) {
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
// [END cloudresourcemanager_v3_generated_Organizations_SearchOrganizations_Paged_async]
