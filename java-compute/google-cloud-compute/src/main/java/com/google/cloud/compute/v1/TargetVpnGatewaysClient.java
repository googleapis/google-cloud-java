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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.TargetVpnGatewaysStub;
import com.google.cloud.compute.v1.stub.TargetVpnGatewaysStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetVpnGateways API.
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
 * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetVpnGateway = "targetVpnGateway935274273";
 *   TargetVpnGateway response = targetVpnGatewaysClient.get(project, region, targetVpnGateway);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetVpnGatewaysClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetVpnGatewaysSettings to
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
 * TargetVpnGatewaysSettings targetVpnGatewaysSettings =
 *     TargetVpnGatewaysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetVpnGatewaysClient targetVpnGatewaysClient =
 *     TargetVpnGatewaysClient.create(targetVpnGatewaysSettings);
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
 * TargetVpnGatewaysSettings targetVpnGatewaysSettings =
 *     TargetVpnGatewaysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetVpnGatewaysClient targetVpnGatewaysClient =
 *     TargetVpnGatewaysClient.create(targetVpnGatewaysSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetVpnGatewaysClient implements BackgroundResource {
  private final TargetVpnGatewaysSettings settings;
  private final TargetVpnGatewaysStub stub;

  /** Constructs an instance of TargetVpnGatewaysClient with default settings. */
  public static final TargetVpnGatewaysClient create() throws IOException {
    return create(TargetVpnGatewaysSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetVpnGatewaysClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetVpnGatewaysClient create(TargetVpnGatewaysSettings settings)
      throws IOException {
    return new TargetVpnGatewaysClient(settings);
  }

  /**
   * Constructs an instance of TargetVpnGatewaysClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TargetVpnGatewaysSettings).
   */
  public static final TargetVpnGatewaysClient create(TargetVpnGatewaysStub stub) {
    return new TargetVpnGatewaysClient(stub);
  }

  /**
   * Constructs an instance of TargetVpnGatewaysClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetVpnGatewaysClient(TargetVpnGatewaysSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetVpnGatewaysStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetVpnGatewaysClient(TargetVpnGatewaysStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetVpnGatewaysSettings getSettings() {
    return settings;
  }

  public TargetVpnGatewaysStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, TargetVpnGatewaysScopedList> element :
   *       targetVpnGatewaysClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetVpnGatewaysRequest request =
        AggregatedListTargetVpnGatewaysRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   AggregatedListTargetVpnGatewaysRequest request =
   *       AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, TargetVpnGatewaysScopedList> element :
   *       targetVpnGatewaysClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetVpnGatewaysRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   AggregatedListTargetVpnGatewaysRequest request =
   *       AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, TargetVpnGatewaysScopedList>> future =
   *       targetVpnGatewaysClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, TargetVpnGatewaysScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListTargetVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   AggregatedListTargetVpnGatewaysRequest request =
   *       AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetVpnGatewayAggregatedList response =
   *         targetVpnGatewaysClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, TargetVpnGatewaysScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetVpnGateway = "targetVpnGateway935274273";
   *   Operation response =
   *       targetVpnGatewaysClient.deleteAsync(project, region, targetVpnGateway).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetVpnGateway Name of the target VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String targetVpnGateway) {
    DeleteTargetVpnGatewayRequest request =
        DeleteTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetVpnGateway(targetVpnGateway)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   DeleteTargetVpnGatewayRequest request =
   *       DeleteTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGateway("targetVpnGateway935274273")
   *           .build();
   *   Operation response = targetVpnGatewaysClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetVpnGatewayRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   DeleteTargetVpnGatewayRequest request =
   *       DeleteTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGateway("targetVpnGateway935274273")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetVpnGatewaysClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetVpnGatewayRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   DeleteTargetVpnGatewayRequest request =
   *       DeleteTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGateway("targetVpnGateway935274273")
   *           .build();
   *   ApiFuture<Operation> future = targetVpnGatewaysClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetVpnGatewayRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetVpnGateway = "targetVpnGateway935274273";
   *   TargetVpnGateway response = targetVpnGatewaysClient.get(project, region, targetVpnGateway);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetVpnGateway Name of the target VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetVpnGateway get(String project, String region, String targetVpnGateway) {
    GetTargetVpnGatewayRequest request =
        GetTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetVpnGateway(targetVpnGateway)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   GetTargetVpnGatewayRequest request =
   *       GetTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetVpnGateway("targetVpnGateway935274273")
   *           .build();
   *   TargetVpnGateway response = targetVpnGatewaysClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetVpnGateway get(GetTargetVpnGatewayRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   GetTargetVpnGatewayRequest request =
   *       GetTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetVpnGateway("targetVpnGateway935274273")
   *           .build();
   *   ApiFuture<TargetVpnGateway> future =
   *       targetVpnGatewaysClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetVpnGateway response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetVpnGatewayRequest, TargetVpnGateway> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   Operation response =
   *       targetVpnGatewaysClient.insertAsync(project, region, targetVpnGatewayResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetVpnGatewayResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, TargetVpnGateway targetVpnGatewayResource) {
    InsertTargetVpnGatewayRequest request =
        InsertTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetVpnGatewayResource(targetVpnGatewayResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   InsertTargetVpnGatewayRequest request =
   *       InsertTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGatewayResource(TargetVpnGateway.newBuilder().build())
   *           .build();
   *   Operation response = targetVpnGatewaysClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetVpnGatewayRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   InsertTargetVpnGatewayRequest request =
   *       InsertTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGatewayResource(TargetVpnGateway.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetVpnGatewaysClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetVpnGatewayRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   InsertTargetVpnGatewayRequest request =
   *       InsertTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetVpnGatewayResource(TargetVpnGateway.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetVpnGatewaysClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetVpnGatewayRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (TargetVpnGateway element : targetVpnGatewaysClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListTargetVpnGatewaysRequest request =
        ListTargetVpnGatewaysRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   ListTargetVpnGatewaysRequest request =
   *       ListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetVpnGateway element : targetVpnGatewaysClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetVpnGatewaysRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   ListTargetVpnGatewaysRequest request =
   *       ListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetVpnGateway> future =
   *       targetVpnGatewaysClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetVpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   ListTargetVpnGatewaysRequest request =
   *       ListTargetVpnGatewaysRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetVpnGatewayList response = targetVpnGatewaysClient.listCallable().call(request);
   *     for (TargetVpnGateway element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetVpnGatewaysRequest, TargetVpnGatewayList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a TargetVpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource =
   *       RegionSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       targetVpnGatewaysClient
   *           .setLabelsAsync(project, region, resource, regionSetLabelsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      String project,
      String region,
      String resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {
    SetLabelsTargetVpnGatewayRequest request =
        SetLabelsTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a TargetVpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   SetLabelsTargetVpnGatewayRequest request =
   *       SetLabelsTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = targetVpnGatewaysClient.setLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      SetLabelsTargetVpnGatewayRequest request) {
    return setLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a TargetVpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   SetLabelsTargetVpnGatewayRequest request =
   *       SetLabelsTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetVpnGatewaysClient.setLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetLabelsTargetVpnGatewayRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return stub.setLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a TargetVpnGateway. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   SetLabelsTargetVpnGatewayRequest request =
   *       SetLabelsTargetVpnGatewayRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future = targetVpnGatewaysClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsTargetVpnGatewayRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetVpnGatewaysRequest,
          TargetVpnGatewayAggregatedList,
          Map.Entry<String, TargetVpnGatewaysScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Map.Entry<String, TargetVpnGatewaysScopedList>>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListTargetVpnGatewaysRequest,
          TargetVpnGatewayAggregatedList,
          Map.Entry<String, TargetVpnGatewaysScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Map.Entry<String, TargetVpnGatewaysScopedList>>
            context,
        TargetVpnGatewayAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Map.Entry<String, TargetVpnGatewaysScopedList>>
            context,
        TargetVpnGatewayAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Map.Entry<String, TargetVpnGatewaysScopedList>>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetVpnGatewaysRequest,
          TargetVpnGatewayAggregatedList,
          Map.Entry<String, TargetVpnGatewaysScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListTargetVpnGatewaysRequest,
          TargetVpnGatewayList,
          TargetVpnGateway,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetVpnGatewaysRequest, TargetVpnGatewayList, TargetVpnGateway> context,
        ApiFuture<TargetVpnGatewayList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListTargetVpnGatewaysRequest, TargetVpnGatewayList, TargetVpnGateway, ListPage> {

    private ListPage(
        PageContext<ListTargetVpnGatewaysRequest, TargetVpnGatewayList, TargetVpnGateway> context,
        TargetVpnGatewayList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetVpnGatewaysRequest, TargetVpnGatewayList, TargetVpnGateway> context,
        TargetVpnGatewayList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetVpnGatewaysRequest, TargetVpnGatewayList, TargetVpnGateway> context,
        ApiFuture<TargetVpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetVpnGatewaysRequest,
          TargetVpnGatewayList,
          TargetVpnGateway,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
