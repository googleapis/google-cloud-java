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

package com.google.cloud.securitycenter.v1p1beta1.samples;

// [START securitycenter_v1p1beta1_generated_securitycenterclient_groupfindings_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest;
import com.google.cloud.securitycenter.v1p1beta1.GroupResult;
import com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1p1beta1.SourceName;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;

public class AsyncGroupFindings {

  public static void main(String[] args) throws Exception {
    asyncGroupFindings();
  }

  public static void asyncGroupFindings() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      GroupFindingsRequest request =
          GroupFindingsRequest.newBuilder()
              .setParent(
                  SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
              .setFilter("filter-1274492040")
              .setGroupBy("groupBy293428022")
              .setReadTime(Timestamp.newBuilder().build())
              .setCompareDuration(Duration.newBuilder().build())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      ApiFuture<GroupResult> future =
          securityCenterClient.groupFindingsPagedCallable().futureCall(request);
      // Do something.
      for (GroupResult element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END securitycenter_v1p1beta1_generated_securitycenterclient_groupfindings_async]
