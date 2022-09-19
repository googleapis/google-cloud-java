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

package com.google.cloud.assuredworkloads.v1.stub;

import static com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

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
import com.google.cloud.assuredworkloads.v1.CreateWorkloadOperationMetadata;
import com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest;
import com.google.cloud.assuredworkloads.v1.GetWorkloadRequest;
import com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest;
import com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse;
import com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1.Workload;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssuredWorkloadsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (assuredworkloads.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of updateWorkload to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssuredWorkloadsServiceStubSettings.Builder assuredWorkloadsServiceSettingsBuilder =
 *     AssuredWorkloadsServiceStubSettings.newBuilder();
 * assuredWorkloadsServiceSettingsBuilder
 *     .updateWorkloadSettings()
 *     .setRetrySettings(
 *         assuredWorkloadsServiceSettingsBuilder
 *             .updateWorkloadSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AssuredWorkloadsServiceStubSettings assuredWorkloadsServiceSettings =
 *     assuredWorkloadsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AssuredWorkloadsServiceStubSettings
    extends StubSettings<AssuredWorkloadsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings;
  private final OperationCallSettings<
          CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationSettings;
  private final UnaryCallSettings<UpdateWorkloadRequest, Workload> updateWorkloadSettings;
  private final UnaryCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadSettings;
  private final UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings;
  private final PagedCallSettings<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings;

  private static final PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>
      LIST_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkloadsRequest injectToken(ListWorkloadsRequest payload, String token) {
              return ListWorkloadsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkloadsRequest injectPageSize(ListWorkloadsRequest payload, int pageSize) {
              return ListWorkloadsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkloadsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkloadsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workload> extractResources(ListWorkloadsResponse payload) {
              return payload.getWorkloadsList() == null
                  ? ImmutableList.<Workload>of()
                  : payload.getWorkloadsList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      LIST_WORKLOADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkloadsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> callable,
                ListWorkloadsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkloadsResponse> futureResponse) {
              PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> pageContext =
                  PageContext.create(callable, LIST_WORKLOADS_PAGE_STR_DESC, request, context);
              return ListWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createWorkload. */
  public UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings() {
    return createWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public OperationCallSettings<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationSettings() {
    return createWorkloadOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public UnaryCallSettings<UpdateWorkloadRequest, Workload> updateWorkloadSettings() {
    return updateWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public UnaryCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadSettings() {
    return deleteWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return getWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return listWorkloadsSettings;
  }

  public AssuredWorkloadsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAssuredWorkloadsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAssuredWorkloadsServiceStub.create(this);
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
    return "assuredworkloads.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "assuredworkloads.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AssuredWorkloadsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AssuredWorkloadsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AssuredWorkloadsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createWorkloadSettings = settingsBuilder.createWorkloadSettings().build();
    createWorkloadOperationSettings = settingsBuilder.createWorkloadOperationSettings().build();
    updateWorkloadSettings = settingsBuilder.updateWorkloadSettings().build();
    deleteWorkloadSettings = settingsBuilder.deleteWorkloadSettings().build();
    getWorkloadSettings = settingsBuilder.getWorkloadSettings().build();
    listWorkloadsSettings = settingsBuilder.listWorkloadsSettings().build();
  }

  /** Builder for AssuredWorkloadsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AssuredWorkloadsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateWorkloadRequest, Operation>
        createWorkloadSettings;
    private final OperationCallSettings.Builder<
            CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
        createWorkloadOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkloadRequest, Workload> updateWorkloadSettings;
    private final UnaryCallSettings.Builder<DeleteWorkloadRequest, Empty> deleteWorkloadSettings;
    private final UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings;
    private final PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadOperationSettings = OperationCallSettings.newBuilder();
      updateWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkloadsSettings = PagedCallSettings.newBuilder(LIST_WORKLOADS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkloadSettings,
              updateWorkloadSettings,
              deleteWorkloadSettings,
              getWorkloadSettings,
              listWorkloadsSettings);
      initDefaults(this);
    }

    protected Builder(AssuredWorkloadsServiceStubSettings settings) {
      super(settings);

      createWorkloadSettings = settings.createWorkloadSettings.toBuilder();
      createWorkloadOperationSettings = settings.createWorkloadOperationSettings.toBuilder();
      updateWorkloadSettings = settings.updateWorkloadSettings.toBuilder();
      deleteWorkloadSettings = settings.deleteWorkloadSettings.toBuilder();
      getWorkloadSettings = settings.getWorkloadSettings.toBuilder();
      listWorkloadsSettings = settings.listWorkloadsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkloadSettings,
              updateWorkloadSettings,
              deleteWorkloadSettings,
              getWorkloadSettings,
              listWorkloadsSettings);
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
          .createWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createWorkloadOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkloadRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workload.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateWorkloadOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createWorkload. */
    public UnaryCallSettings.Builder<CreateWorkloadRequest, Operation> createWorkloadSettings() {
      return createWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
        createWorkloadOperationSettings() {
      return createWorkloadOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public UnaryCallSettings.Builder<UpdateWorkloadRequest, Workload> updateWorkloadSettings() {
      return updateWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public UnaryCallSettings.Builder<DeleteWorkloadRequest, Empty> deleteWorkloadSettings() {
      return deleteWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return listWorkloadsSettings;
    }

    @Override
    public AssuredWorkloadsServiceStubSettings build() throws IOException {
      return new AssuredWorkloadsServiceStubSettings(this);
    }
  }
}
