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

package com.google.cloud.api.servicemanagement.v1;

import com.google.api.Service;
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
import com.google.api.servicemanagement.v1.ConfigSource;
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.OperationMetadata;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
import com.google.cloud.api.servicemanagement.v1.stub.ServiceManagerStub;
import com.google.cloud.api.servicemanagement.v1.stub.ServiceManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Google Service Management
 * API](https://cloud.google.com/service-infrastructure/docs/overview)
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
 * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
 *   String serviceName = "serviceName-1928572192";
 *   ManagedService response = serviceManagerClient.getService(serviceName);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ServiceManagerClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ServiceManagerSettings to
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
 * ServiceManagerSettings serviceManagerSettings =
 *     ServiceManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ServiceManagerClient serviceManagerClient = ServiceManagerClient.create(serviceManagerSettings);
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
 * ServiceManagerSettings serviceManagerSettings =
 *     ServiceManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ServiceManagerClient serviceManagerClient = ServiceManagerClient.create(serviceManagerSettings);
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
 * ServiceManagerSettings serviceManagerSettings =
 *     ServiceManagerSettings.newHttpJsonBuilder().build();
 * ServiceManagerClient serviceManagerClient = ServiceManagerClient.create(serviceManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ServiceManagerClient implements BackgroundResource {
  private final ServiceManagerSettings settings;
  private final ServiceManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ServiceManagerClient with default settings. */
  public static final ServiceManagerClient create() throws IOException {
    return create(ServiceManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ServiceManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ServiceManagerClient create(ServiceManagerSettings settings)
      throws IOException {
    return new ServiceManagerClient(settings);
  }

  /**
   * Constructs an instance of ServiceManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ServiceManagerSettings).
   */
  public static final ServiceManagerClient create(ServiceManagerStub stub) {
    return new ServiceManagerClient(stub);
  }

  /**
   * Constructs an instance of ServiceManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ServiceManagerClient(ServiceManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ServiceManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ServiceManagerClient(ServiceManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ServiceManagerSettings getSettings() {
    return settings;
  }

  public ServiceManagerStub getStub() {
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
   * Lists managed services.
   *
   * <p>Returns all public services. For authenticated users, also returns all services the calling
   * user has "servicemanagement.services.get" permission for.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String producerProjectId = "producerProjectId-1297373534";
   *   String consumerId = "consumerId-166238287";
   *   for (ManagedService element :
   *       serviceManagerClient.listServices(producerProjectId, consumerId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param producerProjectId Include services produced by the specified project.
   * @param consumerId Include services consumed by the specified consumer.
   *     <p>The Google Service Management implementation accepts the following forms: -
   *     project:&lt;project_id&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(String producerProjectId, String consumerId) {
    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setProducerProjectId(producerProjectId)
            .setConsumerId(consumerId)
            .build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists managed services.
   *
   * <p>Returns all public services. For authenticated users, also returns all services the calling
   * user has "servicemanagement.services.get" permission for.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setProducerProjectId("producerProjectId-1297373534")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setConsumerId("consumerId-166238287")
   *           .build();
   *   for (ManagedService element : serviceManagerClient.listServices(request).iterateAll()) {
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
   * Lists managed services.
   *
   * <p>Returns all public services. For authenticated users, also returns all services the calling
   * user has "servicemanagement.services.get" permission for.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setProducerProjectId("producerProjectId-1297373534")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setConsumerId("consumerId-166238287")
   *           .build();
   *   ApiFuture<ManagedService> future =
   *       serviceManagerClient.listServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagedService element : future.get().iterateAll()) {
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
   * Lists managed services.
   *
   * <p>Returns all public services. For authenticated users, also returns all services the calling
   * user has "servicemanagement.services.get" permission for.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setProducerProjectId("producerProjectId-1297373534")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setConsumerId("consumerId-166238287")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response = serviceManagerClient.listServicesCallable().call(request);
   *     for (ManagedService element : response.getServicesList()) {
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
   * Gets a managed service. Authentication is required unless the service is public.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   ManagedService response = serviceManagerClient.getService(serviceName);
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the `ServiceManager` overview for
   *     naming requirements. For example: `example.googleapis.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedService getService(String serviceName) {
    GetServiceRequest request = GetServiceRequest.newBuilder().setServiceName(serviceName).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a managed service. Authentication is required unless the service is public.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   ManagedService response = serviceManagerClient.getService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedService getService(GetServiceRequest request) {
    return getServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a managed service. Authentication is required unless the service is public.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   ApiFuture<ManagedService> future =
   *       serviceManagerClient.getServiceCallable().futureCall(request);
   *   // Do something.
   *   ManagedService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed service.
   *
   * <p>A managed service is immutable, and is subject to mandatory 30-day data retention. You
   * cannot move a service or recreate it within 30 days after deletion.
   *
   * <p>One producer project can own no more than 500 services. For security and reliability
   * purposes, a production service should be hosted in a dedicated producer project.
   *
   * <p>Operation&lt;response: ManagedService&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ManagedService service = ManagedService.newBuilder().build();
   *   ManagedService response = serviceManagerClient.createServiceAsync(service).get();
   * }
   * }</pre>
   *
   * @param service Required. Initial values for the service resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagedService, OperationMetadata> createServiceAsync(
      ManagedService service) {
    CreateServiceRequest request = CreateServiceRequest.newBuilder().setService(service).build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed service.
   *
   * <p>A managed service is immutable, and is subject to mandatory 30-day data retention. You
   * cannot move a service or recreate it within 30 days after deletion.
   *
   * <p>One producer project can own no more than 500 services. For security and reliability
   * purposes, a production service should be hosted in a dedicated producer project.
   *
   * <p>Operation&lt;response: ManagedService&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder().setService(ManagedService.newBuilder().build()).build();
   *   ManagedService response = serviceManagerClient.createServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagedService, OperationMetadata> createServiceAsync(
      CreateServiceRequest request) {
    return createServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed service.
   *
   * <p>A managed service is immutable, and is subject to mandatory 30-day data retention. You
   * cannot move a service or recreate it within 30 days after deletion.
   *
   * <p>One producer project can own no more than 500 services. For security and reliability
   * purposes, a production service should be hosted in a dedicated producer project.
   *
   * <p>Operation&lt;response: ManagedService&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder().setService(ManagedService.newBuilder().build()).build();
   *   OperationFuture<ManagedService, OperationMetadata> future =
   *       serviceManagerClient.createServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   ManagedService response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable() {
    return stub.createServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new managed service.
   *
   * <p>A managed service is immutable, and is subject to mandatory 30-day data retention. You
   * cannot move a service or recreate it within 30 days after deletion.
   *
   * <p>One producer project can own no more than 500 services. For security and reliability
   * purposes, a production service should be hosted in a dedicated producer project.
   *
   * <p>Operation&lt;response: ManagedService&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder().setService(ManagedService.newBuilder().build()).build();
   *   ApiFuture<Operation> future =
   *       serviceManagerClient.createServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return stub.createServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a managed service. This method will change the service to the `Soft-Delete` state for
   * 30 days. Within this period, service producers may call
   * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService] to restore
   * the service. After 30 days, the service will be permanently deleted.
   *
   * <p>Operation&lt;response: google.protobuf.Empty&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   serviceManagerClient.deleteServiceAsync(serviceName).get();
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(String serviceName) {
    DeleteServiceRequest request =
        DeleteServiceRequest.newBuilder().setServiceName(serviceName).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a managed service. This method will change the service to the `Soft-Delete` state for
   * 30 days. Within this period, service producers may call
   * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService] to restore
   * the service. After 30 days, the service will be permanently deleted.
   *
   * <p>Operation&lt;response: google.protobuf.Empty&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   serviceManagerClient.deleteServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(
      DeleteServiceRequest request) {
    return deleteServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a managed service. This method will change the service to the `Soft-Delete` state for
   * 30 days. Within this period, service producers may call
   * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService] to restore
   * the service. After 30 days, the service will be permanently deleted.
   *
   * <p>Operation&lt;response: google.protobuf.Empty&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       serviceManagerClient.deleteServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return stub.deleteServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a managed service. This method will change the service to the `Soft-Delete` state for
   * 30 days. Within this period, service producers may call
   * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService] to restore
   * the service. After 30 days, the service will be permanently deleted.
   *
   * <p>Operation&lt;response: google.protobuf.Empty&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   ApiFuture<Operation> future =
   *       serviceManagerClient.deleteServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return stub.deleteServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revives a previously deleted managed service. The method restores the service using the
   * configuration at the time the service was deleted. The target service must exist and must have
   * been deleted within the last 30 days.
   *
   * <p>Operation&lt;response: UndeleteServiceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   UndeleteServiceResponse response =
   *       serviceManagerClient.undeleteServiceAsync(serviceName).get();
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeleteServiceResponse, OperationMetadata> undeleteServiceAsync(
      String serviceName) {
    UndeleteServiceRequest request =
        UndeleteServiceRequest.newBuilder().setServiceName(serviceName).build();
    return undeleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revives a previously deleted managed service. The method restores the service using the
   * configuration at the time the service was deleted. The target service must exist and must have
   * been deleted within the last 30 days.
   *
   * <p>Operation&lt;response: UndeleteServiceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   UndeleteServiceRequest request =
   *       UndeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   UndeleteServiceResponse response = serviceManagerClient.undeleteServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeleteServiceResponse, OperationMetadata> undeleteServiceAsync(
      UndeleteServiceRequest request) {
    return undeleteServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revives a previously deleted managed service. The method restores the service using the
   * configuration at the time the service was deleted. The target service must exist and must have
   * been deleted within the last 30 days.
   *
   * <p>Operation&lt;response: UndeleteServiceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   UndeleteServiceRequest request =
   *       UndeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   OperationFuture<UndeleteServiceResponse, OperationMetadata> future =
   *       serviceManagerClient.undeleteServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeleteServiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable() {
    return stub.undeleteServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revives a previously deleted managed service. The method restores the service using the
   * configuration at the time the service was deleted. The target service must exist and must have
   * been deleted within the last 30 days.
   *
   * <p>Operation&lt;response: UndeleteServiceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   UndeleteServiceRequest request =
   *       UndeleteServiceRequest.newBuilder().setServiceName("serviceName-1928572192").build();
   *   ApiFuture<Operation> future =
   *       serviceManagerClient.undeleteServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable() {
    return stub.undeleteServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration for a managed service, from the newest to the
   * oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   for (Service element : serviceManagerClient.listServiceConfigs(serviceName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConfigsPagedResponse listServiceConfigs(String serviceName) {
    ListServiceConfigsRequest request =
        ListServiceConfigsRequest.newBuilder().setServiceName(serviceName).build();
    return listServiceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration for a managed service, from the newest to the
   * oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceConfigsRequest request =
   *       ListServiceConfigsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Service element : serviceManagerClient.listServiceConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConfigsPagedResponse listServiceConfigs(
      ListServiceConfigsRequest request) {
    return listServiceConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration for a managed service, from the newest to the
   * oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceConfigsRequest request =
   *       ListServiceConfigsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Service> future =
   *       serviceManagerClient.listServiceConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Service element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable() {
    return stub.listServiceConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration for a managed service, from the newest to the
   * oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceConfigsRequest request =
   *       ListServiceConfigsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListServiceConfigsResponse response =
   *         serviceManagerClient.listServiceConfigsCallable().call(request);
   *     for (Service element : response.getServiceConfigsList()) {
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
  public final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable() {
    return stub.listServiceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration (version) for a managed service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   String configId = "configId-580140035";
   *   GetServiceConfigRequest.ConfigView view = GetServiceConfigRequest.ConfigView.forNumber(0);
   *   Service response = serviceManagerClient.getServiceConfig(serviceName, configId, view);
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param configId Required. The id of the service configuration resource.
   *     <p>This field must be specified for the server to return all fields, including
   *     `SourceInfo`.
   * @param view Specifies which parts of the Service Config should be returned in the response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getServiceConfig(
      String serviceName, String configId, GetServiceConfigRequest.ConfigView view) {
    GetServiceConfigRequest request =
        GetServiceConfigRequest.newBuilder()
            .setServiceName(serviceName)
            .setConfigId(configId)
            .setView(view)
            .build();
    return getServiceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration (version) for a managed service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceConfigRequest request =
   *       GetServiceConfigRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setConfigId("configId-580140035")
   *           .build();
   *   Service response = serviceManagerClient.getServiceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getServiceConfig(GetServiceConfigRequest request) {
    return getServiceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration (version) for a managed service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceConfigRequest request =
   *       GetServiceConfigRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setConfigId("configId-580140035")
   *           .build();
   *   ApiFuture<Service> future =
   *       serviceManagerClient.getServiceConfigCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable() {
    return stub.getServiceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service. This method only stores
   * the service configuration. To roll out the service configuration to backend systems please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent service configurations and ones referenced by existing rollouts are
   * kept for each service. The rest will be deleted eventually.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   Service serviceConfig = Service.newBuilder().build();
   *   Service response = serviceManagerClient.createServiceConfig(serviceName, serviceConfig);
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param serviceConfig Required. The service configuration resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service createServiceConfig(String serviceName, Service serviceConfig) {
    CreateServiceConfigRequest request =
        CreateServiceConfigRequest.newBuilder()
            .setServiceName(serviceName)
            .setServiceConfig(serviceConfig)
            .build();
    return createServiceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service. This method only stores
   * the service configuration. To roll out the service configuration to backend systems please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent service configurations and ones referenced by existing rollouts are
   * kept for each service. The rest will be deleted eventually.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceConfigRequest request =
   *       CreateServiceConfigRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setServiceConfig(Service.newBuilder().build())
   *           .build();
   *   Service response = serviceManagerClient.createServiceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service createServiceConfig(CreateServiceConfigRequest request) {
    return createServiceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service. This method only stores
   * the service configuration. To roll out the service configuration to backend systems please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent service configurations and ones referenced by existing rollouts are
   * kept for each service. The rest will be deleted eventually.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceConfigRequest request =
   *       CreateServiceConfigRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setServiceConfig(Service.newBuilder().build())
   *           .build();
   *   ApiFuture<Service> future =
   *       serviceManagerClient.createServiceConfigCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable() {
    return stub.createServiceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service based on user-supplied
   * configuration source files (for example: OpenAPI Specification). This method stores the source
   * configurations as well as the generated service configuration. To rollout the service
   * configuration to other services, please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent configuration sources and ones referenced by existing service
   * configurtions are kept for each service. The rest will be deleted eventually.
   *
   * <p>Operation&lt;response: SubmitConfigSourceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   ConfigSource configSource = ConfigSource.newBuilder().build();
   *   boolean validateOnly = true;
   *   SubmitConfigSourceResponse response =
   *       serviceManagerClient
   *           .submitConfigSourceAsync(serviceName, configSource, validateOnly)
   *           .get();
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param configSource Required. The source configuration for the service.
   * @param validateOnly Optional. If set, this will result in the generation of a
   *     `google.api.Service` configuration based on the `ConfigSource` provided, but the generated
   *     config and the sources will NOT be persisted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceAsync(String serviceName, ConfigSource configSource, boolean validateOnly) {
    SubmitConfigSourceRequest request =
        SubmitConfigSourceRequest.newBuilder()
            .setServiceName(serviceName)
            .setConfigSource(configSource)
            .setValidateOnly(validateOnly)
            .build();
    return submitConfigSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service based on user-supplied
   * configuration source files (for example: OpenAPI Specification). This method stores the source
   * configurations as well as the generated service configuration. To rollout the service
   * configuration to other services, please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent configuration sources and ones referenced by existing service
   * configurtions are kept for each service. The rest will be deleted eventually.
   *
   * <p>Operation&lt;response: SubmitConfigSourceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   SubmitConfigSourceRequest request =
   *       SubmitConfigSourceRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setConfigSource(ConfigSource.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   SubmitConfigSourceResponse response =
   *       serviceManagerClient.submitConfigSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceAsync(SubmitConfigSourceRequest request) {
    return submitConfigSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service based on user-supplied
   * configuration source files (for example: OpenAPI Specification). This method stores the source
   * configurations as well as the generated service configuration. To rollout the service
   * configuration to other services, please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent configuration sources and ones referenced by existing service
   * configurtions are kept for each service. The rest will be deleted eventually.
   *
   * <p>Operation&lt;response: SubmitConfigSourceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   SubmitConfigSourceRequest request =
   *       SubmitConfigSourceRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setConfigSource(ConfigSource.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<SubmitConfigSourceResponse, OperationMetadata> future =
   *       serviceManagerClient.submitConfigSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   SubmitConfigSourceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable() {
    return stub.submitConfigSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration (version) for a managed service based on user-supplied
   * configuration source files (for example: OpenAPI Specification). This method stores the source
   * configurations as well as the generated service configuration. To rollout the service
   * configuration to other services, please call
   * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
   *
   * <p>Only the 100 most recent configuration sources and ones referenced by existing service
   * configurtions are kept for each service. The rest will be deleted eventually.
   *
   * <p>Operation&lt;response: SubmitConfigSourceResponse&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   SubmitConfigSourceRequest request =
   *       SubmitConfigSourceRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setConfigSource(ConfigSource.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceManagerClient.submitConfigSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable() {
    return stub.submitConfigSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration rollouts for a managed service, from the newest
   * to the oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   String filter = "filter-1274492040";
   *   for (Rollout element :
   *       serviceManagerClient.listServiceRollouts(serviceName, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param filter Required. Use `filter` to return subset of rollouts. The following filters are
   *     supported: -- To limit the results to only those in status
   *     (google.api.servicemanagement.v1.RolloutStatus) 'SUCCESS', use filter='status=SUCCESS' --
   *     To limit the results to those in status (google.api.servicemanagement.v1.RolloutStatus)
   *     'CANCELLED' or 'FAILED', use filter='status=CANCELLED OR status=FAILED'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceRolloutsPagedResponse listServiceRollouts(
      String serviceName, String filter) {
    ListServiceRolloutsRequest request =
        ListServiceRolloutsRequest.newBuilder()
            .setServiceName(serviceName)
            .setFilter(filter)
            .build();
    return listServiceRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration rollouts for a managed service, from the newest
   * to the oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceRolloutsRequest request =
   *       ListServiceRolloutsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Rollout element : serviceManagerClient.listServiceRollouts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceRolloutsPagedResponse listServiceRollouts(
      ListServiceRolloutsRequest request) {
    return listServiceRolloutsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration rollouts for a managed service, from the newest
   * to the oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceRolloutsRequest request =
   *       ListServiceRolloutsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Rollout> future =
   *       serviceManagerClient.listServiceRolloutsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rollout element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable() {
    return stub.listServiceRolloutsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the history of the service configuration rollouts for a managed service, from the newest
   * to the oldest.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   ListServiceRolloutsRequest request =
   *       ListServiceRolloutsRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListServiceRolloutsResponse response =
   *         serviceManagerClient.listServiceRolloutsCallable().call(request);
   *     for (Rollout element : response.getRolloutsList()) {
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
  public final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable() {
    return stub.listServiceRolloutsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration [rollout][google.api.servicemanagement.v1.Rollout].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   String rolloutId = "rolloutId551248556";
   *   Rollout response = serviceManagerClient.getServiceRollout(serviceName, rolloutId);
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param rolloutId Required. The id of the rollout resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getServiceRollout(String serviceName, String rolloutId) {
    GetServiceRolloutRequest request =
        GetServiceRolloutRequest.newBuilder()
            .setServiceName(serviceName)
            .setRolloutId(rolloutId)
            .build();
    return getServiceRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration [rollout][google.api.servicemanagement.v1.Rollout].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceRolloutRequest request =
   *       GetServiceRolloutRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setRolloutId("rolloutId551248556")
   *           .build();
   *   Rollout response = serviceManagerClient.getServiceRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getServiceRollout(GetServiceRolloutRequest request) {
    return getServiceRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a service configuration [rollout][google.api.servicemanagement.v1.Rollout].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GetServiceRolloutRequest request =
   *       GetServiceRolloutRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setRolloutId("rolloutId551248556")
   *           .build();
   *   ApiFuture<Rollout> future =
   *       serviceManagerClient.getServiceRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable() {
    return stub.getServiceRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration rollout. Based on rollout, the Google Service Management
   * will roll out the service configurations to different backend services. For example, the
   * logging configuration will be pushed to Google Cloud Logging.
   *
   * <p>Please note that any previous pending and running Rollouts and associated Operations will be
   * automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts.
   *
   * <p>Only the 100 most recent (in any state) and the last 10 successful (if not already part of
   * the set of 100 most recent) rollouts are kept for each service. The rest will be deleted
   * eventually.
   *
   * <p>Operation&lt;response: Rollout&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   String serviceName = "serviceName-1928572192";
   *   Rollout rollout = Rollout.newBuilder().build();
   *   Rollout response = serviceManagerClient.createServiceRolloutAsync(serviceName, rollout).get();
   * }
   * }</pre>
   *
   * @param serviceName Required. The name of the service. See the
   *     [overview](https://cloud.google.com/service-infrastructure/docs/overview) for naming
   *     requirements. For example: `example.googleapis.com`.
   * @param rollout Required. The rollout resource. The `service_name` field is output only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createServiceRolloutAsync(
      String serviceName, Rollout rollout) {
    CreateServiceRolloutRequest request =
        CreateServiceRolloutRequest.newBuilder()
            .setServiceName(serviceName)
            .setRollout(rollout)
            .build();
    return createServiceRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration rollout. Based on rollout, the Google Service Management
   * will roll out the service configurations to different backend services. For example, the
   * logging configuration will be pushed to Google Cloud Logging.
   *
   * <p>Please note that any previous pending and running Rollouts and associated Operations will be
   * automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts.
   *
   * <p>Only the 100 most recent (in any state) and the last 10 successful (if not already part of
   * the set of 100 most recent) rollouts are kept for each service. The rest will be deleted
   * eventually.
   *
   * <p>Operation&lt;response: Rollout&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRolloutRequest request =
   *       CreateServiceRolloutRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setRollout(Rollout.newBuilder().build())
   *           .build();
   *   Rollout response = serviceManagerClient.createServiceRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> createServiceRolloutAsync(
      CreateServiceRolloutRequest request) {
    return createServiceRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration rollout. Based on rollout, the Google Service Management
   * will roll out the service configurations to different backend services. For example, the
   * logging configuration will be pushed to Google Cloud Logging.
   *
   * <p>Please note that any previous pending and running Rollouts and associated Operations will be
   * automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts.
   *
   * <p>Only the 100 most recent (in any state) and the last 10 successful (if not already part of
   * the set of 100 most recent) rollouts are kept for each service. The rest will be deleted
   * eventually.
   *
   * <p>Operation&lt;response: Rollout&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRolloutRequest request =
   *       CreateServiceRolloutRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setRollout(Rollout.newBuilder().build())
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       serviceManagerClient.createServiceRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable() {
    return stub.createServiceRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service configuration rollout. Based on rollout, the Google Service Management
   * will roll out the service configurations to different backend services. For example, the
   * logging configuration will be pushed to Google Cloud Logging.
   *
   * <p>Please note that any previous pending and running Rollouts and associated Operations will be
   * automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts.
   *
   * <p>Only the 100 most recent (in any state) and the last 10 successful (if not already part of
   * the set of 100 most recent) rollouts are kept for each service. The rest will be deleted
   * eventually.
   *
   * <p>Operation&lt;response: Rollout&gt;
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   CreateServiceRolloutRequest request =
   *       CreateServiceRolloutRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setRollout(Rollout.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       serviceManagerClient.createServiceRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceRolloutRequest, Operation>
      createServiceRolloutCallable() {
    return stub.createServiceRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a report (errors, warnings and changes from existing configurations)
   * associated with GenerateConfigReportRequest.new_value
   *
   * <p>If GenerateConfigReportRequest.old_value is specified, GenerateConfigReportRequest will
   * contain a single ChangeReport based on the comparison between
   * GenerateConfigReportRequest.new_value and GenerateConfigReportRequest.old_value. If
   * GenerateConfigReportRequest.old_value is not specified, this method will compare
   * GenerateConfigReportRequest.new_value with the last pushed service configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   Any newConfig = Any.newBuilder().build();
   *   Any oldConfig = Any.newBuilder().build();
   *   GenerateConfigReportResponse response =
   *       serviceManagerClient.generateConfigReport(newConfig, oldConfig);
   * }
   * }</pre>
   *
   * @param newConfig Required. Service configuration for which we want to generate the report. For
   *     this version of API, the supported types are
   *     [google.api.servicemanagement.v1.ConfigRef][google.api.servicemanagement.v1.ConfigRef],
   *     [google.api.servicemanagement.v1.ConfigSource][google.api.servicemanagement.v1.ConfigSource],
   *     and [google.api.Service][google.api.Service]
   * @param oldConfig Optional. Service configuration against which the comparison will be done. For
   *     this version of API, the supported types are
   *     [google.api.servicemanagement.v1.ConfigRef][google.api.servicemanagement.v1.ConfigRef],
   *     [google.api.servicemanagement.v1.ConfigSource][google.api.servicemanagement.v1.ConfigSource],
   *     and [google.api.Service][google.api.Service]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConfigReportResponse generateConfigReport(Any newConfig, Any oldConfig) {
    GenerateConfigReportRequest request =
        GenerateConfigReportRequest.newBuilder()
            .setNewConfig(newConfig)
            .setOldConfig(oldConfig)
            .build();
    return generateConfigReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a report (errors, warnings and changes from existing configurations)
   * associated with GenerateConfigReportRequest.new_value
   *
   * <p>If GenerateConfigReportRequest.old_value is specified, GenerateConfigReportRequest will
   * contain a single ChangeReport based on the comparison between
   * GenerateConfigReportRequest.new_value and GenerateConfigReportRequest.old_value. If
   * GenerateConfigReportRequest.old_value is not specified, this method will compare
   * GenerateConfigReportRequest.new_value with the last pushed service configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GenerateConfigReportRequest request =
   *       GenerateConfigReportRequest.newBuilder()
   *           .setNewConfig(Any.newBuilder().build())
   *           .setOldConfig(Any.newBuilder().build())
   *           .build();
   *   GenerateConfigReportResponse response = serviceManagerClient.generateConfigReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConfigReportResponse generateConfigReport(
      GenerateConfigReportRequest request) {
    return generateConfigReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a report (errors, warnings and changes from existing configurations)
   * associated with GenerateConfigReportRequest.new_value
   *
   * <p>If GenerateConfigReportRequest.old_value is specified, GenerateConfigReportRequest will
   * contain a single ChangeReport based on the comparison between
   * GenerateConfigReportRequest.new_value and GenerateConfigReportRequest.old_value. If
   * GenerateConfigReportRequest.old_value is not specified, this method will compare
   * GenerateConfigReportRequest.new_value with the last pushed service configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
   *   GenerateConfigReportRequest request =
   *       GenerateConfigReportRequest.newBuilder()
   *           .setNewConfig(Any.newBuilder().build())
   *           .setOldConfig(Any.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateConfigReportResponse> future =
   *       serviceManagerClient.generateConfigReportCallable().futureCall(request);
   *   // Do something.
   *   GenerateConfigReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable() {
    return stub.generateConfigReportCallable();
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
          ManagedService,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    public static ApiFuture<ListServicesPagedResponse> createAsync(
        PageContext<ListServicesRequest, ListServicesResponse, ManagedService> context,
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
      extends AbstractPage<
          ListServicesRequest, ListServicesResponse, ManagedService, ListServicesPage> {

    private ListServicesPage(
        PageContext<ListServicesRequest, ListServicesResponse, ManagedService> context,
        ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        PageContext<ListServicesRequest, ListServicesResponse, ManagedService> context,
        ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        PageContext<ListServicesRequest, ListServicesResponse, ManagedService> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServicesRequest,
          ListServicesResponse,
          ManagedService,
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

  public static class ListServiceConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceConfigsRequest,
          ListServiceConfigsResponse,
          Service,
          ListServiceConfigsPage,
          ListServiceConfigsFixedSizeCollection> {

    public static ApiFuture<ListServiceConfigsPagedResponse> createAsync(
        PageContext<ListServiceConfigsRequest, ListServiceConfigsResponse, Service> context,
        ApiFuture<ListServiceConfigsResponse> futureResponse) {
      ApiFuture<ListServiceConfigsPage> futurePage =
          ListServiceConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceConfigsPagedResponse(ListServiceConfigsPage page) {
      super(page, ListServiceConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceConfigsPage
      extends AbstractPage<
          ListServiceConfigsRequest, ListServiceConfigsResponse, Service, ListServiceConfigsPage> {

    private ListServiceConfigsPage(
        PageContext<ListServiceConfigsRequest, ListServiceConfigsResponse, Service> context,
        ListServiceConfigsResponse response) {
      super(context, response);
    }

    private static ListServiceConfigsPage createEmptyPage() {
      return new ListServiceConfigsPage(null, null);
    }

    @Override
    protected ListServiceConfigsPage createPage(
        PageContext<ListServiceConfigsRequest, ListServiceConfigsResponse, Service> context,
        ListServiceConfigsResponse response) {
      return new ListServiceConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceConfigsPage> createPageAsync(
        PageContext<ListServiceConfigsRequest, ListServiceConfigsResponse, Service> context,
        ApiFuture<ListServiceConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceConfigsRequest,
          ListServiceConfigsResponse,
          Service,
          ListServiceConfigsPage,
          ListServiceConfigsFixedSizeCollection> {

    private ListServiceConfigsFixedSizeCollection(
        List<ListServiceConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceConfigsFixedSizeCollection createEmptyCollection() {
      return new ListServiceConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceConfigsFixedSizeCollection createCollection(
        List<ListServiceConfigsPage> pages, int collectionSize) {
      return new ListServiceConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServiceRolloutsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceRolloutsRequest,
          ListServiceRolloutsResponse,
          Rollout,
          ListServiceRolloutsPage,
          ListServiceRolloutsFixedSizeCollection> {

    public static ApiFuture<ListServiceRolloutsPagedResponse> createAsync(
        PageContext<ListServiceRolloutsRequest, ListServiceRolloutsResponse, Rollout> context,
        ApiFuture<ListServiceRolloutsResponse> futureResponse) {
      ApiFuture<ListServiceRolloutsPage> futurePage =
          ListServiceRolloutsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceRolloutsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceRolloutsPagedResponse(ListServiceRolloutsPage page) {
      super(page, ListServiceRolloutsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceRolloutsPage
      extends AbstractPage<
          ListServiceRolloutsRequest,
          ListServiceRolloutsResponse,
          Rollout,
          ListServiceRolloutsPage> {

    private ListServiceRolloutsPage(
        PageContext<ListServiceRolloutsRequest, ListServiceRolloutsResponse, Rollout> context,
        ListServiceRolloutsResponse response) {
      super(context, response);
    }

    private static ListServiceRolloutsPage createEmptyPage() {
      return new ListServiceRolloutsPage(null, null);
    }

    @Override
    protected ListServiceRolloutsPage createPage(
        PageContext<ListServiceRolloutsRequest, ListServiceRolloutsResponse, Rollout> context,
        ListServiceRolloutsResponse response) {
      return new ListServiceRolloutsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceRolloutsPage> createPageAsync(
        PageContext<ListServiceRolloutsRequest, ListServiceRolloutsResponse, Rollout> context,
        ApiFuture<ListServiceRolloutsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceRolloutsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceRolloutsRequest,
          ListServiceRolloutsResponse,
          Rollout,
          ListServiceRolloutsPage,
          ListServiceRolloutsFixedSizeCollection> {

    private ListServiceRolloutsFixedSizeCollection(
        List<ListServiceRolloutsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceRolloutsFixedSizeCollection createEmptyCollection() {
      return new ListServiceRolloutsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceRolloutsFixedSizeCollection createCollection(
        List<ListServiceRolloutsPage> pages, int collectionSize) {
      return new ListServiceRolloutsFixedSizeCollection(pages, collectionSize);
    }
  }
}
