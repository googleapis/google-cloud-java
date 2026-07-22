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

import static com.google.ads.admanager.v1.AdRuleServiceClient.ListAdRulesPagedResponse;

import com.google.ads.admanager.v1.AdRule;
import com.google.ads.admanager.v1.BatchActivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchActivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchCreateAdRulesRequest;
import com.google.ads.admanager.v1.BatchCreateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeleteAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesResponse;
import com.google.ads.admanager.v1.CreateAdRuleRequest;
import com.google.ads.admanager.v1.GetAdRuleRequest;
import com.google.ads.admanager.v1.ListAdRulesRequest;
import com.google.ads.admanager.v1.ListAdRulesResponse;
import com.google.ads.admanager.v1.UpdateAdRuleRequest;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdRuleServiceStub}.
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
 * of getAdRule:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdRuleServiceStubSettings.Builder adRuleServiceSettingsBuilder =
 *     AdRuleServiceStubSettings.newBuilder();
 * adRuleServiceSettingsBuilder
 *     .getAdRuleSettings()
 *     .setRetrySettings(
 *         adRuleServiceSettingsBuilder
 *             .getAdRuleSettings()
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
 * AdRuleServiceStubSettings adRuleServiceSettings = adRuleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AdRuleServiceStubSettings extends StubSettings<AdRuleServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetAdRuleRequest, AdRule> getAdRuleSettings;
  private final PagedCallSettings<ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
      listAdRulesSettings;
  private final UnaryCallSettings<CreateAdRuleRequest, AdRule> createAdRuleSettings;
  private final UnaryCallSettings<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesSettings;
  private final UnaryCallSettings<UpdateAdRuleRequest, AdRule> updateAdRuleSettings;
  private final UnaryCallSettings<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesSettings;
  private final UnaryCallSettings<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesSettings;
  private final UnaryCallSettings<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesSettings;
  private final UnaryCallSettings<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesSettings;

  private static final PagedListDescriptor<ListAdRulesRequest, ListAdRulesResponse, AdRule>
      LIST_AD_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAdRulesRequest, ListAdRulesResponse, AdRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdRulesRequest injectToken(ListAdRulesRequest payload, String token) {
              return ListAdRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdRulesRequest injectPageSize(ListAdRulesRequest payload, int pageSize) {
              return ListAdRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAdRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdRule> extractResources(ListAdRulesResponse payload) {
              return payload.getAdRulesList();
            }
          };

  private static final PagedListResponseFactory<
          ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
      LIST_AD_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>() {
            @Override
            public ApiFuture<ListAdRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdRulesRequest, ListAdRulesResponse> callable,
                ListAdRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListAdRulesResponse> futureResponse) {
              PageContext<ListAdRulesRequest, ListAdRulesResponse, AdRule> pageContext =
                  PageContext.create(callable, LIST_AD_RULES_PAGE_STR_DESC, request, context);
              return ListAdRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getAdRule. */
  public UnaryCallSettings<GetAdRuleRequest, AdRule> getAdRuleSettings() {
    return getAdRuleSettings;
  }

  /** Returns the object with the settings used for calls to listAdRules. */
  public PagedCallSettings<ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
      listAdRulesSettings() {
    return listAdRulesSettings;
  }

  /** Returns the object with the settings used for calls to createAdRule. */
  public UnaryCallSettings<CreateAdRuleRequest, AdRule> createAdRuleSettings() {
    return createAdRuleSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateAdRules. */
  public UnaryCallSettings<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesSettings() {
    return batchCreateAdRulesSettings;
  }

  /** Returns the object with the settings used for calls to updateAdRule. */
  public UnaryCallSettings<UpdateAdRuleRequest, AdRule> updateAdRuleSettings() {
    return updateAdRuleSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateAdRules. */
  public UnaryCallSettings<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesSettings() {
    return batchUpdateAdRulesSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateAdRules. */
  public UnaryCallSettings<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesSettings() {
    return batchActivateAdRulesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateAdRules. */
  public UnaryCallSettings<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesSettings() {
    return batchDeactivateAdRulesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteAdRules. */
  public UnaryCallSettings<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesSettings() {
    return batchDeleteAdRulesSettings;
  }

  public AdRuleServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAdRuleServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AdRuleServiceStubSettings.class))
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

  protected AdRuleServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAdRuleSettings = settingsBuilder.getAdRuleSettings().build();
    listAdRulesSettings = settingsBuilder.listAdRulesSettings().build();
    createAdRuleSettings = settingsBuilder.createAdRuleSettings().build();
    batchCreateAdRulesSettings = settingsBuilder.batchCreateAdRulesSettings().build();
    updateAdRuleSettings = settingsBuilder.updateAdRuleSettings().build();
    batchUpdateAdRulesSettings = settingsBuilder.batchUpdateAdRulesSettings().build();
    batchActivateAdRulesSettings = settingsBuilder.batchActivateAdRulesSettings().build();
    batchDeactivateAdRulesSettings = settingsBuilder.batchDeactivateAdRulesSettings().build();
    batchDeleteAdRulesSettings = settingsBuilder.batchDeleteAdRulesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AdRuleServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AdRuleServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAdRuleRequest, AdRule> getAdRuleSettings;
    private final PagedCallSettings.Builder<
            ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
        listAdRulesSettings;
    private final UnaryCallSettings.Builder<CreateAdRuleRequest, AdRule> createAdRuleSettings;
    private final UnaryCallSettings.Builder<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
        batchCreateAdRulesSettings;
    private final UnaryCallSettings.Builder<UpdateAdRuleRequest, AdRule> updateAdRuleSettings;
    private final UnaryCallSettings.Builder<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
        batchUpdateAdRulesSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
        batchActivateAdRulesSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
        batchDeactivateAdRulesSettings;
    private final UnaryCallSettings.Builder<BatchDeleteAdRulesRequest, Empty>
        batchDeleteAdRulesSettings;
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

      getAdRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdRulesSettings = PagedCallSettings.newBuilder(LIST_AD_RULES_PAGE_STR_FACT);
      createAdRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateAdRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAdRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateAdRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateAdRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateAdRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteAdRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdRuleSettings,
              listAdRulesSettings,
              createAdRuleSettings,
              batchCreateAdRulesSettings,
              updateAdRuleSettings,
              batchUpdateAdRulesSettings,
              batchActivateAdRulesSettings,
              batchDeactivateAdRulesSettings,
              batchDeleteAdRulesSettings);
      initDefaults(this);
    }

    protected Builder(AdRuleServiceStubSettings settings) {
      super(settings);

      getAdRuleSettings = settings.getAdRuleSettings.toBuilder();
      listAdRulesSettings = settings.listAdRulesSettings.toBuilder();
      createAdRuleSettings = settings.createAdRuleSettings.toBuilder();
      batchCreateAdRulesSettings = settings.batchCreateAdRulesSettings.toBuilder();
      updateAdRuleSettings = settings.updateAdRuleSettings.toBuilder();
      batchUpdateAdRulesSettings = settings.batchUpdateAdRulesSettings.toBuilder();
      batchActivateAdRulesSettings = settings.batchActivateAdRulesSettings.toBuilder();
      batchDeactivateAdRulesSettings = settings.batchDeactivateAdRulesSettings.toBuilder();
      batchDeleteAdRulesSettings = settings.batchDeleteAdRulesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdRuleSettings,
              listAdRulesSettings,
              createAdRuleSettings,
              batchCreateAdRulesSettings,
              updateAdRuleSettings,
              batchUpdateAdRulesSettings,
              batchActivateAdRulesSettings,
              batchDeactivateAdRulesSettings,
              batchDeleteAdRulesSettings);
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
          .getAdRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAdRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateAdRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAdRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateAdRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateAdRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateAdRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeleteAdRulesSettings()
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

    /** Returns the builder for the settings used for calls to getAdRule. */
    public UnaryCallSettings.Builder<GetAdRuleRequest, AdRule> getAdRuleSettings() {
      return getAdRuleSettings;
    }

    /** Returns the builder for the settings used for calls to listAdRules. */
    public PagedCallSettings.Builder<
            ListAdRulesRequest, ListAdRulesResponse, ListAdRulesPagedResponse>
        listAdRulesSettings() {
      return listAdRulesSettings;
    }

    /** Returns the builder for the settings used for calls to createAdRule. */
    public UnaryCallSettings.Builder<CreateAdRuleRequest, AdRule> createAdRuleSettings() {
      return createAdRuleSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateAdRules. */
    public UnaryCallSettings.Builder<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
        batchCreateAdRulesSettings() {
      return batchCreateAdRulesSettings;
    }

    /** Returns the builder for the settings used for calls to updateAdRule. */
    public UnaryCallSettings.Builder<UpdateAdRuleRequest, AdRule> updateAdRuleSettings() {
      return updateAdRuleSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateAdRules. */
    public UnaryCallSettings.Builder<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
        batchUpdateAdRulesSettings() {
      return batchUpdateAdRulesSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateAdRules. */
    public UnaryCallSettings.Builder<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
        batchActivateAdRulesSettings() {
      return batchActivateAdRulesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateAdRules. */
    public UnaryCallSettings.Builder<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
        batchDeactivateAdRulesSettings() {
      return batchDeactivateAdRulesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteAdRules. */
    public UnaryCallSettings.Builder<BatchDeleteAdRulesRequest, Empty>
        batchDeleteAdRulesSettings() {
      return batchDeleteAdRulesSettings;
    }

    @Override
    public AdRuleServiceStubSettings build() throws IOException {
      return new AdRuleServiceStubSettings(this);
    }
  }
}
