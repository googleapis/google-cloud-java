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
import com.google.cloud.compute.v1.stub.TargetVpnGatewayStub;
import com.google.cloud.compute.v1.stub.TargetVpnGatewayStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
 *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
 *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(targetVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetVpnGatewayClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetVpnGatewaySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetVpnGatewaySettings targetVpnGatewaySettings =
 *     TargetVpnGatewaySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetVpnGatewayClient targetVpnGatewayClient =
 *     TargetVpnGatewayClient.create(targetVpnGatewaySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetVpnGatewaySettings targetVpnGatewaySettings =
 *     TargetVpnGatewaySettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetVpnGatewayClient targetVpnGatewayClient =
 *     TargetVpnGatewayClient.create(targetVpnGatewaySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetVpnGatewayClient implements BackgroundResource {
  private final TargetVpnGatewaySettings settings;
  private final TargetVpnGatewayStub stub;

  /** Constructs an instance of TargetVpnGatewayClient with default settings. */
  public static final TargetVpnGatewayClient create() throws IOException {
    return create(TargetVpnGatewaySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetVpnGatewayClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetVpnGatewayClient create(TargetVpnGatewaySettings settings)
      throws IOException {
    return new TargetVpnGatewayClient(settings);
  }

  /**
   * Constructs an instance of TargetVpnGatewayClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use TargetVpnGatewaySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetVpnGatewayClient create(TargetVpnGatewayStub stub) {
    return new TargetVpnGatewayClient(stub);
  }

  /**
   * Constructs an instance of TargetVpnGatewayClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetVpnGatewayClient(TargetVpnGatewaySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetVpnGatewayStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetVpnGatewayClient(TargetVpnGatewayStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetVpnGatewaySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetVpnGatewayStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetVpnGatewaysScopedList element : targetVpnGatewayClient.aggregatedListTargetVpnGateways(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetVpnGatewaysPagedResponse aggregatedListTargetVpnGateways(
      ProjectName project) {
    AggregatedListTargetVpnGatewaysHttpRequest request =
        AggregatedListTargetVpnGatewaysHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListTargetVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetVpnGatewaysScopedList element : targetVpnGatewayClient.aggregatedListTargetVpnGateways(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetVpnGatewaysPagedResponse aggregatedListTargetVpnGateways(
      String project) {
    AggregatedListTargetVpnGatewaysHttpRequest request =
        AggregatedListTargetVpnGatewaysHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListTargetVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetVpnGatewaysHttpRequest request = AggregatedListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (TargetVpnGatewaysScopedList element : targetVpnGatewayClient.aggregatedListTargetVpnGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetVpnGatewaysPagedResponse aggregatedListTargetVpnGateways(
      AggregatedListTargetVpnGatewaysHttpRequest request) {
    return aggregatedListTargetVpnGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetVpnGatewaysHttpRequest request = AggregatedListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListTargetVpnGatewaysPagedResponse&gt; future = targetVpnGatewayClient.aggregatedListTargetVpnGatewaysPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetVpnGatewaysScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListTargetVpnGatewaysHttpRequest, AggregatedListTargetVpnGatewaysPagedResponse>
      aggregatedListTargetVpnGatewaysPagedCallable() {
    return stub.aggregatedListTargetVpnGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target VPN gateways.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetVpnGatewaysHttpRequest request = AggregatedListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     TargetVpnGatewayAggregatedList response = targetVpnGatewayClient.aggregatedListTargetVpnGatewaysCallable().call(request);
   *     for (TargetVpnGatewaysScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<
          AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
      aggregatedListTargetVpnGatewaysCallable() {
    return stub.aggregatedListTargetVpnGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(targetVpnGateway);
   * }
   * </code></pre>
   *
   * @param targetVpnGateway Name of the target VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetVpnGateway(
      ProjectRegionTargetVpnGatewayName targetVpnGateway) {

    DeleteTargetVpnGatewayHttpRequest request =
        DeleteTargetVpnGatewayHttpRequest.newBuilder()
            .setTargetVpnGateway(targetVpnGateway == null ? null : targetVpnGateway.toString())
            .build();
    return deleteTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(targetVpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param targetVpnGateway Name of the target VPN gateway to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetVpnGateway(String targetVpnGateway) {

    DeleteTargetVpnGatewayHttpRequest request =
        DeleteTargetVpnGatewayHttpRequest.newBuilder()
            .setTargetVpnGateway(targetVpnGateway)
            .build();
    return deleteTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   DeleteTargetVpnGatewayHttpRequest request = DeleteTargetVpnGatewayHttpRequest.newBuilder()
   *     .setTargetVpnGateway(targetVpnGateway.toString())
   *     .build();
   *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetVpnGateway(DeleteTargetVpnGatewayHttpRequest request) {
    return deleteTargetVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target VPN gateway.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   DeleteTargetVpnGatewayHttpRequest request = DeleteTargetVpnGatewayHttpRequest.newBuilder()
   *     .setTargetVpnGateway(targetVpnGateway.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetVpnGatewayClient.deleteTargetVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteTargetVpnGatewayHttpRequest, Operation>
      deleteTargetVpnGatewayCallable() {
    return stub.deleteTargetVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   TargetVpnGateway response = targetVpnGatewayClient.getTargetVpnGateway(targetVpnGateway);
   * }
   * </code></pre>
   *
   * @param targetVpnGateway Name of the target VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetVpnGateway getTargetVpnGateway(
      ProjectRegionTargetVpnGatewayName targetVpnGateway) {

    GetTargetVpnGatewayHttpRequest request =
        GetTargetVpnGatewayHttpRequest.newBuilder()
            .setTargetVpnGateway(targetVpnGateway == null ? null : targetVpnGateway.toString())
            .build();
    return getTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   TargetVpnGateway response = targetVpnGatewayClient.getTargetVpnGateway(targetVpnGateway.toString());
   * }
   * </code></pre>
   *
   * @param targetVpnGateway Name of the target VPN gateway to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetVpnGateway getTargetVpnGateway(String targetVpnGateway) {

    GetTargetVpnGatewayHttpRequest request =
        GetTargetVpnGatewayHttpRequest.newBuilder().setTargetVpnGateway(targetVpnGateway).build();
    return getTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   GetTargetVpnGatewayHttpRequest request = GetTargetVpnGatewayHttpRequest.newBuilder()
   *     .setTargetVpnGateway(targetVpnGateway.toString())
   *     .build();
   *   TargetVpnGateway response = targetVpnGatewayClient.getTargetVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetVpnGateway getTargetVpnGateway(GetTargetVpnGatewayHttpRequest request) {
    return getTargetVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target VPN gateway. Gets a list of available target VPN gateways by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
   *   GetTargetVpnGatewayHttpRequest request = GetTargetVpnGatewayHttpRequest.newBuilder()
   *     .setTargetVpnGateway(targetVpnGateway.toString())
   *     .build();
   *   ApiFuture&lt;TargetVpnGateway&gt; future = targetVpnGatewayClient.getTargetVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   TargetVpnGateway response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
      getTargetVpnGatewayCallable() {
    return stub.getTargetVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   Operation response = targetVpnGatewayClient.insertTargetVpnGateway(region, targetVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param targetVpnGatewayResource Represents a Target VPN gateway resource. (== resource_for
   *     beta.targetVpnGateways ==) (== resource_for v1.targetVpnGateways ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetVpnGateway(
      ProjectRegionName region, TargetVpnGateway targetVpnGatewayResource) {

    InsertTargetVpnGatewayHttpRequest request =
        InsertTargetVpnGatewayHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setTargetVpnGatewayResource(targetVpnGatewayResource)
            .build();
    return insertTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   Operation response = targetVpnGatewayClient.insertTargetVpnGateway(region.toString(), targetVpnGatewayResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param targetVpnGatewayResource Represents a Target VPN gateway resource. (== resource_for
   *     beta.targetVpnGateways ==) (== resource_for v1.targetVpnGateways ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetVpnGateway(
      String region, TargetVpnGateway targetVpnGatewayResource) {

    InsertTargetVpnGatewayHttpRequest request =
        InsertTargetVpnGatewayHttpRequest.newBuilder()
            .setRegion(region)
            .setTargetVpnGatewayResource(targetVpnGatewayResource)
            .build();
    return insertTargetVpnGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   InsertTargetVpnGatewayHttpRequest request = InsertTargetVpnGatewayHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setTargetVpnGatewayResource(targetVpnGatewayResource)
   *     .build();
   *   Operation response = targetVpnGatewayClient.insertTargetVpnGateway(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetVpnGateway(InsertTargetVpnGatewayHttpRequest request) {
    return insertTargetVpnGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target VPN gateway in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetVpnGateway targetVpnGatewayResource = TargetVpnGateway.newBuilder().build();
   *   InsertTargetVpnGatewayHttpRequest request = InsertTargetVpnGatewayHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setTargetVpnGatewayResource(targetVpnGatewayResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetVpnGatewayClient.insertTargetVpnGatewayCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertTargetVpnGatewayHttpRequest, Operation>
      insertTargetVpnGatewayCallable() {
    return stub.insertTargetVpnGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetVpnGateway element : targetVpnGatewayClient.listTargetVpnGateways(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetVpnGatewaysPagedResponse listTargetVpnGateways(ProjectRegionName region) {
    ListTargetVpnGatewaysHttpRequest request =
        ListTargetVpnGatewaysHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listTargetVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetVpnGateway element : targetVpnGatewayClient.listTargetVpnGateways(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetVpnGatewaysPagedResponse listTargetVpnGateways(String region) {
    ListTargetVpnGatewaysHttpRequest request =
        ListTargetVpnGatewaysHttpRequest.newBuilder().setRegion(region).build();
    return listTargetVpnGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListTargetVpnGatewaysHttpRequest request = ListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (TargetVpnGateway element : targetVpnGatewayClient.listTargetVpnGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetVpnGatewaysPagedResponse listTargetVpnGateways(
      ListTargetVpnGatewaysHttpRequest request) {
    return listTargetVpnGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListTargetVpnGatewaysHttpRequest request = ListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListTargetVpnGatewaysPagedResponse&gt; future = targetVpnGatewayClient.listTargetVpnGatewaysPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetVpnGateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListTargetVpnGatewaysHttpRequest, ListTargetVpnGatewaysPagedResponse>
      listTargetVpnGatewaysPagedCallable() {
    return stub.listTargetVpnGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target VPN gateways available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListTargetVpnGatewaysHttpRequest request = ListTargetVpnGatewaysHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     TargetVpnGatewayList response = targetVpnGatewayClient.listTargetVpnGatewaysCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>
      listTargetVpnGatewaysCallable() {
    return stub.listTargetVpnGatewaysCallable();
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

  public static class AggregatedListTargetVpnGatewaysPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayAggregatedList,
          TargetVpnGatewaysScopedList,
          AggregatedListTargetVpnGatewaysPage,
          AggregatedListTargetVpnGatewaysFixedSizeCollection> {

    public static ApiFuture<AggregatedListTargetVpnGatewaysPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysHttpRequest,
                TargetVpnGatewayAggregatedList,
                TargetVpnGatewaysScopedList>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      ApiFuture<AggregatedListTargetVpnGatewaysPage> futurePage =
          AggregatedListTargetVpnGatewaysPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListTargetVpnGatewaysPage, AggregatedListTargetVpnGatewaysPagedResponse>() {
            @Override
            public AggregatedListTargetVpnGatewaysPagedResponse apply(
                AggregatedListTargetVpnGatewaysPage input) {
              return new AggregatedListTargetVpnGatewaysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListTargetVpnGatewaysPagedResponse(AggregatedListTargetVpnGatewaysPage page) {
      super(page, AggregatedListTargetVpnGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListTargetVpnGatewaysPage
      extends AbstractPage<
          AggregatedListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayAggregatedList,
          TargetVpnGatewaysScopedList,
          AggregatedListTargetVpnGatewaysPage> {

    private AggregatedListTargetVpnGatewaysPage(
        PageContext<
                AggregatedListTargetVpnGatewaysHttpRequest,
                TargetVpnGatewayAggregatedList,
                TargetVpnGatewaysScopedList>
            context,
        TargetVpnGatewayAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListTargetVpnGatewaysPage createEmptyPage() {
      return new AggregatedListTargetVpnGatewaysPage(null, null);
    }

    @Override
    protected AggregatedListTargetVpnGatewaysPage createPage(
        PageContext<
                AggregatedListTargetVpnGatewaysHttpRequest,
                TargetVpnGatewayAggregatedList,
                TargetVpnGatewaysScopedList>
            context,
        TargetVpnGatewayAggregatedList response) {
      return new AggregatedListTargetVpnGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListTargetVpnGatewaysPage> createPageAsync(
        PageContext<
                AggregatedListTargetVpnGatewaysHttpRequest,
                TargetVpnGatewayAggregatedList,
                TargetVpnGatewaysScopedList>
            context,
        ApiFuture<TargetVpnGatewayAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListTargetVpnGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayAggregatedList,
          TargetVpnGatewaysScopedList,
          AggregatedListTargetVpnGatewaysPage,
          AggregatedListTargetVpnGatewaysFixedSizeCollection> {

    private AggregatedListTargetVpnGatewaysFixedSizeCollection(
        List<AggregatedListTargetVpnGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListTargetVpnGatewaysFixedSizeCollection createEmptyCollection() {
      return new AggregatedListTargetVpnGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListTargetVpnGatewaysFixedSizeCollection createCollection(
        List<AggregatedListTargetVpnGatewaysPage> pages, int collectionSize) {
      return new AggregatedListTargetVpnGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetVpnGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayList,
          TargetVpnGateway,
          ListTargetVpnGatewaysPage,
          ListTargetVpnGatewaysFixedSizeCollection> {

    public static ApiFuture<ListTargetVpnGatewaysPagedResponse> createAsync(
        PageContext<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList, TargetVpnGateway>
            context,
        ApiFuture<TargetVpnGatewayList> futureResponse) {
      ApiFuture<ListTargetVpnGatewaysPage> futurePage =
          ListTargetVpnGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTargetVpnGatewaysPage, ListTargetVpnGatewaysPagedResponse>() {
            @Override
            public ListTargetVpnGatewaysPagedResponse apply(ListTargetVpnGatewaysPage input) {
              return new ListTargetVpnGatewaysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTargetVpnGatewaysPagedResponse(ListTargetVpnGatewaysPage page) {
      super(page, ListTargetVpnGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetVpnGatewaysPage
      extends AbstractPage<
          ListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayList,
          TargetVpnGateway,
          ListTargetVpnGatewaysPage> {

    private ListTargetVpnGatewaysPage(
        PageContext<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList, TargetVpnGateway>
            context,
        TargetVpnGatewayList response) {
      super(context, response);
    }

    private static ListTargetVpnGatewaysPage createEmptyPage() {
      return new ListTargetVpnGatewaysPage(null, null);
    }

    @Override
    protected ListTargetVpnGatewaysPage createPage(
        PageContext<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList, TargetVpnGateway>
            context,
        TargetVpnGatewayList response) {
      return new ListTargetVpnGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetVpnGatewaysPage> createPageAsync(
        PageContext<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList, TargetVpnGateway>
            context,
        ApiFuture<TargetVpnGatewayList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetVpnGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayList,
          TargetVpnGateway,
          ListTargetVpnGatewaysPage,
          ListTargetVpnGatewaysFixedSizeCollection> {

    private ListTargetVpnGatewaysFixedSizeCollection(
        List<ListTargetVpnGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetVpnGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListTargetVpnGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetVpnGatewaysFixedSizeCollection createCollection(
        List<ListTargetVpnGatewaysPage> pages, int collectionSize) {
      return new ListTargetVpnGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }
}
