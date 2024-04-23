/*
 * Copyright 2024 Google LLC
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

package com.google.api.cloudquotas.v1.stub;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.GetQuotaInfoRequest;
import com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosResponse;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse;
import com.google.api.cloudquotas.v1.QuotaInfo;
import com.google.api.cloudquotas.v1.QuotaPreference;
import com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudQuotasStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudquotas.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getQuotaInfo to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudQuotasStubSettings.Builder cloudQuotasSettingsBuilder =
 *     CloudQuotasStubSettings.newBuilder();
 * cloudQuotasSettingsBuilder
 *     .getQuotaInfoSettings()
 *     .setRetrySettings(
 *         cloudQuotasSettingsBuilder
 *             .getQuotaInfoSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudQuotasStubSettings cloudQuotasSettings = cloudQuotasSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudQuotasStubSettings extends StubSettings<CloudQuotasStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
      listQuotaInfosSettings;
  private final UnaryCallSettings<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings;
  private final PagedCallSettings<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesSettings;
  private final UnaryCallSettings<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceSettings;
  private final UnaryCallSettings<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceSettings;
  private final UnaryCallSettings<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceSettings;

  private static final PagedListDescriptor<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo>
      LIST_QUOTA_INFOS_PAGE_STR_DESC =
          new PagedListDescriptor<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQuotaInfosRequest injectToken(ListQuotaInfosRequest payload, String token) {
              return ListQuotaInfosRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListQuotaInfosRequest injectPageSize(
                ListQuotaInfosRequest payload, int pageSize) {
              return ListQuotaInfosRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListQuotaInfosRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQuotaInfosResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QuotaInfo> extractResources(ListQuotaInfosResponse payload) {
              return payload.getQuotaInfosList() == null
                  ? ImmutableList.<QuotaInfo>of()
                  : payload.getQuotaInfosList();
            }
          };

  private static final PagedListDescriptor<
          ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
      LIST_QUOTA_PREFERENCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQuotaPreferencesRequest injectToken(
                ListQuotaPreferencesRequest payload, String token) {
              return ListQuotaPreferencesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListQuotaPreferencesRequest injectPageSize(
                ListQuotaPreferencesRequest payload, int pageSize) {
              return ListQuotaPreferencesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListQuotaPreferencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQuotaPreferencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QuotaPreference> extractResources(
                ListQuotaPreferencesResponse payload) {
              return payload.getQuotaPreferencesList() == null
                  ? ImmutableList.<QuotaPreference>of()
                  : payload.getQuotaPreferencesList();
            }
          };

  private static final PagedListResponseFactory<
          ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
      LIST_QUOTA_INFOS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>() {
            @Override
            public ApiFuture<ListQuotaInfosPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> callable,
                ListQuotaInfosRequest request,
                ApiCallContext context,
                ApiFuture<ListQuotaInfosResponse> futureResponse) {
              PageContext<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo> pageContext =
                  PageContext.create(callable, LIST_QUOTA_INFOS_PAGE_STR_DESC, request, context);
              return ListQuotaInfosPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          ListQuotaPreferencesPagedResponse>
      LIST_QUOTA_PREFERENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQuotaPreferencesRequest,
              ListQuotaPreferencesResponse,
              ListQuotaPreferencesPagedResponse>() {
            @Override
            public ApiFuture<ListQuotaPreferencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse> callable,
                ListQuotaPreferencesRequest request,
                ApiCallContext context,
                ApiFuture<ListQuotaPreferencesResponse> futureResponse) {
              PageContext<
                      ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
                  pageContext =
                      PageContext.create(
                          callable, LIST_QUOTA_PREFERENCES_PAGE_STR_DESC, request, context);
              return ListQuotaPreferencesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listQuotaInfos. */
  public PagedCallSettings<
          ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
      listQuotaInfosSettings() {
    return listQuotaInfosSettings;
  }

  /** Returns the object with the settings used for calls to getQuotaInfo. */
  public UnaryCallSettings<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings() {
    return getQuotaInfoSettings;
  }

  /** Returns the object with the settings used for calls to listQuotaPreferences. */
  public PagedCallSettings<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesSettings() {
    return listQuotaPreferencesSettings;
  }

  /** Returns the object with the settings used for calls to getQuotaPreference. */
  public UnaryCallSettings<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceSettings() {
    return getQuotaPreferenceSettings;
  }

  /** Returns the object with the settings used for calls to createQuotaPreference. */
  public UnaryCallSettings<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceSettings() {
    return createQuotaPreferenceSettings;
  }

  /** Returns the object with the settings used for calls to updateQuotaPreference. */
  public UnaryCallSettings<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceSettings() {
    return updateQuotaPreferenceSettings;
  }

  public CloudQuotasStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudQuotasStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudQuotasStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudquotas";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudquotas.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudquotas.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudQuotasStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudQuotasStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudQuotasStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudQuotasStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listQuotaInfosSettings = settingsBuilder.listQuotaInfosSettings().build();
    getQuotaInfoSettings = settingsBuilder.getQuotaInfoSettings().build();
    listQuotaPreferencesSettings = settingsBuilder.listQuotaPreferencesSettings().build();
    getQuotaPreferenceSettings = settingsBuilder.getQuotaPreferenceSettings().build();
    createQuotaPreferenceSettings = settingsBuilder.createQuotaPreferenceSettings().build();
    updateQuotaPreferenceSettings = settingsBuilder.updateQuotaPreferenceSettings().build();
  }

  /** Builder for CloudQuotasStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudQuotasStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
        listQuotaInfosSettings;
    private final UnaryCallSettings.Builder<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings;
    private final PagedCallSettings.Builder<
            ListQuotaPreferencesRequest,
            ListQuotaPreferencesResponse,
            ListQuotaPreferencesPagedResponse>
        listQuotaPreferencesSettings;
    private final UnaryCallSettings.Builder<GetQuotaPreferenceRequest, QuotaPreference>
        getQuotaPreferenceSettings;
    private final UnaryCallSettings.Builder<CreateQuotaPreferenceRequest, QuotaPreference>
        createQuotaPreferenceSettings;
    private final UnaryCallSettings.Builder<UpdateQuotaPreferenceRequest, QuotaPreference>
        updateQuotaPreferenceSettings;
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

      listQuotaInfosSettings = PagedCallSettings.newBuilder(LIST_QUOTA_INFOS_PAGE_STR_FACT);
      getQuotaInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listQuotaPreferencesSettings =
          PagedCallSettings.newBuilder(LIST_QUOTA_PREFERENCES_PAGE_STR_FACT);
      getQuotaPreferenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createQuotaPreferenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateQuotaPreferenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listQuotaInfosSettings,
              getQuotaInfoSettings,
              listQuotaPreferencesSettings,
              getQuotaPreferenceSettings,
              createQuotaPreferenceSettings,
              updateQuotaPreferenceSettings);
      initDefaults(this);
    }

    protected Builder(CloudQuotasStubSettings settings) {
      super(settings);

      listQuotaInfosSettings = settings.listQuotaInfosSettings.toBuilder();
      getQuotaInfoSettings = settings.getQuotaInfoSettings.toBuilder();
      listQuotaPreferencesSettings = settings.listQuotaPreferencesSettings.toBuilder();
      getQuotaPreferenceSettings = settings.getQuotaPreferenceSettings.toBuilder();
      createQuotaPreferenceSettings = settings.createQuotaPreferenceSettings.toBuilder();
      updateQuotaPreferenceSettings = settings.updateQuotaPreferenceSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listQuotaInfosSettings,
              getQuotaInfoSettings,
              listQuotaPreferencesSettings,
              getQuotaPreferenceSettings,
              createQuotaPreferenceSettings,
              updateQuotaPreferenceSettings);
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
          .listQuotaInfosSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getQuotaInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listQuotaPreferencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getQuotaPreferenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createQuotaPreferenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateQuotaPreferenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to listQuotaInfos. */
    public PagedCallSettings.Builder<
            ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
        listQuotaInfosSettings() {
      return listQuotaInfosSettings;
    }

    /** Returns the builder for the settings used for calls to getQuotaInfo. */
    public UnaryCallSettings.Builder<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings() {
      return getQuotaInfoSettings;
    }

    /** Returns the builder for the settings used for calls to listQuotaPreferences. */
    public PagedCallSettings.Builder<
            ListQuotaPreferencesRequest,
            ListQuotaPreferencesResponse,
            ListQuotaPreferencesPagedResponse>
        listQuotaPreferencesSettings() {
      return listQuotaPreferencesSettings;
    }

    /** Returns the builder for the settings used for calls to getQuotaPreference. */
    public UnaryCallSettings.Builder<GetQuotaPreferenceRequest, QuotaPreference>
        getQuotaPreferenceSettings() {
      return getQuotaPreferenceSettings;
    }

    /** Returns the builder for the settings used for calls to createQuotaPreference. */
    public UnaryCallSettings.Builder<CreateQuotaPreferenceRequest, QuotaPreference>
        createQuotaPreferenceSettings() {
      return createQuotaPreferenceSettings;
    }

    /** Returns the builder for the settings used for calls to updateQuotaPreference. */
    public UnaryCallSettings.Builder<UpdateQuotaPreferenceRequest, QuotaPreference>
        updateQuotaPreferenceSettings() {
      return updateQuotaPreferenceSettings;
    }

    @Override
    public CloudQuotasStubSettings build() throws IOException {
      return new CloudQuotasStubSettings(this);
    }
  }
}
