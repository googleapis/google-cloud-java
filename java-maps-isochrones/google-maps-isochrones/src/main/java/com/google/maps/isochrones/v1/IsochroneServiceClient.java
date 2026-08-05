/*
 * Copyright 2026 Google LLC
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

package com.google.maps.isochrones.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.isochrones.v1.stub.IsochroneServiceStub;
import com.google.maps.isochrones.v1.stub.IsochroneServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for calculating isochrones. An isochrone is an area of reachability
 * from a given origin point within a specified travel time.
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
 * try (IsochroneServiceClient isochroneServiceClient = IsochroneServiceClient.create()) {
 *   GenerateIsochroneRequest request =
 *       GenerateIsochroneRequest.newBuilder()
 *           .setTravelDuration(Duration.newBuilder().build())
 *           .setEnableSmoothing(true)
 *           .build();
 *   GenerateIsochroneResponse response = isochroneServiceClient.generateIsochrone(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IsochroneServiceClient object to clean up resources
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
 *      <td><p> GenerateIsochrone</td>
 *      <td><p> Calculates and returns a single isochrone for a given set of parameters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateIsochrone(GenerateIsochroneRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateIsochroneCallable()
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
 * <p>This class can be customized by passing in a custom instance of IsochroneServiceSettings to
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
 * IsochroneServiceSettings isochroneServiceSettings =
 *     IsochroneServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IsochroneServiceClient isochroneServiceClient =
 *     IsochroneServiceClient.create(isochroneServiceSettings);
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
 * IsochroneServiceSettings isochroneServiceSettings =
 *     IsochroneServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IsochroneServiceClient isochroneServiceClient =
 *     IsochroneServiceClient.create(isochroneServiceSettings);
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
 * IsochroneServiceSettings isochroneServiceSettings =
 *     IsochroneServiceSettings.newHttpJsonBuilder().build();
 * IsochroneServiceClient isochroneServiceClient =
 *     IsochroneServiceClient.create(isochroneServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class IsochroneServiceClient implements BackgroundResource {
  private final @Nullable IsochroneServiceSettings settings;
  private final IsochroneServiceStub stub;

  /** Constructs an instance of IsochroneServiceClient with default settings. */
  public static final IsochroneServiceClient create() throws IOException {
    return create(IsochroneServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IsochroneServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IsochroneServiceClient create(IsochroneServiceSettings settings)
      throws IOException {
    return new IsochroneServiceClient(settings);
  }

  /**
   * Constructs an instance of IsochroneServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(IsochroneServiceSettings).
   */
  public static final IsochroneServiceClient create(IsochroneServiceStub stub) {
    return new IsochroneServiceClient(stub);
  }

  /**
   * Constructs an instance of IsochroneServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected IsochroneServiceClient(IsochroneServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IsochroneServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IsochroneServiceClient(IsochroneServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable IsochroneServiceSettings getSettings() {
    return settings;
  }

  public IsochroneServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates and returns a single isochrone for a given set of parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IsochroneServiceClient isochroneServiceClient = IsochroneServiceClient.create()) {
   *   GenerateIsochroneRequest request =
   *       GenerateIsochroneRequest.newBuilder()
   *           .setTravelDuration(Duration.newBuilder().build())
   *           .setEnableSmoothing(true)
   *           .build();
   *   GenerateIsochroneResponse response = isochroneServiceClient.generateIsochrone(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateIsochroneResponse generateIsochrone(GenerateIsochroneRequest request) {
    return generateIsochroneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates and returns a single isochrone for a given set of parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IsochroneServiceClient isochroneServiceClient = IsochroneServiceClient.create()) {
   *   GenerateIsochroneRequest request =
   *       GenerateIsochroneRequest.newBuilder()
   *           .setTravelDuration(Duration.newBuilder().build())
   *           .setEnableSmoothing(true)
   *           .build();
   *   ApiFuture<GenerateIsochroneResponse> future =
   *       isochroneServiceClient.generateIsochroneCallable().futureCall(request);
   *   // Do something.
   *   GenerateIsochroneResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneCallable() {
    return stub.generateIsochroneCallable();
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
