/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta.stub;

import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolProvidersPagedResponse;
import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolOperationMetadata;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderOperationMetadata;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkloadIdentityPoolsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkloadIdentityPool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadIdentityPoolsStubSettings.Builder workloadIdentityPoolsSettingsBuilder =
 *     WorkloadIdentityPoolsStubSettings.newBuilder();
 * workloadIdentityPoolsSettingsBuilder
 *     .getWorkloadIdentityPoolSettings()
 *     .setRetrySettings(
 *         workloadIdentityPoolsSettingsBuilder
 *             .getWorkloadIdentityPoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkloadIdentityPoolsStubSettings workloadIdentityPoolsSettings =
 *     workloadIdentityPoolsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkloadIdentityPoolsStubSettings
    extends StubSettings<WorkloadIdentityPoolsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsSettings;
  private final UnaryCallSettings<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolSettings;
  private final UnaryCallSettings<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolSettings;
  private final OperationCallSettings<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationSettings;
  private final UnaryCallSettings<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolSettings;
  private final OperationCallSettings<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationSettings;
  private final UnaryCallSettings<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolSettings;
  private final OperationCallSettings<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationSettings;
  private final UnaryCallSettings<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolSettings;
  private final OperationCallSettings<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationSettings;
  private final PagedCallSettings<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersSettings;
  private final UnaryCallSettings<
          GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderSettings;
  private final UnaryCallSettings<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderSettings;
  private final OperationCallSettings<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationSettings;
  private final UnaryCallSettings<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderSettings;
  private final OperationCallSettings<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationSettings;
  private final UnaryCallSettings<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderSettings;
  private final OperationCallSettings<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationSettings;
  private final UnaryCallSettings<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderSettings;
  private final OperationCallSettings<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationSettings;

  private static final PagedListDescriptor<
          ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse, WorkloadIdentityPool>
      LIST_WORKLOAD_IDENTITY_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkloadIdentityPoolsRequest,
              ListWorkloadIdentityPoolsResponse,
              WorkloadIdentityPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkloadIdentityPoolsRequest injectToken(
                ListWorkloadIdentityPoolsRequest payload, String token) {
              return ListWorkloadIdentityPoolsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListWorkloadIdentityPoolsRequest injectPageSize(
                ListWorkloadIdentityPoolsRequest payload, int pageSize) {
              return ListWorkloadIdentityPoolsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListWorkloadIdentityPoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkloadIdentityPoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkloadIdentityPool> extractResources(
                ListWorkloadIdentityPoolsResponse payload) {
              return payload.getWorkloadIdentityPoolsList() == null
                  ? ImmutableList.<WorkloadIdentityPool>of()
                  : payload.getWorkloadIdentityPoolsList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          WorkloadIdentityPoolProvider>
      LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkloadIdentityPoolProvidersRequest,
              ListWorkloadIdentityPoolProvidersResponse,
              WorkloadIdentityPoolProvider>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkloadIdentityPoolProvidersRequest injectToken(
                ListWorkloadIdentityPoolProvidersRequest payload, String token) {
              return ListWorkloadIdentityPoolProvidersRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListWorkloadIdentityPoolProvidersRequest injectPageSize(
                ListWorkloadIdentityPoolProvidersRequest payload, int pageSize) {
              return ListWorkloadIdentityPoolProvidersRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListWorkloadIdentityPoolProvidersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkloadIdentityPoolProvidersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkloadIdentityPoolProvider> extractResources(
                ListWorkloadIdentityPoolProvidersResponse payload) {
              return payload.getWorkloadIdentityPoolProvidersList() == null
                  ? ImmutableList.<WorkloadIdentityPoolProvider>of()
                  : payload.getWorkloadIdentityPoolProvidersList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          ListWorkloadIdentityPoolsPagedResponse>
      LIST_WORKLOAD_IDENTITY_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkloadIdentityPoolsRequest,
              ListWorkloadIdentityPoolsResponse,
              ListWorkloadIdentityPoolsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkloadIdentityPoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
                    callable,
                ListWorkloadIdentityPoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkloadIdentityPoolsResponse> futureResponse) {
              PageContext<
                      ListWorkloadIdentityPoolsRequest,
                      ListWorkloadIdentityPoolsResponse,
                      WorkloadIdentityPool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKLOAD_IDENTITY_POOLS_PAGE_STR_DESC, request, context);
              return ListWorkloadIdentityPoolsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          ListWorkloadIdentityPoolProvidersPagedResponse>
      LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkloadIdentityPoolProvidersRequest,
              ListWorkloadIdentityPoolProvidersResponse,
              ListWorkloadIdentityPoolProvidersPagedResponse>() {
            @Override
            public ApiFuture<ListWorkloadIdentityPoolProvidersPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListWorkloadIdentityPoolProvidersRequest,
                        ListWorkloadIdentityPoolProvidersResponse>
                    callable,
                ListWorkloadIdentityPoolProvidersRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkloadIdentityPoolProvidersResponse> futureResponse) {
              PageContext<
                      ListWorkloadIdentityPoolProvidersRequest,
                      ListWorkloadIdentityPoolProvidersResponse,
                      WorkloadIdentityPoolProvider>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS_PAGE_STR_DESC,
                          request,
                          context);
              return ListWorkloadIdentityPoolProvidersPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listWorkloadIdentityPools. */
  public PagedCallSettings<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsSettings() {
    return listWorkloadIdentityPoolsSettings;
  }

  /** Returns the object with the settings used for calls to getWorkloadIdentityPool. */
  public UnaryCallSettings<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolSettings() {
    return getWorkloadIdentityPoolSettings;
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPool. */
  public UnaryCallSettings<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolSettings() {
    return createWorkloadIdentityPoolSettings;
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPool. */
  public OperationCallSettings<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationSettings() {
    return createWorkloadIdentityPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPool. */
  public UnaryCallSettings<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolSettings() {
    return updateWorkloadIdentityPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPool. */
  public OperationCallSettings<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationSettings() {
    return updateWorkloadIdentityPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPool. */
  public UnaryCallSettings<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolSettings() {
    return deleteWorkloadIdentityPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPool. */
  public OperationCallSettings<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationSettings() {
    return deleteWorkloadIdentityPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteWorkloadIdentityPool. */
  public UnaryCallSettings<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolSettings() {
    return undeleteWorkloadIdentityPoolSettings;
  }

  /** Returns the object with the settings used for calls to undeleteWorkloadIdentityPool. */
  public OperationCallSettings<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationSettings() {
    return undeleteWorkloadIdentityPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to listWorkloadIdentityPoolProviders. */
  public PagedCallSettings<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersSettings() {
    return listWorkloadIdentityPoolProvidersSettings;
  }

  /** Returns the object with the settings used for calls to getWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderSettings() {
    return getWorkloadIdentityPoolProviderSettings;
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderSettings() {
    return createWorkloadIdentityPoolProviderSettings;
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationSettings() {
    return createWorkloadIdentityPoolProviderOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderSettings() {
    return updateWorkloadIdentityPoolProviderSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationSettings() {
    return updateWorkloadIdentityPoolProviderOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderSettings() {
    return deleteWorkloadIdentityPoolProviderSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationSettings() {
    return deleteWorkloadIdentityPoolProviderOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to undeleteWorkloadIdentityPoolProvider.
   */
  public UnaryCallSettings<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderSettings() {
    return undeleteWorkloadIdentityPoolProviderSettings;
  }

  /**
   * Returns the object with the settings used for calls to undeleteWorkloadIdentityPoolProvider.
   */
  public OperationCallSettings<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationSettings() {
    return undeleteWorkloadIdentityPoolProviderOperationSettings;
  }

  public WorkloadIdentityPoolsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkloadIdentityPoolsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the endpoint set by the user or the the service's default endpoint. */
  @Override
  public String getEndpoint() {
    if (super.getEndpoint() != null) {
      return super.getEndpoint();
    }
    return getDefaultEndpoint();
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "iam";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "iam.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "iam.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(WorkloadIdentityPoolsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected WorkloadIdentityPoolsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listWorkloadIdentityPoolsSettings = settingsBuilder.listWorkloadIdentityPoolsSettings().build();
    getWorkloadIdentityPoolSettings = settingsBuilder.getWorkloadIdentityPoolSettings().build();
    createWorkloadIdentityPoolSettings =
        settingsBuilder.createWorkloadIdentityPoolSettings().build();
    createWorkloadIdentityPoolOperationSettings =
        settingsBuilder.createWorkloadIdentityPoolOperationSettings().build();
    updateWorkloadIdentityPoolSettings =
        settingsBuilder.updateWorkloadIdentityPoolSettings().build();
    updateWorkloadIdentityPoolOperationSettings =
        settingsBuilder.updateWorkloadIdentityPoolOperationSettings().build();
    deleteWorkloadIdentityPoolSettings =
        settingsBuilder.deleteWorkloadIdentityPoolSettings().build();
    deleteWorkloadIdentityPoolOperationSettings =
        settingsBuilder.deleteWorkloadIdentityPoolOperationSettings().build();
    undeleteWorkloadIdentityPoolSettings =
        settingsBuilder.undeleteWorkloadIdentityPoolSettings().build();
    undeleteWorkloadIdentityPoolOperationSettings =
        settingsBuilder.undeleteWorkloadIdentityPoolOperationSettings().build();
    listWorkloadIdentityPoolProvidersSettings =
        settingsBuilder.listWorkloadIdentityPoolProvidersSettings().build();
    getWorkloadIdentityPoolProviderSettings =
        settingsBuilder.getWorkloadIdentityPoolProviderSettings().build();
    createWorkloadIdentityPoolProviderSettings =
        settingsBuilder.createWorkloadIdentityPoolProviderSettings().build();
    createWorkloadIdentityPoolProviderOperationSettings =
        settingsBuilder.createWorkloadIdentityPoolProviderOperationSettings().build();
    updateWorkloadIdentityPoolProviderSettings =
        settingsBuilder.updateWorkloadIdentityPoolProviderSettings().build();
    updateWorkloadIdentityPoolProviderOperationSettings =
        settingsBuilder.updateWorkloadIdentityPoolProviderOperationSettings().build();
    deleteWorkloadIdentityPoolProviderSettings =
        settingsBuilder.deleteWorkloadIdentityPoolProviderSettings().build();
    deleteWorkloadIdentityPoolProviderOperationSettings =
        settingsBuilder.deleteWorkloadIdentityPoolProviderOperationSettings().build();
    undeleteWorkloadIdentityPoolProviderSettings =
        settingsBuilder.undeleteWorkloadIdentityPoolProviderSettings().build();
    undeleteWorkloadIdentityPoolProviderOperationSettings =
        settingsBuilder.undeleteWorkloadIdentityPoolProviderOperationSettings().build();
  }

  /** Builder for WorkloadIdentityPoolsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<WorkloadIdentityPoolsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListWorkloadIdentityPoolsRequest,
            ListWorkloadIdentityPoolsResponse,
            ListWorkloadIdentityPoolsPagedResponse>
        listWorkloadIdentityPoolsSettings;
    private final UnaryCallSettings.Builder<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
        getWorkloadIdentityPoolSettings;
    private final UnaryCallSettings.Builder<CreateWorkloadIdentityPoolRequest, Operation>
        createWorkloadIdentityPoolSettings;
    private final OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        createWorkloadIdentityPoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolRequest, Operation>
        updateWorkloadIdentityPoolSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        updateWorkloadIdentityPoolOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolRequest, Operation>
        deleteWorkloadIdentityPoolSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        deleteWorkloadIdentityPoolOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolRequest, Operation>
        undeleteWorkloadIdentityPoolSettings;
    private final OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        undeleteWorkloadIdentityPoolOperationSettings;
    private final PagedCallSettings.Builder<
            ListWorkloadIdentityPoolProvidersRequest,
            ListWorkloadIdentityPoolProvidersResponse,
            ListWorkloadIdentityPoolProvidersPagedResponse>
        listWorkloadIdentityPoolProvidersSettings;
    private final UnaryCallSettings.Builder<
            GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
        getWorkloadIdentityPoolProviderSettings;
    private final UnaryCallSettings.Builder<CreateWorkloadIdentityPoolProviderRequest, Operation>
        createWorkloadIdentityPoolProviderSettings;
    private final OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        createWorkloadIdentityPoolProviderOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolProviderRequest, Operation>
        updateWorkloadIdentityPoolProviderSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        updateWorkloadIdentityPoolProviderOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolProviderRequest, Operation>
        deleteWorkloadIdentityPoolProviderSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        deleteWorkloadIdentityPoolProviderOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
        undeleteWorkloadIdentityPoolProviderSettings;
    private final OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        undeleteWorkloadIdentityPoolProviderOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listWorkloadIdentityPoolsSettings =
          PagedCallSettings.newBuilder(LIST_WORKLOAD_IDENTITY_POOLS_PAGE_STR_FACT);
      getWorkloadIdentityPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadIdentityPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadIdentityPoolOperationSettings = OperationCallSettings.newBuilder();
      updateWorkloadIdentityPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkloadIdentityPoolOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkloadIdentityPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkloadIdentityPoolOperationSettings = OperationCallSettings.newBuilder();
      undeleteWorkloadIdentityPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteWorkloadIdentityPoolOperationSettings = OperationCallSettings.newBuilder();
      listWorkloadIdentityPoolProvidersSettings =
          PagedCallSettings.newBuilder(LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS_PAGE_STR_FACT);
      getWorkloadIdentityPoolProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadIdentityPoolProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadIdentityPoolProviderOperationSettings = OperationCallSettings.newBuilder();
      updateWorkloadIdentityPoolProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkloadIdentityPoolProviderOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkloadIdentityPoolProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkloadIdentityPoolProviderOperationSettings = OperationCallSettings.newBuilder();
      undeleteWorkloadIdentityPoolProviderSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteWorkloadIdentityPoolProviderOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listWorkloadIdentityPoolsSettings,
              getWorkloadIdentityPoolSettings,
              createWorkloadIdentityPoolSettings,
              updateWorkloadIdentityPoolSettings,
              deleteWorkloadIdentityPoolSettings,
              undeleteWorkloadIdentityPoolSettings,
              listWorkloadIdentityPoolProvidersSettings,
              getWorkloadIdentityPoolProviderSettings,
              createWorkloadIdentityPoolProviderSettings,
              updateWorkloadIdentityPoolProviderSettings,
              deleteWorkloadIdentityPoolProviderSettings,
              undeleteWorkloadIdentityPoolProviderSettings);
      initDefaults(this);
    }

    protected Builder(WorkloadIdentityPoolsStubSettings settings) {
      super(settings);

      listWorkloadIdentityPoolsSettings = settings.listWorkloadIdentityPoolsSettings.toBuilder();
      getWorkloadIdentityPoolSettings = settings.getWorkloadIdentityPoolSettings.toBuilder();
      createWorkloadIdentityPoolSettings = settings.createWorkloadIdentityPoolSettings.toBuilder();
      createWorkloadIdentityPoolOperationSettings =
          settings.createWorkloadIdentityPoolOperationSettings.toBuilder();
      updateWorkloadIdentityPoolSettings = settings.updateWorkloadIdentityPoolSettings.toBuilder();
      updateWorkloadIdentityPoolOperationSettings =
          settings.updateWorkloadIdentityPoolOperationSettings.toBuilder();
      deleteWorkloadIdentityPoolSettings = settings.deleteWorkloadIdentityPoolSettings.toBuilder();
      deleteWorkloadIdentityPoolOperationSettings =
          settings.deleteWorkloadIdentityPoolOperationSettings.toBuilder();
      undeleteWorkloadIdentityPoolSettings =
          settings.undeleteWorkloadIdentityPoolSettings.toBuilder();
      undeleteWorkloadIdentityPoolOperationSettings =
          settings.undeleteWorkloadIdentityPoolOperationSettings.toBuilder();
      listWorkloadIdentityPoolProvidersSettings =
          settings.listWorkloadIdentityPoolProvidersSettings.toBuilder();
      getWorkloadIdentityPoolProviderSettings =
          settings.getWorkloadIdentityPoolProviderSettings.toBuilder();
      createWorkloadIdentityPoolProviderSettings =
          settings.createWorkloadIdentityPoolProviderSettings.toBuilder();
      createWorkloadIdentityPoolProviderOperationSettings =
          settings.createWorkloadIdentityPoolProviderOperationSettings.toBuilder();
      updateWorkloadIdentityPoolProviderSettings =
          settings.updateWorkloadIdentityPoolProviderSettings.toBuilder();
      updateWorkloadIdentityPoolProviderOperationSettings =
          settings.updateWorkloadIdentityPoolProviderOperationSettings.toBuilder();
      deleteWorkloadIdentityPoolProviderSettings =
          settings.deleteWorkloadIdentityPoolProviderSettings.toBuilder();
      deleteWorkloadIdentityPoolProviderOperationSettings =
          settings.deleteWorkloadIdentityPoolProviderOperationSettings.toBuilder();
      undeleteWorkloadIdentityPoolProviderSettings =
          settings.undeleteWorkloadIdentityPoolProviderSettings.toBuilder();
      undeleteWorkloadIdentityPoolProviderOperationSettings =
          settings.undeleteWorkloadIdentityPoolProviderOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listWorkloadIdentityPoolsSettings,
              getWorkloadIdentityPoolSettings,
              createWorkloadIdentityPoolSettings,
              updateWorkloadIdentityPoolSettings,
              deleteWorkloadIdentityPoolSettings,
              undeleteWorkloadIdentityPoolSettings,
              listWorkloadIdentityPoolProvidersSettings,
              getWorkloadIdentityPoolProviderSettings,
              createWorkloadIdentityPoolProviderSettings,
              updateWorkloadIdentityPoolProviderSettings,
              deleteWorkloadIdentityPoolProviderSettings,
              undeleteWorkloadIdentityPoolProviderSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listWorkloadIdentityPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getWorkloadIdentityPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkloadIdentityPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateWorkloadIdentityPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteWorkloadIdentityPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteWorkloadIdentityPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkloadIdentityPoolProvidersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getWorkloadIdentityPoolProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkloadIdentityPoolProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateWorkloadIdentityPoolProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteWorkloadIdentityPoolProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteWorkloadIdentityPoolProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkloadIdentityPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkloadIdentityPoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkloadIdentityPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolOperationMetadata.class))
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
          .updateWorkloadIdentityPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkloadIdentityPoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkloadIdentityPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolOperationMetadata.class))
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
          .deleteWorkloadIdentityPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkloadIdentityPoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkloadIdentityPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolOperationMetadata.class))
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
          .undeleteWorkloadIdentityPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteWorkloadIdentityPoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkloadIdentityPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolOperationMetadata.class))
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
          .createWorkloadIdentityPoolProviderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkloadIdentityPoolProviderRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  WorkloadIdentityPoolProvider.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolProviderOperationMetadata.class))
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
          .updateWorkloadIdentityPoolProviderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkloadIdentityPoolProviderRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  WorkloadIdentityPoolProvider.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolProviderOperationMetadata.class))
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
          .deleteWorkloadIdentityPoolProviderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkloadIdentityPoolProviderRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  WorkloadIdentityPoolProvider.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolProviderOperationMetadata.class))
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
          .undeleteWorkloadIdentityPoolProviderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteWorkloadIdentityPoolProviderRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  WorkloadIdentityPoolProvider.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  WorkloadIdentityPoolProviderOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listWorkloadIdentityPools. */
    public PagedCallSettings.Builder<
            ListWorkloadIdentityPoolsRequest,
            ListWorkloadIdentityPoolsResponse,
            ListWorkloadIdentityPoolsPagedResponse>
        listWorkloadIdentityPoolsSettings() {
      return listWorkloadIdentityPoolsSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
        getWorkloadIdentityPoolSettings() {
      return getWorkloadIdentityPoolSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<CreateWorkloadIdentityPoolRequest, Operation>
        createWorkloadIdentityPoolSettings() {
      return createWorkloadIdentityPoolSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        createWorkloadIdentityPoolOperationSettings() {
      return createWorkloadIdentityPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolRequest, Operation>
        updateWorkloadIdentityPoolSettings() {
      return updateWorkloadIdentityPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        updateWorkloadIdentityPoolOperationSettings() {
      return updateWorkloadIdentityPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolRequest, Operation>
        deleteWorkloadIdentityPoolSettings() {
      return deleteWorkloadIdentityPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        deleteWorkloadIdentityPoolOperationSettings() {
      return deleteWorkloadIdentityPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolRequest, Operation>
        undeleteWorkloadIdentityPoolSettings() {
      return undeleteWorkloadIdentityPoolSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        undeleteWorkloadIdentityPoolOperationSettings() {
      return undeleteWorkloadIdentityPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkloadIdentityPoolProviders. */
    public PagedCallSettings.Builder<
            ListWorkloadIdentityPoolProvidersRequest,
            ListWorkloadIdentityPoolProvidersResponse,
            ListWorkloadIdentityPoolProvidersPagedResponse>
        listWorkloadIdentityPoolProvidersSettings() {
      return listWorkloadIdentityPoolProvidersSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkloadIdentityPoolProvider. */
    public UnaryCallSettings.Builder<
            GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
        getWorkloadIdentityPoolProviderSettings() {
      return getWorkloadIdentityPoolProviderSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<CreateWorkloadIdentityPoolProviderRequest, Operation>
        createWorkloadIdentityPoolProviderSettings() {
      return createWorkloadIdentityPoolProviderSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        createWorkloadIdentityPoolProviderOperationSettings() {
      return createWorkloadIdentityPoolProviderOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolProviderRequest, Operation>
        updateWorkloadIdentityPoolProviderSettings() {
      return updateWorkloadIdentityPoolProviderSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        updateWorkloadIdentityPoolProviderOperationSettings() {
      return updateWorkloadIdentityPoolProviderOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolProviderRequest, Operation>
        deleteWorkloadIdentityPoolProviderSettings() {
      return deleteWorkloadIdentityPoolProviderSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        deleteWorkloadIdentityPoolProviderOperationSettings() {
      return deleteWorkloadIdentityPoolProviderOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to undeleteWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
        undeleteWorkloadIdentityPoolProviderSettings() {
      return undeleteWorkloadIdentityPoolProviderSettings;
    }

    /**
     * Returns the builder for the settings used for calls to undeleteWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        undeleteWorkloadIdentityPoolProviderOperationSettings() {
      return undeleteWorkloadIdentityPoolProviderOperationSettings;
    }

    /** Returns the endpoint set by the user or the the service's default endpoint. */
    @Override
    public String getEndpoint() {
      if (super.getEndpoint() != null) {
        return super.getEndpoint();
      }
      return getDefaultEndpoint();
    }

    @Override
    public WorkloadIdentityPoolsStubSettings build() throws IOException {
      return new WorkloadIdentityPoolsStubSettings(this);
    }
  }
}
