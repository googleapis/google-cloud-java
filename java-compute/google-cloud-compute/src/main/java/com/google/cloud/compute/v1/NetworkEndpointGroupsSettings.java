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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkEndpointGroupsClient}.
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
 * NetworkEndpointGroupsSettings.Builder networkEndpointGroupsSettingsBuilder =
 *     NetworkEndpointGroupsSettings.newBuilder();
 * networkEndpointGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networkEndpointGroupsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkEndpointGroupsSettings networkEndpointGroupsSettings =
 *     networkEndpointGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkEndpointGroupsSettings extends ClientSettings<NetworkEndpointGroupsSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListNetworkEndpointGroupsRequest,
          NetworkEndpointGroupAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to attachNetworkEndpoints. */
  public UnaryCallSettings<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).attachNetworkEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to attachNetworkEndpoints. */
  public OperationCallSettings<
          AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings())
        .attachNetworkEndpointsOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkEndpointGroupRequest, Operation> deleteSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to detachNetworkEndpoints. */
  public UnaryCallSettings<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).detachNetworkEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to detachNetworkEndpoints. */
  public OperationCallSettings<
          DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings())
        .detachNetworkEndpointsOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkEndpointGroupRequest, Operation> insertSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
      listSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listNetworkEndpoints. */
  public PagedCallSettings<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).listNetworkEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NetworkEndpointGroupsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NetworkEndpointGroupsSettings create(NetworkEndpointGroupsStubSettings stub)
      throws IOException {
    return new NetworkEndpointGroupsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkEndpointGroupsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkEndpointGroupsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkEndpointGroupsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkEndpointGroupsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkEndpointGroupsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkEndpointGroupsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkEndpointGroupsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkEndpointGroupsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkEndpointGroupsSettings. */
  public static class Builder
      extends ClientSettings.Builder<NetworkEndpointGroupsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkEndpointGroupsStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkEndpointGroupsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkEndpointGroupsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkEndpointGroupsStubSettings.newBuilder());
    }

    public NetworkEndpointGroupsStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkEndpointGroupsStubSettings.Builder) getStubSettings());
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
            AggregatedListNetworkEndpointGroupsRequest,
            NetworkEndpointGroupAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to attachNetworkEndpoints. */
    public UnaryCallSettings.Builder<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsSettings() {
      return getStubSettingsBuilder().attachNetworkEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to attachNetworkEndpoints. */
    public OperationCallSettings.Builder<
            AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
        attachNetworkEndpointsOperationSettings() {
      return getStubSettingsBuilder().attachNetworkEndpointsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkEndpointGroupRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteNetworkEndpointGroupRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to detachNetworkEndpoints. */
    public UnaryCallSettings.Builder<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsSettings() {
      return getStubSettingsBuilder().detachNetworkEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to detachNetworkEndpoints. */
    public OperationCallSettings.Builder<
            DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
        detachNetworkEndpointsOperationSettings() {
      return getStubSettingsBuilder().detachNetworkEndpointsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkEndpointGroupRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertNetworkEndpointGroupRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkEndpoints. */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsPagedResponse>
        listNetworkEndpointsSettings() {
      return getStubSettingsBuilder().listNetworkEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NetworkEndpointGroupsSettings build() throws IOException {
      return new NetworkEndpointGroupsSettings(this);
    }
  }
}
