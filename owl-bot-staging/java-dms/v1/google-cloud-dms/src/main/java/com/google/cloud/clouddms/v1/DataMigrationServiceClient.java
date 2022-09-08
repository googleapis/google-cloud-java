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

package com.google.cloud.clouddms.v1;

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
import com.google.cloud.clouddms.v1.stub.DataMigrationServiceStub;
import com.google.cloud.clouddms.v1.stub.DataMigrationServiceStubSettings;
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
 * Service Description: Database Migration service
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
 * try (DataMigrationServiceClient dataMigrationServiceClient =
 *     DataMigrationServiceClient.create()) {
 *   MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");
 *   MigrationJob response = dataMigrationServiceClient.getMigrationJob(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataMigrationServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of DataMigrationServiceSettings
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
 * DataMigrationServiceSettings dataMigrationServiceSettings =
 *     DataMigrationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataMigrationServiceClient dataMigrationServiceClient =
 *     DataMigrationServiceClient.create(dataMigrationServiceSettings);
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
 * DataMigrationServiceSettings dataMigrationServiceSettings =
 *     DataMigrationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataMigrationServiceClient dataMigrationServiceClient =
 *     DataMigrationServiceClient.create(dataMigrationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataMigrationServiceClient implements BackgroundResource {
  private final DataMigrationServiceSettings settings;
  private final DataMigrationServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DataMigrationServiceClient with default settings. */
  public static final DataMigrationServiceClient create() throws IOException {
    return create(DataMigrationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataMigrationServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataMigrationServiceClient create(DataMigrationServiceSettings settings)
      throws IOException {
    return new DataMigrationServiceClient(settings);
  }

  /**
   * Constructs an instance of DataMigrationServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataMigrationServiceSettings).
   */
  public static final DataMigrationServiceClient create(DataMigrationServiceStub stub) {
    return new DataMigrationServiceClient(stub);
  }

  /**
   * Constructs an instance of DataMigrationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataMigrationServiceClient(DataMigrationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataMigrationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected DataMigrationServiceClient(DataMigrationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DataMigrationServiceSettings getSettings() {
    return settings;
  }

  public DataMigrationServiceStub getStub() {
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
   * Lists migration jobs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MigrationJob element :
   *       dataMigrationServiceClient.listMigrationJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrationJobs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationJobsPagedResponse listMigrationJobs(LocationName parent) {
    ListMigrationJobsRequest request =
        ListMigrationJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMigrationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists migration jobs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MigrationJob element :
   *       dataMigrationServiceClient.listMigrationJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrationJobs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationJobsPagedResponse listMigrationJobs(String parent) {
    ListMigrationJobsRequest request =
        ListMigrationJobsRequest.newBuilder().setParent(parent).build();
    return listMigrationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists migration jobs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListMigrationJobsRequest request =
   *       ListMigrationJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MigrationJob element :
   *       dataMigrationServiceClient.listMigrationJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigrationJobsPagedResponse listMigrationJobs(ListMigrationJobsRequest request) {
    return listMigrationJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists migration jobs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListMigrationJobsRequest request =
   *       ListMigrationJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MigrationJob> future =
   *       dataMigrationServiceClient.listMigrationJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigrationJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsPagedResponse>
      listMigrationJobsPagedCallable() {
    return stub.listMigrationJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists migration jobs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListMigrationJobsRequest request =
   *       ListMigrationJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMigrationJobsResponse response =
   *         dataMigrationServiceClient.listMigrationJobsCallable().call(request);
   *     for (MigrationJob element : response.getMigrationJobsList()) {
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
  public final UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsCallable() {
    return stub.listMigrationJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");
   *   MigrationJob response = dataMigrationServiceClient.getMigrationJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the migration job resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationJob getMigrationJob(MigrationJobName name) {
    GetMigrationJobRequest request =
        GetMigrationJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMigrationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString();
   *   MigrationJob response = dataMigrationServiceClient.getMigrationJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the migration job resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationJob getMigrationJob(String name) {
    GetMigrationJobRequest request = GetMigrationJobRequest.newBuilder().setName(name).build();
    return getMigrationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GetMigrationJobRequest request =
   *       GetMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.getMigrationJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigrationJob getMigrationJob(GetMigrationJobRequest request) {
    return getMigrationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GetMigrationJobRequest request =
   *       GetMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<MigrationJob> future =
   *       dataMigrationServiceClient.getMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMigrationJobRequest, MigrationJob> getMigrationJobCallable() {
    return stub.getMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new migration job in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MigrationJob migrationJob = MigrationJob.newBuilder().build();
   *   String migrationJobId = "migrationJobId1870575242";
   *   MigrationJob response =
   *       dataMigrationServiceClient
   *           .createMigrationJobAsync(parent, migrationJob, migrationJobId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migration jobs.
   * @param migrationJob Required. Represents a [migration
   *     job](https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs)
   *     object.
   * @param migrationJobId Required. The ID of the instance to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> createMigrationJobAsync(
      LocationName parent, MigrationJob migrationJob, String migrationJobId) {
    CreateMigrationJobRequest request =
        CreateMigrationJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMigrationJob(migrationJob)
            .setMigrationJobId(migrationJobId)
            .build();
    return createMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new migration job in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MigrationJob migrationJob = MigrationJob.newBuilder().build();
   *   String migrationJobId = "migrationJobId1870575242";
   *   MigrationJob response =
   *       dataMigrationServiceClient
   *           .createMigrationJobAsync(parent, migrationJob, migrationJobId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migration jobs.
   * @param migrationJob Required. Represents a [migration
   *     job](https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs)
   *     object.
   * @param migrationJobId Required. The ID of the instance to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> createMigrationJobAsync(
      String parent, MigrationJob migrationJob, String migrationJobId) {
    CreateMigrationJobRequest request =
        CreateMigrationJobRequest.newBuilder()
            .setParent(parent)
            .setMigrationJob(migrationJob)
            .setMigrationJobId(migrationJobId)
            .build();
    return createMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new migration job in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateMigrationJobRequest request =
   *       CreateMigrationJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMigrationJobId("migrationJobId1870575242")
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.createMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> createMigrationJobAsync(
      CreateMigrationJobRequest request) {
    return createMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new migration job in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateMigrationJobRequest request =
   *       CreateMigrationJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMigrationJobId("migrationJobId1870575242")
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.createMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationCallable() {
    return stub.createMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new migration job in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateMigrationJobRequest request =
   *       CreateMigrationJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMigrationJobId("migrationJobId1870575242")
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.createMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMigrationJobRequest, Operation> createMigrationJobCallable() {
    return stub.createMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   MigrationJob migrationJob = MigrationJob.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MigrationJob response =
   *       dataMigrationServiceClient.updateMigrationJobAsync(migrationJob, updateMask).get();
   * }
   * }</pre>
   *
   * @param migrationJob Required. The migration job parameters to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     migration job resource by the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> updateMigrationJobAsync(
      MigrationJob migrationJob, FieldMask updateMask) {
    UpdateMigrationJobRequest request =
        UpdateMigrationJobRequest.newBuilder()
            .setMigrationJob(migrationJob)
            .setUpdateMask(updateMask)
            .build();
    return updateMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateMigrationJobRequest request =
   *       UpdateMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.updateMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> updateMigrationJobAsync(
      UpdateMigrationJobRequest request) {
    return updateMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateMigrationJobRequest request =
   *       UpdateMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.updateMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationCallable() {
    return stub.updateMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateMigrationJobRequest request =
   *       UpdateMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigrationJob(MigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.updateMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMigrationJobRequest, Operation> updateMigrationJobCallable() {
    return stub.updateMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   MigrationJobName name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]");
   *   dataMigrationServiceClient.deleteMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the migration job resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigrationJobAsync(
      MigrationJobName name) {
    DeleteMigrationJobRequest request =
        DeleteMigrationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String name = MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString();
   *   dataMigrationServiceClient.deleteMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the migration job resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigrationJobAsync(String name) {
    DeleteMigrationJobRequest request =
        DeleteMigrationJobRequest.newBuilder().setName(name).build();
    return deleteMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteMigrationJobRequest request =
   *       DeleteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   dataMigrationServiceClient.deleteMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigrationJobAsync(
      DeleteMigrationJobRequest request) {
    return deleteMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteMigrationJobRequest request =
   *       DeleteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataMigrationServiceClient.deleteMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationCallable() {
    return stub.deleteMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteMigrationJobRequest request =
   *       DeleteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.deleteMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMigrationJobRequest, Operation> deleteMigrationJobCallable() {
    return stub.deleteMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an already created migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StartMigrationJobRequest request =
   *       StartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.startMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> startMigrationJobAsync(
      StartMigrationJobRequest request) {
    return startMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an already created migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StartMigrationJobRequest request =
   *       StartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.startMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationCallable() {
    return stub.startMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an already created migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StartMigrationJobRequest request =
   *       StartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.startMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartMigrationJobRequest, Operation> startMigrationJobCallable() {
    return stub.startMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StopMigrationJobRequest request =
   *       StopMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.stopMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> stopMigrationJobAsync(
      StopMigrationJobRequest request) {
    return stopMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StopMigrationJobRequest request =
   *       StopMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.stopMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationCallable() {
    return stub.stopMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   StopMigrationJobRequest request =
   *       StopMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.stopMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopMigrationJobRequest, Operation> stopMigrationJobCallable() {
    return stub.stopMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a migration job that is currently stopped and is resumable (was stopped during CDC
   * phase).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ResumeMigrationJobRequest request =
   *       ResumeMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.resumeMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> resumeMigrationJobAsync(
      ResumeMigrationJobRequest request) {
    return resumeMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a migration job that is currently stopped and is resumable (was stopped during CDC
   * phase).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ResumeMigrationJobRequest request =
   *       ResumeMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.resumeMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationCallable() {
    return stub.resumeMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a migration job that is currently stopped and is resumable (was stopped during CDC
   * phase).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ResumeMigrationJobRequest request =
   *       ResumeMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.resumeMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeMigrationJobRequest, Operation> resumeMigrationJobCallable() {
    return stub.resumeMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Promote a migration job, stopping replication to the destination and promoting the destination
   * to be a standalone database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   PromoteMigrationJobRequest request =
   *       PromoteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.promoteMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> promoteMigrationJobAsync(
      PromoteMigrationJobRequest request) {
    return promoteMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Promote a migration job, stopping replication to the destination and promoting the destination
   * to be a standalone database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   PromoteMigrationJobRequest request =
   *       PromoteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.promoteMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationCallable() {
    return stub.promoteMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Promote a migration job, stopping replication to the destination and promoting the destination
   * to be a standalone database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   PromoteMigrationJobRequest request =
   *       PromoteMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.promoteMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PromoteMigrationJobRequest, Operation> promoteMigrationJobCallable() {
    return stub.promoteMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify a migration job, making sure the destination can reach the source and that all
   * configuration and prerequisites are met.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   VerifyMigrationJobRequest request =
   *       VerifyMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.verifyMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> verifyMigrationJobAsync(
      VerifyMigrationJobRequest request) {
    return verifyMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify a migration job, making sure the destination can reach the source and that all
   * configuration and prerequisites are met.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   VerifyMigrationJobRequest request =
   *       VerifyMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.verifyMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationCallable() {
    return stub.verifyMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify a migration job, making sure the destination can reach the source and that all
   * configuration and prerequisites are met.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   VerifyMigrationJobRequest request =
   *       VerifyMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.verifyMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<VerifyMigrationJobRequest, Operation> verifyMigrationJobCallable() {
    return stub.verifyMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a stopped or failed migration job, resetting the destination instance to its original
   * state and starting the migration process from scratch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   RestartMigrationJobRequest request =
   *       RestartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   MigrationJob response = dataMigrationServiceClient.restartMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigrationJob, OperationMetadata> restartMigrationJobAsync(
      RestartMigrationJobRequest request) {
    return restartMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a stopped or failed migration job, resetting the destination instance to its original
   * state and starting the migration process from scratch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   RestartMigrationJobRequest request =
   *       RestartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   OperationFuture<MigrationJob, OperationMetadata> future =
   *       dataMigrationServiceClient.restartMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   MigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationCallable() {
    return stub.restartMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a stopped or failed migration job, resetting the destination instance to its original
   * state and starting the migration process from scratch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   RestartMigrationJobRequest request =
   *       RestartMigrationJobRequest.newBuilder()
   *           .setName(MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.restartMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartMigrationJobRequest, Operation> restartMigrationJobCallable() {
    return stub.restartMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a SSH configuration script to configure the reverse SSH connectivity.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GenerateSshScriptRequest request =
   *       GenerateSshScriptRequest.newBuilder()
   *           .setMigrationJob(
   *               MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .setVm("vm3767")
   *           .setVmPort(563010825)
   *           .build();
   *   SshScript response = dataMigrationServiceClient.generateSshScript(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshScript generateSshScript(GenerateSshScriptRequest request) {
    return generateSshScriptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate a SSH configuration script to configure the reverse SSH connectivity.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GenerateSshScriptRequest request =
   *       GenerateSshScriptRequest.newBuilder()
   *           .setMigrationJob(
   *               MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
   *           .setVm("vm3767")
   *           .setVmPort(563010825)
   *           .build();
   *   ApiFuture<SshScript> future =
   *       dataMigrationServiceClient.generateSshScriptCallable().futureCall(request);
   *   // Do something.
   *   SshScript response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateSshScriptRequest, SshScript> generateSshScriptCallable() {
    return stub.generateSshScriptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of all connection profiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ConnectionProfile element :
   *       dataMigrationServiceClient.listConnectionProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connection profiles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(LocationName parent) {
    ListConnectionProfilesRequest request =
        ListConnectionProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnectionProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of all connection profiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ConnectionProfile element :
   *       dataMigrationServiceClient.listConnectionProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connection profiles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(String parent) {
    ListConnectionProfilesRequest request =
        ListConnectionProfilesRequest.newBuilder().setParent(parent).build();
    return listConnectionProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of all connection profiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ConnectionProfile element :
   *       dataMigrationServiceClient.listConnectionProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionProfilesPagedResponse listConnectionProfiles(
      ListConnectionProfilesRequest request) {
    return listConnectionProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of all connection profiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ConnectionProfile> future =
   *       dataMigrationServiceClient.listConnectionProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConnectionProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    return stub.listConnectionProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of all connection profiles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ListConnectionProfilesRequest request =
   *       ListConnectionProfilesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectionProfilesResponse response =
   *         dataMigrationServiceClient.listConnectionProfilesCallable().call(request);
   *     for (ConnectionProfile element : response.getConnectionProfilesList()) {
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
  public final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    return stub.listConnectionProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ConnectionProfileName name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
   *   ConnectionProfile response = dataMigrationServiceClient.getConnectionProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the connection profile resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(ConnectionProfileName name) {
    GetConnectionProfileRequest request =
        GetConnectionProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConnectionProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]").toString();
   *   ConnectionProfile response = dataMigrationServiceClient.getConnectionProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the connection profile resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(String name) {
    GetConnectionProfileRequest request =
        GetConnectionProfileRequest.newBuilder().setName(name).build();
    return getConnectionProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GetConnectionProfileRequest request =
   *       GetConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ConnectionProfile response = dataMigrationServiceClient.getConnectionProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProfile getConnectionProfile(GetConnectionProfileRequest request) {
    return getConnectionProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   GetConnectionProfileRequest request =
   *       GetConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ConnectionProfile> future =
   *       dataMigrationServiceClient.getConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    return stub.getConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection profile in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ConnectionProfileName parent =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   String connectionProfileId = "connectionProfileId597575526";
   *   ConnectionProfile response =
   *       dataMigrationServiceClient
   *           .createConnectionProfileAsync(parent, connectionProfile, connectionProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connection profiles.
   * @param connectionProfile Required. The create request body including the connection profile
   *     data
   * @param connectionProfileId Required. The connection profile identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      ConnectionProfileName parent,
      ConnectionProfile connectionProfile,
      String connectionProfileId) {
    CreateConnectionProfileRequest request =
        CreateConnectionProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnectionProfile(connectionProfile)
            .setConnectionProfileId(connectionProfileId)
            .build();
    return createConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection profile in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String parent =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]").toString();
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   String connectionProfileId = "connectionProfileId597575526";
   *   ConnectionProfile response =
   *       dataMigrationServiceClient
   *           .createConnectionProfileAsync(parent, connectionProfile, connectionProfileId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connection profiles.
   * @param connectionProfile Required. The create request body including the connection profile
   *     data
   * @param connectionProfileId Required. The connection profile identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      String parent, ConnectionProfile connectionProfile, String connectionProfileId) {
    CreateConnectionProfileRequest request =
        CreateConnectionProfileRequest.newBuilder()
            .setParent(parent)
            .setConnectionProfile(connectionProfile)
            .setConnectionProfileId(connectionProfileId)
            .build();
    return createConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection profile in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ConnectionProfile response =
   *       dataMigrationServiceClient.createConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> createConnectionProfileAsync(
      CreateConnectionProfileRequest request) {
    return createConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection profile in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ConnectionProfile, OperationMetadata> future =
   *       dataMigrationServiceClient.createConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    return stub.createConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection profile in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   CreateConnectionProfileRequest request =
   *       CreateConnectionProfileRequest.newBuilder()
   *           .setParent(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setConnectionProfileId("connectionProfileId597575526")
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.createConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    return stub.createConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the configuration of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConnectionProfile response =
   *       dataMigrationServiceClient
   *           .updateConnectionProfileAsync(connectionProfile, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param connectionProfile Required. The connection profile parameters to update.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     connection profile resource by the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> updateConnectionProfileAsync(
      ConnectionProfile connectionProfile, FieldMask updateMask) {
    UpdateConnectionProfileRequest request =
        UpdateConnectionProfileRequest.newBuilder()
            .setConnectionProfile(connectionProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the configuration of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ConnectionProfile response =
   *       dataMigrationServiceClient.updateConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectionProfile, OperationMetadata> updateConnectionProfileAsync(
      UpdateConnectionProfileRequest request) {
    return updateConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the configuration of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ConnectionProfile, OperationMetadata> future =
   *       dataMigrationServiceClient.updateConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectionProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    return stub.updateConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the configuration of a single connection profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   UpdateConnectionProfileRequest request =
   *       UpdateConnectionProfileRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectionProfile(ConnectionProfile.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.updateConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    return stub.updateConnectionProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Database Migration Service connection profile. A connection profile can only
   * be deleted if it is not in use by any active migration jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   ConnectionProfileName name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
   *   dataMigrationServiceClient.deleteConnectionProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the connection profile resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(
      ConnectionProfileName name) {
    DeleteConnectionProfileRequest request =
        DeleteConnectionProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Database Migration Service connection profile. A connection profile can only
   * be deleted if it is not in use by any active migration jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   String name =
   *       ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]").toString();
   *   dataMigrationServiceClient.deleteConnectionProfileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the connection profile resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(String name) {
    DeleteConnectionProfileRequest request =
        DeleteConnectionProfileRequest.newBuilder().setName(name).build();
    return deleteConnectionProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Database Migration Service connection profile. A connection profile can only
   * be deleted if it is not in use by any active migration jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   dataMigrationServiceClient.deleteConnectionProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionProfileAsync(
      DeleteConnectionProfileRequest request) {
    return deleteConnectionProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Database Migration Service connection profile. A connection profile can only
   * be deleted if it is not in use by any active migration jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataMigrationServiceClient.deleteConnectionProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    return stub.deleteConnectionProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Database Migration Service connection profile. A connection profile can only
   * be deleted if it is not in use by any active migration jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataMigrationServiceClient dataMigrationServiceClient =
   *     DataMigrationServiceClient.create()) {
   *   DeleteConnectionProfileRequest request =
   *       DeleteConnectionProfileRequest.newBuilder()
   *           .setName(
   *               ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataMigrationServiceClient.deleteConnectionProfileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    return stub.deleteConnectionProfileCallable();
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

  public static class ListMigrationJobsPagedResponse
      extends AbstractPagedListResponse<
          ListMigrationJobsRequest,
          ListMigrationJobsResponse,
          MigrationJob,
          ListMigrationJobsPage,
          ListMigrationJobsFixedSizeCollection> {

    public static ApiFuture<ListMigrationJobsPagedResponse> createAsync(
        PageContext<ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob> context,
        ApiFuture<ListMigrationJobsResponse> futureResponse) {
      ApiFuture<ListMigrationJobsPage> futurePage =
          ListMigrationJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMigrationJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMigrationJobsPagedResponse(ListMigrationJobsPage page) {
      super(page, ListMigrationJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMigrationJobsPage
      extends AbstractPage<
          ListMigrationJobsRequest,
          ListMigrationJobsResponse,
          MigrationJob,
          ListMigrationJobsPage> {

    private ListMigrationJobsPage(
        PageContext<ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob> context,
        ListMigrationJobsResponse response) {
      super(context, response);
    }

    private static ListMigrationJobsPage createEmptyPage() {
      return new ListMigrationJobsPage(null, null);
    }

    @Override
    protected ListMigrationJobsPage createPage(
        PageContext<ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob> context,
        ListMigrationJobsResponse response) {
      return new ListMigrationJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListMigrationJobsPage> createPageAsync(
        PageContext<ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob> context,
        ApiFuture<ListMigrationJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMigrationJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMigrationJobsRequest,
          ListMigrationJobsResponse,
          MigrationJob,
          ListMigrationJobsPage,
          ListMigrationJobsFixedSizeCollection> {

    private ListMigrationJobsFixedSizeCollection(
        List<ListMigrationJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMigrationJobsFixedSizeCollection createEmptyCollection() {
      return new ListMigrationJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMigrationJobsFixedSizeCollection createCollection(
        List<ListMigrationJobsPage> pages, int collectionSize) {
      return new ListMigrationJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConnectionProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage,
          ListConnectionProfilesFixedSizeCollection> {

    public static ApiFuture<ListConnectionProfilesPagedResponse> createAsync(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ApiFuture<ListConnectionProfilesResponse> futureResponse) {
      ApiFuture<ListConnectionProfilesPage> futurePage =
          ListConnectionProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectionProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectionProfilesPagedResponse(ListConnectionProfilesPage page) {
      super(page, ListConnectionProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectionProfilesPage
      extends AbstractPage<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage> {

    private ListConnectionProfilesPage(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ListConnectionProfilesResponse response) {
      super(context, response);
    }

    private static ListConnectionProfilesPage createEmptyPage() {
      return new ListConnectionProfilesPage(null, null);
    }

    @Override
    protected ListConnectionProfilesPage createPage(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ListConnectionProfilesResponse response) {
      return new ListConnectionProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectionProfilesPage> createPageAsync(
        PageContext<
                ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
            context,
        ApiFuture<ListConnectionProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectionProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ConnectionProfile,
          ListConnectionProfilesPage,
          ListConnectionProfilesFixedSizeCollection> {

    private ListConnectionProfilesFixedSizeCollection(
        List<ListConnectionProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectionProfilesFixedSizeCollection createEmptyCollection() {
      return new ListConnectionProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectionProfilesFixedSizeCollection createCollection(
        List<ListConnectionProfilesPage> pages, int collectionSize) {
      return new ListConnectionProfilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
