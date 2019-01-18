/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.AcceleratorTypeClient.AggregatedListAcceleratorTypesPagedResponse;
import static com.google.cloud.compute.v1.AcceleratorTypeClient.ListAcceleratorTypesPagedResponse;

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
import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypeAggregatedList;
import com.google.cloud.compute.v1.AcceleratorTypeList;
import com.google.cloud.compute.v1.AcceleratorTypesScopedList;
import com.google.cloud.compute.v1.AggregatedListAcceleratorTypesHttpRequest;
import com.google.cloud.compute.v1.GetAcceleratorTypeHttpRequest;
import com.google.cloud.compute.v1.ListAcceleratorTypesHttpRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link AcceleratorTypeStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getAcceleratorType to 30 seconds:
 *
 * <pre>
 * <code>
 * AcceleratorTypeStubSettings.Builder acceleratorTypeSettingsBuilder =
 *     AcceleratorTypeStubSettings.newBuilder();
 * acceleratorTypeSettingsBuilder.getAcceleratorTypeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AcceleratorTypeStubSettings acceleratorTypeSettings = acceleratorTypeSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AcceleratorTypeStubSettings extends StubSettings<AcceleratorTypeStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final PagedCallSettings<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesSettings;
  private final UnaryCallSettings<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeSettings;
  private final PagedCallSettings<
          ListAcceleratorTypesHttpRequest, AcceleratorTypeList, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings;

  /** Returns the object with the settings used for calls to aggregatedListAcceleratorTypes. */
  public PagedCallSettings<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesSettings() {
    return aggregatedListAcceleratorTypesSettings;
  }

  /** Returns the object with the settings used for calls to getAcceleratorType. */
  public UnaryCallSettings<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeSettings() {
    return getAcceleratorTypeSettings;
  }

  /** Returns the object with the settings used for calls to listAcceleratorTypes. */
  public PagedCallSettings<
          ListAcceleratorTypesHttpRequest, AcceleratorTypeList, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings() {
    return listAcceleratorTypesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AcceleratorTypeStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAcceleratorTypeStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
            "gapic", GaxProperties.getLibraryVersion(AcceleratorTypeStubSettings.class))
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

  protected AcceleratorTypeStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListAcceleratorTypesSettings =
        settingsBuilder.aggregatedListAcceleratorTypesSettings().build();
    getAcceleratorTypeSettings = settingsBuilder.getAcceleratorTypeSettings().build();
    listAcceleratorTypesSettings = settingsBuilder.listAcceleratorTypesSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AcceleratorTypesScopedList>
      AGGREGATED_LIST_ACCELERATOR_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListAcceleratorTypesHttpRequest,
              AcceleratorTypeAggregatedList,
              AcceleratorTypesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListAcceleratorTypesHttpRequest injectToken(
                AggregatedListAcceleratorTypesHttpRequest payload, String token) {
              return AggregatedListAcceleratorTypesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListAcceleratorTypesHttpRequest injectPageSize(
                AggregatedListAcceleratorTypesHttpRequest payload, int pageSize) {
              return AggregatedListAcceleratorTypesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListAcceleratorTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(AcceleratorTypeAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AcceleratorTypesScopedList> extractResources(
                AcceleratorTypeAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<AcceleratorTypesScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType>
      LIST_ACCELERATOR_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAcceleratorTypesHttpRequest injectToken(
                ListAcceleratorTypesHttpRequest payload, String token) {
              return ListAcceleratorTypesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAcceleratorTypesHttpRequest injectPageSize(
                ListAcceleratorTypesHttpRequest payload, int pageSize) {
              return ListAcceleratorTypesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAcceleratorTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(AcceleratorTypeList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AcceleratorType> extractResources(AcceleratorTypeList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<AcceleratorType>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListAcceleratorTypesHttpRequest,
          AcceleratorTypeAggregatedList,
          AggregatedListAcceleratorTypesPagedResponse>
      AGGREGATED_LIST_ACCELERATOR_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListAcceleratorTypesHttpRequest,
              AcceleratorTypeAggregatedList,
              AggregatedListAcceleratorTypesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListAcceleratorTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
                    callable,
                AggregatedListAcceleratorTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<AcceleratorTypeAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListAcceleratorTypesHttpRequest,
                      AcceleratorTypeAggregatedList,
                      AcceleratorTypesScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_ACCELERATOR_TYPES_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListAcceleratorTypesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAcceleratorTypesHttpRequest, AcceleratorTypeList, ListAcceleratorTypesPagedResponse>
      LIST_ACCELERATOR_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAcceleratorTypesHttpRequest,
              AcceleratorTypeList,
              ListAcceleratorTypesPagedResponse>() {
            @Override
            public ApiFuture<ListAcceleratorTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAcceleratorTypesHttpRequest, AcceleratorTypeList> callable,
                ListAcceleratorTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<AcceleratorTypeList> futureResponse) {
              PageContext<ListAcceleratorTypesHttpRequest, AcceleratorTypeList, AcceleratorType>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCELERATOR_TYPES_PAGE_STR_DESC, request, context);
              return ListAcceleratorTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for AcceleratorTypeStubSettings. */
  public static class Builder extends StubSettings.Builder<AcceleratorTypeStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListAcceleratorTypesHttpRequest,
            AcceleratorTypeAggregatedList,
            AggregatedListAcceleratorTypesPagedResponse>
        aggregatedListAcceleratorTypesSettings;
    private final UnaryCallSettings.Builder<GetAcceleratorTypeHttpRequest, AcceleratorType>
        getAcceleratorTypeSettings;
    private final PagedCallSettings.Builder<
            ListAcceleratorTypesHttpRequest, AcceleratorTypeList, ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListAcceleratorTypesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_ACCELERATOR_TYPES_PAGE_STR_FACT);

      getAcceleratorTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listAcceleratorTypesSettings =
          PagedCallSettings.newBuilder(LIST_ACCELERATOR_TYPES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListAcceleratorTypesSettings,
              getAcceleratorTypeSettings,
              listAcceleratorTypesSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .aggregatedListAcceleratorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getAcceleratorTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listAcceleratorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(AcceleratorTypeStubSettings settings) {
      super(settings);

      aggregatedListAcceleratorTypesSettings =
          settings.aggregatedListAcceleratorTypesSettings.toBuilder();
      getAcceleratorTypeSettings = settings.getAcceleratorTypeSettings.toBuilder();
      listAcceleratorTypesSettings = settings.listAcceleratorTypesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListAcceleratorTypesSettings,
              getAcceleratorTypeSettings,
              listAcceleratorTypesSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to aggregatedListAcceleratorTypes. */
    public PagedCallSettings.Builder<
            AggregatedListAcceleratorTypesHttpRequest,
            AcceleratorTypeAggregatedList,
            AggregatedListAcceleratorTypesPagedResponse>
        aggregatedListAcceleratorTypesSettings() {
      return aggregatedListAcceleratorTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getAcceleratorType. */
    public UnaryCallSettings.Builder<GetAcceleratorTypeHttpRequest, AcceleratorType>
        getAcceleratorTypeSettings() {
      return getAcceleratorTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listAcceleratorTypes. */
    public PagedCallSettings.Builder<
            ListAcceleratorTypesHttpRequest, AcceleratorTypeList, ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings() {
      return listAcceleratorTypesSettings;
    }

    @Override
    public AcceleratorTypeStubSettings build() throws IOException {
      return new AcceleratorTypeStubSettings(this);
    }
  }
}
