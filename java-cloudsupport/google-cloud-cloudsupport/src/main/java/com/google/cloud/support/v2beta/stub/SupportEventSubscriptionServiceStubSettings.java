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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

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
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse;
import com.google.cloud.support.v2beta.SupportEventSubscription;
import com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SupportEventSubscriptionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsupport.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSupportEventSubscription:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SupportEventSubscriptionServiceStubSettings.Builder
 *     supportEventSubscriptionServiceSettingsBuilder =
 *         SupportEventSubscriptionServiceStubSettings.newBuilder();
 * supportEventSubscriptionServiceSettingsBuilder
 *     .createSupportEventSubscriptionSettings()
 *     .setRetrySettings(
 *         supportEventSubscriptionServiceSettingsBuilder
 *             .createSupportEventSubscriptionSettings()
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
 * SupportEventSubscriptionServiceStubSettings supportEventSubscriptionServiceSettings =
 *     supportEventSubscriptionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SupportEventSubscriptionServiceStubSettings
    extends StubSettings<SupportEventSubscriptionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionSettings;
  private final UnaryCallSettings<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionSettings;
  private final PagedCallSettings<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsSettings;
  private final UnaryCallSettings<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionSettings;
  private final UnaryCallSettings<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionSettings;
  private final UnaryCallSettings<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionSettings;

  private static final PagedListDescriptor<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          SupportEventSubscription>
      LIST_SUPPORT_EVENT_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSupportEventSubscriptionsRequest,
              ListSupportEventSubscriptionsResponse,
              SupportEventSubscription>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSupportEventSubscriptionsRequest injectToken(
                ListSupportEventSubscriptionsRequest payload, String token) {
              return ListSupportEventSubscriptionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSupportEventSubscriptionsRequest injectPageSize(
                ListSupportEventSubscriptionsRequest payload, int pageSize) {
              return ListSupportEventSubscriptionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSupportEventSubscriptionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSupportEventSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SupportEventSubscription> extractResources(
                ListSupportEventSubscriptionsResponse payload) {
              return payload.getSupportEventSubscriptionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          ListSupportEventSubscriptionsPagedResponse>
      LIST_SUPPORT_EVENT_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSupportEventSubscriptionsRequest,
              ListSupportEventSubscriptionsResponse,
              ListSupportEventSubscriptionsPagedResponse>() {
            @Override
            public ApiFuture<ListSupportEventSubscriptionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
                    callable,
                ListSupportEventSubscriptionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSupportEventSubscriptionsResponse> futureResponse) {
              PageContext<
                      ListSupportEventSubscriptionsRequest,
                      ListSupportEventSubscriptionsResponse,
                      SupportEventSubscription>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SUPPORT_EVENT_SUBSCRIPTIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListSupportEventSubscriptionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSupportEventSubscription. */
  public UnaryCallSettings<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionSettings() {
    return createSupportEventSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to getSupportEventSubscription. */
  public UnaryCallSettings<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionSettings() {
    return getSupportEventSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSupportEventSubscriptions. */
  public PagedCallSettings<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsSettings() {
    return listSupportEventSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to updateSupportEventSubscription. */
  public UnaryCallSettings<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionSettings() {
    return updateSupportEventSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSupportEventSubscription. */
  public UnaryCallSettings<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionSettings() {
    return deleteSupportEventSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to undeleteSupportEventSubscription. */
  public UnaryCallSettings<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionSettings() {
    return undeleteSupportEventSubscriptionSettings;
  }

  public SupportEventSubscriptionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSupportEventSubscriptionServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSupportEventSubscriptionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudsupport";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudsupport.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudsupport.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(SupportEventSubscriptionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(SupportEventSubscriptionServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SupportEventSubscriptionServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    createSupportEventSubscriptionSettings =
        settingsBuilder.createSupportEventSubscriptionSettings().build();
    getSupportEventSubscriptionSettings =
        settingsBuilder.getSupportEventSubscriptionSettings().build();
    listSupportEventSubscriptionsSettings =
        settingsBuilder.listSupportEventSubscriptionsSettings().build();
    updateSupportEventSubscriptionSettings =
        settingsBuilder.updateSupportEventSubscriptionSettings().build();
    deleteSupportEventSubscriptionSettings =
        settingsBuilder.deleteSupportEventSubscriptionSettings().build();
    undeleteSupportEventSubscriptionSettings =
        settingsBuilder.undeleteSupportEventSubscriptionSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-cloudsupport")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SupportEventSubscriptionServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SupportEventSubscriptionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreateSupportEventSubscriptionRequest, SupportEventSubscription>
        createSupportEventSubscriptionSettings;
    private final UnaryCallSettings.Builder<
            GetSupportEventSubscriptionRequest, SupportEventSubscription>
        getSupportEventSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSupportEventSubscriptionsRequest,
            ListSupportEventSubscriptionsResponse,
            ListSupportEventSubscriptionsPagedResponse>
        listSupportEventSubscriptionsSettings;
    private final UnaryCallSettings.Builder<
            UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
        updateSupportEventSubscriptionSettings;
    private final UnaryCallSettings.Builder<
            DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        deleteSupportEventSubscriptionSettings;
    private final UnaryCallSettings.Builder<
            UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        undeleteSupportEventSubscriptionSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSupportEventSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSupportEventSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSupportEventSubscriptionsSettings =
          PagedCallSettings.newBuilder(LIST_SUPPORT_EVENT_SUBSCRIPTIONS_PAGE_STR_FACT);
      updateSupportEventSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSupportEventSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteSupportEventSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSupportEventSubscriptionSettings,
              getSupportEventSubscriptionSettings,
              listSupportEventSubscriptionsSettings,
              updateSupportEventSubscriptionSettings,
              deleteSupportEventSubscriptionSettings,
              undeleteSupportEventSubscriptionSettings);
      initDefaults(this);
    }

    protected Builder(SupportEventSubscriptionServiceStubSettings settings) {
      super(settings);

      createSupportEventSubscriptionSettings =
          settings.createSupportEventSubscriptionSettings.toBuilder();
      getSupportEventSubscriptionSettings =
          settings.getSupportEventSubscriptionSettings.toBuilder();
      listSupportEventSubscriptionsSettings =
          settings.listSupportEventSubscriptionsSettings.toBuilder();
      updateSupportEventSubscriptionSettings =
          settings.updateSupportEventSubscriptionSettings.toBuilder();
      deleteSupportEventSubscriptionSettings =
          settings.deleteSupportEventSubscriptionSettings.toBuilder();
      undeleteSupportEventSubscriptionSettings =
          settings.undeleteSupportEventSubscriptionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSupportEventSubscriptionSettings,
              getSupportEventSubscriptionSettings,
              listSupportEventSubscriptionsSettings,
              updateSupportEventSubscriptionSettings,
              deleteSupportEventSubscriptionSettings,
              undeleteSupportEventSubscriptionSettings);
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
          .createSupportEventSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSupportEventSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSupportEventSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSupportEventSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSupportEventSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .undeleteSupportEventSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            CreateSupportEventSubscriptionRequest, SupportEventSubscription>
        createSupportEventSubscriptionSettings() {
      return createSupportEventSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to getSupportEventSubscription. */
    public UnaryCallSettings.Builder<GetSupportEventSubscriptionRequest, SupportEventSubscription>
        getSupportEventSubscriptionSettings() {
      return getSupportEventSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to listSupportEventSubscriptions. */
    public PagedCallSettings.Builder<
            ListSupportEventSubscriptionsRequest,
            ListSupportEventSubscriptionsResponse,
            ListSupportEventSubscriptionsPagedResponse>
        listSupportEventSubscriptionsSettings() {
      return listSupportEventSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
        updateSupportEventSubscriptionSettings() {
      return updateSupportEventSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        deleteSupportEventSubscriptionSettings() {
      return deleteSupportEventSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        undeleteSupportEventSubscriptionSettings() {
      return undeleteSupportEventSubscriptionSettings;
    }

    @Override
    public SupportEventSubscriptionServiceStubSettings build() throws IOException {
      return new SupportEventSubscriptionServiceStubSettings(this);
    }
  }
}
