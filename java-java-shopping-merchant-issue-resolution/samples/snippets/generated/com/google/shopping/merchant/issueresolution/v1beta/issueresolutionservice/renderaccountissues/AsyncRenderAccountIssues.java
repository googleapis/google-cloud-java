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

package com.google.shopping.merchant.issueresolution.v1beta.samples;

// [START merchantapi_v1beta_generated_IssueResolutionService_RenderAccountIssues_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.issueresolution.v1beta.AccountName;
import com.google.shopping.merchant.issueresolution.v1beta.IssueResolutionServiceClient;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1beta.RenderIssuesRequestPayload;

public class AsyncRenderAccountIssues {

  public static void main(String[] args) throws Exception {
    asyncRenderAccountIssues();
  }

  public static void asyncRenderAccountIssues() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IssueResolutionServiceClient issueResolutionServiceClient =
        IssueResolutionServiceClient.create()) {
      RenderAccountIssuesRequest request =
          RenderAccountIssuesRequest.newBuilder()
              .setName(AccountName.of("[ACCOUNT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setTimeZone("timeZone-2077180903")
              .setPayload(RenderIssuesRequestPayload.newBuilder().build())
              .build();
      ApiFuture<RenderAccountIssuesResponse> future =
          issueResolutionServiceClient.renderAccountIssuesCallable().futureCall(request);
      // Do something.
      RenderAccountIssuesResponse response = future.get();
    }
  }
}
// [END merchantapi_v1beta_generated_IssueResolutionService_RenderAccountIssues_async]
