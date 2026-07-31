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

import static com.google.ads.admanager.v1.SuggestedAdUnitServiceClient.ListSuggestedAdUnitsPagedResponse;

import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.GetSuggestedAdUnitRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.SuggestedAdUnit;
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
 * Settings class to configure an instance of {@link SuggestedAdUnitServiceStub}.
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
 * of getSuggestedAdUnit:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SuggestedAdUnitServiceStubSettings.Builder suggestedAdUnitServiceSettingsBuilder =
 *     SuggestedAdUnitServiceStubSettings.newBuilder();
 * suggestedAdUnitServiceSettingsBuilder
 *     .getSuggestedAdUnitSettings()
 *     .setRetrySettings(
 *         suggestedAdUnitServiceSettingsBuilder
 *             .getSuggestedAdUnitSettings()
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
 * SuggestedAdUnitServiceStubSettings suggestedAdUnitServiceSettings =
 *     suggestedAdUnitServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SuggestedAdUnitServiceStubSettings
    extends StubSettings<SuggestedAdUnitServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetSuggestedAdUnitRequest, SuggestedAdUnit>
      getSuggestedAdUnitSettings;
  private final PagedCallSettings<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsSettings;
  private final UnaryCallSettings<
          BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsSettings;

  private static final PagedListDescriptor<
          ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
      LIST_SUGGESTED_AD_UNITS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSuggestedAdUnitsRequest injectToken(
                ListSuggestedAdUnitsRequest payload, String token) {
              return ListSuggestedAdUnitsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSuggestedAdUnitsRequest injectPageSize(
                ListSuggestedAdUnitsRequest payload, int pageSize) {
              return ListSuggestedAdUnitsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSuggestedAdUnitsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSuggestedAdUnitsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SuggestedAdUnit> extractResources(
                ListSuggestedAdUnitsResponse payload) {
              return payload.getSuggestedAdUnitsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          ListSuggestedAdUnitsPagedResponse>
      LIST_SUGGESTED_AD_UNITS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSuggestedAdUnitsRequest,
              ListSuggestedAdUnitsResponse,
              ListSuggestedAdUnitsPagedResponse>() {
            @Override
            public ApiFuture<ListSuggestedAdUnitsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse> callable,
                ListSuggestedAdUnitsRequest request,
                ApiCallContext context,
                ApiFuture<ListSuggestedAdUnitsResponse> futureResponse) {
              PageContext<
                      ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SUGGESTED_AD_UNITS_PAGE_STR_DESC, request, context);
              return ListSuggestedAdUnitsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSuggestedAdUnit. */
  public UnaryCallSettings<GetSuggestedAdUnitRequest, SuggestedAdUnit>
      getSuggestedAdUnitSettings() {
    return getSuggestedAdUnitSettings;
  }

  /** Returns the object with the settings used for calls to listSuggestedAdUnits. */
  public PagedCallSettings<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsSettings() {
    return listSuggestedAdUnitsSettings;
  }

  /** Returns the object with the settings used for calls to batchApproveSuggestedAdUnits. */
  public UnaryCallSettings<
          BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsSettings() {
    return batchApproveSuggestedAdUnitsSettings;
  }

  public SuggestedAdUnitServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSuggestedAdUnitServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SuggestedAdUnitServiceStubSettings.class))
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

  protected SuggestedAdUnitServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSuggestedAdUnitSettings = settingsBuilder.getSuggestedAdUnitSettings().build();
    listSuggestedAdUnitsSettings = settingsBuilder.listSuggestedAdUnitsSettings().build();
    batchApproveSuggestedAdUnitsSettings =
        settingsBuilder.batchApproveSuggestedAdUnitsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SuggestedAdUnitServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SuggestedAdUnitServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSuggestedAdUnitRequest, SuggestedAdUnit>
        getSuggestedAdUnitSettings;
    private final PagedCallSettings.Builder<
            ListSuggestedAdUnitsRequest,
            ListSuggestedAdUnitsResponse,
            ListSuggestedAdUnitsPagedResponse>
        listSuggestedAdUnitsSettings;
    private final UnaryCallSettings.Builder<
            BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
        batchApproveSuggestedAdUnitsSettings;
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

      getSuggestedAdUnitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSuggestedAdUnitsSettings =
          PagedCallSettings.newBuilder(LIST_SUGGESTED_AD_UNITS_PAGE_STR_FACT);
      batchApproveSuggestedAdUnitsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSuggestedAdUnitSettings,
              listSuggestedAdUnitsSettings,
              batchApproveSuggestedAdUnitsSettings);
      initDefaults(this);
    }

    protected Builder(SuggestedAdUnitServiceStubSettings settings) {
      super(settings);

      getSuggestedAdUnitSettings = settings.getSuggestedAdUnitSettings.toBuilder();
      listSuggestedAdUnitsSettings = settings.listSuggestedAdUnitsSettings.toBuilder();
      batchApproveSuggestedAdUnitsSettings =
          settings.batchApproveSuggestedAdUnitsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSuggestedAdUnitSettings,
              listSuggestedAdUnitsSettings,
              batchApproveSuggestedAdUnitsSettings);
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
          .getSuggestedAdUnitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSuggestedAdUnitsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchApproveSuggestedAdUnitsSettings()
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

    /** Returns the builder for the settings used for calls to getSuggestedAdUnit. */
    public UnaryCallSettings.Builder<GetSuggestedAdUnitRequest, SuggestedAdUnit>
        getSuggestedAdUnitSettings() {
      return getSuggestedAdUnitSettings;
    }

    /** Returns the builder for the settings used for calls to listSuggestedAdUnits. */
    public PagedCallSettings.Builder<
            ListSuggestedAdUnitsRequest,
            ListSuggestedAdUnitsResponse,
            ListSuggestedAdUnitsPagedResponse>
        listSuggestedAdUnitsSettings() {
      return listSuggestedAdUnitsSettings;
    }

    /** Returns the builder for the settings used for calls to batchApproveSuggestedAdUnits. */
    public UnaryCallSettings.Builder<
            BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
        batchApproveSuggestedAdUnitsSettings() {
      return batchApproveSuggestedAdUnitsSettings;
    }

    @Override
    public SuggestedAdUnitServiceStubSettings build() throws IOException {
      return new SuggestedAdUnitServiceStubSettings(this);
    }
  }
}
