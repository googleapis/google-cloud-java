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

package com.google.cloud.securityposture.v1.samples;

// [START securityposture_v1_generated_SecurityPosture_ListPostures_Paged_async]
import com.google.cloud.securityposture.v1.ListPosturesRequest;
import com.google.cloud.securityposture.v1.ListPosturesResponse;
import com.google.cloud.securityposture.v1.OrganizationName;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.SecurityPostureClient;
import com.google.common.base.Strings;

public class AsyncListPosturesPaged {

  public static void main(String[] args) throws Exception {
    asyncListPosturesPaged();
  }

  public static void asyncListPosturesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
      ListPosturesRequest request =
          ListPosturesRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListPosturesResponse response = securityPostureClient.listPosturesCallable().call(request);
        for (Posture element : response.getPosturesList()) {
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
// [END securityposture_v1_generated_SecurityPosture_ListPostures_Paged_async]
