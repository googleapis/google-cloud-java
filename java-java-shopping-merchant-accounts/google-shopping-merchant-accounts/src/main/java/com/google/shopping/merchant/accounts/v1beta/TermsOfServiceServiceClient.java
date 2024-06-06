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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.stub.TermsOfServiceServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.TermsOfServiceServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support `TermsOfService` API.
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
 * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
 *     TermsOfServiceServiceClient.create()) {
 *   TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
 *   TermsOfService response = termsOfServiceServiceClient.getTermsOfService(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TermsOfServiceServiceClient object to clean up
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
 *      <td><p> GetTermsOfService</td>
 *      <td><p> Retrieves the `TermsOfService` associated with the provided version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTermsOfService(GetTermsOfServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTermsOfService(TermsOfServiceName name)
 *           <li><p> getTermsOfService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTermsOfServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveLatestTermsOfService</td>
 *      <td><p> Retrieves the latest version of the `TermsOfService` for a given `kind` and `region_code`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveLatestTermsOfService(RetrieveLatestTermsOfServiceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveLatestTermsOfServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AcceptTermsOfService</td>
 *      <td><p> Accepts a `TermsOfService`. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acceptTermsOfService(AcceptTermsOfServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> acceptTermsOfService(TermsOfServiceName name)
 *           <li><p> acceptTermsOfService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acceptTermsOfServiceCallable()
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
 * <p>This class can be customized by passing in a custom instance of TermsOfServiceServiceSettings
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
 * TermsOfServiceServiceSettings termsOfServiceServiceSettings =
 *     TermsOfServiceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TermsOfServiceServiceClient termsOfServiceServiceClient =
 *     TermsOfServiceServiceClient.create(termsOfServiceServiceSettings);
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
 * TermsOfServiceServiceSettings termsOfServiceServiceSettings =
 *     TermsOfServiceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TermsOfServiceServiceClient termsOfServiceServiceClient =
 *     TermsOfServiceServiceClient.create(termsOfServiceServiceSettings);
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
 * TermsOfServiceServiceSettings termsOfServiceServiceSettings =
 *     TermsOfServiceServiceSettings.newHttpJsonBuilder().build();
 * TermsOfServiceServiceClient termsOfServiceServiceClient =
 *     TermsOfServiceServiceClient.create(termsOfServiceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TermsOfServiceServiceClient implements BackgroundResource {
  private final TermsOfServiceServiceSettings settings;
  private final TermsOfServiceServiceStub stub;

  /** Constructs an instance of TermsOfServiceServiceClient with default settings. */
  public static final TermsOfServiceServiceClient create() throws IOException {
    return create(TermsOfServiceServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TermsOfServiceServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TermsOfServiceServiceClient create(TermsOfServiceServiceSettings settings)
      throws IOException {
    return new TermsOfServiceServiceClient(settings);
  }

  /**
   * Constructs an instance of TermsOfServiceServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(TermsOfServiceServiceSettings).
   */
  public static final TermsOfServiceServiceClient create(TermsOfServiceServiceStub stub) {
    return new TermsOfServiceServiceClient(stub);
  }

  /**
   * Constructs an instance of TermsOfServiceServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TermsOfServiceServiceClient(TermsOfServiceServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TermsOfServiceServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TermsOfServiceServiceClient(TermsOfServiceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TermsOfServiceServiceSettings getSettings() {
    return settings;
  }

  public TermsOfServiceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the `TermsOfService` associated with the provided version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
   *   TermsOfService response = termsOfServiceServiceClient.getTermsOfService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `termsOfService/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfService getTermsOfService(TermsOfServiceName name) {
    GetTermsOfServiceRequest request =
        GetTermsOfServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTermsOfService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the `TermsOfService` associated with the provided version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   String name = TermsOfServiceName.of("[VERSION]").toString();
   *   TermsOfService response = termsOfServiceServiceClient.getTermsOfService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `termsOfService/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfService getTermsOfService(String name) {
    GetTermsOfServiceRequest request = GetTermsOfServiceRequest.newBuilder().setName(name).build();
    return getTermsOfService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the `TermsOfService` associated with the provided version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   GetTermsOfServiceRequest request =
   *       GetTermsOfServiceRequest.newBuilder()
   *           .setName(TermsOfServiceName.of("[VERSION]").toString())
   *           .build();
   *   TermsOfService response = termsOfServiceServiceClient.getTermsOfService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfService getTermsOfService(GetTermsOfServiceRequest request) {
    return getTermsOfServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the `TermsOfService` associated with the provided version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   GetTermsOfServiceRequest request =
   *       GetTermsOfServiceRequest.newBuilder()
   *           .setName(TermsOfServiceName.of("[VERSION]").toString())
   *           .build();
   *   ApiFuture<TermsOfService> future =
   *       termsOfServiceServiceClient.getTermsOfServiceCallable().futureCall(request);
   *   // Do something.
   *   TermsOfService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable() {
    return stub.getTermsOfServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the latest version of the `TermsOfService` for a given `kind` and `region_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   RetrieveLatestTermsOfServiceRequest request =
   *       RetrieveLatestTermsOfServiceRequest.newBuilder()
   *           .setRegionCode("regionCode-1991004415")
   *           .setKind(TermsOfServiceKind.forNumber(0))
   *           .build();
   *   TermsOfService response = termsOfServiceServiceClient.retrieveLatestTermsOfService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfService retrieveLatestTermsOfService(
      RetrieveLatestTermsOfServiceRequest request) {
    return retrieveLatestTermsOfServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the latest version of the `TermsOfService` for a given `kind` and `region_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   RetrieveLatestTermsOfServiceRequest request =
   *       RetrieveLatestTermsOfServiceRequest.newBuilder()
   *           .setRegionCode("regionCode-1991004415")
   *           .setKind(TermsOfServiceKind.forNumber(0))
   *           .build();
   *   ApiFuture<TermsOfService> future =
   *       termsOfServiceServiceClient.retrieveLatestTermsOfServiceCallable().futureCall(request);
   *   // Do something.
   *   TermsOfService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable() {
    return stub.retrieveLatestTermsOfServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a `TermsOfService`. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
   *   termsOfServiceServiceClient.acceptTermsOfService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `termsOfService/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acceptTermsOfService(TermsOfServiceName name) {
    AcceptTermsOfServiceRequest request =
        AcceptTermsOfServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    acceptTermsOfService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a `TermsOfService`. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   String name = TermsOfServiceName.of("[VERSION]").toString();
   *   termsOfServiceServiceClient.acceptTermsOfService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `termsOfService/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acceptTermsOfService(String name) {
    AcceptTermsOfServiceRequest request =
        AcceptTermsOfServiceRequest.newBuilder().setName(name).build();
    acceptTermsOfService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a `TermsOfService`. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   AcceptTermsOfServiceRequest request =
   *       AcceptTermsOfServiceRequest.newBuilder()
   *           .setName(TermsOfServiceName.of("[VERSION]").toString())
   *           .setAccount(AccountName.of("[ACCOUNT]").toString())
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   termsOfServiceServiceClient.acceptTermsOfService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acceptTermsOfService(AcceptTermsOfServiceRequest request) {
    acceptTermsOfServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a `TermsOfService`. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
   *     TermsOfServiceServiceClient.create()) {
   *   AcceptTermsOfServiceRequest request =
   *       AcceptTermsOfServiceRequest.newBuilder()
   *           .setName(TermsOfServiceName.of("[VERSION]").toString())
   *           .setAccount(AccountName.of("[ACCOUNT]").toString())
   *           .setRegionCode("regionCode-1991004415")
   *           .build();
   *   ApiFuture<Empty> future =
   *       termsOfServiceServiceClient.acceptTermsOfServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AcceptTermsOfServiceRequest, Empty> acceptTermsOfServiceCallable() {
    return stub.acceptTermsOfServiceCallable();
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
