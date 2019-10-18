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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.AggregatedListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointsNetworkEndpointGroupsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NetworkEndpointGroupClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of attachNetworkEndpointsNetworkEndpointGroup to 30
 * seconds:
 *
 * <pre>
 * <code>
 * NetworkEndpointGroupSettings.Builder networkEndpointGroupSettingsBuilder =
 *     NetworkEndpointGroupSettings.newBuilder();
 * networkEndpointGroupSettingsBuilder.attachNetworkEndpointsNetworkEndpointGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NetworkEndpointGroupSettings networkEndpointGroupSettings = networkEndpointGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworkEndpointGroupSettings extends ClientSettings<NetworkEndpointGroupSettings> {
  /** Returns the object with the settings used for calls to aggregatedListNetworkEndpointGroups. */
  public PagedCallSettings<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupAggregatedList,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .aggregatedListNetworkEndpointGroupsSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * attachNetworkEndpointsNetworkEndpointGroup.
   */
  public UnaryCallSettings<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .attachNetworkEndpointsNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkEndpointGroup. */
  public UnaryCallSettings<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .deleteNetworkEndpointGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * detachNetworkEndpointsNetworkEndpointGroup.
   */
  public UnaryCallSettings<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .detachNetworkEndpointsNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to getNetworkEndpointGroup. */
  public UnaryCallSettings<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings()).getNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to insertNetworkEndpointGroup. */
  public UnaryCallSettings<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .insertNetworkEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to listNetworkEndpointGroups. */
  public PagedCallSettings<
          ListNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupList,
          ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .listNetworkEndpointGroupsSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listNetworkEndpointsNetworkEndpointGroups.
   */
  public PagedCallSettings<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .listNetworkEndpointsNetworkEndpointGroupsSettings();
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissionsNetworkEndpointGroup.
   */
  public UnaryCallSettings<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupSettings() {
    return ((NetworkEndpointGroupStubSettings) getStubSettings())
        .testIamPermissionsNetworkEndpointGroupSettings();
  }

  public static final NetworkEndpointGroupSettings create(NetworkEndpointGroupStubSettings stub)
      throws IOException {
    return new NetworkEndpointGroupSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkEndpointGroupStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkEndpointGroupStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return NetworkEndpointGroupStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkEndpointGroupStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkEndpointGroupStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkEndpointGroupStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkEndpointGroupStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkEndpointGroupStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkEndpointGroupSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkEndpointGroupSettings. */
  public static class Builder
      extends ClientSettings.Builder<NetworkEndpointGroupSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkEndpointGroupStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NetworkEndpointGroupStubSettings.newBuilder());
    }

    protected Builder(NetworkEndpointGroupSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkEndpointGroupStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public NetworkEndpointGroupStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkEndpointGroupStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to aggregatedListNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            AggregatedListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupAggregatedList,
            AggregatedListNetworkEndpointGroupsPagedResponse>
        aggregatedListNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().aggregatedListNetworkEndpointGroupsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * attachNetworkEndpointsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().attachNetworkEndpointsNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteNetworkEndpointGroupHttpRequest, Operation>
        deleteNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().deleteNetworkEndpointGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * detachNetworkEndpointsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().detachNetworkEndpointsNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().getNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to insertNetworkEndpointGroup. */
    public UnaryCallSettings.Builder<InsertNetworkEndpointGroupHttpRequest, Operation>
        insertNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().insertNetworkEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkEndpointGroups. */
    public PagedCallSettings.Builder<
            ListNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupList,
            ListNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().listNetworkEndpointGroupsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listNetworkEndpointsNetworkEndpointGroups.
     */
    public PagedCallSettings.Builder<
            ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints,
            ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
        listNetworkEndpointsNetworkEndpointGroupsSettings() {
      return getStubSettingsBuilder().listNetworkEndpointsNetworkEndpointGroupsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * testIamPermissionsNetworkEndpointGroup.
     */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNetworkEndpointGroupSettings() {
      return getStubSettingsBuilder().testIamPermissionsNetworkEndpointGroupSettings();
    }

    @Override
    public NetworkEndpointGroupSettings build() throws IOException {
      return new NetworkEndpointGroupSettings(this);
    }
  }
}
