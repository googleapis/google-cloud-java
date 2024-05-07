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

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_LiveVideoAnalytics_ListAnalyses_Paged_async]
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.ClusterName;
import com.google.cloud.visionai.v1.ListAnalysesRequest;
import com.google.cloud.visionai.v1.ListAnalysesResponse;
import com.google.cloud.visionai.v1.LiveVideoAnalyticsClient;
import com.google.common.base.Strings;

public class AsyncListAnalysesPaged {

  public static void main(String[] args) throws Exception {
    asyncListAnalysesPaged();
  }

  public static void asyncListAnalysesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
      ListAnalysesRequest request =
          ListAnalysesRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListAnalysesResponse response =
            liveVideoAnalyticsClient.listAnalysesCallable().call(request);
        for (Analysis element : response.getAnalysesList()) {
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
// [END visionai_v1_generated_LiveVideoAnalytics_ListAnalyses_Paged_async]
