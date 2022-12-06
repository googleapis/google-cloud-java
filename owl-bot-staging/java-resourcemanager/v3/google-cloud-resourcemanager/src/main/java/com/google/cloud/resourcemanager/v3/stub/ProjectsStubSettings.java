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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.ProjectsClient.ListProjectsPagedResponse;
import static com.google.cloud.resourcemanager.v3.ProjectsClient.SearchProjectsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateProjectMetadata;
import com.google.cloud.resourcemanager.v3.CreateProjectRequest;
import com.google.cloud.resourcemanager.v3.DeleteProjectMetadata;
import com.google.cloud.resourcemanager.v3.DeleteProjectRequest;
import com.google.cloud.resourcemanager.v3.GetProjectRequest;
import com.google.cloud.resourcemanager.v3.ListProjectsRequest;
import com.google.cloud.resourcemanager.v3.ListProjectsResponse;
import com.google.cloud.resourcemanager.v3.MoveProjectMetadata;
import com.google.cloud.resourcemanager.v3.MoveProjectRequest;
import com.google.cloud.resourcemanager.v3.Project;
import com.google.cloud.resourcemanager.v3.SearchProjectsRequest;
import com.google.cloud.resourcemanager.v3.SearchProjectsResponse;
import com.google.cloud.resourcemanager.v3.UndeleteProjectMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteProjectRequest;
import com.google.cloud.resourcemanager.v3.UpdateProjectMetadata;
import com.google.cloud.resourcemanager.v3.UpdateProjectRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProjectsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getProject to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectsStubSettings.Builder projectsSettingsBuilder = ProjectsStubSettings.newBuilder();
 * projectsSettingsBuilder
 *     .getProjectSettings()
 *     .setRetrySettings(
 *         projectsSettingsBuilder.getProjectSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectsStubSettings projectsSettings = projectsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProjectsStubSettings extends StubSettings<ProjectsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<GetProjectRequest, Project> getProjectSettings;
  private final PagedCallSettings<
          ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
      listProjectsSettings;
  private final PagedCallSettings<
          SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
      searchProjectsSettings;
  private final UnaryCallSettings<CreateProjectRequest, Operation> createProjectSettings;
  private final OperationCallSettings<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationSettings;
  private final UnaryCallSettings<UpdateProjectRequest, Operation> updateProjectSettings;
  private final OperationCallSettings<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationSettings;
  private final UnaryCallSettings<MoveProjectRequest, Operation> moveProjectSettings;
  private final OperationCallSettings<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationSettings;
  private final UnaryCallSettings<DeleteProjectRequest, Operation> deleteProjectSettings;
  private final OperationCallSettings<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationSettings;
  private final UnaryCallSettings<UndeleteProjectRequest, Operation> undeleteProjectSettings;
  private final OperationCallSettings<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListProjectsRequest, ListProjectsResponse, Project>
      LIST_PROJECTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProjectsRequest, ListProjectsResponse, Project>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProjectsRequest injectToken(ListProjectsRequest payload, String token) {
              return ListProjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProjectsRequest injectPageSize(ListProjectsRequest payload, int pageSize) {
              return ListProjectsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProjectsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProjectsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Project> extractResources(ListProjectsResponse payload) {
              return payload.getProjectsList() == null
                  ? ImmutableList.<Project>of()
                  : payload.getProjectsList();
            }
          };

  private static final PagedListDescriptor<SearchProjectsRequest, SearchProjectsResponse, Project>
      SEARCH_PROJECTS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchProjectsRequest, SearchProjectsResponse, Project>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchProjectsRequest injectToken(SearchProjectsRequest payload, String token) {
              return SearchProjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchProjectsRequest injectPageSize(
                SearchProjectsRequest payload, int pageSize) {
              return SearchProjectsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchProjectsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchProjectsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Project> extractResources(SearchProjectsResponse payload) {
              return payload.getProjectsList() == null
                  ? ImmutableList.<Project>of()
                  : payload.getProjectsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
      LIST_PROJECTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>() {
            @Override
            public ApiFuture<ListProjectsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProjectsRequest, ListProjectsResponse> callable,
                ListProjectsRequest request,
                ApiCallContext context,
                ApiFuture<ListProjectsResponse> futureResponse) {
              PageContext<ListProjectsRequest, ListProjectsResponse, Project> pageContext =
                  PageContext.create(callable, LIST_PROJECTS_PAGE_STR_DESC, request, context);
              return ListProjectsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
      SEARCH_PROJECTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>() {
            @Override
            public ApiFuture<SearchProjectsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchProjectsRequest, SearchProjectsResponse> callable,
                SearchProjectsRequest request,
                ApiCallContext context,
                ApiFuture<SearchProjectsResponse> futureResponse) {
              PageContext<SearchProjectsRequest, SearchProjectsResponse, Project> pageContext =
                  PageContext.create(callable, SEARCH_PROJECTS_PAGE_STR_DESC, request, context);
              return SearchProjectsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getProject. */
  public UnaryCallSettings<GetProjectRequest, Project> getProjectSettings() {
    return getProjectSettings;
  }

  /** Returns the object with the settings used for calls to listProjects. */
  public PagedCallSettings<ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
      listProjectsSettings() {
    return listProjectsSettings;
  }

  /** Returns the object with the settings used for calls to searchProjects. */
  public PagedCallSettings<
          SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
      searchProjectsSettings() {
    return searchProjectsSettings;
  }

  /** Returns the object with the settings used for calls to createProject. */
  public UnaryCallSettings<CreateProjectRequest, Operation> createProjectSettings() {
    return createProjectSettings;
  }

  /** Returns the object with the settings used for calls to createProject. */
  public OperationCallSettings<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationSettings() {
    return createProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateProject. */
  public UnaryCallSettings<UpdateProjectRequest, Operation> updateProjectSettings() {
    return updateProjectSettings;
  }

  /** Returns the object with the settings used for calls to updateProject. */
  public OperationCallSettings<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationSettings() {
    return updateProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to moveProject. */
  public UnaryCallSettings<MoveProjectRequest, Operation> moveProjectSettings() {
    return moveProjectSettings;
  }

  /** Returns the object with the settings used for calls to moveProject. */
  public OperationCallSettings<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationSettings() {
    return moveProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteProject. */
  public UnaryCallSettings<DeleteProjectRequest, Operation> deleteProjectSettings() {
    return deleteProjectSettings;
  }

  /** Returns the object with the settings used for calls to deleteProject. */
  public OperationCallSettings<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationSettings() {
    return deleteProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteProject. */
  public UnaryCallSettings<UndeleteProjectRequest, Operation> undeleteProjectSettings() {
    return undeleteProjectSettings;
  }

  /** Returns the object with the settings used for calls to undeleteProject. */
  public OperationCallSettings<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationSettings() {
    return undeleteProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public ProjectsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProjectsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonProjectsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudresourcemanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudresourcemanager.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ProjectsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ProjectsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProjectsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ProjectsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getProjectSettings = settingsBuilder.getProjectSettings().build();
    listProjectsSettings = settingsBuilder.listProjectsSettings().build();
    searchProjectsSettings = settingsBuilder.searchProjectsSettings().build();
    createProjectSettings = settingsBuilder.createProjectSettings().build();
    createProjectOperationSettings = settingsBuilder.createProjectOperationSettings().build();
    updateProjectSettings = settingsBuilder.updateProjectSettings().build();
    updateProjectOperationSettings = settingsBuilder.updateProjectOperationSettings().build();
    moveProjectSettings = settingsBuilder.moveProjectSettings().build();
    moveProjectOperationSettings = settingsBuilder.moveProjectOperationSettings().build();
    deleteProjectSettings = settingsBuilder.deleteProjectSettings().build();
    deleteProjectOperationSettings = settingsBuilder.deleteProjectOperationSettings().build();
    undeleteProjectSettings = settingsBuilder.undeleteProjectSettings().build();
    undeleteProjectOperationSettings = settingsBuilder.undeleteProjectOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ProjectsStubSettings. */
  public static class Builder extends StubSettings.Builder<ProjectsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProjectRequest, Project> getProjectSettings;
    private final PagedCallSettings.Builder<
            ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
        listProjectsSettings;
    private final PagedCallSettings.Builder<
            SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
        searchProjectsSettings;
    private final UnaryCallSettings.Builder<CreateProjectRequest, Operation> createProjectSettings;
    private final OperationCallSettings.Builder<
            CreateProjectRequest, Project, CreateProjectMetadata>
        createProjectOperationSettings;
    private final UnaryCallSettings.Builder<UpdateProjectRequest, Operation> updateProjectSettings;
    private final OperationCallSettings.Builder<
            UpdateProjectRequest, Project, UpdateProjectMetadata>
        updateProjectOperationSettings;
    private final UnaryCallSettings.Builder<MoveProjectRequest, Operation> moveProjectSettings;
    private final OperationCallSettings.Builder<MoveProjectRequest, Project, MoveProjectMetadata>
        moveProjectOperationSettings;
    private final UnaryCallSettings.Builder<DeleteProjectRequest, Operation> deleteProjectSettings;
    private final OperationCallSettings.Builder<
            DeleteProjectRequest, Project, DeleteProjectMetadata>
        deleteProjectOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteProjectRequest, Operation>
        undeleteProjectSettings;
    private final OperationCallSettings.Builder<
            UndeleteProjectRequest, Project, UndeleteProjectMetadata>
        undeleteProjectOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProjectsSettings = PagedCallSettings.newBuilder(LIST_PROJECTS_PAGE_STR_FACT);
      searchProjectsSettings = PagedCallSettings.newBuilder(SEARCH_PROJECTS_PAGE_STR_FACT);
      createProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProjectOperationSettings = OperationCallSettings.newBuilder();
      updateProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProjectOperationSettings = OperationCallSettings.newBuilder();
      moveProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveProjectOperationSettings = OperationCallSettings.newBuilder();
      deleteProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProjectOperationSettings = OperationCallSettings.newBuilder();
      undeleteProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteProjectOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProjectSettings,
              listProjectsSettings,
              searchProjectsSettings,
              createProjectSettings,
              updateProjectSettings,
              moveProjectSettings,
              deleteProjectSettings,
              undeleteProjectSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ProjectsStubSettings settings) {
      super(settings);

      getProjectSettings = settings.getProjectSettings.toBuilder();
      listProjectsSettings = settings.listProjectsSettings.toBuilder();
      searchProjectsSettings = settings.searchProjectsSettings.toBuilder();
      createProjectSettings = settings.createProjectSettings.toBuilder();
      createProjectOperationSettings = settings.createProjectOperationSettings.toBuilder();
      updateProjectSettings = settings.updateProjectSettings.toBuilder();
      updateProjectOperationSettings = settings.updateProjectOperationSettings.toBuilder();
      moveProjectSettings = settings.moveProjectSettings.toBuilder();
      moveProjectOperationSettings = settings.moveProjectOperationSettings.toBuilder();
      deleteProjectSettings = settings.deleteProjectSettings.toBuilder();
      deleteProjectOperationSettings = settings.deleteProjectOperationSettings.toBuilder();
      undeleteProjectSettings = settings.undeleteProjectSettings.toBuilder();
      undeleteProjectOperationSettings = settings.undeleteProjectOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProjectSettings,
              listProjectsSettings,
              searchProjectsSettings,
              createProjectSettings,
              updateProjectSettings,
              moveProjectSettings,
              deleteProjectSettings,
              undeleteProjectSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listProjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchProjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .moveProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .undeleteProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Project.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateProjectMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Project.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateProjectMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .moveProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<MoveProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Project.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(MoveProjectMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Project.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteProjectMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .undeleteProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Project.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UndeleteProjectMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getProject. */
    public UnaryCallSettings.Builder<GetProjectRequest, Project> getProjectSettings() {
      return getProjectSettings;
    }

    /** Returns the builder for the settings used for calls to listProjects. */
    public PagedCallSettings.Builder<
            ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
        listProjectsSettings() {
      return listProjectsSettings;
    }

    /** Returns the builder for the settings used for calls to searchProjects. */
    public PagedCallSettings.Builder<
            SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
        searchProjectsSettings() {
      return searchProjectsSettings;
    }

    /** Returns the builder for the settings used for calls to createProject. */
    public UnaryCallSettings.Builder<CreateProjectRequest, Operation> createProjectSettings() {
      return createProjectSettings;
    }

    /** Returns the builder for the settings used for calls to createProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateProjectRequest, Project, CreateProjectMetadata>
        createProjectOperationSettings() {
      return createProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateProject. */
    public UnaryCallSettings.Builder<UpdateProjectRequest, Operation> updateProjectSettings() {
      return updateProjectSettings;
    }

    /** Returns the builder for the settings used for calls to updateProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateProjectRequest, Project, UpdateProjectMetadata>
        updateProjectOperationSettings() {
      return updateProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to moveProject. */
    public UnaryCallSettings.Builder<MoveProjectRequest, Operation> moveProjectSettings() {
      return moveProjectSettings;
    }

    /** Returns the builder for the settings used for calls to moveProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<MoveProjectRequest, Project, MoveProjectMetadata>
        moveProjectOperationSettings() {
      return moveProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProject. */
    public UnaryCallSettings.Builder<DeleteProjectRequest, Operation> deleteProjectSettings() {
      return deleteProjectSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteProjectRequest, Project, DeleteProjectMetadata>
        deleteProjectOperationSettings() {
      return deleteProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteProject. */
    public UnaryCallSettings.Builder<UndeleteProjectRequest, Operation> undeleteProjectSettings() {
      return undeleteProjectSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
        undeleteProjectOperationSettings() {
      return undeleteProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ProjectsStubSettings build() throws IOException {
      return new ProjectsStubSettings(this);
    }
  }
}
