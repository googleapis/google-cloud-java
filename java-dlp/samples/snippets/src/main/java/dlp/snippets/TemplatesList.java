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

// [START dlp_list_inspect_templates]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.LocationName;
import java.io.IOException;

class TemplatesList {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listInspectTemplates(projectId);
  }

  // Lists all templates associated with a given project
  public static void listInspectTemplates(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Create the request to be sent by the client
      ListInspectTemplatesRequest request =
          ListInspectTemplatesRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setPageSize(1)
              .build();

      // Send the request
      ListInspectTemplatesPagedResponse response = dlpServiceClient.listInspectTemplates(request);

      // Parse through and process the response
      System.out.println("Templates found:");
      for (InspectTemplate template : response.getPage().getResponse().getInspectTemplatesList()) {
        System.out.printf("Template name: %s\n", template.getName());
        if (template.getDisplayName() != null) {
          System.out.printf("\tDisplay name: %s \n", template.getDisplayName());
          System.out.printf("\tCreate time: %s \n", template.getCreateTime());
          System.out.printf("\tUpdate time: %s \n", template.getUpdateTime());

          // print inspection config
          InspectConfig inspectConfig = template.getInspectConfig();
          for (InfoType infoType : inspectConfig.getInfoTypesList()) {
            System.out.printf("\tInfoType: %s\n", infoType.getName());
          }
          System.out.printf("\tMin likelihood: %s\n", inspectConfig.getMinLikelihood());
          System.out.printf("\tLimits: %s\n", inspectConfig.getLimits().getMaxFindingsPerRequest());
        }
      }
    }
  }
}
// [END dlp_list_inspect_templates]
