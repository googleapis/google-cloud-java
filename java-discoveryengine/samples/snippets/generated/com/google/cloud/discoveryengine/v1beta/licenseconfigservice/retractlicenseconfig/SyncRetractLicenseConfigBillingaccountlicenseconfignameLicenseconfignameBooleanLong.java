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

// [START discoveryengine_v1beta_generated_LicenseConfigService_RetractLicenseConfig_BillingaccountlicenseconfignameLicenseconfignameBooleanLong_sync]
import com.google.cloud.discoveryengine.v1beta.BillingAccountLicenseConfigName;
import com.google.cloud.discoveryengine.v1beta.LicenseConfigName;
import com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse;

public class SyncRetractLicenseConfigBillingaccountlicenseconfignameLicenseconfignameBooleanLong {

  public static void main(String[] args) throws Exception {
    syncRetractLicenseConfigBillingaccountlicenseconfignameLicenseconfignameBooleanLong();
  }

  public static void
      syncRetractLicenseConfigBillingaccountlicenseconfignameLicenseconfignameBooleanLong()
          throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LicenseConfigServiceClient licenseConfigServiceClient =
        LicenseConfigServiceClient.create()) {
      BillingAccountLicenseConfigName billingAccountLicenseConfig =
          BillingAccountLicenseConfigName.of(
              "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
      LicenseConfigName licenseConfig =
          LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
      boolean fullRetract = true;
      long licenseCount = -1565113455;
      RetractLicenseConfigResponse response =
          licenseConfigServiceClient.retractLicenseConfig(
              billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
    }
  }
}
// [END discoveryengine_v1beta_generated_LicenseConfigService_RetractLicenseConfig_BillingaccountlicenseconfignameLicenseconfignameBooleanLong_sync]
