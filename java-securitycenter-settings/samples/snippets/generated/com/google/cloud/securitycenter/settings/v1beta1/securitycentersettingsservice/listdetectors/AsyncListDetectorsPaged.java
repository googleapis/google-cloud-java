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

package com.google.cloud.securitycenter.settings.v1beta1.samples;

// [START securitycenter_v1beta1_generated_SecurityCenterSettingsService_ListDetectors_Paged_async]
import com.google.cloud.securitycenter.settings.v1beta1.Detector;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.OrganizationName;
import com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient;
import com.google.common.base.Strings;

public class AsyncListDetectorsPaged {

  public static void main(String[] args) throws Exception {
    asyncListDetectorsPaged();
  }

  public static void asyncListDetectorsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterSettingsServiceClient securityCenterSettingsServiceClient =
        SecurityCenterSettingsServiceClient.create()) {
      ListDetectorsRequest request =
          ListDetectorsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListDetectorsResponse response =
            securityCenterSettingsServiceClient.listDetectorsCallable().call(request);
        for (Detector element : response.getDetectorsList()) {
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
// [END securitycenter_v1beta1_generated_SecurityCenterSettingsService_ListDetectors_Paged_async]
