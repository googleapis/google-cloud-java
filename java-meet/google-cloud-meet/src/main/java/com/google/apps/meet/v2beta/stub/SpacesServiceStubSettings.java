/*
 * Copyright 2025 Google LLC
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

package com.google.apps.meet.v2beta.stub;

import static com.google.apps.meet.v2beta.SpacesServiceClient.ListMembersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.apps.meet.v2beta.ConnectActiveConferenceRequest;
import com.google.apps.meet.v2beta.ConnectActiveConferenceResponse;
import com.google.apps.meet.v2beta.CreateMemberRequest;
import com.google.apps.meet.v2beta.CreateSpaceRequest;
import com.google.apps.meet.v2beta.DeleteMemberRequest;
import com.google.apps.meet.v2beta.EndActiveConferenceRequest;
import com.google.apps.meet.v2beta.GetMemberRequest;
import com.google.apps.meet.v2beta.GetSpaceRequest;
import com.google.apps.meet.v2beta.ListMembersRequest;
import com.google.apps.meet.v2beta.ListMembersResponse;
import com.google.apps.meet.v2beta.Member;
import com.google.apps.meet.v2beta.Space;
import com.google.apps.meet.v2beta.UpdateSpaceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SpacesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (meet.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSpace:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpacesServiceStubSettings.Builder spacesServiceSettingsBuilder =
 *     SpacesServiceStubSettings.newBuilder();
 * spacesServiceSettingsBuilder
 *     .createSpaceSettings()
 *     .setRetrySettings(
 *         spacesServiceSettingsBuilder
 *             .createSpaceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * SpacesServiceStubSettings spacesServiceSettings = spacesServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SpacesServiceStubSettings extends StubSettings<SpacesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/meetings.conference.media.audio.readonly")
          .add("https://www.googleapis.com/auth/meetings.conference.media.readonly")
          .add("https://www.googleapis.com/auth/meetings.conference.media.video.readonly")
          .add("https://www.googleapis.com/auth/meetings.space.created")
          .add("https://www.googleapis.com/auth/meetings.space.readonly")
          .add("https://www.googleapis.com/auth/meetings.space.settings")
          .build();

  private final UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings;
  private final UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings;
  private final UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings;
  private final UnaryCallSettings<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceSettings;
  private final UnaryCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceSettings;
  private final UnaryCallSettings<CreateMemberRequest, Member> createMemberSettings;
  private final UnaryCallSettings<GetMemberRequest, Member> getMemberSettings;
  private final PagedCallSettings<ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>
      listMembersSettings;
  private final UnaryCallSettings<DeleteMemberRequest, Empty> deleteMemberSettings;

  private static final PagedListDescriptor<ListMembersRequest, ListMembersResponse, Member>
      LIST_MEMBERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMembersRequest, ListMembersResponse, Member>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembersRequest injectToken(ListMembersRequest payload, String token) {
              return ListMembersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembersRequest injectPageSize(ListMembersRequest payload, int pageSize) {
              return ListMembersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMembersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Member> extractResources(ListMembersResponse payload) {
              return payload.getMembersList();
            }
          };

  private static final PagedListResponseFactory<
          ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>
      LIST_MEMBERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>() {
            @Override
            public ApiFuture<ListMembersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembersRequest, ListMembersResponse> callable,
                ListMembersRequest request,
                ApiCallContext context,
                ApiFuture<ListMembersResponse> futureResponse) {
              PageContext<ListMembersRequest, ListMembersResponse, Member> pageContext =
                  PageContext.create(callable, LIST_MEMBERS_PAGE_STR_DESC, request, context);
              return ListMembersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSpace. */
  public UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings() {
    return createSpaceSettings;
  }

  /** Returns the object with the settings used for calls to getSpace. */
  public UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings() {
    return getSpaceSettings;
  }

  /** Returns the object with the settings used for calls to updateSpace. */
  public UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings() {
    return updateSpaceSettings;
  }

  /** Returns the object with the settings used for calls to connectActiveConference. */
  public UnaryCallSettings<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceSettings() {
    return connectActiveConferenceSettings;
  }

  /** Returns the object with the settings used for calls to endActiveConference. */
  public UnaryCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceSettings() {
    return endActiveConferenceSettings;
  }

  /** Returns the object with the settings used for calls to createMember. */
  public UnaryCallSettings<CreateMemberRequest, Member> createMemberSettings() {
    return createMemberSettings;
  }

  /** Returns the object with the settings used for calls to getMember. */
  public UnaryCallSettings<GetMemberRequest, Member> getMemberSettings() {
    return getMemberSettings;
  }

  /** Returns the object with the settings used for calls to listMembers. */
  public PagedCallSettings<ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>
      listMembersSettings() {
    return listMembersSettings;
  }

  /** Returns the object with the settings used for calls to deleteMember. */
  public UnaryCallSettings<DeleteMemberRequest, Empty> deleteMemberSettings() {
    return deleteMemberSettings;
  }

  public SpacesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSpacesServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSpacesServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "meet";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "meet.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "meet.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SpacesServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SpacesServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpacesServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SpacesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSpaceSettings = settingsBuilder.createSpaceSettings().build();
    getSpaceSettings = settingsBuilder.getSpaceSettings().build();
    updateSpaceSettings = settingsBuilder.updateSpaceSettings().build();
    connectActiveConferenceSettings = settingsBuilder.connectActiveConferenceSettings().build();
    endActiveConferenceSettings = settingsBuilder.endActiveConferenceSettings().build();
    createMemberSettings = settingsBuilder.createMemberSettings().build();
    getMemberSettings = settingsBuilder.getMemberSettings().build();
    listMembersSettings = settingsBuilder.listMembersSettings().build();
    deleteMemberSettings = settingsBuilder.deleteMemberSettings().build();
  }

  /** Builder for SpacesServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SpacesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings;
    private final UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings;
    private final UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings;
    private final UnaryCallSettings.Builder<
            ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
        connectActiveConferenceSettings;
    private final UnaryCallSettings.Builder<EndActiveConferenceRequest, Empty>
        endActiveConferenceSettings;
    private final UnaryCallSettings.Builder<CreateMemberRequest, Member> createMemberSettings;
    private final UnaryCallSettings.Builder<GetMemberRequest, Member> getMemberSettings;
    private final PagedCallSettings.Builder<
            ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>
        listMembersSettings;
    private final UnaryCallSettings.Builder<DeleteMemberRequest, Empty> deleteMemberSettings;
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
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      connectActiveConferenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      endActiveConferenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMembersSettings = PagedCallSettings.newBuilder(LIST_MEMBERS_PAGE_STR_FACT);
      deleteMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSpaceSettings,
              getSpaceSettings,
              updateSpaceSettings,
              connectActiveConferenceSettings,
              endActiveConferenceSettings,
              createMemberSettings,
              getMemberSettings,
              listMembersSettings,
              deleteMemberSettings);
      initDefaults(this);
    }

    protected Builder(SpacesServiceStubSettings settings) {
      super(settings);

      createSpaceSettings = settings.createSpaceSettings.toBuilder();
      getSpaceSettings = settings.getSpaceSettings.toBuilder();
      updateSpaceSettings = settings.updateSpaceSettings.toBuilder();
      connectActiveConferenceSettings = settings.connectActiveConferenceSettings.toBuilder();
      endActiveConferenceSettings = settings.endActiveConferenceSettings.toBuilder();
      createMemberSettings = settings.createMemberSettings.toBuilder();
      getMemberSettings = settings.getMemberSettings.toBuilder();
      listMembersSettings = settings.listMembersSettings.toBuilder();
      deleteMemberSettings = settings.deleteMemberSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSpaceSettings,
              getSpaceSettings,
              updateSpaceSettings,
              connectActiveConferenceSettings,
              endActiveConferenceSettings,
              createMemberSettings,
              getMemberSettings,
              listMembersSettings,
              deleteMemberSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .connectActiveConferenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .endActiveConferenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listMembersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to createSpace. */
    public UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings() {
      return createSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to getSpace. */
    public UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings() {
      return getSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpace. */
    public UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings() {
      return updateSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to connectActiveConference. */
    public UnaryCallSettings.Builder<
            ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
        connectActiveConferenceSettings() {
      return connectActiveConferenceSettings;
    }

    /** Returns the builder for the settings used for calls to endActiveConference. */
    public UnaryCallSettings.Builder<EndActiveConferenceRequest, Empty>
        endActiveConferenceSettings() {
      return endActiveConferenceSettings;
    }

    /** Returns the builder for the settings used for calls to createMember. */
    public UnaryCallSettings.Builder<CreateMemberRequest, Member> createMemberSettings() {
      return createMemberSettings;
    }

    /** Returns the builder for the settings used for calls to getMember. */
    public UnaryCallSettings.Builder<GetMemberRequest, Member> getMemberSettings() {
      return getMemberSettings;
    }

    /** Returns the builder for the settings used for calls to listMembers. */
    public PagedCallSettings.Builder<
            ListMembersRequest, ListMembersResponse, ListMembersPagedResponse>
        listMembersSettings() {
      return listMembersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMember. */
    public UnaryCallSettings.Builder<DeleteMemberRequest, Empty> deleteMemberSettings() {
      return deleteMemberSettings;
    }

    @Override
    public SpacesServiceStubSettings build() throws IOException {
      return new SpacesServiceStubSettings(this);
    }
  }
}
