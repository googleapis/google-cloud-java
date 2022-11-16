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

package com.google.cloud.beyondcorp.appconnections.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.beyondcorp.appconnections.v1.stub.AppConnectionsServiceStub;
import com.google.cloud.beyondcorp.appconnections.v1.stub.AppConnectionsServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * Service Description: API Overview:
 *
 * <p>The `beyondcorp.googleapis.com` service implements the Google Cloud BeyondCorp API.
 *
 * <p>Data Model:
 *
 * <p>The AppConnectionsService exposes the following resources:
 *
 * <ul>
 *   <li>AppConnections, named as follows:
 *       `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
 * </ul>
 *
 * <p>The AppConnectionsService service provides methods to manage (create/read/update/delete)
 * BeyondCorp AppConnections.
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
 * try (AppConnectionsServiceClient appConnectionsServiceClient =
 *     AppConnectionsServiceClient.create()) {
 *   AppConnectionName name = AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]");
 *   AppConnection response = appConnectionsServiceClient.getAppConnection(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppConnectionsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of AppConnectionsServiceSettings
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
 * AppConnectionsServiceSettings appConnectionsServiceSettings =
 *     AppConnectionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppConnectionsServiceClient appConnectionsServiceClient =
 *     AppConnectionsServiceClient.create(appConnectionsServiceSettings);
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
 * AppConnectionsServiceSettings appConnectionsServiceSettings =
 *     AppConnectionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppConnectionsServiceClient appConnectionsServiceClient =
 *     AppConnectionsServiceClient.create(appConnectionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AppConnectionsServiceClient implements BackgroundResource {
  private final AppConnectionsServiceSettings settings;
  private final AppConnectionsServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AppConnectionsServiceClient with default settings. */
  public static final AppConnectionsServiceClient create() throws IOException {
    return create(AppConnectionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppConnectionsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppConnectionsServiceClient create(AppConnectionsServiceSettings settings)
      throws IOException {
    return new AppConnectionsServiceClient(settings);
  }

  /**
   * Constructs an instance of AppConnectionsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AppConnectionsServiceSettings).
   */
  public static final AppConnectionsServiceClient create(AppConnectionsServiceStub stub) {
    return new AppConnectionsServiceClient(stub);
  }

  /**
   * Constructs an instance of AppConnectionsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AppConnectionsServiceClient(AppConnectionsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppConnectionsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AppConnectionsServiceClient(AppConnectionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AppConnectionsServiceSettings getSettings() {
    return settings;
  }

  public AppConnectionsServiceStub getStub() {
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
   * Lists AppConnections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AppConnection element :
   *       appConnectionsServiceClient.listAppConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectionsPagedResponse listAppConnections(LocationName parent) {
    ListAppConnectionsRequest request =
        ListAppConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AppConnection element :
   *       appConnectionsServiceClient.listAppConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectionsPagedResponse listAppConnections(String parent) {
    ListAppConnectionsRequest request =
        ListAppConnectionsRequest.newBuilder().setParent(parent).build();
    return listAppConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListAppConnectionsRequest request =
   *       ListAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AppConnection element :
   *       appConnectionsServiceClient.listAppConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectionsPagedResponse listAppConnections(
      ListAppConnectionsRequest request) {
    return listAppConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListAppConnectionsRequest request =
   *       ListAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AppConnection> future =
   *       appConnectionsServiceClient.listAppConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AppConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsPagedResponse>
      listAppConnectionsPagedCallable() {
    return stub.listAppConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListAppConnectionsRequest request =
   *       ListAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAppConnectionsResponse response =
   *         appConnectionsServiceClient.listAppConnectionsCallable().call(request);
   *     for (AppConnection element : response.getAppConnectionsList()) {
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
  public final UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsResponse>
      listAppConnectionsCallable() {
    return stub.listAppConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   AppConnectionName name = AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]");
   *   AppConnection response = appConnectionsServiceClient.getAppConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnection name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnection getAppConnection(AppConnectionName name) {
    GetAppConnectionRequest request =
        GetAppConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   String name = AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString();
   *   AppConnection response = appConnectionsServiceClient.getAppConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnection name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnection getAppConnection(String name) {
    GetAppConnectionRequest request = GetAppConnectionRequest.newBuilder().setName(name).build();
    return getAppConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetAppConnectionRequest request =
   *       GetAppConnectionRequest.newBuilder()
   *           .setName(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .build();
   *   AppConnection response = appConnectionsServiceClient.getAppConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnection getAppConnection(GetAppConnectionRequest request) {
    return getAppConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetAppConnectionRequest request =
   *       GetAppConnectionRequest.newBuilder()
   *           .setName(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .build();
   *   ApiFuture<AppConnection> future =
   *       appConnectionsServiceClient.getAppConnectionCallable().futureCall(request);
   *   // Do something.
   *   AppConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppConnectionRequest, AppConnection> getAppConnectionCallable() {
    return stub.getAppConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AppConnection appConnection = AppConnection.newBuilder().build();
   *   String appConnectionId = "appConnectionId-1293292198";
   *   AppConnection response =
   *       appConnectionsServiceClient
   *           .createAppConnectionAsync(parent, appConnection, appConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appConnection Required. A BeyondCorp AppConnection resource.
   * @param appConnectionId Optional. User-settable AppConnection resource ID. &#42; Must start with
   *     a letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must end
   *     with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnection, AppConnectionOperationMetadata>
      createAppConnectionAsync(
          LocationName parent, AppConnection appConnection, String appConnectionId) {
    CreateAppConnectionRequest request =
        CreateAppConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppConnection(appConnection)
            .setAppConnectionId(appConnectionId)
            .build();
    return createAppConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AppConnection appConnection = AppConnection.newBuilder().build();
   *   String appConnectionId = "appConnectionId-1293292198";
   *   AppConnection response =
   *       appConnectionsServiceClient
   *           .createAppConnectionAsync(parent, appConnection, appConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appConnection Required. A BeyondCorp AppConnection resource.
   * @param appConnectionId Optional. User-settable AppConnection resource ID. &#42; Must start with
   *     a letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must end
   *     with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnection, AppConnectionOperationMetadata>
      createAppConnectionAsync(String parent, AppConnection appConnection, String appConnectionId) {
    CreateAppConnectionRequest request =
        CreateAppConnectionRequest.newBuilder()
            .setParent(parent)
            .setAppConnection(appConnection)
            .setAppConnectionId(appConnectionId)
            .build();
    return createAppConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   CreateAppConnectionRequest request =
   *       CreateAppConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectionId("appConnectionId-1293292198")
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   AppConnection response = appConnectionsServiceClient.createAppConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnection, AppConnectionOperationMetadata>
      createAppConnectionAsync(CreateAppConnectionRequest request) {
    return createAppConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   CreateAppConnectionRequest request =
   *       CreateAppConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectionId("appConnectionId-1293292198")
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AppConnection, AppConnectionOperationMetadata> future =
   *       appConnectionsServiceClient.createAppConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   AppConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationCallable() {
    return stub.createAppConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   CreateAppConnectionRequest request =
   *       CreateAppConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectionId("appConnectionId-1293292198")
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectionsServiceClient.createAppConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppConnectionRequest, Operation> createAppConnectionCallable() {
    return stub.createAppConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   AppConnection appConnection = AppConnection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AppConnection response =
   *       appConnectionsServiceClient.updateAppConnectionAsync(appConnection, updateMask).get();
   * }
   * }</pre>
   *
   * @param appConnection Required. AppConnection message with updated fields. Only supported fields
   *     specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [BeyondCorp.AppConnection]:
   *     <ul>
   *       <li>`labels`
   *       <li>`display_name`
   *       <li>`application_endpoint`
   *       <li>`connectors`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionAsync(AppConnection appConnection, FieldMask updateMask) {
    UpdateAppConnectionRequest request =
        UpdateAppConnectionRequest.newBuilder()
            .setAppConnection(appConnection)
            .setUpdateMask(updateMask)
            .build();
    return updateAppConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   UpdateAppConnectionRequest request =
   *       UpdateAppConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   AppConnection response = appConnectionsServiceClient.updateAppConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionAsync(UpdateAppConnectionRequest request) {
    return updateAppConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   UpdateAppConnectionRequest request =
   *       UpdateAppConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<AppConnection, AppConnectionOperationMetadata> future =
   *       appConnectionsServiceClient.updateAppConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   AppConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationCallable() {
    return stub.updateAppConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   UpdateAppConnectionRequest request =
   *       UpdateAppConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnection(AppConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectionsServiceClient.updateAppConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAppConnectionRequest, Operation> updateAppConnectionCallable() {
    return stub.updateAppConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   AppConnectionName name = AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]");
   *   appConnectionsServiceClient.deleteAppConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp Connector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectionOperationMetadata> deleteAppConnectionAsync(
      AppConnectionName name) {
    DeleteAppConnectionRequest request =
        DeleteAppConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAppConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   String name = AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString();
   *   appConnectionsServiceClient.deleteAppConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp Connector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectionOperationMetadata> deleteAppConnectionAsync(
      String name) {
    DeleteAppConnectionRequest request =
        DeleteAppConnectionRequest.newBuilder().setName(name).build();
    return deleteAppConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   DeleteAppConnectionRequest request =
   *       DeleteAppConnectionRequest.newBuilder()
   *           .setName(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   appConnectionsServiceClient.deleteAppConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectionOperationMetadata> deleteAppConnectionAsync(
      DeleteAppConnectionRequest request) {
    return deleteAppConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   DeleteAppConnectionRequest request =
   *       DeleteAppConnectionRequest.newBuilder()
   *           .setName(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, AppConnectionOperationMetadata> future =
   *       appConnectionsServiceClient.deleteAppConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationCallable() {
    return stub.deleteAppConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   DeleteAppConnectionRequest request =
   *       DeleteAppConnectionRequest.newBuilder()
   *           .setName(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectionsServiceClient.deleteAppConnectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppConnectionRequest, Operation> deleteAppConnectionCallable() {
    return stub.deleteAppConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves AppConnections details for a given AppConnector. An internal method called by a
   * connector to find AppConnections to connect to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ResolveAppConnectionsResponse.AppConnectionDetails element :
   *       appConnectionsServiceClient.resolveAppConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveAppConnectionsPagedResponse resolveAppConnections(LocationName parent) {
    ResolveAppConnectionsRequest request =
        ResolveAppConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return resolveAppConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves AppConnections details for a given AppConnector. An internal method called by a
   * connector to find AppConnections to connect to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ResolveAppConnectionsResponse.AppConnectionDetails element :
   *       appConnectionsServiceClient.resolveAppConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnection location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveAppConnectionsPagedResponse resolveAppConnections(String parent) {
    ResolveAppConnectionsRequest request =
        ResolveAppConnectionsRequest.newBuilder().setParent(parent).build();
    return resolveAppConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves AppConnections details for a given AppConnector. An internal method called by a
   * connector to find AppConnections to connect to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ResolveAppConnectionsRequest request =
   *       ResolveAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ResolveAppConnectionsResponse.AppConnectionDetails element :
   *       appConnectionsServiceClient.resolveAppConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveAppConnectionsPagedResponse resolveAppConnections(
      ResolveAppConnectionsRequest request) {
    return resolveAppConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves AppConnections details for a given AppConnector. An internal method called by a
   * connector to find AppConnections to connect to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ResolveAppConnectionsRequest request =
   *       ResolveAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ResolveAppConnectionsResponse.AppConnectionDetails> future =
   *       appConnectionsServiceClient.resolveAppConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResolveAppConnectionsResponse.AppConnectionDetails element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsPagedCallable() {
    return stub.resolveAppConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resolves AppConnections details for a given AppConnector. An internal method called by a
   * connector to find AppConnections to connect to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ResolveAppConnectionsRequest request =
   *       ResolveAppConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ResolveAppConnectionsResponse response =
   *         appConnectionsServiceClient.resolveAppConnectionsCallable().call(request);
   *     for (ResolveAppConnectionsResponse.AppConnectionDetails element :
   *         response.getAppConnectionDetailsList()) {
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
  public final UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse>
      resolveAppConnectionsCallable() {
    return stub.resolveAppConnectionsCallable();
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
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appConnectionsServiceClient.listLocations(request).iterateAll()) {
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
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       appConnectionsServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         appConnectionsServiceClient.listLocationsCallable().call(request);
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
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appConnectionsServiceClient.getLocation(request);
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
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       appConnectionsServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = appConnectionsServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appConnectionsServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = appConnectionsServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appConnectionsServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = appConnectionsServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectionsServiceClient appConnectionsServiceClient =
   *     AppConnectionsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       appConnectionsServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListAppConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListAppConnectionsRequest,
          ListAppConnectionsResponse,
          AppConnection,
          ListAppConnectionsPage,
          ListAppConnectionsFixedSizeCollection> {

    public static ApiFuture<ListAppConnectionsPagedResponse> createAsync(
        PageContext<ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection> context,
        ApiFuture<ListAppConnectionsResponse> futureResponse) {
      ApiFuture<ListAppConnectionsPage> futurePage =
          ListAppConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAppConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAppConnectionsPagedResponse(ListAppConnectionsPage page) {
      super(page, ListAppConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppConnectionsPage
      extends AbstractPage<
          ListAppConnectionsRequest,
          ListAppConnectionsResponse,
          AppConnection,
          ListAppConnectionsPage> {

    private ListAppConnectionsPage(
        PageContext<ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection> context,
        ListAppConnectionsResponse response) {
      super(context, response);
    }

    private static ListAppConnectionsPage createEmptyPage() {
      return new ListAppConnectionsPage(null, null);
    }

    @Override
    protected ListAppConnectionsPage createPage(
        PageContext<ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection> context,
        ListAppConnectionsResponse response) {
      return new ListAppConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAppConnectionsPage> createPageAsync(
        PageContext<ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection> context,
        ApiFuture<ListAppConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppConnectionsRequest,
          ListAppConnectionsResponse,
          AppConnection,
          ListAppConnectionsPage,
          ListAppConnectionsFixedSizeCollection> {

    private ListAppConnectionsFixedSizeCollection(
        List<ListAppConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListAppConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppConnectionsFixedSizeCollection createCollection(
        List<ListAppConnectionsPage> pages, int collectionSize) {
      return new ListAppConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ResolveAppConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsResponse.AppConnectionDetails,
          ResolveAppConnectionsPage,
          ResolveAppConnectionsFixedSizeCollection> {

    public static ApiFuture<ResolveAppConnectionsPagedResponse> createAsync(
        PageContext<
                ResolveAppConnectionsRequest,
                ResolveAppConnectionsResponse,
                ResolveAppConnectionsResponse.AppConnectionDetails>
            context,
        ApiFuture<ResolveAppConnectionsResponse> futureResponse) {
      ApiFuture<ResolveAppConnectionsPage> futurePage =
          ResolveAppConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ResolveAppConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ResolveAppConnectionsPagedResponse(ResolveAppConnectionsPage page) {
      super(page, ResolveAppConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ResolveAppConnectionsPage
      extends AbstractPage<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsResponse.AppConnectionDetails,
          ResolveAppConnectionsPage> {

    private ResolveAppConnectionsPage(
        PageContext<
                ResolveAppConnectionsRequest,
                ResolveAppConnectionsResponse,
                ResolveAppConnectionsResponse.AppConnectionDetails>
            context,
        ResolveAppConnectionsResponse response) {
      super(context, response);
    }

    private static ResolveAppConnectionsPage createEmptyPage() {
      return new ResolveAppConnectionsPage(null, null);
    }

    @Override
    protected ResolveAppConnectionsPage createPage(
        PageContext<
                ResolveAppConnectionsRequest,
                ResolveAppConnectionsResponse,
                ResolveAppConnectionsResponse.AppConnectionDetails>
            context,
        ResolveAppConnectionsResponse response) {
      return new ResolveAppConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ResolveAppConnectionsPage> createPageAsync(
        PageContext<
                ResolveAppConnectionsRequest,
                ResolveAppConnectionsResponse,
                ResolveAppConnectionsResponse.AppConnectionDetails>
            context,
        ApiFuture<ResolveAppConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ResolveAppConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsResponse.AppConnectionDetails,
          ResolveAppConnectionsPage,
          ResolveAppConnectionsFixedSizeCollection> {

    private ResolveAppConnectionsFixedSizeCollection(
        List<ResolveAppConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ResolveAppConnectionsFixedSizeCollection createEmptyCollection() {
      return new ResolveAppConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ResolveAppConnectionsFixedSizeCollection createCollection(
        List<ResolveAppConnectionsPage> pages, int collectionSize) {
      return new ResolveAppConnectionsFixedSizeCollection(pages, collectionSize);
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
