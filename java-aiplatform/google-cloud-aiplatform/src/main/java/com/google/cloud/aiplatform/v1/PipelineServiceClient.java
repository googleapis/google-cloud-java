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

package com.google.cloud.aiplatform.v1;

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
import com.google.cloud.aiplatform.v1.stub.PipelineServiceStub;
import com.google.cloud.aiplatform.v1.stub.PipelineServiceStubSettings;
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
 * Service Description: A service for creating and managing AI Platform's pipelines.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the PipelineServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of PipelineServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PipelineServiceClient implements BackgroundResource {
  private final PipelineServiceSettings settings;
  private final PipelineServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of PipelineServiceClient with default settings. */
  public static final PipelineServiceClient create() throws IOException {
    return create(PipelineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PipelineServiceClient create(PipelineServiceSettings settings)
      throws IOException {
    return new PipelineServiceClient(settings);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PipelineServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PipelineServiceClient create(PipelineServiceStub stub) {
    return new PipelineServiceClient(stub);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PipelineServiceClient(PipelineServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PipelineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PipelineServiceClient(PipelineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PipelineServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PipelineServiceStub getStub() {
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
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * @param parent Required. The resource name of the Location to create the TrainingPipeline in.
   *     Format: `projects/{project}/locations/{location}`
   * @param trainingPipeline Required. The TrainingPipeline to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(
      LocationName parent, TrainingPipeline trainingPipeline) {
    CreateTrainingPipelineRequest request =
        CreateTrainingPipelineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrainingPipeline(trainingPipeline)
            .build();
    return createTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * @param parent Required. The resource name of the Location to create the TrainingPipeline in.
   *     Format: `projects/{project}/locations/{location}`
   * @param trainingPipeline Required. The TrainingPipeline to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(
      String parent, TrainingPipeline trainingPipeline) {
    CreateTrainingPipelineRequest request =
        CreateTrainingPipelineRequest.newBuilder()
            .setParent(parent)
            .setTrainingPipeline(trainingPipeline)
            .build();
    return createTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(CreateTrainingPipelineRequest request) {
    return createTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineCallable() {
    return stub.createTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * @param name Required. The name of the TrainingPipeline resource. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(TrainingPipelineName name) {
    GetTrainingPipelineRequest request =
        GetTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * @param name Required. The name of the TrainingPipeline resource. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(String name) {
    GetTrainingPipelineRequest request =
        GetTrainingPipelineRequest.newBuilder().setName(name).build();
    return getTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(GetTrainingPipelineRequest request) {
    return getTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetTrainingPipelineRequest, TrainingPipeline>
      getTrainingPipelineCallable() {
    return stub.getTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * @param parent Required. The resource name of the Location to list the TrainingPipelines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(LocationName parent) {
    ListTrainingPipelinesRequest request =
        ListTrainingPipelinesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTrainingPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * @param parent Required. The resource name of the Location to list the TrainingPipelines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(String parent) {
    ListTrainingPipelinesRequest request =
        ListTrainingPipelinesRequest.newBuilder().setParent(parent).build();
    return listTrainingPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(
      ListTrainingPipelinesRequest request) {
    return listTrainingPipelinesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesPagedCallable() {
    return stub.listTrainingPipelinesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesCallable() {
    return stub.listTrainingPipelinesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * @param name Required. The name of the TrainingPipeline resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      TrainingPipelineName name) {
    DeleteTrainingPipelineRequest request =
        DeleteTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTrainingPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * @param name Required. The name of the TrainingPipeline resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      String name) {
    DeleteTrainingPipelineRequest request =
        DeleteTrainingPipelineRequest.newBuilder().setName(name).build();
    return deleteTrainingPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      DeleteTrainingPipelineRequest request) {
    return deleteTrainingPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationCallable() {
    return stub.deleteTrainingPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteTrainingPipelineRequest, Operation>
      deleteTrainingPipelineCallable() {
    return stub.deleteTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * @param name Required. The name of the TrainingPipeline to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(TrainingPipelineName name) {
    CancelTrainingPipelineRequest request =
        CancelTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * @param name Required. The name of the TrainingPipeline to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(String name) {
    CancelTrainingPipelineRequest request =
        CancelTrainingPipelineRequest.newBuilder().setName(name).build();
    cancelTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(CancelTrainingPipelineRequest request) {
    cancelTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelTrainingPipelineRequest, Empty>
      cancelTrainingPipelineCallable() {
    return stub.cancelTrainingPipelineCallable();
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

  public static class ListTrainingPipelinesPagedResponse
      extends AbstractPagedListResponse<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage,
          ListTrainingPipelinesFixedSizeCollection> {

    public static ApiFuture<ListTrainingPipelinesPagedResponse> createAsync(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ApiFuture<ListTrainingPipelinesResponse> futureResponse) {
      ApiFuture<ListTrainingPipelinesPage> futurePage =
          ListTrainingPipelinesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTrainingPipelinesPage, ListTrainingPipelinesPagedResponse>() {
            @Override
            public ListTrainingPipelinesPagedResponse apply(ListTrainingPipelinesPage input) {
              return new ListTrainingPipelinesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTrainingPipelinesPagedResponse(ListTrainingPipelinesPage page) {
      super(page, ListTrainingPipelinesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTrainingPipelinesPage
      extends AbstractPage<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage> {

    private ListTrainingPipelinesPage(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ListTrainingPipelinesResponse response) {
      super(context, response);
    }

    private static ListTrainingPipelinesPage createEmptyPage() {
      return new ListTrainingPipelinesPage(null, null);
    }

    @Override
    protected ListTrainingPipelinesPage createPage(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ListTrainingPipelinesResponse response) {
      return new ListTrainingPipelinesPage(context, response);
    }

    @Override
    public ApiFuture<ListTrainingPipelinesPage> createPageAsync(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ApiFuture<ListTrainingPipelinesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTrainingPipelinesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage,
          ListTrainingPipelinesFixedSizeCollection> {

    private ListTrainingPipelinesFixedSizeCollection(
        List<ListTrainingPipelinesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTrainingPipelinesFixedSizeCollection createEmptyCollection() {
      return new ListTrainingPipelinesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTrainingPipelinesFixedSizeCollection createCollection(
        List<ListTrainingPipelinesPage> pages, int collectionSize) {
      return new ListTrainingPipelinesFixedSizeCollection(pages, collectionSize);
    }
  }
}
