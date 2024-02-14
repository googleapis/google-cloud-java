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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_JobService_ListBatchPredictionJobs_Paged_async]
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsRequest;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsResponse;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.common.base.Strings;
import com.google.protobuf.FieldMask;

public class AsyncListBatchPredictionJobsPaged {

  public static void main(String[] args) throws Exception {
    asyncListBatchPredictionJobsPaged();
  }

  public static void asyncListBatchPredictionJobsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      ListBatchPredictionJobsRequest request =
          ListBatchPredictionJobsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setReadMask(FieldMask.newBuilder().build())
              .build();
      while (true) {
        ListBatchPredictionJobsResponse response =
            jobServiceClient.listBatchPredictionJobsCallable().call(request);
        for (BatchPredictionJob element : response.getBatchPredictionJobsList()) {
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
// [END aiplatform_v1_generated_JobService_ListBatchPredictionJobs_Paged_async]
