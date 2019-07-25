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

import static com.google.cloud.gaming.v1alpha.AllocationPoliciesServiceClient.ListAllocationPoliciesPagedResponse;

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
import com.google.cloud.gaming.v1alpha.AllocationPolicy;
import com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse;
import com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest;
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
 * Settings class to configure an instance of {@link AllocationPoliciesServiceStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAllocationPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * AllocationPoliciesServiceStubSettings.Builder allocationPoliciesServiceSettingsBuilder =
 *     AllocationPoliciesServiceStubSettings.newBuilder();
 * allocationPoliciesServiceSettingsBuilder.getAllocationPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AllocationPoliciesServiceStubSettings allocationPoliciesServiceSettings = allocationPoliciesServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AllocationPoliciesServiceStubSettings
    extends StubSettings<AllocationPoliciesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesSettings;
  private final UnaryCallSettings<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicySettings;
  private final UnaryCallSettings<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicySettings;
  private final OperationCallSettings<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationSettings;
  private final UnaryCallSettings<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicySettings;
  private final OperationCallSettings<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationSettings;
  private final UnaryCallSettings<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicySettings;
  private final OperationCallSettings<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationSettings;

  /** Returns the object with the settings used for calls to listAllocationPolicies. */
  public PagedCallSettings<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesSettings() {
    return listAllocationPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getAllocationPolicy. */
  public UnaryCallSettings<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicySettings() {
    return getAllocationPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAllocationPolicy. */
  public UnaryCallSettings<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicySettings() {
    return createAllocationPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAllocationPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationSettings() {
    return createAllocationPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAllocationPolicy. */
  public UnaryCallSettings<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicySettings() {
    return deleteAllocationPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAllocationPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationSettings() {
    return deleteAllocationPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAllocationPolicy. */
  public UnaryCallSettings<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicySettings() {
    return updateAllocationPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAllocationPolicy. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationSettings() {
    return updateAllocationPolicyOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AllocationPoliciesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAllocationPoliciesServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AllocationPoliciesServiceStubSettings.class))
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

  protected AllocationPoliciesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAllocationPoliciesSettings = settingsBuilder.listAllocationPoliciesSettings().build();
    getAllocationPolicySettings = settingsBuilder.getAllocationPolicySettings().build();
    createAllocationPolicySettings = settingsBuilder.createAllocationPolicySettings().build();
    createAllocationPolicyOperationSettings =
        settingsBuilder.createAllocationPolicyOperationSettings().build();
    deleteAllocationPolicySettings = settingsBuilder.deleteAllocationPolicySettings().build();
    deleteAllocationPolicyOperationSettings =
        settingsBuilder.deleteAllocationPolicyOperationSettings().build();
    updateAllocationPolicySettings = settingsBuilder.updateAllocationPolicySettings().build();
    updateAllocationPolicyOperationSettings =
        settingsBuilder.updateAllocationPolicyOperationSettings().build();
  }

  private static final PagedListDescriptor<
          ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>
      LIST_ALLOCATION_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAllocationPoliciesRequest injectToken(
                ListAllocationPoliciesRequest payload, String token) {
              return ListAllocationPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAllocationPoliciesRequest injectPageSize(
                ListAllocationPoliciesRequest payload, int pageSize) {
              return ListAllocationPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAllocationPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAllocationPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AllocationPolicy> extractResources(
                ListAllocationPoliciesResponse payload) {
              return payload.getAllocationPoliciesList() != null
                  ? payload.getAllocationPoliciesList()
                  : ImmutableList.<AllocationPolicy>of();
            }
          };

  private static final PagedListResponseFactory<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          ListAllocationPoliciesPagedResponse>
      LIST_ALLOCATION_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAllocationPoliciesRequest,
              ListAllocationPoliciesResponse,
              ListAllocationPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAllocationPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
                    callable,
                ListAllocationPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAllocationPoliciesResponse> futureResponse) {
              PageContext<
                      ListAllocationPoliciesRequest,
                      ListAllocationPoliciesResponse,
                      AllocationPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ALLOCATION_POLICIES_PAGE_STR_DESC, request, context);
              return ListAllocationPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for AllocationPoliciesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AllocationPoliciesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListAllocationPoliciesRequest,
            ListAllocationPoliciesResponse,
            ListAllocationPoliciesPagedResponse>
        listAllocationPoliciesSettings;
    private final UnaryCallSettings.Builder<GetAllocationPolicyRequest, AllocationPolicy>
        getAllocationPolicySettings;
    private final UnaryCallSettings.Builder<CreateAllocationPolicyRequest, Operation>
        createAllocationPolicySettings;
    private final OperationCallSettings.Builder<
            CreateAllocationPolicyRequest, AllocationPolicy, Empty>
        createAllocationPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAllocationPolicyRequest, Operation>
        deleteAllocationPolicySettings;
    private final OperationCallSettings.Builder<DeleteAllocationPolicyRequest, Empty, Empty>
        deleteAllocationPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAllocationPolicyRequest, Operation>
        updateAllocationPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
        updateAllocationPolicyOperationSettings;

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

      listAllocationPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_ALLOCATION_POLICIES_PAGE_STR_FACT);

      getAllocationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createAllocationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createAllocationPolicyOperationSettings = OperationCallSettings.newBuilder();

      deleteAllocationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteAllocationPolicyOperationSettings = OperationCallSettings.newBuilder();

      updateAllocationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateAllocationPolicyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAllocationPoliciesSettings,
              getAllocationPolicySettings,
              createAllocationPolicySettings,
              deleteAllocationPolicySettings,
              updateAllocationPolicySettings);

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
          .listAllocationPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getAllocationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createAllocationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteAllocationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateAllocationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createAllocationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAllocationPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AllocationPolicy.class))
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
          .deleteAllocationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAllocationPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateAllocationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAllocationPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AllocationPolicy.class))
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

    protected Builder(AllocationPoliciesServiceStubSettings settings) {
      super(settings);

      listAllocationPoliciesSettings = settings.listAllocationPoliciesSettings.toBuilder();
      getAllocationPolicySettings = settings.getAllocationPolicySettings.toBuilder();
      createAllocationPolicySettings = settings.createAllocationPolicySettings.toBuilder();
      createAllocationPolicyOperationSettings =
          settings.createAllocationPolicyOperationSettings.toBuilder();
      deleteAllocationPolicySettings = settings.deleteAllocationPolicySettings.toBuilder();
      deleteAllocationPolicyOperationSettings =
          settings.deleteAllocationPolicyOperationSettings.toBuilder();
      updateAllocationPolicySettings = settings.updateAllocationPolicySettings.toBuilder();
      updateAllocationPolicyOperationSettings =
          settings.updateAllocationPolicyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAllocationPoliciesSettings,
              getAllocationPolicySettings,
              createAllocationPolicySettings,
              deleteAllocationPolicySettings,
              updateAllocationPolicySettings);
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

    /** Returns the builder for the settings used for calls to listAllocationPolicies. */
    public PagedCallSettings.Builder<
            ListAllocationPoliciesRequest,
            ListAllocationPoliciesResponse,
            ListAllocationPoliciesPagedResponse>
        listAllocationPoliciesSettings() {
      return listAllocationPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getAllocationPolicy. */
    public UnaryCallSettings.Builder<GetAllocationPolicyRequest, AllocationPolicy>
        getAllocationPolicySettings() {
      return getAllocationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAllocationPolicy. */
    public UnaryCallSettings.Builder<CreateAllocationPolicyRequest, Operation>
        createAllocationPolicySettings() {
      return createAllocationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAllocationPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
        createAllocationPolicyOperationSettings() {
      return createAllocationPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAllocationPolicy. */
    public UnaryCallSettings.Builder<DeleteAllocationPolicyRequest, Operation>
        deleteAllocationPolicySettings() {
      return deleteAllocationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAllocationPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAllocationPolicyRequest, Empty, Empty>
        deleteAllocationPolicyOperationSettings() {
      return deleteAllocationPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAllocationPolicy. */
    public UnaryCallSettings.Builder<UpdateAllocationPolicyRequest, Operation>
        updateAllocationPolicySettings() {
      return updateAllocationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAllocationPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
        updateAllocationPolicyOperationSettings() {
      return updateAllocationPolicyOperationSettings;
    }

    @Override
    public AllocationPoliciesServiceStubSettings build() throws IOException {
      return new AllocationPoliciesServiceStubSettings(this);
    }
  }
}
