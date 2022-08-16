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

// [START dlp_redact_image_all_infotypes]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class RedactImageFileAllInfoTypes {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String inputPath = "src/test/resources/sensitive-data-image.jpeg";
    String outputPath = "sensitive-data-image-redacted.jpeg";
    redactImageFileAllInfoTypes(projectId, inputPath, outputPath);
  }

  static void redactImageFileAllInfoTypes(String projectId, String inputPath, String outputPath)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the content to be redacted.
      ByteString fileBytes = ByteString.readFrom(new FileInputStream(inputPath));
      ByteContentItem byteItem =
          ByteContentItem.newBuilder().setType(BytesType.IMAGE_JPEG).setData(fileBytes).build();

      // Construct the Redact request to be sent by the client.
      // Do not specify the type of info to redact.
      RedactImageRequest request =
          RedactImageRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setByteItem(byteItem)
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
// [END dlp_redact_image_all_infotypes]
