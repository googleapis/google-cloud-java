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
import com.google.cloud.gaming.v1beta.stub.GameServerConfigsServiceStub;
import com.google.cloud.gaming.v1beta.stub.GameServerConfigsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The game server config configures the game servers in an Agones fleet.
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
 * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
 *     GameServerConfigsServiceClient.create()) {
 *   GameServerConfigName name =
 *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
 *   GameServerConfig response = gameServerConfigsServiceClient.getGameServerConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GameServerConfigsServiceClient object to clean up
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
 * GameServerConfigsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GameServerConfigsServiceSettings gameServerConfigsServiceSettings =
 *     GameServerConfigsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GameServerConfigsServiceClient gameServerConfigsServiceClient =
 *     GameServerConfigsServiceClient.create(gameServerConfigsServiceSettings);
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
 * GameServerConfigsServiceSettings gameServerConfigsServiceSettings =
 *     GameServerConfigsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GameServerConfigsServiceClient gameServerConfigsServiceClient =
 *     GameServerConfigsServiceClient.create(gameServerConfigsServiceSettings);
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
 * GameServerConfigsServiceSettings gameServerConfigsServiceSettings =
 *     GameServerConfigsServiceSettings.newHttpJsonBuilder().build();
 * GameServerConfigsServiceClient gameServerConfigsServiceClient =
 *     GameServerConfigsServiceClient.create(gameServerConfigsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerConfigsServiceClient implements BackgroundResource {
  private final GameServerConfigsServiceSettings settings;
  private final GameServerConfigsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GameServerConfigsServiceClient with default settings. */
  public static final GameServerConfigsServiceClient create() throws IOException {
    return create(GameServerConfigsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GameServerConfigsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GameServerConfigsServiceClient create(
      GameServerConfigsServiceSettings settings) throws IOException {
    return new GameServerConfigsServiceClient(settings);
  }

  /**
   * Constructs an instance of GameServerConfigsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GameServerConfigsServiceSettings).
   */
  public static final GameServerConfigsServiceClient create(GameServerConfigsServiceStub stub) {
    return new GameServerConfigsServiceClient(stub);
  }

  /**
   * Constructs an instance of GameServerConfigsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GameServerConfigsServiceClient(GameServerConfigsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GameServerConfigsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GameServerConfigsServiceClient(GameServerConfigsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GameServerConfigsServiceSettings getSettings() {
    return settings;
  }

  public GameServerConfigsServiceStub getStub() {
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
   * Lists game server configs in a given project, location, and game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GameServerDeploymentName parent =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   for (GameServerConfig element :
   *       gameServerConfigsServiceClient.listGameServerConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerConfigsPagedResponse listGameServerConfigs(
      GameServerDeploymentName parent) {
    ListGameServerConfigsRequest request =
        ListGameServerConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGameServerConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server configs in a given project, location, and game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   String parent =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   for (GameServerConfig element :
   *       gameServerConfigsServiceClient.listGameServerConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerConfigsPagedResponse listGameServerConfigs(String parent) {
    ListGameServerConfigsRequest request =
        ListGameServerConfigsRequest.newBuilder().setParent(parent).build();
    return listGameServerConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server configs in a given project, location, and game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   ListGameServerConfigsRequest request =
   *       ListGameServerConfigsRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GameServerConfig element :
   *       gameServerConfigsServiceClient.listGameServerConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerConfigsPagedResponse listGameServerConfigs(
      ListGameServerConfigsRequest request) {
    return listGameServerConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server configs in a given project, location, and game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   ListGameServerConfigsRequest request =
   *       ListGameServerConfigsRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GameServerConfig> future =
   *       gameServerConfigsServiceClient.listGameServerConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GameServerConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsPagedResponse>
      listGameServerConfigsPagedCallable() {
    return stub.listGameServerConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server configs in a given project, location, and game server deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   ListGameServerConfigsRequest request =
   *       ListGameServerConfigsRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGameServerConfigsResponse response =
   *         gameServerConfigsServiceClient.listGameServerConfigsCallable().call(request);
   *     for (GameServerConfig element : response.getGameServerConfigsList()) {
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
  public final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsCallable() {
    return stub.listGameServerConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GameServerConfigName name =
   *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
   *   GameServerConfig response = gameServerConfigsServiceClient.getGameServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server config to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/{config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerConfig getGameServerConfig(GameServerConfigName name) {
    GetGameServerConfigRequest request =
        GetGameServerConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGameServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   String name =
   *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]").toString();
   *   GameServerConfig response = gameServerConfigsServiceClient.getGameServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server config to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/{config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerConfig getGameServerConfig(String name) {
    GetGameServerConfigRequest request =
        GetGameServerConfigRequest.newBuilder().setName(name).build();
    return getGameServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GetGameServerConfigRequest request =
   *       GetGameServerConfigRequest.newBuilder()
   *           .setName(
   *               GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
   *                   .toString())
   *           .build();
   *   GameServerConfig response = gameServerConfigsServiceClient.getGameServerConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerConfig getGameServerConfig(GetGameServerConfigRequest request) {
    return getGameServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GetGameServerConfigRequest request =
   *       GetGameServerConfigRequest.newBuilder()
   *           .setName(
   *               GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GameServerConfig> future =
   *       gameServerConfigsServiceClient.getGameServerConfigCallable().futureCall(request);
   *   // Do something.
   *   GameServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigCallable() {
    return stub.getGameServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server config in a given project, location, and game server deployment. Game
   * server configs are immutable, and are not applied until referenced in the game server
   * deployment rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GameServerDeploymentName parent =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();
   *   GameServerConfig response =
   *       gameServerConfigsServiceClient
   *           .createGameServerConfigAsync(parent, gameServerConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/`.
   * @param gameServerConfig Required. The game server config resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerConfig, OperationMetadata> createGameServerConfigAsync(
      GameServerDeploymentName parent, GameServerConfig gameServerConfig) {
    CreateGameServerConfigRequest request =
        CreateGameServerConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGameServerConfig(gameServerConfig)
            .build();
    return createGameServerConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server config in a given project, location, and game server deployment. Game
   * server configs are immutable, and are not applied until referenced in the game server
   * deployment rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   String parent =
   *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();
   *   GameServerConfig response =
   *       gameServerConfigsServiceClient
   *           .createGameServerConfigAsync(parent, gameServerConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/`.
   * @param gameServerConfig Required. The game server config resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerConfig, OperationMetadata> createGameServerConfigAsync(
      String parent, GameServerConfig gameServerConfig) {
    CreateGameServerConfigRequest request =
        CreateGameServerConfigRequest.newBuilder()
            .setParent(parent)
            .setGameServerConfig(gameServerConfig)
            .build();
    return createGameServerConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server config in a given project, location, and game server deployment. Game
   * server configs are immutable, and are not applied until referenced in the game server
   * deployment rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   CreateGameServerConfigRequest request =
   *       CreateGameServerConfigRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setConfigId("configId-580140035")
   *           .setGameServerConfig(GameServerConfig.newBuilder().build())
   *           .build();
   *   GameServerConfig response =
   *       gameServerConfigsServiceClient.createGameServerConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerConfig, OperationMetadata> createGameServerConfigAsync(
      CreateGameServerConfigRequest request) {
    return createGameServerConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server config in a given project, location, and game server deployment. Game
   * server configs are immutable, and are not applied until referenced in the game server
   * deployment rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   CreateGameServerConfigRequest request =
   *       CreateGameServerConfigRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setConfigId("configId-580140035")
   *           .setGameServerConfig(GameServerConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerConfig, OperationMetadata> future =
   *       gameServerConfigsServiceClient
   *           .createGameServerConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationCallable() {
    return stub.createGameServerConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server config in a given project, location, and game server deployment. Game
   * server configs are immutable, and are not applied until referenced in the game server
   * deployment rollout resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   CreateGameServerConfigRequest request =
   *       CreateGameServerConfigRequest.newBuilder()
   *           .setParent(
   *               GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setConfigId("configId-580140035")
   *           .setGameServerConfig(GameServerConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerConfigsServiceClient.createGameServerConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGameServerConfigRequest, Operation>
      createGameServerConfigCallable() {
    return stub.createGameServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server config. The deletion will fail if the game server config is
   * referenced in a game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   GameServerConfigName name =
   *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
   *   gameServerConfigsServiceClient.deleteGameServerConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server config to delete. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/{config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerConfigAsync(
      GameServerConfigName name) {
    DeleteGameServerConfigRequest request =
        DeleteGameServerConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGameServerConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server config. The deletion will fail if the game server config is
   * referenced in a game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   String name =
   *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]").toString();
   *   gameServerConfigsServiceClient.deleteGameServerConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server config to delete. Uses the form:
   *     <p>`projects/{project}/locations/{location}/gameServerDeployments/{deployment}/configs/{config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerConfigAsync(String name) {
    DeleteGameServerConfigRequest request =
        DeleteGameServerConfigRequest.newBuilder().setName(name).build();
    return deleteGameServerConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server config. The deletion will fail if the game server config is
   * referenced in a game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   DeleteGameServerConfigRequest request =
   *       DeleteGameServerConfigRequest.newBuilder()
   *           .setName(
   *               GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
   *                   .toString())
   *           .build();
   *   gameServerConfigsServiceClient.deleteGameServerConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerConfigAsync(
      DeleteGameServerConfigRequest request) {
    return deleteGameServerConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server config. The deletion will fail if the game server config is
   * referenced in a game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   DeleteGameServerConfigRequest request =
   *       DeleteGameServerConfigRequest.newBuilder()
   *           .setName(
   *               GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gameServerConfigsServiceClient
   *           .deleteGameServerConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationCallable() {
    return stub.deleteGameServerConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server config. The deletion will fail if the game server config is
   * referenced in a game server deployment rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
   *     GameServerConfigsServiceClient.create()) {
   *   DeleteGameServerConfigRequest request =
   *       DeleteGameServerConfigRequest.newBuilder()
   *           .setName(
   *               GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerConfigsServiceClient.deleteGameServerConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigCallable() {
    return stub.deleteGameServerConfigCallable();
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

  public static class ListGameServerConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          GameServerConfig,
          ListGameServerConfigsPage,
          ListGameServerConfigsFixedSizeCollection> {

    public static ApiFuture<ListGameServerConfigsPagedResponse> createAsync(
        PageContext<ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
            context,
        ApiFuture<ListGameServerConfigsResponse> futureResponse) {
      ApiFuture<ListGameServerConfigsPage> futurePage =
          ListGameServerConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGameServerConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGameServerConfigsPagedResponse(ListGameServerConfigsPage page) {
      super(page, ListGameServerConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGameServerConfigsPage
      extends AbstractPage<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          GameServerConfig,
          ListGameServerConfigsPage> {

    private ListGameServerConfigsPage(
        PageContext<ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
            context,
        ListGameServerConfigsResponse response) {
      super(context, response);
    }

    private static ListGameServerConfigsPage createEmptyPage() {
      return new ListGameServerConfigsPage(null, null);
    }

    @Override
    protected ListGameServerConfigsPage createPage(
        PageContext<ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
            context,
        ListGameServerConfigsResponse response) {
      return new ListGameServerConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListGameServerConfigsPage> createPageAsync(
        PageContext<ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
            context,
        ApiFuture<ListGameServerConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGameServerConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          GameServerConfig,
          ListGameServerConfigsPage,
          ListGameServerConfigsFixedSizeCollection> {

    private ListGameServerConfigsFixedSizeCollection(
        List<ListGameServerConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGameServerConfigsFixedSizeCollection createEmptyCollection() {
      return new ListGameServerConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGameServerConfigsFixedSizeCollection createCollection(
        List<ListGameServerConfigsPage> pages, int collectionSize) {
      return new ListGameServerConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
