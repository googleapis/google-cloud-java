/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Assistant;
import com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.GetAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse;
import com.google.cloud.discoveryengine.v1beta.StreamAssistRequest;
import com.google.cloud.discoveryengine.v1beta.StreamAssistResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssistantServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createAssistant:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssistantServiceStubSettings.Builder assistantServiceSettingsBuilder =
 *     AssistantServiceStubSettings.newBuilder();
 * assistantServiceSettingsBuilder
 *     .createAssistantSettings()
 *     .setRetrySettings(
 *         assistantServiceSettingsBuilder
 *             .createAssistantSettings()
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
 * AssistantServiceStubSettings assistantServiceSettings = assistantServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AssistantServiceStubSettings extends StubSettings<AssistantServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/discoveryengine.assist.readwrite")
          .add("https://www.googleapis.com/auth/discoveryengine.readwrite")
          .add("https://www.googleapis.com/auth/discoveryengine.serving.readwrite")
          .build();

  private final ServerStreamingCallSettings<StreamAssistRequest, StreamAssistResponse>
      streamAssistSettings;
  private final UnaryCallSettings<CreateAssistantRequest, Assistant> createAssistantSettings;
  private final UnaryCallSettings<DeleteAssistantRequest, Empty> deleteAssistantSettings;
  private final UnaryCallSettings<UpdateAssistantRequest, Assistant> updateAssistantSettings;
  private final UnaryCallSettings<GetAssistantRequest, Assistant> getAssistantSettings;
  private final PagedCallSettings<
          ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>
      listAssistantsSettings;

  private static final PagedListDescriptor<ListAssistantsRequest, ListAssistantsResponse, Assistant>
      LIST_ASSISTANTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssistantsRequest, ListAssistantsResponse, Assistant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssistantsRequest injectToken(ListAssistantsRequest payload, String token) {
              return ListAssistantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssistantsRequest injectPageSize(
                ListAssistantsRequest payload, int pageSize) {
              return ListAssistantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssistantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssistantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Assistant> extractResources(ListAssistantsResponse payload) {
              return payload.getAssistantsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>
      LIST_ASSISTANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>() {
            @Override
            public ApiFuture<ListAssistantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> callable,
                ListAssistantsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssistantsResponse> futureResponse) {
              PageContext<ListAssistantsRequest, ListAssistantsResponse, Assistant> pageContext =
                  PageContext.create(callable, LIST_ASSISTANTS_PAGE_STR_DESC, request, context);
              return ListAssistantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to streamAssist. */
  public ServerStreamingCallSettings<StreamAssistRequest, StreamAssistResponse>
      streamAssistSettings() {
    return streamAssistSettings;
  }

  /** Returns the object with the settings used for calls to createAssistant. */
  public UnaryCallSettings<CreateAssistantRequest, Assistant> createAssistantSettings() {
    return createAssistantSettings;
  }

  /** Returns the object with the settings used for calls to deleteAssistant. */
  public UnaryCallSettings<DeleteAssistantRequest, Empty> deleteAssistantSettings() {
    return deleteAssistantSettings;
  }

  /** Returns the object with the settings used for calls to updateAssistant. */
  public UnaryCallSettings<UpdateAssistantRequest, Assistant> updateAssistantSettings() {
    return updateAssistantSettings;
  }

  /** Returns the object with the settings used for calls to getAssistant. */
  public UnaryCallSettings<GetAssistantRequest, Assistant> getAssistantSettings() {
    return getAssistantSettings;
  }

  /** Returns the object with the settings used for calls to listAssistants. */
  public PagedCallSettings<
          ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>
      listAssistantsSettings() {
    return listAssistantsSettings;
  }

  public AssistantServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAssistantServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAssistantServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AssistantServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AssistantServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssistantServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AssistantServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    streamAssistSettings = settingsBuilder.streamAssistSettings().build();
    createAssistantSettings = settingsBuilder.createAssistantSettings().build();
    deleteAssistantSettings = settingsBuilder.deleteAssistantSettings().build();
    updateAssistantSettings = settingsBuilder.updateAssistantSettings().build();
    getAssistantSettings = settingsBuilder.getAssistantSettings().build();
    listAssistantsSettings = settingsBuilder.listAssistantsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-discoveryengine")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AssistantServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AssistantServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final ServerStreamingCallSettings.Builder<StreamAssistRequest, StreamAssistResponse>
        streamAssistSettings;
    private final UnaryCallSettings.Builder<CreateAssistantRequest, Assistant>
        createAssistantSettings;
    private final UnaryCallSettings.Builder<DeleteAssistantRequest, Empty> deleteAssistantSettings;
    private final UnaryCallSettings.Builder<UpdateAssistantRequest, Assistant>
        updateAssistantSettings;
    private final UnaryCallSettings.Builder<GetAssistantRequest, Assistant> getAssistantSettings;
    private final PagedCallSettings.Builder<
            ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>
        listAssistantsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_4_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(30000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("retry_policy_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      streamAssistSettings = ServerStreamingCallSettings.newBuilder();
      createAssistantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAssistantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAssistantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAssistantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAssistantsSettings = PagedCallSettings.newBuilder(LIST_ASSISTANTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssistantSettings,
              deleteAssistantSettings,
              updateAssistantSettings,
              getAssistantSettings,
              listAssistantsSettings);
      initDefaults(this);
    }

    protected Builder(AssistantServiceStubSettings settings) {
      super(settings);

      streamAssistSettings = settings.streamAssistSettings.toBuilder();
      createAssistantSettings = settings.createAssistantSettings.toBuilder();
      deleteAssistantSettings = settings.deleteAssistantSettings.toBuilder();
      updateAssistantSettings = settings.updateAssistantSettings.toBuilder();
      getAssistantSettings = settings.getAssistantSettings.toBuilder();
      listAssistantsSettings = settings.listAssistantsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssistantSettings,
              deleteAssistantSettings,
              updateAssistantSettings,
              getAssistantSettings,
              listAssistantsSettings);
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
          .streamAssistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .createAssistantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteAssistantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateAssistantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getAssistantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listAssistantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to streamAssist. */
    public ServerStreamingCallSettings.Builder<StreamAssistRequest, StreamAssistResponse>
        streamAssistSettings() {
      return streamAssistSettings;
    }

    /** Returns the builder for the settings used for calls to createAssistant. */
    public UnaryCallSettings.Builder<CreateAssistantRequest, Assistant> createAssistantSettings() {
      return createAssistantSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAssistant. */
    public UnaryCallSettings.Builder<DeleteAssistantRequest, Empty> deleteAssistantSettings() {
      return deleteAssistantSettings;
    }

    /** Returns the builder for the settings used for calls to updateAssistant. */
    public UnaryCallSettings.Builder<UpdateAssistantRequest, Assistant> updateAssistantSettings() {
      return updateAssistantSettings;
    }

    /** Returns the builder for the settings used for calls to getAssistant. */
    public UnaryCallSettings.Builder<GetAssistantRequest, Assistant> getAssistantSettings() {
      return getAssistantSettings;
    }

    /** Returns the builder for the settings used for calls to listAssistants. */
    public PagedCallSettings.Builder<
            ListAssistantsRequest, ListAssistantsResponse, ListAssistantsPagedResponse>
        listAssistantsSettings() {
      return listAssistantsSettings;
    }

    @Override
    public AssistantServiceStubSettings build() throws IOException {
      return new AssistantServiceStubSettings(this);
    }
  }
}
