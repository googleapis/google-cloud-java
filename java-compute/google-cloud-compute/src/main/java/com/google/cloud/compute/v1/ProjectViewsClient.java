/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ProjectViewsStub;
import com.google.cloud.compute.v1.stub.ProjectViewsStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ProjectViews API.
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
 * try (ProjectViewsClient projectViewsClient = ProjectViewsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   ProjectView response = projectViewsClient.get(project, region);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProjectViewsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified global ProjectViews resource, with a regional context. This regional API endpoint reads resource metadata from regional read-only replicas. Because changes are copied to these regional replicas asynchronously, for real-time resource reads or any write operations (creating, updating, or deleting resources), use the global [projects.get](https://cloud.google.com/compute/docs/reference/rest/v1/projects/get) endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetProjectViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ProjectViewsSettings to
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
 * ProjectViewsSettings projectViewsSettings =
 *     ProjectViewsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectViewsClient projectViewsClient = ProjectViewsClient.create(projectViewsSettings);
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
 * ProjectViewsSettings projectViewsSettings =
 *     ProjectViewsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectViewsClient projectViewsClient = ProjectViewsClient.create(projectViewsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ProjectViewsClient implements BackgroundResource {
  private final @Nullable ProjectViewsSettings settings;
  private final ProjectViewsStub stub;

  /** Constructs an instance of ProjectViewsClient with default settings. */
  public static final ProjectViewsClient create() throws IOException {
    return create(ProjectViewsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectViewsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectViewsClient create(ProjectViewsSettings settings) throws IOException {
    return new ProjectViewsClient(settings);
  }

  /**
   * Constructs an instance of ProjectViewsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProjectViewsSettings).
   */
  public static final ProjectViewsClient create(ProjectViewsStub stub) {
    return new ProjectViewsClient(stub);
  }

  /**
   * Constructs an instance of ProjectViewsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProjectViewsClient(ProjectViewsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectViewsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProjectViewsClient(ProjectViewsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ProjectViewsSettings getSettings() {
    return settings;
  }

  public ProjectViewsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ProjectViews resource, with a regional context. This regional API
   * endpoint reads resource metadata from regional read-only replicas. Because changes are copied
   * to these regional replicas asynchronously, for real-time resource reads or any write operations
   * (creating, updating, or deleting resources), use the global
   * [projects.get](https://cloud.google.com/compute/docs/reference/rest/v1/projects/get) endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectViewsClient projectViewsClient = ProjectViewsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   ProjectView response = projectViewsClient.get(project, region);
   * }
   * }</pre>
   *
   * @param project Required. Project ID for this request. This is part of the URL path.
   * @param region Required. Name of the region for this request. This is part of the URL path.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectView get(String project, String region) {
    GetProjectViewRequest request =
        GetProjectViewRequest.newBuilder().setProject(project).setRegion(region).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ProjectViews resource, with a regional context. This regional API
   * endpoint reads resource metadata from regional read-only replicas. Because changes are copied
   * to these regional replicas asynchronously, for real-time resource reads or any write operations
   * (creating, updating, or deleting resources), use the global
   * [projects.get](https://cloud.google.com/compute/docs/reference/rest/v1/projects/get) endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectViewsClient projectViewsClient = ProjectViewsClient.create()) {
   *   GetProjectViewRequest request =
   *       GetProjectViewRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ProjectView response = projectViewsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectView get(GetProjectViewRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global ProjectViews resource, with a regional context. This regional API
   * endpoint reads resource metadata from regional read-only replicas. Because changes are copied
   * to these regional replicas asynchronously, for real-time resource reads or any write operations
   * (creating, updating, or deleting resources), use the global
   * [projects.get](https://cloud.google.com/compute/docs/reference/rest/v1/projects/get) endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectViewsClient projectViewsClient = ProjectViewsClient.create()) {
   *   GetProjectViewRequest request =
   *       GetProjectViewRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<ProjectView> future = projectViewsClient.getCallable().futureCall(request);
   *   // Do something.
   *   ProjectView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectViewRequest, ProjectView> getCallable() {
    return stub.getCallable();
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
