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

package com.google.cloud.datalabeling.v1beta1;

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
import com.google.cloud.datalabeling.v1beta1.stub.DataLabelingServiceStub;
import com.google.cloud.datalabeling.v1beta1.stub.DataLabelingServiceStubSettings;
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
 * Service Description: Service for the AI Platform Data Labeling API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the DataLabelingServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DataLabelingServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * DataLabelingServiceSettings dataLabelingServiceSettings =
 *     DataLabelingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataLabelingServiceClient dataLabelingServiceClient =
 *     DataLabelingServiceClient.create(dataLabelingServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * DataLabelingServiceSettings dataLabelingServiceSettings =
 *     DataLabelingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataLabelingServiceClient dataLabelingServiceClient =
 *     DataLabelingServiceClient.create(dataLabelingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class DataLabelingServiceClient implements BackgroundResource {
  private final DataLabelingServiceSettings settings;
  private final DataLabelingServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DataLabelingServiceClient with default settings. */
  public static final DataLabelingServiceClient create() throws IOException {
    return create(DataLabelingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataLabelingServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataLabelingServiceClient create(DataLabelingServiceSettings settings)
      throws IOException {
    return new DataLabelingServiceClient(settings);
  }

  /**
   * Constructs an instance of DataLabelingServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataLabelingServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DataLabelingServiceClient create(DataLabelingServiceStub stub) {
    return new DataLabelingServiceClient(stub);
  }

  /**
   * Constructs an instance of DataLabelingServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataLabelingServiceClient(DataLabelingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataLabelingServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DataLabelingServiceClient(DataLabelingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DataLabelingServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataLabelingServiceStub getStub() {
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
   * Creates dataset. If success return a Dataset resource.
   *
   * @param parent Required. Dataset resource parent, format: projects/{project_id}
   * @param dataset Required. The dataset to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(ProjectName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates dataset. If success return a Dataset resource.
   *
   * @param parent Required. Dataset resource parent, format: projects/{project_id}
   * @param dataset Required. The dataset to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates dataset. If success return a Dataset resource.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(CreateDatasetRequest request) {
    return createDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates dataset. If success return a Dataset resource.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets dataset by resource name.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets dataset by resource name.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets dataset by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets dataset by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets under a project. Pagination is supported.
   *
   * @param parent Required. Dataset resource parent, format: projects/{project_id}
   * @param filter Optional. Filter on dataset is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ProjectName parent, String filter) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets under a project. Pagination is supported.
   *
   * @param parent Required. Dataset resource parent, format: projects/{project_id}
   * @param filter Optional. Filter on dataset is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent, String filter) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets under a project. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets under a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets under a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset by resource name.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset by resource name.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    deleteDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(DeleteDatasetRequest request) {
    deleteDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into dataset based on source locations defined in request. It can be called
   * multiple times for the same dataset. Each dataset can only have one long running operation
   * running on it. For example, no labeling task (also long running operation) can be started while
   * importing is still ongoing. Vice versa.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param inputConfig Required. Specify the input source of the data.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataAsync(DatasetName name, InputConfig inputConfig) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setInputConfig(inputConfig)
            .build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into dataset based on source locations defined in request. It can be called
   * multiple times for the same dataset. Each dataset can only have one long running operation
   * running on it. For example, no labeling task (also long running operation) can be started while
   * importing is still ongoing. Vice versa.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param inputConfig Required. Specify the input source of the data.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataAsync(String name, InputConfig inputConfig) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder().setName(name).setInputConfig(inputConfig).build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into dataset based on source locations defined in request. It can be called
   * multiple times for the same dataset. Each dataset can only have one long running operation
   * running on it. For example, no labeling task (also long running operation) can be started while
   * importing is still ongoing. Vice versa.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataAsync(ImportDataRequest request) {
    return importDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into dataset based on source locations defined in request. It can be called
   * multiple times for the same dataset. Each dataset can only have one long running operation
   * running on it. For example, no labeling task (also long running operation) can be started while
   * importing is still ongoing. Vice versa.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return stub.importDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into dataset based on source locations defined in request. It can be called
   * multiple times for the same dataset. Each dataset can only have one long running operation
   * running on it. For example, no labeling task (also long running operation) can be started while
   * importing is still ongoing. Vice versa.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return stub.importDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param annotatedDataset Required. Annotated dataset resource name. DataItem in Dataset and
   *     their annotations in specified annotated dataset will be exported. It's in format of
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @param outputConfig Required. Specify the output destination.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataAsync(
          DatasetName name,
          AnnotatedDatasetName annotatedDataset,
          String filter,
          OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAnnotatedDataset(annotatedDataset == null ? null : annotatedDataset.toString())
            .setFilter(filter)
            .setOutputConfig(outputConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param annotatedDataset Required. Annotated dataset resource name. DataItem in Dataset and
   *     their annotations in specified annotated dataset will be exported. It's in format of
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @param outputConfig Required. Specify the output destination.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataAsync(
          DatasetName name, String annotatedDataset, String filter, OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAnnotatedDataset(annotatedDataset)
            .setFilter(filter)
            .setOutputConfig(outputConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param annotatedDataset Required. Annotated dataset resource name. DataItem in Dataset and
   *     their annotations in specified annotated dataset will be exported. It's in format of
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @param outputConfig Required. Specify the output destination.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataAsync(
          String name,
          AnnotatedDatasetName annotatedDataset,
          String filter,
          OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name)
            .setAnnotatedDataset(annotatedDataset == null ? null : annotatedDataset.toString())
            .setFilter(filter)
            .setOutputConfig(outputConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * @param name Required. Dataset resource name, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param annotatedDataset Required. Annotated dataset resource name. DataItem in Dataset and
   *     their annotations in specified annotated dataset will be exported. It's in format of
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @param outputConfig Required. Specify the output destination.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataAsync(
          String name, String annotatedDataset, String filter, OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name)
            .setAnnotatedDataset(annotatedDataset)
            .setFilter(filter)
            .setOutputConfig(outputConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataAsync(ExportDataRequest request) {
    return exportDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return stub.exportDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data and annotations from dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return stub.exportDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data item in a dataset by resource name. This API can be called after data are imported
   * into dataset.
   *
   * @param name Required. The name of the data item to get, format:
   *     projects/{project_id}/datasets/{dataset_id}/dataItems/{data_item_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataItem getDataItem(DataItemName name) {
    GetDataItemRequest request =
        GetDataItemRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data item in a dataset by resource name. This API can be called after data are imported
   * into dataset.
   *
   * @param name Required. The name of the data item to get, format:
   *     projects/{project_id}/datasets/{dataset_id}/dataItems/{data_item_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataItem getDataItem(String name) {
    GetDataItemRequest request = GetDataItemRequest.newBuilder().setName(name).build();
    return getDataItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data item in a dataset by resource name. This API can be called after data are imported
   * into dataset.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataItem getDataItem(GetDataItemRequest request) {
    return getDataItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data item in a dataset by resource name. This API can be called after data are imported
   * into dataset.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDataItemRequest, DataItem> getDataItemCallable() {
    return stub.getDataItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data items in a dataset. This API can be called after data are imported into dataset.
   * Pagination is supported.
   *
   * @param parent Required. Name of the dataset to list data items, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(DatasetName parent, String filter) {
    ListDataItemsRequest request =
        ListDataItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data items in a dataset. This API can be called after data are imported into dataset.
   * Pagination is supported.
   *
   * @param parent Required. Name of the dataset to list data items, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(String parent, String filter) {
    ListDataItemsRequest request =
        ListDataItemsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listDataItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data items in a dataset. This API can be called after data are imported into dataset.
   * Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataItemsPagedResponse listDataItems(ListDataItemsRequest request) {
    return listDataItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data items in a dataset. This API can be called after data are imported into dataset.
   * Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return stub.listDataItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists data items in a dataset. This API can be called after data are imported into dataset.
   * Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return stub.listDataItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotated dataset by resource name.
   *
   * @param name Required. Name of the annotated dataset to get, format:
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotatedDataset getAnnotatedDataset(AnnotatedDatasetName name) {
    GetAnnotatedDatasetRequest request =
        GetAnnotatedDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnnotatedDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotated dataset by resource name.
   *
   * @param name Required. Name of the annotated dataset to get, format:
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotatedDataset getAnnotatedDataset(String name) {
    GetAnnotatedDatasetRequest request =
        GetAnnotatedDatasetRequest.newBuilder().setName(name).build();
    return getAnnotatedDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotated dataset by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotatedDataset getAnnotatedDataset(GetAnnotatedDatasetRequest request) {
    return getAnnotatedDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotated dataset by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetCallable() {
    return stub.getAnnotatedDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotated datasets for a dataset. Pagination is supported.
   *
   * @param parent Required. Name of the dataset to list annotated datasets, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotatedDatasetsPagedResponse listAnnotatedDatasets(
      DatasetName parent, String filter) {
    ListAnnotatedDatasetsRequest request =
        ListAnnotatedDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listAnnotatedDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotated datasets for a dataset. Pagination is supported.
   *
   * @param parent Required. Name of the dataset to list annotated datasets, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotatedDatasetsPagedResponse listAnnotatedDatasets(
      String parent, String filter) {
    ListAnnotatedDatasetsRequest request =
        ListAnnotatedDatasetsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listAnnotatedDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotated datasets for a dataset. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotatedDatasetsPagedResponse listAnnotatedDatasets(
      ListAnnotatedDatasetsRequest request) {
    return listAnnotatedDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotated datasets for a dataset. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsPagedCallable() {
    return stub.listAnnotatedDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotated datasets for a dataset. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>
      listAnnotatedDatasetsCallable() {
    return stub.listAnnotatedDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotated dataset by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotatedDataset(DeleteAnnotatedDatasetRequest request) {
    deleteAnnotatedDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotated dataset by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteAnnotatedDatasetRequest, Empty>
      deleteAnnotatedDatasetCallable() {
    return stub.deleteAnnotatedDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for image. The type of image labeling task is configured by feature in
   * the request.
   *
   * @param parent Required. Name of the dataset to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of image labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelImageAsync(
      DatasetName parent, HumanAnnotationConfig basicConfig, LabelImageRequest.Feature feature) {
    LabelImageRequest request =
        LabelImageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelImageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for image. The type of image labeling task is configured by feature in
   * the request.
   *
   * @param parent Required. Name of the dataset to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of image labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelImageAsync(
      String parent, HumanAnnotationConfig basicConfig, LabelImageRequest.Feature feature) {
    LabelImageRequest request =
        LabelImageRequest.newBuilder()
            .setParent(parent)
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelImageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for image. The type of image labeling task is configured by feature in
   * the request.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelImageAsync(
      LabelImageRequest request) {
    return labelImageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for image. The type of image labeling task is configured by feature in
   * the request.
   *
   * <p>Sample code:
   */
  public final OperationCallable<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationCallable() {
    return stub.labelImageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for image. The type of image labeling task is configured by feature in
   * the request.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<LabelImageRequest, Operation> labelImageCallable() {
    return stub.labelImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for video. The type of video labeling task is configured by feature in
   * the request.
   *
   * @param parent Required. Name of the dataset to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of video labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelVideoAsync(
      DatasetName parent, HumanAnnotationConfig basicConfig, LabelVideoRequest.Feature feature) {
    LabelVideoRequest request =
        LabelVideoRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelVideoAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for video. The type of video labeling task is configured by feature in
   * the request.
   *
   * @param parent Required. Name of the dataset to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of video labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelVideoAsync(
      String parent, HumanAnnotationConfig basicConfig, LabelVideoRequest.Feature feature) {
    LabelVideoRequest request =
        LabelVideoRequest.newBuilder()
            .setParent(parent)
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelVideoAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for video. The type of video labeling task is configured by feature in
   * the request.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelVideoAsync(
      LabelVideoRequest request) {
    return labelVideoOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for video. The type of video labeling task is configured by feature in
   * the request.
   *
   * <p>Sample code:
   */
  public final OperationCallable<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationCallable() {
    return stub.labelVideoOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for video. The type of video labeling task is configured by feature in
   * the request.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<LabelVideoRequest, Operation> labelVideoCallable() {
    return stub.labelVideoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for text. The type of text labeling task is configured by feature in the
   * request.
   *
   * @param parent Required. Name of the data set to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of text labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelTextAsync(
      DatasetName parent, HumanAnnotationConfig basicConfig, LabelTextRequest.Feature feature) {
    LabelTextRequest request =
        LabelTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelTextAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for text. The type of text labeling task is configured by feature in the
   * request.
   *
   * @param parent Required. Name of the data set to request labeling task, format:
   *     projects/{project_id}/datasets/{dataset_id}
   * @param basicConfig Required. Basic human annotation config.
   * @param feature Required. The type of text labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelTextAsync(
      String parent, HumanAnnotationConfig basicConfig, LabelTextRequest.Feature feature) {
    LabelTextRequest request =
        LabelTextRequest.newBuilder()
            .setParent(parent)
            .setBasicConfig(basicConfig)
            .setFeature(feature)
            .build();
    return labelTextAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for text. The type of text labeling task is configured by feature in the
   * request.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnnotatedDataset, LabelOperationMetadata> labelTextAsync(
      LabelTextRequest request) {
    return labelTextOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for text. The type of text labeling task is configured by feature in the
   * request.
   *
   * <p>Sample code:
   */
  public final OperationCallable<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationCallable() {
    return stub.labelTextOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a labeling task for text. The type of text labeling task is configured by feature in the
   * request.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<LabelTextRequest, Operation> labelTextCallable() {
    return stub.labelTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an example by resource name, including both data and annotation.
   *
   * @param name Required. Name of example, format:
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/
   *     {annotated_dataset_id}/examples/{example_id}
   * @param filter Optional. An expression for filtering Examples. Filter by
   *     annotation_spec.display_name is supported. Format "annotation_spec.display_name =
   *     {display_name}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(ExampleName name, String filter) {
    GetExampleRequest request =
        GetExampleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setFilter(filter)
            .build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an example by resource name, including both data and annotation.
   *
   * @param name Required. Name of example, format:
   *     projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/
   *     {annotated_dataset_id}/examples/{example_id}
   * @param filter Optional. An expression for filtering Examples. Filter by
   *     annotation_spec.display_name is supported. Format "annotation_spec.display_name =
   *     {display_name}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(String name, String filter) {
    GetExampleRequest request =
        GetExampleRequest.newBuilder().setName(name).setFilter(filter).build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an example by resource name, including both data and annotation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(GetExampleRequest request) {
    return getExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an example by resource name, including both data and annotation.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    return stub.getExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in an annotated dataset. Pagination is supported.
   *
   * @param parent Required. Example resource parent.
   * @param filter Optional. An expression for filtering Examples. For annotated datasets that have
   *     annotation spec set, filter by annotation_spec.display_name is supported. Format
   *     "annotation_spec.display_name = {display_name}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(AnnotatedDatasetName parent, String filter) {
    ListExamplesRequest request =
        ListExamplesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in an annotated dataset. Pagination is supported.
   *
   * @param parent Required. Example resource parent.
   * @param filter Optional. An expression for filtering Examples. For annotated datasets that have
   *     annotation spec set, filter by annotation_spec.display_name is supported. Format
   *     "annotation_spec.display_name = {display_name}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(String parent, String filter) {
    ListExamplesRequest request =
        ListExamplesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in an annotated dataset. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(ListExamplesRequest request) {
    return listExamplesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in an annotated dataset. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable() {
    return stub.listExamplesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in an annotated dataset. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return stub.listExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an annotation spec set by providing a set of labels.
   *
   * @param parent Required. AnnotationSpecSet resource parent, format: projects/{project_id}
   * @param annotationSpecSet Required. Annotation spec set to create. Annotation specs must be
   *     included. Only one annotation spec will be accepted for annotation specs with same
   *     display_name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet createAnnotationSpecSet(
      ProjectName parent, AnnotationSpecSet annotationSpecSet) {
    CreateAnnotationSpecSetRequest request =
        CreateAnnotationSpecSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnnotationSpecSet(annotationSpecSet)
            .build();
    return createAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an annotation spec set by providing a set of labels.
   *
   * @param parent Required. AnnotationSpecSet resource parent, format: projects/{project_id}
   * @param annotationSpecSet Required. Annotation spec set to create. Annotation specs must be
   *     included. Only one annotation spec will be accepted for annotation specs with same
   *     display_name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet createAnnotationSpecSet(
      String parent, AnnotationSpecSet annotationSpecSet) {
    CreateAnnotationSpecSetRequest request =
        CreateAnnotationSpecSetRequest.newBuilder()
            .setParent(parent)
            .setAnnotationSpecSet(annotationSpecSet)
            .build();
    return createAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an annotation spec set by providing a set of labels.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet createAnnotationSpecSet(CreateAnnotationSpecSetRequest request) {
    return createAnnotationSpecSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an annotation spec set by providing a set of labels.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetCallable() {
    return stub.createAnnotationSpecSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec set by resource name.
   *
   * @param name Required. AnnotationSpecSet resource name, format:
   *     projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet getAnnotationSpecSet(AnnotationSpecSetName name) {
    GetAnnotationSpecSetRequest request =
        GetAnnotationSpecSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec set by resource name.
   *
   * @param name Required. AnnotationSpecSet resource name, format:
   *     projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet getAnnotationSpecSet(String name) {
    GetAnnotationSpecSetRequest request =
        GetAnnotationSpecSetRequest.newBuilder().setName(name).build();
    return getAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec set by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpecSet getAnnotationSpecSet(GetAnnotationSpecSetRequest request) {
    return getAnnotationSpecSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec set by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetCallable() {
    return stub.getAnnotationSpecSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotation spec sets for a project. Pagination is supported.
   *
   * @param parent Required. Parent of AnnotationSpecSet resource, format: projects/{project_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationSpecSetsPagedResponse listAnnotationSpecSets(
      ProjectName parent, String filter) {
    ListAnnotationSpecSetsRequest request =
        ListAnnotationSpecSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listAnnotationSpecSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotation spec sets for a project. Pagination is supported.
   *
   * @param parent Required. Parent of AnnotationSpecSet resource, format: projects/{project_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationSpecSetsPagedResponse listAnnotationSpecSets(
      String parent, String filter) {
    ListAnnotationSpecSetsRequest request =
        ListAnnotationSpecSetsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listAnnotationSpecSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotation spec sets for a project. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationSpecSetsPagedResponse listAnnotationSpecSets(
      ListAnnotationSpecSetsRequest request) {
    return listAnnotationSpecSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotation spec sets for a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsPagedCallable() {
    return stub.listAnnotationSpecSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists annotation spec sets for a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
      listAnnotationSpecSetsCallable() {
    return stub.listAnnotationSpecSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotation spec set by resource name.
   *
   * @param name Required. AnnotationSpec resource name, format:
   *     `projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotationSpecSet(AnnotationSpecSetName name) {
    DeleteAnnotationSpecSetRequest request =
        DeleteAnnotationSpecSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotation spec set by resource name.
   *
   * @param name Required. AnnotationSpec resource name, format:
   *     `projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotationSpecSet(String name) {
    DeleteAnnotationSpecSetRequest request =
        DeleteAnnotationSpecSetRequest.newBuilder().setName(name).build();
    deleteAnnotationSpecSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotation spec set by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotationSpecSet(DeleteAnnotationSpecSetRequest request) {
    deleteAnnotationSpecSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an annotation spec set by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetCallable() {
    return stub.deleteAnnotationSpecSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instruction for how data should be labeled.
   *
   * @param parent Required. Instruction resource parent, format: projects/{project_id}
   * @param instruction Required. Instruction of how to perform the labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instruction, CreateInstructionMetadata> createInstructionAsync(
      ProjectName parent, Instruction instruction) {
    CreateInstructionRequest request =
        CreateInstructionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstruction(instruction)
            .build();
    return createInstructionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instruction for how data should be labeled.
   *
   * @param parent Required. Instruction resource parent, format: projects/{project_id}
   * @param instruction Required. Instruction of how to perform the labeling task.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instruction, CreateInstructionMetadata> createInstructionAsync(
      String parent, Instruction instruction) {
    CreateInstructionRequest request =
        CreateInstructionRequest.newBuilder().setParent(parent).setInstruction(instruction).build();
    return createInstructionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instruction for how data should be labeled.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instruction, CreateInstructionMetadata> createInstructionAsync(
      CreateInstructionRequest request) {
    return createInstructionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instruction for how data should be labeled.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationCallable() {
    return stub.createInstructionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instruction for how data should be labeled.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateInstructionRequest, Operation> createInstructionCallable() {
    return stub.createInstructionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instruction by resource name.
   *
   * @param name Required. Instruction resource name, format:
   *     projects/{project_id}/instructions/{instruction_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instruction getInstruction(InstructionName name) {
    GetInstructionRequest request =
        GetInstructionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstruction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instruction by resource name.
   *
   * @param name Required. Instruction resource name, format:
   *     projects/{project_id}/instructions/{instruction_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instruction getInstruction(String name) {
    GetInstructionRequest request = GetInstructionRequest.newBuilder().setName(name).build();
    return getInstruction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instruction by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instruction getInstruction(GetInstructionRequest request) {
    return getInstructionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instruction by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetInstructionRequest, Instruction> getInstructionCallable() {
    return stub.getInstructionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instructions for a project. Pagination is supported.
   *
   * @param parent Required. Instruction resource parent, format: projects/{project_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstructionsPagedResponse listInstructions(ProjectName parent, String filter) {
    ListInstructionsRequest request =
        ListInstructionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listInstructions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instructions for a project. Pagination is supported.
   *
   * @param parent Required. Instruction resource parent, format: projects/{project_id}
   * @param filter Optional. Filter is not supported at this moment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstructionsPagedResponse listInstructions(String parent, String filter) {
    ListInstructionsRequest request =
        ListInstructionsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listInstructions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instructions for a project. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstructionsPagedResponse listInstructions(ListInstructionsRequest request) {
    return listInstructionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instructions for a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInstructionsRequest, ListInstructionsPagedResponse>
      listInstructionsPagedCallable() {
    return stub.listInstructionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instructions for a project. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInstructionsRequest, ListInstructionsResponse>
      listInstructionsCallable() {
    return stub.listInstructionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instruction object by resource name.
   *
   * @param name Required. Instruction resource name, format:
   *     projects/{project_id}/instructions/{instruction_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstruction(InstructionName name) {
    DeleteInstructionRequest request =
        DeleteInstructionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteInstruction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instruction object by resource name.
   *
   * @param name Required. Instruction resource name, format:
   *     projects/{project_id}/instructions/{instruction_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstruction(String name) {
    DeleteInstructionRequest request = DeleteInstructionRequest.newBuilder().setName(name).build();
    deleteInstruction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instruction object by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstruction(DeleteInstructionRequest request) {
    deleteInstructionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instruction object by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteInstructionRequest, Empty> deleteInstructionCallable() {
    return stub.deleteInstructionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation by resource name (to search, use
   * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
   *
   * @param name Required. Name of the evaluation. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/datasets/&lt;var&gt;{dataset_id}&lt;/var&gt;/evaluations/&lt;var&gt;{evaluation_id}&lt;/var&gt;'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(EvaluationName name) {
    GetEvaluationRequest request =
        GetEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation by resource name (to search, use
   * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
   *
   * @param name Required. Name of the evaluation. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/datasets/&lt;var&gt;{dataset_id}&lt;/var&gt;/evaluations/&lt;var&gt;{evaluation_id}&lt;/var&gt;'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(String name) {
    GetEvaluationRequest request = GetEvaluationRequest.newBuilder().setName(name).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation by resource name (to search, use
   * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(GetEvaluationRequest request) {
    return getEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation by resource name (to search, use
   * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return stub.getEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
   *
   * @param parent Required. Evaluation search parent (project ID). Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param filter Optional. To search evaluations, you can filter by the following:
   *     <ul>
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_id (the last part of
   *           [EvaluationJob.name][google.cloud.datalabeling.v1beta1.EvaluationJob.name])
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.model_id (the
   *           &lt;var&gt;{model_name}&lt;/var&gt; portion of
   *           [EvaluationJob.modelVersion][google.cloud.datalabeling.v1beta1.EvaluationJob.model_version])
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_start (Minimum
   *           threshold for the
   *           [evaluationJobRunTime][google.cloud.datalabeling.v1beta1.Evaluation.evaluation_job_run_time]
   *           that created the evaluation)
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_end (Maximum
   *           threshold for the
   *           [evaluationJobRunTime][google.cloud.datalabeling.v1beta1.Evaluation.evaluation_job_run_time]
   *           that created the evaluation)
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.job_state
   *           ([EvaluationJob.state][google.cloud.datalabeling.v1beta1.EvaluationJob.state])
   *       <li>annotation&lt;span&gt;_&lt;/span&gt;spec.display_name (the Evaluation contains a
   *           metric for the annotation spec with this
   *           [displayName][google.cloud.datalabeling.v1beta1.AnnotationSpec.display_name])
   *     </ul>
   *     <p>To filter by multiple critiera, use the `AND` operator or the `OR` operator. The
   *     following examples shows a string that filters by several critiera:
   *     <p>"evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_id =
   *     &lt;var&gt;{evaluation_job_id}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.model_id = &lt;var&gt;{model_name}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_start =
   *     &lt;var&gt;{timestamp_1}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_end =
   *     &lt;var&gt;{timestamp_2}&lt;/var&gt; AND
   *     annotation&lt;span&gt;_&lt;/span&gt;spec.display_name =
   *     &lt;var&gt;{display_name}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEvaluationsPagedResponse searchEvaluations(
      EvaluationName parent, String filter) {
    SearchEvaluationsRequest request =
        SearchEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return searchEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
   *
   * @param parent Required. Evaluation search parent (project ID). Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param filter Optional. To search evaluations, you can filter by the following:
   *     <ul>
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_id (the last part of
   *           [EvaluationJob.name][google.cloud.datalabeling.v1beta1.EvaluationJob.name])
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.model_id (the
   *           &lt;var&gt;{model_name}&lt;/var&gt; portion of
   *           [EvaluationJob.modelVersion][google.cloud.datalabeling.v1beta1.EvaluationJob.model_version])
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_start (Minimum
   *           threshold for the
   *           [evaluationJobRunTime][google.cloud.datalabeling.v1beta1.Evaluation.evaluation_job_run_time]
   *           that created the evaluation)
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_end (Maximum
   *           threshold for the
   *           [evaluationJobRunTime][google.cloud.datalabeling.v1beta1.Evaluation.evaluation_job_run_time]
   *           that created the evaluation)
   *       <li>evaluation&lt;span&gt;_&lt;/span&gt;job.job_state
   *           ([EvaluationJob.state][google.cloud.datalabeling.v1beta1.EvaluationJob.state])
   *       <li>annotation&lt;span&gt;_&lt;/span&gt;spec.display_name (the Evaluation contains a
   *           metric for the annotation spec with this
   *           [displayName][google.cloud.datalabeling.v1beta1.AnnotationSpec.display_name])
   *     </ul>
   *     <p>To filter by multiple critiera, use the `AND` operator or the `OR` operator. The
   *     following examples shows a string that filters by several critiera:
   *     <p>"evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_id =
   *     &lt;var&gt;{evaluation_job_id}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.model_id = &lt;var&gt;{model_name}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_start =
   *     &lt;var&gt;{timestamp_1}&lt;/var&gt; AND
   *     evaluation&lt;span&gt;_&lt;/span&gt;job.evaluation_job_run_time_end =
   *     &lt;var&gt;{timestamp_2}&lt;/var&gt; AND
   *     annotation&lt;span&gt;_&lt;/span&gt;spec.display_name =
   *     &lt;var&gt;{display_name}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEvaluationsPagedResponse searchEvaluations(String parent, String filter) {
    SearchEvaluationsRequest request =
        SearchEvaluationsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return searchEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEvaluationsPagedResponse searchEvaluations(SearchEvaluationsRequest request) {
    return searchEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchEvaluationsRequest, SearchEvaluationsPagedResponse>
      searchEvaluationsPagedCallable() {
    return stub.searchEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchEvaluationsRequest, SearchEvaluationsResponse>
      searchEvaluationsCallable() {
    return stub.searchEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches example comparisons from an evaluation. The return format is a list of example
   * comparisons that show ground truth and prediction(s) for a single input. Search by providing an
   * evaluation ID.
   *
   * @param parent Required. Name of the [Evaluation][google.cloud.datalabeling.v1beta1.Evaluation]
   *     resource to search for example comparisons from. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/datasets/&lt;var&gt;{dataset_id}&lt;/var&gt;/evaluations/&lt;var&gt;{evaluation_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchExampleComparisonsPagedResponse searchExampleComparisons(
      EvaluationName parent) {
    SearchExampleComparisonsRequest request =
        SearchExampleComparisonsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchExampleComparisons(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches example comparisons from an evaluation. The return format is a list of example
   * comparisons that show ground truth and prediction(s) for a single input. Search by providing an
   * evaluation ID.
   *
   * @param parent Required. Name of the [Evaluation][google.cloud.datalabeling.v1beta1.Evaluation]
   *     resource to search for example comparisons from. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/datasets/&lt;var&gt;{dataset_id}&lt;/var&gt;/evaluations/&lt;var&gt;{evaluation_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchExampleComparisonsPagedResponse searchExampleComparisons(String parent) {
    SearchExampleComparisonsRequest request =
        SearchExampleComparisonsRequest.newBuilder().setParent(parent).build();
    return searchExampleComparisons(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches example comparisons from an evaluation. The return format is a list of example
   * comparisons that show ground truth and prediction(s) for a single input. Search by providing an
   * evaluation ID.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchExampleComparisonsPagedResponse searchExampleComparisons(
      SearchExampleComparisonsRequest request) {
    return searchExampleComparisonsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches example comparisons from an evaluation. The return format is a list of example
   * comparisons that show ground truth and prediction(s) for a single input. Search by providing an
   * evaluation ID.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchExampleComparisonsRequest, SearchExampleComparisonsPagedResponse>
      searchExampleComparisonsPagedCallable() {
    return stub.searchExampleComparisonsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches example comparisons from an evaluation. The return format is a list of example
   * comparisons that show ground truth and prediction(s) for a single input. Search by providing an
   * evaluation ID.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchExampleComparisonsRequest, SearchExampleComparisonsResponse>
      searchExampleComparisonsCallable() {
    return stub.searchExampleComparisonsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation job.
   *
   * @param parent Required. Evaluation job resource parent. Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param job Required. The evaluation job to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob createEvaluationJob(ProjectName parent, EvaluationJob job) {
    CreateEvaluationJobRequest request =
        CreateEvaluationJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJob(job)
            .build();
    return createEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation job.
   *
   * @param parent Required. Evaluation job resource parent. Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param job Required. The evaluation job to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob createEvaluationJob(String parent, EvaluationJob job) {
    CreateEvaluationJobRequest request =
        CreateEvaluationJobRequest.newBuilder().setParent(parent).setJob(job).build();
    return createEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation job.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob createEvaluationJob(CreateEvaluationJobRequest request) {
    return createEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation job.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEvaluationJobRequest, EvaluationJob>
      createEvaluationJobCallable() {
    return stub.createEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation job. You can only update certain fields of the job's
   * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]:
   * `humanAnnotationConfig.instruction`, `exampleCount`, and `exampleSamplePercentage`.
   *
   * <p>If you want to change any other aspect of the evaluation job, you must delete the job and
   * create a new one.
   *
   * @param evaluationJob Required. Evaluation job that is going to be updated.
   * @param updateMask Optional. Mask for which fields to update. You can only provide the following
   *     fields:
   *     <ul>
   *       <li>`evaluationJobConfig.humanAnnotationConfig.instruction`
   *       <li>`evaluationJobConfig.exampleCount`
   *       <li>`evaluationJobConfig.exampleSamplePercentage`
   *     </ul>
   *     <p>You can provide more than one of these fields by separating them with commas.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob updateEvaluationJob(
      EvaluationJob evaluationJob, FieldMask updateMask) {
    UpdateEvaluationJobRequest request =
        UpdateEvaluationJobRequest.newBuilder()
            .setEvaluationJob(evaluationJob)
            .setUpdateMask(updateMask)
            .build();
    return updateEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation job. You can only update certain fields of the job's
   * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]:
   * `humanAnnotationConfig.instruction`, `exampleCount`, and `exampleSamplePercentage`.
   *
   * <p>If you want to change any other aspect of the evaluation job, you must delete the job and
   * create a new one.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob updateEvaluationJob(UpdateEvaluationJobRequest request) {
    return updateEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation job. You can only update certain fields of the job's
   * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]:
   * `humanAnnotationConfig.instruction`, `exampleCount`, and `exampleSamplePercentage`.
   *
   * <p>If you want to change any other aspect of the evaluation job, you must delete the job and
   * create a new one.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateEvaluationJobRequest, EvaluationJob>
      updateEvaluationJobCallable() {
    return stub.updateEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation job by resource name.
   *
   * @param name Required. Name of the evaluation job. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob getEvaluationJob(EvaluationJobName name) {
    GetEvaluationJobRequest request =
        GetEvaluationJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation job by resource name.
   *
   * @param name Required. Name of the evaluation job. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob getEvaluationJob(String name) {
    GetEvaluationJobRequest request = GetEvaluationJobRequest.newBuilder().setName(name).build();
    return getEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation job by resource name.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationJob getEvaluationJob(GetEvaluationJobRequest request) {
    return getEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation job by resource name.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEvaluationJobRequest, EvaluationJob> getEvaluationJobCallable() {
    return stub.getEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a
   * no-op.
   *
   * @param name Required. Name of the evaluation job that is going to be paused. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseEvaluationJob(EvaluationJobName name) {
    PauseEvaluationJobRequest request =
        PauseEvaluationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    pauseEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a
   * no-op.
   *
   * @param name Required. Name of the evaluation job that is going to be paused. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseEvaluationJob(String name) {
    PauseEvaluationJobRequest request =
        PauseEvaluationJobRequest.newBuilder().setName(name).build();
    pauseEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a
   * no-op.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseEvaluationJob(PauseEvaluationJobRequest request) {
    pauseEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a
   * no-op.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<PauseEvaluationJobRequest, Empty> pauseEvaluationJobCallable() {
    return stub.pauseEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running
   * or scheduled evaluation job is a no-op.
   *
   * @param name Required. Name of the evaluation job that is going to be resumed. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeEvaluationJob(EvaluationJobName name) {
    ResumeEvaluationJobRequest request =
        ResumeEvaluationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    resumeEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running
   * or scheduled evaluation job is a no-op.
   *
   * @param name Required. Name of the evaluation job that is going to be resumed. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeEvaluationJob(String name) {
    ResumeEvaluationJobRequest request =
        ResumeEvaluationJobRequest.newBuilder().setName(name).build();
    resumeEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running
   * or scheduled evaluation job is a no-op.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeEvaluationJob(ResumeEvaluationJobRequest request) {
    resumeEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running
   * or scheduled evaluation job is a no-op.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResumeEvaluationJobRequest, Empty> resumeEvaluationJobCallable() {
    return stub.resumeEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops and deletes an evaluation job.
   *
   * @param name Required. Name of the evaluation job that is going to be deleted. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationJob(EvaluationJobName name) {
    DeleteEvaluationJobRequest request =
        DeleteEvaluationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops and deletes an evaluation job.
   *
   * @param name Required. Name of the evaluation job that is going to be deleted. Format:
   *     <p>"projects/&lt;var&gt;{project_id}&lt;/var&gt;/evaluationJobs/&lt;var&gt;{evaluation_job_id}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationJob(String name) {
    DeleteEvaluationJobRequest request =
        DeleteEvaluationJobRequest.newBuilder().setName(name).build();
    deleteEvaluationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops and deletes an evaluation job.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationJob(DeleteEvaluationJobRequest request) {
    deleteEvaluationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops and deletes an evaluation job.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEvaluationJobRequest, Empty> deleteEvaluationJobCallable() {
    return stub.deleteEvaluationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation jobs within a project with possible filters. Pagination is supported.
   *
   * @param parent Required. Evaluation job resource parent. Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param filter Optional. You can filter the jobs to list by model_id (also known as model_name,
   *     as described in
   *     [EvaluationJob.modelVersion][google.cloud.datalabeling.v1beta1.EvaluationJob.model_version])
   *     or by evaluation job state (as described in
   *     [EvaluationJob.state][google.cloud.datalabeling.v1beta1.EvaluationJob.state]). To filter by
   *     both criteria, use the `AND` operator or the `OR` operator. For example, you can use the
   *     following string for your filter: "evaluation&lt;span&gt;_&lt;/span&gt;job.model_id =
   *     &lt;var&gt;{model_name}&lt;/var&gt; AND evaluation&lt;span&gt;_&lt;/span&gt;job.state =
   *     &lt;var&gt;{evaluation_job_state}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationJobsPagedResponse listEvaluationJobs(
      ProjectName parent, String filter) {
    ListEvaluationJobsRequest request =
        ListEvaluationJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listEvaluationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation jobs within a project with possible filters. Pagination is supported.
   *
   * @param parent Required. Evaluation job resource parent. Format:
   *     "projects/&lt;var&gt;{project_id}&lt;/var&gt;"
   * @param filter Optional. You can filter the jobs to list by model_id (also known as model_name,
   *     as described in
   *     [EvaluationJob.modelVersion][google.cloud.datalabeling.v1beta1.EvaluationJob.model_version])
   *     or by evaluation job state (as described in
   *     [EvaluationJob.state][google.cloud.datalabeling.v1beta1.EvaluationJob.state]). To filter by
   *     both criteria, use the `AND` operator or the `OR` operator. For example, you can use the
   *     following string for your filter: "evaluation&lt;span&gt;_&lt;/span&gt;job.model_id =
   *     &lt;var&gt;{model_name}&lt;/var&gt; AND evaluation&lt;span&gt;_&lt;/span&gt;job.state =
   *     &lt;var&gt;{evaluation_job_state}&lt;/var&gt;"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationJobsPagedResponse listEvaluationJobs(String parent, String filter) {
    ListEvaluationJobsRequest request =
        ListEvaluationJobsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listEvaluationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation jobs within a project with possible filters. Pagination is supported.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationJobsPagedResponse listEvaluationJobs(
      ListEvaluationJobsRequest request) {
    return listEvaluationJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation jobs within a project with possible filters. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEvaluationJobsRequest, ListEvaluationJobsPagedResponse>
      listEvaluationJobsPagedCallable() {
    return stub.listEvaluationJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation jobs within a project with possible filters. Pagination is supported.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEvaluationJobsRequest, ListEvaluationJobsResponse>
      listEvaluationJobsCallable() {
    return stub.listEvaluationJobsCallable();
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

  public static class ListAnnotatedDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          AnnotatedDataset,
          ListAnnotatedDatasetsPage,
          ListAnnotatedDatasetsFixedSizeCollection> {

    public static ApiFuture<ListAnnotatedDatasetsPagedResponse> createAsync(
        PageContext<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
            context,
        ApiFuture<ListAnnotatedDatasetsResponse> futureResponse) {
      ApiFuture<ListAnnotatedDatasetsPage> futurePage =
          ListAnnotatedDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAnnotatedDatasetsPage, ListAnnotatedDatasetsPagedResponse>() {
            @Override
            public ListAnnotatedDatasetsPagedResponse apply(ListAnnotatedDatasetsPage input) {
              return new ListAnnotatedDatasetsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAnnotatedDatasetsPagedResponse(ListAnnotatedDatasetsPage page) {
      super(page, ListAnnotatedDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnnotatedDatasetsPage
      extends AbstractPage<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          AnnotatedDataset,
          ListAnnotatedDatasetsPage> {

    private ListAnnotatedDatasetsPage(
        PageContext<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
            context,
        ListAnnotatedDatasetsResponse response) {
      super(context, response);
    }

    private static ListAnnotatedDatasetsPage createEmptyPage() {
      return new ListAnnotatedDatasetsPage(null, null);
    }

    @Override
    protected ListAnnotatedDatasetsPage createPage(
        PageContext<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
            context,
        ListAnnotatedDatasetsResponse response) {
      return new ListAnnotatedDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnnotatedDatasetsPage> createPageAsync(
        PageContext<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
            context,
        ApiFuture<ListAnnotatedDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnnotatedDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          AnnotatedDataset,
          ListAnnotatedDatasetsPage,
          ListAnnotatedDatasetsFixedSizeCollection> {

    private ListAnnotatedDatasetsFixedSizeCollection(
        List<ListAnnotatedDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnnotatedDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListAnnotatedDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnnotatedDatasetsFixedSizeCollection createCollection(
        List<ListAnnotatedDatasetsPage> pages, int collectionSize) {
      return new ListAnnotatedDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExamplesPagedResponse
      extends AbstractPagedListResponse<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    public static ApiFuture<ListExamplesPagedResponse> createAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      ApiFuture<ListExamplesPage> futurePage =
          ListExamplesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListExamplesPage, ListExamplesPagedResponse>() {
            @Override
            public ListExamplesPagedResponse apply(ListExamplesPage input) {
              return new ListExamplesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListExamplesPagedResponse(ListExamplesPage page) {
      super(page, ListExamplesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExamplesPage
      extends AbstractPage<ListExamplesRequest, ListExamplesResponse, Example, ListExamplesPage> {

    private ListExamplesPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      super(context, response);
    }

    private static ListExamplesPage createEmptyPage() {
      return new ListExamplesPage(null, null);
    }

    @Override
    protected ListExamplesPage createPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      return new ListExamplesPage(context, response);
    }

    @Override
    public ApiFuture<ListExamplesPage> createPageAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExamplesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    private ListExamplesFixedSizeCollection(List<ListExamplesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExamplesFixedSizeCollection createEmptyCollection() {
      return new ListExamplesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExamplesFixedSizeCollection createCollection(
        List<ListExamplesPage> pages, int collectionSize) {
      return new ListExamplesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnnotationSpecSetsPagedResponse
      extends AbstractPagedListResponse<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          AnnotationSpecSet,
          ListAnnotationSpecSetsPage,
          ListAnnotationSpecSetsFixedSizeCollection> {

    public static ApiFuture<ListAnnotationSpecSetsPagedResponse> createAsync(
        PageContext<
                ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>
            context,
        ApiFuture<ListAnnotationSpecSetsResponse> futureResponse) {
      ApiFuture<ListAnnotationSpecSetsPage> futurePage =
          ListAnnotationSpecSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAnnotationSpecSetsPage, ListAnnotationSpecSetsPagedResponse>() {
            @Override
            public ListAnnotationSpecSetsPagedResponse apply(ListAnnotationSpecSetsPage input) {
              return new ListAnnotationSpecSetsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAnnotationSpecSetsPagedResponse(ListAnnotationSpecSetsPage page) {
      super(page, ListAnnotationSpecSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnnotationSpecSetsPage
      extends AbstractPage<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          AnnotationSpecSet,
          ListAnnotationSpecSetsPage> {

    private ListAnnotationSpecSetsPage(
        PageContext<
                ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>
            context,
        ListAnnotationSpecSetsResponse response) {
      super(context, response);
    }

    private static ListAnnotationSpecSetsPage createEmptyPage() {
      return new ListAnnotationSpecSetsPage(null, null);
    }

    @Override
    protected ListAnnotationSpecSetsPage createPage(
        PageContext<
                ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>
            context,
        ListAnnotationSpecSetsResponse response) {
      return new ListAnnotationSpecSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnnotationSpecSetsPage> createPageAsync(
        PageContext<
                ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>
            context,
        ApiFuture<ListAnnotationSpecSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnnotationSpecSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          AnnotationSpecSet,
          ListAnnotationSpecSetsPage,
          ListAnnotationSpecSetsFixedSizeCollection> {

    private ListAnnotationSpecSetsFixedSizeCollection(
        List<ListAnnotationSpecSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnnotationSpecSetsFixedSizeCollection createEmptyCollection() {
      return new ListAnnotationSpecSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnnotationSpecSetsFixedSizeCollection createCollection(
        List<ListAnnotationSpecSetsPage> pages, int collectionSize) {
      return new ListAnnotationSpecSetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstructionsPagedResponse
      extends AbstractPagedListResponse<
          ListInstructionsRequest,
          ListInstructionsResponse,
          Instruction,
          ListInstructionsPage,
          ListInstructionsFixedSizeCollection> {

    public static ApiFuture<ListInstructionsPagedResponse> createAsync(
        PageContext<ListInstructionsRequest, ListInstructionsResponse, Instruction> context,
        ApiFuture<ListInstructionsResponse> futureResponse) {
      ApiFuture<ListInstructionsPage> futurePage =
          ListInstructionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstructionsPage, ListInstructionsPagedResponse>() {
            @Override
            public ListInstructionsPagedResponse apply(ListInstructionsPage input) {
              return new ListInstructionsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstructionsPagedResponse(ListInstructionsPage page) {
      super(page, ListInstructionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstructionsPage
      extends AbstractPage<
          ListInstructionsRequest, ListInstructionsResponse, Instruction, ListInstructionsPage> {

    private ListInstructionsPage(
        PageContext<ListInstructionsRequest, ListInstructionsResponse, Instruction> context,
        ListInstructionsResponse response) {
      super(context, response);
    }

    private static ListInstructionsPage createEmptyPage() {
      return new ListInstructionsPage(null, null);
    }

    @Override
    protected ListInstructionsPage createPage(
        PageContext<ListInstructionsRequest, ListInstructionsResponse, Instruction> context,
        ListInstructionsResponse response) {
      return new ListInstructionsPage(context, response);
    }

    @Override
    public ApiFuture<ListInstructionsPage> createPageAsync(
        PageContext<ListInstructionsRequest, ListInstructionsResponse, Instruction> context,
        ApiFuture<ListInstructionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstructionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstructionsRequest,
          ListInstructionsResponse,
          Instruction,
          ListInstructionsPage,
          ListInstructionsFixedSizeCollection> {

    private ListInstructionsFixedSizeCollection(
        List<ListInstructionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstructionsFixedSizeCollection createEmptyCollection() {
      return new ListInstructionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstructionsFixedSizeCollection createCollection(
        List<ListInstructionsPage> pages, int collectionSize) {
      return new ListInstructionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          SearchEvaluationsRequest,
          SearchEvaluationsResponse,
          Evaluation,
          SearchEvaluationsPage,
          SearchEvaluationsFixedSizeCollection> {

    public static ApiFuture<SearchEvaluationsPagedResponse> createAsync(
        PageContext<SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation> context,
        ApiFuture<SearchEvaluationsResponse> futureResponse) {
      ApiFuture<SearchEvaluationsPage> futurePage =
          SearchEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchEvaluationsPage, SearchEvaluationsPagedResponse>() {
            @Override
            public SearchEvaluationsPagedResponse apply(SearchEvaluationsPage input) {
              return new SearchEvaluationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchEvaluationsPagedResponse(SearchEvaluationsPage page) {
      super(page, SearchEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchEvaluationsPage
      extends AbstractPage<
          SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation, SearchEvaluationsPage> {

    private SearchEvaluationsPage(
        PageContext<SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation> context,
        SearchEvaluationsResponse response) {
      super(context, response);
    }

    private static SearchEvaluationsPage createEmptyPage() {
      return new SearchEvaluationsPage(null, null);
    }

    @Override
    protected SearchEvaluationsPage createPage(
        PageContext<SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation> context,
        SearchEvaluationsResponse response) {
      return new SearchEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<SearchEvaluationsPage> createPageAsync(
        PageContext<SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation> context,
        ApiFuture<SearchEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchEvaluationsRequest,
          SearchEvaluationsResponse,
          Evaluation,
          SearchEvaluationsPage,
          SearchEvaluationsFixedSizeCollection> {

    private SearchEvaluationsFixedSizeCollection(
        List<SearchEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchEvaluationsFixedSizeCollection createEmptyCollection() {
      return new SearchEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchEvaluationsFixedSizeCollection createCollection(
        List<SearchEvaluationsPage> pages, int collectionSize) {
      return new SearchEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchExampleComparisonsPagedResponse
      extends AbstractPagedListResponse<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsResponse.ExampleComparison,
          SearchExampleComparisonsPage,
          SearchExampleComparisonsFixedSizeCollection> {

    public static ApiFuture<SearchExampleComparisonsPagedResponse> createAsync(
        PageContext<
                SearchExampleComparisonsRequest,
                SearchExampleComparisonsResponse,
                SearchExampleComparisonsResponse.ExampleComparison>
            context,
        ApiFuture<SearchExampleComparisonsResponse> futureResponse) {
      ApiFuture<SearchExampleComparisonsPage> futurePage =
          SearchExampleComparisonsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchExampleComparisonsPage, SearchExampleComparisonsPagedResponse>() {
            @Override
            public SearchExampleComparisonsPagedResponse apply(SearchExampleComparisonsPage input) {
              return new SearchExampleComparisonsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchExampleComparisonsPagedResponse(SearchExampleComparisonsPage page) {
      super(page, SearchExampleComparisonsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchExampleComparisonsPage
      extends AbstractPage<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsResponse.ExampleComparison,
          SearchExampleComparisonsPage> {

    private SearchExampleComparisonsPage(
        PageContext<
                SearchExampleComparisonsRequest,
                SearchExampleComparisonsResponse,
                SearchExampleComparisonsResponse.ExampleComparison>
            context,
        SearchExampleComparisonsResponse response) {
      super(context, response);
    }

    private static SearchExampleComparisonsPage createEmptyPage() {
      return new SearchExampleComparisonsPage(null, null);
    }

    @Override
    protected SearchExampleComparisonsPage createPage(
        PageContext<
                SearchExampleComparisonsRequest,
                SearchExampleComparisonsResponse,
                SearchExampleComparisonsResponse.ExampleComparison>
            context,
        SearchExampleComparisonsResponse response) {
      return new SearchExampleComparisonsPage(context, response);
    }

    @Override
    public ApiFuture<SearchExampleComparisonsPage> createPageAsync(
        PageContext<
                SearchExampleComparisonsRequest,
                SearchExampleComparisonsResponse,
                SearchExampleComparisonsResponse.ExampleComparison>
            context,
        ApiFuture<SearchExampleComparisonsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchExampleComparisonsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsResponse.ExampleComparison,
          SearchExampleComparisonsPage,
          SearchExampleComparisonsFixedSizeCollection> {

    private SearchExampleComparisonsFixedSizeCollection(
        List<SearchExampleComparisonsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchExampleComparisonsFixedSizeCollection createEmptyCollection() {
      return new SearchExampleComparisonsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchExampleComparisonsFixedSizeCollection createCollection(
        List<SearchExampleComparisonsPage> pages, int collectionSize) {
      return new SearchExampleComparisonsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationJobsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationJobsRequest,
          ListEvaluationJobsResponse,
          EvaluationJob,
          ListEvaluationJobsPage,
          ListEvaluationJobsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationJobsPagedResponse> createAsync(
        PageContext<ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob> context,
        ApiFuture<ListEvaluationJobsResponse> futureResponse) {
      ApiFuture<ListEvaluationJobsPage> futurePage =
          ListEvaluationJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEvaluationJobsPage, ListEvaluationJobsPagedResponse>() {
            @Override
            public ListEvaluationJobsPagedResponse apply(ListEvaluationJobsPage input) {
              return new ListEvaluationJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEvaluationJobsPagedResponse(ListEvaluationJobsPage page) {
      super(page, ListEvaluationJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationJobsPage
      extends AbstractPage<
          ListEvaluationJobsRequest,
          ListEvaluationJobsResponse,
          EvaluationJob,
          ListEvaluationJobsPage> {

    private ListEvaluationJobsPage(
        PageContext<ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob> context,
        ListEvaluationJobsResponse response) {
      super(context, response);
    }

    private static ListEvaluationJobsPage createEmptyPage() {
      return new ListEvaluationJobsPage(null, null);
    }

    @Override
    protected ListEvaluationJobsPage createPage(
        PageContext<ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob> context,
        ListEvaluationJobsResponse response) {
      return new ListEvaluationJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationJobsPage> createPageAsync(
        PageContext<ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob> context,
        ApiFuture<ListEvaluationJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationJobsRequest,
          ListEvaluationJobsResponse,
          EvaluationJob,
          ListEvaluationJobsPage,
          ListEvaluationJobsFixedSizeCollection> {

    private ListEvaluationJobsFixedSizeCollection(
        List<ListEvaluationJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationJobsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationJobsFixedSizeCollection createCollection(
        List<ListEvaluationJobsPage> pages, int collectionSize) {
      return new ListEvaluationJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
