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

package com.google.cloud.resourcemanager.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcemanager.v3.stub.ProjectsStub;
import com.google.cloud.resourcemanager.v3.stub.ProjectsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Google Cloud Projects.
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
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   Project response = projectsClient.getProject(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProjectsClient object to clean up resources such as
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectsClient projectsClient = ProjectsClient.create(projectsSettings);
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
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectsClient projectsClient = ProjectsClient.create(projectsSettings);
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
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ProjectsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ProjectsClient projectsClient = ProjectsClient.create(projectsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ProjectsClient implements BackgroundResource {
  private final ProjectsSettings settings;
  private final ProjectsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

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
   * advanced usage - prefer using create(ProjectsSettings).
   */
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
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ProjectsClient(ProjectsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ProjectsSettings getSettings() {
    return settings;
  }

  public ProjectsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the project identified by the specified `name` (for example,
   * `projects/415104041262`).
   *
   * <p>The caller must have `resourcemanager.projects.get` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Project response = projectsClient.getProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the project (for example, `projects/415104041262`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(ProjectName name) {
    GetProjectRequest request =
        GetProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the project identified by the specified `name` (for example,
   * `projects/415104041262`).
   *
   * <p>The caller must have `resourcemanager.projects.get` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   Project response = projectsClient.getProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the project (for example, `projects/415104041262`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(String name) {
    GetProjectRequest request = GetProjectRequest.newBuilder().setName(name).build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the project identified by the specified `name` (for example,
   * `projects/415104041262`).
   *
   * <p>The caller must have `resourcemanager.projects.get` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder().setName(ProjectName.of("[PROJECT]").toString()).build();
   *   Project response = projectsClient.getProject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(GetProjectRequest request) {
    return getProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the project identified by the specified `name` (for example,
   * `projects/415104041262`).
   *
   * <p>The caller must have `resourcemanager.projects.get` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder().setName(ProjectName.of("[PROJECT]").toString()).build();
   *   ApiFuture<Project> future = projectsClient.getProjectCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    return stub.getProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists projects that are direct children of the specified folder or organization resource.
   * `list()` provides a strongly consistent view of the projects underneath the specified parent
   * resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their
   * `display_name`. The caller must have `resourcemanager.projects.list` permission on the
   * identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   for (Project element : projectsClient.listProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource to list projects under.
   *     <p>For example, setting this field to 'folders/1234' would list all projects directly under
   *     that folder.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectsPagedResponse listProjects(ResourceName parent) {
    ListProjectsRequest request =
        ListProjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists projects that are direct children of the specified folder or organization resource.
   * `list()` provides a strongly consistent view of the projects underneath the specified parent
   * resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their
   * `display_name`. The caller must have `resourcemanager.projects.list` permission on the
   * identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   for (Project element : projectsClient.listProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource to list projects under.
   *     <p>For example, setting this field to 'folders/1234' would list all projects directly under
   *     that folder.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectsPagedResponse listProjects(String parent) {
    ListProjectsRequest request = ListProjectsRequest.newBuilder().setParent(parent).build();
    return listProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists projects that are direct children of the specified folder or organization resource.
   * `list()` provides a strongly consistent view of the projects underneath the specified parent
   * resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their
   * `display_name`. The caller must have `resourcemanager.projects.list` permission on the
   * identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListProjectsRequest request =
   *       ListProjectsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setShowDeleted(true)
   *           .build();
   *   for (Project element : projectsClient.listProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectsPagedResponse listProjects(ListProjectsRequest request) {
    return listProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists projects that are direct children of the specified folder or organization resource.
   * `list()` provides a strongly consistent view of the projects underneath the specified parent
   * resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their
   * `display_name`. The caller must have `resourcemanager.projects.list` permission on the
   * identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListProjectsRequest request =
   *       ListProjectsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Project> future = projectsClient.listProjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Project element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProjectsRequest, ListProjectsPagedResponse>
      listProjectsPagedCallable() {
    return stub.listProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists projects that are direct children of the specified folder or organization resource.
   * `list()` provides a strongly consistent view of the projects underneath the specified parent
   * resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their
   * `display_name`. The caller must have `resourcemanager.projects.list` permission on the
   * identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListProjectsRequest request =
   *       ListProjectsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListProjectsResponse response = projectsClient.listProjectsCallable().call(request);
   *     for (Project element : response.getProjectsList()) {
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
  public final UnaryCallable<ListProjectsRequest, ListProjectsResponse> listProjectsCallable() {
    return stub.listProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for projects that the caller has both `resourcemanager.projects.get` permission on, and
   * also satisfy the specified query.
   *
   * <p>This method returns projects in an unspecified order.
   *
   * <p>This method is eventually consistent with project mutations; this means that a newly created
   * project may not appear in the results or recent updates to an existing project may not be
   * reflected in the results. To retrieve the latest state of a project, use the
   * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String query = "query107944136";
   *   for (Project element : projectsClient.searchProjects(query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param query Optional. A query string for searching for projects that the caller has
   *     `resourcemanager.projects.get` permission to. If multiple fields are included in the query,
   *     the it will return results that match any of the fields. Some eligible fields are:
   *     <p>``` | Field | Description |
   *     |-------------------------|----------------------------------------------| | displayName,
   *     name | Filters by displayName. | | parent | Project's parent. (for example: folders/123,
   *     organizations/&#42;) Prefer parent field over parent.type and parent.id. | | parent.type |
   *     Parent's type: `folder` or `organization`. | | parent.id | Parent's id number (for example:
   *     123) | | id, projectId | Filters by projectId. | | state, lifecycleState | Filters by
   *     state. | | labels | Filters by label name or value. | | labels.&lt;key&gt; (where
   *     &#42;key&#42; is the name of a label) | Filters by label name. | ```
   *     <p>Search expressions are case insensitive.
   *     <p>Some examples queries:
   *     <p>``` | Query | Description |
   *     |------------------|-----------------------------------------------------| | name:how&#42;
   *     | The project's name starts with "how". | | name:Howl | The project's name is `Howl` or
   *     `howl`. | | name:HOWL | Equivalent to above. | | NAME:howl | Equivalent to above. | |
   *     labels.color:&#42; | The project has the label `color`. | | labels.color:red | The
   *     project's label `color` has the value `red`. | | labels.color:red&amp;nbsp;labels.size:big
   *     | The project's label `color` has the value `red` and its label `size` has the value `big`.
   *     | ```
   *     <p>If no query is specified, the call will return projects for which the user has the
   *     `resourcemanager.projects.get` permission.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProjectsPagedResponse searchProjects(String query) {
    SearchProjectsRequest request = SearchProjectsRequest.newBuilder().setQuery(query).build();
    return searchProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for projects that the caller has both `resourcemanager.projects.get` permission on, and
   * also satisfy the specified query.
   *
   * <p>This method returns projects in an unspecified order.
   *
   * <p>This method is eventually consistent with project mutations; this means that a newly created
   * project may not appear in the results or recent updates to an existing project may not be
   * reflected in the results. To retrieve the latest state of a project, use the
   * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SearchProjectsRequest request =
   *       SearchProjectsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Project element : projectsClient.searchProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProjectsPagedResponse searchProjects(SearchProjectsRequest request) {
    return searchProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for projects that the caller has both `resourcemanager.projects.get` permission on, and
   * also satisfy the specified query.
   *
   * <p>This method returns projects in an unspecified order.
   *
   * <p>This method is eventually consistent with project mutations; this means that a newly created
   * project may not appear in the results or recent updates to an existing project may not be
   * reflected in the results. To retrieve the latest state of a project, use the
   * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SearchProjectsRequest request =
   *       SearchProjectsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Project> future = projectsClient.searchProjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Project element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchProjectsRequest, SearchProjectsPagedResponse>
      searchProjectsPagedCallable() {
    return stub.searchProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for projects that the caller has both `resourcemanager.projects.get` permission on, and
   * also satisfy the specified query.
   *
   * <p>This method returns projects in an unspecified order.
   *
   * <p>This method is eventually consistent with project mutations; this means that a newly created
   * project may not appear in the results or recent updates to an existing project may not be
   * reflected in the results. To retrieve the latest state of a project, use the
   * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SearchProjectsRequest request =
   *       SearchProjectsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     SearchProjectsResponse response = projectsClient.searchProjectsCallable().call(request);
   *     for (Project element : response.getProjectsList()) {
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
  public final UnaryCallable<SearchProjectsRequest, SearchProjectsResponse>
      searchProjectsCallable() {
    return stub.searchProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request that a new project be created. The result is an `Operation` which can be used to track
   * the creation process. This process usually takes a few seconds, but can sometimes take much
   * longer. The tracking `Operation` is automatically deleted after a few hours, so there is no
   * need to call `DeleteOperation`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   Project project = Project.newBuilder().build();
   *   Project response = projectsClient.createProjectAsync(project).get();
   * }
   * }</pre>
   *
   * @param project Required. The Project to create.
   *     <p>Project ID is required. If the requested ID is unavailable, the request fails.
   *     <p>If the `parent` field is set, the `resourcemanager.projects.create` permission is
   *     checked on the parent resource. If no parent is set and the authorization credentials
   *     belong to an Organziation, the parent will be set to that Organization.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, CreateProjectMetadata> createProjectAsync(Project project) {
    CreateProjectRequest request = CreateProjectRequest.newBuilder().setProject(project).build();
    return createProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request that a new project be created. The result is an `Operation` which can be used to track
   * the creation process. This process usually takes a few seconds, but can sometimes take much
   * longer. The tracking `Operation` is automatically deleted after a few hours, so there is no
   * need to call `DeleteOperation`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   CreateProjectRequest request =
   *       CreateProjectRequest.newBuilder().setProject(Project.newBuilder().build()).build();
   *   Project response = projectsClient.createProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, CreateProjectMetadata> createProjectAsync(
      CreateProjectRequest request) {
    return createProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request that a new project be created. The result is an `Operation` which can be used to track
   * the creation process. This process usually takes a few seconds, but can sometimes take much
   * longer. The tracking `Operation` is automatically deleted after a few hours, so there is no
   * need to call `DeleteOperation`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   CreateProjectRequest request =
   *       CreateProjectRequest.newBuilder().setProject(Project.newBuilder().build()).build();
   *   OperationFuture<Project, CreateProjectMetadata> future =
   *       projectsClient.createProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationCallable() {
    return stub.createProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request that a new project be created. The result is an `Operation` which can be used to track
   * the creation process. This process usually takes a few seconds, but can sometimes take much
   * longer. The tracking `Operation` is automatically deleted after a few hours, so there is no
   * need to call `DeleteOperation`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   CreateProjectRequest request =
   *       CreateProjectRequest.newBuilder().setProject(Project.newBuilder().build()).build();
   *   ApiFuture<Operation> future = projectsClient.createProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProjectRequest, Operation> createProjectCallable() {
    return stub.createProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the `display_name` and labels of the project identified by the specified `name` (for
   * example, `projects/415104041262`). Deleting all labels requires an update mask for labels
   * field.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   Project project = Project.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Project response = projectsClient.updateProjectAsync(project, updateMask).get();
   * }
   * }</pre>
   *
   * @param project Required. The new definition of the project.
   * @param updateMask Optional. An update mask to selectively update fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, UpdateProjectMetadata> updateProjectAsync(
      Project project, FieldMask updateMask) {
    UpdateProjectRequest request =
        UpdateProjectRequest.newBuilder().setProject(project).setUpdateMask(updateMask).build();
    return updateProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the `display_name` and labels of the project identified by the specified `name` (for
   * example, `projects/415104041262`). Deleting all labels requires an update mask for labels
   * field.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UpdateProjectRequest request =
   *       UpdateProjectRequest.newBuilder()
   *           .setProject(Project.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Project response = projectsClient.updateProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, UpdateProjectMetadata> updateProjectAsync(
      UpdateProjectRequest request) {
    return updateProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the `display_name` and labels of the project identified by the specified `name` (for
   * example, `projects/415104041262`). Deleting all labels requires an update mask for labels
   * field.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UpdateProjectRequest request =
   *       UpdateProjectRequest.newBuilder()
   *           .setProject(Project.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Project, UpdateProjectMetadata> future =
   *       projectsClient.updateProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationCallable() {
    return stub.updateProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the `display_name` and labels of the project identified by the specified `name` (for
   * example, `projects/415104041262`). Deleting all labels requires an update mask for labels
   * field.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UpdateProjectRequest request =
   *       UpdateProjectRequest.newBuilder()
   *           .setProject(Project.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.updateProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProjectRequest, Operation> updateProjectCallable() {
    return stub.updateProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   ResourceName destinationParent = ProjectName.of("[PROJECT]");
   *   Project response = projectsClient.moveProjectAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project to move.
   * @param destinationParent Required. The new parent to move the Project under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, MoveProjectMetadata> moveProjectAsync(
      ProjectName name, ResourceName destinationParent) {
    MoveProjectRequest request =
        MoveProjectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationParent(destinationParent == null ? null : destinationParent.toString())
            .build();
    return moveProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   String destinationParent = FolderName.of("[FOLDER]").toString();
   *   Project response = projectsClient.moveProjectAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project to move.
   * @param destinationParent Required. The new parent to move the Project under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, MoveProjectMetadata> moveProjectAsync(
      ProjectName name, String destinationParent) {
    MoveProjectRequest request =
        MoveProjectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationParent(destinationParent)
            .build();
    return moveProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   ResourceName destinationParent = ProjectName.of("[PROJECT]");
   *   Project response = projectsClient.moveProjectAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project to move.
   * @param destinationParent Required. The new parent to move the Project under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, MoveProjectMetadata> moveProjectAsync(
      String name, ResourceName destinationParent) {
    MoveProjectRequest request =
        MoveProjectRequest.newBuilder()
            .setName(name)
            .setDestinationParent(destinationParent == null ? null : destinationParent.toString())
            .build();
    return moveProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   String destinationParent = FolderName.of("[FOLDER]").toString();
   *   Project response = projectsClient.moveProjectAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project to move.
   * @param destinationParent Required. The new parent to move the Project under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, MoveProjectMetadata> moveProjectAsync(
      String name, String destinationParent) {
    MoveProjectRequest request =
        MoveProjectRequest.newBuilder()
            .setName(name)
            .setDestinationParent(destinationParent)
            .build();
    return moveProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveProjectRequest request =
   *       MoveProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   Project response = projectsClient.moveProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, MoveProjectMetadata> moveProjectAsync(
      MoveProjectRequest request) {
    return moveProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveProjectRequest request =
   *       MoveProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   OperationFuture<Project, MoveProjectMetadata> future =
   *       projectsClient.moveProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationCallable() {
    return stub.moveProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Move a project to another place in your resource hierarchy, under a new resource parent.
   *
   * <p>Returns an operation which can be used to track the process of the project move workflow.
   * Upon success, the `Operation.response` field will be populated with the moved project.
   *
   * <p>The caller must have `resourcemanager.projects.update` permission on the project and have
   * `resourcemanager.projects.move` permission on the project's current and proposed new parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveProjectRequest request =
   *       MoveProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.moveProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveProjectRequest, Operation> moveProjectCallable() {
    return stub.moveProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the project identified by the specified `name` (for example, `projects/415104041262`) for
   * deletion.
   *
   * <p>This method will only affect the project if it has a lifecycle state of
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
   *
   * <p>This method changes the Project's lifecycle state from
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE] to
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED]. The
   * deletion starts at an unspecified time, at which point the Project is no longer accessible.
   *
   * <p>Until the deletion completes, you can check the lifecycle state checked by retrieving the
   * project with [GetProject] [google.cloud.resourcemanager.v3.Projects.GetProject], and the
   * project remains visible to [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects]. However, you cannot update the
   * project.
   *
   * <p>After the deletion completes, the project is not retrievable by the [GetProject]
   * [google.cloud.resourcemanager.v3.Projects.GetProject], [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
   * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects] methods.
   *
   * <p>This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not
   * cause an error, but also won't do anything.
   *
   * <p>The caller must have `resourcemanager.projects.delete` permissions for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Project response = projectsClient.deleteProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Project (for example, `projects/415104041262`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, DeleteProjectMetadata> deleteProjectAsync(
      ProjectName name) {
    DeleteProjectRequest request =
        DeleteProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the project identified by the specified `name` (for example, `projects/415104041262`) for
   * deletion.
   *
   * <p>This method will only affect the project if it has a lifecycle state of
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
   *
   * <p>This method changes the Project's lifecycle state from
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE] to
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED]. The
   * deletion starts at an unspecified time, at which point the Project is no longer accessible.
   *
   * <p>Until the deletion completes, you can check the lifecycle state checked by retrieving the
   * project with [GetProject] [google.cloud.resourcemanager.v3.Projects.GetProject], and the
   * project remains visible to [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects]. However, you cannot update the
   * project.
   *
   * <p>After the deletion completes, the project is not retrievable by the [GetProject]
   * [google.cloud.resourcemanager.v3.Projects.GetProject], [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
   * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects] methods.
   *
   * <p>This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not
   * cause an error, but also won't do anything.
   *
   * <p>The caller must have `resourcemanager.projects.delete` permissions for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   Project response = projectsClient.deleteProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Project (for example, `projects/415104041262`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, DeleteProjectMetadata> deleteProjectAsync(String name) {
    DeleteProjectRequest request = DeleteProjectRequest.newBuilder().setName(name).build();
    return deleteProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the project identified by the specified `name` (for example, `projects/415104041262`) for
   * deletion.
   *
   * <p>This method will only affect the project if it has a lifecycle state of
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
   *
   * <p>This method changes the Project's lifecycle state from
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE] to
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED]. The
   * deletion starts at an unspecified time, at which point the Project is no longer accessible.
   *
   * <p>Until the deletion completes, you can check the lifecycle state checked by retrieving the
   * project with [GetProject] [google.cloud.resourcemanager.v3.Projects.GetProject], and the
   * project remains visible to [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects]. However, you cannot update the
   * project.
   *
   * <p>After the deletion completes, the project is not retrievable by the [GetProject]
   * [google.cloud.resourcemanager.v3.Projects.GetProject], [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
   * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects] methods.
   *
   * <p>This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not
   * cause an error, but also won't do anything.
   *
   * <p>The caller must have `resourcemanager.projects.delete` permissions for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DeleteProjectRequest request =
   *       DeleteProjectRequest.newBuilder().setName(ProjectName.of("[PROJECT]").toString()).build();
   *   Project response = projectsClient.deleteProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, DeleteProjectMetadata> deleteProjectAsync(
      DeleteProjectRequest request) {
    return deleteProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the project identified by the specified `name` (for example, `projects/415104041262`) for
   * deletion.
   *
   * <p>This method will only affect the project if it has a lifecycle state of
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
   *
   * <p>This method changes the Project's lifecycle state from
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE] to
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED]. The
   * deletion starts at an unspecified time, at which point the Project is no longer accessible.
   *
   * <p>Until the deletion completes, you can check the lifecycle state checked by retrieving the
   * project with [GetProject] [google.cloud.resourcemanager.v3.Projects.GetProject], and the
   * project remains visible to [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects]. However, you cannot update the
   * project.
   *
   * <p>After the deletion completes, the project is not retrievable by the [GetProject]
   * [google.cloud.resourcemanager.v3.Projects.GetProject], [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
   * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects] methods.
   *
   * <p>This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not
   * cause an error, but also won't do anything.
   *
   * <p>The caller must have `resourcemanager.projects.delete` permissions for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DeleteProjectRequest request =
   *       DeleteProjectRequest.newBuilder().setName(ProjectName.of("[PROJECT]").toString()).build();
   *   OperationFuture<Project, DeleteProjectMetadata> future =
   *       projectsClient.deleteProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationCallable() {
    return stub.deleteProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the project identified by the specified `name` (for example, `projects/415104041262`) for
   * deletion.
   *
   * <p>This method will only affect the project if it has a lifecycle state of
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
   *
   * <p>This method changes the Project's lifecycle state from
   * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE] to
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED]. The
   * deletion starts at an unspecified time, at which point the Project is no longer accessible.
   *
   * <p>Until the deletion completes, you can check the lifecycle state checked by retrieving the
   * project with [GetProject] [google.cloud.resourcemanager.v3.Projects.GetProject], and the
   * project remains visible to [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects]. However, you cannot update the
   * project.
   *
   * <p>After the deletion completes, the project is not retrievable by the [GetProject]
   * [google.cloud.resourcemanager.v3.Projects.GetProject], [ListProjects]
   * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
   * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects] methods.
   *
   * <p>This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not
   * cause an error, but also won't do anything.
   *
   * <p>The caller must have `resourcemanager.projects.delete` permissions for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DeleteProjectRequest request =
   *       DeleteProjectRequest.newBuilder().setName(ProjectName.of("[PROJECT]").toString()).build();
   *   ApiFuture<Operation> future = projectsClient.deleteProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProjectRequest, Operation> deleteProjectCallable() {
    return stub.deleteProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the project identified by the specified `name` (for example, `projects/415104041262`).
   * You can only use this method for a project that has a lifecycle state of [DELETE_REQUESTED]
   * [Projects.State.DELETE_REQUESTED]. After deletion starts, the project cannot be restored.
   *
   * <p>The caller must have `resourcemanager.projects.undelete` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Project response = projectsClient.undeleteProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project (for example, `projects/415104041262`).
   *     <p>Required.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, UndeleteProjectMetadata> undeleteProjectAsync(
      ProjectName name) {
    UndeleteProjectRequest request =
        UndeleteProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return undeleteProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the project identified by the specified `name` (for example, `projects/415104041262`).
   * You can only use this method for a project that has a lifecycle state of [DELETE_REQUESTED]
   * [Projects.State.DELETE_REQUESTED]. After deletion starts, the project cannot be restored.
   *
   * <p>The caller must have `resourcemanager.projects.undelete` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   Project response = projectsClient.undeleteProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the project (for example, `projects/415104041262`).
   *     <p>Required.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, UndeleteProjectMetadata> undeleteProjectAsync(String name) {
    UndeleteProjectRequest request = UndeleteProjectRequest.newBuilder().setName(name).build();
    return undeleteProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the project identified by the specified `name` (for example, `projects/415104041262`).
   * You can only use this method for a project that has a lifecycle state of [DELETE_REQUESTED]
   * [Projects.State.DELETE_REQUESTED]. After deletion starts, the project cannot be restored.
   *
   * <p>The caller must have `resourcemanager.projects.undelete` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UndeleteProjectRequest request =
   *       UndeleteProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   Project response = projectsClient.undeleteProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, UndeleteProjectMetadata> undeleteProjectAsync(
      UndeleteProjectRequest request) {
    return undeleteProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the project identified by the specified `name` (for example, `projects/415104041262`).
   * You can only use this method for a project that has a lifecycle state of [DELETE_REQUESTED]
   * [Projects.State.DELETE_REQUESTED]. After deletion starts, the project cannot be restored.
   *
   * <p>The caller must have `resourcemanager.projects.undelete` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UndeleteProjectRequest request =
   *       UndeleteProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   OperationFuture<Project, UndeleteProjectMetadata> future =
   *       projectsClient.undeleteProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationCallable() {
    return stub.undeleteProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the project identified by the specified `name` (for example, `projects/415104041262`).
   * You can only use this method for a project that has a lifecycle state of [DELETE_REQUESTED]
   * [Projects.State.DELETE_REQUESTED]. After deletion starts, the project cannot be restored.
   *
   * <p>The caller must have `resourcemanager.projects.undelete` permission for this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   UndeleteProjectRequest request =
   *       UndeleteProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.undeleteProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteProjectRequest, Operation> undeleteProjectCallable() {
    return stub.undeleteProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the IAM access control policy for the specified project. Permission is denied if the
   * policy or the resource do not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ResourceName resource = ProjectName.of("[PROJECT]");
   *   Policy response = projectsClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the IAM access control policy for the specified project. Permission is denied if the
   * policy or the resource do not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = projectsClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the IAM access control policy for the specified project. Permission is denied if the
   * policy or the resource do not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = projectsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the IAM access control policy for the specified project. Permission is denied if the
   * policy or the resource do not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = projectsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for the specified project.
   *
   * <p>CAUTION: This method will replace the existing policy, and cannot be used to append
   * additional IAM settings.
   *
   * <p>Note: Removing service accounts from policies or changing their roles can render services
   * completely inoperable. It is important to understand how the service account is being used
   * before removing or updating its roles.
   *
   * <p>The following constraints apply when using `setIamPolicy()`:
   *
   * <p>+ Project does not support `allUsers` and `allAuthenticatedUsers` as `members` in a
   * `Binding` of a `Policy`.
   *
   * <p>+ The owner role can be granted to a `user`, `serviceAccount`, or a group that is part of an
   * organization. For example, group{@literal @}myownpersonaldomain.com could be added as an owner
   * to a project in the myownpersonaldomain.com organization, but not the examplepetstore.com
   * organization.
   *
   * <p>+ Service accounts can be made owners of a project directly without any restrictions.
   * However, to be added as an owner, a user must be invited using the Cloud Platform console and
   * must accept the invitation.
   *
   * <p>+ A user cannot be granted the owner role using `setIamPolicy()`. The user must be granted
   * the owner role using the Cloud Platform Console and must explicitly accept the invitation.
   *
   * <p>+ Invitations to grant the owner role cannot be sent using `setIamPolicy()`; they must be
   * sent only using the Cloud Platform Console.
   *
   * <p>+ Membership changes that leave the project without any owners that have accepted the Terms
   * of Service (ToS) will be rejected.
   *
   * <p>+ If the project is not part of an organization, there must be at least one owner who has
   * accepted the Terms of Service (ToS) agreement in the policy. Calling `setIamPolicy()` to remove
   * the last ToS-accepted owner from the policy will fail. This restriction also applies to legacy
   * projects that no longer have owners who have accepted the ToS. Edits to IAM policies will be
   * rejected until the lack of a ToS-accepting owner is rectified.
   *
   * <p>+ Calling this method requires enabling the App Engine Admin API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ResourceName resource = ProjectName.of("[PROJECT]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = projectsClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for the specified project.
   *
   * <p>CAUTION: This method will replace the existing policy, and cannot be used to append
   * additional IAM settings.
   *
   * <p>Note: Removing service accounts from policies or changing their roles can render services
   * completely inoperable. It is important to understand how the service account is being used
   * before removing or updating its roles.
   *
   * <p>The following constraints apply when using `setIamPolicy()`:
   *
   * <p>+ Project does not support `allUsers` and `allAuthenticatedUsers` as `members` in a
   * `Binding` of a `Policy`.
   *
   * <p>+ The owner role can be granted to a `user`, `serviceAccount`, or a group that is part of an
   * organization. For example, group{@literal @}myownpersonaldomain.com could be added as an owner
   * to a project in the myownpersonaldomain.com organization, but not the examplepetstore.com
   * organization.
   *
   * <p>+ Service accounts can be made owners of a project directly without any restrictions.
   * However, to be added as an owner, a user must be invited using the Cloud Platform console and
   * must accept the invitation.
   *
   * <p>+ A user cannot be granted the owner role using `setIamPolicy()`. The user must be granted
   * the owner role using the Cloud Platform Console and must explicitly accept the invitation.
   *
   * <p>+ Invitations to grant the owner role cannot be sent using `setIamPolicy()`; they must be
   * sent only using the Cloud Platform Console.
   *
   * <p>+ Membership changes that leave the project without any owners that have accepted the Terms
   * of Service (ToS) will be rejected.
   *
   * <p>+ If the project is not part of an organization, there must be at least one owner who has
   * accepted the Terms of Service (ToS) agreement in the policy. Calling `setIamPolicy()` to remove
   * the last ToS-accepted owner from the policy will fail. This restriction also applies to legacy
   * projects that no longer have owners who have accepted the ToS. Edits to IAM policies will be
   * rejected until the lack of a ToS-accepting owner is rectified.
   *
   * <p>+ Calling this method requires enabling the App Engine Admin API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = projectsClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for the specified project.
   *
   * <p>CAUTION: This method will replace the existing policy, and cannot be used to append
   * additional IAM settings.
   *
   * <p>Note: Removing service accounts from policies or changing their roles can render services
   * completely inoperable. It is important to understand how the service account is being used
   * before removing or updating its roles.
   *
   * <p>The following constraints apply when using `setIamPolicy()`:
   *
   * <p>+ Project does not support `allUsers` and `allAuthenticatedUsers` as `members` in a
   * `Binding` of a `Policy`.
   *
   * <p>+ The owner role can be granted to a `user`, `serviceAccount`, or a group that is part of an
   * organization. For example, group{@literal @}myownpersonaldomain.com could be added as an owner
   * to a project in the myownpersonaldomain.com organization, but not the examplepetstore.com
   * organization.
   *
   * <p>+ Service accounts can be made owners of a project directly without any restrictions.
   * However, to be added as an owner, a user must be invited using the Cloud Platform console and
   * must accept the invitation.
   *
   * <p>+ A user cannot be granted the owner role using `setIamPolicy()`. The user must be granted
   * the owner role using the Cloud Platform Console and must explicitly accept the invitation.
   *
   * <p>+ Invitations to grant the owner role cannot be sent using `setIamPolicy()`; they must be
   * sent only using the Cloud Platform Console.
   *
   * <p>+ Membership changes that leave the project without any owners that have accepted the Terms
   * of Service (ToS) will be rejected.
   *
   * <p>+ If the project is not part of an organization, there must be at least one owner who has
   * accepted the Terms of Service (ToS) agreement in the policy. Calling `setIamPolicy()` to remove
   * the last ToS-accepted owner from the policy will fail. This restriction also applies to legacy
   * projects that no longer have owners who have accepted the ToS. Edits to IAM policies will be
   * rejected until the lack of a ToS-accepting owner is rectified.
   *
   * <p>+ Calling this method requires enabling the App Engine Admin API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = projectsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for the specified project.
   *
   * <p>CAUTION: This method will replace the existing policy, and cannot be used to append
   * additional IAM settings.
   *
   * <p>Note: Removing service accounts from policies or changing their roles can render services
   * completely inoperable. It is important to understand how the service account is being used
   * before removing or updating its roles.
   *
   * <p>The following constraints apply when using `setIamPolicy()`:
   *
   * <p>+ Project does not support `allUsers` and `allAuthenticatedUsers` as `members` in a
   * `Binding` of a `Policy`.
   *
   * <p>+ The owner role can be granted to a `user`, `serviceAccount`, or a group that is part of an
   * organization. For example, group{@literal @}myownpersonaldomain.com could be added as an owner
   * to a project in the myownpersonaldomain.com organization, but not the examplepetstore.com
   * organization.
   *
   * <p>+ Service accounts can be made owners of a project directly without any restrictions.
   * However, to be added as an owner, a user must be invited using the Cloud Platform console and
   * must accept the invitation.
   *
   * <p>+ A user cannot be granted the owner role using `setIamPolicy()`. The user must be granted
   * the owner role using the Cloud Platform Console and must explicitly accept the invitation.
   *
   * <p>+ Invitations to grant the owner role cannot be sent using `setIamPolicy()`; they must be
   * sent only using the Cloud Platform Console.
   *
   * <p>+ Membership changes that leave the project without any owners that have accepted the Terms
   * of Service (ToS) will be rejected.
   *
   * <p>+ If the project is not part of an organization, there must be at least one owner who has
   * accepted the Terms of Service (ToS) agreement in the policy. Calling `setIamPolicy()` to remove
   * the last ToS-accepted owner from the policy will fail. This restriction also applies to legacy
   * projects that no longer have owners who have accepted the ToS. Edits to IAM policies will be
   * rejected until the lack of a ToS-accepting owner is rectified.
   *
   * <p>+ Calling this method requires enabling the App Engine Admin API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = projectsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ResourceName resource = ProjectName.of("[PROJECT]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       projectsClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       projectsClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = projectsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       projectsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListProjectsPagedResponse
      extends AbstractPagedListResponse<
          ListProjectsRequest,
          ListProjectsResponse,
          Project,
          ListProjectsPage,
          ListProjectsFixedSizeCollection> {

    public static ApiFuture<ListProjectsPagedResponse> createAsync(
        PageContext<ListProjectsRequest, ListProjectsResponse, Project> context,
        ApiFuture<ListProjectsResponse> futureResponse) {
      ApiFuture<ListProjectsPage> futurePage =
          ListProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProjectsPagedResponse(ListProjectsPage page) {
      super(page, ListProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProjectsPage
      extends AbstractPage<ListProjectsRequest, ListProjectsResponse, Project, ListProjectsPage> {

    private ListProjectsPage(
        PageContext<ListProjectsRequest, ListProjectsResponse, Project> context,
        ListProjectsResponse response) {
      super(context, response);
    }

    private static ListProjectsPage createEmptyPage() {
      return new ListProjectsPage(null, null);
    }

    @Override
    protected ListProjectsPage createPage(
        PageContext<ListProjectsRequest, ListProjectsResponse, Project> context,
        ListProjectsResponse response) {
      return new ListProjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListProjectsPage> createPageAsync(
        PageContext<ListProjectsRequest, ListProjectsResponse, Project> context,
        ApiFuture<ListProjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProjectsRequest,
          ListProjectsResponse,
          Project,
          ListProjectsPage,
          ListProjectsFixedSizeCollection> {

    private ListProjectsFixedSizeCollection(List<ListProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProjectsFixedSizeCollection createEmptyCollection() {
      return new ListProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProjectsFixedSizeCollection createCollection(
        List<ListProjectsPage> pages, int collectionSize) {
      return new ListProjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchProjectsPagedResponse
      extends AbstractPagedListResponse<
          SearchProjectsRequest,
          SearchProjectsResponse,
          Project,
          SearchProjectsPage,
          SearchProjectsFixedSizeCollection> {

    public static ApiFuture<SearchProjectsPagedResponse> createAsync(
        PageContext<SearchProjectsRequest, SearchProjectsResponse, Project> context,
        ApiFuture<SearchProjectsResponse> futureResponse) {
      ApiFuture<SearchProjectsPage> futurePage =
          SearchProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchProjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchProjectsPagedResponse(SearchProjectsPage page) {
      super(page, SearchProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchProjectsPage
      extends AbstractPage<
          SearchProjectsRequest, SearchProjectsResponse, Project, SearchProjectsPage> {

    private SearchProjectsPage(
        PageContext<SearchProjectsRequest, SearchProjectsResponse, Project> context,
        SearchProjectsResponse response) {
      super(context, response);
    }

    private static SearchProjectsPage createEmptyPage() {
      return new SearchProjectsPage(null, null);
    }

    @Override
    protected SearchProjectsPage createPage(
        PageContext<SearchProjectsRequest, SearchProjectsResponse, Project> context,
        SearchProjectsResponse response) {
      return new SearchProjectsPage(context, response);
    }

    @Override
    public ApiFuture<SearchProjectsPage> createPageAsync(
        PageContext<SearchProjectsRequest, SearchProjectsResponse, Project> context,
        ApiFuture<SearchProjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchProjectsRequest,
          SearchProjectsResponse,
          Project,
          SearchProjectsPage,
          SearchProjectsFixedSizeCollection> {

    private SearchProjectsFixedSizeCollection(List<SearchProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchProjectsFixedSizeCollection createEmptyCollection() {
      return new SearchProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchProjectsFixedSizeCollection createCollection(
        List<SearchProjectsPage> pages, int collectionSize) {
      return new SearchProjectsFixedSizeCollection(pages, collectionSize);
    }
  }
}
