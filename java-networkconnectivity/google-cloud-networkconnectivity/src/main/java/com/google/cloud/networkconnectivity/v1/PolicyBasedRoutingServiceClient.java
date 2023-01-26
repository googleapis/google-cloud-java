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

package com.google.cloud.networkconnectivity.v1;

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
import com.google.cloud.networkconnectivity.v1.stub.PolicyBasedRoutingServiceStub;
import com.google.cloud.networkconnectivity.v1.stub.PolicyBasedRoutingServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Policy-Based Routing allows GCP customers to specify flexibile routing
 * policies for Layer 4 traffic traversing through the connected service.
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
 * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
 *     PolicyBasedRoutingServiceClient.create()) {
 *   PolicyBasedRouteName name =
 *       PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");
 *   PolicyBasedRoute response = policyBasedRoutingServiceClient.getPolicyBasedRoute(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PolicyBasedRoutingServiceClient object to clean up
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
 * PolicyBasedRoutingServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBasedRoutingServiceSettings policyBasedRoutingServiceSettings =
 *     PolicyBasedRoutingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
 *     PolicyBasedRoutingServiceClient.create(policyBasedRoutingServiceSettings);
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
 * PolicyBasedRoutingServiceSettings policyBasedRoutingServiceSettings =
 *     PolicyBasedRoutingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
 *     PolicyBasedRoutingServiceClient.create(policyBasedRoutingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PolicyBasedRoutingServiceClient implements BackgroundResource {
  private final PolicyBasedRoutingServiceSettings settings;
  private final PolicyBasedRoutingServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of PolicyBasedRoutingServiceClient with default settings. */
  public static final PolicyBasedRoutingServiceClient create() throws IOException {
    return create(PolicyBasedRoutingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PolicyBasedRoutingServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PolicyBasedRoutingServiceClient create(
      PolicyBasedRoutingServiceSettings settings) throws IOException {
    return new PolicyBasedRoutingServiceClient(settings);
  }

  /**
   * Constructs an instance of PolicyBasedRoutingServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PolicyBasedRoutingServiceSettings).
   */
  public static final PolicyBasedRoutingServiceClient create(PolicyBasedRoutingServiceStub stub) {
    return new PolicyBasedRoutingServiceClient(stub);
  }

  /**
   * Constructs an instance of PolicyBasedRoutingServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PolicyBasedRoutingServiceClient(PolicyBasedRoutingServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PolicyBasedRoutingServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected PolicyBasedRoutingServiceClient(PolicyBasedRoutingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PolicyBasedRoutingServiceSettings getSettings() {
    return settings;
  }

  public PolicyBasedRoutingServiceStub getStub() {
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
   * Lists PolicyBasedRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PolicyBasedRoute element :
   *       policyBasedRoutingServiceClient.listPolicyBasedRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBasedRoutesPagedResponse listPolicyBasedRoutes(LocationName parent) {
    ListPolicyBasedRoutesRequest request =
        ListPolicyBasedRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicyBasedRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PolicyBasedRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PolicyBasedRoute element :
   *       policyBasedRoutingServiceClient.listPolicyBasedRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBasedRoutesPagedResponse listPolicyBasedRoutes(String parent) {
    ListPolicyBasedRoutesRequest request =
        ListPolicyBasedRoutesRequest.newBuilder().setParent(parent).build();
    return listPolicyBasedRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PolicyBasedRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   ListPolicyBasedRoutesRequest request =
   *       ListPolicyBasedRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PolicyBasedRoute element :
   *       policyBasedRoutingServiceClient.listPolicyBasedRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBasedRoutesPagedResponse listPolicyBasedRoutes(
      ListPolicyBasedRoutesRequest request) {
    return listPolicyBasedRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PolicyBasedRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   ListPolicyBasedRoutesRequest request =
   *       ListPolicyBasedRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PolicyBasedRoute> future =
   *       policyBasedRoutingServiceClient.listPolicyBasedRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PolicyBasedRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesPagedResponse>
      listPolicyBasedRoutesPagedCallable() {
    return stub.listPolicyBasedRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PolicyBasedRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   ListPolicyBasedRoutesRequest request =
   *       ListPolicyBasedRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPolicyBasedRoutesResponse response =
   *         policyBasedRoutingServiceClient.listPolicyBasedRoutesCallable().call(request);
   *     for (PolicyBasedRoute element : response.getPolicyBasedRoutesList()) {
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
  public final UnaryCallable<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse>
      listPolicyBasedRoutesCallable() {
    return stub.listPolicyBasedRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   PolicyBasedRouteName name =
   *       PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");
   *   PolicyBasedRoute response = policyBasedRoutingServiceClient.getPolicyBasedRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the PolicyBasedRoute resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBasedRoute getPolicyBasedRoute(PolicyBasedRouteName name) {
    GetPolicyBasedRouteRequest request =
        GetPolicyBasedRouteRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPolicyBasedRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   String name =
   *       PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]").toString();
   *   PolicyBasedRoute response = policyBasedRoutingServiceClient.getPolicyBasedRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the PolicyBasedRoute resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBasedRoute getPolicyBasedRoute(String name) {
    GetPolicyBasedRouteRequest request =
        GetPolicyBasedRouteRequest.newBuilder().setName(name).build();
    return getPolicyBasedRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   GetPolicyBasedRouteRequest request =
   *       GetPolicyBasedRouteRequest.newBuilder()
   *           .setName(
   *               PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
   *                   .toString())
   *           .build();
   *   PolicyBasedRoute response = policyBasedRoutingServiceClient.getPolicyBasedRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBasedRoute getPolicyBasedRoute(GetPolicyBasedRouteRequest request) {
    return getPolicyBasedRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   GetPolicyBasedRouteRequest request =
   *       GetPolicyBasedRouteRequest.newBuilder()
   *           .setName(
   *               PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PolicyBasedRoute> future =
   *       policyBasedRoutingServiceClient.getPolicyBasedRouteCallable().futureCall(request);
   *   // Do something.
   *   PolicyBasedRoute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPolicyBasedRouteRequest, PolicyBasedRoute>
      getPolicyBasedRouteCallable() {
    return stub.getPolicyBasedRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PolicyBasedRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
   *   String policyBasedRouteId = "policyBasedRouteId-18034589";
   *   PolicyBasedRoute response =
   *       policyBasedRoutingServiceClient
   *           .createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the PolicyBasedRoute.
   * @param policyBasedRoute Required. Initial values for a new Policy Based Route.
   * @param policyBasedRouteId Optional. Unique id for the Policy Based Route to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBasedRoute, OperationMetadata> createPolicyBasedRouteAsync(
      LocationName parent, PolicyBasedRoute policyBasedRoute, String policyBasedRouteId) {
    CreatePolicyBasedRouteRequest request =
        CreatePolicyBasedRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicyBasedRoute(policyBasedRoute)
            .setPolicyBasedRouteId(policyBasedRouteId)
            .build();
    return createPolicyBasedRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PolicyBasedRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PolicyBasedRoute policyBasedRoute = PolicyBasedRoute.newBuilder().build();
   *   String policyBasedRouteId = "policyBasedRouteId-18034589";
   *   PolicyBasedRoute response =
   *       policyBasedRoutingServiceClient
   *           .createPolicyBasedRouteAsync(parent, policyBasedRoute, policyBasedRouteId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the PolicyBasedRoute.
   * @param policyBasedRoute Required. Initial values for a new Policy Based Route.
   * @param policyBasedRouteId Optional. Unique id for the Policy Based Route to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBasedRoute, OperationMetadata> createPolicyBasedRouteAsync(
      String parent, PolicyBasedRoute policyBasedRoute, String policyBasedRouteId) {
    CreatePolicyBasedRouteRequest request =
        CreatePolicyBasedRouteRequest.newBuilder()
            .setParent(parent)
            .setPolicyBasedRoute(policyBasedRoute)
            .setPolicyBasedRouteId(policyBasedRouteId)
            .build();
    return createPolicyBasedRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PolicyBasedRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   CreatePolicyBasedRouteRequest request =
   *       CreatePolicyBasedRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicyBasedRouteId("policyBasedRouteId-18034589")
   *           .setPolicyBasedRoute(PolicyBasedRoute.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PolicyBasedRoute response =
   *       policyBasedRoutingServiceClient.createPolicyBasedRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBasedRoute, OperationMetadata> createPolicyBasedRouteAsync(
      CreatePolicyBasedRouteRequest request) {
    return createPolicyBasedRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PolicyBasedRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   CreatePolicyBasedRouteRequest request =
   *       CreatePolicyBasedRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicyBasedRouteId("policyBasedRouteId-18034589")
   *           .setPolicyBasedRoute(PolicyBasedRoute.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PolicyBasedRoute, OperationMetadata> future =
   *       policyBasedRoutingServiceClient
   *           .createPolicyBasedRouteOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PolicyBasedRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
      createPolicyBasedRouteOperationCallable() {
    return stub.createPolicyBasedRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PolicyBasedRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   CreatePolicyBasedRouteRequest request =
   *       CreatePolicyBasedRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicyBasedRouteId("policyBasedRouteId-18034589")
   *           .setPolicyBasedRoute(PolicyBasedRoute.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       policyBasedRoutingServiceClient.createPolicyBasedRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyBasedRouteRequest, Operation>
      createPolicyBasedRouteCallable() {
    return stub.createPolicyBasedRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   PolicyBasedRouteName name =
   *       PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]");
   *   policyBasedRoutingServiceClient.deletePolicyBasedRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the PolicyBasedRoute resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBasedRouteAsync(
      PolicyBasedRouteName name) {
    DeletePolicyBasedRouteRequest request =
        DeletePolicyBasedRouteRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePolicyBasedRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   String name =
   *       PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]").toString();
   *   policyBasedRoutingServiceClient.deletePolicyBasedRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the PolicyBasedRoute resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBasedRouteAsync(String name) {
    DeletePolicyBasedRouteRequest request =
        DeletePolicyBasedRouteRequest.newBuilder().setName(name).build();
    return deletePolicyBasedRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   DeletePolicyBasedRouteRequest request =
   *       DeletePolicyBasedRouteRequest.newBuilder()
   *           .setName(
   *               PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   policyBasedRoutingServiceClient.deletePolicyBasedRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBasedRouteAsync(
      DeletePolicyBasedRouteRequest request) {
    return deletePolicyBasedRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   DeletePolicyBasedRouteRequest request =
   *       DeletePolicyBasedRouteRequest.newBuilder()
   *           .setName(
   *               PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       policyBasedRoutingServiceClient
   *           .deletePolicyBasedRouteOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
      deletePolicyBasedRouteOperationCallable() {
    return stub.deletePolicyBasedRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PolicyBasedRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
   *     PolicyBasedRoutingServiceClient.create()) {
   *   DeletePolicyBasedRouteRequest request =
   *       DeletePolicyBasedRouteRequest.newBuilder()
   *           .setName(
   *               PolicyBasedRouteName.of("[PROJECT]", "[LOCATION]", "[POLICY_BASED_ROUTE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       policyBasedRoutingServiceClient.deletePolicyBasedRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyBasedRouteRequest, Operation>
      deletePolicyBasedRouteCallable() {
    return stub.deletePolicyBasedRouteCallable();
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

  public static class ListPolicyBasedRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          PolicyBasedRoute,
          ListPolicyBasedRoutesPage,
          ListPolicyBasedRoutesFixedSizeCollection> {

    public static ApiFuture<ListPolicyBasedRoutesPagedResponse> createAsync(
        PageContext<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
            context,
        ApiFuture<ListPolicyBasedRoutesResponse> futureResponse) {
      ApiFuture<ListPolicyBasedRoutesPage> futurePage =
          ListPolicyBasedRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPolicyBasedRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPolicyBasedRoutesPagedResponse(ListPolicyBasedRoutesPage page) {
      super(page, ListPolicyBasedRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPolicyBasedRoutesPage
      extends AbstractPage<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          PolicyBasedRoute,
          ListPolicyBasedRoutesPage> {

    private ListPolicyBasedRoutesPage(
        PageContext<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
            context,
        ListPolicyBasedRoutesResponse response) {
      super(context, response);
    }

    private static ListPolicyBasedRoutesPage createEmptyPage() {
      return new ListPolicyBasedRoutesPage(null, null);
    }

    @Override
    protected ListPolicyBasedRoutesPage createPage(
        PageContext<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
            context,
        ListPolicyBasedRoutesResponse response) {
      return new ListPolicyBasedRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListPolicyBasedRoutesPage> createPageAsync(
        PageContext<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
            context,
        ApiFuture<ListPolicyBasedRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPolicyBasedRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          PolicyBasedRoute,
          ListPolicyBasedRoutesPage,
          ListPolicyBasedRoutesFixedSizeCollection> {

    private ListPolicyBasedRoutesFixedSizeCollection(
        List<ListPolicyBasedRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPolicyBasedRoutesFixedSizeCollection createEmptyCollection() {
      return new ListPolicyBasedRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPolicyBasedRoutesFixedSizeCollection createCollection(
        List<ListPolicyBasedRoutesPage> pages, int collectionSize) {
      return new ListPolicyBasedRoutesFixedSizeCollection(pages, collectionSize);
    }
  }
}
