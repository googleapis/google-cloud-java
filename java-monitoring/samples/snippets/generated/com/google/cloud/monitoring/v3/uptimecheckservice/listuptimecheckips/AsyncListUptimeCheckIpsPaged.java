/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.monitoring.v3.samples;

// [START monitoring_v3_generated_UptimeCheckService_ListUptimeCheckIps_Paged_async]
import com.google.cloud.monitoring.v3.UptimeCheckServiceClient;
import com.google.common.base.Strings;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UptimeCheckIp;

public class AsyncListUptimeCheckIpsPaged {

  public static void main(String[] args) throws Exception {
    asyncListUptimeCheckIpsPaged();
  }

  public static void asyncListUptimeCheckIpsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
      ListUptimeCheckIpsRequest request =
          ListUptimeCheckIpsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListUptimeCheckIpsResponse response =
            uptimeCheckServiceClient.listUptimeCheckIpsCallable().call(request);
        for (UptimeCheckIp element : response.getUptimeCheckIpsList()) {
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
// [END monitoring_v3_generated_UptimeCheckService_ListUptimeCheckIps_Paged_async]
