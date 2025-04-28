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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import google.cloud.chronicle.v1.CreateReferenceListRequest;
import google.cloud.chronicle.v1.GetReferenceListRequest;
import google.cloud.chronicle.v1.ListReferenceListsRequest;
import google.cloud.chronicle.v1.ListReferenceListsResponse;
import google.cloud.chronicle.v1.ReferenceList;
import google.cloud.chronicle.v1.UpdateReferenceListRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReferenceListServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getReferenceList:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReferenceListServiceStubSettings.Builder referenceListServiceSettingsBuilder =
 *     ReferenceListServiceStubSettings.newBuilder();
 * referenceListServiceSettingsBuilder
 *     .getReferenceListSettings()
 *     .setRetrySettings(
 *         referenceListServiceSettingsBuilder
 *             .getReferenceListSettings()
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
 * ReferenceListServiceStubSettings referenceListServiceSettings =
 *     referenceListServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ReferenceListServiceStubSettings
    extends StubSettings<ReferenceListServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetReferenceListRequest, ReferenceList> getReferenceListSettings;
  private final PagedCallSettings<
          ListReferenceListsRequest, ListReferenceListsResponse, ListReferenceListsPagedResponse>
      listReferenceListsSettings;
  private final UnaryCallSettings<CreateReferenceListRequest, ReferenceList>
      createReferenceListSettings;
  private final UnaryCallSettings<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListSettings;

  private static final PagedListDescriptor<
          ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList>
      LIST_REFERENCE_LISTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReferenceListsRequest injectToken(
                ListReferenceListsRequest payload, String token) {
              return ListReferenceListsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReferenceListsRequest injectPageSize(
                ListReferenceListsRequest payload, int pageSize) {
              return ListReferenceListsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReferenceListsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReferenceListsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReferenceList> extractResources(ListReferenceListsResponse payload) {
              return payload.getReferenceListsList();
            }
          };

  private static final PagedListResponseFactory<
          ListReferenceListsRequest, ListReferenceListsResponse, ListReferenceListsPagedResponse>
      LIST_REFERENCE_LISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReferenceListsRequest,
              ListReferenceListsResponse,
              ListReferenceListsPagedResponse>() {
            @Override
            public ApiFuture<ListReferenceListsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse> callable,
                ListReferenceListsRequest request,
                ApiCallContext context,
                ApiFuture<ListReferenceListsResponse> futureResponse) {
              PageContext<ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REFERENCE_LISTS_PAGE_STR_DESC, request, context);
              return ListReferenceListsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getReferenceList. */
  public UnaryCallSettings<GetReferenceListRequest, ReferenceList> getReferenceListSettings() {
    return getReferenceListSettings;
  }

  /** Returns the object with the settings used for calls to listReferenceLists. */
  public PagedCallSettings<
          ListReferenceListsRequest, ListReferenceListsResponse, ListReferenceListsPagedResponse>
      listReferenceListsSettings() {
    return listReferenceListsSettings;
  }

  /** Returns the object with the settings used for calls to createReferenceList. */
  public UnaryCallSettings<CreateReferenceListRequest, ReferenceList>
      createReferenceListSettings() {
    return createReferenceListSettings;
  }

  /** Returns the object with the settings used for calls to updateReferenceList. */
  public UnaryCallSettings<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListSettings() {
    return updateReferenceListSettings;
  }

  public ReferenceListServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcReferenceListServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonReferenceListServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ReferenceListServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ReferenceListServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ReferenceListServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ReferenceListServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getReferenceListSettings = settingsBuilder.getReferenceListSettings().build();
    listReferenceListsSettings = settingsBuilder.listReferenceListsSettings().build();
    createReferenceListSettings = settingsBuilder.createReferenceListSettings().build();
    updateReferenceListSettings = settingsBuilder.updateReferenceListSettings().build();
  }

  /** Builder for ReferenceListServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ReferenceListServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetReferenceListRequest, ReferenceList>
        getReferenceListSettings;
    private final PagedCallSettings.Builder<
            ListReferenceListsRequest, ListReferenceListsResponse, ListReferenceListsPagedResponse>
        listReferenceListsSettings;
    private final UnaryCallSettings.Builder<CreateReferenceListRequest, ReferenceList>
        createReferenceListSettings;
    private final UnaryCallSettings.Builder<UpdateReferenceListRequest, ReferenceList>
        updateReferenceListSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getReferenceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReferenceListsSettings = PagedCallSettings.newBuilder(LIST_REFERENCE_LISTS_PAGE_STR_FACT);
      createReferenceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReferenceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReferenceListSettings,
              listReferenceListsSettings,
              createReferenceListSettings,
              updateReferenceListSettings);
      initDefaults(this);
    }

    protected Builder(ReferenceListServiceStubSettings settings) {
      super(settings);

      getReferenceListSettings = settings.getReferenceListSettings.toBuilder();
      listReferenceListsSettings = settings.listReferenceListsSettings.toBuilder();
      createReferenceListSettings = settings.createReferenceListSettings.toBuilder();
      updateReferenceListSettings = settings.updateReferenceListSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReferenceListSettings,
              listReferenceListsSettings,
              createReferenceListSettings,
              updateReferenceListSettings);
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
          .getReferenceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReferenceListsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReferenceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .updateReferenceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

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

    /** Returns the builder for the settings used for calls to getReferenceList. */
    public UnaryCallSettings.Builder<GetReferenceListRequest, ReferenceList>
        getReferenceListSettings() {
      return getReferenceListSettings;
    }

    /** Returns the builder for the settings used for calls to listReferenceLists. */
    public PagedCallSettings.Builder<
            ListReferenceListsRequest, ListReferenceListsResponse, ListReferenceListsPagedResponse>
        listReferenceListsSettings() {
      return listReferenceListsSettings;
    }

    /** Returns the builder for the settings used for calls to createReferenceList. */
    public UnaryCallSettings.Builder<CreateReferenceListRequest, ReferenceList>
        createReferenceListSettings() {
      return createReferenceListSettings;
    }

    /** Returns the builder for the settings used for calls to updateReferenceList. */
    public UnaryCallSettings.Builder<UpdateReferenceListRequest, ReferenceList>
        updateReferenceListSettings() {
      return updateReferenceListSettings;
    }

    @Override
    public ReferenceListServiceStubSettings build() throws IOException {
      return new ReferenceListServiceStubSettings(this);
    }
  }
}
