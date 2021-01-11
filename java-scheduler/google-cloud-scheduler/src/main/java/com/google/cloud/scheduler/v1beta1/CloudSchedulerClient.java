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

package com.google.cloud.scheduler.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.scheduler.v1beta1.stub.CloudSchedulerStub;
import com.google.cloud.scheduler.v1beta1.stub.CloudSchedulerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Scheduler API allows external entities to reliably schedule
 * asynchronous jobs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the CloudSchedulerClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of CloudSchedulerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CloudSchedulerSettings cloudSchedulerSettings =
 *     CloudSchedulerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudSchedulerClient cloudSchedulerClient = CloudSchedulerClient.create(cloudSchedulerSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CloudSchedulerSettings cloudSchedulerSettings =
 *     CloudSchedulerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudSchedulerClient cloudSchedulerClient = CloudSchedulerClient.create(cloudSchedulerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudSchedulerClient implements BackgroundResource {
  private final CloudSchedulerSettings settings;
  private final CloudSchedulerStub stub;

  /** Constructs an instance of CloudSchedulerClient with default settings. */
  public static final CloudSchedulerClient create() throws IOException {
    return create(CloudSchedulerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudSchedulerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudSchedulerClient create(CloudSchedulerSettings settings)
      throws IOException {
    return new CloudSchedulerClient(settings);
  }

  /**
   * Constructs an instance of CloudSchedulerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CloudSchedulerSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CloudSchedulerClient create(CloudSchedulerStub stub) {
    return new CloudSchedulerClient(stub);
  }

  /**
   * Constructs an instance of CloudSchedulerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudSchedulerClient(CloudSchedulerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudSchedulerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudSchedulerClient(CloudSchedulerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudSchedulerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudSchedulerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs.
   *
   * @param parent Required. The location name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(LocationName parent) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs.
   *
   * @param parent Required. The location name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent) {
    ListJobsRequest request = ListJobsRequest.newBuilder().setParent(parent).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(ListJobsRequest request) {
    return listJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return stub.listJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {
    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {
    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(GetJobRequest request) {
    return getJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return stub.getJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job.
   *
   * @param parent Required. The location name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID`.
   * @param job Required. The job to add. The user can optionally specify a name for the job in
   *     [name][google.cloud.scheduler.v1beta1.Job.name].
   *     [name][google.cloud.scheduler.v1beta1.Job.name] cannot be the same as an existing job. If a
   *     name is not specified then the system will generate a random unique name that will be
   *     returned ([name][google.cloud.scheduler.v1beta1.Job.name]) in the response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(LocationName parent, Job job) {
    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJob(job)
            .build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job.
   *
   * @param parent Required. The location name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID`.
   * @param job Required. The job to add. The user can optionally specify a name for the job in
   *     [name][google.cloud.scheduler.v1beta1.Job.name].
   *     [name][google.cloud.scheduler.v1beta1.Job.name] cannot be the same as an existing job. If a
   *     name is not specified then the system will generate a random unique name that will be
   *     returned ([name][google.cloud.scheduler.v1beta1.Job.name]) in the response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(String parent, Job job) {
    CreateJobRequest request = CreateJobRequest.newBuilder().setParent(parent).setJob(job).build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(CreateJobRequest request) {
    return createJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return stub.createJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job.
   *
   * <p>If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job
   * does not exist, `NOT_FOUND` is returned.
   *
   * <p>If UpdateJob does not successfully return, it is possible for the job to be in an
   * [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job
   * in this state may not be executed. If this happens, retry the UpdateJob request until a
   * successful response is received.
   *
   * @param job Required. The new job properties. [name][google.cloud.scheduler.v1beta1.Job.name]
   *     must be specified.
   *     <p>Output only fields cannot be modified using UpdateJob. Any value specified for an output
   *     only field will be ignored.
   * @param updateMask A mask used to specify which fields of the job are being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(Job job, FieldMask updateMask) {
    UpdateJobRequest request =
        UpdateJobRequest.newBuilder().setJob(job).setUpdateMask(updateMask).build();
    return updateJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job.
   *
   * <p>If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job
   * does not exist, `NOT_FOUND` is returned.
   *
   * <p>If UpdateJob does not successfully return, it is possible for the job to be in an
   * [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job
   * in this state may not be executed. If this happens, retry the UpdateJob request until a
   * successful response is received.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(UpdateJobRequest request) {
    return updateJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job.
   *
   * <p>If successful, the updated [Job][google.cloud.scheduler.v1beta1.Job] is returned. If the job
   * does not exist, `NOT_FOUND` is returned.
   *
   * <p>If UpdateJob does not successfully return, it is possible for the job to be in an
   * [Job.State.UPDATE_FAILED][google.cloud.scheduler.v1beta1.Job.State.UPDATE_FAILED] state. A job
   * in this state may not be executed. If this happens, retry the UpdateJob request until a
   * successful response is received.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return stub.updateJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(JobName name) {
    DeleteJobRequest request =
        DeleteJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(String name) {
    DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(DeleteJobRequest request) {
    deleteJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return stub.deleteJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a job.
   *
   * <p>If a job is paused then the system will stop executing the job until it is re-enabled via
   * [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The state of the job is
   * stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it will be set to
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in
   * [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED] to be paused.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job pauseJob(JobName name) {
    PauseJobRequest request =
        PauseJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return pauseJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a job.
   *
   * <p>If a job is paused then the system will stop executing the job until it is re-enabled via
   * [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The state of the job is
   * stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it will be set to
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in
   * [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED] to be paused.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job pauseJob(String name) {
    PauseJobRequest request = PauseJobRequest.newBuilder().setName(name).build();
    return pauseJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a job.
   *
   * <p>If a job is paused then the system will stop executing the job until it is re-enabled via
   * [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The state of the job is
   * stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it will be set to
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in
   * [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED] to be paused.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job pauseJob(PauseJobRequest request) {
    return pauseJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a job.
   *
   * <p>If a job is paused then the system will stop executing the job until it is re-enabled via
   * [ResumeJob][google.cloud.scheduler.v1beta1.CloudScheduler.ResumeJob]. The state of the job is
   * stored in [state][google.cloud.scheduler.v1beta1.Job.state]; if paused it will be set to
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. A job must be in
   * [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED] to be paused.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<PauseJobRequest, Job> pauseJobCallable() {
    return stub.pauseJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a job.
   *
   * <p>This method reenables a job after it has been
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The state of a job is
   * stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
   * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job
   * must be in [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job resumeJob(JobName name) {
    ResumeJobRequest request =
        ResumeJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resumeJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a job.
   *
   * <p>This method reenables a job after it has been
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The state of a job is
   * stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
   * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job
   * must be in [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job resumeJob(String name) {
    ResumeJobRequest request = ResumeJobRequest.newBuilder().setName(name).build();
    return resumeJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a job.
   *
   * <p>This method reenables a job after it has been
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The state of a job is
   * stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
   * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job
   * must be in [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job resumeJob(ResumeJobRequest request) {
    return resumeJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a job.
   *
   * <p>This method reenables a job after it has been
   * [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED]. The state of a job is
   * stored in [Job.state][google.cloud.scheduler.v1beta1.Job.state]; after calling this method it
   * will be set to [Job.State.ENABLED][google.cloud.scheduler.v1beta1.Job.State.ENABLED]. A job
   * must be in [Job.State.PAUSED][google.cloud.scheduler.v1beta1.Job.State.PAUSED] to be resumed.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResumeJobRequest, Job> resumeJobCallable() {
    return stub.resumeJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Forces a job to run now.
   *
   * <p>When this method is called, Cloud Scheduler will dispatch the job, even if the job is
   * already running.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job runJob(JobName name) {
    RunJobRequest request =
        RunJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Forces a job to run now.
   *
   * <p>When this method is called, Cloud Scheduler will dispatch the job, even if the job is
   * already running.
   *
   * @param name Required. The job name. For example:
   *     `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job runJob(String name) {
    RunJobRequest request = RunJobRequest.newBuilder().setName(name).build();
    return runJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Forces a job to run now.
   *
   * <p>When this method is called, Cloud Scheduler will dispatch the job, even if the job is
   * already running.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job runJob(RunJobRequest request) {
    return runJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Forces a job to run now.
   *
   * <p>When this method is called, Cloud Scheduler will dispatch the job, even if the job is
   * already running.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RunJobRequest, Job> runJobCallable() {
    return stub.runJobCallable();
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

  public static class ListJobsPagedResponse
      extends AbstractPagedListResponse<
          ListJobsRequest, ListJobsResponse, Job, ListJobsPage, ListJobsFixedSizeCollection> {

    public static ApiFuture<ListJobsPagedResponse> createAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      ApiFuture<ListJobsPage> futurePage =
          ListJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListJobsPage, ListJobsPagedResponse>() {
            @Override
            public ListJobsPagedResponse apply(ListJobsPage input) {
              return new ListJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListJobsPagedResponse(ListJobsPage page) {
      super(page, ListJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobsPage
      extends AbstractPage<ListJobsRequest, ListJobsResponse, Job, ListJobsPage> {

    private ListJobsPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      super(context, response);
    }

    private static ListJobsPage createEmptyPage() {
      return new ListJobsPage(null, null);
    }

    @Override
    protected ListJobsPage createPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      return new ListJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListJobsPage> createPageAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobsRequest, ListJobsResponse, Job, ListJobsPage, ListJobsFixedSizeCollection> {

    private ListJobsFixedSizeCollection(List<ListJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobsFixedSizeCollection createEmptyCollection() {
      return new ListJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobsFixedSizeCollection createCollection(
        List<ListJobsPage> pages, int collectionSize) {
      return new ListJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
