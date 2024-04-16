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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.RankServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.RankServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for ranking text records.
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
 * try (RankServiceClient rankServiceClient = RankServiceClient.create()) {
 *   RankRequest request =
 *       RankRequest.newBuilder()
 *           .setRankingConfig(
 *               RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
 *           .setModel("model104069929")
 *           .setTopN(110545924)
 *           .setQuery("query107944136")
 *           .addAllRecords(new ArrayList<RankingRecord>())
 *           .setIgnoreRecordDetailsInResponse(true)
 *           .build();
 *   RankResponse response = rankServiceClient.rank(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RankServiceClient object to clean up resources such as
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
 *      <td><p> Rank</td>
 *      <td><p> Ranks a list of text records based on the given input query.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rank(RankRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rankCallable()
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
 * <p>This class can be customized by passing in a custom instance of RankServiceSettings to
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
 * RankServiceSettings rankServiceSettings =
 *     RankServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RankServiceClient rankServiceClient = RankServiceClient.create(rankServiceSettings);
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
 * RankServiceSettings rankServiceSettings =
 *     RankServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RankServiceClient rankServiceClient = RankServiceClient.create(rankServiceSettings);
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
 * RankServiceSettings rankServiceSettings = RankServiceSettings.newHttpJsonBuilder().build();
 * RankServiceClient rankServiceClient = RankServiceClient.create(rankServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RankServiceClient implements BackgroundResource {
  private final RankServiceSettings settings;
  private final RankServiceStub stub;

  /** Constructs an instance of RankServiceClient with default settings. */
  public static final RankServiceClient create() throws IOException {
    return create(RankServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RankServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RankServiceClient create(RankServiceSettings settings) throws IOException {
    return new RankServiceClient(settings);
  }

  /**
   * Constructs an instance of RankServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RankServiceSettings).
   */
  public static final RankServiceClient create(RankServiceStub stub) {
    return new RankServiceClient(stub);
  }

  /**
   * Constructs an instance of RankServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RankServiceClient(RankServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RankServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RankServiceClient(RankServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RankServiceSettings getSettings() {
    return settings;
  }

  public RankServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ranks a list of text records based on the given input query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RankServiceClient rankServiceClient = RankServiceClient.create()) {
   *   RankRequest request =
   *       RankRequest.newBuilder()
   *           .setRankingConfig(
   *               RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
   *           .setModel("model104069929")
   *           .setTopN(110545924)
   *           .setQuery("query107944136")
   *           .addAllRecords(new ArrayList<RankingRecord>())
   *           .setIgnoreRecordDetailsInResponse(true)
   *           .build();
   *   RankResponse response = rankServiceClient.rank(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RankResponse rank(RankRequest request) {
    return rankCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ranks a list of text records based on the given input query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RankServiceClient rankServiceClient = RankServiceClient.create()) {
   *   RankRequest request =
   *       RankRequest.newBuilder()
   *           .setRankingConfig(
   *               RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
   *           .setModel("model104069929")
   *           .setTopN(110545924)
   *           .setQuery("query107944136")
   *           .addAllRecords(new ArrayList<RankingRecord>())
   *           .setIgnoreRecordDetailsInResponse(true)
   *           .build();
   *   ApiFuture<RankResponse> future = rankServiceClient.rankCallable().futureCall(request);
   *   // Do something.
   *   RankResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RankRequest, RankResponse> rankCallable() {
    return stub.rankCallable();
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
