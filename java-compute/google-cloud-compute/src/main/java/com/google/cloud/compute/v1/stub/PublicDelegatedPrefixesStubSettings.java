/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.DeletePublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.GetPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.InsertPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.ListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.PublicDelegatedPrefix;
import com.google.cloud.compute.v1.PublicDelegatedPrefixAggregatedList;
import com.google.cloud.compute.v1.PublicDelegatedPrefixList;
import com.google.cloud.compute.v1.PublicDelegatedPrefixesScopedList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link PublicDelegatedPrefixesStub}.
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
 * <p>For example, to set the total timeout of delete to 30 seconds:
 *
 * <pre>
 * <code>
 * PublicDelegatedPrefixesStubSettings.Builder publicDelegatedPrefixesSettingsBuilder =
 *     PublicDelegatedPrefixesStubSettings.newBuilder();
 * publicDelegatedPrefixesSettingsBuilder
 *     .deleteSettings()
 *     .setRetrySettings(
 *         publicDelegatedPrefixesSettingsBuilder.deleteSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PublicDelegatedPrefixesStubSettings publicDelegatedPrefixesSettings = publicDelegatedPrefixesSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PublicDelegatedPrefixesStubSettings
    extends StubSettings<PublicDelegatedPrefixesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .build();

  private final PagedCallSettings<
          AggregatedListPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeletePublicDelegatedPrefixeRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getSettings;
  private final UnaryCallSettings<InsertPublicDelegatedPrefixeRequest, Operation> insertSettings;
  private final PagedCallSettings<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchPublicDelegatedPrefixeRequest, Operation> patchSettings;

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeletePublicDelegatedPrefixeRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertPublicDelegatedPrefixeRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchPublicDelegatedPrefixeRequest, Operation> patchSettings() {
    return patchSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PublicDelegatedPrefixesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPublicDelegatedPrefixesStub.create(this);
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
    return "compute.googleapis.com";
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
            "gapic", GaxProperties.getLibraryVersion(PublicDelegatedPrefixesStubSettings.class))
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

  protected PublicDelegatedPrefixesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixAggregatedList,
          Entry<String, PublicDelegatedPrefixesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListPublicDelegatedPrefixesRequest,
              PublicDelegatedPrefixAggregatedList,
              Entry<String, PublicDelegatedPrefixesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListPublicDelegatedPrefixesRequest injectToken(
                AggregatedListPublicDelegatedPrefixesRequest payload, String token) {
              return AggregatedListPublicDelegatedPrefixesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListPublicDelegatedPrefixesRequest injectPageSize(
                AggregatedListPublicDelegatedPrefixesRequest payload, int pageSize) {
              return AggregatedListPublicDelegatedPrefixesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListPublicDelegatedPrefixesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(PublicDelegatedPrefixAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entry<String, PublicDelegatedPrefixesScopedList>> extractResources(
                PublicDelegatedPrefixAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().entrySet()
                  : ImmutableList.<Entry<String, PublicDelegatedPrefixesScopedList>>of();
            }
          };

  private static final PagedListDescriptor<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, PublicDelegatedPrefix>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPublicDelegatedPrefixesRequest,
              PublicDelegatedPrefixList,
              PublicDelegatedPrefix>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPublicDelegatedPrefixesRequest injectToken(
                ListPublicDelegatedPrefixesRequest payload, String token) {
              return ListPublicDelegatedPrefixesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPublicDelegatedPrefixesRequest injectPageSize(
                ListPublicDelegatedPrefixesRequest payload, int pageSize) {
              return ListPublicDelegatedPrefixesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPublicDelegatedPrefixesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(PublicDelegatedPrefixList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PublicDelegatedPrefix> extractResources(
                PublicDelegatedPrefixList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<PublicDelegatedPrefix>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListPublicDelegatedPrefixesRequest,
              PublicDelegatedPrefixAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListPublicDelegatedPrefixesRequest,
                        PublicDelegatedPrefixAggregatedList>
                    callable,
                AggregatedListPublicDelegatedPrefixesRequest request,
                ApiCallContext context,
                ApiFuture<PublicDelegatedPrefixAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListPublicDelegatedPrefixesRequest,
                      PublicDelegatedPrefixAggregatedList,
                      Entry<String, PublicDelegatedPrefixesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
                    callable,
                ListPublicDelegatedPrefixesRequest request,
                ApiCallContext context,
                ApiFuture<PublicDelegatedPrefixList> futureResponse) {
              PageContext<
                      ListPublicDelegatedPrefixesRequest,
                      PublicDelegatedPrefixList,
                      PublicDelegatedPrefix>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for PublicDelegatedPrefixesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PublicDelegatedPrefixesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListPublicDelegatedPrefixesRequest,
            PublicDelegatedPrefixAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeletePublicDelegatedPrefixeRequest, Operation>
        deleteSettings;
    private final UnaryCallSettings.Builder<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getSettings;
    private final UnaryCallSettings.Builder<InsertPublicDelegatedPrefixeRequest, Operation>
        insertSettings;
    private final PagedCallSettings.Builder<
            ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchPublicDelegatedPrefixeRequest, Operation>
        patchSettings;

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

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);

      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings);

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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(PublicDelegatedPrefixesStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListPublicDelegatedPrefixesRequest,
            PublicDelegatedPrefixAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeletePublicDelegatedPrefixeRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertPublicDelegatedPrefixeRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchPublicDelegatedPrefixeRequest, Operation>
        patchSettings() {
      return patchSettings;
    }

    @Override
    public PublicDelegatedPrefixesStubSettings build() throws IOException {
      return new PublicDelegatedPrefixesStubSettings(this);
    }
  }
}
