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

// [START merchantapi_v1beta_generated_IssueResolutionService_RenderProductIssues_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.issueresolution.v1beta.IssueResolutionServiceClient;
import com.google.shopping.merchant.issueresolution.v1beta.ProductName;
import com.google.shopping.merchant.issueresolution.v1beta.RenderIssuesRequestPayload;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesResponse;

public class AsyncRenderProductIssues {

  public static void main(String[] args) throws Exception {
    asyncRenderProductIssues();
  }

  public static void asyncRenderProductIssues() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IssueResolutionServiceClient issueResolutionServiceClient =
        IssueResolutionServiceClient.create()) {
      RenderProductIssuesRequest request =
          RenderProductIssuesRequest.newBuilder()
              .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setTimeZone("timeZone-2077180903")
              .setPayload(RenderIssuesRequestPayload.newBuilder().build())
              .build();
      ApiFuture<RenderProductIssuesResponse> future =
          issueResolutionServiceClient.renderProductIssuesCallable().futureCall(request);
      // Do something.
      RenderProductIssuesResponse response = future.get();
    }
  }
}
// [END merchantapi_v1beta_generated_IssueResolutionService_RenderProductIssues_async]
