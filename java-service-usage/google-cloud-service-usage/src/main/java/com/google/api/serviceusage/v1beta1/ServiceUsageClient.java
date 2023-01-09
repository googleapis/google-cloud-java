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

package com.google.api.serviceusage.v1beta1;

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
import com.google.api.serviceusage.v1beta1.stub.ServiceUsageStub;
import com.google.api.serviceusage.v1beta1.stub.ServiceUsageStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
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
 * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
 *   GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
 *   Service response = serviceUsageClient.getService(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ServiceUsageClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ServiceUsageSettings to
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
 * ServiceUsageSettings serviceUsageSettings =
 *     ServiceUsageSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ServiceUsageClient serviceUsageClient = ServiceUsageClient.create(serviceUsageSettings);
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
 * ServiceUsageSettings serviceUsageSettings =
 *     ServiceUsageSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ServiceUsageClient serviceUsageClient = ServiceUsageClient.create(serviceUsageSettings);
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
 * ServiceUsageSettings serviceUsageSettings = ServiceUsageSettings.newHttpJsonBuilder().build();
 * ServiceUsageClient serviceUsageClient = ServiceUsageClient.create(serviceUsageSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ServiceUsageClient implements BackgroundResource {
  private final ServiceUsageSettings settings;
  private final ServiceUsageStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ServiceUsageClient with default settings. */
  public static final ServiceUsageClient create() throws IOException {
    return create(ServiceUsageSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ServiceUsageClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ServiceUsageClient create(ServiceUsageSettings settings) throws IOException {
    return new ServiceUsageClient(settings);
  }

  /**
   * Constructs an instance of ServiceUsageClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ServiceUsageSettings).
   */
  public static final ServiceUsageClient create(ServiceUsageStub stub) {
    return new ServiceUsageClient(stub);
  }

  /**
   * Constructs an instance of ServiceUsageClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ServiceUsageClient(ServiceUsageSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ServiceUsageStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ServiceUsageClient(ServiceUsageStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ServiceUsageSettings getSettings() {
    return settings;
  }

  public ServiceUsageStub getStub() {
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
   * Enables a service so that it can be used with a project.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   EnableServiceRequest request =
   *       EnableServiceRequest.newBuilder().setName("name3373707").build();
   *   serviceUsageClient.enableServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<Empty, OperationMetadata> enableServiceAsync(
      EnableServiceRequest request) {
    return enableServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a service so that it can be used with a project.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   EnableServiceRequest request =
   *       EnableServiceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceUsageClient.enableServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable() {
    return stub.enableServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a service so that it can be used with a project.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   EnableServiceRequest request =
   *       EnableServiceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = serviceUsageClient.enableServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return stub.enableServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DisableServiceRequest request =
   *       DisableServiceRequest.newBuilder().setName("name3373707").build();
   *   serviceUsageClient.disableServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<Empty, OperationMetadata> disableServiceAsync(
      DisableServiceRequest request) {
    return disableServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DisableServiceRequest request =
   *       DisableServiceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceUsageClient.disableServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable() {
    return stub.disableServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DisableServiceRequest request =
   *       DisableServiceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = serviceUsageClient.disableServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    return stub.disableServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the service configuration and enabled state for a given service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
   *   Service response = serviceUsageClient.getService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Service getService(GetServiceRequest request) {
    return getServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the service configuration and enabled state for a given service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Service> future = serviceUsageClient.getServiceCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Service element : serviceUsageClient.listServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListServicesPagedResponse listServices(ListServicesRequest request) {
    return listServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Service> future =
   *       serviceUsageClient.listServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Service element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable() {
    return stub.listServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response = serviceUsageClient.listServicesCallable().call(request);
   *     for (Service element : response.getServicesList()) {
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
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return stub.listServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   BatchEnableServicesRequest request =
   *       BatchEnableServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllServiceIds(new ArrayList<String>())
   *           .build();
   *   serviceUsageClient.batchEnableServicesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationFuture<Empty, OperationMetadata> batchEnableServicesAsync(
      BatchEnableServicesRequest request) {
    return batchEnableServicesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   BatchEnableServicesRequest request =
   *       BatchEnableServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllServiceIds(new ArrayList<String>())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceUsageClient.batchEnableServicesOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return stub.batchEnableServicesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur.
   *
   * <p>Operation response type: `google.protobuf.Empty`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   BatchEnableServicesRequest request =
   *       BatchEnableServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllServiceIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.batchEnableServicesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    return stub.batchEnableServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of all quota information visible to the service consumer, organized by
   * service metric. Each metric includes information about all of its defined limits. Each limit
   * includes the limit configuration (quota unit, preciseness, default value), the current
   * effective limit value, and all of the overrides applied to the limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerQuotaMetricsRequest request =
   *       ListConsumerQuotaMetricsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   for (ConsumerQuotaMetric element :
   *       serviceUsageClient.listConsumerQuotaMetrics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConsumerQuotaMetricsPagedResponse listConsumerQuotaMetrics(
      ListConsumerQuotaMetricsRequest request) {
    return listConsumerQuotaMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of all quota information visible to the service consumer, organized by
   * service metric. Each metric includes information about all of its defined limits. Each limit
   * includes the limit configuration (quota unit, preciseness, default value), the current
   * effective limit value, and all of the overrides applied to the limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerQuotaMetricsRequest request =
   *       ListConsumerQuotaMetricsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   ApiFuture<ConsumerQuotaMetric> future =
   *       serviceUsageClient.listConsumerQuotaMetricsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConsumerQuotaMetric element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable() {
    return stub.listConsumerQuotaMetricsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of all quota information visible to the service consumer, organized by
   * service metric. Each metric includes information about all of its defined limits. Each limit
   * includes the limit configuration (quota unit, preciseness, default value), the current
   * effective limit value, and all of the overrides applied to the limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerQuotaMetricsRequest request =
   *       ListConsumerQuotaMetricsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListConsumerQuotaMetricsResponse response =
   *         serviceUsageClient.listConsumerQuotaMetricsCallable().call(request);
   *     for (ConsumerQuotaMetric element : response.getMetricsList()) {
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
  public final UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable() {
    return stub.listConsumerQuotaMetricsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of quota information for a specific quota metric
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetConsumerQuotaMetricRequest request =
   *       GetConsumerQuotaMetricRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   ConsumerQuotaMetric response = serviceUsageClient.getConsumerQuotaMetric(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerQuotaMetric getConsumerQuotaMetric(GetConsumerQuotaMetricRequest request) {
    return getConsumerQuotaMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of quota information for a specific quota metric
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetConsumerQuotaMetricRequest request =
   *       GetConsumerQuotaMetricRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   ApiFuture<ConsumerQuotaMetric> future =
   *       serviceUsageClient.getConsumerQuotaMetricCallable().futureCall(request);
   *   // Do something.
   *   ConsumerQuotaMetric response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable() {
    return stub.getConsumerQuotaMetricCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of quota information for a specific quota limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetConsumerQuotaLimitRequest request =
   *       GetConsumerQuotaLimitRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   ConsumerQuotaLimit response = serviceUsageClient.getConsumerQuotaLimit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerQuotaLimit getConsumerQuotaLimit(GetConsumerQuotaLimitRequest request) {
    return getConsumerQuotaLimitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a summary of quota information for a specific quota limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GetConsumerQuotaLimitRequest request =
   *       GetConsumerQuotaLimitRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(QuotaView.forNumber(0))
   *           .build();
   *   ApiFuture<ConsumerQuotaLimit> future =
   *       serviceUsageClient.getConsumerQuotaLimitCallable().futureCall(request);
   *   // Do something.
   *   ConsumerQuotaLimit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable() {
    return stub.getConsumerQuotaLimitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin override. An admin override is applied by an administrator of a parent folder
   * or parent organization of the consumer receiving the override. An admin override is intended to
   * limit the amount of quota the consumer can use out of the total quota pool allocated to all
   * children of the folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateAdminOverrideRequest request =
   *       CreateAdminOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaOverride response = serviceUsageClient.createAdminOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QuotaOverride, OperationMetadata> createAdminOverrideAsync(
      CreateAdminOverrideRequest request) {
    return createAdminOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin override. An admin override is applied by an administrator of a parent folder
   * or parent organization of the consumer receiving the override. An admin override is intended to
   * limit the amount of quota the consumer can use out of the total quota pool allocated to all
   * children of the folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateAdminOverrideRequest request =
   *       CreateAdminOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<QuotaOverride, OperationMetadata> future =
   *       serviceUsageClient.createAdminOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   QuotaOverride response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable() {
    return stub.createAdminOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin override. An admin override is applied by an administrator of a parent folder
   * or parent organization of the consumer receiving the override. An admin override is intended to
   * limit the amount of quota the consumer can use out of the total quota pool allocated to all
   * children of the folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateAdminOverrideRequest request =
   *       CreateAdminOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.createAdminOverrideCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable() {
    return stub.createAdminOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateAdminOverrideRequest request =
   *       UpdateAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaOverride response = serviceUsageClient.updateAdminOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QuotaOverride, OperationMetadata> updateAdminOverrideAsync(
      UpdateAdminOverrideRequest request) {
    return updateAdminOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateAdminOverrideRequest request =
   *       UpdateAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<QuotaOverride, OperationMetadata> future =
   *       serviceUsageClient.updateAdminOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   QuotaOverride response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable() {
    return stub.updateAdminOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateAdminOverrideRequest request =
   *       UpdateAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.updateAdminOverrideCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable() {
    return stub.updateAdminOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteAdminOverrideRequest request =
   *       DeleteAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   serviceUsageClient.deleteAdminOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAdminOverrideAsync(
      DeleteAdminOverrideRequest request) {
    return deleteAdminOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteAdminOverrideRequest request =
   *       DeleteAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceUsageClient.deleteAdminOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable() {
    return stub.deleteAdminOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an admin override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteAdminOverrideRequest request =
   *       DeleteAdminOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.deleteAdminOverrideCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable() {
    return stub.deleteAdminOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all admin overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListAdminOverridesRequest request =
   *       ListAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QuotaOverride element : serviceUsageClient.listAdminOverrides(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdminOverridesPagedResponse listAdminOverrides(
      ListAdminOverridesRequest request) {
    return listAdminOverridesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all admin overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListAdminOverridesRequest request =
   *       ListAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QuotaOverride> future =
   *       serviceUsageClient.listAdminOverridesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QuotaOverride element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable() {
    return stub.listAdminOverridesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all admin overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListAdminOverridesRequest request =
   *       ListAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAdminOverridesResponse response =
   *         serviceUsageClient.listAdminOverridesCallable().call(request);
   *     for (QuotaOverride element : response.getOverridesList()) {
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
  public final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable() {
    return stub.listAdminOverridesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple admin overrides atomically, all on the same consumer, but on many
   * different metrics or limits. The name field in the quota override message should not be set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportAdminOverridesRequest request =
   *       ImportAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ImportAdminOverridesResponse response =
   *       serviceUsageClient.importAdminOverridesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesAsync(ImportAdminOverridesRequest request) {
    return importAdminOverridesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple admin overrides atomically, all on the same consumer, but on many
   * different metrics or limits. The name field in the quota override message should not be set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportAdminOverridesRequest request =
   *       ImportAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<ImportAdminOverridesResponse, ImportAdminOverridesMetadata> future =
   *       serviceUsageClient.importAdminOverridesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportAdminOverridesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable() {
    return stub.importAdminOverridesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple admin overrides atomically, all on the same consumer, but on many
   * different metrics or limits. The name field in the quota override message should not be set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportAdminOverridesRequest request =
   *       ImportAdminOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.importAdminOverridesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAdminOverridesRequest, Operation>
      importAdminOverridesCallable() {
    return stub.importAdminOverridesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a consumer override. A consumer override is applied to the consumer on its own
   * authority to limit its own quota usage. Consumer overrides cannot be used to grant more quota
   * than would be allowed by admin overrides, producer overrides, or the default limit of the
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateConsumerOverrideRequest request =
   *       CreateConsumerOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaOverride response = serviceUsageClient.createConsumerOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QuotaOverride, OperationMetadata> createConsumerOverrideAsync(
      CreateConsumerOverrideRequest request) {
    return createConsumerOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a consumer override. A consumer override is applied to the consumer on its own
   * authority to limit its own quota usage. Consumer overrides cannot be used to grant more quota
   * than would be allowed by admin overrides, producer overrides, or the default limit of the
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateConsumerOverrideRequest request =
   *       CreateConsumerOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<QuotaOverride, OperationMetadata> future =
   *       serviceUsageClient.createConsumerOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   QuotaOverride response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable() {
    return stub.createConsumerOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a consumer override. A consumer override is applied to the consumer on its own
   * authority to limit its own quota usage. Consumer overrides cannot be used to grant more quota
   * than would be allowed by admin overrides, producer overrides, or the default limit of the
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   CreateConsumerOverrideRequest request =
   *       CreateConsumerOverrideRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.createConsumerOverrideCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideCallable() {
    return stub.createConsumerOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateConsumerOverrideRequest request =
   *       UpdateConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaOverride response = serviceUsageClient.updateConsumerOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QuotaOverride, OperationMetadata> updateConsumerOverrideAsync(
      UpdateConsumerOverrideRequest request) {
    return updateConsumerOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateConsumerOverrideRequest request =
   *       UpdateConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<QuotaOverride, OperationMetadata> future =
   *       serviceUsageClient.updateConsumerOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   QuotaOverride response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable() {
    return stub.updateConsumerOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   UpdateConsumerOverrideRequest request =
   *       UpdateConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOverride(QuotaOverride.newBuilder().build())
   *           .setForce(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.updateConsumerOverrideCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideCallable() {
    return stub.updateConsumerOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteConsumerOverrideRequest request =
   *       DeleteConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   serviceUsageClient.deleteConsumerOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConsumerOverrideAsync(
      DeleteConsumerOverrideRequest request) {
    return deleteConsumerOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteConsumerOverrideRequest request =
   *       DeleteConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceUsageClient.deleteConsumerOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable() {
    return stub.deleteConsumerOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a consumer override.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   DeleteConsumerOverrideRequest request =
   *       DeleteConsumerOverrideRequest.newBuilder()
   *           .setName("name3373707")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.deleteConsumerOverrideCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideCallable() {
    return stub.deleteConsumerOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all consumer overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerOverridesRequest request =
   *       ListConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QuotaOverride element : serviceUsageClient.listConsumerOverrides(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConsumerOverridesPagedResponse listConsumerOverrides(
      ListConsumerOverridesRequest request) {
    return listConsumerOverridesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all consumer overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerOverridesRequest request =
   *       ListConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QuotaOverride> future =
   *       serviceUsageClient.listConsumerOverridesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QuotaOverride element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable() {
    return stub.listConsumerOverridesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all consumer overrides on this limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ListConsumerOverridesRequest request =
   *       ListConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConsumerOverridesResponse response =
   *         serviceUsageClient.listConsumerOverridesCallable().call(request);
   *     for (QuotaOverride element : response.getOverridesList()) {
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
  public final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable() {
    return stub.listConsumerOverridesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple consumer overrides atomically, all on the same consumer, but on
   * many different metrics or limits. The name field in the quota override message should not be
   * set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportConsumerOverridesRequest request =
   *       ImportConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ImportConsumerOverridesResponse response =
   *       serviceUsageClient.importConsumerOverridesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportConsumerOverridesResponse, ImportConsumerOverridesMetadata>
      importConsumerOverridesAsync(ImportConsumerOverridesRequest request) {
    return importConsumerOverridesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple consumer overrides atomically, all on the same consumer, but on
   * many different metrics or limits. The name field in the quota override message should not be
   * set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportConsumerOverridesRequest request =
   *       ImportConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   OperationFuture<ImportConsumerOverridesResponse, ImportConsumerOverridesMetadata> future =
   *       serviceUsageClient.importConsumerOverridesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportConsumerOverridesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable() {
    return stub.importConsumerOverridesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates multiple consumer overrides atomically, all on the same consumer, but on
   * many different metrics or limits. The name field in the quota override message should not be
   * set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   ImportConsumerOverridesRequest request =
   *       ImportConsumerOverridesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setForce(true)
   *           .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.importConsumerOverridesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable() {
    return stub.importConsumerOverridesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates service identity for service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GenerateServiceIdentityRequest request =
   *       GenerateServiceIdentityRequest.newBuilder().setParent("parent-995424086").build();
   *   ServiceIdentity response = serviceUsageClient.generateServiceIdentityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceIdentity, Empty> generateServiceIdentityAsync(
      GenerateServiceIdentityRequest request) {
    return generateServiceIdentityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates service identity for service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GenerateServiceIdentityRequest request =
   *       GenerateServiceIdentityRequest.newBuilder().setParent("parent-995424086").build();
   *   OperationFuture<ServiceIdentity, Empty> future =
   *       serviceUsageClient.generateServiceIdentityOperationCallable().futureCall(request);
   *   // Do something.
   *   ServiceIdentity response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable() {
    return stub.generateServiceIdentityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates service identity for service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
   *   GenerateServiceIdentityRequest request =
   *       GenerateServiceIdentityRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<Operation> future =
   *       serviceUsageClient.generateServiceIdentityCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable() {
    return stub.generateServiceIdentityCallable();
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

  public static class ListServicesPagedResponse
      extends AbstractPagedListResponse<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    public static ApiFuture<ListServicesPagedResponse> createAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      ApiFuture<ListServicesPage> futurePage =
          ListServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServicesPagedResponse(ListServicesPage page) {
      super(page, ListServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServicesPage
      extends AbstractPage<ListServicesRequest, ListServicesResponse, Service, ListServicesPage> {

    private ListServicesPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    private ListServicesFixedSizeCollection(List<ListServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServicesFixedSizeCollection createEmptyCollection() {
      return new ListServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServicesFixedSizeCollection createCollection(
        List<ListServicesPage> pages, int collectionSize) {
      return new ListServicesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConsumerQuotaMetricsPagedResponse
      extends AbstractPagedListResponse<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ConsumerQuotaMetric,
          ListConsumerQuotaMetricsPage,
          ListConsumerQuotaMetricsFixedSizeCollection> {

    public static ApiFuture<ListConsumerQuotaMetricsPagedResponse> createAsync(
        PageContext<
                ListConsumerQuotaMetricsRequest,
                ListConsumerQuotaMetricsResponse,
                ConsumerQuotaMetric>
            context,
        ApiFuture<ListConsumerQuotaMetricsResponse> futureResponse) {
      ApiFuture<ListConsumerQuotaMetricsPage> futurePage =
          ListConsumerQuotaMetricsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConsumerQuotaMetricsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConsumerQuotaMetricsPagedResponse(ListConsumerQuotaMetricsPage page) {
      super(page, ListConsumerQuotaMetricsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConsumerQuotaMetricsPage
      extends AbstractPage<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ConsumerQuotaMetric,
          ListConsumerQuotaMetricsPage> {

    private ListConsumerQuotaMetricsPage(
        PageContext<
                ListConsumerQuotaMetricsRequest,
                ListConsumerQuotaMetricsResponse,
                ConsumerQuotaMetric>
            context,
        ListConsumerQuotaMetricsResponse response) {
      super(context, response);
    }

    private static ListConsumerQuotaMetricsPage createEmptyPage() {
      return new ListConsumerQuotaMetricsPage(null, null);
    }

    @Override
    protected ListConsumerQuotaMetricsPage createPage(
        PageContext<
                ListConsumerQuotaMetricsRequest,
                ListConsumerQuotaMetricsResponse,
                ConsumerQuotaMetric>
            context,
        ListConsumerQuotaMetricsResponse response) {
      return new ListConsumerQuotaMetricsPage(context, response);
    }

    @Override
    public ApiFuture<ListConsumerQuotaMetricsPage> createPageAsync(
        PageContext<
                ListConsumerQuotaMetricsRequest,
                ListConsumerQuotaMetricsResponse,
                ConsumerQuotaMetric>
            context,
        ApiFuture<ListConsumerQuotaMetricsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConsumerQuotaMetricsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ConsumerQuotaMetric,
          ListConsumerQuotaMetricsPage,
          ListConsumerQuotaMetricsFixedSizeCollection> {

    private ListConsumerQuotaMetricsFixedSizeCollection(
        List<ListConsumerQuotaMetricsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConsumerQuotaMetricsFixedSizeCollection createEmptyCollection() {
      return new ListConsumerQuotaMetricsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConsumerQuotaMetricsFixedSizeCollection createCollection(
        List<ListConsumerQuotaMetricsPage> pages, int collectionSize) {
      return new ListConsumerQuotaMetricsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdminOverridesPagedResponse
      extends AbstractPagedListResponse<
          ListAdminOverridesRequest,
          ListAdminOverridesResponse,
          QuotaOverride,
          ListAdminOverridesPage,
          ListAdminOverridesFixedSizeCollection> {

    public static ApiFuture<ListAdminOverridesPagedResponse> createAsync(
        PageContext<ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride> context,
        ApiFuture<ListAdminOverridesResponse> futureResponse) {
      ApiFuture<ListAdminOverridesPage> futurePage =
          ListAdminOverridesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdminOverridesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdminOverridesPagedResponse(ListAdminOverridesPage page) {
      super(page, ListAdminOverridesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdminOverridesPage
      extends AbstractPage<
          ListAdminOverridesRequest,
          ListAdminOverridesResponse,
          QuotaOverride,
          ListAdminOverridesPage> {

    private ListAdminOverridesPage(
        PageContext<ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride> context,
        ListAdminOverridesResponse response) {
      super(context, response);
    }

    private static ListAdminOverridesPage createEmptyPage() {
      return new ListAdminOverridesPage(null, null);
    }

    @Override
    protected ListAdminOverridesPage createPage(
        PageContext<ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride> context,
        ListAdminOverridesResponse response) {
      return new ListAdminOverridesPage(context, response);
    }

    @Override
    public ApiFuture<ListAdminOverridesPage> createPageAsync(
        PageContext<ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride> context,
        ApiFuture<ListAdminOverridesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdminOverridesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdminOverridesRequest,
          ListAdminOverridesResponse,
          QuotaOverride,
          ListAdminOverridesPage,
          ListAdminOverridesFixedSizeCollection> {

    private ListAdminOverridesFixedSizeCollection(
        List<ListAdminOverridesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdminOverridesFixedSizeCollection createEmptyCollection() {
      return new ListAdminOverridesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdminOverridesFixedSizeCollection createCollection(
        List<ListAdminOverridesPage> pages, int collectionSize) {
      return new ListAdminOverridesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConsumerOverridesPagedResponse
      extends AbstractPagedListResponse<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          QuotaOverride,
          ListConsumerOverridesPage,
          ListConsumerOverridesFixedSizeCollection> {

    public static ApiFuture<ListConsumerOverridesPagedResponse> createAsync(
        PageContext<ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
            context,
        ApiFuture<ListConsumerOverridesResponse> futureResponse) {
      ApiFuture<ListConsumerOverridesPage> futurePage =
          ListConsumerOverridesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConsumerOverridesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConsumerOverridesPagedResponse(ListConsumerOverridesPage page) {
      super(page, ListConsumerOverridesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConsumerOverridesPage
      extends AbstractPage<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          QuotaOverride,
          ListConsumerOverridesPage> {

    private ListConsumerOverridesPage(
        PageContext<ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
            context,
        ListConsumerOverridesResponse response) {
      super(context, response);
    }

    private static ListConsumerOverridesPage createEmptyPage() {
      return new ListConsumerOverridesPage(null, null);
    }

    @Override
    protected ListConsumerOverridesPage createPage(
        PageContext<ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
            context,
        ListConsumerOverridesResponse response) {
      return new ListConsumerOverridesPage(context, response);
    }

    @Override
    public ApiFuture<ListConsumerOverridesPage> createPageAsync(
        PageContext<ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
            context,
        ApiFuture<ListConsumerOverridesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConsumerOverridesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          QuotaOverride,
          ListConsumerOverridesPage,
          ListConsumerOverridesFixedSizeCollection> {

    private ListConsumerOverridesFixedSizeCollection(
        List<ListConsumerOverridesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConsumerOverridesFixedSizeCollection createEmptyCollection() {
      return new ListConsumerOverridesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConsumerOverridesFixedSizeCollection createCollection(
        List<ListConsumerOverridesPage> pages, int collectionSize) {
      return new ListConsumerOverridesFixedSizeCollection(pages, collectionSize);
    }
  }
}
