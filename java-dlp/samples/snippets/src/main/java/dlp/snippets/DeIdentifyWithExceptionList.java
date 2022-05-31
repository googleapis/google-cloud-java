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

// [START dlp_deidentify_exception_list]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CustomInfoType;
import com.google.privacy.dlp.v2.CustomInfoType.Dictionary;
import com.google.privacy.dlp.v2.CustomInfoType.Dictionary.WordList;
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

public class DeIdentifyWithExceptionList {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String textToDeIdentify = "jack@example.org accessed customer record of user5@example.com";
    deIdentifyWithExceptionList(projectId, textToDeIdentify);
  }

  public static void deIdentifyWithExceptionList(String projectId, String textToDeIdentify)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {

      // Specify what content you want the service to DeIdentify.
      ContentItem contentItem = ContentItem.newBuilder().setValue(textToDeIdentify).build();

      // Construct the custom word list to be detected.
      Dictionary wordList =
          Dictionary.newBuilder()
              .setWordList(
                  WordList.newBuilder()
                      .addWords("jack@example.org")
                      .addWords("jill@example.org")
                      .build())
              .build();

      // Construct the custom dictionary detector associated with the word list.
      InfoType developerEmail = InfoType.newBuilder().setName("DEVELOPER_EMAIL").build();
      CustomInfoType customInfoType =
          CustomInfoType.newBuilder().setInfoType(developerEmail).setDictionary(wordList).build();

      // Specify the word list custom info type and build-in info type the inspection will look for.
      InfoType emailAddress = InfoType.newBuilder().setName("EMAIL_ADDRESS").build();
      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addInfoTypes(emailAddress)
              .addCustomInfoTypes(customInfoType)
              .build();

      // Define type of deidentification as replacement.
      PrimitiveTransformation primitiveTransformation =
          PrimitiveTransformation.newBuilder()
              .setReplaceWithInfoTypeConfig(ReplaceWithInfoTypeConfig.getDefaultInstance())
              .build();

      // Associate de-identification type with info type.
      InfoTypeTransformation transformation =
          InfoTypeTransformation.newBuilder()
              .addInfoTypes(emailAddress)
              .setPrimitiveTransformation(primitiveTransformation)
              .build();

      // Construct the configuration for the de-id request and list all desired transformations.
      DeidentifyConfig deidentifyConfig =
          DeidentifyConfig.newBuilder()
              .setInfoTypeTransformations(
                  InfoTypeTransformations.newBuilder().addTransformations(transformation))
              .build();

      // Combine configurations into a request for the service.
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(contentItem)
              .setInspectConfig(inspectConfig)
              .setDeidentifyConfig(deidentifyConfig)
              .build();

      // Send the request and receive response from the service
      DeidentifyContentResponse response = dlp.deidentifyContent(request);

      // Print the results
      System.out.println(
          "Text after replace with infotype config: " + response.getItem().getValue());
    }
  }
}
// [END dlp_deidentify_exception_list]
