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

package com.google.cloud.notebooks.v1;

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
import com.google.cloud.notebooks.v1.stub.NotebookServiceStub;
import com.google.cloud.notebooks.v1.stub.NotebookServiceStubSettings;
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
 * Service Description: API v1 service for Cloud AI Platform Notebooks.
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
 * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
 *   String name = "name3373707";
 *   Instance response = notebookServiceClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NotebookServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of NotebookServiceSettings to
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
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
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
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NotebookServiceClient implements BackgroundResource {
  private final NotebookServiceSettings settings;
  private final NotebookServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of NotebookServiceClient with default settings. */
  public static final NotebookServiceClient create() throws IOException {
    return create(NotebookServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NotebookServiceClient create(NotebookServiceSettings settings)
      throws IOException {
    return new NotebookServiceClient(settings);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NotebookServiceSettings).
   */
  public static final NotebookServiceClient create(NotebookServiceStub stub) {
    return new NotebookServiceClient(stub);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NotebookServiceClient(NotebookServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NotebookServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected NotebookServiceClient(NotebookServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final NotebookServiceSettings getSettings() {
    return settings;
  }

  public NotebookServiceStub getStub() {
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
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Instance element : notebookServiceClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Instance element : notebookServiceClient.listInstances(request).iterateAll()) {
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
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Instance> future =
   *       notebookServiceClient.listInstancesPagedCallable().futureCall(request);
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
   * Lists instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response =
   *         notebookServiceClient.listInstancesCallable().call(request);
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
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Instance response = notebookServiceClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/instances/{instance_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = notebookServiceClient.getInstance(request);
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
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Instance> future = notebookServiceClient.getInstanceCallable().futureCall(request);
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
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response =
   *       notebookServiceClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param instance Required. The instance to be created.
   * @param instanceId Required. User-defined unique ID of this instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   Instance response = notebookServiceClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RegisterInstanceRequest request =
   *       RegisterInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .build();
   *   Instance response = notebookServiceClient.registerInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> registerInstanceAsync(
      RegisterInstanceRequest request) {
    return registerInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RegisterInstanceRequest request =
   *       RegisterInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.registerInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationCallable() {
    return stub.registerInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances
   * are instances created with the legacy Compute Engine calls. They are not manageable by the
   * Notebooks API out of the box. This call makes these instances manageable by the Notebooks API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RegisterInstanceRequest request =
   *       RegisterInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.registerInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterInstanceRequest, Operation> registerInstanceCallable() {
    return stub.registerInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceAcceleratorRequest request =
   *       SetInstanceAcceleratorRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCoreCount(-1963855761)
   *           .build();
   *   Instance response = notebookServiceClient.setInstanceAcceleratorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceAcceleratorAsync(
      SetInstanceAcceleratorRequest request) {
    return setInstanceAcceleratorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceAcceleratorRequest request =
   *       SetInstanceAcceleratorRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCoreCount(-1963855761)
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.setInstanceAcceleratorOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationCallable() {
    return stub.setInstanceAcceleratorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the guest accelerators of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceAcceleratorRequest request =
   *       SetInstanceAcceleratorRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCoreCount(-1963855761)
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.setInstanceAcceleratorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorCallable() {
    return stub.setInstanceAcceleratorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceMachineTypeRequest request =
   *       SetInstanceMachineTypeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .build();
   *   Instance response = notebookServiceClient.setInstanceMachineTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceMachineTypeAsync(
      SetInstanceMachineTypeRequest request) {
    return setInstanceMachineTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceMachineTypeRequest request =
   *       SetInstanceMachineTypeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.setInstanceMachineTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationCallable() {
    return stub.setInstanceMachineTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the machine type of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceMachineTypeRequest request =
   *       SetInstanceMachineTypeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMachineType("machineType-218117087")
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.setInstanceMachineTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeCallable() {
    return stub.setInstanceMachineTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Instance configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateInstanceConfigRequest request =
   *       UpdateInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setConfig(InstanceConfig.newBuilder().build())
   *           .build();
   *   Instance response = notebookServiceClient.updateInstanceConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceConfigAsync(
      UpdateInstanceConfigRequest request) {
    return updateInstanceConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Instance configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateInstanceConfigRequest request =
   *       UpdateInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setConfig(InstanceConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.updateInstanceConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationCallable() {
    return stub.updateInstanceConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Notebook Instance configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateInstanceConfigRequest request =
   *       UpdateInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setConfig(InstanceConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.updateInstanceConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceConfigRequest, Operation>
      updateInstanceConfigCallable() {
    return stub.updateInstanceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded instance configuration of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateShieldedInstanceConfigRequest request =
   *       UpdateShieldedInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
   *           .build();
   *   Instance response = notebookServiceClient.updateShieldedInstanceConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateShieldedInstanceConfigAsync(
      UpdateShieldedInstanceConfigRequest request) {
    return updateShieldedInstanceConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded instance configuration of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateShieldedInstanceConfigRequest request =
   *       UpdateShieldedInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.updateShieldedInstanceConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationCallable() {
    return stub.updateShieldedInstanceConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded instance configuration of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateShieldedInstanceConfigRequest request =
   *       UpdateShieldedInstanceConfigRequest.newBuilder()
   *           .setName("name3373707")
   *           .setShieldedInstanceConfig(Instance.ShieldedInstanceConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.updateShieldedInstanceConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    return stub.updateShieldedInstanceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces all the labels of an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceLabelsRequest request =
   *       SetInstanceLabelsRequest.newBuilder()
   *           .setName("name3373707")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   Instance response = notebookServiceClient.setInstanceLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> setInstanceLabelsAsync(
      SetInstanceLabelsRequest request) {
    return setInstanceLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces all the labels of an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceLabelsRequest request =
   *       SetInstanceLabelsRequest.newBuilder()
   *           .setName("name3373707")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.setInstanceLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationCallable() {
    return stub.setInstanceLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces all the labels of an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetInstanceLabelsRequest request =
   *       SetInstanceLabelsRequest.newBuilder()
   *           .setName("name3373707")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.setInstanceLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetInstanceLabelsRequest, Operation> setInstanceLabelsCallable() {
    return stub.setInstanceLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add/update metadata items for an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateInstanceMetadataItemsRequest request =
   *       UpdateInstanceMetadataItemsRequest.newBuilder()
   *           .setName("name3373707")
   *           .putAllItems(new HashMap<String, String>())
   *           .build();
   *   UpdateInstanceMetadataItemsResponse response =
   *       notebookServiceClient.updateInstanceMetadataItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateInstanceMetadataItemsResponse updateInstanceMetadataItems(
      UpdateInstanceMetadataItemsRequest request) {
    return updateInstanceMetadataItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add/update metadata items for an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpdateInstanceMetadataItemsRequest request =
   *       UpdateInstanceMetadataItemsRequest.newBuilder()
   *           .setName("name3373707")
   *           .putAllItems(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<UpdateInstanceMetadataItemsResponse> future =
   *       notebookServiceClient.updateInstanceMetadataItemsCallable().futureCall(request);
   *   // Do something.
   *   UpdateInstanceMetadataItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsCallable() {
    return stub.updateInstanceMetadataItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   notebookServiceClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/instances/{instance_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   notebookServiceClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       notebookServiceClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = notebookServiceClient.startInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> startInstanceAsync(
      StartInstanceRequest request) {
    return startInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.startInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationCallable() {
    return stub.startInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.startInstanceCallable().futureCall(request);
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
   * Stops a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StopInstanceRequest request = StopInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = notebookServiceClient.stopInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> stopInstanceAsync(
      StopInstanceRequest request) {
    return stopInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StopInstanceRequest request = StopInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.stopInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationCallable() {
    return stub.stopInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StopInstanceRequest request = StopInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.stopInstanceCallable().futureCall(request);
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
   * Resets a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = notebookServiceClient.resetInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> resetInstanceAsync(
      ResetInstanceRequest request) {
    return resetInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.resetInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationCallable() {
    return stub.resetInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a notebook instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.resetInstanceCallable().futureCall(request);
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
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ReportInstanceInfoRequest request =
   *       ReportInstanceInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .putAllMetadata(new HashMap<String, String>())
   *           .build();
   *   Instance response = notebookServiceClient.reportInstanceInfoAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> reportInstanceInfoAsync(
      ReportInstanceInfoRequest request) {
    return reportInstanceInfoOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ReportInstanceInfoRequest request =
   *       ReportInstanceInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .putAllMetadata(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.reportInstanceInfoOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationCallable() {
    return stub.reportInstanceInfoOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to report their latest instance information to the Notebooks API
   * server. The server will merge the reported information to the instance metadata store. Do not
   * use this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ReportInstanceInfoRequest request =
   *       ReportInstanceInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .putAllMetadata(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.reportInstanceInfoCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportInstanceInfoRequest, Operation> reportInstanceInfoCallable() {
    return stub.reportInstanceInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is upgradable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   IsInstanceUpgradeableRequest request =
   *       IsInstanceUpgradeableRequest.newBuilder()
   *           .setNotebookInstance("notebookInstance-544239728")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   IsInstanceUpgradeableResponse response = notebookServiceClient.isInstanceUpgradeable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IsInstanceUpgradeableResponse isInstanceUpgradeable(
      IsInstanceUpgradeableRequest request) {
    return isInstanceUpgradeableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is upgradable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   IsInstanceUpgradeableRequest request =
   *       IsInstanceUpgradeableRequest.newBuilder()
   *           .setNotebookInstance("notebookInstance-544239728")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   ApiFuture<IsInstanceUpgradeableResponse> future =
   *       notebookServiceClient.isInstanceUpgradeableCallable().futureCall(request);
   *   // Do something.
   *   IsInstanceUpgradeableResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableCallable() {
    return stub.isInstanceUpgradeableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is healthy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   GetInstanceHealthResponse response = notebookServiceClient.getInstanceHealth(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/instances/{instance_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetInstanceHealthResponse getInstanceHealth(InstanceName name) {
    GetInstanceHealthRequest request =
        GetInstanceHealthRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInstanceHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is healthy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   GetInstanceHealthResponse response = notebookServiceClient.getInstanceHealth(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/instances/{instance_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetInstanceHealthResponse getInstanceHealth(String name) {
    GetInstanceHealthRequest request = GetInstanceHealthRequest.newBuilder().setName(name).build();
    return getInstanceHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is healthy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetInstanceHealthRequest request =
   *       GetInstanceHealthRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   GetInstanceHealthResponse response = notebookServiceClient.getInstanceHealth(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetInstanceHealthResponse getInstanceHealth(GetInstanceHealthRequest request) {
    return getInstanceHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check if a notebook instance is healthy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetInstanceHealthRequest request =
   *       GetInstanceHealthRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<GetInstanceHealthResponse> future =
   *       notebookServiceClient.getInstanceHealthCallable().futureCall(request);
   *   // Do something.
   *   GetInstanceHealthResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthCallable() {
    return stub.getInstanceHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   Instance response = notebookServiceClient.upgradeInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceAsync(
      UpgradeInstanceRequest request) {
    return upgradeInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.upgradeInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return stub.upgradeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a notebook instance to the latest version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceRequest request =
   *       UpgradeInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.upgradeInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return stub.upgradeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollbacks a notebook instance to the previous version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RollbackInstanceRequest request =
   *       RollbackInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTargetSnapshot("targetSnapshot-1307211147")
   *           .build();
   *   Instance response = notebookServiceClient.rollbackInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> rollbackInstanceAsync(
      RollbackInstanceRequest request) {
    return rollbackInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollbacks a notebook instance to the previous version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RollbackInstanceRequest request =
   *       RollbackInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTargetSnapshot("targetSnapshot-1307211147")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.rollbackInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationCallable() {
    return stub.rollbackInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rollbacks a notebook instance to the previous version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   RollbackInstanceRequest request =
   *       RollbackInstanceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTargetSnapshot("targetSnapshot-1307211147")
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.rollbackInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackInstanceRequest, Operation> rollbackInstanceCallable() {
    return stub.rollbackInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceInternalRequest request =
   *       UpgradeInstanceInternalRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   Instance response = notebookServiceClient.upgradeInstanceInternalAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> upgradeInstanceInternalAsync(
      UpgradeInstanceInternalRequest request) {
    return upgradeInstanceInternalOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceInternalRequest request =
   *       UpgradeInstanceInternalRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       notebookServiceClient.upgradeInstanceInternalOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationCallable() {
    return stub.upgradeInstanceInternalOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeInstanceInternalRequest request =
   *       UpgradeInstanceInternalRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVmId("vmId3622450")
   *           .setType(UpgradeType.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.upgradeInstanceInternalCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalCallable() {
    return stub.upgradeInstanceInternalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Environment element : notebookServiceClient.listEnvironments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(String parent) {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent).build();
    return listEnvironments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Environment element : notebookServiceClient.listEnvironments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnvironmentsPagedResponse listEnvironments(ListEnvironmentsRequest request) {
    return listEnvironmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Environment> future =
   *       notebookServiceClient.listEnvironmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Environment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return stub.listEnvironmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists environments in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListEnvironmentsRequest request =
   *       ListEnvironmentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEnvironmentsResponse response =
   *         notebookServiceClient.listEnvironmentsCallable().call(request);
   *     for (Environment element : response.getEnvironmentsList()) {
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
  public final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return stub.listEnvironmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   Environment response = notebookServiceClient.getEnvironment(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/environments/{environment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(String name) {
    GetEnvironmentRequest request = GetEnvironmentRequest.newBuilder().setName(name).build();
    return getEnvironment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   Environment response = notebookServiceClient.getEnvironment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Environment getEnvironment(GetEnvironmentRequest request) {
    return getEnvironmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetEnvironmentRequest request =
   *       GetEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Environment> future =
   *       notebookServiceClient.getEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return stub.getEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   Environment environment = Environment.newBuilder().build();
   *   String environmentId = "environmentId-950205810";
   *   Environment response =
   *       notebookServiceClient.createEnvironmentAsync(parent, environment, environmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project_id}/locations/{location}`
   * @param environment Required. The environment to be created.
   * @param environmentId Required. User-defined unique ID of this environment. The `environment_id`
   *     must be 1 to 63 characters long and contain only lowercase letters, numeric characters, and
   *     dashes. The first character must be a lowercase letter and the last character cannot be a
   *     dash.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      String parent, Environment environment, String environmentId) {
    CreateEnvironmentRequest request =
        CreateEnvironmentRequest.newBuilder()
            .setParent(parent)
            .setEnvironment(environment)
            .setEnvironmentId(environmentId)
            .build();
    return createEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   Environment response = notebookServiceClient.createEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Environment, OperationMetadata> createEnvironmentAsync(
      CreateEnvironmentRequest request) {
    return createEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   OperationFuture<Environment, OperationMetadata> future =
   *       notebookServiceClient.createEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Environment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return stub.createEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateEnvironmentRequest request =
   *       CreateEnvironmentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setEnvironmentId("environmentId-950205810")
   *           .setEnvironment(Environment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.createEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return stub.createEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = "name3373707";
   *   notebookServiceClient.deleteEnvironmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/environments/{environment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(String name) {
    DeleteEnvironmentRequest request = DeleteEnvironmentRequest.newBuilder().setName(name).build();
    return deleteEnvironmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   notebookServiceClient.deleteEnvironmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEnvironmentAsync(
      DeleteEnvironmentRequest request) {
    return deleteEnvironmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       notebookServiceClient.deleteEnvironmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return stub.deleteEnvironmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Environment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteEnvironmentRequest request =
   *       DeleteEnvironmentRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteEnvironmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return stub.deleteEnvironmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schedules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   for (Schedule element : notebookServiceClient.listSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(ScheduleName parent) {
    ListSchedulesRequest request =
        ListSchedulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schedules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   for (Schedule element : notebookServiceClient.listSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(String parent) {
    ListSchedulesRequest request = ListSchedulesRequest.newBuilder().setParent(parent).build();
    return listSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schedules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Schedule element : notebookServiceClient.listSchedules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(ListSchedulesRequest request) {
    return listSchedulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schedules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Schedule> future =
   *       notebookServiceClient.listSchedulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Schedule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    return stub.listSchedulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schedules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSchedulesResponse response =
   *         notebookServiceClient.listSchedulesCallable().call(request);
   *     for (Schedule element : response.getSchedulesList()) {
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
  public final UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    return stub.listSchedulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of schedule
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   Schedule response = notebookServiceClient.getSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/schedules/{schedule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(ScheduleName name) {
    GetScheduleRequest request =
        GetScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of schedule
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   Schedule response = notebookServiceClient.getSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/schedules/{schedule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(String name) {
    GetScheduleRequest request = GetScheduleRequest.newBuilder().setName(name).build();
    return getSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of schedule
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetScheduleRequest request =
   *       GetScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   Schedule response = notebookServiceClient.getSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(GetScheduleRequest request) {
    return getScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of schedule
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetScheduleRequest request =
   *       GetScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Schedule> future = notebookServiceClient.getScheduleCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    return stub.getScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes schedule and all underlying jobs
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   notebookServiceClient.deleteScheduleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/schedules/{schedule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScheduleAsync(ScheduleName name) {
    DeleteScheduleRequest request =
        DeleteScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes schedule and all underlying jobs
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   notebookServiceClient.deleteScheduleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/schedules/{schedule_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScheduleAsync(String name) {
    DeleteScheduleRequest request = DeleteScheduleRequest.newBuilder().setName(name).build();
    return deleteScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes schedule and all underlying jobs
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   notebookServiceClient.deleteScheduleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScheduleAsync(
      DeleteScheduleRequest request) {
    return deleteScheduleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes schedule and all underlying jobs
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       notebookServiceClient.deleteScheduleOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationCallable() {
    return stub.deleteScheduleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes schedule and all underlying jobs
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    return stub.deleteScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Scheduled Notebook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ScheduleName parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   Schedule schedule = Schedule.newBuilder().build();
   *   String scheduleId = "scheduleId-687058414";
   *   Schedule response =
   *       notebookServiceClient.createScheduleAsync(parent, schedule, scheduleId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param schedule Required. The schedule to be created.
   * @param scheduleId Required. User-defined unique ID of this schedule.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schedule, OperationMetadata> createScheduleAsync(
      ScheduleName parent, Schedule schedule, String scheduleId) {
    CreateScheduleRequest request =
        CreateScheduleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSchedule(schedule)
            .setScheduleId(scheduleId)
            .build();
    return createScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Scheduled Notebook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   Schedule schedule = Schedule.newBuilder().build();
   *   String scheduleId = "scheduleId-687058414";
   *   Schedule response =
   *       notebookServiceClient.createScheduleAsync(parent, schedule, scheduleId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param schedule Required. The schedule to be created.
   * @param scheduleId Required. User-defined unique ID of this schedule.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schedule, OperationMetadata> createScheduleAsync(
      String parent, Schedule schedule, String scheduleId) {
    CreateScheduleRequest request =
        CreateScheduleRequest.newBuilder()
            .setParent(parent)
            .setSchedule(schedule)
            .setScheduleId(scheduleId)
            .build();
    return createScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Scheduled Notebook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateScheduleRequest request =
   *       CreateScheduleRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setScheduleId("scheduleId-687058414")
   *           .setSchedule(Schedule.newBuilder().build())
   *           .build();
   *   Schedule response = notebookServiceClient.createScheduleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schedule, OperationMetadata> createScheduleAsync(
      CreateScheduleRequest request) {
    return createScheduleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Scheduled Notebook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateScheduleRequest request =
   *       CreateScheduleRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setScheduleId("scheduleId-687058414")
   *           .setSchedule(Schedule.newBuilder().build())
   *           .build();
   *   OperationFuture<Schedule, OperationMetadata> future =
   *       notebookServiceClient.createScheduleOperationCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationCallable() {
    return stub.createScheduleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Scheduled Notebook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateScheduleRequest request =
   *       CreateScheduleRequest.newBuilder()
   *           .setParent(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setScheduleId("scheduleId-687058414")
   *           .setSchedule(Schedule.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.createScheduleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScheduleRequest, Operation> createScheduleCallable() {
    return stub.createScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers execution of an existing schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   TriggerScheduleRequest request =
   *       TriggerScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   Schedule response = notebookServiceClient.triggerScheduleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schedule, OperationMetadata> triggerScheduleAsync(
      TriggerScheduleRequest request) {
    return triggerScheduleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers execution of an existing schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   TriggerScheduleRequest request =
   *       TriggerScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   OperationFuture<Schedule, OperationMetadata> future =
   *       notebookServiceClient.triggerScheduleOperationCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationCallable() {
    return stub.triggerScheduleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers execution of an existing schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   TriggerScheduleRequest request =
   *       TriggerScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.triggerScheduleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TriggerScheduleRequest, Operation> triggerScheduleCallable() {
    return stub.triggerScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists executions in a given project and location
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
   *   for (Execution element : notebookServiceClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(ExecutionName parent) {
    ListExecutionsRequest request =
        ListExecutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists executions in a given project and location
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString();
   *   for (Execution element : notebookServiceClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(String parent) {
    ListExecutionsRequest request = ListExecutionsRequest.newBuilder().setParent(parent).build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists executions in a given project and location
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Execution element : notebookServiceClient.listExecutions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(ListExecutionsRequest request) {
    return listExecutionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists executions in a given project and location
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Execution> future =
   *       notebookServiceClient.listExecutionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Execution element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return stub.listExecutionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists executions in a given project and location
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExecutionsResponse response =
   *         notebookServiceClient.listExecutionsCallable().call(request);
   *     for (Execution element : response.getExecutionsList()) {
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
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsCallable() {
    return stub.listExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of executions
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
   *   Execution response = notebookServiceClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/executions/{execution_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(ExecutionName name) {
    GetExecutionRequest request =
        GetExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of executions
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString();
   *   Execution response = notebookServiceClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/executions/{execution_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(String name) {
    GetExecutionRequest request = GetExecutionRequest.newBuilder().setName(name).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of executions
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .build();
   *   Execution response = notebookServiceClient.getExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(GetExecutionRequest request) {
    return getExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of executions
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .build();
   *   ApiFuture<Execution> future =
   *       notebookServiceClient.getExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return stub.getExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes execution
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
   *   notebookServiceClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/executions/{execution_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(ExecutionName name) {
    DeleteExecutionRequest request =
        DeleteExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes execution
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString();
   *   notebookServiceClient.deleteExecutionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Format:
   *     `projects/{project_id}/locations/{location}/executions/{execution_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(String name) {
    DeleteExecutionRequest request = DeleteExecutionRequest.newBuilder().setName(name).build();
    return deleteExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes execution
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .build();
   *   notebookServiceClient.deleteExecutionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExecutionAsync(
      DeleteExecutionRequest request) {
    return deleteExecutionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes execution
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       notebookServiceClient.deleteExecutionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    return stub.deleteExecutionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes execution
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteExecutionRequest request =
   *       DeleteExecutionRequest.newBuilder()
   *           .setName(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteExecutionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return stub.deleteExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]");
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response =
   *       notebookServiceClient.createExecutionAsync(parent, execution, executionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param execution Required. The execution to be created.
   * @param executionId Required. User-defined unique ID of this execution.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> createExecutionAsync(
      ExecutionName parent, Execution execution, String executionId) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return createExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString();
   *   Execution execution = Execution.newBuilder().build();
   *   String executionId = "executionId-454906285";
   *   Execution response =
   *       notebookServiceClient.createExecutionAsync(parent, execution, executionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `parent=projects/{project_id}/locations/{location}`
   * @param execution Required. The execution to be created.
   * @param executionId Required. User-defined unique ID of this execution.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> createExecutionAsync(
      String parent, Execution execution, String executionId) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder()
            .setParent(parent)
            .setExecution(execution)
            .setExecutionId(executionId)
            .build();
    return createExecutionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .build();
   *   Execution response = notebookServiceClient.createExecutionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, OperationMetadata> createExecutionAsync(
      CreateExecutionRequest request) {
    return createExecutionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .build();
   *   OperationFuture<Execution, OperationMetadata> future =
   *       notebookServiceClient.createExecutionOperationCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationCallable() {
    return stub.createExecutionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Execution in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(ExecutionName.of("[PROJECT]", "[LOCATION]", "[EXECUTION]").toString())
   *           .setExecutionId("executionId-454906285")
   *           .setExecution(Execution.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.createExecutionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExecutionRequest, Operation> createExecutionCallable() {
    return stub.createExecutionCallable();
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

  public static class ListEnvironmentsPagedResponse
      extends AbstractPagedListResponse<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    public static ApiFuture<ListEnvironmentsPagedResponse> createAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      ApiFuture<ListEnvironmentsPage> futurePage =
          ListEnvironmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEnvironmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEnvironmentsPagedResponse(ListEnvironmentsPage page) {
      super(page, ListEnvironmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnvironmentsPage
      extends AbstractPage<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment, ListEnvironmentsPage> {

    private ListEnvironmentsPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      super(context, response);
    }

    private static ListEnvironmentsPage createEmptyPage() {
      return new ListEnvironmentsPage(null, null);
    }

    @Override
    protected ListEnvironmentsPage createPage(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ListEnvironmentsResponse response) {
      return new ListEnvironmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListEnvironmentsPage> createPageAsync(
        PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment> context,
        ApiFuture<ListEnvironmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnvironmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnvironmentsRequest,
          ListEnvironmentsResponse,
          Environment,
          ListEnvironmentsPage,
          ListEnvironmentsFixedSizeCollection> {

    private ListEnvironmentsFixedSizeCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnvironmentsFixedSizeCollection createEmptyCollection() {
      return new ListEnvironmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnvironmentsFixedSizeCollection createCollection(
        List<ListEnvironmentsPage> pages, int collectionSize) {
      return new ListEnvironmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSchedulesPagedResponse
      extends AbstractPagedListResponse<
          ListSchedulesRequest,
          ListSchedulesResponse,
          Schedule,
          ListSchedulesPage,
          ListSchedulesFixedSizeCollection> {

    public static ApiFuture<ListSchedulesPagedResponse> createAsync(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ApiFuture<ListSchedulesResponse> futureResponse) {
      ApiFuture<ListSchedulesPage> futurePage =
          ListSchedulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSchedulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSchedulesPagedResponse(ListSchedulesPage page) {
      super(page, ListSchedulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSchedulesPage
      extends AbstractPage<
          ListSchedulesRequest, ListSchedulesResponse, Schedule, ListSchedulesPage> {

    private ListSchedulesPage(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ListSchedulesResponse response) {
      super(context, response);
    }

    private static ListSchedulesPage createEmptyPage() {
      return new ListSchedulesPage(null, null);
    }

    @Override
    protected ListSchedulesPage createPage(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ListSchedulesResponse response) {
      return new ListSchedulesPage(context, response);
    }

    @Override
    public ApiFuture<ListSchedulesPage> createPageAsync(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ApiFuture<ListSchedulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSchedulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSchedulesRequest,
          ListSchedulesResponse,
          Schedule,
          ListSchedulesPage,
          ListSchedulesFixedSizeCollection> {

    private ListSchedulesFixedSizeCollection(List<ListSchedulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSchedulesFixedSizeCollection createEmptyCollection() {
      return new ListSchedulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSchedulesFixedSizeCollection createCollection(
        List<ListSchedulesPage> pages, int collectionSize) {
      return new ListSchedulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExecutionsPagedResponse
      extends AbstractPagedListResponse<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    public static ApiFuture<ListExecutionsPagedResponse> createAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      ApiFuture<ListExecutionsPage> futurePage =
          ListExecutionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExecutionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExecutionsPagedResponse(ListExecutionsPage page) {
      super(page, ListExecutionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExecutionsPage
      extends AbstractPage<
          ListExecutionsRequest, ListExecutionsResponse, Execution, ListExecutionsPage> {

    private ListExecutionsPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      super(context, response);
    }

    private static ListExecutionsPage createEmptyPage() {
      return new ListExecutionsPage(null, null);
    }

    @Override
    protected ListExecutionsPage createPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      return new ListExecutionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExecutionsPage> createPageAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExecutionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    private ListExecutionsFixedSizeCollection(List<ListExecutionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExecutionsFixedSizeCollection createEmptyCollection() {
      return new ListExecutionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExecutionsFixedSizeCollection createCollection(
        List<ListExecutionsPage> pages, int collectionSize) {
      return new ListExecutionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
