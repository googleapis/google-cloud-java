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

import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.DeleteTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.GetTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.InsertTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.ListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetCertificateMapTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetQuicOverrideTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.TargetHttpsProxiesScopedList;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyAggregatedList;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
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
 * Settings class to configure an instance of {@link TargetHttpsProxiesStub}.
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
 * TargetHttpsProxiesStubSettings.Builder targetHttpsProxiesSettingsBuilder =
 *     TargetHttpsProxiesStubSettings.newBuilder();
 * targetHttpsProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetHttpsProxiesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetHttpsProxiesStubSettings targetHttpsProxiesSettings =
 *     targetHttpsProxiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetHttpsProxiesStubSettings extends StubSettings<TargetHttpsProxiesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteTargetHttpsProxyRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetTargetHttpsProxyRequest, TargetHttpsProxy> getSettings;
  private final UnaryCallSettings<InsertTargetHttpsProxyRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchTargetHttpsProxyRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapSettings;
  private final OperationCallSettings<
          SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings;
  private final UnaryCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideSettings;
  private final OperationCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationSettings;
  private final UnaryCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesSettings;
  private final OperationCallSettings<
          SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings;
  private final UnaryCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation>
      setSslPolicySettings;
  private final OperationCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings;
  private final UnaryCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapSettings;
  private final OperationCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          Map.Entry<String, TargetHttpsProxiesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListTargetHttpsProxiesRequest,
              TargetHttpsProxyAggregatedList,
              Map.Entry<String, TargetHttpsProxiesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListTargetHttpsProxiesRequest injectToken(
                AggregatedListTargetHttpsProxiesRequest payload, String token) {
              return AggregatedListTargetHttpsProxiesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListTargetHttpsProxiesRequest injectPageSize(
                AggregatedListTargetHttpsProxiesRequest payload, int pageSize) {
              return AggregatedListTargetHttpsProxiesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListTargetHttpsProxiesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetHttpsProxyAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, TargetHttpsProxiesScopedList>> extractResources(
                TargetHttpsProxyAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, TargetHttpsProxiesScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetHttpsProxiesRequest injectToken(
                ListTargetHttpsProxiesRequest payload, String token) {
              return ListTargetHttpsProxiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetHttpsProxiesRequest injectPageSize(
                ListTargetHttpsProxiesRequest payload, int pageSize) {
              return ListTargetHttpsProxiesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTargetHttpsProxiesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetHttpsProxyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetHttpsProxy> extractResources(TargetHttpsProxyList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<TargetHttpsProxy>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListTargetHttpsProxiesRequest,
              TargetHttpsProxyAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
                    callable,
                AggregatedListTargetHttpsProxiesRequest request,
                ApiCallContext context,
                ApiFuture<TargetHttpsProxyAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListTargetHttpsProxiesRequest,
                      TargetHttpsProxyAggregatedList,
                      Map.Entry<String, TargetHttpsProxiesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetHttpsProxiesRequest, TargetHttpsProxyList> callable,
                ListTargetHttpsProxiesRequest request,
                ApiCallContext context,
                ApiFuture<TargetHttpsProxyList> futureResponse) {
              PageContext<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetHttpsProxyRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetHttpsProxyRequest, TargetHttpsProxy> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetHttpsProxyRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchTargetHttpsProxyRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public UnaryCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapSettings() {
    return setCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public OperationCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings() {
    return setCertificateMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to setQuicOverride. */
  public UnaryCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideSettings() {
    return setQuicOverrideSettings;
  }

  /** Returns the object with the settings used for calls to setQuicOverride. */
  public OperationCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationSettings() {
    return setQuicOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public UnaryCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesSettings() {
    return setSslCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public OperationCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings() {
    return setSslCertificatesOperationSettings;
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public UnaryCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicySettings() {
    return setSslPolicySettings;
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public OperationCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings() {
    return setSslPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public UnaryCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapSettings() {
    return setUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public OperationCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationSettings() {
    return setUrlMapOperationSettings;
  }

  public TargetHttpsProxiesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetHttpsProxiesStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(TargetHttpsProxiesStubSettings.class))
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

  protected TargetHttpsProxiesStubSettings(Builder settingsBuilder) throws IOException {
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
    setCertificateMapSettings = settingsBuilder.setCertificateMapSettings().build();
    setCertificateMapOperationSettings =
        settingsBuilder.setCertificateMapOperationSettings().build();
    setQuicOverrideSettings = settingsBuilder.setQuicOverrideSettings().build();
    setQuicOverrideOperationSettings = settingsBuilder.setQuicOverrideOperationSettings().build();
    setSslCertificatesSettings = settingsBuilder.setSslCertificatesSettings().build();
    setSslCertificatesOperationSettings =
        settingsBuilder.setSslCertificatesOperationSettings().build();
    setSslPolicySettings = settingsBuilder.setSslPolicySettings().build();
    setSslPolicyOperationSettings = settingsBuilder.setSslPolicyOperationSettings().build();
    setUrlMapSettings = settingsBuilder.setUrlMapSettings().build();
    setUrlMapOperationSettings = settingsBuilder.setUrlMapOperationSettings().build();
  }

  /** Builder for TargetHttpsProxiesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<TargetHttpsProxiesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListTargetHttpsProxiesRequest,
            TargetHttpsProxyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetTargetHttpsProxyRequest, TargetHttpsProxy>
        getSettings;
    private final UnaryCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetCertificateMapTargetHttpsProxyRequest, Operation>
        setCertificateMapSettings;
    private final OperationCallSettings.Builder<
            SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings;
    private final UnaryCallSettings.Builder<SetQuicOverrideTargetHttpsProxyRequest, Operation>
        setQuicOverrideSettings;
    private final OperationCallSettings.Builder<
            SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
        setQuicOverrideOperationSettings;
    private final UnaryCallSettings.Builder<SetSslCertificatesTargetHttpsProxyRequest, Operation>
        setSslCertificatesSettings;
    private final OperationCallSettings.Builder<
            SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings;
    private final UnaryCallSettings.Builder<SetSslPolicyTargetHttpsProxyRequest, Operation>
        setSslPolicySettings;
    private final OperationCallSettings.Builder<
            SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings;
    private final UnaryCallSettings.Builder<SetUrlMapTargetHttpsProxyRequest, Operation>
        setUrlMapSettings;
    private final OperationCallSettings.Builder<
            SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
        setUrlMapOperationSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
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
      setCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setCertificateMapOperationSettings = OperationCallSettings.newBuilder();
      setQuicOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setQuicOverrideOperationSettings = OperationCallSettings.newBuilder();
      setSslCertificatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSslCertificatesOperationSettings = OperationCallSettings.newBuilder();
      setSslPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSslPolicyOperationSettings = OperationCallSettings.newBuilder();
      setUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setUrlMapOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setCertificateMapSettings,
              setQuicOverrideSettings,
              setSslCertificatesSettings,
              setSslPolicySettings,
              setUrlMapSettings);
      initDefaults(this);
    }

    protected Builder(TargetHttpsProxiesStubSettings settings) {
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
      setCertificateMapSettings = settings.setCertificateMapSettings.toBuilder();
      setCertificateMapOperationSettings = settings.setCertificateMapOperationSettings.toBuilder();
      setQuicOverrideSettings = settings.setQuicOverrideSettings.toBuilder();
      setQuicOverrideOperationSettings = settings.setQuicOverrideOperationSettings.toBuilder();
      setSslCertificatesSettings = settings.setSslCertificatesSettings.toBuilder();
      setSslCertificatesOperationSettings =
          settings.setSslCertificatesOperationSettings.toBuilder();
      setSslPolicySettings = settings.setSslPolicySettings.toBuilder();
      setSslPolicyOperationSettings = settings.setSslPolicyOperationSettings.toBuilder();
      setUrlMapSettings = settings.setUrlMapSettings.toBuilder();
      setUrlMapOperationSettings = settings.setUrlMapOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setCertificateMapSettings,
              setQuicOverrideSettings,
              setSslCertificatesSettings,
              setSslPolicySettings,
              setUrlMapSettings);
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
          .setCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setQuicOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setSslCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setSslPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetHttpsProxyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<InsertTargetHttpsProxyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchTargetHttpsProxyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setCertificateMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetCertificateMapTargetHttpsProxyRequest, OperationSnapshot>
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
          .setQuicOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetQuicOverrideTargetHttpsProxyRequest, OperationSnapshot>
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
          .setSslCertificatesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetSslCertificatesTargetHttpsProxyRequest, OperationSnapshot>
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
          .setSslPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetSslPolicyTargetHttpsProxyRequest, OperationSnapshot>
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
          .setUrlMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetUrlMapTargetHttpsProxyRequest, OperationSnapshot>
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
            AggregatedListTargetHttpsProxiesRequest,
            TargetHttpsProxyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetHttpsProxyRequest, TargetHttpsProxy> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public UnaryCallSettings.Builder<SetCertificateMapTargetHttpsProxyRequest, Operation>
        setCertificateMapSettings() {
      return setCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings() {
      return setCertificateMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setQuicOverride. */
    public UnaryCallSettings.Builder<SetQuicOverrideTargetHttpsProxyRequest, Operation>
        setQuicOverrideSettings() {
      return setQuicOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to setQuicOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
        setQuicOverrideOperationSettings() {
      return setQuicOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetHttpsProxyRequest, Operation>
        setSslCertificatesSettings() {
      return setSslCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings() {
      return setSslCertificatesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetHttpsProxyRequest, Operation>
        setSslPolicySettings() {
      return setSslPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings() {
      return setSslPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    public UnaryCallSettings.Builder<SetUrlMapTargetHttpsProxyRequest, Operation>
        setUrlMapSettings() {
      return setUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
        setUrlMapOperationSettings() {
      return setUrlMapOperationSettings;
    }

    @Override
    public TargetHttpsProxiesStubSettings build() throws IOException {
      return new TargetHttpsProxiesStubSettings(this);
    }
  }
}
