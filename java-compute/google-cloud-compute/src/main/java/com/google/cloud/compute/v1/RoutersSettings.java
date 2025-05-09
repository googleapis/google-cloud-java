/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListBgpRoutesPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListRoutePoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RoutersStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RoutersClient}.
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
 * RoutersSettings.Builder routersSettingsBuilder = RoutersSettings.newBuilder();
 * routersSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         routersSettingsBuilder
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
 * RoutersSettings routersSettings = routersSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
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
 * RoutersSettings.Builder routersSettingsBuilder = RoutersSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * routersSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RoutersSettings extends ClientSettings<RoutersSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((RoutersStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRouterRequest, Operation> deleteSettings() {
    return ((RoutersStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRouterRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRoutePolicy. */
  public UnaryCallSettings<DeleteRoutePolicyRouterRequest, Operation> deleteRoutePolicySettings() {
    return ((RoutersStubSettings) getStubSettings()).deleteRoutePolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteRoutePolicy. */
  public OperationCallSettings<DeleteRoutePolicyRouterRequest, Operation, Operation>
      deleteRoutePolicyOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).deleteRoutePolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRouterRequest, Router> getSettings() {
    return ((RoutersStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getNatIpInfo. */
  public UnaryCallSettings<GetNatIpInfoRouterRequest, NatIpInfoResponse> getNatIpInfoSettings() {
    return ((RoutersStubSettings) getStubSettings()).getNatIpInfoSettings();
  }

  /** Returns the object with the settings used for calls to getNatMappingInfo. */
  public PagedCallSettings<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      getNatMappingInfoSettings() {
    return ((RoutersStubSettings) getStubSettings()).getNatMappingInfoSettings();
  }

  /** Returns the object with the settings used for calls to getRoutePolicy. */
  public UnaryCallSettings<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
      getRoutePolicySettings() {
    return ((RoutersStubSettings) getStubSettings()).getRoutePolicySettings();
  }

  /** Returns the object with the settings used for calls to getRouterStatus. */
  public UnaryCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusSettings() {
    return ((RoutersStubSettings) getStubSettings()).getRouterStatusSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRouterRequest, Operation> insertSettings() {
    return ((RoutersStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRouterRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRoutersRequest, RouterList, ListPagedResponse> listSettings() {
    return ((RoutersStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listBgpRoutes. */
  public PagedCallSettings<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
      listBgpRoutesSettings() {
    return ((RoutersStubSettings) getStubSettings()).listBgpRoutesSettings();
  }

  /** Returns the object with the settings used for calls to listRoutePolicies. */
  public PagedCallSettings<
          ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, ListRoutePoliciesPagedResponse>
      listRoutePoliciesSettings() {
    return ((RoutersStubSettings) getStubSettings()).listRoutePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRouterRequest, Operation> patchSettings() {
    return ((RoutersStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRouterRequest, Operation, Operation> patchOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRoutePolicy. */
  public UnaryCallSettings<PatchRoutePolicyRouterRequest, Operation> patchRoutePolicySettings() {
    return ((RoutersStubSettings) getStubSettings()).patchRoutePolicySettings();
  }

  /** Returns the object with the settings used for calls to patchRoutePolicy. */
  public OperationCallSettings<PatchRoutePolicyRouterRequest, Operation, Operation>
      patchRoutePolicyOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).patchRoutePolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to preview. */
  public UnaryCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewSettings() {
    return ((RoutersStubSettings) getStubSettings()).previewSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateRouterRequest, Operation> updateSettings() {
    return ((RoutersStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateRouterRequest, Operation, Operation>
      updateOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).updateOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRoutePolicy. */
  public UnaryCallSettings<UpdateRoutePolicyRouterRequest, Operation> updateRoutePolicySettings() {
    return ((RoutersStubSettings) getStubSettings()).updateRoutePolicySettings();
  }

  /** Returns the object with the settings used for calls to updateRoutePolicy. */
  public OperationCallSettings<UpdateRoutePolicyRouterRequest, Operation, Operation>
      updateRoutePolicyOperationSettings() {
    return ((RoutersStubSettings) getStubSettings()).updateRoutePolicyOperationSettings();
  }

  public static final RoutersSettings create(RoutersStubSettings stub) throws IOException {
    return new RoutersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RoutersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RoutersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RoutersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RoutersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RoutersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RoutersStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RoutersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RoutersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RoutersSettings. */
  public static class Builder extends ClientSettings.Builder<RoutersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RoutersStubSettings.newBuilder(clientContext));
    }

    protected Builder(RoutersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RoutersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RoutersStubSettings.newBuilder());
    }

    public RoutersStubSettings.Builder getStubSettingsBuilder() {
      return ((RoutersStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRouterRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRoutePolicy. */
    public UnaryCallSettings.Builder<DeleteRoutePolicyRouterRequest, Operation>
        deleteRoutePolicySettings() {
      return getStubSettingsBuilder().deleteRoutePolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteRoutePolicy. */
    public OperationCallSettings.Builder<DeleteRoutePolicyRouterRequest, Operation, Operation>
        deleteRoutePolicyOperationSettings() {
      return getStubSettingsBuilder().deleteRoutePolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRouterRequest, Router> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getNatIpInfo. */
    public UnaryCallSettings.Builder<GetNatIpInfoRouterRequest, NatIpInfoResponse>
        getNatIpInfoSettings() {
      return getStubSettingsBuilder().getNatIpInfoSettings();
    }

    /** Returns the builder for the settings used for calls to getNatMappingInfo. */
    public PagedCallSettings.Builder<
            GetNatMappingInfoRoutersRequest,
            VmEndpointNatMappingsList,
            GetNatMappingInfoPagedResponse>
        getNatMappingInfoSettings() {
      return getStubSettingsBuilder().getNatMappingInfoSettings();
    }

    /** Returns the builder for the settings used for calls to getRoutePolicy. */
    public UnaryCallSettings.Builder<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
        getRoutePolicySettings() {
      return getStubSettingsBuilder().getRoutePolicySettings();
    }

    /** Returns the builder for the settings used for calls to getRouterStatus. */
    public UnaryCallSettings.Builder<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusSettings() {
      return getStubSettingsBuilder().getRouterStatusSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRouterRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRouterRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRoutersRequest, RouterList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listBgpRoutes. */
    public PagedCallSettings.Builder<
            ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
        listBgpRoutesSettings() {
      return getStubSettingsBuilder().listBgpRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to listRoutePolicies. */
    public PagedCallSettings.Builder<
            ListRoutePoliciesRoutersRequest,
            RoutersListRoutePolicies,
            ListRoutePoliciesPagedResponse>
        listRoutePoliciesSettings() {
      return getStubSettingsBuilder().listRoutePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRouterRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRouterRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRoutePolicy. */
    public UnaryCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation>
        patchRoutePolicySettings() {
      return getStubSettingsBuilder().patchRoutePolicySettings();
    }

    /** Returns the builder for the settings used for calls to patchRoutePolicy. */
    public OperationCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation, Operation>
        patchRoutePolicyOperationSettings() {
      return getStubSettingsBuilder().patchRoutePolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to preview. */
    public UnaryCallSettings.Builder<PreviewRouterRequest, RoutersPreviewResponse>
        previewSettings() {
      return getStubSettingsBuilder().previewSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateRouterRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRoutePolicy. */
    public UnaryCallSettings.Builder<UpdateRoutePolicyRouterRequest, Operation>
        updateRoutePolicySettings() {
      return getStubSettingsBuilder().updateRoutePolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateRoutePolicy. */
    public OperationCallSettings.Builder<UpdateRoutePolicyRouterRequest, Operation, Operation>
        updateRoutePolicyOperationSettings() {
      return getStubSettingsBuilder().updateRoutePolicyOperationSettings();
    }

    @Override
    public RoutersSettings build() throws IOException {
      return new RoutersSettings(this);
    }
  }
}
