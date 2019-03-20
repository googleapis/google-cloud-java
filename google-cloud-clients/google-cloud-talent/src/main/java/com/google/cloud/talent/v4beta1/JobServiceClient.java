/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.talent.v4beta1;

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
import com.google.cloud.talent.v4beta1.stub.JobServiceStub;
import com.google.cloud.talent.v4beta1.stub.JobServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: A service handles job management, including job CRUD, enumeration and
 * search.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Job job = Job.newBuilder().build();
 *   Job response = jobServiceClient.createJob(parent, job);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the jobServiceClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of JobServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobServiceClient jobServiceClient =
 *     JobServiceClient.create(jobServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobServiceClient jobServiceClient =
 *     JobServiceClient.create(jobServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class JobServiceClient implements BackgroundResource {
  private final JobServiceSettings settings;
  private final JobServiceStub stub;

  /** Constructs an instance of JobServiceClient with default settings. */
  public static final JobServiceClient create() throws IOException {
    return create(JobServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of JobServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final JobServiceClient create(JobServiceSettings settings) throws IOException {
    return new JobServiceClient(settings);
  }

  /**
   * Constructs an instance of JobServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use JobServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final JobServiceClient create(JobServiceStub stub) {
    return new JobServiceClient(stub);
  }

  /**
   * Constructs an instance of JobServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected JobServiceClient(JobServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((JobServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected JobServiceClient(JobServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final JobServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.createJob(parent, job);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param job Required.
   *     <p>The Job to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(ProjectName parent, Job job) {

    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJob(job)
            .build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.createJob(parent.toString(), job);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param job Required.
   *     <p>The Job to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(String parent, Job job) {

    CreateJobRequest request = CreateJobRequest.newBuilder().setParent(parent).setJob(job).build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Job job = Job.newBuilder().build();
   *   CreateJobRequest request = CreateJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setJob(job)
   *     .build();
   *   Job response = jobServiceClient.createJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(CreateJobRequest request) {
    return createJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Job job = Job.newBuilder().build();
   *   CreateJobRequest request = CreateJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setJob(job)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobServiceClient.createJobCallable().futureCall(request);
   *   // Do something
   *   Job response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return stub.createJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   Job response = jobServiceClient.getJob(name);
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the job to retrieve.
   *     <p>The format is "projects/{project_id}/jobs/{job_id}", for example,
   *     "projects/api-test-project/jobs/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {

    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   Job response = jobServiceClient.getJob(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the job to retrieve.
   *     <p>The format is "projects/{project_id}/jobs/{job_id}", for example,
   *     "projects/api-test-project/jobs/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {

    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   GetJobRequest request = GetJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Job response = jobServiceClient.getJob(request);
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
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   GetJobRequest request = GetJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobServiceClient.getJobCallable().futureCall(request);
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
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.updateJob(job);
   * }
   * </code></pre>
   *
   * @param job Required.
   *     <p>The Job to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(Job job) {

    UpdateJobRequest request = UpdateJobRequest.newBuilder().setJob(job).build();
    return updateJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   Job job = Job.newBuilder().build();
   *   UpdateJobRequest request = UpdateJobRequest.newBuilder()
   *     .setJob(job)
   *     .build();
   *   Job response = jobServiceClient.updateJob(request);
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
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   Job job = Job.newBuilder().build();
   *   UpdateJobRequest request = UpdateJobRequest.newBuilder()
   *     .setJob(job)
   *     .build();
   *   ApiFuture&lt;Job&gt; future = jobServiceClient.updateJobCallable().futureCall(request);
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
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   jobServiceClient.deleteJob(name);
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the job to be deleted.
   *     <p>The format is "projects/{project_id}/jobs/{job_id}", for example,
   *     "projects/api-test-project/jobs/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(JobName name) {

    DeleteJobRequest request =
        DeleteJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   jobServiceClient.deleteJob(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the job to be deleted.
   *     <p>The format is "projects/{project_id}/jobs/{job_id}", for example,
   *     "projects/api-test-project/jobs/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(String name) {

    DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   DeleteJobRequest request = DeleteJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   jobServiceClient.deleteJob(request);
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
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[JOBS]");
   *   DeleteJobRequest request = DeleteJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = jobServiceClient.deleteJobCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return stub.deleteJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   for (Job element : jobServiceClient.listJobs(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param filter Required.
   *     <p>The filter string specifies the jobs to be enumerated.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <p>&#42; `companyName` (Required) &#42; `requisitionId` (Optional) &#42; `status`
   *     (Optional) Available values: OPEN, EXPIRED, ALL. Defaults to OPEN if no value is specified.
   *     <p>Sample Query:
   *     <p>&#42; companyName = "projects/api-test-project/companies/123" &#42; companyName =
   *     "projects/api-test-project/companies/123" AND requisitionId = "req-1" &#42; companyName =
   *     "projects/api-test-project/companies/123" AND status = "EXPIRED"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(ProjectName parent, String filter) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   for (Job element : jobServiceClient.listJobs(parent.toString(), filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param filter Required.
   *     <p>The filter string specifies the jobs to be enumerated.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <p>&#42; `companyName` (Required) &#42; `requisitionId` (Optional) &#42; `status`
   *     (Optional) Available values: OPEN, EXPIRED, ALL. Defaults to OPEN if no value is specified.
   *     <p>Sample Query:
   *     <p>&#42; companyName = "projects/api-test-project/companies/123" &#42; companyName =
   *     "projects/api-test-project/companies/123" AND requisitionId = "req-1" &#42; companyName =
   *     "projects/api-test-project/companies/123" AND status = "EXPIRED"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent, String filter) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFilter(filter)
   *     .build();
   *   for (Job element : jobServiceClient.listJobs(request).iterateAll()) {
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
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;ListJobsPagedResponse&gt; future = jobServiceClient.listJobsPagedCallable().futureCall(request);
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
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   ListJobsRequest request = ListJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListJobsResponse response = jobServiceClient.listJobsCallable().call(request);
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
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   jobServiceClient.batchDeleteJobs(parent, filter);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param filter Required.
   *     <p>The filter string specifies the jobs to be deleted.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <p>&#42; `companyName` (Required) &#42; `requisitionId` (Required)
   *     <p>Sample Query: companyName = "projects/api-test-project/companies/123" AND requisitionId
   *     = "req-1"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(ProjectName parent, String filter) {

    BatchDeleteJobsRequest request =
        BatchDeleteJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    batchDeleteJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   jobServiceClient.batchDeleteJobs(parent.toString(), filter);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project under which the job is created.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param filter Required.
   *     <p>The filter string specifies the jobs to be deleted.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <p>&#42; `companyName` (Required) &#42; `requisitionId` (Required)
   *     <p>Sample Query: companyName = "projects/api-test-project/companies/123" AND requisitionId
   *     = "req-1"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(String parent, String filter) {

    BatchDeleteJobsRequest request =
        BatchDeleteJobsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    batchDeleteJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   BatchDeleteJobsRequest request = BatchDeleteJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFilter(filter)
   *     .build();
   *   jobServiceClient.batchDeleteJobs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(BatchDeleteJobsRequest request) {
    batchDeleteJobsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   BatchDeleteJobsRequest request = BatchDeleteJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = jobServiceClient.batchDeleteJobsCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchDeleteJobsRequest, Empty> batchDeleteJobsCallable() {
    return stub.batchDeleteJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs that the caller has permission to search
   * against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   for (SearchJobsResponse.MatchingJob element : jobServiceClient.searchJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchJobsPagedResponse searchJobs(SearchJobsRequest request) {
    return searchJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs that the caller has permission to search
   * against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   ApiFuture&lt;SearchJobsPagedResponse&gt; future = jobServiceClient.searchJobsPagedCallable().futureCall(request);
   *   // Do something
   *   for (SearchJobsResponse.MatchingJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchJobsRequest, SearchJobsPagedResponse> searchJobsPagedCallable() {
    return stub.searchJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs that the caller has permission to search
   * against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   while (true) {
   *     SearchJobsResponse response = jobServiceClient.searchJobsCallable().call(request);
   *     for (SearchJobsResponse.MatchingJob element : response.getMatchingJobsList()) {
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
  public final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    return stub.searchJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This API call is intended for the use case of targeting passive job seekers (for example,
   * job seekers who have signed up to receive email alerts about potential job opportunities), and
   * has different algorithmic adjustments that are targeted to passive job seekers.
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs the caller has permission to search against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   for (SearchJobsResponse.MatchingJob element : jobServiceClient.searchJobsForAlert(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchJobsForAlertPagedResponse searchJobsForAlert(SearchJobsRequest request) {
    return searchJobsForAlertPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This API call is intended for the use case of targeting passive job seekers (for example,
   * job seekers who have signed up to receive email alerts about potential job opportunities), and
   * has different algorithmic adjustments that are targeted to passive job seekers.
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs the caller has permission to search against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   ApiFuture&lt;SearchJobsForAlertPagedResponse&gt; future = jobServiceClient.searchJobsForAlertPagedCallable().futureCall(request);
   *   // Do something
   *   for (SearchJobsResponse.MatchingJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchJobsRequest, SearchJobsForAlertPagedResponse>
      searchJobsForAlertPagedCallable() {
    return stub.searchJobsForAlertPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for jobs using the provided
   * [SearchJobsRequest][google.cloud.talent.v4beta1.SearchJobsRequest].
   *
   * <p>This API call is intended for the use case of targeting passive job seekers (for example,
   * job seekers who have signed up to receive email alerts about potential job opportunities), and
   * has different algorithmic adjustments that are targeted to passive job seekers.
   *
   * <p>This call constrains the [visibility][google.cloud.talent.v4beta1.Job.visibility] of jobs
   * present in the database, and only returns jobs the caller has permission to search against.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RequestMetadata requestMetadata = RequestMetadata.newBuilder().build();
   *   SearchJobsRequest request = SearchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setRequestMetadata(requestMetadata)
   *     .build();
   *   while (true) {
   *     SearchJobsResponse response = jobServiceClient.searchJobsForAlertCallable().call(request);
   *     for (SearchJobsResponse.MatchingJob element : response.getMatchingJobsList()) {
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
  public final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable() {
    return stub.searchJobsForAlertCallable();
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

  public static class SearchJobsPagedResponse
      extends AbstractPagedListResponse<
          SearchJobsRequest,
          SearchJobsResponse,
          SearchJobsResponse.MatchingJob,
          SearchJobsPage,
          SearchJobsFixedSizeCollection> {

    public static ApiFuture<SearchJobsPagedResponse> createAsync(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        ApiFuture<SearchJobsResponse> futureResponse) {
      ApiFuture<SearchJobsPage> futurePage =
          SearchJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchJobsPage, SearchJobsPagedResponse>() {
            @Override
            public SearchJobsPagedResponse apply(SearchJobsPage input) {
              return new SearchJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchJobsPagedResponse(SearchJobsPage page) {
      super(page, SearchJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchJobsPage
      extends AbstractPage<
          SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob, SearchJobsPage> {

    private SearchJobsPage(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        SearchJobsResponse response) {
      super(context, response);
    }

    private static SearchJobsPage createEmptyPage() {
      return new SearchJobsPage(null, null);
    }

    @Override
    protected SearchJobsPage createPage(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        SearchJobsResponse response) {
      return new SearchJobsPage(context, response);
    }

    @Override
    public ApiFuture<SearchJobsPage> createPageAsync(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        ApiFuture<SearchJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchJobsRequest,
          SearchJobsResponse,
          SearchJobsResponse.MatchingJob,
          SearchJobsPage,
          SearchJobsFixedSizeCollection> {

    private SearchJobsFixedSizeCollection(List<SearchJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchJobsFixedSizeCollection createEmptyCollection() {
      return new SearchJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchJobsFixedSizeCollection createCollection(
        List<SearchJobsPage> pages, int collectionSize) {
      return new SearchJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchJobsForAlertPagedResponse
      extends AbstractPagedListResponse<
          SearchJobsRequest,
          SearchJobsResponse,
          SearchJobsResponse.MatchingJob,
          SearchJobsForAlertPage,
          SearchJobsForAlertFixedSizeCollection> {

    public static ApiFuture<SearchJobsForAlertPagedResponse> createAsync(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        ApiFuture<SearchJobsResponse> futureResponse) {
      ApiFuture<SearchJobsForAlertPage> futurePage =
          SearchJobsForAlertPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchJobsForAlertPage, SearchJobsForAlertPagedResponse>() {
            @Override
            public SearchJobsForAlertPagedResponse apply(SearchJobsForAlertPage input) {
              return new SearchJobsForAlertPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchJobsForAlertPagedResponse(SearchJobsForAlertPage page) {
      super(page, SearchJobsForAlertFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchJobsForAlertPage
      extends AbstractPage<
          SearchJobsRequest,
          SearchJobsResponse,
          SearchJobsResponse.MatchingJob,
          SearchJobsForAlertPage> {

    private SearchJobsForAlertPage(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        SearchJobsResponse response) {
      super(context, response);
    }

    private static SearchJobsForAlertPage createEmptyPage() {
      return new SearchJobsForAlertPage(null, null);
    }

    @Override
    protected SearchJobsForAlertPage createPage(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        SearchJobsResponse response) {
      return new SearchJobsForAlertPage(context, response);
    }

    @Override
    public ApiFuture<SearchJobsForAlertPage> createPageAsync(
        PageContext<SearchJobsRequest, SearchJobsResponse, SearchJobsResponse.MatchingJob> context,
        ApiFuture<SearchJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchJobsForAlertFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchJobsRequest,
          SearchJobsResponse,
          SearchJobsResponse.MatchingJob,
          SearchJobsForAlertPage,
          SearchJobsForAlertFixedSizeCollection> {

    private SearchJobsForAlertFixedSizeCollection(
        List<SearchJobsForAlertPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchJobsForAlertFixedSizeCollection createEmptyCollection() {
      return new SearchJobsForAlertFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchJobsForAlertFixedSizeCollection createCollection(
        List<SearchJobsForAlertPage> pages, int collectionSize) {
      return new SearchJobsForAlertFixedSizeCollection(pages, collectionSize);
    }
  }
}
