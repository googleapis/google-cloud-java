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

package com.google.cloud.run.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.JobsStub;
import com.google.cloud.run.v2.stub.JobsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Run Job Control Plane API.
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
 * try (JobsClient jobsClient = JobsClient.create()) {
 *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
 *   Job response = jobsClient.getJob(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the JobsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of JobsSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobsSettings jobsSettings =
 *     JobsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobsClient jobsClient = JobsClient.create(jobsSettings);
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
 * JobsSettings jobsSettings = JobsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobsClient jobsClient = JobsClient.create(jobsSettings);
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
 * JobsSettings jobsSettings = JobsSettings.newHttpJsonBuilder().build();
 * JobsClient jobsClient = JobsClient.create(jobsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class JobsClient implements BackgroundResource {
  private final JobsSettings settings;
  private final JobsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of JobsClient with default settings. */
  public static final JobsClient create() throws IOException {
    return create(JobsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of JobsClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final JobsClient create(JobsSettings settings) throws IOException {
    return new JobsClient(settings);
  }

  /**
   * Constructs an instance of JobsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(JobsSettings).
   */
  public static final JobsClient create(JobsStub stub) {
    return new JobsClient(stub);
  }

  /**
   * Constructs an instance of JobsClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected JobsClient(JobsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((JobsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected JobsClient(JobsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final JobsSettings getSettings() {
    return settings;
  }

  public JobsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Job job = Job.newBuilder().build();
   *   String jobId = "jobId101296568";
   *   Job response = jobsClient.createJobAsync(parent, job, jobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location and project in which this Job should be created. Format:
   *     projects/{project}/locations/{location}
   * @param job Required. The Job instance to create.
   * @param jobId Required. The unique identifier for the Job. The name of the job becomes
   *     {parent}/jobs/{job_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> createJobAsync(
      LocationName parent, Job job, String jobId) {
    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJob(job)
            .setJobId(jobId)
            .build();
    return createJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Job job = Job.newBuilder().build();
   *   String jobId = "jobId101296568";
   *   Job response = jobsClient.createJobAsync(parent, job, jobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location and project in which this Job should be created. Format:
   *     projects/{project}/locations/{location}
   * @param job Required. The Job instance to create.
   * @param jobId Required. The unique identifier for the Job. The name of the job becomes
   *     {parent}/jobs/{job_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> createJobAsync(String parent, Job job, String jobId) {
    CreateJobRequest request =
        CreateJobRequest.newBuilder().setParent(parent).setJob(job).setJobId(jobId).build();
    return createJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .setJobId("jobId101296568")
   *           .setValidateOnly(true)
   *           .build();
   *   Job response = jobsClient.createJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> createJobAsync(CreateJobRequest request) {
    return createJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .setJobId("jobId101296568")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Job, Job> future =
   *       jobsClient.createJobOperationCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateJobRequest, Job, Job> createJobOperationCallable() {
    return stub.createJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .setJobId("jobId101296568")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = jobsClient.createJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateJobRequest, Operation> createJobCallable() {
    return stub.createJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   Job response = jobsClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {
    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   Job response = jobsClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {
    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   Job response = jobsClient.getJob(request);
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
   * Gets information about a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Job> future = jobsClient.getJobCallable().futureCall(request);
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
   * Lists Jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Job element : jobsClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location and project to list resources on. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(LocationName parent) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Job element : jobsClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location and project to list resources on. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent) {
    ListJobsRequest request = ListJobsRequest.newBuilder().setParent(parent).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Job element : jobsClient.listJobs(request).iterateAll()) {
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
   * Lists Jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Job> future = jobsClient.listJobsPagedCallable().futureCall(request);
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
   * Lists Jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListJobsResponse response = jobsClient.listJobsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   Job job = Job.newBuilder().build();
   *   Job response = jobsClient.updateJobAsync(job).get();
   * }
   * }</pre>
   *
   * @param job Required. The Job to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> updateJobAsync(Job job) {
    UpdateJobRequest request = UpdateJobRequest.newBuilder().setJob(job).build();
    return updateJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setJob(Job.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   Job response = jobsClient.updateJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> updateJobAsync(UpdateJobRequest request) {
    return updateJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setJob(Job.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Job, Job> future =
   *       jobsClient.updateJobOperationCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateJobRequest, Job, Job> updateJobOperationCallable() {
    return stub.updateJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setJob(Job.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = jobsClient.updateJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateJobRequest, Operation> updateJobCallable() {
    return stub.updateJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   Job response = jobsClient.deleteJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> deleteJobAsync(JobName name) {
    DeleteJobRequest request =
        DeleteJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   Job response = jobsClient.deleteJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> deleteJobAsync(String name) {
    DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name).build();
    return deleteJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Job response = jobsClient.deleteJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Job, Job> deleteJobAsync(DeleteJobRequest request) {
    return deleteJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Job, Job> future =
   *       jobsClient.deleteJobOperationCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteJobRequest, Job, Job> deleteJobOperationCallable() {
    return stub.deleteJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = jobsClient.deleteJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable() {
    return stub.deleteJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers creation of a new Execution of this Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   Execution response = jobsClient.runJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, Execution> runJobAsync(JobName name) {
    RunJobRequest request =
        RunJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers creation of a new Execution of this Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   Execution response = jobsClient.runJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Job. Format:
   *     projects/{project}/locations/{location}/jobs/{job}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, Execution> runJobAsync(String name) {
    RunJobRequest request = RunJobRequest.newBuilder().setName(name).build();
    return runJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers creation of a new Execution of this Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   RunJobRequest request =
   *       RunJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Execution response = jobsClient.runJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Execution, Execution> runJobAsync(RunJobRequest request) {
    return runJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers creation of a new Execution of this Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   RunJobRequest request =
   *       RunJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Execution, Execution> future =
   *       jobsClient.runJobOperationCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunJobRequest, Execution, Execution> runJobOperationCallable() {
    return stub.runJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers creation of a new Execution of this Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   RunJobRequest request =
   *       RunJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = jobsClient.runJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunJobRequest, Operation> runJobCallable() {
    return stub.runJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the IAM Access Control policy currently in effect for the given Job. This result does not
   * include any inherited policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = jobsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the IAM Access Control policy currently in effect for the given Job. This result does not
   * include any inherited policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = jobsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM Access control policy for the specified Job. Overwrites any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = jobsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM Access control policy for the specified Job. Overwrites any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = jobsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified Project.
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = jobsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified Project.
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsClient jobsClient = JobsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       jobsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
          futurePage, input -> new ListJobsPagedResponse(input), MoreExecutors.directExecutor());
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
