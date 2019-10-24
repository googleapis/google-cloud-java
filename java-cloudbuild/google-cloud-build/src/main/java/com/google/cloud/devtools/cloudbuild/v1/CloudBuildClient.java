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
package com.google.cloud.devtools.cloudbuild.v1;

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
import com.google.cloud.devtools.cloudbuild.v1.stub.CloudBuildStub;
import com.google.cloud.devtools.cloudbuild.v1.stub.CloudBuildStubSettings;
import com.google.cloudbuild.v1.Build;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
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
 * <pre>
 * <code>
 * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
 *   String projectId = "";
 *   Build build = Build.newBuilder().build();
 *   Operation response = cloudBuildClient.createBuild(projectId, build);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the cloudBuildClient object to clean up resources such as
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
 * <pre>
 * <code>
 * CloudBuildSettings cloudBuildSettings =
 *     CloudBuildSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudBuildClient cloudBuildClient =
 *     CloudBuildClient.create(cloudBuildSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * CloudBuildSettings cloudBuildSettings =
 *     CloudBuildSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudBuildClient cloudBuildClient =
 *     CloudBuildClient.create(cloudBuildSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class CloudBuildClient implements BackgroundResource {
  private final CloudBuildSettings settings;
  private final CloudBuildStub stub;

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
   * advanced usage - prefer to use CloudBuildSettings}.
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
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudBuildClient(CloudBuildStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudBuildSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudBuildStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   Build build = Build.newBuilder().build();
   *   Operation response = cloudBuildClient.createBuild(projectId, build);
   * }
   * </code></pre>
   *
   * @param projectId Required. ID of the project.
   * @param build Required. Build resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createBuild(String projectId, Build build) {

    CreateBuildRequest request =
        CreateBuildRequest.newBuilder().setProjectId(projectId).setBuild(build).build();
    return createBuild(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   Build build = Build.newBuilder().build();
   *   CreateBuildRequest request = CreateBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setBuild(build)
   *     .build();
   *   Operation response = cloudBuildClient.createBuild(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createBuild(CreateBuildRequest request) {
    return createBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a build with the specified configuration.
   *
   * <p>This method returns a long-running `Operation`, which includes the build ID. Pass the build
   * ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   Build build = Build.newBuilder().build();
   *   CreateBuildRequest request = CreateBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setBuild(build)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudBuildClient.createBuildCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateBuildRequest, Operation> createBuildCallable() {
    return stub.createBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   Build response = cloudBuildClient.getBuild(projectId, id);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   GetBuildRequest request = GetBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   Build response = cloudBuildClient.getBuild(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build getBuild(GetBuildRequest request) {
    return getBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a previously requested build.
   *
   * <p>The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or
   * `WORKING`), and timing information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   GetBuildRequest request = GetBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   ApiFuture&lt;Build&gt; future = cloudBuildClient.getBuildCallable().futureCall(request);
   *   // Do something
   *   Build response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBuildRequest, Build> getBuildCallable() {
    return stub.getBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String filter = "";
   *   for (Build element : cloudBuildClient.listBuilds(projectId, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildsRequest request = ListBuildsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   for (Build element : cloudBuildClient.listBuilds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildsPagedResponse listBuilds(ListBuildsRequest request) {
    return listBuildsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildsRequest request = ListBuildsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ApiFuture&lt;ListBuildsPagedResponse&gt; future = cloudBuildClient.listBuildsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Build element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBuildsRequest, ListBuildsPagedResponse> listBuildsPagedCallable() {
    return stub.listBuildsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists previously requested builds.
   *
   * <p>Previously requested builds may still be in-progress, or may have finished successfully or
   * unsuccessfully.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildsRequest request = ListBuildsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   while (true) {
   *     ListBuildsResponse response = cloudBuildClient.listBuildsCallable().call(request);
   *     for (Build element : response.getBuildsList()) {
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
  public final UnaryCallable<ListBuildsRequest, ListBuildsResponse> listBuildsCallable() {
    return stub.listBuildsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels a build in progress.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   Build response = cloudBuildClient.cancelBuild(projectId, id);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels a build in progress.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   CancelBuildRequest request = CancelBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   Build response = cloudBuildClient.cancelBuild(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Build cancelBuild(CancelBuildRequest request) {
    return cancelBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels a build in progress.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   CancelBuildRequest request = CancelBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   ApiFuture&lt;Build&gt; future = cloudBuildClient.cancelBuildCallable().futureCall(request);
   *   // Do something
   *   Build response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelBuildRequest, Build> cancelBuildCallable() {
    return stub.cancelBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   BuildTrigger response = cloudBuildClient.createBuildTrigger(projectId, trigger);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   CreateBuildTriggerRequest request = CreateBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTrigger(trigger)
   *     .build();
   *   BuildTrigger response = cloudBuildClient.createBuildTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger createBuildTrigger(CreateBuildTriggerRequest request) {
    return createBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   CreateBuildTriggerRequest request = CreateBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTrigger(trigger)
   *     .build();
   *   ApiFuture&lt;BuildTrigger&gt; future = cloudBuildClient.createBuildTriggerCallable().futureCall(request);
   *   // Do something
   *   BuildTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerCallable() {
    return stub.createBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   BuildTrigger response = cloudBuildClient.getBuildTrigger(projectId, triggerId);
   * }
   * </code></pre>
   *
   * @param projectId Required. ID of the project that owns the trigger.
   * @param triggerId Required. ID of the `BuildTrigger` to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger getBuildTrigger(String projectId, String triggerId) {

    GetBuildTriggerRequest request =
        GetBuildTriggerRequest.newBuilder().setProjectId(projectId).setTriggerId(triggerId).build();
    return getBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   GetBuildTriggerRequest request = GetBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .build();
   *   BuildTrigger response = cloudBuildClient.getBuildTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger getBuildTrigger(GetBuildTriggerRequest request) {
    return getBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a `BuildTrigger`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   GetBuildTriggerRequest request = GetBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .build();
   *   ApiFuture&lt;BuildTrigger&gt; future = cloudBuildClient.getBuildTriggerCallable().futureCall(request);
   *   // Do something
   *   BuildTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerCallable() {
    return stub.getBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildTriggersResponse response = cloudBuildClient.listBuildTriggers(projectId);
   * }
   * </code></pre>
   *
   * @param projectId Required. ID of the project for which to list BuildTriggers.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildTriggersResponse listBuildTriggers(String projectId) {

    ListBuildTriggersRequest request =
        ListBuildTriggersRequest.newBuilder().setProjectId(projectId).build();
    return listBuildTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildTriggersRequest request = ListBuildTriggersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ListBuildTriggersResponse response = cloudBuildClient.listBuildTriggers(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBuildTriggersResponse listBuildTriggers(ListBuildTriggersRequest request) {
    return listBuildTriggersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists existing `BuildTrigger`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   ListBuildTriggersRequest request = ListBuildTriggersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ApiFuture&lt;ListBuildTriggersResponse&gt; future = cloudBuildClient.listBuildTriggersCallable().futureCall(request);
   *   // Do something
   *   ListBuildTriggersResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersCallable() {
    return stub.listBuildTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   cloudBuildClient.deleteBuildTrigger(projectId, triggerId);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   DeleteBuildTriggerRequest request = DeleteBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .build();
   *   cloudBuildClient.deleteBuildTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBuildTrigger(DeleteBuildTriggerRequest request) {
    deleteBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   DeleteBuildTriggerRequest request = DeleteBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = cloudBuildClient.deleteBuildTriggerCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerCallable() {
    return stub.deleteBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   BuildTrigger response = cloudBuildClient.updateBuildTrigger(projectId, triggerId, trigger);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   UpdateBuildTriggerRequest request = UpdateBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .setTrigger(trigger)
   *     .build();
   *   BuildTrigger response = cloudBuildClient.updateBuildTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BuildTrigger updateBuildTrigger(UpdateBuildTriggerRequest request) {
    return updateBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a `BuildTrigger` by its project ID and trigger ID.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   BuildTrigger trigger = BuildTrigger.newBuilder().build();
   *   UpdateBuildTriggerRequest request = UpdateBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .setTrigger(trigger)
   *     .build();
   *   ApiFuture&lt;BuildTrigger&gt; future = cloudBuildClient.updateBuildTriggerCallable().futureCall(request);
   *   // Do something
   *   BuildTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerCallable() {
    return stub.updateBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   RepoSource source = RepoSource.newBuilder().build();
   *   Operation response = cloudBuildClient.runBuildTrigger(projectId, triggerId, source);
   * }
   * </code></pre>
   *
   * @param projectId Required. ID of the project.
   * @param triggerId Required. ID of the trigger.
   * @param source Required. Source to build against this trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation runBuildTrigger(String projectId, String triggerId, RepoSource source) {

    RunBuildTriggerRequest request =
        RunBuildTriggerRequest.newBuilder()
            .setProjectId(projectId)
            .setTriggerId(triggerId)
            .setSource(source)
            .build();
    return runBuildTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   RepoSource source = RepoSource.newBuilder().build();
   *   RunBuildTriggerRequest request = RunBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .setSource(source)
   *     .build();
   *   Operation response = cloudBuildClient.runBuildTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation runBuildTrigger(RunBuildTriggerRequest request) {
    return runBuildTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs a `BuildTrigger` at a particular source revision.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String triggerId = "";
   *   RepoSource source = RepoSource.newBuilder().build();
   *   RunBuildTriggerRequest request = RunBuildTriggerRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTriggerId(triggerId)
   *     .setSource(source)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudBuildClient.runBuildTriggerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RunBuildTriggerRequest, Operation> runBuildTriggerCallable() {
    return stub.runBuildTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <p>&#42; Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   * will result in a build that uses the same revision.
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <p>&#42; If the original build built from the tip of a branch, the retried build will build
   * from the tip of that branch, which may not be the same revision as the original build. &#42; If
   * the original build specified a commit sha or revision ID, the retried build will use the
   * identical source.
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <p>&#42; If the original build pulled source from Google Cloud Storage without specifying the
   * generation of the object, the new build will use the current object, which may be different
   * from the original build source. &#42; If the original build pulled source from Cloud Storage
   * and specified the generation of the object, the new build will attempt to use the same object,
   * which may or may not be available depending on the bucket's lifecycle management settings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   Operation response = cloudBuildClient.retryBuild(projectId, id);
   * }
   * </code></pre>
   *
   * @param projectId Required. ID of the project.
   * @param id Required. Build ID of the original build.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation retryBuild(String projectId, String id) {

    RetryBuildRequest request =
        RetryBuildRequest.newBuilder().setProjectId(projectId).setId(id).build();
    return retryBuild(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <p>&#42; Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   * will result in a build that uses the same revision.
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <p>&#42; If the original build built from the tip of a branch, the retried build will build
   * from the tip of that branch, which may not be the same revision as the original build. &#42; If
   * the original build specified a commit sha or revision ID, the retried build will use the
   * identical source.
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <p>&#42; If the original build pulled source from Google Cloud Storage without specifying the
   * generation of the object, the new build will use the current object, which may be different
   * from the original build source. &#42; If the original build pulled source from Cloud Storage
   * and specified the generation of the object, the new build will attempt to use the same object,
   * which may or may not be available depending on the bucket's lifecycle management settings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   RetryBuildRequest request = RetryBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   Operation response = cloudBuildClient.retryBuild(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation retryBuild(RetryBuildRequest request) {
    return retryBuildCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new build based on the specified build.
   *
   * <p>This method creates a new build using the original build request, which may or may not
   * result in an identical build.
   *
   * <p>For triggered builds:
   *
   * <p>&#42; Triggered builds resolve to a precise revision; therefore a retry of a triggered build
   * will result in a build that uses the same revision.
   *
   * <p>For non-triggered builds that specify `RepoSource`:
   *
   * <p>&#42; If the original build built from the tip of a branch, the retried build will build
   * from the tip of that branch, which may not be the same revision as the original build. &#42; If
   * the original build specified a commit sha or revision ID, the retried build will use the
   * identical source.
   *
   * <p>For builds that specify `StorageSource`:
   *
   * <p>&#42; If the original build pulled source from Google Cloud Storage without specifying the
   * generation of the object, the new build will use the current object, which may be different
   * from the original build source. &#42; If the original build pulled source from Cloud Storage
   * and specified the generation of the object, the new build will attempt to use the same object,
   * which may or may not be available depending on the bucket's lifecycle management settings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   String projectId = "";
   *   String id = "";
   *   RetryBuildRequest request = RetryBuildRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setId(id)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudBuildClient.retryBuildCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RetryBuildRequest, Operation> retryBuildCallable() {
    return stub.retryBuildCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   CreateWorkerPoolRequest request = CreateWorkerPoolRequest.newBuilder().build();
   *   WorkerPool response = cloudBuildClient.createWorkerPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool createWorkerPool(CreateWorkerPoolRequest request) {
    return createWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   CreateWorkerPoolRequest request = CreateWorkerPoolRequest.newBuilder().build();
   *   ApiFuture&lt;WorkerPool&gt; future = cloudBuildClient.createWorkerPoolCallable().futureCall(request);
   *   // Do something
   *   WorkerPool response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolCallable() {
    return stub.createWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().build();
   *   WorkerPool response = cloudBuildClient.getWorkerPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool getWorkerPool(GetWorkerPoolRequest request) {
    return getWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().build();
   *   ApiFuture&lt;WorkerPool&gt; future = cloudBuildClient.getWorkerPoolCallable().futureCall(request);
   *   // Do something
   *   WorkerPool response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return stub.getWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a `WorkerPool` by its project ID and WorkerPool name.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   DeleteWorkerPoolRequest request = DeleteWorkerPoolRequest.newBuilder().build();
   *   cloudBuildClient.deleteWorkerPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWorkerPool(DeleteWorkerPoolRequest request) {
    deleteWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a `WorkerPool` by its project ID and WorkerPool name.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   DeleteWorkerPoolRequest request = DeleteWorkerPoolRequest.newBuilder().build();
   *   ApiFuture&lt;Void&gt; future = cloudBuildClient.deleteWorkerPoolCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolCallable() {
    return stub.deleteWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   UpdateWorkerPoolRequest request = UpdateWorkerPoolRequest.newBuilder().build();
   *   WorkerPool response = cloudBuildClient.updateWorkerPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool updateWorkerPool(UpdateWorkerPoolRequest request) {
    return updateWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a `WorkerPool`.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   UpdateWorkerPoolRequest request = UpdateWorkerPoolRequest.newBuilder().build();
   *   ApiFuture&lt;WorkerPool&gt; future = cloudBuildClient.updateWorkerPoolCallable().futureCall(request);
   *   // Do something
   *   WorkerPool response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolCallable() {
    return stub.updateWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List project's `WorkerPool`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   ListWorkerPoolsRequest request = ListWorkerPoolsRequest.newBuilder().build();
   *   ListWorkerPoolsResponse response = cloudBuildClient.listWorkerPools(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkerPoolsResponse listWorkerPools(ListWorkerPoolsRequest request) {
    return listWorkerPoolsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List project's `WorkerPool`s.
   *
   * <p>This API is experimental.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudBuildClient cloudBuildClient = CloudBuildClient.create()) {
   *   ListWorkerPoolsRequest request = ListWorkerPoolsRequest.newBuilder().build();
   *   ApiFuture&lt;ListWorkerPoolsResponse&gt; future = cloudBuildClient.listWorkerPoolsCallable().futureCall(request);
   *   // Do something
   *   ListWorkerPoolsResponse response = future.get();
   * }
   * </code></pre>
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
}
