/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dlp.snippets;

// [START dlp_delete_job]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DlpJobName;
import java.io.IOException;

public class JobsDelete {
  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String jobId = "your-job-id";
    deleteJobs(projectId, jobId);
  }

  // Deletes a DLP Job with the given jobId
  public static void deleteJobs(String projectId, String jobId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Construct the complete job name from the projectId and jobId
      DlpJobName jobName = DlpJobName.of(projectId, jobId);

      // Construct the job deletion request to be sent by the client.
      DeleteDlpJobRequest deleteDlpJobRequest =
          DeleteDlpJobRequest.newBuilder().setName(jobName.toString()).build();

      // Send the job deletion request
      dlpServiceClient.deleteDlpJob(deleteDlpJobRequest);
      System.out.println("Job deleted successfully.");
    }
  }
}
// [END dlp_delete_job]
