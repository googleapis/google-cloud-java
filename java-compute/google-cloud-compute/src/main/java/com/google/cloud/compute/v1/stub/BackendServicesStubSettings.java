/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendServicesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.BackendServicesScopedList;
import com.google.cloud.compute.v1.DeleteBackendServiceRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.GetBackendServiceRequest;
import com.google.cloud.compute.v1.GetHealthBackendServiceRequest;
import com.google.cloud.compute.v1.InsertBackendServiceRequest;
import com.google.cloud.compute.v1.ListBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendServiceRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.UpdateBackendServiceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackendServicesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addSignedUrlKey to 30 seconds:
 *
 * <pre>{@code
 * BackendServicesStubSettings.Builder backendServicesSettingsBuilder =
 *     BackendServicesStubSettings.newBuilder();
 * backendServicesSettingsBuilder
 *     .addSignedUrlKeySettings()
 *     .setRetrySettings(
 *         backendServicesSettingsBuilder
 *             .addSignedUrlKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BackendServicesStubSettings backendServicesSettings = backendServicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackendServicesStubSettings extends StubSettings<BackendServicesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeySettings;
  private final PagedCallSettings<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteBackendServiceRequest, Operation> deleteSettings;
  private final UnaryCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeySettings;
  private final UnaryCallSettings<GetBackendServiceRequest, BackendService> getSettings;
  private final UnaryCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthSettings;
  private final UnaryCallSettings<InsertBackendServiceRequest, Operation> insertSettings;
  private final PagedCallSettings<ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchBackendServiceRequest, Operation> patchSettings;
  private final UnaryCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicySettings;
  private final UnaryCallSettings<UpdateBackendServiceRequest, Operation> updateSettings;

  private static final PagedListDescriptor<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Map.Entry<String, BackendServicesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListBackendServicesRequest,
              BackendServiceAggregatedList,
              Map.Entry<String, BackendServicesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListBackendServicesRequest injectToken(
                AggregatedListBackendServicesRequest payload, String token) {
              return AggregatedListBackendServicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListBackendServicesRequest injectPageSize(
                AggregatedListBackendServicesRequest payload, int pageSize) {
              return AggregatedListBackendServicesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListBackendServicesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, BackendServicesScopedList>> extractResources(
                BackendServiceAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, BackendServicesScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListBackendServicesRequest, BackendServiceList, BackendService>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackendServicesRequest, BackendServiceList, BackendService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackendServicesRequest injectToken(
                ListBackendServicesRequest payload, String token) {
              return ListBackendServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackendServicesRequest injectPageSize(
                ListBackendServicesRequest payload, int pageSize) {
              return ListBackendServicesRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackendServicesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendService> extractResources(BackendServiceList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<BackendService>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListBackendServicesRequest,
              BackendServiceAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
                    callable,
                AggregatedListBackendServicesRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListBackendServicesRequest,
                      BackendServiceAggregatedList,
                      Map.Entry<String, BackendServicesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackendServicesRequest, BackendServiceList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackendServicesRequest, BackendServiceList> callable,
                ListBackendServicesRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceList> futureResponse) {
              PageContext<ListBackendServicesRequest, BackendServiceList, BackendService>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public UnaryCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeySettings() {
    return addSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteBackendServiceRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public UnaryCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeySettings() {
    return deleteSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetBackendServiceRequest, BackendService> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getHealth. */
  public UnaryCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthSettings() {
    return getHealthSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertBackendServiceRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchBackendServiceRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to setSecurityPolicy. */
  public UnaryCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicySettings() {
    return setSecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateBackendServiceRequest, Operation> updateSettings() {
    return updateSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BackendServicesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackendServicesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BackendServicesStubSettings.class))
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

  protected BackendServicesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addSignedUrlKeySettings = settingsBuilder.addSignedUrlKeySettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteSignedUrlKeySettings = settingsBuilder.deleteSignedUrlKeySettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getHealthSettings = settingsBuilder.getHealthSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    setSecurityPolicySettings = settingsBuilder.setSecurityPolicySettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
  }

  /** Builder for BackendServicesStubSettings. */
  public static class Builder extends StubSettings.Builder<BackendServicesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeySettings;
    private final PagedCallSettings.Builder<
            AggregatedListBackendServicesRequest,
            BackendServiceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteBackendServiceRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeySettings;
    private final UnaryCallSettings.Builder<GetBackendServiceRequest, BackendService> getSettings;
    private final UnaryCallSettings.Builder<
            GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthSettings;
    private final UnaryCallSettings.Builder<InsertBackendServiceRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<
            ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchBackendServiceRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicySettings;
    private final UnaryCallSettings.Builder<UpdateBackendServiceRequest, Operation> updateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHealthSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              aggregatedListSettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              getHealthSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setSecurityPolicySettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(BackendServicesStubSettings settings) {
      super(settings);

      addSignedUrlKeySettings = settings.addSignedUrlKeySettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteSignedUrlKeySettings = settings.deleteSignedUrlKeySettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getHealthSettings = settings.getHealthSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      setSecurityPolicySettings = settings.setSecurityPolicySettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              aggregatedListSettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              getHealthSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setSecurityPolicySettings,
              updateSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .addSignedUrlKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSignedUrlKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHealthSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setSecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public UnaryCallSettings.Builder<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeySettings() {
      return addSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListBackendServicesRequest,
            BackendServiceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteBackendServiceRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeySettings() {
      return deleteSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetBackendServiceRequest, BackendService> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getHealth. */
    public UnaryCallSettings.Builder<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthSettings() {
      return getHealthSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertBackendServiceRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchBackendServiceRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to setSecurityPolicy. */
    public UnaryCallSettings.Builder<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicySettings() {
      return setSecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateBackendServiceRequest, Operation> updateSettings() {
      return updateSettings;
    }

    @Override
    public BackendServicesStubSettings build() throws IOException {
      return new BackendServicesStubSettings(this);
    }
  }
}
