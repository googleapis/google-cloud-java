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

// [START
// accessapproval_v1_generated_accessapprovaladminclient_listapprovalrequests_projectname_sync]
import com.google.cloud.accessapproval.v1.AccessApprovalAdminClient;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import com.google.cloud.accessapproval.v1.ProjectName;

public class SyncListApprovalRequestsProjectname {

  public static void main(String[] args) throws Exception {
    syncListApprovalRequestsProjectname();
  }

  public static void syncListApprovalRequestsProjectname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
      ProjectName parent = ProjectName.of("[PROJECT]");
      for (ApprovalRequest element :
          accessApprovalAdminClient.listApprovalRequests(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END accessapproval_v1_generated_accessapprovaladminclient_listapprovalrequests_projectname_sync]
