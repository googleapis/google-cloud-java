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

package com.google.protos.google.cloud.binaryauthorization.v1.samples;

// [START binaryauthorization_v1_generated_ValidationHelperV1_ValidateAttestationOccurrence_async]
import com.google.api.core.ApiFuture;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import com.google.protos.google.cloud.binaryauthorization.v1.ValidationHelperV1Client;
import io.grafeas.v1.AttestationOccurrence;

public class AsyncValidateAttestationOccurrence {

  public static void main(String[] args) throws Exception {
    asyncValidateAttestationOccurrence();
  }

  public static void asyncValidateAttestationOccurrence() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ValidationHelperV1Client validationHelperV1Client = ValidationHelperV1Client.create()) {
      Service.ValidateAttestationOccurrenceRequest request =
          Service.ValidateAttestationOccurrenceRequest.newBuilder()
              .setAttestor("attestor542920680")
              .setAttestation(AttestationOccurrence.newBuilder().build())
              .setOccurrenceNote("occurrenceNote1722072419")
              .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
              .build();
      ApiFuture<Service.ValidateAttestationOccurrenceResponse> future =
          validationHelperV1Client.validateAttestationOccurrenceCallable().futureCall(request);
      // Do something.
      Service.ValidateAttestationOccurrenceResponse response = future.get();
    }
  }
}
// [END binaryauthorization_v1_generated_ValidationHelperV1_ValidateAttestationOccurrence_async]
