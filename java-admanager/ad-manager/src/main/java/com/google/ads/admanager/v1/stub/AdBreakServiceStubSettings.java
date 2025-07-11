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

import static com.google.ads.admanager.v1.AdBreakServiceClient.ListAdBreaksPagedResponse;

import com.google.ads.admanager.v1.AdBreak;
import com.google.ads.admanager.v1.CreateAdBreakRequest;
import com.google.ads.admanager.v1.DeleteAdBreakRequest;
import com.google.ads.admanager.v1.GetAdBreakRequest;
import com.google.ads.admanager.v1.ListAdBreaksRequest;
import com.google.ads.admanager.v1.ListAdBreaksResponse;
import com.google.ads.admanager.v1.UpdateAdBreakRequest;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdBreakServiceStub}.
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
 * of getAdBreak:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdBreakServiceStubSettings.Builder adBreakServiceSettingsBuilder =
 *     AdBreakServiceStubSettings.newBuilder();
 * adBreakServiceSettingsBuilder
 *     .getAdBreakSettings()
 *     .setRetrySettings(
 *         adBreakServiceSettingsBuilder
 *             .getAdBreakSettings()
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
 * AdBreakServiceStubSettings adBreakServiceSettings = adBreakServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class AdBreakServiceStubSettings extends StubSettings<AdBreakServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetAdBreakRequest, AdBreak> getAdBreakSettings;
  private final PagedCallSettings<
          ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>
      listAdBreaksSettings;
  private final UnaryCallSettings<CreateAdBreakRequest, AdBreak> createAdBreakSettings;
  private final UnaryCallSettings<UpdateAdBreakRequest, AdBreak> updateAdBreakSettings;
  private final UnaryCallSettings<DeleteAdBreakRequest, Empty> deleteAdBreakSettings;

  private static final PagedListDescriptor<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak>
      LIST_AD_BREAKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdBreaksRequest injectToken(ListAdBreaksRequest payload, String token) {
              return ListAdBreaksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdBreaksRequest injectPageSize(ListAdBreaksRequest payload, int pageSize) {
              return ListAdBreaksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAdBreaksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdBreaksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdBreak> extractResources(ListAdBreaksResponse payload) {
              return payload.getAdBreaksList();
            }
          };

  private static final PagedListResponseFactory<
          ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>
      LIST_AD_BREAKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>() {
            @Override
            public ApiFuture<ListAdBreaksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdBreaksRequest, ListAdBreaksResponse> callable,
                ListAdBreaksRequest request,
                ApiCallContext context,
                ApiFuture<ListAdBreaksResponse> futureResponse) {
              PageContext<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak> pageContext =
                  PageContext.create(callable, LIST_AD_BREAKS_PAGE_STR_DESC, request, context);
              return ListAdBreaksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getAdBreak. */
  public UnaryCallSettings<GetAdBreakRequest, AdBreak> getAdBreakSettings() {
    return getAdBreakSettings;
  }

  /** Returns the object with the settings used for calls to listAdBreaks. */
  public PagedCallSettings<ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>
      listAdBreaksSettings() {
    return listAdBreaksSettings;
  }

  /** Returns the object with the settings used for calls to createAdBreak. */
  public UnaryCallSettings<CreateAdBreakRequest, AdBreak> createAdBreakSettings() {
    return createAdBreakSettings;
  }

  /** Returns the object with the settings used for calls to updateAdBreak. */
  public UnaryCallSettings<UpdateAdBreakRequest, AdBreak> updateAdBreakSettings() {
    return updateAdBreakSettings;
  }

  /** Returns the object with the settings used for calls to deleteAdBreak. */
  public UnaryCallSettings<DeleteAdBreakRequest, Empty> deleteAdBreakSettings() {
    return deleteAdBreakSettings;
  }

  public AdBreakServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAdBreakServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AdBreakServiceStubSettings.class))
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

  protected AdBreakServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAdBreakSettings = settingsBuilder.getAdBreakSettings().build();
    listAdBreaksSettings = settingsBuilder.listAdBreaksSettings().build();
    createAdBreakSettings = settingsBuilder.createAdBreakSettings().build();
    updateAdBreakSettings = settingsBuilder.updateAdBreakSettings().build();
    deleteAdBreakSettings = settingsBuilder.deleteAdBreakSettings().build();
  }

  /** Builder for AdBreakServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AdBreakServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAdBreakRequest, AdBreak> getAdBreakSettings;
    private final PagedCallSettings.Builder<
            ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>
        listAdBreaksSettings;
    private final UnaryCallSettings.Builder<CreateAdBreakRequest, AdBreak> createAdBreakSettings;
    private final UnaryCallSettings.Builder<UpdateAdBreakRequest, AdBreak> updateAdBreakSettings;
    private final UnaryCallSettings.Builder<DeleteAdBreakRequest, Empty> deleteAdBreakSettings;
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

      getAdBreakSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdBreaksSettings = PagedCallSettings.newBuilder(LIST_AD_BREAKS_PAGE_STR_FACT);
      createAdBreakSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAdBreakSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAdBreakSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdBreakSettings,
              listAdBreaksSettings,
              createAdBreakSettings,
              updateAdBreakSettings,
              deleteAdBreakSettings);
      initDefaults(this);
    }

    protected Builder(AdBreakServiceStubSettings settings) {
      super(settings);

      getAdBreakSettings = settings.getAdBreakSettings.toBuilder();
      listAdBreaksSettings = settings.listAdBreaksSettings.toBuilder();
      createAdBreakSettings = settings.createAdBreakSettings.toBuilder();
      updateAdBreakSettings = settings.updateAdBreakSettings.toBuilder();
      deleteAdBreakSettings = settings.deleteAdBreakSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdBreakSettings,
              listAdBreaksSettings,
              createAdBreakSettings,
              updateAdBreakSettings,
              deleteAdBreakSettings);
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
          .getAdBreakSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdBreaksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAdBreakSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAdBreakSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAdBreakSettings()
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

    /** Returns the builder for the settings used for calls to getAdBreak. */
    public UnaryCallSettings.Builder<GetAdBreakRequest, AdBreak> getAdBreakSettings() {
      return getAdBreakSettings;
    }

    /** Returns the builder for the settings used for calls to listAdBreaks. */
    public PagedCallSettings.Builder<
            ListAdBreaksRequest, ListAdBreaksResponse, ListAdBreaksPagedResponse>
        listAdBreaksSettings() {
      return listAdBreaksSettings;
    }

    /** Returns the builder for the settings used for calls to createAdBreak. */
    public UnaryCallSettings.Builder<CreateAdBreakRequest, AdBreak> createAdBreakSettings() {
      return createAdBreakSettings;
    }

    /** Returns the builder for the settings used for calls to updateAdBreak. */
    public UnaryCallSettings.Builder<UpdateAdBreakRequest, AdBreak> updateAdBreakSettings() {
      return updateAdBreakSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAdBreak. */
    public UnaryCallSettings.Builder<DeleteAdBreakRequest, Empty> deleteAdBreakSettings() {
      return deleteAdBreakSettings;
    }

    @Override
    public AdBreakServiceStubSettings build() throws IOException {
      return new AdBreakServiceStubSettings(this);
    }
  }
}
