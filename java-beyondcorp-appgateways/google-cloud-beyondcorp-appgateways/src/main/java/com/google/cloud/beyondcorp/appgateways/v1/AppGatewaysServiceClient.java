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

package com.google.cloud.beyondcorp.appgateways.v1;

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
import com.google.cloud.beyondcorp.appgateways.v1.stub.AppGatewaysServiceStub;
import com.google.cloud.beyondcorp.appgateways.v1.stub.AppGatewaysServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ## API Overview
 *
 * <p>The `beyondcorp.googleapis.com` service implements the Google Cloud BeyondCorp API.
 *
 * <p>## Data Model
 *
 * <p>The AppGatewaysService exposes the following resources:
 *
 * <ul>
 *   <li>AppGateways, named as follows:
 *       `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`.
 * </ul>
 *
 * <p>The AppGatewaysService service provides methods to manage (create/read/update/delete)
 * BeyondCorp AppGateways.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
 *   AppGatewayName name = AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]");
 *   AppGateway response = appGatewaysServiceClient.getAppGateway(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppGatewaysServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of AppGatewaysServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * AppGatewaysServiceSettings appGatewaysServiceSettings =
 *     AppGatewaysServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppGatewaysServiceClient appGatewaysServiceClient =
 *     AppGatewaysServiceClient.create(appGatewaysServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * AppGatewaysServiceSettings appGatewaysServiceSettings =
 *     AppGatewaysServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppGatewaysServiceClient appGatewaysServiceClient =
 *     AppGatewaysServiceClient.create(appGatewaysServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AppGatewaysServiceClient implements BackgroundResource {
  private final AppGatewaysServiceSettings settings;
  private final AppGatewaysServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AppGatewaysServiceClient with default settings. */
  public static final AppGatewaysServiceClient create() throws IOException {
    return create(AppGatewaysServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppGatewaysServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppGatewaysServiceClient create(AppGatewaysServiceSettings settings)
      throws IOException {
    return new AppGatewaysServiceClient(settings);
  }

  /**
   * Constructs an instance of AppGatewaysServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AppGatewaysServiceSettings).
   */
  public static final AppGatewaysServiceClient create(AppGatewaysServiceStub stub) {
    return new AppGatewaysServiceClient(stub);
  }

  /**
   * Constructs an instance of AppGatewaysServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AppGatewaysServiceClient(AppGatewaysServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppGatewaysServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AppGatewaysServiceClient(AppGatewaysServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AppGatewaysServiceSettings getSettings() {
    return settings;
  }

  public AppGatewaysServiceStub getStub() {
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
   * Lists AppGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AppGateway element : appGatewaysServiceClient.listAppGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppGateway location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppGatewaysPagedResponse listAppGateways(LocationName parent) {
    ListAppGatewaysRequest request =
        ListAppGatewaysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AppGateway element : appGatewaysServiceClient.listAppGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AppGateway location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppGatewaysPagedResponse listAppGateways(String parent) {
    ListAppGatewaysRequest request = ListAppGatewaysRequest.newBuilder().setParent(parent).build();
    return listAppGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListAppGatewaysRequest request =
   *       ListAppGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AppGateway element : appGatewaysServiceClient.listAppGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppGatewaysPagedResponse listAppGateways(ListAppGatewaysRequest request) {
    return listAppGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListAppGatewaysRequest request =
   *       ListAppGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AppGateway> future =
   *       appGatewaysServiceClient.listAppGatewaysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AppGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysPagedResponse>
      listAppGatewaysPagedCallable() {
    return stub.listAppGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AppGateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListAppGatewaysRequest request =
   *       ListAppGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAppGatewaysResponse response =
   *         appGatewaysServiceClient.listAppGatewaysCallable().call(request);
   *     for (AppGateway element : response.getAppGatewaysList()) {
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
  public final UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysResponse>
      listAppGatewaysCallable() {
    return stub.listAppGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   AppGatewayName name = AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]");
   *   AppGateway response = appGatewaysServiceClient.getAppGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppGateway name using the form:
   *     `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppGateway getAppGateway(AppGatewayName name) {
    GetAppGatewayRequest request =
        GetAppGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   String name = AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString();
   *   AppGateway response = appGatewaysServiceClient.getAppGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppGateway name using the form:
   *     `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppGateway getAppGateway(String name) {
    GetAppGatewayRequest request = GetAppGatewayRequest.newBuilder().setName(name).build();
    return getAppGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetAppGatewayRequest request =
   *       GetAppGatewayRequest.newBuilder()
   *           .setName(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .build();
   *   AppGateway response = appGatewaysServiceClient.getAppGateway(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppGateway getAppGateway(GetAppGatewayRequest request) {
    return getAppGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetAppGatewayRequest request =
   *       GetAppGatewayRequest.newBuilder()
   *           .setName(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .build();
   *   ApiFuture<AppGateway> future =
   *       appGatewaysServiceClient.getAppGatewayCallable().futureCall(request);
   *   // Do something.
   *   AppGateway response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppGatewayRequest, AppGateway> getAppGatewayCallable() {
    return stub.getAppGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AppGateway appGateway = AppGateway.newBuilder().build();
   *   String appGatewayId = "appGatewayId355682654";
   *   AppGateway response =
   *       appGatewaysServiceClient.createAppGatewayAsync(parent, appGateway, appGatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppGateway location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appGateway Required. A BeyondCorp AppGateway resource.
   * @param appGatewayId Optional. User-settable AppGateway resource ID. &#42; Must start with a
   *     letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must end
   *     with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppGateway, AppGatewayOperationMetadata> createAppGatewayAsync(
      LocationName parent, AppGateway appGateway, String appGatewayId) {
    CreateAppGatewayRequest request =
        CreateAppGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppGateway(appGateway)
            .setAppGatewayId(appGatewayId)
            .build();
    return createAppGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AppGateway appGateway = AppGateway.newBuilder().build();
   *   String appGatewayId = "appGatewayId355682654";
   *   AppGateway response =
   *       appGatewaysServiceClient.createAppGatewayAsync(parent, appGateway, appGatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name of the AppGateway location using the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param appGateway Required. A BeyondCorp AppGateway resource.
   * @param appGatewayId Optional. User-settable AppGateway resource ID. &#42; Must start with a
   *     letter. &#42; Must contain between 4-63 characters from `/[a-z][0-9]-/`. &#42; Must end
   *     with a number or a letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppGateway, AppGatewayOperationMetadata> createAppGatewayAsync(
      String parent, AppGateway appGateway, String appGatewayId) {
    CreateAppGatewayRequest request =
        CreateAppGatewayRequest.newBuilder()
            .setParent(parent)
            .setAppGateway(appGateway)
            .setAppGatewayId(appGatewayId)
            .build();
    return createAppGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   CreateAppGatewayRequest request =
   *       CreateAppGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppGatewayId("appGatewayId355682654")
   *           .setAppGateway(AppGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   AppGateway response = appGatewaysServiceClient.createAppGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppGateway, AppGatewayOperationMetadata> createAppGatewayAsync(
      CreateAppGatewayRequest request) {
    return createAppGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   CreateAppGatewayRequest request =
   *       CreateAppGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppGatewayId("appGatewayId355682654")
   *           .setAppGateway(AppGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AppGateway, AppGatewayOperationMetadata> future =
   *       appGatewaysServiceClient.createAppGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   AppGateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationCallable() {
    return stub.createAppGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AppGateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   CreateAppGatewayRequest request =
   *       CreateAppGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppGatewayId("appGatewayId355682654")
   *           .setAppGateway(AppGateway.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appGatewaysServiceClient.createAppGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppGatewayRequest, Operation> createAppGatewayCallable() {
    return stub.createAppGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   AppGatewayName name = AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]");
   *   appGatewaysServiceClient.deleteAppGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppGateway name using the form:
   *     `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppGatewayOperationMetadata> deleteAppGatewayAsync(
      AppGatewayName name) {
    DeleteAppGatewayRequest request =
        DeleteAppGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAppGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   String name = AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString();
   *   appGatewaysServiceClient.deleteAppGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. BeyondCorp AppGateway name using the form:
   *     `projects/{project_id}/locations/{location_id}/appGateways/{app_gateway_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppGatewayOperationMetadata> deleteAppGatewayAsync(
      String name) {
    DeleteAppGatewayRequest request = DeleteAppGatewayRequest.newBuilder().setName(name).build();
    return deleteAppGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   DeleteAppGatewayRequest request =
   *       DeleteAppGatewayRequest.newBuilder()
   *           .setName(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   appGatewaysServiceClient.deleteAppGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, AppGatewayOperationMetadata> deleteAppGatewayAsync(
      DeleteAppGatewayRequest request) {
    return deleteAppGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   DeleteAppGatewayRequest request =
   *       DeleteAppGatewayRequest.newBuilder()
   *           .setName(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, AppGatewayOperationMetadata> future =
   *       appGatewaysServiceClient.deleteAppGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationCallable() {
    return stub.deleteAppGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AppGateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   DeleteAppGatewayRequest request =
   *       DeleteAppGatewayRequest.newBuilder()
   *           .setName(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       appGatewaysServiceClient.deleteAppGatewayCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppGatewayRequest, Operation> deleteAppGatewayCallable() {
    return stub.deleteAppGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appGatewaysServiceClient.listLocations(request).iterateAll()) {
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       appGatewaysServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         appGatewaysServiceClient.listLocationsCallable().call(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appGatewaysServiceClient.getLocation(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       appGatewaysServiceClient.getLocationCallable().futureCall(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = appGatewaysServiceClient.setIamPolicy(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appGatewaysServiceClient.setIamPolicyCallable().futureCall(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = appGatewaysServiceClient.getIamPolicy(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       appGatewaysServiceClient.getIamPolicyCallable().futureCall(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = appGatewaysServiceClient.testIamPermissions(request);
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (AppGatewaysServiceClient appGatewaysServiceClient = AppGatewaysServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AppGatewayName.of("[PROJECT]", "[LOCATION]", "[APP_GATEWAY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       appGatewaysServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAppGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListAppGatewaysRequest,
          ListAppGatewaysResponse,
          AppGateway,
          ListAppGatewaysPage,
          ListAppGatewaysFixedSizeCollection> {

    public static ApiFuture<ListAppGatewaysPagedResponse> createAsync(
        PageContext<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway> context,
        ApiFuture<ListAppGatewaysResponse> futureResponse) {
      ApiFuture<ListAppGatewaysPage> futurePage =
          ListAppGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAppGatewaysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAppGatewaysPagedResponse(ListAppGatewaysPage page) {
      super(page, ListAppGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppGatewaysPage
      extends AbstractPage<
          ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway, ListAppGatewaysPage> {

    private ListAppGatewaysPage(
        PageContext<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway> context,
        ListAppGatewaysResponse response) {
      super(context, response);
    }

    private static ListAppGatewaysPage createEmptyPage() {
      return new ListAppGatewaysPage(null, null);
    }

    @Override
    protected ListAppGatewaysPage createPage(
        PageContext<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway> context,
        ListAppGatewaysResponse response) {
      return new ListAppGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListAppGatewaysPage> createPageAsync(
        PageContext<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway> context,
        ApiFuture<ListAppGatewaysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppGatewaysRequest,
          ListAppGatewaysResponse,
          AppGateway,
          ListAppGatewaysPage,
          ListAppGatewaysFixedSizeCollection> {

    private ListAppGatewaysFixedSizeCollection(
        List<ListAppGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListAppGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppGatewaysFixedSizeCollection createCollection(
        List<ListAppGatewaysPage> pages, int collectionSize) {
      return new ListAppGatewaysFixedSizeCollection(pages, collectionSize);
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
