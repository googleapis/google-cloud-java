/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.vpcaccess.v1.stub;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;

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
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.CreateConnectorRequest;
import com.google.cloud.vpcaccess.v1.DeleteConnectorRequest;
import com.google.cloud.vpcaccess.v1.GetConnectorRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsResponse;
import com.google.cloud.vpcaccess.v1.OperationMetadata;
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
 * Settings class to configure an instance of {@link VpcAccessServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vpcaccess.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnector to 30 seconds:
 *
 * <pre>{@code
 * VpcAccessServiceStubSettings.Builder vpcAccessServiceSettingsBuilder =
 *     VpcAccessServiceStubSettings.newBuilder();
 * vpcAccessServiceSettingsBuilder
 *     .getConnectorSettings()
 *     .setRetrySettings(
 *         vpcAccessServiceSettingsBuilder
 *             .getConnectorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VpcAccessServiceStubSettings vpcAccessServiceSettings = vpcAccessServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VpcAccessServiceStubSettings extends StubSettings<VpcAccessServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateConnectorRequest, Operation> createConnectorSettings;
  private final OperationCallSettings<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationSettings;
  private final UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings;
  private final PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings;
  private final UnaryCallSettings<DeleteConnectorRequest, Operation> deleteConnectorSettings;
  private final OperationCallSettings<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationSettings;

  private static final PagedListDescriptor<ListConnectorsRequest, ListConnectorsResponse, Connector>
      LIST_CONNECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConnectorsRequest, ListConnectorsResponse, Connector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectorsRequest injectToken(ListConnectorsRequest payload, String token) {
              return ListConnectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectorsRequest injectPageSize(
                ListConnectorsRequest payload, int pageSize) {
              return ListConnectorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connector> extractResources(ListConnectorsResponse payload) {
              return payload.getConnectorsList() == null
                  ? ImmutableList.<Connector>of()
                  : payload.getConnectorsList();
            }
          };

  private static final PagedListResponseFactory<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      LIST_CONNECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>() {
            @Override
            public ApiFuture<ListConnectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> callable,
                ListConnectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectorsResponse> futureResponse) {
              PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> pageContext =
                  PageContext.create(callable, LIST_CONNECTORS_PAGE_STR_DESC, request, context);
              return ListConnectorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConnector. */
  public UnaryCallSettings<CreateConnectorRequest, Operation> createConnectorSettings() {
    return createConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createConnector. */
  public OperationCallSettings<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationSettings() {
    return createConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConnector. */
  public UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings() {
    return getConnectorSettings;
  }

  /** Returns the object with the settings used for calls to listConnectors. */
  public PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings() {
    return listConnectorsSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public UnaryCallSettings<DeleteConnectorRequest, Operation> deleteConnectorSettings() {
    return deleteConnectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public OperationCallSettings<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationSettings() {
    return deleteConnectorOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpcAccessServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVpcAccessServiceStub.create(this);
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
    return "vpcaccess.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(VpcAccessServiceStubSettings.class))
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

  protected VpcAccessServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConnectorSettings = settingsBuilder.createConnectorSettings().build();
    createConnectorOperationSettings = settingsBuilder.createConnectorOperationSettings().build();
    getConnectorSettings = settingsBuilder.getConnectorSettings().build();
    listConnectorsSettings = settingsBuilder.listConnectorsSettings().build();
    deleteConnectorSettings = settingsBuilder.deleteConnectorSettings().build();
    deleteConnectorOperationSettings = settingsBuilder.deleteConnectorOperationSettings().build();
  }

  /** Builder for VpcAccessServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<VpcAccessServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConnectorRequest, Operation>
        createConnectorSettings;
    private final OperationCallSettings.Builder<
            CreateConnectorRequest, Connector, OperationMetadata>
        createConnectorOperationSettings;
    private final UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings;
    private final PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings;
    private final UnaryCallSettings.Builder<DeleteConnectorRequest, Operation>
        deleteConnectorSettings;
    private final OperationCallSettings.Builder<DeleteConnectorRequest, Empty, OperationMetadata>
        deleteConnectorOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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

      createConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectorOperationSettings = OperationCallSettings.newBuilder();
      getConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConnectorsSettings = PagedCallSettings.newBuilder(LIST_CONNECTORS_PAGE_STR_FACT);
      deleteConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectorOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectorSettings,
              getConnectorSettings,
              listConnectorsSettings,
              deleteConnectorSettings);
      initDefaults(this);
    }

    protected Builder(VpcAccessServiceStubSettings settings) {
      super(settings);

      createConnectorSettings = settings.createConnectorSettings.toBuilder();
      createConnectorOperationSettings = settings.createConnectorOperationSettings.toBuilder();
      getConnectorSettings = settings.getConnectorSettings.toBuilder();
      listConnectorsSettings = settings.listConnectorsSettings.toBuilder();
      deleteConnectorSettings = settings.deleteConnectorSettings.toBuilder();
      deleteConnectorOperationSettings = settings.deleteConnectorOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectorSettings,
              getConnectorSettings,
              listConnectorsSettings,
              deleteConnectorSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listConnectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Connector.class))
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
          .deleteConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConnectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to createConnector. */
    public UnaryCallSettings.Builder<CreateConnectorRequest, Operation> createConnectorSettings() {
      return createConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createConnector. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateConnectorRequest, Connector, OperationMetadata>
        createConnectorOperationSettings() {
      return createConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getConnector. */
    public UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings() {
      return getConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to listConnectors. */
    public PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings() {
      return listConnectorsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    public UnaryCallSettings.Builder<DeleteConnectorRequest, Operation> deleteConnectorSettings() {
      return deleteConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteConnectorRequest, Empty, OperationMetadata>
        deleteConnectorOperationSettings() {
      return deleteConnectorOperationSettings;
    }

    @Override
    public VpcAccessServiceStubSettings build() throws IOException {
      return new VpcAccessServiceStubSettings(this);
    }
  }
}
