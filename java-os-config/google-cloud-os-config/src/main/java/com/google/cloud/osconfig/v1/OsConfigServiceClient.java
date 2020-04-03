/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.osconfig.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStub;
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: OS Config API
 *
 * <p>The OS Config service is a server-side component that you can use to manage package
 * installations and patch jobs for virtual machine instances.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
 *   ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder().build();
 *   PatchJob response = osConfigServiceClient.executePatchJob(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the osConfigServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of OsConfigServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class OsConfigServiceClient implements BackgroundResource {
  private final OsConfigServiceSettings settings;
  private final OsConfigServiceStub stub;

  /** Constructs an instance of OsConfigServiceClient with default settings. */
  public static final OsConfigServiceClient create() throws IOException {
    return create(OsConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OsConfigServiceClient create(OsConfigServiceSettings settings)
      throws IOException {
    return new OsConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use OsConfigServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final OsConfigServiceClient create(OsConfigServiceStub stub) {
    return new OsConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OsConfigServiceClient(OsConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OsConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected OsConfigServiceClient(OsConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OsConfigServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder().build();
   *   PatchJob response = osConfigServiceClient.executePatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob executePatchJob(ExecutePatchJobRequest request) {
    return executePatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder().build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.executePatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExecutePatchJobRequest, PatchJob> executePatchJobCallable() {
    return stub.executePatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   GetPatchJobRequest request = GetPatchJobRequest.newBuilder().build();
   *   PatchJob response = osConfigServiceClient.getPatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob getPatchJob(GetPatchJobRequest request) {
    return getPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   GetPatchJobRequest request = GetPatchJobRequest.newBuilder().build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.getPatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPatchJobRequest, PatchJob> getPatchJobCallable() {
    return stub.getPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder().build();
   *   PatchJob response = osConfigServiceClient.cancelPatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob cancelPatchJob(CancelPatchJobRequest request) {
    return cancelPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder().build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.cancelPatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelPatchJobRequest, PatchJob> cancelPatchJobCallable() {
    return stub.cancelPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder().build();
   *   ListPatchJobsResponse response = osConfigServiceClient.listPatchJobs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsResponse listPatchJobs(ListPatchJobsRequest request) {
    return listPatchJobsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder().build();
   *   ApiFuture&lt;ListPatchJobsResponse&gt; future = osConfigServiceClient.listPatchJobsCallable().futureCall(request);
   *   // Do something
   *   ListPatchJobsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsCallable() {
    return stub.listPatchJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchJobInstanceDetailsRequest request = ListPatchJobInstanceDetailsRequest.newBuilder().build();
   *   ListPatchJobInstanceDetailsResponse response = osConfigServiceClient.listPatchJobInstanceDetails(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsResponse listPatchJobInstanceDetails(
      ListPatchJobInstanceDetailsRequest request) {
    return listPatchJobInstanceDetailsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchJobInstanceDetailsRequest request = ListPatchJobInstanceDetailsRequest.newBuilder().build();
   *   ApiFuture&lt;ListPatchJobInstanceDetailsResponse&gt; future = osConfigServiceClient.listPatchJobInstanceDetailsCallable().futureCall(request);
   *   // Do something
   *   ListPatchJobInstanceDetailsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    return stub.listPatchJobInstanceDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder().build();
   *   PatchDeployment response = osConfigServiceClient.createPatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment createPatchDeployment(CreatePatchDeploymentRequest request) {
    return createPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder().build();
   *   ApiFuture&lt;PatchDeployment&gt; future = osConfigServiceClient.createPatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   PatchDeployment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentCallable() {
    return stub.createPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder().build();
   *   PatchDeployment response = osConfigServiceClient.getPatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment getPatchDeployment(GetPatchDeploymentRequest request) {
    return getPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder().build();
   *   ApiFuture&lt;PatchDeployment&gt; future = osConfigServiceClient.getPatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   PatchDeployment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentCallable() {
    return stub.getPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder().build();
   *   ListPatchDeploymentsResponse response = osConfigServiceClient.listPatchDeployments(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsResponse listPatchDeployments(
      ListPatchDeploymentsRequest request) {
    return listPatchDeploymentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder().build();
   *   ApiFuture&lt;ListPatchDeploymentsResponse&gt; future = osConfigServiceClient.listPatchDeploymentsCallable().futureCall(request);
   *   // Do something
   *   ListPatchDeploymentsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    return stub.listPatchDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder().build();
   *   osConfigServiceClient.deletePatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(DeletePatchDeploymentRequest request) {
    deletePatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder().build();
   *   ApiFuture&lt;Void&gt; future = osConfigServiceClient.deletePatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentCallable() {
    return stub.deletePatchDeploymentCallable();
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
}
