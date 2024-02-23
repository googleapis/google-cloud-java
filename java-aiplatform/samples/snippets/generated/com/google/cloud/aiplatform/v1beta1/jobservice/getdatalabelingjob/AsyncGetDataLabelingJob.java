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

// [START aiplatform_v1beta1_generated_JobService_GetDataLabelingJob_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.DataLabelingJob;
import com.google.cloud.aiplatform.v1beta1.DataLabelingJobName;
import com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1beta1.JobServiceClient;

public class AsyncGetDataLabelingJob {

  public static void main(String[] args) throws Exception {
    asyncGetDataLabelingJob();
  }

  public static void asyncGetDataLabelingJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      GetDataLabelingJobRequest request =
          GetDataLabelingJobRequest.newBuilder()
              .setName(
                  DataLabelingJobName.of("[PROJECT]", "[LOCATION]", "[DATA_LABELING_JOB]")
                      .toString())
              .build();
      ApiFuture<DataLabelingJob> future =
          jobServiceClient.getDataLabelingJobCallable().futureCall(request);
      // Do something.
      DataLabelingJob response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_JobService_GetDataLabelingJob_async]
