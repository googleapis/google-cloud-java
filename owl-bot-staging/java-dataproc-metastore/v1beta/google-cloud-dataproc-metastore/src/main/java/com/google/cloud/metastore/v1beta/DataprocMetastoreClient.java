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

package com.google.cloud.metastore.v1beta;

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
import com.google.cloud.metastore.v1beta.stub.DataprocMetastoreStub;
import com.google.cloud.metastore.v1beta.stub.DataprocMetastoreStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Configures and manages metastore services. Metastore services are fully
 * managed, highly available, autoscaled, autohealing, OSS-native deployments of technical metadata
 * management software. Each metastore service exposes a network endpoint through which metadata
 * queries are served. Metadata queries can originate from a variety of sources, including Apache
 * Hive, Apache Presto, and Apache Spark.
 *
 * <p>The Dataproc Metastore API defines the following resource model:
 *
 * <ul>
 *   <li>The service works with a collection of Google Cloud projects, named: `/projects/&#42;`
 *   <li>Each project has a collection of available locations, named: `/locations/&#42;` (a location
 *       must refer to a Google Cloud `region`)
 *   <li>Each location has a collection of services, named: `/services/&#42;`
 *   <li>Dataproc Metastore services are resources with names of the form:
 * </ul>
 *
 * <p>`/projects/{project_number}/locations/{location_id}/services/{service_id}`.
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
 * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
 *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
 *   Service response = dataprocMetastoreClient.getService(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataprocMetastoreClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DataprocMetastoreSettings to
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
 * DataprocMetastoreSettings dataprocMetastoreSettings =
 *     DataprocMetastoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataprocMetastoreClient dataprocMetastoreClient =
 *     DataprocMetastoreClient.create(dataprocMetastoreSettings);
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
 * DataprocMetastoreSettings dataprocMetastoreSettings =
 *     DataprocMetastoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataprocMetastoreClient dataprocMetastoreClient =
 *     DataprocMetastoreClient.create(dataprocMetastoreSettings);
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
 * DataprocMetastoreSettings dataprocMetastoreSettings =
 *     DataprocMetastoreSettings.newHttpJsonBuilder().build();
 * DataprocMetastoreClient dataprocMetastoreClient =
 *     DataprocMetastoreClient.create(dataprocMetastoreSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataprocMetastoreClient implements BackgroundResource {
  private final DataprocMetastoreSettings settings;
  private final DataprocMetastoreStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataprocMetastoreClient with default settings. */
  public static final DataprocMetastoreClient create() throws IOException {
    return create(DataprocMetastoreSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataprocMetastoreClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataprocMetastoreClient create(DataprocMetastoreSettings settings)
      throws IOException {
    return new DataprocMetastoreClient(settings);
  }

  /**
   * Constructs an instance of DataprocMetastoreClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataprocMetastoreSettings).
   */
  public static final DataprocMetastoreClient create(DataprocMetastoreStub stub) {
    return new DataprocMetastoreClient(stub);
  }

  /**
   * Constructs an instance of DataprocMetastoreClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataprocMetastoreClient(DataprocMetastoreSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataprocMetastoreStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataprocMetastoreClient(DataprocMetastoreStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataprocMetastoreSettings getSettings() {
    return settings;
  }

  public DataprocMetastoreStub getStub() {
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
   * Lists services in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Service element : dataprocMetastoreClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location of metastore services to
   *     list, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(LocationName parent) {
    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists services in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Service element : dataprocMetastoreClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location of metastore services to
   *     list, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(String parent) {
    ListServicesRequest request = ListServicesRequest.newBuilder().setParent(parent).build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists services in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Service element : dataprocMetastoreClient.listServices(request).iterateAll()) {
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
   * Lists services in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Service> future =
   *       dataprocMetastoreClient.listServicesPagedCallable().futureCall(request);
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
   * Lists services in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response =
   *         dataprocMetastoreClient.listServicesCallable().call(request);
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
   * Gets the details of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   Service response = dataprocMetastoreClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore service to retrieve, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(ServiceName name) {
    GetServiceRequest request =
        GetServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   Service response = dataprocMetastoreClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore service to retrieve, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(String name) {
    GetServiceRequest request = GetServiceRequest.newBuilder().setName(name).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .build();
   *   Service response = dataprocMetastoreClient.getService(request);
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
   * Gets the details of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .build();
   *   ApiFuture<Service> future = dataprocMetastoreClient.getServiceCallable().futureCall(request);
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
   * Creates a metastore service in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response =
   *       dataprocMetastoreClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location in which to create a
   *     metastore service, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @param service Required. The Metastore service to create. The `name` field is ignored. The ID
   *     of the created metastore service must be provided in the request's `service_id` field.
   * @param serviceId Required. The ID of the metastore service, which is used as the final
   *     component of the metastore service's name.
   *     <p>This value must be between 2 and 63 characters long inclusive, begin with a letter, end
   *     with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      LocationName parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore service in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response =
   *       dataprocMetastoreClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location in which to create a
   *     metastore service, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @param service Required. The Metastore service to create. The `name` field is ignored. The ID
   *     of the created metastore service must be provided in the request's `service_id` field.
   * @param serviceId Required. The ID of the metastore service, which is used as the final
   *     component of the metastore service's name.
   *     <p>This value must be between 2 and 63 characters long inclusive, begin with a letter, end
   *     with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      String parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent)
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore service in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = dataprocMetastoreClient.createServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      CreateServiceRequest request) {
    return createServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore service in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       dataprocMetastoreClient.createServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return stub.createServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore service in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.createServiceCallable().futureCall(request);
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
   * Updates the parameters of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   Service service = Service.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Service response = dataprocMetastoreClient.updateServiceAsync(service, updateMask).get();
   * }
   * }</pre>
   *
   * @param service Required. The metastore service to update. The server only merges fields in the
   *     service if they are specified in `update_mask`.
   *     <p>The metastore service's `name` field is used to identify the metastore service to be
   *     updated.
   * @param updateMask Required. A field mask used to specify the fields to be overwritten in the
   *     metastore service resource by the update. Fields specified in the `update_mask` are
   *     relative to the resource (not to the full request). A field is overwritten if it is in the
   *     mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      Service service, FieldMask updateMask) {
    UpdateServiceRequest request =
        UpdateServiceRequest.newBuilder().setService(service).setUpdateMask(updateMask).build();
    return updateServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = dataprocMetastoreClient.updateServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      UpdateServiceRequest request) {
    return updateServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       dataprocMetastoreClient.updateServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return stub.updateServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.updateServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return stub.updateServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   dataprocMetastoreClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore service to delete, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(ServiceName name) {
    DeleteServiceRequest request =
        DeleteServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   dataprocMetastoreClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore service to delete, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(String name) {
    DeleteServiceRequest request = DeleteServiceRequest.newBuilder().setName(name).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   dataprocMetastoreClient.deleteServiceAsync(request).get();
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
   * Deletes a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataprocMetastoreClient.deleteServiceOperationCallable().futureCall(request);
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
   * Deletes a single service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.deleteServiceCallable().futureCall(request);
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
   * Lists imports in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (MetadataImport element :
   *       dataprocMetastoreClient.listMetadataImports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service whose metadata imports to
   *     list, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataImportsPagedResponse listMetadataImports(ServiceName parent) {
    ListMetadataImportsRequest request =
        ListMetadataImportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMetadataImports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists imports in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   for (MetadataImport element :
   *       dataprocMetastoreClient.listMetadataImports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service whose metadata imports to
   *     list, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataImportsPagedResponse listMetadataImports(String parent) {
    ListMetadataImportsRequest request =
        ListMetadataImportsRequest.newBuilder().setParent(parent).build();
    return listMetadataImports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists imports in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListMetadataImportsRequest request =
   *       ListMetadataImportsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MetadataImport element :
   *       dataprocMetastoreClient.listMetadataImports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMetadataImportsPagedResponse listMetadataImports(
      ListMetadataImportsRequest request) {
    return listMetadataImportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists imports in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListMetadataImportsRequest request =
   *       ListMetadataImportsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MetadataImport> future =
   *       dataprocMetastoreClient.listMetadataImportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MetadataImport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable() {
    return stub.listMetadataImportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists imports in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListMetadataImportsRequest request =
   *       ListMetadataImportsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMetadataImportsResponse response =
   *         dataprocMetastoreClient.listMetadataImportsCallable().call(request);
   *     for (MetadataImport element : response.getMetadataImportsList()) {
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
  public final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable() {
    return stub.listMetadataImportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single import.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   MetadataImportName name =
   *       MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]");
   *   MetadataImport response = dataprocMetastoreClient.getMetadataImport(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metadata import to retrieve, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports/{import_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataImport getMetadataImport(MetadataImportName name) {
    GetMetadataImportRequest request =
        GetMetadataImportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMetadataImport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single import.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String name =
   *       MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
   *           .toString();
   *   MetadataImport response = dataprocMetastoreClient.getMetadataImport(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metadata import to retrieve, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports/{import_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataImport getMetadataImport(String name) {
    GetMetadataImportRequest request = GetMetadataImportRequest.newBuilder().setName(name).build();
    return getMetadataImport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single import.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetMetadataImportRequest request =
   *       GetMetadataImportRequest.newBuilder()
   *           .setName(
   *               MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
   *                   .toString())
   *           .build();
   *   MetadataImport response = dataprocMetastoreClient.getMetadataImport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MetadataImport getMetadataImport(GetMetadataImportRequest request) {
    return getMetadataImportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single import.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetMetadataImportRequest request =
   *       GetMetadataImportRequest.newBuilder()
   *           .setName(
   *               MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MetadataImport> future =
   *       dataprocMetastoreClient.getMetadataImportCallable().futureCall(request);
   *   // Do something.
   *   MetadataImport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable() {
    return stub.getMetadataImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MetadataImport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   MetadataImport metadataImport = MetadataImport.newBuilder().build();
   *   String metadataImportId = "metadataImportId1824548847";
   *   MetadataImport response =
   *       dataprocMetastoreClient
   *           .createMetadataImportAsync(parent, metadataImport, metadataImportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service in which to create a
   *     metastore import, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @param metadataImport Required. The metadata import to create. The `name` field is ignored. The
   *     ID of the created metadata import must be provided in the request's `metadata_import_id`
   *     field.
   * @param metadataImportId Required. The ID of the metadata import, which is used as the final
   *     component of the metadata import's name.
   *     <p>This value must be between 1 and 64 characters long, begin with a letter, end with a
   *     letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataImport, OperationMetadata> createMetadataImportAsync(
      ServiceName parent, MetadataImport metadataImport, String metadataImportId) {
    CreateMetadataImportRequest request =
        CreateMetadataImportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMetadataImport(metadataImport)
            .setMetadataImportId(metadataImportId)
            .build();
    return createMetadataImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MetadataImport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   MetadataImport metadataImport = MetadataImport.newBuilder().build();
   *   String metadataImportId = "metadataImportId1824548847";
   *   MetadataImport response =
   *       dataprocMetastoreClient
   *           .createMetadataImportAsync(parent, metadataImport, metadataImportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service in which to create a
   *     metastore import, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @param metadataImport Required. The metadata import to create. The `name` field is ignored. The
   *     ID of the created metadata import must be provided in the request's `metadata_import_id`
   *     field.
   * @param metadataImportId Required. The ID of the metadata import, which is used as the final
   *     component of the metadata import's name.
   *     <p>This value must be between 1 and 64 characters long, begin with a letter, end with a
   *     letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataImport, OperationMetadata> createMetadataImportAsync(
      String parent, MetadataImport metadataImport, String metadataImportId) {
    CreateMetadataImportRequest request =
        CreateMetadataImportRequest.newBuilder()
            .setParent(parent)
            .setMetadataImport(metadataImport)
            .setMetadataImportId(metadataImportId)
            .build();
    return createMetadataImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MetadataImport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateMetadataImportRequest request =
   *       CreateMetadataImportRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setMetadataImportId("metadataImportId1824548847")
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MetadataImport response = dataprocMetastoreClient.createMetadataImportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataImport, OperationMetadata> createMetadataImportAsync(
      CreateMetadataImportRequest request) {
    return createMetadataImportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MetadataImport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateMetadataImportRequest request =
   *       CreateMetadataImportRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setMetadataImportId("metadataImportId1824548847")
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MetadataImport, OperationMetadata> future =
   *       dataprocMetastoreClient.createMetadataImportOperationCallable().futureCall(request);
   *   // Do something.
   *   MetadataImport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable() {
    return stub.createMetadataImportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MetadataImport in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateMetadataImportRequest request =
   *       CreateMetadataImportRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setMetadataImportId("metadataImportId1824548847")
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.createMetadataImportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMetadataImportRequest, Operation>
      createMetadataImportCallable() {
    return stub.createMetadataImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single import. Only the description field of MetadataImport is supported to be
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   MetadataImport metadataImport = MetadataImport.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MetadataImport response =
   *       dataprocMetastoreClient.updateMetadataImportAsync(metadataImport, updateMask).get();
   * }
   * }</pre>
   *
   * @param metadataImport Required. The metadata import to update. The server only merges fields in
   *     the import if they are specified in `update_mask`.
   *     <p>The metadata import's `name` field is used to identify the metastore import to be
   *     updated.
   * @param updateMask Required. A field mask used to specify the fields to be overwritten in the
   *     metadata import resource by the update. Fields specified in the `update_mask` are relative
   *     to the resource (not to the full request). A field is overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataImport, OperationMetadata> updateMetadataImportAsync(
      MetadataImport metadataImport, FieldMask updateMask) {
    UpdateMetadataImportRequest request =
        UpdateMetadataImportRequest.newBuilder()
            .setMetadataImport(metadataImport)
            .setUpdateMask(updateMask)
            .build();
    return updateMetadataImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single import. Only the description field of MetadataImport is supported to be
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateMetadataImportRequest request =
   *       UpdateMetadataImportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MetadataImport response = dataprocMetastoreClient.updateMetadataImportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataImport, OperationMetadata> updateMetadataImportAsync(
      UpdateMetadataImportRequest request) {
    return updateMetadataImportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single import. Only the description field of MetadataImport is supported to be
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateMetadataImportRequest request =
   *       UpdateMetadataImportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MetadataImport, OperationMetadata> future =
   *       dataprocMetastoreClient.updateMetadataImportOperationCallable().futureCall(request);
   *   // Do something.
   *   MetadataImport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable() {
    return stub.updateMetadataImportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single import. Only the description field of MetadataImport is supported to be
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   UpdateMetadataImportRequest request =
   *       UpdateMetadataImportRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMetadataImport(MetadataImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.updateMetadataImportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMetadataImportRequest, Operation>
      updateMetadataImportCallable() {
    return stub.updateMetadataImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports metadata from a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ExportMetadataRequest request =
   *       ExportMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MetadataExport response = dataprocMetastoreClient.exportMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MetadataExport, OperationMetadata> exportMetadataAsync(
      ExportMetadataRequest request) {
    return exportMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports metadata from a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ExportMetadataRequest request =
   *       ExportMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MetadataExport, OperationMetadata> future =
   *       dataprocMetastoreClient.exportMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   MetadataExport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable() {
    return stub.exportMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports metadata from a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ExportMetadataRequest request =
   *       ExportMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.exportMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable() {
    return stub.exportMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName service = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   BackupName backup = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]");
   *   Restore response = dataprocMetastoreClient.restoreServiceAsync(service, backup).get();
   * }
   * }</pre>
   *
   * @param service Required. The relative resource name of the metastore service to run restore, in
   *     the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The relative resource name of the metastore service backup to restore
   *     from, in the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> restoreServiceAsync(
      ServiceName service, BackupName backup) {
    RestoreServiceRequest request =
        RestoreServiceRequest.newBuilder()
            .setService(service == null ? null : service.toString())
            .setBackup(backup == null ? null : backup.toString())
            .build();
    return restoreServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName service = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   String backup = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString();
   *   Restore response = dataprocMetastoreClient.restoreServiceAsync(service, backup).get();
   * }
   * }</pre>
   *
   * @param service Required. The relative resource name of the metastore service to run restore, in
   *     the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The relative resource name of the metastore service backup to restore
   *     from, in the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> restoreServiceAsync(
      ServiceName service, String backup) {
    RestoreServiceRequest request =
        RestoreServiceRequest.newBuilder()
            .setService(service == null ? null : service.toString())
            .setBackup(backup)
            .build();
    return restoreServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String service = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   BackupName backup = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]");
   *   Restore response = dataprocMetastoreClient.restoreServiceAsync(service, backup).get();
   * }
   * }</pre>
   *
   * @param service Required. The relative resource name of the metastore service to run restore, in
   *     the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The relative resource name of the metastore service backup to restore
   *     from, in the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> restoreServiceAsync(
      String service, BackupName backup) {
    RestoreServiceRequest request =
        RestoreServiceRequest.newBuilder()
            .setService(service)
            .setBackup(backup == null ? null : backup.toString())
            .build();
    return restoreServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String service = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   String backup = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString();
   *   Restore response = dataprocMetastoreClient.restoreServiceAsync(service, backup).get();
   * }
   * }</pre>
   *
   * @param service Required. The relative resource name of the metastore service to run restore, in
   *     the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The relative resource name of the metastore service backup to restore
   *     from, in the following form:
   *     <p>`projects/{project_id}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> restoreServiceAsync(
      String service, String backup) {
    RestoreServiceRequest request =
        RestoreServiceRequest.newBuilder().setService(service).setBackup(backup).build();
    return restoreServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   RestoreServiceRequest request =
   *       RestoreServiceRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackup(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Restore response = dataprocMetastoreClient.restoreServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> restoreServiceAsync(
      RestoreServiceRequest request) {
    return restoreServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   RestoreServiceRequest request =
   *       RestoreServiceRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackup(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Restore, OperationMetadata> future =
   *       dataprocMetastoreClient.restoreServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable() {
    return stub.restoreServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a service from a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   RestoreServiceRequest request =
   *       RestoreServiceRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackup(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.restoreServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable() {
    return stub.restoreServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists backups in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (Backup element : dataprocMetastoreClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service whose backups to list, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ServiceName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists backups in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   for (Backup element : dataprocMetastoreClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service whose backups to list, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists backups in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Backup element : dataprocMetastoreClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists backups in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Backup> future =
   *       dataprocMetastoreClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists backups in a service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = dataprocMetastoreClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]");
   *   Backup response = dataprocMetastoreClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the backup to retrieve, in the following
   *     form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString();
   *   Backup response = dataprocMetastoreClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the backup to retrieve, in the following
   *     form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = dataprocMetastoreClient.getBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future = dataprocMetastoreClient.getBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = dataprocMetastoreClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service in which to create a backup
   *     of the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The backup to create. The `name` field is ignored. The ID of the
   *     created backup must be provided in the request's `backup_id` field.
   * @param backupId Required. The ID of the backup, which is used as the final component of the
   *     backup's name.
   *     <p>This value must be between 1 and 64 characters long, begin with a letter, end with a
   *     letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      ServiceName parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = dataprocMetastoreClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the service in which to create a backup
   *     of the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * @param backup Required. The backup to create. The `name` field is ignored. The ID of the
   *     created backup must be provided in the request's `backup_id` field.
   * @param backupId Required. The ID of the backup, which is used as the final component of the
   *     backup's name.
   *     <p>This value must be between 1 and 64 characters long, begin with a letter, end with a
   *     letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      String parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent)
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Backup response = dataprocMetastoreClient.createBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       dataprocMetastoreClient.createBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.createBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]");
   *   dataprocMetastoreClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the backup to delete, in the following
   *     form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString();
   *   dataprocMetastoreClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the backup to delete, in the following
   *     form:
   *     <p>`projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   dataprocMetastoreClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataprocMetastoreClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the attached IAM policies for a resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   RemoveIamPolicyRequest request =
   *       RemoveIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setAsynchronous(true)
   *           .build();
   *   RemoveIamPolicyResponse response = dataprocMetastoreClient.removeIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveIamPolicyResponse removeIamPolicy(RemoveIamPolicyRequest request) {
    return removeIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the attached IAM policies for a resource
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   RemoveIamPolicyRequest request =
   *       RemoveIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[BACKUP]").toString())
   *           .setAsynchronous(true)
   *           .build();
   *   ApiFuture<RemoveIamPolicyResponse> future =
   *       dataprocMetastoreClient.removeIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   RemoveIamPolicyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable() {
    return stub.removeIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query DPMS metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   QueryMetadataRequest request =
   *       QueryMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setQuery("query107944136")
   *           .build();
   *   QueryMetadataResponse response = dataprocMetastoreClient.queryMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QueryMetadataResponse, OperationMetadata> queryMetadataAsync(
      QueryMetadataRequest request) {
    return queryMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query DPMS metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   QueryMetadataRequest request =
   *       QueryMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setQuery("query107944136")
   *           .build();
   *   OperationFuture<QueryMetadataResponse, OperationMetadata> future =
   *       dataprocMetastoreClient.queryMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   QueryMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable() {
    return stub.queryMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query DPMS metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   QueryMetadataRequest request =
   *       QueryMetadataRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.queryMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable() {
    return stub.queryMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a table to another database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   MoveTableToDatabaseRequest request =
   *       MoveTableToDatabaseRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setTableName("tableName-1988717703")
   *           .setDbName("dbName-1339126743")
   *           .setDestinationDbName("destinationDbName-2077361705")
   *           .build();
   *   MoveTableToDatabaseResponse response =
   *       dataprocMetastoreClient.moveTableToDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseAsync(MoveTableToDatabaseRequest request) {
    return moveTableToDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a table to another database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   MoveTableToDatabaseRequest request =
   *       MoveTableToDatabaseRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setTableName("tableName-1988717703")
   *           .setDbName("dbName-1339126743")
   *           .setDestinationDbName("destinationDbName-2077361705")
   *           .build();
   *   OperationFuture<MoveTableToDatabaseResponse, OperationMetadata> future =
   *       dataprocMetastoreClient.moveTableToDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   MoveTableToDatabaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable() {
    return stub.moveTableToDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a table to another database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   MoveTableToDatabaseRequest request =
   *       MoveTableToDatabaseRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setTableName("tableName-1988717703")
   *           .setDbName("dbName-1339126743")
   *           .setDestinationDbName("destinationDbName-2077361705")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.moveTableToDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable() {
    return stub.moveTableToDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Alter metadata resource location. The metadata resource can be a database, table, or partition.
   * This functionality only updates the parent directory for the respective metadata resource and
   * does not transfer any existing data to the new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   AlterMetadataResourceLocationRequest request =
   *       AlterMetadataResourceLocationRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setResourceName("resourceName-384566343")
   *           .setLocationUri("locationUri552310135")
   *           .build();
   *   AlterMetadataResourceLocationResponse response =
   *       dataprocMetastoreClient.alterMetadataResourceLocationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AlterMetadataResourceLocationResponse, OperationMetadata>
      alterMetadataResourceLocationAsync(AlterMetadataResourceLocationRequest request) {
    return alterMetadataResourceLocationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Alter metadata resource location. The metadata resource can be a database, table, or partition.
   * This functionality only updates the parent directory for the respective metadata resource and
   * does not transfer any existing data to the new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   AlterMetadataResourceLocationRequest request =
   *       AlterMetadataResourceLocationRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setResourceName("resourceName-384566343")
   *           .setLocationUri("locationUri552310135")
   *           .build();
   *   OperationFuture<AlterMetadataResourceLocationResponse, OperationMetadata> future =
   *       dataprocMetastoreClient
   *           .alterMetadataResourceLocationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AlterMetadataResourceLocationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable() {
    return stub.alterMetadataResourceLocationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Alter metadata resource location. The metadata resource can be a database, table, or partition.
   * This functionality only updates the parent directory for the respective metadata resource and
   * does not transfer any existing data to the new location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
   *   AlterMetadataResourceLocationRequest request =
   *       AlterMetadataResourceLocationRequest.newBuilder()
   *           .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setResourceName("resourceName-384566343")
   *           .setLocationUri("locationUri552310135")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreClient.alterMetadataResourceLocationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable() {
    return stub.alterMetadataResourceLocationCallable();
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

  public static class ListMetadataImportsPagedResponse
      extends AbstractPagedListResponse<
          ListMetadataImportsRequest,
          ListMetadataImportsResponse,
          MetadataImport,
          ListMetadataImportsPage,
          ListMetadataImportsFixedSizeCollection> {

    public static ApiFuture<ListMetadataImportsPagedResponse> createAsync(
        PageContext<ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
            context,
        ApiFuture<ListMetadataImportsResponse> futureResponse) {
      ApiFuture<ListMetadataImportsPage> futurePage =
          ListMetadataImportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMetadataImportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMetadataImportsPagedResponse(ListMetadataImportsPage page) {
      super(page, ListMetadataImportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMetadataImportsPage
      extends AbstractPage<
          ListMetadataImportsRequest,
          ListMetadataImportsResponse,
          MetadataImport,
          ListMetadataImportsPage> {

    private ListMetadataImportsPage(
        PageContext<ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
            context,
        ListMetadataImportsResponse response) {
      super(context, response);
    }

    private static ListMetadataImportsPage createEmptyPage() {
      return new ListMetadataImportsPage(null, null);
    }

    @Override
    protected ListMetadataImportsPage createPage(
        PageContext<ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
            context,
        ListMetadataImportsResponse response) {
      return new ListMetadataImportsPage(context, response);
    }

    @Override
    public ApiFuture<ListMetadataImportsPage> createPageAsync(
        PageContext<ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
            context,
        ApiFuture<ListMetadataImportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMetadataImportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMetadataImportsRequest,
          ListMetadataImportsResponse,
          MetadataImport,
          ListMetadataImportsPage,
          ListMetadataImportsFixedSizeCollection> {

    private ListMetadataImportsFixedSizeCollection(
        List<ListMetadataImportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMetadataImportsFixedSizeCollection createEmptyCollection() {
      return new ListMetadataImportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMetadataImportsFixedSizeCollection createCollection(
        List<ListMetadataImportsPage> pages, int collectionSize) {
      return new ListMetadataImportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBackupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
