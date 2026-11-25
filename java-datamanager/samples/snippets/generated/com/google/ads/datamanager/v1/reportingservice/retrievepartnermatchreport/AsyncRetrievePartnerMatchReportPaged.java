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

package com.google.ads.datamanager.v1.samples;

// [START datamanager_v1_generated_ReportingService_RetrievePartnerMatchReport_Paged_async]
import com.google.ads.datamanager.v1.PartnerMatchReportEntry;
import com.google.ads.datamanager.v1.ReportingServiceClient;
import com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest;
import com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse;
import com.google.common.base.Strings;

public class AsyncRetrievePartnerMatchReportPaged {

  public static void main(String[] args) throws Exception {
    asyncRetrievePartnerMatchReportPaged();
  }

  public static void asyncRetrievePartnerMatchReportPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
      RetrievePartnerMatchReportRequest request =
          RetrievePartnerMatchReportRequest.newBuilder()
              .setParent("parent-995424086")
              .setCurrencyCode("currencyCode1004773790")
              .setFilter("filter-1274492040")
              .setStartDate(-1573629589)
              .setEndDate(1725067410)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        RetrievePartnerMatchReportResponse response =
            reportingServiceClient.retrievePartnerMatchReportCallable().call(request);
        for (PartnerMatchReportEntry element : response.getPartnerMatchReportEntriesList()) {
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
// [END datamanager_v1_generated_ReportingService_RetrievePartnerMatchReport_Paged_async]
