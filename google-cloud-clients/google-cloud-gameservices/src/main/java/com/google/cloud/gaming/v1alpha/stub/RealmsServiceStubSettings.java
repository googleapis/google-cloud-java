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

import static com.google.cloud.gaming.v1alpha.RealmsServiceClient.ListRealmsPagedResponse;

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
import com.google.cloud.gaming.v1alpha.CreateRealmRequest;
import com.google.cloud.gaming.v1alpha.DeleteRealmRequest;
import com.google.cloud.gaming.v1alpha.GetRealmRequest;
import com.google.cloud.gaming.v1alpha.ListRealmsRequest;
import com.google.cloud.gaming.v1alpha.ListRealmsResponse;
import com.google.cloud.gaming.v1alpha.Realm;
import com.google.cloud.gaming.v1alpha.UpdateRealmRequest;
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
 * Settings class to configure an instance of {@link RealmsServiceStub}.
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
 * example, to set the total timeout of getRealm to 30 seconds:
 *
 * <pre>
 * <code>
 * RealmsServiceStubSettings.Builder realmsServiceSettingsBuilder =
 *     RealmsServiceStubSettings.newBuilder();
 * realmsServiceSettingsBuilder.getRealmSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RealmsServiceStubSettings realmsServiceSettings = realmsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RealmsServiceStubSettings extends StubSettings<RealmsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings;
  private final UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings;
  private final UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings;
  private final OperationCallSettings<CreateRealmRequest, Realm, Empty>
      createRealmOperationSettings;
  private final UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings;
  private final OperationCallSettings<DeleteRealmRequest, Empty, Empty>
      deleteRealmOperationSettings;
  private final UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings;
  private final OperationCallSettings<UpdateRealmRequest, Realm, Empty>
      updateRealmOperationSettings;

  /** Returns the object with the settings used for calls to listRealms. */
  public PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings() {
    return listRealmsSettings;
  }

  /** Returns the object with the settings used for calls to getRealm. */
  public UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings() {
    return getRealmSettings;
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings() {
    return createRealmSettings;
  }

  /** Returns the object with the settings used for calls to createRealm. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateRealmRequest, Realm, Empty> createRealmOperationSettings() {
    return createRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings() {
    return deleteRealmSettings;
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteRealmRequest, Empty, Empty> deleteRealmOperationSettings() {
    return deleteRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings() {
    return updateRealmSettings;
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateRealmRequest, Realm, Empty> updateRealmOperationSettings() {
    return updateRealmOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RealmsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRealmsServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RealmsServiceStubSettings.class))
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

  protected RealmsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listRealmsSettings = settingsBuilder.listRealmsSettings().build();
    getRealmSettings = settingsBuilder.getRealmSettings().build();
    createRealmSettings = settingsBuilder.createRealmSettings().build();
    createRealmOperationSettings = settingsBuilder.createRealmOperationSettings().build();
    deleteRealmSettings = settingsBuilder.deleteRealmSettings().build();
    deleteRealmOperationSettings = settingsBuilder.deleteRealmOperationSettings().build();
    updateRealmSettings = settingsBuilder.updateRealmSettings().build();
    updateRealmOperationSettings = settingsBuilder.updateRealmOperationSettings().build();
  }

  private static final PagedListDescriptor<ListRealmsRequest, ListRealmsResponse, Realm>
      LIST_REALMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRealmsRequest, ListRealmsResponse, Realm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRealmsRequest injectToken(ListRealmsRequest payload, String token) {
              return ListRealmsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRealmsRequest injectPageSize(ListRealmsRequest payload, int pageSize) {
              return ListRealmsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRealmsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRealmsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Realm> extractResources(ListRealmsResponse payload) {
              return payload.getRealmsList() != null
                  ? payload.getRealmsList()
                  : ImmutableList.<Realm>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      LIST_REALMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>() {
            @Override
            public ApiFuture<ListRealmsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRealmsRequest, ListRealmsResponse> callable,
                ListRealmsRequest request,
                ApiCallContext context,
                ApiFuture<ListRealmsResponse> futureResponse) {
              PageContext<ListRealmsRequest, ListRealmsResponse, Realm> pageContext =
                  PageContext.create(callable, LIST_REALMS_PAGE_STR_DESC, request, context);
              return ListRealmsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RealmsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<RealmsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings;
    private final UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings;
    private final UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings;
    private final OperationCallSettings.Builder<CreateRealmRequest, Realm, Empty>
        createRealmOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings;
    private final OperationCallSettings.Builder<DeleteRealmRequest, Empty, Empty>
        deleteRealmOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings;
    private final OperationCallSettings.Builder<UpdateRealmRequest, Realm, Empty>
        updateRealmOperationSettings;

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

      listRealmsSettings = PagedCallSettings.newBuilder(LIST_REALMS_PAGE_STR_FACT);

      getRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createRealmOperationSettings = OperationCallSettings.newBuilder();

      deleteRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteRealmOperationSettings = OperationCallSettings.newBuilder();

      updateRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateRealmOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRealmsSettings,
              getRealmSettings,
              createRealmSettings,
              deleteRealmSettings,
              updateRealmSettings);

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
          .listRealmsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Realm.class))
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
          .deleteRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Realm.class))
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

    protected Builder(RealmsServiceStubSettings settings) {
      super(settings);

      listRealmsSettings = settings.listRealmsSettings.toBuilder();
      getRealmSettings = settings.getRealmSettings.toBuilder();
      createRealmSettings = settings.createRealmSettings.toBuilder();
      createRealmOperationSettings = settings.createRealmOperationSettings.toBuilder();
      deleteRealmSettings = settings.deleteRealmSettings.toBuilder();
      deleteRealmOperationSettings = settings.deleteRealmOperationSettings.toBuilder();
      updateRealmSettings = settings.updateRealmSettings.toBuilder();
      updateRealmOperationSettings = settings.updateRealmOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRealmsSettings,
              getRealmSettings,
              createRealmSettings,
              deleteRealmSettings,
              updateRealmSettings);
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

    /** Returns the builder for the settings used for calls to listRealms. */
    public PagedCallSettings.Builder<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings() {
      return listRealmsSettings;
    }

    /** Returns the builder for the settings used for calls to getRealm. */
    public UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings() {
      return getRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings() {
      return createRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateRealmRequest, Realm, Empty>
        createRealmOperationSettings() {
      return createRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings() {
      return deleteRealmSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteRealmRequest, Empty, Empty>
        deleteRealmOperationSettings() {
      return deleteRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings() {
      return updateRealmSettings;
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateRealmRequest, Realm, Empty>
        updateRealmOperationSettings() {
      return updateRealmOperationSettings;
    }

    @Override
    public RealmsServiceStubSettings build() throws IOException {
      return new RealmsServiceStubSettings(this);
    }
  }
}
