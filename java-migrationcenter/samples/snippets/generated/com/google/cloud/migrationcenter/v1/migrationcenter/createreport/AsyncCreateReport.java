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

package com.google.cloud.migrationcenter.v1.samples;

// [START migrationcenter_v1_generated_MigrationCenter_CreateReport_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.migrationcenter.v1.CreateReportRequest;
import com.google.cloud.migrationcenter.v1.MigrationCenterClient;
import com.google.cloud.migrationcenter.v1.Report;
import com.google.cloud.migrationcenter.v1.ReportConfigName;
import com.google.longrunning.Operation;

public class AsyncCreateReport {

  public static void main(String[] args) throws Exception {
    asyncCreateReport();
  }

  public static void asyncCreateReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
      CreateReportRequest request =
          CreateReportRequest.newBuilder()
              .setParent(
                  ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
              .setReportId("reportId-427040401")
              .setReport(Report.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          migrationCenterClient.createReportCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END migrationcenter_v1_generated_MigrationCenter_CreateReport_async]
