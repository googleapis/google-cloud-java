/*
 * Copyright 2020 Google Inc.
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

// [START dlp_delete_inspect_template]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import java.io.IOException;

class TemplatesDelete {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String templateId = "your-template-id";
    deleteInspectTemplate(projectId, templateId);
  }

  // Delete an existing template
  public static void deleteInspectTemplate(String projectId, String templateId) throws IOException {
    // Construct the template name to be deleted
    String templateName = String.format("projects/%s/inspectTemplates/%s", projectId, templateId);

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Create delete template request to be sent by the client
      DeleteInspectTemplateRequest request =
          DeleteInspectTemplateRequest.newBuilder().setName(templateName).build();

      // Send the request with the client
      dlpServiceClient.deleteInspectTemplate(request);
      System.out.printf("Deleted template: %s\n", templateName);
    }
  }
}
// [END dlp_delete_inspect_template]
