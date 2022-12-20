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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AttachedCluster;
import com.google.cloud.gkemulticloud.v1.AttachedServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse;
import com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest;
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
 * Settings class to configure an instance of {@link AttachedClustersStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkemulticloud.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAttachedCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AttachedClustersStubSettings.Builder attachedClustersSettingsBuilder =
 *     AttachedClustersStubSettings.newBuilder();
 * attachedClustersSettingsBuilder
 *     .getAttachedClusterSettings()
 *     .setRetrySettings(
 *         attachedClustersSettingsBuilder
 *             .getAttachedClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AttachedClustersStubSettings attachedClustersSettings = attachedClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AttachedClustersStubSettings extends StubSettings<AttachedClustersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAttachedClusterRequest, Operation>
      createAttachedClusterSettings;
  private final OperationCallSettings<
          CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationSettings;
  private final UnaryCallSettings<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterSettings;
  private final OperationCallSettings<
          UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationSettings;
  private final UnaryCallSettings<ImportAttachedClusterRequest, Operation>
      importAttachedClusterSettings;
  private final OperationCallSettings<
          ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationSettings;
  private final UnaryCallSettings<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterSettings;
  private final PagedCallSettings<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          ListAttachedClustersPagedResponse>
      listAttachedClustersSettings;
  private final UnaryCallSettings<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterSettings;
  private final OperationCallSettings<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationSettings;
  private final UnaryCallSettings<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigSettings;
  private final UnaryCallSettings<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestSettings;

  private static final PagedListDescriptor<
          ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
      LIST_ATTACHED_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAttachedClustersRequest injectToken(
                ListAttachedClustersRequest payload, String token) {
              return ListAttachedClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAttachedClustersRequest injectPageSize(
                ListAttachedClustersRequest payload, int pageSize) {
              return ListAttachedClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAttachedClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAttachedClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AttachedCluster> extractResources(
                ListAttachedClustersResponse payload) {
              return payload.getAttachedClustersList() == null
                  ? ImmutableList.<AttachedCluster>of()
                  : payload.getAttachedClustersList();
            }
          };

  private static final PagedListResponseFactory<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          ListAttachedClustersPagedResponse>
      LIST_ATTACHED_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAttachedClustersRequest,
              ListAttachedClustersResponse,
              ListAttachedClustersPagedResponse>() {
            @Override
            public ApiFuture<ListAttachedClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse> callable,
                ListAttachedClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListAttachedClustersResponse> futureResponse) {
              PageContext<
                      ListAttachedClustersRequest, ListAttachedClustersResponse, AttachedCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ATTACHED_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListAttachedClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAttachedCluster. */
  public UnaryCallSettings<CreateAttachedClusterRequest, Operation>
      createAttachedClusterSettings() {
    return createAttachedClusterSettings;
  }

  /** Returns the object with the settings used for calls to createAttachedCluster. */
  public OperationCallSettings<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationSettings() {
    return createAttachedClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAttachedCluster. */
  public UnaryCallSettings<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterSettings() {
    return updateAttachedClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateAttachedCluster. */
  public OperationCallSettings<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationSettings() {
    return updateAttachedClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to importAttachedCluster. */
  public UnaryCallSettings<ImportAttachedClusterRequest, Operation>
      importAttachedClusterSettings() {
    return importAttachedClusterSettings;
  }

  /** Returns the object with the settings used for calls to importAttachedCluster. */
  public OperationCallSettings<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationSettings() {
    return importAttachedClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAttachedCluster. */
  public UnaryCallSettings<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterSettings() {
    return getAttachedClusterSettings;
  }

  /** Returns the object with the settings used for calls to listAttachedClusters. */
  public PagedCallSettings<
          ListAttachedClustersRequest,
          ListAttachedClustersResponse,
          ListAttachedClustersPagedResponse>
      listAttachedClustersSettings() {
    return listAttachedClustersSettings;
  }

  /** Returns the object with the settings used for calls to deleteAttachedCluster. */
  public UnaryCallSettings<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterSettings() {
    return deleteAttachedClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteAttachedCluster. */
  public OperationCallSettings<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationSettings() {
    return deleteAttachedClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAttachedServerConfig. */
  public UnaryCallSettings<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigSettings() {
    return getAttachedServerConfigSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateAttachedClusterInstallManifest.
   */
  public UnaryCallSettings<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestSettings() {
    return generateAttachedClusterInstallManifestSettings;
  }

  public AttachedClustersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAttachedClustersStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAttachedClustersStub.create(this);
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
    return "gkemulticloud.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkemulticloud.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AttachedClustersStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AttachedClustersStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AttachedClustersStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AttachedClustersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAttachedClusterSettings = settingsBuilder.createAttachedClusterSettings().build();
    createAttachedClusterOperationSettings =
        settingsBuilder.createAttachedClusterOperationSettings().build();
    updateAttachedClusterSettings = settingsBuilder.updateAttachedClusterSettings().build();
    updateAttachedClusterOperationSettings =
        settingsBuilder.updateAttachedClusterOperationSettings().build();
    importAttachedClusterSettings = settingsBuilder.importAttachedClusterSettings().build();
    importAttachedClusterOperationSettings =
        settingsBuilder.importAttachedClusterOperationSettings().build();
    getAttachedClusterSettings = settingsBuilder.getAttachedClusterSettings().build();
    listAttachedClustersSettings = settingsBuilder.listAttachedClustersSettings().build();
    deleteAttachedClusterSettings = settingsBuilder.deleteAttachedClusterSettings().build();
    deleteAttachedClusterOperationSettings =
        settingsBuilder.deleteAttachedClusterOperationSettings().build();
    getAttachedServerConfigSettings = settingsBuilder.getAttachedServerConfigSettings().build();
    generateAttachedClusterInstallManifestSettings =
        settingsBuilder.generateAttachedClusterInstallManifestSettings().build();
  }

  /** Builder for AttachedClustersStubSettings. */
  public static class Builder extends StubSettings.Builder<AttachedClustersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAttachedClusterRequest, Operation>
        createAttachedClusterSettings;
    private final OperationCallSettings.Builder<
            CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        createAttachedClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAttachedClusterRequest, Operation>
        updateAttachedClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        updateAttachedClusterOperationSettings;
    private final UnaryCallSettings.Builder<ImportAttachedClusterRequest, Operation>
        importAttachedClusterSettings;
    private final OperationCallSettings.Builder<
            ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
        importAttachedClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetAttachedClusterRequest, AttachedCluster>
        getAttachedClusterSettings;
    private final PagedCallSettings.Builder<
            ListAttachedClustersRequest,
            ListAttachedClustersResponse,
            ListAttachedClustersPagedResponse>
        listAttachedClustersSettings;
    private final UnaryCallSettings.Builder<DeleteAttachedClusterRequest, Operation>
        deleteAttachedClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteAttachedClusterRequest, Empty, OperationMetadata>
        deleteAttachedClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetAttachedServerConfigRequest, AttachedServerConfig>
        getAttachedServerConfigSettings;
    private final UnaryCallSettings.Builder<
            GenerateAttachedClusterInstallManifestRequest,
            GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifestSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      definitions.put("no_retry_1_params", settings);
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

      createAttachedClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAttachedClusterOperationSettings = OperationCallSettings.newBuilder();
      updateAttachedClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAttachedClusterOperationSettings = OperationCallSettings.newBuilder();
      importAttachedClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAttachedClusterOperationSettings = OperationCallSettings.newBuilder();
      getAttachedClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAttachedClustersSettings =
          PagedCallSettings.newBuilder(LIST_ATTACHED_CLUSTERS_PAGE_STR_FACT);
      deleteAttachedClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAttachedClusterOperationSettings = OperationCallSettings.newBuilder();
      getAttachedServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateAttachedClusterInstallManifestSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAttachedClusterSettings,
              updateAttachedClusterSettings,
              importAttachedClusterSettings,
              getAttachedClusterSettings,
              listAttachedClustersSettings,
              deleteAttachedClusterSettings,
              getAttachedServerConfigSettings,
              generateAttachedClusterInstallManifestSettings);
      initDefaults(this);
    }

    protected Builder(AttachedClustersStubSettings settings) {
      super(settings);

      createAttachedClusterSettings = settings.createAttachedClusterSettings.toBuilder();
      createAttachedClusterOperationSettings =
          settings.createAttachedClusterOperationSettings.toBuilder();
      updateAttachedClusterSettings = settings.updateAttachedClusterSettings.toBuilder();
      updateAttachedClusterOperationSettings =
          settings.updateAttachedClusterOperationSettings.toBuilder();
      importAttachedClusterSettings = settings.importAttachedClusterSettings.toBuilder();
      importAttachedClusterOperationSettings =
          settings.importAttachedClusterOperationSettings.toBuilder();
      getAttachedClusterSettings = settings.getAttachedClusterSettings.toBuilder();
      listAttachedClustersSettings = settings.listAttachedClustersSettings.toBuilder();
      deleteAttachedClusterSettings = settings.deleteAttachedClusterSettings.toBuilder();
      deleteAttachedClusterOperationSettings =
          settings.deleteAttachedClusterOperationSettings.toBuilder();
      getAttachedServerConfigSettings = settings.getAttachedServerConfigSettings.toBuilder();
      generateAttachedClusterInstallManifestSettings =
          settings.generateAttachedClusterInstallManifestSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAttachedClusterSettings,
              updateAttachedClusterSettings,
              importAttachedClusterSettings,
              getAttachedClusterSettings,
              listAttachedClustersSettings,
              deleteAttachedClusterSettings,
              getAttachedServerConfigSettings,
              generateAttachedClusterInstallManifestSettings);
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
          .createAttachedClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAttachedClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .importAttachedClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAttachedClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAttachedClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAttachedClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAttachedServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateAttachedClusterInstallManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAttachedClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAttachedClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AttachedCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateAttachedClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAttachedClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AttachedCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .importAttachedClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportAttachedClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AttachedCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteAttachedClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAttachedClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createAttachedCluster. */
    public UnaryCallSettings.Builder<CreateAttachedClusterRequest, Operation>
        createAttachedClusterSettings() {
      return createAttachedClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createAttachedCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        createAttachedClusterOperationSettings() {
      return createAttachedClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttachedCluster. */
    public UnaryCallSettings.Builder<UpdateAttachedClusterRequest, Operation>
        updateAttachedClusterSettings() {
      return updateAttachedClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttachedCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
        updateAttachedClusterOperationSettings() {
      return updateAttachedClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importAttachedCluster. */
    public UnaryCallSettings.Builder<ImportAttachedClusterRequest, Operation>
        importAttachedClusterSettings() {
      return importAttachedClusterSettings;
    }

    /** Returns the builder for the settings used for calls to importAttachedCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
        importAttachedClusterOperationSettings() {
      return importAttachedClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAttachedCluster. */
    public UnaryCallSettings.Builder<GetAttachedClusterRequest, AttachedCluster>
        getAttachedClusterSettings() {
      return getAttachedClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listAttachedClusters. */
    public PagedCallSettings.Builder<
            ListAttachedClustersRequest,
            ListAttachedClustersResponse,
            ListAttachedClustersPagedResponse>
        listAttachedClustersSettings() {
      return listAttachedClustersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAttachedCluster. */
    public UnaryCallSettings.Builder<DeleteAttachedClusterRequest, Operation>
        deleteAttachedClusterSettings() {
      return deleteAttachedClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAttachedCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAttachedClusterRequest, Empty, OperationMetadata>
        deleteAttachedClusterOperationSettings() {
      return deleteAttachedClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAttachedServerConfig. */
    public UnaryCallSettings.Builder<GetAttachedServerConfigRequest, AttachedServerConfig>
        getAttachedServerConfigSettings() {
      return getAttachedServerConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateAttachedClusterInstallManifest.
     */
    public UnaryCallSettings.Builder<
            GenerateAttachedClusterInstallManifestRequest,
            GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifestSettings() {
      return generateAttachedClusterInstallManifestSettings;
    }

    @Override
    public AttachedClustersStubSettings build() throws IOException {
      return new AttachedClustersStubSettings(this);
    }
  }
}
