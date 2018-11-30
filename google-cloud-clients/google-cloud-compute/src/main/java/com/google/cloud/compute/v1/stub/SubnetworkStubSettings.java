/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.SubnetworkClient.AggregatedListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListUsableSubnetworksPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSubnetworksHttpRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkHttpRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkHttpRequest;
import com.google.cloud.compute.v1.GetSubnetworkHttpRequest;
import com.google.cloud.compute.v1.InsertSubnetworkHttpRequest;
import com.google.cloud.compute.v1.ListSubnetworksHttpRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSubnetworkHttpRequest;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkHttpRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.SubnetworksScopedList;
import com.google.cloud.compute.v1.UsableSubnetwork;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
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
 * Settings class to configure an instance of {@link SubnetworkStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteSubnetwork to 30 seconds:
 *
 * <pre>
 * <code>
 * SubnetworkStubSettings.Builder subnetworkSettingsBuilder =
 *     SubnetworkStubSettings.newBuilder();
 * subnetworkSettingsBuilder.deleteSubnetworkSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SubnetworkStubSettings subnetworkSettings = subnetworkSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SubnetworkStubSettings extends StubSettings<SubnetworkStubSettings> {
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
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksSettings;
  private final UnaryCallSettings<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkSettings;
  private final UnaryCallSettings<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkSettings;
  private final UnaryCallSettings<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkSettings;
  private final UnaryCallSettings<InsertSubnetworkHttpRequest, Operation> insertSubnetworkSettings;
  private final PagedCallSettings<
          ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
      listSubnetworksSettings;
  private final PagedCallSettings<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksSettings;
  private final UnaryCallSettings<PatchSubnetworkHttpRequest, Operation> patchSubnetworkSettings;
  private final UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkSettings;

  /** Returns the object with the settings used for calls to aggregatedListSubnetworks. */
  public PagedCallSettings<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksSettings() {
    return aggregatedListSubnetworksSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubnetwork. */
  public UnaryCallSettings<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkSettings() {
    return deleteSubnetworkSettings;
  }

  /** Returns the object with the settings used for calls to expandIpCidrRangeSubnetwork. */
  public UnaryCallSettings<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkSettings() {
    return expandIpCidrRangeSubnetworkSettings;
  }

  /** Returns the object with the settings used for calls to getSubnetwork. */
  public UnaryCallSettings<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkSettings() {
    return getSubnetworkSettings;
  }

  /** Returns the object with the settings used for calls to insertSubnetwork. */
  public UnaryCallSettings<InsertSubnetworkHttpRequest, Operation> insertSubnetworkSettings() {
    return insertSubnetworkSettings;
  }

  /** Returns the object with the settings used for calls to listSubnetworks. */
  public PagedCallSettings<ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
      listSubnetworksSettings() {
    return listSubnetworksSettings;
  }

  /** Returns the object with the settings used for calls to listUsableSubnetworks. */
  public PagedCallSettings<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksSettings() {
    return listUsableSubnetworksSettings;
  }

  /** Returns the object with the settings used for calls to patchSubnetwork. */
  public UnaryCallSettings<PatchSubnetworkHttpRequest, Operation> patchSubnetworkSettings() {
    return patchSubnetworkSettings;
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccessSubnetwork. */
  public UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkSettings() {
    return setPrivateIpGoogleAccessSubnetworkSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SubnetworkStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSubnetworkStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SubnetworkStubSettings.class))
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

  protected SubnetworkStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSubnetworksSettings = settingsBuilder.aggregatedListSubnetworksSettings().build();
    deleteSubnetworkSettings = settingsBuilder.deleteSubnetworkSettings().build();
    expandIpCidrRangeSubnetworkSettings =
        settingsBuilder.expandIpCidrRangeSubnetworkSettings().build();
    getSubnetworkSettings = settingsBuilder.getSubnetworkSettings().build();
    insertSubnetworkSettings = settingsBuilder.insertSubnetworkSettings().build();
    listSubnetworksSettings = settingsBuilder.listSubnetworksSettings().build();
    listUsableSubnetworksSettings = settingsBuilder.listUsableSubnetworksSettings().build();
    patchSubnetworkSettings = settingsBuilder.patchSubnetworkSettings().build();
    setPrivateIpGoogleAccessSubnetworkSettings =
        settingsBuilder.setPrivateIpGoogleAccessSubnetworkSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList, SubnetworksScopedList>
      AGGREGATED_LIST_SUBNETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListSubnetworksHttpRequest,
              SubnetworkAggregatedList,
              SubnetworksScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListSubnetworksHttpRequest injectToken(
                AggregatedListSubnetworksHttpRequest payload, String token) {
              return AggregatedListSubnetworksHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListSubnetworksHttpRequest injectPageSize(
                AggregatedListSubnetworksHttpRequest payload, int pageSize) {
              return AggregatedListSubnetworksHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListSubnetworksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SubnetworkAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SubnetworksScopedList> extractResources(
                SubnetworkAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<SubnetworksScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork>
      LIST_SUBNETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubnetworksHttpRequest injectToken(
                ListSubnetworksHttpRequest payload, String token) {
              return ListSubnetworksHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubnetworksHttpRequest injectPageSize(
                ListSubnetworksHttpRequest payload, int pageSize) {
              return ListSubnetworksHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubnetworksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SubnetworkList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subnetwork> extractResources(SubnetworkList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Subnetwork>of();
            }
          };

  private static final PagedListDescriptor<
          ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
      LIST_USABLE_SUBNETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUsableSubnetworksHttpRequest,
              UsableSubnetworksAggregatedList,
              UsableSubnetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsableSubnetworksHttpRequest injectToken(
                ListUsableSubnetworksHttpRequest payload, String token) {
              return ListUsableSubnetworksHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUsableSubnetworksHttpRequest injectPageSize(
                ListUsableSubnetworksHttpRequest payload, int pageSize) {
              return ListUsableSubnetworksHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUsableSubnetworksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(UsableSubnetworksAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UsableSubnetwork> extractResources(
                UsableSubnetworksAggregatedList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<UsableSubnetwork>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          AggregatedListSubnetworksPagedResponse>
      AGGREGATED_LIST_SUBNETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListSubnetworksHttpRequest,
              SubnetworkAggregatedList,
              AggregatedListSubnetworksPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListSubnetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
                    callable,
                AggregatedListSubnetworksHttpRequest request,
                ApiCallContext context,
                ApiFuture<SubnetworkAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListSubnetworksHttpRequest,
                      SubnetworkAggregatedList,
                      SubnetworksScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_SUBNETWORKS_PAGE_STR_DESC, request, context);
              return AggregatedListSubnetworksPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
      LIST_SUBNETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>() {
            @Override
            public ApiFuture<ListSubnetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubnetworksHttpRequest, SubnetworkList> callable,
                ListSubnetworksHttpRequest request,
                ApiCallContext context,
                ApiFuture<SubnetworkList> futureResponse) {
              PageContext<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork> pageContext =
                  PageContext.create(callable, LIST_SUBNETWORKS_PAGE_STR_DESC, request, context);
              return ListSubnetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          ListUsableSubnetworksPagedResponse>
      LIST_USABLE_SUBNETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsableSubnetworksHttpRequest,
              UsableSubnetworksAggregatedList,
              ListUsableSubnetworksPagedResponse>() {
            @Override
            public ApiFuture<ListUsableSubnetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
                    callable,
                ListUsableSubnetworksHttpRequest request,
                ApiCallContext context,
                ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
              PageContext<
                      ListUsableSubnetworksHttpRequest,
                      UsableSubnetworksAggregatedList,
                      UsableSubnetwork>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USABLE_SUBNETWORKS_PAGE_STR_DESC, request, context);
              return ListUsableSubnetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for SubnetworkStubSettings. */
  public static class Builder extends StubSettings.Builder<SubnetworkStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListSubnetworksHttpRequest,
            SubnetworkAggregatedList,
            AggregatedListSubnetworksPagedResponse>
        aggregatedListSubnetworksSettings;
    private final UnaryCallSettings.Builder<DeleteSubnetworkHttpRequest, Operation>
        deleteSubnetworkSettings;
    private final UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
        expandIpCidrRangeSubnetworkSettings;
    private final UnaryCallSettings.Builder<GetSubnetworkHttpRequest, Subnetwork>
        getSubnetworkSettings;
    private final UnaryCallSettings.Builder<InsertSubnetworkHttpRequest, Operation>
        insertSubnetworkSettings;
    private final PagedCallSettings.Builder<
            ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
        listSubnetworksSettings;
    private final PagedCallSettings.Builder<
            ListUsableSubnetworksHttpRequest,
            UsableSubnetworksAggregatedList,
            ListUsableSubnetworksPagedResponse>
        listUsableSubnetworksSettings;
    private final UnaryCallSettings.Builder<PatchSubnetworkHttpRequest, Operation>
        patchSubnetworkSettings;
    private final UnaryCallSettings.Builder<
            SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
        setPrivateIpGoogleAccessSubnetworkSettings;

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

      aggregatedListSubnetworksSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_SUBNETWORKS_PAGE_STR_FACT);

      deleteSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      expandIpCidrRangeSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSubnetworksSettings = PagedCallSettings.newBuilder(LIST_SUBNETWORKS_PAGE_STR_FACT);

      listUsableSubnetworksSettings =
          PagedCallSettings.newBuilder(LIST_USABLE_SUBNETWORKS_PAGE_STR_FACT);

      patchSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setPrivateIpGoogleAccessSubnetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSubnetworksSettings,
              deleteSubnetworkSettings,
              expandIpCidrRangeSubnetworkSettings,
              getSubnetworkSettings,
              insertSubnetworkSettings,
              listSubnetworksSettings,
              listUsableSubnetworksSettings,
              patchSubnetworkSettings,
              setPrivateIpGoogleAccessSubnetworkSettings);

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
          .aggregatedListSubnetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .expandIpCidrRangeSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSubnetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listUsableSubnetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setPrivateIpGoogleAccessSubnetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(SubnetworkStubSettings settings) {
      super(settings);

      aggregatedListSubnetworksSettings = settings.aggregatedListSubnetworksSettings.toBuilder();
      deleteSubnetworkSettings = settings.deleteSubnetworkSettings.toBuilder();
      expandIpCidrRangeSubnetworkSettings =
          settings.expandIpCidrRangeSubnetworkSettings.toBuilder();
      getSubnetworkSettings = settings.getSubnetworkSettings.toBuilder();
      insertSubnetworkSettings = settings.insertSubnetworkSettings.toBuilder();
      listSubnetworksSettings = settings.listSubnetworksSettings.toBuilder();
      listUsableSubnetworksSettings = settings.listUsableSubnetworksSettings.toBuilder();
      patchSubnetworkSettings = settings.patchSubnetworkSettings.toBuilder();
      setPrivateIpGoogleAccessSubnetworkSettings =
          settings.setPrivateIpGoogleAccessSubnetworkSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSubnetworksSettings,
              deleteSubnetworkSettings,
              expandIpCidrRangeSubnetworkSettings,
              getSubnetworkSettings,
              insertSubnetworkSettings,
              listSubnetworksSettings,
              listUsableSubnetworksSettings,
              patchSubnetworkSettings,
              setPrivateIpGoogleAccessSubnetworkSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListSubnetworks. */
    public PagedCallSettings.Builder<
            AggregatedListSubnetworksHttpRequest,
            SubnetworkAggregatedList,
            AggregatedListSubnetworksPagedResponse>
        aggregatedListSubnetworksSettings() {
      return aggregatedListSubnetworksSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubnetwork. */
    public UnaryCallSettings.Builder<DeleteSubnetworkHttpRequest, Operation>
        deleteSubnetworkSettings() {
      return deleteSubnetworkSettings;
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRangeSubnetwork. */
    public UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
        expandIpCidrRangeSubnetworkSettings() {
      return expandIpCidrRangeSubnetworkSettings;
    }

    /** Returns the builder for the settings used for calls to getSubnetwork. */
    public UnaryCallSettings.Builder<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkSettings() {
      return getSubnetworkSettings;
    }

    /** Returns the builder for the settings used for calls to insertSubnetwork. */
    public UnaryCallSettings.Builder<InsertSubnetworkHttpRequest, Operation>
        insertSubnetworkSettings() {
      return insertSubnetworkSettings;
    }

    /** Returns the builder for the settings used for calls to listSubnetworks. */
    public PagedCallSettings.Builder<
            ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
        listSubnetworksSettings() {
      return listSubnetworksSettings;
    }

    /** Returns the builder for the settings used for calls to listUsableSubnetworks. */
    public PagedCallSettings.Builder<
            ListUsableSubnetworksHttpRequest,
            UsableSubnetworksAggregatedList,
            ListUsableSubnetworksPagedResponse>
        listUsableSubnetworksSettings() {
      return listUsableSubnetworksSettings;
    }

    /** Returns the builder for the settings used for calls to patchSubnetwork. */
    public UnaryCallSettings.Builder<PatchSubnetworkHttpRequest, Operation>
        patchSubnetworkSettings() {
      return patchSubnetworkSettings;
    }

    /**
     * Returns the builder for the settings used for calls to setPrivateIpGoogleAccessSubnetwork.
     */
    public UnaryCallSettings.Builder<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
        setPrivateIpGoogleAccessSubnetworkSettings() {
      return setPrivateIpGoogleAccessSubnetworkSettings;
    }

    @Override
    public SubnetworkStubSettings build() throws IOException {
      return new SubnetworkStubSettings(this);
    }
  }
}
