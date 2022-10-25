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

// [START channel_v1_generated_cloudchannelreportsserviceclient_fetchreportresults_sync]
import com.google.cloud.channel.v1.CloudChannelReportsServiceClient;
import com.google.cloud.channel.v1.FetchReportResultsRequest;
import com.google.cloud.channel.v1.ReportJobName;
import com.google.cloud.channel.v1.Row;

public class SyncFetchReportResults {

  public static void main(String[] args) throws Exception {
    syncFetchReportResults();
  }

  public static void syncFetchReportResults() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
        CloudChannelReportsServiceClient.create()) {
      FetchReportResultsRequest request =
          FetchReportResultsRequest.newBuilder()
              .setReportJob(ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (Row element :
          cloudChannelReportsServiceClient.fetchReportResults(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END channel_v1_generated_cloudchannelreportsserviceclient_fetchreportresults_sync]
