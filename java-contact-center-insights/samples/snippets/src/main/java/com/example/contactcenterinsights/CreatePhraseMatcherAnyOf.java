/*
 * Copyright 2021 Google Inc.
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

package com.example.contactcenterinsights;

// [START contactcenterinsights_create_phrase_matcher_any_of]

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.ExactMatchConfig;
import com.google.cloud.contactcenterinsights.v1.LocationName;
import com.google.cloud.contactcenterinsights.v1.PhraseMatchRule;
import com.google.cloud.contactcenterinsights.v1.PhraseMatchRuleConfig;
import com.google.cloud.contactcenterinsights.v1.PhraseMatchRuleGroup;
import com.google.cloud.contactcenterinsights.v1.PhraseMatcher;
import java.io.IOException;

public class CreatePhraseMatcherAnyOf {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace this variable before running the sample.
    String projectId = "my_project_id";

    createPhraseMatcherAnyOf(projectId);
  }

  public static PhraseMatcher createPhraseMatcherAnyOf(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      // Construct a phrase matcher that matches any of its rule groups.
      PhraseMatcher.Builder phraseMatcher =
          PhraseMatcher.newBuilder()
              .setDisplayName("PHONE_SERVICE")
              .setTypeValue(2)
              .setActive(true);

      // Construct a rule group to match the word "PHONE" or "CELLPHONE", ignoring case sensitivity.
      PhraseMatchRuleGroup.Builder ruleGroup = PhraseMatchRuleGroup.newBuilder().setTypeValue(2);

      String[] words = {"PHONE", "CELLPHONE"};
      for (String w : words) {
        PhraseMatchRule.Builder rule =
            PhraseMatchRule.newBuilder()
                .setQuery(w)
                .setConfig(
                    PhraseMatchRuleConfig.newBuilder()
                        .setExactMatchConfig(ExactMatchConfig.newBuilder().build())
                        .build());
        ruleGroup.addPhraseMatchRules(rule.build());
      }
      phraseMatcher.addPhraseMatchRuleGroups(ruleGroup.build());

      // Construct a parent resource.
      LocationName parent = LocationName.of(projectId, "us-central1");

      // Call the Insights client to create a phrase matcher.
      PhraseMatcher response = client.createPhraseMatcher(parent, phraseMatcher.build());
      System.out.printf("Created %s%n", response.getName());
      return response;
    }
  }
}

// [END contactcenterinsights_create_phrase_matcher_any_of]
