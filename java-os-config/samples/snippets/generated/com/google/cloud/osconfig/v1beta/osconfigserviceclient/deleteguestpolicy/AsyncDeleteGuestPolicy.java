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

// [START osconfig_v1beta_generated_osconfigserviceclient_deleteguestpolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.GuestPolicyName;
import com.google.cloud.osconfig.v1beta.OsConfigServiceClient;
import com.google.protobuf.Empty;

public class AsyncDeleteGuestPolicy {

  public static void main(String[] args) throws Exception {
    asyncDeleteGuestPolicy();
  }

  public static void asyncDeleteGuestPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
      GuestPolicies.DeleteGuestPolicyRequest request =
          GuestPolicies.DeleteGuestPolicyRequest.newBuilder()
              .setName(GuestPolicyName.of("[PROJECT]", "[GUEST_POLICY]").toString())
              .build();
      ApiFuture<Empty> future =
          osConfigServiceClient.deleteGuestPolicyCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END osconfig_v1beta_generated_osconfigserviceclient_deleteguestpolicy_async]
