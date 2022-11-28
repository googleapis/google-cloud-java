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

package com.google.cloud.metastore.v1alpha;

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
import com.google.cloud.metastore.v1alpha.stub.DataprocMetastoreFederationStub;
import com.google.cloud.metastore.v1alpha.stub.DataprocMetastoreFederationStubSettings;
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
 * Service Description: Configures and manages metastore federation services. Dataproc Metastore
 * Federation Service allows federating a collection of backend metastores like BigQuery, Dataplex
 * Lakes, and other Dataproc Metastores. The Federation Service exposes a gRPC URL through which
 * metadata from the backend metastores are served at query time.
 *
 * <p>The Dataproc Metastore Federation API defines the following resource model:
 *
 * <ul>
 *   <li>The service works with a collection of Google Cloud projects.
 *   <li>Each project has a collection of available locations.
 *   <li>Each location has a collection of federations.
 *   <li>Dataproc Metastore Federations are resources with names of the form:
 *       `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
 * </ul>
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
 * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
 *     DataprocMetastoreFederationClient.create()) {
 *   FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");
 *   Federation response = dataprocMetastoreFederationClient.getFederation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataprocMetastoreFederationClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * DataprocMetastoreFederationSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataprocMetastoreFederationSettings dataprocMetastoreFederationSettings =
 *     DataprocMetastoreFederationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
 *     DataprocMetastoreFederationClient.create(dataprocMetastoreFederationSettings);
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
 * DataprocMetastoreFederationSettings dataprocMetastoreFederationSettings =
 *     DataprocMetastoreFederationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
 *     DataprocMetastoreFederationClient.create(dataprocMetastoreFederationSettings);
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
 * DataprocMetastoreFederationSettings dataprocMetastoreFederationSettings =
 *     DataprocMetastoreFederationSettings.newHttpJsonBuilder().build();
 * DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
 *     DataprocMetastoreFederationClient.create(dataprocMetastoreFederationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataprocMetastoreFederationClient implements BackgroundResource {
  private final DataprocMetastoreFederationSettings settings;
  private final DataprocMetastoreFederationStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataprocMetastoreFederationClient with default settings. */
  public static final DataprocMetastoreFederationClient create() throws IOException {
    return create(DataprocMetastoreFederationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataprocMetastoreFederationClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DataprocMetastoreFederationClient create(
      DataprocMetastoreFederationSettings settings) throws IOException {
    return new DataprocMetastoreFederationClient(settings);
  }

  /**
   * Constructs an instance of DataprocMetastoreFederationClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DataprocMetastoreFederationSettings).
   */
  public static final DataprocMetastoreFederationClient create(
      DataprocMetastoreFederationStub stub) {
    return new DataprocMetastoreFederationClient(stub);
  }

  /**
   * Constructs an instance of DataprocMetastoreFederationClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataprocMetastoreFederationClient(DataprocMetastoreFederationSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DataprocMetastoreFederationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataprocMetastoreFederationClient(DataprocMetastoreFederationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataprocMetastoreFederationSettings getSettings() {
    return settings;
  }

  public DataprocMetastoreFederationStub getStub() {
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
   * Lists federations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Federation element :
   *       dataprocMetastoreFederationClient.listFederations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location of metastore federations to
   *     list, in the following form: `projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFederationsPagedResponse listFederations(LocationName parent) {
    ListFederationsRequest request =
        ListFederationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFederations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists federations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Federation element :
   *       dataprocMetastoreFederationClient.listFederations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location of metastore federations to
   *     list, in the following form: `projects/{project_number}/locations/{location_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFederationsPagedResponse listFederations(String parent) {
    ListFederationsRequest request = ListFederationsRequest.newBuilder().setParent(parent).build();
    return listFederations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists federations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   ListFederationsRequest request =
   *       ListFederationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Federation element :
   *       dataprocMetastoreFederationClient.listFederations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFederationsPagedResponse listFederations(ListFederationsRequest request) {
    return listFederationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists federations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   ListFederationsRequest request =
   *       ListFederationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Federation> future =
   *       dataprocMetastoreFederationClient.listFederationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Federation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    return stub.listFederationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists federations in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   ListFederationsRequest request =
   *       ListFederationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFederationsResponse response =
   *         dataprocMetastoreFederationClient.listFederationsCallable().call(request);
   *     for (Federation element : response.getFederationsList()) {
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
  public final UnaryCallable<ListFederationsRequest, ListFederationsResponse>
      listFederationsCallable() {
    return stub.listFederationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");
   *   Federation response = dataprocMetastoreFederationClient.getFederation(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore federation to retrieve, in
   *     the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Federation getFederation(FederationName name) {
    GetFederationRequest request =
        GetFederationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFederation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   String name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString();
   *   Federation response = dataprocMetastoreFederationClient.getFederation(name);
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore federation to retrieve, in
   *     the following form:
   *     <p>`projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Federation getFederation(String name) {
    GetFederationRequest request = GetFederationRequest.newBuilder().setName(name).build();
    return getFederation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   GetFederationRequest request =
   *       GetFederationRequest.newBuilder()
   *           .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
   *           .build();
   *   Federation response = dataprocMetastoreFederationClient.getFederation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Federation getFederation(GetFederationRequest request) {
    return getFederationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   GetFederationRequest request =
   *       GetFederationRequest.newBuilder()
   *           .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
   *           .build();
   *   ApiFuture<Federation> future =
   *       dataprocMetastoreFederationClient.getFederationCallable().futureCall(request);
   *   // Do something.
   *   Federation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    return stub.getFederationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore federation in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Federation federation = Federation.newBuilder().build();
   *   String federationId = "federationId-735921218";
   *   Federation response =
   *       dataprocMetastoreFederationClient
   *           .createFederationAsync(parent, federation, federationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location in which to create a
   *     federation service, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @param federation Required. The Metastore Federation to create. The `name` field is ignored.
   *     The ID of the created metastore federation must be provided in the request's
   *     `federation_id` field.
   * @param federationId Required. The ID of the metastore federation, which is used as the final
   *     component of the metastore federation's name.
   *     <p>This value must be between 2 and 63 characters long inclusive, begin with a letter, end
   *     with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Federation, OperationMetadata> createFederationAsync(
      LocationName parent, Federation federation, String federationId) {
    CreateFederationRequest request =
        CreateFederationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFederation(federation)
            .setFederationId(federationId)
            .build();
    return createFederationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore federation in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Federation federation = Federation.newBuilder().build();
   *   String federationId = "federationId-735921218";
   *   Federation response =
   *       dataprocMetastoreFederationClient
   *           .createFederationAsync(parent, federation, federationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the location in which to create a
   *     federation service, in the following form:
   *     <p>`projects/{project_number}/locations/{location_id}`.
   * @param federation Required. The Metastore Federation to create. The `name` field is ignored.
   *     The ID of the created metastore federation must be provided in the request's
   *     `federation_id` field.
   * @param federationId Required. The ID of the metastore federation, which is used as the final
   *     component of the metastore federation's name.
   *     <p>This value must be between 2 and 63 characters long inclusive, begin with a letter, end
   *     with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Federation, OperationMetadata> createFederationAsync(
      String parent, Federation federation, String federationId) {
    CreateFederationRequest request =
        CreateFederationRequest.newBuilder()
            .setParent(parent)
            .setFederation(federation)
            .setFederationId(federationId)
            .build();
    return createFederationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore federation in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   CreateFederationRequest request =
   *       CreateFederationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFederationId("federationId-735921218")
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Federation response = dataprocMetastoreFederationClient.createFederationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Federation, OperationMetadata> createFederationAsync(
      CreateFederationRequest request) {
    return createFederationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore federation in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   CreateFederationRequest request =
   *       CreateFederationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFederationId("federationId-735921218")
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Federation, OperationMetadata> future =
   *       dataprocMetastoreFederationClient.createFederationOperationCallable().futureCall(request);
   *   // Do something.
   *   Federation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    return stub.createFederationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a metastore federation in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   CreateFederationRequest request =
   *       CreateFederationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFederationId("federationId-735921218")
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreFederationClient.createFederationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    return stub.createFederationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fields of a federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   Federation federation = Federation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Federation response =
   *       dataprocMetastoreFederationClient.updateFederationAsync(federation, updateMask).get();
   * }
   * }</pre>
   *
   * @param federation Required. The metastore federation to update. The server only merges fields
   *     in the service if they are specified in `update_mask`.
   *     <p>The metastore federation's `name` field is used to identify the metastore service to be
   *     updated.
   * @param updateMask Required. A field mask used to specify the fields to be overwritten in the
   *     metastore federation resource by the update. Fields specified in the `update_mask` are
   *     relative to the resource (not to the full request). A field is overwritten if it is in the
   *     mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Federation, OperationMetadata> updateFederationAsync(
      Federation federation, FieldMask updateMask) {
    UpdateFederationRequest request =
        UpdateFederationRequest.newBuilder()
            .setFederation(federation)
            .setUpdateMask(updateMask)
            .build();
    return updateFederationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fields of a federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   UpdateFederationRequest request =
   *       UpdateFederationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Federation response = dataprocMetastoreFederationClient.updateFederationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Federation, OperationMetadata> updateFederationAsync(
      UpdateFederationRequest request) {
    return updateFederationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fields of a federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   UpdateFederationRequest request =
   *       UpdateFederationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Federation, OperationMetadata> future =
   *       dataprocMetastoreFederationClient.updateFederationOperationCallable().futureCall(request);
   *   // Do something.
   *   Federation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    return stub.updateFederationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the fields of a federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   UpdateFederationRequest request =
   *       UpdateFederationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFederation(Federation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreFederationClient.updateFederationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    return stub.updateFederationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");
   *   dataprocMetastoreFederationClient.deleteFederationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore federation to delete, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFederationAsync(
      FederationName name) {
    DeleteFederationRequest request =
        DeleteFederationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFederationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   String name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString();
   *   dataprocMetastoreFederationClient.deleteFederationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The relative resource name of the metastore federation to delete, in the
   *     following form:
   *     <p>`projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFederationAsync(String name) {
    DeleteFederationRequest request = DeleteFederationRequest.newBuilder().setName(name).build();
    return deleteFederationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   DeleteFederationRequest request =
   *       DeleteFederationRequest.newBuilder()
   *           .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   dataprocMetastoreFederationClient.deleteFederationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFederationAsync(
      DeleteFederationRequest request) {
    return deleteFederationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   DeleteFederationRequest request =
   *       DeleteFederationRequest.newBuilder()
   *           .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataprocMetastoreFederationClient.deleteFederationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    return stub.deleteFederationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single federation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
   *     DataprocMetastoreFederationClient.create()) {
   *   DeleteFederationRequest request =
   *       DeleteFederationRequest.newBuilder()
   *           .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataprocMetastoreFederationClient.deleteFederationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    return stub.deleteFederationCallable();
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

  public static class ListFederationsPagedResponse
      extends AbstractPagedListResponse<
          ListFederationsRequest,
          ListFederationsResponse,
          Federation,
          ListFederationsPage,
          ListFederationsFixedSizeCollection> {

    public static ApiFuture<ListFederationsPagedResponse> createAsync(
        PageContext<ListFederationsRequest, ListFederationsResponse, Federation> context,
        ApiFuture<ListFederationsResponse> futureResponse) {
      ApiFuture<ListFederationsPage> futurePage =
          ListFederationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFederationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFederationsPagedResponse(ListFederationsPage page) {
      super(page, ListFederationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFederationsPage
      extends AbstractPage<
          ListFederationsRequest, ListFederationsResponse, Federation, ListFederationsPage> {

    private ListFederationsPage(
        PageContext<ListFederationsRequest, ListFederationsResponse, Federation> context,
        ListFederationsResponse response) {
      super(context, response);
    }

    private static ListFederationsPage createEmptyPage() {
      return new ListFederationsPage(null, null);
    }

    @Override
    protected ListFederationsPage createPage(
        PageContext<ListFederationsRequest, ListFederationsResponse, Federation> context,
        ListFederationsResponse response) {
      return new ListFederationsPage(context, response);
    }

    @Override
    public ApiFuture<ListFederationsPage> createPageAsync(
        PageContext<ListFederationsRequest, ListFederationsResponse, Federation> context,
        ApiFuture<ListFederationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFederationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFederationsRequest,
          ListFederationsResponse,
          Federation,
          ListFederationsPage,
          ListFederationsFixedSizeCollection> {

    private ListFederationsFixedSizeCollection(
        List<ListFederationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFederationsFixedSizeCollection createEmptyCollection() {
      return new ListFederationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFederationsFixedSizeCollection createCollection(
        List<ListFederationsPage> pages, int collectionSize) {
      return new ListFederationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
