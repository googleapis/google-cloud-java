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

package com.google.cloud.beyondcorp.appconnectors.v1;

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
import com.google.cloud.beyondcorp.appconnectors.v1.stub.AppConnectorsServiceStub;
import com.google.cloud.beyondcorp.appconnectors.v1.stub.AppConnectorsServiceStubSettings;
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
 * <p>The AppConnectorsService exposes the following resource:
 *
 * <ul>
 *   <li>AppConnectors, named as follows:
 *       `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
 * </ul>
 *
 * <p>The AppConnectorsService provides methods to manage (create/read/update/delete) BeyondCorp
 * AppConnectors.
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
 * try (AppConnectorsServiceClient appConnectorsServiceClient =
 *     AppConnectorsServiceClient.create()) {
 *   AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
 *   AppConnector response = appConnectorsServiceClient.getAppConnector(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppConnectorsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of AppConnectorsServiceSettings
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
 * AppConnectorsServiceSettings appConnectorsServiceSettings =
 *     AppConnectorsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppConnectorsServiceClient appConnectorsServiceClient =
 *     AppConnectorsServiceClient.create(appConnectorsServiceSettings);
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
 * AppConnectorsServiceSettings appConnectorsServiceSettings =
 *     AppConnectorsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppConnectorsServiceClient appConnectorsServiceClient =
 *     AppConnectorsServiceClient.create(appConnectorsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AppConnectorsServiceClient implements BackgroundResource {
  private final AppConnectorsServiceSettings settings;
  private final AppConnectorsServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AppConnectorsServiceClient with default settings. */
  public static final AppConnectorsServiceClient create() throws IOException {
    return create(AppConnectorsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppConnectorsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppConnectorsServiceClient create(AppConnectorsServiceSettings settings)
      throws IOException {
    return new AppConnectorsServiceClient(settings);
  }

  /**
   * Constructs an instance of AppConnectorsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AppConnectorsServiceSettings).
   */
  public static final AppConnectorsServiceClient create(AppConnectorsServiceStub stub) {
    return new AppConnectorsServiceClient(stub);
  }

  /**
   * Constructs an instance of AppConnectorsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AppConnectorsServiceClient(AppConnectorsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppConnectorsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AppConnectorsServiceClient(AppConnectorsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AppConnectorsServiceSettings getSettings() {
    return settings;
  }

  public AppConnectorsServiceStub getStub() {
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
   * Lists AppConnectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AppConnector element :
   *       appConnectorsServiceClient.listAppConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnector location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectorsPagedResponse listAppConnectors(LocationName parent) {
    ListAppConnectorsRequest request =
        ListAppConnectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AppConnector element :
   *       appConnectorsServiceClient.listAppConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppConnector location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectorsPagedResponse listAppConnectors(String parent) {
    ListAppConnectorsRequest request =
        ListAppConnectorsRequest.newBuilder().setParent(parent).build();
    return listAppConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListAppConnectorsRequest request =
   *       ListAppConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AppConnector element :
   *       appConnectorsServiceClient.listAppConnectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppConnectorsPagedResponse listAppConnectors(ListAppConnectorsRequest request) {
    return listAppConnectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListAppConnectorsRequest request =
   *       ListAppConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AppConnector> future =
   *       appConnectorsServiceClient.listAppConnectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AppConnector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsPagedResponse>
      listAppConnectorsPagedCallable() {
    return stub.listAppConnectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppConnectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListAppConnectorsRequest request =
   *       ListAppConnectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAppConnectorsResponse response =
   *         appConnectorsServiceClient.listAppConnectorsCallable().call(request);
   *     for (AppConnector element : response.getAppConnectorsList()) {
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
  public final UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsResponse>
      listAppConnectorsCallable() {
    return stub.listAppConnectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
   *   AppConnector response = appConnectorsServiceClient.getAppConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnector getAppConnector(AppConnectorName name) {
    GetAppConnectorRequest request =
        GetAppConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   String name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString();
   *   AppConnector response = appConnectorsServiceClient.getAppConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnector getAppConnector(String name) {
    GetAppConnectorRequest request = GetAppConnectorRequest.newBuilder().setName(name).build();
    return getAppConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetAppConnectorRequest request =
   *       GetAppConnectorRequest.newBuilder()
   *           .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .build();
   *   AppConnector response = appConnectorsServiceClient.getAppConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppConnector getAppConnector(GetAppConnectorRequest request) {
    return getAppConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetAppConnectorRequest request =
   *       GetAppConnectorRequest.newBuilder()
   *           .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .build();
   *   ApiFuture<AppConnector> future =
   *       appConnectorsServiceClient.getAppConnectorCallable().futureCall(request);
   *   // Do something.
   *   AppConnector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppConnectorRequest, AppConnector> getAppConnectorCallable() {
    return stub.getAppConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AppConnector appConnector = AppConnector.newBuilder().build();
   *   String appConnectorId = "appConnectorId374103399";
   *   AppConnector response =
   *       appConnectorsServiceClient
   *           .createAppConnectorAsync(parent, appConnector, appConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppConnector location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appConnector Required. A BeyondCorp AppConnector resource.
   * @param appConnectorId Optional. User-settable AppConnector resource ID.
   *     <p>&#42; Must start with a letter. &#42; Must contain between 4-63 characters from
   *     `/[a-z][0-9]-/`. &#42; Must end with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> createAppConnectorAsync(
      LocationName parent, AppConnector appConnector, String appConnectorId) {
    CreateAppConnectorRequest request =
        CreateAppConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppConnector(appConnector)
            .setAppConnectorId(appConnectorId)
            .build();
    return createAppConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AppConnector appConnector = AppConnector.newBuilder().build();
   *   String appConnectorId = "appConnectorId374103399";
   *   AppConnector response =
   *       appConnectorsServiceClient
   *           .createAppConnectorAsync(parent, appConnector, appConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppConnector location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appConnector Required. A BeyondCorp AppConnector resource.
   * @param appConnectorId Optional. User-settable AppConnector resource ID.
   *     <p>&#42; Must start with a letter. &#42; Must contain between 4-63 characters from
   *     `/[a-z][0-9]-/`. &#42; Must end with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> createAppConnectorAsync(
      String parent, AppConnector appConnector, String appConnectorId) {
    CreateAppConnectorRequest request =
        CreateAppConnectorRequest.newBuilder()
            .setParent(parent)
            .setAppConnector(appConnector)
            .setAppConnectorId(appConnectorId)
            .build();
    return createAppConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   CreateAppConnectorRequest request =
   *       CreateAppConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId("appConnectorId374103399")
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   AppConnector response = appConnectorsServiceClient.createAppConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> createAppConnectorAsync(
      CreateAppConnectorRequest request) {
    return createAppConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   CreateAppConnectorRequest request =
   *       CreateAppConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId("appConnectorId374103399")
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AppConnector, AppConnectorOperationMetadata> future =
   *       appConnectorsServiceClient.createAppConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   AppConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationCallable() {
    return stub.createAppConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppConnector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   CreateAppConnectorRequest request =
   *       CreateAppConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppConnectorId("appConnectorId374103399")
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectorsServiceClient.createAppConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppConnectorRequest, Operation> createAppConnectorCallable() {
    return stub.createAppConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   AppConnector appConnector = AppConnector.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AppConnector response =
   *       appConnectorsServiceClient.updateAppConnectorAsync(appConnector, updateMask).get();
   * }
   * }</pre>
   *
   * @param appConnector Required. AppConnector message with updated fields. Only supported fields
   *     specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [BeyondCorp.AppConnector]:
   *     <ul>
   *       <li>`labels`
   *       <li>`display_name`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> updateAppConnectorAsync(
      AppConnector appConnector, FieldMask updateMask) {
    UpdateAppConnectorRequest request =
        UpdateAppConnectorRequest.newBuilder()
            .setAppConnector(appConnector)
            .setUpdateMask(updateMask)
            .build();
    return updateAppConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   UpdateAppConnectorRequest request =
   *       UpdateAppConnectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   AppConnector response = appConnectorsServiceClient.updateAppConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> updateAppConnectorAsync(
      UpdateAppConnectorRequest request) {
    return updateAppConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   UpdateAppConnectorRequest request =
   *       UpdateAppConnectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AppConnector, AppConnectorOperationMetadata> future =
   *       appConnectorsServiceClient.updateAppConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   AppConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationCallable() {
    return stub.updateAppConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   UpdateAppConnectorRequest request =
   *       UpdateAppConnectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAppConnector(AppConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectorsServiceClient.updateAppConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAppConnectorRequest, Operation> updateAppConnectorCallable() {
    return stub.updateAppConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   AppConnectorName name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
   *   appConnectorsServiceClient.deleteAppConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectorOperationMetadata> deleteAppConnectorAsync(
      AppConnectorName name) {
    DeleteAppConnectorRequest request =
        DeleteAppConnectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAppConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   String name = AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString();
   *   appConnectorsServiceClient.deleteAppConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppConnector name using the form:
   *     `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectorOperationMetadata> deleteAppConnectorAsync(
      String name) {
    DeleteAppConnectorRequest request =
        DeleteAppConnectorRequest.newBuilder().setName(name).build();
    return deleteAppConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   DeleteAppConnectorRequest request =
   *       DeleteAppConnectorRequest.newBuilder()
   *           .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   appConnectorsServiceClient.deleteAppConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppConnectorOperationMetadata> deleteAppConnectorAsync(
      DeleteAppConnectorRequest request) {
    return deleteAppConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   DeleteAppConnectorRequest request =
   *       DeleteAppConnectorRequest.newBuilder()
   *           .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, AppConnectorOperationMetadata> future =
   *       appConnectorsServiceClient.deleteAppConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationCallable() {
    return stub.deleteAppConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   DeleteAppConnectorRequest request =
   *       DeleteAppConnectorRequest.newBuilder()
   *           .setName(AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectorsServiceClient.deleteAppConnectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppConnectorRequest, Operation> deleteAppConnectorCallable() {
    return stub.deleteAppConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report status for a given connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   AppConnectorName appConnector =
   *       AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]");
   *   ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();
   *   AppConnector response =
   *       appConnectorsServiceClient.reportStatusAsync(appConnector, resourceInfo).get();
   * }
   * }</pre>
   *
   * @param appConnector Required. BeyondCorp Connector name using the form:
   *     `projects/{project_id}/locations/{location_id}/connectors/{connector}`
   * @param resourceInfo Required. Resource info of the connector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> reportStatusAsync(
      AppConnectorName appConnector, ResourceInfo resourceInfo) {
    ReportStatusRequest request =
        ReportStatusRequest.newBuilder()
            .setAppConnector(appConnector == null ? null : appConnector.toString())
            .setResourceInfo(resourceInfo)
            .build();
    return reportStatusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report status for a given connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   String appConnector =
   *       AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString();
   *   ResourceInfo resourceInfo = ResourceInfo.newBuilder().build();
   *   AppConnector response =
   *       appConnectorsServiceClient.reportStatusAsync(appConnector, resourceInfo).get();
   * }
   * }</pre>
   *
   * @param appConnector Required. BeyondCorp Connector name using the form:
   *     `projects/{project_id}/locations/{location_id}/connectors/{connector}`
   * @param resourceInfo Required. Resource info of the connector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> reportStatusAsync(
      String appConnector, ResourceInfo resourceInfo) {
    ReportStatusRequest request =
        ReportStatusRequest.newBuilder()
            .setAppConnector(appConnector)
            .setResourceInfo(resourceInfo)
            .build();
    return reportStatusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report status for a given connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ReportStatusRequest request =
   *       ReportStatusRequest.newBuilder()
   *           .setAppConnector(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setResourceInfo(ResourceInfo.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   AppConnector response = appConnectorsServiceClient.reportStatusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppConnector, AppConnectorOperationMetadata> reportStatusAsync(
      ReportStatusRequest request) {
    return reportStatusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report status for a given connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ReportStatusRequest request =
   *       ReportStatusRequest.newBuilder()
   *           .setAppConnector(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setResourceInfo(ResourceInfo.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AppConnector, AppConnectorOperationMetadata> future =
   *       appConnectorsServiceClient.reportStatusOperationCallable().futureCall(request);
   *   // Do something.
   *   AppConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationCallable() {
    return stub.reportStatusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report status for a given connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ReportStatusRequest request =
   *       ReportStatusRequest.newBuilder()
   *           .setAppConnector(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setResourceInfo(ResourceInfo.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appConnectorsServiceClient.reportStatusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportStatusRequest, Operation> reportStatusCallable() {
    return stub.reportStatusCallable();
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appConnectorsServiceClient.listLocations(request).iterateAll()) {
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       appConnectorsServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         appConnectorsServiceClient.listLocationsCallable().call(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appConnectorsServiceClient.getLocation(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       appConnectorsServiceClient.getLocationCallable().futureCall(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = appConnectorsServiceClient.setIamPolicy(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appConnectorsServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = appConnectorsServiceClient.getIamPolicy(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appConnectorsServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = appConnectorsServiceClient.testIamPermissions(request);
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
   * try (AppConnectorsServiceClient appConnectorsServiceClient =
   *     AppConnectorsServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AppConnectorName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTOR]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       appConnectorsServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAppConnectorsPagedResponse
      extends AbstractPagedListResponse<
          ListAppConnectorsRequest,
          ListAppConnectorsResponse,
          AppConnector,
          ListAppConnectorsPage,
          ListAppConnectorsFixedSizeCollection> {

    public static ApiFuture<ListAppConnectorsPagedResponse> createAsync(
        PageContext<ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector> context,
        ApiFuture<ListAppConnectorsResponse> futureResponse) {
      ApiFuture<ListAppConnectorsPage> futurePage =
          ListAppConnectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAppConnectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAppConnectorsPagedResponse(ListAppConnectorsPage page) {
      super(page, ListAppConnectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppConnectorsPage
      extends AbstractPage<
          ListAppConnectorsRequest,
          ListAppConnectorsResponse,
          AppConnector,
          ListAppConnectorsPage> {

    private ListAppConnectorsPage(
        PageContext<ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector> context,
        ListAppConnectorsResponse response) {
      super(context, response);
    }

    private static ListAppConnectorsPage createEmptyPage() {
      return new ListAppConnectorsPage(null, null);
    }

    @Override
    protected ListAppConnectorsPage createPage(
        PageContext<ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector> context,
        ListAppConnectorsResponse response) {
      return new ListAppConnectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListAppConnectorsPage> createPageAsync(
        PageContext<ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector> context,
        ApiFuture<ListAppConnectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppConnectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppConnectorsRequest,
          ListAppConnectorsResponse,
          AppConnector,
          ListAppConnectorsPage,
          ListAppConnectorsFixedSizeCollection> {

    private ListAppConnectorsFixedSizeCollection(
        List<ListAppConnectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppConnectorsFixedSizeCollection createEmptyCollection() {
      return new ListAppConnectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppConnectorsFixedSizeCollection createCollection(
        List<ListAppConnectorsPage> pages, int collectionSize) {
      return new ListAppConnectorsFixedSizeCollection(pages, collectionSize);
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
