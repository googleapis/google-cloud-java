/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.DatasetServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.DatasetServiceStubSettings;
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
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the DatasetServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of DatasetServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * DatasetServiceSettings datasetServiceSettings =
 *     DatasetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatasetServiceClient datasetServiceClient = DatasetServiceClient.create(datasetServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * DatasetServiceSettings datasetServiceSettings =
 *     DatasetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatasetServiceClient datasetServiceClient = DatasetServiceClient.create(datasetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatasetServiceClient implements BackgroundResource {
  private final DatasetServiceSettings settings;
  private final DatasetServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DatasetServiceClient with default settings. */
  public static final DatasetServiceClient create() throws IOException {
    return create(DatasetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatasetServiceClient create(DatasetServiceSettings settings)
      throws IOException {
    return new DatasetServiceClient(settings);
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DatasetServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DatasetServiceClient create(DatasetServiceStub stub) {
    return new DatasetServiceClient(stub);
  }

  /**
   * Constructs an instance of DatasetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatasetServiceClient(DatasetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatasetServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DatasetServiceClient(DatasetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DatasetServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DatasetServiceStub getStub() {
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
   * Creates a Dataset.
   *
   * @param parent Required. The resource name of the Location to create the Dataset in. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      LocationName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * @param parent Required. The resource name of the Location to create the Dataset in. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetOperationMetadata> createDatasetAsync(
      CreateDatasetRequest request) {
    return createDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable() {
    return stub.createDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * @param name Required. The name of the Dataset resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * @param name Required. The name of the Dataset resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * @param dataset Required. The Dataset which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see [FieldMask](https://tinyurl.com/protobufs/google.protobuf#fieldmask).
   *     Updatable fields:
   *     <p>&#42; `display_name` &#42; `description` &#42; `labels`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(Dataset dataset, FieldMask updateMask) {
    UpdateDatasetRequest request =
        UpdateDatasetRequest.newBuilder().setDataset(dataset).setUpdateMask(updateMask).build();
    return updateDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(UpdateDatasetRequest request) {
    return updateDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return stub.updateDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * @param parent Required. The name of the Dataset's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(LocationName parent) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * @param parent Required. The name of the Dataset's parent resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Datasets in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * @param name Required. The resource name of the Dataset to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(
      DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * @param name Required. The resource name of the Dataset to delete. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDatasetAsync(
      DeleteDatasetRequest request) {
    return deleteDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable() {
    return stub.deleteDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param importConfigs Required. The desired input locations. The contents of all input locations
   *     will be imported in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      DatasetName name, List<ImportDataConfig> importConfigs) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllImportConfigs(importConfigs)
            .build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param importConfigs Required. The desired input locations. The contents of all input locations
   *     will be imported in one batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      String name, List<ImportDataConfig> importConfigs) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder().setName(name).addAllImportConfigs(importConfigs).build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataAsync(
      ImportDataRequest request) {
    return importDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   */
  public final OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return stub.importDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return stub.importDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param exportConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      DatasetName name, ExportDataConfig exportConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setExportConfig(exportConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * @param name Required. The name of the Dataset resource. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @param exportConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      String name, ExportDataConfig exportConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder().setName(name).setExportConfig(exportConfig).build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataResponse, ExportDataOperationMetadata> exportDataAsync(
      ExportDataRequest request) {
    return exportDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   */
  public final OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return stub.exportDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return stub.exportDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * @param parent Required. The resource name of the Dataset to list DataItems from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(DatasetName parent) {
    ListDataItemsRequest request =
        ListDataItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * @param parent Required. The resource name of the Dataset to list DataItems from. Format:
   *     `projects/{project}/locations/{location}/datasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(String parent) {
    ListDataItemsRequest request = ListDataItemsRequest.newBuilder().setParent(parent).build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(ListDataItemsRequest request) {
    return listDataItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return stub.listDataItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataItems in a Dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return stub.listDataItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * @param name Required. The name of the AnnotationSpec resource. Format:
   *     <p>`projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(AnnotationSpecName name) {
    GetAnnotationSpecRequest request =
        GetAnnotationSpecRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnnotationSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * @param name Required. The name of the AnnotationSpec resource. Format:
   *     <p>`projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(String name) {
    GetAnnotationSpecRequest request = GetAnnotationSpecRequest.newBuilder().setName(name).build();
    return getAnnotationSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(GetAnnotationSpecRequest request) {
    return getAnnotationSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an AnnotationSpec.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return stub.getAnnotationSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * @param parent Required. The resource name of the DataItem to list Annotations from. Format:
   *     <p>`projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(DataItemName parent) {
    ListAnnotationsRequest request =
        ListAnnotationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * @param parent Required. The resource name of the DataItem to list Annotations from. Format:
   *     <p>`projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(String parent) {
    ListAnnotationsRequest request = ListAnnotationsRequest.newBuilder().setParent(parent).build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(ListAnnotationsRequest request) {
    return listAnnotationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return stub.listAnnotationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Annotations belongs to a dataitem
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable() {
    return stub.listAnnotationsCallable();
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

  public static class ListDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    public static ApiFuture<ListDatasetsPagedResponse> createAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      ApiFuture<ListDatasetsPage> futurePage =
          ListDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDatasetsPage, ListDatasetsPagedResponse>() {
            @Override
            public ListDatasetsPagedResponse apply(ListDatasetsPage input) {
              return new ListDatasetsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDatasetsPagedResponse(ListDatasetsPage page) {
      super(page, ListDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetsPage
      extends AbstractPage<ListDatasetsRequest, ListDatasetsResponse, Dataset, ListDatasetsPage> {

    private ListDatasetsPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      super(context, response);
    }

    private static ListDatasetsPage createEmptyPage() {
      return new ListDatasetsPage(null, null);
    }

    @Override
    protected ListDatasetsPage createPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      return new ListDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetsPage> createPageAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    private ListDatasetsFixedSizeCollection(List<ListDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetsFixedSizeCollection createCollection(
        List<ListDatasetsPage> pages, int collectionSize) {
      return new ListDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataItemsPagedResponse
      extends AbstractPagedListResponse<
          ListDataItemsRequest,
          ListDataItemsResponse,
          DataItem,
          ListDataItemsPage,
          ListDataItemsFixedSizeCollection> {

    public static ApiFuture<ListDataItemsPagedResponse> createAsync(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ApiFuture<ListDataItemsResponse> futureResponse) {
      ApiFuture<ListDataItemsPage> futurePage =
          ListDataItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDataItemsPage, ListDataItemsPagedResponse>() {
            @Override
            public ListDataItemsPagedResponse apply(ListDataItemsPage input) {
              return new ListDataItemsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDataItemsPagedResponse(ListDataItemsPage page) {
      super(page, ListDataItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataItemsPage
      extends AbstractPage<
          ListDataItemsRequest, ListDataItemsResponse, DataItem, ListDataItemsPage> {

    private ListDataItemsPage(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ListDataItemsResponse response) {
      super(context, response);
    }

    private static ListDataItemsPage createEmptyPage() {
      return new ListDataItemsPage(null, null);
    }

    @Override
    protected ListDataItemsPage createPage(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ListDataItemsResponse response) {
      return new ListDataItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataItemsPage> createPageAsync(
        PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> context,
        ApiFuture<ListDataItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataItemsRequest,
          ListDataItemsResponse,
          DataItem,
          ListDataItemsPage,
          ListDataItemsFixedSizeCollection> {

    private ListDataItemsFixedSizeCollection(List<ListDataItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataItemsFixedSizeCollection createEmptyCollection() {
      return new ListDataItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataItemsFixedSizeCollection createCollection(
        List<ListDataItemsPage> pages, int collectionSize) {
      return new ListDataItemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnnotationsPagedResponse
      extends AbstractPagedListResponse<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    public static ApiFuture<ListAnnotationsPagedResponse> createAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      ApiFuture<ListAnnotationsPage> futurePage =
          ListAnnotationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAnnotationsPage, ListAnnotationsPagedResponse>() {
            @Override
            public ListAnnotationsPagedResponse apply(ListAnnotationsPage input) {
              return new ListAnnotationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAnnotationsPagedResponse(ListAnnotationsPage page) {
      super(page, ListAnnotationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnnotationsPage
      extends AbstractPage<
          ListAnnotationsRequest, ListAnnotationsResponse, Annotation, ListAnnotationsPage> {

    private ListAnnotationsPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      super(context, response);
    }

    private static ListAnnotationsPage createEmptyPage() {
      return new ListAnnotationsPage(null, null);
    }

    @Override
    protected ListAnnotationsPage createPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      return new ListAnnotationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnnotationsPage> createPageAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnnotationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    private ListAnnotationsFixedSizeCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnnotationsFixedSizeCollection createEmptyCollection() {
      return new ListAnnotationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnnotationsFixedSizeCollection createCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      return new ListAnnotationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
