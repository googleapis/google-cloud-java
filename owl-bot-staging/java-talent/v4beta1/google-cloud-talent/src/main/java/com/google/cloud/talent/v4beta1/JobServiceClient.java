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

package com.google.cloud.talent.v4beta1;

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
import com.google.cloud.talent.v4beta1.stub.JobServiceStub;
import com.google.cloud.talent.v4beta1.stub.JobServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service handles job management, including job CRUD, enumeration and
 * search.
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
 * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Job job = Job.newBuilder().build();
 *   Job response = jobServiceClient.createJob(parent, job);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the JobServiceClient object to clean up resources such as
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings);
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
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings);
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
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             JobServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class JobServiceClient implements BackgroundResource {
  private final JobServiceSettings settings;
  private final JobServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

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
   * advanced usage - prefer using create(JobServiceSettings).
   */
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
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected JobServiceClient(JobServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final JobServiceSettings getSettings() {
    return settings;
  }

  public JobServiceStub getStub() {
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
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.createJob(parent, job);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified a default tenant is created. For
   *     example, "projects/foo".
   * @param job Required. The Job to be created.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.createJob(parent, job);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified a default tenant is created. For
   *     example, "projects/foo".
   * @param job Required. The Job to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(TenantName parent, Job job) {
    CreateJobRequest request =
        CreateJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJob(job)
            .build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String parent = TenantName.of("[PROJECT]", "[TENANT]").toString();
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.createJob(parent, job);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified a default tenant is created. For
   *     example, "projects/foo".
   * @param job Required. The Job to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(String parent, Job job) {
    CreateJobRequest request = CreateJobRequest.newBuilder().setParent(parent).setJob(job).build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .build();
   *   Job response = jobServiceClient.createJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(CreateJobRequest request) {
    return createJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job.
   *
   * <p>Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .build();
   *   ApiFuture<Job> future = jobServiceClient.createJobCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return stub.createJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchCreateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchCreateJobsAsync(
      ProjectName parent, List<Job> jobs) {
    BatchCreateJobsRequest request =
        BatchCreateJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllJobs(jobs)
            .build();
    return batchCreateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchCreateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchCreateJobsAsync(
      TenantName parent, List<Job> jobs) {
    BatchCreateJobsRequest request =
        BatchCreateJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllJobs(jobs)
            .build();
    return batchCreateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String parent = TenantName.of("[PROJECT]", "[TENANT]").toString();
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchCreateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchCreateJobsAsync(
      String parent, List<Job> jobs) {
    BatchCreateJobsRequest request =
        BatchCreateJobsRequest.newBuilder().setParent(parent).addAllJobs(jobs).build();
    return batchCreateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchCreateJobsRequest request =
   *       BatchCreateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .build();
   *   JobOperationResult response = jobServiceClient.batchCreateJobsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchCreateJobsAsync(
      BatchCreateJobsRequest request) {
    return batchCreateJobsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchCreateJobsRequest request =
   *       BatchCreateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .build();
   *   OperationFuture<JobOperationResult, BatchOperationMetadata> future =
   *       jobServiceClient.batchCreateJobsOperationCallable().futureCall(request);
   *   // Do something.
   *   JobOperationResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchCreateJobsRequest, JobOperationResult, BatchOperationMetadata>
      batchCreateJobsOperationCallable() {
    return stub.batchCreateJobsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch create jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchCreateJobsRequest request =
   *       BatchCreateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .build();
   *   ApiFuture<Operation> future = jobServiceClient.batchCreateJobsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable() {
    return stub.batchCreateJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");
   *   Job response = jobServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job to retrieve.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/jobs/{job_id}". For example,
   *     "projects/foo/tenants/bar/jobs/baz".
   *     <p>If tenant id is unspecified, the default tenant is used. For example,
   *     "projects/foo/jobs/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {
    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString();
   *   Job response = jobServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job to retrieve.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/jobs/{job_id}". For example,
   *     "projects/foo/tenants/bar/jobs/baz".
   *     <p>If tenant id is unspecified, the default tenant is used. For example,
   *     "projects/foo/jobs/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {
    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
   *           .build();
   *   Job response = jobServiceClient.getJob(request);
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
   * Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Job> future = jobServiceClient.getJobCallable().futureCall(request);
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
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   Job job = Job.newBuilder().build();
   *   Job response = jobServiceClient.updateJob(job);
   * }
   * }</pre>
   *
   * @param job Required. The Job to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job updateJob(Job job) {
    UpdateJobRequest request = UpdateJobRequest.newBuilder().setJob(job).build();
    return updateJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setJob(Job.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Job response = jobServiceClient.updateJob(request);
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
   * Updates specified job.
   *
   * <p>Typically, updated contents become visible in search results within 10 seconds, but it may
   * take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setJob(Job.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Job> future = jobServiceClient.updateJobCallable().futureCall(request);
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
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchUpdateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchUpdateJobsAsync(
      ProjectName parent, List<Job> jobs) {
    BatchUpdateJobsRequest request =
        BatchUpdateJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllJobs(jobs)
            .build();
    return batchUpdateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchUpdateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchUpdateJobsAsync(
      TenantName parent, List<Job> jobs) {
    BatchUpdateJobsRequest request =
        BatchUpdateJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllJobs(jobs)
            .build();
    return batchUpdateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String parent = TenantName.of("[PROJECT]", "[TENANT]").toString();
   *   List<Job> jobs = new ArrayList<>();
   *   JobOperationResult response = jobServiceClient.batchUpdateJobsAsync(parent, jobs).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param jobs Required. The jobs to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchUpdateJobsAsync(
      String parent, List<Job> jobs) {
    BatchUpdateJobsRequest request =
        BatchUpdateJobsRequest.newBuilder().setParent(parent).addAllJobs(jobs).build();
    return batchUpdateJobsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchUpdateJobsRequest request =
   *       BatchUpdateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   JobOperationResult response = jobServiceClient.batchUpdateJobsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<JobOperationResult, BatchOperationMetadata> batchUpdateJobsAsync(
      BatchUpdateJobsRequest request) {
    return batchUpdateJobsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchUpdateJobsRequest request =
   *       BatchUpdateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<JobOperationResult, BatchOperationMetadata> future =
   *       jobServiceClient.batchUpdateJobsOperationCallable().futureCall(request);
   *   // Do something.
   *   JobOperationResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchUpdateJobsRequest, JobOperationResult, BatchOperationMetadata>
      batchUpdateJobsOperationCallable() {
    return stub.batchUpdateJobsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins executing a batch update jobs operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchUpdateJobsRequest request =
   *       BatchUpdateJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .addAllJobs(new ArrayList<Job>())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = jobServiceClient.batchUpdateJobsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable() {
    return stub.batchUpdateJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   JobName name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]");
   *   jobServiceClient.deleteJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/jobs/{job_id}". For example,
   *     "projects/foo/tenants/bar/jobs/baz".
   *     <p>If tenant id is unspecified, the default tenant is used. For example,
   *     "projects/foo/jobs/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(JobName name) {
    DeleteJobRequest request =
        DeleteJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String name = JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString();
   *   jobServiceClient.deleteJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the job to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/jobs/{job_id}". For example,
   *     "projects/foo/tenants/bar/jobs/baz".
   *     <p>If tenant id is unspecified, the default tenant is used. For example,
   *     "projects/foo/jobs/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJob(String name) {
    DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name).build();
    deleteJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
   *           .build();
   *   jobServiceClient.deleteJob(request);
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
   * Deletes the specified job.
   *
   * <p>Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.ofProjectTenantJobName("[PROJECT]", "[TENANT]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future = jobServiceClient.deleteJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return stub.deleteJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "filter-1274492040";
   *   jobServiceClient.batchDeleteJobs(parent, filter);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be deleted.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName` (Required)
   *       <li>`requisitionId` (Required)
   *     </ul>
   *     <p>Sample Query: companyName = "projects/foo/companies/bar" AND requisitionId = "req-1"
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   String filter = "filter-1274492040";
   *   jobServiceClient.batchDeleteJobs(parent, filter);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be deleted.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName` (Required)
   *       <li>`requisitionId` (Required)
   *     </ul>
   *     <p>Sample Query: companyName = "projects/foo/companies/bar" AND requisitionId = "req-1"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(TenantName parent, String filter) {
    BatchDeleteJobsRequest request =
        BatchDeleteJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    batchDeleteJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String parent = TenantName.of("[PROJECT]", "[TENANT]").toString();
   *   String filter = "filter-1274492040";
   *   jobServiceClient.batchDeleteJobs(parent, filter);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be deleted.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName` (Required)
   *       <li>`requisitionId` (Required)
   *     </ul>
   *     <p>Sample Query: companyName = "projects/foo/companies/bar" AND requisitionId = "req-1"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(String parent, String filter) {
    BatchDeleteJobsRequest request =
        BatchDeleteJobsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    batchDeleteJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchDeleteJobsRequest request =
   *       BatchDeleteJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   jobServiceClient.batchDeleteJobs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteJobs(BatchDeleteJobsRequest request) {
    batchDeleteJobsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of [Job][google.cloud.talent.v4beta1.Job]s by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   BatchDeleteJobsRequest request =
   *       BatchDeleteJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Empty> future = jobServiceClient.batchDeleteJobsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteJobsRequest, Empty> batchDeleteJobsCallable() {
    return stub.batchDeleteJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "filter-1274492040";
   *   for (Job element : jobServiceClient.listJobs(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be enumerated.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName`
   *       <li>`requisitionId`
   *       <li>`status` Available values: OPEN, EXPIRED, ALL. Defaults to OPEN if no value is
   *           specified.
   *     </ul>
   *     <p>At least one of `companyName` and `requisitionId` must present or an INVALID_ARGUMENT
   *     error is thrown.
   *     <p>Sample Query:
   *     <ul>
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND requisitionId = "req-1"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND status = "EXPIRED"
   *       <li>requisitionId = "req-1"
   *       <li>requisitionId = "req-1" AND status = "EXPIRED"
   *     </ul>
   *
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
   *   String filter = "filter-1274492040";
   *   for (Job element : jobServiceClient.listJobs(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be enumerated.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName`
   *       <li>`requisitionId`
   *       <li>`status` Available values: OPEN, EXPIRED, ALL. Defaults to OPEN if no value is
   *           specified.
   *     </ul>
   *     <p>At least one of `companyName` and `requisitionId` must present or an INVALID_ARGUMENT
   *     error is thrown.
   *     <p>Sample Query:
   *     <ul>
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND requisitionId = "req-1"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND status = "EXPIRED"
   *       <li>requisitionId = "req-1"
   *       <li>requisitionId = "req-1" AND status = "EXPIRED"
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(TenantName parent, String filter) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   String parent = TenantName.of("[PROJECT]", "[TENANT]").toString();
   *   String filter = "filter-1274492040";
   *   for (Job element : jobServiceClient.listJobs(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the tenant under which the job is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenant/bar". If tenant id is unspecified, a default tenant is created. For
   *     example, "projects/foo".
   * @param filter Required. The filter string specifies the jobs to be enumerated.
   *     <p>Supported operator: =, AND
   *     <p>The fields eligible for filtering are:
   *     <ul>
   *       <li>`companyName`
   *       <li>`requisitionId`
   *       <li>`status` Available values: OPEN, EXPIRED, ALL. Defaults to OPEN if no value is
   *           specified.
   *     </ul>
   *     <p>At least one of `companyName` and `requisitionId` must present or an INVALID_ARGUMENT
   *     error is thrown.
   *     <p>Sample Query:
   *     <ul>
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND requisitionId = "req-1"
   *       <li>companyName = "projects/foo/tenants/bar/companies/baz" AND status = "EXPIRED"
   *       <li>requisitionId = "req-1"
   *       <li>requisitionId = "req-1" AND status = "EXPIRED"
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent, String filter) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setJobView(JobView.forNumber(0))
   *           .build();
   *   for (Job element : jobServiceClient.listJobs(request).iterateAll()) {
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
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setJobView(JobView.forNumber(0))
   *           .build();
   *   ApiFuture<Job> future = jobServiceClient.listJobsPagedCallable().futureCall(request);
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
   * Lists jobs by filter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setJobView(JobView.forNumber(0))
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return stub.listJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
   *   for (SearchJobsResponse.MatchingJob element :
   *       jobServiceClient.searchJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchJobsPagedResponse searchJobs(SearchJobsRequest request) {
    return searchJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
   *   ApiFuture<SearchJobsResponse.MatchingJob> future =
   *       jobServiceClient.searchJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchJobsResponse.MatchingJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchJobsRequest, SearchJobsPagedResponse> searchJobsPagedCallable() {
    return stub.searchJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    return stub.searchJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
   *   for (SearchJobsResponse.MatchingJob element :
   *       jobServiceClient.searchJobsForAlert(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchJobsForAlertPagedResponse searchJobsForAlert(SearchJobsRequest request) {
    return searchJobsForAlertPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
   *   ApiFuture<SearchJobsResponse.MatchingJob> future =
   *       jobServiceClient.searchJobsForAlertPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchJobsResponse.MatchingJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchJobsRequest, SearchJobsForAlertPagedResponse>
      searchJobsForAlertPagedCallable() {
    return stub.searchJobsForAlertPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
   *   SearchJobsRequest request =
   *       SearchJobsRequest.newBuilder()
   *           .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setJobQuery(JobQuery.newBuilder().build())
   *           .setEnableBroadening(true)
   *           .setRequirePreciseResultSize(true)
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setJobView(JobView.forNumber(0))
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setCustomRankingInfo(SearchJobsRequest.CustomRankingInfo.newBuilder().build())
   *           .setDisableKeywordMatch(true)
   *           .build();
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
   * }</pre>
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
          futurePage, input -> new SearchJobsPagedResponse(input), MoreExecutors.directExecutor());
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
          input -> new SearchJobsForAlertPagedResponse(input),
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
