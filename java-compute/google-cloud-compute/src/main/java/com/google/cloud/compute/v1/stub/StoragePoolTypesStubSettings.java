/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.compute.v1.StoragePoolTypesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.StoragePoolTypesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.cloud.compute.v1.AggregatedListStoragePoolTypesRequest;
import com.google.cloud.compute.v1.GetStoragePoolTypeRequest;
import com.google.cloud.compute.v1.ListStoragePoolTypesRequest;
import com.google.cloud.compute.v1.StoragePoolType;
import com.google.cloud.compute.v1.StoragePoolTypeAggregatedList;
import com.google.cloud.compute.v1.StoragePoolTypeList;
import com.google.cloud.compute.v1.StoragePoolTypesScopedList;
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
 * Settings class to configure an instance of {@link StoragePoolTypesStub}.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StoragePoolTypesStubSettings.Builder storagePoolTypesSettingsBuilder =
 *     StoragePoolTypesStubSettings.newBuilder();
 * storagePoolTypesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         storagePoolTypesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StoragePoolTypesStubSettings storagePoolTypesSettings = storagePoolTypesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StoragePoolTypesStubSettings extends StubSettings<StoragePoolTypesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListStoragePoolTypesRequest,
          StoragePoolTypeAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<GetStoragePoolTypeRequest, StoragePoolType> getSettings;
  private final PagedCallSettings<
          ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>
      listSettings;

  private static final PagedListDescriptor<
          AggregatedListStoragePoolTypesRequest,
          StoragePoolTypeAggregatedList,
          Map.Entry<String, StoragePoolTypesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListStoragePoolTypesRequest,
              StoragePoolTypeAggregatedList,
              Map.Entry<String, StoragePoolTypesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListStoragePoolTypesRequest injectToken(
                AggregatedListStoragePoolTypesRequest payload, String token) {
              return AggregatedListStoragePoolTypesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListStoragePoolTypesRequest injectPageSize(
                AggregatedListStoragePoolTypesRequest payload, int pageSize) {
              return AggregatedListStoragePoolTypesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListStoragePoolTypesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(StoragePoolTypeAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, StoragePoolTypesScopedList>> extractResources(
                StoragePoolTypeAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, StoragePoolTypesScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListStoragePoolTypesRequest, StoragePoolTypeList, StoragePoolType>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStoragePoolTypesRequest, StoragePoolTypeList, StoragePoolType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStoragePoolTypesRequest injectToken(
                ListStoragePoolTypesRequest payload, String token) {
              return ListStoragePoolTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStoragePoolTypesRequest injectPageSize(
                ListStoragePoolTypesRequest payload, int pageSize) {
              return ListStoragePoolTypesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListStoragePoolTypesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(StoragePoolTypeList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StoragePoolType> extractResources(StoragePoolTypeList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<StoragePoolType>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListStoragePoolTypesRequest,
          StoragePoolTypeAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListStoragePoolTypesRequest,
              StoragePoolTypeAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListStoragePoolTypesRequest, StoragePoolTypeAggregatedList>
                    callable,
                AggregatedListStoragePoolTypesRequest request,
                ApiCallContext context,
                ApiFuture<StoragePoolTypeAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListStoragePoolTypesRequest,
                      StoragePoolTypeAggregatedList,
                      Map.Entry<String, StoragePoolTypesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStoragePoolTypesRequest, StoragePoolTypeList> callable,
                ListStoragePoolTypesRequest request,
                ApiCallContext context,
                ApiFuture<StoragePoolTypeList> futureResponse) {
              PageContext<ListStoragePoolTypesRequest, StoragePoolTypeList, StoragePoolType>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListStoragePoolTypesRequest,
          StoragePoolTypeAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetStoragePoolTypeRequest, StoragePoolType> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  public StoragePoolTypesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStoragePoolTypesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
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
            "gapic", GaxProperties.getLibraryVersion(StoragePoolTypesStubSettings.class))
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

  protected StoragePoolTypesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    listSettings = settingsBuilder.listSettings().build();
  }

  /** Builder for StoragePoolTypesStubSettings. */
  public static class Builder extends StubSettings.Builder<StoragePoolTypesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListStoragePoolTypesRequest,
            StoragePoolTypeAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<GetStoragePoolTypeRequest, StoragePoolType> getSettings;
    private final PagedCallSettings.Builder<
            ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>
        listSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings, getSettings, listSettings);
      initDefaults(this);
    }

    protected Builder(StoragePoolTypesStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings, getSettings, listSettings);
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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListStoragePoolTypesRequest,
            StoragePoolTypeAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetStoragePoolTypeRequest, StoragePoolType> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListStoragePoolTypesRequest, StoragePoolTypeList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    @Override
    public StoragePoolTypesStubSettings build() throws IOException {
      return new StoragePoolTypesStubSettings(this);
    }
  }
}
