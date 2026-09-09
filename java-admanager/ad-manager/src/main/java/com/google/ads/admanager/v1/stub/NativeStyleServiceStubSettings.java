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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.NativeStyleServiceClient.ListNativeStylesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchActivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesRequest;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesResponse;
import com.google.ads.admanager.v1.BatchCreateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchCreateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesResponse;
import com.google.ads.admanager.v1.GetNativeStyleRequest;
import com.google.ads.admanager.v1.ListNativeStylesRequest;
import com.google.ads.admanager.v1.ListNativeStylesResponse;
import com.google.ads.admanager.v1.NativeStyle;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NativeStyleServiceStub}.
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
 * of getNativeStyle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NativeStyleServiceStubSettings.Builder nativeStyleServiceSettingsBuilder =
 *     NativeStyleServiceStubSettings.newBuilder();
 * nativeStyleServiceSettingsBuilder
 *     .getNativeStyleSettings()
 *     .setRetrySettings(
 *         nativeStyleServiceSettingsBuilder
 *             .getNativeStyleSettings()
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
 * NativeStyleServiceStubSettings nativeStyleServiceSettings =
 *     nativeStyleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class NativeStyleServiceStubSettings extends StubSettings<NativeStyleServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetNativeStyleRequest, NativeStyle> getNativeStyleSettings;
  private final PagedCallSettings<
          ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
      listNativeStylesSettings;
  private final UnaryCallSettings<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesSettings;
  private final UnaryCallSettings<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesSettings;
  private final UnaryCallSettings<
          BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesSettings;
  private final UnaryCallSettings<
          BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesSettings;
  private final UnaryCallSettings<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesSettings;

  private static final PagedListDescriptor<
          ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>
      LIST_NATIVE_STYLES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNativeStylesRequest injectToken(
                ListNativeStylesRequest payload, String token) {
              return ListNativeStylesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNativeStylesRequest injectPageSize(
                ListNativeStylesRequest payload, int pageSize) {
              return ListNativeStylesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNativeStylesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNativeStylesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NativeStyle> extractResources(ListNativeStylesResponse payload) {
              return payload.getNativeStylesList();
            }
          };

  private static final PagedListResponseFactory<
          ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
      LIST_NATIVE_STYLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>() {
            @Override
            public ApiFuture<ListNativeStylesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNativeStylesRequest, ListNativeStylesResponse> callable,
                ListNativeStylesRequest request,
                ApiCallContext context,
                ApiFuture<ListNativeStylesResponse> futureResponse) {
              PageContext<ListNativeStylesRequest, ListNativeStylesResponse, NativeStyle>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NATIVE_STYLES_PAGE_STR_DESC, request, context);
              return ListNativeStylesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getNativeStyle. */
  public UnaryCallSettings<GetNativeStyleRequest, NativeStyle> getNativeStyleSettings() {
    return getNativeStyleSettings;
  }

  /** Returns the object with the settings used for calls to listNativeStyles. */
  public PagedCallSettings<
          ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
      listNativeStylesSettings() {
    return listNativeStylesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateNativeStyles. */
  public UnaryCallSettings<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesSettings() {
    return batchCreateNativeStylesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateNativeStyles. */
  public UnaryCallSettings<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesSettings() {
    return batchUpdateNativeStylesSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateNativeStyles. */
  public UnaryCallSettings<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesSettings() {
    return batchActivateNativeStylesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateNativeStyles. */
  public UnaryCallSettings<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesSettings() {
    return batchDeactivateNativeStylesSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveNativeStyles. */
  public UnaryCallSettings<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesSettings() {
    return batchArchiveNativeStylesSettings;
  }

  public NativeStyleServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNativeStyleServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NativeStyleServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NativeStyleServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getNativeStyleSettings = settingsBuilder.getNativeStyleSettings().build();
    listNativeStylesSettings = settingsBuilder.listNativeStylesSettings().build();
    batchCreateNativeStylesSettings = settingsBuilder.batchCreateNativeStylesSettings().build();
    batchUpdateNativeStylesSettings = settingsBuilder.batchUpdateNativeStylesSettings().build();
    batchActivateNativeStylesSettings = settingsBuilder.batchActivateNativeStylesSettings().build();
    batchDeactivateNativeStylesSettings =
        settingsBuilder.batchDeactivateNativeStylesSettings().build();
    batchArchiveNativeStylesSettings = settingsBuilder.batchArchiveNativeStylesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for NativeStyleServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<NativeStyleServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetNativeStyleRequest, NativeStyle>
        getNativeStyleSettings;
    private final PagedCallSettings.Builder<
            ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
        listNativeStylesSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
        batchCreateNativeStylesSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
        batchUpdateNativeStylesSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
        batchActivateNativeStylesSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
        batchDeactivateNativeStylesSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
        batchArchiveNativeStylesSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getNativeStyleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNativeStylesSettings = PagedCallSettings.newBuilder(LIST_NATIVE_STYLES_PAGE_STR_FACT);
      batchCreateNativeStylesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateNativeStylesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateNativeStylesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateNativeStylesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveNativeStylesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getNativeStyleSettings,
              listNativeStylesSettings,
              batchCreateNativeStylesSettings,
              batchUpdateNativeStylesSettings,
              batchActivateNativeStylesSettings,
              batchDeactivateNativeStylesSettings,
              batchArchiveNativeStylesSettings);
      initDefaults(this);
    }

    protected Builder(NativeStyleServiceStubSettings settings) {
      super(settings);

      getNativeStyleSettings = settings.getNativeStyleSettings.toBuilder();
      listNativeStylesSettings = settings.listNativeStylesSettings.toBuilder();
      batchCreateNativeStylesSettings = settings.batchCreateNativeStylesSettings.toBuilder();
      batchUpdateNativeStylesSettings = settings.batchUpdateNativeStylesSettings.toBuilder();
      batchActivateNativeStylesSettings = settings.batchActivateNativeStylesSettings.toBuilder();
      batchDeactivateNativeStylesSettings =
          settings.batchDeactivateNativeStylesSettings.toBuilder();
      batchArchiveNativeStylesSettings = settings.batchArchiveNativeStylesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getNativeStyleSettings,
              listNativeStylesSettings,
              batchCreateNativeStylesSettings,
              batchUpdateNativeStylesSettings,
              batchActivateNativeStylesSettings,
              batchDeactivateNativeStylesSettings,
              batchArchiveNativeStylesSettings);
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
          .getNativeStyleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNativeStylesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateNativeStylesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateNativeStylesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateNativeStylesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateNativeStylesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveNativeStylesSettings()
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

    /** Returns the builder for the settings used for calls to getNativeStyle. */
    public UnaryCallSettings.Builder<GetNativeStyleRequest, NativeStyle> getNativeStyleSettings() {
      return getNativeStyleSettings;
    }

    /** Returns the builder for the settings used for calls to listNativeStyles. */
    public PagedCallSettings.Builder<
            ListNativeStylesRequest, ListNativeStylesResponse, ListNativeStylesPagedResponse>
        listNativeStylesSettings() {
      return listNativeStylesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
        batchCreateNativeStylesSettings() {
      return batchCreateNativeStylesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
        batchUpdateNativeStylesSettings() {
      return batchUpdateNativeStylesSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
        batchActivateNativeStylesSettings() {
      return batchActivateNativeStylesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
        batchDeactivateNativeStylesSettings() {
      return batchDeactivateNativeStylesSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveNativeStyles. */
    public UnaryCallSettings.Builder<
            BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
        batchArchiveNativeStylesSettings() {
      return batchArchiveNativeStylesSettings;
    }

    @Override
    public NativeStyleServiceStubSettings build() throws IOException {
      return new NativeStyleServiceStubSettings(this);
    }
  }
}
