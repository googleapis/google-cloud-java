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

// [START contactcenterinsights_create_issue_model]

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.IssueModel;
import com.google.cloud.contactcenterinsights.v1.LocationName;
import java.io.IOException;

public class CreateIssueModel {

  public static void main(String[] args) throws Exception, IOException {
    // TODO(developer): Replace this variable before running the sample.
    String projectId = "my_project_id";

    createIssueModel(projectId);
  }

  public static IssueModel createIssueModel(String projectId) throws Exception, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      // Construct a parent resource.
      LocationName parent = LocationName.of(projectId, "us-central1");

      // Construct an issue model.
      IssueModel issueModel =
          IssueModel.newBuilder()
              .setDisplayName("my-model")
              .setInputDataConfig(
                  IssueModel.InputDataConfig.newBuilder().setFilter("medium=\"CHAT\"").build())
              .build();

      // Call the Insights client to create an issue model.
      IssueModel response = client.createIssueModelAsync(parent, issueModel).get();
      System.out.printf("Created %s%n", response.getName());
      return response;
    }
  }
}

// [END contactcenterinsights_create_issue_model]
