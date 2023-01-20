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

package com.google.cloud.apigeeconnect.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.apigeeconnect.v1.stub.TetherStub;
import com.google.cloud.apigeeconnect.v1.stub.TetherStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Tether provides a way for the control plane to send HTTP API requests to
 * services in data planes that runs in a remote datacenter without requiring customers to open
 * firewalls on their runtime plane.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 *
 * <p>Note: close() needs to be called on the TetherClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TetherSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TetherSettings tetherSettings =
 *     TetherSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TetherClient tetherClient = TetherClient.create(tetherSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TetherSettings tetherSettings = TetherSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TetherClient tetherClient = TetherClient.create(tetherSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TetherSettings tetherSettings = TetherSettings.newHttpJsonBuilder().build();
 * TetherClient tetherClient = TetherClient.create(tetherSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TetherClient implements BackgroundResource {
  private final TetherSettings settings;
  private final TetherStub stub;

  /** Constructs an instance of TetherClient with default settings. */
  public static final TetherClient create() throws IOException {
    return create(TetherSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TetherClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TetherClient create(TetherSettings settings) throws IOException {
    return new TetherClient(settings);
  }

  /**
   * Constructs an instance of TetherClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TetherSettings).
   */
  public static final TetherClient create(TetherStub stub) {
    return new TetherClient(stub);
  }

  /**
   * Constructs an instance of TetherClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TetherClient(TetherSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TetherStubSettings) settings.getStubSettings()).createStub();
  }

  protected TetherClient(TetherStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TetherSettings getSettings() {
    return settings;
  }

  public TetherStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Egress streams egress requests and responses. Logically, this is not actually a streaming
   * request, but uses streaming as a mechanism to flip the client-server relationship of gRPC so
   * that the server can act as a client. The listener, the RPC server, accepts connections from the
   * dialer, the RPC client. The listener streams http requests and the dialer streams http
   * responses.
   *
   * <p>Sample code:
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
  public final BidiStreamingCallable<EgressResponse, EgressRequest> egressCallable() {
    return stub.egressCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
