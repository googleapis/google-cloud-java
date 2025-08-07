/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.issueresolution.v1.samples;

// [START merchantapi_v1_generated_IssueResolutionService_TriggerAction_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.issueresolution.v1.AccountName;
import com.google.shopping.merchant.issueresolution.v1.IssueResolutionServiceClient;
import com.google.shopping.merchant.issueresolution.v1.TriggerActionPayload;
import com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest;
import com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse;

public class AsyncTriggerAction {

  public static void main(String[] args) throws Exception {
    asyncTriggerAction();
  }

  public static void asyncTriggerAction() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IssueResolutionServiceClient issueResolutionServiceClient =
        IssueResolutionServiceClient.create()) {
      TriggerActionRequest request =
          TriggerActionRequest.newBuilder()
              .setName(AccountName.of("[ACCOUNT]").toString())
              .setPayload(TriggerActionPayload.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .build();
      ApiFuture<TriggerActionResponse> future =
          issueResolutionServiceClient.triggerActionCallable().futureCall(request);
      // Do something.
      TriggerActionResponse response = future.get();
    }
  }
}
// [END merchantapi_v1_generated_IssueResolutionService_TriggerAction_async]
