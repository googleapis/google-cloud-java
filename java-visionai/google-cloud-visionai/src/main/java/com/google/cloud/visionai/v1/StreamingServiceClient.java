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

package com.google.cloud.visionai.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.stub.StreamingServiceStub;
import com.google.cloud.visionai.v1.stub.StreamingServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Streaming service for receiving and sending packets.
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
 * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
 *   AcquireLeaseRequest request =
 *       AcquireLeaseRequest.newBuilder()
 *           .setSeries("series-905838985")
 *           .setOwner("owner106164915")
 *           .setTerm(Duration.newBuilder().build())
 *           .setLeaseType(LeaseType.forNumber(0))
 *           .build();
 *   Lease response = streamingServiceClient.acquireLease(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StreamingServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> SendPackets</td>
 *      <td><p> Send packets to the series.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> sendPacketsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReceivePackets</td>
 *      <td><p> Receive packets from the series.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> receivePacketsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReceiveEvents</td>
 *      <td><p> Receive events given the stream name.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> receiveEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AcquireLease</td>
 *      <td><p> AcquireLease acquires a lease.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acquireLease(AcquireLeaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acquireLeaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenewLease</td>
 *      <td><p> RenewLease renews a lease.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renewLease(RenewLeaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renewLeaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReleaseLease</td>
 *      <td><p> RleaseLease releases a lease.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> releaseLease(ReleaseLeaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> releaseLeaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of StreamingServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StreamingServiceSettings streamingServiceSettings =
 *     StreamingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StreamingServiceClient streamingServiceClient =
 *     StreamingServiceClient.create(streamingServiceSettings);
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
 * StreamingServiceSettings streamingServiceSettings =
 *     StreamingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StreamingServiceClient streamingServiceClient =
 *     StreamingServiceClient.create(streamingServiceSettings);
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
 * StreamingServiceSettings streamingServiceSettings =
 *     StreamingServiceSettings.newHttpJsonBuilder().build();
 * StreamingServiceClient streamingServiceClient =
 *     StreamingServiceClient.create(streamingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StreamingServiceClient implements BackgroundResource {
  private final StreamingServiceSettings settings;
  private final StreamingServiceStub stub;

  /** Constructs an instance of StreamingServiceClient with default settings. */
  public static final StreamingServiceClient create() throws IOException {
    return create(StreamingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StreamingServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StreamingServiceClient create(StreamingServiceSettings settings)
      throws IOException {
    return new StreamingServiceClient(settings);
  }

  /**
   * Constructs an instance of StreamingServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(StreamingServiceSettings).
   */
  public static final StreamingServiceClient create(StreamingServiceStub stub) {
    return new StreamingServiceClient(stub);
  }

  /**
   * Constructs an instance of StreamingServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected StreamingServiceClient(StreamingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((StreamingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected StreamingServiceClient(StreamingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final StreamingServiceSettings getSettings() {
    return settings;
  }

  public StreamingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send packets to the series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   BidiStream<SendPacketsRequest, SendPacketsResponse> bidiStream =
   *       streamingServiceClient.sendPacketsCallable().call();
   *   SendPacketsRequest request = SendPacketsRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (SendPacketsResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse>
      sendPacketsCallable() {
    return stub.sendPacketsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Receive packets from the series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   BidiStream<ReceivePacketsRequest, ReceivePacketsResponse> bidiStream =
   *       streamingServiceClient.receivePacketsCallable().call();
   *   ReceivePacketsRequest request = ReceivePacketsRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (ReceivePacketsResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsCallable() {
    return stub.receivePacketsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Receive events given the stream name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   BidiStream<ReceiveEventsRequest, ReceiveEventsResponse> bidiStream =
   *       streamingServiceClient.receiveEventsCallable().call();
   *   ReceiveEventsRequest request = ReceiveEventsRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (ReceiveEventsResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsCallable() {
    return stub.receiveEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * AcquireLease acquires a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   AcquireLeaseRequest request =
   *       AcquireLeaseRequest.newBuilder()
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .setTerm(Duration.newBuilder().build())
   *           .setLeaseType(LeaseType.forNumber(0))
   *           .build();
   *   Lease response = streamingServiceClient.acquireLease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lease acquireLease(AcquireLeaseRequest request) {
    return acquireLeaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * AcquireLease acquires a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   AcquireLeaseRequest request =
   *       AcquireLeaseRequest.newBuilder()
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .setTerm(Duration.newBuilder().build())
   *           .setLeaseType(LeaseType.forNumber(0))
   *           .build();
   *   ApiFuture<Lease> future = streamingServiceClient.acquireLeaseCallable().futureCall(request);
   *   // Do something.
   *   Lease response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable() {
    return stub.acquireLeaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenewLease renews a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   RenewLeaseRequest request =
   *       RenewLeaseRequest.newBuilder()
   *           .setId("id3355")
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .setTerm(Duration.newBuilder().build())
   *           .build();
   *   Lease response = streamingServiceClient.renewLease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lease renewLease(RenewLeaseRequest request) {
    return renewLeaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenewLease renews a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   RenewLeaseRequest request =
   *       RenewLeaseRequest.newBuilder()
   *           .setId("id3355")
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .setTerm(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<Lease> future = streamingServiceClient.renewLeaseCallable().futureCall(request);
   *   // Do something.
   *   Lease response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable() {
    return stub.renewLeaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RleaseLease releases a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   ReleaseLeaseRequest request =
   *       ReleaseLeaseRequest.newBuilder()
   *           .setId("id3355")
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .build();
   *   ReleaseLeaseResponse response = streamingServiceClient.releaseLease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReleaseLeaseResponse releaseLease(ReleaseLeaseRequest request) {
    return releaseLeaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RleaseLease releases a lease.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
   *   ReleaseLeaseRequest request =
   *       ReleaseLeaseRequest.newBuilder()
   *           .setId("id3355")
   *           .setSeries("series-905838985")
   *           .setOwner("owner106164915")
   *           .build();
   *   ApiFuture<ReleaseLeaseResponse> future =
   *       streamingServiceClient.releaseLeaseCallable().futureCall(request);
   *   // Do something.
   *   ReleaseLeaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable() {
    return stub.releaseLeaseCallable();
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
