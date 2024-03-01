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

package com.google.cloud.confidentialcomputing.v1.samples;

// [START confidentialcomputing_v1_generated_ConfidentialComputing_VerifyAttestation_sync]
import com.google.cloud.confidentialcomputing.v1.ChallengeName;
import com.google.cloud.confidentialcomputing.v1.ConfidentialComputingClient;
import com.google.cloud.confidentialcomputing.v1.ConfidentialSpaceInfo;
import com.google.cloud.confidentialcomputing.v1.GcpCredentials;
import com.google.cloud.confidentialcomputing.v1.TokenOptions;
import com.google.cloud.confidentialcomputing.v1.TpmAttestation;
import com.google.cloud.confidentialcomputing.v1.VerifyAttestationRequest;
import com.google.cloud.confidentialcomputing.v1.VerifyAttestationResponse;

public class SyncVerifyAttestation {

  public static void main(String[] args) throws Exception {
    syncVerifyAttestation();
  }

  public static void syncVerifyAttestation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfidentialComputingClient confidentialComputingClient =
        ConfidentialComputingClient.create()) {
      VerifyAttestationRequest request =
          VerifyAttestationRequest.newBuilder()
              .setChallenge(ChallengeName.of("[PROJECT]", "[LOCATION]", "[UUID]").toString())
              .setGcpCredentials(GcpCredentials.newBuilder().build())
              .setTpmAttestation(TpmAttestation.newBuilder().build())
              .setConfidentialSpaceInfo(ConfidentialSpaceInfo.newBuilder().build())
              .setTokenOptions(TokenOptions.newBuilder().build())
              .build();
      VerifyAttestationResponse response = confidentialComputingClient.verifyAttestation(request);
    }
  }
}
// [END confidentialcomputing_v1_generated_ConfidentialComputing_VerifyAttestation_sync]
