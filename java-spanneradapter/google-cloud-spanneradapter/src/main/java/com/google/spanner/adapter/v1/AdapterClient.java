/*
 * Copyright 2025 Google LLC
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

package com.google.spanner.adapter.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.spanner.adapter.v1.stub.AdapterStub;
import com.google.spanner.adapter.v1.stub.AdapterStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Spanner Adapter API
 *
 * <p>The Cloud Spanner Adapter service allows native drivers of supported database dialects to
 * interact directly with Cloud Spanner by wrapping the underlying wire protocol used by the driver
 * in a gRPC stream.
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
 * try (AdapterClient adapterClient = AdapterClient.create()) {
 *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
 *   Session session = Session.newBuilder().build();
 *   Session response = adapterClient.createSession(parent, session);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdapterClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSession</td>
 *      <td><p> Creates a new session to be used for requests made by the adapter. A session identifies a specific incarnation of a database resource and is meant to be reused across many `AdaptMessage` calls.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSession(CreateSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSession(DatabaseName parent, Session session)
 *           <li><p> createSession(String parent, Session session)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AdaptMessage</td>
 *      <td><p> Handles a single message from the client and returns the result as a stream. The server will interpret the message frame and respond with message frames to the client.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> adaptMessageCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdapterSettings to create().
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
 * AdapterSettings adapterSettings =
 *     AdapterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdapterClient adapterClient = AdapterClient.create(adapterSettings);
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
 * AdapterSettings adapterSettings = AdapterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdapterClient adapterClient = AdapterClient.create(adapterSettings);
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
 * AdapterSettings adapterSettings = AdapterSettings.newHttpJsonBuilder().build();
 * AdapterClient adapterClient = AdapterClient.create(adapterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdapterClient implements BackgroundResource {
  private final AdapterSettings settings;
  private final AdapterStub stub;

  /** Constructs an instance of AdapterClient with default settings. */
  public static final AdapterClient create() throws IOException {
    return create(AdapterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdapterClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdapterClient create(AdapterSettings settings) throws IOException {
    return new AdapterClient(settings);
  }

  /**
   * Constructs an instance of AdapterClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AdapterSettings).
   */
  public static final AdapterClient create(AdapterStub stub) {
    return new AdapterClient(stub);
  }

  /**
   * Constructs an instance of AdapterClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AdapterClient(AdapterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdapterStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdapterClient(AdapterStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdapterSettings getSettings() {
    return settings;
  }

  public AdapterStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new session to be used for requests made by the adapter. A session identifies a
   * specific incarnation of a database resource and is meant to be reused across many
   * `AdaptMessage` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdapterClient adapterClient = AdapterClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Session session = Session.newBuilder().build();
   *   Session response = adapterClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. The database in which the new session is created.
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(DatabaseName parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSession(session)
            .build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new session to be used for requests made by the adapter. A session identifies a
   * specific incarnation of a database resource and is meant to be reused across many
   * `AdaptMessage` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdapterClient adapterClient = AdapterClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   Session session = Session.newBuilder().build();
   *   Session response = adapterClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. The database in which the new session is created.
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(String parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder().setParent(parent).setSession(session).build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new session to be used for requests made by the adapter. A session identifies a
   * specific incarnation of a database resource and is meant to be reused across many
   * `AdaptMessage` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdapterClient adapterClient = AdapterClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   Session response = adapterClient.createSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(CreateSessionRequest request) {
    return createSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new session to be used for requests made by the adapter. A session identifies a
   * specific incarnation of a database resource and is meant to be reused across many
   * `AdaptMessage` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdapterClient adapterClient = AdapterClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   ApiFuture<Session> future = adapterClient.createSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return stub.createSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Handles a single message from the client and returns the result as a stream. The server will
   * interpret the message frame and respond with message frames to the client.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdapterClient adapterClient = AdapterClient.create()) {
   *   AdaptMessageRequest request =
   *       AdaptMessageRequest.newBuilder()
   *           .setName(
   *               SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
   *           .setProtocol("protocol-989163880")
   *           .setPayload(ByteString.EMPTY)
   *           .putAllAttachments(new HashMap<String, String>())
   *           .build();
   *   ServerStream<AdaptMessageResponse> stream =
   *       adapterClient.adaptMessageCallable().call(request);
   *   for (AdaptMessageResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<AdaptMessageRequest, AdaptMessageResponse>
      adaptMessageCallable() {
    return stub.adaptMessageCallable();
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
