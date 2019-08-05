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

import static com.google.cloud.compute.v1.RegionInstanceGroupClient.ListInstancesRegionInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupClient.ListRegionInstanceGroupsPagedResponse;

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
import com.google.cloud.compute.v1.GetRegionInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.ListInstancesRegionInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionInstanceGroupList;
import com.google.cloud.compute.v1.RegionInstanceGroupsListInstances;
import com.google.cloud.compute.v1.SetNamedPortsRegionInstanceGroupHttpRequest;
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
 * Settings class to configure an instance of {@link RegionInstanceGroupStub}.
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
 * <p>For example, to set the total timeout of getRegionInstanceGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupStubSettings.Builder regionInstanceGroupSettingsBuilder =
 *     RegionInstanceGroupStubSettings.newBuilder();
 * regionInstanceGroupSettingsBuilder.getRegionInstanceGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionInstanceGroupStubSettings regionInstanceGroupSettings = regionInstanceGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionInstanceGroupStubSettings extends StubSettings<RegionInstanceGroupStubSettings> {
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

  private final UnaryCallSettings<GetRegionInstanceGroupHttpRequest, InstanceGroup>
      getRegionInstanceGroupSettings;
  private final PagedCallSettings<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          ListRegionInstanceGroupsPagedResponse>
      listRegionInstanceGroupsSettings;
  private final PagedCallSettings<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesRegionInstanceGroupsPagedResponse>
      listInstancesRegionInstanceGroupsSettings;
  private final UnaryCallSettings<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
      setNamedPortsRegionInstanceGroupSettings;

  /** Returns the object with the settings used for calls to getRegionInstanceGroup. */
  public UnaryCallSettings<GetRegionInstanceGroupHttpRequest, InstanceGroup>
      getRegionInstanceGroupSettings() {
    return getRegionInstanceGroupSettings;
  }

  /** Returns the object with the settings used for calls to listRegionInstanceGroups. */
  public PagedCallSettings<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          ListRegionInstanceGroupsPagedResponse>
      listRegionInstanceGroupsSettings() {
    return listRegionInstanceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to listInstancesRegionInstanceGroups. */
  public PagedCallSettings<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesRegionInstanceGroupsPagedResponse>
      listInstancesRegionInstanceGroupsSettings() {
    return listInstancesRegionInstanceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to setNamedPortsRegionInstanceGroup. */
  public UnaryCallSettings<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
      setNamedPortsRegionInstanceGroupSettings() {
    return setNamedPortsRegionInstanceGroupSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionInstanceGroupStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionInstanceGroupStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RegionInstanceGroupStubSettings.class))
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

  protected RegionInstanceGroupStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getRegionInstanceGroupSettings = settingsBuilder.getRegionInstanceGroupSettings().build();
    listRegionInstanceGroupsSettings = settingsBuilder.listRegionInstanceGroupsSettings().build();
    listInstancesRegionInstanceGroupsSettings =
        settingsBuilder.listInstancesRegionInstanceGroupsSettings().build();
    setNamedPortsRegionInstanceGroupSettings =
        settingsBuilder.setNamedPortsRegionInstanceGroupSettings().build();
  }

  private static final PagedListDescriptor<
          ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
      LIST_REGION_INSTANCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionInstanceGroupsHttpRequest injectToken(
                ListRegionInstanceGroupsHttpRequest payload, String token) {
              return ListRegionInstanceGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionInstanceGroupsHttpRequest injectPageSize(
                ListRegionInstanceGroupsHttpRequest payload, int pageSize) {
              return ListRegionInstanceGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionInstanceGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RegionInstanceGroupList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceGroup> extractResources(RegionInstanceGroupList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InstanceGroup>of();
            }
          };

  private static final PagedListDescriptor<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts>
      LIST_INSTANCES_REGION_INSTANCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancesRegionInstanceGroupsHttpRequest,
              RegionInstanceGroupsListInstances,
              InstanceWithNamedPorts>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRegionInstanceGroupsHttpRequest injectToken(
                ListInstancesRegionInstanceGroupsHttpRequest payload, String token) {
              return ListInstancesRegionInstanceGroupsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstancesRegionInstanceGroupsHttpRequest injectPageSize(
                ListInstancesRegionInstanceGroupsHttpRequest payload, int pageSize) {
              return ListInstancesRegionInstanceGroupsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRegionInstanceGroupsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RegionInstanceGroupsListInstances payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceWithNamedPorts> extractResources(
                RegionInstanceGroupsListInstances payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InstanceWithNamedPorts>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          ListRegionInstanceGroupsPagedResponse>
      LIST_REGION_INSTANCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionInstanceGroupsHttpRequest,
              RegionInstanceGroupList,
              ListRegionInstanceGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListRegionInstanceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList>
                    callable,
                ListRegionInstanceGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<RegionInstanceGroupList> futureResponse) {
              PageContext<
                      ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGION_INSTANCE_GROUPS_PAGE_STR_DESC, request, context);
              return ListRegionInstanceGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesRegionInstanceGroupsPagedResponse>
      LIST_INSTANCES_REGION_INSTANCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRegionInstanceGroupsHttpRequest,
              RegionInstanceGroupsListInstances,
              ListInstancesRegionInstanceGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesRegionInstanceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInstancesRegionInstanceGroupsHttpRequest,
                        RegionInstanceGroupsListInstances>
                    callable,
                ListInstancesRegionInstanceGroupsHttpRequest request,
                ApiCallContext context,
                ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
              PageContext<
                      ListInstancesRegionInstanceGroupsHttpRequest,
                      RegionInstanceGroupsListInstances,
                      InstanceWithNamedPorts>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_INSTANCES_REGION_INSTANCE_GROUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListInstancesRegionInstanceGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for RegionInstanceGroupStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionInstanceGroupStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<GetRegionInstanceGroupHttpRequest, InstanceGroup>
        getRegionInstanceGroupSettings;
    private final PagedCallSettings.Builder<
            ListRegionInstanceGroupsHttpRequest,
            RegionInstanceGroupList,
            ListRegionInstanceGroupsPagedResponse>
        listRegionInstanceGroupsSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRegionInstanceGroupsHttpRequest,
            RegionInstanceGroupsListInstances,
            ListInstancesRegionInstanceGroupsPagedResponse>
        listInstancesRegionInstanceGroupsSettings;
    private final UnaryCallSettings.Builder<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
        setNamedPortsRegionInstanceGroupSettings;

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

      getRegionInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionInstanceGroupsSettings =
          PagedCallSettings.newBuilder(LIST_REGION_INSTANCE_GROUPS_PAGE_STR_FACT);

      listInstancesRegionInstanceGroupsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCES_REGION_INSTANCE_GROUPS_PAGE_STR_FACT);

      setNamedPortsRegionInstanceGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getRegionInstanceGroupSettings,
              listRegionInstanceGroupsSettings,
              listInstancesRegionInstanceGroupsSettings,
              setNamedPortsRegionInstanceGroupSettings);

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
          .getRegionInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionInstanceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInstancesRegionInstanceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setNamedPortsRegionInstanceGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionInstanceGroupStubSettings settings) {
      super(settings);

      getRegionInstanceGroupSettings = settings.getRegionInstanceGroupSettings.toBuilder();
      listRegionInstanceGroupsSettings = settings.listRegionInstanceGroupsSettings.toBuilder();
      listInstancesRegionInstanceGroupsSettings =
          settings.listInstancesRegionInstanceGroupsSettings.toBuilder();
      setNamedPortsRegionInstanceGroupSettings =
          settings.setNamedPortsRegionInstanceGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getRegionInstanceGroupSettings,
              listRegionInstanceGroupsSettings,
              listInstancesRegionInstanceGroupsSettings,
              setNamedPortsRegionInstanceGroupSettings);
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

    /** Returns the builder for the settings used for calls to getRegionInstanceGroup. */
    public UnaryCallSettings.Builder<GetRegionInstanceGroupHttpRequest, InstanceGroup>
        getRegionInstanceGroupSettings() {
      return getRegionInstanceGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionInstanceGroups. */
    public PagedCallSettings.Builder<
            ListRegionInstanceGroupsHttpRequest,
            RegionInstanceGroupList,
            ListRegionInstanceGroupsPagedResponse>
        listRegionInstanceGroupsSettings() {
      return listRegionInstanceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to listInstancesRegionInstanceGroups. */
    public PagedCallSettings.Builder<
            ListInstancesRegionInstanceGroupsHttpRequest,
            RegionInstanceGroupsListInstances,
            ListInstancesRegionInstanceGroupsPagedResponse>
        listInstancesRegionInstanceGroupsSettings() {
      return listInstancesRegionInstanceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to setNamedPortsRegionInstanceGroup. */
    public UnaryCallSettings.Builder<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
        setNamedPortsRegionInstanceGroupSettings() {
      return setNamedPortsRegionInstanceGroupSettings;
    }

    @Override
    public RegionInstanceGroupStubSettings build() throws IOException {
      return new RegionInstanceGroupStubSettings(this);
    }
  }
}
