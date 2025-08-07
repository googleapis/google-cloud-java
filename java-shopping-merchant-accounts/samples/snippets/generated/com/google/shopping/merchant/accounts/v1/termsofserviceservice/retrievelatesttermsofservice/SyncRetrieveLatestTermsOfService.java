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

package com.google.shopping.merchant.accounts.v1.samples;

// [START merchantapi_v1_generated_TermsOfServiceService_RetrieveLatestTermsOfService_sync]
import com.google.shopping.merchant.accounts.v1.RetrieveLatestTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.TermsOfService;
import com.google.shopping.merchant.accounts.v1.TermsOfServiceKind;
import com.google.shopping.merchant.accounts.v1.TermsOfServiceServiceClient;

public class SyncRetrieveLatestTermsOfService {

  public static void main(String[] args) throws Exception {
    syncRetrieveLatestTermsOfService();
  }

  public static void syncRetrieveLatestTermsOfService() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TermsOfServiceServiceClient termsOfServiceServiceClient =
        TermsOfServiceServiceClient.create()) {
      RetrieveLatestTermsOfServiceRequest request =
          RetrieveLatestTermsOfServiceRequest.newBuilder()
              .setRegionCode("regionCode-1991004415")
              .setKind(TermsOfServiceKind.forNumber(0))
              .build();
      TermsOfService response = termsOfServiceServiceClient.retrieveLatestTermsOfService(request);
    }
  }
}
// [END merchantapi_v1_generated_TermsOfServiceService_RetrieveLatestTermsOfService_sync]
