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

// [START securitycenter_set_unmute]

import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.Finding.Mute;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SetMuteRequest;
import java.io.IOException;

public class SetUnmuteFinding {

  public static void main(String[] args) {
    // TODO: Replace the variables within {}

    // findingPath: The relative resource name of the finding. See:
    // https://cloud.google.com/apis/design/resource_names#relative_resource_name
    // Use any one of the following formats:
    //  - organizations/{organization_id}/sources/{source_id}/finding/{finding_id}
    //  - folders/{folder_id}/sources/{source_id}/finding/{finding_id}
    //  - projects/{project_id}/sources/{source_id}/finding/{finding_id}
    String findingPath = "{path-to-the-finding}";
    setUnmute(findingPath);
  }

  // Unmute an individual finding.
  // Unmuting a finding that isn't muted has no effect.
  // Various mute states are: MUTE_UNSPECIFIED/MUTE/UNMUTE.
  public static void setUnmute(String findingPath) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      SetMuteRequest setMuteRequest =
          SetMuteRequest.newBuilder().setName(findingPath).setMute(Mute.UNMUTED).build();

      Finding finding = client.setMute(setMuteRequest);
      System.out.println(
          "Mute value for the finding " + finding.getName() + " is: " + finding.getMute());
    } catch (IOException e) {
      System.out.println("Failed to set the specified mute value. \n Exception: " + e);
    }
  }
}
// [END securitycenter_set_unmute]
