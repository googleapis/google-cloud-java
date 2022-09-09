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

package com.google.cloud.apigateway.v1;

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
import com.google.cloud.apigateway.v1.stub.ApiGatewayServiceStub;
import com.google.cloud.apigateway.v1.stub.ApiGatewayServiceStubSettings;
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
 * Service Description: The API Gateway Service is the interface for managing API Gateways.
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
 * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
 *   GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
 *   Gateway response = apiGatewayServiceClient.getGateway(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiGatewayServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ApiGatewayServiceSettings to
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
 * ApiGatewayServiceSettings apiGatewayServiceSettings =
 *     ApiGatewayServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiGatewayServiceClient apiGatewayServiceClient =
 *     ApiGatewayServiceClient.create(apiGatewayServiceSettings);
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
 * ApiGatewayServiceSettings apiGatewayServiceSettings =
 *     ApiGatewayServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiGatewayServiceClient apiGatewayServiceClient =
 *     ApiGatewayServiceClient.create(apiGatewayServiceSettings);
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
 * ApiGatewayServiceSettings apiGatewayServiceSettings =
 *     ApiGatewayServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ApiGatewayServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ApiGatewayServiceClient apiGatewayServiceClient =
 *     ApiGatewayServiceClient.create(apiGatewayServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiGatewayServiceClient implements BackgroundResource {
  private final ApiGatewayServiceSettings settings;
  private final ApiGatewayServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ApiGatewayServiceClient with default settings. */
  public static final ApiGatewayServiceClient create() throws IOException {
    return create(ApiGatewayServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiGatewayServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiGatewayServiceClient create(ApiGatewayServiceSettings settings)
      throws IOException {
    return new ApiGatewayServiceClient(settings);
  }

  /**
   * Constructs an instance of ApiGatewayServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ApiGatewayServiceSettings).
   */
  public static final ApiGatewayServiceClient create(ApiGatewayServiceStub stub) {
    return new ApiGatewayServiceClient(stub);
  }

  /**
   * Constructs an instance of ApiGatewayServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiGatewayServiceClient(ApiGatewayServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiGatewayServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ApiGatewayServiceClient(ApiGatewayServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ApiGatewayServiceSettings getSettings() {
    return settings;
  }

  public ApiGatewayServiceStub getStub() {
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
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Gateway element : apiGatewayServiceClient.listGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the Gateway, of the form:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(LocationName parent) {
    ListGatewaysRequest request =
        ListGatewaysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Gateway element : apiGatewayServiceClient.listGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the Gateway, of the form:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(String parent) {
    ListGatewaysRequest request = ListGatewaysRequest.newBuilder().setParent(parent).build();
    return listGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Gateway element : apiGatewayServiceClient.listGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(ListGatewaysRequest request) {
    return listGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Gateway> future =
   *       apiGatewayServiceClient.listGatewaysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Gateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse>
      listGatewaysPagedCallable() {
    return stub.listGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGatewaysResponse response =
   *         apiGatewayServiceClient.listGatewaysCallable().call(request);
   *     for (Gateway element : response.getGatewaysList()) {
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
  public final UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    return stub.listGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
   *   Gateway response = apiGatewayServiceClient.getGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(GatewayName name) {
    GetGatewayRequest request =
        GetGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString();
   *   Gateway response = apiGatewayServiceClient.getGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(String name) {
    GetGatewayRequest request = GetGatewayRequest.newBuilder().setName(name).build();
    return getGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetGatewayRequest request =
   *       GetGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   Gateway response = apiGatewayServiceClient.getGateway(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(GetGatewayRequest request) {
    return getGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetGatewayRequest request =
   *       GetGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   ApiFuture<Gateway> future = apiGatewayServiceClient.getGatewayCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    return stub.getGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Gateway gateway = Gateway.newBuilder().build();
   *   String gatewayId = "gatewayId-1354641793";
   *   Gateway response =
   *       apiGatewayServiceClient.createGatewayAsync(parent, gateway, gatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the Gateway, of the form:
   *     `projects/&#42;/locations/&#42;`
   * @param gateway Required. Gateway resource.
   * @param gatewayId Required. Identifier to assign to the Gateway. Must be unique within scope of
   *     the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      LocationName parent, Gateway gateway, String gatewayId) {
    CreateGatewayRequest request =
        CreateGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGateway(gateway)
            .setGatewayId(gatewayId)
            .build();
    return createGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Gateway gateway = Gateway.newBuilder().build();
   *   String gatewayId = "gatewayId-1354641793";
   *   Gateway response =
   *       apiGatewayServiceClient.createGatewayAsync(parent, gateway, gatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the Gateway, of the form:
   *     `projects/&#42;/locations/&#42;`
   * @param gateway Required. Gateway resource.
   * @param gatewayId Required. Identifier to assign to the Gateway. Must be unique within scope of
   *     the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      String parent, Gateway gateway, String gatewayId) {
    CreateGatewayRequest request =
        CreateGatewayRequest.newBuilder()
            .setParent(parent)
            .setGateway(gateway)
            .setGatewayId(gatewayId)
            .build();
    return createGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   Gateway response = apiGatewayServiceClient.createGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      CreateGatewayRequest request) {
    return createGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   OperationFuture<Gateway, OperationMetadata> future =
   *       apiGatewayServiceClient.createGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    return stub.createGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.createGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    return stub.createGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   Gateway gateway = Gateway.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Gateway response = apiGatewayServiceClient.updateGatewayAsync(gateway, updateMask).get();
   * }
   * }</pre>
   *
   * @param gateway Required. Gateway resource.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Gateway
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> updateGatewayAsync(
      Gateway gateway, FieldMask updateMask) {
    UpdateGatewayRequest request =
        UpdateGatewayRequest.newBuilder().setGateway(gateway).setUpdateMask(updateMask).build();
    return updateGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   Gateway response = apiGatewayServiceClient.updateGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> updateGatewayAsync(
      UpdateGatewayRequest request) {
    return updateGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   OperationFuture<Gateway, OperationMetadata> future =
   *       apiGatewayServiceClient.updateGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    return stub.updateGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.updateGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    return stub.updateGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
   *   apiGatewayServiceClient.deleteGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(GatewayName name) {
    DeleteGatewayRequest request =
        DeleteGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString();
   *   apiGatewayServiceClient.deleteGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(String name) {
    DeleteGatewayRequest request = DeleteGatewayRequest.newBuilder().setName(name).build();
    return deleteGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   apiGatewayServiceClient.deleteGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(
      DeleteGatewayRequest request) {
    return deleteGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       apiGatewayServiceClient.deleteGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    return stub.deleteGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.deleteGatewayCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    return stub.deleteGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Apis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Api element : apiGatewayServiceClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API, of the form:
   *     `projects/&#42;/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(LocationName parent) {
    ListApisRequest request =
        ListApisRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Apis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Api element : apiGatewayServiceClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API, of the form:
   *     `projects/&#42;/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(String parent) {
    ListApisRequest request = ListApisRequest.newBuilder().setParent(parent).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Apis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Api element : apiGatewayServiceClient.listApis(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(ListApisRequest request) {
    return listApisPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Apis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Api> future = apiGatewayServiceClient.listApisPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Api element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return stub.listApisPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Apis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApisResponse response = apiGatewayServiceClient.listApisCallable().call(request);
   *     for (Api element : response.getApisList()) {
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
  public final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return stub.listApisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[API]");
   *   Api response = apiGatewayServiceClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form: `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(ApiName name) {
    GetApiRequest request =
        GetApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[API]").toString();
   *   Api response = apiGatewayServiceClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form: `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(String name) {
    GetApiRequest request = GetApiRequest.newBuilder().setName(name).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder().setName(ApiName.of("[PROJECT]", "[API]").toString()).build();
   *   Api response = apiGatewayServiceClient.getApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(GetApiRequest request) {
    return getApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder().setName(ApiName.of("[PROJECT]", "[API]").toString()).build();
   *   ApiFuture<Api> future = apiGatewayServiceClient.getApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return stub.getApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Api in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = apiGatewayServiceClient.createApiAsync(parent, api, apiId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API, of the form:
   *     `projects/&#42;/locations/global`
   * @param api Required. API resource.
   * @param apiId Required. Identifier to assign to the API. Must be unique within scope of the
   *     parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Api, OperationMetadata> createApiAsync(
      LocationName parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApi(api)
            .setApiId(apiId)
            .build();
    return createApiAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Api in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = apiGatewayServiceClient.createApiAsync(parent, api, apiId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API, of the form:
   *     `projects/&#42;/locations/global`
   * @param api Required. API resource.
   * @param apiId Required. Identifier to assign to the API. Must be unique within scope of the
   *     parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Api, OperationMetadata> createApiAsync(
      String parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder().setParent(parent).setApi(api).setApiId(apiId).build();
    return createApiAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Api in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiId("apiId93021397")
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   Api response = apiGatewayServiceClient.createApiAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Api, OperationMetadata> createApiAsync(CreateApiRequest request) {
    return createApiOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Api in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiId("apiId93021397")
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   OperationFuture<Api, OperationMetadata> future =
   *       apiGatewayServiceClient.createApiOperationCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateApiRequest, Api, OperationMetadata>
      createApiOperationCallable() {
    return stub.createApiOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Api in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiId("apiId93021397")
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = apiGatewayServiceClient.createApiCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiRequest, Operation> createApiCallable() {
    return stub.createApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   Api api = Api.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Api response = apiGatewayServiceClient.updateApiAsync(api, updateMask).get();
   * }
   * }</pre>
   *
   * @param api Required. API resource.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Api
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Api, OperationMetadata> updateApiAsync(
      Api api, FieldMask updateMask) {
    UpdateApiRequest request =
        UpdateApiRequest.newBuilder().setApi(api).setUpdateMask(updateMask).build();
    return updateApiAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   Api response = apiGatewayServiceClient.updateApiAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Api, OperationMetadata> updateApiAsync(UpdateApiRequest request) {
    return updateApiOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   OperationFuture<Api, OperationMetadata> future =
   *       apiGatewayServiceClient.updateApiOperationCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateApiRequest, Api, OperationMetadata>
      updateApiOperationCallable() {
    return stub.updateApiOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = apiGatewayServiceClient.updateApiCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiRequest, Operation> updateApiCallable() {
    return stub.updateApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[API]");
   *   apiGatewayServiceClient.deleteApiAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form: `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiAsync(ApiName name) {
    DeleteApiRequest request =
        DeleteApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteApiAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[API]").toString();
   *   apiGatewayServiceClient.deleteApiAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form: `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiAsync(String name) {
    DeleteApiRequest request = DeleteApiRequest.newBuilder().setName(name).build();
    return deleteApiAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[API]").toString())
   *           .build();
   *   apiGatewayServiceClient.deleteApiAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiAsync(DeleteApiRequest request) {
    return deleteApiOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[API]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       apiGatewayServiceClient.deleteApiOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationCallable() {
    return stub.deleteApiOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[API]").toString())
   *           .build();
   *   ApiFuture<Operation> future = apiGatewayServiceClient.deleteApiCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiRequest, Operation> deleteApiCallable() {
    return stub.deleteApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ApiConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[API]");
   *   for (ApiConfig element : apiGatewayServiceClient.listApiConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API Config, of the form:
   *     `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiConfigsPagedResponse listApiConfigs(ApiName parent) {
    ListApiConfigsRequest request =
        ListApiConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApiConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ApiConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[API]").toString();
   *   for (ApiConfig element : apiGatewayServiceClient.listApiConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API Config, of the form:
   *     `projects/&#42;/locations/global/apis/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiConfigsPagedResponse listApiConfigs(String parent) {
    ListApiConfigsRequest request = ListApiConfigsRequest.newBuilder().setParent(parent).build();
    return listApiConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ApiConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApiConfigsRequest request =
   *       ListApiConfigsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ApiConfig element : apiGatewayServiceClient.listApiConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiConfigsPagedResponse listApiConfigs(ListApiConfigsRequest request) {
    return listApiConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ApiConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApiConfigsRequest request =
   *       ListApiConfigsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ApiConfig> future =
   *       apiGatewayServiceClient.listApiConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiConfigsRequest, ListApiConfigsPagedResponse>
      listApiConfigsPagedCallable() {
    return stub.listApiConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ApiConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ListApiConfigsRequest request =
   *       ListApiConfigsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListApiConfigsResponse response =
   *         apiGatewayServiceClient.listApiConfigsCallable().call(request);
   *     for (ApiConfig element : response.getApiConfigsList()) {
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
  public final UnaryCallable<ListApiConfigsRequest, ListApiConfigsResponse>
      listApiConfigsCallable() {
    return stub.listApiConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");
   *   ApiConfig response = apiGatewayServiceClient.getApiConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/global/apis/&#42;/configs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiConfig getApiConfig(ApiConfigName name) {
    GetApiConfigRequest request =
        GetApiConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApiConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString();
   *   ApiConfig response = apiGatewayServiceClient.getApiConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/global/apis/&#42;/configs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiConfig getApiConfig(String name) {
    GetApiConfigRequest request = GetApiConfigRequest.newBuilder().setName(name).build();
    return getApiConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetApiConfigRequest request =
   *       GetApiConfigRequest.newBuilder()
   *           .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
   *           .build();
   *   ApiConfig response = apiGatewayServiceClient.getApiConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiConfig getApiConfig(GetApiConfigRequest request) {
    return getApiConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   GetApiConfigRequest request =
   *       GetApiConfigRequest.newBuilder()
   *           .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
   *           .build();
   *   ApiFuture<ApiConfig> future =
   *       apiGatewayServiceClient.getApiConfigCallable().futureCall(request);
   *   // Do something.
   *   ApiConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiConfigRequest, ApiConfig> getApiConfigCallable() {
    return stub.getApiConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ApiConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[API]");
   *   ApiConfig apiConfig = ApiConfig.newBuilder().build();
   *   String apiConfigId = "apiConfigId-64952265";
   *   ApiConfig response =
   *       apiGatewayServiceClient.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API Config, of the form:
   *     `projects/&#42;/locations/global/apis/&#42;`
   * @param apiConfig Required. API resource.
   * @param apiConfigId Required. Identifier to assign to the API Config. Must be unique within
   *     scope of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiConfig, OperationMetadata> createApiConfigAsync(
      ApiName parent, ApiConfig apiConfig, String apiConfigId) {
    CreateApiConfigRequest request =
        CreateApiConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApiConfig(apiConfig)
            .setApiConfigId(apiConfigId)
            .build();
    return createApiConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ApiConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[API]").toString();
   *   ApiConfig apiConfig = ApiConfig.newBuilder().build();
   *   String apiConfigId = "apiConfigId-64952265";
   *   ApiConfig response =
   *       apiGatewayServiceClient.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource of the API Config, of the form:
   *     `projects/&#42;/locations/global/apis/&#42;`
   * @param apiConfig Required. API resource.
   * @param apiConfigId Required. Identifier to assign to the API Config. Must be unique within
   *     scope of the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiConfig, OperationMetadata> createApiConfigAsync(
      String parent, ApiConfig apiConfig, String apiConfigId) {
    CreateApiConfigRequest request =
        CreateApiConfigRequest.newBuilder()
            .setParent(parent)
            .setApiConfig(apiConfig)
            .setApiConfigId(apiConfigId)
            .build();
    return createApiConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ApiConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiConfigRequest request =
   *       CreateApiConfigRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setApiConfigId("apiConfigId-64952265")
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   ApiConfig response = apiGatewayServiceClient.createApiConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiConfig, OperationMetadata> createApiConfigAsync(
      CreateApiConfigRequest request) {
    return createApiConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ApiConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiConfigRequest request =
   *       CreateApiConfigRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setApiConfigId("apiConfigId-64952265")
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ApiConfig, OperationMetadata> future =
   *       apiGatewayServiceClient.createApiConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   ApiConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationCallable() {
    return stub.createApiConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ApiConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   CreateApiConfigRequest request =
   *       CreateApiConfigRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[API]").toString())
   *           .setApiConfigId("apiConfigId-64952265")
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.createApiConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiConfigRequest, Operation> createApiConfigCallable() {
    return stub.createApiConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiConfig apiConfig = ApiConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ApiConfig response =
   *       apiGatewayServiceClient.updateApiConfigAsync(apiConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param apiConfig Required. API Config resource.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the ApiConfig
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiConfig, OperationMetadata> updateApiConfigAsync(
      ApiConfig apiConfig, FieldMask updateMask) {
    UpdateApiConfigRequest request =
        UpdateApiConfigRequest.newBuilder()
            .setApiConfig(apiConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateApiConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiConfigRequest request =
   *       UpdateApiConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   ApiConfig response = apiGatewayServiceClient.updateApiConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiConfig, OperationMetadata> updateApiConfigAsync(
      UpdateApiConfigRequest request) {
    return updateApiConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiConfigRequest request =
   *       UpdateApiConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ApiConfig, OperationMetadata> future =
   *       apiGatewayServiceClient.updateApiConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   ApiConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationCallable() {
    return stub.updateApiConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   UpdateApiConfigRequest request =
   *       UpdateApiConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setApiConfig(ApiConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.updateApiConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiConfigRequest, Operation> updateApiConfigCallable() {
    return stub.updateApiConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");
   *   apiGatewayServiceClient.deleteApiConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/global/apis/&#42;/configs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiConfigAsync(ApiConfigName name) {
    DeleteApiConfigRequest request =
        DeleteApiConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteApiConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   String name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString();
   *   apiGatewayServiceClient.deleteApiConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the form:
   *     `projects/&#42;/locations/global/apis/&#42;/configs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiConfigAsync(String name) {
    DeleteApiConfigRequest request = DeleteApiConfigRequest.newBuilder().setName(name).build();
    return deleteApiConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiConfigRequest request =
   *       DeleteApiConfigRequest.newBuilder()
   *           .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
   *           .build();
   *   apiGatewayServiceClient.deleteApiConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteApiConfigAsync(
      DeleteApiConfigRequest request) {
    return deleteApiConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiConfigRequest request =
   *       DeleteApiConfigRequest.newBuilder()
   *           .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       apiGatewayServiceClient.deleteApiConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationCallable() {
    return stub.deleteApiConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ApiConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiGatewayServiceClient apiGatewayServiceClient = ApiGatewayServiceClient.create()) {
   *   DeleteApiConfigRequest request =
   *       DeleteApiConfigRequest.newBuilder()
   *           .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiGatewayServiceClient.deleteApiConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiConfigRequest, Operation> deleteApiConfigCallable() {
    return stub.deleteApiConfigCallable();
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

  public static class ListGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListGatewaysRequest,
          ListGatewaysResponse,
          Gateway,
          ListGatewaysPage,
          ListGatewaysFixedSizeCollection> {

    public static ApiFuture<ListGatewaysPagedResponse> createAsync(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ApiFuture<ListGatewaysResponse> futureResponse) {
      ApiFuture<ListGatewaysPage> futurePage =
          ListGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGatewaysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGatewaysPagedResponse(ListGatewaysPage page) {
      super(page, ListGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGatewaysPage
      extends AbstractPage<ListGatewaysRequest, ListGatewaysResponse, Gateway, ListGatewaysPage> {

    private ListGatewaysPage(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ListGatewaysResponse response) {
      super(context, response);
    }

    private static ListGatewaysPage createEmptyPage() {
      return new ListGatewaysPage(null, null);
    }

    @Override
    protected ListGatewaysPage createPage(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ListGatewaysResponse response) {
      return new ListGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListGatewaysPage> createPageAsync(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ApiFuture<ListGatewaysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGatewaysRequest,
          ListGatewaysResponse,
          Gateway,
          ListGatewaysPage,
          ListGatewaysFixedSizeCollection> {

    private ListGatewaysFixedSizeCollection(List<ListGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGatewaysFixedSizeCollection createCollection(
        List<ListGatewaysPage> pages, int collectionSize) {
      return new ListGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApisPagedResponse
      extends AbstractPagedListResponse<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    public static ApiFuture<ListApisPagedResponse> createAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      ApiFuture<ListApisPage> futurePage =
          ListApisPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListApisPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListApisPagedResponse(ListApisPage page) {
      super(page, ListApisFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApisPage
      extends AbstractPage<ListApisRequest, ListApisResponse, Api, ListApisPage> {

    private ListApisPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      super(context, response);
    }

    private static ListApisPage createEmptyPage() {
      return new ListApisPage(null, null);
    }

    @Override
    protected ListApisPage createPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      return new ListApisPage(context, response);
    }

    @Override
    public ApiFuture<ListApisPage> createPageAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApisFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    private ListApisFixedSizeCollection(List<ListApisPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApisFixedSizeCollection createEmptyCollection() {
      return new ListApisFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApisFixedSizeCollection createCollection(
        List<ListApisPage> pages, int collectionSize) {
      return new ListApisFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListApiConfigsRequest,
          ListApiConfigsResponse,
          ApiConfig,
          ListApiConfigsPage,
          ListApiConfigsFixedSizeCollection> {

    public static ApiFuture<ListApiConfigsPagedResponse> createAsync(
        PageContext<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig> context,
        ApiFuture<ListApiConfigsResponse> futureResponse) {
      ApiFuture<ListApiConfigsPage> futurePage =
          ListApiConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiConfigsPagedResponse(ListApiConfigsPage page) {
      super(page, ListApiConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiConfigsPage
      extends AbstractPage<
          ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig, ListApiConfigsPage> {

    private ListApiConfigsPage(
        PageContext<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig> context,
        ListApiConfigsResponse response) {
      super(context, response);
    }

    private static ListApiConfigsPage createEmptyPage() {
      return new ListApiConfigsPage(null, null);
    }

    @Override
    protected ListApiConfigsPage createPage(
        PageContext<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig> context,
        ListApiConfigsResponse response) {
      return new ListApiConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiConfigsPage> createPageAsync(
        PageContext<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig> context,
        ApiFuture<ListApiConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiConfigsRequest,
          ListApiConfigsResponse,
          ApiConfig,
          ListApiConfigsPage,
          ListApiConfigsFixedSizeCollection> {

    private ListApiConfigsFixedSizeCollection(List<ListApiConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiConfigsFixedSizeCollection createEmptyCollection() {
      return new ListApiConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiConfigsFixedSizeCollection createCollection(
        List<ListApiConfigsPage> pages, int collectionSize) {
      return new ListApiConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
