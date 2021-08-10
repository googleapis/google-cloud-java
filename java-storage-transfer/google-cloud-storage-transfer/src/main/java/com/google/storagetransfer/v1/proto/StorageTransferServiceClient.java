/*
 * Copyright 2021 Google LLC
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

package com.google.storagetransfer.v1.proto;

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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.stub.StorageTransferServiceStub;
import com.google.storagetransfer.v1.proto.stub.StorageTransferServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Storage Transfer Service and its protos. Transfers data between between
 * Google Cloud Storage buckets or from a data source external to Google to a Cloud Storage bucket.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (StorageTransferServiceClient storageTransferServiceClient =
 *     StorageTransferServiceClient.create()) {
 *   TransferProto.GetGoogleServiceAccountRequest request =
 *       TransferProto.GetGoogleServiceAccountRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .build();
 *   TransferTypes.GoogleServiceAccount response =
 *       storageTransferServiceClient.getGoogleServiceAccount(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StorageTransferServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of StorageTransferServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * StorageTransferServiceSettings storageTransferServiceSettings =
 *     StorageTransferServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StorageTransferServiceClient storageTransferServiceClient =
 *     StorageTransferServiceClient.create(storageTransferServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * StorageTransferServiceSettings storageTransferServiceSettings =
 *     StorageTransferServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StorageTransferServiceClient storageTransferServiceClient =
 *     StorageTransferServiceClient.create(storageTransferServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StorageTransferServiceClient implements BackgroundResource {
  private final StorageTransferServiceSettings settings;
  private final StorageTransferServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of StorageTransferServiceClient with default settings. */
  public static final StorageTransferServiceClient create() throws IOException {
    return create(StorageTransferServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StorageTransferServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StorageTransferServiceClient create(StorageTransferServiceSettings settings)
      throws IOException {
    return new StorageTransferServiceClient(settings);
  }

  /**
   * Constructs an instance of StorageTransferServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(StorageTransferServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final StorageTransferServiceClient create(StorageTransferServiceStub stub) {
    return new StorageTransferServiceClient(stub);
  }

  /**
   * Constructs an instance of StorageTransferServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected StorageTransferServiceClient(StorageTransferServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((StorageTransferServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected StorageTransferServiceClient(StorageTransferServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final StorageTransferServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public StorageTransferServiceStub getStub() {
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
   * Returns the Google service account that is used by Storage Transfer Service to access buckets
   * in the project where transfers run or in other projects. Each Google service account is
   * associated with one Google Cloud Platform Console project. Users should add this service
   * account to the Google Cloud Storage bucket ACLs to grant access to Storage Transfer Service.
   * This service account is created and owned by Storage Transfer Service and can only be used by
   * Storage Transfer Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.GetGoogleServiceAccountRequest request =
   *       TransferProto.GetGoogleServiceAccountRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   TransferTypes.GoogleServiceAccount response =
   *       storageTransferServiceClient.getGoogleServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferTypes.GoogleServiceAccount getGoogleServiceAccount(
      TransferProto.GetGoogleServiceAccountRequest request) {
    return getGoogleServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Google service account that is used by Storage Transfer Service to access buckets
   * in the project where transfers run or in other projects. Each Google service account is
   * associated with one Google Cloud Platform Console project. Users should add this service
   * account to the Google Cloud Storage bucket ACLs to grant access to Storage Transfer Service.
   * This service account is created and owned by Storage Transfer Service and can only be used by
   * Storage Transfer Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.GetGoogleServiceAccountRequest request =
   *       TransferProto.GetGoogleServiceAccountRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   ApiFuture<TransferTypes.GoogleServiceAccount> future =
   *       storageTransferServiceClient.getGoogleServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   TransferTypes.GoogleServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountCallable() {
    return stub.getGoogleServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a transfer job that runs periodically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.CreateTransferJobRequest request =
   *       TransferProto.CreateTransferJobRequest.newBuilder()
   *           .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
   *           .build();
   *   TransferTypes.TransferJob response = storageTransferServiceClient.createTransferJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferTypes.TransferJob createTransferJob(
      TransferProto.CreateTransferJobRequest request) {
    return createTransferJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a transfer job that runs periodically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.CreateTransferJobRequest request =
   *       TransferProto.CreateTransferJobRequest.newBuilder()
   *           .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
   *           .build();
   *   ApiFuture<TransferTypes.TransferJob> future =
   *       storageTransferServiceClient.createTransferJobCallable().futureCall(request);
   *   // Do something.
   *   TransferTypes.TransferJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobCallable() {
    return stub.createTransferJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a transfer job. Updating a job's transfer spec does not affect transfer operations that
   * are running already.
   *
   * <p>&#42;&#42;Note:&#42;&#42; The job's [status][google.storagetransfer.v1.TransferJob.status]
   * field can be modified using this RPC (for example, to set a job's status to
   * [DELETED][google.storagetransfer.v1.TransferJob.Status.DELETED],
   * [DISABLED][google.storagetransfer.v1.TransferJob.Status.DISABLED], or
   * [ENABLED][google.storagetransfer.v1.TransferJob.Status.ENABLED]).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.UpdateTransferJobRequest request =
   *       TransferProto.UpdateTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
   *           .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   TransferTypes.TransferJob response = storageTransferServiceClient.updateTransferJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferTypes.TransferJob updateTransferJob(
      TransferProto.UpdateTransferJobRequest request) {
    return updateTransferJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a transfer job. Updating a job's transfer spec does not affect transfer operations that
   * are running already.
   *
   * <p>&#42;&#42;Note:&#42;&#42; The job's [status][google.storagetransfer.v1.TransferJob.status]
   * field can be modified using this RPC (for example, to set a job's status to
   * [DELETED][google.storagetransfer.v1.TransferJob.Status.DELETED],
   * [DISABLED][google.storagetransfer.v1.TransferJob.Status.DISABLED], or
   * [ENABLED][google.storagetransfer.v1.TransferJob.Status.ENABLED]).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.UpdateTransferJobRequest request =
   *       TransferProto.UpdateTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
   *           .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TransferTypes.TransferJob> future =
   *       storageTransferServiceClient.updateTransferJobCallable().futureCall(request);
   *   // Do something.
   *   TransferTypes.TransferJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobCallable() {
    return stub.updateTransferJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a transfer job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.GetTransferJobRequest request =
   *       TransferProto.GetTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   TransferTypes.TransferJob response = storageTransferServiceClient.getTransferJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferTypes.TransferJob getTransferJob(
      TransferProto.GetTransferJobRequest request) {
    return getTransferJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a transfer job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.GetTransferJobRequest request =
   *       TransferProto.GetTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   ApiFuture<TransferTypes.TransferJob> future =
   *       storageTransferServiceClient.getTransferJobCallable().futureCall(request);
   *   // Do something.
   *   TransferTypes.TransferJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobCallable() {
    return stub.getTransferJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists transfer jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.ListTransferJobsRequest request =
   *       TransferProto.ListTransferJobsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TransferTypes.TransferJob element :
   *       storageTransferServiceClient.listTransferJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferJobsPagedResponse listTransferJobs(
      TransferProto.ListTransferJobsRequest request) {
    return listTransferJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists transfer jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.ListTransferJobsRequest request =
   *       TransferProto.ListTransferJobsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TransferTypes.TransferJob> future =
   *       storageTransferServiceClient.listTransferJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TransferTypes.TransferJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.ListTransferJobsRequest, ListTransferJobsPagedResponse>
      listTransferJobsPagedCallable() {
    return stub.listTransferJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists transfer jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.ListTransferJobsRequest request =
   *       TransferProto.ListTransferJobsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     TransferProto.ListTransferJobsResponse response =
   *         storageTransferServiceClient.listTransferJobsCallable().call(request);
   *     for (TransferTypes.TransferJob element : response.getResponsesList()) {
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
  public final UnaryCallable<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsCallable() {
    return stub.listTransferJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a transfer operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.PauseTransferOperationRequest request =
   *       TransferProto.PauseTransferOperationRequest.newBuilder().setName("name3373707").build();
   *   storageTransferServiceClient.pauseTransferOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseTransferOperation(TransferProto.PauseTransferOperationRequest request) {
    pauseTransferOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a transfer operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.PauseTransferOperationRequest request =
   *       TransferProto.PauseTransferOperationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future =
   *       storageTransferServiceClient.pauseTransferOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationCallable() {
    return stub.pauseTransferOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a transfer operation that is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.ResumeTransferOperationRequest request =
   *       TransferProto.ResumeTransferOperationRequest.newBuilder().setName("name3373707").build();
   *   storageTransferServiceClient.resumeTransferOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeTransferOperation(TransferProto.ResumeTransferOperationRequest request) {
    resumeTransferOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a transfer operation that is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.ResumeTransferOperationRequest request =
   *       TransferProto.ResumeTransferOperationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future =
   *       storageTransferServiceClient.resumeTransferOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationCallable() {
    return stub.resumeTransferOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attempts to start a new TransferOperation for the current TransferJob. A TransferJob has a
   * maximum of one active TransferOperation. If this method is called while a TransferOperation is
   * active, an error wil be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.RunTransferJobRequest request =
   *       TransferProto.RunTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   storageTransferServiceClient.runTransferJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, TransferTypes.TransferOperation> runTransferJobAsync(
      TransferProto.RunTransferJobRequest request) {
    return runTransferJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attempts to start a new TransferOperation for the current TransferJob. A TransferJob has a
   * maximum of one active TransferOperation. If this method is called while a TransferOperation is
   * active, an error wil be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.RunTransferJobRequest request =
   *       TransferProto.RunTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   OperationFuture<Empty, TransferTypes.TransferOperation> future =
   *       storageTransferServiceClient.runTransferJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationCallable() {
    return stub.runTransferJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attempts to start a new TransferOperation for the current TransferJob. A TransferJob has a
   * maximum of one active TransferOperation. If this method is called while a TransferOperation is
   * active, an error wil be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (StorageTransferServiceClient storageTransferServiceClient =
   *     StorageTransferServiceClient.create()) {
   *   TransferProto.RunTransferJobRequest request =
   *       TransferProto.RunTransferJobRequest.newBuilder()
   *           .setJobName("jobName-1438096408")
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   ApiFuture<Operation> future =
   *       storageTransferServiceClient.runTransferJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobCallable() {
    return stub.runTransferJobCallable();
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

  public static class ListTransferJobsPagedResponse
      extends AbstractPagedListResponse<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          TransferTypes.TransferJob,
          ListTransferJobsPage,
          ListTransferJobsFixedSizeCollection> {

    public static ApiFuture<ListTransferJobsPagedResponse> createAsync(
        PageContext<
                TransferProto.ListTransferJobsRequest,
                TransferProto.ListTransferJobsResponse,
                TransferTypes.TransferJob>
            context,
        ApiFuture<TransferProto.ListTransferJobsResponse> futureResponse) {
      ApiFuture<ListTransferJobsPage> futurePage =
          ListTransferJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTransferJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTransferJobsPagedResponse(ListTransferJobsPage page) {
      super(page, ListTransferJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferJobsPage
      extends AbstractPage<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          TransferTypes.TransferJob,
          ListTransferJobsPage> {

    private ListTransferJobsPage(
        PageContext<
                TransferProto.ListTransferJobsRequest,
                TransferProto.ListTransferJobsResponse,
                TransferTypes.TransferJob>
            context,
        TransferProto.ListTransferJobsResponse response) {
      super(context, response);
    }

    private static ListTransferJobsPage createEmptyPage() {
      return new ListTransferJobsPage(null, null);
    }

    @Override
    protected ListTransferJobsPage createPage(
        PageContext<
                TransferProto.ListTransferJobsRequest,
                TransferProto.ListTransferJobsResponse,
                TransferTypes.TransferJob>
            context,
        TransferProto.ListTransferJobsResponse response) {
      return new ListTransferJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferJobsPage> createPageAsync(
        PageContext<
                TransferProto.ListTransferJobsRequest,
                TransferProto.ListTransferJobsResponse,
                TransferTypes.TransferJob>
            context,
        ApiFuture<TransferProto.ListTransferJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          TransferTypes.TransferJob,
          ListTransferJobsPage,
          ListTransferJobsFixedSizeCollection> {

    private ListTransferJobsFixedSizeCollection(
        List<ListTransferJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferJobsFixedSizeCollection createEmptyCollection() {
      return new ListTransferJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferJobsFixedSizeCollection createCollection(
        List<ListTransferJobsPage> pages, int collectionSize) {
      return new ListTransferJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
