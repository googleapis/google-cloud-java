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

package com.google.cloud.automl.v1beta1;

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
import com.google.cloud.automl.v1beta1.stub.AutoMlStub;
import com.google.cloud.automl.v1beta1.stub.AutoMlStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: AutoML Server API.
 *
 * <p>The resource names are assigned by the server. The server never reuses names that it has
 * created after the resources with those names are deleted.
 *
 * <p>An ID of a resource is the last element of the item's resource name. For
 * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then the id for the item
 * is `{dataset_id}`.
 *
 * <p>Currently the only supported `location_id` is "us-central1".
 *
 * <p>On any input that is documented to expect a string parameter in snake_case or kebab-case,
 * either of those cases is accepted.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Dataset dataset = Dataset.newBuilder().build();
 *   Dataset response = autoMlClient.createDataset(parent, dataset);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AutoMlClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of AutoMlSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * AutoMlSettings autoMlSettings =
 *     AutoMlSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutoMlClient autoMlClient = AutoMlClient.create(autoMlSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * AutoMlSettings autoMlSettings = AutoMlSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutoMlClient autoMlClient = AutoMlClient.create(autoMlSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AutoMlClient implements BackgroundResource {
  private final AutoMlSettings settings;
  private final AutoMlStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AutoMlClient with default settings. */
  public static final AutoMlClient create() throws IOException {
    return create(AutoMlSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutoMlClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AutoMlClient create(AutoMlSettings settings) throws IOException {
    return new AutoMlClient(settings);
  }

  /**
   * Constructs an instance of AutoMlClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AutoMlSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AutoMlClient create(AutoMlStub stub) {
    return new AutoMlClient(stub);
  }

  /**
   * Constructs an instance of AutoMlClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AutoMlClient(AutoMlSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AutoMlStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AutoMlClient(AutoMlStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AutoMlSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AutoMlStub getStub() {
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
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = autoMlClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project to create the dataset for.
   * @param dataset Required. The dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(LocationName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = autoMlClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project to create the dataset for.
   * @param dataset Required. The dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   Dataset response = autoMlClient.createDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(CreateDatasetRequest request) {
    return createDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future = autoMlClient.createDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   Dataset response = autoMlClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   Dataset response = autoMlClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   Dataset response = autoMlClient.getDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Dataset> future = autoMlClient.getDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Dataset element : autoMlClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list datasets.
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
   * Lists datasets in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Dataset element : autoMlClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list datasets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dataset element : autoMlClient.listDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dataset> future = autoMlClient.listDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   while (true) {
   *     ListDatasetsResponse response = autoMlClient.listDatasetsCallable().call(request);
   *     for (Dataset element : response.getResponsesList()) {
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
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = autoMlClient.updateDataset(dataset);
   * }
   * }</pre>
   *
   * @param dataset Required. The dataset which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(Dataset dataset) {
    UpdateDatasetRequest request = UpdateDatasetRequest.newBuilder().setDataset(dataset).build();
    return updateDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = autoMlClient.updateDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDataset(UpdateDatasetRequest request) {
    return updateDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future = autoMlClient.updateDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return stub.updateDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents. Returns empty response in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   autoMlClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents. Returns empty response in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   autoMlClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents. Returns empty response in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   autoMlClient.deleteDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(
      DeleteDatasetRequest request) {
    return deleteDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents. Returns empty response in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.deleteDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    return stub.deleteDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents. Returns empty response in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.deleteDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a dataset. For Tables this method can only be called on an empty Dataset.
   *
   * <p>For Tables:
   *
   * <ul>
   *   <li>A [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params] parameter
   *       must be explicitly set. Returns an empty response in the
   *       [response][google.longrunning.Operation.response] field when it completes.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   autoMlClient.importDataAsync(name, inputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Dataset name. Dataset must already exist. All imported annotations and
   *     examples will be added.
   * @param inputConfig Required. The desired input location and its domain specific semantics, if
   *     any.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> importDataAsync(
      DatasetName name, InputConfig inputConfig) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setInputConfig(inputConfig)
            .build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a dataset. For Tables this method can only be called on an empty Dataset.
   *
   * <p>For Tables:
   *
   * <ul>
   *   <li>A [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params] parameter
   *       must be explicitly set. Returns an empty response in the
   *       [response][google.longrunning.Operation.response] field when it completes.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   autoMlClient.importDataAsync(name, inputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. Dataset name. Dataset must already exist. All imported annotations and
   *     examples will be added.
   * @param inputConfig Required. The desired input location and its domain specific semantics, if
   *     any.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> importDataAsync(
      String name, InputConfig inputConfig) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder().setName(name).setInputConfig(inputConfig).build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a dataset. For Tables this method can only be called on an empty Dataset.
   *
   * <p>For Tables:
   *
   * <ul>
   *   <li>A [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params] parameter
   *       must be explicitly set. Returns an empty response in the
   *       [response][google.longrunning.Operation.response] field when it completes.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   autoMlClient.importDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> importDataAsync(
      ImportDataRequest request) {
    return importDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a dataset. For Tables this method can only be called on an empty Dataset.
   *
   * <p>For Tables:
   *
   * <ul>
   *   <li>A [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params] parameter
   *       must be explicitly set. Returns an empty response in the
   *       [response][google.longrunning.Operation.response] field when it completes.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.importDataOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportDataRequest, Empty, OperationMetadata>
      importDataOperationCallable() {
    return stub.importDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a dataset. For Tables this method can only be called on an empty Dataset.
   *
   * <p>For Tables:
   *
   * <ul>
   *   <li>A [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params] parameter
   *       must be explicitly set. Returns an empty response in the
   *       [response][google.longrunning.Operation.response] field when it completes.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.importDataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return stub.importDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location. Returns an empty response in the
   * [response][google.longrunning.Operation.response] field when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   autoMlClient.exportDataAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset.
   * @param outputConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportDataAsync(
      DatasetName name, OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOutputConfig(outputConfig)
            .build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location. Returns an empty response in the
   * [response][google.longrunning.Operation.response] field when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   autoMlClient.exportDataAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset.
   * @param outputConfig Required. The desired output location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportDataAsync(
      String name, OutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder().setName(name).setOutputConfig(outputConfig).build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location. Returns an empty response in the
   * [response][google.longrunning.Operation.response] field when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   autoMlClient.exportDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportDataAsync(
      ExportDataRequest request) {
    return exportDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location. Returns an empty response in the
   * [response][google.longrunning.Operation.response] field when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.exportDataOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportDataRequest, Empty, OperationMetadata>
      exportDataOperationCallable() {
    return stub.exportDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location. Returns an empty response in the
   * [response][google.longrunning.Operation.response] field when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.exportDataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return stub.exportDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   AnnotationSpecName name =
   *       AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]");
   *   AnnotationSpec response = autoMlClient.getAnnotationSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the annotation spec to retrieve.
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
   * Gets an annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name =
   *       AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *           .toString();
   *   AnnotationSpec response = autoMlClient.getAnnotationSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the annotation spec to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(String name) {
    GetAnnotationSpecRequest request = GetAnnotationSpecRequest.newBuilder().setName(name).build();
    return getAnnotationSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetAnnotationSpecRequest request =
   *       GetAnnotationSpecRequest.newBuilder()
   *           .setName(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .build();
   *   AnnotationSpec response = autoMlClient.getAnnotationSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotationSpec getAnnotationSpec(GetAnnotationSpecRequest request) {
    return getAnnotationSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetAnnotationSpecRequest request =
   *       GetAnnotationSpecRequest.newBuilder()
   *           .setName(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AnnotationSpec> future =
   *       autoMlClient.getAnnotationSpecCallable().futureCall(request);
   *   // Do something.
   *   AnnotationSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return stub.getAnnotationSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   TableSpecName name = TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]");
   *   TableSpec response = autoMlClient.getTableSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the table spec to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TableSpec getTableSpec(TableSpecName name) {
    GetTableSpecRequest request =
        GetTableSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTableSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name =
   *       TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]").toString();
   *   TableSpec response = autoMlClient.getTableSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the table spec to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TableSpec getTableSpec(String name) {
    GetTableSpecRequest request = GetTableSpecRequest.newBuilder().setName(name).build();
    return getTableSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetTableSpecRequest request =
   *       GetTableSpecRequest.newBuilder()
   *           .setName(
   *               TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   TableSpec response = autoMlClient.getTableSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TableSpec getTableSpec(GetTableSpecRequest request) {
    return getTableSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetTableSpecRequest request =
   *       GetTableSpecRequest.newBuilder()
   *           .setName(
   *               TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TableSpec> future = autoMlClient.getTableSpecCallable().futureCall(request);
   *   // Do something.
   *   TableSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTableSpecRequest, TableSpec> getTableSpecCallable() {
    return stub.getTableSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists table specs in a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (TableSpec element : autoMlClient.listTableSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the dataset to list table specs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTableSpecsPagedResponse listTableSpecs(DatasetName parent) {
    ListTableSpecsRequest request =
        ListTableSpecsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTableSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists table specs in a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (TableSpec element : autoMlClient.listTableSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the dataset to list table specs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTableSpecsPagedResponse listTableSpecs(String parent) {
    ListTableSpecsRequest request = ListTableSpecsRequest.newBuilder().setParent(parent).build();
    return listTableSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists table specs in a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListTableSpecsRequest request =
   *       ListTableSpecsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TableSpec element : autoMlClient.listTableSpecs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTableSpecsPagedResponse listTableSpecs(ListTableSpecsRequest request) {
    return listTableSpecsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists table specs in a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListTableSpecsRequest request =
   *       ListTableSpecsRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TableSpec> future = autoMlClient.listTableSpecsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TableSpec element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTableSpecsRequest, ListTableSpecsPagedResponse>
      listTableSpecsPagedCallable() {
    return stub.listTableSpecsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists table specs in a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   while (true) {
   *     ListTableSpecsResponse response = autoMlClient.listTableSpecsCallable().call(request);
   *     for (TableSpec element : response.getResponsesList()) {
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
  public final UnaryCallable<ListTableSpecsRequest, ListTableSpecsResponse>
      listTableSpecsCallable() {
    return stub.listTableSpecsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   TableSpec tableSpec = TableSpec.newBuilder().build();
   *   TableSpec response = autoMlClient.updateTableSpec(tableSpec);
   * }
   * }</pre>
   *
   * @param tableSpec Required. The table spec which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TableSpec updateTableSpec(TableSpec tableSpec) {
    UpdateTableSpecRequest request =
        UpdateTableSpecRequest.newBuilder().setTableSpec(tableSpec).build();
    return updateTableSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateTableSpecRequest request =
   *       UpdateTableSpecRequest.newBuilder()
   *           .setTableSpec(TableSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TableSpec response = autoMlClient.updateTableSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TableSpec updateTableSpec(UpdateTableSpecRequest request) {
    return updateTableSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateTableSpecRequest request =
   *       UpdateTableSpecRequest.newBuilder()
   *           .setTableSpec(TableSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TableSpec> future = autoMlClient.updateTableSpecCallable().futureCall(request);
   *   // Do something.
   *   TableSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTableSpecRequest, TableSpec> updateTableSpecCallable() {
    return stub.updateTableSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ColumnSpecName name =
   *       ColumnSpecName.of(
   *           "[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]", "[COLUMN_SPEC]");
   *   ColumnSpec response = autoMlClient.getColumnSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the column spec to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ColumnSpec getColumnSpec(ColumnSpecName name) {
    GetColumnSpecRequest request =
        GetColumnSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getColumnSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name =
   *       ColumnSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]", "[COLUMN_SPEC]")
   *           .toString();
   *   ColumnSpec response = autoMlClient.getColumnSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the column spec to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ColumnSpec getColumnSpec(String name) {
    GetColumnSpecRequest request = GetColumnSpecRequest.newBuilder().setName(name).build();
    return getColumnSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetColumnSpecRequest request =
   *       GetColumnSpecRequest.newBuilder()
   *           .setName(
   *               ColumnSpecName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]", "[COLUMN_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   ColumnSpec response = autoMlClient.getColumnSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ColumnSpec getColumnSpec(GetColumnSpecRequest request) {
    return getColumnSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetColumnSpecRequest request =
   *       GetColumnSpecRequest.newBuilder()
   *           .setName(
   *               ColumnSpecName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]", "[COLUMN_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ColumnSpec> future = autoMlClient.getColumnSpecCallable().futureCall(request);
   *   // Do something.
   *   ColumnSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetColumnSpecRequest, ColumnSpec> getColumnSpecCallable() {
    return stub.getColumnSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists column specs in a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   TableSpecName parent =
   *       TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]");
   *   for (ColumnSpec element : autoMlClient.listColumnSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the table spec to list column specs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListColumnSpecsPagedResponse listColumnSpecs(TableSpecName parent) {
    ListColumnSpecsRequest request =
        ListColumnSpecsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listColumnSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists column specs in a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent =
   *       TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]").toString();
   *   for (ColumnSpec element : autoMlClient.listColumnSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the table spec to list column specs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListColumnSpecsPagedResponse listColumnSpecs(String parent) {
    ListColumnSpecsRequest request = ListColumnSpecsRequest.newBuilder().setParent(parent).build();
    return listColumnSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists column specs in a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListColumnSpecsRequest request =
   *       ListColumnSpecsRequest.newBuilder()
   *           .setParent(
   *               TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ColumnSpec element : autoMlClient.listColumnSpecs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListColumnSpecsPagedResponse listColumnSpecs(ListColumnSpecsRequest request) {
    return listColumnSpecsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists column specs in a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListColumnSpecsRequest request =
   *       ListColumnSpecsRequest.newBuilder()
   *           .setParent(
   *               TableSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[TABLE_SPEC]")
   *                   .toString())
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ColumnSpec> future =
   *       autoMlClient.listColumnSpecsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ColumnSpec element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsPagedResponse>
      listColumnSpecsPagedCallable() {
    return stub.listColumnSpecsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists column specs in a table spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   while (true) {
   *     ListColumnSpecsResponse response = autoMlClient.listColumnSpecsCallable().call(request);
   *     for (ColumnSpec element : response.getResponsesList()) {
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
  public final UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsResponse>
      listColumnSpecsCallable() {
    return stub.listColumnSpecsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ColumnSpec columnSpec = ColumnSpec.newBuilder().build();
   *   ColumnSpec response = autoMlClient.updateColumnSpec(columnSpec);
   * }
   * }</pre>
   *
   * @param columnSpec Required. The column spec which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ColumnSpec updateColumnSpec(ColumnSpec columnSpec) {
    UpdateColumnSpecRequest request =
        UpdateColumnSpecRequest.newBuilder().setColumnSpec(columnSpec).build();
    return updateColumnSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateColumnSpecRequest request =
   *       UpdateColumnSpecRequest.newBuilder()
   *           .setColumnSpec(ColumnSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ColumnSpec response = autoMlClient.updateColumnSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ColumnSpec updateColumnSpec(UpdateColumnSpecRequest request) {
    return updateColumnSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a column spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UpdateColumnSpecRequest request =
   *       UpdateColumnSpecRequest.newBuilder()
   *           .setColumnSpec(ColumnSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ColumnSpec> future = autoMlClient.updateColumnSpecCallable().futureCall(request);
   *   // Do something.
   *   ColumnSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecCallable() {
    return stub.updateColumnSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model. Returns a Model in the [response][google.longrunning.Operation.response] field
   * when it completes. When you create a model, several model evaluations are created for it: a
   * global evaluation, and one evaluation for each annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Model model = Model.newBuilder().build();
   *   Model response = autoMlClient.createModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent project where the model is being created.
   * @param model Required. The model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      LocationName parent, Model model) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model. Returns a Model in the [response][google.longrunning.Operation.response] field
   * when it completes. When you create a model, several model evaluations are created for it: a
   * global evaluation, and one evaluation for each annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Model model = Model.newBuilder().build();
   *   Model response = autoMlClient.createModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent project where the model is being created.
   * @param model Required. The model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      String parent, Model model) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder().setParent(parent).setModel(model).build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model. Returns a Model in the [response][google.longrunning.Operation.response] field
   * when it completes. When you create a model, several model evaluations are created for it: a
   * global evaluation, and one evaluation for each annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   Model response = autoMlClient.createModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      CreateModelRequest request) {
    return createModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model. Returns a Model in the [response][google.longrunning.Operation.response] field
   * when it completes. When you create a model, several model evaluations are created for it: a
   * global evaluation, and one evaluation for each annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   OperationFuture<Model, OperationMetadata> future =
   *       autoMlClient.createModelOperationCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    return stub.createModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model. Returns a Model in the [response][google.longrunning.Operation.response] field
   * when it completes. When you create a model, several model evaluations are created for it: a
   * global evaluation, and one evaluation for each annotation spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.createModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return stub.createModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   Model response = autoMlClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(ModelName name) {
    GetModelRequest request =
        GetModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   Model response = autoMlClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(String name) {
    GetModelRequest request = GetModelRequest.newBuilder().setName(name).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   Model response = autoMlClient.getModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(GetModelRequest request) {
    return getModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Model> future = autoMlClient.getModelCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return stub.getModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Model element : autoMlClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project, from which to list the models.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(LocationName parent) {
    ListModelsRequest request =
        ListModelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Model element : autoMlClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project, from which to list the models.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(String parent) {
    ListModelsRequest request = ListModelsRequest.newBuilder().setParent(parent).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Model element : autoMlClient.listModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(ListModelsRequest request) {
    return listModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Model> future = autoMlClient.listModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Model element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return stub.listModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   while (true) {
   *     ListModelsResponse response = autoMlClient.listModelsCallable().call(request);
   *     for (Model element : response.getResponsesList()) {
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
  public final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return stub.listModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model. Returns `google.protobuf.Empty` in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   autoMlClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model being deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(ModelName name) {
    DeleteModelRequest request =
        DeleteModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model. Returns `google.protobuf.Empty` in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   autoMlClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model being deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(String name) {
    DeleteModelRequest request = DeleteModelRequest.newBuilder().setName(name).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model. Returns `google.protobuf.Empty` in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   autoMlClient.deleteModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(
      DeleteModelRequest request) {
    return deleteModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model. Returns `google.protobuf.Empty` in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.deleteModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    return stub.deleteModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model. Returns `google.protobuf.Empty` in the
   * [response][google.longrunning.Operation.response] field when it completes, and `delete_details`
   * in the [metadata][google.longrunning.Operation.metadata] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.deleteModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return stub.deleteModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it with the same parameters has no
   * effect. Deploying with different parametrs (as e.g. changing
   *
   * <p>[node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
   * will reset the deployment state without pausing the model's availability.
   *
   * <p>Only applicable for Text Classification, Image Object Detection , Tables, and Image
   * Segmentation; all other domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   autoMlClient.deployModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deployModelAsync(ModelName name) {
    DeployModelRequest request =
        DeployModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it with the same parameters has no
   * effect. Deploying with different parametrs (as e.g. changing
   *
   * <p>[node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
   * will reset the deployment state without pausing the model's availability.
   *
   * <p>Only applicable for Text Classification, Image Object Detection , Tables, and Image
   * Segmentation; all other domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   autoMlClient.deployModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deployModelAsync(String name) {
    DeployModelRequest request = DeployModelRequest.newBuilder().setName(name).build();
    return deployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it with the same parameters has no
   * effect. Deploying with different parametrs (as e.g. changing
   *
   * <p>[node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
   * will reset the deployment state without pausing the model's availability.
   *
   * <p>Only applicable for Text Classification, Image Object Detection , Tables, and Image
   * Segmentation; all other domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   autoMlClient.deployModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deployModelAsync(
      DeployModelRequest request) {
    return deployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it with the same parameters has no
   * effect. Deploying with different parametrs (as e.g. changing
   *
   * <p>[node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
   * will reset the deployment state without pausing the model's availability.
   *
   * <p>Only applicable for Text Classification, Image Object Detection , Tables, and Image
   * Segmentation; all other domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.deployModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeployModelRequest, Empty, OperationMetadata>
      deployModelOperationCallable() {
    return stub.deployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it with the same parameters has no
   * effect. Deploying with different parametrs (as e.g. changing
   *
   * <p>[node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
   * will reset the deployment state without pausing the model's availability.
   *
   * <p>Only applicable for Text Classification, Image Object Detection , Tables, and Image
   * Segmentation; all other domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   DeployModelRequest request =
   *       DeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.deployModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return stub.deployModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect.
   *
   * <p>Only applicable for Text Classification, Image Object Detection and Tables; all other
   * domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   autoMlClient.undeployModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> undeployModelAsync(ModelName name) {
    UndeployModelRequest request =
        UndeployModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect.
   *
   * <p>Only applicable for Text Classification, Image Object Detection and Tables; all other
   * domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   autoMlClient.undeployModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> undeployModelAsync(String name) {
    UndeployModelRequest request = UndeployModelRequest.newBuilder().setName(name).build();
    return undeployModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect.
   *
   * <p>Only applicable for Text Classification, Image Object Detection and Tables; all other
   * domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   autoMlClient.undeployModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> undeployModelAsync(
      UndeployModelRequest request) {
    return undeployModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect.
   *
   * <p>Only applicable for Text Classification, Image Object Detection and Tables; all other
   * domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.undeployModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeployModelRequest, Empty, OperationMetadata>
      undeployModelOperationCallable() {
    return stub.undeployModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect.
   *
   * <p>Only applicable for Text Classification, Image Object Detection and Tables; all other
   * domains manage deployment automatically.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   UndeployModelRequest request =
   *       UndeployModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.undeployModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return stub.undeployModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, "export-able", model to a user specified Google Cloud Storage location. A
   * model is considered export-able if and only if it has an export format defined for it in
   *
   * <p>[ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ModelExportOutputConfig outputConfig = ModelExportOutputConfig.newBuilder().build();
   *   autoMlClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model to export.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportModelAsync(
      ModelName name, ModelExportOutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOutputConfig(outputConfig)
            .build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, "export-able", model to a user specified Google Cloud Storage location. A
   * model is considered export-able if and only if it has an export format defined for it in
   *
   * <p>[ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ModelExportOutputConfig outputConfig = ModelExportOutputConfig.newBuilder().build();
   *   autoMlClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model to export.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportModelAsync(
      String name, ModelExportOutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder().setName(name).setOutputConfig(outputConfig).build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, "export-able", model to a user specified Google Cloud Storage location. A
   * model is considered export-able if and only if it has an export format defined for it in
   *
   * <p>[ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ModelExportOutputConfig.newBuilder().build())
   *           .build();
   *   autoMlClient.exportModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportModelAsync(
      ExportModelRequest request) {
    return exportModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, "export-able", model to a user specified Google Cloud Storage location. A
   * model is considered export-able if and only if it has an export format defined for it in
   *
   * <p>[ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ModelExportOutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.exportModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportModelRequest, Empty, OperationMetadata>
      exportModelOperationCallable() {
    return stub.exportModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, "export-able", model to a user specified Google Cloud Storage location. A
   * model is considered export-able if and only if it has an export format defined for it in
   *
   * <p>[ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ModelExportOutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = autoMlClient.exportModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return stub.exportModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports examples on which the model was evaluated (i.e. which were in the TEST set of the
   * dataset the model was created from), together with their ground truth annotations and the
   * annotations created (predicted) by the model. The examples, ground truth and predictions are
   * exported in the state they were at the moment the model was evaluated.
   *
   * <p>This export is available only for 30 days since the model evaluation is created.
   *
   * <p>Currently only available for Tables.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExportEvaluatedExamplesOutputConfig outputConfig =
   *       ExportEvaluatedExamplesOutputConfig.newBuilder().build();
   *   autoMlClient.exportEvaluatedExamplesAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model whose evaluated examples are to be
   *     exported.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportEvaluatedExamplesAsync(
      ModelName name, ExportEvaluatedExamplesOutputConfig outputConfig) {
    ExportEvaluatedExamplesRequest request =
        ExportEvaluatedExamplesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOutputConfig(outputConfig)
            .build();
    return exportEvaluatedExamplesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports examples on which the model was evaluated (i.e. which were in the TEST set of the
   * dataset the model was created from), together with their ground truth annotations and the
   * annotations created (predicted) by the model. The examples, ground truth and predictions are
   * exported in the state they were at the moment the model was evaluated.
   *
   * <p>This export is available only for 30 days since the model evaluation is created.
   *
   * <p>Currently only available for Tables.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ExportEvaluatedExamplesOutputConfig outputConfig =
   *       ExportEvaluatedExamplesOutputConfig.newBuilder().build();
   *   autoMlClient.exportEvaluatedExamplesAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model whose evaluated examples are to be
   *     exported.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportEvaluatedExamplesAsync(
      String name, ExportEvaluatedExamplesOutputConfig outputConfig) {
    ExportEvaluatedExamplesRequest request =
        ExportEvaluatedExamplesRequest.newBuilder()
            .setName(name)
            .setOutputConfig(outputConfig)
            .build();
    return exportEvaluatedExamplesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports examples on which the model was evaluated (i.e. which were in the TEST set of the
   * dataset the model was created from), together with their ground truth annotations and the
   * annotations created (predicted) by the model. The examples, ground truth and predictions are
   * exported in the state they were at the moment the model was evaluated.
   *
   * <p>This export is available only for 30 days since the model evaluation is created.
   *
   * <p>Currently only available for Tables.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportEvaluatedExamplesRequest request =
   *       ExportEvaluatedExamplesRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportEvaluatedExamplesOutputConfig.newBuilder().build())
   *           .build();
   *   autoMlClient.exportEvaluatedExamplesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> exportEvaluatedExamplesAsync(
      ExportEvaluatedExamplesRequest request) {
    return exportEvaluatedExamplesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports examples on which the model was evaluated (i.e. which were in the TEST set of the
   * dataset the model was created from), together with their ground truth annotations and the
   * annotations created (predicted) by the model. The examples, ground truth and predictions are
   * exported in the state they were at the moment the model was evaluated.
   *
   * <p>This export is available only for 30 days since the model evaluation is created.
   *
   * <p>Currently only available for Tables.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportEvaluatedExamplesRequest request =
   *       ExportEvaluatedExamplesRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportEvaluatedExamplesOutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       autoMlClient.exportEvaluatedExamplesOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportEvaluatedExamplesRequest, Empty, OperationMetadata>
      exportEvaluatedExamplesOperationCallable() {
    return stub.exportEvaluatedExamplesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports examples on which the model was evaluated (i.e. which were in the TEST set of the
   * dataset the model was created from), together with their ground truth annotations and the
   * annotations created (predicted) by the model. The examples, ground truth and predictions are
   * exported in the state they were at the moment the model was evaluated.
   *
   * <p>This export is available only for 30 days since the model evaluation is created.
   *
   * <p>Currently only available for Tables.
   *
   * <p>Returns an empty response in the [response][google.longrunning.Operation.response] field
   * when it completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ExportEvaluatedExamplesRequest request =
   *       ExportEvaluatedExamplesRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportEvaluatedExamplesOutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       autoMlClient.exportEvaluatedExamplesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesCallable() {
    return stub.exportEvaluatedExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelEvaluationName name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[MODEL_EVALUATION]");
   *   ModelEvaluation response = autoMlClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for the model evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(ModelEvaluationName name) {
    GetModelEvaluationRequest request =
        GetModelEvaluationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[MODEL_EVALUATION]")
   *           .toString();
   *   ModelEvaluation response = autoMlClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for the model evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(String name) {
    GetModelEvaluationRequest request =
        GetModelEvaluationRequest.newBuilder().setName(name).build();
    return getModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[MODEL_EVALUATION]")
   *                   .toString())
   *           .build();
   *   ModelEvaluation response = autoMlClient.getModelEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(GetModelEvaluationRequest request) {
    return getModelEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[MODEL_EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       autoMlClient.getModelEvaluationCallable().futureCall(request);
   *   // Do something.
   *   ModelEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationCallable() {
    return stub.getModelEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists model evaluations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   for (ModelEvaluation element : autoMlClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the model to list the model evaluations for. If
   *     modelId is set as "-", this will list model evaluations from across all models of the
   *     parent location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(ModelName parent) {
    ListModelEvaluationsRequest request =
        ListModelEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists model evaluations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   String parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   for (ModelEvaluation element : autoMlClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the model to list the model evaluations for. If
   *     modelId is set as "-", this will list model evaluations from across all models of the
   *     parent location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(String parent) {
    ListModelEvaluationsRequest request =
        ListModelEvaluationsRequest.newBuilder().setParent(parent).build();
    return listModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists model evaluations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ModelEvaluation element : autoMlClient.listModelEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(
      ListModelEvaluationsRequest request) {
    return listModelEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists model evaluations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       autoMlClient.listModelEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelEvaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    return stub.listModelEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists model evaluations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (AutoMlClient autoMlClient = AutoMlClient.create()) {
   *   while (true) {
   *     ListModelEvaluationsResponse response =
   *         autoMlClient.listModelEvaluationsCallable().call(request);
   *     for (ModelEvaluation element : response.getResponsesList()) {
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
  public final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    return stub.listModelEvaluationsCallable();
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

  public static class ListTableSpecsPagedResponse
      extends AbstractPagedListResponse<
          ListTableSpecsRequest,
          ListTableSpecsResponse,
          TableSpec,
          ListTableSpecsPage,
          ListTableSpecsFixedSizeCollection> {

    public static ApiFuture<ListTableSpecsPagedResponse> createAsync(
        PageContext<ListTableSpecsRequest, ListTableSpecsResponse, TableSpec> context,
        ApiFuture<ListTableSpecsResponse> futureResponse) {
      ApiFuture<ListTableSpecsPage> futurePage =
          ListTableSpecsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTableSpecsPage, ListTableSpecsPagedResponse>() {
            @Override
            public ListTableSpecsPagedResponse apply(ListTableSpecsPage input) {
              return new ListTableSpecsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTableSpecsPagedResponse(ListTableSpecsPage page) {
      super(page, ListTableSpecsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTableSpecsPage
      extends AbstractPage<
          ListTableSpecsRequest, ListTableSpecsResponse, TableSpec, ListTableSpecsPage> {

    private ListTableSpecsPage(
        PageContext<ListTableSpecsRequest, ListTableSpecsResponse, TableSpec> context,
        ListTableSpecsResponse response) {
      super(context, response);
    }

    private static ListTableSpecsPage createEmptyPage() {
      return new ListTableSpecsPage(null, null);
    }

    @Override
    protected ListTableSpecsPage createPage(
        PageContext<ListTableSpecsRequest, ListTableSpecsResponse, TableSpec> context,
        ListTableSpecsResponse response) {
      return new ListTableSpecsPage(context, response);
    }

    @Override
    public ApiFuture<ListTableSpecsPage> createPageAsync(
        PageContext<ListTableSpecsRequest, ListTableSpecsResponse, TableSpec> context,
        ApiFuture<ListTableSpecsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTableSpecsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTableSpecsRequest,
          ListTableSpecsResponse,
          TableSpec,
          ListTableSpecsPage,
          ListTableSpecsFixedSizeCollection> {

    private ListTableSpecsFixedSizeCollection(List<ListTableSpecsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTableSpecsFixedSizeCollection createEmptyCollection() {
      return new ListTableSpecsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTableSpecsFixedSizeCollection createCollection(
        List<ListTableSpecsPage> pages, int collectionSize) {
      return new ListTableSpecsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListColumnSpecsPagedResponse
      extends AbstractPagedListResponse<
          ListColumnSpecsRequest,
          ListColumnSpecsResponse,
          ColumnSpec,
          ListColumnSpecsPage,
          ListColumnSpecsFixedSizeCollection> {

    public static ApiFuture<ListColumnSpecsPagedResponse> createAsync(
        PageContext<ListColumnSpecsRequest, ListColumnSpecsResponse, ColumnSpec> context,
        ApiFuture<ListColumnSpecsResponse> futureResponse) {
      ApiFuture<ListColumnSpecsPage> futurePage =
          ListColumnSpecsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListColumnSpecsPage, ListColumnSpecsPagedResponse>() {
            @Override
            public ListColumnSpecsPagedResponse apply(ListColumnSpecsPage input) {
              return new ListColumnSpecsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListColumnSpecsPagedResponse(ListColumnSpecsPage page) {
      super(page, ListColumnSpecsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListColumnSpecsPage
      extends AbstractPage<
          ListColumnSpecsRequest, ListColumnSpecsResponse, ColumnSpec, ListColumnSpecsPage> {

    private ListColumnSpecsPage(
        PageContext<ListColumnSpecsRequest, ListColumnSpecsResponse, ColumnSpec> context,
        ListColumnSpecsResponse response) {
      super(context, response);
    }

    private static ListColumnSpecsPage createEmptyPage() {
      return new ListColumnSpecsPage(null, null);
    }

    @Override
    protected ListColumnSpecsPage createPage(
        PageContext<ListColumnSpecsRequest, ListColumnSpecsResponse, ColumnSpec> context,
        ListColumnSpecsResponse response) {
      return new ListColumnSpecsPage(context, response);
    }

    @Override
    public ApiFuture<ListColumnSpecsPage> createPageAsync(
        PageContext<ListColumnSpecsRequest, ListColumnSpecsResponse, ColumnSpec> context,
        ApiFuture<ListColumnSpecsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListColumnSpecsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListColumnSpecsRequest,
          ListColumnSpecsResponse,
          ColumnSpec,
          ListColumnSpecsPage,
          ListColumnSpecsFixedSizeCollection> {

    private ListColumnSpecsFixedSizeCollection(
        List<ListColumnSpecsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListColumnSpecsFixedSizeCollection createEmptyCollection() {
      return new ListColumnSpecsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListColumnSpecsFixedSizeCollection createCollection(
        List<ListColumnSpecsPage> pages, int collectionSize) {
      return new ListColumnSpecsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelsPagedResponse
      extends AbstractPagedListResponse<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    public static ApiFuture<ListModelsPagedResponse> createAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      ApiFuture<ListModelsPage> futurePage =
          ListModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListModelsPage, ListModelsPagedResponse>() {
            @Override
            public ListModelsPagedResponse apply(ListModelsPage input) {
              return new ListModelsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListModelsPagedResponse(ListModelsPage page) {
      super(page, ListModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelsPage
      extends AbstractPage<ListModelsRequest, ListModelsResponse, Model, ListModelsPage> {

    private ListModelsPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      super(context, response);
    }

    private static ListModelsPage createEmptyPage() {
      return new ListModelsPage(null, null);
    }

    @Override
    protected ListModelsPage createPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      return new ListModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelsPage> createPageAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    private ListModelsFixedSizeCollection(List<ListModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelsFixedSizeCollection createEmptyCollection() {
      return new ListModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelsFixedSizeCollection createCollection(
        List<ListModelsPage> pages, int collectionSize) {
      return new ListModelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage,
          ListModelEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListModelEvaluationsPagedResponse> createAsync(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ApiFuture<ListModelEvaluationsResponse> futureResponse) {
      ApiFuture<ListModelEvaluationsPage> futurePage =
          ListModelEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListModelEvaluationsPage, ListModelEvaluationsPagedResponse>() {
            @Override
            public ListModelEvaluationsPagedResponse apply(ListModelEvaluationsPage input) {
              return new ListModelEvaluationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListModelEvaluationsPagedResponse(ListModelEvaluationsPage page) {
      super(page, ListModelEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelEvaluationsPage
      extends AbstractPage<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage> {

    private ListModelEvaluationsPage(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ListModelEvaluationsResponse response) {
      super(context, response);
    }

    private static ListModelEvaluationsPage createEmptyPage() {
      return new ListModelEvaluationsPage(null, null);
    }

    @Override
    protected ListModelEvaluationsPage createPage(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ListModelEvaluationsResponse response) {
      return new ListModelEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelEvaluationsPage> createPageAsync(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ApiFuture<ListModelEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage,
          ListModelEvaluationsFixedSizeCollection> {

    private ListModelEvaluationsFixedSizeCollection(
        List<ListModelEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListModelEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelEvaluationsFixedSizeCollection createCollection(
        List<ListModelEvaluationsPage> pages, int collectionSize) {
      return new ListModelEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
