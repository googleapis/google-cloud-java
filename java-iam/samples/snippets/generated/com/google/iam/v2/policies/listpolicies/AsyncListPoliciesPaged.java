/*
 * Copyright 2024 Google LLC
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

package com.google.iam.v2.samples;

// [START iam_v2_generated_Policies_ListPolicies_Paged_async]
import com.google.common.base.Strings;
import com.google.iam.v2.ListPoliciesRequest;
import com.google.iam.v2.ListPoliciesResponse;
import com.google.iam.v2.PoliciesClient;
import com.google.iam.v2.Policy;

public class AsyncListPoliciesPaged {

  public static void main(String[] args) throws Exception {
    asyncListPoliciesPaged();
  }

  public static void asyncListPoliciesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PoliciesClient policiesClient = PoliciesClient.create()) {
      ListPoliciesRequest request =
          ListPoliciesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListPoliciesResponse response = policiesClient.listPoliciesCallable().call(request);
        for (Policy element : response.getPoliciesList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END iam_v2_generated_Policies_ListPolicies_Paged_async]
