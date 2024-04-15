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

package com.google.cloud.cloudcontrolspartner.v1.samples;

// [START cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_GetPartner_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient;
import com.google.cloud.cloudcontrolspartner.v1.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1.Partner;
import com.google.cloud.cloudcontrolspartner.v1.PartnerName;

public class AsyncGetPartner {

  public static void main(String[] args) throws Exception {
    asyncGetPartner();
  }

  public static void asyncGetPartner() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
        CloudControlsPartnerCoreClient.create()) {
      GetPartnerRequest request =
          GetPartnerRequest.newBuilder()
              .setName(PartnerName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .build();
      ApiFuture<Partner> future =
          cloudControlsPartnerCoreClient.getPartnerCallable().futureCall(request);
      // Do something.
      Partner response = future.get();
    }
  }
}
// [END cloudcontrolspartner_v1_generated_CloudControlsPartnerCore_GetPartner_async]
