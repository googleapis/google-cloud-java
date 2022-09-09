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
import com.google.dataflow.v1beta3.stub.JobsV1Beta3Stub;
import com.google.dataflow.v1beta3.stub.JobsV1Beta3StubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides a method to create and modify Google Cloud Dataflow jobs. A Job is
 * a multi-stage computation graph run by the Cloud Dataflow service.
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
 * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
 *   CreateJobRequest request =
 *       CreateJobRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJob(Job.newBuilder().build())
 *           .setView(JobView.forNumber(0))
 *           .setReplaceJobId("replaceJobId441554788")
 *           .setLocation("location1901043637")
 *           .build();
 *   Job response = jobsV1Beta3Client.createJob(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the JobsV1Beta3Client object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of JobsV1Beta3Settings to
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
 * JobsV1Beta3Settings jobsV1Beta3Settings =
 *     JobsV1Beta3Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create(jobsV1Beta3Settings);
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
 * JobsV1Beta3Settings jobsV1Beta3Settings =
 *     JobsV1Beta3Settings.newBuilder().setEndpoint(myEndpoint).build();
 * JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create(jobsV1Beta3Settings);
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
 * JobsV1Beta3Settings jobsV1Beta3Settings =
 *     JobsV1Beta3Settings.newBuilder()
 *         .setTransportChannelProvider(
 *             JobsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create(jobsV1Beta3Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class JobsV1Beta3Client implements BackgroundResource {
  private final JobsV1Beta3Settings settings;
  private final JobsV1Beta3Stub stub;

  /** Constructs an instance of JobsV1Beta3Client with default settings. */
  public static final JobsV1Beta3Client create() throws IOException {
    return create(JobsV1Beta3Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of JobsV1Beta3Client, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final JobsV1Beta3Client create(JobsV1Beta3Settings settings) throws IOException {
    return new JobsV1Beta3Client(settings);
  }

  /**
   * Constructs an instance of JobsV1Beta3Client, using the given stub for making calls. This is for
   * advanced usage - prefer using create(JobsV1Beta3Settings).
   */
  public static final JobsV1Beta3Client create(JobsV1Beta3Stub stub) {
    return new JobsV1Beta3Client(stub);
  }

  /**
   * Constructs an instance of JobsV1Beta3Client, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected JobsV1Beta3Client(JobsV1Beta3Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((JobsV1Beta3StubSettings) settings.getStubSettings()).createStub();
  }

  protected JobsV1Beta3Client(JobsV1Beta3Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final JobsV1Beta3Settings getSettings() {
    return settings;
  }

  public JobsV1Beta3Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Dataflow job.
   *
   * <p>To create a job, we recommend using `projects.locations.jobs.create` with a [regional
   * endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.create` is not recommended, as your job will always start in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJob(Job.newBuilder().build())
   *           .setView(JobView.forNumber(0))
   *           .setReplaceJobId("replaceJobId441554788")
   *           .setLocation("location1901043637")
   *           .build();
   *   Job response = jobsV1Beta3Client.createJob(request);
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
   * Creates a Cloud Dataflow job.
   *
   * <p>To create a job, we recommend using `projects.locations.jobs.create` with a [regional
   * endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.create` is not recommended, as your job will always start in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJob(Job.newBuilder().build())
   *           .setView(JobView.forNumber(0))
   *           .setReplaceJobId("replaceJobId441554788")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future = jobsV1Beta3Client.createJobCallable().futureCall(request);
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
   * Gets the state of the specified Cloud Dataflow job.
   *
   * <p>To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional
   * endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running
   * in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setView(JobView.forNumber(0))
   *           .setLocation("location1901043637")
   *           .build();
   *   Job response = jobsV1Beta3Client.getJob(request);
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
   * Gets the state of the specified Cloud Dataflow job.
   *
   * <p>To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional
   * endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running
   * in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setView(JobView.forNumber(0))
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future = jobsV1Beta3Client.getJobCallable().futureCall(request);
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
   * Updates the state of an existing Cloud Dataflow job.
   *
   * <p>To update the state of an existing job, we recommend using `projects.locations.jobs.update`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.update` is not recommended, as you can only update the state of jobs that are
   * running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setJob(Job.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   Job response = jobsV1Beta3Client.updateJob(request);
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
   * Updates the state of an existing Cloud Dataflow job.
   *
   * <p>To update the state of an existing job, we recommend using `projects.locations.jobs.update`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.update` is not recommended, as you can only update the state of jobs that are
   * running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   UpdateJobRequest request =
   *       UpdateJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setJob(Job.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future = jobsV1Beta3Client.updateJobCallable().futureCall(request);
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
   * List the jobs of a project.
   *
   * <p>To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs
   * across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not
   * recommended, as you can only get the list of jobs that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   for (Job element : jobsV1Beta3Client.listJobs(request).iterateAll()) {
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
   * List the jobs of a project.
   *
   * <p>To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs
   * across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not
   * recommended, as you can only get the list of jobs that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future = jobsV1Beta3Client.listJobsPagedCallable().futureCall(request);
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
   * List the jobs of a project.
   *
   * <p>To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs
   * across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not
   * recommended, as you can only get the list of jobs that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   while (true) {
   *     ListJobsResponse response = jobsV1Beta3Client.listJobsCallable().call(request);
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
   * List the jobs of a project across all regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   for (Job element : jobsV1Beta3Client.aggregatedListJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListJobsPagedResponse aggregatedListJobs(ListJobsRequest request) {
    return aggregatedListJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the jobs of a project across all regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future =
   *       jobsV1Beta3Client.aggregatedListJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Job element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable() {
    return stub.aggregatedListJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the jobs of a project across all regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setView(JobView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLocation("location1901043637")
   *           .build();
   *   while (true) {
   *     ListJobsResponse response = jobsV1Beta3Client.aggregatedListJobsCallable().call(request);
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
  public final UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable() {
    return stub.aggregatedListJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check for existence of active jobs in the given project across all regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   CheckActiveJobsRequest request =
   *       CheckActiveJobsRequest.newBuilder().setProjectId("projectId-894832108").build();
   *   CheckActiveJobsResponse response = jobsV1Beta3Client.checkActiveJobs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckActiveJobsResponse checkActiveJobs(CheckActiveJobsRequest request) {
    return checkActiveJobsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Check for existence of active jobs in the given project across all regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   CheckActiveJobsRequest request =
   *       CheckActiveJobsRequest.newBuilder().setProjectId("projectId-894832108").build();
   *   ApiFuture<CheckActiveJobsResponse> future =
   *       jobsV1Beta3Client.checkActiveJobsCallable().futureCall(request);
   *   // Do something.
   *   CheckActiveJobsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckActiveJobsRequest, CheckActiveJobsResponse>
      checkActiveJobsCallable() {
    return stub.checkActiveJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshot the state of a streaming job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   SnapshotJobRequest request =
   *       SnapshotJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setTtl(Duration.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .setSnapshotSources(true)
   *           .setDescription("description-1724546052")
   *           .build();
   *   Snapshot response = jobsV1Beta3Client.snapshotJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot snapshotJob(SnapshotJobRequest request) {
    return snapshotJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Snapshot the state of a streaming job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
   *   SnapshotJobRequest request =
   *       SnapshotJobRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setTtl(Duration.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .setSnapshotSources(true)
   *           .setDescription("description-1724546052")
   *           .build();
   *   ApiFuture<Snapshot> future = jobsV1Beta3Client.snapshotJobCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable() {
    return stub.snapshotJobCallable();
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

  public static class AggregatedListJobsPagedResponse
      extends AbstractPagedListResponse<
          ListJobsRequest,
          ListJobsResponse,
          Job,
          AggregatedListJobsPage,
          AggregatedListJobsFixedSizeCollection> {

    public static ApiFuture<AggregatedListJobsPagedResponse> createAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      ApiFuture<AggregatedListJobsPage> futurePage =
          AggregatedListJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListJobsPagedResponse(AggregatedListJobsPage page) {
      super(page, AggregatedListJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListJobsPage
      extends AbstractPage<ListJobsRequest, ListJobsResponse, Job, AggregatedListJobsPage> {

    private AggregatedListJobsPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      super(context, response);
    }

    private static AggregatedListJobsPage createEmptyPage() {
      return new AggregatedListJobsPage(null, null);
    }

    @Override
    protected AggregatedListJobsPage createPage(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context, ListJobsResponse response) {
      return new AggregatedListJobsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListJobsPage> createPageAsync(
        PageContext<ListJobsRequest, ListJobsResponse, Job> context,
        ApiFuture<ListJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobsRequest,
          ListJobsResponse,
          Job,
          AggregatedListJobsPage,
          AggregatedListJobsFixedSizeCollection> {

    private AggregatedListJobsFixedSizeCollection(
        List<AggregatedListJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListJobsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListJobsFixedSizeCollection createCollection(
        List<AggregatedListJobsPage> pages, int collectionSize) {
      return new AggregatedListJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
