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

package com.google.cloud.certificatemanager.v1.samples;

// [START certificatemanager_v1_generated_certificatemanagersettings_getcertificate_sync]
import com.google.cloud.certificatemanager.v1.CertificateManagerSettings;
import java.time.Duration;

public class SyncGetCertificate {

  public static void main(String[] args) throws Exception {
    syncGetCertificate();
  }

  public static void syncGetCertificate() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    CertificateManagerSettings.Builder certificateManagerSettingsBuilder =
        CertificateManagerSettings.newBuilder();
    certificateManagerSettingsBuilder
        .getCertificateSettings()
        .setRetrySettings(
            certificateManagerSettingsBuilder
                .getCertificateSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    CertificateManagerSettings certificateManagerSettings =
        certificateManagerSettingsBuilder.build();
  }
}
// [END certificatemanager_v1_generated_certificatemanagersettings_getcertificate_sync]
