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

import static com.google.cloud.resourcemanager.v3.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v3.FoldersClient.SearchFoldersPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateFolderMetadata;
import com.google.cloud.resourcemanager.v3.CreateFolderRequest;
import com.google.cloud.resourcemanager.v3.DeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.DeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.Folder;
import com.google.cloud.resourcemanager.v3.GetFolderRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersResponse;
import com.google.cloud.resourcemanager.v3.MoveFolderMetadata;
import com.google.cloud.resourcemanager.v3.MoveFolderRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersResponse;
import com.google.cloud.resourcemanager.v3.UndeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.UpdateFolderMetadata;
import com.google.cloud.resourcemanager.v3.UpdateFolderRequest;
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
 * Settings class to configure an instance of {@link FoldersStub}.
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
 * <p>For example, to set the total timeout of getFolder to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FoldersStubSettings.Builder foldersSettingsBuilder = FoldersStubSettings.newBuilder();
 * foldersSettingsBuilder
 *     .getFolderSettings()
 *     .setRetrySettings(
 *         foldersSettingsBuilder.getFolderSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FoldersStubSettings foldersSettings = foldersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FoldersStubSettings extends StubSettings<FoldersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings;
  private final PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings;
  private final PagedCallSettings<
          SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      searchFoldersSettings;
  private final UnaryCallSettings<CreateFolderRequest, Operation> createFolderSettings;
  private final OperationCallSettings<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationSettings;
  private final UnaryCallSettings<UpdateFolderRequest, Operation> updateFolderSettings;
  private final OperationCallSettings<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationSettings;
  private final UnaryCallSettings<MoveFolderRequest, Operation> moveFolderSettings;
  private final OperationCallSettings<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationSettings;
  private final UnaryCallSettings<DeleteFolderRequest, Operation> deleteFolderSettings;
  private final OperationCallSettings<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationSettings;
  private final UnaryCallSettings<UndeleteFolderRequest, Operation> undeleteFolderSettings;
  private final OperationCallSettings<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>
      LIST_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFoldersRequest injectToken(ListFoldersRequest payload, String token) {
              return ListFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFoldersRequest injectPageSize(ListFoldersRequest payload, int pageSize) {
              return ListFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Folder> extractResources(ListFoldersResponse payload) {
              return payload.getFoldersList() == null
                  ? ImmutableList.<Folder>of()
                  : payload.getFoldersList();
            }
          };

  private static final PagedListDescriptor<SearchFoldersRequest, SearchFoldersResponse, Folder>
      SEARCH_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchFoldersRequest, SearchFoldersResponse, Folder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchFoldersRequest injectToken(SearchFoldersRequest payload, String token) {
              return SearchFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchFoldersRequest injectPageSize(SearchFoldersRequest payload, int pageSize) {
              return SearchFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Folder> extractResources(SearchFoldersResponse payload) {
              return payload.getFoldersList() == null
                  ? ImmutableList.<Folder>of()
                  : payload.getFoldersList();
            }
          };

  private static final PagedListResponseFactory<
          ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      LIST_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>() {
            @Override
            public ApiFuture<ListFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFoldersRequest, ListFoldersResponse> callable,
                ListFoldersRequest request,
                ApiCallContext context,
                ApiFuture<ListFoldersResponse> futureResponse) {
              PageContext<ListFoldersRequest, ListFoldersResponse, Folder> pageContext =
                  PageContext.create(callable, LIST_FOLDERS_PAGE_STR_DESC, request, context);
              return ListFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      SEARCH_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>() {
            @Override
            public ApiFuture<SearchFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> callable,
                SearchFoldersRequest request,
                ApiCallContext context,
                ApiFuture<SearchFoldersResponse> futureResponse) {
              PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> pageContext =
                  PageContext.create(callable, SEARCH_FOLDERS_PAGE_STR_DESC, request, context);
              return SearchFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getFolder. */
  public UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings() {
    return getFolderSettings;
  }

  /** Returns the object with the settings used for calls to listFolders. */
  public PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings() {
    return listFoldersSettings;
  }

  /** Returns the object with the settings used for calls to searchFolders. */
  public PagedCallSettings<SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      searchFoldersSettings() {
    return searchFoldersSettings;
  }

  /** Returns the object with the settings used for calls to createFolder. */
  public UnaryCallSettings<CreateFolderRequest, Operation> createFolderSettings() {
    return createFolderSettings;
  }

  /** Returns the object with the settings used for calls to createFolder. */
  public OperationCallSettings<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationSettings() {
    return createFolderOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFolder. */
  public UnaryCallSettings<UpdateFolderRequest, Operation> updateFolderSettings() {
    return updateFolderSettings;
  }

  /** Returns the object with the settings used for calls to updateFolder. */
  public OperationCallSettings<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationSettings() {
    return updateFolderOperationSettings;
  }

  /** Returns the object with the settings used for calls to moveFolder. */
  public UnaryCallSettings<MoveFolderRequest, Operation> moveFolderSettings() {
    return moveFolderSettings;
  }

  /** Returns the object with the settings used for calls to moveFolder. */
  public OperationCallSettings<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationSettings() {
    return moveFolderOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public UnaryCallSettings<DeleteFolderRequest, Operation> deleteFolderSettings() {
    return deleteFolderSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public OperationCallSettings<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationSettings() {
    return deleteFolderOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteFolder. */
  public UnaryCallSettings<UndeleteFolderRequest, Operation> undeleteFolderSettings() {
    return undeleteFolderSettings;
  }

  /** Returns the object with the settings used for calls to undeleteFolder. */
  public OperationCallSettings<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationSettings() {
    return undeleteFolderOperationSettings;
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

  public FoldersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFoldersStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFoldersStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FoldersStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FoldersStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FoldersStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FoldersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getFolderSettings = settingsBuilder.getFolderSettings().build();
    listFoldersSettings = settingsBuilder.listFoldersSettings().build();
    searchFoldersSettings = settingsBuilder.searchFoldersSettings().build();
    createFolderSettings = settingsBuilder.createFolderSettings().build();
    createFolderOperationSettings = settingsBuilder.createFolderOperationSettings().build();
    updateFolderSettings = settingsBuilder.updateFolderSettings().build();
    updateFolderOperationSettings = settingsBuilder.updateFolderOperationSettings().build();
    moveFolderSettings = settingsBuilder.moveFolderSettings().build();
    moveFolderOperationSettings = settingsBuilder.moveFolderOperationSettings().build();
    deleteFolderSettings = settingsBuilder.deleteFolderSettings().build();
    deleteFolderOperationSettings = settingsBuilder.deleteFolderOperationSettings().build();
    undeleteFolderSettings = settingsBuilder.undeleteFolderSettings().build();
    undeleteFolderOperationSettings = settingsBuilder.undeleteFolderOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for FoldersStubSettings. */
  public static class Builder extends StubSettings.Builder<FoldersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings;
    private final PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings;
    private final PagedCallSettings.Builder<
            SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
        searchFoldersSettings;
    private final UnaryCallSettings.Builder<CreateFolderRequest, Operation> createFolderSettings;
    private final OperationCallSettings.Builder<CreateFolderRequest, Folder, CreateFolderMetadata>
        createFolderOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFolderRequest, Operation> updateFolderSettings;
    private final OperationCallSettings.Builder<UpdateFolderRequest, Folder, UpdateFolderMetadata>
        updateFolderOperationSettings;
    private final UnaryCallSettings.Builder<MoveFolderRequest, Operation> moveFolderSettings;
    private final OperationCallSettings.Builder<MoveFolderRequest, Folder, MoveFolderMetadata>
        moveFolderOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFolderRequest, Operation> deleteFolderSettings;
    private final OperationCallSettings.Builder<DeleteFolderRequest, Folder, DeleteFolderMetadata>
        deleteFolderOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteFolderRequest, Operation>
        undeleteFolderSettings;
    private final OperationCallSettings.Builder<
            UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
        undeleteFolderOperationSettings;
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

      getFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFoldersSettings = PagedCallSettings.newBuilder(LIST_FOLDERS_PAGE_STR_FACT);
      searchFoldersSettings = PagedCallSettings.newBuilder(SEARCH_FOLDERS_PAGE_STR_FACT);
      createFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFolderOperationSettings = OperationCallSettings.newBuilder();
      updateFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFolderOperationSettings = OperationCallSettings.newBuilder();
      moveFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveFolderOperationSettings = OperationCallSettings.newBuilder();
      deleteFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFolderOperationSettings = OperationCallSettings.newBuilder();
      undeleteFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteFolderOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFolderSettings,
              listFoldersSettings,
              searchFoldersSettings,
              createFolderSettings,
              updateFolderSettings,
              moveFolderSettings,
              deleteFolderSettings,
              undeleteFolderSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FoldersStubSettings settings) {
      super(settings);

      getFolderSettings = settings.getFolderSettings.toBuilder();
      listFoldersSettings = settings.listFoldersSettings.toBuilder();
      searchFoldersSettings = settings.searchFoldersSettings.toBuilder();
      createFolderSettings = settings.createFolderSettings.toBuilder();
      createFolderOperationSettings = settings.createFolderOperationSettings.toBuilder();
      updateFolderSettings = settings.updateFolderSettings.toBuilder();
      updateFolderOperationSettings = settings.updateFolderOperationSettings.toBuilder();
      moveFolderSettings = settings.moveFolderSettings.toBuilder();
      moveFolderOperationSettings = settings.moveFolderOperationSettings.toBuilder();
      deleteFolderSettings = settings.deleteFolderSettings.toBuilder();
      deleteFolderOperationSettings = settings.deleteFolderOperationSettings.toBuilder();
      undeleteFolderSettings = settings.undeleteFolderSettings.toBuilder();
      undeleteFolderOperationSettings = settings.undeleteFolderOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFolderSettings,
              listFoldersSettings,
              searchFoldersSettings,
              createFolderSettings,
              updateFolderSettings,
              moveFolderSettings,
              deleteFolderSettings,
              undeleteFolderSettings,
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
          .getFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .moveFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .undeleteFolderSettings()
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
          .createFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateFolderMetadata.class))
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
          .updateFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateFolderMetadata.class))
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
          .moveFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<MoveFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(MoveFolderMetadata.class))
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
          .deleteFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteFolderMetadata.class))
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
          .undeleteFolderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteFolderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Folder.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UndeleteFolderMetadata.class))
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

    /** Returns the builder for the settings used for calls to getFolder. */
    public UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings() {
      return getFolderSettings;
    }

    /** Returns the builder for the settings used for calls to listFolders. */
    public PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings() {
      return listFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to searchFolders. */
    public PagedCallSettings.Builder<
            SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
        searchFoldersSettings() {
      return searchFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to createFolder. */
    public UnaryCallSettings.Builder<CreateFolderRequest, Operation> createFolderSettings() {
      return createFolderSettings;
    }

    /** Returns the builder for the settings used for calls to createFolder. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateFolderRequest, Folder, CreateFolderMetadata>
        createFolderOperationSettings() {
      return createFolderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFolder. */
    public UnaryCallSettings.Builder<UpdateFolderRequest, Operation> updateFolderSettings() {
      return updateFolderSettings;
    }

    /** Returns the builder for the settings used for calls to updateFolder. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateFolderRequest, Folder, UpdateFolderMetadata>
        updateFolderOperationSettings() {
      return updateFolderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to moveFolder. */
    public UnaryCallSettings.Builder<MoveFolderRequest, Operation> moveFolderSettings() {
      return moveFolderSettings;
    }

    /** Returns the builder for the settings used for calls to moveFolder. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<MoveFolderRequest, Folder, MoveFolderMetadata>
        moveFolderOperationSettings() {
      return moveFolderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public UnaryCallSettings.Builder<DeleteFolderRequest, Operation> deleteFolderSettings() {
      return deleteFolderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFolderRequest, Folder, DeleteFolderMetadata>
        deleteFolderOperationSettings() {
      return deleteFolderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteFolder. */
    public UnaryCallSettings.Builder<UndeleteFolderRequest, Operation> undeleteFolderSettings() {
      return undeleteFolderSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteFolder. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
        undeleteFolderOperationSettings() {
      return undeleteFolderOperationSettings;
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
    public FoldersStubSettings build() throws IOException {
      return new FoldersStubSettings(this);
    }
  }
}
