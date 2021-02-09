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

package com.google.cloud.dataproc.v1;

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
import com.google.cloud.dataproc.v1.stub.JobControllerStub;
import com.google.cloud.dataproc.v1.stub.JobControllerStubSettings;
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
 * Service Description: The JobController provides methods to manage jobs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
 *   String projectId = "projectId-894832108";
 *   String region = "region-934795532";
 *   Job job = Job.newBuilder().build();
 *   Job response = jobControllerClient.submitJob(projectId, region, job);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the JobControllerClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of JobControllerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * JobControllerSettings jobControllerSettings =
 *     JobControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobControllerClient jobControllerClient = JobControllerClient.create(jobControllerSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * JobControllerSettings jobControllerSettings =
 *     JobControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobControllerClient jobControllerClient = JobControllerClient.create(jobControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class JobControllerClient implements BackgroundResource {
  private final JobControllerSettings settings;
  private final JobControllerStub stub;
  private final OperationsClient operationsClient;

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
   * for advanced usage - prefer using create(JobControllerSettings).
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected JobControllerClient(JobControllerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final JobControllerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobControllerStub getStub() {
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
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   Job job = Job.newBuilder().build();
   *   Job response = jobControllerClient.submitJob(projectId, region, job);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param job Required. The job resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job submitJob(String projectId, String region, Job job) {
    SubmitJobRequest request =
        SubmitJobRequest.newBuilder().setProjectId(projectId).setRegion(region).setJob(job).build();
    return submitJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   SubmitJobRequest request =
   *       SubmitJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJob(Job.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Job response = jobControllerClient.submitJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job submitJob(SubmitJobRequest request) {
    return submitJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   SubmitJobRequest request =
   *       SubmitJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJob(Job.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Job> future = jobControllerClient.submitJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitJobRequest, Job> submitJobCallable() {
    return stub.submitJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   Job job = Job.newBuilder().build();
   *   Job response = jobControllerClient.submitJobAsOperationAsync(projectId, region, job).get();
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param job Required. The job resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, JobMetadata> submitJobAsOperationAsync(
      String projectId, String region, Job job) {
    SubmitJobRequest request =
        SubmitJobRequest.newBuilder().setProjectId(projectId).setRegion(region).setJob(job).build();
    return submitJobAsOperationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   SubmitJobRequest request =
   *       SubmitJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJob(Job.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Job response = jobControllerClient.submitJobAsOperationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, JobMetadata> submitJobAsOperationAsync(
      SubmitJobRequest request) {
    return submitJobAsOperationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   SubmitJobRequest request =
   *       SubmitJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJob(Job.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Job, JobMetadata> future =
   *       jobControllerClient.submitJobAsOperationOperationCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SubmitJobRequest, Job, JobMetadata>
      submitJobAsOperationOperationCallable() {
    return stub.submitJobAsOperationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits job to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   SubmitJobRequest request =
   *       SubmitJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJob(Job.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       jobControllerClient.submitJobAsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitJobRequest, Operation> submitJobAsOperationCallable() {
    return stub.submitJobAsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String jobId = "jobId101296568";
   *   Job response = jobControllerClient.getJob(projectId, region, jobId);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   Job response = jobControllerClient.getJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(GetJobRequest request) {
    return getJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a job in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<Job> future = jobControllerClient.getJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return stub.getJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   for (Job element : jobControllerClient.listJobs(projectId, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String projectId, String region) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setProjectId(projectId).setRegion(region).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String filter = "filter-1274492040";
   *   for (Job element : jobControllerClient.listJobs(projectId, region, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param filter Optional. A filter constraining the jobs to list. Filters are case-sensitive and
   *     have the following syntax:
   *     <p>[field = value] AND [field [= value]] ...
   *     <p>where &#42;&#42;field&#42;&#42; is `status.state` or `labels.[KEY]`, and `[KEY]` is a
   *     label key. &#42;&#42;value&#42;&#42; can be `&#42;` to match all values. `status.state` can
   *     be either `ACTIVE` or `NON_ACTIVE`. Only the logical `AND` operator is supported;
   *     space-separated items are treated as having an implicit `AND` operator.
   *     <p>Example filter:
   *     <p>status.state = ACTIVE AND labels.env = staging AND labels.starred = &#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String projectId, String region, String filter) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setFilter(filter)
            .build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setClusterName("clusterName-1141738587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Job element : jobControllerClient.listJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(ListJobsRequest request) {
    return listJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setClusterName("clusterName-1141738587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Job> future = jobControllerClient.listJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Job element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return stub.listJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists regions/{region}/jobs in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   while (true) {
   *     ListJobsResponse response = jobControllerClient.listJobsCallable().call(request);
   *     for (Job element : response.getResponsesList()) {
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
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .setJob(Job.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Job response = jobControllerClient.updateJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(UpdateJobRequest request) {
    return updateJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .setJob(Job.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Job> future = jobControllerClient.updateJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return stub.updateJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
   * or
   * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String jobId = "jobId101296568";
   *   Job response = jobControllerClient.cancelJob(projectId, region, jobId);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
   * or
   * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   CancelJobRequest request =
   *       CancelJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   Job response = jobControllerClient.cancelJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job cancelJob(CancelJobRequest request) {
    return cancelJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a job cancellation request. To access the job resource after cancellation, call
   * [regions/{region}/jobs.list](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list)
   * or
   * [regions/{region}/jobs.get](https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   CancelJobRequest request =
   *       CancelJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<Job> future = jobControllerClient.cancelJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelJobRequest, Job> cancelJobCallable() {
    return stub.cancelJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String jobId = "jobId101296568";
   *   jobControllerClient.deleteJob(projectId, region, jobId);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the job belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   jobControllerClient.deleteJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(DeleteJobRequest request) {
    deleteJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the job from the project. If the job is active, the delete fails, and the response
   * returns `FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setJobId("jobId101296568")
   *           .build();
   *   ApiFuture<Empty> future = jobControllerClient.deleteJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return stub.deleteJobCallable();
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
