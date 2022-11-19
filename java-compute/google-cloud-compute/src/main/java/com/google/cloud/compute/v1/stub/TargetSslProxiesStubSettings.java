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

import static com.google.cloud.compute.v1.TargetSslProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetSslProxyRequest;
import com.google.cloud.compute.v1.GetTargetSslProxyRequest;
import com.google.cloud.compute.v1.InsertTargetSslProxyRequest;
import com.google.cloud.compute.v1.ListTargetSslProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetBackendServiceTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetCertificateMapTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetSslProxyRequest;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TargetSslProxiesStub}.
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
 * TargetSslProxiesStubSettings.Builder targetSslProxiesSettingsBuilder =
 *     TargetSslProxiesStubSettings.newBuilder();
 * targetSslProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetSslProxiesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetSslProxiesStubSettings targetSslProxiesSettings = targetSslProxiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetSslProxiesStubSettings extends StubSettings<TargetSslProxiesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<DeleteTargetSslProxyRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetTargetSslProxyRequest, TargetSslProxy> getSettings;
  private final UnaryCallSettings<InsertTargetSslProxyRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceSettings;
  private final OperationCallSettings<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationSettings;
  private final UnaryCallSettings<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapSettings;
  private final OperationCallSettings<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings;
  private final UnaryCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderSettings;
  private final OperationCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationSettings;
  private final UnaryCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesSettings;
  private final OperationCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings;
  private final UnaryCallSettings<SetSslPolicyTargetSslProxyRequest, Operation>
      setSslPolicySettings;
  private final OperationCallSettings<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings;

  private static final PagedListDescriptor<
          ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetSslProxiesRequest injectToken(
                ListTargetSslProxiesRequest payload, String token) {
              return ListTargetSslProxiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetSslProxiesRequest injectPageSize(
                ListTargetSslProxiesRequest payload, int pageSize) {
              return ListTargetSslProxiesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTargetSslProxiesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetSslProxyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetSslProxy> extractResources(TargetSslProxyList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<TargetSslProxy>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> callable,
                ListTargetSslProxiesRequest request,
                ApiCallContext context,
                ApiFuture<TargetSslProxyList> futureResponse) {
              PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetSslProxyRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetSslProxyRequest, TargetSslProxy> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetSslProxyRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public UnaryCallSettings<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceSettings() {
    return setBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public OperationCallSettings<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationSettings() {
    return setBackendServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public UnaryCallSettings<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapSettings() {
    return setCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public OperationCallSettings<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings() {
    return setCertificateMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public UnaryCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderSettings() {
    return setProxyHeaderSettings;
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public OperationCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationSettings() {
    return setProxyHeaderOperationSettings;
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public UnaryCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesSettings() {
    return setSslCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public OperationCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings() {
    return setSslCertificatesOperationSettings;
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public UnaryCallSettings<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicySettings() {
    return setSslPolicySettings;
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public OperationCallSettings<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings() {
    return setSslPolicyOperationSettings;
  }

  public TargetSslProxiesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetSslProxiesStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(TargetSslProxiesStubSettings.class))
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

  protected TargetSslProxiesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    setBackendServiceSettings = settingsBuilder.setBackendServiceSettings().build();
    setBackendServiceOperationSettings =
        settingsBuilder.setBackendServiceOperationSettings().build();
    setCertificateMapSettings = settingsBuilder.setCertificateMapSettings().build();
    setCertificateMapOperationSettings =
        settingsBuilder.setCertificateMapOperationSettings().build();
    setProxyHeaderSettings = settingsBuilder.setProxyHeaderSettings().build();
    setProxyHeaderOperationSettings = settingsBuilder.setProxyHeaderOperationSettings().build();
    setSslCertificatesSettings = settingsBuilder.setSslCertificatesSettings().build();
    setSslCertificatesOperationSettings =
        settingsBuilder.setSslCertificatesOperationSettings().build();
    setSslPolicySettings = settingsBuilder.setSslPolicySettings().build();
    setSslPolicyOperationSettings = settingsBuilder.setSslPolicyOperationSettings().build();
  }

  /** Builder for TargetSslProxiesStubSettings. */
  public static class Builder extends StubSettings.Builder<TargetSslProxiesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<DeleteTargetSslProxyRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteTargetSslProxyRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetTargetSslProxyRequest, TargetSslProxy> getSettings;
    private final UnaryCallSettings.Builder<InsertTargetSslProxyRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertTargetSslProxyRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<SetBackendServiceTargetSslProxyRequest, Operation>
        setBackendServiceSettings;
    private final OperationCallSettings.Builder<
            SetBackendServiceTargetSslProxyRequest, Operation, Operation>
        setBackendServiceOperationSettings;
    private final UnaryCallSettings.Builder<SetCertificateMapTargetSslProxyRequest, Operation>
        setCertificateMapSettings;
    private final OperationCallSettings.Builder<
            SetCertificateMapTargetSslProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings;
    private final UnaryCallSettings.Builder<SetProxyHeaderTargetSslProxyRequest, Operation>
        setProxyHeaderSettings;
    private final OperationCallSettings.Builder<
            SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
        setProxyHeaderOperationSettings;
    private final UnaryCallSettings.Builder<SetSslCertificatesTargetSslProxyRequest, Operation>
        setSslCertificatesSettings;
    private final OperationCallSettings.Builder<
            SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings;
    private final UnaryCallSettings.Builder<SetSslPolicyTargetSslProxyRequest, Operation>
        setSslPolicySettings;
    private final OperationCallSettings.Builder<
            SetSslPolicyTargetSslProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings;
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

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      setBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setBackendServiceOperationSettings = OperationCallSettings.newBuilder();
      setCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setCertificateMapOperationSettings = OperationCallSettings.newBuilder();
      setProxyHeaderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setProxyHeaderOperationSettings = OperationCallSettings.newBuilder();
      setSslCertificatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSslCertificatesOperationSettings = OperationCallSettings.newBuilder();
      setSslPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSslPolicyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              setBackendServiceSettings,
              setCertificateMapSettings,
              setProxyHeaderSettings,
              setSslCertificatesSettings,
              setSslPolicySettings);
      initDefaults(this);
    }

    protected Builder(TargetSslProxiesStubSettings settings) {
      super(settings);

      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      setBackendServiceSettings = settings.setBackendServiceSettings.toBuilder();
      setBackendServiceOperationSettings = settings.setBackendServiceOperationSettings.toBuilder();
      setCertificateMapSettings = settings.setCertificateMapSettings.toBuilder();
      setCertificateMapOperationSettings = settings.setCertificateMapOperationSettings.toBuilder();
      setProxyHeaderSettings = settings.setProxyHeaderSettings.toBuilder();
      setProxyHeaderOperationSettings = settings.setProxyHeaderOperationSettings.toBuilder();
      setSslCertificatesSettings = settings.setSslCertificatesSettings.toBuilder();
      setSslCertificatesOperationSettings =
          settings.setSslCertificatesOperationSettings.toBuilder();
      setSslPolicySettings = settings.setSslPolicySettings.toBuilder();
      setSslPolicyOperationSettings = settings.setSslPolicyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              setBackendServiceSettings,
              setCertificateMapSettings,
              setProxyHeaderSettings,
              setSslCertificatesSettings,
              setSslPolicySettings);
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
          .setBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setProxyHeaderSettings()
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
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetSslProxyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<InsertTargetSslProxyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setBackendServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetBackendServiceTargetSslProxyRequest, OperationSnapshot>
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
          .setCertificateMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetCertificateMapTargetSslProxyRequest, OperationSnapshot>
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
          .setProxyHeaderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetProxyHeaderTargetSslProxyRequest, OperationSnapshot>
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
                  .<SetSslCertificatesTargetSslProxyRequest, OperationSnapshot>
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
                  .<SetSslPolicyTargetSslProxyRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetSslProxyRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTargetSslProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetSslProxyRequest, TargetSslProxy> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetSslProxyRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertTargetSslProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    public UnaryCallSettings.Builder<SetBackendServiceTargetSslProxyRequest, Operation>
        setBackendServiceSettings() {
      return setBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetBackendServiceTargetSslProxyRequest, Operation, Operation>
        setBackendServiceOperationSettings() {
      return setBackendServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public UnaryCallSettings.Builder<SetCertificateMapTargetSslProxyRequest, Operation>
        setCertificateMapSettings() {
      return setCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetCertificateMapTargetSslProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings() {
      return setCertificateMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    public UnaryCallSettings.Builder<SetProxyHeaderTargetSslProxyRequest, Operation>
        setProxyHeaderSettings() {
      return setProxyHeaderSettings;
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
        setProxyHeaderOperationSettings() {
      return setProxyHeaderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetSslProxyRequest, Operation>
        setSslCertificatesSettings() {
      return setSslCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings() {
      return setSslCertificatesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetSslProxyRequest, Operation>
        setSslPolicySettings() {
      return setSslPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings() {
      return setSslPolicyOperationSettings;
    }

    @Override
    public TargetSslProxiesStubSettings build() throws IOException {
      return new TargetSslProxiesStubSettings(this);
    }
  }
}
