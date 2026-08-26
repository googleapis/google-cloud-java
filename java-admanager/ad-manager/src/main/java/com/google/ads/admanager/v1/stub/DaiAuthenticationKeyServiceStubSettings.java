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

import static com.google.ads.admanager.v1.DaiAuthenticationKeyServiceClient.ListDaiAuthenticationKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.CreateDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.DaiAuthenticationKey;
import com.google.ads.admanager.v1.GetDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.UpdateDaiAuthenticationKeyRequest;
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
 * Settings class to configure an instance of {@link DaiAuthenticationKeyServiceStub}.
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
 * of getDaiAuthenticationKey:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiAuthenticationKeyServiceStubSettings.Builder daiAuthenticationKeyServiceSettingsBuilder =
 *     DaiAuthenticationKeyServiceStubSettings.newBuilder();
 * daiAuthenticationKeyServiceSettingsBuilder
 *     .getDaiAuthenticationKeySettings()
 *     .setRetrySettings(
 *         daiAuthenticationKeyServiceSettingsBuilder
 *             .getDaiAuthenticationKeySettings()
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
 * DaiAuthenticationKeyServiceStubSettings daiAuthenticationKeyServiceSettings =
 *     daiAuthenticationKeyServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DaiAuthenticationKeyServiceStubSettings
    extends StubSettings<DaiAuthenticationKeyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeySettings;
  private final PagedCallSettings<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysSettings;
  private final UnaryCallSettings<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeySettings;
  private final UnaryCallSettings<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysSettings;
  private final UnaryCallSettings<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeySettings;
  private final UnaryCallSettings<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysSettings;
  private final UnaryCallSettings<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysSettings;
  private final UnaryCallSettings<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysSettings;

  private static final PagedListDescriptor<
          ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse, DaiAuthenticationKey>
      LIST_DAI_AUTHENTICATION_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDaiAuthenticationKeysRequest,
              ListDaiAuthenticationKeysResponse,
              DaiAuthenticationKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDaiAuthenticationKeysRequest injectToken(
                ListDaiAuthenticationKeysRequest payload, String token) {
              return ListDaiAuthenticationKeysRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDaiAuthenticationKeysRequest injectPageSize(
                ListDaiAuthenticationKeysRequest payload, int pageSize) {
              return ListDaiAuthenticationKeysRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDaiAuthenticationKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDaiAuthenticationKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DaiAuthenticationKey> extractResources(
                ListDaiAuthenticationKeysResponse payload) {
              return payload.getDaiAuthenticationKeysList();
            }
          };

  private static final PagedListResponseFactory<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          ListDaiAuthenticationKeysPagedResponse>
      LIST_DAI_AUTHENTICATION_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDaiAuthenticationKeysRequest,
              ListDaiAuthenticationKeysResponse,
              ListDaiAuthenticationKeysPagedResponse>() {
            @Override
            public ApiFuture<ListDaiAuthenticationKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
                    callable,
                ListDaiAuthenticationKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListDaiAuthenticationKeysResponse> futureResponse) {
              PageContext<
                      ListDaiAuthenticationKeysRequest,
                      ListDaiAuthenticationKeysResponse,
                      DaiAuthenticationKey>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DAI_AUTHENTICATION_KEYS_PAGE_STR_DESC, request, context);
              return ListDaiAuthenticationKeysPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getDaiAuthenticationKey. */
  public UnaryCallSettings<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeySettings() {
    return getDaiAuthenticationKeySettings;
  }

  /** Returns the object with the settings used for calls to listDaiAuthenticationKeys. */
  public PagedCallSettings<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysSettings() {
    return listDaiAuthenticationKeysSettings;
  }

  /** Returns the object with the settings used for calls to createDaiAuthenticationKey. */
  public UnaryCallSettings<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeySettings() {
    return createDaiAuthenticationKeySettings;
  }

  /** Returns the object with the settings used for calls to batchCreateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysSettings() {
    return batchCreateDaiAuthenticationKeysSettings;
  }

  /** Returns the object with the settings used for calls to updateDaiAuthenticationKey. */
  public UnaryCallSettings<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeySettings() {
    return updateDaiAuthenticationKeySettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysSettings() {
    return batchUpdateDaiAuthenticationKeysSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysSettings() {
    return batchActivateDaiAuthenticationKeysSettings;
  }

  /**
   * Returns the object with the settings used for calls to batchDeactivateDaiAuthenticationKeys.
   */
  public UnaryCallSettings<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysSettings() {
    return batchDeactivateDaiAuthenticationKeysSettings;
  }

  public DaiAuthenticationKeyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDaiAuthenticationKeyServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DaiAuthenticationKeyServiceStubSettings.class))
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

  protected DaiAuthenticationKeyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDaiAuthenticationKeySettings = settingsBuilder.getDaiAuthenticationKeySettings().build();
    listDaiAuthenticationKeysSettings = settingsBuilder.listDaiAuthenticationKeysSettings().build();
    createDaiAuthenticationKeySettings =
        settingsBuilder.createDaiAuthenticationKeySettings().build();
    batchCreateDaiAuthenticationKeysSettings =
        settingsBuilder.batchCreateDaiAuthenticationKeysSettings().build();
    updateDaiAuthenticationKeySettings =
        settingsBuilder.updateDaiAuthenticationKeySettings().build();
    batchUpdateDaiAuthenticationKeysSettings =
        settingsBuilder.batchUpdateDaiAuthenticationKeysSettings().build();
    batchActivateDaiAuthenticationKeysSettings =
        settingsBuilder.batchActivateDaiAuthenticationKeysSettings().build();
    batchDeactivateDaiAuthenticationKeysSettings =
        settingsBuilder.batchDeactivateDaiAuthenticationKeysSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DaiAuthenticationKeyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DaiAuthenticationKeyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        getDaiAuthenticationKeySettings;
    private final PagedCallSettings.Builder<
            ListDaiAuthenticationKeysRequest,
            ListDaiAuthenticationKeysResponse,
            ListDaiAuthenticationKeysPagedResponse>
        listDaiAuthenticationKeysSettings;
    private final UnaryCallSettings.Builder<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        createDaiAuthenticationKeySettings;
    private final UnaryCallSettings.Builder<
            BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
        batchCreateDaiAuthenticationKeysSettings;
    private final UnaryCallSettings.Builder<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        updateDaiAuthenticationKeySettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
        batchUpdateDaiAuthenticationKeysSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
        batchActivateDaiAuthenticationKeysSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateDaiAuthenticationKeysRequest,
            BatchDeactivateDaiAuthenticationKeysResponse>
        batchDeactivateDaiAuthenticationKeysSettings;
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

      getDaiAuthenticationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDaiAuthenticationKeysSettings =
          PagedCallSettings.newBuilder(LIST_DAI_AUTHENTICATION_KEYS_PAGE_STR_FACT);
      createDaiAuthenticationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateDaiAuthenticationKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDaiAuthenticationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateDaiAuthenticationKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateDaiAuthenticationKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateDaiAuthenticationKeysSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDaiAuthenticationKeySettings,
              listDaiAuthenticationKeysSettings,
              createDaiAuthenticationKeySettings,
              batchCreateDaiAuthenticationKeysSettings,
              updateDaiAuthenticationKeySettings,
              batchUpdateDaiAuthenticationKeysSettings,
              batchActivateDaiAuthenticationKeysSettings,
              batchDeactivateDaiAuthenticationKeysSettings);
      initDefaults(this);
    }

    protected Builder(DaiAuthenticationKeyServiceStubSettings settings) {
      super(settings);

      getDaiAuthenticationKeySettings = settings.getDaiAuthenticationKeySettings.toBuilder();
      listDaiAuthenticationKeysSettings = settings.listDaiAuthenticationKeysSettings.toBuilder();
      createDaiAuthenticationKeySettings = settings.createDaiAuthenticationKeySettings.toBuilder();
      batchCreateDaiAuthenticationKeysSettings =
          settings.batchCreateDaiAuthenticationKeysSettings.toBuilder();
      updateDaiAuthenticationKeySettings = settings.updateDaiAuthenticationKeySettings.toBuilder();
      batchUpdateDaiAuthenticationKeysSettings =
          settings.batchUpdateDaiAuthenticationKeysSettings.toBuilder();
      batchActivateDaiAuthenticationKeysSettings =
          settings.batchActivateDaiAuthenticationKeysSettings.toBuilder();
      batchDeactivateDaiAuthenticationKeysSettings =
          settings.batchDeactivateDaiAuthenticationKeysSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDaiAuthenticationKeySettings,
              listDaiAuthenticationKeysSettings,
              createDaiAuthenticationKeySettings,
              batchCreateDaiAuthenticationKeysSettings,
              updateDaiAuthenticationKeySettings,
              batchUpdateDaiAuthenticationKeysSettings,
              batchActivateDaiAuthenticationKeysSettings,
              batchDeactivateDaiAuthenticationKeysSettings);
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
          .getDaiAuthenticationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDaiAuthenticationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDaiAuthenticationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateDaiAuthenticationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDaiAuthenticationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateDaiAuthenticationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateDaiAuthenticationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateDaiAuthenticationKeysSettings()
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

    /** Returns the builder for the settings used for calls to getDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        getDaiAuthenticationKeySettings() {
      return getDaiAuthenticationKeySettings;
    }

    /** Returns the builder for the settings used for calls to listDaiAuthenticationKeys. */
    public PagedCallSettings.Builder<
            ListDaiAuthenticationKeysRequest,
            ListDaiAuthenticationKeysResponse,
            ListDaiAuthenticationKeysPagedResponse>
        listDaiAuthenticationKeysSettings() {
      return listDaiAuthenticationKeysSettings;
    }

    /** Returns the builder for the settings used for calls to createDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        createDaiAuthenticationKeySettings() {
      return createDaiAuthenticationKeySettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateDaiAuthenticationKeys. */
    public UnaryCallSettings.Builder<
            BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
        batchCreateDaiAuthenticationKeysSettings() {
      return batchCreateDaiAuthenticationKeysSettings;
    }

    /** Returns the builder for the settings used for calls to updateDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        updateDaiAuthenticationKeySettings() {
      return updateDaiAuthenticationKeySettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateDaiAuthenticationKeys. */
    public UnaryCallSettings.Builder<
            BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
        batchUpdateDaiAuthenticationKeysSettings() {
      return batchUpdateDaiAuthenticationKeysSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchActivateDaiAuthenticationKeys.
     */
    public UnaryCallSettings.Builder<
            BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
        batchActivateDaiAuthenticationKeysSettings() {
      return batchActivateDaiAuthenticationKeysSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchDeactivateDaiAuthenticationKeys.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateDaiAuthenticationKeysRequest,
            BatchDeactivateDaiAuthenticationKeysResponse>
        batchDeactivateDaiAuthenticationKeysSettings() {
      return batchDeactivateDaiAuthenticationKeysSettings;
    }

    @Override
    public DaiAuthenticationKeyServiceStubSettings build() throws IOException {
      return new DaiAuthenticationKeyServiceStubSettings(this);
    }
  }
}
