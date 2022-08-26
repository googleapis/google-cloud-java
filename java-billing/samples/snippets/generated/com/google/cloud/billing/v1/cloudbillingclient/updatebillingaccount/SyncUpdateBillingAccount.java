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

// [START billing_v1_generated_cloudbillingclient_updatebillingaccount_sync]
import com.google.cloud.billing.v1.BillingAccount;
import com.google.cloud.billing.v1.BillingAccountName;
import com.google.cloud.billing.v1.CloudBillingClient;
import com.google.cloud.billing.v1.UpdateBillingAccountRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateBillingAccount {

  public static void main(String[] args) throws Exception {
    syncUpdateBillingAccount();
  }

  public static void syncUpdateBillingAccount() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CloudBillingClient cloudBillingClient = CloudBillingClient.create()) {
      UpdateBillingAccountRequest request =
          UpdateBillingAccountRequest.newBuilder()
              .setName(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
              .setAccount(BillingAccount.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      BillingAccount response = cloudBillingClient.updateBillingAccount(request);
    }
  }
}
// [END billing_v1_generated_cloudbillingclient_updatebillingaccount_sync]
