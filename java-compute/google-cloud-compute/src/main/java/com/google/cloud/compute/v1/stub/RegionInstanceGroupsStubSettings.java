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

import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.GetRegionInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.ListInstancesRegionInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionInstanceGroupList;
import com.google.cloud.compute.v1.RegionInstanceGroupsListInstances;
import com.google.cloud.compute.v1.SetNamedPortsRegionInstanceGroupRequest;
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
 * Settings class to configure an instance of {@link RegionInstanceGroupsStub}.
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
 * RegionInstanceGroupsStubSettings.Builder regionInstanceGroupsSettingsBuilder =
 *     RegionInstanceGroupsStubSettings.newBuilder();
 * regionInstanceGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionInstanceGroupsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionInstanceGroupsStubSettings regionInstanceGroupsSettings =
 *     regionInstanceGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionInstanceGroupsStubSettings
    extends StubSettings<RegionInstanceGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<GetRegionInstanceGroupRequest, InstanceGroup> getSettings;
  private final PagedCallSettings<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsSettings;
  private final OperationCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationSettings;

  private static final PagedListDescriptor<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionInstanceGroupsRequest injectToken(
                ListRegionInstanceGroupsRequest payload, String token) {
              return ListRegionInstanceGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionInstanceGroupsRequest injectPageSize(
                ListRegionInstanceGroupsRequest payload, int pageSize) {
              return ListRegionInstanceGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionInstanceGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RegionInstanceGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroup> extractResources(RegionInstanceGroupList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<InstanceGroup>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancesRegionInstanceGroupsRequest,
              RegionInstanceGroupsListInstances,
              InstanceWithNamedPorts>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRegionInstanceGroupsRequest injectToken(
                ListInstancesRegionInstanceGroupsRequest payload, String token) {
              return ListInstancesRegionInstanceGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstancesRegionInstanceGroupsRequest injectPageSize(
                ListInstancesRegionInstanceGroupsRequest payload, int pageSize) {
              return ListInstancesRegionInstanceGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRegionInstanceGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RegionInstanceGroupsListInstances payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceWithNamedPorts> extractResources(
                RegionInstanceGroupsListInstances payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<InstanceWithNamedPorts>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionInstanceGroupsRequest, RegionInstanceGroupList> callable,
                ListRegionInstanceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<RegionInstanceGroupList> futureResponse) {
              PageContext<ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRegionInstanceGroupsRequest,
              RegionInstanceGroupsListInstances,
              ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
                    callable,
                ListInstancesRegionInstanceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
              PageContext<
                      ListInstancesRegionInstanceGroupsRequest,
                      RegionInstanceGroupsListInstances,
                      InstanceWithNamedPorts>
                  pageContext =
                      PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionInstanceGroupRequest, InstanceGroup> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public UnaryCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsSettings() {
    return setNamedPortsSettings;
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public OperationCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationSettings() {
    return setNamedPortsOperationSettings;
  }

  public RegionInstanceGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionInstanceGroupsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RegionInstanceGroupsStubSettings.class))
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

  protected RegionInstanceGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSettings = settingsBuilder.getSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    setNamedPortsSettings = settingsBuilder.setNamedPortsSettings().build();
    setNamedPortsOperationSettings = settingsBuilder.setNamedPortsOperationSettings().build();
  }

  /** Builder for RegionInstanceGroupsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionInstanceGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetRegionInstanceGroupRequest, InstanceGroup>
        getSettings;
    private final PagedCallSettings.Builder<
            ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRegionInstanceGroupsRequest,
            RegionInstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<SetNamedPortsRegionInstanceGroupRequest, Operation>
        setNamedPortsSettings;
    private final OperationCallSettings.Builder<
            SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
        setNamedPortsOperationSettings;
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

      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      setNamedPortsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setNamedPortsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSettings, listSettings, listInstancesSettings, setNamedPortsSettings);
      initDefaults(this);
    }

    protected Builder(RegionInstanceGroupsStubSettings settings) {
      super(settings);

      getSettings = settings.getSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      setNamedPortsSettings = settings.setNamedPortsSettings.toBuilder();
      setNamedPortsOperationSettings = settings.setNamedPortsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSettings, listSettings, listInstancesSettings, setNamedPortsSettings);
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
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setNamedPortsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setNamedPortsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetNamedPortsRegionInstanceGroupRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionInstanceGroupRequest, InstanceGroup> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRegionInstanceGroupsRequest,
            RegionInstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public UnaryCallSettings.Builder<SetNamedPortsRegionInstanceGroupRequest, Operation>
        setNamedPortsSettings() {
      return setNamedPortsSettings;
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
        setNamedPortsOperationSettings() {
      return setNamedPortsOperationSettings;
    }

    @Override
    public RegionInstanceGroupsStubSettings build() throws IOException {
      return new RegionInstanceGroupsStubSettings(this);
    }
  }
}
