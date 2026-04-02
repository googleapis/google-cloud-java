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

package com.google.ads.datamanager.v1.samples;

// [START datamanager_v1_generated_UserListGlobalLicenseService_ListUserListGlobalLicenseCustomerInfos_Paged_async]
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse;
import com.google.ads.datamanager.v1.UserListGlobalLicenseCustomerInfo;
import com.google.ads.datamanager.v1.UserListGlobalLicenseName;
import com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient;
import com.google.common.base.Strings;

public class AsyncListUserListGlobalLicenseCustomerInfosPaged {

  public static void main(String[] args) throws Exception {
    asyncListUserListGlobalLicenseCustomerInfosPaged();
  }

  public static void asyncListUserListGlobalLicenseCustomerInfosPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
        UserListGlobalLicenseServiceClient.create()) {
      ListUserListGlobalLicenseCustomerInfosRequest request =
          ListUserListGlobalLicenseCustomerInfosRequest.newBuilder()
              .setParent(
                  UserListGlobalLicenseName.of(
                          "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListUserListGlobalLicenseCustomerInfosResponse response =
            userListGlobalLicenseServiceClient
                .listUserListGlobalLicenseCustomerInfosCallable()
                .call(request);
        for (UserListGlobalLicenseCustomerInfo element :
            response.getUserListGlobalLicenseCustomerInfosList()) {
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
// [END datamanager_v1_generated_UserListGlobalLicenseService_ListUserListGlobalLicenseCustomerInfos_Paged_async]
