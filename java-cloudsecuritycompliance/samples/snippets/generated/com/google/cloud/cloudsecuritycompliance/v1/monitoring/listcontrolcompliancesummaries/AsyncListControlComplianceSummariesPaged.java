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

package com.google.cloud.cloudsecuritycompliance.v1.samples;

// [START cloudsecuritycompliance_v1_generated_Monitoring_ListControlComplianceSummaries_Paged_async]
import com.google.cloud.cloudsecuritycompliance.v1.ControlComplianceSummary;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReportName;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient;
import com.google.common.base.Strings;
import com.google.protobuf.Timestamp;

public class AsyncListControlComplianceSummariesPaged {

  public static void main(String[] args) throws Exception {
    asyncListControlComplianceSummariesPaged();
  }

  public static void asyncListControlComplianceSummariesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MonitoringClient monitoringClient = MonitoringClient.create()) {
      ListControlComplianceSummariesRequest request =
          ListControlComplianceSummariesRequest.newBuilder()
              .setParent(
                  FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
                          "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
                      .toString())
              .setEndTime(Timestamp.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListControlComplianceSummariesResponse response =
            monitoringClient.listControlComplianceSummariesCallable().call(request);
        for (ControlComplianceSummary element : response.getControlComplianceSummariesList()) {
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
// [END cloudsecuritycompliance_v1_generated_Monitoring_ListControlComplianceSummaries_Paged_async]
