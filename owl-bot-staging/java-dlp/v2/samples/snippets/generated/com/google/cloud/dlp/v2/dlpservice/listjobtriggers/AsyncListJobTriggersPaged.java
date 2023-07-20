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

package com.google.cloud.dlp.v2.samples;

// [START dlp_v2_generated_DlpService_ListJobTriggers_Paged_async]
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.base.Strings;
import com.google.privacy.dlp.v2.DlpJobType;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ProjectName;

public class AsyncListJobTriggersPaged {

  public static void main(String[] args) throws Exception {
    asyncListJobTriggersPaged();
  }

  public static void asyncListJobTriggersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      ListJobTriggersRequest request =
          ListJobTriggersRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .setOrderBy("orderBy-1207110587")
              .setFilter("filter-1274492040")
              .setType(DlpJobType.forNumber(0))
              .setLocationId("locationId1541836720")
              .build();
      while (true) {
        ListJobTriggersResponse response = dlpServiceClient.listJobTriggersCallable().call(request);
        for (JobTrigger element : response.getJobTriggersList()) {
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
// [END dlp_v2_generated_DlpService_ListJobTriggers_Paged_async]
