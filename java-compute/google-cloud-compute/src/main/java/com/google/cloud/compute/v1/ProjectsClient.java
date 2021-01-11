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
import com.google.cloud.compute.v1.stub.ProjectsStub;
import com.google.cloud.compute.v1.stub.ProjectsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Projects API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   String project = "";
 *   Operation response = projectsClient.disableXpnHost(project);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the projectsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ProjectsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectsClient projectsClient =
 *     ProjectsClient.create(projectsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectsClient projectsClient =
 *     ProjectsClient.create(projectsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ProjectsClient implements BackgroundResource {
  private final ProjectsSettings settings;
  private final ProjectsStub stub;

  /** Constructs an instance of ProjectsClient with default settings. */
  public static final ProjectsClient create() throws IOException {
    return create(ProjectsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectsClient create(ProjectsSettings settings) throws IOException {
    return new ProjectsClient(settings);
  }

  /**
   * Constructs an instance of ProjectsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ProjectsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ProjectsClient create(ProjectsStub stub) {
    return new ProjectsClient(stub);
  }

  /**
   * Constructs an instance of ProjectsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ProjectsClient(ProjectsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ProjectsClient(ProjectsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProjectsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProjectsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   Operation response = projectsClient.disableXpnHost(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation disableXpnHost(String project) {
    DisableXpnHostProjectRequest request =
        DisableXpnHostProjectRequest.newBuilder().setProject(project).build();
    return disableXpnHost(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   DisableXpnHostProjectRequest request = DisableXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Operation response = projectsClient.disableXpnHost(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation disableXpnHost(DisableXpnHostProjectRequest request) {
    return disableXpnHostCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   DisableXpnHostProjectRequest request = DisableXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.disableXpnHostCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DisableXpnHostProjectRequest, Operation> disableXpnHostCallable() {
    return stub.disableXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectsClient.disableXpnResource(project, projectsDisableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsDisableXpnResourceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation disableXpnResource(
      String project, ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource) {
    DisableXpnResourceProjectRequest request =
        DisableXpnResourceProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
            .build();
    return disableXpnResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   DisableXpnResourceProjectRequest request = DisableXpnResourceProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
   *     .build();
   *   Operation response = projectsClient.disableXpnResource(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation disableXpnResource(DisableXpnResourceProjectRequest request) {
    return disableXpnResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource = ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   DisableXpnResourceProjectRequest request = DisableXpnResourceProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.disableXpnResourceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceCallable() {
    return stub.disableXpnResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   Operation response = projectsClient.enableXpnHost(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation enableXpnHost(String project) {
    EnableXpnHostProjectRequest request =
        EnableXpnHostProjectRequest.newBuilder().setProject(project).build();
    return enableXpnHost(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   EnableXpnHostProjectRequest request = EnableXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Operation response = projectsClient.enableXpnHost(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation enableXpnHost(EnableXpnHostProjectRequest request) {
    return enableXpnHostCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   EnableXpnHostProjectRequest request = EnableXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.enableXpnHostCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<EnableXpnHostProjectRequest, Operation> enableXpnHostCallable() {
    return stub.enableXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   Operation response = projectsClient.enableXpnResource(project, projectsEnableXpnResourceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsEnableXpnResourceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation enableXpnResource(
      String project, ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource) {
    EnableXpnResourceProjectRequest request =
        EnableXpnResourceProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
            .build();
    return enableXpnResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   EnableXpnResourceProjectRequest request = EnableXpnResourceProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
   *     .build();
   *   Operation response = projectsClient.enableXpnResource(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation enableXpnResource(EnableXpnResourceProjectRequest request) {
    return enableXpnResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource = ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   EnableXpnResourceProjectRequest request = EnableXpnResourceProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.enableXpnResourceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<EnableXpnResourceProjectRequest, Operation>
      enableXpnResourceCallable() {
    return stub.enableXpnResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   Project response = projectsClient.get(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project get(String project) {
    GetProjectRequest request = GetProjectRequest.newBuilder().setProject(project).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetProjectRequest request = GetProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Project response = projectsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project get(GetProjectRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Project resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetProjectRequest request = GetProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Project&gt; future = projectsClient.getCallable().futureCall(request);
   *   // Do something
   *   Project response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetProjectRequest, Project> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   Project response = projectsClient.getXpnHost(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getXpnHost(String project) {
    GetXpnHostProjectRequest request =
        GetXpnHostProjectRequest.newBuilder().setProject(project).build();
    return getXpnHost(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetXpnHostProjectRequest request = GetXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Project response = projectsClient.getXpnHost(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getXpnHost(GetXpnHostProjectRequest request) {
    return getXpnHostCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetXpnHostProjectRequest request = GetXpnHostProjectRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Project&gt; future = projectsClient.getXpnHostCallable().futureCall(request);
   *   // Do something
   *   Project response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetXpnHostProjectRequest, Project> getXpnHostCallable() {
    return stub.getXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   for (XpnResourceId element : projectsClient.getXpnResources(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetXpnResourcesPagedResponse getXpnResources(String project) {
    GetXpnResourcesProjectsRequest request =
        GetXpnResourcesProjectsRequest.newBuilder().setProject(project).build();
    return getXpnResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetXpnResourcesProjectsRequest request = GetXpnResourcesProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (XpnResourceId element : projectsClient.getXpnResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetXpnResourcesPagedResponse getXpnResources(
      GetXpnResourcesProjectsRequest request) {
    return getXpnResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetXpnResourcesProjectsRequest request = GetXpnResourcesProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;GetXpnResourcesPagedResponse&gt; future = projectsClient.getXpnResourcesPagedCallable().futureCall(request);
   *   // Do something
   *   for (XpnResourceId element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetXpnResourcesProjectsRequest, GetXpnResourcesPagedResponse>
      getXpnResourcesPagedCallable() {
    return stub.getXpnResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   GetXpnResourcesProjectsRequest request = GetXpnResourcesProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     ProjectsGetXpnResources response = projectsClient.getXpnResourcesCallable().call(request);
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
  public final UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesCallable() {
    return stub.getXpnResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   for (Project element : projectsClient.listXpnHosts(project, projectsListXpnHostsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsListXpnHostsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListXpnHostsPagedResponse listXpnHosts(
      String project, ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource) {
    ListXpnHostsProjectsRequest request =
        ListXpnHostsProjectsRequest.newBuilder()
            .setProject(project)
            .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
            .build();
    return listXpnHosts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsRequest request = ListXpnHostsProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   for (Project element : projectsClient.listXpnHosts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListXpnHostsPagedResponse listXpnHosts(ListXpnHostsProjectsRequest request) {
    return listXpnHostsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsRequest request = ListXpnHostsProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   ApiFuture&lt;ListXpnHostsPagedResponse&gt; future = projectsClient.listXpnHostsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Project element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListXpnHostsProjectsRequest, ListXpnHostsPagedResponse>
      listXpnHostsPagedCallable() {
    return stub.listXpnHostsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource = ProjectsListXpnHostsRequest.newBuilder().build();
   *   ListXpnHostsProjectsRequest request = ListXpnHostsProjectsRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
   *     .build();
   *   while (true) {
   *     XpnHostList response = projectsClient.listXpnHostsCallable().call(request);
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
  public final UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsCallable() {
    return stub.listXpnHostsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   Operation response = projectsClient.moveDisk(project, diskMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param diskMoveRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveDisk(String project, DiskMoveRequest diskMoveRequestResource) {
    MoveDiskProjectRequest request =
        MoveDiskProjectRequest.newBuilder()
            .setProject(project)
            .setDiskMoveRequestResource(diskMoveRequestResource)
            .build();
    return moveDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   String project = "";
   *   MoveDiskProjectRequest request = MoveDiskProjectRequest.newBuilder()
   *     .setDiskMoveRequestResource(diskMoveRequestResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = projectsClient.moveDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveDisk(MoveDiskProjectRequest request) {
    return moveDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   String project = "";
   *   MoveDiskProjectRequest request = MoveDiskProjectRequest.newBuilder()
   *     .setDiskMoveRequestResource(diskMoveRequestResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.moveDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<MoveDiskProjectRequest, Operation> moveDiskCallable() {
    return stub.moveDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   Operation response = projectsClient.moveInstance(project, instanceMoveRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param instanceMoveRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveInstance(
      String project, InstanceMoveRequest instanceMoveRequestResource) {
    MoveInstanceProjectRequest request =
        MoveInstanceProjectRequest.newBuilder()
            .setProject(project)
            .setInstanceMoveRequestResource(instanceMoveRequestResource)
            .build();
    return moveInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   String project = "";
   *   MoveInstanceProjectRequest request = MoveInstanceProjectRequest.newBuilder()
   *     .setInstanceMoveRequestResource(instanceMoveRequestResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = projectsClient.moveInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveInstance(MoveInstanceProjectRequest request) {
    return moveInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves an instance and its attached persistent disks from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   String project = "";
   *   MoveInstanceProjectRequest request = MoveInstanceProjectRequest.newBuilder()
   *     .setInstanceMoveRequestResource(instanceMoveRequestResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.moveInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<MoveInstanceProjectRequest, Operation> moveInstanceCallable() {
    return stub.moveInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = projectsClient.setCommonInstanceMetadata(project, metadataResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param metadataResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setCommonInstanceMetadata(String project, Metadata metadataResource) {
    SetCommonInstanceMetadataProjectRequest request =
        SetCommonInstanceMetadataProjectRequest.newBuilder()
            .setProject(project)
            .setMetadataResource(metadataResource)
            .build();
    return setCommonInstanceMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   String project = "";
   *   SetCommonInstanceMetadataProjectRequest request = SetCommonInstanceMetadataProjectRequest.newBuilder()
   *     .setMetadataResource(metadataResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = projectsClient.setCommonInstanceMetadata(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setCommonInstanceMetadata(
      SetCommonInstanceMetadataProjectRequest request) {
    return setCommonInstanceMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   String project = "";
   *   SetCommonInstanceMetadataProjectRequest request = SetCommonInstanceMetadataProjectRequest.newBuilder()
   *     .setMetadataResource(metadataResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.setCommonInstanceMetadataCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataCallable() {
    return stub.setCommonInstanceMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   Operation response = projectsClient.setDefaultNetworkTier(project, projectsSetDefaultNetworkTierRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param projectsSetDefaultNetworkTierRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDefaultNetworkTier(
      String project,
      ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource) {
    SetDefaultNetworkTierProjectRequest request =
        SetDefaultNetworkTierProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsSetDefaultNetworkTierRequestResource(
                projectsSetDefaultNetworkTierRequestResource)
            .build();
    return setDefaultNetworkTier(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   SetDefaultNetworkTierProjectRequest request = SetDefaultNetworkTierProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsSetDefaultNetworkTierRequestResource(projectsSetDefaultNetworkTierRequestResource)
   *     .build();
   *   Operation response = projectsClient.setDefaultNetworkTier(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDefaultNetworkTier(SetDefaultNetworkTierProjectRequest request) {
    return setDefaultNetworkTierCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource = ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   SetDefaultNetworkTierProjectRequest request = SetDefaultNetworkTierProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setProjectsSetDefaultNetworkTierRequestResource(projectsSetDefaultNetworkTierRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.setDefaultNetworkTierCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierCallable() {
    return stub.setDefaultNetworkTierCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   Operation response = projectsClient.setUsageExportBucket(project, usageExportLocationResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param usageExportLocationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setUsageExportBucket(
      String project, UsageExportLocation usageExportLocationResource) {
    SetUsageExportBucketProjectRequest request =
        SetUsageExportBucketProjectRequest.newBuilder()
            .setProject(project)
            .setUsageExportLocationResource(usageExportLocationResource)
            .build();
    return setUsageExportBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   SetUsageExportBucketProjectRequest request = SetUsageExportBucketProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setUsageExportLocationResource(usageExportLocationResource)
   *     .build();
   *   Operation response = projectsClient.setUsageExportBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setUsageExportBucket(SetUsageExportBucketProjectRequest request) {
    return setUsageExportBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "";
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   SetUsageExportBucketProjectRequest request = SetUsageExportBucketProjectRequest.newBuilder()
   *     .setProject(project)
   *     .setUsageExportLocationResource(usageExportLocationResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = projectsClient.setUsageExportBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketCallable() {
    return stub.setUsageExportBucketCallable();
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

  public static class GetXpnResourcesPagedResponse
      extends AbstractPagedListResponse<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage,
          GetXpnResourcesFixedSizeCollection> {

    public static ApiFuture<GetXpnResourcesPagedResponse> createAsync(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      ApiFuture<GetXpnResourcesPage> futurePage =
          GetXpnResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<GetXpnResourcesPage, GetXpnResourcesPagedResponse>() {
            @Override
            public GetXpnResourcesPagedResponse apply(GetXpnResourcesPage input) {
              return new GetXpnResourcesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private GetXpnResourcesPagedResponse(GetXpnResourcesPage page) {
      super(page, GetXpnResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetXpnResourcesPage
      extends AbstractPage<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage> {

    private GetXpnResourcesPage(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ProjectsGetXpnResources response) {
      super(context, response);
    }

    private static GetXpnResourcesPage createEmptyPage() {
      return new GetXpnResourcesPage(null, null);
    }

    @Override
    protected GetXpnResourcesPage createPage(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ProjectsGetXpnResources response) {
      return new GetXpnResourcesPage(context, response);
    }

    @Override
    public ApiFuture<GetXpnResourcesPage> createPageAsync(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetXpnResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage,
          GetXpnResourcesFixedSizeCollection> {

    private GetXpnResourcesFixedSizeCollection(
        List<GetXpnResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetXpnResourcesFixedSizeCollection createEmptyCollection() {
      return new GetXpnResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected GetXpnResourcesFixedSizeCollection createCollection(
        List<GetXpnResourcesPage> pages, int collectionSize) {
      return new GetXpnResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListXpnHostsPagedResponse
      extends AbstractPagedListResponse<
          ListXpnHostsProjectsRequest,
          XpnHostList,
          Project,
          ListXpnHostsPage,
          ListXpnHostsFixedSizeCollection> {

    public static ApiFuture<ListXpnHostsPagedResponse> createAsync(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      ApiFuture<ListXpnHostsPage> futurePage =
          ListXpnHostsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListXpnHostsPage, ListXpnHostsPagedResponse>() {
            @Override
            public ListXpnHostsPagedResponse apply(ListXpnHostsPage input) {
              return new ListXpnHostsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListXpnHostsPagedResponse(ListXpnHostsPage page) {
      super(page, ListXpnHostsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListXpnHostsPage
      extends AbstractPage<ListXpnHostsProjectsRequest, XpnHostList, Project, ListXpnHostsPage> {

    private ListXpnHostsPage(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        XpnHostList response) {
      super(context, response);
    }

    private static ListXpnHostsPage createEmptyPage() {
      return new ListXpnHostsPage(null, null);
    }

    @Override
    protected ListXpnHostsPage createPage(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        XpnHostList response) {
      return new ListXpnHostsPage(context, response);
    }

    @Override
    public ApiFuture<ListXpnHostsPage> createPageAsync(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListXpnHostsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListXpnHostsProjectsRequest,
          XpnHostList,
          Project,
          ListXpnHostsPage,
          ListXpnHostsFixedSizeCollection> {

    private ListXpnHostsFixedSizeCollection(List<ListXpnHostsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListXpnHostsFixedSizeCollection createEmptyCollection() {
      return new ListXpnHostsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListXpnHostsFixedSizeCollection createCollection(
        List<ListXpnHostsPage> pages, int collectionSize) {
      return new ListXpnHostsFixedSizeCollection(pages, collectionSize);
    }
  }
}
