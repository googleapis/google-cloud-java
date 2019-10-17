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
package com.google.cloud.devtools.cloudbuild.v1.stub;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
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
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link CloudBuildStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbuild.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createBuild to 30 seconds:
 *
 * <pre>
 * <code>
 * CloudBuildStubSettings.Builder cloudBuildSettingsBuilder =
 *     CloudBuildStubSettings.newBuilder();
 * cloudBuildSettingsBuilder.createBuildSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * CloudBuildStubSettings cloudBuildSettings = cloudBuildSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class CloudBuildStubSettings extends StubSettings<CloudBuildStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateBuildRequest, Operation> createBuildSettings;
  private final UnaryCallSettings<GetBuildRequest, Build> getBuildSettings;
  private final PagedCallSettings<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      listBuildsSettings;
  private final UnaryCallSettings<CancelBuildRequest, Build> cancelBuildSettings;
  private final UnaryCallSettings<CreateBuildTriggerRequest, BuildTrigger>
      createBuildTriggerSettings;
  private final UnaryCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerSettings;
  private final UnaryCallSettings<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersSettings;
  private final UnaryCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerSettings;
  private final UnaryCallSettings<UpdateBuildTriggerRequest, BuildTrigger>
      updateBuildTriggerSettings;
  private final UnaryCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerSettings;
  private final UnaryCallSettings<RetryBuildRequest, Operation> retryBuildSettings;
  private final UnaryCallSettings<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolSettings;
  private final UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
  private final UnaryCallSettings<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolSettings;
  private final UnaryCallSettings<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolSettings;
  private final UnaryCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsSettings;

  /** Returns the object with the settings used for calls to createBuild. */
  public UnaryCallSettings<CreateBuildRequest, Operation> createBuildSettings() {
    return createBuildSettings;
  }

  /** Returns the object with the settings used for calls to getBuild. */
  public UnaryCallSettings<GetBuildRequest, Build> getBuildSettings() {
    return getBuildSettings;
  }

  /** Returns the object with the settings used for calls to listBuilds. */
  public PagedCallSettings<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      listBuildsSettings() {
    return listBuildsSettings;
  }

  /** Returns the object with the settings used for calls to cancelBuild. */
  public UnaryCallSettings<CancelBuildRequest, Build> cancelBuildSettings() {
    return cancelBuildSettings;
  }

  /** Returns the object with the settings used for calls to createBuildTrigger. */
  public UnaryCallSettings<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerSettings() {
    return createBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to getBuildTrigger. */
  public UnaryCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerSettings() {
    return getBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to listBuildTriggers. */
  public UnaryCallSettings<ListBuildTriggersRequest, ListBuildTriggersResponse>
      listBuildTriggersSettings() {
    return listBuildTriggersSettings;
  }

  /** Returns the object with the settings used for calls to deleteBuildTrigger. */
  public UnaryCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerSettings() {
    return deleteBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to updateBuildTrigger. */
  public UnaryCallSettings<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerSettings() {
    return updateBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to runBuildTrigger. */
  public UnaryCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
    return runBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to retryBuild. */
  public UnaryCallSettings<RetryBuildRequest, Operation> retryBuildSettings() {
    return retryBuildSettings;
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public UnaryCallSettings<CreateWorkerPoolRequest, WorkerPool> createWorkerPoolSettings() {
    return createWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to getWorkerPool. */
  public UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
    return getWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public UnaryCallSettings<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolSettings() {
    return deleteWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public UnaryCallSettings<UpdateWorkerPoolRequest, WorkerPool> updateWorkerPoolSettings() {
    return updateWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to listWorkerPools. */
  public UnaryCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsSettings() {
    return listWorkerPoolsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudBuildStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudBuildStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudbuild.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudBuildStubSettings.class))
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

  protected CloudBuildStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createBuildSettings = settingsBuilder.createBuildSettings().build();
    getBuildSettings = settingsBuilder.getBuildSettings().build();
    listBuildsSettings = settingsBuilder.listBuildsSettings().build();
    cancelBuildSettings = settingsBuilder.cancelBuildSettings().build();
    createBuildTriggerSettings = settingsBuilder.createBuildTriggerSettings().build();
    getBuildTriggerSettings = settingsBuilder.getBuildTriggerSettings().build();
    listBuildTriggersSettings = settingsBuilder.listBuildTriggersSettings().build();
    deleteBuildTriggerSettings = settingsBuilder.deleteBuildTriggerSettings().build();
    updateBuildTriggerSettings = settingsBuilder.updateBuildTriggerSettings().build();
    runBuildTriggerSettings = settingsBuilder.runBuildTriggerSettings().build();
    retryBuildSettings = settingsBuilder.retryBuildSettings().build();
    createWorkerPoolSettings = settingsBuilder.createWorkerPoolSettings().build();
    getWorkerPoolSettings = settingsBuilder.getWorkerPoolSettings().build();
    deleteWorkerPoolSettings = settingsBuilder.deleteWorkerPoolSettings().build();
    updateWorkerPoolSettings = settingsBuilder.updateWorkerPoolSettings().build();
    listWorkerPoolsSettings = settingsBuilder.listWorkerPoolsSettings().build();
  }

  private static final PagedListDescriptor<ListBuildsRequest, ListBuildsResponse, Build>
      LIST_BUILDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBuildsRequest, ListBuildsResponse, Build>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBuildsRequest injectToken(ListBuildsRequest payload, String token) {
              return ListBuildsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBuildsRequest injectPageSize(ListBuildsRequest payload, int pageSize) {
              return ListBuildsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBuildsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBuildsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Build> extractResources(ListBuildsResponse payload) {
              return payload.getBuildsList() != null
                  ? payload.getBuildsList()
                  : ImmutableList.<Build>of();
            }
          };

  private static final PagedListResponseFactory<
          ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      LIST_BUILDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>() {
            @Override
            public ApiFuture<ListBuildsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBuildsRequest, ListBuildsResponse> callable,
                ListBuildsRequest request,
                ApiCallContext context,
                ApiFuture<ListBuildsResponse> futureResponse) {
              PageContext<ListBuildsRequest, ListBuildsResponse, Build> pageContext =
                  PageContext.create(callable, LIST_BUILDS_PAGE_STR_DESC, request, context);
              return ListBuildsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for CloudBuildStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudBuildStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateBuildRequest, Operation> createBuildSettings;
    private final UnaryCallSettings.Builder<GetBuildRequest, Build> getBuildSettings;
    private final PagedCallSettings.Builder<
            ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
        listBuildsSettings;
    private final UnaryCallSettings.Builder<CancelBuildRequest, Build> cancelBuildSettings;
    private final UnaryCallSettings.Builder<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerSettings;
    private final UnaryCallSettings.Builder<GetBuildTriggerRequest, BuildTrigger>
        getBuildTriggerSettings;
    private final UnaryCallSettings.Builder<ListBuildTriggersRequest, ListBuildTriggersResponse>
        listBuildTriggersSettings;
    private final UnaryCallSettings.Builder<DeleteBuildTriggerRequest, Empty>
        deleteBuildTriggerSettings;
    private final UnaryCallSettings.Builder<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerSettings;
    private final UnaryCallSettings.Builder<RunBuildTriggerRequest, Operation>
        runBuildTriggerSettings;
    private final UnaryCallSettings.Builder<RetryBuildRequest, Operation> retryBuildSettings;
    private final UnaryCallSettings.Builder<CreateWorkerPoolRequest, WorkerPool>
        createWorkerPoolSettings;
    private final UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
    private final UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Empty>
        deleteWorkerPoolSettings;
    private final UnaryCallSettings.Builder<UpdateWorkerPoolRequest, WorkerPool>
        updateWorkerPoolSettings;
    private final UnaryCallSettings.Builder<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listBuildsSettings = PagedCallSettings.newBuilder(LIST_BUILDS_PAGE_STR_FACT);

      cancelBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listBuildTriggersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      runBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      retryBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listWorkerPoolsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBuildSettings,
              getBuildSettings,
              listBuildsSettings,
              cancelBuildSettings,
              createBuildTriggerSettings,
              getBuildTriggerSettings,
              listBuildTriggersSettings,
              deleteBuildTriggerSettings,
              updateBuildTriggerSettings,
              runBuildTriggerSettings,
              retryBuildSettings,
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              deleteWorkerPoolSettings,
              updateWorkerPoolSettings,
              listWorkerPoolsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .createBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listBuildsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listBuildTriggersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .runBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .retryBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listWorkerPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(CloudBuildStubSettings settings) {
      super(settings);

      createBuildSettings = settings.createBuildSettings.toBuilder();
      getBuildSettings = settings.getBuildSettings.toBuilder();
      listBuildsSettings = settings.listBuildsSettings.toBuilder();
      cancelBuildSettings = settings.cancelBuildSettings.toBuilder();
      createBuildTriggerSettings = settings.createBuildTriggerSettings.toBuilder();
      getBuildTriggerSettings = settings.getBuildTriggerSettings.toBuilder();
      listBuildTriggersSettings = settings.listBuildTriggersSettings.toBuilder();
      deleteBuildTriggerSettings = settings.deleteBuildTriggerSettings.toBuilder();
      updateBuildTriggerSettings = settings.updateBuildTriggerSettings.toBuilder();
      runBuildTriggerSettings = settings.runBuildTriggerSettings.toBuilder();
      retryBuildSettings = settings.retryBuildSettings.toBuilder();
      createWorkerPoolSettings = settings.createWorkerPoolSettings.toBuilder();
      getWorkerPoolSettings = settings.getWorkerPoolSettings.toBuilder();
      deleteWorkerPoolSettings = settings.deleteWorkerPoolSettings.toBuilder();
      updateWorkerPoolSettings = settings.updateWorkerPoolSettings.toBuilder();
      listWorkerPoolsSettings = settings.listWorkerPoolsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBuildSettings,
              getBuildSettings,
              listBuildsSettings,
              cancelBuildSettings,
              createBuildTriggerSettings,
              getBuildTriggerSettings,
              listBuildTriggersSettings,
              deleteBuildTriggerSettings,
              updateBuildTriggerSettings,
              runBuildTriggerSettings,
              retryBuildSettings,
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              deleteWorkerPoolSettings,
              updateWorkerPoolSettings,
              listWorkerPoolsSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createBuild. */
    public UnaryCallSettings.Builder<CreateBuildRequest, Operation> createBuildSettings() {
      return createBuildSettings;
    }

    /** Returns the builder for the settings used for calls to getBuild. */
    public UnaryCallSettings.Builder<GetBuildRequest, Build> getBuildSettings() {
      return getBuildSettings;
    }

    /** Returns the builder for the settings used for calls to listBuilds. */
    public PagedCallSettings.Builder<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
        listBuildsSettings() {
      return listBuildsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelBuild. */
    public UnaryCallSettings.Builder<CancelBuildRequest, Build> cancelBuildSettings() {
      return cancelBuildSettings;
    }

    /** Returns the builder for the settings used for calls to createBuildTrigger. */
    public UnaryCallSettings.Builder<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerSettings() {
      return createBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to getBuildTrigger. */
    public UnaryCallSettings.Builder<GetBuildTriggerRequest, BuildTrigger>
        getBuildTriggerSettings() {
      return getBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to listBuildTriggers. */
    public UnaryCallSettings.Builder<ListBuildTriggersRequest, ListBuildTriggersResponse>
        listBuildTriggersSettings() {
      return listBuildTriggersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBuildTrigger. */
    public UnaryCallSettings.Builder<DeleteBuildTriggerRequest, Empty>
        deleteBuildTriggerSettings() {
      return deleteBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to updateBuildTrigger. */
    public UnaryCallSettings.Builder<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerSettings() {
      return updateBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to runBuildTrigger. */
    public UnaryCallSettings.Builder<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
      return runBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to retryBuild. */
    public UnaryCallSettings.Builder<RetryBuildRequest, Operation> retryBuildSettings() {
      return retryBuildSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public UnaryCallSettings.Builder<CreateWorkerPoolRequest, WorkerPool>
        createWorkerPoolSettings() {
      return createWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkerPool. */
    public UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
      return getWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Empty> deleteWorkerPoolSettings() {
      return deleteWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public UnaryCallSettings.Builder<UpdateWorkerPoolRequest, WorkerPool>
        updateWorkerPoolSettings() {
      return updateWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkerPools. */
    public UnaryCallSettings.Builder<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsSettings() {
      return listWorkerPoolsSettings;
    }

    @Override
    public CloudBuildStubSettings build() throws IOException {
      return new CloudBuildStubSettings(this);
    }
  }
}
