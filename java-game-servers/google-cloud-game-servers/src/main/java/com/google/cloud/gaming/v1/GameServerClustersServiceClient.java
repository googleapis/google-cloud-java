/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.gaming.v1;

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
import com.google.cloud.gaming.v1.stub.GameServerClustersServiceStub;
import com.google.cloud.gaming.v1.stub.GameServerClustersServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The game server cluster maps to Kubernetes clusters running Agones and is
 * used to manage fleets within clusters.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create()) {
 *   GameServerClusterName name =
 *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
 *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GameServerClustersServiceClient object to clean up
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
 * <pre>{@code
 * GameServerClustersServiceSettings gameServerClustersServiceSettings =
 *     GameServerClustersServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create(gameServerClustersServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * GameServerClustersServiceSettings gameServerClustersServiceSettings =
 *     GameServerClustersServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create(gameServerClustersServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GameServerClustersServiceClient implements BackgroundResource {
  private final GameServerClustersServiceSettings settings;
  private final GameServerClustersServiceStub stub;
  private final OperationsClient operationsClient;

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
   * calls. This is for advanced usage - prefer using create(GameServerClustersServiceSettings).
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
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
   *   for (GameServerCluster element :
   *       gameServerClustersServiceClient.listGameServerClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     "projects/{project}/locations/{location}/realms/{realm}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerClustersPagedResponse listGameServerClusters(RealmName parent) {
    ListGameServerClustersRequest request =
        ListGameServerClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGameServerClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   String parent =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]").toString();
   *   for (GameServerCluster element :
   *       gameServerClustersServiceClient.listGameServerClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     "projects/{project}/locations/{location}/realms/{realm}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerClustersPagedResponse listGameServerClusters(String parent) {
    ListGameServerClustersRequest request =
        ListGameServerClustersRequest.newBuilder().setParent(parent).build();
    return listGameServerClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   ListGameServerClustersRequest request =
   *       ListGameServerClustersRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GameServerCluster element :
   *       gameServerClustersServiceClient.listGameServerClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerClustersPagedResponse listGameServerClusters(
      ListGameServerClustersRequest request) {
    return listGameServerClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   ListGameServerClustersRequest request =
   *       ListGameServerClustersRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GameServerCluster> future =
   *       gameServerClustersServiceClient.listGameServerClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GameServerCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable() {
    return stub.listGameServerClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists game server clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   while (true) {
   *     ListGameServerClustersResponse response =
   *         gameServerClustersServiceClient.listGameServerClustersCallable().call(request);
   *     for (GameServerCluster element : response.getResponsesList()) {
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
  public final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable() {
    return stub.listGameServerClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   GameServerClusterName name =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
   *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server cluster to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/realms/{realm-id}/gameServerClusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerCluster getGameServerCluster(GameServerClusterName name) {
    GetGameServerClusterRequest request =
        GetGameServerClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGameServerCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   String name =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]").toString();
   *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server cluster to retrieve. Uses the form:
   *     <p>`projects/{project}/locations/{location}/realms/{realm-id}/gameServerClusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerCluster getGameServerCluster(String name) {
    GetGameServerClusterRequest request =
        GetGameServerClusterRequest.newBuilder().setName(name).build();
    return getGameServerCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   GetGameServerClusterRequest request =
   *       GetGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerCluster getGameServerCluster(GetGameServerClusterRequest request) {
    return getGameServerClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   GetGameServerClusterRequest request =
   *       GetGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GameServerCluster> future =
   *       gameServerClustersServiceClient.getGameServerClusterCallable().futureCall(request);
   *   // Do something.
   *   GameServerCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable() {
    return stub.getGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   String gameServerClusterId = "gameServerClusterId-1301104032";
   *   GameServerCluster response =
   *       gameServerClustersServiceClient
   *           .createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm-id}`.
   * @param gameServerCluster Required. The game server cluster resource to be created.
   * @param gameServerClusterId Required. The ID of the game server cluster resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerCluster, OperationMetadata> createGameServerClusterAsync(
      RealmName parent, GameServerCluster gameServerCluster, String gameServerClusterId) {
    CreateGameServerClusterRequest request =
        CreateGameServerClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGameServerCluster(gameServerCluster)
            .setGameServerClusterId(gameServerClusterId)
            .build();
    return createGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   String parent =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]").toString();
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   String gameServerClusterId = "gameServerClusterId-1301104032";
   *   GameServerCluster response =
   *       gameServerClustersServiceClient
   *           .createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Uses the form:
   *     `projects/{project}/locations/{location}/realms/{realm-id}`.
   * @param gameServerCluster Required. The game server cluster resource to be created.
   * @param gameServerClusterId Required. The ID of the game server cluster resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerCluster, OperationMetadata> createGameServerClusterAsync(
      String parent, GameServerCluster gameServerCluster, String gameServerClusterId) {
    CreateGameServerClusterRequest request =
        CreateGameServerClusterRequest.newBuilder()
            .setParent(parent)
            .setGameServerCluster(gameServerCluster)
            .setGameServerClusterId(gameServerClusterId)
            .build();
    return createGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   CreateGameServerClusterRequest request =
   *       CreateGameServerClusterRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setGameServerClusterId("gameServerClusterId-1301104032")
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .build();
   *   GameServerCluster response =
   *       gameServerClustersServiceClient.createGameServerClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerCluster, OperationMetadata> createGameServerClusterAsync(
      CreateGameServerClusterRequest request) {
    return createGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   CreateGameServerClusterRequest request =
   *       CreateGameServerClusterRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setGameServerClusterId("gameServerClusterId-1301104032")
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerCluster, OperationMetadata> future =
   *       gameServerClustersServiceClient
   *           .createGameServerClusterOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationCallable() {
    return stub.createGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   CreateGameServerClusterRequest request =
   *       CreateGameServerClusterRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setGameServerClusterId("gameServerClusterId-1301104032")
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerClustersServiceClient.createGameServerClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    return stub.createGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews creation of a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewCreateGameServerClusterRequest request =
   *       PreviewCreateGameServerClusterRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setGameServerClusterId("gameServerClusterId-1301104032")
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   PreviewCreateGameServerClusterResponse response =
   *       gameServerClustersServiceClient.previewCreateGameServerCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewCreateGameServerClusterResponse previewCreateGameServerCluster(
      PreviewCreateGameServerClusterRequest request) {
    return previewCreateGameServerClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews creation of a new game server cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewCreateGameServerClusterRequest request =
   *       PreviewCreateGameServerClusterRequest.newBuilder()
   *           .setParent(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setGameServerClusterId("gameServerClusterId-1301104032")
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<PreviewCreateGameServerClusterResponse> future =
   *       gameServerClustersServiceClient
   *           .previewCreateGameServerClusterCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PreviewCreateGameServerClusterResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterCallable() {
    return stub.previewCreateGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   GameServerClusterName name =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
   *   gameServerClustersServiceClient.deleteGameServerClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server cluster to delete. Uses the form:
   *     `projects/{project}/locations/{location}/gameServerClusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerClusterAsync(
      GameServerClusterName name) {
    DeleteGameServerClusterRequest request =
        DeleteGameServerClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   String name =
   *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]").toString();
   *   gameServerClustersServiceClient.deleteGameServerClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the game server cluster to delete. Uses the form:
   *     `projects/{project}/locations/{location}/gameServerClusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerClusterAsync(String name) {
    DeleteGameServerClusterRequest request =
        DeleteGameServerClusterRequest.newBuilder().setName(name).build();
    return deleteGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   DeleteGameServerClusterRequest request =
   *       DeleteGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   gameServerClustersServiceClient.deleteGameServerClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGameServerClusterAsync(
      DeleteGameServerClusterRequest request) {
    return deleteGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   DeleteGameServerClusterRequest request =
   *       DeleteGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gameServerClustersServiceClient
   *           .deleteGameServerClusterOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationCallable() {
    return stub.deleteGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   DeleteGameServerClusterRequest request =
   *       DeleteGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerClustersServiceClient.deleteGameServerClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    return stub.deleteGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deletion of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewDeleteGameServerClusterRequest request =
   *       PreviewDeleteGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   PreviewDeleteGameServerClusterResponse response =
   *       gameServerClustersServiceClient.previewDeleteGameServerCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewDeleteGameServerClusterResponse previewDeleteGameServerCluster(
      PreviewDeleteGameServerClusterRequest request) {
    return previewDeleteGameServerClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews deletion of a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewDeleteGameServerClusterRequest request =
   *       PreviewDeleteGameServerClusterRequest.newBuilder()
   *           .setName(
   *               GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
   *                   .toString())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<PreviewDeleteGameServerClusterResponse> future =
   *       gameServerClustersServiceClient
   *           .previewDeleteGameServerClusterCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PreviewDeleteGameServerClusterResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterCallable() {
    return stub.previewDeleteGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GameServerCluster response =
   *       gameServerClustersServiceClient
   *           .updateGameServerClusterAsync(gameServerCluster, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param gameServerCluster Required. The game server cluster to be updated. Only fields specified
   *     in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerCluster, OperationMetadata> updateGameServerClusterAsync(
      GameServerCluster gameServerCluster, FieldMask updateMask) {
    UpdateGameServerClusterRequest request =
        UpdateGameServerClusterRequest.newBuilder()
            .setGameServerCluster(gameServerCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateGameServerClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   UpdateGameServerClusterRequest request =
   *       UpdateGameServerClusterRequest.newBuilder()
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GameServerCluster response =
   *       gameServerClustersServiceClient.updateGameServerClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GameServerCluster, OperationMetadata> updateGameServerClusterAsync(
      UpdateGameServerClusterRequest request) {
    return updateGameServerClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   UpdateGameServerClusterRequest request =
   *       UpdateGameServerClusterRequest.newBuilder()
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<GameServerCluster, OperationMetadata> future =
   *       gameServerClustersServiceClient
   *           .updateGameServerClusterOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GameServerCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationCallable() {
    return stub.updateGameServerClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a single game server cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   UpdateGameServerClusterRequest request =
   *       UpdateGameServerClusterRequest.newBuilder()
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gameServerClustersServiceClient.updateGameServerClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    return stub.updateGameServerClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews updating a GameServerCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewUpdateGameServerClusterRequest request =
   *       PreviewUpdateGameServerClusterRequest.newBuilder()
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   PreviewUpdateGameServerClusterResponse response =
   *       gameServerClustersServiceClient.previewUpdateGameServerCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewUpdateGameServerClusterResponse previewUpdateGameServerCluster(
      PreviewUpdateGameServerClusterRequest request) {
    return previewUpdateGameServerClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Previews updating a GameServerCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (GameServerClustersServiceClient gameServerClustersServiceClient =
   *     GameServerClustersServiceClient.create()) {
   *   PreviewUpdateGameServerClusterRequest request =
   *       PreviewUpdateGameServerClusterRequest.newBuilder()
   *           .setGameServerCluster(GameServerCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPreviewTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<PreviewUpdateGameServerClusterResponse> future =
   *       gameServerClustersServiceClient
   *           .previewUpdateGameServerClusterCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PreviewUpdateGameServerClusterResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterCallable() {
    return stub.previewUpdateGameServerClusterCallable();
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
