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

package com.google.cloud.kms.v1.samples;

// [START kms_v1_generated_keymanagementservicesettings_getkeyring_sync]
import com.google.cloud.kms.v1.KeyManagementServiceSettings;
import java.time.Duration;

public class SyncGetKeyRing {

  public static void main(String[] args) throws Exception {
    syncGetKeyRing();
  }

  public static void syncGetKeyRing() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    KeyManagementServiceSettings.Builder keyManagementServiceSettingsBuilder =
        KeyManagementServiceSettings.newBuilder();
    keyManagementServiceSettingsBuilder
        .getKeyRingSettings()
        .setRetrySettings(
            keyManagementServiceSettingsBuilder
                .getKeyRingSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    KeyManagementServiceSettings keyManagementServiceSettings =
        keyManagementServiceSettingsBuilder.build();
  }
}
// [END kms_v1_generated_keymanagementservicesettings_getkeyring_sync]
