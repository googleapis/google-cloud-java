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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_TeamService_ListTeams_async]
import com.google.ads.admanager.v1.ListTeamsRequest;
import com.google.ads.admanager.v1.NetworkName;
import com.google.ads.admanager.v1.Team;
import com.google.ads.admanager.v1.TeamServiceClient;
import com.google.api.core.ApiFuture;

public class AsyncListTeams {

  public static void main(String[] args) throws Exception {
    asyncListTeams();
  }

  public static void asyncListTeams() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
      ListTeamsRequest request =
          ListTeamsRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setSkip(3532159)
              .build();
      ApiFuture<Team> future = teamServiceClient.listTeamsPagedCallable().futureCall(request);
      // Do something.
      for (Team element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END admanager_v1_generated_TeamService_ListTeams_async]
