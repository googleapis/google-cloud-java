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

package com.google.cloud.gkehub.v1alpha2.stub;

import static com.google.cloud.gkehub.v1alpha2.GkeHubClient.ListMembershipsPagedResponse;

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
import com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1alpha2.GetMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.InitializeHubRequest;
import com.google.cloud.gkehub.v1alpha2.InitializeHubResponse;
import com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest;
import com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse;
import com.google.cloud.gkehub.v1alpha2.Membership;
import com.google.cloud.gkehub.v1alpha2.OperationMetadata;
import com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest;
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
 * Settings class to configure an instance of {@link GkeHubStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkehub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMembership to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubStubSettings.Builder gkeHubSettingsBuilder = GkeHubStubSettings.newBuilder();
 * gkeHubSettingsBuilder
 *     .getMembershipSettings()
 *     .setRetrySettings(
 *         gkeHubSettingsBuilder
 *             .getMembershipSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GkeHubStubSettings gkeHubSettings = gkeHubSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GkeHubStubSettings extends StubSettings<GkeHubStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings;
  private final UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings;
  private final UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings;
  private final OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings;
  private final UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings;
  private final OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings;
  private final UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings;
  private final OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings;
  private final UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings;
  private final UnaryCallSettings<InitializeHubRequest, InitializeHubResponse>
      initializeHubSettings;

  private static final PagedListDescriptor<
          ListMembershipsRequest, ListMembershipsResponse, Membership>
      LIST_MEMBERSHIPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMembershipsRequest, ListMembershipsResponse, Membership>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipsRequest injectToken(
                ListMembershipsRequest payload, String token) {
              return ListMembershipsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembershipsRequest injectPageSize(
                ListMembershipsRequest payload, int pageSize) {
              return ListMembershipsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMembershipsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Membership> extractResources(ListMembershipsResponse payload) {
              return payload.getResourcesList() == null
                  ? ImmutableList.<Membership>of()
                  : payload.getResourcesList();
            }
          };

  private static final PagedListResponseFactory<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      LIST_MEMBERSHIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> callable,
                ListMembershipsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipsResponse> futureResponse) {
              PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> pageContext =
                  PageContext.create(callable, LIST_MEMBERSHIPS_PAGE_STR_DESC, request, context);
              return ListMembershipsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return listMembershipsSettings;
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return getMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings() {
    return createMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings() {
    return createMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings() {
    return deleteMembershipSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings() {
    return deleteMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings() {
    return updateMembershipSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings() {
    return updateMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateConnectManifest. */
  public UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings() {
    return generateConnectManifestSettings;
  }

  /** Returns the object with the settings used for calls to initializeHub. */
  public UnaryCallSettings<InitializeHubRequest, InitializeHubResponse> initializeHubSettings() {
    return initializeHubSettings;
  }

  public GkeHubStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGkeHubStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGkeHubStub.create(this);
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
    return "gkehub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkehub.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected GkeHubStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMembershipsSettings = settingsBuilder.listMembershipsSettings().build();
    getMembershipSettings = settingsBuilder.getMembershipSettings().build();
    createMembershipSettings = settingsBuilder.createMembershipSettings().build();
    createMembershipOperationSettings = settingsBuilder.createMembershipOperationSettings().build();
    deleteMembershipSettings = settingsBuilder.deleteMembershipSettings().build();
    deleteMembershipOperationSettings = settingsBuilder.deleteMembershipOperationSettings().build();
    updateMembershipSettings = settingsBuilder.updateMembershipSettings().build();
    updateMembershipOperationSettings = settingsBuilder.updateMembershipOperationSettings().build();
    generateConnectManifestSettings = settingsBuilder.generateConnectManifestSettings().build();
    initializeHubSettings = settingsBuilder.initializeHubSettings().build();
  }

  /** Builder for GkeHubStubSettings. */
  public static class Builder extends StubSettings.Builder<GkeHubStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings;
    private final UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings;
    private final UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings;
    private final OperationCallSettings.Builder<
            CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings;
    private final OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings;
    private final OperationCallSettings.Builder<
            UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings;
    private final UnaryCallSettings.Builder<InitializeHubRequest, InitializeHubResponse>
        initializeHubSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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

      listMembershipsSettings = PagedCallSettings.newBuilder(LIST_MEMBERSHIPS_PAGE_STR_FACT);
      getMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipOperationSettings = OperationCallSettings.newBuilder();
      deleteMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipOperationSettings = OperationCallSettings.newBuilder();
      updateMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipOperationSettings = OperationCallSettings.newBuilder();
      generateConnectManifestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      initializeHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              getMembershipSettings,
              createMembershipSettings,
              deleteMembershipSettings,
              updateMembershipSettings,
              generateConnectManifestSettings,
              initializeHubSettings);
      initDefaults(this);
    }

    protected Builder(GkeHubStubSettings settings) {
      super(settings);

      listMembershipsSettings = settings.listMembershipsSettings.toBuilder();
      getMembershipSettings = settings.getMembershipSettings.toBuilder();
      createMembershipSettings = settings.createMembershipSettings.toBuilder();
      createMembershipOperationSettings = settings.createMembershipOperationSettings.toBuilder();
      deleteMembershipSettings = settings.deleteMembershipSettings.toBuilder();
      deleteMembershipOperationSettings = settings.deleteMembershipOperationSettings.toBuilder();
      updateMembershipSettings = settings.updateMembershipSettings.toBuilder();
      updateMembershipOperationSettings = settings.updateMembershipOperationSettings.toBuilder();
      generateConnectManifestSettings = settings.generateConnectManifestSettings.toBuilder();
      initializeHubSettings = settings.initializeHubSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              getMembershipSettings,
              createMembershipSettings,
              deleteMembershipSettings,
              updateMembershipSettings,
              generateConnectManifestSettings,
              initializeHubSettings);
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
          .listMembershipsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateConnectManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .initializeHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
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
          .deleteMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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

      builder
          .updateMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
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

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return listMembershipsSettings;
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings() {
      return createMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings() {
      return createMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings() {
      return deleteMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings() {
      return deleteMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings() {
      return updateMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings() {
      return updateMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateConnectManifest. */
    public UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings() {
      return generateConnectManifestSettings;
    }

    /** Returns the builder for the settings used for calls to initializeHub. */
    public UnaryCallSettings.Builder<InitializeHubRequest, InitializeHubResponse>
        initializeHubSettings() {
      return initializeHubSettings;
    }

    @Override
    public GkeHubStubSettings build() throws IOException {
      return new GkeHubStubSettings(this);
    }
  }
}
