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

// [START dlp_deidentify_infotype]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InfoTypeTransformations;
import com.google.privacy.dlp.v2.InfoTypeTransformations.InfoTypeTransformation;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrimitiveTransformation;
import com.google.privacy.dlp.v2.ReplaceWithInfoTypeConfig;
import java.io.IOException;

public class DeIdentifyWithInfoType {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String textToInspect = "My email is test@example.com";
    deIdentifyWithInfoType(projectId, textToInspect);
  }

  public static void deIdentifyWithInfoType(String projectId, String textToRedact)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the content to be inspected.
      ContentItem item = ContentItem.newBuilder().setValue(textToRedact).build();

      // Specify the type of info the inspection will look for.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      InfoType infoType = InfoType.newBuilder().setName("EMAIL_ADDRESS").build();
      InspectConfig inspectConfig = InspectConfig.newBuilder().addInfoTypes(infoType).build();
      // Specify replacement string to be used for the finding.
      ReplaceWithInfoTypeConfig replaceWithInfoTypeConfig =
          ReplaceWithInfoTypeConfig.newBuilder().build();
      // Define type of deidentification as replacement with info type.
      PrimitiveTransformation primitiveTransformation =
          PrimitiveTransformation.newBuilder()
              .setReplaceWithInfoTypeConfig(replaceWithInfoTypeConfig)
              .build();
      // Associate deidentification type with info type.
      InfoTypeTransformation transformation =
          InfoTypeTransformation.newBuilder()
              .addInfoTypes(infoType)
              .setPrimitiveTransformation(primitiveTransformation)
              .build();
      // Construct the configuration for the Redact request and list all desired transformations.
      DeidentifyConfig redactConfig =
          DeidentifyConfig.newBuilder()
              .setInfoTypeTransformations(
                  InfoTypeTransformations.newBuilder().addTransformations(transformation))
              .build();

      // Construct the Redact request to be sent by the client.
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(item)
              .setDeidentifyConfig(redactConfig)
              .setInspectConfig(inspectConfig)
              .build();

      // Use the client to send the API request.
      DeidentifyContentResponse response = dlp.deidentifyContent(request);

      // Parse the response and process results
      System.out.println("Text after redaction: " + response.getItem().getValue());
    }
  }
}
// [END dlp_deidentify_replace]
