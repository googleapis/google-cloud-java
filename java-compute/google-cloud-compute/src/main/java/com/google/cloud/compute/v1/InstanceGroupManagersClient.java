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
import com.google.cloud.compute.v1.stub.InstanceGroupManagersStub;
import com.google.cloud.compute.v1.stub.InstanceGroupManagersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The InstanceGroupManagers API.
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
 * try (InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instanceGroupManager = "instanceGroupManager-388242077";
 *   InstanceGroupManager response =
 *       instanceGroupManagersClient.get(project, zone, instanceGroupManager);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InstanceGroupManagersClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of InstanceGroupManagersSettings
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
 * InstanceGroupManagersSettings instanceGroupManagersSettings =
 *     InstanceGroupManagersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create(instanceGroupManagersSettings);
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
 * InstanceGroupManagersSettings instanceGroupManagersSettings =
 *     InstanceGroupManagersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create(instanceGroupManagersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InstanceGroupManagersClient implements BackgroundResource {
  private final InstanceGroupManagersSettings settings;
  private final InstanceGroupManagersStub stub;

  /** Constructs an instance of InstanceGroupManagersClient with default settings. */
  public static final InstanceGroupManagersClient create() throws IOException {
    return create(InstanceGroupManagersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupManagersClient create(InstanceGroupManagersSettings settings)
      throws IOException {
    return new InstanceGroupManagersClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InstanceGroupManagersSettings).
   */
  public static final InstanceGroupManagersClient create(InstanceGroupManagersStub stub) {
    return new InstanceGroupManagersClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InstanceGroupManagersClient(InstanceGroupManagersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupManagersStubSettings) settings.getStubSettings()).createStub();
  }

  protected InstanceGroupManagersClient(InstanceGroupManagersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupManagersSettings getSettings() {
    return settings;
  }

  public InstanceGroupManagersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersAbandonInstancesRequest
   *       instanceGroupManagersAbandonInstancesRequestResource =
   *           InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .abandonInstancesAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersAbandonInstancesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> abandonInstancesAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {
    AbandonInstancesInstanceGroupManagerRequest request =
        AbandonInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AbandonInstancesInstanceGroupManagerRequest request =
   *       AbandonInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersAbandonInstancesRequestResource(
   *               InstanceGroupManagersAbandonInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.abandonInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> abandonInstancesAsync(
      AbandonInstancesInstanceGroupManagerRequest request) {
    return abandonInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AbandonInstancesInstanceGroupManagerRequest request =
   *       AbandonInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersAbandonInstancesRequestResource(
   *               InstanceGroupManagersAbandonInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.abandonInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable() {
    return stub.abandonInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AbandonInstancesInstanceGroupManagerRequest request =
   *       AbandonInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersAbandonInstancesRequestResource(
   *               InstanceGroupManagersAbandonInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.abandonInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return stub.abandonInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, InstanceGroupManagersScopedList> element :
   *       instanceGroupManagersClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInstanceGroupManagersRequest request =
        AggregatedListInstanceGroupManagersRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AggregatedListInstanceGroupManagersRequest request =
   *       AggregatedListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, InstanceGroupManagersScopedList> element :
   *       instanceGroupManagersClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListInstanceGroupManagersRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AggregatedListInstanceGroupManagersRequest request =
   *       AggregatedListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, InstanceGroupManagersScopedList>> future =
   *       instanceGroupManagersClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, InstanceGroupManagersScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   AggregatedListInstanceGroupManagersRequest request =
   *       AggregatedListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InstanceGroupManagerAggregatedList response =
   *         instanceGroupManagersClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, InstanceGroupManagersScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource =
   *       InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .applyUpdatesToInstancesAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersApplyUpdatesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. Should conform to
   *     RFC1035.
   * @param instanceGroupManager The name of the managed instance group, should conform to RFC1035.
   * @param instanceGroupManagersApplyUpdatesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> applyUpdatesToInstancesAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource) {
    ApplyUpdatesToInstancesInstanceGroupManagerRequest request =
        ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersApplyUpdatesRequestResource(
                instanceGroupManagersApplyUpdatesRequestResource)
            .build();
    return applyUpdatesToInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ApplyUpdatesToInstancesInstanceGroupManagerRequest request =
   *       ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersApplyUpdatesRequestResource(
   *               InstanceGroupManagersApplyUpdatesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.applyUpdatesToInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> applyUpdatesToInstancesAsync(
      ApplyUpdatesToInstancesInstanceGroupManagerRequest request) {
    return applyUpdatesToInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ApplyUpdatesToInstancesInstanceGroupManagerRequest request =
   *       ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersApplyUpdatesRequestResource(
   *               InstanceGroupManagersApplyUpdatesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient
   *           .applyUpdatesToInstancesOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable() {
    return stub.applyUpdatesToInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ApplyUpdatesToInstancesInstanceGroupManagerRequest request =
   *       ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersApplyUpdatesRequestResource(
   *               InstanceGroupManagersApplyUpdatesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.applyUpdatesToInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return stub.applyUpdatesToInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates instances with per-instance configurations in this managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersCreateInstancesRequest
   *       instanceGroupManagersCreateInstancesRequestResource =
   *           InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .createInstancesAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersCreateInstancesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersCreateInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> createInstancesAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersCreateInstancesRequest
          instanceGroupManagersCreateInstancesRequestResource) {
    CreateInstancesInstanceGroupManagerRequest request =
        CreateInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersCreateInstancesRequestResource(
                instanceGroupManagersCreateInstancesRequestResource)
            .build();
    return createInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates instances with per-instance configurations in this managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   CreateInstancesInstanceGroupManagerRequest request =
   *       CreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersCreateInstancesRequestResource(
   *               InstanceGroupManagersCreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.createInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> createInstancesAsync(
      CreateInstancesInstanceGroupManagerRequest request) {
    return createInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates instances with per-instance configurations in this managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   CreateInstancesInstanceGroupManagerRequest request =
   *       CreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersCreateInstancesRequestResource(
   *               InstanceGroupManagersCreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.createInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable() {
    return stub.createInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates instances with per-instance configurations in this managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   CreateInstancesInstanceGroupManagerRequest request =
   *       CreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersCreateInstancesRequestResource(
   *               InstanceGroupManagersCreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.createInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return stub.createInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   Operation response =
   *       instanceGroupManagersClient.deleteAsync(project, zone, instanceGroupManager).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String instanceGroupManager) {
    DeleteInstanceGroupManagerRequest request =
        DeleteInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstanceGroupManagerRequest request =
   *       DeleteInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteInstanceGroupManagerRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstanceGroupManagerRequest request =
   *       DeleteInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstanceGroupManagerRequest request =
   *       DeleteInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersDeleteInstancesRequest
   *       instanceGroupManagersDeleteInstancesRequestResource =
   *           InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .deleteInstancesAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersDeleteInstancesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteInstancesAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {
    DeleteInstancesInstanceGroupManagerRequest request =
        DeleteInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstancesInstanceGroupManagerRequest request =
   *       DeleteInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeleteInstancesRequestResource(
   *               InstanceGroupManagersDeleteInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.deleteInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteInstancesAsync(
      DeleteInstancesInstanceGroupManagerRequest request) {
    return deleteInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstancesInstanceGroupManagerRequest request =
   *       DeleteInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeleteInstancesRequestResource(
   *               InstanceGroupManagersDeleteInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.deleteInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable() {
    return stub.deleteInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method. If the group is part of a backend service that has enabled
   * connection draining, it can take up to 60 seconds after the connection draining duration has
   * elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000
   * instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeleteInstancesInstanceGroupManagerRequest request =
   *       DeleteInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeleteInstancesRequestResource(
   *               InstanceGroupManagersDeleteInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.deleteInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return stub.deleteInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes selected per-instance configurations for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersDeletePerInstanceConfigsReq
   *       instanceGroupManagersDeletePerInstanceConfigsReqResource =
   *           InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .deletePerInstanceConfigsAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersDeletePerInstanceConfigsReqResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersDeletePerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deletePerInstanceConfigsAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersDeletePerInstanceConfigsReq
          instanceGroupManagersDeletePerInstanceConfigsReqResource) {
    DeletePerInstanceConfigsInstanceGroupManagerRequest request =
        DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
                instanceGroupManagersDeletePerInstanceConfigsReqResource)
            .build();
    return deletePerInstanceConfigsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes selected per-instance configurations for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeletePerInstanceConfigsInstanceGroupManagerRequest request =
   *       DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
   *               InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.deletePerInstanceConfigsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deletePerInstanceConfigsAsync(
      DeletePerInstanceConfigsInstanceGroupManagerRequest request) {
    return deletePerInstanceConfigsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes selected per-instance configurations for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeletePerInstanceConfigsInstanceGroupManagerRequest request =
   *       DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
   *               InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient
   *           .deletePerInstanceConfigsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable() {
    return stub.deletePerInstanceConfigsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes selected per-instance configurations for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   DeletePerInstanceConfigsInstanceGroupManagerRequest request =
   *       DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
   *               InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.deletePerInstanceConfigsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return stub.deletePerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManager response =
   *       instanceGroupManagersClient.get(project, zone, instanceGroupManager);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(String project, String zone, String instanceGroupManager) {
    GetInstanceGroupManagerRequest request =
        GetInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   GetInstanceGroupManagerRequest request =
   *       GetInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   InstanceGroupManager response = instanceGroupManagersClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(GetInstanceGroupManagerRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   GetInstanceGroupManagerRequest request =
   *       GetInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceGroupManager> future =
   *       instanceGroupManagersClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceGroupManager response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method. A managed instance group can have up to 1000 VM instances
   * per group. Please contact Cloud Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .insertAsync(project, zone, instanceGroupManagerResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, InstanceGroupManager instanceGroupManagerResource) {
    InsertInstanceGroupManagerRequest request =
        InsertInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method. A managed instance group can have up to 1000 VM instances
   * per group. Please contact Cloud Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   InsertInstanceGroupManagerRequest request =
   *       InsertInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertInstanceGroupManagerRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method. A managed instance group can have up to 1000 VM instances
   * per group. Please contact Cloud Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   InsertInstanceGroupManagerRequest request =
   *       InsertInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method. A managed instance group can have up to 1000 VM instances
   * per group. Please contact Cloud Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   InsertInstanceGroupManagerRequest request =
   *       InsertInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (InstanceGroupManager element :
   *       instanceGroupManagersClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListInstanceGroupManagersRequest request =
        ListInstanceGroupManagersRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListInstanceGroupManagersRequest request =
   *       ListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (InstanceGroupManager element : instanceGroupManagersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstanceGroupManagersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListInstanceGroupManagersRequest request =
   *       ListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceGroupManager> future =
   *       instanceGroupManagersClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListInstanceGroupManagersRequest request =
   *       ListInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceGroupManagerList response =
   *         instanceGroupManagersClient.listCallable().call(request);
   *     for (InstanceGroupManager element : response.getItemsList()) {
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
  public final UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   for (InstanceManagedByIgmError element :
   *       instanceGroupManagersClient
   *           .listErrors(project, zone, instanceGroupManager)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It must be a string that
   *     meets the requirements in RFC1035, or an unsigned long integer: must match regexp pattern:
   *     (?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)|1-9{0,19}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(
      String project, String zone, String instanceGroupManager) {
    ListErrorsInstanceGroupManagersRequest request =
        ListErrorsInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListErrorsInstanceGroupManagersRequest request =
   *       ListErrorsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (InstanceManagedByIgmError element :
   *       instanceGroupManagersClient.listErrors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(ListErrorsInstanceGroupManagersRequest request) {
    return listErrorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListErrorsInstanceGroupManagersRequest request =
   *       ListErrorsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstanceManagedByIgmError> future =
   *       instanceGroupManagersClient.listErrorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceManagedByIgmError element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return stub.listErrorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListErrorsInstanceGroupManagersRequest request =
   *       ListErrorsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceGroupManagersListErrorsResponse response =
   *         instanceGroupManagersClient.listErrorsCallable().call(request);
   *     for (InstanceManagedByIgmError element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return stub.listErrorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported. The `pageToken` query parameter is supported only in
   * the alpha and beta API and only if the group's `listManagedInstancesResults` field is set to
   * `PAGINATED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   for (ManagedInstance element :
   *       instanceGroupManagersClient
   *           .listManagedInstances(project, zone, instanceGroupManager)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      String project, String zone, String instanceGroupManager) {
    ListManagedInstancesInstanceGroupManagersRequest request =
        ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported. The `pageToken` query parameter is supported only in
   * the alpha and beta API and only if the group's `listManagedInstancesResults` field is set to
   * `PAGINATED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListManagedInstancesInstanceGroupManagersRequest request =
   *       ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (ManagedInstance element :
   *       instanceGroupManagersClient.listManagedInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      ListManagedInstancesInstanceGroupManagersRequest request) {
    return listManagedInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported. The `pageToken` query parameter is supported only in
   * the alpha and beta API and only if the group's `listManagedInstancesResults` field is set to
   * `PAGINATED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListManagedInstancesInstanceGroupManagersRequest request =
   *       ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ManagedInstance> future =
   *       instanceGroupManagersClient.listManagedInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagedInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return stub.listManagedInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported. The `pageToken` query parameter is supported only in
   * the alpha and beta API and only if the group's `listManagedInstancesResults` field is set to
   * `PAGINATED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListManagedInstancesInstanceGroupManagersRequest request =
   *       ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceGroupManagersListManagedInstancesResponse response =
   *         instanceGroupManagersClient.listManagedInstancesCallable().call(request);
   *     for (ManagedInstance element : response.getManagedInstancesList()) {
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
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable() {
    return stub.listManagedInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the per-instance configurations defined for the managed instance group. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   for (PerInstanceConfig element :
   *       instanceGroupManagersClient
   *           .listPerInstanceConfigs(project, zone, instanceGroupManager)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      String project, String zone, String instanceGroupManager) {
    ListPerInstanceConfigsInstanceGroupManagersRequest request =
        ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listPerInstanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the per-instance configurations defined for the managed instance group. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request =
   *       ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (PerInstanceConfig element :
   *       instanceGroupManagersClient.listPerInstanceConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      ListPerInstanceConfigsInstanceGroupManagersRequest request) {
    return listPerInstanceConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the per-instance configurations defined for the managed instance group. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request =
   *       ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<PerInstanceConfig> future =
   *       instanceGroupManagersClient.listPerInstanceConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PerInstanceConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return stub.listPerInstanceConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the per-instance configurations defined for the managed instance group. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request =
   *       ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceGroupManagersListPerInstanceConfigsResp response =
   *         instanceGroupManagersClient.listPerInstanceConfigsCallable().call(request);
   *     for (PerInstanceConfig element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return stub.listPerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules. If you update your group to specify a new
   * template or instance configuration, it's possible that your intended specification for each VM
   * in the group is different from the current state of that VM. To learn how to apply an updated
   * configuration to the VMs in a MIG, see Updating instances in a MIG.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .patchAsync(project, zone, instanceGroupManager, instanceGroupManagerResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource) {
    PatchInstanceGroupManagerRequest request =
        PatchInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules. If you update your group to specify a new
   * template or instance configuration, it's possible that your intended specification for each VM
   * in the group is different from the current state of that VM. To learn how to apply an updated
   * configuration to the VMs in a MIG, see Updating instances in a MIG.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchInstanceGroupManagerRequest request =
   *       PatchInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchInstanceGroupManagerRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules. If you update your group to specify a new
   * template or instance configuration, it's possible that your intended specification for each VM
   * in the group is different from the current state of that VM. To learn how to apply an updated
   * configuration to the VMs in a MIG, see Updating instances in a MIG.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchInstanceGroupManagerRequest request =
   *       PatchInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules. If you update your group to specify a new
   * template or instance configuration, it's possible that your intended specification for each VM
   * in the group is different from the current state of that VM. To learn how to apply an updated
   * configuration to the VMs in a MIG, see Updating instances in a MIG.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchInstanceGroupManagerRequest request =
   *       PatchInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagerResource(InstanceGroupManager.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instanceGroupManagersClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or patches per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersPatchPerInstanceConfigsReq
   *       instanceGroupManagersPatchPerInstanceConfigsReqResource =
   *           InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .patchPerInstanceConfigsAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersPatchPerInstanceConfigsReqResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersPatchPerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchPerInstanceConfigsAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersPatchPerInstanceConfigsReq
          instanceGroupManagersPatchPerInstanceConfigsReqResource) {
    PatchPerInstanceConfigsInstanceGroupManagerRequest request =
        PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
                instanceGroupManagersPatchPerInstanceConfigsReqResource)
            .build();
    return patchPerInstanceConfigsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or patches per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchPerInstanceConfigsInstanceGroupManagerRequest request =
   *       PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
   *               InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.patchPerInstanceConfigsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchPerInstanceConfigsAsync(
      PatchPerInstanceConfigsInstanceGroupManagerRequest request) {
    return patchPerInstanceConfigsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or patches per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchPerInstanceConfigsInstanceGroupManagerRequest request =
   *       PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
   *               InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient
   *           .patchPerInstanceConfigsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable() {
    return stub.patchPerInstanceConfigsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or patches per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   PatchPerInstanceConfigsInstanceGroupManagerRequest request =
   *       PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
   *               InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.patchPerInstanceConfigsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return stub.patchPerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified VM instances in the managed instance group to be immediately recreated.
   * Each instance is recreated using the group's current configuration. This operation is marked as
   * DONE when the flag is set even if the instances have not yet been recreated. You must
   * separately verify the status of each instance by checking its currentAction field; for more
   * information, see Checking the status of managed instances. If the group is part of a backend
   * service that has enabled connection draining, it can take up to 60 seconds after the connection
   * draining duration has elapsed before the VM instance is removed or deleted. You can specify a
   * maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersRecreateInstancesRequest
   *       instanceGroupManagersRecreateInstancesRequestResource =
   *           InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .recreateInstancesAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersRecreateInstancesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> recreateInstancesAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {
    RecreateInstancesInstanceGroupManagerRequest request =
        RecreateInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
            .build();
    return recreateInstancesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified VM instances in the managed instance group to be immediately recreated.
   * Each instance is recreated using the group's current configuration. This operation is marked as
   * DONE when the flag is set even if the instances have not yet been recreated. You must
   * separately verify the status of each instance by checking its currentAction field; for more
   * information, see Checking the status of managed instances. If the group is part of a backend
   * service that has enabled connection draining, it can take up to 60 seconds after the connection
   * draining duration has elapsed before the VM instance is removed or deleted. You can specify a
   * maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   RecreateInstancesInstanceGroupManagerRequest request =
   *       RecreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersRecreateInstancesRequestResource(
   *               InstanceGroupManagersRecreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.recreateInstancesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> recreateInstancesAsync(
      RecreateInstancesInstanceGroupManagerRequest request) {
    return recreateInstancesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified VM instances in the managed instance group to be immediately recreated.
   * Each instance is recreated using the group's current configuration. This operation is marked as
   * DONE when the flag is set even if the instances have not yet been recreated. You must
   * separately verify the status of each instance by checking its currentAction field; for more
   * information, see Checking the status of managed instances. If the group is part of a backend
   * service that has enabled connection draining, it can take up to 60 seconds after the connection
   * draining duration has elapsed before the VM instance is removed or deleted. You can specify a
   * maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   RecreateInstancesInstanceGroupManagerRequest request =
   *       RecreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersRecreateInstancesRequestResource(
   *               InstanceGroupManagersRecreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.recreateInstancesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable() {
    return stub.recreateInstancesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Flags the specified VM instances in the managed instance group to be immediately recreated.
   * Each instance is recreated using the group's current configuration. This operation is marked as
   * DONE when the flag is set even if the instances have not yet been recreated. You must
   * separately verify the status of each instance by checking its currentAction field; for more
   * information, see Checking the status of managed instances. If the group is part of a backend
   * service that has enabled connection draining, it can take up to 60 seconds after the connection
   * draining duration has elapsed before the VM instance is removed or deleted. You can specify a
   * maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   RecreateInstancesInstanceGroupManagerRequest request =
   *       RecreateInstancesInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersRecreateInstancesRequestResource(
   *               InstanceGroupManagersRecreateInstancesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.recreateInstancesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return stub.recreateInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method. When resizing down, the instance group
   * arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM
   * attributes when making the selection including: + The status of the VM instance. + The health
   * of the VM instance. + The instance template version the VM is based on. + For regional managed
   * instance groups, the location of the VM instance. This list is subject to change. If the group
   * is part of a backend service that has enabled connection draining, it can take up to 60 seconds
   * after the connection draining duration has elapsed before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   int size = 3530753;
   *   Operation response =
   *       instanceGroupManagersClient.resizeAsync(project, zone, instanceGroupManager, size).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> resizeAsync(
      String project, String zone, String instanceGroupManager, int size) {
    ResizeInstanceGroupManagerRequest request =
        ResizeInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setSize(size)
            .build();
    return resizeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method. When resizing down, the instance group
   * arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM
   * attributes when making the selection including: + The status of the VM instance. + The health
   * of the VM instance. + The instance template version the VM is based on. + For regional managed
   * instance groups, the location of the VM instance. This list is subject to change. If the group
   * is part of a backend service that has enabled connection draining, it can take up to 60 seconds
   * after the connection draining duration has elapsed before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ResizeInstanceGroupManagerRequest request =
   *       ResizeInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSize(3530753)
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.resizeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> resizeAsync(
      ResizeInstanceGroupManagerRequest request) {
    return resizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method. When resizing down, the instance group
   * arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM
   * attributes when making the selection including: + The status of the VM instance. + The health
   * of the VM instance. + The instance template version the VM is based on. + For regional managed
   * instance groups, the location of the VM instance. This list is subject to change. If the group
   * is part of a backend service that has enabled connection draining, it can take up to 60 seconds
   * after the connection draining duration has elapsed before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ResizeInstanceGroupManagerRequest request =
   *       ResizeInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSize(3530753)
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.resizeOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResizeInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable() {
    return stub.resizeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method. When resizing down, the instance group
   * arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM
   * attributes when making the selection including: + The status of the VM instance. + The health
   * of the VM instance. + The instance template version the VM is based on. + For regional managed
   * instance groups, the location of the VM instance. This list is subject to change. If the group
   * is part of a backend service that has enabled connection draining, it can take up to 60 seconds
   * after the connection draining duration has elapsed before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   ResizeInstanceGroupManagerRequest request =
   *       ResizeInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSize(3530753)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.resizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersSetInstanceTemplateRequest
   *       instanceGroupManagersSetInstanceTemplateRequestResource =
   *           InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .setInstanceTemplateAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersSetInstanceTemplateRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setInstanceTemplateAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {
    SetInstanceTemplateInstanceGroupManagerRequest request =
        SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetInstanceTemplateInstanceGroupManagerRequest request =
   *       SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetInstanceTemplateRequestResource(
   *               InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.setInstanceTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setInstanceTemplateAsync(
      SetInstanceTemplateInstanceGroupManagerRequest request) {
    return setInstanceTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetInstanceTemplateInstanceGroupManagerRequest request =
   *       SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetInstanceTemplateRequestResource(
   *               InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.setInstanceTemplateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable() {
    return stub.setInstanceTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetInstanceTemplateInstanceGroupManagerRequest request =
   *       SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetInstanceTemplateRequestResource(
   *               InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.setInstanceTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return stub.setInstanceTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersSetTargetPoolsRequest
   *       instanceGroupManagersSetTargetPoolsRequestResource =
   *           InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .setTargetPoolsAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersSetTargetPoolsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setTargetPoolsAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {
    SetTargetPoolsInstanceGroupManagerRequest request =
        SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetTargetPoolsInstanceGroupManagerRequest request =
   *       SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetTargetPoolsRequestResource(
   *               InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.setTargetPoolsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setTargetPoolsAsync(
      SetTargetPoolsInstanceGroupManagerRequest request) {
    return setTargetPoolsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetTargetPoolsInstanceGroupManagerRequest request =
   *       SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetTargetPoolsRequestResource(
   *               InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient.setTargetPoolsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable() {
    return stub.setTargetPoolsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   SetTargetPoolsInstanceGroupManagerRequest request =
   *       SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersSetTargetPoolsRequestResource(
   *               InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.setTargetPoolsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return stub.setTargetPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or updates per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instanceGroupManager = "instanceGroupManager-388242077";
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq
   *       instanceGroupManagersUpdatePerInstanceConfigsReqResource =
   *           InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   Operation response =
   *       instanceGroupManagersClient
   *           .updatePerInstanceConfigsAsync(
   *               project,
   *               zone,
   *               instanceGroupManager,
   *               instanceGroupManagersUpdatePerInstanceConfigsReqResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersUpdatePerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updatePerInstanceConfigsAsync(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersUpdatePerInstanceConfigsReq
          instanceGroupManagersUpdatePerInstanceConfigsReqResource) {
    UpdatePerInstanceConfigsInstanceGroupManagerRequest request =
        UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
                instanceGroupManagersUpdatePerInstanceConfigsReqResource)
            .build();
    return updatePerInstanceConfigsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or updates per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   UpdatePerInstanceConfigsInstanceGroupManagerRequest request =
   *       UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
   *               InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instanceGroupManagersClient.updatePerInstanceConfigsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updatePerInstanceConfigsAsync(
      UpdatePerInstanceConfigsInstanceGroupManagerRequest request) {
    return updatePerInstanceConfigsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or updates per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   UpdatePerInstanceConfigsInstanceGroupManagerRequest request =
   *       UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
   *               InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       instanceGroupManagersClient
   *           .updatePerInstanceConfigsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable() {
    return stub.updatePerInstanceConfigsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts or updates per-instance configurations for the managed instance group.
   * perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InstanceGroupManagersClient instanceGroupManagersClient =
   *     InstanceGroupManagersClient.create()) {
   *   UpdatePerInstanceConfigsInstanceGroupManagerRequest request =
   *       UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *           .setInstanceGroupManager("instanceGroupManager-388242077")
   *           .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
   *               InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instanceGroupManagersClient.updatePerInstanceConfigsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    return stub.updatePerInstanceConfigsCallable();
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
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Map.Entry<String, InstanceGroupManagersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Map.Entry<String, InstanceGroupManagersScopedList>>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
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
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Map.Entry<String, InstanceGroupManagersScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Map.Entry<String, InstanceGroupManagersScopedList>>
            context,
        InstanceGroupManagerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Map.Entry<String, InstanceGroupManagersScopedList>>
            context,
        InstanceGroupManagerAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Map.Entry<String, InstanceGroupManagersScopedList>>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Map.Entry<String, InstanceGroupManagersScopedList>,
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
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
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
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListPage> {

    private ListPage(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
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

  public static class ListErrorsPagedResponse
      extends AbstractPagedListResponse<
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage,
          ListErrorsFixedSizeCollection> {

    public static ApiFuture<ListErrorsPagedResponse> createAsync(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
      ApiFuture<ListErrorsPage> futurePage =
          ListErrorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListErrorsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListErrorsPagedResponse(ListErrorsPage page) {
      super(page, ListErrorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListErrorsPage
      extends AbstractPage<
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage> {

    private ListErrorsPage(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      super(context, response);
    }

    private static ListErrorsPage createEmptyPage() {
      return new ListErrorsPage(null, null);
    }

    @Override
    protected ListErrorsPage createPage(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      return new ListErrorsPage(context, response);
    }

    @Override
    public ApiFuture<ListErrorsPage> createPageAsync(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListErrorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage,
          ListErrorsFixedSizeCollection> {

    private ListErrorsFixedSizeCollection(List<ListErrorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListErrorsFixedSizeCollection createEmptyCollection() {
      return new ListErrorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListErrorsFixedSizeCollection createCollection(
        List<ListErrorsPage> pages, int collectionSize) {
      return new ListErrorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListManagedInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage,
          ListManagedInstancesFixedSizeCollection> {

    public static ApiFuture<ListManagedInstancesPagedResponse> createAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
      ApiFuture<ListManagedInstancesPage> futurePage =
          ListManagedInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListManagedInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListManagedInstancesPagedResponse(ListManagedInstancesPage page) {
      super(page, ListManagedInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagedInstancesPage
      extends AbstractPage<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage> {

    private ListManagedInstancesPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      super(context, response);
    }

    private static ListManagedInstancesPage createEmptyPage() {
      return new ListManagedInstancesPage(null, null);
    }

    @Override
    protected ListManagedInstancesPage createPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      return new ListManagedInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListManagedInstancesPage> createPageAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagedInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage,
          ListManagedInstancesFixedSizeCollection> {

    private ListManagedInstancesFixedSizeCollection(
        List<ListManagedInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagedInstancesFixedSizeCollection createEmptyCollection() {
      return new ListManagedInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagedInstancesFixedSizeCollection createCollection(
        List<ListManagedInstancesPage> pages, int collectionSize) {
      return new ListManagedInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPerInstanceConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage,
          ListPerInstanceConfigsFixedSizeCollection> {

    public static ApiFuture<ListPerInstanceConfigsPagedResponse> createAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
      ApiFuture<ListPerInstanceConfigsPage> futurePage =
          ListPerInstanceConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPerInstanceConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPerInstanceConfigsPagedResponse(ListPerInstanceConfigsPage page) {
      super(page, ListPerInstanceConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPerInstanceConfigsPage
      extends AbstractPage<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage> {

    private ListPerInstanceConfigsPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      super(context, response);
    }

    private static ListPerInstanceConfigsPage createEmptyPage() {
      return new ListPerInstanceConfigsPage(null, null);
    }

    @Override
    protected ListPerInstanceConfigsPage createPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      return new ListPerInstanceConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListPerInstanceConfigsPage> createPageAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPerInstanceConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage,
          ListPerInstanceConfigsFixedSizeCollection> {

    private ListPerInstanceConfigsFixedSizeCollection(
        List<ListPerInstanceConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPerInstanceConfigsFixedSizeCollection createEmptyCollection() {
      return new ListPerInstanceConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPerInstanceConfigsFixedSizeCollection createCollection(
        List<ListPerInstanceConfigsPage> pages, int collectionSize) {
      return new ListPerInstanceConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
