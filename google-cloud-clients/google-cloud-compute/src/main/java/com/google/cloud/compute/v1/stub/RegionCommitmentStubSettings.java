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

import static com.google.cloud.compute.v1.RegionCommitmentClient.AggregatedListRegionCommitmentsPagedResponse;
import static com.google.cloud.compute.v1.RegionCommitmentClient.ListRegionCommitmentsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CommitmentAggregatedList;
import com.google.cloud.compute.v1.CommitmentList;
import com.google.cloud.compute.v1.CommitmentsScopedList;
import com.google.cloud.compute.v1.GetRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.InsertRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.ListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Operation;
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
 * Settings class to configure an instance of {@link RegionCommitmentStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRegionCommitment to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionCommitmentStubSettings.Builder regionCommitmentSettingsBuilder =
 *     RegionCommitmentStubSettings.newBuilder();
 * regionCommitmentSettingsBuilder.getRegionCommitmentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionCommitmentStubSettings regionCommitmentSettings = regionCommitmentSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionCommitmentStubSettings extends StubSettings<RegionCommitmentStubSettings> {
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
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsSettings;
  private final UnaryCallSettings<GetRegionCommitmentHttpRequest, Commitment>
      getRegionCommitmentSettings;
  private final UnaryCallSettings<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentSettings;
  private final PagedCallSettings<
          ListRegionCommitmentsHttpRequest, CommitmentList, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsSettings;

  /** Returns the object with the settings used for calls to aggregatedListRegionCommitments. */
  public PagedCallSettings<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsSettings() {
    return aggregatedListRegionCommitmentsSettings;
  }

  /** Returns the object with the settings used for calls to getRegionCommitment. */
  public UnaryCallSettings<GetRegionCommitmentHttpRequest, Commitment>
      getRegionCommitmentSettings() {
    return getRegionCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionCommitment. */
  public UnaryCallSettings<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentSettings() {
    return insertRegionCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to listRegionCommitments. */
  public PagedCallSettings<
          ListRegionCommitmentsHttpRequest, CommitmentList, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsSettings() {
    return listRegionCommitmentsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionCommitmentStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionCommitmentStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RegionCommitmentStubSettings.class))
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

  protected RegionCommitmentStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListRegionCommitmentsSettings =
        settingsBuilder.aggregatedListRegionCommitmentsSettings().build();
    getRegionCommitmentSettings = settingsBuilder.getRegionCommitmentSettings().build();
    insertRegionCommitmentSettings = settingsBuilder.insertRegionCommitmentSettings().build();
    listRegionCommitmentsSettings = settingsBuilder.listRegionCommitmentsSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          CommitmentsScopedList>
      AGGREGATED_LIST_REGION_COMMITMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListRegionCommitmentsHttpRequest,
              CommitmentAggregatedList,
              CommitmentsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListRegionCommitmentsHttpRequest injectToken(
                AggregatedListRegionCommitmentsHttpRequest payload, String token) {
              return AggregatedListRegionCommitmentsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListRegionCommitmentsHttpRequest injectPageSize(
                AggregatedListRegionCommitmentsHttpRequest payload, int pageSize) {
              return AggregatedListRegionCommitmentsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListRegionCommitmentsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(CommitmentAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CommitmentsScopedList> extractResources(
                CommitmentAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<CommitmentsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListRegionCommitmentsHttpRequest, CommitmentList, Commitment>
      LIST_REGION_COMMITMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionCommitmentsHttpRequest injectToken(
                ListRegionCommitmentsHttpRequest payload, String token) {
              return ListRegionCommitmentsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionCommitmentsHttpRequest injectPageSize(
                ListRegionCommitmentsHttpRequest payload, int pageSize) {
              return ListRegionCommitmentsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionCommitmentsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(CommitmentList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Commitment> extractResources(CommitmentList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Commitment>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          AggregatedListRegionCommitmentsPagedResponse>
      AGGREGATED_LIST_REGION_COMMITMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListRegionCommitmentsHttpRequest,
              CommitmentAggregatedList,
              AggregatedListRegionCommitmentsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListRegionCommitmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
                    callable,
                AggregatedListRegionCommitmentsHttpRequest request,
                ApiCallContext context,
                ApiFuture<CommitmentAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListRegionCommitmentsHttpRequest,
                      CommitmentAggregatedList,
                      CommitmentsScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_REGION_COMMITMENTS_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListRegionCommitmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRegionCommitmentsHttpRequest, CommitmentList, ListRegionCommitmentsPagedResponse>
      LIST_REGION_COMMITMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionCommitmentsHttpRequest,
              CommitmentList,
              ListRegionCommitmentsPagedResponse>() {
            @Override
            public ApiFuture<ListRegionCommitmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionCommitmentsHttpRequest, CommitmentList> callable,
                ListRegionCommitmentsHttpRequest request,
                ApiCallContext context,
                ApiFuture<CommitmentList> futureResponse) {
              PageContext<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGION_COMMITMENTS_PAGE_STR_DESC, request, context);
              return ListRegionCommitmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RegionCommitmentStubSettings. */
  public static class Builder extends StubSettings.Builder<RegionCommitmentStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListRegionCommitmentsHttpRequest,
            CommitmentAggregatedList,
            AggregatedListRegionCommitmentsPagedResponse>
        aggregatedListRegionCommitmentsSettings;
    private final UnaryCallSettings.Builder<GetRegionCommitmentHttpRequest, Commitment>
        getRegionCommitmentSettings;
    private final UnaryCallSettings.Builder<InsertRegionCommitmentHttpRequest, Operation>
        insertRegionCommitmentSettings;
    private final PagedCallSettings.Builder<
            ListRegionCommitmentsHttpRequest, CommitmentList, ListRegionCommitmentsPagedResponse>
        listRegionCommitmentsSettings;

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

      aggregatedListRegionCommitmentsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_REGION_COMMITMENTS_PAGE_STR_FACT);

      getRegionCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionCommitmentsSettings =
          PagedCallSettings.newBuilder(LIST_REGION_COMMITMENTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListRegionCommitmentsSettings,
              getRegionCommitmentSettings,
              insertRegionCommitmentSettings,
              listRegionCommitmentsSettings);

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
          .aggregatedListRegionCommitmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionCommitmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionCommitmentStubSettings settings) {
      super(settings);

      aggregatedListRegionCommitmentsSettings =
          settings.aggregatedListRegionCommitmentsSettings.toBuilder();
      getRegionCommitmentSettings = settings.getRegionCommitmentSettings.toBuilder();
      insertRegionCommitmentSettings = settings.insertRegionCommitmentSettings.toBuilder();
      listRegionCommitmentsSettings = settings.listRegionCommitmentsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListRegionCommitmentsSettings,
              getRegionCommitmentSettings,
              insertRegionCommitmentSettings,
              listRegionCommitmentsSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListRegionCommitments. */
    public PagedCallSettings.Builder<
            AggregatedListRegionCommitmentsHttpRequest,
            CommitmentAggregatedList,
            AggregatedListRegionCommitmentsPagedResponse>
        aggregatedListRegionCommitmentsSettings() {
      return aggregatedListRegionCommitmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionCommitment. */
    public UnaryCallSettings.Builder<GetRegionCommitmentHttpRequest, Commitment>
        getRegionCommitmentSettings() {
      return getRegionCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionCommitment. */
    public UnaryCallSettings.Builder<InsertRegionCommitmentHttpRequest, Operation>
        insertRegionCommitmentSettings() {
      return insertRegionCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionCommitments. */
    public PagedCallSettings.Builder<
            ListRegionCommitmentsHttpRequest, CommitmentList, ListRegionCommitmentsPagedResponse>
        listRegionCommitmentsSettings() {
      return listRegionCommitmentsSettings;
    }

    @Override
    public RegionCommitmentStubSettings build() throws IOException {
      return new RegionCommitmentStubSettings(this);
    }
  }
}
