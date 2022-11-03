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

// [START osconfig_v1beta_generated_OsConfigService_LookupEffectiveGuestPolicy_sync]
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.OsConfigServiceClient;

public class SyncLookupEffectiveGuestPolicy {

  public static void main(String[] args) throws Exception {
    syncLookupEffectiveGuestPolicy();
  }

  public static void syncLookupEffectiveGuestPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
      GuestPolicies.LookupEffectiveGuestPolicyRequest request =
          GuestPolicies.LookupEffectiveGuestPolicyRequest.newBuilder()
              .setInstance("instance555127957")
              .setOsShortName("osShortName1253394339")
              .setOsVersion("osVersion1812004436")
              .setOsArchitecture("osArchitecture1339954519")
              .build();
      GuestPolicies.EffectiveGuestPolicy response =
          osConfigServiceClient.lookupEffectiveGuestPolicy(request);
    }
  }
}
// [END osconfig_v1beta_generated_OsConfigService_LookupEffectiveGuestPolicy_sync]
