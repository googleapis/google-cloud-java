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

// [START dlp_create_inspect_template]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.LocationName;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TemplatesCreate {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    createInspectTemplate(projectId);
  }

  // Creates a template to persist configuration information
  public static void createInspectTemplate(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // Specify the type of info the inspection will look for.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      List<InfoType> infoTypes =
          Stream.of("PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER")
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      // Construct the inspection configuration for the template
      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();

      // Optionally set a display name and a description for the template
      String displayName = "Inspection Config Template";
      String description = "Save configuration for future inspection jobs";

      // Build the template
      InspectTemplate inspectTemplate =
          InspectTemplate.newBuilder()
              .setInspectConfig(inspectConfig)
              .setDisplayName(displayName)
              .setDescription(description)
              .build();

      // Create the request to be sent by the client
      CreateInspectTemplateRequest createInspectTemplateRequest =
          CreateInspectTemplateRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setInspectTemplate(inspectTemplate)
              .build();

      // Send the request to the API and process the response
      InspectTemplate response =
          dlpServiceClient.createInspectTemplate(createInspectTemplateRequest);
      System.out.printf("Template created: %s", response.getName());
    }
  }
}
// [END dlp_create_inspect_template]
