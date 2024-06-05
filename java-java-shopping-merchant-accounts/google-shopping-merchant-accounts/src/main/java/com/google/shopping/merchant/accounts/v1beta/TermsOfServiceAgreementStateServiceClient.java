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
import com.google.shopping.merchant.accounts.v1beta.stub.TermsOfServiceAgreementStateServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.TermsOfServiceAgreementStateServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support `TermsOfServiceAgreementState` API.
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
 * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
 *     TermsOfServiceAgreementStateServiceClient.create()) {
 *   TermsOfServiceAgreementStateName name =
 *       TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");
 *   TermsOfServiceAgreementState response =
 *       termsOfServiceAgreementStateServiceClient.getTermsOfServiceAgreementState(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TermsOfServiceAgreementStateServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetTermsOfServiceAgreementState</td>
 *      <td><p> Returns the state of a terms of service agreement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTermsOfServiceAgreementState(GetTermsOfServiceAgreementStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTermsOfServiceAgreementState(TermsOfServiceAgreementStateName name)
 *           <li><p> getTermsOfServiceAgreementState(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTermsOfServiceAgreementStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveForApplicationTermsOfServiceAgreementState</td>
 *      <td><p> Retrieves the state of the agreement for the application terms of service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveForApplicationTermsOfServiceAgreementState(RetrieveForApplicationTermsOfServiceAgreementStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> retrieveForApplicationTermsOfServiceAgreementState(AccountName parent)
 *           <li><p> retrieveForApplicationTermsOfServiceAgreementState(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveForApplicationTermsOfServiceAgreementStateCallable()
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
 * TermsOfServiceAgreementStateServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TermsOfServiceAgreementStateServiceSettings termsOfServiceAgreementStateServiceSettings =
 *     TermsOfServiceAgreementStateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
 *     TermsOfServiceAgreementStateServiceClient.create(
 *         termsOfServiceAgreementStateServiceSettings);
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
 * TermsOfServiceAgreementStateServiceSettings termsOfServiceAgreementStateServiceSettings =
 *     TermsOfServiceAgreementStateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
 *     TermsOfServiceAgreementStateServiceClient.create(
 *         termsOfServiceAgreementStateServiceSettings);
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
 * TermsOfServiceAgreementStateServiceSettings termsOfServiceAgreementStateServiceSettings =
 *     TermsOfServiceAgreementStateServiceSettings.newHttpJsonBuilder().build();
 * TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
 *     TermsOfServiceAgreementStateServiceClient.create(
 *         termsOfServiceAgreementStateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TermsOfServiceAgreementStateServiceClient implements BackgroundResource {
  private final TermsOfServiceAgreementStateServiceSettings settings;
  private final TermsOfServiceAgreementStateServiceStub stub;

  /** Constructs an instance of TermsOfServiceAgreementStateServiceClient with default settings. */
  public static final TermsOfServiceAgreementStateServiceClient create() throws IOException {
    return create(TermsOfServiceAgreementStateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TermsOfServiceAgreementStateServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final TermsOfServiceAgreementStateServiceClient create(
      TermsOfServiceAgreementStateServiceSettings settings) throws IOException {
    return new TermsOfServiceAgreementStateServiceClient(settings);
  }

  /**
   * Constructs an instance of TermsOfServiceAgreementStateServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(TermsOfServiceAgreementStateServiceSettings).
   */
  public static final TermsOfServiceAgreementStateServiceClient create(
      TermsOfServiceAgreementStateServiceStub stub) {
    return new TermsOfServiceAgreementStateServiceClient(stub);
  }

  /**
   * Constructs an instance of TermsOfServiceAgreementStateServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected TermsOfServiceAgreementStateServiceClient(
      TermsOfServiceAgreementStateServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((TermsOfServiceAgreementStateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TermsOfServiceAgreementStateServiceClient(
      TermsOfServiceAgreementStateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TermsOfServiceAgreementStateServiceSettings getSettings() {
    return settings;
  }

  public TermsOfServiceAgreementStateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the state of a terms of service agreement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   TermsOfServiceAgreementStateName name =
   *       TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient.getTermsOfServiceAgreementState(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `accounts/{account}/termsOfServiceAgreementState/{identifier}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState getTermsOfServiceAgreementState(
      TermsOfServiceAgreementStateName name) {
    GetTermsOfServiceAgreementStateRequest request =
        GetTermsOfServiceAgreementStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTermsOfServiceAgreementState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the state of a terms of service agreement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   String name = TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString();
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient.getTermsOfServiceAgreementState(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the terms of service version. Format:
   *     `accounts/{account}/termsOfServiceAgreementState/{identifier}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState getTermsOfServiceAgreementState(String name) {
    GetTermsOfServiceAgreementStateRequest request =
        GetTermsOfServiceAgreementStateRequest.newBuilder().setName(name).build();
    return getTermsOfServiceAgreementState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the state of a terms of service agreement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   GetTermsOfServiceAgreementStateRequest request =
   *       GetTermsOfServiceAgreementStateRequest.newBuilder()
   *           .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
   *           .build();
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient.getTermsOfServiceAgreementState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState getTermsOfServiceAgreementState(
      GetTermsOfServiceAgreementStateRequest request) {
    return getTermsOfServiceAgreementStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the state of a terms of service agreement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   GetTermsOfServiceAgreementStateRequest request =
   *       GetTermsOfServiceAgreementStateRequest.newBuilder()
   *           .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
   *           .build();
   *   ApiFuture<TermsOfServiceAgreementState> future =
   *       termsOfServiceAgreementStateServiceClient
   *           .getTermsOfServiceAgreementStateCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TermsOfServiceAgreementState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      getTermsOfServiceAgreementStateCallable() {
    return stub.getTermsOfServiceAgreementStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the state of the agreement for the application terms of service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient
   *           .retrieveForApplicationTermsOfServiceAgreementState(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The account for which to get a TermsOfServiceAgreementState Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState retrieveForApplicationTermsOfServiceAgreementState(
      AccountName parent) {
    RetrieveForApplicationTermsOfServiceAgreementStateRequest request =
        RetrieveForApplicationTermsOfServiceAgreementStateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return retrieveForApplicationTermsOfServiceAgreementState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the state of the agreement for the application terms of service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient
   *           .retrieveForApplicationTermsOfServiceAgreementState(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The account for which to get a TermsOfServiceAgreementState Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState retrieveForApplicationTermsOfServiceAgreementState(
      String parent) {
    RetrieveForApplicationTermsOfServiceAgreementStateRequest request =
        RetrieveForApplicationTermsOfServiceAgreementStateRequest.newBuilder()
            .setParent(parent)
            .build();
    return retrieveForApplicationTermsOfServiceAgreementState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the state of the agreement for the application terms of service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   RetrieveForApplicationTermsOfServiceAgreementStateRequest request =
   *       RetrieveForApplicationTermsOfServiceAgreementStateRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
   *   TermsOfServiceAgreementState response =
   *       termsOfServiceAgreementStateServiceClient
   *           .retrieveForApplicationTermsOfServiceAgreementState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TermsOfServiceAgreementState retrieveForApplicationTermsOfServiceAgreementState(
      RetrieveForApplicationTermsOfServiceAgreementStateRequest request) {
    return retrieveForApplicationTermsOfServiceAgreementStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the state of the agreement for the application terms of service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
   *     TermsOfServiceAgreementStateServiceClient.create()) {
   *   RetrieveForApplicationTermsOfServiceAgreementStateRequest request =
   *       RetrieveForApplicationTermsOfServiceAgreementStateRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<TermsOfServiceAgreementState> future =
   *       termsOfServiceAgreementStateServiceClient
   *           .retrieveForApplicationTermsOfServiceAgreementStateCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TermsOfServiceAgreementState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      retrieveForApplicationTermsOfServiceAgreementStateCallable() {
    return stub.retrieveForApplicationTermsOfServiceAgreementStateCallable();
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
