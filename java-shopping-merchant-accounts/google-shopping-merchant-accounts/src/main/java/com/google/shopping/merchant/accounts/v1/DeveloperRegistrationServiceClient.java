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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.DeveloperRegistrationServiceStub;
import com.google.shopping.merchant.accounts.v1.stub.DeveloperRegistrationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to access Developer Registration.
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
 * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
 *     DeveloperRegistrationServiceClient.create()) {
 *   RegisterGcpRequest request =
 *       RegisterGcpRequest.newBuilder()
 *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
 *           .setDeveloperEmail("developerEmail251249138")
 *           .build();
 *   DeveloperRegistration response = developerRegistrationServiceClient.registerGcp(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeveloperRegistrationServiceClient object to clean up
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
 *      <td><p> RegisterGcp</td>
 *      <td><p> Registers the GCP used for the API call to the shopping account passed in the request. Will create a user with an "API developer" and add the "developer_email" as a contact with "API notifications" email preference on.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> registerGcp(RegisterGcpRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> registerGcpCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeveloperRegistration</td>
 *      <td><p> Retrieves a developer registration for a merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeveloperRegistration(GetDeveloperRegistrationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeveloperRegistration(DeveloperRegistrationName name)
 *           <li><p> getDeveloperRegistration(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeveloperRegistrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UnregisterGcp</td>
 *      <td><p> Unregister the calling GCP from the calling shopping account. Note that the GCP will still be able to access the API for at most 1 day from the unregister succussful call.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> unregisterGcp(UnregisterGcpRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> unregisterGcpCallable()
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
 * DeveloperRegistrationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeveloperRegistrationServiceSettings developerRegistrationServiceSettings =
 *     DeveloperRegistrationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeveloperRegistrationServiceClient developerRegistrationServiceClient =
 *     DeveloperRegistrationServiceClient.create(developerRegistrationServiceSettings);
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
 * DeveloperRegistrationServiceSettings developerRegistrationServiceSettings =
 *     DeveloperRegistrationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeveloperRegistrationServiceClient developerRegistrationServiceClient =
 *     DeveloperRegistrationServiceClient.create(developerRegistrationServiceSettings);
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
 * DeveloperRegistrationServiceSettings developerRegistrationServiceSettings =
 *     DeveloperRegistrationServiceSettings.newHttpJsonBuilder().build();
 * DeveloperRegistrationServiceClient developerRegistrationServiceClient =
 *     DeveloperRegistrationServiceClient.create(developerRegistrationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeveloperRegistrationServiceClient implements BackgroundResource {
  private final DeveloperRegistrationServiceSettings settings;
  private final DeveloperRegistrationServiceStub stub;

  /** Constructs an instance of DeveloperRegistrationServiceClient with default settings. */
  public static final DeveloperRegistrationServiceClient create() throws IOException {
    return create(DeveloperRegistrationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeveloperRegistrationServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DeveloperRegistrationServiceClient create(
      DeveloperRegistrationServiceSettings settings) throws IOException {
    return new DeveloperRegistrationServiceClient(settings);
  }

  /**
   * Constructs an instance of DeveloperRegistrationServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DeveloperRegistrationServiceSettings).
   */
  public static final DeveloperRegistrationServiceClient create(
      DeveloperRegistrationServiceStub stub) {
    return new DeveloperRegistrationServiceClient(stub);
  }

  /**
   * Constructs an instance of DeveloperRegistrationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DeveloperRegistrationServiceClient(DeveloperRegistrationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((DeveloperRegistrationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeveloperRegistrationServiceClient(DeveloperRegistrationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeveloperRegistrationServiceSettings getSettings() {
    return settings;
  }

  public DeveloperRegistrationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the GCP used for the API call to the shopping account passed in the request. Will
   * create a user with an "API developer" and add the "developer_email" as a contact with "API
   * notifications" email preference on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   RegisterGcpRequest request =
   *       RegisterGcpRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .setDeveloperEmail("developerEmail251249138")
   *           .build();
   *   DeveloperRegistration response = developerRegistrationServiceClient.registerGcp(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeveloperRegistration registerGcp(RegisterGcpRequest request) {
    return registerGcpCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the GCP used for the API call to the shopping account passed in the request. Will
   * create a user with an "API developer" and add the "developer_email" as a contact with "API
   * notifications" email preference on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   RegisterGcpRequest request =
   *       RegisterGcpRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .setDeveloperEmail("developerEmail251249138")
   *           .build();
   *   ApiFuture<DeveloperRegistration> future =
   *       developerRegistrationServiceClient.registerGcpCallable().futureCall(request);
   *   // Do something.
   *   DeveloperRegistration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterGcpRequest, DeveloperRegistration> registerGcpCallable() {
    return stub.registerGcpCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a developer registration for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   DeveloperRegistrationName name = DeveloperRegistrationName.of("[ACCOUNT]");
   *   DeveloperRegistration response =
   *       developerRegistrationServiceClient.getDeveloperRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` (ID) of the developer registration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeveloperRegistration getDeveloperRegistration(DeveloperRegistrationName name) {
    GetDeveloperRegistrationRequest request =
        GetDeveloperRegistrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeveloperRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a developer registration for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   String name = DeveloperRegistrationName.of("[ACCOUNT]").toString();
   *   DeveloperRegistration response =
   *       developerRegistrationServiceClient.getDeveloperRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` (ID) of the developer registration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeveloperRegistration getDeveloperRegistration(String name) {
    GetDeveloperRegistrationRequest request =
        GetDeveloperRegistrationRequest.newBuilder().setName(name).build();
    return getDeveloperRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a developer registration for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   GetDeveloperRegistrationRequest request =
   *       GetDeveloperRegistrationRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .build();
   *   DeveloperRegistration response =
   *       developerRegistrationServiceClient.getDeveloperRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeveloperRegistration getDeveloperRegistration(
      GetDeveloperRegistrationRequest request) {
    return getDeveloperRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a developer registration for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   GetDeveloperRegistrationRequest request =
   *       GetDeveloperRegistrationRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<DeveloperRegistration> future =
   *       developerRegistrationServiceClient.getDeveloperRegistrationCallable().futureCall(request);
   *   // Do something.
   *   DeveloperRegistration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationCallable() {
    return stub.getDeveloperRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister the calling GCP from the calling shopping account. Note that the GCP will still be
   * able to access the API for at most 1 day from the unregister succussful call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   UnregisterGcpRequest request =
   *       UnregisterGcpRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .build();
   *   developerRegistrationServiceClient.unregisterGcp(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void unregisterGcp(UnregisterGcpRequest request) {
    unregisterGcpCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregister the calling GCP from the calling shopping account. Note that the GCP will still be
   * able to access the API for at most 1 day from the unregister succussful call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
   *     DeveloperRegistrationServiceClient.create()) {
   *   UnregisterGcpRequest request =
   *       UnregisterGcpRequest.newBuilder()
   *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       developerRegistrationServiceClient.unregisterGcpCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnregisterGcpRequest, Empty> unregisterGcpCallable() {
    return stub.unregisterGcpCallable();
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
