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

package com.google.cloud.apigeeconnect.v1.samples;

// [START apigeeconnect_v1_generated_Tether_Egress_async]
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.apigeeconnect.v1.EgressRequest;
import com.google.cloud.apigeeconnect.v1.EgressResponse;
import com.google.cloud.apigeeconnect.v1.HttpResponse;
import com.google.cloud.apigeeconnect.v1.TetherClient;
import com.google.cloud.apigeeconnect.v1.TetherEndpoint;
import com.google.rpc.Status;

public class AsyncEgress {

  public static void main(String[] args) throws Exception {
    asyncEgress();
  }

  public static void asyncEgress() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TetherClient tetherClient = TetherClient.create()) {
      BidiStream<EgressResponse, EgressRequest> bidiStream = tetherClient.egressCallable().call();
      EgressResponse request =
          EgressResponse.newBuilder()
              .setId("id3355")
              .setHttpResponse(HttpResponse.newBuilder().build())
              .setStatus(Status.newBuilder().build())
              .setProject("project-309310695")
              .setTraceId("traceId-1067401920")
              .setEndpoint(TetherEndpoint.forNumber(0))
              .setName("name3373707")
              .build();
      bidiStream.send(request);
      for (EgressRequest response : bidiStream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END apigeeconnect_v1_generated_Tether_Egress_async]
