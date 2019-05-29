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

import static com.google.cloud.compute.v1.TargetInstanceClient.AggregatedListTargetInstancesPagedResponse;
import static com.google.cloud.compute.v1.TargetInstanceClient.ListTargetInstancesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.GetTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.InsertTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.ListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceAggregatedList;
import com.google.cloud.compute.v1.TargetInstanceList;
import com.google.cloud.compute.v1.TargetInstancesScopedList;
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
 * Settings class to configure an instance of {@link TargetInstanceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteTargetInstance to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetInstanceStubSettings.Builder targetInstanceSettingsBuilder =
 *     TargetInstanceStubSettings.newBuilder();
 * targetInstanceSettingsBuilder.deleteTargetInstanceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetInstanceStubSettings targetInstanceSettings = targetInstanceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetInstanceStubSettings extends StubSettings<TargetInstanceStubSettings> {
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
          AggregatedListTargetInstancesHttpRequest,
          TargetInstanceAggregatedList,
          AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesSettings;
  private final UnaryCallSettings<DeleteTargetInstanceHttpRequest, Operation>
      deleteTargetInstanceSettings;
  private final UnaryCallSettings<GetTargetInstanceHttpRequest, TargetInstance>
      getTargetInstanceSettings;
  private final UnaryCallSettings<InsertTargetInstanceHttpRequest, Operation>
      insertTargetInstanceSettings;
  private final PagedCallSettings<
          ListTargetInstancesHttpRequest, TargetInstanceList, ListTargetInstancesPagedResponse>
      listTargetInstancesSettings;

  /** Returns the object with the settings used for calls to aggregatedListTargetInstances. */
  public PagedCallSettings<
          AggregatedListTargetInstancesHttpRequest,
          TargetInstanceAggregatedList,
          AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesSettings() {
    return aggregatedListTargetInstancesSettings;
  }

  /** Returns the object with the settings used for calls to deleteTargetInstance. */
  public UnaryCallSettings<DeleteTargetInstanceHttpRequest, Operation>
      deleteTargetInstanceSettings() {
    return deleteTargetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to getTargetInstance. */
  public UnaryCallSettings<GetTargetInstanceHttpRequest, TargetInstance>
      getTargetInstanceSettings() {
    return getTargetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to insertTargetInstance. */
  public UnaryCallSettings<InsertTargetInstanceHttpRequest, Operation>
      insertTargetInstanceSettings() {
    return insertTargetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to listTargetInstances. */
  public PagedCallSettings<
          ListTargetInstancesHttpRequest, TargetInstanceList, ListTargetInstancesPagedResponse>
      listTargetInstancesSettings() {
    return listTargetInstancesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetInstanceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetInstanceStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(TargetInstanceStubSettings.class))
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

  protected TargetInstanceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListTargetInstancesSettings =
        settingsBuilder.aggregatedListTargetInstancesSettings().build();
    deleteTargetInstanceSettings = settingsBuilder.deleteTargetInstanceSettings().build();
    getTargetInstanceSettings = settingsBuilder.getTargetInstanceSettings().build();
    insertTargetInstanceSettings = settingsBuilder.insertTargetInstanceSettings().build();
    listTargetInstancesSettings = settingsBuilder.listTargetInstancesSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListTargetInstancesHttpRequest,
          TargetInstanceAggregatedList,
          TargetInstancesScopedList>
      AGGREGATED_LIST_TARGET_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListTargetInstancesHttpRequest,
              TargetInstanceAggregatedList,
              TargetInstancesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListTargetInstancesHttpRequest injectToken(
                AggregatedListTargetInstancesHttpRequest payload, String token) {
              return AggregatedListTargetInstancesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListTargetInstancesHttpRequest injectPageSize(
                AggregatedListTargetInstancesHttpRequest payload, int pageSize) {
              return AggregatedListTargetInstancesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListTargetInstancesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetInstanceAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetInstancesScopedList> extractResources(
                TargetInstanceAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<TargetInstancesScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance>
      LIST_TARGET_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetInstancesHttpRequest injectToken(
                ListTargetInstancesHttpRequest payload, String token) {
              return ListTargetInstancesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetInstancesHttpRequest injectPageSize(
                ListTargetInstancesHttpRequest payload, int pageSize) {
              return ListTargetInstancesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTargetInstancesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetInstanceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetInstance> extractResources(TargetInstanceList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<TargetInstance>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListTargetInstancesHttpRequest,
          TargetInstanceAggregatedList,
          AggregatedListTargetInstancesPagedResponse>
      AGGREGATED_LIST_TARGET_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListTargetInstancesHttpRequest,
              TargetInstanceAggregatedList,
              AggregatedListTargetInstancesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListTargetInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
                    callable,
                AggregatedListTargetInstancesHttpRequest request,
                ApiCallContext context,
                ApiFuture<TargetInstanceAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListTargetInstancesHttpRequest,
                      TargetInstanceAggregatedList,
                      TargetInstancesScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_TARGET_INSTANCES_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListTargetInstancesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTargetInstancesHttpRequest, TargetInstanceList, ListTargetInstancesPagedResponse>
      LIST_TARGET_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetInstancesHttpRequest,
              TargetInstanceList,
              ListTargetInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListTargetInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetInstancesHttpRequest, TargetInstanceList> callable,
                ListTargetInstancesHttpRequest request,
                ApiCallContext context,
                ApiFuture<TargetInstanceList> futureResponse) {
              PageContext<ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TARGET_INSTANCES_PAGE_STR_DESC, request, context);
              return ListTargetInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for TargetInstanceStubSettings. */
  public static class Builder extends StubSettings.Builder<TargetInstanceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListTargetInstancesHttpRequest,
            TargetInstanceAggregatedList,
            AggregatedListTargetInstancesPagedResponse>
        aggregatedListTargetInstancesSettings;
    private final UnaryCallSettings.Builder<DeleteTargetInstanceHttpRequest, Operation>
        deleteTargetInstanceSettings;
    private final UnaryCallSettings.Builder<GetTargetInstanceHttpRequest, TargetInstance>
        getTargetInstanceSettings;
    private final UnaryCallSettings.Builder<InsertTargetInstanceHttpRequest, Operation>
        insertTargetInstanceSettings;
    private final PagedCallSettings.Builder<
            ListTargetInstancesHttpRequest, TargetInstanceList, ListTargetInstancesPagedResponse>
        listTargetInstancesSettings;

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

      aggregatedListTargetInstancesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_TARGET_INSTANCES_PAGE_STR_FACT);

      deleteTargetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTargetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertTargetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTargetInstancesSettings =
          PagedCallSettings.newBuilder(LIST_TARGET_INSTANCES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListTargetInstancesSettings,
              deleteTargetInstanceSettings,
              getTargetInstanceSettings,
              insertTargetInstanceSettings,
              listTargetInstancesSettings);

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
          .aggregatedListTargetInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTargetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTargetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertTargetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTargetInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(TargetInstanceStubSettings settings) {
      super(settings);

      aggregatedListTargetInstancesSettings =
          settings.aggregatedListTargetInstancesSettings.toBuilder();
      deleteTargetInstanceSettings = settings.deleteTargetInstanceSettings.toBuilder();
      getTargetInstanceSettings = settings.getTargetInstanceSettings.toBuilder();
      insertTargetInstanceSettings = settings.insertTargetInstanceSettings.toBuilder();
      listTargetInstancesSettings = settings.listTargetInstancesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListTargetInstancesSettings,
              deleteTargetInstanceSettings,
              getTargetInstanceSettings,
              insertTargetInstanceSettings,
              listTargetInstancesSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListTargetInstances. */
    public PagedCallSettings.Builder<
            AggregatedListTargetInstancesHttpRequest,
            TargetInstanceAggregatedList,
            AggregatedListTargetInstancesPagedResponse>
        aggregatedListTargetInstancesSettings() {
      return aggregatedListTargetInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTargetInstance. */
    public UnaryCallSettings.Builder<DeleteTargetInstanceHttpRequest, Operation>
        deleteTargetInstanceSettings() {
      return deleteTargetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to getTargetInstance. */
    public UnaryCallSettings.Builder<GetTargetInstanceHttpRequest, TargetInstance>
        getTargetInstanceSettings() {
      return getTargetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to insertTargetInstance. */
    public UnaryCallSettings.Builder<InsertTargetInstanceHttpRequest, Operation>
        insertTargetInstanceSettings() {
      return insertTargetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to listTargetInstances. */
    public PagedCallSettings.Builder<
            ListTargetInstancesHttpRequest, TargetInstanceList, ListTargetInstancesPagedResponse>
        listTargetInstancesSettings() {
      return listTargetInstancesSettings;
    }

    @Override
    public TargetInstanceStubSettings build() throws IOException {
      return new TargetInstanceStubSettings(this);
    }
  }
}
