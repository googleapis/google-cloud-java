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

// [START policysimulator_v1_generated_OrgPolicyViolationsPreviewService_ListOrgPolicyViolations_String_sync]
import com.google.cloud.policysimulator.v1.OrgPolicyViolation;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewName;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient;

public class SyncListOrgPolicyViolationsString {

  public static void main(String[] args) throws Exception {
    syncListOrgPolicyViolationsString();
  }

  public static void syncListOrgPolicyViolationsString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
        OrgPolicyViolationsPreviewServiceClient.create()) {
      String parent =
          OrgPolicyViolationsPreviewName.of(
                  "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
              .toString();
      for (OrgPolicyViolation element :
          orgPolicyViolationsPreviewServiceClient.listOrgPolicyViolations(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END policysimulator_v1_generated_OrgPolicyViolationsPreviewService_ListOrgPolicyViolations_String_sync]
