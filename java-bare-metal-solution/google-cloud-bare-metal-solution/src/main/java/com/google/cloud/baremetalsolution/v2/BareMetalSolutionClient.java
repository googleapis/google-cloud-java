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
import com.google.api.gax.core.BackgroundResource;
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
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
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
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
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
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
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
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder().setEndpoint(myEndpoint).build();
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
  private final OperationsClient operationsClient;

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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected BareMetalSolutionClient(BareMetalSolutionStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
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
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response =
   *         bareMetalSolutionClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getResponsesList()) {
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVolumesResponse response = bareMetalSolutionClient.listVolumesCallable().call(request);
   *     for (Volume element : response.getResponsesList()) {
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   *     `snapshot_auto_delete_behavior` `snapshot_schedule_policy_name`
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNetworksResponse response =
   *         bareMetalSolutionClient.listNetworksCallable().call(request);
   *     for (Network element : response.getResponsesList()) {
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
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * List snapshot schedule policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SnapshotSchedulePolicy element :
   *       bareMetalSolutionClient.listSnapshotSchedulePolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project containing the Snapshot Schedule Policies.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotSchedulePoliciesPagedResponse listSnapshotSchedulePolicies(
      LocationName parent) {
    ListSnapshotSchedulePoliciesRequest request =
        ListSnapshotSchedulePoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSnapshotSchedulePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List snapshot schedule policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SnapshotSchedulePolicy element :
   *       bareMetalSolutionClient.listSnapshotSchedulePolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project containing the Snapshot Schedule Policies.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotSchedulePoliciesPagedResponse listSnapshotSchedulePolicies(
      String parent) {
    ListSnapshotSchedulePoliciesRequest request =
        ListSnapshotSchedulePoliciesRequest.newBuilder().setParent(parent).build();
    return listSnapshotSchedulePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List snapshot schedule policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSnapshotSchedulePoliciesRequest request =
   *       ListSnapshotSchedulePoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SnapshotSchedulePolicy element :
   *       bareMetalSolutionClient.listSnapshotSchedulePolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotSchedulePoliciesPagedResponse listSnapshotSchedulePolicies(
      ListSnapshotSchedulePoliciesRequest request) {
    return listSnapshotSchedulePoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List snapshot schedule policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSnapshotSchedulePoliciesRequest request =
   *       ListSnapshotSchedulePoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SnapshotSchedulePolicy> future =
   *       bareMetalSolutionClient.listSnapshotSchedulePoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SnapshotSchedulePolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesPagedCallable() {
    return stub.listSnapshotSchedulePoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List snapshot schedule policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSnapshotSchedulePoliciesRequest request =
   *       ListSnapshotSchedulePoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSnapshotSchedulePoliciesResponse response =
   *         bareMetalSolutionClient.listSnapshotSchedulePoliciesCallable().call(request);
   *     for (SnapshotSchedulePolicy element : response.getResponsesList()) {
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
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
      listSnapshotSchedulePoliciesCallable() {
    return stub.listSnapshotSchedulePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SnapshotSchedulePolicyName name =
   *       SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");
   *   SnapshotSchedulePolicy response = bareMetalSolutionClient.getSnapshotSchedulePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy getSnapshotSchedulePolicy(SnapshotSchedulePolicyName name) {
    GetSnapshotSchedulePolicyRequest request =
        GetSnapshotSchedulePolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *           .toString();
   *   SnapshotSchedulePolicy response = bareMetalSolutionClient.getSnapshotSchedulePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy getSnapshotSchedulePolicy(String name) {
    GetSnapshotSchedulePolicyRequest request =
        GetSnapshotSchedulePolicyRequest.newBuilder().setName(name).build();
    return getSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetSnapshotSchedulePolicyRequest request =
   *       GetSnapshotSchedulePolicyRequest.newBuilder()
   *           .setName(
   *               SnapshotSchedulePolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *                   .toString())
   *           .build();
   *   SnapshotSchedulePolicy response = bareMetalSolutionClient.getSnapshotSchedulePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy getSnapshotSchedulePolicy(
      GetSnapshotSchedulePolicyRequest request) {
    return getSnapshotSchedulePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetSnapshotSchedulePolicyRequest request =
   *       GetSnapshotSchedulePolicyRequest.newBuilder()
   *           .setName(
   *               SnapshotSchedulePolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SnapshotSchedulePolicy> future =
   *       bareMetalSolutionClient.getSnapshotSchedulePolicyCallable().futureCall(request);
   *   // Do something.
   *   SnapshotSchedulePolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicyCallable() {
    return stub.getSnapshotSchedulePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
   *   String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";
   *   SnapshotSchedulePolicy response =
   *       bareMetalSolutionClient.createSnapshotSchedulePolicy(
   *           parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the SnapshotSchedulePolicy.
   * @param snapshotSchedulePolicy Required. The SnapshotSchedulePolicy to create.
   * @param snapshotSchedulePolicyId Required. Snapshot policy ID
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy createSnapshotSchedulePolicy(
      LocationName parent,
      SnapshotSchedulePolicy snapshotSchedulePolicy,
      String snapshotSchedulePolicyId) {
    CreateSnapshotSchedulePolicyRequest request =
        CreateSnapshotSchedulePolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSnapshotSchedulePolicy(snapshotSchedulePolicy)
            .setSnapshotSchedulePolicyId(snapshotSchedulePolicyId)
            .build();
    return createSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
   *   String snapshotSchedulePolicyId = "snapshotSchedulePolicyId1929948040";
   *   SnapshotSchedulePolicy response =
   *       bareMetalSolutionClient.createSnapshotSchedulePolicy(
   *           parent, snapshotSchedulePolicy, snapshotSchedulePolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the SnapshotSchedulePolicy.
   * @param snapshotSchedulePolicy Required. The SnapshotSchedulePolicy to create.
   * @param snapshotSchedulePolicyId Required. Snapshot policy ID
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy createSnapshotSchedulePolicy(
      String parent,
      SnapshotSchedulePolicy snapshotSchedulePolicy,
      String snapshotSchedulePolicyId) {
    CreateSnapshotSchedulePolicyRequest request =
        CreateSnapshotSchedulePolicyRequest.newBuilder()
            .setParent(parent)
            .setSnapshotSchedulePolicy(snapshotSchedulePolicy)
            .setSnapshotSchedulePolicyId(snapshotSchedulePolicyId)
            .build();
    return createSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateSnapshotSchedulePolicyRequest request =
   *       CreateSnapshotSchedulePolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSnapshotSchedulePolicy(SnapshotSchedulePolicy.newBuilder().build())
   *           .setSnapshotSchedulePolicyId("snapshotSchedulePolicyId1929948040")
   *           .build();
   *   SnapshotSchedulePolicy response =
   *       bareMetalSolutionClient.createSnapshotSchedulePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy createSnapshotSchedulePolicy(
      CreateSnapshotSchedulePolicyRequest request) {
    return createSnapshotSchedulePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateSnapshotSchedulePolicyRequest request =
   *       CreateSnapshotSchedulePolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSnapshotSchedulePolicy(SnapshotSchedulePolicy.newBuilder().build())
   *           .setSnapshotSchedulePolicyId("snapshotSchedulePolicyId1929948040")
   *           .build();
   *   ApiFuture<SnapshotSchedulePolicy> future =
   *       bareMetalSolutionClient.createSnapshotSchedulePolicyCallable().futureCall(request);
   *   // Do something.
   *   SnapshotSchedulePolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicyCallable() {
    return stub.createSnapshotSchedulePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SnapshotSchedulePolicy snapshotSchedulePolicy = SnapshotSchedulePolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SnapshotSchedulePolicy response =
   *       bareMetalSolutionClient.updateSnapshotSchedulePolicy(snapshotSchedulePolicy, updateMask);
   * }
   * }</pre>
   *
   * @param snapshotSchedulePolicy Required. The snapshot schedule policy to update.
   *     <p>The `name` field is used to identify the snapshot schedule policy to update. Format:
   *     projects/{project}/locations/global/snapshotSchedulePolicies/{policy}
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy updateSnapshotSchedulePolicy(
      SnapshotSchedulePolicy snapshotSchedulePolicy, FieldMask updateMask) {
    UpdateSnapshotSchedulePolicyRequest request =
        UpdateSnapshotSchedulePolicyRequest.newBuilder()
            .setSnapshotSchedulePolicy(snapshotSchedulePolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateSnapshotSchedulePolicyRequest request =
   *       UpdateSnapshotSchedulePolicyRequest.newBuilder()
   *           .setSnapshotSchedulePolicy(SnapshotSchedulePolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SnapshotSchedulePolicy response =
   *       bareMetalSolutionClient.updateSnapshotSchedulePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SnapshotSchedulePolicy updateSnapshotSchedulePolicy(
      UpdateSnapshotSchedulePolicyRequest request) {
    return updateSnapshotSchedulePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a snapshot schedule policy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateSnapshotSchedulePolicyRequest request =
   *       UpdateSnapshotSchedulePolicyRequest.newBuilder()
   *           .setSnapshotSchedulePolicy(SnapshotSchedulePolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SnapshotSchedulePolicy> future =
   *       bareMetalSolutionClient.updateSnapshotSchedulePolicyCallable().futureCall(request);
   *   // Do something.
   *   SnapshotSchedulePolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicyCallable() {
    return stub.updateSnapshotSchedulePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a named snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SnapshotSchedulePolicyName name =
   *       SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]");
   *   bareMetalSolutionClient.deleteSnapshotSchedulePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot schedule policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshotSchedulePolicy(SnapshotSchedulePolicyName name) {
    DeleteSnapshotSchedulePolicyRequest request =
        DeleteSnapshotSchedulePolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a named snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       SnapshotSchedulePolicyName.of("[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *           .toString();
   *   bareMetalSolutionClient.deleteSnapshotSchedulePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot schedule policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshotSchedulePolicy(String name) {
    DeleteSnapshotSchedulePolicyRequest request =
        DeleteSnapshotSchedulePolicyRequest.newBuilder().setName(name).build();
    deleteSnapshotSchedulePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a named snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteSnapshotSchedulePolicyRequest request =
   *       DeleteSnapshotSchedulePolicyRequest.newBuilder()
   *           .setName(
   *               SnapshotSchedulePolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *                   .toString())
   *           .build();
   *   bareMetalSolutionClient.deleteSnapshotSchedulePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshotSchedulePolicy(DeleteSnapshotSchedulePolicyRequest request) {
    deleteSnapshotSchedulePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a named snapshot schedule policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteSnapshotSchedulePolicyRequest request =
   *       DeleteSnapshotSchedulePolicyRequest.newBuilder()
   *           .setName(
   *               SnapshotSchedulePolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SNAPSHOT_SCHEDULE_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       bareMetalSolutionClient.deleteSnapshotSchedulePolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicyCallable() {
    return stub.deleteSnapshotSchedulePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a storage volume snapshot in a containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.createVolumeSnapshot(parent, volumeSnapshot);
   * }
   * }</pre>
   *
   * @param parent Required. The volume to snapshot.
   * @param volumeSnapshot Required. The volume snapshot to create. Only the description field may
   *     be specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(
      VolumeName parent, VolumeSnapshot volumeSnapshot) {
    CreateVolumeSnapshotRequest request =
        CreateVolumeSnapshotRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVolumeSnapshot(volumeSnapshot)
            .build();
    return createVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a storage volume snapshot in a containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.createVolumeSnapshot(parent, volumeSnapshot);
   * }
   * }</pre>
   *
   * @param parent Required. The volume to snapshot.
   * @param volumeSnapshot Required. The volume snapshot to create. Only the description field may
   *     be specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(String parent, VolumeSnapshot volumeSnapshot) {
    CreateVolumeSnapshotRequest request =
        CreateVolumeSnapshotRequest.newBuilder()
            .setParent(parent)
            .setVolumeSnapshot(volumeSnapshot)
            .build();
    return createVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a storage volume snapshot in a containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateVolumeSnapshotRequest request =
   *       CreateVolumeSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setVolumeSnapshot(VolumeSnapshot.newBuilder().build())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.createVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(CreateVolumeSnapshotRequest request) {
    return createVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a storage volume snapshot in a containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateVolumeSnapshotRequest request =
   *       CreateVolumeSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setVolumeSnapshot(VolumeSnapshot.newBuilder().build())
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.createVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotCallable() {
    return stub.createVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a storage volume snapshot to its containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName volumeSnapshot =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.restoreVolumeSnapshotAsync(volumeSnapshot).get();
   * }
   * }</pre>
   *
   * @param volumeSnapshot Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      VolumeSnapshotName volumeSnapshot) {
    RestoreVolumeSnapshotRequest request =
        RestoreVolumeSnapshotRequest.newBuilder()
            .setVolumeSnapshot(volumeSnapshot == null ? null : volumeSnapshot.toString())
            .build();
    return restoreVolumeSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a storage volume snapshot to its containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String volumeSnapshot =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.restoreVolumeSnapshotAsync(volumeSnapshot).get();
   * }
   * }</pre>
   *
   * @param volumeSnapshot Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      String volumeSnapshot) {
    RestoreVolumeSnapshotRequest request =
        RestoreVolumeSnapshotRequest.newBuilder().setVolumeSnapshot(volumeSnapshot).build();
    return restoreVolumeSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a storage volume snapshot to its containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.restoreVolumeSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      RestoreVolumeSnapshotRequest request) {
    return restoreVolumeSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a storage volume snapshot to its containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<VolumeSnapshot, OperationMetadata> future =
   *       bareMetalSolutionClient.restoreVolumeSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationCallable() {
    return stub.restoreVolumeSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a storage volume snapshot to its containing volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.restoreVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotCallable() {
    return stub.restoreVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a storage volume snapshot for a given volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   bareMetalSolutionClient.deleteVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(VolumeSnapshotName name) {
    DeleteVolumeSnapshotRequest request =
        DeleteVolumeSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a storage volume snapshot for a given volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   bareMetalSolutionClient.deleteVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(String name) {
    DeleteVolumeSnapshotRequest request =
        DeleteVolumeSnapshotRequest.newBuilder().setName(name).build();
    deleteVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a storage volume snapshot for a given volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteVolumeSnapshotRequest request =
   *       DeleteVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   bareMetalSolutionClient.deleteVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(DeleteVolumeSnapshotRequest request) {
    deleteVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a storage volume snapshot for a given volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteVolumeSnapshotRequest request =
   *       DeleteVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       bareMetalSolutionClient.deleteVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotCallable() {
    return stub.deleteVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(VolumeSnapshotName name) {
    GetVolumeSnapshotRequest request =
        GetVolumeSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(String name) {
    GetVolumeSnapshotRequest request = GetVolumeSnapshotRequest.newBuilder().setName(name).build();
    return getVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeSnapshotRequest request =
   *       GetVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(GetVolumeSnapshotRequest request) {
    return getVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeSnapshotRequest request =
   *       GetVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.getVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotCallable() {
    return stub.getVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume snapshots for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(VolumeName parent) {
    ListVolumeSnapshotsRequest request =
        ListVolumeSnapshotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume snapshots for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(String parent) {
    ListVolumeSnapshotsRequest request =
        ListVolumeSnapshotsRequest.newBuilder().setParent(parent).build();
    return listVolumeSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume snapshots for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(
      ListVolumeSnapshotsRequest request) {
    return listVolumeSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume snapshots for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.listVolumeSnapshotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeSnapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsPagedCallable() {
    return stub.listVolumeSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume snapshots for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVolumeSnapshotsResponse response =
   *         bareMetalSolutionClient.listVolumeSnapshotsCallable().call(request);
   *     for (VolumeSnapshot element : response.getResponsesList()) {
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
  public final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsCallable() {
    return stub.listVolumeSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
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
   * // This snippet has been automatically generated for illustrative purposes only.
   * // It may require modifications to work in your environment.
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLunsResponse response = bareMetalSolutionClient.listLunsCallable().call(request);
   *     for (Lun element : response.getResponsesList()) {
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

  public static class ListSnapshotSchedulePoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          SnapshotSchedulePolicy,
          ListSnapshotSchedulePoliciesPage,
          ListSnapshotSchedulePoliciesFixedSizeCollection> {

    public static ApiFuture<ListSnapshotSchedulePoliciesPagedResponse> createAsync(
        PageContext<
                ListSnapshotSchedulePoliciesRequest,
                ListSnapshotSchedulePoliciesResponse,
                SnapshotSchedulePolicy>
            context,
        ApiFuture<ListSnapshotSchedulePoliciesResponse> futureResponse) {
      ApiFuture<ListSnapshotSchedulePoliciesPage> futurePage =
          ListSnapshotSchedulePoliciesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSnapshotSchedulePoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSnapshotSchedulePoliciesPagedResponse(ListSnapshotSchedulePoliciesPage page) {
      super(page, ListSnapshotSchedulePoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnapshotSchedulePoliciesPage
      extends AbstractPage<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          SnapshotSchedulePolicy,
          ListSnapshotSchedulePoliciesPage> {

    private ListSnapshotSchedulePoliciesPage(
        PageContext<
                ListSnapshotSchedulePoliciesRequest,
                ListSnapshotSchedulePoliciesResponse,
                SnapshotSchedulePolicy>
            context,
        ListSnapshotSchedulePoliciesResponse response) {
      super(context, response);
    }

    private static ListSnapshotSchedulePoliciesPage createEmptyPage() {
      return new ListSnapshotSchedulePoliciesPage(null, null);
    }

    @Override
    protected ListSnapshotSchedulePoliciesPage createPage(
        PageContext<
                ListSnapshotSchedulePoliciesRequest,
                ListSnapshotSchedulePoliciesResponse,
                SnapshotSchedulePolicy>
            context,
        ListSnapshotSchedulePoliciesResponse response) {
      return new ListSnapshotSchedulePoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListSnapshotSchedulePoliciesPage> createPageAsync(
        PageContext<
                ListSnapshotSchedulePoliciesRequest,
                ListSnapshotSchedulePoliciesResponse,
                SnapshotSchedulePolicy>
            context,
        ApiFuture<ListSnapshotSchedulePoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnapshotSchedulePoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          SnapshotSchedulePolicy,
          ListSnapshotSchedulePoliciesPage,
          ListSnapshotSchedulePoliciesFixedSizeCollection> {

    private ListSnapshotSchedulePoliciesFixedSizeCollection(
        List<ListSnapshotSchedulePoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnapshotSchedulePoliciesFixedSizeCollection createEmptyCollection() {
      return new ListSnapshotSchedulePoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnapshotSchedulePoliciesFixedSizeCollection createCollection(
        List<ListSnapshotSchedulePoliciesPage> pages, int collectionSize) {
      return new ListSnapshotSchedulePoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage,
          ListVolumeSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListVolumeSnapshotsPagedResponse> createAsync(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
      ApiFuture<ListVolumeSnapshotsPage> futurePage =
          ListVolumeSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeSnapshotsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeSnapshotsPagedResponse(ListVolumeSnapshotsPage page) {
      super(page, ListVolumeSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeSnapshotsPage
      extends AbstractPage<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage> {

    private ListVolumeSnapshotsPage(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ListVolumeSnapshotsResponse response) {
      super(context, response);
    }

    private static ListVolumeSnapshotsPage createEmptyPage() {
      return new ListVolumeSnapshotsPage(null, null);
    }

    @Override
    protected ListVolumeSnapshotsPage createPage(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ListVolumeSnapshotsResponse response) {
      return new ListVolumeSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeSnapshotsPage> createPageAsync(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage,
          ListVolumeSnapshotsFixedSizeCollection> {

    private ListVolumeSnapshotsFixedSizeCollection(
        List<ListVolumeSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListVolumeSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeSnapshotsFixedSizeCollection createCollection(
        List<ListVolumeSnapshotsPage> pages, int collectionSize) {
      return new ListVolumeSnapshotsFixedSizeCollection(pages, collectionSize);
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
}
