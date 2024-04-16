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
import com.google.cloud.discoveryengine.v1beta.stub.GroundedGenerationServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.GroundedGenerationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for grounded generation.
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
 * try (GroundedGenerationServiceClient groundedGenerationServiceClient =
 *     GroundedGenerationServiceClient.create()) {
 *   CheckGroundingRequest request =
 *       CheckGroundingRequest.newBuilder()
 *           .setGroundingConfig(
 *               GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
 *                   .toString())
 *           .setAnswerCandidate("answerCandidate-292402331")
 *           .addAllFacts(new ArrayList<GroundingFact>())
 *           .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
 *           .build();
 *   CheckGroundingResponse response = groundedGenerationServiceClient.checkGrounding(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GroundedGenerationServiceClient object to clean up
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
 *      <td><p> CheckGrounding</td>
 *      <td><p> Performs a grounding check.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> checkGrounding(CheckGroundingRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> checkGroundingCallable()
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
 * GroundedGenerationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GroundedGenerationServiceSettings groundedGenerationServiceSettings =
 *     GroundedGenerationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GroundedGenerationServiceClient groundedGenerationServiceClient =
 *     GroundedGenerationServiceClient.create(groundedGenerationServiceSettings);
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
 * GroundedGenerationServiceSettings groundedGenerationServiceSettings =
 *     GroundedGenerationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GroundedGenerationServiceClient groundedGenerationServiceClient =
 *     GroundedGenerationServiceClient.create(groundedGenerationServiceSettings);
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
 * GroundedGenerationServiceSettings groundedGenerationServiceSettings =
 *     GroundedGenerationServiceSettings.newHttpJsonBuilder().build();
 * GroundedGenerationServiceClient groundedGenerationServiceClient =
 *     GroundedGenerationServiceClient.create(groundedGenerationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GroundedGenerationServiceClient implements BackgroundResource {
  private final GroundedGenerationServiceSettings settings;
  private final GroundedGenerationServiceStub stub;

  /** Constructs an instance of GroundedGenerationServiceClient with default settings. */
  public static final GroundedGenerationServiceClient create() throws IOException {
    return create(GroundedGenerationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GroundedGenerationServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GroundedGenerationServiceClient create(
      GroundedGenerationServiceSettings settings) throws IOException {
    return new GroundedGenerationServiceClient(settings);
  }

  /**
   * Constructs an instance of GroundedGenerationServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GroundedGenerationServiceSettings).
   */
  public static final GroundedGenerationServiceClient create(GroundedGenerationServiceStub stub) {
    return new GroundedGenerationServiceClient(stub);
  }

  /**
   * Constructs an instance of GroundedGenerationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GroundedGenerationServiceClient(GroundedGenerationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GroundedGenerationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GroundedGenerationServiceClient(GroundedGenerationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GroundedGenerationServiceSettings getSettings() {
    return settings;
  }

  public GroundedGenerationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a grounding check.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GroundedGenerationServiceClient groundedGenerationServiceClient =
   *     GroundedGenerationServiceClient.create()) {
   *   CheckGroundingRequest request =
   *       CheckGroundingRequest.newBuilder()
   *           .setGroundingConfig(
   *               GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
   *                   .toString())
   *           .setAnswerCandidate("answerCandidate-292402331")
   *           .addAllFacts(new ArrayList<GroundingFact>())
   *           .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
   *           .build();
   *   CheckGroundingResponse response = groundedGenerationServiceClient.checkGrounding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckGroundingResponse checkGrounding(CheckGroundingRequest request) {
    return checkGroundingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a grounding check.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GroundedGenerationServiceClient groundedGenerationServiceClient =
   *     GroundedGenerationServiceClient.create()) {
   *   CheckGroundingRequest request =
   *       CheckGroundingRequest.newBuilder()
   *           .setGroundingConfig(
   *               GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
   *                   .toString())
   *           .setAnswerCandidate("answerCandidate-292402331")
   *           .addAllFacts(new ArrayList<GroundingFact>())
   *           .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<CheckGroundingResponse> future =
   *       groundedGenerationServiceClient.checkGroundingCallable().futureCall(request);
   *   // Do something.
   *   CheckGroundingResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckGroundingRequest, CheckGroundingResponse>
      checkGroundingCallable() {
    return stub.checkGroundingCallable();
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
