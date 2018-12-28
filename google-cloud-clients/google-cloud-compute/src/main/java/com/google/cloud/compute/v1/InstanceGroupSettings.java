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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.InstanceGroupClient.AggregatedListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstancesInstanceGroupsPagedResponse;

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
import com.google.cloud.compute.v1.stub.InstanceGroupStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link InstanceGroupClient}.
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
 * example, to set the total timeout of addInstancesInstanceGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * InstanceGroupSettings.Builder instanceGroupSettingsBuilder =
 *     InstanceGroupSettings.newBuilder();
 * instanceGroupSettingsBuilder.addInstancesInstanceGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InstanceGroupSettings instanceGroupSettings = instanceGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupSettings extends ClientSettings<InstanceGroupSettings> {
  /** Returns the object with the settings used for calls to addInstancesInstanceGroup. */
  public UnaryCallSettings<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).addInstancesInstanceGroupSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListInstanceGroups. */
  public PagedCallSettings<
          AggregatedListInstanceGroupsHttpRequest,
          InstanceGroupAggregatedList,
          AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).aggregatedListInstanceGroupsSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstanceGroup. */
  public UnaryCallSettings<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).deleteInstanceGroupSettings();
  }

  /** Returns the object with the settings used for calls to getInstanceGroup. */
  public UnaryCallSettings<GetInstanceGroupHttpRequest, InstanceGroup> getInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).getInstanceGroupSettings();
  }

  /** Returns the object with the settings used for calls to insertInstanceGroup. */
  public UnaryCallSettings<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).insertInstanceGroupSettings();
  }

  /** Returns the object with the settings used for calls to listInstanceGroups. */
  public PagedCallSettings<
          ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
      listInstanceGroupsSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).listInstanceGroupsSettings();
  }

  /** Returns the object with the settings used for calls to listInstancesInstanceGroups. */
  public PagedCallSettings<
          ListInstancesInstanceGroupsHttpRequest,
          InstanceGroupsListInstances,
          ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).listInstancesInstanceGroupsSettings();
  }

  /** Returns the object with the settings used for calls to removeInstancesInstanceGroup. */
  public UnaryCallSettings<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).removeInstancesInstanceGroupSettings();
  }

  /** Returns the object with the settings used for calls to setNamedPortsInstanceGroup. */
  public UnaryCallSettings<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupSettings() {
    return ((InstanceGroupStubSettings) getStubSettings()).setNamedPortsInstanceGroupSettings();
  }

  public static final InstanceGroupSettings create(InstanceGroupStubSettings stub)
      throws IOException {
    return new InstanceGroupSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstanceGroupStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstanceGroupStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return InstanceGroupStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstanceGroupStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstanceGroupStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstanceGroupStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstanceGroupStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceGroupStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstanceGroupSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstanceGroupSettings. */
  public static class Builder extends ClientSettings.Builder<InstanceGroupSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(InstanceGroupStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(InstanceGroupStubSettings.newBuilder());
    }

    protected Builder(InstanceGroupSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstanceGroupStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public InstanceGroupStubSettings.Builder getStubSettingsBuilder() {
      return ((InstanceGroupStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addInstancesInstanceGroup. */
    public UnaryCallSettings.Builder<AddInstancesInstanceGroupHttpRequest, Operation>
        addInstancesInstanceGroupSettings() {
      return getStubSettingsBuilder().addInstancesInstanceGroupSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedListInstanceGroups. */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupsHttpRequest,
            InstanceGroupAggregatedList,
            AggregatedListInstanceGroupsPagedResponse>
        aggregatedListInstanceGroupsSettings() {
      return getStubSettingsBuilder().aggregatedListInstanceGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstanceGroup. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupHttpRequest, Operation>
        deleteInstanceGroupSettings() {
      return getStubSettingsBuilder().deleteInstanceGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getInstanceGroup. */
    public UnaryCallSettings.Builder<GetInstanceGroupHttpRequest, InstanceGroup>
        getInstanceGroupSettings() {
      return getStubSettingsBuilder().getInstanceGroupSettings();
    }

    /** Returns the builder for the settings used for calls to insertInstanceGroup. */
    public UnaryCallSettings.Builder<InsertInstanceGroupHttpRequest, Operation>
        insertInstanceGroupSettings() {
      return getStubSettingsBuilder().insertInstanceGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listInstanceGroups. */
    public PagedCallSettings.Builder<
            ListInstanceGroupsHttpRequest, InstanceGroupList, ListInstanceGroupsPagedResponse>
        listInstanceGroupsSettings() {
      return getStubSettingsBuilder().listInstanceGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to listInstancesInstanceGroups. */
    public PagedCallSettings.Builder<
            ListInstancesInstanceGroupsHttpRequest,
            InstanceGroupsListInstances,
            ListInstancesInstanceGroupsPagedResponse>
        listInstancesInstanceGroupsSettings() {
      return getStubSettingsBuilder().listInstancesInstanceGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstancesInstanceGroup. */
    public UnaryCallSettings.Builder<RemoveInstancesInstanceGroupHttpRequest, Operation>
        removeInstancesInstanceGroupSettings() {
      return getStubSettingsBuilder().removeInstancesInstanceGroupSettings();
    }

    /** Returns the builder for the settings used for calls to setNamedPortsInstanceGroup. */
    public UnaryCallSettings.Builder<SetNamedPortsInstanceGroupHttpRequest, Operation>
        setNamedPortsInstanceGroupSettings() {
      return getStubSettingsBuilder().setNamedPortsInstanceGroupSettings();
    }

    @Override
    public InstanceGroupSettings build() throws IOException {
      return new InstanceGroupSettings(this);
    }
  }
}
