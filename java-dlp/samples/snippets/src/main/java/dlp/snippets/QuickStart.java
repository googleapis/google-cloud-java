/*
 * Copyright 2017 Google Inc.
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

// [START dlp_quickstart]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.Finding;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectResult;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.LocationName;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickStart {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    quickstart(projectId);
  }

  public static void quickstart(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // Configure that content that will be inspected
      String text = "His name was Robert Frost";
      ByteContentItem byteContentItem =
          ByteContentItem.newBuilder()
              .setType(ByteContentItem.BytesType.TEXT_UTF8)
              .setData(ByteString.copyFromUtf8(text))
              .build();
      ContentItem contentItem = ContentItem.newBuilder().setByteItem(byteContentItem).build();

      // The types of information to match:
      // See: https://cloud.google.com/dlp/docs/infotypes-reference
      List<InfoType> infoTypes =
          Stream.of("PERSON_NAME", "US_STATE")
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      // The minimum likelihood required before returning a match:
      // See: https://cloud.google.com/dlp/docs/likelihood
      Likelihood minLikelihood = Likelihood.POSSIBLE;

      // The maximum number of findings to report (0 = server maximum)
      InspectConfig.FindingLimits findingLimits =
          InspectConfig.FindingLimits.newBuilder().setMaxFindingsPerItem(0).build();

      // Specify the inspection configuration
      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .setIncludeQuote(true)
              .build();

      // Create the request from previous configs
      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setInspectConfig(inspectConfig)
              .setItem(contentItem)
              .build();

      // Send the request to the service and receive the results
      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      // Process the results
      System.out.println("Inspect of text complete: ");
      InspectResult result = response.getResult();
      if (result.getFindingsCount() < 0) {
        System.out.println("No findings.");
        return;
      }
      System.out.println("Findings: ");
      for (Finding finding : result.getFindingsList()) {
        System.out.println("\tQuote: " + finding.getQuote());
        System.out.println("\tInfo type: " + finding.getInfoType().getName());
        System.out.println("\tLikelihood: " + finding.getLikelihood());
      }
    }
  }
}

// [END dlp_quickstart]
