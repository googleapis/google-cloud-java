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

package com.google.cloud.cloudcontrolspartner.v1beta.samples;

// [START cloudcontrolspartner_v1beta_generated_CloudControlsPartnerCore_GetPartner_sync]
import com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.Partner;
import com.google.cloud.cloudcontrolspartner.v1beta.PartnerName;

public class SyncGetPartner {

  public static void main(String[] args) throws Exception {
    syncGetPartner();
  }

  public static void syncGetPartner() throws Exception {
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
      Partner response = cloudControlsPartnerCoreClient.getPartner(request);
    }
  }
}
// [END cloudcontrolspartner_v1beta_generated_CloudControlsPartnerCore_GetPartner_sync]
