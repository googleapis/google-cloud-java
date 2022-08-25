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

// [START contactcenterinsights_create_analysis]

import com.google.cloud.contactcenterinsights.v1.Analysis;
import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import java.io.IOException;

public class CreateAnalysis {

  public static void main(String[] args) throws Exception, IOException {
    // TODO(developer): Replace this variable before running the sample.
    String conversationName =
        "projects/my_project_id/locations/us-central1/conversations/my_conversation_id";

    createAnalysis(conversationName);
  }

  public static Analysis createAnalysis(String conversationName) throws Exception, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      // Construct an analysis.
      Analysis analysis = Analysis.newBuilder().build();

      // Call the Insights client to create an analysis.
      Analysis response = client.createAnalysisAsync(conversationName, analysis).get();
      System.out.printf("Created %s%n", response.getName());
      return response;
    }
  }
}

// [END contactcenterinsights_create_analysis]
