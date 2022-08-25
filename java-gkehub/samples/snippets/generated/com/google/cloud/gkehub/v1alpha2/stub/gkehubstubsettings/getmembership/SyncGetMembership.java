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

package com.google.cloud.gkehub.v1alpha2.stub.samples;

// [START gkehub_v1alpha2_generated_gkehubstubsettings_getmembership_sync]
import com.google.cloud.gkehub.v1alpha2.stub.GkeHubStubSettings;
import java.time.Duration;

public class SyncGetMembership {

  public static void main(String[] args) throws Exception {
    syncGetMembership();
  }

  public static void syncGetMembership() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    GkeHubStubSettings.Builder gkeHubSettingsBuilder = GkeHubStubSettings.newBuilder();
    gkeHubSettingsBuilder
        .getMembershipSettings()
        .setRetrySettings(
            gkeHubSettingsBuilder
                .getMembershipSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    GkeHubStubSettings gkeHubSettings = gkeHubSettingsBuilder.build();
  }
}
// [END gkehub_v1alpha2_generated_gkehubstubsettings_getmembership_sync]
