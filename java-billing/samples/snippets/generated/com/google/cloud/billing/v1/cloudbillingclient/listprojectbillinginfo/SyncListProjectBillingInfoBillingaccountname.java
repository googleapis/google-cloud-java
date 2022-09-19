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

package com.google.cloud.billing.v1.samples;

// [START billing_v1_generated_cloudbillingclient_listprojectbillinginfo_billingaccountname_sync]
import com.google.cloud.billing.v1.BillingAccountName;
import com.google.cloud.billing.v1.CloudBillingClient;
import com.google.cloud.billing.v1.ProjectBillingInfo;

public class SyncListProjectBillingInfoBillingaccountname {

  public static void main(String[] args) throws Exception {
    syncListProjectBillingInfoBillingaccountname();
  }

  public static void syncListProjectBillingInfoBillingaccountname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudBillingClient cloudBillingClient = CloudBillingClient.create()) {
      BillingAccountName name = BillingAccountName.of("[BILLING_ACCOUNT]");
      for (ProjectBillingInfo element :
          cloudBillingClient.listProjectBillingInfo(name).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END billing_v1_generated_cloudbillingclient_listprojectbillinginfo_billingaccountname_sync]
