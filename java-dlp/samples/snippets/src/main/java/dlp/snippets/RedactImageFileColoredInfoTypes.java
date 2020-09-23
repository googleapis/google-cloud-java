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

// [START dlp_redact_image_colored_infotypes]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.Color;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageRequest.ImageRedactionConfig;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RedactImageFileColoredInfoTypes {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String inputPath = "src/test/resources/test.png";
    String outputPath = "redacted.png";
    redactImageFileColoredInfoTypes(projectId, inputPath, outputPath);
  }

  static void redactImageFileColoredInfoTypes(String projectId, String inputPath, String outputPath)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the content to be redacted.
      ByteString fileBytes = ByteString.readFrom(new FileInputStream(inputPath));
      ByteContentItem byteItem =
          ByteContentItem.newBuilder().setType(BytesType.IMAGE_JPEG).setData(fileBytes).build();

      // Define types of info to redact associate each one with a different color.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      ImageRedactionConfig ssnRedactionConfig =
          ImageRedactionConfig.newBuilder()
              .setInfoType(InfoType.newBuilder().setName("US_SOCIAL_SECURITY_NUMBER").build())
              .setRedactionColor(Color.newBuilder().setRed(.3f).setGreen(.1f).setBlue(.6f).build())
              .build();
      ImageRedactionConfig emailRedactionConfig =
          ImageRedactionConfig.newBuilder()
              .setInfoType(InfoType.newBuilder().setName("EMAIL_ADDRESS").build())
              .setRedactionColor(Color.newBuilder().setRed(.5f).setGreen(.5f).setBlue(1).build())
              .build();
      ImageRedactionConfig phoneRedactionConfig =
          ImageRedactionConfig.newBuilder()
              .setInfoType(InfoType.newBuilder().setName("PHONE_NUMBER").build())
              .setRedactionColor(Color.newBuilder().setRed(1).setGreen(0).setBlue(.6f).build())
              .build();

      // Create collection of all redact configurations.
      List<ImageRedactionConfig> imageRedactionConfigs =
          Arrays.asList(ssnRedactionConfig, emailRedactionConfig, phoneRedactionConfig);

      // List types of info to search for.
      InspectConfig config =
          InspectConfig.newBuilder()
              .addAllInfoTypes(
                  imageRedactionConfigs.stream()
                      .map(ImageRedactionConfig::getInfoType)
                      .collect(Collectors.toList()))
              .build();

      // Construct the Redact request to be sent by the client.
      RedactImageRequest request =
          RedactImageRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setByteItem(byteItem)
              .addAllImageRedactionConfigs(imageRedactionConfigs)
              .setInspectConfig(config)
              .build();

      // Use the client to send the API request.
      RedactImageResponse response = dlp.redactImage(request);

      // Parse the response and process results.
      FileOutputStream redacted = new FileOutputStream(outputPath);
      redacted.write(response.getRedactedImage().toByteArray());
      redacted.close();
      System.out.println("Redacted image written to " + outputPath);
    }
  }
}
// [END dlp_redact_image_colored_infotypes]
