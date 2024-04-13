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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_ModelMonitoringService_ListModelMonitoringJobs_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ModelMonitorName;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient;
import com.google.protobuf.FieldMask;

public class AsyncListModelMonitoringJobs {

  public static void main(String[] args) throws Exception {
    asyncListModelMonitoringJobs();
  }

  public static void asyncListModelMonitoringJobs() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ModelMonitoringServiceClient modelMonitoringServiceClient =
        ModelMonitoringServiceClient.create()) {
      ListModelMonitoringJobsRequest request =
          ListModelMonitoringJobsRequest.newBuilder()
              .setParent(
                  ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setReadMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<ModelMonitoringJob> future =
          modelMonitoringServiceClient.listModelMonitoringJobsPagedCallable().futureCall(request);
      // Do something.
      for (ModelMonitoringJob element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END aiplatform_v1beta1_generated_ModelMonitoringService_ListModelMonitoringJobs_async]
