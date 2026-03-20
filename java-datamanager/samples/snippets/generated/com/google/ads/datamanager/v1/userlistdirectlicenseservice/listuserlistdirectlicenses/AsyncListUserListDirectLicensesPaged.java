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

// [START datamanager_v1_generated_UserListDirectLicenseService_ListUserListDirectLicenses_Paged_async]
import com.google.ads.datamanager.v1.AccountName;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse;
import com.google.ads.datamanager.v1.UserListDirectLicense;
import com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient;
import com.google.common.base.Strings;

public class AsyncListUserListDirectLicensesPaged {

  public static void main(String[] args) throws Exception {
    asyncListUserListDirectLicensesPaged();
  }

  public static void asyncListUserListDirectLicensesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
        UserListDirectLicenseServiceClient.create()) {
      ListUserListDirectLicensesRequest request =
          ListUserListDirectLicensesRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListUserListDirectLicensesResponse response =
            userListDirectLicenseServiceClient.listUserListDirectLicensesCallable().call(request);
        for (UserListDirectLicense element : response.getUserListDirectLicensesList()) {
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
// [END datamanager_v1_generated_UserListDirectLicenseService_ListUserListDirectLicenses_Paged_async]
