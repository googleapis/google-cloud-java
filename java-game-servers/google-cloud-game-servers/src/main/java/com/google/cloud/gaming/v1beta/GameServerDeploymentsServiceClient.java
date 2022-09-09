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

package com.google.cloud.gaming.v1beta;

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
import com.google.cloud.gaming.v1beta.stub.GameServerDeploymentsServiceStub;
import com.google.cloud.gaming.v1beta.stub.GameServerDeploymentsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The game server deployment is used to control the deployment of Agones
 * fleets.
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
 * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create()) {
 *   GameServerDeploymentName name =
 *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
 *   GameServerDeployment response =
 *       gameServerDeploymentsServiceClient.getGameServerDeployment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GameServerDeploymentsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * GameServerDeploymentsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     GameServerDeploymentsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
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
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     GameServerDeploymentsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
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
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     GameServerDeploymentsServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             GameServerDeploymentsServiceSettings.defaultHttpJsonTransportProviderBuilder()
 *                 .build())
 *         .build();
 * GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerDeploymentsServiceClient implements BackgroundResource {
  private final GameServerDeploymentsServiceSettings settings;
  private final GameServerDeploymentsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GameServerDeploymentsServiceClient with default settings. */
  public static final GameServerDeploymentsServiceClient create() throws IOException {
    return create(GameServerDeploymentsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GameServerDeploymentsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GameServerDeploymentsServiceClient create(
      GameServerDeploymentsServiceSettings settings) throws IOException {
    return new GameServerDeploymentsServiceClient(settings);
  }

  /**
   * Constructs an instance of GameServerDeploymentsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GameServerDeploymentsServiceSettings).
   */
  public static final GameServerDeploymentsServiceClient create(
      GameServerDeploymentsServiceStub stub) {
    return new GameServerDeploymentsServiceClient(stub);
  }

  /**
   * Constructs an instance of GameServerDeploymentsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GameServerDeploymentsServiceClient(GameServerDeploymentsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((GameServerDeploymentsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GameServerDeploymentsServiceClient(GameServerDeploymentsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GameServerDeploymentsServiceSettings getSettings() {
    return settings;
  }

  public GameServerDeploymentsServiceStub getStub() {
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
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (GameServerDeployment element :
   *       gameServerDeploymentsServiceClient.listGameServerDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerDeploymentsPagedResponse listGameServerDeployments(
      LocationName parent) {
    ListGameServerDeploymentsRequest request =
        ListGameServerDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGameServerDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (GameServerDeployment element :
   *       gameServerDeploymentsServiceClient.listGameServerDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerDeploymentsPagedResponse listGameServerDeployments(String parent) {
    ListGameServerDeploymentsRequest request =
        ListGameServerDeploymentsRequest.newBuilder().setParent(parent).build();
    return listGameServerDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   ListGameServerDeploymentsRequest request =
   *       ListGameServerDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GameServerDeployment element :
   *       gameServerDeploymentsServiceClient.listGameServerDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerDeploymentsPagedResponse listGameServerDeployments(
      ListGameServerDeploymentsRequest request) {
    return listGameServerDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   ListGameServerDeploymentsRequest request =
   *       ListGameServerDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GameServerDeployment> future =
   *       gameServerDeploymentsServiceClient
   *           .listGameServerDeploymentsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (GameServerDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListGameServerDeploymentsRequest, ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsPagedCallable() {
    return stub.listGameServerDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   ListGameServerDeploymentsRequest request =
   *       ListGameServerDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGameServerDeploymentsResponse response =
   *         gameServerDeploymentsServiceClient.listGameServerDeploymentsCallable().call(request);
   *     for (GameServerDeployment element : response.getGameServerDeploymentsList()) {
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
  public final UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsCallable() {
    return stub.listGameServerDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeploymentName name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.getGameServerDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeployment getGameServerDeployment(GameServerDeploymentName name) {
    GetGameServerDeploymentRequest request =
        GetGameServerDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGameServerDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   String name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.getGameServerDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeployment getGameServerDeployment(String name) {
    GetGameServerDeploymentRequest request =
        GetGameServerDeploymentRequest.newBuilder().setName(name).build();
    return getGameServerDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GetGameServerDeploymentRequest request =
   *       GetGameServerDeploymentRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.getGameServerDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeployment getGameServerDeployment(
      GetGameServerDeploymentRequest request) {
    return getGameServerDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GetGameServerDeploymentRequest request =
   *       GetGameServerDeploymentRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<GameServerDeployment> future =
   *       gameServerDeploymentsServiceClient.getGameServerDeploymentCallable().futureCall(request);
   *   // Do something.
   *   GameServerDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentCallable() {
    return stub.getGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient
   *           .createGameServerDeploymentAsync(parent, gameServerDeployment)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @param gameServerDeployment Required. The game server delpoyment resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      createGameServerDeploymentAsync(
          LocationName parent, GameServerDeployment gameServerDeployment) {
    CreateGameServerDeploymentRequest request =
        CreateGameServerDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGameServerDeployment(gameServerDeployment)
            .build();
    return createGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient
   *           .createGameServerDeploymentAsync(parent, gameServerDeployment)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}`.
   * @param gameServerDeployment Required. The game server delpoyment resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      createGameServerDeploymentAsync(String parent, GameServerDeployment gameServerDeployment) {
    CreateGameServerDeploymentRequest request =
        CreateGameServerDeploymentRequest.newBuilder()
            .setParent(parent)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    return createGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   CreateGameServerDeploymentRequest request =
   *       CreateGameServerDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.createGameServerDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      createGameServerDeploymentAsync(CreateGameServerDeploymentRequest request) {
    return createGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   CreateGameServerDeploymentRequest request =
   *       CreateGameServerDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerDeployment, OperationMetadata> future =
   *       gameServerDeploymentsServiceClient
   *           .createGameServerDeploymentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationCallable() {
    return stub.createGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   CreateGameServerDeploymentRequest request =
   *       CreateGameServerDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerDeploymentsServiceClient
   *           .createGameServerDeploymentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable() {
    return stub.createGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeploymentName name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   gameServerDeploymentsServiceClient.deleteGameServerDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to delete. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerDeploymentAsync(
      GameServerDeploymentName name) {
    DeleteGameServerDeploymentRequest request =
        DeleteGameServerDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   String name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   gameServerDeploymentsServiceClient.deleteGameServerDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to delete. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerDeploymentAsync(
      String name) {
    DeleteGameServerDeploymentRequest request =
        DeleteGameServerDeploymentRequest.newBuilder().setName(name).build();
    return deleteGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   DeleteGameServerDeploymentRequest request =
   *       DeleteGameServerDeploymentRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   gameServerDeploymentsServiceClient.deleteGameServerDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerDeploymentAsync(
      DeleteGameServerDeploymentRequest request) {
    return deleteGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   DeleteGameServerDeploymentRequest request =
   *       DeleteGameServerDeploymentRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gameServerDeploymentsServiceClient
   *           .deleteGameServerDeploymentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationCallable() {
    return stub.deleteGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   DeleteGameServerDeploymentRequest request =
   *       DeleteGameServerDeploymentRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerDeploymentsServiceClient
   *           .deleteGameServerDeploymentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable() {
    return stub.deleteGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentAsync(gameServerDeployment, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param gameServerDeployment Required. The game server delpoyment to be updated. Only fields
   *     specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentAsync(
          GameServerDeployment gameServerDeployment, FieldMask updateMask) {
    UpdateGameServerDeploymentRequest request =
        UpdateGameServerDeploymentRequest.newBuilder()
            .setGameServerDeployment(gameServerDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRequest request =
   *       UpdateGameServerDeploymentRequest.newBuilder()
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.updateGameServerDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentAsync(UpdateGameServerDeploymentRequest request) {
    return updateGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRequest request =
   *       UpdateGameServerDeploymentRequest.newBuilder()
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerDeployment, OperationMetadata> future =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationCallable() {
    return stub.updateGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRequest request =
   *       UpdateGameServerDeploymentRequest.newBuilder()
   *           .setGameServerDeployment(GameServerDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable() {
    return stub.updateGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details a single game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeploymentName name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   GameServerDeploymentRollout response =
   *       gameServerDeploymentsServiceClient.getGameServerDeploymentRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeploymentRollout getGameServerDeploymentRollout(
      GameServerDeploymentName name) {
    GetGameServerDeploymentRolloutRequest request =
        GetGameServerDeploymentRolloutRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGameServerDeploymentRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details a single game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   String name =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   GameServerDeploymentRollout response =
   *       gameServerDeploymentsServiceClient.getGameServerDeploymentRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server delpoyment to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/rollout`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeploymentRollout getGameServerDeploymentRollout(String name) {
    GetGameServerDeploymentRolloutRequest request =
        GetGameServerDeploymentRolloutRequest.newBuilder().setName(name).build();
    return getGameServerDeploymentRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details a single game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GetGameServerDeploymentRolloutRequest request =
   *       GetGameServerDeploymentRolloutRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   GameServerDeploymentRollout response =
   *       gameServerDeploymentsServiceClient.getGameServerDeploymentRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeploymentRollout getGameServerDeploymentRollout(
      GetGameServerDeploymentRolloutRequest request) {
    return getGameServerDeploymentRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details a single game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GetGameServerDeploymentRolloutRequest request =
   *       GetGameServerDeploymentRolloutRequest.newBuilder()
   *           .setName(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<GameServerDeploymentRollout> future =
   *       gameServerDeploymentsServiceClient
   *           .getGameServerDeploymentRolloutCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerDeploymentRollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutCallable() {
    return stub.getGameServerDeploymentRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server deployment rollout. The method will not return an error if the
   * update does not affect any existing realms. For example - if the default_game_server_config is
   * changed but all existing realms use the override, that is valid. Similarly, if a non existing
   * realm is explicitly called out in game_server_config_overrides field, that will also not result
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentRolloutAsync(rollout, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param rollout Required. The game server delpoyment rollout to be updated. Only fields
   *     specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutAsync(
          GameServerDeploymentRollout rollout, FieldMask updateMask) {
    UpdateGameServerDeploymentRolloutRequest request =
        UpdateGameServerDeploymentRolloutRequest.newBuilder()
            .setRollout(rollout)
            .setUpdateMask(updateMask)
            .build();
    return updateGameServerDeploymentRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server deployment rollout. The method will not return an error if the
   * update does not affect any existing realms. For example - if the default_game_server_config is
   * changed but all existing realms use the override, that is valid. Similarly, if a non existing
   * realm is explicitly called out in game_server_config_overrides field, that will also not result
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRolloutRequest request =
   *       UpdateGameServerDeploymentRolloutRequest.newBuilder()
   *           .setRollout(GameServerDeploymentRollout.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GameServerDeployment response =
   *       gameServerDeploymentsServiceClient.updateGameServerDeploymentRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutAsync(UpdateGameServerDeploymentRolloutRequest request) {
    return updateGameServerDeploymentRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server deployment rollout. The method will not return an error if the
   * update does not affect any existing realms. For example - if the default_game_server_config is
   * changed but all existing realms use the override, that is valid. Similarly, if a non existing
   * realm is explicitly called out in game_server_config_overrides field, that will also not result
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRolloutRequest request =
   *       UpdateGameServerDeploymentRolloutRequest.newBuilder()
   *           .setRollout(GameServerDeploymentRollout.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerDeployment, OperationMetadata> future =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentRolloutOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationCallable() {
    return stub.updateGameServerDeploymentRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server deployment rollout. The method will not return an error if the
   * update does not affect any existing realms. For example - if the default_game_server_config is
   * changed but all existing realms use the override, that is valid. Similarly, if a non existing
   * realm is explicitly called out in game_server_config_overrides field, that will also not result
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   UpdateGameServerDeploymentRolloutRequest request =
   *       UpdateGameServerDeploymentRolloutRequest.newBuilder()
   *           .setRollout(GameServerDeploymentRollout.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerDeploymentsServiceClient
   *           .updateGameServerDeploymentRolloutCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutCallable() {
    return stub.updateGameServerDeploymentRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews the game server deployment rollout. This API does not mutate the rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   PreviewGameServerDeploymentRolloutRequest request =
   *       PreviewGameServerDeploymentRolloutRequest.newBuilder()
   *           .setRollout(GameServerDeploymentRollout.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   PreviewGameServerDeploymentRolloutResponse response =
   *       gameServerDeploymentsServiceClient.previewGameServerDeploymentRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewGameServerDeploymentRolloutResponse previewGameServerDeploymentRollout(
      PreviewGameServerDeploymentRolloutRequest request) {
    return previewGameServerDeploymentRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews the game server deployment rollout. This API does not mutate the rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   PreviewGameServerDeploymentRolloutRequest request =
   *       PreviewGameServerDeploymentRolloutRequest.newBuilder()
   *           .setRollout(GameServerDeploymentRollout.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<PreviewGameServerDeploymentRolloutResponse> future =
   *       gameServerDeploymentsServiceClient
   *           .previewGameServerDeploymentRolloutCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PreviewGameServerDeploymentRolloutResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutCallable() {
    return stub.previewGameServerDeploymentRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the current state of the game server deployment. Gathers all the
   * Agones fleets and Agones autoscalers, including fleets running an older version of the game
   * server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   FetchDeploymentStateRequest request =
   *       FetchDeploymentStateRequest.newBuilder().setName("name3373707").build();
   *   FetchDeploymentStateResponse response =
   *       gameServerDeploymentsServiceClient.fetchDeploymentState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchDeploymentStateResponse fetchDeploymentState(
      FetchDeploymentStateRequest request) {
    return fetchDeploymentStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves information about the current state of the game server deployment. Gathers all the
   * Agones fleets and Agones autoscalers, including fleets running an older version of the game
   * server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
   *     GameServerDeploymentsServiceClient.create()) {
   *   FetchDeploymentStateRequest request =
   *       FetchDeploymentStateRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<FetchDeploymentStateResponse> future =
   *       gameServerDeploymentsServiceClient.fetchDeploymentStateCallable().futureCall(request);
   *   // Do something.
   *   FetchDeploymentStateResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateCallable() {
    return stub.fetchDeploymentStateCallable();
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

  public static class ListGameServerDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          GameServerDeployment,
          ListGameServerDeploymentsPage,
          ListGameServerDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListGameServerDeploymentsPagedResponse> createAsync(
        PageContext<
                ListGameServerDeploymentsRequest,
                ListGameServerDeploymentsResponse,
                GameServerDeployment>
            context,
        ApiFuture<ListGameServerDeploymentsResponse> futureResponse) {
      ApiFuture<ListGameServerDeploymentsPage> futurePage =
          ListGameServerDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGameServerDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGameServerDeploymentsPagedResponse(ListGameServerDeploymentsPage page) {
      super(page, ListGameServerDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGameServerDeploymentsPage
      extends AbstractPage<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          GameServerDeployment,
          ListGameServerDeploymentsPage> {

    private ListGameServerDeploymentsPage(
        PageContext<
                ListGameServerDeploymentsRequest,
                ListGameServerDeploymentsResponse,
                GameServerDeployment>
            context,
        ListGameServerDeploymentsResponse response) {
      super(context, response);
    }

    private static ListGameServerDeploymentsPage createEmptyPage() {
      return new ListGameServerDeploymentsPage(null, null);
    }

    @Override
    protected ListGameServerDeploymentsPage createPage(
        PageContext<
                ListGameServerDeploymentsRequest,
                ListGameServerDeploymentsResponse,
                GameServerDeployment>
            context,
        ListGameServerDeploymentsResponse response) {
      return new ListGameServerDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListGameServerDeploymentsPage> createPageAsync(
        PageContext<
                ListGameServerDeploymentsRequest,
                ListGameServerDeploymentsResponse,
                GameServerDeployment>
            context,
        ApiFuture<ListGameServerDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGameServerDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          GameServerDeployment,
          ListGameServerDeploymentsPage,
          ListGameServerDeploymentsFixedSizeCollection> {

    private ListGameServerDeploymentsFixedSizeCollection(
        List<ListGameServerDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGameServerDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListGameServerDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGameServerDeploymentsFixedSizeCollection createCollection(
        List<ListGameServerDeploymentsPage> pages, int collectionSize) {
      return new ListGameServerDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
