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

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemsResponse;
import com.google.ads.admanager.v1.BatchArchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchArchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReleaseLineItemsRequest;
import com.google.ads.admanager.v1.BatchReleaseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeLineItemsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchUpdateLineItemsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemsResponse;
import com.google.ads.admanager.v1.CreateLineItemRequest;
import com.google.ads.admanager.v1.GetLineItemRequest;
import com.google.ads.admanager.v1.LineItem;
import com.google.ads.admanager.v1.ListLineItemsRequest;
import com.google.ads.admanager.v1.ListLineItemsResponse;
import com.google.ads.admanager.v1.UpdateLineItemRequest;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LineItemServiceStub}.
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
 * of getLineItem:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemServiceStubSettings.Builder lineItemServiceSettingsBuilder =
 *     LineItemServiceStubSettings.newBuilder();
 * lineItemServiceSettingsBuilder
 *     .getLineItemSettings()
 *     .setRetrySettings(
 *         lineItemServiceSettingsBuilder
 *             .getLineItemSettings()
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
 * LineItemServiceStubSettings lineItemServiceSettings = lineItemServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LineItemServiceStubSettings extends StubSettings<LineItemServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetLineItemRequest, LineItem> getLineItemSettings;
  private final PagedCallSettings<
          ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
      listLineItemsSettings;
  private final UnaryCallSettings<CreateLineItemRequest, LineItem> createLineItemSettings;
  private final UnaryCallSettings<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsSettings;
  private final UnaryCallSettings<UpdateLineItemRequest, LineItem> updateLineItemSettings;
  private final UnaryCallSettings<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsSettings;
  private final UnaryCallSettings<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsSettings;
  private final UnaryCallSettings<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsSettings;
  private final UnaryCallSettings<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsSettings;
  private final UnaryCallSettings<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsSettings;
  private final UnaryCallSettings<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsSettings;
  private final UnaryCallSettings<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsSettings;
  private final UnaryCallSettings<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsSettings;
  private final UnaryCallSettings<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsSettings;
  private final UnaryCallSettings<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsSettings;
  private final UnaryCallSettings<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsSettings;

  private static final PagedListDescriptor<ListLineItemsRequest, ListLineItemsResponse, LineItem>
      LIST_LINE_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLineItemsRequest, ListLineItemsResponse, LineItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLineItemsRequest injectToken(ListLineItemsRequest payload, String token) {
              return ListLineItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLineItemsRequest injectPageSize(ListLineItemsRequest payload, int pageSize) {
              return ListLineItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLineItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLineItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LineItem> extractResources(ListLineItemsResponse payload) {
              return payload.getLineItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
      LIST_LINE_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>() {
            @Override
            public ApiFuture<ListLineItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> callable,
                ListLineItemsRequest request,
                ApiCallContext context,
                ApiFuture<ListLineItemsResponse> futureResponse) {
              PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> pageContext =
                  PageContext.create(callable, LIST_LINE_ITEMS_PAGE_STR_DESC, request, context);
              return ListLineItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLineItem. */
  public UnaryCallSettings<GetLineItemRequest, LineItem> getLineItemSettings() {
    return getLineItemSettings;
  }

  /** Returns the object with the settings used for calls to listLineItems. */
  public PagedCallSettings<ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
      listLineItemsSettings() {
    return listLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to createLineItem. */
  public UnaryCallSettings<CreateLineItemRequest, LineItem> createLineItemSettings() {
    return createLineItemSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateLineItems. */
  public UnaryCallSettings<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsSettings() {
    return batchCreateLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to updateLineItem. */
  public UnaryCallSettings<UpdateLineItemRequest, LineItem> updateLineItemSettings() {
    return updateLineItemSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateLineItems. */
  public UnaryCallSettings<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsSettings() {
    return batchUpdateLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateLineItems. */
  public UnaryCallSettings<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsSettings() {
    return batchActivateLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchPauseLineItems. */
  public UnaryCallSettings<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsSettings() {
    return batchPauseLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchResumeLineItems. */
  public UnaryCallSettings<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsSettings() {
    return batchResumeLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchResumeAndOverbookLineItems. */
  public UnaryCallSettings<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsSettings() {
    return batchResumeAndOverbookLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteLineItems. */
  public UnaryCallSettings<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsSettings() {
    return batchDeleteLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchReserveLineItems. */
  public UnaryCallSettings<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsSettings() {
    return batchReserveLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchReserveAndOverbookLineItems. */
  public UnaryCallSettings<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsSettings() {
    return batchReserveAndOverbookLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchReleaseLineItems. */
  public UnaryCallSettings<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsSettings() {
    return batchReleaseLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveLineItems. */
  public UnaryCallSettings<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsSettings() {
    return batchArchiveLineItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchUnarchiveLineItems. */
  public UnaryCallSettings<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsSettings() {
    return batchUnarchiveLineItemsSettings;
  }

  public LineItemServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLineItemServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(LineItemServiceStubSettings.class))
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

  protected LineItemServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLineItemSettings = settingsBuilder.getLineItemSettings().build();
    listLineItemsSettings = settingsBuilder.listLineItemsSettings().build();
    createLineItemSettings = settingsBuilder.createLineItemSettings().build();
    batchCreateLineItemsSettings = settingsBuilder.batchCreateLineItemsSettings().build();
    updateLineItemSettings = settingsBuilder.updateLineItemSettings().build();
    batchUpdateLineItemsSettings = settingsBuilder.batchUpdateLineItemsSettings().build();
    batchActivateLineItemsSettings = settingsBuilder.batchActivateLineItemsSettings().build();
    batchPauseLineItemsSettings = settingsBuilder.batchPauseLineItemsSettings().build();
    batchResumeLineItemsSettings = settingsBuilder.batchResumeLineItemsSettings().build();
    batchResumeAndOverbookLineItemsSettings =
        settingsBuilder.batchResumeAndOverbookLineItemsSettings().build();
    batchDeleteLineItemsSettings = settingsBuilder.batchDeleteLineItemsSettings().build();
    batchReserveLineItemsSettings = settingsBuilder.batchReserveLineItemsSettings().build();
    batchReserveAndOverbookLineItemsSettings =
        settingsBuilder.batchReserveAndOverbookLineItemsSettings().build();
    batchReleaseLineItemsSettings = settingsBuilder.batchReleaseLineItemsSettings().build();
    batchArchiveLineItemsSettings = settingsBuilder.batchArchiveLineItemsSettings().build();
    batchUnarchiveLineItemsSettings = settingsBuilder.batchUnarchiveLineItemsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for LineItemServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LineItemServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLineItemRequest, LineItem> getLineItemSettings;
    private final PagedCallSettings.Builder<
            ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
        listLineItemsSettings;
    private final UnaryCallSettings.Builder<CreateLineItemRequest, LineItem> createLineItemSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
        batchCreateLineItemsSettings;
    private final UnaryCallSettings.Builder<UpdateLineItemRequest, LineItem> updateLineItemSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
        batchUpdateLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
        batchActivateLineItemsSettings;
    private final UnaryCallSettings.Builder<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
        batchPauseLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
        batchResumeLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
        batchResumeAndOverbookLineItemsSettings;
    private final UnaryCallSettings.Builder<BatchDeleteLineItemsRequest, Empty>
        batchDeleteLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
        batchReserveLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
        batchReserveAndOverbookLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
        batchReleaseLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
        batchArchiveLineItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
        batchUnarchiveLineItemsSettings;
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

      getLineItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLineItemsSettings = PagedCallSettings.newBuilder(LIST_LINE_ITEMS_PAGE_STR_FACT);
      createLineItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLineItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchPauseLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchResumeLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchResumeAndOverbookLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchReserveLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchReserveAndOverbookLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchReleaseLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUnarchiveLineItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemSettings,
              listLineItemsSettings,
              createLineItemSettings,
              batchCreateLineItemsSettings,
              updateLineItemSettings,
              batchUpdateLineItemsSettings,
              batchActivateLineItemsSettings,
              batchPauseLineItemsSettings,
              batchResumeLineItemsSettings,
              batchResumeAndOverbookLineItemsSettings,
              batchDeleteLineItemsSettings,
              batchReserveLineItemsSettings,
              batchReserveAndOverbookLineItemsSettings,
              batchReleaseLineItemsSettings,
              batchArchiveLineItemsSettings,
              batchUnarchiveLineItemsSettings);
      initDefaults(this);
    }

    protected Builder(LineItemServiceStubSettings settings) {
      super(settings);

      getLineItemSettings = settings.getLineItemSettings.toBuilder();
      listLineItemsSettings = settings.listLineItemsSettings.toBuilder();
      createLineItemSettings = settings.createLineItemSettings.toBuilder();
      batchCreateLineItemsSettings = settings.batchCreateLineItemsSettings.toBuilder();
      updateLineItemSettings = settings.updateLineItemSettings.toBuilder();
      batchUpdateLineItemsSettings = settings.batchUpdateLineItemsSettings.toBuilder();
      batchActivateLineItemsSettings = settings.batchActivateLineItemsSettings.toBuilder();
      batchPauseLineItemsSettings = settings.batchPauseLineItemsSettings.toBuilder();
      batchResumeLineItemsSettings = settings.batchResumeLineItemsSettings.toBuilder();
      batchResumeAndOverbookLineItemsSettings =
          settings.batchResumeAndOverbookLineItemsSettings.toBuilder();
      batchDeleteLineItemsSettings = settings.batchDeleteLineItemsSettings.toBuilder();
      batchReserveLineItemsSettings = settings.batchReserveLineItemsSettings.toBuilder();
      batchReserveAndOverbookLineItemsSettings =
          settings.batchReserveAndOverbookLineItemsSettings.toBuilder();
      batchReleaseLineItemsSettings = settings.batchReleaseLineItemsSettings.toBuilder();
      batchArchiveLineItemsSettings = settings.batchArchiveLineItemsSettings.toBuilder();
      batchUnarchiveLineItemsSettings = settings.batchUnarchiveLineItemsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemSettings,
              listLineItemsSettings,
              createLineItemSettings,
              batchCreateLineItemsSettings,
              updateLineItemSettings,
              batchUpdateLineItemsSettings,
              batchActivateLineItemsSettings,
              batchPauseLineItemsSettings,
              batchResumeLineItemsSettings,
              batchResumeAndOverbookLineItemsSettings,
              batchDeleteLineItemsSettings,
              batchReserveLineItemsSettings,
              batchReserveAndOverbookLineItemsSettings,
              batchReleaseLineItemsSettings,
              batchArchiveLineItemsSettings,
              batchUnarchiveLineItemsSettings);
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
          .getLineItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createLineItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateLineItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchPauseLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchResumeLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchResumeAndOverbookLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeleteLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchReserveLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchReserveAndOverbookLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchReleaseLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveLineItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUnarchiveLineItemsSettings()
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

    /** Returns the builder for the settings used for calls to getLineItem. */
    public UnaryCallSettings.Builder<GetLineItemRequest, LineItem> getLineItemSettings() {
      return getLineItemSettings;
    }

    /** Returns the builder for the settings used for calls to listLineItems. */
    public PagedCallSettings.Builder<
            ListLineItemsRequest, ListLineItemsResponse, ListLineItemsPagedResponse>
        listLineItemsSettings() {
      return listLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to createLineItem. */
    public UnaryCallSettings.Builder<CreateLineItemRequest, LineItem> createLineItemSettings() {
      return createLineItemSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateLineItems. */
    public UnaryCallSettings.Builder<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
        batchCreateLineItemsSettings() {
      return batchCreateLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to updateLineItem. */
    public UnaryCallSettings.Builder<UpdateLineItemRequest, LineItem> updateLineItemSettings() {
      return updateLineItemSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateLineItems. */
    public UnaryCallSettings.Builder<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
        batchUpdateLineItemsSettings() {
      return batchUpdateLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateLineItems. */
    public UnaryCallSettings.Builder<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
        batchActivateLineItemsSettings() {
      return batchActivateLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchPauseLineItems. */
    public UnaryCallSettings.Builder<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
        batchPauseLineItemsSettings() {
      return batchPauseLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchResumeLineItems. */
    public UnaryCallSettings.Builder<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
        batchResumeLineItemsSettings() {
      return batchResumeLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchResumeAndOverbookLineItems. */
    public UnaryCallSettings.Builder<
            BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
        batchResumeAndOverbookLineItemsSettings() {
      return batchResumeAndOverbookLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteLineItems. */
    public UnaryCallSettings.Builder<BatchDeleteLineItemsRequest, Empty>
        batchDeleteLineItemsSettings() {
      return batchDeleteLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchReserveLineItems. */
    public UnaryCallSettings.Builder<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
        batchReserveLineItemsSettings() {
      return batchReserveLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchReserveAndOverbookLineItems. */
    public UnaryCallSettings.Builder<
            BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
        batchReserveAndOverbookLineItemsSettings() {
      return batchReserveAndOverbookLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchReleaseLineItems. */
    public UnaryCallSettings.Builder<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
        batchReleaseLineItemsSettings() {
      return batchReleaseLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveLineItems. */
    public UnaryCallSettings.Builder<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
        batchArchiveLineItemsSettings() {
      return batchArchiveLineItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveLineItems. */
    public UnaryCallSettings.Builder<
            BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
        batchUnarchiveLineItemsSettings() {
      return batchUnarchiveLineItemsSettings;
    }

    @Override
    public LineItemServiceStubSettings build() throws IOException {
      return new LineItemServiceStubSettings(this);
    }
  }
}
