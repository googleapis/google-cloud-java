/*
 * Copyright 2019 Google LLC
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

// [START dlp_redact_image]
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

class RedactImageFile {

  static void redactImageFile(String projectId, String filePath) {
    // String projectId = "my-project-id";
    // String filePath = "path/to/image.png";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the project used for request.
      ProjectName project = ProjectName.of(projectId);

      // Specify the content to be inspected.
      ByteString fileBytes = ByteString.readFrom(new FileInputStream(filePath));
      ByteContentItem byteItem =
          ByteContentItem.newBuilder().setType(BytesType.IMAGE).setData(fileBytes).build();

      // Specify the type of info and likelihood necessary to redact.
      List<InfoType> infoTypes = new ArrayList<>();
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      for (String typeName : new String[] {"PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER"}) {
        infoTypes.add(InfoType.newBuilder().setName(typeName).build());
      }
      InspectConfig config =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(Likelihood.LIKELY)
              .build();

      // Construct the Redact request to be sent by the client.
      RedactImageRequest request =
          RedactImageRequest.newBuilder()
              .setParent(project.toString())
              .setByteItem(byteItem)
              .setInspectConfig(config)
              .build();

      // Use the client to send the API request.
      RedactImageResponse response = dlp.redactImage(request);

      // Parse the response and process results.
      String outputPath = "redacted.png";
      FileOutputStream redacted = new FileOutputStream(outputPath);
      redacted.write(response.getRedactedImage().toByteArray());
      redacted.close();
      System.out.println("Redacted image written to " + outputPath);

    } catch (Exception e) {
      System.out.println("Error during inspectFile: \n" + e.toString());
    }
  }
}
// [END dlp_redact_image]
