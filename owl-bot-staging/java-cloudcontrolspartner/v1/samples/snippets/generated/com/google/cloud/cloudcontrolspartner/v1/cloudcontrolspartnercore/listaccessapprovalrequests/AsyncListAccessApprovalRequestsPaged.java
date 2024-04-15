/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.samples;

// [START cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_ListAccessApprovalRequests_Paged_async]
import com.google.cloud.cloudcontrolspartner.v1.AccessApprovalRequest;
import com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1.WorkloadName;
import com.google.common.base.Strings;

public class AsyncListAccessApprovalRequestsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAccessApprovalRequestsPaged();
  }

  public static void asyncListAccessApprovalRequestsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
        CloudControlsPartnerCoreClient.create()) {
      ListAccessApprovalRequestsRequest request =
          ListAccessApprovalRequestsRequest.newBuilder()
              .setParent(
                  WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListAccessApprovalRequestsResponse response =
            cloudControlsPartnerCoreClient.listAccessApprovalRequestsCallable().call(request);
        for (AccessApprovalRequest element : response.getAccessApprovalRequestsList()) {
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
// [END cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_ListAccessApprovalRequests_Paged_async]
