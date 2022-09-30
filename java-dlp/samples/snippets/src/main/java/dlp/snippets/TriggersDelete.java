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

// [START dlp_delete_trigger]
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.ProjectJobTriggerName;
import java.io.IOException;

class TriggersDelete {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String triggerId = "your-trigger-id";
    deleteTrigger(projectId, triggerId);
  }

  public static void deleteTrigger(String projectId, String triggerId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Get the full trigger name from the given triggerId and ProjectId
      ProjectJobTriggerName triggerName = ProjectJobTriggerName.of(projectId, triggerId);

      // Construct the trigger deletion request to be sent by the client
      DeleteJobTriggerRequest deleteJobTriggerRequest =
          DeleteJobTriggerRequest.newBuilder().setName(triggerName.toString()).build();

      // Send the trigger deletion request
      dlpServiceClient.deleteJobTrigger(deleteJobTriggerRequest);
      System.out.println("Trigger deleted: " + triggerName.toString());
    }
  }
}
// [END dlp_delete_trigger]
