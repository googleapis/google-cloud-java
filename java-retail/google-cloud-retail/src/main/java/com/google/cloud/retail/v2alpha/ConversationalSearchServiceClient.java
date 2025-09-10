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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.retail.v2alpha.stub.ConversationalSearchServiceStub;
import com.google.cloud.retail.v2alpha.stub.ConversationalSearchServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for retail conversational search.
 *
 * <p>This feature is only available for users who have Retail Conversational Search enabled. Enable
 * Retail Conversational Search on Cloud Console before using this feature.
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
 * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create()) {
 *   ConversationalSearchRequest request =
 *       ConversationalSearchRequest.newBuilder()
 *           .setPlacement("placement1792938725")
 *           .setBranch(
 *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
 *           .setQuery("query107944136")
 *           .addAllPageCategories(new ArrayList<String>())
 *           .setConversationId("conversationId-1676095234")
 *           .setSearchParams(ConversationalSearchRequest.SearchParams.newBuilder().build())
 *           .setVisitorId("visitorId1880545833")
 *           .setUserInfo(UserInfo.newBuilder().build())
 *           .setConversationalFilteringSpec(
 *               ConversationalSearchRequest.ConversationalFilteringSpec.newBuilder().build())
 *           .putAllUserLabels(new HashMap<String, String>())
 *           .addAllSafetySettings(new ArrayList<SafetySetting>())
 *           .build();
 *   ServerStream<ConversationalSearchResponse> stream =
 *       conversationalSearchServiceClient.conversationalSearchCallable().call(request);
 *   for (ConversationalSearchResponse response : stream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationalSearchServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ConversationalSearch</td>
 *      <td><p> Performs a conversational search.
 * <p>  This feature is only available for users who have Conversational Search enabled.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> conversationalSearchCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * ConversationalSearchServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
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
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
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
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newHttpJsonBuilder().build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationalSearchServiceClient implements BackgroundResource {
  private final ConversationalSearchServiceSettings settings;
  private final ConversationalSearchServiceStub stub;

  /** Constructs an instance of ConversationalSearchServiceClient with default settings. */
  public static final ConversationalSearchServiceClient create() throws IOException {
    return create(ConversationalSearchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ConversationalSearchServiceClient create(
      ConversationalSearchServiceSettings settings) throws IOException {
    return new ConversationalSearchServiceClient(settings);
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ConversationalSearchServiceSettings).
   */
  public static final ConversationalSearchServiceClient create(
      ConversationalSearchServiceStub stub) {
    return new ConversationalSearchServiceClient(stub);
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConversationalSearchServiceClient(ConversationalSearchServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConversationalSearchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConversationalSearchServiceClient(ConversationalSearchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConversationalSearchServiceSettings getSettings() {
    return settings;
  }

  public ConversationalSearchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a conversational search.
   *
   * <p>This feature is only available for users who have Conversational Search enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConversationalSearchRequest request =
   *       ConversationalSearchRequest.newBuilder()
   *           .setPlacement("placement1792938725")
   *           .setBranch(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setQuery("query107944136")
   *           .addAllPageCategories(new ArrayList<String>())
   *           .setConversationId("conversationId-1676095234")
   *           .setSearchParams(ConversationalSearchRequest.SearchParams.newBuilder().build())
   *           .setVisitorId("visitorId1880545833")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setConversationalFilteringSpec(
   *               ConversationalSearchRequest.ConversationalFilteringSpec.newBuilder().build())
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .addAllSafetySettings(new ArrayList<SafetySetting>())
   *           .build();
   *   ServerStream<ConversationalSearchResponse> stream =
   *       conversationalSearchServiceClient.conversationalSearchCallable().call(request);
   *   for (ConversationalSearchResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchCallable() {
    return stub.conversationalSearchCallable();
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
