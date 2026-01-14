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

import static com.google.ads.admanager.v1.CustomTargetingKeyServiceClient.ListCustomTargetingKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.CreateCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.CustomTargetingKey;
import com.google.ads.admanager.v1.GetCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.UpdateCustomTargetingKeyRequest;
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
 * Settings class to configure an instance of {@link CustomTargetingKeyServiceStub}.
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
 * of getCustomTargetingKey:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomTargetingKeyServiceStubSettings.Builder customTargetingKeyServiceSettingsBuilder =
 *     CustomTargetingKeyServiceStubSettings.newBuilder();
 * customTargetingKeyServiceSettingsBuilder
 *     .getCustomTargetingKeySettings()
 *     .setRetrySettings(
 *         customTargetingKeyServiceSettingsBuilder
 *             .getCustomTargetingKeySettings()
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
 * CustomTargetingKeyServiceStubSettings customTargetingKeyServiceSettings =
 *     customTargetingKeyServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class CustomTargetingKeyServiceStubSettings
    extends StubSettings<CustomTargetingKeyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeySettings;
  private final PagedCallSettings<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysSettings;
  private final UnaryCallSettings<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeySettings;
  private final UnaryCallSettings<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysSettings;
  private final UnaryCallSettings<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeySettings;
  private final UnaryCallSettings<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysSettings;
  private final UnaryCallSettings<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysSettings;
  private final UnaryCallSettings<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysSettings;

  private static final PagedListDescriptor<
          ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
      LIST_CUSTOM_TARGETING_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomTargetingKeysRequest,
              ListCustomTargetingKeysResponse,
              CustomTargetingKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomTargetingKeysRequest injectToken(
                ListCustomTargetingKeysRequest payload, String token) {
              return ListCustomTargetingKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomTargetingKeysRequest injectPageSize(
                ListCustomTargetingKeysRequest payload, int pageSize) {
              return ListCustomTargetingKeysRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCustomTargetingKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomTargetingKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomTargetingKey> extractResources(
                ListCustomTargetingKeysResponse payload) {
              return payload.getCustomTargetingKeysList();
            }
          };

  private static final PagedListResponseFactory<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          ListCustomTargetingKeysPagedResponse>
      LIST_CUSTOM_TARGETING_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomTargetingKeysRequest,
              ListCustomTargetingKeysResponse,
              ListCustomTargetingKeysPagedResponse>() {
            @Override
            public ApiFuture<ListCustomTargetingKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
                    callable,
                ListCustomTargetingKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomTargetingKeysResponse> futureResponse) {
              PageContext<
                      ListCustomTargetingKeysRequest,
                      ListCustomTargetingKeysResponse,
                      CustomTargetingKey>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_TARGETING_KEYS_PAGE_STR_DESC, request, context);
              return ListCustomTargetingKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getCustomTargetingKey. */
  public UnaryCallSettings<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeySettings() {
    return getCustomTargetingKeySettings;
  }

  /** Returns the object with the settings used for calls to listCustomTargetingKeys. */
  public PagedCallSettings<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysSettings() {
    return listCustomTargetingKeysSettings;
  }

  /** Returns the object with the settings used for calls to createCustomTargetingKey. */
  public UnaryCallSettings<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeySettings() {
    return createCustomTargetingKeySettings;
  }

  /** Returns the object with the settings used for calls to batchCreateCustomTargetingKeys. */
  public UnaryCallSettings<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysSettings() {
    return batchCreateCustomTargetingKeysSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomTargetingKey. */
  public UnaryCallSettings<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeySettings() {
    return updateCustomTargetingKeySettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateCustomTargetingKeys. */
  public UnaryCallSettings<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysSettings() {
    return batchUpdateCustomTargetingKeysSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateCustomTargetingKeys. */
  public UnaryCallSettings<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysSettings() {
    return batchActivateCustomTargetingKeysSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateCustomTargetingKeys. */
  public UnaryCallSettings<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysSettings() {
    return batchDeactivateCustomTargetingKeysSettings;
  }

  public CustomTargetingKeyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCustomTargetingKeyServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(CustomTargetingKeyServiceStubSettings.class))
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

  protected CustomTargetingKeyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getCustomTargetingKeySettings = settingsBuilder.getCustomTargetingKeySettings().build();
    listCustomTargetingKeysSettings = settingsBuilder.listCustomTargetingKeysSettings().build();
    createCustomTargetingKeySettings = settingsBuilder.createCustomTargetingKeySettings().build();
    batchCreateCustomTargetingKeysSettings =
        settingsBuilder.batchCreateCustomTargetingKeysSettings().build();
    updateCustomTargetingKeySettings = settingsBuilder.updateCustomTargetingKeySettings().build();
    batchUpdateCustomTargetingKeysSettings =
        settingsBuilder.batchUpdateCustomTargetingKeysSettings().build();
    batchActivateCustomTargetingKeysSettings =
        settingsBuilder.batchActivateCustomTargetingKeysSettings().build();
    batchDeactivateCustomTargetingKeysSettings =
        settingsBuilder.batchDeactivateCustomTargetingKeysSettings().build();
  }

  /** Builder for CustomTargetingKeyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CustomTargetingKeyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetCustomTargetingKeyRequest, CustomTargetingKey>
        getCustomTargetingKeySettings;
    private final PagedCallSettings.Builder<
            ListCustomTargetingKeysRequest,
            ListCustomTargetingKeysResponse,
            ListCustomTargetingKeysPagedResponse>
        listCustomTargetingKeysSettings;
    private final UnaryCallSettings.Builder<CreateCustomTargetingKeyRequest, CustomTargetingKey>
        createCustomTargetingKeySettings;
    private final UnaryCallSettings.Builder<
            BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
        batchCreateCustomTargetingKeysSettings;
    private final UnaryCallSettings.Builder<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
        updateCustomTargetingKeySettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
        batchUpdateCustomTargetingKeysSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
        batchActivateCustomTargetingKeysSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
        batchDeactivateCustomTargetingKeysSettings;
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

      getCustomTargetingKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomTargetingKeysSettings =
          PagedCallSettings.newBuilder(LIST_CUSTOM_TARGETING_KEYS_PAGE_STR_FACT);
      createCustomTargetingKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateCustomTargetingKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomTargetingKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateCustomTargetingKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateCustomTargetingKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateCustomTargetingKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCustomTargetingKeySettings,
              listCustomTargetingKeysSettings,
              createCustomTargetingKeySettings,
              batchCreateCustomTargetingKeysSettings,
              updateCustomTargetingKeySettings,
              batchUpdateCustomTargetingKeysSettings,
              batchActivateCustomTargetingKeysSettings,
              batchDeactivateCustomTargetingKeysSettings);
      initDefaults(this);
    }

    protected Builder(CustomTargetingKeyServiceStubSettings settings) {
      super(settings);

      getCustomTargetingKeySettings = settings.getCustomTargetingKeySettings.toBuilder();
      listCustomTargetingKeysSettings = settings.listCustomTargetingKeysSettings.toBuilder();
      createCustomTargetingKeySettings = settings.createCustomTargetingKeySettings.toBuilder();
      batchCreateCustomTargetingKeysSettings =
          settings.batchCreateCustomTargetingKeysSettings.toBuilder();
      updateCustomTargetingKeySettings = settings.updateCustomTargetingKeySettings.toBuilder();
      batchUpdateCustomTargetingKeysSettings =
          settings.batchUpdateCustomTargetingKeysSettings.toBuilder();
      batchActivateCustomTargetingKeysSettings =
          settings.batchActivateCustomTargetingKeysSettings.toBuilder();
      batchDeactivateCustomTargetingKeysSettings =
          settings.batchDeactivateCustomTargetingKeysSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCustomTargetingKeySettings,
              listCustomTargetingKeysSettings,
              createCustomTargetingKeySettings,
              batchCreateCustomTargetingKeysSettings,
              updateCustomTargetingKeySettings,
              batchUpdateCustomTargetingKeysSettings,
              batchActivateCustomTargetingKeysSettings,
              batchDeactivateCustomTargetingKeysSettings);
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
          .getCustomTargetingKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCustomTargetingKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCustomTargetingKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateCustomTargetingKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCustomTargetingKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateCustomTargetingKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateCustomTargetingKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateCustomTargetingKeysSettings()
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

    /** Returns the builder for the settings used for calls to getCustomTargetingKey. */
    public UnaryCallSettings.Builder<GetCustomTargetingKeyRequest, CustomTargetingKey>
        getCustomTargetingKeySettings() {
      return getCustomTargetingKeySettings;
    }

    /** Returns the builder for the settings used for calls to listCustomTargetingKeys. */
    public PagedCallSettings.Builder<
            ListCustomTargetingKeysRequest,
            ListCustomTargetingKeysResponse,
            ListCustomTargetingKeysPagedResponse>
        listCustomTargetingKeysSettings() {
      return listCustomTargetingKeysSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomTargetingKey. */
    public UnaryCallSettings.Builder<CreateCustomTargetingKeyRequest, CustomTargetingKey>
        createCustomTargetingKeySettings() {
      return createCustomTargetingKeySettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateCustomTargetingKeys. */
    public UnaryCallSettings.Builder<
            BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
        batchCreateCustomTargetingKeysSettings() {
      return batchCreateCustomTargetingKeysSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomTargetingKey. */
    public UnaryCallSettings.Builder<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
        updateCustomTargetingKeySettings() {
      return updateCustomTargetingKeySettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateCustomTargetingKeys. */
    public UnaryCallSettings.Builder<
            BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
        batchUpdateCustomTargetingKeysSettings() {
      return batchUpdateCustomTargetingKeysSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateCustomTargetingKeys. */
    public UnaryCallSettings.Builder<
            BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
        batchActivateCustomTargetingKeysSettings() {
      return batchActivateCustomTargetingKeysSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchDeactivateCustomTargetingKeys.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
        batchDeactivateCustomTargetingKeysSettings() {
      return batchDeactivateCustomTargetingKeysSettings;
    }

    @Override
    public CustomTargetingKeyServiceStubSettings build() throws IOException {
      return new CustomTargetingKeyServiceStubSettings(this);
    }
  }
}
