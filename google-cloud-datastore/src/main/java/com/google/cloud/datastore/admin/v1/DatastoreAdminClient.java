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

package com.google.cloud.datastore.admin.v1;

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
import com.google.cloud.datastore.admin.v1.stub.DatastoreAdminStub;
import com.google.cloud.datastore.admin.v1.stub.DatastoreAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.datastore.admin.v1.CreateIndexRequest;
import com.google.datastore.admin.v1.DeleteIndexRequest;
import com.google.datastore.admin.v1.EntityFilter;
import com.google.datastore.admin.v1.ExportEntitiesMetadata;
import com.google.datastore.admin.v1.ExportEntitiesRequest;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import com.google.datastore.admin.v1.GetIndexRequest;
import com.google.datastore.admin.v1.ImportEntitiesMetadata;
import com.google.datastore.admin.v1.ImportEntitiesRequest;
import com.google.datastore.admin.v1.Index;
import com.google.datastore.admin.v1.IndexOperationMetadata;
import com.google.datastore.admin.v1.ListIndexesRequest;
import com.google.datastore.admin.v1.ListIndexesResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud Datastore Admin API
 *
 * <p>The Datastore Admin API provides several admin services for Cloud Datastore.
 *
 * <p>----------------------------------------------------------------------------- ## Concepts
 *
 * <p>Project, namespace, kind, and entity as defined in the Google Cloud Datastore API.
 *
 * <p>Operation: An Operation represents work being performed in the background.
 *
 * <p>EntityFilter: Allows specifying a subset of entities in a project. This is specified as a
 * combination of kinds and namespaces (either or both of which may be all).
 *
 * <p>----------------------------------------------------------------------------- ## Services
 *
 * <p># Export/Import
 *
 * <p>The Export/Import service provides the ability to copy all or a subset of entities to/from
 * Google Cloud Storage.
 *
 * <p>Exported data may be imported into Cloud Datastore for any Google Cloud Platform project. It
 * is not restricted to the export source project. It is possible to export from one project and
 * then import into another.
 *
 * <p>Exported data can also be loaded into Google BigQuery for analysis.
 *
 * <p>Exports and imports are performed asynchronously. An Operation resource is created for each
 * export/import. The state (including any errors encountered) of the export/import may be queried
 * via the Operation resource.
 *
 * <p># Index
 *
 * <p>The index service manages Cloud Datastore composite indexes.
 *
 * <p>Index creation and deletion are performed asynchronously. An Operation resource is created for
 * each such asynchronous operation. The state of the operation (including any errors encountered)
 * may be queried via the Operation resource.
 *
 * <p># Operation
 *
 * <p>The Operations collection provides a record of actions performed for the specified project
 * (including any operations in progress). Operations are not created directly but through calls on
 * other collections or resources.
 *
 * <p>An operation that is not yet done may be cancelled. The request to cancel is asynchronous and
 * the operation may continue to run for some time after the request to cancel is made.
 *
 * <p>An operation that is done may be deleted so that it is no longer listed as part of the
 * Operation collection.
 *
 * <p>ListOperations returns all pending operations, but not completed operations.
 *
 * <p>Operations are created by service DatastoreAdmin, but are accessed via service
 * google.longrunning.Operations.
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
 * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
 *   GetIndexRequest request =
 *       GetIndexRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setIndexId("indexId1943291277")
 *           .build();
 *   Index response = datastoreAdminClient.getIndex(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatastoreAdminClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of DatastoreAdminSettings to
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
 * DatastoreAdminSettings datastoreAdminSettings =
 *     DatastoreAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create(datastoreAdminSettings);
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
 * DatastoreAdminSettings datastoreAdminSettings =
 *     DatastoreAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create(datastoreAdminSettings);
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
 * DatastoreAdminSettings datastoreAdminSettings =
 *     DatastoreAdminSettings.newHttpJsonBuilder().build();
 * DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create(datastoreAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DatastoreAdminClient implements BackgroundResource {
  private final DatastoreAdminSettings settings;
  private final DatastoreAdminStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DatastoreAdminClient with default settings. */
  public static final DatastoreAdminClient create() throws IOException {
    return create(DatastoreAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatastoreAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatastoreAdminClient create(DatastoreAdminSettings settings)
      throws IOException {
    return new DatastoreAdminClient(settings);
  }

  /**
   * Constructs an instance of DatastoreAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DatastoreAdminSettings).
   */
  public static final DatastoreAdminClient create(DatastoreAdminStub stub) {
    return new DatastoreAdminClient(stub);
  }

  /**
   * Constructs an instance of DatastoreAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatastoreAdminClient(DatastoreAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatastoreAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DatastoreAdminClient(DatastoreAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DatastoreAdminSettings getSettings() {
    return settings;
  }

  public DatastoreAdminStub getStub() {
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
   * Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage
   * system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   String projectId = "projectId-894832108";
   *   Map<String, String> labels = new HashMap<>();
   *   EntityFilter entityFilter = EntityFilter.newBuilder().build();
   *   String outputUrlPrefix = "outputUrlPrefix-1132598048";
   *   ExportEntitiesResponse response =
   *       datastoreAdminClient
   *           .exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix)
   *           .get();
   * }
   * }</pre>
   *
   * @param projectId Required. Project ID against which to make the request.
   * @param labels Client-assigned labels.
   * @param entityFilter Description of what data from the project is included in the export.
   * @param outputUrlPrefix Required. Location for the export metadata and data files.
   *     <p>The full resource URL of the external storage location. Currently, only Google Cloud
   *     Storage is supported. So output_url_prefix should be of the form:
   *     `gs://BUCKET_NAME[/NAMESPACE_PATH]`, where `BUCKET_NAME` is the name of the Cloud Storage
   *     bucket and `NAMESPACE_PATH` is an optional Cloud Storage namespace path (this is not a
   *     Cloud Datastore namespace). For more information about Cloud Storage namespace paths, see
   *     [Object name
   *     considerations](https://cloud.google.com/storage/docs/naming#object-considerations).
   *     <p>The resulting files will be nested deeper than the specified URL prefix. The final
   *     output URL will be provided in the
   *     [google.datastore.admin.v1.ExportEntitiesResponse.output_url][google.datastore.admin.v1.ExportEntitiesResponse.output_url]
   *     field. That value should be used for subsequent ImportEntities operations.
   *     <p>By nesting the data files deeper, the same Cloud Storage bucket can be used in multiple
   *     ExportEntities operations without conflict.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportEntitiesResponse, ExportEntitiesMetadata> exportEntitiesAsync(
      String projectId,
      Map<String, String> labels,
      EntityFilter entityFilter,
      String outputUrlPrefix) {
    ExportEntitiesRequest request =
        ExportEntitiesRequest.newBuilder()
            .setProjectId(projectId)
            .putAllLabels(labels)
            .setEntityFilter(entityFilter)
            .setOutputUrlPrefix(outputUrlPrefix)
            .build();
    return exportEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage
   * system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ExportEntitiesRequest request =
   *       ExportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .setOutputUrlPrefix("outputUrlPrefix-1132598048")
   *           .build();
   *   ExportEntitiesResponse response = datastoreAdminClient.exportEntitiesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportEntitiesResponse, ExportEntitiesMetadata> exportEntitiesAsync(
      ExportEntitiesRequest request) {
    return exportEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage
   * system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ExportEntitiesRequest request =
   *       ExportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .setOutputUrlPrefix("outputUrlPrefix-1132598048")
   *           .build();
   *   OperationFuture<ExportEntitiesResponse, ExportEntitiesMetadata> future =
   *       datastoreAdminClient.exportEntitiesOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportEntitiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportEntitiesRequest, ExportEntitiesResponse, ExportEntitiesMetadata>
      exportEntitiesOperationCallable() {
    return stub.exportEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage
   * system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ExportEntitiesRequest request =
   *       ExportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .setOutputUrlPrefix("outputUrlPrefix-1132598048")
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastoreAdminClient.exportEntitiesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportEntitiesRequest, Operation> exportEntitiesCallable() {
    return stub.exportEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports entities into Google Cloud Datastore. Existing entities with the same key are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportEntities operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   String projectId = "projectId-894832108";
   *   Map<String, String> labels = new HashMap<>();
   *   String inputUrl = "inputUrl470706501";
   *   EntityFilter entityFilter = EntityFilter.newBuilder().build();
   *   datastoreAdminClient.importEntitiesAsync(projectId, labels, inputUrl, entityFilter).get();
   * }
   * }</pre>
   *
   * @param projectId Required. Project ID against which to make the request.
   * @param labels Client-assigned labels.
   * @param inputUrl Required. The full resource URL of the external storage location. Currently,
   *     only Google Cloud Storage is supported. So input_url should be of the form:
   *     `gs://BUCKET_NAME[/NAMESPACE_PATH]/OVERALL_EXPORT_METADATA_FILE`, where `BUCKET_NAME` is
   *     the name of the Cloud Storage bucket, `NAMESPACE_PATH` is an optional Cloud Storage
   *     namespace path (this is not a Cloud Datastore namespace), and
   *     `OVERALL_EXPORT_METADATA_FILE` is the metadata file written by the ExportEntities
   *     operation. For more information about Cloud Storage namespace paths, see [Object name
   *     considerations](https://cloud.google.com/storage/docs/naming#object-considerations).
   *     <p>For more information, see
   *     [google.datastore.admin.v1.ExportEntitiesResponse.output_url][google.datastore.admin.v1.ExportEntitiesResponse.output_url].
   * @param entityFilter Optionally specify which kinds/namespaces are to be imported. If provided,
   *     the list must be a subset of the EntityFilter used in creating the export, otherwise a
   *     FAILED_PRECONDITION error will be returned. If no filter is specified then all entities
   *     from the export are imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportEntitiesMetadata> importEntitiesAsync(
      String projectId, Map<String, String> labels, String inputUrl, EntityFilter entityFilter) {
    ImportEntitiesRequest request =
        ImportEntitiesRequest.newBuilder()
            .setProjectId(projectId)
            .putAllLabels(labels)
            .setInputUrl(inputUrl)
            .setEntityFilter(entityFilter)
            .build();
    return importEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports entities into Google Cloud Datastore. Existing entities with the same key are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportEntities operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ImportEntitiesRequest request =
   *       ImportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setInputUrl("inputUrl470706501")
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .build();
   *   datastoreAdminClient.importEntitiesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportEntitiesMetadata> importEntitiesAsync(
      ImportEntitiesRequest request) {
    return importEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports entities into Google Cloud Datastore. Existing entities with the same key are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportEntities operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ImportEntitiesRequest request =
   *       ImportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setInputUrl("inputUrl470706501")
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, ImportEntitiesMetadata> future =
   *       datastoreAdminClient.importEntitiesOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportEntitiesRequest, Empty, ImportEntitiesMetadata>
      importEntitiesOperationCallable() {
    return stub.importEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports entities into Google Cloud Datastore. Existing entities with the same key are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportEntities operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ImportEntitiesRequest request =
   *       ImportEntitiesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setInputUrl("inputUrl470706501")
   *           .setEntityFilter(EntityFilter.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       datastoreAdminClient.importEntitiesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportEntitiesRequest, Operation> importEntitiesCallable() {
    return stub.importEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the specified index. A newly created index's initial state is `CREATING`. On completion
   * of the returned [google.longrunning.Operation][google.longrunning.Operation], the state will be
   * `READY`. If the index already exists, the call will return an `ALREADY_EXISTS` status.
   *
   * <p>During index creation, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, removing the index with [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex],
   * then re-creating the index with [create]
   * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
   *
   * <p>Indexes with a single property cannot be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   Index response = datastoreAdminClient.createIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, IndexOperationMetadata> createIndexAsync(
      CreateIndexRequest request) {
    return createIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the specified index. A newly created index's initial state is `CREATING`. On completion
   * of the returned [google.longrunning.Operation][google.longrunning.Operation], the state will be
   * `READY`. If the index already exists, the call will return an `ALREADY_EXISTS` status.
   *
   * <p>During index creation, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, removing the index with [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex],
   * then re-creating the index with [create]
   * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
   *
   * <p>Indexes with a single property cannot be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, IndexOperationMetadata> future =
   *       datastoreAdminClient.createIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    return stub.createIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the specified index. A newly created index's initial state is `CREATING`. On completion
   * of the returned [google.longrunning.Operation][google.longrunning.Operation], the state will be
   * `READY`. If the index already exists, the call will return an `ALREADY_EXISTS` status.
   *
   * <p>During index creation, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, removing the index with [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex],
   * then re-creating the index with [create]
   * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
   *
   * <p>Indexes with a single property cannot be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = datastoreAdminClient.createIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return stub.createIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing index. An index can only be deleted if it is in a `READY` or `ERROR` state.
   * On successful execution of the request, the index will be in a `DELETING`
   * [state][google.datastore.admin.v1.Index.State]. And on completion of the returned
   * [google.longrunning.Operation][google.longrunning.Operation], the index will be removed.
   *
   * <p>During index deletion, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, followed by calling [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex]
   * again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndexId("indexId1943291277")
   *           .build();
   *   Index response = datastoreAdminClient.deleteIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, IndexOperationMetadata> deleteIndexAsync(
      DeleteIndexRequest request) {
    return deleteIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing index. An index can only be deleted if it is in a `READY` or `ERROR` state.
   * On successful execution of the request, the index will be in a `DELETING`
   * [state][google.datastore.admin.v1.Index.State]. And on completion of the returned
   * [google.longrunning.Operation][google.longrunning.Operation], the index will be removed.
   *
   * <p>During index deletion, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, followed by calling [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex]
   * again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndexId("indexId1943291277")
   *           .build();
   *   OperationFuture<Index, IndexOperationMetadata> future =
   *       datastoreAdminClient.deleteIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIndexRequest, Index, IndexOperationMetadata>
      deleteIndexOperationCallable() {
    return stub.deleteIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing index. An index can only be deleted if it is in a `READY` or `ERROR` state.
   * On successful execution of the request, the index will be in a `DELETING`
   * [state][google.datastore.admin.v1.Index.State]. And on completion of the returned
   * [google.longrunning.Operation][google.longrunning.Operation], the index will be removed.
   *
   * <p>During index deletion, the process could result in an error, in which case the index will
   * move to the `ERROR` state. The process can be recovered by fixing the data that caused the
   * error, followed by calling [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex]
   * again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndexId("indexId1943291277")
   *           .build();
   *   ApiFuture<Operation> future = datastoreAdminClient.deleteIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return stub.deleteIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndexId("indexId1943291277")
   *           .build();
   *   Index response = datastoreAdminClient.getIndex(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(GetIndexRequest request) {
    return getIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setIndexId("indexId1943291277")
   *           .build();
   *   ApiFuture<Index> future = datastoreAdminClient.getIndexCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return stub.getIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the indexes that match the specified filters. Datastore uses an eventually consistent
   * query to fetch the list of indexes and may occasionally return stale results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Index element : datastoreAdminClient.listIndexes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ListIndexesRequest request) {
    return listIndexesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the indexes that match the specified filters. Datastore uses an eventually consistent
   * query to fetch the list of indexes and may occasionally return stale results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Index> future = datastoreAdminClient.listIndexesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Index element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable() {
    return stub.listIndexesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the indexes that match the specified filters. Datastore uses an eventually consistent
   * query to fetch the list of indexes and may occasionally return stale results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIndexesResponse response = datastoreAdminClient.listIndexesCallable().call(request);
   *     for (Index element : response.getIndexesList()) {
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
  public final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return stub.listIndexesCallable();
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

  public static class ListIndexesPagedResponse
      extends AbstractPagedListResponse<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    public static ApiFuture<ListIndexesPagedResponse> createAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      ApiFuture<ListIndexesPage> futurePage =
          ListIndexesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListIndexesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListIndexesPagedResponse(ListIndexesPage page) {
      super(page, ListIndexesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexesPage
      extends AbstractPage<ListIndexesRequest, ListIndexesResponse, Index, ListIndexesPage> {

    private ListIndexesPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      super(context, response);
    }

    private static ListIndexesPage createEmptyPage() {
      return new ListIndexesPage(null, null);
    }

    @Override
    protected ListIndexesPage createPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      return new ListIndexesPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexesPage> createPageAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    private ListIndexesFixedSizeCollection(List<ListIndexesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexesFixedSizeCollection createEmptyCollection() {
      return new ListIndexesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexesFixedSizeCollection createCollection(
        List<ListIndexesPage> pages, int collectionSize) {
      return new ListIndexesFixedSizeCollection(pages, collectionSize);
    }
  }
}
