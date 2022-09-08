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

package com.google.cloud.shell.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.shell.v1.stub.CloudShellServiceStub;
import com.google.cloud.shell.v1.stub.CloudShellServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
 * least one environment, which has the ID "default". Environment consists of a Docker image
 * defining what is installed on the environment and a home directory containing the user's data
 * that will remain across sessions. Clients use this API to start and fetch information about their
 * environment, which can then be used to connect to that environment via a separate SSH client.
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
 * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
 *   EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");
 *   Environment response = cloudShellServiceClient.getEnvironment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudShellServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of CloudShellServiceSettings to
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
 * CloudShellServiceSettings cloudShellServiceSettings =
 *     CloudShellServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudShellServiceClient cloudShellServiceClient =
 *     CloudShellServiceClient.create(cloudShellServiceSettings);
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
 * CloudShellServiceSettings cloudShellServiceSettings =
 *     CloudShellServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudShellServiceClient cloudShellServiceClient =
 *     CloudShellServiceClient.create(cloudShellServiceSettings);
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
 * CloudShellServiceSettings cloudShellServiceSettings =
 *     CloudShellServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             CloudShellServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * CloudShellServiceClient cloudShellServiceClient =
 *     CloudShellServiceClient.create(cloudShellServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudShellServiceClient implements BackgroundResource {
  private final CloudShellServiceSettings settings;
  private final CloudShellServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudShellServiceClient with default settings. */
  public static final CloudShellServiceClient create() throws IOException {
    return create(CloudShellServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudShellServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudShellServiceClient create(CloudShellServiceSettings settings)
      throws IOException {
    return new CloudShellServiceClient(settings);
  }

  /**
   * Constructs an instance of CloudShellServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CloudShellServiceSettings).
   */
  public static final CloudShellServiceClient create(CloudShellServiceStub stub) {
    return new CloudShellServiceClient(stub);
  }

  /**
   * Constructs an instance of CloudShellServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudShellServiceClient(CloudShellServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudShellServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudShellServiceClient(CloudShellServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudShellServiceSettings getSettings() {
    return settings;
  }

  public CloudShellServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an environment. Returns NOT_FOUND if the environment does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");
   *   Environment response = cloudShellServiceClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource, for example
   *     `users/me/environments/default` or
   *     `users/someone{@literal @}example.com/environments/default`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(EnvironmentName name) {
    GetEnvironmentRequest request =
        GetEnvironmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an environment. Returns NOT_FOUND if the environment does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   String name = EnvironmentName.of("[USER]", "[ENVIRONMENT]").toString();
   *   Environment response = cloudShellServiceClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource, for example
   *     `users/me/environments/default` or
   *     `users/someone{@literal @}example.com/environments/default`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an environment. Returns NOT_FOUND if the environment does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(EnvironmentName.of("[USER]", "[ENVIRONMENT]").toString())
   *           .build();
   *   Environment response = cloudShellServiceClient.getEnvironment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an environment. Returns NOT_FOUND if the environment does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(EnvironmentName.of("[USER]", "[ENVIRONMENT]").toString())
   *           .build();
   *   ApiFuture<Environment> future =
   *       cloudShellServiceClient.getEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an existing environment, allowing clients to connect to it. The returned operation will
   * contain an instance of StartEnvironmentMetadata in its metadata field. Users can wait for the
   * environment to start by polling this operation via GetOperation. Once the environment has
   * finished starting and is ready to accept connections, the operation will contain a
   * StartEnvironmentResponse in its response field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   StartEnvironmentRequest request =
   *       StartEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .addAllPublicKeys(new ArrayList<String>())
   *           .build();
   *   StartEnvironmentResponse response =
   *       cloudShellServiceClient.startEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentAsync(StartEnvironmentRequest request) {
    return startEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an existing environment, allowing clients to connect to it. The returned operation will
   * contain an instance of StartEnvironmentMetadata in its metadata field. Users can wait for the
   * environment to start by polling this operation via GetOperation. Once the environment has
   * finished starting and is ready to accept connections, the operation will contain a
   * StartEnvironmentResponse in its response field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   StartEnvironmentRequest request =
   *       StartEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .addAllPublicKeys(new ArrayList<String>())
   *           .build();
   *   OperationFuture<StartEnvironmentResponse, StartEnvironmentMetadata> future =
   *       cloudShellServiceClient.startEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   StartEnvironmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable() {
    return stub.startEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an existing environment, allowing clients to connect to it. The returned operation will
   * contain an instance of StartEnvironmentMetadata in its metadata field. Users can wait for the
   * environment to start by polling this operation via GetOperation. Once the environment has
   * finished starting and is ready to accept connections, the operation will contain a
   * StartEnvironmentResponse in its response field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   StartEnvironmentRequest request =
   *       StartEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .addAllPublicKeys(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudShellServiceClient.startEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable() {
    return stub.startEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends OAuth credentials to a running environment on behalf of a user. When this completes, the
   * environment will be authorized to run various Google Cloud command line tools without requiring
   * the user to manually authenticate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AuthorizeEnvironmentRequest request =
   *       AuthorizeEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .setIdToken("idToken1642509726")
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   AuthorizeEnvironmentResponse response =
   *       cloudShellServiceClient.authorizeEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentAsync(AuthorizeEnvironmentRequest request) {
    return authorizeEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends OAuth credentials to a running environment on behalf of a user. When this completes, the
   * environment will be authorized to run various Google Cloud command line tools without requiring
   * the user to manually authenticate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AuthorizeEnvironmentRequest request =
   *       AuthorizeEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .setIdToken("idToken1642509726")
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata> future =
   *       cloudShellServiceClient.authorizeEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   AuthorizeEnvironmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable() {
    return stub.authorizeEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends OAuth credentials to a running environment on behalf of a user. When this completes, the
   * environment will be authorized to run various Google Cloud command line tools without requiring
   * the user to manually authenticate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AuthorizeEnvironmentRequest request =
   *       AuthorizeEnvironmentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setAccessToken("accessToken-1042689291")
   *           .setIdToken("idToken1642509726")
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudShellServiceClient.authorizeEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AuthorizeEnvironmentRequest, Operation>
      authorizeEnvironmentCallable() {
    return stub.authorizeEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a public SSH key to an environment, allowing clients with the corresponding private key to
   * connect to that environment via SSH. If a key with the same content already exists, this will
   * error with ALREADY_EXISTS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AddPublicKeyRequest request =
   *       AddPublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   AddPublicKeyResponse response = cloudShellServiceClient.addPublicKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddPublicKeyResponse, AddPublicKeyMetadata> addPublicKeyAsync(
      AddPublicKeyRequest request) {
    return addPublicKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a public SSH key to an environment, allowing clients with the corresponding private key to
   * connect to that environment via SSH. If a key with the same content already exists, this will
   * error with ALREADY_EXISTS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AddPublicKeyRequest request =
   *       AddPublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   OperationFuture<AddPublicKeyResponse, AddPublicKeyMetadata> future =
   *       cloudShellServiceClient.addPublicKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   AddPublicKeyResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable() {
    return stub.addPublicKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a public SSH key to an environment, allowing clients with the corresponding private key to
   * connect to that environment via SSH. If a key with the same content already exists, this will
   * error with ALREADY_EXISTS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   AddPublicKeyRequest request =
   *       AddPublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudShellServiceClient.addPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable() {
    return stub.addPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a public SSH key from an environment. Clients will no longer be able to connect to the
   * environment using the corresponding private key. If a key with the same content is not present,
   * this will error with NOT_FOUND.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   RemovePublicKeyRequest request =
   *       RemovePublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   RemovePublicKeyResponse response =
   *       cloudShellServiceClient.removePublicKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyAsync(RemovePublicKeyRequest request) {
    return removePublicKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a public SSH key from an environment. Clients will no longer be able to connect to the
   * environment using the corresponding private key. If a key with the same content is not present,
   * this will error with NOT_FOUND.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   RemovePublicKeyRequest request =
   *       RemovePublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   OperationFuture<RemovePublicKeyResponse, RemovePublicKeyMetadata> future =
   *       cloudShellServiceClient.removePublicKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   RemovePublicKeyResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable() {
    return stub.removePublicKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a public SSH key from an environment. Clients will no longer be able to connect to the
   * environment using the corresponding private key. If a key with the same content is not present,
   * this will error with NOT_FOUND.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
   *   RemovePublicKeyRequest request =
   *       RemovePublicKeyRequest.newBuilder()
   *           .setEnvironment("environment-85904877")
   *           .setKey("key106079")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudShellServiceClient.removePublicKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable() {
    return stub.removePublicKeyCallable();
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
