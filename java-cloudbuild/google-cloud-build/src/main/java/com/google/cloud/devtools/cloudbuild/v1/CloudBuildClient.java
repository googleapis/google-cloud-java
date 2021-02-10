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

package com.google.cloud.devtools.cloudbuild.v1;

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
import com.google.cloud.devtools.cloudbuild.v1.stub.CloudBuildStub;
import com.google.cloud.devtools.cloudbuild.v1.stub.CloudBuildStubSettings;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildOperationMetadata;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.RepoSource;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
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
 * Service Description: Creates and manages builds on Google Cloud Platform.
 *
 * <p>The main concept used by this API is a `Build`, which describes the location of the source to
 * build, how to build the source, and where to store the built artifacts, if any.
 *
 * <p>A user can list previously-requested builds or get builds by their ID to determine the status
 * of the build.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the CloudBuildClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of CloudBuildSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CloudBuildSettings cloudBuildSettings =
 *     CloudBuildSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudBuildClient cloudBuildClient = CloudBuildClient.create(cloudBuildSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CloudBuildSettings cloudBuildSettings =
 *     CloudBuildSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudBuildClient cloudBuildClient = CloudBuildClient.create(cloudBuildSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudBuildClient implements BackgroundResource {
  private final CloudBuildSettings settings;
  private final CloudBuildStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of CloudBuildClient with default settings. */
  public static final CloudBuildClient create() throws IOException {
    return create(CloudBuildSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudBuildClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudBuildClient create(CloudBuildSettings settings) throws IOException {
    return new CloudBuildClient(settings);
  }

  /**
   * Constructs an instance of CloudBuildClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CloudBuildSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CloudBuildClient create(CloudBuildStub stub) {
    return new CloudBuildClient(stub);
  }

  /**
   * Constructs an instance of CloudBuildClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected CloudBuildClient(CloudBuildSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudBuildStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudBuildClient(CloudBuildStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CloudBuildSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudBuildStub getStub() {
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
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * @param projectId Required. ID of the project.
   * @param build Required. Build resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> createBuildAsync(
      String projectId, Build build) {
    CreateBuildRequest request =
        CreateBuildRequest.newBuilder().setProjectId(projectId).setBuild(build).build();
    return createBuildAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> createBuildAsync(
      CreateBuildRequest request) {
    return createBuildOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationCallable() {
    return stub.createBuildOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateBuildRequest, Operation> createBuildCallable() {
    return stub.createBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * @param projectId Required. ID of the project.
   * @param id Required. ID of the build.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build getBuild(String projectId, String id) {
    GetBuildRequest request =
        GetBuildRequest.newBuilder().setProjectId(projectId).setId(id).build();
    return getBuild(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build getBuild(GetBuildRequest request) {
    return getBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetBuildRequest, Build> getBuildCallable() {
    return stub.getBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * @param projectId Required. ID of the project.
   * @param filter The raw filter text to constrain the results.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildsPagedResponse listBuilds(String projectId, String filter) {
    ListBuildsRequest request =
        ListBuildsRequest.newBuilder().setProjectId(projectId).setFilter(filter).build();
    return listBuilds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildsPagedResponse listBuilds(ListBuildsRequest request) {
    return listBuildsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable() {
    return stub.listBuildsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable() {
    return stub.listBuildsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a build in progress.
   *
   * @param projectId Required. ID of the project.
   * @param id Required. ID of the build.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build cancelBuild(String projectId, String id) {
    CancelBuildRequest request =
        CancelBuildRequest.newBuilder().setProjectId(projectId).setId(id).build();
    return cancelBuild(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a build in progress.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build cancelBuild(CancelBuildRequest request) {
    return cancelBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a build in progress.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable() {
    return stub.cancelBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <ul>
   *   <li>Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   *       will result in a build that uses the same revision.
   * </ul>
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <ul>
   *   <li>If the original build built from the tip of a branch, the retried build will build from
   *       the tip of that branch, which may not be the same revision as the original build.
   *   <li>If the original build specified a commit sha or revision ID, the retried build will use
   *       the identical source.
   * </ul>
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <ul>
   *   <li>If the original build pulled source from Google Cloud Storage without specifying the
   *       generation of the object, the new build will use the current object, which may be
   *       different from the original build source.
   *   <li>If the original build pulled source from Cloud Storage and specified the generation of
   *       the object, the new build will attempt to use the same object, which may or may not be
   *       available depending on the bucket's lifecycle management settings.
   * </ul>
   *
   * @param projectId Required. ID of the project.
   * @param id Required. Build ID of the original build.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> retryBuildAsync(
      String projectId, String id) {
    RetryBuildRequest request =
        RetryBuildRequest.newBuilder().setProjectId(projectId).setId(id).build();
    return retryBuildAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <ul>
   *   <li>Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   *       will result in a build that uses the same revision.
   * </ul>
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <ul>
   *   <li>If the original build built from the tip of a branch, the retried build will build from
   *       the tip of that branch, which may not be the same revision as the original build.
   *   <li>If the original build specified a commit sha or revision ID, the retried build will use
   *       the identical source.
   * </ul>
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <ul>
   *   <li>If the original build pulled source from Google Cloud Storage without specifying the
   *       generation of the object, the new build will use the current object, which may be
   *       different from the original build source.
   *   <li>If the original build pulled source from Cloud Storage and specified the generation of
   *       the object, the new build will attempt to use the same object, which may or may not be
   *       available depending on the bucket's lifecycle management settings.
   * </ul>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> retryBuildAsync(
      RetryBuildRequest request) {
    return retryBuildOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <ul>
   *   <li>Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   *       will result in a build that uses the same revision.
   * </ul>
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <ul>
   *   <li>If the original build built from the tip of a branch, the retried build will build from
   *       the tip of that branch, which may not be the same revision as the original build.
   *   <li>If the original build specified a commit sha or revision ID, the retried build will use
   *       the identical source.
   * </ul>
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <ul>
   *   <li>If the original build pulled source from Google Cloud Storage without specifying the
   *       generation of the object, the new build will use the current object, which may be
   *       different from the original build source.
   *   <li>If the original build pulled source from Cloud Storage and specified the generation of
   *       the object, the new build will attempt to use the same object, which may or may not be
   *       available depending on the bucket's lifecycle management settings.
   * </ul>
   *
   * <p>Sample code:
   */
  public final OperationCallable<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationCallable() {
    return stub.retryBuildOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <ul>
   *   <li>Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   *       will result in a build that uses the same revision.
   * </ul>
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <ul>
   *   <li>If the original build built from the tip of a branch, the retried build will build from
   *       the tip of that branch, which may not be the same revision as the original build.
   *   <li>If the original build specified a commit sha or revision ID, the retried build will use
   *       the identical source.
   * </ul>
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <ul>
   *   <li>If the original build pulled source from Google Cloud Storage without specifying the
   *       generation of the object, the new build will use the current object, which may be
   *       different from the original build source.
   *   <li>If the original build pulled source from Cloud Storage and specified the generation of
   *       the object, the new build will attempt to use the same object, which may or may not be
   *       available depending on the bucket's lifecycle management settings.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable() {
    return stub.retryBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * @param projectId Required. ID of the project for which to configure automatic builds.
   * @param trigger Required. `BuildTrigger` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger createBuildTrigger(String projectId, BuildTrigger trigger) {
    CreateBuildTriggerRequest request =
        CreateBuildTriggerRequest.newBuilder().setProjectId(projectId).setTrigger(trigger).build();
    return createBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger createBuildTrigger(CreateBuildTriggerRequest request) {
    return createBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable() {
    return stub.createBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * @param projectId Required. ID of the project that owns the trigger.
   * @param triggerId Required. Identifier (`id` or `name`) of the `BuildTrigger` to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger getBuildTrigger(String projectId, String triggerId) {
    GetBuildTriggerRequest request =
        GetBuildTriggerRequest.newBuilder().setProjectId(projectId).setTriggerId(triggerId).build();
    return getBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger getBuildTrigger(GetBuildTriggerRequest request) {
    return getBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable() {
    return stub.getBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * @param projectId Required. ID of the project for which to list BuildTriggers.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildTriggersPagedResponse listBuildTriggers(String projectId) {
    ListBuildTriggersRequest request =
        ListBuildTriggersRequest.newBuilder().setProjectId(projectId).build();
    return listBuildTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildTriggersPagedResponse listBuildTriggers(ListBuildTriggersRequest request) {
    return listBuildTriggersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersPagedResponse>
      listBuildTriggersPagedCallable() {
    return stub.listBuildTriggersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable() {
    return stub.listBuildTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * @param projectId Required. ID of the project that owns the trigger.
   * @param triggerId Required. ID of the `BuildTrigger` to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBuildTrigger(String projectId, String triggerId) {
    DeleteBuildTriggerRequest request =
        DeleteBuildTriggerRequest.newBuilder()
            .setProjectId(projectId)
            .setTriggerId(triggerId)
            .build();
    deleteBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBuildTrigger(DeleteBuildTriggerRequest request) {
    deleteBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable() {
    return stub.deleteBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * @param projectId Required. ID of the project that owns the trigger.
   * @param triggerId Required. ID of the `BuildTrigger` to update.
   * @param trigger Required. `BuildTrigger` to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger updateBuildTrigger(
      String projectId, String triggerId, BuildTrigger trigger) {
    UpdateBuildTriggerRequest request =
        UpdateBuildTriggerRequest.newBuilder()
            .setProjectId(projectId)
            .setTriggerId(triggerId)
            .setTrigger(trigger)
            .build();
    return updateBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger updateBuildTrigger(UpdateBuildTriggerRequest request) {
    return updateBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable() {
    return stub.updateBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * @param projectId Required. ID of the project.
   * @param triggerId Required. ID of the trigger.
   * @param source Required. Source to build against this trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> runBuildTriggerAsync(
      String projectId, String triggerId, RepoSource source) {
    RunBuildTriggerRequest request =
        RunBuildTriggerRequest.newBuilder()
            .setProjectId(projectId)
            .setTriggerId(triggerId)
            .setSource(source)
            .build();
    return runBuildTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Build, BuildOperationMetadata> runBuildTriggerAsync(
      RunBuildTriggerRequest request) {
    return runBuildTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * <p>Sample code:
   */
  public final OperationCallable<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationCallable() {
    return stub.runBuildTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable() {
    return stub.runBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool createWorkerPool(CreateWorkerPoolRequest request) {
    return createWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolCallable() {
    return stub.createWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool getWorkerPool(GetWorkerPoolRequest request) {
    return getWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return stub.getWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `WorkerPool` by its project ID and WorkerPool name.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkerPool(DeleteWorkerPoolRequest request) {
    deleteWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `WorkerPool` by its project ID and WorkerPool name.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolCallable() {
    return stub.deleteWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool updateWorkerPool(UpdateWorkerPoolRequest request) {
    return updateWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolCallable() {
    return stub.updateWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List project's `WorkerPools`.
   *
   * <p>This API is experimental.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkerPoolsResponse listWorkerPools(ListWorkerPoolsRequest request) {
    return listWorkerPoolsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List project's `WorkerPools`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable() {
    return stub.listWorkerPoolsCallable();
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

  public static class ListBuildsPagedResponse
      extends AbstractPagedListResponse<
          ListBuildsRequest,
          ListBuildsResponse,
          Build,
          ListBuildsPage,
          ListBuildsFixedSizeCollection> {

    public static ApiFuture<ListBuildsPagedResponse> createAsync(
        PageContext<ListBuildsRequest, ListBuildsResponse, Build> context,
        ApiFuture<ListBuildsResponse> futureResponse) {
      ApiFuture<ListBuildsPage> futurePage =
          ListBuildsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBuildsPage, ListBuildsPagedResponse>() {
            @Override
            public ListBuildsPagedResponse apply(ListBuildsPage input) {
              return new ListBuildsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBuildsPagedResponse(ListBuildsPage page) {
      super(page, ListBuildsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBuildsPage
      extends AbstractPage<ListBuildsRequest, ListBuildsResponse, Build, ListBuildsPage> {

    private ListBuildsPage(
        PageContext<ListBuildsRequest, ListBuildsResponse, Build> context,
        ListBuildsResponse response) {
      super(context, response);
    }

    private static ListBuildsPage createEmptyPage() {
      return new ListBuildsPage(null, null);
    }

    @Override
    protected ListBuildsPage createPage(
        PageContext<ListBuildsRequest, ListBuildsResponse, Build> context,
        ListBuildsResponse response) {
      return new ListBuildsPage(context, response);
    }

    @Override
    public ApiFuture<ListBuildsPage> createPageAsync(
        PageContext<ListBuildsRequest, ListBuildsResponse, Build> context,
        ApiFuture<ListBuildsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBuildsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBuildsRequest,
          ListBuildsResponse,
          Build,
          ListBuildsPage,
          ListBuildsFixedSizeCollection> {

    private ListBuildsFixedSizeCollection(List<ListBuildsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBuildsFixedSizeCollection createEmptyCollection() {
      return new ListBuildsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBuildsFixedSizeCollection createCollection(
        List<ListBuildsPage> pages, int collectionSize) {
      return new ListBuildsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBuildTriggersPagedResponse
      extends AbstractPagedListResponse<
          ListBuildTriggersRequest,
          ListBuildTriggersResponse,
          BuildTrigger,
          ListBuildTriggersPage,
          ListBuildTriggersFixedSizeCollection> {

    public static ApiFuture<ListBuildTriggersPagedResponse> createAsync(
        PageContext<ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger> context,
        ApiFuture<ListBuildTriggersResponse> futureResponse) {
      ApiFuture<ListBuildTriggersPage> futurePage =
          ListBuildTriggersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBuildTriggersPage, ListBuildTriggersPagedResponse>() {
            @Override
            public ListBuildTriggersPagedResponse apply(ListBuildTriggersPage input) {
              return new ListBuildTriggersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBuildTriggersPagedResponse(ListBuildTriggersPage page) {
      super(page, ListBuildTriggersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBuildTriggersPage
      extends AbstractPage<
          ListBuildTriggersRequest,
          ListBuildTriggersResponse,
          BuildTrigger,
          ListBuildTriggersPage> {

    private ListBuildTriggersPage(
        PageContext<ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger> context,
        ListBuildTriggersResponse response) {
      super(context, response);
    }

    private static ListBuildTriggersPage createEmptyPage() {
      return new ListBuildTriggersPage(null, null);
    }

    @Override
    protected ListBuildTriggersPage createPage(
        PageContext<ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger> context,
        ListBuildTriggersResponse response) {
      return new ListBuildTriggersPage(context, response);
    }

    @Override
    public ApiFuture<ListBuildTriggersPage> createPageAsync(
        PageContext<ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger> context,
        ApiFuture<ListBuildTriggersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBuildTriggersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBuildTriggersRequest,
          ListBuildTriggersResponse,
          BuildTrigger,
          ListBuildTriggersPage,
          ListBuildTriggersFixedSizeCollection> {

    private ListBuildTriggersFixedSizeCollection(
        List<ListBuildTriggersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBuildTriggersFixedSizeCollection createEmptyCollection() {
      return new ListBuildTriggersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBuildTriggersFixedSizeCollection createCollection(
        List<ListBuildTriggersPage> pages, int collectionSize) {
      return new ListBuildTriggersFixedSizeCollection(pages, collectionSize);
    }
  }
}
