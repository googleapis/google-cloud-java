/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.DiskTypeClient.AggregatedListDiskTypesPagedResponse;
import static com.google.cloud.compute.v1.DiskTypeClient.ListDiskTypesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.DiskTypeAggregatedList;
import com.google.cloud.compute.v1.DiskTypeList;
import com.google.cloud.compute.v1.DiskTypesScopedList;
import com.google.cloud.compute.v1.GetDiskTypeHttpRequest;
import com.google.cloud.compute.v1.ListDiskTypesHttpRequest;
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
 * Settings class to configure an instance of {@link DiskTypeStub}.
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
 * example, to set the total timeout of getDiskType to 30 seconds:
 *
 * <pre>
 * <code>
 * DiskTypeStubSettings.Builder diskTypeSettingsBuilder =
 *     DiskTypeStubSettings.newBuilder();
 * diskTypeSettingsBuilder.getDiskTypeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DiskTypeStubSettings diskTypeSettings = diskTypeSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskTypeStubSettings extends StubSettings<DiskTypeStubSettings> {
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
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesSettings;
  private final UnaryCallSettings<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings;
  private final PagedCallSettings<
          ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
      listDiskTypesSettings;

  /** Returns the object with the settings used for calls to aggregatedListDiskTypes. */
  public PagedCallSettings<
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesSettings() {
    return aggregatedListDiskTypesSettings;
  }

  /** Returns the object with the settings used for calls to getDiskType. */
  public UnaryCallSettings<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings() {
    return getDiskTypeSettings;
  }

  /** Returns the object with the settings used for calls to listDiskTypes. */
  public PagedCallSettings<ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
      listDiskTypesSettings() {
    return listDiskTypesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DiskTypeStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDiskTypeStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DiskTypeStubSettings.class))
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

  protected DiskTypeStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListDiskTypesSettings = settingsBuilder.aggregatedListDiskTypesSettings().build();
    getDiskTypeSettings = settingsBuilder.getDiskTypeSettings().build();
    listDiskTypesSettings = settingsBuilder.listDiskTypesSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>
      AGGREGATED_LIST_DISK_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListDiskTypesHttpRequest injectToken(
                AggregatedListDiskTypesHttpRequest payload, String token) {
              return AggregatedListDiskTypesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListDiskTypesHttpRequest injectPageSize(
                AggregatedListDiskTypesHttpRequest payload, int pageSize) {
              return AggregatedListDiskTypesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListDiskTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskTypeAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiskTypesScopedList> extractResources(DiskTypeAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<DiskTypesScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListDiskTypesHttpRequest, DiskTypeList, DiskType>
      LIST_DISK_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDiskTypesHttpRequest, DiskTypeList, DiskType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiskTypesHttpRequest injectToken(
                ListDiskTypesHttpRequest payload, String token) {
              return ListDiskTypesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiskTypesHttpRequest injectPageSize(
                ListDiskTypesHttpRequest payload, int pageSize) {
              return ListDiskTypesHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDiskTypesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskTypeList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiskType> extractResources(DiskTypeList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<DiskType>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          AggregatedListDiskTypesPagedResponse>
      AGGREGATED_LIST_DISK_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListDiskTypesHttpRequest,
              DiskTypeAggregatedList,
              AggregatedListDiskTypesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListDiskTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList> callable,
                AggregatedListDiskTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<DiskTypeAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListDiskTypesHttpRequest,
                      DiskTypeAggregatedList,
                      DiskTypesScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_DISK_TYPES_PAGE_STR_DESC, request, context);
              return AggregatedListDiskTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
      LIST_DISK_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>() {
            @Override
            public ApiFuture<ListDiskTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiskTypesHttpRequest, DiskTypeList> callable,
                ListDiskTypesHttpRequest request,
                ApiCallContext context,
                ApiFuture<DiskTypeList> futureResponse) {
              PageContext<ListDiskTypesHttpRequest, DiskTypeList, DiskType> pageContext =
                  PageContext.create(callable, LIST_DISK_TYPES_PAGE_STR_DESC, request, context);
              return ListDiskTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for DiskTypeStubSettings. */
  public static class Builder extends StubSettings.Builder<DiskTypeStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListDiskTypesHttpRequest,
            DiskTypeAggregatedList,
            AggregatedListDiskTypesPagedResponse>
        aggregatedListDiskTypesSettings;
    private final UnaryCallSettings.Builder<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings;
    private final PagedCallSettings.Builder<
            ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
        listDiskTypesSettings;

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

      aggregatedListDiskTypesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_DISK_TYPES_PAGE_STR_FACT);

      getDiskTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDiskTypesSettings = PagedCallSettings.newBuilder(LIST_DISK_TYPES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListDiskTypesSettings, getDiskTypeSettings, listDiskTypesSettings);

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
          .aggregatedListDiskTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getDiskTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDiskTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(DiskTypeStubSettings settings) {
      super(settings);

      aggregatedListDiskTypesSettings = settings.aggregatedListDiskTypesSettings.toBuilder();
      getDiskTypeSettings = settings.getDiskTypeSettings.toBuilder();
      listDiskTypesSettings = settings.listDiskTypesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListDiskTypesSettings, getDiskTypeSettings, listDiskTypesSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListDiskTypes. */
    public PagedCallSettings.Builder<
            AggregatedListDiskTypesHttpRequest,
            DiskTypeAggregatedList,
            AggregatedListDiskTypesPagedResponse>
        aggregatedListDiskTypesSettings() {
      return aggregatedListDiskTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getDiskType. */
    public UnaryCallSettings.Builder<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings() {
      return getDiskTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listDiskTypes. */
    public PagedCallSettings.Builder<
            ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
        listDiskTypesSettings() {
      return listDiskTypesSettings;
    }

    @Override
    public DiskTypeStubSettings build() throws IOException {
      return new DiskTypeStubSettings(this);
    }
  }
}
