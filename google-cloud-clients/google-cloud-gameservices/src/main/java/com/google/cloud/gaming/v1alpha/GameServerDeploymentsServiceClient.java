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
import com.google.cloud.gaming.v1alpha.stub.GameServerDeploymentsServiceStub;
import com.google.cloud.gaming.v1alpha.stub.GameServerDeploymentsServiceStubSettings;
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
 * Service Description: The game server deployment is used to configure the deployment of game
 * server software to Agones Fleets in game server clusters.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
 *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
 *   GameServerDeployment response = gameServerDeploymentsServiceClient.getGameServerDeployment(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the gameServerDeploymentsServiceClient object to clean up
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
 * <pre>
 * <code>
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     GameServerDeploymentsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     GameServerDeploymentsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GameServerDeploymentsServiceClient implements BackgroundResource {
  private final GameServerDeploymentsServiceSettings settings;
  private final GameServerDeploymentsServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/gameServerDeployments/{game_server_deployment}");

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  /**
   * Formats a string containing the fully-qualified path to represent a game_server_deployment
   * resource.
   *
   * @deprecated Use the {@link GameServerDeploymentName} class instead.
   */
  @Deprecated
  public static final String formatGameServerDeploymentName(
      String project, String location, String gameServerDeployment) {
    return GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "game_server_deployment", gameServerDeployment);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a
   * game_server_deployment resource.
   *
   * @deprecated Use the {@link GameServerDeploymentName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromGameServerDeploymentName(
      String gameServerDeploymentName) {
    return GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.parse(gameServerDeploymentName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a
   * game_server_deployment resource.
   *
   * @deprecated Use the {@link GameServerDeploymentName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromGameServerDeploymentName(
      String gameServerDeploymentName) {
    return GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.parse(gameServerDeploymentName).get("location");
  }

  /**
   * Parses the game_server_deployment from the given fully-qualified path which represents a
   * game_server_deployment resource.
   *
   * @deprecated Use the {@link GameServerDeploymentName} class instead.
   */
  @Deprecated
  public static final String parseGameServerDeploymentFromGameServerDeploymentName(
      String gameServerDeploymentName) {
    return GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE
        .parse(gameServerDeploymentName)
        .get("game_server_deployment");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

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
   * calls. This is for advanced usage - prefer to use GameServerDeploymentsServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GameServerDeploymentsServiceClient(GameServerDeploymentsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final GameServerDeploymentsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GameServerDeploymentsServiceStub getStub() {
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
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (GameServerDeployment element : gameServerDeploymentsServiceClient.listGameServerDeployments(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerDeploymentsPagedResponse listGameServerDeployments(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listGameServerDeployments");
    ListGameServerDeploymentsRequest request =
        ListGameServerDeploymentsRequest.newBuilder().setParent(parent).build();
    return listGameServerDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListGameServerDeploymentsRequest request = ListGameServerDeploymentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (GameServerDeployment element : gameServerDeploymentsServiceClient.listGameServerDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGameServerDeploymentsPagedResponse listGameServerDeployments(
      ListGameServerDeploymentsRequest request) {
    return listGameServerDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListGameServerDeploymentsRequest request = ListGameServerDeploymentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListGameServerDeploymentsPagedResponse&gt; future = gameServerDeploymentsServiceClient.listGameServerDeploymentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (GameServerDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListGameServerDeploymentsRequest, ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsPagedCallable() {
    return stub.listGameServerDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists game server deployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListGameServerDeploymentsRequest request = ListGameServerDeploymentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListGameServerDeploymentsResponse response = gameServerDeploymentsServiceClient.listGameServerDeploymentsCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsCallable() {
    return stub.listGameServerDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.getGameServerDeployment(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment to retrieve, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeployment getGameServerDeployment(String name) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "getGameServerDeployment");
    GetGameServerDeploymentRequest request =
        GetGameServerDeploymentRequest.newBuilder().setName(name).build();
    return getGameServerDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GetGameServerDeploymentRequest request = GetGameServerDeploymentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.getGameServerDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GameServerDeployment getGameServerDeployment(
      GetGameServerDeploymentRequest request) {
    return getGameServerDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GetGameServerDeploymentRequest request = GetGameServerDeploymentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;GameServerDeployment&gt; future = gameServerDeploymentsServiceClient.getGameServerDeploymentCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentCallable() {
    return stub.getGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String deploymentId = "";
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.createGameServerDeploymentAsync(formattedParent, deploymentId, gameServerDeployment).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @param deploymentId Required. The ID of the game server deployment resource to be created.
   * @param gameServerDeployment Required. The game server deployment resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> createGameServerDeploymentAsync(
      String parent, String deploymentId, GameServerDeployment gameServerDeployment) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createGameServerDeployment");
    CreateGameServerDeploymentRequest request =
        CreateGameServerDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeploymentId(deploymentId)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    return createGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String deploymentId = "";
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   CreateGameServerDeploymentRequest request = CreateGameServerDeploymentRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDeploymentId(deploymentId)
   *     .setGameServerDeployment(gameServerDeployment)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.createGameServerDeploymentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> createGameServerDeploymentAsync(
      CreateGameServerDeploymentRequest request) {
    return createGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String deploymentId = "";
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   CreateGameServerDeploymentRequest request = CreateGameServerDeploymentRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDeploymentId(deploymentId)
   *     .setGameServerDeployment(gameServerDeployment)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.createGameServerDeploymentOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateGameServerDeploymentRequest, GameServerDeployment, Empty>
      createGameServerDeploymentOperationCallable() {
    return stub.createGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new game server deployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedParent = GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String deploymentId = "";
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   CreateGameServerDeploymentRequest request = CreateGameServerDeploymentRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setDeploymentId(deploymentId)
   *     .setGameServerDeployment(gameServerDeployment)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.createGameServerDeploymentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable() {
    return stub.createGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   gameServerDeploymentsServiceClient.deleteGameServerDeploymentAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment to delete, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteGameServerDeploymentAsync(String name) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "deleteGameServerDeployment");
    DeleteGameServerDeploymentRequest request =
        DeleteGameServerDeploymentRequest.newBuilder().setName(name).build();
    return deleteGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   DeleteGameServerDeploymentRequest request = DeleteGameServerDeploymentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   gameServerDeploymentsServiceClient.deleteGameServerDeploymentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteGameServerDeploymentAsync(
      DeleteGameServerDeploymentRequest request) {
    return deleteGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   DeleteGameServerDeploymentRequest request = DeleteGameServerDeploymentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;Empty, Empty&gt; future = gameServerDeploymentsServiceClient.deleteGameServerDeploymentOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteGameServerDeploymentRequest, Empty, Empty>
      deleteGameServerDeploymentOperationCallable() {
    return stub.deleteGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   DeleteGameServerDeploymentRequest request = DeleteGameServerDeploymentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.deleteGameServerDeploymentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable() {
    return stub.deleteGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.updateGameServerDeploymentAsync(gameServerDeployment, updateMask).get();
   * }
   * </code></pre>
   *
   * @param gameServerDeployment Required. The game server deployment to be updated. Only fields
   *     specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> updateGameServerDeploymentAsync(
      GameServerDeployment gameServerDeployment, FieldMask updateMask) {

    UpdateGameServerDeploymentRequest request =
        UpdateGameServerDeploymentRequest.newBuilder()
            .setGameServerDeployment(gameServerDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateGameServerDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerDeploymentRequest request = UpdateGameServerDeploymentRequest.newBuilder()
   *     .setGameServerDeployment(gameServerDeployment)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.updateGameServerDeploymentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> updateGameServerDeploymentAsync(
      UpdateGameServerDeploymentRequest request) {
    return updateGameServerDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerDeploymentRequest request = UpdateGameServerDeploymentRequest.newBuilder()
   *     .setGameServerDeployment(gameServerDeployment)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.updateGameServerDeploymentOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateGameServerDeploymentRequest, GameServerDeployment, Empty>
      updateGameServerDeploymentOperationCallable() {
    return stub.updateGameServerDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a game server deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateGameServerDeploymentRequest request = UpdateGameServerDeploymentRequest.newBuilder()
   *     .setGameServerDeployment(gameServerDeployment)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.updateGameServerDeploymentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable() {
    return stub.updateGameServerDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts rollout of this game server deployment based on the given game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerTemplate newGameServerTemplate = GameServerTemplate.newBuilder().build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.startRolloutAsync(formattedName, newGameServerTemplate).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @param newGameServerTemplate Required. The game server template for the new rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> startRolloutAsync(
      String name, GameServerTemplate newGameServerTemplate) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "startRollout");
    StartRolloutRequest request =
        StartRolloutRequest.newBuilder()
            .setName(name)
            .setNewGameServerTemplate(newGameServerTemplate)
            .build();
    return startRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts rollout of this game server deployment based on the given game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerTemplate newGameServerTemplate = GameServerTemplate.newBuilder().build();
   *   StartRolloutRequest request = StartRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNewGameServerTemplate(newGameServerTemplate)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.startRolloutAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> startRolloutAsync(
      StartRolloutRequest request) {
    return startRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts rollout of this game server deployment based on the given game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerTemplate newGameServerTemplate = GameServerTemplate.newBuilder().build();
   *   StartRolloutRequest request = StartRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNewGameServerTemplate(newGameServerTemplate)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.startRolloutOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<StartRolloutRequest, GameServerDeployment, Empty>
      startRolloutOperationCallable() {
    return stub.startRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts rollout of this game server deployment based on the given game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerTemplate newGameServerTemplate = GameServerTemplate.newBuilder().build();
   *   StartRolloutRequest request = StartRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNewGameServerTemplate(newGameServerTemplate)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.startRolloutCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<StartRolloutRequest, Operation> startRolloutCallable() {
    return stub.startRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets rollout target for the ongoing game server deployment rollout in the specified clusters
   * and based on the given rollout percentage. Default is 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   List&lt;ClusterPercentageSelector&gt; clusterPercentageSelector = new ArrayList&lt;&gt;();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.setRolloutTargetAsync(formattedName, clusterPercentageSelector).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @param clusterPercentageSelector Required. The percentage of game servers that should run the
   *     new game server template in the specified clusters. Default is 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> setRolloutTargetAsync(
      String name, List<ClusterPercentageSelector> clusterPercentageSelector) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "setRolloutTarget");
    SetRolloutTargetRequest request =
        SetRolloutTargetRequest.newBuilder()
            .setName(name)
            .addAllClusterPercentageSelector(clusterPercentageSelector)
            .build();
    return setRolloutTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets rollout target for the ongoing game server deployment rollout in the specified clusters
   * and based on the given rollout percentage. Default is 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   List&lt;ClusterPercentageSelector&gt; clusterPercentageSelector = new ArrayList&lt;&gt;();
   *   SetRolloutTargetRequest request = SetRolloutTargetRequest.newBuilder()
   *     .setName(formattedName)
   *     .addAllClusterPercentageSelector(clusterPercentageSelector)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.setRolloutTargetAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> setRolloutTargetAsync(
      SetRolloutTargetRequest request) {
    return setRolloutTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets rollout target for the ongoing game server deployment rollout in the specified clusters
   * and based on the given rollout percentage. Default is 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   List&lt;ClusterPercentageSelector&gt; clusterPercentageSelector = new ArrayList&lt;&gt;();
   *   SetRolloutTargetRequest request = SetRolloutTargetRequest.newBuilder()
   *     .setName(formattedName)
   *     .addAllClusterPercentageSelector(clusterPercentageSelector)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.setRolloutTargetOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<SetRolloutTargetRequest, GameServerDeployment, Empty>
      setRolloutTargetOperationCallable() {
    return stub.setRolloutTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets rollout target for the ongoing game server deployment rollout in the specified clusters
   * and based on the given rollout percentage. Default is 0.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   List&lt;ClusterPercentageSelector&gt; clusterPercentageSelector = new ArrayList&lt;&gt;();
   *   SetRolloutTargetRequest request = SetRolloutTargetRequest.newBuilder()
   *     .setName(formattedName)
   *     .addAllClusterPercentageSelector(clusterPercentageSelector)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.setRolloutTargetCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetRolloutTargetRequest, Operation> setRolloutTargetCallable() {
    return stub.setRolloutTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits the ongoing game server deployment rollout by setting the rollout percentage to 100 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.commitRolloutAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> commitRolloutAsync(String name) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "commitRollout");
    CommitRolloutRequest request = CommitRolloutRequest.newBuilder().setName(name).build();
    return commitRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits the ongoing game server deployment rollout by setting the rollout percentage to 100 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   CommitRolloutRequest request = CommitRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.commitRolloutAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> commitRolloutAsync(
      CommitRolloutRequest request) {
    return commitRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits the ongoing game server deployment rollout by setting the rollout percentage to 100 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   CommitRolloutRequest request = CommitRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.commitRolloutOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CommitRolloutRequest, GameServerDeployment, Empty>
      commitRolloutOperationCallable() {
    return stub.commitRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits the ongoing game server deployment rollout by setting the rollout percentage to 100 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   CommitRolloutRequest request = CommitRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.commitRolloutCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CommitRolloutRequest, Operation> commitRolloutCallable() {
    return stub.commitRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back the ongoing game server deployment rollout by setting the rollout percentage to 0 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.revertRolloutAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment to deploy, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> revertRolloutAsync(String name) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "revertRollout");
    RevertRolloutRequest request = RevertRolloutRequest.newBuilder().setName(name).build();
    return revertRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back the ongoing game server deployment rollout by setting the rollout percentage to 0 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   RevertRolloutRequest request = RevertRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   GameServerDeployment response = gameServerDeploymentsServiceClient.revertRolloutAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<GameServerDeployment, Empty> revertRolloutAsync(
      RevertRolloutRequest request) {
    return revertRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back the ongoing game server deployment rollout by setting the rollout percentage to 0 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   RevertRolloutRequest request = RevertRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;GameServerDeployment, Empty&gt; future = gameServerDeploymentsServiceClient.revertRolloutOperationCallable().futureCall(request);
   *   // Do something
   *   GameServerDeployment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<RevertRolloutRequest, GameServerDeployment, Empty>
      revertRolloutOperationCallable() {
    return stub.revertRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back the ongoing game server deployment rollout by setting the rollout percentage to 0 in
   * all clusters whose labels match labels in the game server template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   RevertRolloutRequest request = RevertRolloutRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = gameServerDeploymentsServiceClient.revertRolloutCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RevertRolloutRequest, Operation> revertRolloutCallable() {
    return stub.revertRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information on the rollout target of the deployment, e.g. the target percentage of
   * game servers running stable_game_server_template and new_game_server_template in clusters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   DeploymentTarget response = gameServerDeploymentsServiceClient.getDeploymentTarget(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the game server deployment, using the form:
   *     <p>`projects/{project_id}/locations/{location}/gameServerDeployments/{deployment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeploymentTarget getDeploymentTarget(String name) {
    GAME_SERVER_DEPLOYMENT_PATH_TEMPLATE.validate(name, "getDeploymentTarget");
    GetDeploymentTargetRequest request =
        GetDeploymentTargetRequest.newBuilder().setName(name).build();
    return getDeploymentTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information on the rollout target of the deployment, e.g. the target percentage of
   * game servers running stable_game_server_template and new_game_server_template in clusters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GetDeploymentTargetRequest request = GetDeploymentTargetRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   DeploymentTarget response = gameServerDeploymentsServiceClient.getDeploymentTarget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeploymentTarget getDeploymentTarget(GetDeploymentTargetRequest request) {
    return getDeploymentTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves information on the rollout target of the deployment, e.g. the target percentage of
   * game servers running stable_game_server_template and new_game_server_template in clusters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
   *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
   *   GetDeploymentTargetRequest request = GetDeploymentTargetRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;DeploymentTarget&gt; future = gameServerDeploymentsServiceClient.getDeploymentTargetCallable().futureCall(request);
   *   // Do something
   *   DeploymentTarget response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDeploymentTargetRequest, DeploymentTarget>
      getDeploymentTargetCallable() {
    return stub.getDeploymentTargetCallable();
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
          new ApiFunction<ListGameServerDeploymentsPage, ListGameServerDeploymentsPagedResponse>() {
            @Override
            public ListGameServerDeploymentsPagedResponse apply(
                ListGameServerDeploymentsPage input) {
              return new ListGameServerDeploymentsPagedResponse(input);
            }
          },
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
