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

import static com.google.ads.admanager.v1.DaiEncodingProfileServiceClient.ListDaiEncodingProfilesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.CreateDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.DaiEncodingProfile;
import com.google.ads.admanager.v1.GetDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.UpdateDaiEncodingProfileRequest;
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
 * Settings class to configure an instance of {@link DaiEncodingProfileServiceStub}.
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
 * of getDaiEncodingProfile:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiEncodingProfileServiceStubSettings.Builder daiEncodingProfileServiceSettingsBuilder =
 *     DaiEncodingProfileServiceStubSettings.newBuilder();
 * daiEncodingProfileServiceSettingsBuilder
 *     .getDaiEncodingProfileSettings()
 *     .setRetrySettings(
 *         daiEncodingProfileServiceSettingsBuilder
 *             .getDaiEncodingProfileSettings()
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
 * DaiEncodingProfileServiceStubSettings daiEncodingProfileServiceSettings =
 *     daiEncodingProfileServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DaiEncodingProfileServiceStubSettings
    extends StubSettings<DaiEncodingProfileServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileSettings;
  private final PagedCallSettings<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesSettings;
  private final UnaryCallSettings<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileSettings;
  private final UnaryCallSettings<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesSettings;
  private final UnaryCallSettings<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileSettings;
  private final UnaryCallSettings<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesSettings;
  private final UnaryCallSettings<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesSettings;
  private final UnaryCallSettings<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesSettings;

  private static final PagedListDescriptor<
          ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse, DaiEncodingProfile>
      LIST_DAI_ENCODING_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDaiEncodingProfilesRequest,
              ListDaiEncodingProfilesResponse,
              DaiEncodingProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDaiEncodingProfilesRequest injectToken(
                ListDaiEncodingProfilesRequest payload, String token) {
              return ListDaiEncodingProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDaiEncodingProfilesRequest injectPageSize(
                ListDaiEncodingProfilesRequest payload, int pageSize) {
              return ListDaiEncodingProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDaiEncodingProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDaiEncodingProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DaiEncodingProfile> extractResources(
                ListDaiEncodingProfilesResponse payload) {
              return payload.getDaiEncodingProfilesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          ListDaiEncodingProfilesPagedResponse>
      LIST_DAI_ENCODING_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDaiEncodingProfilesRequest,
              ListDaiEncodingProfilesResponse,
              ListDaiEncodingProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListDaiEncodingProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
                    callable,
                ListDaiEncodingProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListDaiEncodingProfilesResponse> futureResponse) {
              PageContext<
                      ListDaiEncodingProfilesRequest,
                      ListDaiEncodingProfilesResponse,
                      DaiEncodingProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DAI_ENCODING_PROFILES_PAGE_STR_DESC, request, context);
              return ListDaiEncodingProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getDaiEncodingProfile. */
  public UnaryCallSettings<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileSettings() {
    return getDaiEncodingProfileSettings;
  }

  /** Returns the object with the settings used for calls to listDaiEncodingProfiles. */
  public PagedCallSettings<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesSettings() {
    return listDaiEncodingProfilesSettings;
  }

  /** Returns the object with the settings used for calls to createDaiEncodingProfile. */
  public UnaryCallSettings<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileSettings() {
    return createDaiEncodingProfileSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesSettings() {
    return batchCreateDaiEncodingProfilesSettings;
  }

  /** Returns the object with the settings used for calls to updateDaiEncodingProfile. */
  public UnaryCallSettings<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileSettings() {
    return updateDaiEncodingProfileSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesSettings() {
    return batchUpdateDaiEncodingProfilesSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesSettings() {
    return batchActivateDaiEncodingProfilesSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesSettings() {
    return batchArchiveDaiEncodingProfilesSettings;
  }

  public DaiEncodingProfileServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDaiEncodingProfileServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DaiEncodingProfileServiceStubSettings.class))
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

  protected DaiEncodingProfileServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDaiEncodingProfileSettings = settingsBuilder.getDaiEncodingProfileSettings().build();
    listDaiEncodingProfilesSettings = settingsBuilder.listDaiEncodingProfilesSettings().build();
    createDaiEncodingProfileSettings = settingsBuilder.createDaiEncodingProfileSettings().build();
    batchCreateDaiEncodingProfilesSettings =
        settingsBuilder.batchCreateDaiEncodingProfilesSettings().build();
    updateDaiEncodingProfileSettings = settingsBuilder.updateDaiEncodingProfileSettings().build();
    batchUpdateDaiEncodingProfilesSettings =
        settingsBuilder.batchUpdateDaiEncodingProfilesSettings().build();
    batchActivateDaiEncodingProfilesSettings =
        settingsBuilder.batchActivateDaiEncodingProfilesSettings().build();
    batchArchiveDaiEncodingProfilesSettings =
        settingsBuilder.batchArchiveDaiEncodingProfilesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DaiEncodingProfileServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DaiEncodingProfileServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetDaiEncodingProfileRequest, DaiEncodingProfile>
        getDaiEncodingProfileSettings;
    private final PagedCallSettings.Builder<
            ListDaiEncodingProfilesRequest,
            ListDaiEncodingProfilesResponse,
            ListDaiEncodingProfilesPagedResponse>
        listDaiEncodingProfilesSettings;
    private final UnaryCallSettings.Builder<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
        createDaiEncodingProfileSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
        batchCreateDaiEncodingProfilesSettings;
    private final UnaryCallSettings.Builder<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
        updateDaiEncodingProfileSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
        batchUpdateDaiEncodingProfilesSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
        batchActivateDaiEncodingProfilesSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
        batchArchiveDaiEncodingProfilesSettings;
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

      getDaiEncodingProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDaiEncodingProfilesSettings =
          PagedCallSettings.newBuilder(LIST_DAI_ENCODING_PROFILES_PAGE_STR_FACT);
      createDaiEncodingProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateDaiEncodingProfilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDaiEncodingProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateDaiEncodingProfilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateDaiEncodingProfilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveDaiEncodingProfilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDaiEncodingProfileSettings,
              listDaiEncodingProfilesSettings,
              createDaiEncodingProfileSettings,
              batchCreateDaiEncodingProfilesSettings,
              updateDaiEncodingProfileSettings,
              batchUpdateDaiEncodingProfilesSettings,
              batchActivateDaiEncodingProfilesSettings,
              batchArchiveDaiEncodingProfilesSettings);
      initDefaults(this);
    }

    protected Builder(DaiEncodingProfileServiceStubSettings settings) {
      super(settings);

      getDaiEncodingProfileSettings = settings.getDaiEncodingProfileSettings.toBuilder();
      listDaiEncodingProfilesSettings = settings.listDaiEncodingProfilesSettings.toBuilder();
      createDaiEncodingProfileSettings = settings.createDaiEncodingProfileSettings.toBuilder();
      batchCreateDaiEncodingProfilesSettings =
          settings.batchCreateDaiEncodingProfilesSettings.toBuilder();
      updateDaiEncodingProfileSettings = settings.updateDaiEncodingProfileSettings.toBuilder();
      batchUpdateDaiEncodingProfilesSettings =
          settings.batchUpdateDaiEncodingProfilesSettings.toBuilder();
      batchActivateDaiEncodingProfilesSettings =
          settings.batchActivateDaiEncodingProfilesSettings.toBuilder();
      batchArchiveDaiEncodingProfilesSettings =
          settings.batchArchiveDaiEncodingProfilesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDaiEncodingProfileSettings,
              listDaiEncodingProfilesSettings,
              createDaiEncodingProfileSettings,
              batchCreateDaiEncodingProfilesSettings,
              updateDaiEncodingProfileSettings,
              batchUpdateDaiEncodingProfilesSettings,
              batchActivateDaiEncodingProfilesSettings,
              batchArchiveDaiEncodingProfilesSettings);
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
          .getDaiEncodingProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDaiEncodingProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDaiEncodingProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateDaiEncodingProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDaiEncodingProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateDaiEncodingProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateDaiEncodingProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveDaiEncodingProfilesSettings()
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

    /** Returns the builder for the settings used for calls to getDaiEncodingProfile. */
    public UnaryCallSettings.Builder<GetDaiEncodingProfileRequest, DaiEncodingProfile>
        getDaiEncodingProfileSettings() {
      return getDaiEncodingProfileSettings;
    }

    /** Returns the builder for the settings used for calls to listDaiEncodingProfiles. */
    public PagedCallSettings.Builder<
            ListDaiEncodingProfilesRequest,
            ListDaiEncodingProfilesResponse,
            ListDaiEncodingProfilesPagedResponse>
        listDaiEncodingProfilesSettings() {
      return listDaiEncodingProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to createDaiEncodingProfile. */
    public UnaryCallSettings.Builder<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
        createDaiEncodingProfileSettings() {
      return createDaiEncodingProfileSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
        batchCreateDaiEncodingProfilesSettings() {
      return batchCreateDaiEncodingProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to updateDaiEncodingProfile. */
    public UnaryCallSettings.Builder<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
        updateDaiEncodingProfileSettings() {
      return updateDaiEncodingProfileSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
        batchUpdateDaiEncodingProfilesSettings() {
      return batchUpdateDaiEncodingProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
        batchActivateDaiEncodingProfilesSettings() {
      return batchActivateDaiEncodingProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
        batchArchiveDaiEncodingProfilesSettings() {
      return batchArchiveDaiEncodingProfilesSettings;
    }

    @Override
    public DaiEncodingProfileServiceStubSettings build() throws IOException {
      return new DaiEncodingProfileServiceStubSettings(this);
    }
  }
}
