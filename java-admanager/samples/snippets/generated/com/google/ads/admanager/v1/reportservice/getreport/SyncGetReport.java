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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_ReportService_GetReport_sync]
import com.google.ads.admanager.v1.GetReportRequest;
import com.google.ads.admanager.v1.Report;
import com.google.ads.admanager.v1.ReportName;
import com.google.ads.admanager.v1.ReportServiceClient;

public class SyncGetReport {

  public static void main(String[] args) throws Exception {
    syncGetReport();
  }

  public static void syncGetReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
      GetReportRequest request =
          GetReportRequest.newBuilder()
              .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
              .build();
      Report response = reportServiceClient.getReport(request);
    }
  }
}
// [END admanager_v1_generated_ReportService_GetReport_sync]
