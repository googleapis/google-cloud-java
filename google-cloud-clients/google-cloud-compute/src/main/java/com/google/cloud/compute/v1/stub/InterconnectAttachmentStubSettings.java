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

import static com.google.cloud.compute.v1.InterconnectAttachmentClient.AggregatedListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.compute.v1.InterconnectAttachmentClient.ListInterconnectAttachmentsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListInterconnectAttachmentsHttpRequest;
import com.google.cloud.compute.v1.DeleteInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.GetInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.InsertInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.InterconnectAttachment;
import com.google.cloud.compute.v1.InterconnectAttachmentAggregatedList;
import com.google.cloud.compute.v1.InterconnectAttachmentList;
import com.google.cloud.compute.v1.InterconnectAttachmentsScopedList;
import com.google.cloud.compute.v1.ListInterconnectAttachmentsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectAttachmentHttpRequest;
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
 * Settings class to configure an instance of {@link InterconnectAttachmentStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteInterconnectAttachment to 30 seconds:
 *
 * <pre>
 * <code>
 * InterconnectAttachmentStubSettings.Builder interconnectAttachmentSettingsBuilder =
 *     InterconnectAttachmentStubSettings.newBuilder();
 * interconnectAttachmentSettingsBuilder.deleteInterconnectAttachmentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InterconnectAttachmentStubSettings interconnectAttachmentSettings = interconnectAttachmentSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectAttachmentStubSettings
    extends StubSettings<InterconnectAttachmentStubSettings> {
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
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsSettings;
  private final UnaryCallSettings<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentSettings;
  private final UnaryCallSettings<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings;
  private final UnaryCallSettings<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentSettings;
  private final PagedCallSettings<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings;
  private final UnaryCallSettings<PatchInterconnectAttachmentHttpRequest, Operation>
      patchInterconnectAttachmentSettings;

  /**
   * Returns the object with the settings used for calls to aggregatedListInterconnectAttachments.
   */
  public PagedCallSettings<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsSettings() {
    return aggregatedListInterconnectAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public UnaryCallSettings<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentSettings() {
    return deleteInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to getInterconnectAttachment. */
  public UnaryCallSettings<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings() {
    return getInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to insertInterconnectAttachment. */
  public UnaryCallSettings<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentSettings() {
    return insertInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listInterconnectAttachments. */
  public PagedCallSettings<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings() {
    return listInterconnectAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to patchInterconnectAttachment. */
  public UnaryCallSettings<PatchInterconnectAttachmentHttpRequest, Operation>
      patchInterconnectAttachmentSettings() {
    return patchInterconnectAttachmentSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectAttachmentStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInterconnectAttachmentStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(InterconnectAttachmentStubSettings.class))
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

  protected InterconnectAttachmentStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListInterconnectAttachmentsSettings =
        settingsBuilder.aggregatedListInterconnectAttachmentsSettings().build();
    deleteInterconnectAttachmentSettings =
        settingsBuilder.deleteInterconnectAttachmentSettings().build();
    getInterconnectAttachmentSettings = settingsBuilder.getInterconnectAttachmentSettings().build();
    insertInterconnectAttachmentSettings =
        settingsBuilder.insertInterconnectAttachmentSettings().build();
    listInterconnectAttachmentsSettings =
        settingsBuilder.listInterconnectAttachmentsSettings().build();
    patchInterconnectAttachmentSettings =
        settingsBuilder.patchInterconnectAttachmentSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          InterconnectAttachmentsScopedList>
      AGGREGATED_LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListInterconnectAttachmentsHttpRequest,
              InterconnectAttachmentAggregatedList,
              InterconnectAttachmentsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListInterconnectAttachmentsHttpRequest injectToken(
                AggregatedListInterconnectAttachmentsHttpRequest payload, String token) {
              return AggregatedListInterconnectAttachmentsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListInterconnectAttachmentsHttpRequest injectPageSize(
                AggregatedListInterconnectAttachmentsHttpRequest payload, int pageSize) {
              return AggregatedListInterconnectAttachmentsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                AggregatedListInterconnectAttachmentsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InterconnectAttachmentAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterconnectAttachmentsScopedList> extractResources(
                InterconnectAttachmentAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<InterconnectAttachmentsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          InterconnectAttachment>
      LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterconnectAttachmentsHttpRequest,
              InterconnectAttachmentList,
              InterconnectAttachment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterconnectAttachmentsHttpRequest injectToken(
                ListInterconnectAttachmentsHttpRequest payload, String token) {
              return ListInterconnectAttachmentsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterconnectAttachmentsHttpRequest injectPageSize(
                ListInterconnectAttachmentsHttpRequest payload, int pageSize) {
              return ListInterconnectAttachmentsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterconnectAttachmentsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InterconnectAttachmentList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterconnectAttachment> extractResources(
                InterconnectAttachmentList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InterconnectAttachment>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          AggregatedListInterconnectAttachmentsPagedResponse>
      AGGREGATED_LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListInterconnectAttachmentsHttpRequest,
              InterconnectAttachmentAggregatedList,
              AggregatedListInterconnectAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListInterconnectAttachmentsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            AggregatedListInterconnectAttachmentsHttpRequest,
                            InterconnectAttachmentAggregatedList>
                        callable,
                    AggregatedListInterconnectAttachmentsHttpRequest request,
                    ApiCallContext context,
                    ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListInterconnectAttachmentsHttpRequest,
                      InterconnectAttachmentAggregatedList,
                      InterconnectAttachmentsScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListInterconnectAttachmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          ListInterconnectAttachmentsPagedResponse>
      LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterconnectAttachmentsHttpRequest,
              InterconnectAttachmentList,
              ListInterconnectAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<ListInterconnectAttachmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
                    callable,
                ListInterconnectAttachmentsHttpRequest request,
                ApiCallContext context,
                ApiFuture<InterconnectAttachmentList> futureResponse) {
              PageContext<
                      ListInterconnectAttachmentsHttpRequest,
                      InterconnectAttachmentList,
                      InterconnectAttachment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC, request, context);
              return ListInterconnectAttachmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for InterconnectAttachmentStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InterconnectAttachmentStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentAggregatedList,
            AggregatedListInterconnectAttachmentsPagedResponse>
        aggregatedListInterconnectAttachmentsSettings;
    private final UnaryCallSettings.Builder<DeleteInterconnectAttachmentHttpRequest, Operation>
        deleteInterconnectAttachmentSettings;
    private final UnaryCallSettings.Builder<
            GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings;
    private final UnaryCallSettings.Builder<InsertInterconnectAttachmentHttpRequest, Operation>
        insertInterconnectAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentList,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings;
    private final UnaryCallSettings.Builder<PatchInterconnectAttachmentHttpRequest, Operation>
        patchInterconnectAttachmentSettings;

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

      aggregatedListInterconnectAttachmentsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT);

      deleteInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInterconnectAttachmentsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT);

      patchInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListInterconnectAttachmentsSettings,
              deleteInterconnectAttachmentSettings,
              getInterconnectAttachmentSettings,
              insertInterconnectAttachmentSettings,
              listInterconnectAttachmentsSettings,
              patchInterconnectAttachmentSettings);

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
          .aggregatedListInterconnectAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInterconnectAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(InterconnectAttachmentStubSettings settings) {
      super(settings);

      aggregatedListInterconnectAttachmentsSettings =
          settings.aggregatedListInterconnectAttachmentsSettings.toBuilder();
      deleteInterconnectAttachmentSettings =
          settings.deleteInterconnectAttachmentSettings.toBuilder();
      getInterconnectAttachmentSettings = settings.getInterconnectAttachmentSettings.toBuilder();
      insertInterconnectAttachmentSettings =
          settings.insertInterconnectAttachmentSettings.toBuilder();
      listInterconnectAttachmentsSettings =
          settings.listInterconnectAttachmentsSettings.toBuilder();
      patchInterconnectAttachmentSettings =
          settings.patchInterconnectAttachmentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListInterconnectAttachmentsSettings,
              deleteInterconnectAttachmentSettings,
              getInterconnectAttachmentSettings,
              insertInterconnectAttachmentSettings,
              listInterconnectAttachmentsSettings,
              patchInterconnectAttachmentSettings);
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

    /**
     * Returns the builder for the settings used for calls to aggregatedListInterconnectAttachments.
     */
    public PagedCallSettings.Builder<
            AggregatedListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentAggregatedList,
            AggregatedListInterconnectAttachmentsPagedResponse>
        aggregatedListInterconnectAttachmentsSettings() {
      return aggregatedListInterconnectAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public UnaryCallSettings.Builder<DeleteInterconnectAttachmentHttpRequest, Operation>
        deleteInterconnectAttachmentSettings() {
      return deleteInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to getInterconnectAttachment. */
    public UnaryCallSettings.Builder<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings() {
      return getInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to insertInterconnectAttachment. */
    public UnaryCallSettings.Builder<InsertInterconnectAttachmentHttpRequest, Operation>
        insertInterconnectAttachmentSettings() {
      return insertInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listInterconnectAttachments. */
    public PagedCallSettings.Builder<
            ListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentList,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings() {
      return listInterconnectAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to patchInterconnectAttachment. */
    public UnaryCallSettings.Builder<PatchInterconnectAttachmentHttpRequest, Operation>
        patchInterconnectAttachmentSettings() {
      return patchInterconnectAttachmentSettings;
    }

    @Override
    public InterconnectAttachmentStubSettings build() throws IOException {
      return new InterconnectAttachmentStubSettings(this);
    }
  }
}
