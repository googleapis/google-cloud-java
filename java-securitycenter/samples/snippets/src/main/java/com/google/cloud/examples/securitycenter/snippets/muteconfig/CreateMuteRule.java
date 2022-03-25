/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.examples.securitycenter.snippets.muteconfig;

// [START securitycenter_create_mute_config]

import com.google.cloud.securitycenter.v1.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v1.MuteConfig;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;
import java.util.UUID;

public class CreateMuteRule {

  public static void main(String[] args) {
    // TODO: Replace the variables within {}

    // parentPath: Use any one of the following options:
    //             - organizations/{organization_id}
    //             - folders/{folder_id}
    //             - projects/{project_id}
    String parentPath = String.format("projects/%s", "your-google-cloud-project-id");

    // muteConfigId: Set a random id; max of 63 chars.
    String muteConfigId = "random-mute-id-" + UUID.randomUUID();
    createMuteRule(parentPath, muteConfigId);
  }

  // Creates a mute configuration under a given scope that will mute
  // all new findings that match a given filter.
  // Existing findings will not be muted.
  public static void createMuteRule(String parentPath, String muteConfigId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      MuteConfig muteConfig =
          MuteConfig.newBuilder()
              .setDescription("Mute low-medium IAM grants excluding 'compute' ")
              // Set mute rule(s).
              // To construct mute rules and for supported properties, see:
              // https://cloud.google.com/security-command-center/docs/how-to-mute-findings#create_mute_rules
              .setFilter(
                  "severity=\"LOW\" OR severity=\"MEDIUM\" AND "
                      + "category=\"Persistence: IAM Anomalous Grant\" AND "
                      + "-resource.type:\"compute\"")
              .build();

      CreateMuteConfigRequest request =
          CreateMuteConfigRequest.newBuilder()
              .setParent(parentPath)
              .setMuteConfigId(muteConfigId)
              .setMuteConfig(muteConfig)
              .build();

      // ExecutionException is thrown if the below call fails.
      MuteConfig response = client.createMuteConfig(request);
      System.out.println("Mute rule created successfully: " + response.getName());
    } catch (IOException e) {
      System.out.println("Mute rule creation failed! \n Exception: " + e);
    }
  }
}
// [END securitycenter_create_mute_config]
