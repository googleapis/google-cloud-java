/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_LicenseConfigService_RetractLicenseConfig_sync]
import com.google.cloud.discoveryengine.v1beta.BillingAccountLicenseConfigName;
import com.google.cloud.discoveryengine.v1beta.LicenseConfigName;
import com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse;

public class SyncRetractLicenseConfig {

  public static void main(String[] args) throws Exception {
    syncRetractLicenseConfig();
  }

  public static void syncRetractLicenseConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LicenseConfigServiceClient licenseConfigServiceClient =
        LicenseConfigServiceClient.create()) {
      RetractLicenseConfigRequest request =
          RetractLicenseConfigRequest.newBuilder()
              .setBillingAccountLicenseConfig(
                  BillingAccountLicenseConfigName.of(
                          "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
                      .toString())
              .setLicenseConfig(
                  LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
              .setFullRetract(true)
              .setLicenseCount(-1565113455)
              .build();
      RetractLicenseConfigResponse response =
          licenseConfigServiceClient.retractLicenseConfig(request);
    }
  }
}
// [END discoveryengine_v1beta_generated_LicenseConfigService_RetractLicenseConfig_sync]
