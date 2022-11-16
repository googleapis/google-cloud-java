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

package com.google.cloud.securitycenter.v1.samples;

// [START securitycenter_v1_generated_SecurityCenter_SetFindingState_FindingnameFindingstateTimestamp_sync]
import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.FindingName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.protobuf.Timestamp;

public class SyncSetFindingStateFindingnameFindingstateTimestamp {

  public static void main(String[] args) throws Exception {
    syncSetFindingStateFindingnameFindingstateTimestamp();
  }

  public static void syncSetFindingStateFindingnameFindingstateTimestamp() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      FindingName name =
          FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
      Finding.State state = Finding.State.forNumber(0);
      Timestamp startTime = Timestamp.newBuilder().build();
      Finding response = securityCenterClient.setFindingState(name, state, startTime);
    }
  }
}
// [END securitycenter_v1_generated_SecurityCenter_SetFindingState_FindingnameFindingstateTimestamp_sync]
