/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolRequest;
import com.google.cloud.compute.v1.GetTargetPoolRequest;
import com.google.cloud.compute.v1.InsertTargetPoolRequest;
import com.google.cloud.compute.v1.ListTargetPoolsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
import com.google.cloud.compute.v1.TargetPoolsScopedList;
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
 * Settings class to configure an instance of {@link TargetPoolsStub}.
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
 * TargetPoolsStubSettings.Builder targetPoolsSettingsBuilder =
 *     TargetPoolsStubSettings.newBuilder();
 * targetPoolsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetPoolsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetPoolsStubSettings targetPoolsSettings = targetPoolsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetPoolsStubSettings extends StubSettings<TargetPoolsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddHealthCheckTargetPoolRequest, Operation>
      addHealthCheckSettings;
  private final OperationCallSettings<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationSettings;
  private final UnaryCallSettings<AddInstanceTargetPoolRequest, Operation> addInstanceSettings;
  private final OperationCallSettings<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationSettings;
  private final PagedCallSettings<
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteTargetPoolRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetTargetPoolRequest, TargetPool> getSettings;
  private final UnaryCallSettings<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthSettings;
  private final UnaryCallSettings<InsertTargetPoolRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertTargetPoolRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckSettings;
  private final OperationCallSettings<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationSettings;
  private final UnaryCallSettings<RemoveInstanceTargetPoolRequest, Operation>
      removeInstanceSettings;
  private final OperationCallSettings<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationSettings;
  private final UnaryCallSettings<SetBackupTargetPoolRequest, Operation> setBackupSettings;
  private final OperationCallSettings<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Map.Entry<String, TargetPoolsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListTargetPoolsRequest,
              TargetPoolAggregatedList,
              Map.Entry<String, TargetPoolsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListTargetPoolsRequest injectToken(
                AggregatedListTargetPoolsRequest payload, String token) {
              return AggregatedListTargetPoolsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListTargetPoolsRequest injectPageSize(
                AggregatedListTargetPoolsRequest payload, int pageSize) {
              return AggregatedListTargetPoolsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListTargetPoolsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetPoolAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, TargetPoolsScopedList>> extractResources(
                TargetPoolAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, TargetPoolsScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListTargetPoolsRequest, TargetPoolList, TargetPool>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListTargetPoolsRequest, TargetPoolList, TargetPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetPoolsRequest injectToken(
                ListTargetPoolsRequest payload, String token) {
              return ListTargetPoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetPoolsRequest injectPageSize(
                ListTargetPoolsRequest payload, int pageSize) {
              return ListTargetPoolsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTargetPoolsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetPoolList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetPool> extractResources(TargetPoolList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<TargetPool>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListTargetPoolsRequest,
              TargetPoolAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList> callable,
                AggregatedListTargetPoolsRequest request,
                ApiCallContext context,
                ApiFuture<TargetPoolAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListTargetPoolsRequest,
                      TargetPoolAggregatedList,
                      Map.Entry<String, TargetPoolsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetPoolsRequest, TargetPoolList> callable,
                ListTargetPoolsRequest request,
                ApiCallContext context,
                ApiFuture<TargetPoolList> futureResponse) {
              PageContext<ListTargetPoolsRequest, TargetPoolList, TargetPool> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addHealthCheck. */
  public UnaryCallSettings<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckSettings() {
    return addHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to addHealthCheck. */
  public OperationCallSettings<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationSettings() {
    return addHealthCheckOperationSettings;
  }

  /** Returns the object with the settings used for calls to addInstance. */
  public UnaryCallSettings<AddInstanceTargetPoolRequest, Operation> addInstanceSettings() {
    return addInstanceSettings;
  }

  /** Returns the object with the settings used for calls to addInstance. */
  public OperationCallSettings<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationSettings() {
    return addInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetPoolRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetPoolRequest, TargetPool> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getHealth. */
  public UnaryCallSettings<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthSettings() {
    return getHealthSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetPoolRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetPoolRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to removeHealthCheck. */
  public UnaryCallSettings<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckSettings() {
    return removeHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to removeHealthCheck. */
  public OperationCallSettings<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationSettings() {
    return removeHealthCheckOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeInstance. */
  public UnaryCallSettings<RemoveInstanceTargetPoolRequest, Operation> removeInstanceSettings() {
    return removeInstanceSettings;
  }

  /** Returns the object with the settings used for calls to removeInstance. */
  public OperationCallSettings<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationSettings() {
    return removeInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to setBackup. */
  public UnaryCallSettings<SetBackupTargetPoolRequest, Operation> setBackupSettings() {
    return setBackupSettings;
  }

  /** Returns the object with the settings used for calls to setBackup. */
  public OperationCallSettings<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationSettings() {
    return setBackupOperationSettings;
  }

  public TargetPoolsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetPoolsStub.create(this);
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TargetPoolsStubSettings.class))
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

  protected TargetPoolsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addHealthCheckSettings = settingsBuilder.addHealthCheckSettings().build();
    addHealthCheckOperationSettings = settingsBuilder.addHealthCheckOperationSettings().build();
    addInstanceSettings = settingsBuilder.addInstanceSettings().build();
    addInstanceOperationSettings = settingsBuilder.addInstanceOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getHealthSettings = settingsBuilder.getHealthSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    removeHealthCheckSettings = settingsBuilder.removeHealthCheckSettings().build();
    removeHealthCheckOperationSettings =
        settingsBuilder.removeHealthCheckOperationSettings().build();
    removeInstanceSettings = settingsBuilder.removeInstanceSettings().build();
    removeInstanceOperationSettings = settingsBuilder.removeInstanceOperationSettings().build();
    setBackupSettings = settingsBuilder.setBackupSettings().build();
    setBackupOperationSettings = settingsBuilder.setBackupOperationSettings().build();
  }

  /** Builder for TargetPoolsStubSettings. */
  public static class Builder extends StubSettings.Builder<TargetPoolsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddHealthCheckTargetPoolRequest, Operation>
        addHealthCheckSettings;
    private final OperationCallSettings.Builder<
            AddHealthCheckTargetPoolRequest, Operation, Operation>
        addHealthCheckOperationSettings;
    private final UnaryCallSettings.Builder<AddInstanceTargetPoolRequest, Operation>
        addInstanceSettings;
    private final OperationCallSettings.Builder<AddInstanceTargetPoolRequest, Operation, Operation>
        addInstanceOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteTargetPoolRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteTargetPoolRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetTargetPoolRequest, TargetPool> getSettings;
    private final UnaryCallSettings.Builder<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
        getHealthSettings;
    private final UnaryCallSettings.Builder<InsertTargetPoolRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertTargetPoolRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<RemoveHealthCheckTargetPoolRequest, Operation>
        removeHealthCheckSettings;
    private final OperationCallSettings.Builder<
            RemoveHealthCheckTargetPoolRequest, Operation, Operation>
        removeHealthCheckOperationSettings;
    private final UnaryCallSettings.Builder<RemoveInstanceTargetPoolRequest, Operation>
        removeInstanceSettings;
    private final OperationCallSettings.Builder<
            RemoveInstanceTargetPoolRequest, Operation, Operation>
        removeInstanceOperationSettings;
    private final UnaryCallSettings.Builder<SetBackupTargetPoolRequest, Operation>
        setBackupSettings;
    private final OperationCallSettings.Builder<SetBackupTargetPoolRequest, Operation, Operation>
        setBackupOperationSettings;
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

      addHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addHealthCheckOperationSettings = OperationCallSettings.newBuilder();
      addInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addInstanceOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHealthSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      removeHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeHealthCheckOperationSettings = OperationCallSettings.newBuilder();
      removeInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeInstanceOperationSettings = OperationCallSettings.newBuilder();
      setBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setBackupOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addHealthCheckSettings,
              addInstanceSettings,
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getHealthSettings,
              insertSettings,
              listSettings,
              removeHealthCheckSettings,
              removeInstanceSettings,
              setBackupSettings);
      initDefaults(this);
    }

    protected Builder(TargetPoolsStubSettings settings) {
      super(settings);

      addHealthCheckSettings = settings.addHealthCheckSettings.toBuilder();
      addHealthCheckOperationSettings = settings.addHealthCheckOperationSettings.toBuilder();
      addInstanceSettings = settings.addInstanceSettings.toBuilder();
      addInstanceOperationSettings = settings.addInstanceOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getHealthSettings = settings.getHealthSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      removeHealthCheckSettings = settings.removeHealthCheckSettings.toBuilder();
      removeHealthCheckOperationSettings = settings.removeHealthCheckOperationSettings.toBuilder();
      removeInstanceSettings = settings.removeInstanceSettings.toBuilder();
      removeInstanceOperationSettings = settings.removeInstanceOperationSettings.toBuilder();
      setBackupSettings = settings.setBackupSettings.toBuilder();
      setBackupOperationSettings = settings.setBackupOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addHealthCheckSettings,
              addInstanceSettings,
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getHealthSettings,
              insertSettings,
              listSettings,
              removeHealthCheckSettings,
              removeInstanceSettings,
              setBackupSettings);
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
          .addHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addInstanceSettings()
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
          .removeHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addHealthCheckOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddHealthCheckTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .addInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddInstanceTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removeHealthCheckOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveHealthCheckTargetPoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removeInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveInstanceTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetBackupTargetPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to addHealthCheck. */
    public UnaryCallSettings.Builder<AddHealthCheckTargetPoolRequest, Operation>
        addHealthCheckSettings() {
      return addHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to addHealthCheck. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddHealthCheckTargetPoolRequest, Operation, Operation>
        addHealthCheckOperationSettings() {
      return addHealthCheckOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addInstance. */
    public UnaryCallSettings.Builder<AddInstanceTargetPoolRequest, Operation>
        addInstanceSettings() {
      return addInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to addInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddInstanceTargetPoolRequest, Operation, Operation>
        addInstanceOperationSettings() {
      return addInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetPoolRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTargetPoolRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetPoolRequest, TargetPool> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getHealth. */
    public UnaryCallSettings.Builder<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
        getHealthSettings() {
      return getHealthSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetPoolRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertTargetPoolRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to removeHealthCheck. */
    public UnaryCallSettings.Builder<RemoveHealthCheckTargetPoolRequest, Operation>
        removeHealthCheckSettings() {
      return removeHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to removeHealthCheck. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
        removeHealthCheckOperationSettings() {
      return removeHealthCheckOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeInstance. */
    public UnaryCallSettings.Builder<RemoveInstanceTargetPoolRequest, Operation>
        removeInstanceSettings() {
      return removeInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to removeInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RemoveInstanceTargetPoolRequest, Operation, Operation>
        removeInstanceOperationSettings() {
      return removeInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setBackup. */
    public UnaryCallSettings.Builder<SetBackupTargetPoolRequest, Operation> setBackupSettings() {
      return setBackupSettings;
    }

    /** Returns the builder for the settings used for calls to setBackup. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetBackupTargetPoolRequest, Operation, Operation>
        setBackupOperationSettings() {
      return setBackupOperationSettings;
    }

    @Override
    public TargetPoolsStubSettings build() throws IOException {
      return new TargetPoolsStubSettings(this);
    }
  }
}
