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

// [START dlp_inspect_string_with_exclusion_regex]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CustomInfoType.Regex;
import com.google.privacy.dlp.v2.ExclusionRule;
import com.google.privacy.dlp.v2.Finding;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectionRule;
import com.google.privacy.dlp.v2.InspectionRuleSet;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.MatchingType;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InspectStringWithExclusionRegex {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String textToInspect = "Some email addresses: gary@example.com, bob@example.org";
    String excludedRegex = ".+@example.com";
    inspectStringWithExclusionRegex(projectId, textToInspect, excludedRegex);
  }

  // Inspects the provided text, avoiding matches specified in the exclusion list.
  public static void inspectStringWithExclusionRegex(
      String projectId, String textToInspect, String excludedRegex) throws IOException {
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

      // Specify the type of info the inspection will look for.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types.
      List<InfoType> infoTypes = new ArrayList<>();
      for (String typeName : new String[] {"PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER"}) {
        infoTypes.add(InfoType.newBuilder().setName(typeName).build());
      }

      // Exclude matches from the specified excludedMatchList.
      ExclusionRule exclusionRule =
          ExclusionRule.newBuilder()
              .setMatchingType(MatchingType.MATCHING_TYPE_FULL_MATCH)
              .setRegex(Regex.newBuilder().setPattern(excludedRegex))
              .build();

      // Construct a ruleset that applies the exclusion rule to the EMAIL_ADDRESSES infotype.
      InspectionRuleSet ruleSet =
          InspectionRuleSet.newBuilder()
              .addInfoTypes(InfoType.newBuilder().setName("EMAIL_ADDRESS"))
              .addRules(InspectionRule.newBuilder().setExclusionRule(exclusionRule))
              .build();

      // Construct the configuration for the Inspect request, including the ruleset.
      InspectConfig config =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setIncludeQuote(true)
              .addRuleSet(ruleSet)
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
// [END dlp_inspect_string_with_exclusion_regex]
