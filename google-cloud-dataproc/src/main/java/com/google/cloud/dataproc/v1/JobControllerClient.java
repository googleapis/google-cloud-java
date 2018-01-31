/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.PagedResponseWrappers.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.JobControllerStub;
import com.google.cloud.dataproc.v1.stub.JobControllerStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The JobController provides methods to manage jobs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
 *   String projectId = "";
 *   String region = "";
 *   Job job = Job.newBuilder().build();
 *   Job response = jobControllerClient.submitJob(projectId, region, job);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the jobControllerClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of JobControllerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * JobControllerSettings jobControllerSettings =
 *     JobControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobControllerClient jobControllerClient =
 *     JobControllerClient.create(jobControllerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * JobControllerSettings jobControllerSettings =
 *     JobControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobControllerClient jobControllerClient =
 *     JobControllerClient.create(jobControllerSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class JobControllerClient implements BackgroundResource {
  private final JobControllerSettings settings;
  private final JobControllerStub stub;

  /** Constructs an instance of JobControllerClient with default settings. */
  public static final JobControllerClient create() throws IOException {
    return create(JobControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of JobControllerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final JobControllerClient create(JobControllerSettings settings)
      throws IOException {
    return new JobControllerClient(settings);
  }

  /**
   * Constructs an instance of JobControllerClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use JobControllerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final JobControllerClient create(JobControllerStub stub) {
    return new JobControllerClient(stub);
  }

  /**
   * Constructs an instance of JobControllerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected JobControllerClient(JobControllerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((JobControllerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected JobControllerClient(JobControllerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final JobControllerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobControllerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Job job = Job.newBuilder().build();
   *   Job response = jobControllerClient.submitJob(projectId, region, job);
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @param job Required. The job resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job submitJob(String projectId, String region, Job job) {

    SubmitJobRequest request =
        SubmitJobRequest.newBuilder().setProjectId(projectId).setRegion(region).setJob(job).build();
    return submitJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Job job = Job.newBuilder().build();
   *   SubmitJobRequest request = SubmitJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJob(job)
   *     .build();
   *   Job response = jobControllerClient.submitJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job submitJob(SubmitJobRequest request) {
    return submitJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Job job = Job.newBuilder().build();
   *   SubmitJobRequest request = SubmitJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJob(job)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobControllerClient.submitJobCallable().futureCall(request);
   *   // Do something
   *   Job response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SubmitJobRequest, Job> submitJobCallable() {
    return stub.submitJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   Job response = jobControllerClient.getJob(projectId, region, jobId);
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @param jobId Required. The job ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String projectId, String region, String jobId) {

    GetJobRequest request =
        GetJobRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setJobId(jobId)
            .build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   GetJobRequest request = GetJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   Job response = jobControllerClient.getJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(GetJobRequest request) {
    return getJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   GetJobRequest request = GetJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobControllerClient.getJobCallable().futureCall(request);
   *   // Do something
   *   Job response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return stub.getJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   for (Job element : jobControllerClient.listJobs(projectId, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String projectId, String region) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setProjectId(projectId).setRegion(region).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   for (Job element : jobControllerClient.listJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(ListJobsRequest request) {
    return listJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListJobsPagedResponse&gt; future = jobControllerClient.listJobsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Job element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return stub.listJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     ListJobsResponse response = jobControllerClient.listJobsCallable().call(request);
   *     for (Job element : response.getJobsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a job in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   Job job = Job.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateJobRequest request = UpdateJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .setJob(job)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Job response = jobControllerClient.updateJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(UpdateJobRequest request) {
    return updateJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a job in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   Job job = Job.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateJobRequest request = UpdateJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .setJob(job)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobControllerClient.updateJobCallable().futureCall(request);
   *   // Do something
   *   Job response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return stub.updateJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1/projects.regions.jobs/list) or
   * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   Job response = jobControllerClient.cancelJob(projectId, region, jobId);
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @param jobId Required. The job ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job cancelJob(String projectId, String region, String jobId) {

    CancelJobRequest request =
        CancelJobRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setJobId(jobId)
            .build();
    return cancelJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1/projects.regions.jobs/list) or
   * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   CancelJobRequest request = CancelJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   Job response = jobControllerClient.cancelJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job cancelJob(CancelJobRequest request) {
    return cancelJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](/dataproc/docs/reference/rest/v1/projects.regions.jobs/list) or
   * [regions/{region}/jobs.get](/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   CancelJobRequest request = CancelJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobControllerClient.cancelJobCallable().futureCall(request);
   *   // Do something
   *   Job response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelJobRequest, Job> cancelJobCallable() {
    return stub.cancelJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   jobControllerClient.deleteJob(projectId, region, jobId);
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @param jobId Required. The job ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(String projectId, String region, String jobId) {

    DeleteJobRequest request =
        DeleteJobRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setJobId(jobId)
            .build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   DeleteJobRequest request = DeleteJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   jobControllerClient.deleteJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(DeleteJobRequest request) {
    deleteJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String jobId = "";
   *   DeleteJobRequest request = DeleteJobRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setJobId(jobId)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = jobControllerClient.deleteJobCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return stub.deleteJobCallable();
  }

  @Override
  public final void close() throws Exception {
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
}
