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

// [START dlp_inspect_string_without_overlap]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.ByteContentItem.BytesType;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CustomInfoType;
import com.google.privacy.dlp.v2.CustomInfoType.ExclusionType;
import com.google.privacy.dlp.v2.ExcludeInfoTypes;
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

public class InspectStringWithoutOverlap {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String textToInspect = "example.com is a domain, james@example.org is an email.";
    inspectStringWithoutOverlap(projectId, textToInspect);
  }

  // Inspects the provided text, avoiding matches specified in the exclusion list.
  public static void inspectStringWithoutOverlap(String projectId, String textToInspect)
      throws IOException {
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
      for (String typeName : new String[] {"DOMAIN_NAME", "EMAIL_ADDRESS"}) {
        infoTypes.add(InfoType.newBuilder().setName(typeName).build());
      }

      // Define a custom info type to exclude email addresses
      CustomInfoType customInfoType =
          CustomInfoType.newBuilder()
              .setInfoType(InfoType.newBuilder().setName("EMAIL_ADDRESS"))
              .setExclusionType(ExclusionType.EXCLUSION_TYPE_EXCLUDE)
              .build();

      // Exclude EMAIL_ADDRESS matches
      ExclusionRule exclusionRule =
          ExclusionRule.newBuilder()
              .setExcludeInfoTypes(
                  ExcludeInfoTypes.newBuilder()
                      .addInfoTypes(InfoType.newBuilder().setName("EMAIL_ADDRESS")))
              .setMatchingType(MatchingType.MATCHING_TYPE_PARTIAL_MATCH)
              .build();

      // Construct a ruleset that applies the exclusion rule to the DOMAIN_NAME infotype.
      // If a DOMAIN_NAME match is part of an EMAIL_ADDRESS match, the DOMAIN_NAME match will
      // be excluded.
      InspectionRuleSet ruleSet =
          InspectionRuleSet.newBuilder()
              .addInfoTypes(InfoType.newBuilder().setName("DOMAIN_NAME"))
              .addRules(InspectionRule.newBuilder().setExclusionRule(exclusionRule))
              .build();

      // Construct the configuration for the Inspect request, including the ruleset.
      InspectConfig config =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .addCustomInfoTypes(customInfoType)
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
// [END dlp_inspect_string_without_overlap]
