/*
 * Copyright 2022 Google LLC
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

// [START securitycenter_delete_mute_config]

import com.google.cloud.securitycenter.v1.MuteConfigName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;

public class DeleteMuteRule {

  public static void main(String[] args) {
    // TODO(Developer): Replace the following variables
    // parentPath: Use any one of the following options:
    //             - organizations/{organization_id}
    //             - folders/{folder_id}
    //             - projects/{project_id}
    String parentPath = String.format("projects/%s", "your-google-cloud-project-id");

    // muteConfigId: Specify the name of the mute config to delete.
    String muteConfigId = "mute-config-id";

    deleteMuteRule(parentPath, muteConfigId);
  }

  // Deletes a mute configuration given its resource name.
  // Note: Previously muted findings are not affected when a mute config is deleted.
  public static void deleteMuteRule(String projectId, String muteConfigId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Use appropriate MuteConfigName methods depending on the type of parent.
      // org -> MuteConfigName.ofOrganizationMuteConfigName()
      // folder -> MuteConfigName.ofFolderMuteConfigName()
      // project -> MuteConfigName.ofProjectMuteConfigName)
      client.deleteMuteConfig(MuteConfigName.ofProjectMuteConfigName(projectId, muteConfigId));

      System.out.println("Mute rule deleted successfully: " + muteConfigId);
    } catch (IOException e) {
      System.out.println("Mute rule deletion failed! \n Exception: " + e);
    }
  }
}
// [END securitycenter_delete_mute_config]
