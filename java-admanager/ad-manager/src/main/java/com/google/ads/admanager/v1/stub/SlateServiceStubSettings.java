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

import static com.google.ads.admanager.v1.SlateServiceClient.ListSlatesPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchArchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchCreateSlatesRequest;
import com.google.ads.admanager.v1.BatchCreateSlatesResponse;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchUpdateSlatesRequest;
import com.google.ads.admanager.v1.BatchUpdateSlatesResponse;
import com.google.ads.admanager.v1.CreateSlateRequest;
import com.google.ads.admanager.v1.GetSlateRequest;
import com.google.ads.admanager.v1.ListSlatesRequest;
import com.google.ads.admanager.v1.ListSlatesResponse;
import com.google.ads.admanager.v1.Slate;
import com.google.ads.admanager.v1.UpdateSlateRequest;
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
 * Settings class to configure an instance of {@link SlateServiceStub}.
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
 * of getSlate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SlateServiceStubSettings.Builder slateServiceSettingsBuilder =
 *     SlateServiceStubSettings.newBuilder();
 * slateServiceSettingsBuilder
 *     .getSlateSettings()
 *     .setRetrySettings(
 *         slateServiceSettingsBuilder
 *             .getSlateSettings()
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
 * SlateServiceStubSettings slateServiceSettings = slateServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SlateServiceStubSettings extends StubSettings<SlateServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings;
  private final PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings;
  private final UnaryCallSettings<CreateSlateRequest, Slate> createSlateSettings;
  private final UnaryCallSettings<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesSettings;
  private final UnaryCallSettings<UpdateSlateRequest, Slate> updateSlateSettings;
  private final UnaryCallSettings<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesSettings;
  private final UnaryCallSettings<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesSettings;
  private final UnaryCallSettings<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesSettings;

  private static final PagedListDescriptor<ListSlatesRequest, ListSlatesResponse, Slate>
      LIST_SLATES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSlatesRequest, ListSlatesResponse, Slate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSlatesRequest injectToken(ListSlatesRequest payload, String token) {
              return ListSlatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSlatesRequest injectPageSize(ListSlatesRequest payload, int pageSize) {
              return ListSlatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSlatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSlatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Slate> extractResources(ListSlatesResponse payload) {
              return payload.getSlatesList();
            }
          };

  private static final PagedListResponseFactory<
          ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      LIST_SLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>() {
            @Override
            public ApiFuture<ListSlatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSlatesRequest, ListSlatesResponse> callable,
                ListSlatesRequest request,
                ApiCallContext context,
                ApiFuture<ListSlatesResponse> futureResponse) {
              PageContext<ListSlatesRequest, ListSlatesResponse, Slate> pageContext =
                  PageContext.create(callable, LIST_SLATES_PAGE_STR_DESC, request, context);
              return ListSlatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSlate. */
  public UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings() {
    return getSlateSettings;
  }

  /** Returns the object with the settings used for calls to listSlates. */
  public PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings() {
    return listSlatesSettings;
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public UnaryCallSettings<CreateSlateRequest, Slate> createSlateSettings() {
    return createSlateSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateSlates. */
  public UnaryCallSettings<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesSettings() {
    return batchCreateSlatesSettings;
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public UnaryCallSettings<UpdateSlateRequest, Slate> updateSlateSettings() {
    return updateSlateSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateSlates. */
  public UnaryCallSettings<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesSettings() {
    return batchUpdateSlatesSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveSlates. */
  public UnaryCallSettings<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesSettings() {
    return batchArchiveSlatesSettings;
  }

  /** Returns the object with the settings used for calls to batchUnarchiveSlates. */
  public UnaryCallSettings<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesSettings() {
    return batchUnarchiveSlatesSettings;
  }

  public SlateServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSlateServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SlateServiceStubSettings.class))
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

  protected SlateServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSlateSettings = settingsBuilder.getSlateSettings().build();
    listSlatesSettings = settingsBuilder.listSlatesSettings().build();
    createSlateSettings = settingsBuilder.createSlateSettings().build();
    batchCreateSlatesSettings = settingsBuilder.batchCreateSlatesSettings().build();
    updateSlateSettings = settingsBuilder.updateSlateSettings().build();
    batchUpdateSlatesSettings = settingsBuilder.batchUpdateSlatesSettings().build();
    batchArchiveSlatesSettings = settingsBuilder.batchArchiveSlatesSettings().build();
    batchUnarchiveSlatesSettings = settingsBuilder.batchUnarchiveSlatesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SlateServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SlateServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings;
    private final PagedCallSettings.Builder<
            ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings;
    private final UnaryCallSettings.Builder<CreateSlateRequest, Slate> createSlateSettings;
    private final UnaryCallSettings.Builder<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
        batchCreateSlatesSettings;
    private final UnaryCallSettings.Builder<UpdateSlateRequest, Slate> updateSlateSettings;
    private final UnaryCallSettings.Builder<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
        batchUpdateSlatesSettings;
    private final UnaryCallSettings.Builder<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
        batchArchiveSlatesSettings;
    private final UnaryCallSettings.Builder<
            BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
        batchUnarchiveSlatesSettings;
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

      getSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSlatesSettings = PagedCallSettings.newBuilder(LIST_SLATES_PAGE_STR_FACT);
      createSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateSlatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateSlatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveSlatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUnarchiveSlatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSlateSettings,
              listSlatesSettings,
              createSlateSettings,
              batchCreateSlatesSettings,
              updateSlateSettings,
              batchUpdateSlatesSettings,
              batchArchiveSlatesSettings,
              batchUnarchiveSlatesSettings);
      initDefaults(this);
    }

    protected Builder(SlateServiceStubSettings settings) {
      super(settings);

      getSlateSettings = settings.getSlateSettings.toBuilder();
      listSlatesSettings = settings.listSlatesSettings.toBuilder();
      createSlateSettings = settings.createSlateSettings.toBuilder();
      batchCreateSlatesSettings = settings.batchCreateSlatesSettings.toBuilder();
      updateSlateSettings = settings.updateSlateSettings.toBuilder();
      batchUpdateSlatesSettings = settings.batchUpdateSlatesSettings.toBuilder();
      batchArchiveSlatesSettings = settings.batchArchiveSlatesSettings.toBuilder();
      batchUnarchiveSlatesSettings = settings.batchUnarchiveSlatesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSlateSettings,
              listSlatesSettings,
              createSlateSettings,
              batchCreateSlatesSettings,
              updateSlateSettings,
              batchUpdateSlatesSettings,
              batchArchiveSlatesSettings,
              batchUnarchiveSlatesSettings);
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
          .getSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSlatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateSlatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateSlatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveSlatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUnarchiveSlatesSettings()
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

    /** Returns the builder for the settings used for calls to getSlate. */
    public UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings() {
      return getSlateSettings;
    }

    /** Returns the builder for the settings used for calls to listSlates. */
    public PagedCallSettings.Builder<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings() {
      return listSlatesSettings;
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public UnaryCallSettings.Builder<CreateSlateRequest, Slate> createSlateSettings() {
      return createSlateSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateSlates. */
    public UnaryCallSettings.Builder<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
        batchCreateSlatesSettings() {
      return batchCreateSlatesSettings;
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public UnaryCallSettings.Builder<UpdateSlateRequest, Slate> updateSlateSettings() {
      return updateSlateSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateSlates. */
    public UnaryCallSettings.Builder<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
        batchUpdateSlatesSettings() {
      return batchUpdateSlatesSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveSlates. */
    public UnaryCallSettings.Builder<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
        batchArchiveSlatesSettings() {
      return batchArchiveSlatesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveSlates. */
    public UnaryCallSettings.Builder<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
        batchUnarchiveSlatesSettings() {
      return batchUnarchiveSlatesSettings;
    }

    @Override
    public SlateServiceStubSettings build() throws IOException {
      return new SlateServiceStubSettings(this);
    }
  }
}
