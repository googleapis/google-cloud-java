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

package com.google.dataflow.v1beta3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.dataflow.v1beta3.stub.MetricsV1Beta3Stub;
import com.google.dataflow.v1beta3.stub.MetricsV1Beta3StubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Dataflow Metrics API lets you monitor the progress of Dataflow jobs.
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
 * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
 *   GetJobMetricsRequest request =
 *       GetJobMetricsRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobId("jobId101296568")
 *           .setStartTime(Timestamp.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   JobMetrics response = metricsV1Beta3Client.getJobMetrics(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetricsV1Beta3Client object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of MetricsV1Beta3Settings to
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
 * MetricsV1Beta3Settings metricsV1Beta3Settings =
 *     MetricsV1Beta3Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create(metricsV1Beta3Settings);
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
 * MetricsV1Beta3Settings metricsV1Beta3Settings =
 *     MetricsV1Beta3Settings.newBuilder().setEndpoint(myEndpoint).build();
 * MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create(metricsV1Beta3Settings);
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
 * MetricsV1Beta3Settings metricsV1Beta3Settings =
 *     MetricsV1Beta3Settings.newBuilder()
 *         .setTransportChannelProvider(
 *             MetricsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create(metricsV1Beta3Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetricsV1Beta3Client implements BackgroundResource {
  private final MetricsV1Beta3Settings settings;
  private final MetricsV1Beta3Stub stub;

  /** Constructs an instance of MetricsV1Beta3Client with default settings. */
  public static final MetricsV1Beta3Client create() throws IOException {
    return create(MetricsV1Beta3Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetricsV1Beta3Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetricsV1Beta3Client create(MetricsV1Beta3Settings settings)
      throws IOException {
    return new MetricsV1Beta3Client(settings);
  }

  /**
   * Constructs an instance of MetricsV1Beta3Client, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MetricsV1Beta3Settings).
   */
  public static final MetricsV1Beta3Client create(MetricsV1Beta3Stub stub) {
    return new MetricsV1Beta3Client(stub);
  }

  /**
   * Constructs an instance of MetricsV1Beta3Client, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MetricsV1Beta3Client(MetricsV1Beta3Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MetricsV1Beta3StubSettings) settings.getStubSettings()).createStub();
  }

  protected MetricsV1Beta3Client(MetricsV1Beta3Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MetricsV1Beta3Settings getSettings() {
    return settings;
  }

  public MetricsV1Beta3Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request the job status.
   *
   * <p>To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with
   * a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints).
   * Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs
   * that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetJobMetricsRequest request =
   *       GetJobMetricsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   JobMetrics response = metricsV1Beta3Client.getJobMetrics(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobMetrics getJobMetrics(GetJobMetricsRequest request) {
    return getJobMetricsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request the job status.
   *
   * <p>To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with
   * a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints).
   * Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs
   * that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetJobMetricsRequest request =
   *       GetJobMetricsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<JobMetrics> future =
   *       metricsV1Beta3Client.getJobMetricsCallable().futureCall(request);
   *   // Do something.
   *   JobMetrics response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobMetricsRequest, JobMetrics> getJobMetricsCallable() {
    return stub.getJobMetricsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetJobExecutionDetailsRequest request =
   *       GetJobExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (StageSummary element :
   *       metricsV1Beta3Client.getJobExecutionDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetJobExecutionDetailsPagedResponse getJobExecutionDetails(
      GetJobExecutionDetailsRequest request) {
    return getJobExecutionDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetJobExecutionDetailsRequest request =
   *       GetJobExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<StageSummary> future =
   *       metricsV1Beta3Client.getJobExecutionDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StageSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobExecutionDetailsRequest, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsPagedCallable() {
    return stub.getJobExecutionDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetJobExecutionDetailsRequest request =
   *       GetJobExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     JobExecutionDetails response =
   *         metricsV1Beta3Client.getJobExecutionDetailsCallable().call(request);
   *     for (StageSummary element : response.getStagesList()) {
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
  public final UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsCallable() {
    return stub.getJobExecutionDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of a stage of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetStageExecutionDetailsRequest request =
   *       GetStageExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setStageId("stageId-1897528135")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   for (WorkerDetails element :
   *       metricsV1Beta3Client.getStageExecutionDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetStageExecutionDetailsPagedResponse getStageExecutionDetails(
      GetStageExecutionDetailsRequest request) {
    return getStageExecutionDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of a stage of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetStageExecutionDetailsRequest request =
   *       GetStageExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setStageId("stageId-1897528135")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<WorkerDetails> future =
   *       metricsV1Beta3Client.getStageExecutionDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkerDetails element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStageExecutionDetailsRequest, GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsPagedCallable() {
    return stub.getStageExecutionDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request detailed information about the execution status of a stage of the job.
   *
   * <p>EXPERIMENTAL. This API is subject to change or removal without notice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
   *   GetStageExecutionDetailsRequest request =
   *       GetStageExecutionDetailsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .setStageId("stageId-1897528135")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   while (true) {
   *     StageExecutionDetails response =
   *         metricsV1Beta3Client.getStageExecutionDetailsCallable().call(request);
   *     for (WorkerDetails element : response.getWorkersList()) {
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
  public final UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsCallable() {
    return stub.getStageExecutionDetailsCallable();
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

  public static class GetJobExecutionDetailsPagedResponse
      extends AbstractPagedListResponse<
          GetJobExecutionDetailsRequest,
          JobExecutionDetails,
          StageSummary,
          GetJobExecutionDetailsPage,
          GetJobExecutionDetailsFixedSizeCollection> {

    public static ApiFuture<GetJobExecutionDetailsPagedResponse> createAsync(
        PageContext<GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary> context,
        ApiFuture<JobExecutionDetails> futureResponse) {
      ApiFuture<GetJobExecutionDetailsPage> futurePage =
          GetJobExecutionDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new GetJobExecutionDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private GetJobExecutionDetailsPagedResponse(GetJobExecutionDetailsPage page) {
      super(page, GetJobExecutionDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetJobExecutionDetailsPage
      extends AbstractPage<
          GetJobExecutionDetailsRequest,
          JobExecutionDetails,
          StageSummary,
          GetJobExecutionDetailsPage> {

    private GetJobExecutionDetailsPage(
        PageContext<GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary> context,
        JobExecutionDetails response) {
      super(context, response);
    }

    private static GetJobExecutionDetailsPage createEmptyPage() {
      return new GetJobExecutionDetailsPage(null, null);
    }

    @Override
    protected GetJobExecutionDetailsPage createPage(
        PageContext<GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary> context,
        JobExecutionDetails response) {
      return new GetJobExecutionDetailsPage(context, response);
    }

    @Override
    public ApiFuture<GetJobExecutionDetailsPage> createPageAsync(
        PageContext<GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary> context,
        ApiFuture<JobExecutionDetails> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetJobExecutionDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetJobExecutionDetailsRequest,
          JobExecutionDetails,
          StageSummary,
          GetJobExecutionDetailsPage,
          GetJobExecutionDetailsFixedSizeCollection> {

    private GetJobExecutionDetailsFixedSizeCollection(
        List<GetJobExecutionDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetJobExecutionDetailsFixedSizeCollection createEmptyCollection() {
      return new GetJobExecutionDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected GetJobExecutionDetailsFixedSizeCollection createCollection(
        List<GetJobExecutionDetailsPage> pages, int collectionSize) {
      return new GetJobExecutionDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class GetStageExecutionDetailsPagedResponse
      extends AbstractPagedListResponse<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          WorkerDetails,
          GetStageExecutionDetailsPage,
          GetStageExecutionDetailsFixedSizeCollection> {

    public static ApiFuture<GetStageExecutionDetailsPagedResponse> createAsync(
        PageContext<GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails> context,
        ApiFuture<StageExecutionDetails> futureResponse) {
      ApiFuture<GetStageExecutionDetailsPage> futurePage =
          GetStageExecutionDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new GetStageExecutionDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private GetStageExecutionDetailsPagedResponse(GetStageExecutionDetailsPage page) {
      super(page, GetStageExecutionDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetStageExecutionDetailsPage
      extends AbstractPage<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          WorkerDetails,
          GetStageExecutionDetailsPage> {

    private GetStageExecutionDetailsPage(
        PageContext<GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails> context,
        StageExecutionDetails response) {
      super(context, response);
    }

    private static GetStageExecutionDetailsPage createEmptyPage() {
      return new GetStageExecutionDetailsPage(null, null);
    }

    @Override
    protected GetStageExecutionDetailsPage createPage(
        PageContext<GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails> context,
        StageExecutionDetails response) {
      return new GetStageExecutionDetailsPage(context, response);
    }

    @Override
    public ApiFuture<GetStageExecutionDetailsPage> createPageAsync(
        PageContext<GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails> context,
        ApiFuture<StageExecutionDetails> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetStageExecutionDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          WorkerDetails,
          GetStageExecutionDetailsPage,
          GetStageExecutionDetailsFixedSizeCollection> {

    private GetStageExecutionDetailsFixedSizeCollection(
        List<GetStageExecutionDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetStageExecutionDetailsFixedSizeCollection createEmptyCollection() {
      return new GetStageExecutionDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected GetStageExecutionDetailsFixedSizeCollection createCollection(
        List<GetStageExecutionDetailsPage> pages, int collectionSize) {
      return new GetStageExecutionDetailsFixedSizeCollection(pages, collectionSize);
    }
  }
}
