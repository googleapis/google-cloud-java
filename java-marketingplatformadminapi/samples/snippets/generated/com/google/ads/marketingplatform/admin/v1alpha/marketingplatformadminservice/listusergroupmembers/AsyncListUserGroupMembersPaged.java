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

package com.google.ads.marketingplatform.admin.v1alpha.samples;

// [START marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_ListUserGroupMembers_Paged_async]
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersResponse;
import com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroupMember;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroupName;
import com.google.common.base.Strings;

public class AsyncListUserGroupMembersPaged {

  public static void main(String[] args) throws Exception {
    asyncListUserGroupMembersPaged();
  }

  public static void asyncListUserGroupMembersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
        MarketingplatformAdminServiceClient.create()) {
      ListUserGroupMembersRequest request =
          ListUserGroupMembersRequest.newBuilder()
              .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListUserGroupMembersResponse response =
            marketingplatformAdminServiceClient.listUserGroupMembersCallable().call(request);
        for (UserGroupMember element : response.getUserGroupMembersList()) {
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
// [END marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_ListUserGroupMembers_Paged_async]
