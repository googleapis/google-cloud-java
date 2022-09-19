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

package com.google.api.serviceusage.v1;

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
import com.google.api.serviceusage.v1.stub.ServiceUsageStub;
import com.google.api.serviceusage.v1.stub.ServiceUsageStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Enables services that service consumers want to use on Google Cloud
 * Platform, lists the available or enabled services, or disables services that service consumers no
 * longer use.
 *
 * <p>See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
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
 * ServiceUsageSettings serviceUsageSettings =
 *     ServiceUsageSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ServiceUsageSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ServiceUsageClient serviceUsageClient = ServiceUsageClient.create(serviceUsageSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
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
   * Enable a service so that it can be used with a project.
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
   *   EnableServiceResponse response = serviceUsageClient.enableServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableServiceResponse, OperationMetadata> enableServiceAsync(
      EnableServiceRequest request) {
    return enableServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a service so that it can be used with a project.
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
   *   OperationFuture<EnableServiceResponse, OperationMetadata> future =
   *       serviceUsageClient.enableServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   EnableServiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable() {
    return stub.enableServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a service so that it can be used with a project.
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
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return stub.enableServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
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
   *       DisableServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDisableDependentServices(true)
   *           .build();
   *   DisableServiceResponse response = serviceUsageClient.disableServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableServiceResponse, OperationMetadata> disableServiceAsync(
      DisableServiceRequest request) {
    return disableServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
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
   *       DisableServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDisableDependentServices(true)
   *           .build();
   *   OperationFuture<DisableServiceResponse, OperationMetadata> future =
   *       serviceUsageClient.disableServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   DisableServiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable() {
    return stub.disableServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service so that it can no longer be used with a project. This prevents unintended
   * usage that may cause unexpected billing charges or security leaks.
   *
   * <p>It is not valid to call the disable method on a service that is not currently enabled.
   * Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently
   * enabled.
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
   *       DisableServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDisableDependentServices(true)
   *           .build();
   *   ApiFuture<Operation> future = serviceUsageClient.disableServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
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
   */
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
   */
  public final UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>WARNING: If you need to query enabled services frequently or across an organization, you
   * should use [Cloud Asset Inventory API](https://cloud.google.com/asset-inventory/docs/apis),
   * which provides higher throughput and richer filtering capability.
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
   */
  public final ListServicesPagedResponse listServices(ListServicesRequest request) {
    return listServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>WARNING: If you need to query enabled services frequently or across an organization, you
   * should use [Cloud Asset Inventory API](https://cloud.google.com/asset-inventory/docs/apis),
   * which provides higher throughput and richer filtering capability.
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
   */
  public final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable() {
    return stub.listServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all services available to the specified project, and the current state of those services
   * with respect to the project. The list includes all public services, all services for which the
   * calling user has the `servicemanagement.services.bind` permission, and all services that have
   * already been enabled on the project. The list can be filtered to only include services in a
   * specific state, for example to only include services enabled on the project.
   *
   * <p>WARNING: If you need to query enabled services frequently or across an organization, you
   * should use [Cloud Asset Inventory API](https://cloud.google.com/asset-inventory/docs/apis),
   * which provides higher throughput and richer filtering capability.
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
   */
  public final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return stub.listServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur. To enable a single service, use the
   * `EnableService` method instead.
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
   *   BatchEnableServicesResponse response =
   *       serviceUsageClient.batchEnableServicesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesAsync(BatchEnableServicesRequest request) {
    return batchEnableServicesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur. To enable a single service, use the
   * `EnableService` method instead.
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
   *   OperationFuture<BatchEnableServicesResponse, OperationMetadata> future =
   *       serviceUsageClient.batchEnableServicesOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchEnableServicesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return stub.batchEnableServicesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable multiple services on a project. The operation is atomic: if enabling any service fails,
   * then the entire batch fails, and no state changes occur. To enable a single service, use the
   * `EnableService` method instead.
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
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    return stub.batchEnableServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the service configurations and enabled states for a given list of services.
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
   *   BatchGetServicesRequest request =
   *       BatchGetServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchGetServicesResponse response = serviceUsageClient.batchGetServices(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetServicesResponse batchGetServices(BatchGetServicesRequest request) {
    return batchGetServicesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the service configurations and enabled states for a given list of services.
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
   *   BatchGetServicesRequest request =
   *       BatchGetServicesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchGetServicesResponse> future =
   *       serviceUsageClient.batchGetServicesCallable().futureCall(request);
   *   // Do something.
   *   BatchGetServicesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable() {
    return stub.batchGetServicesCallable();
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
}
