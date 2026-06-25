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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_LicenseConfigService_ListLicenseConfigs_Paged_async]
import com.google.cloud.discoveryengine.v1beta.LicenseConfig;
import com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.LocationName;
import com.google.common.base.Strings;

public class AsyncListLicenseConfigsPaged {

  public static void main(String[] args) throws Exception {
    asyncListLicenseConfigsPaged();
  }

  public static void asyncListLicenseConfigsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LicenseConfigServiceClient licenseConfigServiceClient =
        LicenseConfigServiceClient.create()) {
      ListLicenseConfigsRequest request =
          ListLicenseConfigsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListLicenseConfigsResponse response =
            licenseConfigServiceClient.listLicenseConfigsCallable().call(request);
        for (LicenseConfig element : response.getLicenseConfigsList()) {
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
// [END discoveryengine_v1beta_generated_LicenseConfigService_ListLicenseConfigs_Paged_async]
