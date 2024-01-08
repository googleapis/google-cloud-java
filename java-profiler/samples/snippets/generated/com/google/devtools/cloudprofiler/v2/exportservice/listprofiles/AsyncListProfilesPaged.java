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

package com.google.devtools.cloudprofiler.v2.samples;

// [START cloudprofiler_v2_generated_ExportService_ListProfiles_Paged_async]
import com.google.common.base.Strings;
import com.google.devtools.cloudprofiler.v2.ExportServiceClient;
import com.google.devtools.cloudprofiler.v2.ListProfilesRequest;
import com.google.devtools.cloudprofiler.v2.ListProfilesResponse;
import com.google.devtools.cloudprofiler.v2.Profile;
import com.google.devtools.cloudprofiler.v2.ProjectName;

public class AsyncListProfilesPaged {

  public static void main(String[] args) throws Exception {
    asyncListProfilesPaged();
  }

  public static void asyncListProfilesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ExportServiceClient exportServiceClient = ExportServiceClient.create()) {
      ListProfilesRequest request =
          ListProfilesRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListProfilesResponse response = exportServiceClient.listProfilesCallable().call(request);
        for (Profile element : response.getProfilesList()) {
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
// [END cloudprofiler_v2_generated_ExportService_ListProfiles_Paged_async]
