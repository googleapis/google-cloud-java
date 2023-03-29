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

package com.google.cloud.webrisk.v1beta1.samples;

// [START webrisk_v1beta1_generated_WebRiskServiceV1Beta1_ComputeThreatListDiff_sync]
import com.google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1Client;
import com.google.protobuf.ByteString;
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.ThreatType;

public class SyncComputeThreatListDiff {

  public static void main(String[] args) throws Exception {
    syncComputeThreatListDiff();
  }

  public static void syncComputeThreatListDiff() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WebRiskServiceV1Beta1Client webRiskServiceV1Beta1Client =
        WebRiskServiceV1Beta1Client.create()) {
      ComputeThreatListDiffRequest request =
          ComputeThreatListDiffRequest.newBuilder()
              .setThreatType(ThreatType.forNumber(0))
              .setVersionToken(ByteString.EMPTY)
              .setConstraints(ComputeThreatListDiffRequest.Constraints.newBuilder().build())
              .build();
      ComputeThreatListDiffResponse response =
          webRiskServiceV1Beta1Client.computeThreatListDiff(request);
    }
  }
}
// [END webrisk_v1beta1_generated_WebRiskServiceV1Beta1_ComputeThreatListDiff_sync]
