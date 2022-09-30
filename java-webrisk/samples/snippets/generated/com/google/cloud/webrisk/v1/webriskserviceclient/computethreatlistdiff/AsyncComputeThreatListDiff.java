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

package com.google.cloud.webrisk.v1.samples;

// [START webrisk_v1_generated_webriskserviceclient_computethreatlistdiff_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.webrisk.v1.WebRiskServiceClient;
import com.google.protobuf.ByteString;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.ThreatType;

public class AsyncComputeThreatListDiff {

  public static void main(String[] args) throws Exception {
    asyncComputeThreatListDiff();
  }

  public static void asyncComputeThreatListDiff() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
      ComputeThreatListDiffRequest request =
          ComputeThreatListDiffRequest.newBuilder()
              .setThreatType(ThreatType.forNumber(0))
              .setVersionToken(ByteString.EMPTY)
              .setConstraints(ComputeThreatListDiffRequest.Constraints.newBuilder().build())
              .build();
      ApiFuture<ComputeThreatListDiffResponse> future =
          webRiskServiceClient.computeThreatListDiffCallable().futureCall(request);
      // Do something.
      ComputeThreatListDiffResponse response = future.get();
    }
  }
}
// [END webrisk_v1_generated_webriskserviceclient_computethreatlistdiff_async]
