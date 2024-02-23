/*
 * Copyright 2024 Google LLC
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

package com.google.dataflow.v1beta3.samples;

// [START dataflow_v1beta3_generated_MetricsV1Beta3_GetStageExecutionDetails_Paged_async]
import com.google.common.base.Strings;
import com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest;
import com.google.dataflow.v1beta3.MetricsV1Beta3Client;
import com.google.dataflow.v1beta3.StageExecutionDetails;
import com.google.dataflow.v1beta3.WorkerDetails;
import com.google.protobuf.Timestamp;

public class AsyncGetStageExecutionDetailsPaged {

  public static void main(String[] args) throws Exception {
    asyncGetStageExecutionDetailsPaged();
  }

  public static void asyncGetStageExecutionDetailsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
      GetStageExecutionDetailsRequest request =
          GetStageExecutionDetailsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setLocation("location1901043637")
              .setStageId("stageId-1897528135")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .build();
      while (true) {
        StageExecutionDetails response =
            metricsV1Beta3Client.getStageExecutionDetailsCallable().call(request);
        for (WorkerDetails element : response.getWorkersList()) {
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
// [END dataflow_v1beta3_generated_MetricsV1Beta3_GetStageExecutionDetails_Paged_async]
