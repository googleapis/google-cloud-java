/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_HostProjectRegistrationService_CreateHostProjectRegistration_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest;
import com.google.cloud.apihub.v1.HostProjectRegistration;
import com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient;
import com.google.cloud.apihub.v1.LocationName;

public class AsyncCreateHostProjectRegistration {

  public static void main(String[] args) throws Exception {
    asyncCreateHostProjectRegistration();
  }

  public static void asyncCreateHostProjectRegistration() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
        HostProjectRegistrationServiceClient.create()) {
      CreateHostProjectRegistrationRequest request =
          CreateHostProjectRegistrationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setHostProjectRegistrationId("hostProjectRegistrationId1352651365")
              .setHostProjectRegistration(HostProjectRegistration.newBuilder().build())
              .build();
      ApiFuture<HostProjectRegistration> future =
          hostProjectRegistrationServiceClient
              .createHostProjectRegistrationCallable()
              .futureCall(request);
      // Do something.
      HostProjectRegistration response = future.get();
    }
  }
}
// [END apihub_v1_generated_HostProjectRegistrationService_CreateHostProjectRegistration_async]
