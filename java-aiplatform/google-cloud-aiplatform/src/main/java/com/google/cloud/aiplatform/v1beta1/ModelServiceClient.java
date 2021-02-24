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
import com.google.cloud.aiplatform.v1beta1.stub.ModelServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ModelServiceStubSettings;
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
 * Service Description: A service for managing AI Platform's machine learning Models.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
 *   Model response = modelServiceClient.getModel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ModelServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class ModelServiceClient implements BackgroundResource {
  private final ModelServiceSettings settings;
  private final ModelServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ModelServiceClient with default settings. */
  public static final ModelServiceClient create() throws IOException {
    return create(ModelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelServiceClient create(ModelServiceSettings settings) throws IOException {
    return new ModelServiceClient(settings);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ModelServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ModelServiceClient create(ModelServiceStub stub) {
    return new ModelServiceClient(stub);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ModelServiceClient(ModelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ModelServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ModelServiceClient(ModelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ModelServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ModelServiceStub getStub() {
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
   * Uploads a Model artifact into AI Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Model model = Model.newBuilder().build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to upload the Model.
   *     Format: `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      LocationName parent, Model model) {
    UploadModelRequest request =
        UploadModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .build();
    return uploadModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into AI Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Model model = Model.newBuilder().build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to upload the Model.
   *     Format: `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      String parent, Model model) {
    UploadModelRequest request =
        UploadModelRequest.newBuilder().setParent(parent).setModel(model).build();
    return uploadModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into AI Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      UploadModelRequest request) {
    return uploadModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into AI Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   OperationFuture<UploadModelResponse, UploadModelOperationMetadata> future =
   *       modelServiceClient.uploadModelOperationCallable().futureCall(request);
   *   // Do something.
   *   UploadModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable() {
    return stub.uploadModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into AI Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.uploadModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadModelRequest, Operation> uploadModelCallable() {
    return stub.uploadModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(ModelName name) {
    GetModelRequest request =
        GetModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(String name) {
    GetModelRequest request = GetModelRequest.newBuilder().setName(name).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   Model response = modelServiceClient.getModel(request);
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
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.getModelCallable().futureCall(request);
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
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Model element : modelServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Models from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(LocationName parent) {
    ListModelsRequest request =
        ListModelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Model element : modelServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Models from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(String parent) {
    ListModelsRequest request = ListModelsRequest.newBuilder().setParent(parent).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Model element : modelServiceClient.listModels(request).iterateAll()) {
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
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.listModelsPagedCallable().futureCall(request);
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
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   while (true) {
   *     ListModelsResponse response = modelServiceClient.listModelsCallable().call(request);
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
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   Model model = Model.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Model response = modelServiceClient.updateModel(model, updateMask);
   * }
   * }</pre>
   *
   * @param model Required. The Model which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     <p>[FieldMask](https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model updateModel(Model model, FieldMask updateMask) {
    UpdateModelRequest request =
        UpdateModelRequest.newBuilder().setModel(model).setUpdateMask(updateMask).build();
    return updateModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setModel(Model.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Model response = modelServiceClient.updateModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model updateModel(UpdateModelRequest request) {
    return updateModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setModel(Model.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.updateModelCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return stub.updateModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model. Note: Model can only be deleted if there are no DeployedModels created from
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   modelServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(ModelName name) {
    DeleteModelRequest request =
        DeleteModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model. Note: Model can only be deleted if there are no DeployedModels created from
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   modelServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(String name) {
    DeleteModelRequest request = DeleteModelRequest.newBuilder().setName(name).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model. Note: Model can only be deleted if there are no DeployedModels created from
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   modelServiceClient.deleteModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(
      DeleteModelRequest request) {
    return deleteModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model. Note: Model can only be deleted if there are no DeployedModels created from
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       modelServiceClient.deleteModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable() {
    return stub.deleteModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model. Note: Model can only be deleted if there are no DeployedModels created from
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.deleteModelCallable().futureCall(request);
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
   * Exports a trained, exportable, Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1beta1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExportModelRequest.OutputConfig outputConfig =
   *       ExportModelRequest.OutputConfig.newBuilder().build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model to export. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      ModelName name, ExportModelRequest.OutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOutputConfig(outputConfig)
            .build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable, Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1beta1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ExportModelRequest.OutputConfig outputConfig =
   *       ExportModelRequest.OutputConfig.newBuilder().build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model to export. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      String name, ExportModelRequest.OutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder().setName(name).setOutputConfig(outputConfig).build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable, Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1beta1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      ExportModelRequest request) {
    return exportModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable, Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1beta1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportModelResponse, ExportModelOperationMetadata> future =
   *       modelServiceClient.exportModelOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable() {
    return stub.exportModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable, Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1beta1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.exportModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return stub.exportModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationName name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluation resource. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
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
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]").toString();
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluation resource. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(String name) {
    GetModelEvaluationRequest request =
        GetModelEvaluationRequest.newBuilder().setName(name).build();
    return getModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(request);
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
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       modelServiceClient.getModelEvaluationCallable().futureCall(request);
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
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   for (ModelEvaluation element : modelServiceClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Model to list the ModelEvaluations from.
   *     Format: `projects/{project}/locations/{location}/models/{model}`
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
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   for (ModelEvaluation element : modelServiceClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Model to list the ModelEvaluations from.
   *     Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(String parent) {
    ListModelEvaluationsRequest request =
        ListModelEvaluationsRequest.newBuilder().setParent(parent).build();
    return listModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelEvaluation element :
   *       modelServiceClient.listModelEvaluations(request).iterateAll()) {
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
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       modelServiceClient.listModelEvaluationsPagedCallable().futureCall(request);
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
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   while (true) {
   *     ListModelEvaluationsResponse response =
   *         modelServiceClient.listModelEvaluationsCallable().call(request);
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationSliceName name =
   *       ModelEvaluationSliceName.of(
   *           "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]");
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluationSlice resource. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(ModelEvaluationSliceName name) {
    GetModelEvaluationSliceRequest request =
        GetModelEvaluationSliceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getModelEvaluationSlice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name =
   *       ModelEvaluationSliceName.of(
   *               "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *           .toString();
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluationSlice resource. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(String name) {
    GetModelEvaluationSliceRequest request =
        GetModelEvaluationSliceRequest.newBuilder().setName(name).build();
    return getModelEvaluationSlice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationSliceRequest request =
   *       GetModelEvaluationSliceRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .build();
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(
      GetModelEvaluationSliceRequest request) {
    return getModelEvaluationSliceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationSliceRequest request =
   *       GetModelEvaluationSliceRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelEvaluationSlice> future =
   *       modelServiceClient.getModelEvaluationSliceCallable().futureCall(request);
   *   // Do something.
   *   ModelEvaluationSlice response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable() {
    return stub.getModelEvaluationSliceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationName parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ModelEvaluation to list the
   *     ModelEvaluationSlices from. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(
      ModelEvaluationName parent) {
    ListModelEvaluationSlicesRequest request =
        ListModelEvaluationSlicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]").toString();
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ModelEvaluation to list the
   *     ModelEvaluationSlices from. Format:
   *     <p>`projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(String parent) {
    ListModelEvaluationSlicesRequest request =
        ListModelEvaluationSlicesRequest.newBuilder().setParent(parent).build();
    return listModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationSlicesRequest request =
   *       ListModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(
      ListModelEvaluationSlicesRequest request) {
    return listModelEvaluationSlicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationSlicesRequest request =
   *       ListModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelEvaluationSlice> future =
   *       modelServiceClient.listModelEvaluationSlicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelEvaluationSlice element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable() {
    return stub.listModelEvaluationSlicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   while (true) {
   *     ListModelEvaluationSlicesResponse response =
   *         modelServiceClient.listModelEvaluationSlicesCallable().call(request);
   *     for (ModelEvaluationSlice element : response.getResponsesList()) {
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
  public final UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable() {
    return stub.listModelEvaluationSlicesCallable();
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

  public static class ListModelEvaluationSlicesPagedResponse
      extends AbstractPagedListResponse<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage,
          ListModelEvaluationSlicesFixedSizeCollection> {

    public static ApiFuture<ListModelEvaluationSlicesPagedResponse> createAsync(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ApiFuture<ListModelEvaluationSlicesResponse> futureResponse) {
      ApiFuture<ListModelEvaluationSlicesPage> futurePage =
          ListModelEvaluationSlicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListModelEvaluationSlicesPage, ListModelEvaluationSlicesPagedResponse>() {
            @Override
            public ListModelEvaluationSlicesPagedResponse apply(
                ListModelEvaluationSlicesPage input) {
              return new ListModelEvaluationSlicesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListModelEvaluationSlicesPagedResponse(ListModelEvaluationSlicesPage page) {
      super(page, ListModelEvaluationSlicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelEvaluationSlicesPage
      extends AbstractPage<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage> {

    private ListModelEvaluationSlicesPage(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ListModelEvaluationSlicesResponse response) {
      super(context, response);
    }

    private static ListModelEvaluationSlicesPage createEmptyPage() {
      return new ListModelEvaluationSlicesPage(null, null);
    }

    @Override
    protected ListModelEvaluationSlicesPage createPage(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ListModelEvaluationSlicesResponse response) {
      return new ListModelEvaluationSlicesPage(context, response);
    }

    @Override
    public ApiFuture<ListModelEvaluationSlicesPage> createPageAsync(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ApiFuture<ListModelEvaluationSlicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelEvaluationSlicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage,
          ListModelEvaluationSlicesFixedSizeCollection> {

    private ListModelEvaluationSlicesFixedSizeCollection(
        List<ListModelEvaluationSlicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelEvaluationSlicesFixedSizeCollection createEmptyCollection() {
      return new ListModelEvaluationSlicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelEvaluationSlicesFixedSizeCollection createCollection(
        List<ListModelEvaluationSlicesPage> pages, int collectionSize) {
      return new ListModelEvaluationSlicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
