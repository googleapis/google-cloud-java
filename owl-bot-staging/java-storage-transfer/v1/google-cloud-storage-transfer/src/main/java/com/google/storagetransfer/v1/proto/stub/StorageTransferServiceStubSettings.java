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

package com.google.storagetransfer.v1.proto.stub;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.TransferProto;
import com.google.storagetransfer.v1.proto.TransferTypes;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageTransferServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storagetransfer.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getGoogleServiceAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageTransferServiceStubSettings.Builder storageTransferServiceSettingsBuilder =
 *     StorageTransferServiceStubSettings.newBuilder();
 * storageTransferServiceSettingsBuilder
 *     .getGoogleServiceAccountSettings()
 *     .setRetrySettings(
 *         storageTransferServiceSettingsBuilder
 *             .getGoogleServiceAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StorageTransferServiceStubSettings storageTransferServiceSettings =
 *     storageTransferServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StorageTransferServiceStubSettings
    extends StubSettings<StorageTransferServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountSettings;
  private final UnaryCallSettings<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobSettings;
  private final UnaryCallSettings<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobSettings;
  private final UnaryCallSettings<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobSettings;
  private final PagedCallSettings<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          ListTransferJobsPagedResponse>
      listTransferJobsSettings;
  private final UnaryCallSettings<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationSettings;
  private final UnaryCallSettings<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationSettings;
  private final UnaryCallSettings<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobSettings;
  private final OperationCallSettings<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationSettings;
  private final UnaryCallSettings<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobSettings;
  private final UnaryCallSettings<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolSettings;
  private final UnaryCallSettings<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolSettings;
  private final UnaryCallSettings<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolSettings;
  private final PagedCallSettings<
          TransferProto.ListAgentPoolsRequest,
          TransferProto.ListAgentPoolsResponse,
          ListAgentPoolsPagedResponse>
      listAgentPoolsSettings;
  private final UnaryCallSettings<TransferProto.DeleteAgentPoolRequest, Empty>
      deleteAgentPoolSettings;

  private static final PagedListDescriptor<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          TransferTypes.TransferJob>
      LIST_TRANSFER_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              TransferProto.ListTransferJobsRequest,
              TransferProto.ListTransferJobsResponse,
              TransferTypes.TransferJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public TransferProto.ListTransferJobsRequest injectToken(
                TransferProto.ListTransferJobsRequest payload, String token) {
              return TransferProto.ListTransferJobsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public TransferProto.ListTransferJobsRequest injectPageSize(
                TransferProto.ListTransferJobsRequest payload, int pageSize) {
              return TransferProto.ListTransferJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(TransferProto.ListTransferJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(TransferProto.ListTransferJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransferTypes.TransferJob> extractResources(
                TransferProto.ListTransferJobsResponse payload) {
              return payload.getTransferJobsList() == null
                  ? ImmutableList.<TransferTypes.TransferJob>of()
                  : payload.getTransferJobsList();
            }
          };

  private static final PagedListDescriptor<
          TransferProto.ListAgentPoolsRequest,
          TransferProto.ListAgentPoolsResponse,
          TransferTypes.AgentPool>
      LIST_AGENT_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              TransferProto.ListAgentPoolsRequest,
              TransferProto.ListAgentPoolsResponse,
              TransferTypes.AgentPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public TransferProto.ListAgentPoolsRequest injectToken(
                TransferProto.ListAgentPoolsRequest payload, String token) {
              return TransferProto.ListAgentPoolsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public TransferProto.ListAgentPoolsRequest injectPageSize(
                TransferProto.ListAgentPoolsRequest payload, int pageSize) {
              return TransferProto.ListAgentPoolsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(TransferProto.ListAgentPoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(TransferProto.ListAgentPoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransferTypes.AgentPool> extractResources(
                TransferProto.ListAgentPoolsResponse payload) {
              return payload.getAgentPoolsList() == null
                  ? ImmutableList.<TransferTypes.AgentPool>of()
                  : payload.getAgentPoolsList();
            }
          };

  private static final PagedListResponseFactory<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          ListTransferJobsPagedResponse>
      LIST_TRANSFER_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              TransferProto.ListTransferJobsRequest,
              TransferProto.ListTransferJobsResponse,
              ListTransferJobsPagedResponse>() {
            @Override
            public ApiFuture<ListTransferJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        TransferProto.ListTransferJobsRequest,
                        TransferProto.ListTransferJobsResponse>
                    callable,
                TransferProto.ListTransferJobsRequest request,
                ApiCallContext context,
                ApiFuture<TransferProto.ListTransferJobsResponse> futureResponse) {
              PageContext<
                      TransferProto.ListTransferJobsRequest,
                      TransferProto.ListTransferJobsResponse,
                      TransferTypes.TransferJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSFER_JOBS_PAGE_STR_DESC, request, context);
              return ListTransferJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          TransferProto.ListAgentPoolsRequest,
          TransferProto.ListAgentPoolsResponse,
          ListAgentPoolsPagedResponse>
      LIST_AGENT_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              TransferProto.ListAgentPoolsRequest,
              TransferProto.ListAgentPoolsResponse,
              ListAgentPoolsPagedResponse>() {
            @Override
            public ApiFuture<ListAgentPoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
                    callable,
                TransferProto.ListAgentPoolsRequest request,
                ApiCallContext context,
                ApiFuture<TransferProto.ListAgentPoolsResponse> futureResponse) {
              PageContext<
                      TransferProto.ListAgentPoolsRequest,
                      TransferProto.ListAgentPoolsResponse,
                      TransferTypes.AgentPool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AGENT_POOLS_PAGE_STR_DESC, request, context);
              return ListAgentPoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getGoogleServiceAccount. */
  public UnaryCallSettings<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountSettings() {
    return getGoogleServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to createTransferJob. */
  public UnaryCallSettings<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobSettings() {
    return createTransferJobSettings;
  }

  /** Returns the object with the settings used for calls to updateTransferJob. */
  public UnaryCallSettings<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobSettings() {
    return updateTransferJobSettings;
  }

  /** Returns the object with the settings used for calls to getTransferJob. */
  public UnaryCallSettings<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobSettings() {
    return getTransferJobSettings;
  }

  /** Returns the object with the settings used for calls to listTransferJobs. */
  public PagedCallSettings<
          TransferProto.ListTransferJobsRequest,
          TransferProto.ListTransferJobsResponse,
          ListTransferJobsPagedResponse>
      listTransferJobsSettings() {
    return listTransferJobsSettings;
  }

  /** Returns the object with the settings used for calls to pauseTransfer. */
  public UnaryCallSettings<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationSettings() {
    return pauseTransferOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeTransfer. */
  public UnaryCallSettings<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationSettings() {
    return resumeTransferOperationSettings;
  }

  /** Returns the object with the settings used for calls to runTransferJob. */
  public UnaryCallSettings<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobSettings() {
    return runTransferJobSettings;
  }

  /** Returns the object with the settings used for calls to runTransferJob. */
  public OperationCallSettings<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationSettings() {
    return runTransferJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransferJob. */
  public UnaryCallSettings<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobSettings() {
    return deleteTransferJobSettings;
  }

  /** Returns the object with the settings used for calls to createAgentPool. */
  public UnaryCallSettings<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolSettings() {
    return createAgentPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateAgentPool. */
  public UnaryCallSettings<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolSettings() {
    return updateAgentPoolSettings;
  }

  /** Returns the object with the settings used for calls to getAgentPool. */
  public UnaryCallSettings<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolSettings() {
    return getAgentPoolSettings;
  }

  /** Returns the object with the settings used for calls to listAgentPools. */
  public PagedCallSettings<
          TransferProto.ListAgentPoolsRequest,
          TransferProto.ListAgentPoolsResponse,
          ListAgentPoolsPagedResponse>
      listAgentPoolsSettings() {
    return listAgentPoolsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAgentPool. */
  public UnaryCallSettings<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolSettings() {
    return deleteAgentPoolSettings;
  }

  public StorageTransferServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcStorageTransferServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStorageTransferServiceStub.create(this);
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
    return "storagetransfer.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "storagetransfer.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StorageTransferServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StorageTransferServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageTransferServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected StorageTransferServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getGoogleServiceAccountSettings = settingsBuilder.getGoogleServiceAccountSettings().build();
    createTransferJobSettings = settingsBuilder.createTransferJobSettings().build();
    updateTransferJobSettings = settingsBuilder.updateTransferJobSettings().build();
    getTransferJobSettings = settingsBuilder.getTransferJobSettings().build();
    listTransferJobsSettings = settingsBuilder.listTransferJobsSettings().build();
    pauseTransferOperationSettings = settingsBuilder.pauseTransferOperationSettings().build();
    resumeTransferOperationSettings = settingsBuilder.resumeTransferOperationSettings().build();
    runTransferJobSettings = settingsBuilder.runTransferJobSettings().build();
    runTransferJobOperationSettings = settingsBuilder.runTransferJobOperationSettings().build();
    deleteTransferJobSettings = settingsBuilder.deleteTransferJobSettings().build();
    createAgentPoolSettings = settingsBuilder.createAgentPoolSettings().build();
    updateAgentPoolSettings = settingsBuilder.updateAgentPoolSettings().build();
    getAgentPoolSettings = settingsBuilder.getAgentPoolSettings().build();
    listAgentPoolsSettings = settingsBuilder.listAgentPoolsSettings().build();
    deleteAgentPoolSettings = settingsBuilder.deleteAgentPoolSettings().build();
  }

  /** Builder for StorageTransferServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<StorageTransferServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
        getGoogleServiceAccountSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
        createTransferJobSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
        updateTransferJobSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
        getTransferJobSettings;
    private final PagedCallSettings.Builder<
            TransferProto.ListTransferJobsRequest,
            TransferProto.ListTransferJobsResponse,
            ListTransferJobsPagedResponse>
        listTransferJobsSettings;
    private final UnaryCallSettings.Builder<TransferProto.PauseTransferOperationRequest, Empty>
        pauseTransferOperationSettings;
    private final UnaryCallSettings.Builder<TransferProto.ResumeTransferOperationRequest, Empty>
        resumeTransferOperationSettings;
    private final UnaryCallSettings.Builder<TransferProto.RunTransferJobRequest, Operation>
        runTransferJobSettings;
    private final OperationCallSettings.Builder<
            TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
        runTransferJobOperationSettings;
    private final UnaryCallSettings.Builder<TransferProto.DeleteTransferJobRequest, Empty>
        deleteTransferJobSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
        createAgentPoolSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
        updateAgentPoolSettings;
    private final UnaryCallSettings.Builder<
            TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
        getAgentPoolSettings;
    private final PagedCallSettings.Builder<
            TransferProto.ListAgentPoolsRequest,
            TransferProto.ListAgentPoolsResponse,
            ListAgentPoolsPagedResponse>
        listAgentPoolsSettings;
    private final UnaryCallSettings.Builder<TransferProto.DeleteAgentPoolRequest, Empty>
        deleteAgentPoolSettings;
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
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getGoogleServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTransferJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTransferJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTransferJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTransferJobsSettings = PagedCallSettings.newBuilder(LIST_TRANSFER_JOBS_PAGE_STR_FACT);
      pauseTransferOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeTransferOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runTransferJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runTransferJobOperationSettings = OperationCallSettings.newBuilder();
      deleteTransferJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAgentPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAgentPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAgentPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAgentPoolsSettings = PagedCallSettings.newBuilder(LIST_AGENT_POOLS_PAGE_STR_FACT);
      deleteAgentPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getGoogleServiceAccountSettings,
              createTransferJobSettings,
              updateTransferJobSettings,
              getTransferJobSettings,
              listTransferJobsSettings,
              pauseTransferOperationSettings,
              resumeTransferOperationSettings,
              runTransferJobSettings,
              deleteTransferJobSettings,
              createAgentPoolSettings,
              updateAgentPoolSettings,
              getAgentPoolSettings,
              listAgentPoolsSettings,
              deleteAgentPoolSettings);
      initDefaults(this);
    }

    protected Builder(StorageTransferServiceStubSettings settings) {
      super(settings);

      getGoogleServiceAccountSettings = settings.getGoogleServiceAccountSettings.toBuilder();
      createTransferJobSettings = settings.createTransferJobSettings.toBuilder();
      updateTransferJobSettings = settings.updateTransferJobSettings.toBuilder();
      getTransferJobSettings = settings.getTransferJobSettings.toBuilder();
      listTransferJobsSettings = settings.listTransferJobsSettings.toBuilder();
      pauseTransferOperationSettings = settings.pauseTransferOperationSettings.toBuilder();
      resumeTransferOperationSettings = settings.resumeTransferOperationSettings.toBuilder();
      runTransferJobSettings = settings.runTransferJobSettings.toBuilder();
      runTransferJobOperationSettings = settings.runTransferJobOperationSettings.toBuilder();
      deleteTransferJobSettings = settings.deleteTransferJobSettings.toBuilder();
      createAgentPoolSettings = settings.createAgentPoolSettings.toBuilder();
      updateAgentPoolSettings = settings.updateAgentPoolSettings.toBuilder();
      getAgentPoolSettings = settings.getAgentPoolSettings.toBuilder();
      listAgentPoolsSettings = settings.listAgentPoolsSettings.toBuilder();
      deleteAgentPoolSettings = settings.deleteAgentPoolSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getGoogleServiceAccountSettings,
              createTransferJobSettings,
              updateTransferJobSettings,
              getTransferJobSettings,
              listTransferJobsSettings,
              pauseTransferOperationSettings,
              resumeTransferOperationSettings,
              runTransferJobSettings,
              deleteTransferJobSettings,
              createAgentPoolSettings,
              updateAgentPoolSettings,
              getAgentPoolSettings,
              listAgentPoolsSettings,
              deleteAgentPoolSettings);
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
          .getGoogleServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTransferJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTransferJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTransferJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTransferJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .pauseTransferOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resumeTransferOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runTransferJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTransferJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAgentPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAgentPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAgentPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAgentPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAgentPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runTransferJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<TransferProto.RunTransferJobRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  TransferTypes.TransferOperation.class))
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

    /** Returns the builder for the settings used for calls to getGoogleServiceAccount. */
    public UnaryCallSettings.Builder<
            TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
        getGoogleServiceAccountSettings() {
      return getGoogleServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to createTransferJob. */
    public UnaryCallSettings.Builder<
            TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
        createTransferJobSettings() {
      return createTransferJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateTransferJob. */
    public UnaryCallSettings.Builder<
            TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
        updateTransferJobSettings() {
      return updateTransferJobSettings;
    }

    /** Returns the builder for the settings used for calls to getTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
        getTransferJobSettings() {
      return getTransferJobSettings;
    }

    /** Returns the builder for the settings used for calls to listTransferJobs. */
    public PagedCallSettings.Builder<
            TransferProto.ListTransferJobsRequest,
            TransferProto.ListTransferJobsResponse,
            ListTransferJobsPagedResponse>
        listTransferJobsSettings() {
      return listTransferJobsSettings;
    }

    /** Returns the builder for the settings used for calls to pauseTransfer. */
    public UnaryCallSettings.Builder<TransferProto.PauseTransferOperationRequest, Empty>
        pauseTransferOperationSettings() {
      return pauseTransferOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeTransfer. */
    public UnaryCallSettings.Builder<TransferProto.ResumeTransferOperationRequest, Empty>
        resumeTransferOperationSettings() {
      return resumeTransferOperationSettings;
    }

    /** Returns the builder for the settings used for calls to runTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.RunTransferJobRequest, Operation>
        runTransferJobSettings() {
      return runTransferJobSettings;
    }

    /** Returns the builder for the settings used for calls to runTransferJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
        runTransferJobOperationSettings() {
      return runTransferJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransferJob. */
    public UnaryCallSettings.Builder<TransferProto.DeleteTransferJobRequest, Empty>
        deleteTransferJobSettings() {
      return deleteTransferJobSettings;
    }

    /** Returns the builder for the settings used for calls to createAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
        createAgentPoolSettings() {
      return createAgentPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
        updateAgentPoolSettings() {
      return updateAgentPoolSettings;
    }

    /** Returns the builder for the settings used for calls to getAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
        getAgentPoolSettings() {
      return getAgentPoolSettings;
    }

    /** Returns the builder for the settings used for calls to listAgentPools. */
    public PagedCallSettings.Builder<
            TransferProto.ListAgentPoolsRequest,
            TransferProto.ListAgentPoolsResponse,
            ListAgentPoolsPagedResponse>
        listAgentPoolsSettings() {
      return listAgentPoolsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAgentPool. */
    public UnaryCallSettings.Builder<TransferProto.DeleteAgentPoolRequest, Empty>
        deleteAgentPoolSettings() {
      return deleteAgentPoolSettings;
    }

    @Override
    public StorageTransferServiceStubSettings build() throws IOException {
      return new StorageTransferServiceStubSettings(this);
    }
  }
}
