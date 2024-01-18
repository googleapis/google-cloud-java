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

// [START accessapproval_v1_generated_accessapprovaladminclient_getapprovalrequest_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.accessapproval.v1.AccessApprovalAdminClient;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import com.google.cloud.accessapproval.v1.ApprovalRequestName;
import com.google.cloud.accessapproval.v1.GetApprovalRequestMessage;

public class AsyncGetApprovalRequest {

  public static void main(String[] args) throws Exception {
    asyncGetApprovalRequest();
  }

  public static void asyncGetApprovalRequest() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
      GetApprovalRequestMessage request =
          GetApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .build();
      ApiFuture<ApprovalRequest> future =
          accessApprovalAdminClient.getApprovalRequestCallable().futureCall(request);
      // Do something.
      ApprovalRequest response = future.get();
    }
  }
}
// [END accessapproval_v1_generated_accessapprovaladminclient_getapprovalrequest_async]
