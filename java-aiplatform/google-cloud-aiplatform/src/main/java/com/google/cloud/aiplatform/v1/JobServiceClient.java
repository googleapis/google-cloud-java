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
import com.google.cloud.aiplatform.v1.stub.JobServiceStub;
import com.google.cloud.aiplatform.v1.stub.JobServiceStubSettings;
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
 * Service Description: A service for creating and managing AI Platform's jobs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 * JobServiceSettings jobServiceSettings =
 *     JobServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class JobServiceClient implements BackgroundResource {
  private final JobServiceSettings settings;
  private final JobServiceStub stub;
  private final OperationsClient operationsClient;

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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected JobServiceClient(JobServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final JobServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobServiceStub getStub() {
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
   * Creates a CustomJob. A created CustomJob right away will be attempted to be run.
   *
   * @param parent Required. The resource name of the Location to create the CustomJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param customJob Required. The CustomJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob createCustomJob(LocationName parent, CustomJob customJob) {
    CreateCustomJobRequest request =
        CreateCustomJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomJob(customJob)
            .build();
    return createCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomJob. A created CustomJob right away will be attempted to be run.
   *
   * @param parent Required. The resource name of the Location to create the CustomJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param customJob Required. The CustomJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob createCustomJob(String parent, CustomJob customJob) {
    CreateCustomJobRequest request =
        CreateCustomJobRequest.newBuilder().setParent(parent).setCustomJob(customJob).build();
    return createCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomJob. A created CustomJob right away will be attempted to be run.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob createCustomJob(CreateCustomJobRequest request) {
    return createCustomJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomJob. A created CustomJob right away will be attempted to be run.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable() {
    return stub.createCustomJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a CustomJob.
   *
   * @param name Required. The name of the CustomJob resource. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob getCustomJob(CustomJobName name) {
    GetCustomJobRequest request =
        GetCustomJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a CustomJob.
   *
   * @param name Required. The name of the CustomJob resource. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob getCustomJob(String name) {
    GetCustomJobRequest request = GetCustomJobRequest.newBuilder().setName(name).build();
    return getCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a CustomJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomJob getCustomJob(GetCustomJobRequest request) {
    return getCustomJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a CustomJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable() {
    return stub.getCustomJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the CustomJobs from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomJobsPagedResponse listCustomJobs(LocationName parent) {
    ListCustomJobsRequest request =
        ListCustomJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the CustomJobs from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomJobsPagedResponse listCustomJobs(String parent) {
    ListCustomJobsRequest request = ListCustomJobsRequest.newBuilder().setParent(parent).build();
    return listCustomJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomJobs in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomJobsPagedResponse listCustomJobs(ListCustomJobsRequest request) {
    return listCustomJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable() {
    return stub.listCustomJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse>
      listCustomJobsCallable() {
    return stub.listCustomJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CustomJob.
   *
   * @param name Required. The name of the CustomJob resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteCustomJobAsync(
      CustomJobName name) {
    DeleteCustomJobRequest request =
        DeleteCustomJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCustomJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CustomJob.
   *
   * @param name Required. The name of the CustomJob resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteCustomJobAsync(String name) {
    DeleteCustomJobRequest request = DeleteCustomJobRequest.newBuilder().setName(name).build();
    return deleteCustomJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CustomJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteCustomJobAsync(
      DeleteCustomJobRequest request) {
    return deleteCustomJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CustomJob.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable() {
    return stub.deleteCustomJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CustomJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable() {
    return stub.deleteCustomJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetCustomJob][google.cloud.aiplatform.v1.JobService.GetCustomJob] or other methods
   * to check whether the cancellation succeeded or whether the job completed despite cancellation.
   * On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a
   * [CustomJob.error][google.cloud.aiplatform.v1.CustomJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [CustomJob.state][google.cloud.aiplatform.v1.CustomJob.state] is set to `CANCELLED`.
   *
   * @param name Required. The name of the CustomJob to cancel. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelCustomJob(CustomJobName name) {
    CancelCustomJobRequest request =
        CancelCustomJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    cancelCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetCustomJob][google.cloud.aiplatform.v1.JobService.GetCustomJob] or other methods
   * to check whether the cancellation succeeded or whether the job completed despite cancellation.
   * On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a
   * [CustomJob.error][google.cloud.aiplatform.v1.CustomJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [CustomJob.state][google.cloud.aiplatform.v1.CustomJob.state] is set to `CANCELLED`.
   *
   * @param name Required. The name of the CustomJob to cancel. Format:
   *     `projects/{project}/locations/{location}/customJobs/{custom_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelCustomJob(String name) {
    CancelCustomJobRequest request = CancelCustomJobRequest.newBuilder().setName(name).build();
    cancelCustomJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetCustomJob][google.cloud.aiplatform.v1.JobService.GetCustomJob] or other methods
   * to check whether the cancellation succeeded or whether the job completed despite cancellation.
   * On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a
   * [CustomJob.error][google.cloud.aiplatform.v1.CustomJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [CustomJob.state][google.cloud.aiplatform.v1.CustomJob.state] is set to `CANCELLED`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelCustomJob(CancelCustomJobRequest request) {
    cancelCustomJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetCustomJob][google.cloud.aiplatform.v1.JobService.GetCustomJob] or other methods
   * to check whether the cancellation succeeded or whether the job completed despite cancellation.
   * On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a
   * [CustomJob.error][google.cloud.aiplatform.v1.CustomJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [CustomJob.state][google.cloud.aiplatform.v1.CustomJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable() {
    return stub.cancelCustomJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataLabelingJob.
   *
   * @param parent Required. The parent of the DataLabelingJob. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataLabelingJob Required. The DataLabelingJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob createDataLabelingJob(
      LocationName parent, DataLabelingJob dataLabelingJob) {
    CreateDataLabelingJobRequest request =
        CreateDataLabelingJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataLabelingJob(dataLabelingJob)
            .build();
    return createDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataLabelingJob.
   *
   * @param parent Required. The parent of the DataLabelingJob. Format:
   *     `projects/{project}/locations/{location}`
   * @param dataLabelingJob Required. The DataLabelingJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob createDataLabelingJob(
      String parent, DataLabelingJob dataLabelingJob) {
    CreateDataLabelingJobRequest request =
        CreateDataLabelingJobRequest.newBuilder()
            .setParent(parent)
            .setDataLabelingJob(dataLabelingJob)
            .build();
    return createDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataLabelingJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob createDataLabelingJob(CreateDataLabelingJobRequest request) {
    return createDataLabelingJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DataLabelingJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable() {
    return stub.createDataLabelingJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DataLabelingJob.
   *
   * @param name Required. The name of the DataLabelingJob. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob getDataLabelingJob(DataLabelingJobName name) {
    GetDataLabelingJobRequest request =
        GetDataLabelingJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DataLabelingJob.
   *
   * @param name Required. The name of the DataLabelingJob. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob getDataLabelingJob(String name) {
    GetDataLabelingJobRequest request =
        GetDataLabelingJobRequest.newBuilder().setName(name).build();
    return getDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DataLabelingJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataLabelingJob getDataLabelingJob(GetDataLabelingJobRequest request) {
    return getDataLabelingJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DataLabelingJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobCallable() {
    return stub.getDataLabelingJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataLabelingJobs in a Location.
   *
   * @param parent Required. The parent of the DataLabelingJob. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataLabelingJobsPagedResponse listDataLabelingJobs(LocationName parent) {
    ListDataLabelingJobsRequest request =
        ListDataLabelingJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataLabelingJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataLabelingJobs in a Location.
   *
   * @param parent Required. The parent of the DataLabelingJob. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataLabelingJobsPagedResponse listDataLabelingJobs(String parent) {
    ListDataLabelingJobsRequest request =
        ListDataLabelingJobsRequest.newBuilder().setParent(parent).build();
    return listDataLabelingJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataLabelingJobs in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataLabelingJobsPagedResponse listDataLabelingJobs(
      ListDataLabelingJobsRequest request) {
    return listDataLabelingJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataLabelingJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable() {
    return stub.listDataLabelingJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataLabelingJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable() {
    return stub.listDataLabelingJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataLabelingJob.
   *
   * @param name Required. The name of the DataLabelingJob to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDataLabelingJobAsync(
      DataLabelingJobName name) {
    DeleteDataLabelingJobRequest request =
        DeleteDataLabelingJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDataLabelingJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataLabelingJob.
   *
   * @param name Required. The name of the DataLabelingJob to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDataLabelingJobAsync(
      String name) {
    DeleteDataLabelingJobRequest request =
        DeleteDataLabelingJobRequest.newBuilder().setName(name).build();
    return deleteDataLabelingJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataLabelingJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteDataLabelingJobAsync(
      DeleteDataLabelingJobRequest request) {
    return deleteDataLabelingJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataLabelingJob.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable() {
    return stub.deleteDataLabelingJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataLabelingJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobCallable() {
    return stub.deleteDataLabelingJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
   *
   * @param name Required. The name of the DataLabelingJob. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDataLabelingJob(DataLabelingJobName name) {
    CancelDataLabelingJobRequest request =
        CancelDataLabelingJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
   *
   * @param name Required. The name of the DataLabelingJob. Format:
   *     <p>`projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDataLabelingJob(String name) {
    CancelDataLabelingJobRequest request =
        CancelDataLabelingJobRequest.newBuilder().setName(name).build();
    cancelDataLabelingJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDataLabelingJob(CancelDataLabelingJobRequest request) {
    cancelDataLabelingJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable() {
    return stub.cancelDataLabelingJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HyperparameterTuningJob
   *
   * @param parent Required. The resource name of the Location to create the HyperparameterTuningJob
   *     in. Format: `projects/{project}/locations/{location}`
   * @param hyperparameterTuningJob Required. The HyperparameterTuningJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob createHyperparameterTuningJob(
      LocationName parent, HyperparameterTuningJob hyperparameterTuningJob) {
    CreateHyperparameterTuningJobRequest request =
        CreateHyperparameterTuningJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHyperparameterTuningJob(hyperparameterTuningJob)
            .build();
    return createHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HyperparameterTuningJob
   *
   * @param parent Required. The resource name of the Location to create the HyperparameterTuningJob
   *     in. Format: `projects/{project}/locations/{location}`
   * @param hyperparameterTuningJob Required. The HyperparameterTuningJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob createHyperparameterTuningJob(
      String parent, HyperparameterTuningJob hyperparameterTuningJob) {
    CreateHyperparameterTuningJobRequest request =
        CreateHyperparameterTuningJobRequest.newBuilder()
            .setParent(parent)
            .setHyperparameterTuningJob(hyperparameterTuningJob)
            .build();
    return createHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HyperparameterTuningJob
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob createHyperparameterTuningJob(
      CreateHyperparameterTuningJobRequest request) {
    return createHyperparameterTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HyperparameterTuningJob
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable() {
    return stub.createHyperparameterTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a HyperparameterTuningJob
   *
   * @param name Required. The name of the HyperparameterTuningJob resource. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob getHyperparameterTuningJob(
      HyperparameterTuningJobName name) {
    GetHyperparameterTuningJobRequest request =
        GetHyperparameterTuningJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a HyperparameterTuningJob
   *
   * @param name Required. The name of the HyperparameterTuningJob resource. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob getHyperparameterTuningJob(String name) {
    GetHyperparameterTuningJobRequest request =
        GetHyperparameterTuningJobRequest.newBuilder().setName(name).build();
    return getHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a HyperparameterTuningJob
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HyperparameterTuningJob getHyperparameterTuningJob(
      GetHyperparameterTuningJobRequest request) {
    return getHyperparameterTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a HyperparameterTuningJob
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable() {
    return stub.getHyperparameterTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HyperparameterTuningJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the HyperparameterTuningJobs
   *     from. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHyperparameterTuningJobsPagedResponse listHyperparameterTuningJobs(
      LocationName parent) {
    ListHyperparameterTuningJobsRequest request =
        ListHyperparameterTuningJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHyperparameterTuningJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HyperparameterTuningJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the HyperparameterTuningJobs
   *     from. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHyperparameterTuningJobsPagedResponse listHyperparameterTuningJobs(
      String parent) {
    ListHyperparameterTuningJobsRequest request =
        ListHyperparameterTuningJobsRequest.newBuilder().setParent(parent).build();
    return listHyperparameterTuningJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HyperparameterTuningJobs in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHyperparameterTuningJobsPagedResponse listHyperparameterTuningJobs(
      ListHyperparameterTuningJobsRequest request) {
    return listHyperparameterTuningJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HyperparameterTuningJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable() {
    return stub.listHyperparameterTuningJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HyperparameterTuningJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable() {
    return stub.listHyperparameterTuningJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a HyperparameterTuningJob.
   *
   * @param name Required. The name of the HyperparameterTuningJob resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteHyperparameterTuningJobAsync(
      HyperparameterTuningJobName name) {
    DeleteHyperparameterTuningJobRequest request =
        DeleteHyperparameterTuningJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteHyperparameterTuningJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a HyperparameterTuningJob.
   *
   * @param name Required. The name of the HyperparameterTuningJob resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteHyperparameterTuningJobAsync(
      String name) {
    DeleteHyperparameterTuningJobRequest request =
        DeleteHyperparameterTuningJobRequest.newBuilder().setName(name).build();
    return deleteHyperparameterTuningJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a HyperparameterTuningJob.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteHyperparameterTuningJobAsync(
      DeleteHyperparameterTuningJobRequest request) {
    return deleteHyperparameterTuningJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a HyperparameterTuningJob.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable() {
    return stub.deleteHyperparameterTuningJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a HyperparameterTuningJob.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable() {
    return stub.deleteHyperparameterTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the
   * HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not
   * guaranteed. Clients can use
   * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1.JobService.GetHyperparameterTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted;
   * instead it becomes a job with a
   * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1.HyperparameterTuningJob.error] value
   * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
   * `Code.CANCELLED`, and
   * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1.HyperparameterTuningJob.state] is
   * set to `CANCELLED`.
   *
   * @param name Required. The name of the HyperparameterTuningJob to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelHyperparameterTuningJob(HyperparameterTuningJobName name) {
    CancelHyperparameterTuningJobRequest request =
        CancelHyperparameterTuningJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the
   * HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not
   * guaranteed. Clients can use
   * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1.JobService.GetHyperparameterTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted;
   * instead it becomes a job with a
   * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1.HyperparameterTuningJob.error] value
   * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
   * `Code.CANCELLED`, and
   * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1.HyperparameterTuningJob.state] is
   * set to `CANCELLED`.
   *
   * @param name Required. The name of the HyperparameterTuningJob to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelHyperparameterTuningJob(String name) {
    CancelHyperparameterTuningJobRequest request =
        CancelHyperparameterTuningJobRequest.newBuilder().setName(name).build();
    cancelHyperparameterTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the
   * HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not
   * guaranteed. Clients can use
   * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1.JobService.GetHyperparameterTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted;
   * instead it becomes a job with a
   * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1.HyperparameterTuningJob.error] value
   * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
   * `Code.CANCELLED`, and
   * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1.HyperparameterTuningJob.state] is
   * set to `CANCELLED`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelHyperparameterTuningJob(CancelHyperparameterTuningJobRequest request) {
    cancelHyperparameterTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the
   * HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not
   * guaranteed. Clients can use
   * [JobService.GetHyperparameterTuningJob][google.cloud.aiplatform.v1.JobService.GetHyperparameterTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted;
   * instead it becomes a job with a
   * [HyperparameterTuningJob.error][google.cloud.aiplatform.v1.HyperparameterTuningJob.error] value
   * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to
   * `Code.CANCELLED`, and
   * [HyperparameterTuningJob.state][google.cloud.aiplatform.v1.HyperparameterTuningJob.state] is
   * set to `CANCELLED`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable() {
    return stub.cancelHyperparameterTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to
   * start.
   *
   * @param parent Required. The resource name of the Location to create the BatchPredictionJob in.
   *     Format: `projects/{project}/locations/{location}`
   * @param batchPredictionJob Required. The BatchPredictionJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob createBatchPredictionJob(
      LocationName parent, BatchPredictionJob batchPredictionJob) {
    CreateBatchPredictionJobRequest request =
        CreateBatchPredictionJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBatchPredictionJob(batchPredictionJob)
            .build();
    return createBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to
   * start.
   *
   * @param parent Required. The resource name of the Location to create the BatchPredictionJob in.
   *     Format: `projects/{project}/locations/{location}`
   * @param batchPredictionJob Required. The BatchPredictionJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob createBatchPredictionJob(
      String parent, BatchPredictionJob batchPredictionJob) {
    CreateBatchPredictionJobRequest request =
        CreateBatchPredictionJobRequest.newBuilder()
            .setParent(parent)
            .setBatchPredictionJob(batchPredictionJob)
            .build();
    return createBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to
   * start.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob createBatchPredictionJob(
      CreateBatchPredictionJobRequest request) {
    return createBatchPredictionJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to
   * start.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable() {
    return stub.createBatchPredictionJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BatchPredictionJob
   *
   * @param name Required. The name of the BatchPredictionJob resource. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob getBatchPredictionJob(BatchPredictionJobName name) {
    GetBatchPredictionJobRequest request =
        GetBatchPredictionJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BatchPredictionJob
   *
   * @param name Required. The name of the BatchPredictionJob resource. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob getBatchPredictionJob(String name) {
    GetBatchPredictionJobRequest request =
        GetBatchPredictionJobRequest.newBuilder().setName(name).build();
    return getBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BatchPredictionJob
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPredictionJob getBatchPredictionJob(GetBatchPredictionJobRequest request) {
    return getBatchPredictionJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BatchPredictionJob
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable() {
    return stub.getBatchPredictionJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BatchPredictionJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the BatchPredictionJobs from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchPredictionJobsPagedResponse listBatchPredictionJobs(LocationName parent) {
    ListBatchPredictionJobsRequest request =
        ListBatchPredictionJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBatchPredictionJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BatchPredictionJobs in a Location.
   *
   * @param parent Required. The resource name of the Location to list the BatchPredictionJobs from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchPredictionJobsPagedResponse listBatchPredictionJobs(String parent) {
    ListBatchPredictionJobsRequest request =
        ListBatchPredictionJobsRequest.newBuilder().setParent(parent).build();
    return listBatchPredictionJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BatchPredictionJobs in a Location.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBatchPredictionJobsPagedResponse listBatchPredictionJobs(
      ListBatchPredictionJobsRequest request) {
    return listBatchPredictionJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BatchPredictionJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable() {
    return stub.listBatchPredictionJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BatchPredictionJobs in a Location.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable() {
    return stub.listBatchPredictionJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
   *
   * @param name Required. The name of the BatchPredictionJob resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteBatchPredictionJobAsync(
      BatchPredictionJobName name) {
    DeleteBatchPredictionJobRequest request =
        DeleteBatchPredictionJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBatchPredictionJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
   *
   * @param name Required. The name of the BatchPredictionJob resource to be deleted. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteBatchPredictionJobAsync(
      String name) {
    DeleteBatchPredictionJobRequest request =
        DeleteBatchPredictionJobRequest.newBuilder().setName(name).build();
    return deleteBatchPredictionJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteBatchPredictionJobAsync(
      DeleteBatchPredictionJobRequest request) {
    return deleteBatchPredictionJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable() {
    return stub.deleteBatchPredictionJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable() {
    return stub.deleteBatchPredictionJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a BatchPredictionJob.
   *
   * <p>Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort
   * to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1.JobService.GetBatchPredictionJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On a successful cancellation, the BatchPredictionJob is not
   * deleted;instead its
   * [BatchPredictionJob.state][google.cloud.aiplatform.v1.BatchPredictionJob.state] is set to
   * `CANCELLED`. Any files already outputted by the job are not deleted.
   *
   * @param name Required. The name of the BatchPredictionJob to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelBatchPredictionJob(BatchPredictionJobName name) {
    CancelBatchPredictionJobRequest request =
        CancelBatchPredictionJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a BatchPredictionJob.
   *
   * <p>Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort
   * to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1.JobService.GetBatchPredictionJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On a successful cancellation, the BatchPredictionJob is not
   * deleted;instead its
   * [BatchPredictionJob.state][google.cloud.aiplatform.v1.BatchPredictionJob.state] is set to
   * `CANCELLED`. Any files already outputted by the job are not deleted.
   *
   * @param name Required. The name of the BatchPredictionJob to cancel. Format:
   *     <p>`projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelBatchPredictionJob(String name) {
    CancelBatchPredictionJobRequest request =
        CancelBatchPredictionJobRequest.newBuilder().setName(name).build();
    cancelBatchPredictionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a BatchPredictionJob.
   *
   * <p>Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort
   * to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1.JobService.GetBatchPredictionJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On a successful cancellation, the BatchPredictionJob is not
   * deleted;instead its
   * [BatchPredictionJob.state][google.cloud.aiplatform.v1.BatchPredictionJob.state] is set to
   * `CANCELLED`. Any files already outputted by the job are not deleted.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelBatchPredictionJob(CancelBatchPredictionJobRequest request) {
    cancelBatchPredictionJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a BatchPredictionJob.
   *
   * <p>Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort
   * to cancel the job, but success is not guaranteed. Clients can use
   * [JobService.GetBatchPredictionJob][google.cloud.aiplatform.v1.JobService.GetBatchPredictionJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On a successful cancellation, the BatchPredictionJob is not
   * deleted;instead its
   * [BatchPredictionJob.state][google.cloud.aiplatform.v1.BatchPredictionJob.state] is set to
   * `CANCELLED`. Any files already outputted by the job are not deleted.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobCallable() {
    return stub.cancelBatchPredictionJobCallable();
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

  public static class ListCustomJobsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomJobsRequest,
          ListCustomJobsResponse,
          CustomJob,
          ListCustomJobsPage,
          ListCustomJobsFixedSizeCollection> {

    public static ApiFuture<ListCustomJobsPagedResponse> createAsync(
        PageContext<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob> context,
        ApiFuture<ListCustomJobsResponse> futureResponse) {
      ApiFuture<ListCustomJobsPage> futurePage =
          ListCustomJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCustomJobsPage, ListCustomJobsPagedResponse>() {
            @Override
            public ListCustomJobsPagedResponse apply(ListCustomJobsPage input) {
              return new ListCustomJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCustomJobsPagedResponse(ListCustomJobsPage page) {
      super(page, ListCustomJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomJobsPage
      extends AbstractPage<
          ListCustomJobsRequest, ListCustomJobsResponse, CustomJob, ListCustomJobsPage> {

    private ListCustomJobsPage(
        PageContext<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob> context,
        ListCustomJobsResponse response) {
      super(context, response);
    }

    private static ListCustomJobsPage createEmptyPage() {
      return new ListCustomJobsPage(null, null);
    }

    @Override
    protected ListCustomJobsPage createPage(
        PageContext<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob> context,
        ListCustomJobsResponse response) {
      return new ListCustomJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomJobsPage> createPageAsync(
        PageContext<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob> context,
        ApiFuture<ListCustomJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomJobsRequest,
          ListCustomJobsResponse,
          CustomJob,
          ListCustomJobsPage,
          ListCustomJobsFixedSizeCollection> {

    private ListCustomJobsFixedSizeCollection(List<ListCustomJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomJobsFixedSizeCollection createEmptyCollection() {
      return new ListCustomJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomJobsFixedSizeCollection createCollection(
        List<ListCustomJobsPage> pages, int collectionSize) {
      return new ListCustomJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataLabelingJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          DataLabelingJob,
          ListDataLabelingJobsPage,
          ListDataLabelingJobsFixedSizeCollection> {

    public static ApiFuture<ListDataLabelingJobsPagedResponse> createAsync(
        PageContext<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
            context,
        ApiFuture<ListDataLabelingJobsResponse> futureResponse) {
      ApiFuture<ListDataLabelingJobsPage> futurePage =
          ListDataLabelingJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDataLabelingJobsPage, ListDataLabelingJobsPagedResponse>() {
            @Override
            public ListDataLabelingJobsPagedResponse apply(ListDataLabelingJobsPage input) {
              return new ListDataLabelingJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDataLabelingJobsPagedResponse(ListDataLabelingJobsPage page) {
      super(page, ListDataLabelingJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataLabelingJobsPage
      extends AbstractPage<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          DataLabelingJob,
          ListDataLabelingJobsPage> {

    private ListDataLabelingJobsPage(
        PageContext<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
            context,
        ListDataLabelingJobsResponse response) {
      super(context, response);
    }

    private static ListDataLabelingJobsPage createEmptyPage() {
      return new ListDataLabelingJobsPage(null, null);
    }

    @Override
    protected ListDataLabelingJobsPage createPage(
        PageContext<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
            context,
        ListDataLabelingJobsResponse response) {
      return new ListDataLabelingJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataLabelingJobsPage> createPageAsync(
        PageContext<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
            context,
        ApiFuture<ListDataLabelingJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataLabelingJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          DataLabelingJob,
          ListDataLabelingJobsPage,
          ListDataLabelingJobsFixedSizeCollection> {

    private ListDataLabelingJobsFixedSizeCollection(
        List<ListDataLabelingJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataLabelingJobsFixedSizeCollection createEmptyCollection() {
      return new ListDataLabelingJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataLabelingJobsFixedSizeCollection createCollection(
        List<ListDataLabelingJobsPage> pages, int collectionSize) {
      return new ListDataLabelingJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHyperparameterTuningJobsPagedResponse
      extends AbstractPagedListResponse<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          HyperparameterTuningJob,
          ListHyperparameterTuningJobsPage,
          ListHyperparameterTuningJobsFixedSizeCollection> {

    public static ApiFuture<ListHyperparameterTuningJobsPagedResponse> createAsync(
        PageContext<
                ListHyperparameterTuningJobsRequest,
                ListHyperparameterTuningJobsResponse,
                HyperparameterTuningJob>
            context,
        ApiFuture<ListHyperparameterTuningJobsResponse> futureResponse) {
      ApiFuture<ListHyperparameterTuningJobsPage> futurePage =
          ListHyperparameterTuningJobsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListHyperparameterTuningJobsPage, ListHyperparameterTuningJobsPagedResponse>() {
            @Override
            public ListHyperparameterTuningJobsPagedResponse apply(
                ListHyperparameterTuningJobsPage input) {
              return new ListHyperparameterTuningJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListHyperparameterTuningJobsPagedResponse(ListHyperparameterTuningJobsPage page) {
      super(page, ListHyperparameterTuningJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHyperparameterTuningJobsPage
      extends AbstractPage<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          HyperparameterTuningJob,
          ListHyperparameterTuningJobsPage> {

    private ListHyperparameterTuningJobsPage(
        PageContext<
                ListHyperparameterTuningJobsRequest,
                ListHyperparameterTuningJobsResponse,
                HyperparameterTuningJob>
            context,
        ListHyperparameterTuningJobsResponse response) {
      super(context, response);
    }

    private static ListHyperparameterTuningJobsPage createEmptyPage() {
      return new ListHyperparameterTuningJobsPage(null, null);
    }

    @Override
    protected ListHyperparameterTuningJobsPage createPage(
        PageContext<
                ListHyperparameterTuningJobsRequest,
                ListHyperparameterTuningJobsResponse,
                HyperparameterTuningJob>
            context,
        ListHyperparameterTuningJobsResponse response) {
      return new ListHyperparameterTuningJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListHyperparameterTuningJobsPage> createPageAsync(
        PageContext<
                ListHyperparameterTuningJobsRequest,
                ListHyperparameterTuningJobsResponse,
                HyperparameterTuningJob>
            context,
        ApiFuture<ListHyperparameterTuningJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHyperparameterTuningJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          HyperparameterTuningJob,
          ListHyperparameterTuningJobsPage,
          ListHyperparameterTuningJobsFixedSizeCollection> {

    private ListHyperparameterTuningJobsFixedSizeCollection(
        List<ListHyperparameterTuningJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHyperparameterTuningJobsFixedSizeCollection createEmptyCollection() {
      return new ListHyperparameterTuningJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHyperparameterTuningJobsFixedSizeCollection createCollection(
        List<ListHyperparameterTuningJobsPage> pages, int collectionSize) {
      return new ListHyperparameterTuningJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBatchPredictionJobsPagedResponse
      extends AbstractPagedListResponse<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          BatchPredictionJob,
          ListBatchPredictionJobsPage,
          ListBatchPredictionJobsFixedSizeCollection> {

    public static ApiFuture<ListBatchPredictionJobsPagedResponse> createAsync(
        PageContext<
                ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse, BatchPredictionJob>
            context,
        ApiFuture<ListBatchPredictionJobsResponse> futureResponse) {
      ApiFuture<ListBatchPredictionJobsPage> futurePage =
          ListBatchPredictionJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBatchPredictionJobsPage, ListBatchPredictionJobsPagedResponse>() {
            @Override
            public ListBatchPredictionJobsPagedResponse apply(ListBatchPredictionJobsPage input) {
              return new ListBatchPredictionJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBatchPredictionJobsPagedResponse(ListBatchPredictionJobsPage page) {
      super(page, ListBatchPredictionJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBatchPredictionJobsPage
      extends AbstractPage<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          BatchPredictionJob,
          ListBatchPredictionJobsPage> {

    private ListBatchPredictionJobsPage(
        PageContext<
                ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse, BatchPredictionJob>
            context,
        ListBatchPredictionJobsResponse response) {
      super(context, response);
    }

    private static ListBatchPredictionJobsPage createEmptyPage() {
      return new ListBatchPredictionJobsPage(null, null);
    }

    @Override
    protected ListBatchPredictionJobsPage createPage(
        PageContext<
                ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse, BatchPredictionJob>
            context,
        ListBatchPredictionJobsResponse response) {
      return new ListBatchPredictionJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListBatchPredictionJobsPage> createPageAsync(
        PageContext<
                ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse, BatchPredictionJob>
            context,
        ApiFuture<ListBatchPredictionJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBatchPredictionJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          BatchPredictionJob,
          ListBatchPredictionJobsPage,
          ListBatchPredictionJobsFixedSizeCollection> {

    private ListBatchPredictionJobsFixedSizeCollection(
        List<ListBatchPredictionJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBatchPredictionJobsFixedSizeCollection createEmptyCollection() {
      return new ListBatchPredictionJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBatchPredictionJobsFixedSizeCollection createCollection(
        List<ListBatchPredictionJobsPage> pages, int collectionSize) {
      return new ListBatchPredictionJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
