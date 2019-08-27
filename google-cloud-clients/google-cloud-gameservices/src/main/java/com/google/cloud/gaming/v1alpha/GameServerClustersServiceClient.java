/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.gaming.v1alpha.stub.GameServerClustersServiceStub;
import com.google.cloud.gaming.v1alpha.stub.GameServerClustersServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The game server cluster is used to capture the game server cluster's
 * settings which are used to manage game server clusters.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
 *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
 *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the gameServerClustersServiceClient object to clean up
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
 * GameServerClustersServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GameServerClustersServiceSettings gameServerClustersServiceSettings =
 *     GameServerClustersServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create(gameServerClustersServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GameServerClustersServiceSettings gameServerClustersServiceSettings =
 *     GameServerClustersServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create(gameServerClustersServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GameServerClustersServiceClient implements BackgroundResource {
  private final GameServerClustersServiceSettings settings;
  private final GameServerClustersServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate GAME_SERVER_CLUSTER_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/realms/{realm}/gameServerClusters/{game_server_cluster}");

  private static final PathTemplate REALM_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/realms/{realm}");

  /**
   * Formats a string containing the fully-qualified path to represent a game_server_cluster
   * resource.
   *
   * @deprecated Use the {@link GameServerClusterName} class instead.
   */
  @Deprecated
  public static final String formatGameServerClusterName(
      String project, String location, String realm, String gameServerCluster) {
    return GAME_SERVER_CLUSTER_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "realm", realm,
        "game_server_cluster", gameServerCluster);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String formatRealmName(String project, String location, String realm) {
    return REALM_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "realm", realm);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a game_server_cluster
   * resource.
   *
   * @deprecated Use the {@link GameServerClusterName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromGameServerClusterName(String gameServerClusterName) {
    return GAME_SERVER_CLUSTER_PATH_TEMPLATE.parse(gameServerClusterName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a game_server_cluster
   * resource.
   *
   * @deprecated Use the {@link GameServerClusterName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromGameServerClusterName(String gameServerClusterName) {
    return GAME_SERVER_CLUSTER_PATH_TEMPLATE.parse(gameServerClusterName).get("location");
  }

  /**
   * Parses the realm from the given fully-qualified path which represents a game_server_cluster
   * resource.
   *
   * @deprecated Use the {@link GameServerClusterName} class instead.
   */
  @Deprecated
  public static final String parseRealmFromGameServerClusterName(String gameServerClusterName) {
    return GAME_SERVER_CLUSTER_PATH_TEMPLATE.parse(gameServerClusterName).get("realm");
  }

  /**
   * Parses the game_server_cluster from the given fully-qualified path which represents a
   * game_server_cluster resource.
   *
   * @deprecated Use the {@link GameServerClusterName} class instead.
   */
  @Deprecated
  public static final String parseGameServerClusterFromGameServerClusterName(
      String gameServerClusterName) {
    return GAME_SERVER_CLUSTER_PATH_TEMPLATE
        .parse(gameServerClusterName)
        .get("game_server_cluster");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("location");
  }

  /**
   * Parses the realm from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseRealmFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("realm");
  }

  /** Constructs an instance of GameServerClustersServiceClient with default settings. */
  public static final GameServerClustersServiceClient create() throws IOException {
    return create(GameServerClustersServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GameServerClustersServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GameServerClustersServiceClient create(
      GameServerClustersServiceSettings settings) throws IOException {
    return new GameServerClustersServiceClient(settings);
  }

  /**
   * Constructs an instance of GameServerClustersServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use GameServerClustersServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GameServerClustersServiceClient create(GameServerClustersServiceStub stub) {
    return new GameServerClustersServiceClient(stub);
  }

  /**
   * Constructs an instance of GameServerClustersServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GameServerClustersServiceClient(GameServerClustersServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GameServerClustersServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GameServerClustersServiceClient(GameServerClustersServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final GameServerClustersServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GameServerClustersServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   for (GameServerCluster element : gameServerClustersServiceClient.listGameServerClusters(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     "projects/{project_id}/locations/{location}/realms/{realm-id}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerClustersPagedResponse listGameServerClusters(String parent) {
    REALM_PATH_TEMPLATE.validate(parent, "listGameServerClusters");
    ListGameServerClustersRequest request =
        ListGameServerClustersRequest.newBuilder().setParent(parent).build();
    return listGameServerClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   ListGameServerClustersRequest request = ListGameServerClustersRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (GameServerCluster element : gameServerClustersServiceClient.listGameServerClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerClustersPagedResponse listGameServerClusters(
      ListGameServerClustersRequest request) {
    return listGameServerClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   ListGameServerClustersRequest request = ListGameServerClustersRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListGameServerClustersPagedResponse&gt; future = gameServerClustersServiceClient.listGameServerClustersPagedCallable().futureCall(request);
   *   // Do something
   *   for (GameServerCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable() {
    return stub.listGameServerClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   ListGameServerClustersRequest request = ListGameServerClustersRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListGameServerClustersResponse response = gameServerClustersServiceClient.listGameServerClustersCallable().call(request);
   *     for (GameServerCluster element : response.getGameServerClustersList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable() {
    return stub.listGameServerClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server cluster to retrieve, using the form:
   *     <p>`projects/{project_id}/locations/{location}/realms/{realm-id}/gameServerClusters/{cluster_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerCluster getGameServerCluster(String name) {
    GAME_SERVER_CLUSTER_PATH_TEMPLATE.validate(name, "getGameServerCluster");
    GetGameServerClusterRequest request =
        GetGameServerClusterRequest.newBuilder().setName(name).build();
    return getGameServerCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   GetGameServerClusterRequest request = GetGameServerClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerCluster getGameServerCluster(GetGameServerClusterRequest request) {
    return getGameServerClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   GetGameServerClusterRequest request = GetGameServerClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;GameServerCluster&gt; future = gameServerClustersServiceClient.getGameServerClusterCallable().futureCall(request);
   *   // Do something
   *   GameServerCluster response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable() {
    return stub.getGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   String gameServerClusterId = "";
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   GameServerCluster response = gameServerClustersServiceClient.createGameServerClusterAsync(formattedParent, gameServerClusterId, gameServerCluster).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}/realms/{realm-id}`.
   * @param gameServerClusterId Required. The ID of the game server cluster resource to be created.
   * @param gameServerCluster Required. The game server cluster resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerCluster, Empty> createGameServerClusterAsync(
      String parent, String gameServerClusterId, GameServerCluster gameServerCluster) {
    REALM_PATH_TEMPLATE.validate(parent, "createGameServerCluster");
    CreateGameServerClusterRequest request =
        CreateGameServerClusterRequest.newBuilder()
            .setParent(parent)
            .setGameServerClusterId(gameServerClusterId)
            .setGameServerCluster(gameServerCluster)
            .build();
    return createGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   String gameServerClusterId = "";
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   CreateGameServerClusterRequest request = CreateGameServerClusterRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGameServerClusterId(gameServerClusterId)
   *     .setGameServerCluster(gameServerCluster)
   *     .build();
   *   GameServerCluster response = gameServerClustersServiceClient.createGameServerClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerCluster, Empty> createGameServerClusterAsync(
      CreateGameServerClusterRequest request) {
    return createGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   String gameServerClusterId = "";
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   CreateGameServerClusterRequest request = CreateGameServerClusterRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGameServerClusterId(gameServerClusterId)
   *     .setGameServerCluster(gameServerCluster)
   *     .build();
   *   OperationFuture&lt;GameServerCluster, Empty&gt; future = gameServerClustersServiceClient.createGameServerClusterOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerCluster response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationCallable() {
    return stub.createGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedParent = GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   String gameServerClusterId = "";
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   CreateGameServerClusterRequest request = CreateGameServerClusterRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGameServerClusterId(gameServerClusterId)
   *     .setGameServerCluster(gameServerCluster)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerClustersServiceClient.createGameServerClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    return stub.createGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   gameServerClustersServiceClient.deleteGameServerClusterAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server cluster to delete, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerClusters/{cluster_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteGameServerClusterAsync(String name) {
    GAME_SERVER_CLUSTER_PATH_TEMPLATE.validate(name, "deleteGameServerCluster");
    DeleteGameServerClusterRequest request =
        DeleteGameServerClusterRequest.newBuilder().setName(name).build();
    return deleteGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   DeleteGameServerClusterRequest request = DeleteGameServerClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   gameServerClustersServiceClient.deleteGameServerClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteGameServerClusterAsync(
      DeleteGameServerClusterRequest request) {
    return deleteGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   DeleteGameServerClusterRequest request = DeleteGameServerClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;Empty, Empty&gt; future = gameServerClustersServiceClient.deleteGameServerClusterOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationCallable() {
    return stub.deleteGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
   *   DeleteGameServerClusterRequest request = DeleteGameServerClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerClustersServiceClient.deleteGameServerClusterCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    return stub.deleteGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GameServerCluster response = gameServerClustersServiceClient.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
   * }
   * </code></pre>
   *
   * @param gameServerCluster Required. The game server cluster to be updated. Only fields specified
   *     in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerCluster, Empty> updateGameServerClusterAsync(
      GameServerCluster gameServerCluster, FieldMask updateMask) {

    UpdateGameServerClusterRequest request =
        UpdateGameServerClusterRequest.newBuilder()
            .setGameServerCluster(gameServerCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerClusterRequest request = UpdateGameServerClusterRequest.newBuilder()
   *     .setGameServerCluster(gameServerCluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   GameServerCluster response = gameServerClustersServiceClient.updateGameServerClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerCluster, Empty> updateGameServerClusterAsync(
      UpdateGameServerClusterRequest request) {
    return updateGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerClusterRequest request = UpdateGameServerClusterRequest.newBuilder()
   *     .setGameServerCluster(gameServerCluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;GameServerCluster, Empty&gt; future = gameServerClustersServiceClient.updateGameServerClusterOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerCluster response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationCallable() {
    return stub.updateGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerClusterRequest request = UpdateGameServerClusterRequest.newBuilder()
   *     .setGameServerCluster(gameServerCluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerClustersServiceClient.updateGameServerClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    return stub.updateGameServerClusterCallable();
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

  public static class ListGameServerClustersPagedResponse
      extends AbstractPagedListResponse<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          GameServerCluster,
          ListGameServerClustersPage,
          ListGameServerClustersFixedSizeCollection> {

    public static ApiFuture<ListGameServerClustersPagedResponse> createAsync(
        PageContext<
                ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>
            context,
        ApiFuture<ListGameServerClustersResponse> futureResponse) {
      ApiFuture<ListGameServerClustersPage> futurePage =
          ListGameServerClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGameServerClustersPage, ListGameServerClustersPagedResponse>() {
            @Override
            public ListGameServerClustersPagedResponse apply(ListGameServerClustersPage input) {
              return new ListGameServerClustersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListGameServerClustersPagedResponse(ListGameServerClustersPage page) {
      super(page, ListGameServerClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGameServerClustersPage
      extends AbstractPage<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          GameServerCluster,
          ListGameServerClustersPage> {

    private ListGameServerClustersPage(
        PageContext<
                ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>
            context,
        ListGameServerClustersResponse response) {
      super(context, response);
    }

    private static ListGameServerClustersPage createEmptyPage() {
      return new ListGameServerClustersPage(null, null);
    }

    @Override
    protected ListGameServerClustersPage createPage(
        PageContext<
                ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>
            context,
        ListGameServerClustersResponse response) {
      return new ListGameServerClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListGameServerClustersPage> createPageAsync(
        PageContext<
                ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>
            context,
        ApiFuture<ListGameServerClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGameServerClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          GameServerCluster,
          ListGameServerClustersPage,
          ListGameServerClustersFixedSizeCollection> {

    private ListGameServerClustersFixedSizeCollection(
        List<ListGameServerClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGameServerClustersFixedSizeCollection createEmptyCollection() {
      return new ListGameServerClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGameServerClustersFixedSizeCollection createCollection(
        List<ListGameServerClustersPage> pages, int collectionSize) {
      return new ListGameServerClustersFixedSizeCollection(pages, collectionSize);
    }
  }
}
