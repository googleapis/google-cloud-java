/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.samples;

// [START cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_UpdateCustomer_CustomerFieldmask_sync]
import com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient;
import com.google.cloud.cloudcontrolspartner.v1.Customer;
import com.google.protobuf.FieldMask;

public class SyncUpdateCustomerCustomerFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateCustomerCustomerFieldmask();
  }

  public static void syncUpdateCustomerCustomerFieldmask() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
        CloudControlsPartnerCoreClient.create()) {
      Customer customer = Customer.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      Customer response = cloudControlsPartnerCoreClient.updateCustomer(customer, updateMask);
    }
  }
}
// [END cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_UpdateCustomer_CustomerFieldmask_sync]
