/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.securitycenter.v1.samples;

// [START securitycenter_v1_generated_SecurityCenter_ListAttackPaths_Paged_async]
import com.google.cloud.securitycenter.v1.AttackPath;
import com.google.cloud.securitycenter.v1.ListAttackPathsRequest;
import com.google.cloud.securitycenter.v1.ListAttackPathsResponse;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.ValuedResourceName;
import com.google.common.base.Strings;

public class AsyncListAttackPathsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAttackPathsPaged();
  }

  public static void asyncListAttackPathsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      ListAttackPathsRequest request =
          ListAttackPathsRequest.newBuilder()
              .setParent(
                  ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      while (true) {
        ListAttackPathsResponse response =
            securityCenterClient.listAttackPathsCallable().call(request);
        for (AttackPath element : response.getAttackPathsList()) {
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
// [END securitycenter_v1_generated_SecurityCenter_ListAttackPaths_Paged_async]
