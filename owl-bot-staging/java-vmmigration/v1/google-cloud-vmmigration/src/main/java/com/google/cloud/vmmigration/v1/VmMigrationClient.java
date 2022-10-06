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

package com.google.cloud.vmmigration.v1;

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
import com.google.cloud.vmmigration.v1.stub.VmMigrationStub;
import com.google.cloud.vmmigration.v1.stub.VmMigrationStubSettings;
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
 * Service Description: VM Migration Service
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
 * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
 *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
 *   Source response = vmMigrationClient.getSource(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VmMigrationClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of VmMigrationSettings to
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
 * VmMigrationSettings vmMigrationSettings =
 *     VmMigrationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
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
 * VmMigrationSettings vmMigrationSettings =
 *     VmMigrationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
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
 * VmMigrationSettings vmMigrationSettings =
 *     VmMigrationSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             VmMigrationSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VmMigrationClient implements BackgroundResource {
  private final VmMigrationSettings settings;
  private final VmMigrationStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of VmMigrationClient with default settings. */
  public static final VmMigrationClient create() throws IOException {
    return create(VmMigrationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VmMigrationClient create(VmMigrationSettings settings) throws IOException {
    return new VmMigrationClient(settings);
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(VmMigrationSettings).
   */
  public static final VmMigrationClient create(VmMigrationStub stub) {
    return new VmMigrationClient(stub);
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VmMigrationClient(VmMigrationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VmMigrationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected VmMigrationClient(VmMigrationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final VmMigrationSettings getSettings() {
    return settings;
  }

  public VmMigrationStub getStub() {
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
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Source element : vmMigrationClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of sources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(LocationName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Source element : vmMigrationClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of sources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(String parent) {
    ListSourcesRequest request = ListSourcesRequest.newBuilder().setParent(parent).build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Source element : vmMigrationClient.listSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(ListSourcesRequest request) {
    return listSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Source> future = vmMigrationClient.listSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Source element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable() {
    return stub.listSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSourcesResponse response = vmMigrationClient.listSourcesCallable().call(request);
   *     for (Source element : response.getSourcesList()) {
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
  public final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return stub.listSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   Source response = vmMigrationClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(SourceName name) {
    GetSourceRequest request =
        GetSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   Source response = vmMigrationClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(String name) {
    GetSourceRequest request = GetSourceRequest.newBuilder().setName(name).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   Source response = vmMigrationClient.getSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(GetSourceRequest request) {
    return getSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   ApiFuture<Source> future = vmMigrationClient.getSourceCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return stub.getSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = vmMigrationClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Source's parent.
   * @param source Required. The create request body.
   * @param sourceId Required. The source identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      LocationName parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = vmMigrationClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Source's parent.
   * @param source Required. The create request body.
   * @param sourceId Required. The source identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      String parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent)
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = vmMigrationClient.createSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      CreateSourceRequest request) {
    return createSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       vmMigrationClient.createSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    return stub.createSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    return stub.createSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   Source source = Source.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Source response = vmMigrationClient.updateSourceAsync(source, updateMask).get();
   * }
   * }</pre>
   *
   * @param source Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Source
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      Source source, FieldMask updateMask) {
    UpdateSourceRequest request =
        UpdateSourceRequest.newBuilder().setSource(source).setUpdateMask(updateMask).build();
    return updateSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = vmMigrationClient.updateSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      UpdateSourceRequest request) {
    return updateSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       vmMigrationClient.updateSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    return stub.updateSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.updateSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    return stub.updateSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   vmMigrationClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(SourceName name) {
    DeleteSourceRequest request =
        DeleteSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   vmMigrationClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(String name) {
    DeleteSourceRequest request = DeleteSourceRequest.newBuilder().setName(name).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(
      DeleteSourceRequest request) {
    return deleteSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    return stub.deleteSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.deleteSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    return stub.deleteSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(source);
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(SourceName source) {
    FetchInventoryRequest request =
        FetchInventoryRequest.newBuilder()
            .setSource(source == null ? null : source.toString())
            .build();
    return fetchInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(source);
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(String source) {
    FetchInventoryRequest request = FetchInventoryRequest.newBuilder().setSource(source).build();
    return fetchInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchInventoryRequest request =
   *       FetchInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .build();
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(FetchInventoryRequest request) {
    return fetchInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchInventoryRequest request =
   *       FetchInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .build();
   *   ApiFuture<FetchInventoryResponse> future =
   *       vmMigrationClient.fetchInventoryCallable().futureCall(request);
   *   // Do something.
   *   FetchInventoryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchInventoryRequest, FetchInventoryResponse>
      fetchInventoryCallable() {
    return stub.fetchInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Reports parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(SourceName parent) {
    ListUtilizationReportsRequest request =
        ListUtilizationReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUtilizationReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Reports parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(String parent) {
    ListUtilizationReportsRequest request =
        ListUtilizationReportsRequest.newBuilder().setParent(parent).build();
    return listUtilizationReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(
      ListUtilizationReportsRequest request) {
    return listUtilizationReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<UtilizationReport> future =
   *       vmMigrationClient.listUtilizationReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UtilizationReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable() {
    return stub.listUtilizationReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListUtilizationReportsResponse response =
   *         vmMigrationClient.listUtilizationReportsCallable().call(request);
   *     for (UtilizationReport element : response.getUtilizationReportsList()) {
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
  public final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable() {
    return stub.listUtilizationReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UtilizationReportName name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(UtilizationReportName name) {
    GetUtilizationReportRequest request =
        GetUtilizationReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUtilizationReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *           .toString();
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(String name) {
    GetUtilizationReportRequest request =
        GetUtilizationReportRequest.newBuilder().setName(name).build();
    return getUtilizationReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetUtilizationReportRequest request =
   *       GetUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .build();
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(GetUtilizationReportRequest request) {
    return getUtilizationReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetUtilizationReportRequest request =
   *       GetUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .build();
   *   ApiFuture<UtilizationReport> future =
   *       vmMigrationClient.getUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   UtilizationReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable() {
    return stub.getUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
   *   String utilizationReportId = "utilizationReportId1215771057";
   *   UtilizationReport response =
   *       vmMigrationClient
   *           .createUtilizationReportAsync(parent, utilizationReport, utilizationReportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Report's parent.
   * @param utilizationReport Required. The report to create.
   * @param utilizationReportId Required. The ID to use for the report, which will become the final
   *     component of the reports's resource name.
   *     <p>This value maximum length is 63 characters, and valid characters are /[a-z][0-9]-/. It
   *     must start with an english letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      SourceName parent, UtilizationReport utilizationReport, String utilizationReportId) {
    CreateUtilizationReportRequest request =
        CreateUtilizationReportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUtilizationReport(utilizationReport)
            .setUtilizationReportId(utilizationReportId)
            .build();
    return createUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
   *   String utilizationReportId = "utilizationReportId1215771057";
   *   UtilizationReport response =
   *       vmMigrationClient
   *           .createUtilizationReportAsync(parent, utilizationReport, utilizationReportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Report's parent.
   * @param utilizationReport Required. The report to create.
   * @param utilizationReportId Required. The ID to use for the report, which will become the final
   *     component of the reports's resource name.
   *     <p>This value maximum length is 63 characters, and valid characters are /[a-z][0-9]-/. It
   *     must start with an english letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      String parent, UtilizationReport utilizationReport, String utilizationReportId) {
    CreateUtilizationReportRequest request =
        CreateUtilizationReportRequest.newBuilder()
            .setParent(parent)
            .setUtilizationReport(utilizationReport)
            .setUtilizationReportId(utilizationReportId)
            .build();
    return createUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UtilizationReport response = vmMigrationClient.createUtilizationReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      CreateUtilizationReportRequest request) {
    return createUtilizationReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<UtilizationReport, OperationMetadata> future =
   *       vmMigrationClient.createUtilizationReportOperationCallable().futureCall(request);
   *   // Do something.
   *   UtilizationReport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable() {
    return stub.createUtilizationReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable() {
    return stub.createUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UtilizationReportName name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
   *   vmMigrationClient.deleteUtilizationReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(
      UtilizationReportName name) {
    DeleteUtilizationReportRequest request =
        DeleteUtilizationReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *           .toString();
   *   vmMigrationClient.deleteUtilizationReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(String name) {
    DeleteUtilizationReportRequest request =
        DeleteUtilizationReportRequest.newBuilder().setName(name).build();
    return deleteUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteUtilizationReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(
      DeleteUtilizationReportRequest request) {
    return deleteUtilizationReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteUtilizationReportOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable() {
    return stub.deleteUtilizationReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable() {
    return stub.deleteUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connectors.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(SourceName parent) {
    ListDatacenterConnectorsRequest request =
        ListDatacenterConnectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatacenterConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connectors.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(String parent) {
    ListDatacenterConnectorsRequest request =
        ListDatacenterConnectorsRequest.newBuilder().setParent(parent).build();
    return listDatacenterConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(
      ListDatacenterConnectorsRequest request) {
    return listDatacenterConnectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DatacenterConnector> future =
   *       vmMigrationClient.listDatacenterConnectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatacenterConnector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable() {
    return stub.listDatacenterConnectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDatacenterConnectorsResponse response =
   *         vmMigrationClient.listDatacenterConnectorsCallable().call(request);
   *     for (DatacenterConnector element : response.getDatacenterConnectorsList()) {
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
  public final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable() {
    return stub.listDatacenterConnectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DatacenterConnectorName name =
   *       DatacenterConnectorName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatacenterConnector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(DatacenterConnectorName name) {
    GetDatacenterConnectorRequest request =
        GetDatacenterConnectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDatacenterConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DatacenterConnectorName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *           .toString();
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatacenterConnector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(String name) {
    GetDatacenterConnectorRequest request =
        GetDatacenterConnectorRequest.newBuilder().setName(name).build();
    return getDatacenterConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDatacenterConnectorRequest request =
   *       GetDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .build();
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(GetDatacenterConnectorRequest request) {
    return getDatacenterConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDatacenterConnectorRequest request =
   *       GetDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DatacenterConnector> future =
   *       vmMigrationClient.getDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   DatacenterConnector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable() {
    return stub.getDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
   *   String datacenterConnectorId = "datacenterConnectorId-761889719";
   *   DatacenterConnector response =
   *       vmMigrationClient
   *           .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DatacenterConnector's parent. Required. The Source in where the new
   *     DatacenterConnector will be created. For example:
   *     `projects/my-project/locations/us-central1/sources/my-source`
   * @param datacenterConnector Required. The create request body.
   * @param datacenterConnectorId Required. The datacenterConnector identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(
          SourceName parent,
          DatacenterConnector datacenterConnector,
          String datacenterConnectorId) {
    CreateDatacenterConnectorRequest request =
        CreateDatacenterConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatacenterConnector(datacenterConnector)
            .setDatacenterConnectorId(datacenterConnectorId)
            .build();
    return createDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
   *   String datacenterConnectorId = "datacenterConnectorId-761889719";
   *   DatacenterConnector response =
   *       vmMigrationClient
   *           .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DatacenterConnector's parent. Required. The Source in where the new
   *     DatacenterConnector will be created. For example:
   *     `projects/my-project/locations/us-central1/sources/my-source`
   * @param datacenterConnector Required. The create request body.
   * @param datacenterConnectorId Required. The datacenterConnector identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(
          String parent, DatacenterConnector datacenterConnector, String datacenterConnectorId) {
    CreateDatacenterConnectorRequest request =
        CreateDatacenterConnectorRequest.newBuilder()
            .setParent(parent)
            .setDatacenterConnector(datacenterConnector)
            .setDatacenterConnectorId(datacenterConnectorId)
            .build();
    return createDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DatacenterConnector response =
   *       vmMigrationClient.createDatacenterConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(CreateDatacenterConnectorRequest request) {
    return createDatacenterConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DatacenterConnector, OperationMetadata> future =
   *       vmMigrationClient.createDatacenterConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   DatacenterConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable() {
    return stub.createDatacenterConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable() {
    return stub.createDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DatacenterConnectorName name =
   *       DatacenterConnectorName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
   *   vmMigrationClient.deleteDatacenterConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The DatacenterConnector name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      DatacenterConnectorName name) {
    DeleteDatacenterConnectorRequest request =
        DeleteDatacenterConnectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DatacenterConnectorName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *           .toString();
   *   vmMigrationClient.deleteDatacenterConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The DatacenterConnector name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      String name) {
    DeleteDatacenterConnectorRequest request =
        DeleteDatacenterConnectorRequest.newBuilder().setName(name).build();
    return deleteDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteDatacenterConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      DeleteDatacenterConnectorRequest request) {
    return deleteDatacenterConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteDatacenterConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable() {
    return stub.deleteDatacenterConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable() {
    return stub.deleteDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UpgradeApplianceResponse response = vmMigrationClient.upgradeApplianceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpgradeApplianceResponse, OperationMetadata> upgradeApplianceAsync(
      UpgradeApplianceRequest request) {
    return upgradeApplianceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<UpgradeApplianceResponse, OperationMetadata> future =
   *       vmMigrationClient.upgradeApplianceOperationCallable().futureCall(request);
   *   // Do something.
   *   UpgradeApplianceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable() {
    return stub.upgradeApplianceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.upgradeApplianceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable() {
    return stub.upgradeApplianceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   String migratingVmId = "migratingVmId441244154";
   *   MigratingVm response =
   *       vmMigrationClient.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The MigratingVm's parent.
   * @param migratingVm Required. The create request body.
   * @param migratingVmId Required. The migratingVm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      SourceName parent, MigratingVm migratingVm, String migratingVmId) {
    CreateMigratingVmRequest request =
        CreateMigratingVmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMigratingVm(migratingVm)
            .setMigratingVmId(migratingVmId)
            .build();
    return createMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   String migratingVmId = "migratingVmId441244154";
   *   MigratingVm response =
   *       vmMigrationClient.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The MigratingVm's parent.
   * @param migratingVm Required. The create request body.
   * @param migratingVmId Required. The migratingVm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      String parent, MigratingVm migratingVm, String migratingVmId) {
    CreateMigratingVmRequest request =
        CreateMigratingVmRequest.newBuilder()
            .setParent(parent)
            .setMigratingVm(migratingVm)
            .setMigratingVmId(migratingVmId)
            .build();
    return createMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigratingVm response = vmMigrationClient.createMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      CreateMigratingVmRequest request) {
    return createMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigratingVm, OperationMetadata> future =
   *       vmMigrationClient.createMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable() {
    return stub.createMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable() {
    return stub.createMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MigratingVms.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(SourceName parent) {
    ListMigratingVmsRequest request =
        ListMigratingVmsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMigratingVms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MigratingVms.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(String parent) {
    ListMigratingVmsRequest request =
        ListMigratingVmsRequest.newBuilder().setParent(parent).build();
    return listMigratingVms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(ListMigratingVmsRequest request) {
    return listMigratingVmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   ApiFuture<MigratingVm> future =
   *       vmMigrationClient.listMigratingVmsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigratingVm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable() {
    return stub.listMigratingVmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListMigratingVmsResponse response =
   *         vmMigrationClient.listMigratingVmsCallable().call(request);
   *     for (MigratingVm element : response.getMigratingVmsList()) {
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
  public final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable() {
    return stub.listMigratingVmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   MigratingVm response = vmMigrationClient.getMigratingVm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(MigratingVmName name) {
    GetMigratingVmRequest request =
        GetMigratingVmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMigratingVm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   MigratingVm response = vmMigrationClient.getMigratingVm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(String name) {
    GetMigratingVmRequest request = GetMigratingVmRequest.newBuilder().setName(name).build();
    return getMigratingVm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetMigratingVmRequest request =
   *       GetMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   MigratingVm response = vmMigrationClient.getMigratingVm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(GetMigratingVmRequest request) {
    return getMigratingVmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetMigratingVmRequest request =
   *       GetMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   ApiFuture<MigratingVm> future =
   *       vmMigrationClient.getMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable() {
    return stub.getMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MigratingVm response =
   *       vmMigrationClient.updateMigratingVmAsync(migratingVm, updateMask).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the MigratingVm
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> updateMigratingVmAsync(
      MigratingVm migratingVm, FieldMask updateMask) {
    UpdateMigratingVmRequest request =
        UpdateMigratingVmRequest.newBuilder()
            .setMigratingVm(migratingVm)
            .setUpdateMask(updateMask)
            .build();
    return updateMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigratingVm response = vmMigrationClient.updateMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> updateMigratingVmAsync(
      UpdateMigratingVmRequest request) {
    return updateMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigratingVm, OperationMetadata> future =
   *       vmMigrationClient.updateMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable() {
    return stub.updateMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.updateMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable() {
    return stub.updateMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   vmMigrationClient.deleteMigratingVmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(
      MigratingVmName name) {
    DeleteMigratingVmRequest request =
        DeleteMigratingVmRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   vmMigrationClient.deleteMigratingVmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(String name) {
    DeleteMigratingVmRequest request = DeleteMigratingVmRequest.newBuilder().setName(name).build();
    return deleteMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   vmMigrationClient.deleteMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(
      DeleteMigratingVmRequest request) {
    return deleteMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable() {
    return stub.deleteMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable() {
    return stub.deleteMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      MigratingVmName migratingVm) {
    StartMigrationRequest request =
        StartMigrationRequest.newBuilder()
            .setMigratingVm(migratingVm == null ? null : migratingVm.toString())
            .build();
    return startMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      String migratingVm) {
    StartMigrationRequest request =
        StartMigrationRequest.newBuilder().setMigratingVm(migratingVm).build();
    return startMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      StartMigrationRequest request) {
    return startMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<StartMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.startMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   StartMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable() {
    return stub.startMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.startMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return stub.startMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ResumeMigrationResponse response = vmMigrationClient.resumeMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResumeMigrationResponse, OperationMetadata> resumeMigrationAsync(
      ResumeMigrationRequest request) {
    return resumeMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ResumeMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.resumeMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   ResumeMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable() {
    return stub.resumeMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.resumeMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable() {
    return stub.resumeMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   PauseMigrationResponse response = vmMigrationClient.pauseMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PauseMigrationResponse, OperationMetadata> pauseMigrationAsync(
      PauseMigrationRequest request) {
    return pauseMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PauseMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.pauseMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   PauseMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable() {
    return stub.pauseMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.pauseMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable() {
    return stub.pauseMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   FinalizeMigrationResponse response =
   *       vmMigrationClient.finalizeMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      MigratingVmName migratingVm) {
    FinalizeMigrationRequest request =
        FinalizeMigrationRequest.newBuilder()
            .setMigratingVm(migratingVm == null ? null : migratingVm.toString())
            .build();
    return finalizeMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   FinalizeMigrationResponse response =
   *       vmMigrationClient.finalizeMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      String migratingVm) {
    FinalizeMigrationRequest request =
        FinalizeMigrationRequest.newBuilder().setMigratingVm(migratingVm).build();
    return finalizeMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   FinalizeMigrationResponse response = vmMigrationClient.finalizeMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      FinalizeMigrationRequest request) {
    return finalizeMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<FinalizeMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.finalizeMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   FinalizeMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable() {
    return stub.finalizeMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.finalizeMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable() {
    return stub.finalizeMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   CloneJob cloneJob = CloneJob.newBuilder().build();
   *   String cloneJobId = "cloneJobId2071309915";
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Clone's parent.
   * @param cloneJob Required. The clone request body.
   * @param cloneJobId Required. The clone job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      MigratingVmName parent, CloneJob cloneJob, String cloneJobId) {
    CreateCloneJobRequest request =
        CreateCloneJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCloneJob(cloneJob)
            .setCloneJobId(cloneJobId)
            .build();
    return createCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   CloneJob cloneJob = CloneJob.newBuilder().build();
   *   String cloneJobId = "cloneJobId2071309915";
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Clone's parent.
   * @param cloneJob Required. The clone request body.
   * @param cloneJobId Required. The clone job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      String parent, CloneJob cloneJob, String cloneJobId) {
    CreateCloneJobRequest request =
        CreateCloneJobRequest.newBuilder()
            .setParent(parent)
            .setCloneJob(cloneJob)
            .setCloneJobId(cloneJobId)
            .build();
    return createCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      CreateCloneJobRequest request) {
    return createCloneJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CloneJob, OperationMetadata> future =
   *       vmMigrationClient.createCloneJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CloneJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable() {
    return stub.createCloneJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createCloneJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable() {
    return stub.createCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CloneJobName name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The clone job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      CloneJobName name) {
    CancelCloneJobRequest request =
        CancelCloneJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *           .toString();
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The clone job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      String name) {
    CancelCloneJobRequest request = CancelCloneJobRequest.newBuilder().setName(name).build();
    return cancelCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      CancelCloneJobRequest request) {
    return cancelCloneJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<CancelCloneJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelCloneJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelCloneJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable() {
    return stub.cancelCloneJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.cancelCloneJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable() {
    return stub.cancelCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloneJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of source VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(MigratingVmName parent) {
    ListCloneJobsRequest request =
        ListCloneJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloneJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloneJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of source VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(String parent) {
    ListCloneJobsRequest request = ListCloneJobsRequest.newBuilder().setParent(parent).build();
    return listCloneJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloneJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(ListCloneJobsRequest request) {
    return listCloneJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloneJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CloneJob> future =
   *       vmMigrationClient.listCloneJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloneJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable() {
    return stub.listCloneJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CloneJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCloneJobsResponse response = vmMigrationClient.listCloneJobsCallable().call(request);
   *     for (CloneJob element : response.getCloneJobsList()) {
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
  public final UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable() {
    return stub.listCloneJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CloneJobName name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
   *   CloneJob response = vmMigrationClient.getCloneJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CloneJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(CloneJobName name) {
    GetCloneJobRequest request =
        GetCloneJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCloneJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *           .toString();
   *   CloneJob response = vmMigrationClient.getCloneJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CloneJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(String name) {
    GetCloneJobRequest request = GetCloneJobRequest.newBuilder().setName(name).build();
    return getCloneJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCloneJobRequest request =
   *       GetCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   CloneJob response = vmMigrationClient.getCloneJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(GetCloneJobRequest request) {
    return getCloneJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCloneJobRequest request =
   *       GetCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CloneJob> future = vmMigrationClient.getCloneJobCallable().futureCall(request);
   *   // Do something.
   *   CloneJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable() {
    return stub.getCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   CutoverJob cutoverJob = CutoverJob.newBuilder().build();
   *   String cutoverJobId = "cutoverJobId-2003089086";
   *   CutoverJob response =
   *       vmMigrationClient.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Cutover's parent.
   * @param cutoverJob Required. The cutover request body.
   * @param cutoverJobId Required. The cutover job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      MigratingVmName parent, CutoverJob cutoverJob, String cutoverJobId) {
    CreateCutoverJobRequest request =
        CreateCutoverJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCutoverJob(cutoverJob)
            .setCutoverJobId(cutoverJobId)
            .build();
    return createCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   CutoverJob cutoverJob = CutoverJob.newBuilder().build();
   *   String cutoverJobId = "cutoverJobId-2003089086";
   *   CutoverJob response =
   *       vmMigrationClient.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Cutover's parent.
   * @param cutoverJob Required. The cutover request body.
   * @param cutoverJobId Required. The cutover job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      String parent, CutoverJob cutoverJob, String cutoverJobId) {
    CreateCutoverJobRequest request =
        CreateCutoverJobRequest.newBuilder()
            .setParent(parent)
            .setCutoverJob(cutoverJob)
            .setCutoverJobId(cutoverJobId)
            .build();
    return createCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CutoverJob response = vmMigrationClient.createCutoverJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      CreateCutoverJobRequest request) {
    return createCutoverJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CutoverJob, OperationMetadata> future =
   *       vmMigrationClient.createCutoverJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CutoverJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable() {
    return stub.createCutoverJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable() {
    return stub.createCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CutoverJobName name =
   *       CutoverJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The cutover job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      CutoverJobName name) {
    CancelCutoverJobRequest request =
        CancelCutoverJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CutoverJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *           .toString();
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The cutover job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      String name) {
    CancelCutoverJobRequest request = CancelCutoverJobRequest.newBuilder().setName(name).build();
    return cancelCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      CancelCutoverJobRequest request) {
    return cancelCutoverJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<CancelCutoverJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelCutoverJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelCutoverJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable() {
    return stub.cancelCutoverJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.cancelCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable() {
    return stub.cancelCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CutoverJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrating VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(MigratingVmName parent) {
    ListCutoverJobsRequest request =
        ListCutoverJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCutoverJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CutoverJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrating VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(String parent) {
    ListCutoverJobsRequest request = ListCutoverJobsRequest.newBuilder().setParent(parent).build();
    return listCutoverJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CutoverJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(ListCutoverJobsRequest request) {
    return listCutoverJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CutoverJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CutoverJob> future =
   *       vmMigrationClient.listCutoverJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CutoverJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable() {
    return stub.listCutoverJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CutoverJobs of a given migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCutoverJobsResponse response =
   *         vmMigrationClient.listCutoverJobsCallable().call(request);
   *     for (CutoverJob element : response.getCutoverJobsList()) {
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
  public final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsCallable() {
    return stub.listCutoverJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CutoverJobName name =
   *       CutoverJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
   *   CutoverJob response = vmMigrationClient.getCutoverJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CutoverJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(CutoverJobName name) {
    GetCutoverJobRequest request =
        GetCutoverJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCutoverJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CutoverJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *           .toString();
   *   CutoverJob response = vmMigrationClient.getCutoverJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CutoverJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(String name) {
    GetCutoverJobRequest request = GetCutoverJobRequest.newBuilder().setName(name).build();
    return getCutoverJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCutoverJobRequest request =
   *       GetCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   CutoverJob response = vmMigrationClient.getCutoverJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(GetCutoverJobRequest request) {
    return getCutoverJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCutoverJobRequest request =
   *       GetCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CutoverJob> future = vmMigrationClient.getCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   CutoverJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable() {
    return stub.getCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Group element : vmMigrationClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of groups.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(LocationName parent) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Group element : vmMigrationClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of groups.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(String parent) {
    ListGroupsRequest request = ListGroupsRequest.newBuilder().setParent(parent).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Group element : vmMigrationClient.listGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Group> future = vmMigrationClient.listGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Group element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGroupsResponse response = vmMigrationClient.listGroupsCallable().call(request);
   *     for (Group element : response.getGroupsList()) {
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
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   Group response = vmMigrationClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {
    GetGroupRequest request =
        GetGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   Group response = vmMigrationClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   Group response = vmMigrationClient.getGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   ApiFuture<Group> future = vmMigrationClient.getGroupCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = vmMigrationClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Group's parent.
   * @param group Required. The create request body.
   * @param groupId Required. The group identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      LocationName parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = vmMigrationClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Group's parent.
   * @param group Required. The create request body.
   * @param groupId Required. The group identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      String parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent)
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = vmMigrationClient.createGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      CreateGroupRequest request) {
    return createGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       vmMigrationClient.createGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    return stub.createGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    return stub.createGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Group response = vmMigrationClient.updateGroupAsync(group, updateMask).get();
   * }
   * }</pre>
   *
   * @param group Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Group
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      Group group, FieldMask updateMask) {
    UpdateGroupRequest request =
        UpdateGroupRequest.newBuilder().setGroup(group).setUpdateMask(updateMask).build();
    return updateGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = vmMigrationClient.updateGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      UpdateGroupRequest request) {
    return updateGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       vmMigrationClient.updateGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return stub.updateGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.updateGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   vmMigrationClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(GroupName name) {
    DeleteGroupRequest request =
        DeleteGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   vmMigrationClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(String name) {
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(
      DeleteGroupRequest request) {
    return deleteGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    return stub.deleteGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.deleteGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    return stub.deleteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The full path name of the Group to add to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      GroupName group) {
    AddGroupMigrationRequest request =
        AddGroupMigrationRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return addGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The full path name of the Group to add to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      String group) {
    AddGroupMigrationRequest request =
        AddGroupMigrationRequest.newBuilder().setGroup(group).build();
    return addGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      AddGroupMigrationRequest request) {
    return addGroupMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AddGroupMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.addGroupMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   AddGroupMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable() {
    return stub.addGroupMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.addGroupMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable() {
    return stub.addGroupMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The name of the Group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(GroupName group) {
    RemoveGroupMigrationRequest request =
        RemoveGroupMigrationRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return removeGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The name of the Group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(String group) {
    RemoveGroupMigrationRequest request =
        RemoveGroupMigrationRequest.newBuilder().setGroup(group).build();
    return removeGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(RemoveGroupMigrationRequest request) {
    return removeGroupMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RemoveGroupMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.removeGroupMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveGroupMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable() {
    return stub.removeGroupMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.removeGroupMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveGroupMigrationRequest, Operation>
      removeGroupMigrationCallable() {
    return stub.removeGroupMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(LocationName parent) {
    ListTargetProjectsRequest request =
        ListTargetProjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargetProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(String parent) {
    ListTargetProjectsRequest request =
        ListTargetProjectsRequest.newBuilder().setParent(parent).build();
    return listTargetProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(
      ListTargetProjectsRequest request) {
    return listTargetProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TargetProject> future =
   *       vmMigrationClient.listTargetProjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetProject element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable() {
    return stub.listTargetProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTargetProjectsResponse response =
   *         vmMigrationClient.listTargetProjectsCallable().call(request);
   *     for (TargetProject element : response.getTargetProjectsList()) {
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
  public final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable() {
    return stub.listTargetProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
   *   TargetProject response = vmMigrationClient.getTargetProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(TargetProjectName name) {
    GetTargetProjectRequest request =
        GetTargetProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTargetProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString();
   *   TargetProject response = vmMigrationClient.getTargetProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(String name) {
    GetTargetProjectRequest request = GetTargetProjectRequest.newBuilder().setName(name).build();
    return getTargetProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetTargetProjectRequest request =
   *       GetTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .build();
   *   TargetProject response = vmMigrationClient.getTargetProject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(GetTargetProjectRequest request) {
    return getTargetProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetTargetProjectRequest request =
   *       GetTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .build();
   *   ApiFuture<TargetProject> future =
   *       vmMigrationClient.getTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable() {
    return stub.getTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   String targetProjectId = "targetProjectId1290130307";
   *   TargetProject response =
   *       vmMigrationClient.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The TargetProject's parent.
   * @param targetProject Required. The create request body.
   * @param targetProjectId Required. The target_project identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      LocationName parent, TargetProject targetProject, String targetProjectId) {
    CreateTargetProjectRequest request =
        CreateTargetProjectRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetProject(targetProject)
            .setTargetProjectId(targetProjectId)
            .build();
    return createTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   String targetProjectId = "targetProjectId1290130307";
   *   TargetProject response =
   *       vmMigrationClient.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The TargetProject's parent.
   * @param targetProject Required. The create request body.
   * @param targetProjectId Required. The target_project identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      String parent, TargetProject targetProject, String targetProjectId) {
    CreateTargetProjectRequest request =
        CreateTargetProjectRequest.newBuilder()
            .setParent(parent)
            .setTargetProject(targetProject)
            .setTargetProjectId(targetProjectId)
            .build();
    return createTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TargetProject response = vmMigrationClient.createTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      CreateTargetProjectRequest request) {
    return createTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<TargetProject, OperationMetadata> future =
   *       vmMigrationClient.createTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable() {
    return stub.createTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable() {
    return stub.createTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TargetProject response =
   *       vmMigrationClient.updateTargetProjectAsync(targetProject, updateMask).get();
   * }
   * }</pre>
   *
   * @param targetProject Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the
   *     TargetProject resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> updateTargetProjectAsync(
      TargetProject targetProject, FieldMask updateMask) {
    UpdateTargetProjectRequest request =
        UpdateTargetProjectRequest.newBuilder()
            .setTargetProject(targetProject)
            .setUpdateMask(updateMask)
            .build();
    return updateTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TargetProject response = vmMigrationClient.updateTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> updateTargetProjectAsync(
      UpdateTargetProjectRequest request) {
    return updateTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<TargetProject, OperationMetadata> future =
   *       vmMigrationClient.updateTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable() {
    return stub.updateTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.updateTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable() {
    return stub.updateTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
   *   vmMigrationClient.deleteTargetProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(
      TargetProjectName name) {
    DeleteTargetProjectRequest request =
        DeleteTargetProjectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString();
   *   vmMigrationClient.deleteTargetProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(String name) {
    DeleteTargetProjectRequest request =
        DeleteTargetProjectRequest.newBuilder().setName(name).build();
    return deleteTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(
      DeleteTargetProjectRequest request) {
    return deleteTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable() {
    return stub.deleteTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable() {
    return stub.deleteTargetProjectCallable();
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

  public static class ListSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    public static ApiFuture<ListSourcesPagedResponse> createAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      ApiFuture<ListSourcesPage> futurePage =
          ListSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSourcesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSourcesPagedResponse(ListSourcesPage page) {
      super(page, ListSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSourcesPage
      extends AbstractPage<ListSourcesRequest, ListSourcesResponse, Source, ListSourcesPage> {

    private ListSourcesPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      super(context, response);
    }

    private static ListSourcesPage createEmptyPage() {
      return new ListSourcesPage(null, null);
    }

    @Override
    protected ListSourcesPage createPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      return new ListSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListSourcesPage> createPageAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    private ListSourcesFixedSizeCollection(List<ListSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSourcesFixedSizeCollection createEmptyCollection() {
      return new ListSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSourcesFixedSizeCollection createCollection(
        List<ListSourcesPage> pages, int collectionSize) {
      return new ListSourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUtilizationReportsPagedResponse
      extends AbstractPagedListResponse<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage,
          ListUtilizationReportsFixedSizeCollection> {

    public static ApiFuture<ListUtilizationReportsPagedResponse> createAsync(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ApiFuture<ListUtilizationReportsResponse> futureResponse) {
      ApiFuture<ListUtilizationReportsPage> futurePage =
          ListUtilizationReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUtilizationReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUtilizationReportsPagedResponse(ListUtilizationReportsPage page) {
      super(page, ListUtilizationReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUtilizationReportsPage
      extends AbstractPage<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage> {

    private ListUtilizationReportsPage(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ListUtilizationReportsResponse response) {
      super(context, response);
    }

    private static ListUtilizationReportsPage createEmptyPage() {
      return new ListUtilizationReportsPage(null, null);
    }

    @Override
    protected ListUtilizationReportsPage createPage(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ListUtilizationReportsResponse response) {
      return new ListUtilizationReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListUtilizationReportsPage> createPageAsync(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ApiFuture<ListUtilizationReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUtilizationReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage,
          ListUtilizationReportsFixedSizeCollection> {

    private ListUtilizationReportsFixedSizeCollection(
        List<ListUtilizationReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUtilizationReportsFixedSizeCollection createEmptyCollection() {
      return new ListUtilizationReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUtilizationReportsFixedSizeCollection createCollection(
        List<ListUtilizationReportsPage> pages, int collectionSize) {
      return new ListUtilizationReportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatacenterConnectorsPagedResponse
      extends AbstractPagedListResponse<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage,
          ListDatacenterConnectorsFixedSizeCollection> {

    public static ApiFuture<ListDatacenterConnectorsPagedResponse> createAsync(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ApiFuture<ListDatacenterConnectorsResponse> futureResponse) {
      ApiFuture<ListDatacenterConnectorsPage> futurePage =
          ListDatacenterConnectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatacenterConnectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatacenterConnectorsPagedResponse(ListDatacenterConnectorsPage page) {
      super(page, ListDatacenterConnectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatacenterConnectorsPage
      extends AbstractPage<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage> {

    private ListDatacenterConnectorsPage(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ListDatacenterConnectorsResponse response) {
      super(context, response);
    }

    private static ListDatacenterConnectorsPage createEmptyPage() {
      return new ListDatacenterConnectorsPage(null, null);
    }

    @Override
    protected ListDatacenterConnectorsPage createPage(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ListDatacenterConnectorsResponse response) {
      return new ListDatacenterConnectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatacenterConnectorsPage> createPageAsync(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ApiFuture<ListDatacenterConnectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatacenterConnectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage,
          ListDatacenterConnectorsFixedSizeCollection> {

    private ListDatacenterConnectorsFixedSizeCollection(
        List<ListDatacenterConnectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatacenterConnectorsFixedSizeCollection createEmptyCollection() {
      return new ListDatacenterConnectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatacenterConnectorsFixedSizeCollection createCollection(
        List<ListDatacenterConnectorsPage> pages, int collectionSize) {
      return new ListDatacenterConnectorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMigratingVmsPagedResponse
      extends AbstractPagedListResponse<
          ListMigratingVmsRequest,
          ListMigratingVmsResponse,
          MigratingVm,
          ListMigratingVmsPage,
          ListMigratingVmsFixedSizeCollection> {

    public static ApiFuture<ListMigratingVmsPagedResponse> createAsync(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ApiFuture<ListMigratingVmsResponse> futureResponse) {
      ApiFuture<ListMigratingVmsPage> futurePage =
          ListMigratingVmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMigratingVmsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMigratingVmsPagedResponse(ListMigratingVmsPage page) {
      super(page, ListMigratingVmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMigratingVmsPage
      extends AbstractPage<
          ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm, ListMigratingVmsPage> {

    private ListMigratingVmsPage(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ListMigratingVmsResponse response) {
      super(context, response);
    }

    private static ListMigratingVmsPage createEmptyPage() {
      return new ListMigratingVmsPage(null, null);
    }

    @Override
    protected ListMigratingVmsPage createPage(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ListMigratingVmsResponse response) {
      return new ListMigratingVmsPage(context, response);
    }

    @Override
    public ApiFuture<ListMigratingVmsPage> createPageAsync(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ApiFuture<ListMigratingVmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMigratingVmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMigratingVmsRequest,
          ListMigratingVmsResponse,
          MigratingVm,
          ListMigratingVmsPage,
          ListMigratingVmsFixedSizeCollection> {

    private ListMigratingVmsFixedSizeCollection(
        List<ListMigratingVmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMigratingVmsFixedSizeCollection createEmptyCollection() {
      return new ListMigratingVmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMigratingVmsFixedSizeCollection createCollection(
        List<ListMigratingVmsPage> pages, int collectionSize) {
      return new ListMigratingVmsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCloneJobsPagedResponse
      extends AbstractPagedListResponse<
          ListCloneJobsRequest,
          ListCloneJobsResponse,
          CloneJob,
          ListCloneJobsPage,
          ListCloneJobsFixedSizeCollection> {

    public static ApiFuture<ListCloneJobsPagedResponse> createAsync(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ApiFuture<ListCloneJobsResponse> futureResponse) {
      ApiFuture<ListCloneJobsPage> futurePage =
          ListCloneJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloneJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloneJobsPagedResponse(ListCloneJobsPage page) {
      super(page, ListCloneJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloneJobsPage
      extends AbstractPage<
          ListCloneJobsRequest, ListCloneJobsResponse, CloneJob, ListCloneJobsPage> {

    private ListCloneJobsPage(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ListCloneJobsResponse response) {
      super(context, response);
    }

    private static ListCloneJobsPage createEmptyPage() {
      return new ListCloneJobsPage(null, null);
    }

    @Override
    protected ListCloneJobsPage createPage(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ListCloneJobsResponse response) {
      return new ListCloneJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListCloneJobsPage> createPageAsync(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ApiFuture<ListCloneJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloneJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloneJobsRequest,
          ListCloneJobsResponse,
          CloneJob,
          ListCloneJobsPage,
          ListCloneJobsFixedSizeCollection> {

    private ListCloneJobsFixedSizeCollection(List<ListCloneJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloneJobsFixedSizeCollection createEmptyCollection() {
      return new ListCloneJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloneJobsFixedSizeCollection createCollection(
        List<ListCloneJobsPage> pages, int collectionSize) {
      return new ListCloneJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCutoverJobsPagedResponse
      extends AbstractPagedListResponse<
          ListCutoverJobsRequest,
          ListCutoverJobsResponse,
          CutoverJob,
          ListCutoverJobsPage,
          ListCutoverJobsFixedSizeCollection> {

    public static ApiFuture<ListCutoverJobsPagedResponse> createAsync(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ApiFuture<ListCutoverJobsResponse> futureResponse) {
      ApiFuture<ListCutoverJobsPage> futurePage =
          ListCutoverJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCutoverJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCutoverJobsPagedResponse(ListCutoverJobsPage page) {
      super(page, ListCutoverJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCutoverJobsPage
      extends AbstractPage<
          ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob, ListCutoverJobsPage> {

    private ListCutoverJobsPage(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ListCutoverJobsResponse response) {
      super(context, response);
    }

    private static ListCutoverJobsPage createEmptyPage() {
      return new ListCutoverJobsPage(null, null);
    }

    @Override
    protected ListCutoverJobsPage createPage(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ListCutoverJobsResponse response) {
      return new ListCutoverJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListCutoverJobsPage> createPageAsync(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ApiFuture<ListCutoverJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCutoverJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCutoverJobsRequest,
          ListCutoverJobsResponse,
          CutoverJob,
          ListCutoverJobsPage,
          ListCutoverJobsFixedSizeCollection> {

    private ListCutoverJobsFixedSizeCollection(
        List<ListCutoverJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCutoverJobsFixedSizeCollection createEmptyCollection() {
      return new ListCutoverJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCutoverJobsFixedSizeCollection createCollection(
        List<ListCutoverJobsPage> pages, int collectionSize) {
      return new ListCutoverJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListGroupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetProjectsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage,
          ListTargetProjectsFixedSizeCollection> {

    public static ApiFuture<ListTargetProjectsPagedResponse> createAsync(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ApiFuture<ListTargetProjectsResponse> futureResponse) {
      ApiFuture<ListTargetProjectsPage> futurePage =
          ListTargetProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTargetProjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTargetProjectsPagedResponse(ListTargetProjectsPage page) {
      super(page, ListTargetProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetProjectsPage
      extends AbstractPage<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage> {

    private ListTargetProjectsPage(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ListTargetProjectsResponse response) {
      super(context, response);
    }

    private static ListTargetProjectsPage createEmptyPage() {
      return new ListTargetProjectsPage(null, null);
    }

    @Override
    protected ListTargetProjectsPage createPage(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ListTargetProjectsResponse response) {
      return new ListTargetProjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetProjectsPage> createPageAsync(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ApiFuture<ListTargetProjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage,
          ListTargetProjectsFixedSizeCollection> {

    private ListTargetProjectsFixedSizeCollection(
        List<ListTargetProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetProjectsFixedSizeCollection createEmptyCollection() {
      return new ListTargetProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetProjectsFixedSizeCollection createCollection(
        List<ListTargetProjectsPage> pages, int collectionSize) {
      return new ListTargetProjectsFixedSizeCollection(pages, collectionSize);
    }
  }
}
