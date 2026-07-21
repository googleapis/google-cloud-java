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

package com.google.cloud.agentidentity.v1.samples;

// [START agentidentity_v1_generated_AuthProviderService_QueryWorkloads_Paged_async]
import com.google.cloud.agentidentity.v1.AuthProviderName;
import com.google.cloud.agentidentity.v1.AuthProviderServiceClient;
import com.google.cloud.agentidentity.v1.QueryWorkloadsRequest;
import com.google.cloud.agentidentity.v1.QueryWorkloadsResponse;
import com.google.common.base.Strings;

public class AsyncQueryWorkloadsPaged {

  public static void main(String[] args) throws Exception {
    asyncQueryWorkloadsPaged();
  }

  public static void asyncQueryWorkloadsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
      QueryWorkloadsRequest request =
          QueryWorkloadsRequest.newBuilder()
              .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        QueryWorkloadsResponse response =
            authProviderServiceClient.queryWorkloadsCallable().call(request);
        for (String element : response.getWorkloadIdsList()) {
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
// [END agentidentity_v1_generated_AuthProviderService_QueryWorkloads_Paged_async]
