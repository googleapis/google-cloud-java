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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.discoveryengine.v1.stub.AssistantServiceStub;
import com.google.cloud.discoveryengine.v1.stub.AssistantServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Assistant configuration and assisting users.
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
 * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
 *   StreamAssistRequest request =
 *       StreamAssistRequest.newBuilder()
 *           .setName(
 *               AssistantName.of(
 *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
 *                   .toString())
 *           .setQuery(Query.newBuilder().build())
 *           .setSession(
 *               SessionName.ofProjectLocationDataStoreSessionName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
 *                   .toString())
 *           .setUserMetadata(AssistUserMetadata.newBuilder().build())
 *           .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
 *           .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
 *           .build();
 *   ServerStream<StreamAssistResponse> stream =
 *       assistantServiceClient.streamAssistCallable().call(request);
 *   for (StreamAssistResponse response : stream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AssistantServiceClient object to clean up resources
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
 *      <td><p> StreamAssist</td>
 *      <td><p> Assists the user with a query in a streaming fashion.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamAssistCallable()
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
 * <p>This class can be customized by passing in a custom instance of AssistantServiceSettings to
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
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
 * AssistantServiceSettings assistantServiceSettings =
 *     AssistantServiceSettings.newHttpJsonBuilder().build();
 * AssistantServiceClient assistantServiceClient =
 *     AssistantServiceClient.create(assistantServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AssistantServiceClient implements BackgroundResource {
  private final AssistantServiceSettings settings;
  private final AssistantServiceStub stub;

  /** Constructs an instance of AssistantServiceClient with default settings. */
  public static final AssistantServiceClient create() throws IOException {
    return create(AssistantServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssistantServiceClient create(AssistantServiceSettings settings)
      throws IOException {
    return new AssistantServiceClient(settings);
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AssistantServiceSettings).
   */
  public static final AssistantServiceClient create(AssistantServiceStub stub) {
    return new AssistantServiceClient(stub);
  }

  /**
   * Constructs an instance of AssistantServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AssistantServiceClient(AssistantServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssistantServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AssistantServiceClient(AssistantServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AssistantServiceSettings getSettings() {
    return settings;
  }

  public AssistantServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assists the user with a query in a streaming fashion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
   *   StreamAssistRequest request =
   *       StreamAssistRequest.newBuilder()
   *           .setName(
   *               AssistantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
   *                   .toString())
   *           .setQuery(Query.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setUserMetadata(AssistUserMetadata.newBuilder().build())
   *           .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
   *           .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
   *           .build();
   *   ServerStream<StreamAssistResponse> stream =
   *       assistantServiceClient.streamAssistCallable().call(request);
   *   for (StreamAssistResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse>
      streamAssistCallable() {
    return stub.streamAssistCallable();
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
