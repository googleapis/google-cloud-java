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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

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
import com.google.shopping.merchant.accounts.v1beta.CreateOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1beta.GetOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOmnichannelSettingsResponse;
import com.google.shopping.merchant.accounts.v1beta.OmnichannelSetting;
import com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationRequest;
import com.google.shopping.merchant.accounts.v1beta.RequestInventoryVerificationResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateOmnichannelSettingRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OmnichannelSettingsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getOmnichannelSetting:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OmnichannelSettingsServiceStubSettings.Builder omnichannelSettingsServiceSettingsBuilder =
 *     OmnichannelSettingsServiceStubSettings.newBuilder();
 * omnichannelSettingsServiceSettingsBuilder
 *     .getOmnichannelSettingSettings()
 *     .setRetrySettings(
 *         omnichannelSettingsServiceSettingsBuilder
 *             .getOmnichannelSettingSettings()
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
 * OmnichannelSettingsServiceStubSettings omnichannelSettingsServiceSettings =
 *     omnichannelSettingsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OmnichannelSettingsServiceStubSettings
    extends StubSettings<OmnichannelSettingsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingSettings;
  private final PagedCallSettings<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsSettings;
  private final UnaryCallSettings<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingSettings;
  private final UnaryCallSettings<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingSettings;
  private final UnaryCallSettings<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationSettings;

  private static final PagedListDescriptor<
          ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse, OmnichannelSetting>
      LIST_OMNICHANNEL_SETTINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOmnichannelSettingsRequest,
              ListOmnichannelSettingsResponse,
              OmnichannelSetting>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOmnichannelSettingsRequest injectToken(
                ListOmnichannelSettingsRequest payload, String token) {
              return ListOmnichannelSettingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOmnichannelSettingsRequest injectPageSize(
                ListOmnichannelSettingsRequest payload, int pageSize) {
              return ListOmnichannelSettingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOmnichannelSettingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOmnichannelSettingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OmnichannelSetting> extractResources(
                ListOmnichannelSettingsResponse payload) {
              return payload.getOmnichannelSettingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          ListOmnichannelSettingsPagedResponse>
      LIST_OMNICHANNEL_SETTINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOmnichannelSettingsRequest,
              ListOmnichannelSettingsResponse,
              ListOmnichannelSettingsPagedResponse>() {
            @Override
            public ApiFuture<ListOmnichannelSettingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
                    callable,
                ListOmnichannelSettingsRequest request,
                ApiCallContext context,
                ApiFuture<ListOmnichannelSettingsResponse> futureResponse) {
              PageContext<
                      ListOmnichannelSettingsRequest,
                      ListOmnichannelSettingsResponse,
                      OmnichannelSetting>
                  pageContext =
                      PageContext.create(
                          callable, LIST_OMNICHANNEL_SETTINGS_PAGE_STR_DESC, request, context);
              return ListOmnichannelSettingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getOmnichannelSetting. */
  public UnaryCallSettings<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingSettings() {
    return getOmnichannelSettingSettings;
  }

  /** Returns the object with the settings used for calls to listOmnichannelSettings. */
  public PagedCallSettings<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsSettings() {
    return listOmnichannelSettingsSettings;
  }

  /** Returns the object with the settings used for calls to createOmnichannelSetting. */
  public UnaryCallSettings<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingSettings() {
    return createOmnichannelSettingSettings;
  }

  /** Returns the object with the settings used for calls to updateOmnichannelSetting. */
  public UnaryCallSettings<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingSettings() {
    return updateOmnichannelSettingSettings;
  }

  /** Returns the object with the settings used for calls to requestInventoryVerification. */
  public UnaryCallSettings<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationSettings() {
    return requestInventoryVerificationSettings;
  }

  public OmnichannelSettingsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOmnichannelSettingsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOmnichannelSettingsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "merchantapi";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "merchantapi.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "merchantapi.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(OmnichannelSettingsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OmnichannelSettingsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OmnichannelSettingsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected OmnichannelSettingsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getOmnichannelSettingSettings = settingsBuilder.getOmnichannelSettingSettings().build();
    listOmnichannelSettingsSettings = settingsBuilder.listOmnichannelSettingsSettings().build();
    createOmnichannelSettingSettings = settingsBuilder.createOmnichannelSettingSettings().build();
    updateOmnichannelSettingSettings = settingsBuilder.updateOmnichannelSettingSettings().build();
    requestInventoryVerificationSettings =
        settingsBuilder.requestInventoryVerificationSettings().build();
  }

  /** Builder for OmnichannelSettingsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<OmnichannelSettingsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetOmnichannelSettingRequest, OmnichannelSetting>
        getOmnichannelSettingSettings;
    private final PagedCallSettings.Builder<
            ListOmnichannelSettingsRequest,
            ListOmnichannelSettingsResponse,
            ListOmnichannelSettingsPagedResponse>
        listOmnichannelSettingsSettings;
    private final UnaryCallSettings.Builder<CreateOmnichannelSettingRequest, OmnichannelSetting>
        createOmnichannelSettingSettings;
    private final UnaryCallSettings.Builder<UpdateOmnichannelSettingRequest, OmnichannelSetting>
        updateOmnichannelSettingSettings;
    private final UnaryCallSettings.Builder<
            RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
        requestInventoryVerificationSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getOmnichannelSettingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOmnichannelSettingsSettings =
          PagedCallSettings.newBuilder(LIST_OMNICHANNEL_SETTINGS_PAGE_STR_FACT);
      createOmnichannelSettingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOmnichannelSettingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      requestInventoryVerificationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOmnichannelSettingSettings,
              listOmnichannelSettingsSettings,
              createOmnichannelSettingSettings,
              updateOmnichannelSettingSettings,
              requestInventoryVerificationSettings);
      initDefaults(this);
    }

    protected Builder(OmnichannelSettingsServiceStubSettings settings) {
      super(settings);

      getOmnichannelSettingSettings = settings.getOmnichannelSettingSettings.toBuilder();
      listOmnichannelSettingsSettings = settings.listOmnichannelSettingsSettings.toBuilder();
      createOmnichannelSettingSettings = settings.createOmnichannelSettingSettings.toBuilder();
      updateOmnichannelSettingSettings = settings.updateOmnichannelSettingSettings.toBuilder();
      requestInventoryVerificationSettings =
          settings.requestInventoryVerificationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOmnichannelSettingSettings,
              listOmnichannelSettingsSettings,
              createOmnichannelSettingSettings,
              updateOmnichannelSettingSettings,
              requestInventoryVerificationSettings);
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
          .getOmnichannelSettingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOmnichannelSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOmnichannelSettingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateOmnichannelSettingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .requestInventoryVerificationSettings()
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

    /** Returns the builder for the settings used for calls to getOmnichannelSetting. */
    public UnaryCallSettings.Builder<GetOmnichannelSettingRequest, OmnichannelSetting>
        getOmnichannelSettingSettings() {
      return getOmnichannelSettingSettings;
    }

    /** Returns the builder for the settings used for calls to listOmnichannelSettings. */
    public PagedCallSettings.Builder<
            ListOmnichannelSettingsRequest,
            ListOmnichannelSettingsResponse,
            ListOmnichannelSettingsPagedResponse>
        listOmnichannelSettingsSettings() {
      return listOmnichannelSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to createOmnichannelSetting. */
    public UnaryCallSettings.Builder<CreateOmnichannelSettingRequest, OmnichannelSetting>
        createOmnichannelSettingSettings() {
      return createOmnichannelSettingSettings;
    }

    /** Returns the builder for the settings used for calls to updateOmnichannelSetting. */
    public UnaryCallSettings.Builder<UpdateOmnichannelSettingRequest, OmnichannelSetting>
        updateOmnichannelSettingSettings() {
      return updateOmnichannelSettingSettings;
    }

    /** Returns the builder for the settings used for calls to requestInventoryVerification. */
    public UnaryCallSettings.Builder<
            RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
        requestInventoryVerificationSettings() {
      return requestInventoryVerificationSettings;
    }

    @Override
    public OmnichannelSettingsServiceStubSettings build() throws IOException {
      return new OmnichannelSettingsServiceStubSettings(this);
    }
  }
}
