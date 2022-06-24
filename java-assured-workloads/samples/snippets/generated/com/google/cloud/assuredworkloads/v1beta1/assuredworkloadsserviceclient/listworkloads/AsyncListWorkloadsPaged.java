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

package com.google.cloud.assuredworkloads.v1beta1.samples;

// [START
// assuredworkloads_v1beta1_generated_assuredworkloadsserviceclient_listworkloads_paged_async]
import com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest;
import com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse;
import com.google.cloud.assuredworkloads.v1beta1.LocationName;
import com.google.cloud.assuredworkloads.v1beta1.Workload;
import com.google.common.base.Strings;

public class AsyncListWorkloadsPaged {

  public static void main(String[] args) throws Exception {
    asyncListWorkloadsPaged();
  }

  public static void asyncListWorkloadsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
        AssuredWorkloadsServiceClient.create()) {
      ListWorkloadsRequest request =
          ListWorkloadsRequest.newBuilder()
              .setParent(LocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListWorkloadsResponse response =
            assuredWorkloadsServiceClient.listWorkloadsCallable().call(request);
        for (Workload element : response.getWorkloadsList()) {
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
// [END assuredworkloads_v1beta1_generated_assuredworkloadsserviceclient_listworkloads_paged_async]
