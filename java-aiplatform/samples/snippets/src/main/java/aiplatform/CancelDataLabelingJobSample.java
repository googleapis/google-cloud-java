/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_cancel_data_labeling_job_sample]

import com.google.cloud.aiplatform.v1.DataLabelingJobName;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import java.io.IOException;

public class CancelDataLabelingJobSample {
  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String dataLabelingJobId = "YOUR_DATA_LABELING_JOB_ID";
    cancelDataLabelingJob(project, dataLabelingJobId);
  }

  static void cancelDataLabelingJob(String project, String dataLabelingJobId) throws IOException {
    JobServiceSettings jobServiceSettings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings)) {
      String location = "us-central1";

      DataLabelingJobName dataLabelingJobName =
          DataLabelingJobName.of(project, location, dataLabelingJobId);
      jobServiceClient.cancelDataLabelingJob(dataLabelingJobName);
      System.out.println("Cancelled Data labeling job");
    }
  }
}
// [END aiplatform_cancel_data_labeling_job_sample]
