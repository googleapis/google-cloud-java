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

package com.google.cloud.gsuiteaddons.v1.stub.samples;

// [START gsuiteaddons_v1_generated_gsuiteaddonsstubsettings_getauthorization_sync]
import com.google.cloud.gsuiteaddons.v1.stub.GSuiteAddOnsStubSettings;
import java.time.Duration;

public class SyncGetAuthorization {

  public static void main(String[] args) throws Exception {
    syncGetAuthorization();
  }

  public static void syncGetAuthorization() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    GSuiteAddOnsStubSettings.Builder gSuiteAddOnsSettingsBuilder =
        GSuiteAddOnsStubSettings.newBuilder();
    gSuiteAddOnsSettingsBuilder
        .getAuthorizationSettings()
        .setRetrySettings(
            gSuiteAddOnsSettingsBuilder
                .getAuthorizationSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    GSuiteAddOnsStubSettings gSuiteAddOnsSettings = gSuiteAddOnsSettingsBuilder.build();
  }
}
// [END gsuiteaddons_v1_generated_gsuiteaddonsstubsettings_getauthorization_sync]
