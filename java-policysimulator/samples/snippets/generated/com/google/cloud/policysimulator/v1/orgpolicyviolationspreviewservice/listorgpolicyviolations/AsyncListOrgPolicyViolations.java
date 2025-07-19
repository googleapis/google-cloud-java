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

package com.google.cloud.policysimulator.v1.samples;

// [START policysimulator_v1_generated_OrgPolicyViolationsPreviewService_ListOrgPolicyViolations_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest;
import com.google.cloud.policysimulator.v1.OrgPolicyViolation;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewName;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient;

public class AsyncListOrgPolicyViolations {

  public static void main(String[] args) throws Exception {
    asyncListOrgPolicyViolations();
  }

  public static void asyncListOrgPolicyViolations() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
        OrgPolicyViolationsPreviewServiceClient.create()) {
      ListOrgPolicyViolationsRequest request =
          ListOrgPolicyViolationsRequest.newBuilder()
              .setParent(
                  OrgPolicyViolationsPreviewName.of(
                          "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<OrgPolicyViolation> future =
          orgPolicyViolationsPreviewServiceClient
              .listOrgPolicyViolationsPagedCallable()
              .futureCall(request);
      // Do something.
      for (OrgPolicyViolation element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END policysimulator_v1_generated_OrgPolicyViolationsPreviewService_ListOrgPolicyViolations_async]
