// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// [START batch_get_job]

import com.google.cloud.batch.v1.BatchServiceClient;
import com.google.cloud.batch.v1.Job;
import com.google.cloud.batch.v1.JobName;
import java.io.IOException;

public class GetJob {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // Project ID or project number of the Cloud project you want to use.
    String projectId = "YOUR_PROJECT_ID";

    // Name of the region hosts the job.
    String region = "europe-central2";

    // The name of the job you want to retrieve information about.
    String jobName = "JOB_NAME";

    getJob(projectId, region, jobName);
  }

  // Retrieve information about a Batch Job.
  public static void getJob(String projectId, String region, String jobName) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `batchServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (BatchServiceClient batchServiceClient = BatchServiceClient.create()) {

      Job job =
          batchServiceClient.getJob(
              JobName.newBuilder()
                  .setProject(projectId)
                  .setLocation(region)
                  .setJob(jobName)
                  .build());

      System.out.printf("Retrieved the job: %s ", job.getName());
    }
  }
}
// [END batch_get_job]
