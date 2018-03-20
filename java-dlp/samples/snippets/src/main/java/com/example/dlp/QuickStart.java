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

package com.example.dlp;

import com.google.cloud.ServiceOptions;
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
import com.google.privacy.dlp.v2.ProjectName;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import java.util.List;

// [START dlp_quickstart]
public class QuickStart {

  /** Quick start to DLP API : inspects a given string for an InfoType. */
  public static void main(String[] args) throws Exception {

    // string to inspect
    String text = "His name was Robert Frost";

    // The minimum likelihood required before returning a match:
    // LIKELIHOOD_UNSPECIFIED, VERY_UNLIKELY, UNLIKELY, POSSIBLE, LIKELY, VERY_LIKELY, UNRECOGNIZED
    Likelihood minLikelihood = Likelihood.POSSIBLE;

    // The maximum number of findings to report (0 = server maximum)
    int maxFindings = 0;

    // The infoTypes of information to match
    List<InfoType> infoTypes =
        Arrays.asList(
            InfoType.newBuilder().setName("PERSON_NAME").build(),
            InfoType.newBuilder().setName("US_STATE").build());

    // Whether to include the matching string
    boolean includeQuote = true;

    // instantiate a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      InspectConfig.FindingLimits findingLimits =
          InspectConfig.FindingLimits.newBuilder().setMaxFindingsPerItem(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .setIncludeQuote(includeQuote)
              .build();

      ByteContentItem byteContentItem =
          ByteContentItem.newBuilder()
              .setType(ByteContentItem.BytesType.TEXT_UTF8)
              .setData(ByteString.copyFromUtf8(text))
              .build();
      ContentItem contentItem = ContentItem.newBuilder().setByteItem(byteContentItem).build();

      String projectId = ServiceOptions.getDefaultProjectId();
      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectConfig(inspectConfig)
              .setItem(contentItem)
              .build();

      // Inspect the text for info types
      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      InspectResult result = response.getResult();
      if (result.getFindingsCount() > 0) {
        System.out.println("Findings: ");
        for (Finding finding : result.getFindingsList()) {
          if (includeQuote) {
            System.out.print("\tQuote: " + finding.getQuote());
          }
          System.out.print("\tInfo type: " + finding.getInfoType().getName());
          System.out.println("\tLikelihood: " + finding.getLikelihood());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      System.out.println("Error in inspectString: " + e.getMessage());
    }
  }
}

// [END dlp_quickstart]
