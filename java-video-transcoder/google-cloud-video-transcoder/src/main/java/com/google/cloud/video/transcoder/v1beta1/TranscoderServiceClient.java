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

package com.google.cloud.video.transcoder.v1beta1;

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
import com.google.cloud.video.transcoder.v1beta1.stub.TranscoderServiceStub;
import com.google.cloud.video.transcoder.v1beta1.stub.TranscoderServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Using the Transcoder API, you can queue asynchronous jobs for transcoding
 * media into various output formats. Output formats may include different streaming standards such
 * as HTTP Live Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can also
 * customize jobs using advanced features such as Digital Rights Management (DRM), audio
 * equalization, content concatenation, and digital ad-stitch ready content generation.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Job job = Job.newBuilder().build();
 *   Job response = transcoderServiceClient.createJob(parent, job);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TranscoderServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TranscoderServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TranscoderServiceSettings transcoderServiceSettings =
 *     TranscoderServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TranscoderServiceClient transcoderServiceClient =
 *     TranscoderServiceClient.create(transcoderServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * TranscoderServiceSettings transcoderServiceSettings =
 *     TranscoderServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TranscoderServiceClient transcoderServiceClient =
 *     TranscoderServiceClient.create(transcoderServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TranscoderServiceClient implements BackgroundResource {
  private final TranscoderServiceSettings settings;
  private final TranscoderServiceStub stub;

  /** Constructs an instance of TranscoderServiceClient with default settings. */
  public static final TranscoderServiceClient create() throws IOException {
    return create(TranscoderServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TranscoderServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TranscoderServiceClient create(TranscoderServiceSettings settings)
      throws IOException {
    return new TranscoderServiceClient(settings);
  }

  /**
   * Constructs an instance of TranscoderServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TranscoderServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TranscoderServiceClient create(TranscoderServiceStub stub) {
    return new TranscoderServiceClient(stub);
  }

  /**
   * Constructs an instance of TranscoderServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TranscoderServiceClient(TranscoderServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TranscoderServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TranscoderServiceClient(TranscoderServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TranscoderServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TranscoderServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Job job = Job.newBuilder().build();
   *   Job response = transcoderServiceClient.createJob(parent, job);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to create and process this job. Format:
   *     `projects/{project}/locations/{location}`
   * @param job Required. Parameters for creating transcoding job.
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
   * Creates a job in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Job job = Job.newBuilder().build();
   *   Job response = transcoderServiceClient.createJob(parent, job);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to create and process this job. Format:
   *     `projects/{project}/locations/{location}`
   * @param job Required. Parameters for creating transcoding job.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJob(String parent, Job job) {
    CreateJobRequest request = CreateJobRequest.newBuilder().setParent(parent).setJob(job).build();
    return createJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .build();
   *   Job response = transcoderServiceClient.createJob(request);
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
   * Creates a job in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   CreateJobRequest request =
   *       CreateJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJob(Job.newBuilder().build())
   *           .build();
   *   ApiFuture<Job> future = transcoderServiceClient.createJobCallable().futureCall(request);
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
   * Lists jobs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Job element : transcoderServiceClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(LocationName parent) {
    ListJobsRequest request =
        ListJobsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Job element : transcoderServiceClient.listJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobsPagedResponse listJobs(String parent) {
    ListJobsRequest request = ListJobsRequest.newBuilder().setParent(parent).build();
    return listJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists jobs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Job element : transcoderServiceClient.listJobs(request).iterateAll()) {
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
   * Lists jobs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   ListJobsRequest request =
   *       ListJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Job> future = transcoderServiceClient.listJobsPagedCallable().futureCall(request);
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
   * Lists jobs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   while (true) {
   *     ListJobsResponse response = transcoderServiceClient.listJobsCallable().call(request);
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
   * Returns the job data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   Job response = transcoderServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job to retrieve. Format:
   *     `projects/{project}/locations/{location}/jobs/{job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(JobName name) {
    GetJobRequest request =
        GetJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   Job response = transcoderServiceClient.getJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job to retrieve. Format:
   *     `projects/{project}/locations/{location}/jobs/{job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job getJob(String name) {
    GetJobRequest request = GetJobRequest.newBuilder().setName(name).build();
    return getJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   Job response = transcoderServiceClient.getJob(request);
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
   * Returns the job data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   GetJobRequest request =
   *       GetJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Job> future = transcoderServiceClient.getJobCallable().futureCall(request);
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
   * Deletes a job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   transcoderServiceClient.deleteJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job to delete. Format:
   *     `projects/{project}/locations/{location}/jobs/{job}`
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
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   transcoderServiceClient.deleteJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job to delete. Format:
   *     `projects/{project}/locations/{location}/jobs/{job}`
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
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   transcoderServiceClient.deleteJob(request);
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
   * Deletes a job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   DeleteJobRequest request =
   *       DeleteJobRequest.newBuilder()
   *           .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future = transcoderServiceClient.deleteJobCallable().futureCall(request);
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
   * Creates a job template in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   JobTemplate jobTemplate = JobTemplate.newBuilder().build();
   *   String jobTemplateId = "jobTemplateId-597733678";
   *   JobTemplate response =
   *       transcoderServiceClient.createJobTemplate(parent, jobTemplate, jobTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to create this job template. Format:
   *     `projects/{project}/locations/{location}`
   * @param jobTemplate Required. Parameters for creating job template.
   * @param jobTemplateId Required. The ID to use for the job template, which will become the final
   *     component of the job template's resource name.
   *     <p>This value should be 4-63 characters, and valid characters must match the regular
   *     expression `[a-zA-Z][a-zA-Z0-9_-]&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate createJobTemplate(
      LocationName parent, JobTemplate jobTemplate, String jobTemplateId) {
    CreateJobTemplateRequest request =
        CreateJobTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJobTemplate(jobTemplate)
            .setJobTemplateId(jobTemplateId)
            .build();
    return createJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job template in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   JobTemplate jobTemplate = JobTemplate.newBuilder().build();
   *   String jobTemplateId = "jobTemplateId-597733678";
   *   JobTemplate response =
   *       transcoderServiceClient.createJobTemplate(parent, jobTemplate, jobTemplateId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to create this job template. Format:
   *     `projects/{project}/locations/{location}`
   * @param jobTemplate Required. Parameters for creating job template.
   * @param jobTemplateId Required. The ID to use for the job template, which will become the final
   *     component of the job template's resource name.
   *     <p>This value should be 4-63 characters, and valid characters must match the regular
   *     expression `[a-zA-Z][a-zA-Z0-9_-]&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate createJobTemplate(
      String parent, JobTemplate jobTemplate, String jobTemplateId) {
    CreateJobTemplateRequest request =
        CreateJobTemplateRequest.newBuilder()
            .setParent(parent)
            .setJobTemplate(jobTemplate)
            .setJobTemplateId(jobTemplateId)
            .build();
    return createJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job template in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   CreateJobTemplateRequest request =
   *       CreateJobTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJobTemplate(JobTemplate.newBuilder().build())
   *           .setJobTemplateId("jobTemplateId-597733678")
   *           .build();
   *   JobTemplate response = transcoderServiceClient.createJobTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate createJobTemplate(CreateJobTemplateRequest request) {
    return createJobTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job template in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   CreateJobTemplateRequest request =
   *       CreateJobTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setJobTemplate(JobTemplate.newBuilder().build())
   *           .setJobTemplateId("jobTemplateId-597733678")
   *           .build();
   *   ApiFuture<JobTemplate> future =
   *       transcoderServiceClient.createJobTemplateCallable().futureCall(request);
   *   // Do something.
   *   JobTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateJobTemplateRequest, JobTemplate> createJobTemplateCallable() {
    return stub.createJobTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job templates in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (JobTemplate element : transcoderServiceClient.listJobTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location from which to retrieve the collection of job
   *     templates. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTemplatesPagedResponse listJobTemplates(LocationName parent) {
    ListJobTemplatesRequest request =
        ListJobTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listJobTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job templates in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (JobTemplate element : transcoderServiceClient.listJobTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location from which to retrieve the collection of job
   *     templates. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTemplatesPagedResponse listJobTemplates(String parent) {
    ListJobTemplatesRequest request =
        ListJobTemplatesRequest.newBuilder().setParent(parent).build();
    return listJobTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job templates in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   ListJobTemplatesRequest request =
   *       ListJobTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (JobTemplate element : transcoderServiceClient.listJobTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTemplatesPagedResponse listJobTemplates(ListJobTemplatesRequest request) {
    return listJobTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job templates in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   ListJobTemplatesRequest request =
   *       ListJobTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<JobTemplate> future =
   *       transcoderServiceClient.listJobTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (JobTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesPagedResponse>
      listJobTemplatesPagedCallable() {
    return stub.listJobTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job templates in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   while (true) {
   *     ListJobTemplatesResponse response =
   *         transcoderServiceClient.listJobTemplatesCallable().call(request);
   *     for (JobTemplate element : response.getResponsesList()) {
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
  public final UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesCallable() {
    return stub.listJobTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job template data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
   *   JobTemplate response = transcoderServiceClient.getJobTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job template to retrieve. Format:
   *     `projects/{project}/locations/{location}/jobTemplates/{job_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate getJobTemplate(JobTemplateName name) {
    GetJobTemplateRequest request =
        GetJobTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job template data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString();
   *   JobTemplate response = transcoderServiceClient.getJobTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job template to retrieve. Format:
   *     `projects/{project}/locations/{location}/jobTemplates/{job_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate getJobTemplate(String name) {
    GetJobTemplateRequest request = GetJobTemplateRequest.newBuilder().setName(name).build();
    return getJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job template data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   GetJobTemplateRequest request =
   *       GetJobTemplateRequest.newBuilder()
   *           .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
   *           .build();
   *   JobTemplate response = transcoderServiceClient.getJobTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTemplate getJobTemplate(GetJobTemplateRequest request) {
    return getJobTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the job template data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   GetJobTemplateRequest request =
   *       GetJobTemplateRequest.newBuilder()
   *           .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<JobTemplate> future =
   *       transcoderServiceClient.getJobTemplateCallable().futureCall(request);
   *   // Do something.
   *   JobTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobTemplateRequest, JobTemplate> getJobTemplateCallable() {
    return stub.getJobTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   JobTemplateName name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]");
   *   transcoderServiceClient.deleteJobTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job template to delete.
   *     `projects/{project}/locations/{location}/jobTemplates/{job_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTemplate(JobTemplateName name) {
    DeleteJobTemplateRequest request =
        DeleteJobTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   String name = JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString();
   *   transcoderServiceClient.deleteJobTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the job template to delete.
   *     `projects/{project}/locations/{location}/jobTemplates/{job_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTemplate(String name) {
    DeleteJobTemplateRequest request = DeleteJobTemplateRequest.newBuilder().setName(name).build();
    deleteJobTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   DeleteJobTemplateRequest request =
   *       DeleteJobTemplateRequest.newBuilder()
   *           .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
   *           .build();
   *   transcoderServiceClient.deleteJobTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTemplate(DeleteJobTemplateRequest request) {
    deleteJobTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
   *   DeleteJobTemplateRequest request =
   *       DeleteJobTemplateRequest.newBuilder()
   *           .setName(JobTemplateName.of("[PROJECT]", "[LOCATION]", "[JOB_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       transcoderServiceClient.deleteJobTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteJobTemplateRequest, Empty> deleteJobTemplateCallable() {
    return stub.deleteJobTemplateCallable();
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

  public static class ListJobTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListJobTemplatesRequest,
          ListJobTemplatesResponse,
          JobTemplate,
          ListJobTemplatesPage,
          ListJobTemplatesFixedSizeCollection> {

    public static ApiFuture<ListJobTemplatesPagedResponse> createAsync(
        PageContext<ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate> context,
        ApiFuture<ListJobTemplatesResponse> futureResponse) {
      ApiFuture<ListJobTemplatesPage> futurePage =
          ListJobTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListJobTemplatesPage, ListJobTemplatesPagedResponse>() {
            @Override
            public ListJobTemplatesPagedResponse apply(ListJobTemplatesPage input) {
              return new ListJobTemplatesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListJobTemplatesPagedResponse(ListJobTemplatesPage page) {
      super(page, ListJobTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobTemplatesPage
      extends AbstractPage<
          ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate, ListJobTemplatesPage> {

    private ListJobTemplatesPage(
        PageContext<ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate> context,
        ListJobTemplatesResponse response) {
      super(context, response);
    }

    private static ListJobTemplatesPage createEmptyPage() {
      return new ListJobTemplatesPage(null, null);
    }

    @Override
    protected ListJobTemplatesPage createPage(
        PageContext<ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate> context,
        ListJobTemplatesResponse response) {
      return new ListJobTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListJobTemplatesPage> createPageAsync(
        PageContext<ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate> context,
        ApiFuture<ListJobTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobTemplatesRequest,
          ListJobTemplatesResponse,
          JobTemplate,
          ListJobTemplatesPage,
          ListJobTemplatesFixedSizeCollection> {

    private ListJobTemplatesFixedSizeCollection(
        List<ListJobTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListJobTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobTemplatesFixedSizeCollection createCollection(
        List<ListJobTemplatesPage> pages, int collectionSize) {
      return new ListJobTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
