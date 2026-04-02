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

package com.google.cloud.cloudsecuritycompliance.v1.samples;

// [START cloudsecuritycompliance_v1_generated_CmEnrollmentService_CalculateEffectiveCmEnrollment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse;
import com.google.cloud.cloudsecuritycompliance.v1.CmEnrollmentName;
import com.google.cloud.cloudsecuritycompliance.v1.CmEnrollmentServiceClient;

public class AsyncCalculateEffectiveCmEnrollment {

  public static void main(String[] args) throws Exception {
    asyncCalculateEffectiveCmEnrollment();
  }

  public static void asyncCalculateEffectiveCmEnrollment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
      CalculateEffectiveCmEnrollmentRequest request =
          CalculateEffectiveCmEnrollmentRequest.newBuilder()
              .setName(
                  CmEnrollmentName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
                      .toString())
              .build();
      ApiFuture<CalculateEffectiveCmEnrollmentResponse> future =
          cmEnrollmentServiceClient.calculateEffectiveCmEnrollmentCallable().futureCall(request);
      // Do something.
      CalculateEffectiveCmEnrollmentResponse response = future.get();
    }
  }
}
// [END cloudsecuritycompliance_v1_generated_CmEnrollmentService_CalculateEffectiveCmEnrollment_async]
