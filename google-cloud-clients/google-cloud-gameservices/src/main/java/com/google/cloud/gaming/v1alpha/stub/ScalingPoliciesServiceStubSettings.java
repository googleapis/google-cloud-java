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
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.ScalingPoliciesServiceClient.ListScalingPoliciesPagedResponse;

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
import com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse;
import com.google.cloud.gaming.v1alpha.ScalingPolicy;
import com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest;
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
 * Settings class to configure an instance of {@link ScalingPoliciesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gameservices.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getScalingPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ScalingPoliciesServiceStubSettings.Builder scalingPoliciesServiceSettingsBuilder =
 *     ScalingPoliciesServiceStubSettings.newBuilder();
 * scalingPoliciesServiceSettingsBuilder.getScalingPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ScalingPoliciesServiceStubSettings scalingPoliciesServiceSettings = scalingPoliciesServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ScalingPoliciesServiceStubSettings
    extends StubSettings<ScalingPoliciesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListScalingPoliciesRequest, ListScalingPoliciesResponse, ListScalingPoliciesPagedResponse>
      listScalingPoliciesSettings;
  private final UnaryCallSettings<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicySettings;
  private final UnaryCallSettings<CreateScalingPolicyRequest, Operation>
      createScalingPolicySettings;
  private final OperationCallSettings<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationSettings;
  private final UnaryCallSettings<DeleteScalingPolicyRequest, Operation>
      deleteScalingPolicySettings;
  private final OperationCallSettings<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationSettings;
  private final UnaryCallSettings<UpdateScalingPolicyRequest, Operation>
      updateScalingPolicySettings;
  private final OperationCallSettings<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationSettings;

  /** Returns the object with the settings used for calls to listScalingPolicies. */
  public PagedCallSettings<
          ListScalingPoliciesRequest, ListScalingPoliciesResponse, ListScalingPoliciesPagedResponse>
      listScalingPoliciesSettings() {
    return listScalingPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getScalingPolicy. */
  public UnaryCallSettings<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicySettings() {
    return getScalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to createScalingPolicy. */
  public UnaryCallSettings<CreateScalingPolicyRequest, Operation> createScalingPolicySettings() {
    return createScalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to createScalingPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationSettings() {
    return createScalingPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteScalingPolicy. */
  public UnaryCallSettings<DeleteScalingPolicyRequest, Operation> deleteScalingPolicySettings() {
    return deleteScalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteScalingPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationSettings() {
    return deleteScalingPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateScalingPolicy. */
  public UnaryCallSettings<UpdateScalingPolicyRequest, Operation> updateScalingPolicySettings() {
    return updateScalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateScalingPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationSettings() {
    return updateScalingPolicyOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ScalingPoliciesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcScalingPoliciesServiceStub.create(this);
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
    return "gameservices.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ScalingPoliciesServiceStubSettings.class))
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

  protected ScalingPoliciesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listScalingPoliciesSettings = settingsBuilder.listScalingPoliciesSettings().build();
    getScalingPolicySettings = settingsBuilder.getScalingPolicySettings().build();
    createScalingPolicySettings = settingsBuilder.createScalingPolicySettings().build();
    createScalingPolicyOperationSettings =
        settingsBuilder.createScalingPolicyOperationSettings().build();
    deleteScalingPolicySettings = settingsBuilder.deleteScalingPolicySettings().build();
    deleteScalingPolicyOperationSettings =
        settingsBuilder.deleteScalingPolicyOperationSettings().build();
    updateScalingPolicySettings = settingsBuilder.updateScalingPolicySettings().build();
    updateScalingPolicyOperationSettings =
        settingsBuilder.updateScalingPolicyOperationSettings().build();
  }

  private static final PagedListDescriptor<
          ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy>
      LIST_SCALING_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScalingPoliciesRequest injectToken(
                ListScalingPoliciesRequest payload, String token) {
              return ListScalingPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScalingPoliciesRequest injectPageSize(
                ListScalingPoliciesRequest payload, int pageSize) {
              return ListScalingPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScalingPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScalingPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScalingPolicy> extractResources(ListScalingPoliciesResponse payload) {
              return payload.getScalingPoliciesList() != null
                  ? payload.getScalingPoliciesList()
                  : ImmutableList.<ScalingPolicy>of();
            }
          };

  private static final PagedListResponseFactory<
          ListScalingPoliciesRequest, ListScalingPoliciesResponse, ListScalingPoliciesPagedResponse>
      LIST_SCALING_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScalingPoliciesRequest,
              ListScalingPoliciesResponse,
              ListScalingPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListScalingPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesResponse> callable,
                ListScalingPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListScalingPoliciesResponse> futureResponse) {
              PageContext<ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SCALING_POLICIES_PAGE_STR_DESC, request, context);
              return ListScalingPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ScalingPoliciesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ScalingPoliciesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListScalingPoliciesRequest,
            ListScalingPoliciesResponse,
            ListScalingPoliciesPagedResponse>
        listScalingPoliciesSettings;
    private final UnaryCallSettings.Builder<GetScalingPolicyRequest, ScalingPolicy>
        getScalingPolicySettings;
    private final UnaryCallSettings.Builder<CreateScalingPolicyRequest, Operation>
        createScalingPolicySettings;
    private final OperationCallSettings.Builder<CreateScalingPolicyRequest, ScalingPolicy, Empty>
        createScalingPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteScalingPolicyRequest, Operation>
        deleteScalingPolicySettings;
    private final OperationCallSettings.Builder<DeleteScalingPolicyRequest, Empty, Empty>
        deleteScalingPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateScalingPolicyRequest, Operation>
        updateScalingPolicySettings;
    private final OperationCallSettings.Builder<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
        updateScalingPolicyOperationSettings;

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

      listScalingPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_SCALING_POLICIES_PAGE_STR_FACT);

      getScalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createScalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createScalingPolicyOperationSettings = OperationCallSettings.newBuilder();

      deleteScalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteScalingPolicyOperationSettings = OperationCallSettings.newBuilder();

      updateScalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateScalingPolicyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listScalingPoliciesSettings,
              getScalingPolicySettings,
              createScalingPolicySettings,
              deleteScalingPolicySettings,
              updateScalingPolicySettings);

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
          .listScalingPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getScalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createScalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteScalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateScalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createScalingPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateScalingPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ScalingPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));
      builder
          .deleteScalingPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteScalingPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));
      builder
          .updateScalingPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateScalingPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ScalingPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    protected Builder(ScalingPoliciesServiceStubSettings settings) {
      super(settings);

      listScalingPoliciesSettings = settings.listScalingPoliciesSettings.toBuilder();
      getScalingPolicySettings = settings.getScalingPolicySettings.toBuilder();
      createScalingPolicySettings = settings.createScalingPolicySettings.toBuilder();
      createScalingPolicyOperationSettings =
          settings.createScalingPolicyOperationSettings.toBuilder();
      deleteScalingPolicySettings = settings.deleteScalingPolicySettings.toBuilder();
      deleteScalingPolicyOperationSettings =
          settings.deleteScalingPolicyOperationSettings.toBuilder();
      updateScalingPolicySettings = settings.updateScalingPolicySettings.toBuilder();
      updateScalingPolicyOperationSettings =
          settings.updateScalingPolicyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listScalingPoliciesSettings,
              getScalingPolicySettings,
              createScalingPolicySettings,
              deleteScalingPolicySettings,
              updateScalingPolicySettings);
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

    /** Returns the builder for the settings used for calls to listScalingPolicies. */
    public PagedCallSettings.Builder<
            ListScalingPoliciesRequest,
            ListScalingPoliciesResponse,
            ListScalingPoliciesPagedResponse>
        listScalingPoliciesSettings() {
      return listScalingPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getScalingPolicy. */
    public UnaryCallSettings.Builder<GetScalingPolicyRequest, ScalingPolicy>
        getScalingPolicySettings() {
      return getScalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createScalingPolicy. */
    public UnaryCallSettings.Builder<CreateScalingPolicyRequest, Operation>
        createScalingPolicySettings() {
      return createScalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createScalingPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateScalingPolicyRequest, ScalingPolicy, Empty>
        createScalingPolicyOperationSettings() {
      return createScalingPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScalingPolicy. */
    public UnaryCallSettings.Builder<DeleteScalingPolicyRequest, Operation>
        deleteScalingPolicySettings() {
      return deleteScalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteScalingPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteScalingPolicyRequest, Empty, Empty>
        deleteScalingPolicyOperationSettings() {
      return deleteScalingPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateScalingPolicy. */
    public UnaryCallSettings.Builder<UpdateScalingPolicyRequest, Operation>
        updateScalingPolicySettings() {
      return updateScalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateScalingPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
        updateScalingPolicyOperationSettings() {
      return updateScalingPolicyOperationSettings;
    }

    @Override
    public ScalingPoliciesServiceStubSettings build() throws IOException {
      return new ScalingPoliciesServiceStubSettings(this);
    }
  }
}
