/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.TargetVpnGatewaysStub;
import com.google.cloud.compute.v1.stub.TargetVpnGatewaysStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The TargetVpnGateways API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetVpnGateway = "";
 *   Operation response = targetVpnGatewaysClient.delete(project, region, targetVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetVpnGatewaysClient object to clean up resources
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
 * <pre>
 * <code>
 * TargetVpnGatewaysSettings targetVpnGatewaysSettings =
 *     TargetVpnGatewaysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetVpnGatewaysClient targetVpnGatewaysClient =
 *     TargetVpnGatewaysClient.create(targetVpnGatewaysSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetVpnGatewaysSettings targetVpnGatewaysSettings =
 *     TargetVpnGatewaysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetVpnGatewaysClient targetVpnGatewaysClient =
 *     TargetVpnGatewaysClient.create(targetVpnGatewaysSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * is for advanced usage - prefer to use TargetVpnGatewaysSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetVpnGatewaysClient(TargetVpnGatewaysStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetVpnGatewaysSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetVpnGatewaysStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, TargetVpnGatewaysScopedList&gt; element : targetVpnGatewaysClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetVpnGatewaysRequest request =
        AggregatedListTargetVpnGatewaysRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListTargetVpnGatewaysRequest request = AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, TargetVpnGatewaysScopedList&gt; element : targetVpnGatewaysClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetVpnGatewaysRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListTargetVpnGatewaysRequest request = AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = targetVpnGatewaysClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, TargetVpnGatewaysScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListTargetVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   AggregatedListTargetVpnGatewaysRequest request = AggregatedListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     TargetVpnGatewayAggregatedList response = targetVpnGatewaysClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, TargetVpnGatewaysScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   Operation response = targetVpnGatewaysClient.delete(project, region, targetVpnGateway);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetVpnGateway Name of the target VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String targetVpnGateway) {
    DeleteTargetVpnGatewayRequest request =
        DeleteTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetVpnGateway(targetVpnGateway)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   DeleteTargetVpnGatewayRequest request = DeleteTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGateway(targetVpnGateway)
   *     .build();
   *   Operation response = targetVpnGatewaysClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteTargetVpnGatewayRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   DeleteTargetVpnGatewayRequest request = DeleteTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGateway(targetVpnGateway)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetVpnGatewaysClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTargetVpnGatewayRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   TargetVpnGateway response = targetVpnGatewaysClient.get(project, region, targetVpnGateway);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   GetTargetVpnGatewayRequest request = GetTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGateway(targetVpnGateway)
   *     .build();
   *   TargetVpnGateway response = targetVpnGatewaysClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetVpnGateway get(GetTargetVpnGatewayRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetVpnGateway = "";
   *   GetTargetVpnGatewayRequest request = GetTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGateway(targetVpnGateway)
   *     .build();
   *   ApiFuture&lt;TargetVpnGateway&gt; future = targetVpnGatewaysClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetVpnGateway response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTargetVpnGatewayRequest, TargetVpnGateway> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   Operation response = targetVpnGatewaysClient.insert(project, region, targetVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetVpnGatewayResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, TargetVpnGateway targetVpnGatewayResource) {
    InsertTargetVpnGatewayRequest request =
        InsertTargetVpnGatewayRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetVpnGatewayResource(targetVpnGatewayResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   InsertTargetVpnGatewayRequest request = InsertTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGatewayResource(targetVpnGatewayResource)
   *     .build();
   *   Operation response = targetVpnGatewaysClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertTargetVpnGatewayRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   InsertTargetVpnGatewayRequest request = InsertTargetVpnGatewayRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetVpnGatewayResource(targetVpnGatewayResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetVpnGatewaysClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertTargetVpnGatewayRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (TargetVpnGateway element : targetVpnGatewaysClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetVpnGatewaysRequest request = ListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (TargetVpnGateway element : targetVpnGatewaysClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetVpnGatewaysRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetVpnGatewaysRequest request = ListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = targetVpnGatewaysClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetVpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTargetVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetVpnGatewaysRequest request = ListTargetVpnGatewaysRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListTargetVpnGatewaysRequest, TargetVpnGatewayList> listCallable() {
    return stub.listCallable();
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
          Entry<String, TargetVpnGatewaysScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Entry<String, TargetVpnGatewaysScopedList>>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
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
          Entry<String, TargetVpnGatewaysScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Entry<String, TargetVpnGatewaysScopedList>>
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
                Entry<String, TargetVpnGatewaysScopedList>>
            context,
        TargetVpnGatewayAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysRequest,
                TargetVpnGatewayAggregatedList,
                Entry<String, TargetVpnGatewaysScopedList>>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetVpnGatewaysRequest,
          TargetVpnGatewayAggregatedList,
          Entry<String, TargetVpnGatewaysScopedList>,
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
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
