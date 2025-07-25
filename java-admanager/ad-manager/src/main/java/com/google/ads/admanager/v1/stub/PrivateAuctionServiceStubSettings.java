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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.PrivateAuctionServiceClient.ListPrivateAuctionsPagedResponse;

import com.google.ads.admanager.v1.CreatePrivateAuctionRequest;
import com.google.ads.admanager.v1.GetPrivateAuctionRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsResponse;
import com.google.ads.admanager.v1.PrivateAuction;
import com.google.ads.admanager.v1.UpdatePrivateAuctionRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrivateAuctionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPrivateAuction:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivateAuctionServiceStubSettings.Builder privateAuctionServiceSettingsBuilder =
 *     PrivateAuctionServiceStubSettings.newBuilder();
 * privateAuctionServiceSettingsBuilder
 *     .getPrivateAuctionSettings()
 *     .setRetrySettings(
 *         privateAuctionServiceSettingsBuilder
 *             .getPrivateAuctionSettings()
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
 * PrivateAuctionServiceStubSettings privateAuctionServiceSettings =
 *     privateAuctionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class PrivateAuctionServiceStubSettings
    extends StubSettings<PrivateAuctionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetPrivateAuctionRequest, PrivateAuction>
      getPrivateAuctionSettings;
  private final PagedCallSettings<
          ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsSettings;
  private final UnaryCallSettings<CreatePrivateAuctionRequest, PrivateAuction>
      createPrivateAuctionSettings;
  private final UnaryCallSettings<UpdatePrivateAuctionRequest, PrivateAuction>
      updatePrivateAuctionSettings;

  private static final PagedListDescriptor<
          ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
      LIST_PRIVATE_AUCTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateAuctionsRequest injectToken(
                ListPrivateAuctionsRequest payload, String token) {
              return ListPrivateAuctionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateAuctionsRequest injectPageSize(
                ListPrivateAuctionsRequest payload, int pageSize) {
              return ListPrivateAuctionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPrivateAuctionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateAuctionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateAuction> extractResources(ListPrivateAuctionsResponse payload) {
              return payload.getPrivateAuctionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, ListPrivateAuctionsPagedResponse>
      LIST_PRIVATE_AUCTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateAuctionsRequest,
              ListPrivateAuctionsResponse,
              ListPrivateAuctionsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateAuctionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse> callable,
                ListPrivateAuctionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateAuctionsResponse> futureResponse) {
              PageContext<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_AUCTIONS_PAGE_STR_DESC, request, context);
              return ListPrivateAuctionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getPrivateAuction. */
  public UnaryCallSettings<GetPrivateAuctionRequest, PrivateAuction> getPrivateAuctionSettings() {
    return getPrivateAuctionSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateAuctions. */
  public PagedCallSettings<
          ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsSettings() {
    return listPrivateAuctionsSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateAuction. */
  public UnaryCallSettings<CreatePrivateAuctionRequest, PrivateAuction>
      createPrivateAuctionSettings() {
    return createPrivateAuctionSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateAuction. */
  public UnaryCallSettings<UpdatePrivateAuctionRequest, PrivateAuction>
      updatePrivateAuctionSettings() {
    return updatePrivateAuctionSettings;
  }

  public PrivateAuctionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPrivateAuctionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PrivateAuctionServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected PrivateAuctionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getPrivateAuctionSettings = settingsBuilder.getPrivateAuctionSettings().build();
    listPrivateAuctionsSettings = settingsBuilder.listPrivateAuctionsSettings().build();
    createPrivateAuctionSettings = settingsBuilder.createPrivateAuctionSettings().build();
    updatePrivateAuctionSettings = settingsBuilder.updatePrivateAuctionSettings().build();
  }

  /** Builder for PrivateAuctionServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PrivateAuctionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetPrivateAuctionRequest, PrivateAuction>
        getPrivateAuctionSettings;
    private final PagedCallSettings.Builder<
            ListPrivateAuctionsRequest,
            ListPrivateAuctionsResponse,
            ListPrivateAuctionsPagedResponse>
        listPrivateAuctionsSettings;
    private final UnaryCallSettings.Builder<CreatePrivateAuctionRequest, PrivateAuction>
        createPrivateAuctionSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateAuctionRequest, PrivateAuction>
        updatePrivateAuctionSettings;
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

      getPrivateAuctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateAuctionsSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_AUCTIONS_PAGE_STR_FACT);
      createPrivateAuctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateAuctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPrivateAuctionSettings,
              listPrivateAuctionsSettings,
              createPrivateAuctionSettings,
              updatePrivateAuctionSettings);
      initDefaults(this);
    }

    protected Builder(PrivateAuctionServiceStubSettings settings) {
      super(settings);

      getPrivateAuctionSettings = settings.getPrivateAuctionSettings.toBuilder();
      listPrivateAuctionsSettings = settings.listPrivateAuctionsSettings.toBuilder();
      createPrivateAuctionSettings = settings.createPrivateAuctionSettings.toBuilder();
      updatePrivateAuctionSettings = settings.updatePrivateAuctionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPrivateAuctionSettings,
              listPrivateAuctionsSettings,
              createPrivateAuctionSettings,
              updatePrivateAuctionSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getPrivateAuctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPrivateAuctionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPrivateAuctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePrivateAuctionSettings()
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

    /** Returns the builder for the settings used for calls to getPrivateAuction. */
    public UnaryCallSettings.Builder<GetPrivateAuctionRequest, PrivateAuction>
        getPrivateAuctionSettings() {
      return getPrivateAuctionSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateAuctions. */
    public PagedCallSettings.Builder<
            ListPrivateAuctionsRequest,
            ListPrivateAuctionsResponse,
            ListPrivateAuctionsPagedResponse>
        listPrivateAuctionsSettings() {
      return listPrivateAuctionsSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateAuction. */
    public UnaryCallSettings.Builder<CreatePrivateAuctionRequest, PrivateAuction>
        createPrivateAuctionSettings() {
      return createPrivateAuctionSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateAuction. */
    public UnaryCallSettings.Builder<UpdatePrivateAuctionRequest, PrivateAuction>
        updatePrivateAuctionSettings() {
      return updatePrivateAuctionSettings;
    }

    @Override
    public PrivateAuctionServiceStubSettings build() throws IOException {
      return new PrivateAuctionServiceStubSettings(this);
    }
  }
}
