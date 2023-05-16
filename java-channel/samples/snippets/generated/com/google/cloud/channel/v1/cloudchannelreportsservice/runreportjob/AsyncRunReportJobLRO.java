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

package com.google.cloud.channel.v1.samples;

// [START cloudchannel_v1_generated_CloudChannelReportsService_RunReportJob_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.channel.v1.CloudChannelReportsServiceClient;
import com.google.cloud.channel.v1.DateRange;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.ReportName;
import com.google.cloud.channel.v1.RunReportJobRequest;
import com.google.cloud.channel.v1.RunReportJobResponse;

public class AsyncRunReportJobLRO {

  public static void main(String[] args) throws Exception {
    asyncRunReportJobLRO();
  }

  public static void asyncRunReportJobLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
        CloudChannelReportsServiceClient.create()) {
      RunReportJobRequest request =
          RunReportJobRequest.newBuilder()
              .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
              .setDateRange(DateRange.newBuilder().build())
              .setFilter("filter-1274492040")
              .setLanguageCode("languageCode-2092349083")
              .build();
      OperationFuture<RunReportJobResponse, OperationMetadata> future =
          cloudChannelReportsServiceClient.runReportJobOperationCallable().futureCall(request);
      // Do something.
      RunReportJobResponse response = future.get();
    }
  }
}
// [END cloudchannel_v1_generated_CloudChannelReportsService_RunReportJob_LRO_async]
