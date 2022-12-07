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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.RecommendationServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.RecommendationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for making recommendations.
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
 * try (RecommendationServiceClient recommendationServiceClient =
 *     RecommendationServiceClient.create()) {
 *   RecommendRequest request =
 *       RecommendRequest.newBuilder()
 *           .setServingConfig(
 *               ServingConfigName.of(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
 *                   .toString())
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setFilter("filter-1274492040")
 *           .setValidateOnly(true)
 *           .putAllParams(new HashMap<String, Value>())
 *           .putAllUserLabels(new HashMap<String, String>())
 *           .build();
 *   RecommendResponse response = recommendationServiceClient.recommend(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RecommendationServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of RecommendationServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RecommendationServiceSettings recommendationServiceSettings =
 *     RecommendationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RecommendationServiceClient recommendationServiceClient =
 *     RecommendationServiceClient.create(recommendationServiceSettings);
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
 * RecommendationServiceSettings recommendationServiceSettings =
 *     RecommendationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RecommendationServiceClient recommendationServiceClient =
 *     RecommendationServiceClient.create(recommendationServiceSettings);
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
 * RecommendationServiceSettings recommendationServiceSettings =
 *     RecommendationServiceSettings.newHttpJsonBuilder().build();
 * RecommendationServiceClient recommendationServiceClient =
 *     RecommendationServiceClient.create(recommendationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RecommendationServiceClient implements BackgroundResource {
  private final RecommendationServiceSettings settings;
  private final RecommendationServiceStub stub;

  /** Constructs an instance of RecommendationServiceClient with default settings. */
  public static final RecommendationServiceClient create() throws IOException {
    return create(RecommendationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RecommendationServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RecommendationServiceClient create(RecommendationServiceSettings settings)
      throws IOException {
    return new RecommendationServiceClient(settings);
  }

  /**
   * Constructs an instance of RecommendationServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RecommendationServiceSettings).
   */
  public static final RecommendationServiceClient create(RecommendationServiceStub stub) {
    return new RecommendationServiceClient(stub);
  }

  /**
   * Constructs an instance of RecommendationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RecommendationServiceClient(RecommendationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RecommendationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RecommendationServiceClient(RecommendationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RecommendationServiceSettings getSettings() {
    return settings;
  }

  public RecommendationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation, which requires a contextual user event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecommendationServiceClient recommendationServiceClient =
   *     RecommendationServiceClient.create()) {
   *   RecommendRequest request =
   *       RecommendRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setUserEvent(UserEvent.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .setValidateOnly(true)
   *           .putAllParams(new HashMap<String, Value>())
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .build();
   *   RecommendResponse response = recommendationServiceClient.recommend(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecommendResponse recommend(RecommendRequest request) {
    return recommendCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes a recommendation, which requires a contextual user event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecommendationServiceClient recommendationServiceClient =
   *     RecommendationServiceClient.create()) {
   *   RecommendRequest request =
   *       RecommendRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setUserEvent(UserEvent.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .setValidateOnly(true)
   *           .putAllParams(new HashMap<String, Value>())
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<RecommendResponse> future =
   *       recommendationServiceClient.recommendCallable().futureCall(request);
   *   // Do something.
   *   RecommendResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecommendRequest, RecommendResponse> recommendCallable() {
    return stub.recommendCallable();
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
