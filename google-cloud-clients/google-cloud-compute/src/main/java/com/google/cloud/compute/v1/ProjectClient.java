/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.ProjectStub;
import com.google.cloud.compute.v1.stub.ProjectStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ProjectClient projectClient = ProjectClient.create()) {
 *   ProjectName project = ProjectName.of("[PROJECT]");
 *   Operation response = projectClient.disableXpnHostProject(project);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the projectClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ProjectSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ProjectSettings projectSettings =
 *     ProjectSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectClient projectClient =
 *     ProjectClient.create(projectSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ProjectSettings projectSettings =
 *     ProjectSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectClient projectClient =
 *     ProjectClient.create(projectSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ProjectClient implements BackgroundResource {
  private final ProjectSettings settings;
  private final ProjectStub stub;

  /** Constructs an instance of ProjectClient with default settings. */
  public static final ProjectClient create() throws IOException {
    return create(ProjectSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectClient create(ProjectSettings settings) throws IOException {
    return new ProjectClient(settings);
  }

  /**
   * Constructs an instance of ProjectClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ProjectSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ProjectClient create(ProjectStub stub) {
    return new ProjectClient(stub);
  }

  /**
   * Constructs an instance of ProjectClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ProjectClient(ProjectSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ProjectClient(ProjectStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProjectSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProjectStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Operation response = projectClient.disableXpnHostProject(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnHostProject(ProjectName project) {

    DisableXpnHostProjectHttpRequest request =
        DisableXpnHostProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return disableXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Operation response = projectClient.disableXpnHostProject(project.toString());
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnHostProject(String project) {

    DisableXpnHostProjectHttpRequest request =
        DisableXpnHostProjectHttpRequest.newBuilder().setProject(project).build();
    return disableXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DisableXpnHostProjectHttpRequest request = DisableXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   Operation response = projectClient.disableXpnHostProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnHostProject(DisableXpnHostProjectHttpRequest request) {
    return disableXpnHostProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DisableXpnHostProjectHttpRequest request = DisableXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.disableXpnHostProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DisableXpnHostProjectHttpRequest, Operation>
      disableXpnHostProjectCallable() {
    return stub.disableXpnHostProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a serivce resource (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectClient.disableXpnResourceProject(project, projectsDisableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsDisableXpnResourceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnResourceProject(
      ProjectName project,
      ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource) {

    DisableXpnResourceProjectHttpRequest request =
        DisableXpnResourceProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
            .build();
    return disableXpnResourceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a serivce resource (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectClient.disableXpnResourceProject(project.toString(), projectsDisableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsDisableXpnResourceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnResourceProject(
      String project, ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource) {

    DisableXpnResourceProjectHttpRequest request =
        DisableXpnResourceProjectHttpRequest.newBuilder()
            .setProject(project)
            .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
            .build();
    return disableXpnResourceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a serivce resource (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   DisableXpnResourceProjectHttpRequest request = DisableXpnResourceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
   *     .build();
   *   Operation response = projectClient.disableXpnResourceProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation disableXpnResourceProject(DisableXpnResourceProjectHttpRequest request) {
    return disableXpnResourceProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a serivce resource (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   DisableXpnResourceProjectHttpRequest request = DisableXpnResourceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.disableXpnResourceProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DisableXpnResourceProjectHttpRequest, Operation>
      disableXpnResourceProjectCallable() {
    return stub.disableXpnResourceProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Operation response = projectClient.enableXpnHostProject(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnHostProject(ProjectName project) {

    EnableXpnHostProjectHttpRequest request =
        EnableXpnHostProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return enableXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Operation response = projectClient.enableXpnHostProject(project.toString());
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnHostProject(String project) {

    EnableXpnHostProjectHttpRequest request =
        EnableXpnHostProjectHttpRequest.newBuilder().setProject(project).build();
    return enableXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   EnableXpnHostProjectHttpRequest request = EnableXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   Operation response = projectClient.enableXpnHostProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnHostProject(EnableXpnHostProjectHttpRequest request) {
    return enableXpnHostProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   EnableXpnHostProjectHttpRequest request = EnableXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.enableXpnHostProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<EnableXpnHostProjectHttpRequest, Operation>
      enableXpnHostProjectCallable() {
    return stub.enableXpnHostProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectClient.enableXpnResourceProject(project, projectsEnableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsEnableXpnResourceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnResourceProject(
      ProjectName project,
      ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource) {

    EnableXpnResourceProjectHttpRequest request =
        EnableXpnResourceProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
            .build();
    return enableXpnResourceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectClient.enableXpnResourceProject(project.toString(), projectsEnableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsEnableXpnResourceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnResourceProject(
      String project, ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource) {

    EnableXpnResourceProjectHttpRequest request =
        EnableXpnResourceProjectHttpRequest.newBuilder()
            .setProject(project)
            .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
            .build();
    return enableXpnResourceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   EnableXpnResourceProjectHttpRequest request = EnableXpnResourceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
   *     .build();
   *   Operation response = projectClient.enableXpnResourceProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation enableXpnResourceProject(EnableXpnResourceProjectHttpRequest request) {
    return enableXpnResourceProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   EnableXpnResourceProjectHttpRequest request = EnableXpnResourceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.enableXpnResourceProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<EnableXpnResourceProjectHttpRequest, Operation>
      enableXpnResourceProjectCallable() {
    return stub.enableXpnResourceProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Project response = projectClient.getProject(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Project getProject(ProjectName project) {

    GetProjectHttpRequest request =
        GetProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Project response = projectClient.getProject(project.toString());
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Project getProject(String project) {

    GetProjectHttpRequest request = GetProjectHttpRequest.newBuilder().setProject(project).build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetProjectHttpRequest request = GetProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   Project response = projectClient.getProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  private final Project getProject(GetProjectHttpRequest request) {
    return getProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetProjectHttpRequest request = GetProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;Project&gt; future = projectClient.getProjectCallable().futureCall(request);
   *   // Do something
   *   Project response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetProjectHttpRequest, Project> getProjectCallable() {
    return stub.getProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Project response = projectClient.getXpnHostProject(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Project getXpnHostProject(ProjectName project) {

    GetXpnHostProjectHttpRequest request =
        GetXpnHostProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return getXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Project response = projectClient.getXpnHostProject(project.toString());
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Project getXpnHostProject(String project) {

    GetXpnHostProjectHttpRequest request =
        GetXpnHostProjectHttpRequest.newBuilder().setProject(project).build();
    return getXpnHostProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetXpnHostProjectHttpRequest request = GetXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   Project response = projectClient.getXpnHostProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  private final Project getXpnHostProject(GetXpnHostProjectHttpRequest request) {
    return getXpnHostProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetXpnHostProjectHttpRequest request = GetXpnHostProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;Project&gt; future = projectClient.getXpnHostProjectCallable().futureCall(request);
   *   // Do something
   *   Project response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetXpnHostProjectHttpRequest, Project> getXpnHostProjectCallable() {
    return stub.getXpnHostProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (XpnResourceId element : projectClient.getXpnResourcesProjects(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final GetXpnResourcesProjectsPagedResponse getXpnResourcesProjects(ProjectName project) {
    GetXpnResourcesProjectsHttpRequest request =
        GetXpnResourcesProjectsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return getXpnResourcesProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (XpnResourceId element : projectClient.getXpnResourcesProjects(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final GetXpnResourcesProjectsPagedResponse getXpnResourcesProjects(String project) {
    GetXpnResourcesProjectsHttpRequest request =
        GetXpnResourcesProjectsHttpRequest.newBuilder().setProject(project).build();
    return getXpnResourcesProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetXpnResourcesProjectsHttpRequest request = GetXpnResourcesProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (XpnResourceId element : projectClient.getXpnResourcesProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final GetXpnResourcesProjectsPagedResponse getXpnResourcesProjects(
      GetXpnResourcesProjectsHttpRequest request) {
    return getXpnResourcesProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetXpnResourcesProjectsHttpRequest request = GetXpnResourcesProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;GetXpnResourcesProjectsPagedResponse&gt; future = projectClient.getXpnResourcesProjectsPagedCallable().futureCall(request);
   *   // Do something
   *   for (XpnResourceId element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          GetXpnResourcesProjectsHttpRequest, GetXpnResourcesProjectsPagedResponse>
      getXpnResourcesProjectsPagedCallable() {
    return stub.getXpnResourcesProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   GetXpnResourcesProjectsHttpRequest request = GetXpnResourcesProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     ProjectsGetXpnResources response = projectClient.getXpnResourcesProjectsCallable().call(request);
   *     for (XpnResourceId element : response.getResourcesList()) {
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
  @BetaApi
  public final UnaryCallable<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>
      getXpnResourcesProjectsCallable() {
    return stub.getXpnResourcesProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   for (Project element : projectClient.listXpnHostsProjects(project, projectsListXpnHostsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsListXpnHostsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListXpnHostsProjectsPagedResponse listXpnHostsProjects(
      ProjectName project, ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource) {
    ListXpnHostsProjectsHttpRequest request =
        ListXpnHostsProjectsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
            .build();
    return listXpnHostsProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   for (Project element : projectClient.listXpnHostsProjects(project.toString(), projectsListXpnHostsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsListXpnHostsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListXpnHostsProjectsPagedResponse listXpnHostsProjects(
      String project, ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource) {
    ListXpnHostsProjectsHttpRequest request =
        ListXpnHostsProjectsHttpRequest.newBuilder()
            .setProject(project)
            .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
            .build();
    return listXpnHostsProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsHttpRequest request = ListXpnHostsProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   for (Project element : projectClient.listXpnHostsProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListXpnHostsProjectsPagedResponse listXpnHostsProjects(
      ListXpnHostsProjectsHttpRequest request) {
    return listXpnHostsProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsHttpRequest request = ListXpnHostsProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   ApiFuture&lt;ListXpnHostsProjectsPagedResponse&gt; future = projectClient.listXpnHostsProjectsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Project element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListXpnHostsProjectsHttpRequest, ListXpnHostsProjectsPagedResponse>
      listXpnHostsProjectsPagedCallable() {
    return stub.listXpnHostsProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsHttpRequest request = ListXpnHostsProjectsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   while (true) {
   *     XpnHostList response = projectClient.listXpnHostsProjectsCallable().call(request);
   *     for (Project element : response.getItemsList()) {
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
  @BetaApi
  public final UnaryCallable<ListXpnHostsProjectsHttpRequest, XpnHostList>
      listXpnHostsProjectsCallable() {
    return stub.listXpnHostsProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   Operation response = projectClient.moveDiskProject(project, diskMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param diskMoveRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveDiskProject(
      ProjectName project, DiskMoveRequest diskMoveRequestResource) {

    MoveDiskProjectHttpRequest request =
        MoveDiskProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setDiskMoveRequestResource(diskMoveRequestResource)
            .build();
    return moveDiskProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   Operation response = projectClient.moveDiskProject(project.toString(), diskMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param diskMoveRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveDiskProject(String project, DiskMoveRequest diskMoveRequestResource) {

    MoveDiskProjectHttpRequest request =
        MoveDiskProjectHttpRequest.newBuilder()
            .setProject(project)
            .setDiskMoveRequestResource(diskMoveRequestResource)
            .build();
    return moveDiskProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   MoveDiskProjectHttpRequest request = MoveDiskProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setDiskMoveRequestResource(diskMoveRequestResource)
   *     .build();
   *   Operation response = projectClient.moveDiskProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveDiskProject(MoveDiskProjectHttpRequest request) {
    return moveDiskProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   MoveDiskProjectHttpRequest request = MoveDiskProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setDiskMoveRequestResource(diskMoveRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.moveDiskProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<MoveDiskProjectHttpRequest, Operation> moveDiskProjectCallable() {
    return stub.moveDiskProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   Operation response = projectClient.moveInstanceProject(project, instanceMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceMoveRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveInstanceProject(
      ProjectName project, InstanceMoveRequest instanceMoveRequestResource) {

    MoveInstanceProjectHttpRequest request =
        MoveInstanceProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setInstanceMoveRequestResource(instanceMoveRequestResource)
            .build();
    return moveInstanceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   Operation response = projectClient.moveInstanceProject(project.toString(), instanceMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceMoveRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveInstanceProject(
      String project, InstanceMoveRequest instanceMoveRequestResource) {

    MoveInstanceProjectHttpRequest request =
        MoveInstanceProjectHttpRequest.newBuilder()
            .setProject(project)
            .setInstanceMoveRequestResource(instanceMoveRequestResource)
            .build();
    return moveInstanceProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   MoveInstanceProjectHttpRequest request = MoveInstanceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setInstanceMoveRequestResource(instanceMoveRequestResource)
   *     .build();
   *   Operation response = projectClient.moveInstanceProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation moveInstanceProject(MoveInstanceProjectHttpRequest request) {
    return moveInstanceProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   MoveInstanceProjectHttpRequest request = MoveInstanceProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setInstanceMoveRequestResource(instanceMoveRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.moveInstanceProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<MoveInstanceProjectHttpRequest, Operation>
      moveInstanceProjectCallable() {
    return stub.moveInstanceProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = projectClient.setCommonInstanceMetadataProject(project, metadataResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param metadataResource A metadata key/value entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setCommonInstanceMetadataProject(
      ProjectName project, Metadata metadataResource) {

    SetCommonInstanceMetadataProjectHttpRequest request =
        SetCommonInstanceMetadataProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setMetadataResource(metadataResource)
            .build();
    return setCommonInstanceMetadataProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = projectClient.setCommonInstanceMetadataProject(project.toString(), metadataResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param metadataResource A metadata key/value entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setCommonInstanceMetadataProject(
      String project, Metadata metadataResource) {

    SetCommonInstanceMetadataProjectHttpRequest request =
        SetCommonInstanceMetadataProjectHttpRequest.newBuilder()
            .setProject(project)
            .setMetadataResource(metadataResource)
            .build();
    return setCommonInstanceMetadataProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   SetCommonInstanceMetadataProjectHttpRequest request = SetCommonInstanceMetadataProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setMetadataResource(metadataResource)
   *     .build();
   *   Operation response = projectClient.setCommonInstanceMetadataProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setCommonInstanceMetadataProject(
      SetCommonInstanceMetadataProjectHttpRequest request) {
    return setCommonInstanceMetadataProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   SetCommonInstanceMetadataProjectHttpRequest request = SetCommonInstanceMetadataProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setMetadataResource(metadataResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.setCommonInstanceMetadataProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetCommonInstanceMetadataProjectHttpRequest, Operation>
      setCommonInstanceMetadataProjectCallable() {
    return stub.setCommonInstanceMetadataProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   Operation response = projectClient.setDefaultNetworkTierProject(project, projectsSetDefaultNetworkTierRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsSetDefaultNetworkTierRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDefaultNetworkTierProject(
      ProjectName project,
      ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource) {

    SetDefaultNetworkTierProjectHttpRequest request =
        SetDefaultNetworkTierProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setProjectsSetDefaultNetworkTierRequestResource(
                projectsSetDefaultNetworkTierRequestResource)
            .build();
    return setDefaultNetworkTierProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   Operation response = projectClient.setDefaultNetworkTierProject(project.toString(), projectsSetDefaultNetworkTierRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsSetDefaultNetworkTierRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDefaultNetworkTierProject(
      String project,
      ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource) {

    SetDefaultNetworkTierProjectHttpRequest request =
        SetDefaultNetworkTierProjectHttpRequest.newBuilder()
            .setProject(project)
            .setProjectsSetDefaultNetworkTierRequestResource(
                projectsSetDefaultNetworkTierRequestResource)
            .build();
    return setDefaultNetworkTierProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   SetDefaultNetworkTierProjectHttpRequest request = SetDefaultNetworkTierProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsSetDefaultNetworkTierRequestResource(projectsSetDefaultNetworkTierRequestResource)
   *     .build();
   *   Operation response = projectClient.setDefaultNetworkTierProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDefaultNetworkTierProject(
      SetDefaultNetworkTierProjectHttpRequest request) {
    return setDefaultNetworkTierProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   SetDefaultNetworkTierProjectHttpRequest request = SetDefaultNetworkTierProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setProjectsSetDefaultNetworkTierRequestResource(projectsSetDefaultNetworkTierRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.setDefaultNetworkTierProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetDefaultNetworkTierProjectHttpRequest, Operation>
      setDefaultNetworkTierProjectCallable() {
    return stub.setDefaultNetworkTierProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   Operation response = projectClient.setUsageExportBucketProject(project, usageExportLocationResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param usageExportLocationResource The location in Cloud Storage and naming method of the daily
   *     usage report. Contains bucket_name and report_name prefix.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUsageExportBucketProject(
      ProjectName project, UsageExportLocation usageExportLocationResource) {

    SetUsageExportBucketProjectHttpRequest request =
        SetUsageExportBucketProjectHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setUsageExportLocationResource(usageExportLocationResource)
            .build();
    return setUsageExportBucketProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   Operation response = projectClient.setUsageExportBucketProject(project.toString(), usageExportLocationResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param usageExportLocationResource The location in Cloud Storage and naming method of the daily
   *     usage report. Contains bucket_name and report_name prefix.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUsageExportBucketProject(
      String project, UsageExportLocation usageExportLocationResource) {

    SetUsageExportBucketProjectHttpRequest request =
        SetUsageExportBucketProjectHttpRequest.newBuilder()
            .setProject(project)
            .setUsageExportLocationResource(usageExportLocationResource)
            .build();
    return setUsageExportBucketProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   SetUsageExportBucketProjectHttpRequest request = SetUsageExportBucketProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setUsageExportLocationResource(usageExportLocationResource)
   *     .build();
   *   Operation response = projectClient.setUsageExportBucketProject(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUsageExportBucketProject(
      SetUsageExportBucketProjectHttpRequest request) {
    return setUsageExportBucketProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectClient projectClient = ProjectClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   SetUsageExportBucketProjectHttpRequest request = SetUsageExportBucketProjectHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setUsageExportLocationResource(usageExportLocationResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectClient.setUsageExportBucketProjectCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetUsageExportBucketProjectHttpRequest, Operation>
      setUsageExportBucketProjectCallable() {
    return stub.setUsageExportBucketProjectCallable();
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

  public static class GetXpnResourcesProjectsPagedResponse
      extends AbstractPagedListResponse<
          GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId,
          GetXpnResourcesProjectsPage, GetXpnResourcesProjectsFixedSizeCollection> {

    public static ApiFuture<GetXpnResourcesProjectsPagedResponse> createAsync(
        PageContext<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId>
            context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      ApiFuture<GetXpnResourcesProjectsPage> futurePage =
          GetXpnResourcesProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<GetXpnResourcesProjectsPage, GetXpnResourcesProjectsPagedResponse>() {
            @Override
            public GetXpnResourcesProjectsPagedResponse apply(GetXpnResourcesProjectsPage input) {
              return new GetXpnResourcesProjectsPagedResponse(input);
            }
          });
    }

    private GetXpnResourcesProjectsPagedResponse(GetXpnResourcesProjectsPage page) {
      super(page, GetXpnResourcesProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetXpnResourcesProjectsPage
      extends AbstractPage<
          GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId,
          GetXpnResourcesProjectsPage> {

    private GetXpnResourcesProjectsPage(
        PageContext<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId>
            context,
        ProjectsGetXpnResources response) {
      super(context, response);
    }

    private static GetXpnResourcesProjectsPage createEmptyPage() {
      return new GetXpnResourcesProjectsPage(null, null);
    }

    @Override
    protected GetXpnResourcesProjectsPage createPage(
        PageContext<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId>
            context,
        ProjectsGetXpnResources response) {
      return new GetXpnResourcesProjectsPage(context, response);
    }

    @Override
    public ApiFuture<GetXpnResourcesProjectsPage> createPageAsync(
        PageContext<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId>
            context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetXpnResourcesProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources, XpnResourceId,
          GetXpnResourcesProjectsPage, GetXpnResourcesProjectsFixedSizeCollection> {

    private GetXpnResourcesProjectsFixedSizeCollection(
        List<GetXpnResourcesProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetXpnResourcesProjectsFixedSizeCollection createEmptyCollection() {
      return new GetXpnResourcesProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected GetXpnResourcesProjectsFixedSizeCollection createCollection(
        List<GetXpnResourcesProjectsPage> pages, int collectionSize) {
      return new GetXpnResourcesProjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListXpnHostsProjectsPagedResponse
      extends AbstractPagedListResponse<
          ListXpnHostsProjectsHttpRequest, XpnHostList, Project, ListXpnHostsProjectsPage,
          ListXpnHostsProjectsFixedSizeCollection> {

    public static ApiFuture<ListXpnHostsProjectsPagedResponse> createAsync(
        PageContext<ListXpnHostsProjectsHttpRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      ApiFuture<ListXpnHostsProjectsPage> futurePage =
          ListXpnHostsProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListXpnHostsProjectsPage, ListXpnHostsProjectsPagedResponse>() {
            @Override
            public ListXpnHostsProjectsPagedResponse apply(ListXpnHostsProjectsPage input) {
              return new ListXpnHostsProjectsPagedResponse(input);
            }
          });
    }

    private ListXpnHostsProjectsPagedResponse(ListXpnHostsProjectsPage page) {
      super(page, ListXpnHostsProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListXpnHostsProjectsPage
      extends AbstractPage<
          ListXpnHostsProjectsHttpRequest, XpnHostList, Project, ListXpnHostsProjectsPage> {

    private ListXpnHostsProjectsPage(
        PageContext<ListXpnHostsProjectsHttpRequest, XpnHostList, Project> context,
        XpnHostList response) {
      super(context, response);
    }

    private static ListXpnHostsProjectsPage createEmptyPage() {
      return new ListXpnHostsProjectsPage(null, null);
    }

    @Override
    protected ListXpnHostsProjectsPage createPage(
        PageContext<ListXpnHostsProjectsHttpRequest, XpnHostList, Project> context,
        XpnHostList response) {
      return new ListXpnHostsProjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListXpnHostsProjectsPage> createPageAsync(
        PageContext<ListXpnHostsProjectsHttpRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListXpnHostsProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListXpnHostsProjectsHttpRequest, XpnHostList, Project, ListXpnHostsProjectsPage,
          ListXpnHostsProjectsFixedSizeCollection> {

    private ListXpnHostsProjectsFixedSizeCollection(
        List<ListXpnHostsProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListXpnHostsProjectsFixedSizeCollection createEmptyCollection() {
      return new ListXpnHostsProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListXpnHostsProjectsFixedSizeCollection createCollection(
        List<ListXpnHostsProjectsPage> pages, int collectionSize) {
      return new ListXpnHostsProjectsFixedSizeCollection(pages, collectionSize);
    }
  }
}
