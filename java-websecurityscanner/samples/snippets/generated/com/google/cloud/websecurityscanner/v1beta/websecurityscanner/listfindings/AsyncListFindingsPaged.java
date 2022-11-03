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

package com.google.cloud.websecurityscanner.v1beta.samples;

// [START websecurityscanner_v1beta_generated_WebSecurityScanner_ListFindings_Paged_async]
import com.google.cloud.websecurityscanner.v1beta.Finding;
import com.google.cloud.websecurityscanner.v1beta.ListFindingsRequest;
import com.google.cloud.websecurityscanner.v1beta.ListFindingsResponse;
import com.google.cloud.websecurityscanner.v1beta.ScanRunName;
import com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient;
import com.google.common.base.Strings;

public class AsyncListFindingsPaged {

  public static void main(String[] args) throws Exception {
    asyncListFindingsPaged();
  }

  public static void asyncListFindingsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WebSecurityScannerClient webSecurityScannerClient = WebSecurityScannerClient.create()) {
      ListFindingsRequest request =
          ListFindingsRequest.newBuilder()
              .setParent(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
              .setFilter("filter-1274492040")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      while (true) {
        ListFindingsResponse response =
            webSecurityScannerClient.listFindingsCallable().call(request);
        for (Finding element : response.getFindingsList()) {
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
// [END websecurityscanner_v1beta_generated_WebSecurityScanner_ListFindings_Paged_async]
