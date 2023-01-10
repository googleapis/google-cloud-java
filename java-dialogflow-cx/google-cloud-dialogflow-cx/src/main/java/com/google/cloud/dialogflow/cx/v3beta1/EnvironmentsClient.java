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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.stub.EnvironmentsStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.EnvironmentsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Environments][google.cloud.dialogflow.cx.v3beta1.Environment].
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
 * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
 *   EnvironmentName name =
 *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
 *   Environment response = environmentsClient.getEnvironment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EnvironmentsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of EnvironmentsSettings to
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
 * EnvironmentsSettings environmentsSettings =
 *     EnvironmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
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
 * EnvironmentsSettings environmentsSettings =
 *     EnvironmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
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
 * EnvironmentsSettings environmentsSettings = EnvironmentsSettings.newHttpJsonBuilder().build();
 * EnvironmentsClient environmentsClient = EnvironmentsClient.create(environmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EnvironmentsClient implements BackgroundResource {
  private final EnvironmentsSettings settings;
  private final EnvironmentsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EnvironmentsClient with default settings. */
  public static final EnvironmentsClient create() throws IOException {
    return create(EnvironmentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EnvironmentsClient create(EnvironmentsSettings settings) throws IOException {
    return new EnvironmentsClient(settings);
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EnvironmentsSettings).
   */
  public static final EnvironmentsClient create(EnvironmentsStub stub) {
    return new EnvironmentsClient(stub);
  }

  /**
   * Constructs an instance of EnvironmentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EnvironmentsClient(EnvironmentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EnvironmentsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EnvironmentsClient(EnvironmentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EnvironmentsSettings getSettings() {
    return settings;
  }

  public EnvironmentsStub getStub() {
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
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Environment element : environmentsClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3beta1.Agent] to list all
   *     environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(AgentName parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (Environment element : environmentsClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3beta1.Agent] to list all
   *     environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(String parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Environment element : environmentsClient.listEnvironments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Environment> future =
   *       environmentsClient.listEnvironmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Environment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all environments in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEnvironmentsResponse response =
   *         environmentsClient.listEnvironmentsCallable().call(request);
   *     for (Environment element : response.getEnvironmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   EnvironmentName name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   Environment response = environmentsClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(EnvironmentName name) {
    GetEnvironmentRequest request =
        GetEnvironmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   Environment response = environmentsClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   Environment response = environmentsClient.getEnvironment(request);
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
   * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Environment> future =
   *       environmentsClient.getEnvironmentCallable().futureCall(request);
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
   * Creates an [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Environment environment = Environment.newBuilder().build();
   *   Environment response = environmentsClient.createEnvironmentAsync(parent, environment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3beta1.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param environment Required. The environment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      AgentName parent, Environment environment) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEnvironment(environment)
            .build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Environment environment = Environment.newBuilder().build();
   *   Environment response = environmentsClient.createEnvironmentAsync(parent, environment).get();
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3beta1.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param environment Required. The environment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      String parent, Environment environment) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder().setParent(parent).setEnvironment(environment).build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   Environment response = environmentsClient.createEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> createEnvironmentAsync(
      CreateEnvironmentRequest request) {
    return createEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   OperationFuture<Environment, Struct> future =
   *       environmentsClient.createEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] in the specified
   * [Agent][google.cloud.dialogflow.cx.v3beta1.Agent].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.createEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   Environment environment = Environment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Environment response =
   *       environmentsClient.updateEnvironmentAsync(environment, updateMask).get();
   * }
   * }</pre>
   *
   * @param environment Required. The environment to update.
   * @param updateMask Required. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> updateEnvironmentAsync(
      Environment environment, FieldMask updateMask) {
    UpdateEnvironmentRequest request =
        UpdateEnvironmentRequest.newBuilder()
            .setEnvironment(environment)
            .setUpdateMask(updateMask)
            .build();
    return updateEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Environment response = environmentsClient.updateEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, Struct> updateEnvironmentAsync(
      UpdateEnvironmentRequest request) {
    return updateEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Environment, Struct> future =
   *       environmentsClient.updateEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationCallable() {
    return stub.updateEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: An empty [Struct
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
   * - `response`: [Environment][google.cloud.dialogflow.cx.v3beta1.Environment]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   UpdateEnvironmentRequest request =
   *       UpdateEnvironmentRequest.newBuilder()
   *           .setEnvironment(Environment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.updateEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return stub.updateEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   EnvironmentName name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   environmentsClient.deleteEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(EnvironmentName name) {
    DeleteEnvironmentRequest request =
        DeleteEnvironmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   environmentsClient.deleteEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [Environment][google.cloud.dialogflow.cx.v3beta1.Environment] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(String name) {
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();
    deleteEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   environmentsClient.deleteEnvironment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEnvironment(DeleteEnvironmentRequest request) {
    deleteEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = environmentsClient.deleteEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   EnvironmentName name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   for (Environment element : environmentsClient.lookupEnvironmentHistory(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the environment to look up the history for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(
      EnvironmentName name) {
    LookupEnvironmentHistoryRequest request =
        LookupEnvironmentHistoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return lookupEnvironmentHistory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String name =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   for (Environment element : environmentsClient.lookupEnvironmentHistory(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the environment to look up the history for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(String name) {
    LookupEnvironmentHistoryRequest request =
        LookupEnvironmentHistoryRequest.newBuilder().setName(name).build();
    return lookupEnvironmentHistory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LookupEnvironmentHistoryRequest request =
   *       LookupEnvironmentHistoryRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Environment element :
   *       environmentsClient.lookupEnvironmentHistory(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupEnvironmentHistoryPagedResponse lookupEnvironmentHistory(
      LookupEnvironmentHistoryRequest request) {
    return lookupEnvironmentHistoryPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LookupEnvironmentHistoryRequest request =
   *       LookupEnvironmentHistoryRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Environment> future =
   *       environmentsClient.lookupEnvironmentHistoryPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Environment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistoryPagedCallable() {
    return stub.lookupEnvironmentHistoryPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up the history of the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   LookupEnvironmentHistoryRequest request =
   *       LookupEnvironmentHistoryRequest.newBuilder()
   *           .setName(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     LookupEnvironmentHistoryResponse response =
   *         environmentsClient.lookupEnvironmentHistoryCallable().call(request);
   *     for (Environment element : response.getEnvironmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryCallable() {
    return stub.lookupEnvironmentHistoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a continuous test under the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestMetadata] -
   * `response`:
   * [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RunContinuousTestRequest request =
   *       RunContinuousTestRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   RunContinuousTestResponse response = environmentsClient.runContinuousTestAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunContinuousTestResponse, RunContinuousTestMetadata>
      runContinuousTestAsync(RunContinuousTestRequest request) {
    return runContinuousTestOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a continuous test under the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestMetadata] -
   * `response`:
   * [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RunContinuousTestRequest request =
   *       RunContinuousTestRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RunContinuousTestResponse, RunContinuousTestMetadata> future =
   *       environmentsClient.runContinuousTestOperationCallable().futureCall(request);
   *   // Do something.
   *   RunContinuousTestResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RunContinuousTestRequest, RunContinuousTestResponse, RunContinuousTestMetadata>
      runContinuousTestOperationCallable() {
    return stub.runContinuousTestOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a continuous test under the specified
   * [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestMetadata] -
   * `response`:
   * [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3beta1.RunContinuousTestResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   RunContinuousTestRequest request =
   *       RunContinuousTestRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       environmentsClient.runContinuousTestCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunContinuousTestRequest, Operation> runContinuousTestCallable() {
    return stub.runContinuousTestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of continuous test results for a given environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   EnvironmentName parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   for (ContinuousTestResult element :
   *       environmentsClient.listContinuousTestResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The environment to list results for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/ environments/&lt;Environment
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContinuousTestResultsPagedResponse listContinuousTestResults(
      EnvironmentName parent) {
    ListContinuousTestResultsRequest request =
        ListContinuousTestResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContinuousTestResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of continuous test results for a given environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   String parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   for (ContinuousTestResult element :
   *       environmentsClient.listContinuousTestResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The environment to list results for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/ environments/&lt;Environment
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContinuousTestResultsPagedResponse listContinuousTestResults(String parent) {
    ListContinuousTestResultsRequest request =
        ListContinuousTestResultsRequest.newBuilder().setParent(parent).build();
    return listContinuousTestResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of continuous test results for a given environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListContinuousTestResultsRequest request =
   *       ListContinuousTestResultsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ContinuousTestResult element :
   *       environmentsClient.listContinuousTestResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContinuousTestResultsPagedResponse listContinuousTestResults(
      ListContinuousTestResultsRequest request) {
    return listContinuousTestResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of continuous test results for a given environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListContinuousTestResultsRequest request =
   *       ListContinuousTestResultsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ContinuousTestResult> future =
   *       environmentsClient.listContinuousTestResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ContinuousTestResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListContinuousTestResultsRequest, ListContinuousTestResultsPagedResponse>
      listContinuousTestResultsPagedCallable() {
    return stub.listContinuousTestResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of continuous test results for a given environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListContinuousTestResultsRequest request =
   *       ListContinuousTestResultsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListContinuousTestResultsResponse response =
   *         environmentsClient.listContinuousTestResultsCallable().call(request);
   *     for (ContinuousTestResult element : response.getContinuousTestResultsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsCallable() {
    return stub.listContinuousTestResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3beta1.DeployFlowMetadata] -
   * `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3beta1.DeployFlowResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeployFlowRequest request =
   *       DeployFlowRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setFlowVersion(
   *               VersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   DeployFlowResponse response = environmentsClient.deployFlowAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployFlowResponse, DeployFlowMetadata> deployFlowAsync(
      DeployFlowRequest request) {
    return deployFlowOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3beta1.DeployFlowMetadata] -
   * `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3beta1.DeployFlowResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeployFlowRequest request =
   *       DeployFlowRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setFlowVersion(
   *               VersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<DeployFlowResponse, DeployFlowMetadata> future =
   *       environmentsClient.deployFlowOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployFlowResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeployFlowRequest, DeployFlowResponse, DeployFlowMetadata>
      deployFlowOperationCallable() {
    return stub.deployFlowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3beta1.Environment].
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3beta1.DeployFlowMetadata] -
   * `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3beta1.DeployFlowResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   DeployFlowRequest request =
   *       DeployFlowRequest.newBuilder()
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setFlowVersion(
   *               VersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = environmentsClient.deployFlowCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployFlowRequest, Operation> deployFlowCallable() {
    return stub.deployFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : environmentsClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       environmentsClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = environmentsClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = environmentsClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = environmentsClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListEnvironmentsPagedResponse
      extends AbstractPagedListResponse<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    public static ApiFuture<ListEnvironmentsPagedResponse> createAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      ApiFuture<ListEnvironmentsPage> futurePage =
          ListEnvironmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEnvironmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEnvironmentsPagedResponse(ListEnvironmentsPage page) {
      super(page, ListEnvironmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnvironmentsPage
      extends AbstractPage<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment, ListEnvironmentsPage> {

    private ListEnvironmentsPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      super(context, response);
    }

    private static ListEnvironmentsPage createEmptyPage() {
      return new ListEnvironmentsPage(null, null);
    }

    @Override
    protected ListEnvironmentsPage createPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      return new ListEnvironmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListEnvironmentsPage> createPageAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnvironmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    private ListEnvironmentsFixedSizeCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnvironmentsFixedSizeCollection createEmptyCollection() {
      return new ListEnvironmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnvironmentsFixedSizeCollection createCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      return new ListEnvironmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class LookupEnvironmentHistoryPagedResponse
      extends AbstractPagedListResponse<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage,
          LookupEnvironmentHistoryFixedSizeCollection> {

    public static ApiFuture<LookupEnvironmentHistoryPagedResponse> createAsync(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        ApiFuture<LookupEnvironmentHistoryResponse> futureResponse) {
      ApiFuture<LookupEnvironmentHistoryPage> futurePage =
          LookupEnvironmentHistoryPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new LookupEnvironmentHistoryPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private LookupEnvironmentHistoryPagedResponse(LookupEnvironmentHistoryPage page) {
      super(page, LookupEnvironmentHistoryFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class LookupEnvironmentHistoryPage
      extends AbstractPage<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage> {

    private LookupEnvironmentHistoryPage(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        LookupEnvironmentHistoryResponse response) {
      super(context, response);
    }

    private static LookupEnvironmentHistoryPage createEmptyPage() {
      return new LookupEnvironmentHistoryPage(null, null);
    }

    @Override
    protected LookupEnvironmentHistoryPage createPage(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        LookupEnvironmentHistoryResponse response) {
      return new LookupEnvironmentHistoryPage(context, response);
    }

    @Override
    public ApiFuture<LookupEnvironmentHistoryPage> createPageAsync(
        PageContext<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
            context,
        ApiFuture<LookupEnvironmentHistoryResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class LookupEnvironmentHistoryFixedSizeCollection
      extends AbstractFixedSizeCollection<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          Environment,
          LookupEnvironmentHistoryPage,
          LookupEnvironmentHistoryFixedSizeCollection> {

    private LookupEnvironmentHistoryFixedSizeCollection(
        List<LookupEnvironmentHistoryPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static LookupEnvironmentHistoryFixedSizeCollection createEmptyCollection() {
      return new LookupEnvironmentHistoryFixedSizeCollection(null, 0);
    }

    @Override
    protected LookupEnvironmentHistoryFixedSizeCollection createCollection(
        List<LookupEnvironmentHistoryPage> pages, int collectionSize) {
      return new LookupEnvironmentHistoryFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListContinuousTestResultsPagedResponse
      extends AbstractPagedListResponse<
          ListContinuousTestResultsRequest,
          ListContinuousTestResultsResponse,
          ContinuousTestResult,
          ListContinuousTestResultsPage,
          ListContinuousTestResultsFixedSizeCollection> {

    public static ApiFuture<ListContinuousTestResultsPagedResponse> createAsync(
        PageContext<
                ListContinuousTestResultsRequest,
                ListContinuousTestResultsResponse,
                ContinuousTestResult>
            context,
        ApiFuture<ListContinuousTestResultsResponse> futureResponse) {
      ApiFuture<ListContinuousTestResultsPage> futurePage =
          ListContinuousTestResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContinuousTestResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContinuousTestResultsPagedResponse(ListContinuousTestResultsPage page) {
      super(page, ListContinuousTestResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContinuousTestResultsPage
      extends AbstractPage<
          ListContinuousTestResultsRequest,
          ListContinuousTestResultsResponse,
          ContinuousTestResult,
          ListContinuousTestResultsPage> {

    private ListContinuousTestResultsPage(
        PageContext<
                ListContinuousTestResultsRequest,
                ListContinuousTestResultsResponse,
                ContinuousTestResult>
            context,
        ListContinuousTestResultsResponse response) {
      super(context, response);
    }

    private static ListContinuousTestResultsPage createEmptyPage() {
      return new ListContinuousTestResultsPage(null, null);
    }

    @Override
    protected ListContinuousTestResultsPage createPage(
        PageContext<
                ListContinuousTestResultsRequest,
                ListContinuousTestResultsResponse,
                ContinuousTestResult>
            context,
        ListContinuousTestResultsResponse response) {
      return new ListContinuousTestResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListContinuousTestResultsPage> createPageAsync(
        PageContext<
                ListContinuousTestResultsRequest,
                ListContinuousTestResultsResponse,
                ContinuousTestResult>
            context,
        ApiFuture<ListContinuousTestResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContinuousTestResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContinuousTestResultsRequest,
          ListContinuousTestResultsResponse,
          ContinuousTestResult,
          ListContinuousTestResultsPage,
          ListContinuousTestResultsFixedSizeCollection> {

    private ListContinuousTestResultsFixedSizeCollection(
        List<ListContinuousTestResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContinuousTestResultsFixedSizeCollection createEmptyCollection() {
      return new ListContinuousTestResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContinuousTestResultsFixedSizeCollection createCollection(
        List<ListContinuousTestResultsPage> pages, int collectionSize) {
      return new ListContinuousTestResultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
