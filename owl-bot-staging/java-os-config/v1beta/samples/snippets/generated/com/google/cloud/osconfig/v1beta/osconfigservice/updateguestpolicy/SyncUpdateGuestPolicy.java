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

package com.google.cloud.osconfig.v1beta.samples;

// [START osconfig_v1beta_generated_OsConfigService_UpdateGuestPolicy_sync]
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.OsConfigServiceClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateGuestPolicy {

  public static void main(String[] args) throws Exception {
    syncUpdateGuestPolicy();
  }

  public static void syncUpdateGuestPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
      GuestPolicies.UpdateGuestPolicyRequest request =
          GuestPolicies.UpdateGuestPolicyRequest.newBuilder()
              .setGuestPolicy(GuestPolicies.GuestPolicy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      GuestPolicies.GuestPolicy response = osConfigServiceClient.updateGuestPolicy(request);
    }
  }
}
// [END osconfig_v1beta_generated_OsConfigService_UpdateGuestPolicy_sync]
