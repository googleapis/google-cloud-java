/*
 * Copyright 2026 Google LLC
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

package com.google.iam.v3beta.samples;

// [START iam_v3beta_generated_PrincipalAccessBoundaryPolicies_ListPrincipalAccessBoundaryPolicies_async]
import com.google.api.core.ApiFuture;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest;
import com.google.iam.v3beta.OrganizationLocationName;
import com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient;
import com.google.iam.v3beta.PrincipalAccessBoundaryPolicy;

public class AsyncListPrincipalAccessBoundaryPolicies {

  public static void main(String[] args) throws Exception {
    asyncListPrincipalAccessBoundaryPolicies();
  }

  public static void asyncListPrincipalAccessBoundaryPolicies() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
        PrincipalAccessBoundaryPoliciesClient.create()) {
      ListPrincipalAccessBoundaryPoliciesRequest request =
          ListPrincipalAccessBoundaryPoliciesRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<PrincipalAccessBoundaryPolicy> future =
          principalAccessBoundaryPoliciesClient
              .listPrincipalAccessBoundaryPoliciesPagedCallable()
              .futureCall(request);
      // Do something.
      for (PrincipalAccessBoundaryPolicy element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END iam_v3beta_generated_PrincipalAccessBoundaryPolicies_ListPrincipalAccessBoundaryPolicies_async]
