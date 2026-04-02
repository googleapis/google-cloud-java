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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionHealthSourcesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionHealthSourcesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRegionHealthSourcesRequest;
import com.google.cloud.compute.v1.DeleteRegionHealthSourceRequest;
import com.google.cloud.compute.v1.GetRegionHealthSourceRequest;
import com.google.cloud.compute.v1.HealthSource;
import com.google.cloud.compute.v1.HealthSourceAggregatedList;
import com.google.cloud.compute.v1.HealthSourceList;
import com.google.cloud.compute.v1.HealthSourcesScopedList;
import com.google.cloud.compute.v1.InsertRegionHealthSourceRequest;
import com.google.cloud.compute.v1.ListRegionHealthSourcesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthSourceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionHealthSourceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionHealthSourcesStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthSourcesStubSettings.Builder regionHealthSourcesSettingsBuilder =
 *     RegionHealthSourcesStubSettings.newBuilder();
 * regionHealthSourcesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionHealthSourcesSettingsBuilder
 *             .getSettings()
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
 * RegionHealthSourcesStubSettings regionHealthSourcesSettings =
 *     regionHealthSourcesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for delete:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthSourcesStubSettings.Builder regionHealthSourcesSettingsBuilder =
 *     RegionHealthSourcesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * regionHealthSourcesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class RegionHealthSourcesStubSettings extends StubSettings<RegionHealthSourcesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteRegionHealthSourceRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteRegionHealthSourceRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetRegionHealthSourceRequest, HealthSource> getSettings;
  private final UnaryCallSettings<InsertRegionHealthSourceRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertRegionHealthSourceRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchRegionHealthSourceRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchRegionHealthSourceRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<
          TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          Map.Entry<String, HealthSourcesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListRegionHealthSourcesRequest,
              HealthSourceAggregatedList,
              Map.Entry<String, HealthSourcesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListRegionHealthSourcesRequest injectToken(
                AggregatedListRegionHealthSourcesRequest payload, String token) {
              return AggregatedListRegionHealthSourcesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListRegionHealthSourcesRequest injectPageSize(
                AggregatedListRegionHealthSourcesRequest payload, int pageSize) {
              return AggregatedListRegionHealthSourcesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListRegionHealthSourcesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(HealthSourceAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, HealthSourcesScopedList>> extractResources(
                HealthSourceAggregatedList payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListRegionHealthSourcesRequest, HealthSourceList, HealthSource>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionHealthSourcesRequest, HealthSourceList, HealthSource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionHealthSourcesRequest injectToken(
                ListRegionHealthSourcesRequest payload, String token) {
              return ListRegionHealthSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegionHealthSourcesRequest injectPageSize(
                ListRegionHealthSourcesRequest payload, int pageSize) {
              return ListRegionHealthSourcesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionHealthSourcesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(HealthSourceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HealthSource> extractResources(HealthSourceList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListRegionHealthSourcesRequest,
              HealthSourceAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListRegionHealthSourcesRequest, HealthSourceAggregatedList>
                    callable,
                AggregatedListRegionHealthSourcesRequest request,
                ApiCallContext context,
                ApiFuture<HealthSourceAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListRegionHealthSourcesRequest,
                      HealthSourceAggregatedList,
                      Map.Entry<String, HealthSourcesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionHealthSourcesRequest, HealthSourceList> callable,
                ListRegionHealthSourcesRequest request,
                ApiCallContext context,
                ApiFuture<HealthSourceList> futureResponse) {
              PageContext<ListRegionHealthSourcesRequest, HealthSourceList, HealthSource>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListRegionHealthSourcesRequest,
          HealthSourceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionHealthSourceRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionHealthSourceRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionHealthSourceRequest, HealthSource> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionHealthSourceRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionHealthSourceRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionHealthSourceRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionHealthSourceRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public RegionHealthSourcesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionHealthSourcesStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(RegionHealthSourcesStubSettings.class))
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

  protected RegionHealthSourcesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-compute")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for RegionHealthSourcesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionHealthSourcesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListRegionHealthSourcesRequest,
            HealthSourceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteRegionHealthSourceRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteRegionHealthSourceRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetRegionHealthSourceRequest, HealthSource> getSettings;
    private final UnaryCallSettings.Builder<InsertRegionHealthSourceRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertRegionHealthSourceRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchRegionHealthSourceRequest, Operation>
        patchSettings;
    private final OperationCallSettings.Builder<
            PatchRegionHealthSourceRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
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
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(RegionHealthSourcesStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              testIamPermissionsSettings);
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
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRegionHealthSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertRegionHealthSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchRegionHealthSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

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
            AggregatedListRegionHealthSourcesRequest,
            HealthSourceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionHealthSourceRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionHealthSourceRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionHealthSourceRequest, HealthSource> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionHealthSourceRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionHealthSourceRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionHealthSourcesRequest, HealthSourceList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionHealthSourceRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionHealthSourceRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public RegionHealthSourcesStubSettings build() throws IOException {
      return new RegionHealthSourcesStubSettings(this);
    }
  }
}
