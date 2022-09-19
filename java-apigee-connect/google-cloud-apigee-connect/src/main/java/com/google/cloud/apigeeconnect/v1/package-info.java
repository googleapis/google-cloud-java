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

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ConnectionServiceClient =======================
 *
 * <p>Service Description: Service Interface for the Apigee Connect connection management APIs.
 *
 * <p>Sample for ConnectionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
 *   EndpointName parent = EndpointName.of("[PROJECT]", "[ENDPOINT]");
 *   for (Connection element : connectionServiceClient.listConnections(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= TetherClient =======================
 *
 * <p>Service Description: Tether provides a way for the control plane to send HTTP API requests to
 * services in data planes that runs in a remote datacenter without requiring customers to open
 * firewalls on their runtime plane.
 *
 * <p>Sample for TetherClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TetherClient tetherClient = TetherClient.create()) {
 *   BidiStream<EgressResponse, EgressRequest> bidiStream = tetherClient.egressCallable().call();
 *   EgressResponse request =
 *       EgressResponse.newBuilder()
 *           .setId("id3355")
 *           .setHttpResponse(HttpResponse.newBuilder().build())
 *           .setStatus(Status.newBuilder().build())
 *           .setProject("project-309310695")
 *           .setTraceId("traceId-1067401920")
 *           .setEndpoint(TetherEndpoint.forNumber(0))
 *           .setName("name3373707")
 *           .build();
 *   bidiStream.send(request);
 *   for (EgressRequest response : bidiStream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.apigeeconnect.v1;

import javax.annotation.Generated;
