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

// [START dlp_inspect_string_custom_hotword]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CustomInfoType.DetectionRule.HotwordRule;
import com.google.privacy.dlp.v2.CustomInfoType.DetectionRule.LikelihoodAdjustment;
import com.google.privacy.dlp.v2.CustomInfoType.DetectionRule.Proximity;
import com.google.privacy.dlp.v2.CustomInfoType.Regex;
import com.google.privacy.dlp.v2.Finding;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectionRule;
import com.google.privacy.dlp.v2.InspectionRuleSet;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.LocationName;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class InspectStringCustomHotword {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String textToInspect = "patient name: John Doe";
    String customHotword = "patient";
    inspectStringCustomHotword(projectId, textToInspect, customHotword);
  }

  // Inspects the provided text.
  public static void inspectStringCustomHotword(
      String projectId, String textToInspect, String customHotword) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the type and content to be inspected.
      ByteContentItem byteItem =
          ByteContentItem.newBuilder()
              .setType(BytesType.TEXT_UTF8)
              .setData(ByteString.copyFromUtf8(textToInspect))
              .build();
      ContentItem item = ContentItem.newBuilder().setByteItem(byteItem).build();

      // Increase likelihood of matches that have customHotword nearby
      HotwordRule hotwordRule =
          HotwordRule.newBuilder()
              .setHotwordRegex(Regex.newBuilder().setPattern(customHotword))
              .setProximity(Proximity.newBuilder().setWindowBefore(50))
              .setLikelihoodAdjustment(
                  LikelihoodAdjustment.newBuilder().setFixedLikelihood(Likelihood.VERY_LIKELY))
              .build();

      // Construct a ruleset that applies the hotword rule to the PERSON_NAME infotype.
      InspectionRuleSet ruleSet =
          InspectionRuleSet.newBuilder()
              .addInfoTypes(InfoType.newBuilder().setName("PERSON_NAME").build())
              .addRules(InspectionRule.newBuilder().setHotwordRule(hotwordRule))
              .build();

      // Construct the configuration for the Inspect request.
      InspectConfig config =
          InspectConfig.newBuilder()
              .addInfoTypes(InfoType.newBuilder().setName("PERSON_NAME").build())
              .setIncludeQuote(true)
              .addRuleSet(ruleSet)
              .setMinLikelihood(Likelihood.VERY_LIKELY)
              .build();

      // Construct the Inspect request to be sent by the client.
      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(item)
              .setInspectConfig(config)
              .build();

      // Use the client to send the API request.
      InspectContentResponse response = dlp.inspectContent(request);

      // Parse the response and process results
      System.out.println("Findings: " + response.getResult().getFindingsCount());
      for (Finding f : response.getResult().getFindingsList()) {
        System.out.println("\tQuote: " + f.getQuote());
        System.out.println("\tInfo type: " + f.getInfoType().getName());
        System.out.println("\tLikelihood: " + f.getLikelihood());
      }
    }
  }
}
// [END dlp_inspect_string_custom_hotword]
