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

package com.google.cloud.baremetalsolution.v2;

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
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStub;
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Performs management operations on Bare Metal Solution servers.
 *
 * <p>The `baremetalsolution.googleapis.com` service provides management capabilities for Bare Metal
 * Solution servers. To access the API methods, you must assign Bare Metal Solution IAM roles
 * containing the desired permissions to your staff in your Google Cloud project. You must also
 * enable the Bare Metal Solution API. Once enabled, the methods act upon specific servers in your
 * Bare Metal Solution environment.
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
 * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = bareMetalSolutionClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BareMetalSolutionClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of BareMetalSolutionSettings to
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             BareMetalSolutionSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BareMetalSolutionClient implements BackgroundResource {
  private final BareMetalSolutionSettings settings;
  private final BareMetalSolutionStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BareMetalSolutionClient with default settings. */
  public static final BareMetalSolutionClient create() throws IOException {
    return create(BareMetalSolutionSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BareMetalSolutionClient create(BareMetalSolutionSettings settings)
      throws IOException {
    return new BareMetalSolutionClient(settings);
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(BareMetalSolutionSettings).
   */
  public static final BareMetalSolutionClient create(BareMetalSolutionStub stub) {
    return new BareMetalSolutionClient(stub);
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BareMetalSolutionClient(BareMetalSolutionSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BareMetalSolutionStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BareMetalSolutionClient(BareMetalSolutionStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BareMetalSolutionSettings getSettings() {
    return settings;
  }

  public BareMetalSolutionStub getStub() {
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
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : bareMetalSolutionClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : bareMetalSolutionClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Instance element : bareMetalSolutionClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Instance> future =
   *       bareMetalSolutionClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response =
   *         bareMetalSolutionClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = bareMetalSolutionClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = bareMetalSolutionClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = bareMetalSolutionClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future =
   *       bareMetalSolutionClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = bareMetalSolutionClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The server to update.
   *     <p>The `name` field is used to identify the instance to update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param updateMask The list of fields to update. The currently supported fields are: `labels`
   *     `hyperthreading_enabled` `os_image`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Instance response = bareMetalSolutionClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       bareMetalSolutionClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      InstanceName name) {
    ResetInstanceRequest request =
        ResetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resetInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      String name) {
    ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName(name).build();
    return resetInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      ResetInstanceRequest request) {
    return resetInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<ResetInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.resetInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   ResetInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    return stub.resetInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.resetInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return stub.resetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      InstanceName name) {
    StartInstanceRequest request =
        StartInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      String name) {
    StartInstanceRequest request = StartInstanceRequest.newBuilder().setName(name).build();
    return startInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      StartInstanceRequest request) {
    return startInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<StartInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.startInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   StartInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable() {
    return stub.startInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.startInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    return stub.startInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      InstanceName name) {
    StopInstanceRequest request =
        StopInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      String name) {
    StopInstanceRequest request = StopInstanceRequest.newBuilder().setName(name).build();
    return stopInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      StopInstanceRequest request) {
    return stopInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<StopInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.stopInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   StopInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable() {
    return stub.stopInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.stopInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    return stub.stopInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      InstanceName instance, LunName lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setLun(lun == null ? null : lun.toString())
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      InstanceName instance, String lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setLun(lun)
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      String instance, LunName lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance)
            .setLun(lun == null ? null : lun.toString())
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      String instance, String lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder().setInstance(instance).setLun(lun).build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      DetachLunRequest request) {
    return detachLunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       bareMetalSolutionClient.detachLunOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    return stub.detachLunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   ApiFuture<Operation> future = bareMetalSolutionClient.detachLunCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    return stub.detachLunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Volume element : bareMetalSolutionClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(LocationName parent) {
    ListVolumesRequest request =
        ListVolumesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Volume element : bareMetalSolutionClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(String parent) {
    ListVolumesRequest request = ListVolumesRequest.newBuilder().setParent(parent).build();
    return listVolumes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Volume element : bareMetalSolutionClient.listVolumes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(ListVolumesRequest request) {
    return listVolumesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Volume> future =
   *       bareMetalSolutionClient.listVolumesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Volume element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable() {
    return stub.listVolumesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListVolumesResponse response = bareMetalSolutionClient.listVolumesCallable().call(request);
   *     for (Volume element : response.getVolumesList()) {
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
  public final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable() {
    return stub.listVolumesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   Volume response = bareMetalSolutionClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(VolumeName name) {
    GetVolumeRequest request =
        GetVolumeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   Volume response = bareMetalSolutionClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(String name) {
    GetVolumeRequest request = GetVolumeRequest.newBuilder().setName(name).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   Volume response = bareMetalSolutionClient.getVolume(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(GetVolumeRequest request) {
    return getVolumeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   ApiFuture<Volume> future = bareMetalSolutionClient.getVolumeCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable() {
    return stub.getVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Volume volume = Volume.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Volume response = bareMetalSolutionClient.updateVolumeAsync(volume, updateMask).get();
   * }
   * }</pre>
   *
   * @param volume Required. The volume to update.
   *     <p>The `name` field is used to identify the volume to update. Format:
   *     projects/{project}/locations/{location}/volumes/{volume}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     `snapshot_auto_delete_behavior` `snapshot_schedule_policy_name` 'labels' 'snapshot_enabled'
   *     'snapshot_reservation_detail.reserved_space_percent'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> updateVolumeAsync(
      Volume volume, FieldMask updateMask) {
    UpdateVolumeRequest request =
        UpdateVolumeRequest.newBuilder().setVolume(volume).setUpdateMask(updateMask).build();
    return updateVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Volume response = bareMetalSolutionClient.updateVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> updateVolumeAsync(
      UpdateVolumeRequest request) {
    return updateVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       bareMetalSolutionClient.updateVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable() {
    return stub.updateVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable() {
    return stub.updateVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   long sizeGib = 847296130;
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(volume, sizeGib).get();
   * }
   * }</pre>
   *
   * @param volume Required. Volume to resize.
   * @param sizeGib New Volume size, in GiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      VolumeName volume, long sizeGib) {
    ResizeVolumeRequest request =
        ResizeVolumeRequest.newBuilder()
            .setVolume(volume == null ? null : volume.toString())
            .setSizeGib(sizeGib)
            .build();
    return resizeVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   long sizeGib = 847296130;
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(volume, sizeGib).get();
   * }
   * }</pre>
   *
   * @param volume Required. Volume to resize.
   * @param sizeGib New Volume size, in GiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      String volume, long sizeGib) {
    ResizeVolumeRequest request =
        ResizeVolumeRequest.newBuilder().setVolume(volume).setSizeGib(sizeGib).build();
    return resizeVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      ResizeVolumeRequest request) {
    return resizeVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       bareMetalSolutionClient.resizeVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationCallable() {
    return stub.resizeVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.resizeVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResizeVolumeRequest, Operation> resizeVolumeCallable() {
    return stub.resizeVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Network element : bareMetalSolutionClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(LocationName parent) {
    ListNetworksRequest request =
        ListNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Network element : bareMetalSolutionClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(String parent) {
    ListNetworksRequest request = ListNetworksRequest.newBuilder().setParent(parent).build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Network element : bareMetalSolutionClient.listNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(ListNetworksRequest request) {
    return listNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Network> future =
   *       bareMetalSolutionClient.listNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Network element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable() {
    return stub.listNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNetworksResponse response =
   *         bareMetalSolutionClient.listNetworksCallable().call(request);
   *     for (Network element : response.getNetworksList()) {
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
  public final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return stub.listNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(location);
   * }
   * }</pre>
   *
   * @param location Required. Parent value (project and location).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(LocationName location) {
    ListNetworkUsageRequest request =
        ListNetworkUsageRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .build();
    return listNetworkUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(location);
   * }
   * }</pre>
   *
   * @param location Required. Parent value (project and location).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(String location) {
    ListNetworkUsageRequest request =
        ListNetworkUsageRequest.newBuilder().setLocation(location).build();
    return listNetworkUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworkUsageRequest request =
   *       ListNetworkUsageRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(ListNetworkUsageRequest request) {
    return listNetworkUsageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworkUsageRequest request =
   *       ListNetworkUsageRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListNetworkUsageResponse> future =
   *       bareMetalSolutionClient.listNetworkUsageCallable().futureCall(request);
   *   // Do something.
   *   ListNetworkUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageCallable() {
    return stub.listNetworkUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
   *   Network response = bareMetalSolutionClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(NetworkName name) {
    GetNetworkRequest request =
        GetNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString();
   *   Network response = bareMetalSolutionClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(String name) {
    GetNetworkRequest request = GetNetworkRequest.newBuilder().setName(name).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .build();
   *   Network response = bareMetalSolutionClient.getNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(GetNetworkRequest request) {
    return getNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .build();
   *   ApiFuture<Network> future = bareMetalSolutionClient.getNetworkCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return stub.getNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Network network = Network.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Network response = bareMetalSolutionClient.updateNetworkAsync(network, updateMask).get();
   * }
   * }</pre>
   *
   * @param network Required. The network to update.
   *     <p>The `name` field is used to identify the instance to update. Format:
   *     projects/{project}/locations/{location}/networks/{network}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     `labels`, `reservations`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> updateNetworkAsync(
      Network network, FieldMask updateMask) {
    UpdateNetworkRequest request =
        UpdateNetworkRequest.newBuilder().setNetwork(network).setUpdateMask(updateMask).build();
    return updateNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Network response = bareMetalSolutionClient.updateNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> updateNetworkAsync(
      UpdateNetworkRequest request) {
    return updateNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Network, OperationMetadata> future =
   *       bareMetalSolutionClient.updateNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationCallable() {
    return stub.updateNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkRequest, Operation> updateNetworkCallable() {
    return stub.updateNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Lun response = bareMetalSolutionClient.getLun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(LunName name) {
    GetLunRequest request =
        GetLunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Lun response = bareMetalSolutionClient.getLun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(String name) {
    GetLunRequest request = GetLunRequest.newBuilder().setName(name).build();
    return getLun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLunRequest request =
   *       GetLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   Lun response = bareMetalSolutionClient.getLun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(GetLunRequest request) {
    return getLunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLunRequest request =
   *       GetLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   ApiFuture<Lun> future = bareMetalSolutionClient.getLunCallable().futureCall(request);
   *   // Do something.
   *   Lun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLunRequest, Lun> getLunCallable() {
    return stub.getLunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (Lun element : bareMetalSolutionClient.listLuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListLunsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(VolumeName parent) {
    ListLunsRequest request =
        ListLunsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (Lun element : bareMetalSolutionClient.listLuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListLunsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(String parent) {
    ListLunsRequest request = ListLunsRequest.newBuilder().setParent(parent).build();
    return listLuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Lun element : bareMetalSolutionClient.listLuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(ListLunsRequest request) {
    return listLunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Lun> future = bareMetalSolutionClient.listLunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Lun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable() {
    return stub.listLunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLunsResponse response = bareMetalSolutionClient.listLunsCallable().call(request);
   *     for (Lun element : response.getLunsList()) {
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
  public final UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable() {
    return stub.listLunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(NFSShareName name) {
    GetNfsShareRequest request =
        GetNfsShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString();
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(String name) {
    GetNfsShareRequest request = GetNfsShareRequest.newBuilder().setName(name).build();
    return getNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNfsShareRequest request =
   *       GetNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(GetNfsShareRequest request) {
    return getNfsShareCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNfsShareRequest request =
   *       GetNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   ApiFuture<NfsShare> future =
   *       bareMetalSolutionClient.getNfsShareCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable() {
    return stub.getNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNfsSharesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(LocationName parent) {
    ListNfsSharesRequest request =
        ListNfsSharesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNfsShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNfsSharesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(String parent) {
    ListNfsSharesRequest request = ListNfsSharesRequest.newBuilder().setParent(parent).build();
    return listNfsShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(ListNfsSharesRequest request) {
    return listNfsSharesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<NfsShare> future =
   *       bareMetalSolutionClient.listNfsSharesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NfsShare element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable() {
    return stub.listNfsSharesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNfsSharesResponse response =
   *         bareMetalSolutionClient.listNfsSharesCallable().call(request);
   *     for (NfsShare element : response.getNfsSharesList()) {
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
  public final UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable() {
    return stub.listNfsSharesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NfsShare nfsShare = NfsShare.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NfsShare response = bareMetalSolutionClient.updateNfsShareAsync(nfsShare, updateMask).get();
   * }
   * }</pre>
   *
   * @param nfsShare Required. The NFS share to update.
   *     <p>The `name` field is used to identify the NFS share to update. Format:
   *     projects/{project}/locations/{location}/nfsShares/{nfs_share}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     `labels`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> updateNfsShareAsync(
      NfsShare nfsShare, FieldMask updateMask) {
    UpdateNfsShareRequest request =
        UpdateNfsShareRequest.newBuilder().setNfsShare(nfsShare).setUpdateMask(updateMask).build();
    return updateNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.updateNfsShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> updateNfsShareAsync(
      UpdateNfsShareRequest request) {
    return updateNfsShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<NfsShare, OperationMetadata> future =
   *       bareMetalSolutionClient.updateNfsShareOperationCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable() {
    return stub.updateNfsShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateNfsShareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable() {
    return stub.updateNfsShareCallable();
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumesPagedResponse
      extends AbstractPagedListResponse<
          ListVolumesRequest,
          ListVolumesResponse,
          Volume,
          ListVolumesPage,
          ListVolumesFixedSizeCollection> {

    public static ApiFuture<ListVolumesPagedResponse> createAsync(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ApiFuture<ListVolumesResponse> futureResponse) {
      ApiFuture<ListVolumesPage> futurePage =
          ListVolumesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListVolumesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListVolumesPagedResponse(ListVolumesPage page) {
      super(page, ListVolumesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumesPage
      extends AbstractPage<ListVolumesRequest, ListVolumesResponse, Volume, ListVolumesPage> {

    private ListVolumesPage(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ListVolumesResponse response) {
      super(context, response);
    }

    private static ListVolumesPage createEmptyPage() {
      return new ListVolumesPage(null, null);
    }

    @Override
    protected ListVolumesPage createPage(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ListVolumesResponse response) {
      return new ListVolumesPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumesPage> createPageAsync(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ApiFuture<ListVolumesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumesRequest,
          ListVolumesResponse,
          Volume,
          ListVolumesPage,
          ListVolumesFixedSizeCollection> {

    private ListVolumesFixedSizeCollection(List<ListVolumesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumesFixedSizeCollection createEmptyCollection() {
      return new ListVolumesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumesFixedSizeCollection createCollection(
        List<ListVolumesPage> pages, int collectionSize) {
      return new ListVolumesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    public static ApiFuture<ListNetworksPagedResponse> createAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      ApiFuture<ListNetworksPage> futurePage =
          ListNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworksPagedResponse(ListNetworksPage page) {
      super(page, ListNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworksPage
      extends AbstractPage<ListNetworksRequest, ListNetworksResponse, Network, ListNetworksPage> {

    private ListNetworksPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      super(context, response);
    }

    private static ListNetworksPage createEmptyPage() {
      return new ListNetworksPage(null, null);
    }

    @Override
    protected ListNetworksPage createPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      return new ListNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworksPage> createPageAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    private ListNetworksFixedSizeCollection(List<ListNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworksFixedSizeCollection createEmptyCollection() {
      return new ListNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworksFixedSizeCollection createCollection(
        List<ListNetworksPage> pages, int collectionSize) {
      return new ListNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLunsPagedResponse
      extends AbstractPagedListResponse<
          ListLunsRequest, ListLunsResponse, Lun, ListLunsPage, ListLunsFixedSizeCollection> {

    public static ApiFuture<ListLunsPagedResponse> createAsync(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context,
        ApiFuture<ListLunsResponse> futureResponse) {
      ApiFuture<ListLunsPage> futurePage =
          ListLunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLunsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLunsPagedResponse(ListLunsPage page) {
      super(page, ListLunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLunsPage
      extends AbstractPage<ListLunsRequest, ListLunsResponse, Lun, ListLunsPage> {

    private ListLunsPage(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context, ListLunsResponse response) {
      super(context, response);
    }

    private static ListLunsPage createEmptyPage() {
      return new ListLunsPage(null, null);
    }

    @Override
    protected ListLunsPage createPage(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context, ListLunsResponse response) {
      return new ListLunsPage(context, response);
    }

    @Override
    public ApiFuture<ListLunsPage> createPageAsync(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context,
        ApiFuture<ListLunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLunsRequest, ListLunsResponse, Lun, ListLunsPage, ListLunsFixedSizeCollection> {

    private ListLunsFixedSizeCollection(List<ListLunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLunsFixedSizeCollection createEmptyCollection() {
      return new ListLunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLunsFixedSizeCollection createCollection(
        List<ListLunsPage> pages, int collectionSize) {
      return new ListLunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNfsSharesPagedResponse
      extends AbstractPagedListResponse<
          ListNfsSharesRequest,
          ListNfsSharesResponse,
          NfsShare,
          ListNfsSharesPage,
          ListNfsSharesFixedSizeCollection> {

    public static ApiFuture<ListNfsSharesPagedResponse> createAsync(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ApiFuture<ListNfsSharesResponse> futureResponse) {
      ApiFuture<ListNfsSharesPage> futurePage =
          ListNfsSharesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNfsSharesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNfsSharesPagedResponse(ListNfsSharesPage page) {
      super(page, ListNfsSharesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNfsSharesPage
      extends AbstractPage<
          ListNfsSharesRequest, ListNfsSharesResponse, NfsShare, ListNfsSharesPage> {

    private ListNfsSharesPage(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ListNfsSharesResponse response) {
      super(context, response);
    }

    private static ListNfsSharesPage createEmptyPage() {
      return new ListNfsSharesPage(null, null);
    }

    @Override
    protected ListNfsSharesPage createPage(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ListNfsSharesResponse response) {
      return new ListNfsSharesPage(context, response);
    }

    @Override
    public ApiFuture<ListNfsSharesPage> createPageAsync(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ApiFuture<ListNfsSharesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNfsSharesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNfsSharesRequest,
          ListNfsSharesResponse,
          NfsShare,
          ListNfsSharesPage,
          ListNfsSharesFixedSizeCollection> {

    private ListNfsSharesFixedSizeCollection(List<ListNfsSharesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNfsSharesFixedSizeCollection createEmptyCollection() {
      return new ListNfsSharesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNfsSharesFixedSizeCollection createCollection(
        List<ListNfsSharesPage> pages, int collectionSize) {
      return new ListNfsSharesFixedSizeCollection(pages, collectionSize);
    }
  }
}
