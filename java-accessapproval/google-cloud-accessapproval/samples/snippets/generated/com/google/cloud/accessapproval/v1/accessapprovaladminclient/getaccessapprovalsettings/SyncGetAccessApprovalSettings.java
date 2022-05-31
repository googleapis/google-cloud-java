/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.accessapproval.v1.samples;

// [START accessapproval_v1_generated_accessapprovaladminclient_getaccessapprovalsettings_sync]
import com.google.cloud.accessapproval.v1.AccessApprovalAdminClient;
import com.google.cloud.accessapproval.v1.AccessApprovalSettings;
import com.google.cloud.accessapproval.v1.AccessApprovalSettingsName;
import com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage;

public class SyncGetAccessApprovalSettings {

  public static void main(String[] args) throws Exception {
    syncGetAccessApprovalSettings();
  }

  public static void syncGetAccessApprovalSettings() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
      GetAccessApprovalSettingsMessage request =
          GetAccessApprovalSettingsMessage.newBuilder()
              .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
              .build();
      AccessApprovalSettings response =
          accessApprovalAdminClient.getAccessApprovalSettings(request);
    }
  }
}
// [END accessapproval_v1_generated_accessapprovaladminclient_getaccessapprovalsettings_sync]
