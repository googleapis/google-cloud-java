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

package com.google.shopping.merchant.reports.v1alpha.samples;

// [START merchantapi_v1alpha_generated_ReportService_Search_Paged_async]
import com.google.common.base.Strings;
import com.google.shopping.merchant.reports.v1alpha.ReportRow;
import com.google.shopping.merchant.reports.v1alpha.ReportServiceClient;
import com.google.shopping.merchant.reports.v1alpha.SearchRequest;
import com.google.shopping.merchant.reports.v1alpha.SearchResponse;

public class AsyncSearchPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchPaged();
  }

  public static void asyncSearchPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        SearchResponse response = reportServiceClient.searchCallable().call(request);
        for (ReportRow element : response.getResultsList()) {
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
// [END merchantapi_v1alpha_generated_ReportService_Search_Paged_async]
