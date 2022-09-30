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

// [START contactcenterinsights_set_project_ttl]

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.Settings;
import com.google.cloud.contactcenterinsights.v1.SettingsName;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import java.io.IOException;

public class SetProjectTtl {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace this variable before running the sample.
    String projectId = "my_project_id";

    setProjectTtl(projectId);
  }

  public static void setProjectTtl(String projectId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      // Construct a settings resource.
      SettingsName name = SettingsName.of(projectId, "us-central1");
      Settings settings =
          Settings.newBuilder()
              .setName(name.toString())
              .setConversationTtl(Duration.newBuilder().setSeconds(86400).build())
              .build();

      // Construct an update mask.
      FieldMask updateMask = FieldMask.newBuilder().addPaths("conversation_ttl").build();

      // Call the Insights client to set a project-level TTL.
      Settings response = client.updateSettings(settings, updateMask);
      System.out.printf("Set TTL for all incoming conversations to 1 day");
    }
  }
}

// [END contactcenterinsights_set_project_ttl]
