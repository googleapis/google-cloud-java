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

import static com.google.ads.admanager.v1.BrowserLanguageServiceClient.ListBrowserLanguagesPagedResponse;

import com.google.ads.admanager.v1.BrowserLanguage;
import com.google.ads.admanager.v1.GetBrowserLanguageRequest;
import com.google.ads.admanager.v1.ListBrowserLanguagesRequest;
import com.google.ads.admanager.v1.ListBrowserLanguagesResponse;
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
 * Settings class to configure an instance of {@link BrowserLanguageServiceStub}.
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
 * of getBrowserLanguage:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BrowserLanguageServiceStubSettings.Builder browserLanguageServiceSettingsBuilder =
 *     BrowserLanguageServiceStubSettings.newBuilder();
 * browserLanguageServiceSettingsBuilder
 *     .getBrowserLanguageSettings()
 *     .setRetrySettings(
 *         browserLanguageServiceSettingsBuilder
 *             .getBrowserLanguageSettings()
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
 * BrowserLanguageServiceStubSettings browserLanguageServiceSettings =
 *     browserLanguageServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class BrowserLanguageServiceStubSettings
    extends StubSettings<BrowserLanguageServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetBrowserLanguageRequest, BrowserLanguage>
      getBrowserLanguageSettings;
  private final PagedCallSettings<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          ListBrowserLanguagesPagedResponse>
      listBrowserLanguagesSettings;

  private static final PagedListDescriptor<
          ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
      LIST_BROWSER_LANGUAGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBrowserLanguagesRequest injectToken(
                ListBrowserLanguagesRequest payload, String token) {
              return ListBrowserLanguagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBrowserLanguagesRequest injectPageSize(
                ListBrowserLanguagesRequest payload, int pageSize) {
              return ListBrowserLanguagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBrowserLanguagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBrowserLanguagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BrowserLanguage> extractResources(
                ListBrowserLanguagesResponse payload) {
              return payload.getBrowserLanguagesList();
            }
          };

  private static final PagedListResponseFactory<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          ListBrowserLanguagesPagedResponse>
      LIST_BROWSER_LANGUAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBrowserLanguagesRequest,
              ListBrowserLanguagesResponse,
              ListBrowserLanguagesPagedResponse>() {
            @Override
            public ApiFuture<ListBrowserLanguagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse> callable,
                ListBrowserLanguagesRequest request,
                ApiCallContext context,
                ApiFuture<ListBrowserLanguagesResponse> futureResponse) {
              PageContext<
                      ListBrowserLanguagesRequest, ListBrowserLanguagesResponse, BrowserLanguage>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BROWSER_LANGUAGES_PAGE_STR_DESC, request, context);
              return ListBrowserLanguagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getBrowserLanguage. */
  public UnaryCallSettings<GetBrowserLanguageRequest, BrowserLanguage>
      getBrowserLanguageSettings() {
    return getBrowserLanguageSettings;
  }

  /** Returns the object with the settings used for calls to listBrowserLanguages. */
  public PagedCallSettings<
          ListBrowserLanguagesRequest,
          ListBrowserLanguagesResponse,
          ListBrowserLanguagesPagedResponse>
      listBrowserLanguagesSettings() {
    return listBrowserLanguagesSettings;
  }

  public BrowserLanguageServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBrowserLanguageServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(BrowserLanguageServiceStubSettings.class))
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

  protected BrowserLanguageServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getBrowserLanguageSettings = settingsBuilder.getBrowserLanguageSettings().build();
    listBrowserLanguagesSettings = settingsBuilder.listBrowserLanguagesSettings().build();
  }

  /** Builder for BrowserLanguageServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<BrowserLanguageServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetBrowserLanguageRequest, BrowserLanguage>
        getBrowserLanguageSettings;
    private final PagedCallSettings.Builder<
            ListBrowserLanguagesRequest,
            ListBrowserLanguagesResponse,
            ListBrowserLanguagesPagedResponse>
        listBrowserLanguagesSettings;
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

      getBrowserLanguageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBrowserLanguagesSettings =
          PagedCallSettings.newBuilder(LIST_BROWSER_LANGUAGES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getBrowserLanguageSettings, listBrowserLanguagesSettings);
      initDefaults(this);
    }

    protected Builder(BrowserLanguageServiceStubSettings settings) {
      super(settings);

      getBrowserLanguageSettings = settings.getBrowserLanguageSettings.toBuilder();
      listBrowserLanguagesSettings = settings.listBrowserLanguagesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getBrowserLanguageSettings, listBrowserLanguagesSettings);
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
          .getBrowserLanguageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBrowserLanguagesSettings()
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

    /** Returns the builder for the settings used for calls to getBrowserLanguage. */
    public UnaryCallSettings.Builder<GetBrowserLanguageRequest, BrowserLanguage>
        getBrowserLanguageSettings() {
      return getBrowserLanguageSettings;
    }

    /** Returns the builder for the settings used for calls to listBrowserLanguages. */
    public PagedCallSettings.Builder<
            ListBrowserLanguagesRequest,
            ListBrowserLanguagesResponse,
            ListBrowserLanguagesPagedResponse>
        listBrowserLanguagesSettings() {
      return listBrowserLanguagesSettings;
    }

    @Override
    public BrowserLanguageServiceStubSettings build() throws IOException {
      return new BrowserLanguageServiceStubSettings(this);
    }
  }
}
