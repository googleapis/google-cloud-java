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

package com.google.cloud.commerceproducer.v1beta.samples;

// [START commerceproducer_v1beta_generated_CommerceTransaction_CreatePrivateOffer_sync]
import com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.LocationName;
import com.google.cloud.commerceproducer.v1beta.PrivateOffer;

public class SyncCreatePrivateOffer {

  public static void main(String[] args) throws Exception {
    syncCreatePrivateOffer();
  }

  public static void syncCreatePrivateOffer() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
      CreatePrivateOfferRequest request =
          CreatePrivateOfferRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPrivateOffer(PrivateOffer.newBuilder().build())
              .build();
      PrivateOffer response = commerceTransactionClient.createPrivateOffer(request);
    }
  }
}
// [END commerceproducer_v1beta_generated_CommerceTransaction_CreatePrivateOffer_sync]
