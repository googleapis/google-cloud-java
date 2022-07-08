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

// [START osconfig_v1beta_generated_osconfigserviceclient_listguestpolicies_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.OsConfigServiceClient;
import com.google.cloud.osconfig.v1beta.ProjectName;

public class AsyncListGuestPolicies {

  public static void main(String[] args) throws Exception {
    asyncListGuestPolicies();
  }

  public static void asyncListGuestPolicies() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
      GuestPolicies.ListGuestPoliciesRequest request =
          GuestPolicies.ListGuestPoliciesRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<GuestPolicies.GuestPolicy> future =
          osConfigServiceClient.listGuestPoliciesPagedCallable().futureCall(request);
      // Do something.
      for (GuestPolicies.GuestPolicy element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END osconfig_v1beta_generated_osconfigserviceclient_listguestpolicies_async]
